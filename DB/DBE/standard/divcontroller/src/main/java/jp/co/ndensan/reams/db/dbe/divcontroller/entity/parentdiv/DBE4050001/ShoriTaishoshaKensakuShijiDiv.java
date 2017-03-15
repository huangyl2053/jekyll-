package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriTaishoshaKensakuShiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriTaishoshaKensakuShijiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNumber")
    private TextBoxCode txtHihokenshaNumber;
    @JsonProperty("ddlKensakuTaisho")
    private DropDownList ddlKensakuTaisho;
    @JsonProperty("txtSearchYMD")
    private TextBoxDateRange txtSearchYMD;
    @JsonProperty("chkMasking")
    private CheckBoxList chkMasking;
    @JsonProperty("txtShinsakaiKaisaiNo")
    private TextBoxNum txtShinsakaiKaisaiNo;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("txtMaxDisp")
    private TextBoxNum txtMaxDisp;
    @JsonProperty("ccdHokensya")
    private HokenshaListDiv ccdHokensya;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNumber
     * @return txtHihokenshaNumber
     */
    @JsonProperty("txtHihokenshaNumber")
    public TextBoxCode getTxtHihokenshaNumber() {
        return txtHihokenshaNumber;
    }

    /*
     * settxtHihokenshaNumber
     * @param txtHihokenshaNumber txtHihokenshaNumber
     */
    @JsonProperty("txtHihokenshaNumber")
    public void setTxtHihokenshaNumber(TextBoxCode txtHihokenshaNumber) {
        this.txtHihokenshaNumber = txtHihokenshaNumber;
    }

    /*
     * getddlKensakuTaisho
     * @return ddlKensakuTaisho
     */
    @JsonProperty("ddlKensakuTaisho")
    public DropDownList getDdlKensakuTaisho() {
        return ddlKensakuTaisho;
    }

    /*
     * setddlKensakuTaisho
     * @param ddlKensakuTaisho ddlKensakuTaisho
     */
    @JsonProperty("ddlKensakuTaisho")
    public void setDdlKensakuTaisho(DropDownList ddlKensakuTaisho) {
        this.ddlKensakuTaisho = ddlKensakuTaisho;
    }

    /*
     * gettxtSearchYMD
     * @return txtSearchYMD
     */
    @JsonProperty("txtSearchYMD")
    public TextBoxDateRange getTxtSearchYMD() {
        return txtSearchYMD;
    }

    /*
     * settxtSearchYMD
     * @param txtSearchYMD txtSearchYMD
     */
    @JsonProperty("txtSearchYMD")
    public void setTxtSearchYMD(TextBoxDateRange txtSearchYMD) {
        this.txtSearchYMD = txtSearchYMD;
    }

    /*
     * getchkMasking
     * @return chkMasking
     */
    @JsonProperty("chkMasking")
    public CheckBoxList getChkMasking() {
        return chkMasking;
    }

    /*
     * setchkMasking
     * @param chkMasking chkMasking
     */
    @JsonProperty("chkMasking")
    public void setChkMasking(CheckBoxList chkMasking) {
        this.chkMasking = chkMasking;
    }

    /*
     * gettxtShinsakaiKaisaiNo
     * @return txtShinsakaiKaisaiNo
     */
    @JsonProperty("txtShinsakaiKaisaiNo")
    public TextBoxNum getTxtShinsakaiKaisaiNo() {
        return txtShinsakaiKaisaiNo;
    }

    /*
     * settxtShinsakaiKaisaiNo
     * @param txtShinsakaiKaisaiNo txtShinsakaiKaisaiNo
     */
    @JsonProperty("txtShinsakaiKaisaiNo")
    public void setTxtShinsakaiKaisaiNo(TextBoxNum txtShinsakaiKaisaiNo) {
        this.txtShinsakaiKaisaiNo = txtShinsakaiKaisaiNo;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * gettxtMaxDisp
     * @return txtMaxDisp
     */
    @JsonProperty("txtMaxDisp")
    public TextBoxNum getTxtMaxDisp() {
        return txtMaxDisp;
    }

    /*
     * settxtMaxDisp
     * @param txtMaxDisp txtMaxDisp
     */
    @JsonProperty("txtMaxDisp")
    public void setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.txtMaxDisp = txtMaxDisp;
    }

    /*
     * getccdHokensya
     * @return ccdHokensya
     */
    @JsonProperty("ccdHokensya")
    public IHokenshaListDiv getCcdHokensya() {
        return ccdHokensya;
    }

    // </editor-fold>
}
