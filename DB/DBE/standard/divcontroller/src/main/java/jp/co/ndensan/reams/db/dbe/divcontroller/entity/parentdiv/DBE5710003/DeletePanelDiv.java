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
    public ChosahyoMessageDiv getChosahyoMessage() {
        return this.getChosahyo().getChosahyoMessage();
    }

    @JsonIgnore
    public void  setChosahyoMessage(ChosahyoMessageDiv ChosahyoMessage) {
        this.getChosahyo().setChosahyoMessage(ChosahyoMessage);
    }

    @JsonIgnore
    public Label getLblChosahyoMessage() {
        return this.getChosahyo().getChosahyoMessage().getLblChosahyoMessage();
    }

    @JsonIgnore
    public void  setLblChosahyoMessage(Label lblChosahyoMessage) {
        this.getChosahyo().getChosahyoMessage().setLblChosahyoMessage(lblChosahyoMessage);
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
    public GaikyoTokkiMessageDiv getGaikyoTokkiMessage() {
        return this.getGaikyoTokki().getGaikyoTokkiMessage();
    }

    @JsonIgnore
    public void  setGaikyoTokkiMessage(GaikyoTokkiMessageDiv GaikyoTokkiMessage) {
        this.getGaikyoTokki().setGaikyoTokkiMessage(GaikyoTokkiMessage);
    }

    @JsonIgnore
    public Label getLblGaikyoTokkiMessage() {
        return this.getGaikyoTokki().getGaikyoTokkiMessage().getLblGaikyoTokkiMessage();
    }

    @JsonIgnore
    public void  setLblGaikyoTokkiMessage(Label lblGaikyoTokkiMessage) {
        this.getGaikyoTokki().getGaikyoTokkiMessage().setLblGaikyoTokkiMessage(lblGaikyoTokkiMessage);
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
    public IkenshoMessageDiv getIkenshoMessage() {
        return this.getIkensho().getIkenshoMessage();
    }

    @JsonIgnore
    public void  setIkenshoMessage(IkenshoMessageDiv IkenshoMessage) {
        this.getIkensho().setIkenshoMessage(IkenshoMessage);
    }

    @JsonIgnore
    public Label getLblIkenshoMessage() {
        return this.getIkensho().getIkenshoMessage().getLblIkenshoMessage();
    }

    @JsonIgnore
    public void  setLblIkenshoMessage(Label lblIkenshoMessage) {
        this.getIkensho().getIkenshoMessage().setLblIkenshoMessage(lblIkenshoMessage);
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
    public SonotaMessageDiv getSonotaMessage() {
        return this.getSonota().getSonotaMessage();
    }

    @JsonIgnore
    public void  setSonotaMessage(SonotaMessageDiv SonotaMessage) {
        this.getSonota().setSonotaMessage(SonotaMessage);
    }

    @JsonIgnore
    public Label getLblSonotaMessage() {
        return this.getSonota().getSonotaMessage().getLblSonotaMessage();
    }

    @JsonIgnore
    public void  setLblSonotaMessage(Label lblSonotaMessage) {
        this.getSonota().getSonotaMessage().setLblSonotaMessage(lblSonotaMessage);
    }

    // </editor-fold>
}
