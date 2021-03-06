package com.example.company;

import com.example.model.Alimenti;
import com.example.model.Datasource;

import java.util.List;

public class Protein extends BaseMeal{
    public Protein(String nameFood) {
        super(nameFood);
    }

    public StringBuilder calculatePortion(PersonPrototype personPrototype){
        float bmi = personPrototype.BmiCalculated();
        StringBuilder sb = new StringBuilder();
        sb.append("\n-proteine del giorno: ");
        sb.append(chooseFood());
        float portion;
        if (bmi > 30.01){
            portion =  (float) ((personPrototype.getWeight()*0.0008*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }else if ((bmi >= 25.01) && (bmi < 30)){
            portion =  (float) ((personPrototype.getWeight()*0.0009*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }else if ((bmi >= 18.51) && (bmi < 25)){
            portion =  (float) ((personPrototype.getWeight()*0.0012*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));

        }else if ((bmi >= 17.51) && (bmi < 18.50)){
            portion =  (float) ((personPrototype.getWeight()*0.0015*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));

        }else if ((bmi >= 16.01) && (bmi < 17.50)) {
            portion =  (float) ((personPrototype.getWeight()*0.002*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }
        return sb;
    }
    public StringBuilder calculatePortion(WomenPerson womenPerson){
        float bmi = womenPerson.BmiCalculated();

        StringBuilder sb = new StringBuilder();
        sb.append("\n-proteine del giorno: ");
        sb.append(chooseFood());
        float portion = 0;
        if (bmi > 30.01){
            portion =  (float) ((womenPerson.getWeight()*0.0008*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }else if ((bmi >= 25.01) && (bmi < 30)){
            portion =  (float) ((womenPerson.getWeight()*0.0009*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }else if ((bmi >= 18.51) && (bmi < 25)){
            portion =  (float) ((womenPerson.getWeight()*0.0012*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));

        }else if ((bmi >= 17.51) && (bmi < 18.50)){
            portion =  (float) ((womenPerson.getWeight()*0.0015*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));

        }else if ((bmi >= 16.01) && (bmi < 17.50)) {
            portion =  (float) ((womenPerson.getWeight()*0.002*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }
        return sb;
    }

    public StringBuilder calculatePortion(MenPerson menPerson){
        float bmi = menPerson.BmiCalculated();
        StringBuilder sb = new StringBuilder();
        sb.append("\n-proteine del giorno: ");
        sb.append(chooseFood());
        float portion = 0;
        if (bmi > 30.01){
            portion =  (float) ((menPerson.getWeight()*0.0008*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }else if ((bmi >= 25.01) || (bmi < 30)){
            portion =  (float) ((menPerson.getWeight()*0.0009*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }else if ((bmi >= 18.51) || (bmi < 25)){
            portion =  (float) ((menPerson.getWeight()*0.0012*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));

        }else if ((bmi >= 17.51) || (bmi < 18.50)){
            portion =  (float) ((menPerson.getWeight()*0.0015*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));

        }else if ((bmi >= 16.01) || (bmi < 17.50)) {
            portion =  (float) ((menPerson.getWeight()*0.002*1000)/2.2);
            sb.append(" ,grammi da mangiare ").append(Math.ceil(portion/2));
        }
        return sb;
    }



    public StringBuilder chooseFood(){
        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Non riesco ad aprire datasource");
            return null;
        }

        List<Alimenti> proteine = datasource.queryProteine();
        if(proteine == null){
            System.out.println("Nessuna proteina");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int n = (int) (Math.random() * proteine.size()-1);
        sb.append(proteine.get(n).getName()).append( " oppure ").append(proteine.get(n+1).getName());
        datasource.close();
        return sb;
    }

}
