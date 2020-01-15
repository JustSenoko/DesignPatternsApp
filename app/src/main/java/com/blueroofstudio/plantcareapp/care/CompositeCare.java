package com.blueroofstudio.plantcareapp.care;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeCare implements PlantCare {
    private List<PlantCare> care = new ArrayList<>();

    @Override
    public void perform() {
        System.out.printf("performing %s \n{\n",this.getClass().getSimpleName());
        for (PlantCare operation : care) {
            operation.perform();
        }
        System.out.print("}");
    }

    @Override
    public String getExplanation() {
        StringBuilder sb = new StringBuilder("[");
        for (PlantCare operation : care) {
            sb.append(operation.getExplanation());
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public PlantCare add(PlantCare... operations) {
        this.care.addAll(Arrays.asList(operations));
        return this;
    }

}
