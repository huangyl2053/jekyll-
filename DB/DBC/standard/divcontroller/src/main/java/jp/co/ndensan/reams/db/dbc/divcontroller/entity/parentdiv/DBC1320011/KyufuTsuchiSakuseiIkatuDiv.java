package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiSakuseiIkatu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuTsuchiSakuseiIkatuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuTsuchiSakusei")
    private KyufuTsuchiSakuseiDiv KyufuTsuchiSakusei;
    @JsonProperty("KyufuTsuchiSakuseiPrint")
    private KyufuTsuchiSakuseiPrintDiv KyufuTsuchiSakuseiPrint;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuTsuchiSakusei
     * @return KyufuTsuchiSakusei
     */
    @JsonProperty("KyufuTsuchiSakusei")
    public KyufuTsuchiSakuseiDiv getKyufuTsuchiSakusei() {
        return KyufuTsuchiSakusei;
    }

    /*
     * setKyufuTsuchiSakusei
     * @param KyufuTsuchiSakusei KyufuTsuchiSakusei
     */
    @JsonProperty("KyufuTsuchiSakusei")
    public void setKyufuTsuchiSakusei(KyufuTsuchiSakuseiDiv KyufuTsuchiSakusei) {
        this.KyufuTsuchiSakusei = KyufuTsuchiSakusei;
    }

    /*
     * getKyufuTsuchiSakuseiPrint
     * @return KyufuTsuchiSakuseiPrint
     */
    @JsonProperty("KyufuTsuchiSakuseiPrint")
    public KyufuTsuchiSakuseiPrintDiv getKyufuTsuchiSakuseiPrint() {
        return KyufuTsuchiSakuseiPrint;
    }

    /*
     * setKyufuTsuchiSakuseiPrint
     * @param KyufuTsuchiSakuseiPrint KyufuTsuchiSakuseiPrint
     */
    @JsonProperty("KyufuTsuchiSakuseiPrint")
    public void setKyufuTsuchiSakuseiPrint(KyufuTsuchiSakuseiPrintDiv KyufuTsuchiSakuseiPrint) {
        this.KyufuTsuchiSakuseiPrint = KyufuTsuchiSakuseiPrint;
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
    public TextBoxDateRange getTdrServiceYM() {
        return this.getKyufuTsuchiSakusei().getTdrServiceYM();
    }

    @JsonIgnore
    public void  setTdrServiceYM(TextBoxDateRange tdrServiceYM) {
        this.getKyufuTsuchiSakusei().setTdrServiceYM(tdrServiceYM);
    }

    @JsonIgnore
    public CheckBoxList getChkServiceSyuruiSyuyaku() {
        return this.getKyufuTsuchiSakusei().getChkServiceSyuruiSyuyaku();
    }

    @JsonIgnore
    public void  setChkServiceSyuruiSyuyaku(CheckBoxList chkServiceSyuruiSyuyaku) {
        this.getKyufuTsuchiSakusei().setChkServiceSyuruiSyuyaku(chkServiceSyuruiSyuyaku);
    }

    @JsonIgnore
    public HorizontalLine getHolLine1() {
        return this.getKyufuTsuchiSakusei().getHolLine1();
    }

    @JsonIgnore
    public void  setHolLine1(HorizontalLine holLine1) {
        this.getKyufuTsuchiSakusei().setHolLine1(holLine1);
    }

    @JsonIgnore
    public CheckBoxList getChkYokaigodo() {
        return this.getKyufuTsuchiSakusei().getChkYokaigodo();
    }

    @JsonIgnore
    public void  setChkYokaigodo(CheckBoxList chkYokaigodo) {
        this.getKyufuTsuchiSakusei().setChkYokaigodo(chkYokaigodo);
    }

    @JsonIgnore
    public KyufuTsuchiSakusei1Div getKyufuTsuchiSakusei1() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1();
    }

    @JsonIgnore
    public void  setKyufuTsuchiSakusei1(KyufuTsuchiSakusei1Div KyufuTsuchiSakusei1) {
        this.getKyufuTsuchiSakusei().setKyufuTsuchiSakusei1(KyufuTsuchiSakusei1);
    }

    @JsonIgnore
    public RadioButton getOptServiceType() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().getOptServiceType();
    }

    @JsonIgnore
    public void  setOptServiceType(RadioButton optServiceType) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().setOptServiceType(optServiceType);
    }

    @JsonIgnore
    public Label getLblServiceType() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().getLblServiceType();
    }

    @JsonIgnore
    public void  setLblServiceType(Label lblServiceType) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().setLblServiceType(lblServiceType);
    }

    @JsonIgnore
    public CheckBoxList getChkTyusyutuJoken() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().getChkTyusyutuJoken();
    }

    @JsonIgnore
    public void  setChkTyusyutuJoken(CheckBoxList chkTyusyutuJoken) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().setChkTyusyutuJoken(chkTyusyutuJoken);
    }

    @JsonIgnore
    public HorizontalLine getHolLine2() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().getHolLine2();
    }

    @JsonIgnore
    public void  setHolLine2(HorizontalLine holLine2) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().setHolLine2(holLine2);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaJoho() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().getBtnHihokenshaJoho();
    }

    @JsonIgnore
    public void  setBtnHihokenshaJoho(ButtonDialog btnHihokenshaJoho) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().setBtnHihokenshaJoho(btnHihokenshaJoho);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei1().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public KyufuTsuchiSakusei2Div getKyufuTsuchiSakusei2() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei2();
    }

    @JsonIgnore
    public void  setKyufuTsuchiSakusei2(KyufuTsuchiSakusei2Div KyufuTsuchiSakusei2) {
        this.getKyufuTsuchiSakusei().setKyufuTsuchiSakusei2(KyufuTsuchiSakusei2);
    }

    @JsonIgnore
    public Button getBtnTuuchiJoho() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei2().getBtnTuuchiJoho();
    }

    @JsonIgnore
    public void  setBtnTuuchiJoho(Button btnTuuchiJoho) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei2().setBtnTuuchiJoho(btnTuuchiJoho);
    }

    @JsonIgnore
    public DataGrid<grdTuuchiJoho_Row> getGrdTuuchiJoho() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei2().getGrdTuuchiJoho();
    }

    @JsonIgnore
    public void  setGrdTuuchiJoho(DataGrid<grdTuuchiJoho_Row> grdTuuchiJoho) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei2().setGrdTuuchiJoho(grdTuuchiJoho);
    }

    @JsonIgnore
    public Label getLblTyuibun1() {
        return this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei2().getLblTyuibun1();
    }

    @JsonIgnore
    public void  setLblTyuibun1(Label lblTyuibun1) {
        this.getKyufuTsuchiSakusei().getKyufuTsuchiSakusei2().setLblTyuibun1(lblTyuibun1);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getKyufuTsuchiSakusei().getCcdHokenshaList();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunsyobango() {
        return this.getKyufuTsuchiSakuseiPrint().getCcdBunsyobango();
    }

    @JsonIgnore
    public IPrintContentsSettingDiv getKyufuTsuchiSakuseiSetting() {
        return this.getKyufuTsuchiSakuseiPrint().getKyufuTsuchiSakuseiSetting();
    }

    // </editor-fold>
}
