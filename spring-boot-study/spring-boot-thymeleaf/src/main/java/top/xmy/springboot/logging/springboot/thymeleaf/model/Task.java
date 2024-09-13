package top.xmy.springboot.logging.springboot.thymeleaf.model;

public class Task {
    public String getName() {
        return name;
    }
    public Task(Long id, String name) {
        this.id=id;
        this.name=name;
        this.completed=false;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String name;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    private  Boolean completed;
}
