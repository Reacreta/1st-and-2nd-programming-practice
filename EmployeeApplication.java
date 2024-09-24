import javax.swing.JOptionPane;

public class EmployeeApplication {
   
   private static int currentIndex = 0;
    
   public static void main(String[] args){
      
        
      DS_EmployeeList_Sorter list;
      Employee node;
      boolean run = true;
        
      list = new DS_EmployeeList_Sorter();
      node = new Employee();
        
      while (run) {
         String[] options = {"Add Employee", "Search an Employee", "Remove an Employee", "View Employees", "Sorting", "Exit"}; 
         int choice = JOptionPane.showOptionDialog(null, "Choose an Action", "Employee Management",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        
         switch (choice) {
            
            case 0:
               String[] options1 = {"Add Employee", "Add Employee on Index"};
               int choice1 = JOptionPane.showOptionDialog(null, "Choose an Action", "Employee Management",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
               
               switch (choice1) {   
                  case 0:
                     String name = JOptionPane.showInputDialog("Enter name:");
                     String position = JOptionPane.showInputDialog("Enter postion:");
                     byte age = Byte.parseByte(JOptionPane.showInputDialog("Enter age:"));
                     int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                     node = new Employee(name, position, age, id);
                     list.addItem(node);
                     break;
               
                  case 1:
                     String name1 = JOptionPane.showInputDialog("Enter name:");
                     String position1 = JOptionPane.showInputDialog("Enter postion:");
                     byte age1 = Byte.parseByte(JOptionPane.showInputDialog("Enter age:"));
                     int id1 = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                     node = new Employee(name1, position1, age1, id1);
                     int index = Integer.parseInt(JOptionPane.showInputDialog("Enter the index to add the employee at:"));
                     list.addItem(index, node);
                     JOptionPane.showMessageDialog(null, "Employee added at index: " + index);
                     break;
                  
                  default:
                     break;  
               }
               continue;
            
            case 1:
               String[] options2 = {"Search by Index", "Search by Name", "Search by ID"};
               int choice2 = JOptionPane.showOptionDialog(null, "Choose an Action", "Employee Management",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
               
               switch (choice2) {
                  case 0:
                     int search = Integer.parseInt(JOptionPane.showInputDialog("Enter index to search"));
                     Employee foundNode = list.searchByIndex(search);
                     if (foundNode !=null) {
                        JOptionPane.showMessageDialog(null, "Employee found at index " + search + ": \n" + foundNode);
                     } else {
                        JOptionPane.showMessageDialog(null, "No employee found at index " + search);
                     }
                     break;
                  
                  case 1:
                     String searchName = JOptionPane.showInputDialog("Enter the Employee's name:");
                     Employee foundNode1 = list.searchByName(searchName);
                     
                     if (foundNode1 !=null) {
                        JOptionPane.showMessageDialog(null, "Employee Details: \n" + foundNode1);
                     } else {
                        JOptionPane.showMessageDialog(null, "No Employee found.");
                     }
                     break;
               
                  case 2:
                     int searchID = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search"));
                     Employee foundNode2 = list.searchByID(searchID);
                     
                     if (foundNode2 !=null) {
                        JOptionPane.showMessageDialog(null, "Employee Details: \n" + foundNode2);
                     } else {
                        JOptionPane.showMessageDialog(null, "No Employee found.");
                     }
                     break;
               
               }
               continue;
            
            case 2:
               String[] options3 = {"Remove last employee", "Remove by Index"};
               int choice3 = JOptionPane.showOptionDialog(null, "Choose an Action", "Employee Management",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options3, options3[0]);
               
               switch (choice3) {
                  
                  case 0:
                     Employee lastRemoved = list.removeLastEmployee();
                     if (lastRemoved != null) {
                        JOptionPane.showMessageDialog(null, "\nRemoved employee: \n" + lastRemoved);
                     } else {
                        JOptionPane.showMessageDialog(null, "No employees to remove.");
                     }
                     break;
                       
                  
                  case 1:
                     int remove = Integer.parseInt(JOptionPane.showInputDialog("Enter index to remove"));
                     Employee foundNode1 = list.searchByIndex(remove);
                     if (foundNode1 !=null) {
                        list.removeByIndex(remove);
                        JOptionPane.showMessageDialog(null, "\nEmployee " + foundNode1 + "\nis removed from index " + remove);
                     } else {
                        JOptionPane.showMessageDialog(null, "No Employee found at index " + remove);
                     }
                     break;
                           
               }
               continue;
            
               
            
            case 3:
               if (list.getSize() > 0) {
                  boolean viewing = true;
                  
                  while (viewing) {
                     Employee currentEmployee = list.searchByIndex(currentIndex);
                     String nodeInfo = "Employee " + (currentIndex + 1) + " of " + list.getSize() + "\n"     
                                            + "Name: " + currentEmployee.getName() + "\n"
                                            + "Position: " + currentEmployee.getPosition() + "\n"
                                            + "Age: " + currentEmployee.getAge() + "\n"
                                            + "ID: " + currentEmployee.getID();
                     
                     String[] options4 = {"Previous", "Next", "Exit"};
                     int choice4 = JOptionPane.showOptionDialog(null, nodeInfo, "Employee information ",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, options4[0]);
                  
                     switch (choice4) {
                        case 0:
                           if (currentIndex > 0) {
                              currentIndex--;
                           } else {
                              JOptionPane.showMessageDialog(null, "This is the first employee.");
                           }
                           break;
                     
                        case 1:
                           if (currentIndex < list.getSize() - 1) {
                              currentIndex++;
                           } else {
                              JOptionPane.showMessageDialog(null, "This is the last employee.");
                           }
                           break;
                     
                        case 2:
                           viewing = false;
                           break;   
                     
                        default:
                           viewing = false;
                           break;
                     }
                  }  
               } else {
                  JOptionPane.showMessageDialog(null, "No employees in the list.");
               }
               break;
                                             
            case 4:
               String[] options5 = {"Selection", "Double Selection", "Bubble Sort", "Insertion Sort", "Quick Sort", "Merge Sort"};
               int choice5 = JOptionPane.showOptionDialog(null, "Sorting Options", "Sort Employees",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options5, options5[0]);
               
               switch (choice5) {
                  case 0:
                     list.selectionSort();
                     JOptionPane.showMessageDialog(null, "Employees sorted by Selection Sort!");
                     break;
                     
                  case 1:
                     list.doubleSelectionSort();
                     JOptionPane.showMessageDialog(null, "Employees are now sorted using Double Selection Sort!");
                     break;
                    
                  case 2:
                     list.bubbleSort();
                     JOptionPane.showMessageDialog(null, "Employees sorted by Bubble Sort!");
                     break;
                     
                  case 3:
                     list.insertionSort();
                     JOptionPane.showMessageDialog(null, "Employees sorted by Insertion Sort!");
                     break;
                     
                  case 4:
                     list.quickSort();
                     JOptionPane.showMessageDialog(null, "Employees are now sorted using Quick Sort");
                     break;
                  
                  case 5:
                     list.mergeSort();
                     JOptionPane.showMessageDialog(null, "Employees are now sorted using Merge Sort");
                     break;
                  
                  default:
                     break;   
               }
               continue;  
            
            case 5:
               run = false;
               break;
               
            
            default:
               break;
         }
      } 
   }
}