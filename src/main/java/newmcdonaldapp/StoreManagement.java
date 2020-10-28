package newmcdonaldapp;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="StoreManagement_table")
public class StoreManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Long burgerId;

    @PrePersist
    public void onPrePersist(){

        try {
            Thread.currentThread().sleep((long) (400 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CookStarted cookStarted = new CookStarted();
        BeanUtils.copyProperties(this, cookStarted);
        cookStarted.publishAfterCommit();

        try {
            Thread.currentThread().sleep((long) (5000 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DeliveryStart deliveryStart = new DeliveryStart();
        BeanUtils.copyProperties(this, deliveryStart);
        deliveryStart.publishAfterCommit();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBurgerId() {
        return burgerId;
    }

    public void setBurgerId(Long burgerId) {
        this.burgerId = burgerId;
    }

}
