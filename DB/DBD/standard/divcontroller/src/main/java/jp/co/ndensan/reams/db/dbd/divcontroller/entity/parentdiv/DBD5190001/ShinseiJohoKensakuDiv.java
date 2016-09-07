package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiJohoKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiJohoKensakuDiv extends Panel {
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
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("btnJokenClear")
    private Button btnJokenClear;

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
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getbtnJokenClear
     * @return btnJokenClear
     */
    @JsonProperty("btnJokenClear")
    public Button getBtnJokenClear() {
        return btnJokenClear;
    }

    /*
     * setbtnJokenClear
     * @param btnJokenClear btnJokenClear
     */
    @JsonProperty("btnJokenClear")
    public void setBtnJokenClear(Button btnJokenClear) {
        this.btnJokenClear = btnJokenClear;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void  setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public KensakuJokenTaishoKikanDiv getKensakuJokenTaishoKikan() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan();
    }

    @JsonIgnore
    public void  setKensakuJokenTaishoKikan(KensakuJokenTaishoKikanDiv KensakuJokenTaishoKikan) {
        this.getChushutsuJoken().setKensakuJokenTaishoKikan(KensakuJokenTaishoKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDay() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiDay(TextBoxDate txtZenkaiKaishiDay) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiKaishiDay(txtZenkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblZenkaiFor() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getLblZenkaiFor();
    }

    @JsonIgnore
    public void  setLblZenkaiFor(Label lblZenkaiFor) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setLblZenkaiFor(lblZenkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDay() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoDay(TextBoxDate txtZenkaiShuryoDay) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiShuryoDay(txtZenkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDay() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiDay(TextBoxDate txtKonkaiKaishiDay) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiKaishiDay(txtKonkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblKonkaiFor() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getLblKonkaiFor();
    }

    @JsonIgnore
    public void  setLblKonkaiFor(Label lblKonkaiFor) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setLblKonkaiFor(lblKonkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDay() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoDay(TextBoxDate txtKonkaiShuryoDay) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiShuryoDay(txtKonkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    @JsonIgnore
    public KensakuJokenHihokenshaDiv getKensakuJokenHihokensha() {
        return this.getChushutsuJoken().getKensakuJokenHihokensha();
    }

    @JsonIgnore
    public void  setKensakuJokenHihokensha(KensakuJokenHihokenshaDiv KensakuJokenHihokensha) {
        this.getChushutsuJoken().setKensakuJokenHihokensha(KensakuJokenHihokensha);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getChushutsuJoken().getKensakuJokenHihokensha().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getChushutsuJoken().getKensakuJokenHihokensha().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaGuide() {
        return this.getChushutsuJoken().getKensakuJokenHihokensha().getBtnHihokenshaGuide();
    }

    @JsonIgnore
    public void  setBtnHihokenshaGuide(ButtonDialog btnHihokenshaGuide) {
        this.getChushutsuJoken().getKensakuJokenHihokensha().setBtnHihokenshaGuide(btnHihokenshaGuide);
    }

    @JsonIgnore
    public Button getBtnhihokensha() {
        return this.getChushutsuJoken().getKensakuJokenHihokensha().getBtnhihokensha();
    }

    @JsonIgnore
    public void  setBtnhihokensha(Button btnhihokensha) {
        this.getChushutsuJoken().getKensakuJokenHihokensha().setBtnhihokensha(btnhihokensha);
    }

    @JsonIgnore
    public IHokenshaListDiv getCommonChildDiv1() {
        return this.getChushutsuJoken().getCommonChildDiv1();
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
    public RadioButton getRadIfShubetsu() {
        return this.getShutsuryokuTaiishoIF().getRadIfShubetsu();
    }

    @JsonIgnore
    public void  setRadIfShubetsu(RadioButton radIfShubetsu) {
        this.getShutsuryokuTaiishoIF().setRadIfShubetsu(radIfShubetsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getShutsuryokuTaiishoIF().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getShutsuryokuTaiishoIF().setTxtMaxKensu(txtMaxKensu);
    }

    // </editor-fold>
}
