package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "operations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operations {
    @XmlElement(name = "BeanOperation")
    private List<BeanOperation> operations = null;

    public List<BeanOperation> getOperations() {
        return operations;
    }

    public void setEmployees(List<BeanOperation> operations) {
        this.operations = operations;
    }
}
