SELECT 
    u.name Name, a.moduleID Module, a.date Date
FROM
    approval a
        INNER JOIN
    user u ON a.studentID = u.userID;