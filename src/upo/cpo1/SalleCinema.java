package upo.cpo1;

public final class SalleCinema {
    private final String film;
    private final int capacite;
    private int tarif;
    private int placesVendues;

    public SalleCinema(String film, int capacite, int tarif) {
        this.film = film;
        this.capacite = capacite;
        this.tarif = tarif;
        placesVendues = 0;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public String getFilm() {
        return film;
    }

    public int getPlacesVendues() {
        return placesVendues;
    }

    public void setPlacesVendues(int placesVendues) {
        this.placesVendues = placesVendues;
    }

    public void vendrePlace(){
        if(!estPleine()){
            placesVendues++;
        }
    }

    public float tauxRemplissage(){
        return (float) placesVendues / capacite;
    }

    public int chiffreAffaires(){
        return tarif * placesVendues;
    }

    public boolean estPleine(){
        if(capacite == placesVendues){
            return true;
        }
        return false;
    }

    public int nbPlacesDisponibles(){
        return capacite - placesVendues;
    }

    @Override
    public String toString() {
        final String Newligne=System.getProperty("line.separator");
        final StringBuilder sb = new StringBuilder("");
        sb.append("Film = ").append(film).append(Newligne);
        sb.append("Tarif = ").append(tarif).append(Newligne);
        sb.append("Nombre de places = ").append(capacite).append(Newligne);
        sb.append("Taux remplissage = ").append(tauxRemplissage()).append(Newligne);
        sb.append("Chiffre d'affaires = ").append(chiffreAffaires()).append(Newligne);
        return sb.toString();
    }
}
