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
 * RenkeiDataSakuseiShinseiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class RenkeiDataSakuseiShinseiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinseiJohoKensaku")
    private ShinseiJohoKensakuDiv ShinseiJohoKensaku;
    @JsonProperty("TaishoshaIchiran")
    private TaishoshaIchiranDiv TaishoshaIchiran;
    @JsonProperty("HanteiIraiIchiranhyo")
    private HanteiIraiIchiranhyoDiv HanteiIraiIchiranhyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinseiJohoKensaku
     * @return ShinseiJohoKensaku
     */
    @JsonProperty("ShinseiJohoKensaku")
    public ShinseiJohoKensakuDiv getShinseiJohoKensaku() {
        return ShinseiJohoKensaku;
    }

    /*
     * setShinseiJohoKensaku
     * @param ShinseiJohoKensaku ShinseiJohoKensaku
     */
    @JsonProperty("ShinseiJohoKensaku")
    public void setShinseiJohoKensaku(ShinseiJohoKensakuDiv ShinseiJohoKensaku) {
        this.ShinseiJohoKensaku = ShinseiJohoKensaku;
    }

    /*
     * getTaishoshaIchiran
     * @return TaishoshaIchiran
     */
    @JsonProperty("TaishoshaIchiran")
    public TaishoshaIchiranDiv getTaishoshaIchiran() {
        return TaishoshaIchiran;
    }

    /*
     * setTaishoshaIchiran
     * @param TaishoshaIchiran TaishoshaIchiran
     */
    @JsonProperty("TaishoshaIchiran")
    public void setTaishoshaIchiran(TaishoshaIchiranDiv TaishoshaIchiran) {
        this.TaishoshaIchiran = TaishoshaIchiran;
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
    public ChushutsuJokenDiv getChushutsuJoken() {
        return this.getShinseiJohoKensaku().getChushutsuJoken();
    }

    @JsonIgnore
    public void  setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.getShinseiJohoKensaku().setChushutsuJoken(ChushutsuJoken);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void  setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getShinseiJohoKensaku().getChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public KensakuJokenTaishoKikanDiv getKensakuJokenTaishoKikan() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan();
    }

    @JsonIgnore
    public void  setKensakuJokenTaishoKikan(KensakuJokenTaishoKikanDiv KensakuJokenTaishoKikan) {
        this.getShinseiJohoKensaku().getChushutsuJoken().setKensakuJokenTaishoKikan(KensakuJokenTaishoKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDay() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiDay(TextBoxDate txtZenkaiKaishiDay) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiKaishiDay(txtZenkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblZenkaiFor() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getLblZenkaiFor();
    }

    @JsonIgnore
    public void  setLblZenkaiFor(Label lblZenkaiFor) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setLblZenkaiFor(lblZenkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDay() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoDay(TextBoxDate txtZenkaiShuryoDay) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiShuryoDay(txtZenkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDay() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiKaishiDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiDay(TextBoxDate txtKonkaiKaishiDay) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiKaishiDay(txtKonkaiKaishiDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblKonkaiFor() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getLblKonkaiFor();
    }

    @JsonIgnore
    public void  setLblKonkaiFor(Label lblKonkaiFor) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setLblKonkaiFor(lblKonkaiFor);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDay() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiShuryoDay();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoDay(TextBoxDate txtKonkaiShuryoDay) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiShuryoDay(txtKonkaiShuryoDay);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenTaishoKikan().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    @JsonIgnore
    public KensakuJokenHihokenshaDiv getKensakuJokenHihokensha() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenHihokensha();
    }

    @JsonIgnore
    public void  setKensakuJokenHihokensha(KensakuJokenHihokenshaDiv KensakuJokenHihokensha) {
        this.getShinseiJohoKensaku().getChushutsuJoken().setKensakuJokenHihokensha(KensakuJokenHihokensha);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenHihokensha().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenHihokensha().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaGuide() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenHihokensha().getBtnHihokenshaGuide();
    }

    @JsonIgnore
    public void  setBtnHihokenshaGuide(ButtonDialog btnHihokenshaGuide) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenHihokensha().setBtnHihokenshaGuide(btnHihokenshaGuide);
    }

    @JsonIgnore
    public Button getBtnhihokensha() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenHihokensha().getBtnhihokensha();
    }

    @JsonIgnore
    public void  setBtnhihokensha(Button btnhihokensha) {
        this.getShinseiJohoKensaku().getChushutsuJoken().getKensakuJokenHihokensha().setBtnhihokensha(btnhihokensha);
    }

    @JsonIgnore
    public IHokenshaListDiv getCommonChildDiv1() {
        return this.getShinseiJohoKensaku().getChushutsuJoken().getCommonChildDiv1();
    }

    @JsonIgnore
    public ShutsuryokuTaiishoIFDiv getShutsuryokuTaiishoIF() {
        return this.getShinseiJohoKensaku().getShutsuryokuTaiishoIF();
    }

    @JsonIgnore
    public void  setShutsuryokuTaiishoIF(ShutsuryokuTaiishoIFDiv ShutsuryokuTaiishoIF) {
        this.getShinseiJohoKensaku().setShutsuryokuTaiishoIF(ShutsuryokuTaiishoIF);
    }

    @JsonIgnore
    public TextBox getTxtNewFileName() {
        return this.getShinseiJohoKensaku().getShutsuryokuTaiishoIF().getTxtNewFileName();
    }

    @JsonIgnore
    public void  setTxtNewFileName(TextBox txtNewFileName) {
        this.getShinseiJohoKensaku().getShutsuryokuTaiishoIF().setTxtNewFileName(txtNewFileName);
    }

    @JsonIgnore
    public RadioButton getRadIfShubetsu() {
        return this.getShinseiJohoKensaku().getShutsuryokuTaiishoIF().getRadIfShubetsu();
    }

    @JsonIgnore
    public void  setRadIfShubetsu(RadioButton radIfShubetsu) {
        this.getShinseiJohoKensaku().getShutsuryokuTaiishoIF().setRadIfShubetsu(radIfShubetsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getShinseiJohoKensaku().getShutsuryokuTaiishoIF().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getShinseiJohoKensaku().getShutsuryokuTaiishoIF().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getShinseiJohoKensaku().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getShinseiJohoKensaku().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnJokenClear() {
        return this.getShinseiJohoKensaku().getBtnJokenClear();
    }

    @JsonIgnore
    public void  setBtnJokenClear(Button btnJokenClear) {
        this.getShinseiJohoKensaku().setBtnJokenClear(btnJokenClear);
    }

    @JsonIgnore
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return this.getTaishoshaIchiran().getDgTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.getTaishoshaIchiran().setDgTaishoshaIchiran(dgTaishoshaIchiran);
    }

    @JsonIgnore
    public TextBox getTxtInsatsuDay() {
        return this.getHanteiIraiIchiranhyo().getTxtInsatsuDay();
    }

    @JsonIgnore
    public void  setTxtInsatsuDay(TextBox txtInsatsuDay) {
        this.getHanteiIraiIchiranhyo().setTxtInsatsuDay(txtInsatsuDay);
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
