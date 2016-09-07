package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Hihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("ddlMachJoken")
    private DropDownList ddlMachJoken;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtBirthYMD")
    private TextBoxFlexibleDate txtBirthYMD;
    @JsonProperty("chkSeibetsu")
    private CheckBoxList chkSeibetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihoNo
     * @return txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * getddlMachJoken
     * @return ddlMachJoken
     */
    @JsonProperty("ddlMachJoken")
    public DropDownList getDdlMachJoken() {
        return ddlMachJoken;
    }

    /*
     * setddlMachJoken
     * @param ddlMachJoken ddlMachJoken
     */
    @JsonProperty("ddlMachJoken")
    public void setDdlMachJoken(DropDownList ddlMachJoken) {
        this.ddlMachJoken = ddlMachJoken;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtBirthYMD
     * @return txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public TextBoxFlexibleDate getTxtBirthYMD() {
        return txtBirthYMD;
    }

    /*
     * settxtBirthYMD
     * @param txtBirthYMD txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public void setTxtBirthYMD(TextBoxFlexibleDate txtBirthYMD) {
        this.txtBirthYMD = txtBirthYMD;
    }

    /*
     * getchkSeibetsu
     * @return chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public CheckBoxList getChkSeibetsu() {
        return chkSeibetsu;
    }

    /*
     * setchkSeibetsu
     * @param chkSeibetsu chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public void setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.chkSeibetsu = chkSeibetsu;
    }

    // </editor-fold>
}
