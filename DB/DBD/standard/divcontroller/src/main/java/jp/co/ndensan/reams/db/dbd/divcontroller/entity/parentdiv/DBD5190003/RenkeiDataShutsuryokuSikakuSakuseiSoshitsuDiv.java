package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190003;
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
 * RenkeiDataShutsuryokuSikakuSakuseiSoshitsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ShutsuryokuTaiishoIF")
    private ShutsuryokuTaiishoIFDiv ShutsuryokuTaiishoIF;
    @JsonProperty("HanteiIraiIchiranhyo")
    private HanteiIraiIchiranhyoDiv HanteiIraiIchiranhyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getShutsuryokuTaiishoIF
     * @return ShutsuryokuTaiishoIF
     */
    @JsonProperty("ShutsuryokuTaiishoIF")
    public ShutsuryokuTaiishoIFDiv getShutsuryokuTaiishoIF() {
        return ShutsuryokuTaiishoIF;
    }

    /*
     * setShutsuryokuTaiishoIF
     * @param ShutsuryokuTaiishoIF ShutsuryokuTaiishoIF
     */
    @JsonProperty("ShutsuryokuTaiishoIF")
    public void setShutsuryokuTaiishoIF(ShutsuryokuTaiishoIFDiv ShutsuryokuTaiishoIF) {
        this.ShutsuryokuTaiishoIF = ShutsuryokuTaiishoIF;
    }

    /*
     * getHanteiIraiIchiranhyo
     * @return HanteiIraiIchiranhyo
     */
    @JsonProperty("HanteiIraiIchiranhyo")
    public HanteiIraiIchiranhyoDiv getHanteiIraiIchiranhyo() {
        return HanteiIraiIchiranhyo;
    }

    /*
     * setHanteiIraiIchiranhyo
     * @param HanteiIraiIchiranhyo HanteiIraiIchiranhyo
     */
    @JsonProperty("HanteiIraiIchiranhyo")
    public void setHanteiIraiIchiranhyo(HanteiIraiIchiranhyoDiv HanteiIraiIchiranhyo) {
        this.HanteiIraiIchiranhyo = HanteiIraiIchiranhyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTaishoKikan() {
        return this.getChushutsuJoken().getLblTaishoKikan();
    }

    @JsonIgnore
    public void  setLblTaishoKikan(Label lblTaishoKikan) {
        this.getChushutsuJoken().setLblTaishoKikan(lblTaishoKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDay() {
        return this.getChushutsuJoken().getTxtZenkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiDay(TextBoxDate txtZenkaiKaishiDay) {
        this.getChushutsuJoken().setTxtZenkaiKaishiDay(txtZenkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getChushutsuJoken().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getChushutsuJoken().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblZenkaiFor() {
        return this.getChushutsuJoken().getLblZenkaiFor();
    }

    @JsonIgnore
    public void  setLblZenkaiFor(Label lblZenkaiFor) {
        this.getChushutsuJoken().setLblZenkaiFor(lblZenkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDay() {
        return this.getChushutsuJoken().getTxtZenkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoDay(TextBoxDate txtZenkaiShuryoDay) {
        this.getChushutsuJoken().setTxtZenkaiShuryoDay(txtZenkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getChushutsuJoken().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getChushutsuJoken().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDay() {
        return this.getChushutsuJoken().getTxtKonkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiDay(TextBoxDate txtKonkaiKaishiDay) {
        this.getChushutsuJoken().setTxtKonkaiKaishiDay(txtKonkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getChushutsuJoken().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getChushutsuJoken().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblKonkaiFor() {
        return this.getChushutsuJoken().getLblKonkaiFor();
    }

    @JsonIgnore
    public void  setLblKonkaiFor(Label lblKonkaiFor) {
        this.getChushutsuJoken().setLblKonkaiFor(lblKonkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDay() {
        return this.getChushutsuJoken().getTxtKonkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoDay(TextBoxDate txtKonkaiShuryoDay) {
        this.getChushutsuJoken().setTxtKonkaiShuryoDay(txtKonkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getChushutsuJoken().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getChushutsuJoken().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    @JsonIgnore
    public Label getLblChushutuTaisho() {
        return this.getChushutsuJoken().getLblChushutuTaisho();
    }

    @JsonIgnore
    public void  setLblChushutuTaisho(Label lblChushutuTaisho) {
        this.getChushutsuJoken().setLblChushutuTaisho(lblChushutuTaisho);
    }

    @JsonIgnore
    public RadioButton getRadIfShubetu() {
        return this.getShutsuryokuTaiishoIF().getRadIfShubetu();
    }

    @JsonIgnore
    public void  setRadIfShubetu(RadioButton radIfShubetu) {
        this.getShutsuryokuTaiishoIF().setRadIfShubetu(radIfShubetu);
    }

    @JsonIgnore
    public TextBox getTxtNewFileName() {
        return this.getShutsuryokuTaiishoIF().getTxtNewFileName();
    }

    @JsonIgnore
    public void  setTxtNewFileName(TextBox txtNewFileName) {
        this.getShutsuryokuTaiishoIF().setTxtNewFileName(txtNewFileName);
    }

    @JsonIgnore
    public RadioButton getRadInsatsuDay() {
        return this.getHanteiIraiIchiranhyo().getRadInsatsuDay();
    }

    @JsonIgnore
    public void  setRadInsatsuDay(RadioButton RadInsatsuDay) {
        this.getHanteiIraiIchiranhyo().setRadInsatsuDay(RadInsatsuDay);
    }

    @JsonIgnore
    public Label getLblInsatsuDayComment() {
        return this.getHanteiIraiIchiranhyo().getLblInsatsuDayComment();
    }

    @JsonIgnore
    public void  setLblInsatsuDayComment(Label lblInsatsuDayComment) {
        this.getHanteiIraiIchiranhyo().setLblInsatsuDayComment(lblInsatsuDayComment);
    }

    // </editor-fold>
}
