public class StudentRecords {
    Character operationCode;
    int studentNumber;
    String lastName;
    int homeDepartment;
    String program;
    int year;
    public StudentRecords(Character operationCode, int studentNumber,String lastName, int homeDepartment, String program, int year){
        this.operationCode=operationCode;
        this.studentNumber=studentNumber;
        this.lastName=lastName;
        this.homeDepartment=homeDepartment;
        this.program=program;
        this.year=year;
    }

    @Override
    public String toString() {
        return this.studentNumber+" "+this.lastName+" "+this.homeDepartment+this.program+" "+this.year;
    }
}
