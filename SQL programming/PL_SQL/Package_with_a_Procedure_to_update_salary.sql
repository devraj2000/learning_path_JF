create package EMP_DESIGNATION
as
PROCEDURE EMP_DETAILS
(
design employee.designation%type,
incentive number 
);
end EMP_DESIGNATION;
/
CREATE package body EMP_DESIGNATION
as
PROCEDURE EMP_DETAILS
(
design employee.designation%type,
incentive number
)
as
begin
update employee set employee.salary=employee.salary+incentive
where employee.designation=design;
dbms_output.put_line (sql%rowcount || 'employee(s) are updated.');
end EMP_DETAILS;
end EMP_DESIGNATION;
/
