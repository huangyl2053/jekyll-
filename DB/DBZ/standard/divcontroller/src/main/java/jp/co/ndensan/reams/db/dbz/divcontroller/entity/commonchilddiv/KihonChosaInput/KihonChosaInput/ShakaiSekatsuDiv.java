package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShakaiSekatsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiSekatsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kusuri")
    private KusuriDiv Kusuri;
    @JsonProperty("KingakuKanri")
    private KingakuKanriDiv KingakuKanri;
    @JsonProperty("IshiKetei")
    private IshiKeteiDiv IshiKetei;
    @JsonProperty("Shudan")
    private ShudanDiv Shudan;
    @JsonProperty("KaiMono")
    private KaiMonoDiv KaiMono;
    @JsonProperty("KantanChori")
    private KantanChoriDiv KantanChori;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKusuri
     * @return Kusuri
     */
    @JsonProperty("Kusuri")
    public KusuriDiv getKusuri() {
        return Kusuri;
    }

    /*
     * setKusuri
     * @param Kusuri Kusuri
     */
    @JsonProperty("Kusuri")
    public void setKusuri(KusuriDiv Kusuri) {
        this.Kusuri = Kusuri;
    }

    /*
     * getKingakuKanri
     * @return KingakuKanri
     */
    @JsonProperty("KingakuKanri")
    public KingakuKanriDiv getKingakuKanri() {
        return KingakuKanri;
    }

    /*
     * setKingakuKanri
     * @param KingakuKanri KingakuKanri
     */
    @JsonProperty("KingakuKanri")
    public void setKingakuKanri(KingakuKanriDiv KingakuKanri) {
        this.KingakuKanri = KingakuKanri;
    }

    /*
     * getIshiKetei
     * @return IshiKetei
     */
    @JsonProperty("IshiKetei")
    public IshiKeteiDiv getIshiKetei() {
        return IshiKetei;
    }

    /*
     * setIshiKetei
     * @param IshiKetei IshiKetei
     */
    @JsonProperty("IshiKetei")
    public void setIshiKetei(IshiKeteiDiv IshiKetei) {
        this.IshiKetei = IshiKetei;
    }

    /*
     * getShudan
     * @return Shudan
     */
    @JsonProperty("Shudan")
    public ShudanDiv getShudan() {
        return Shudan;
    }

    /*
     * setShudan
     * @param Shudan Shudan
     */
    @JsonProperty("Shudan")
    public void setShudan(ShudanDiv Shudan) {
        this.Shudan = Shudan;
    }

    /*
     * getKaiMono
     * @return KaiMono
     */
    @JsonProperty("KaiMono")
    public KaiMonoDiv getKaiMono() {
        return KaiMono;
    }

    /*
     * setKaiMono
     * @param KaiMono KaiMono
     */
    @JsonProperty("KaiMono")
    public void setKaiMono(KaiMonoDiv KaiMono) {
        this.KaiMono = KaiMono;
    }

    /*
     * getKantanChori
     * @return KantanChori
     */
    @JsonProperty("KantanChori")
    public KantanChoriDiv getKantanChori() {
        return KantanChori;
    }

    /*
     * setKantanChori
     * @param KantanChori KantanChori
     */
    @JsonProperty("KantanChori")
    public void setKantanChori(KantanChoriDiv KantanChori) {
        this.KantanChori = KantanChori;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnKusuri() {
        return this.getKusuri().getBtnKusuri();
    }

    @JsonIgnore
    public void  setBtnKusuri(Button btnKusuri) {
        this.getKusuri().setBtnKusuri(btnKusuri);
    }

    @JsonIgnore
    public RadioButton getRadKusuri() {
        return this.getKusuri().getRadKusuri();
    }

    @JsonIgnore
    public void  setRadKusuri(RadioButton radKusuri) {
        this.getKusuri().setRadKusuri(radKusuri);
    }

    @JsonIgnore
    public Button getBtnKingakuKanri() {
        return this.getKingakuKanri().getBtnKingakuKanri();
    }

    @JsonIgnore
    public void  setBtnKingakuKanri(Button btnKingakuKanri) {
        this.getKingakuKanri().setBtnKingakuKanri(btnKingakuKanri);
    }

    @JsonIgnore
    public RadioButton getRadKingakuKanri() {
        return this.getKingakuKanri().getRadKingakuKanri();
    }

    @JsonIgnore
    public void  setRadKingakuKanri(RadioButton radKingakuKanri) {
        this.getKingakuKanri().setRadKingakuKanri(radKingakuKanri);
    }

    @JsonIgnore
    public Button getBtnIshiKetei() {
        return this.getIshiKetei().getBtnIshiKetei();
    }

    @JsonIgnore
    public void  setBtnIshiKetei(Button btnIshiKetei) {
        this.getIshiKetei().setBtnIshiKetei(btnIshiKetei);
    }

    @JsonIgnore
    public RadioButton getRadIshiKetei() {
        return this.getIshiKetei().getRadIshiKetei();
    }

    @JsonIgnore
    public void  setRadIshiKetei(RadioButton radIshiKetei) {
        this.getIshiKetei().setRadIshiKetei(radIshiKetei);
    }

    @JsonIgnore
    public Button getBtnShudan() {
        return this.getShudan().getBtnShudan();
    }

    @JsonIgnore
    public void  setBtnShudan(Button btnShudan) {
        this.getShudan().setBtnShudan(btnShudan);
    }

    @JsonIgnore
    public RadioButton getRadShudan() {
        return this.getShudan().getRadShudan();
    }

    @JsonIgnore
    public void  setRadShudan(RadioButton radShudan) {
        this.getShudan().setRadShudan(radShudan);
    }

    @JsonIgnore
    public Button getBtnKaiMono() {
        return this.getKaiMono().getBtnKaiMono();
    }

    @JsonIgnore
    public void  setBtnKaiMono(Button btnKaiMono) {
        this.getKaiMono().setBtnKaiMono(btnKaiMono);
    }

    @JsonIgnore
    public RadioButton getRadKaiMono() {
        return this.getKaiMono().getRadKaiMono();
    }

    @JsonIgnore
    public void  setRadKaiMono(RadioButton radKaiMono) {
        this.getKaiMono().setRadKaiMono(radKaiMono);
    }

    @JsonIgnore
    public Button getBtnKantanChori() {
        return this.getKantanChori().getBtnKantanChori();
    }

    @JsonIgnore
    public void  setBtnKantanChori(Button btnKantanChori) {
        this.getKantanChori().setBtnKantanChori(btnKantanChori);
    }

    @JsonIgnore
    public RadioButton getRadKantanChori() {
        return this.getKantanChori().getRadKantanChori();
    }

    @JsonIgnore
    public void  setRadKantanChori(RadioButton radKantanChori) {
        this.getKantanChori().setRadKantanChori(radKantanChori);
    }

    // </editor-fold>
}
