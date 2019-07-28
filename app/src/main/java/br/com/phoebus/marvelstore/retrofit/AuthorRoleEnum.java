package br.com.phoebus.marvelstore.retrofit;

public enum AuthorRoleEnum {

    WRITER("writer"),
    PENCILER("penciler"),
    COVER_ARTIST("penciler (cover)");

    private String authorRole;

    AuthorRoleEnum(String authorRole) {
        this.authorRole = authorRole;
    }

    public String getAuthorRole() {
        return authorRole;
    }

}
