package lab.aikibo.springservice;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by tamami on 11/12/16.
 */
@Data
@Entity
@Table(name="task_list")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="task_id")
  private int id;

  @Column(name="task_name")
  private String taskName;

  @Column(name="task_description")
  private String taskDescription;

  @Column(name="task_priority")
  private String taskPriority;

  @Column(name="task_status")
  private String taskStatus;

  @Column(name="task_archived")
  private boolean taskArchived = false;

  @Override
  public String toString() {
    return "Task [id=" + id + ", taskName=" + taskName + ", taskDescription=" + taskDescription +
        ", taskPriority=" + taskPriority + ",taskStatus=" + taskStatus + "]";
  }

}
