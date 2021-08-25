TRUNCATE `mydbtest`.`users_roles`;
TRUNCATE `mydbtest`.`users`;
INSERT INTO `mydbtest`.`users` (`department`, `name`, `password`, `salary`, `surname`) VALUES ('ad', 'admin', '$2a$10$rQnl/Z6gxB3IOgfOXFAyVe6G4lLa3ik8l7jQTGAP5yNPxL4i5Xl5S', '100', 'admin');
INSERT INTO `mydbtest`.`users` (`department`, `name`, `password`, `salary`, `surname`) VALUES ('us', 'user', '$2a$10$fzfTO8VCpMxkk1n/9BjOuuO6ZbQCAGJ6hW7CpWDvr0CXskYEB7S4e', '100', 'user');
INSERT INTO `mydbtest`.`users_roles` (`User_id`, `roles_id`) VALUES ('1', '1');
INSERT INTO `mydbtest`.`users_roles` (`User_id`, `roles_id`) VALUES ('2', '2');


    
    