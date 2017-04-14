--
-- Structure de la table `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
  `id`      INT(5) PRIMARY KEY AUTO_INCREMENT,
  `content` TEXT NOT NULL
);

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id`       INT(5) PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(25)  NOT NULL,
  `password` VARCHAR(250) NOT NULL,
  `enabled`  BOOLEAN      NOT NULL
);

--
-- Structure de la table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id`   INT(5) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL
);

--
-- Structure de la table `user_role`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `id`      INT(10) PRIMARY KEY AUTO_INCREMENT,
  `user_id` INT(5) NOT NULL,
  `role_id` INT(5) NOT NULL,
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles (id)
);

--
-- Structure de la table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id`        INT(11) PRIMARY KEY AUTO_INCREMENT,
  `author_id` INT(5)  NOT NULL,
  `post_id`   INT(11) NOT NULL,
  `content`   TEXT    NOT NULL,
  CONSTRAINT fk_comments_posts FOREIGN KEY (post_id) REFERENCES posts (id),
  CONSTRAINT fk_comments_users FOREIGN KEY (author_id) REFERENCES users (id)
);

--
-- Structure de la table `likes`
--

CREATE TABLE IF NOT EXISTS `likes` (
  `id`        INT(11) PRIMARY KEY AUTO_INCREMENT,
  `author_id` INT(5)  NOT NULL,
  `post_id`   INT(11) NOT NULL,
  CONSTRAINT fk_likes_posts FOREIGN KEY (post_id) REFERENCES posts (id),
  CONSTRAINT fk_likes_users FOREIGN KEY (author_id) REFERENCES users (id)
);

