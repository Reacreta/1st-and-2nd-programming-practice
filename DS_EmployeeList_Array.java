import javax.swing.JOptionPane;

public class DS_EmployeeList_Array {
    
   final int arraySize=100;
   Employee EmployeeList[];// reference array object
   int size;
    
   DS_EmployeeList_Array(){    
      MakeEmpty();   
   }
    
   public void addItem(Employee E) {
    // Check if employee ID already exists
      for (int i = 0; i < size; i++) {
         if (EmployeeList[i].getID() == E.getID()) {
            JOptionPane.showMessageDialog(null, "Employee with ID " + E.getID() + " already exists!");
            return; // Stop execution if duplicate found
         }
      }
   
      if (size < arraySize) {
         EmployeeList[size] = new Employee(E); // Make a new Employee object
         size++;
         JOptionPane.showMessageDialog(null, "Employee added successfully!");
      }
   }
   
    
   public void MakeEmpty(){
      EmployeeList = new Employee[arraySize];
      size=0; 
   }
    
   public void addItem(int i, Employee E){
      if(size < arraySize ) {
         for (int j = size; j > i; j--) 
            EmployeeList[j] = EmployeeList[j - 1];
         EmployeeList[i]= E;
         size++;
      }
   }
    
   public Employee searchByIndex(int i) {
      return ((i>=0 && i<size)? EmployeeList[i]:null); 
    
   }
    
   public Employee searchByName(String name) {
      for(int i = 0; i < size; i++) {
         if (EmployeeList[i].getName().equalsIgnoreCase(name)) {
            return EmployeeList[i];
         }
      }
      return null;
   }
   
   public Employee searchByID(int id) {
      for(int i = 0; i < size; i++) {
         if (EmployeeList[i].getID() == id) {
            return EmployeeList[i];
         }
      }
      return null;
   }
   
   public Employee removeLastEmployee() {
      if (size > 0) {
         Employee lastEmployee = EmployeeList[size - 1];
         EmployeeList[size - 1] = null;
         size--;
         return lastEmployee;
      } else {
         return null;
      }
   }
   
    
   public void removeByIndex(int i) {
      if (searchByIndex(i) != null) {
         for (int j = i; j < size - 1; j++) {
            EmployeeList[j] = EmployeeList[j + 1]; // Shift employees to the left
         }
         EmployeeList[size - 1] = null; // Clear last entry after shifting
         size--;
      }
   }
    
   public String toString(){
      String str="";
        
      for(int i=0; i< size; i++)
         str += EmployeeList[i].toString()+"\n\n";
        
      return str; 
   }
    
   public int getSize(){
      return size;}
    
    
    
}