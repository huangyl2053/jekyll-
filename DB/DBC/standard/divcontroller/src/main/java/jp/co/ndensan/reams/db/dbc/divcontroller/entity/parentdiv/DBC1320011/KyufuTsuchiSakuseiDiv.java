package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuTsuchiSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tdrServiceYM")
    private TextBoxDateRange tdrServiceYM;
    @JsonProperty("chkServiceSyuruiSyuyaku")
    private CheckBoxList chkServiceSyuruiSyuyaku;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("holLine1")
    private HorizontalLine holLine1;
    @JsonProperty("chkYokaigodo")
    private CheckBoxList chkYokaigodo;
    @JsonProperty("KyufuTsuchiSakusei1")
    private KyufuTsuchiSakusei1Div KyufuTsuchiSakusei1;
    @JsonProperty("KyufuTsuchiSakusei2")
    private KyufuTsuchiSakusei2Div KyufuTsuchiSakusei2;
    @JsonProperty("hdn市町村コード")
    private RString hdn市町村コード;
    @JsonProperty("hdn保険者構成key")
    private RString hdn保険者構成key;
    @JsonProperty("hdn要介護度")
    private RString hdn要介護度;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettdrServiceYM
     * @return tdrServiceYM
     */
    @JsonProperty("tdrServiceYM")
    public TextBoxDateRange getTdrServiceYM() {
        return tdrServiceYM;
    }

    /*
     * settdrServiceYM
     * @param tdrServiceYM tdrServiceYM
     */
    @JsonProperty("tdrServiceYM")
    public void setTdrServiceYM(TextBoxDateRange tdrServiceYM) {
        this.tdrServiceYM = tdrServiceYM;
    }

    /*
     * getchkServiceSyuruiSyuyaku
     * @return chkServiceSyuruiSyuyaku
     */
    @JsonProperty("chkServiceSyuruiSyuyaku")
    public CheckBoxList getChkServiceSyuruiSyuyaku() {
        return chkServiceSyuruiSyuyaku;
    }

    /*
     * setchkServiceSyuruiSyuyaku
     * @param chkServiceSyuruiSyuyaku chkServiceSyuruiSyuyaku
     */
    @JsonProperty("chkServiceSyuruiSyuyaku")
    public void setChkServiceSyuruiSyuyaku(CheckBoxList chkServiceSyuruiSyuyaku) {
        this.chkServiceSyuruiSyuyaku = chkServiceSyuruiSyuyaku;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * getholLine1
     * @return holLine1
     */
    @JsonProperty("holLine1")
    public HorizontalLine getHolLine1() {
        return holLine1;
    }

    /*
     * setholLine1
     * @param holLine1 holLine1
     */
    @JsonProperty("holLine1")
    public void setHolLine1(HorizontalLine holLine1) {
        this.holLine1 = holLine1;
    }

    /*
     * getchkYokaigodo
     * @return chkYokaigodo
     */
    @JsonProperty("chkYokaigodo")
    public CheckBoxList getChkYokaigodo() {
        return chkYokaigodo;
    }

    /*
     * setchkYokaigodo
     * @param chkYokaigodo chkYokaigodo
     */
    @JsonProperty("chkYokaigodo")
    public void setChkYokaigodo(CheckBoxList chkYokaigodo) {
        this.chkYokaigodo = chkYokaigodo;
    }

    /*
     * getKyufuTsuchiSakusei1
     * @return KyufuTsuchiSakusei1
     */
    @JsonProperty("KyufuTsuchiSakusei1")
    public KyufuTsuchiSakusei1Div getKyufuTsuchiSakusei1() {
        return KyufuTsuchiSakusei1;
    }

    /*
     * setKyufuTsuchiSakusei1
     * @param KyufuTsuchiSakusei1 KyufuTsuchiSakusei1
     */
    @JsonProperty("KyufuTsuchiSakusei1")
    public void setKyufuTsuchiSakusei1(KyufuTsuchiSakusei1Div KyufuTsuchiSakusei1) {
        this.KyufuTsuchiSakusei1 = KyufuTsuchiSakusei1;
    }

    /*
     * getKyufuTsuchiSakusei2
     * @return KyufuTsuchiSakusei2
     */
    @JsonProperty("KyufuTsuchiSakusei2")
    public KyufuTsuchiSakusei2Div getKyufuTsuchiSakusei2() {
        return KyufuTsuchiSakusei2;
    }

    /*
     * setKyufuTsuchiSakusei2
     * @param KyufuTsuchiSakusei2 KyufuTsuchiSakusei2
     */
    @JsonProperty("KyufuTsuchiSakusei2")
    public void setKyufuTsuchiSakusei2(KyufuTsuchiSakusei2Div KyufuTsuchiSakusei2) {
        this.KyufuTsuchiSakusei2 = KyufuTsuchiSakusei2;
    }

    /*
     * gethdn市町村コード
     * @return hdn市町村コード
     */
    @JsonProperty("hdn市町村コード")
    public RString getHdn市町村コード() {
        return hdn市町村コード;
    }

    /*
     * sethdn市町村コード
     * @param hdn市町村コード hdn市町村コード
     */
    @JsonProperty("hdn市町村コード")
    public void setHdn市町村コード(RString hdn市町村コード) {
        this.hdn市町村コード = hdn市町村コード;
    }

    /*
     * gethdn保険者構成key
     * @return hdn保険者構成key
     */
    @JsonProperty("hdn保険者構成key")
    public RString getHdn保険者構成key() {
        return hdn保険者構成key;
    }

    /*
     * sethdn保険者構成key
     * @param hdn保険者構成key hdn保険者構成key
     */
    @JsonProperty("hdn保険者構成key")
    public void setHdn保険者構成key(RString hdn保険者構成key) {
        this.hdn保険者構成key = hdn保険者構成key;
    }

    /*
     * gethdn要介護度
     * @return hdn要介護度
     */
    @JsonProperty("hdn要介護度")
    public RString getHdn要介護度() {
        return hdn要介護度;
    }

    /*
     * sethdn要介護度
     * @param hdn要介護度 hdn要介護度
     */
    @JsonProperty("hdn要介護度")
    public void setHdn要介護度(RString hdn要介護度) {
        this.hdn要介護度 = hdn要介護度;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getOptServiceType() {
        return this.getKyufuTsuchiSakusei1().getOptServiceType();
    }

    @JsonIgnore
    public void  setOptServiceType(RadioButton optServiceType) {
        this.getKyufuTsuchiSakusei1().setOptServiceType(optServiceType);
    }

    @JsonIgnore
    public Label getLblServiceType() {
        return this.getKyufuTsuchiSakusei1().getLblServiceType();
    }

    @JsonIgnore
    public void  setLblServiceType(Label lblServiceType) {
        this.getKyufuTsuchiSakusei1().setLblServiceType(lblServiceType);
    }

    @JsonIgnore
    public CheckBoxList getChkTyusyutuJoken() {
        return this.getKyufuTsuchiSakusei1().getChkTyusyutuJoken();
    }

    @JsonIgnore
    public void  setChkTyusyutuJoken(CheckBoxList chkTyusyutuJoken) {
        this.getKyufuTsuchiSakusei1().setChkTyusyutuJoken(chkTyusyutuJoken);
    }

    @JsonIgnore
    public HorizontalLine getHolLine2() {
        return this.getKyufuTsuchiSakusei1().getHolLine2();
    }

    @JsonIgnore
    public void  setHolLine2(HorizontalLine holLine2) {
        this.getKyufuTsuchiSakusei1().setHolLine2(holLine2);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getKyufuTsuchiSakusei1().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getKyufuTsuchiSakusei1().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaJoho() {
        return this.getKyufuTsuchiSakusei1().getBtnHihokenshaJoho();
    }

    @JsonIgnore
    public void  setBtnHihokenshaJoho(ButtonDialog btnHihokenshaJoho) {
        this.getKyufuTsuchiSakusei1().setBtnHihokenshaJoho(btnHihokenshaJoho);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getKyufuTsuchiSakusei1().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getKyufuTsuchiSakusei1().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public Button getBtnTuuchiJoho() {
        return this.getKyufuTsuchiSakusei2().getBtnTuuchiJoho();
    }

    @JsonIgnore
    public void  setBtnTuuchiJoho(Button btnTuuchiJoho) {
        this.getKyufuTsuchiSakusei2().setBtnTuuchiJoho(btnTuuchiJoho);
    }

    @JsonIgnore
    public DataGrid<grdTuuchiJoho_Row> getGrdTuuchiJoho() {
        return this.getKyufuTsuchiSakusei2().getGrdTuuchiJoho();
    }

    @JsonIgnore
    public void  setGrdTuuchiJoho(DataGrid<grdTuuchiJoho_Row> grdTuuchiJoho) {
        this.getKyufuTsuchiSakusei2().setGrdTuuchiJoho(grdTuuchiJoho);
    }

    @JsonIgnore
    public Label getLblTyuibun1() {
        return this.getKyufuTsuchiSakusei2().getLblTyuibun1();
    }

    @JsonIgnore
    public void  setLblTyuibun1(Label lblTyuibun1) {
        this.getKyufuTsuchiSakusei2().setLblTyuibun1(lblTyuibun1);
    }

    // </editor-fold>
}
