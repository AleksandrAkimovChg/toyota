package com.toyota.dealer;

import com.toyota.car.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Report {
    private static final String FILENAME_TEMPLATE = "report_%s_%s.txt";
    private static final String LINE = "===========================================================\n";
    private static final String SPACE = " - ";
    private final String nameManager;
    private final LinkedList<Car> soldCars;
    private final LinkedList<Models> soldModels;


    public Report(String name) {
        this.soldCars = new LinkedList<>();
        this.soldModels = new LinkedList<>();
        this.nameManager = name;
    }

    public void addReport(Models model, Car car) {
        soldCars.add(car);
        soldModels.add(model);
    }

    public void doReport()  {
        StringBuilder report = new StringBuilder();
        report.append("Имя менеджера: ").append(nameManager).append("\n");
        report.append(LINE);
        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalCoast = BigDecimal.ZERO;
        BigDecimal totalProfit = BigDecimal.ZERO;
        int number = 0;
        for (int i = 0; i < soldCars.size(); i++) {
            number++;
            report
                    .append(soldModels.get(i).getName())
                    .append(" № ")
                    .append(number)
                    .append(SPACE)
                    .append(soldCars.get(i).getPrice().setScale(2, RoundingMode.HALF_UP))
                    .append(SPACE)
                    .append(soldModels.get(i).getCoast().setScale(2, RoundingMode.HALF_UP))
                    .append("\n");
            totalIncome = totalIncome.add(soldCars.get(i).getPrice());
            totalCoast = totalCoast.add(soldModels.get(i).getCoast());
            totalProfit = totalIncome.subtract(totalCoast);
        }
        report
                .append("Доходы - ")
                .append(totalIncome)
                .append(" , Расходы - ")
                .append(totalCoast)
                .append(" , Прибыль - ")
                .append(totalProfit)
                .append("\n");
        report.append(LINE);
        writeReport(report.toString());
    }

    private void writeReport(String text) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH:mm");
        String filename = FILENAME_TEMPLATE.formatted(this.nameManager, LocalDateTime.now().format(formatter));
        try (FileWriter fileWriter = new FileWriter(filename, false)) {
            fileWriter.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
