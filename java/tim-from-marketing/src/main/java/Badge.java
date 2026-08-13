class principal{
    public static void main(String[] args) {
        Badge badge = new Badge();
        badge.print(17, "Ryder Herbert", "Marketing");
        badge.print(null, "Bogdan Rosario", "Marketing");
        badge.print(59, "Julie Sokato", null);
        badge.print(null, "Amare Osei", null);
    }
}

class Badge {

    public String print(Integer id, String name, String department) {
        String employeeBadgeLabel;
        if (id != null){
            employeeBadgeLabel = "[" + id + "] - " + name + " - ";
            employeeBadgeLabel += (department != null) ?  department.toUpperCase() : "OWNER";

        }else{
            employeeBadgeLabel = name + " - ";
            employeeBadgeLabel += (department != null) ?  department.toUpperCase() : "OWNER";
        }

        return employeeBadgeLabel;
    }
}
