create trigger
display_message
after insert or update on employee
begin
dbms_output.put_line('NEW EMPLOYEE DETAILS INSERTED');
END;
/
