-- Assign Roles to Users
INSERT INTO user_roles (user_id, role_id)
VALUES
-- Assign ADMIN role to user_id 1
(1, (SELECT id FROM roles WHERE role_name = 'ADMIN')),

-- Assign GUEST role to user_id 2
(2, (SELECT id FROM roles WHERE role_name = 'GUEST')),

-- Assign AUTHORIZED_USER role to user_ids 3 to 20
(3, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(4, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(5, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(6, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(7, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(8, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(9, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(10, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(11, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(12, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(13, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(14, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(15, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(16, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(17, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(18, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(19, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER')),
(20, (SELECT id FROM roles WHERE role_name = 'AUTHORIZED_USER'));