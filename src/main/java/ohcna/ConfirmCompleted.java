package ohcna;

public class ConfirmCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private String confirmDtm;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getConfirmUserId() {
        return userId;
    }

    public void setConfirmUserId(String userId) {
        this.userId = userId;
    }
    public String getConfirmDtm() {
        return confirmDtm;
    }

    public void setConfirmDtm(String confirmDtm) {
        this.confirmDtm = confirmDtm;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}