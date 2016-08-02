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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiTsuchishoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiTsuchishoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Printselect")
    private PrintselectDiv Printselect;
    @JsonProperty("TaishoshaKensaku")
    private TaishoshaKensakuDiv TaishoshaKensaku;
    @JsonProperty("TaishoshaIchiran")
    private TaishoshaIchiranDiv TaishoshaIchiran;
    @JsonProperty("KobetsuPrint")
    private KobetsuPrintDiv KobetsuPrint;
    @JsonProperty("IkkatsuHakko")
    private IkkatsuHakkoDiv IkkatsuHakko;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPrintselect
     * @return Printselect
     */
    @JsonProperty("Printselect")
    public PrintselectDiv getPrintselect() {
        return Printselect;
    }

    /*
     * setPrintselect
     * @param Printselect Printselect
     */
    @JsonProperty("Printselect")
    public void setPrintselect(PrintselectDiv Printselect) {
        this.Printselect = Printselect;
    }

    /*
     * getTaishoshaKensaku
     * @return TaishoshaKensaku
     */
    @JsonProperty("TaishoshaKensaku")
    public TaishoshaKensakuDiv getTaishoshaKensaku() {
        return TaishoshaKensaku;
    }

    /*
     * setTaishoshaKensaku
     * @param TaishoshaKensaku TaishoshaKensaku
     */
    @JsonProperty("TaishoshaKensaku")
    public void setTaishoshaKensaku(TaishoshaKensakuDiv TaishoshaKensaku) {
        this.TaishoshaKensaku = TaishoshaKensaku;
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
     * getKobetsuPrint
     * @return KobetsuPrint
     */
    @JsonProperty("KobetsuPrint")
    public KobetsuPrintDiv getKobetsuPrint() {
        return KobetsuPrint;
    }

    /*
     * setKobetsuPrint
     * @param KobetsuPrint KobetsuPrint
     */
    @JsonProperty("KobetsuPrint")
    public void setKobetsuPrint(KobetsuPrintDiv KobetsuPrint) {
        this.KobetsuPrint = KobetsuPrint;
    }

    /*
     * getIkkatsuHakko
     * @return IkkatsuHakko
     */
    @JsonProperty("IkkatsuHakko")
    public IkkatsuHakkoDiv getIkkatsuHakko() {
        return IkkatsuHakko;
    }

    /*
     * setIkkatsuHakko
     * @param IkkatsuHakko IkkatsuHakko
     */
    @JsonProperty("IkkatsuHakko")
    public void setIkkatsuHakko(IkkatsuHakkoDiv IkkatsuHakko) {
        this.IkkatsuHakko = IkkatsuHakko;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadPrintSelect() {
        return this.getPrintselect().getRadPrintSelect();
    }

    @JsonIgnore
    public void  setRadPrintSelect(RadioButton radPrintSelect) {
        this.getPrintselect().setRadPrintSelect(radPrintSelect);
    }

    @JsonIgnore
    public HihokenshaDiv getHihokensha() {
        return this.getTaishoshaKensaku().getHihokensha();
    }

    @JsonIgnore
    public void  setHihokensha(HihokenshaDiv Hihokensha) {
        this.getTaishoshaKensaku().setHihokensha(Hihokensha);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getTaishoshaKensaku().getHihokensha().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getTaishoshaKensaku().getHihokensha().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getTaishoshaKensaku().getHihokensha().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getTaishoshaKensaku().getHihokensha().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public DropDownList getDdlMachJoken() {
        return this.getTaishoshaKensaku().getHihokensha().getDdlMachJoken();
    }

    @JsonIgnore
    public void  setDdlMachJoken(DropDownList ddlMachJoken) {
        this.getTaishoshaKensaku().getHihokensha().setDdlMachJoken(ddlMachJoken);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikibetsuCode() {
        return this.getTaishoshaKensaku().getHihokensha().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.getTaishoshaKensaku().getHihokensha().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthYMD() {
        return this.getTaishoshaKensaku().getHihokensha().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxFlexibleDate txtBirthYMD) {
        this.getTaishoshaKensaku().getHihokensha().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkSeibetsu() {
        return this.getTaishoshaKensaku().getHihokensha().getChkSeibetsu();
    }

    @JsonIgnore
    public void  setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.getTaishoshaKensaku().getHihokensha().setChkSeibetsu(chkSeibetsu);
    }

    @JsonIgnore
    public YokaigoNinteiDiv getYokaigoNintei() {
        return this.getTaishoshaKensaku().getYokaigoNintei();
    }

    @JsonIgnore
    public void  setYokaigoNintei(YokaigoNinteiDiv YokaigoNintei) {
        this.getTaishoshaKensaku().setYokaigoNintei(YokaigoNintei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiDay() {
        return this.getTaishoshaKensaku().getYokaigoNintei().getTxtShinseiDay();
    }

    @JsonIgnore
    public void  setTxtShinseiDay(TextBoxDateRange txtShinseiDay) {
        this.getTaishoshaKensaku().getYokaigoNintei().setTxtShinseiDay(txtShinseiDay);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiDay() {
        return this.getTaishoshaKensaku().getYokaigoNintei().getTxtNinteiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiDay(TextBoxDateRange txtNinteiDay) {
        this.getTaishoshaKensaku().getYokaigoNintei().setTxtNinteiDay(txtNinteiDay);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return this.getTaishoshaKensaku().getTxtSaidaiHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.getTaishoshaKensaku().setTxtSaidaiHyojiKensu(txtSaidaiHyojiKensu);
    }

    @JsonIgnore
    public Button getBtnJokenClear() {
        return this.getTaishoshaKensaku().getBtnJokenClear();
    }

    @JsonIgnore
    public void  setBtnJokenClear(Button btnJokenClear) {
        this.getTaishoshaKensaku().setBtnJokenClear(btnJokenClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getTaishoshaKensaku().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getTaishoshaKensaku().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getTaishoshaKensaku().getCcdHokenshaList();
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
    public NinteiKekkaTsuchiDiv getNinteiKekkaTsuchi() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi();
    }

    @JsonIgnore
    public void  setNinteiKekkaTsuchi(NinteiKekkaTsuchiDiv NinteiKekkaTsuchi) {
        this.getKobetsuPrint().setNinteiKekkaTsuchi(NinteiKekkaTsuchi);
    }

    @JsonIgnore
    public RadioButton getRadNinteiKekkaRireki() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi().getRadNinteiKekkaRireki();
    }

    @JsonIgnore
    public void  setRadNinteiKekkaRireki(RadioButton radNinteiKekkaRireki) {
        this.getKobetsuPrint().getNinteiKekkaTsuchi().setRadNinteiKekkaRireki(radNinteiKekkaRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaSakuseiDay() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi().getTxtNinteiKekkaSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaSakuseiDay(TextBoxFlexibleDate txtNinteiKekkaSakuseiDay) {
        this.getKobetsuPrint().getNinteiKekkaTsuchi().setTxtNinteiKekkaSakuseiDay(txtNinteiKekkaSakuseiDay);
    }

    @JsonIgnore
    public TextBox getTxtNinteikekkaJoho() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi().getTxtNinteikekkaJoho();
    }

    @JsonIgnore
    public void  setTxtNinteikekkaJoho(TextBox txtNinteikekkaJoho) {
        this.getKobetsuPrint().getNinteiKekkaTsuchi().setTxtNinteikekkaJoho(txtNinteikekkaJoho);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiKekka() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi().getTxtNinteiKekka();
    }

    @JsonIgnore
    public void  setTxtNinteiKekka(TextBoxDateRange txtNinteiKekka) {
        this.getKobetsuPrint().getNinteiKekkaTsuchi().setTxtNinteiKekka(txtNinteiKekka);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNinteiKekkaShinsakaiIken() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi().getTxtNinteiKekkaShinsakaiIken();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaShinsakaiIken(TextBoxMultiLine txtNinteiKekkaShinsakaiIken) {
        this.getKobetsuPrint().getNinteiKekkaTsuchi().setTxtNinteiKekkaShinsakaiIken(txtNinteiKekkaShinsakaiIken);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNinteiKekkaRiyu() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi().getTxtNinteiKekkaRiyu();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaRiyu(TextBoxMultiLine txtNinteiKekkaRiyu) {
        this.getKobetsuPrint().getNinteiKekkaTsuchi().setTxtNinteiKekkaRiyu(txtNinteiKekkaRiyu);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuNinteiKekkaBunshoBango() {
        return this.getKobetsuPrint().getNinteiKekkaTsuchi().getCcdKobetsuNinteiKekkaBunshoBango();
    }

    @JsonIgnore
    public ServiceHenkoTsuchiDiv getServiceHenkoTsuchi() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi();
    }

    @JsonIgnore
    public void  setServiceHenkoTsuchi(ServiceHenkoTsuchiDiv ServiceHenkoTsuchi) {
        this.getKobetsuPrint().setServiceHenkoTsuchi(ServiceHenkoTsuchi);
    }

    @JsonIgnore
    public RadioButton getRadServiceHenkoBunshoRireki() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getRadServiceHenkoBunshoRireki();
    }

    @JsonIgnore
    public void  setRadServiceHenkoBunshoRireki(RadioButton radServiceHenkoBunshoRireki) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setRadServiceHenkoBunshoRireki(radServiceHenkoBunshoRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoBunshoSakuseiDay() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getTxtServiceHenkoBunshoSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoBunshoSakuseiDay(TextBoxFlexibleDate txtServiceHenkoBunshoSakuseiDay) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setTxtServiceHenkoBunshoSakuseiDay(txtServiceHenkoBunshoSakuseiDay);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtServiceHenkoBunshoYukoKikanRange() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getTxtServiceHenkoBunshoYukoKikanRange();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoBunshoYukoKikanRange(TextBoxDateRange txtServiceHenkoBunshoYukoKikanRange) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setTxtServiceHenkoBunshoYukoKikanRange(txtServiceHenkoBunshoYukoKikanRange);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon1() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getLinHorizon1();
    }

    @JsonIgnore
    public void  setLinHorizon1(HorizontalLine linHorizon1) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setLinHorizon1(linHorizon1);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHenkoBeforeService() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getTxtHenkoBeforeService();
    }

    @JsonIgnore
    public void  setTxtHenkoBeforeService(TextBoxMultiLine txtHenkoBeforeService) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setTxtHenkoBeforeService(txtHenkoBeforeService);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon2() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getLinHorizon2();
    }

    @JsonIgnore
    public void  setLinHorizon2(HorizontalLine linHorizon2) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setLinHorizon2(linHorizon2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHenkoAfterService() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getTxtHenkoAfterService();
    }

    @JsonIgnore
    public void  setTxtHenkoAfterService(TextBoxMultiLine txtHenkoAfterService) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setTxtHenkoAfterService(txtHenkoAfterService);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon3() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getLinHorizon3();
    }

    @JsonIgnore
    public void  setLinHorizon3(HorizontalLine linHorizon3) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setLinHorizon3(linHorizon3);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtServiceHenkoRiyu() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getTxtServiceHenkoRiyu();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoRiyu(TextBoxMultiLine txtServiceHenkoRiyu) {
        this.getKobetsuPrint().getServiceHenkoTsuchi().setTxtServiceHenkoRiyu(txtServiceHenkoRiyu);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuServiceHenkoBunshoBango() {
        return this.getKobetsuPrint().getServiceHenkoTsuchi().getCcdKobetsuServiceHenkoBunshoBango();
    }

    @JsonIgnore
    public YokaigodoHenkoTsuchiDiv getYokaigodoHenkoTsuchi() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi();
    }

    @JsonIgnore
    public void  setYokaigodoHenkoTsuchi(YokaigodoHenkoTsuchiDiv YokaigodoHenkoTsuchi) {
        this.getKobetsuPrint().setYokaigodoHenkoTsuchi(YokaigodoHenkoTsuchi);
    }

    @JsonIgnore
    public RadioButton getRadYokaigodoHenkoRireki() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getRadYokaigodoHenkoRireki();
    }

    @JsonIgnore
    public void  setRadYokaigodoHenkoRireki(RadioButton radYokaigodoHenkoRireki) {
        this.getKobetsuPrint().getYokaigodoHenkoTsuchi().setRadYokaigodoHenkoRireki(radYokaigodoHenkoRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokaigodoHenkoTsuchiSakuseiDay() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getTxtYokaigodoHenkoTsuchiSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtYokaigodoHenkoTsuchiSakuseiDay(TextBoxFlexibleDate txtYokaigodoHenkoTsuchiSakuseiDay) {
        this.getKobetsuPrint().getYokaigodoHenkoTsuchi().setTxtYokaigodoHenkoTsuchiSakuseiDay(txtYokaigodoHenkoTsuchiSakuseiDay);
    }

    @JsonIgnore
    public TextBox getTxtKyuYokaigodo() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getTxtKyuYokaigodo();
    }

    @JsonIgnore
    public void  setTxtKyuYokaigodo(TextBox txtKyuYokaigodo) {
        this.getKobetsuPrint().getYokaigodoHenkoTsuchi().setTxtKyuYokaigodo(txtKyuYokaigodo);
    }

    @JsonIgnore
    public TextBox getTxtShinYokaigodo() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getTxtShinYokaigodo();
    }

    @JsonIgnore
    public void  setTxtShinYokaigodo(TextBox txtShinYokaigodo) {
        this.getKobetsuPrint().getYokaigodoHenkoTsuchi().setTxtShinYokaigodo(txtShinYokaigodo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoYMD() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getTxtHenkoYMD();
    }

    @JsonIgnore
    public void  setTxtHenkoYMD(TextBoxFlexibleDate txtHenkoYMD) {
        this.getKobetsuPrint().getYokaigodoHenkoTsuchi().setTxtHenkoYMD(txtHenkoYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtYukoKikanRange() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getTxtYukoKikanRange();
    }

    @JsonIgnore
    public void  setTxtYukoKikanRange(TextBoxDateRange txtYukoKikanRange) {
        this.getKobetsuPrint().getYokaigodoHenkoTsuchi().setTxtYukoKikanRange(txtYukoKikanRange);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshashoTeishutsuKigen() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getTxtHihokenshashoTeishutsuKigen();
    }

    @JsonIgnore
    public void  setTxtHihokenshashoTeishutsuKigen(TextBoxFlexibleDate txtHihokenshashoTeishutsuKigen) {
        this.getKobetsuPrint().getYokaigodoHenkoTsuchi().setTxtHihokenshashoTeishutsuKigen(txtHihokenshashoTeishutsuKigen);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuKaigodoHenkoBunshoBango() {
        return this.getKobetsuPrint().getYokaigodoHenkoTsuchi().getCcdKobetsuKaigodoHenkoBunshoBango();
    }

    @JsonIgnore
    public NinteiKyakkaTshuchiDiv getNinteiKyakkaTshuchi() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi();
    }

    @JsonIgnore
    public void  setNinteiKyakkaTshuchi(NinteiKyakkaTshuchiDiv NinteiKyakkaTshuchi) {
        this.getKobetsuPrint().setNinteiKyakkaTshuchi(NinteiKyakkaTshuchi);
    }

    @JsonIgnore
    public RadioButton getRadNinteiKyakkaRireki() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi().getRadNinteiKyakkaRireki();
    }

    @JsonIgnore
    public void  setRadNinteiKyakkaRireki(RadioButton radNinteiKyakkaRireki) {
        this.getKobetsuPrint().getNinteiKyakkaTshuchi().setRadNinteiKyakkaRireki(radNinteiKyakkaRireki);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKyakkaTsuchi() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi().getTxtNinteiKyakkaTsuchi();
    }

    @JsonIgnore
    public void  setTxtNinteiKyakkaTsuchi(TextBoxFlexibleDate txtNinteiKyakkaTsuchi) {
        this.getKobetsuPrint().getNinteiKyakkaTshuchi().setTxtNinteiKyakkaTsuchi(txtNinteiKyakkaTsuchi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKyakkaDay() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi().getTxtKyakkaDay();
    }

    @JsonIgnore
    public void  setTxtKyakkaDay(TextBoxFlexibleDate txtKyakkaDay) {
        this.getKobetsuPrint().getNinteiKyakkaTshuchi().setTxtKyakkaDay(txtKyakkaDay);
    }

    @JsonIgnore
    public TextBox getTxtIdoJiyu() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi().getTxtIdoJiyu();
    }

    @JsonIgnore
    public void  setTxtIdoJiyu(TextBox txtIdoJiyu) {
        this.getKobetsuPrint().getNinteiKyakkaTshuchi().setTxtIdoJiyu(txtIdoJiyu);
    }

    @JsonIgnore
    public Button getBtnCopyJiyuToRiyu() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi().getBtnCopyJiyuToRiyu();
    }

    @JsonIgnore
    public void  setBtnCopyJiyuToRiyu(Button btnCopyJiyuToRiyu) {
        this.getKobetsuPrint().getNinteiKyakkaTshuchi().setBtnCopyJiyuToRiyu(btnCopyJiyuToRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyakkaRiyu() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi().getTxtKyakkaRiyu();
    }

    @JsonIgnore
    public void  setTxtKyakkaRiyu(TextBoxMultiLine txtKyakkaRiyu) {
        this.getKobetsuPrint().getNinteiKyakkaTshuchi().setTxtKyakkaRiyu(txtKyakkaRiyu);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKobetsuNinteiKyakkaBunshoBango() {
        return this.getKobetsuPrint().getNinteiKyakkaTshuchi().getCcdKobetsuNinteiKyakkaBunshoBango();
    }

    @JsonIgnore
    public CheckBoxList getChkOutPutSelect() {
        return this.getIkkatsuHakko().getChkOutPutSelect();
    }

    @JsonIgnore
    public void  setChkOutPutSelect(CheckBoxList chkOutPutSelect) {
        this.getIkkatsuHakko().setChkOutPutSelect(chkOutPutSelect);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiDaytxtSakuseiDaytxtSakuseiDay() {
        return this.getIkkatsuHakko().getTxtSakuseiDaytxtSakuseiDaytxtSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtSakuseiDaytxtSakuseiDaytxtSakuseiDay(TextBoxFlexibleDate txtSakuseiDaytxtSakuseiDaytxtSakuseiDay) {
        this.getIkkatsuHakko().setTxtSakuseiDaytxtSakuseiDaytxtSakuseiDay(txtSakuseiDaytxtSakuseiDaytxtSakuseiDay);
    }

    @JsonIgnore
    public ChushutsuTashoDiv getChushutsuTasho() {
        return this.getIkkatsuHakko().getChushutsuTasho();
    }

    @JsonIgnore
    public void  setChushutsuTasho(ChushutsuTashoDiv ChushutsuTasho) {
        this.getIkkatsuHakko().setChushutsuTasho(ChushutsuTasho);
    }

    @JsonIgnore
    public RadioButton getRadTanpyoHakkoZumi() {
        return this.getIkkatsuHakko().getChushutsuTasho().getRadTanpyoHakkoZumi();
    }

    @JsonIgnore
    public void  setRadTanpyoHakkoZumi(RadioButton radTanpyoHakkoZumi) {
        this.getIkkatsuHakko().getChushutsuTasho().setRadTanpyoHakkoZumi(radTanpyoHakkoZumi);
    }

    @JsonIgnore
    public Label getLblTaishoKikan() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblTaishoKikan();
    }

    @JsonIgnore
    public void  setLblTaishoKikan(Label lblTaishoKikan) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblTaishoKikan(lblTaishoKikan);
    }

    @JsonIgnore
    public Label getLblNinteiKekkaTsuchisho() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblNinteiKekkaTsuchisho();
    }

    @JsonIgnore
    public void  setLblNinteiKekkaTsuchisho(Label lblNinteiKekkaTsuchisho) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblNinteiKekkaTsuchisho(lblNinteiKekkaTsuchisho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaZenkaiYMDFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaZenkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiYMDFrom(TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaZenkaiYMDFrom(txtNinteiKekkaZenkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaZenkaiTimeFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaZenkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiTimeFrom(TextBoxTime txtNinteiKekkaZenkaiTimeFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaZenkaiTimeFrom(txtNinteiKekkaZenkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblNinteiKekkaZenkaiFor() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblNinteiKekkaZenkaiFor();
    }

    @JsonIgnore
    public void  setLblNinteiKekkaZenkaiFor(Label lblNinteiKekkaZenkaiFor) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblNinteiKekkaZenkaiFor(lblNinteiKekkaZenkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaZenkaiYMDTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaZenkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiYMDTo(TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaZenkaiYMDTo(txtNinteiKekkaZenkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaZenkaiTimeTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaZenkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiTimeTo(TextBoxTime txtNinteiKekkaZenkaiTimeTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaZenkaiTimeTo(txtNinteiKekkaZenkaiTimeTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaKonkaiYMDFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaKonkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiYMDFrom(TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaKonkaiYMDFrom(txtNinteiKekkaKonkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaKonkaiTimeFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaKonkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiTimeFrom(TextBoxTime txtNinteiKekkaKonkaiTimeFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaKonkaiTimeFrom(txtNinteiKekkaKonkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblNinteiKekkaKonkaiFor() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblNinteiKekkaKonkaiFor();
    }

    @JsonIgnore
    public void  setLblNinteiKekkaKonkaiFor(Label lblNinteiKekkaKonkaiFor) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblNinteiKekkaKonkaiFor(lblNinteiKekkaKonkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaKonkaiYMDTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaKonkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiYMDTo(TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaKonkaiYMDTo(txtNinteiKekkaKonkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaKonkaiTimeTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtNinteiKekkaKonkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiTimeTo(TextBoxTime txtNinteiKekkaKonkaiTimeTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtNinteiKekkaKonkaiTimeTo(txtNinteiKekkaKonkaiTimeTo);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizontal1() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLinHorizontal1();
    }

    @JsonIgnore
    public void  setLinHorizontal1(HorizontalLine linHorizontal1) {
        this.getIkkatsuHakko().getChushutsuTasho().setLinHorizontal1(linHorizontal1);
    }

    @JsonIgnore
    public Label getLblServiceHenkoTsuchi() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblServiceHenkoTsuchi();
    }

    @JsonIgnore
    public void  setLblServiceHenkoTsuchi(Label lblServiceHenkoTsuchi) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblServiceHenkoTsuchi(lblServiceHenkoTsuchi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoZenkaiYMDFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoZenkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiYMDFrom(TextBoxFlexibleDate txtServiceHenkoZenkaiYMDFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoZenkaiYMDFrom(txtServiceHenkoZenkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoZenkaiTimeForm() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoZenkaiTimeForm();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiTimeForm(TextBoxTime txtServiceHenkoZenkaiTimeForm) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoZenkaiTimeForm(txtServiceHenkoZenkaiTimeForm);
    }

    @JsonIgnore
    public Label getLblServiceHenkoZenkaiFor() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblServiceHenkoZenkaiFor();
    }

    @JsonIgnore
    public void  setLblServiceHenkoZenkaiFor(Label lblServiceHenkoZenkaiFor) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblServiceHenkoZenkaiFor(lblServiceHenkoZenkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoZenkaiYMDTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoZenkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiYMDTo(TextBoxFlexibleDate txtServiceHenkoZenkaiYMDTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoZenkaiYMDTo(txtServiceHenkoZenkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoZenkaiTimeTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoZenkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiTimeTo(TextBoxTime txtServiceHenkoZenkaiTimeTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoZenkaiTimeTo(txtServiceHenkoZenkaiTimeTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoKonkaiYMDFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoKonkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiYMDFrom(TextBoxFlexibleDate txtServiceHenkoKonkaiYMDFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoKonkaiYMDFrom(txtServiceHenkoKonkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoKonkaiTimeFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoKonkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiTimeFrom(TextBoxTime txtServiceHenkoKonkaiTimeFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoKonkaiTimeFrom(txtServiceHenkoKonkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblServiceHenkoKonkaiFor() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblServiceHenkoKonkaiFor();
    }

    @JsonIgnore
    public void  setLblServiceHenkoKonkaiFor(Label lblServiceHenkoKonkaiFor) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblServiceHenkoKonkaiFor(lblServiceHenkoKonkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoKonkaiYMDTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoKonkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiYMDTo(TextBoxFlexibleDate txtServiceHenkoKonkaiYMDTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoKonkaiYMDTo(txtServiceHenkoKonkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoKonkaiTimeTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtServiceHenkoKonkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiTimeTo(TextBoxTime txtServiceHenkoKonkaiTimeTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtServiceHenkoKonkaiTimeTo(txtServiceHenkoKonkaiTimeTo);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizontal2() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLinHorizontal2();
    }

    @JsonIgnore
    public void  setLinHorizontal2(HorizontalLine linHorizontal2) {
        this.getIkkatsuHakko().getChushutsuTasho().setLinHorizontal2(linHorizontal2);
    }

    @JsonIgnore
    public Label getLblYokaigoKubunHenkoTsuchisho() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblYokaigoKubunHenkoTsuchisho();
    }

    @JsonIgnore
    public void  setLblYokaigoKubunHenkoTsuchisho(Label lblYokaigoKubunHenkoTsuchisho) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblYokaigoKubunHenkoTsuchisho(lblYokaigoKubunHenkoTsuchisho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoZenkaiYMDFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoZenkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiYMDFrom(TextBoxFlexibleDate txtKubunHenkoZenkaiYMDFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoZenkaiYMDFrom(txtKubunHenkoZenkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoZenkaiTimeFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoZenkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiTimeFrom(TextBoxTime txtKubunHenkoZenkaiTimeFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoZenkaiTimeFrom(txtKubunHenkoZenkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblKubunHenkoZenkaiFor() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblKubunHenkoZenkaiFor();
    }

    @JsonIgnore
    public void  setLblKubunHenkoZenkaiFor(Label lblKubunHenkoZenkaiFor) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblKubunHenkoZenkaiFor(lblKubunHenkoZenkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoZenkaiYMDTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoZenkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiYMDTo(TextBoxFlexibleDate txtKubunHenkoZenkaiYMDTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoZenkaiYMDTo(txtKubunHenkoZenkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoZenkaiTimeTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoZenkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiTimeTo(TextBoxTime txtKubunHenkoZenkaiTimeTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoZenkaiTimeTo(txtKubunHenkoZenkaiTimeTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoKonkaiYMDFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoKonkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiYMDFrom(TextBoxFlexibleDate txtKubunHenkoKonkaiYMDFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoKonkaiYMDFrom(txtKubunHenkoKonkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoKonkaiTimeFrom() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoKonkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiTimeFrom(TextBoxTime txtKubunHenkoKonkaiTimeFrom) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoKonkaiTimeFrom(txtKubunHenkoKonkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblKubunHenkoKonkaiFor() {
        return this.getIkkatsuHakko().getChushutsuTasho().getLblKubunHenkoKonkaiFor();
    }

    @JsonIgnore
    public void  setLblKubunHenkoKonkaiFor(Label lblKubunHenkoKonkaiFor) {
        this.getIkkatsuHakko().getChushutsuTasho().setLblKubunHenkoKonkaiFor(lblKubunHenkoKonkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoKonkaiYMDTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoKonkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiYMDTo(TextBoxFlexibleDate txtKubunHenkoKonkaiYMDTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoKonkaiYMDTo(txtKubunHenkoKonkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoKonkaiTimeTo() {
        return this.getIkkatsuHakko().getChushutsuTasho().getTxtKubunHenkoKonkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiTimeTo(TextBoxTime txtKubunHenkoKonkaiTimeTo) {
        this.getIkkatsuHakko().getChushutsuTasho().setTxtKubunHenkoKonkaiTimeTo(txtKubunHenkoKonkaiTimeTo);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdIkkatsuNinteiKekkaBunshoBango() {
        return this.getIkkatsuHakko().getChushutsuTasho().getCcdIkkatsuNinteiKekkaBunshoBango();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdIkkatsuServiceHenkoBunshoBango() {
        return this.getIkkatsuHakko().getChushutsuTasho().getCcdIkkatsuServiceHenkoBunshoBango();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdIkkatsuKubunHenkoBunshoBango() {
        return this.getIkkatsuHakko().getChushutsuTasho().getCcdIkkatsuKubunHenkoBunshoBango();
    }

    // </editor-fold>
}
