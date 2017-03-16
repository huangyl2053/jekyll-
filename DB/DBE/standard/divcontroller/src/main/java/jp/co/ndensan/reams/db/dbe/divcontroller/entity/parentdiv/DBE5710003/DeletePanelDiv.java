package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003;
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
 * DeletePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DeletePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTargetImage")
    private Label lblTargetImage;
    @JsonProperty("Chosahyo")
    private ChosahyoDiv Chosahyo;
    @JsonProperty("GaikyoTokki")
    private GaikyoTokkiDiv GaikyoTokki;
    @JsonProperty("Ikensho")
    private IkenshoDiv Ikensho;
    @JsonProperty("Sonota")
    private SonotaDiv Sonota;
    @JsonProperty("btnDelete")
    private Button btnDelete;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTargetImage
     * @return lblTargetImage
     */
    @JsonProperty("lblTargetImage")
    public Label getLblTargetImage() {
        return lblTargetImage;
    }

    /*
     * setlblTargetImage
     * @param lblTargetImage lblTargetImage
     */
    @JsonProperty("lblTargetImage")
    public void setLblTargetImage(Label lblTargetImage) {
        this.lblTargetImage = lblTargetImage;
    }

    /*
     * getChosahyo
     * @return Chosahyo
     */
    @JsonProperty("Chosahyo")
    public ChosahyoDiv getChosahyo() {
        return Chosahyo;
    }

    /*
     * setChosahyo
     * @param Chosahyo Chosahyo
     */
    @JsonProperty("Chosahyo")
    public void setChosahyo(ChosahyoDiv Chosahyo) {
        this.Chosahyo = Chosahyo;
    }

    /*
     * getGaikyoTokki
     * @return GaikyoTokki
     */
    @JsonProperty("GaikyoTokki")
    public GaikyoTokkiDiv getGaikyoTokki() {
        return GaikyoTokki;
    }

    /*
     * setGaikyoTokki
     * @param GaikyoTokki GaikyoTokki
     */
    @JsonProperty("GaikyoTokki")
    public void setGaikyoTokki(GaikyoTokkiDiv GaikyoTokki) {
        this.GaikyoTokki = GaikyoTokki;
    }

    /*
     * getIkensho
     * @return Ikensho
     */
    @JsonProperty("Ikensho")
    public IkenshoDiv getIkensho() {
        return Ikensho;
    }

    /*
     * setIkensho
     * @param Ikensho Ikensho
     */
    @JsonProperty("Ikensho")
    public void setIkensho(IkenshoDiv Ikensho) {
        this.Ikensho = Ikensho;
    }

    /*
     * getSonota
     * @return Sonota
     */
    @JsonProperty("Sonota")
    public SonotaDiv getSonota() {
        return Sonota;
    }

    /*
     * setSonota
     * @param Sonota Sonota
     */
    @JsonProperty("Sonota")
    public void setSonota(SonotaDiv Sonota) {
        this.Sonota = Sonota;
    }

    /*
     * getbtnDelete
     * @return btnDelete
     */
    @JsonProperty("btnDelete")
    public Button getBtnDelete() {
        return btnDelete;
    }

    /*
     * setbtnDelete
     * @param btnDelete btnDelete
     */
    @JsonProperty("btnDelete")
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkChosahyo() {
        return this.getChosahyo().getChkChosahyo();
    }

    @JsonIgnore
    public void  setChkChosahyo(CheckBoxList chkChosahyo) {
        this.getChosahyo().setChkChosahyo(chkChosahyo);
    }

    @JsonIgnore
    public RadioButton getRadChosahyoDeleteTarget() {
        return this.getChosahyo().getRadChosahyoDeleteTarget();
    }

    @JsonIgnore
    public void  setRadChosahyoDeleteTarget(RadioButton radChosahyoDeleteTarget) {
        this.getChosahyo().setRadChosahyoDeleteTarget(radChosahyoDeleteTarget);
    }

    @JsonIgnore
    public ChosahyoMessage1Div getChosahyoMessage1() {
        return this.getChosahyo().getChosahyoMessage1();
    }

    @JsonIgnore
    public void  setChosahyoMessage1(ChosahyoMessage1Div ChosahyoMessage1) {
        this.getChosahyo().setChosahyoMessage1(ChosahyoMessage1);
    }

    @JsonIgnore
    public Label getLblChosahyoMessage1() {
        return this.getChosahyo().getChosahyoMessage1().getLblChosahyoMessage1();
    }

    @JsonIgnore
    public void  setLblChosahyoMessage1(Label lblChosahyoMessage1) {
        this.getChosahyo().getChosahyoMessage1().setLblChosahyoMessage1(lblChosahyoMessage1);
    }

    @JsonIgnore
    public ChosahyoMessage2Div getChosahyoMessage2() {
        return this.getChosahyo().getChosahyoMessage2();
    }

    @JsonIgnore
    public void  setChosahyoMessage2(ChosahyoMessage2Div ChosahyoMessage2) {
        this.getChosahyo().setChosahyoMessage2(ChosahyoMessage2);
    }

    @JsonIgnore
    public Label getLblChosahyoMessage2() {
        return this.getChosahyo().getChosahyoMessage2().getLblChosahyoMessage2();
    }

    @JsonIgnore
    public void  setLblChosahyoMessage2(Label lblChosahyoMessage2) {
        this.getChosahyo().getChosahyoMessage2().setLblChosahyoMessage2(lblChosahyoMessage2);
    }

    @JsonIgnore
    public CheckBoxList getChkGaikyoTokki() {
        return this.getGaikyoTokki().getChkGaikyoTokki();
    }

    @JsonIgnore
    public void  setChkGaikyoTokki(CheckBoxList chkGaikyoTokki) {
        this.getGaikyoTokki().setChkGaikyoTokki(chkGaikyoTokki);
    }

    @JsonIgnore
    public RadioButton getRadGaikyoTokkiDeleteTarget() {
        return this.getGaikyoTokki().getRadGaikyoTokkiDeleteTarget();
    }

    @JsonIgnore
    public void  setRadGaikyoTokkiDeleteTarget(RadioButton radGaikyoTokkiDeleteTarget) {
        this.getGaikyoTokki().setRadGaikyoTokkiDeleteTarget(radGaikyoTokkiDeleteTarget);
    }

    @JsonIgnore
    public GaikyoTokkiMessage1Div getGaikyoTokkiMessage1() {
        return this.getGaikyoTokki().getGaikyoTokkiMessage1();
    }

    @JsonIgnore
    public void  setGaikyoTokkiMessage1(GaikyoTokkiMessage1Div GaikyoTokkiMessage1) {
        this.getGaikyoTokki().setGaikyoTokkiMessage1(GaikyoTokkiMessage1);
    }

    @JsonIgnore
    public Label getLblGaikyoTokkiMessage1() {
        return this.getGaikyoTokki().getGaikyoTokkiMessage1().getLblGaikyoTokkiMessage1();
    }

    @JsonIgnore
    public void  setLblGaikyoTokkiMessage1(Label lblGaikyoTokkiMessage1) {
        this.getGaikyoTokki().getGaikyoTokkiMessage1().setLblGaikyoTokkiMessage1(lblGaikyoTokkiMessage1);
    }

    @JsonIgnore
    public CheckBoxList getChkIkensho() {
        return this.getIkensho().getChkIkensho();
    }

    @JsonIgnore
    public void  setChkIkensho(CheckBoxList chkIkensho) {
        this.getIkensho().setChkIkensho(chkIkensho);
    }

    @JsonIgnore
    public RadioButton getRadIkenshoDeleteTarget() {
        return this.getIkensho().getRadIkenshoDeleteTarget();
    }

    @JsonIgnore
    public void  setRadIkenshoDeleteTarget(RadioButton radIkenshoDeleteTarget) {
        this.getIkensho().setRadIkenshoDeleteTarget(radIkenshoDeleteTarget);
    }

    @JsonIgnore
    public IkenshoMessage1Div getIkenshoMessage1() {
        return this.getIkensho().getIkenshoMessage1();
    }

    @JsonIgnore
    public void  setIkenshoMessage1(IkenshoMessage1Div IkenshoMessage1) {
        this.getIkensho().setIkenshoMessage1(IkenshoMessage1);
    }

    @JsonIgnore
    public Label getLblIkenshoMessage1() {
        return this.getIkensho().getIkenshoMessage1().getLblIkenshoMessage1();
    }

    @JsonIgnore
    public void  setLblIkenshoMessage1(Label lblIkenshoMessage1) {
        this.getIkensho().getIkenshoMessage1().setLblIkenshoMessage1(lblIkenshoMessage1);
    }

    @JsonIgnore
    public IkenshoMessage2Div getIkenshoMessage2() {
        return this.getIkensho().getIkenshoMessage2();
    }

    @JsonIgnore
    public void  setIkenshoMessage2(IkenshoMessage2Div IkenshoMessage2) {
        this.getIkensho().setIkenshoMessage2(IkenshoMessage2);
    }

    @JsonIgnore
    public Label getLblIkenshoMessage2() {
        return this.getIkensho().getIkenshoMessage2().getLblIkenshoMessage2();
    }

    @JsonIgnore
    public void  setLblIkenshoMessage2(Label lblIkenshoMessage2) {
        this.getIkensho().getIkenshoMessage2().setLblIkenshoMessage2(lblIkenshoMessage2);
    }

    @JsonIgnore
    public CheckBoxList getChkSonota() {
        return this.getSonota().getChkSonota();
    }

    @JsonIgnore
    public void  setChkSonota(CheckBoxList chkSonota) {
        this.getSonota().setChkSonota(chkSonota);
    }

    @JsonIgnore
    public RadioButton getRadSonotaDeleteTarget() {
        return this.getSonota().getRadSonotaDeleteTarget();
    }

    @JsonIgnore
    public void  setRadSonotaDeleteTarget(RadioButton radSonotaDeleteTarget) {
        this.getSonota().setRadSonotaDeleteTarget(radSonotaDeleteTarget);
    }

    @JsonIgnore
    public SonotaMessage1Div getSonotaMessage1() {
        return this.getSonota().getSonotaMessage1();
    }

    @JsonIgnore
    public void  setSonotaMessage1(SonotaMessage1Div SonotaMessage1) {
        this.getSonota().setSonotaMessage1(SonotaMessage1);
    }

    @JsonIgnore
    public Label getLblSonotaMessage1() {
        return this.getSonota().getSonotaMessage1().getLblSonotaMessage1();
    }

    @JsonIgnore
    public void  setLblSonotaMessage1(Label lblSonotaMessage1) {
        this.getSonota().getSonotaMessage1().setLblSonotaMessage1(lblSonotaMessage1);
    }

    @JsonIgnore
    public SonotaMessage2Div getSonotaMessage2() {
        return this.getSonota().getSonotaMessage2();
    }

    @JsonIgnore
    public void  setSonotaMessage2(SonotaMessage2Div SonotaMessage2) {
        this.getSonota().setSonotaMessage2(SonotaMessage2);
    }

    @JsonIgnore
    public Label getLblSonotaMessage2() {
        return this.getSonota().getSonotaMessage2().getLblSonotaMessage2();
    }

    @JsonIgnore
    public void  setLblSonotaMessage2(Label lblSonotaMessage2) {
        this.getSonota().getSonotaMessage2().setLblSonotaMessage2(lblSonotaMessage2);
    }

    // </editor-fold>
}
