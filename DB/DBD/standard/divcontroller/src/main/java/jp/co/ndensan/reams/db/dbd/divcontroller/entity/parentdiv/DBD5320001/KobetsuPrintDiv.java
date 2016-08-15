package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KobetsuPrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuPrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiKekkaTsuchi")
    private NinteiKekkaTsuchiDiv NinteiKekkaTsuchi;
    @JsonProperty("ServiceHenkoTsuchi")
    private ServiceHenkoTsuchiDiv ServiceHenkoTsuchi;
    @JsonProperty("YokaigodoHenkoTsuchi")
    private YokaigodoHenkoTsuchiDiv YokaigodoHenkoTsuchi;
    @JsonProperty("NinteiKyakkaTshuchi")
    private NinteiKyakkaTshuchiDiv NinteiKyakkaTshuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteiKekkaTsuchi
     * @return NinteiKekkaTsuchi
     */
    @JsonProperty("NinteiKekkaTsuchi")
    public NinteiKekkaTsuchiDiv getNinteiKekkaTsuchi() {
        return NinteiKekkaTsuchi;
    }

    /*
     * setNinteiKekkaTsuchi
     * @param NinteiKekkaTsuchi NinteiKekkaTsuchi
     */
    @JsonProperty("NinteiKekkaTsuchi")
    public void setNinteiKekkaTsuchi(NinteiKekkaTsuchiDiv NinteiKekkaTsuchi) {
        this.NinteiKekkaTsuchi = NinteiKekkaTsuchi;
    }

    /*
     * getServiceHenkoTsuchi
     * @return ServiceHenkoTsuchi
     */
    @JsonProperty("ServiceHenkoTsuchi")
    public ServiceHenkoTsuchiDiv getServiceHenkoTsuchi() {
        return ServiceHenkoTsuchi;
    }

    /*
     * setServiceHenkoTsuchi
     * @param ServiceHenkoTsuchi ServiceHenkoTsuchi
     */
    @JsonProperty("ServiceHenkoTsuchi")
    public void setServiceHenkoTsuchi(ServiceHenkoTsuchiDiv ServiceHenkoTsuchi) {
        this.ServiceHenkoTsuchi = ServiceHenkoTsuchi;
    }

    /*
     * getYokaigodoHenkoTsuchi
     * @return YokaigodoHenkoTsuchi
     */
    @JsonProperty("YokaigodoHenkoTsuchi")
    public YokaigodoHenkoTsuchiDiv getYokaigodoHenkoTsuchi() {
        return YokaigodoHenkoTsuchi;
    }

    /*
     * setYokaigodoHenkoTsuchi
     * @param YokaigodoHenkoTsuchi YokaigodoHenkoTsuchi
     */
    @JsonProperty("YokaigodoHenkoTsuchi")
    public void setYokaigodoHenkoTsuchi(YokaigodoHenkoTsuchiDiv YokaigodoHenkoTsuchi) {
        this.YokaigodoHenkoTsuchi = YokaigodoHenkoTsuchi;
    }

    /*
     * getNinteiKyakkaTshuchi
     * @return NinteiKyakkaTshuchi
     */
    @JsonProperty("NinteiKyakkaTshuchi")
    public NinteiKyakkaTshuchiDiv getNinteiKyakkaTshuchi() {
        return NinteiKyakkaTshuchi;
    }

    /*
     * setNinteiKyakkaTshuchi
     * @param NinteiKyakkaTshuchi NinteiKyakkaTshuchi
     */
    @JsonProperty("NinteiKyakkaTshuchi")
    public void setNinteiKyakkaTshuchi(NinteiKyakkaTshuchiDiv NinteiKyakkaTshuchi) {
        this.NinteiKyakkaTshuchi = NinteiKyakkaTshuchi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadNinteiKekkaRireki() {
        return this.getNinteiKekkaTsuchi().getRadNinteiKekkaRireki();
    }

    @JsonIgnore
    public void  setRadNinteiKekkaRireki(RadioButton radNinteiKekkaRireki) {
        this.getNinteiKekkaTsuchi().setRadNinteiKekkaRireki(radNinteiKekkaRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaSakuseiDay() {
        return this.getNinteiKekkaTsuchi().getTxtNinteiKekkaSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaSakuseiDay(TextBoxFlexibleDate txtNinteiKekkaSakuseiDay) {
        this.getNinteiKekkaTsuchi().setTxtNinteiKekkaSakuseiDay(txtNinteiKekkaSakuseiDay);
    }

    @JsonIgnore
    public TextBox getTxtNinteikekkaJoho() {
        return this.getNinteiKekkaTsuchi().getTxtNinteikekkaJoho();
    }

    @JsonIgnore
    public void  setTxtNinteikekkaJoho(TextBox txtNinteikekkaJoho) {
        this.getNinteiKekkaTsuchi().setTxtNinteikekkaJoho(txtNinteikekkaJoho);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiKekka() {
        return this.getNinteiKekkaTsuchi().getTxtNinteiKekka();
    }

    @JsonIgnore
    public void  setTxtNinteiKekka(TextBoxDateRange txtNinteiKekka) {
        this.getNinteiKekkaTsuchi().setTxtNinteiKekka(txtNinteiKekka);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNinteiKekkaShinsakaiIken() {
        return this.getNinteiKekkaTsuchi().getTxtNinteiKekkaShinsakaiIken();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaShinsakaiIken(TextBoxMultiLine txtNinteiKekkaShinsakaiIken) {
        this.getNinteiKekkaTsuchi().setTxtNinteiKekkaShinsakaiIken(txtNinteiKekkaShinsakaiIken);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNinteiKekkaRiyu() {
        return this.getNinteiKekkaTsuchi().getTxtNinteiKekkaRiyu();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaRiyu(TextBoxMultiLine txtNinteiKekkaRiyu) {
        this.getNinteiKekkaTsuchi().setTxtNinteiKekkaRiyu(txtNinteiKekkaRiyu);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuNinteiKekkaBunshoBango() {
        return this.getNinteiKekkaTsuchi().getCcdKobetsuNinteiKekkaBunshoBango();
    }

    @JsonIgnore
    public RadioButton getRadServiceHenkoBunshoRireki() {
        return this.getServiceHenkoTsuchi().getRadServiceHenkoBunshoRireki();
    }

    @JsonIgnore
    public void  setRadServiceHenkoBunshoRireki(RadioButton radServiceHenkoBunshoRireki) {
        this.getServiceHenkoTsuchi().setRadServiceHenkoBunshoRireki(radServiceHenkoBunshoRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoBunshoSakuseiDay() {
        return this.getServiceHenkoTsuchi().getTxtServiceHenkoBunshoSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoBunshoSakuseiDay(TextBoxFlexibleDate txtServiceHenkoBunshoSakuseiDay) {
        this.getServiceHenkoTsuchi().setTxtServiceHenkoBunshoSakuseiDay(txtServiceHenkoBunshoSakuseiDay);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtServiceHenkoBunshoYukoKikanRange() {
        return this.getServiceHenkoTsuchi().getTxtServiceHenkoBunshoYukoKikanRange();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoBunshoYukoKikanRange(TextBoxDateRange txtServiceHenkoBunshoYukoKikanRange) {
        this.getServiceHenkoTsuchi().setTxtServiceHenkoBunshoYukoKikanRange(txtServiceHenkoBunshoYukoKikanRange);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon1() {
        return this.getServiceHenkoTsuchi().getLinHorizon1();
    }

    @JsonIgnore
    public void  setLinHorizon1(HorizontalLine linHorizon1) {
        this.getServiceHenkoTsuchi().setLinHorizon1(linHorizon1);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHenkoBeforeService() {
        return this.getServiceHenkoTsuchi().getTxtHenkoBeforeService();
    }

    @JsonIgnore
    public void  setTxtHenkoBeforeService(TextBoxMultiLine txtHenkoBeforeService) {
        this.getServiceHenkoTsuchi().setTxtHenkoBeforeService(txtHenkoBeforeService);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon2() {
        return this.getServiceHenkoTsuchi().getLinHorizon2();
    }

    @JsonIgnore
    public void  setLinHorizon2(HorizontalLine linHorizon2) {
        this.getServiceHenkoTsuchi().setLinHorizon2(linHorizon2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHenkoAfterService() {
        return this.getServiceHenkoTsuchi().getTxtHenkoAfterService();
    }

    @JsonIgnore
    public void  setTxtHenkoAfterService(TextBoxMultiLine txtHenkoAfterService) {
        this.getServiceHenkoTsuchi().setTxtHenkoAfterService(txtHenkoAfterService);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon3() {
        return this.getServiceHenkoTsuchi().getLinHorizon3();
    }

    @JsonIgnore
    public void  setLinHorizon3(HorizontalLine linHorizon3) {
        this.getServiceHenkoTsuchi().setLinHorizon3(linHorizon3);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtServiceHenkoRiyu() {
        return this.getServiceHenkoTsuchi().getTxtServiceHenkoRiyu();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoRiyu(TextBoxMultiLine txtServiceHenkoRiyu) {
        this.getServiceHenkoTsuchi().setTxtServiceHenkoRiyu(txtServiceHenkoRiyu);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuServiceHenkoBunshoBango() {
        return this.getServiceHenkoTsuchi().getCcdKobetsuServiceHenkoBunshoBango();
    }

    @JsonIgnore
    public RadioButton getRadYokaigodoHenkoRireki() {
        return this.getYokaigodoHenkoTsuchi().getRadYokaigodoHenkoRireki();
    }

    @JsonIgnore
    public void  setRadYokaigodoHenkoRireki(RadioButton radYokaigodoHenkoRireki) {
        this.getYokaigodoHenkoTsuchi().setRadYokaigodoHenkoRireki(radYokaigodoHenkoRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokaigodoHenkoTsuchiSakuseiDay() {
        return this.getYokaigodoHenkoTsuchi().getTxtYokaigodoHenkoTsuchiSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtYokaigodoHenkoTsuchiSakuseiDay(TextBoxFlexibleDate txtYokaigodoHenkoTsuchiSakuseiDay) {
        this.getYokaigodoHenkoTsuchi().setTxtYokaigodoHenkoTsuchiSakuseiDay(txtYokaigodoHenkoTsuchiSakuseiDay);
    }

    @JsonIgnore
    public TextBox getTxtKyuYokaigodo() {
        return this.getYokaigodoHenkoTsuchi().getTxtKyuYokaigodo();
    }

    @JsonIgnore
    public void  setTxtKyuYokaigodo(TextBox txtKyuYokaigodo) {
        this.getYokaigodoHenkoTsuchi().setTxtKyuYokaigodo(txtKyuYokaigodo);
    }

    @JsonIgnore
    public TextBox getTxtShinYokaigodo() {
        return this.getYokaigodoHenkoTsuchi().getTxtShinYokaigodo();
    }

    @JsonIgnore
    public void  setTxtShinYokaigodo(TextBox txtShinYokaigodo) {
        this.getYokaigodoHenkoTsuchi().setTxtShinYokaigodo(txtShinYokaigodo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoYMD() {
        return this.getYokaigodoHenkoTsuchi().getTxtHenkoYMD();
    }

    @JsonIgnore
    public void  setTxtHenkoYMD(TextBoxFlexibleDate txtHenkoYMD) {
        this.getYokaigodoHenkoTsuchi().setTxtHenkoYMD(txtHenkoYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtYukoKikanRange() {
        return this.getYokaigodoHenkoTsuchi().getTxtYukoKikanRange();
    }

    @JsonIgnore
    public void  setTxtYukoKikanRange(TextBoxDateRange txtYukoKikanRange) {
        this.getYokaigodoHenkoTsuchi().setTxtYukoKikanRange(txtYukoKikanRange);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshashoTeishutsuKigen() {
        return this.getYokaigodoHenkoTsuchi().getTxtHihokenshashoTeishutsuKigen();
    }

    @JsonIgnore
    public void  setTxtHihokenshashoTeishutsuKigen(TextBoxFlexibleDate txtHihokenshashoTeishutsuKigen) {
        this.getYokaigodoHenkoTsuchi().setTxtHihokenshashoTeishutsuKigen(txtHihokenshashoTeishutsuKigen);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuKaigodoHenkoBunshoBango() {
        return this.getYokaigodoHenkoTsuchi().getCcdKobetsuKaigodoHenkoBunshoBango();
    }

    @JsonIgnore
    public RadioButton getRadNinteiKyakkaRireki() {
        return this.getNinteiKyakkaTshuchi().getRadNinteiKyakkaRireki();
    }

    @JsonIgnore
    public void  setRadNinteiKyakkaRireki(RadioButton radNinteiKyakkaRireki) {
        this.getNinteiKyakkaTshuchi().setRadNinteiKyakkaRireki(radNinteiKyakkaRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKyakkaTsuchi() {
        return this.getNinteiKyakkaTshuchi().getTxtNinteiKyakkaTsuchi();
    }

    @JsonIgnore
    public void  setTxtNinteiKyakkaTsuchi(TextBoxFlexibleDate txtNinteiKyakkaTsuchi) {
        this.getNinteiKyakkaTshuchi().setTxtNinteiKyakkaTsuchi(txtNinteiKyakkaTsuchi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKyakkaDay() {
        return this.getNinteiKyakkaTshuchi().getTxtKyakkaDay();
    }

    @JsonIgnore
    public void  setTxtKyakkaDay(TextBoxFlexibleDate txtKyakkaDay) {
        this.getNinteiKyakkaTshuchi().setTxtKyakkaDay(txtKyakkaDay);
    }

    @JsonIgnore
    public TextBox getTxtIdoJiyu() {
        return this.getNinteiKyakkaTshuchi().getTxtIdoJiyu();
    }

    @JsonIgnore
    public void  setTxtIdoJiyu(TextBox txtIdoJiyu) {
        this.getNinteiKyakkaTshuchi().setTxtIdoJiyu(txtIdoJiyu);
    }

    @JsonIgnore
    public Button getBtnCopyJiyuToRiyu() {
        return this.getNinteiKyakkaTshuchi().getBtnCopyJiyuToRiyu();
    }

    @JsonIgnore
    public void  setBtnCopyJiyuToRiyu(Button btnCopyJiyuToRiyu) {
        this.getNinteiKyakkaTshuchi().setBtnCopyJiyuToRiyu(btnCopyJiyuToRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyakkaRiyu() {
        return this.getNinteiKyakkaTshuchi().getTxtKyakkaRiyu();
    }

    @JsonIgnore
    public void  setTxtKyakkaRiyu(TextBoxMultiLine txtKyakkaRiyu) {
        this.getNinteiKyakkaTshuchi().setTxtKyakkaRiyu(txtKyakkaRiyu);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuNinteiKyakkaBunshoBango() {
        return this.getNinteiKyakkaTshuchi().getCcdKobetsuNinteiKyakkaBunshoBango();
    }

    // </editor-fold>
}
