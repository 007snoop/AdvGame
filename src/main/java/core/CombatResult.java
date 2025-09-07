package core;

public class CombatResult {
    private int damage;
    private boolean hit;
    private String message;

    public CombatResult(int damage, boolean hit, String message) {
        this.damage = damage;
        this.hit = hit;
        this.message = message;
    }

    public int getDamage() {
        return damage;
    }

    public String getMessage() {
        return message;
    }

    public boolean isHit() {
        return hit;
    }
}
