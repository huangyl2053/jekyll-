package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
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
 * TaishoshaKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoshaKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Hihokensha")
    private HihokenshaDiv Hihokensha;
    @JsonProperty("YokaigoNintei")
    private YokaigoNinteiDiv YokaigoNintei;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("btnJokenClear")
    private Button btnJokenClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHihokensha
     * @return Hihokensha
     */
    @JsonProperty("Hihokensha")
    public HihokenshaDiv getHihokensha() {
        return Hihokensha;
    }

    /*
     * setHihokensha
     * @param Hihokensha Hihokensha
     */
    @JsonProperty("Hihokensha")
    public void setHihokensha(HihokenshaDiv Hihokensha) {
        this.Hihokensha = Hihokensha;
    }

    /*
     * getYokaigoNintei
     * @return YokaigoNintei
     */
    @JsonProperty("YokaigoNintei")
    public YokaigoNinteiDiv getYokaigoNintei() {
        return YokaigoNintei;
    }

    /*
     * setYokaigoNintei
     * @param YokaigoNintei YokaigoNintei
     */
    @JsonProperty("YokaigoNintei")
    public void setYokaigoNintei(YokaigoNinteiDiv YokaigoNintei) {
        this.YokaigoNintei = YokaigoNintei;
    }

    /*
     * gettxtSaidaiHyojiKensu
     * @return txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return txtSaidaiHyojiKensu;
    }

    /*
     * settxtSaidaiHyojiKensu
     * @param txtSaidaiHyojiKensu txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public void setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.txtSaidaiHyojiKensu = txtSaidaiHyojiKensu;
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
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getHihokensha().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getHihokensha().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getHihokensha().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getHihokensha().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public DropDownList getDdlMachJoken() {
        return this.getHihokensha().getDdlMachJoken();
    }

    @JsonIgnore
    public void  setDdlMachJoken(DropDownList ddlMachJoken) {
        this.getHihokensha().setDdlMachJoken(ddlMachJoken);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikibetsuCode() {
        return this.getHihokensha().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.getHihokensha().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthYMD() {
        return this.getHihokensha().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxFlexibleDate txtBirthYMD) {
        this.getHihokensha().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkSeibetsu() {
        return this.getHihokensha().getChkSeibetsu();
    }

    @JsonIgnore
    public void  setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.getHihokensha().setChkSeibetsu(chkSeibetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiDay() {
        return this.getYokaigoNintei().getTxtShinseiDay();
    }

    @JsonIgnore
    public void  setTxtShinseiDay(TextBoxDateRange txtShinseiDay) {
        this.getYokaigoNintei().setTxtShinseiDay(txtShinseiDay);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiDay() {
        return this.getYokaigoNintei().getTxtNinteiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiDay(TextBoxDateRange txtNinteiDay) {
        this.getYokaigoNintei().setTxtNinteiDay(txtNinteiDay);
    }

    // </editor-fold>
}
