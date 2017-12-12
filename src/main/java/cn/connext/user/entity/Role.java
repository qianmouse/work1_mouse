package cn.connext.user.entity;

public class Role {
    private String role;
    private String permission;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
