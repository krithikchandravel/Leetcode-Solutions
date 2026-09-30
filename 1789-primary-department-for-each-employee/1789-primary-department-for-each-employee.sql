select employee_id,count as department_id from (select employee_id,CASE
    WHEN primary_flag = 'Y'
        THEN department_id

    WHEN COUNT(department_id) OVER(PARTITION BY employee_id) = 1
        THEN department_id
END as count from employee) t where count is not null;