package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.swing.plaf.nimbus.State;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String name;
    private List<State> states;
    //pojo classtaki degerleri koymak icin pojo classin ismini veerdik




//    public Country(String name, List<State> states) {
//        //string olrak ulkenin ismi listolarakta eyaletleri istiyor
//        this.name = name;
//        this.states = states;
//    }

    public Country(String name, List<pojos.State> state) {
        this.name = name;
        this.states = states;
    }

//    public Country(String banana, List<pojos.State> stateList) {
//        //string olrak ulkenin ismi listolarakta eyaletleri istiyor
//        this.name = name;
//        this.states = states;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
