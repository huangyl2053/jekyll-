package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiShinseiRenrakusakiKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiRenrakusakiKihonDiv extends Panel implements INinteiShinseiRenrakusakiKihonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("ddlTsuzukigara")
    private DropDownList ddlTsuzukigara;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtMobileNo")
    private TextBoxTelNo txtMobileNo;
    @JsonProperty("ShinseishoKanriNo")
    private RString ShinseishoKanriNo;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getddlTsuzukigara
     * @return ddlTsuzukigara
     */
    @JsonProperty("ddlTsuzukigara")
    public DropDownList getDdlTsuzukigara() {
        return ddlTsuzukigara;
    }

    /*
     * setddlTsuzukigara
     * @param ddlTsuzukigara ddlTsuzukigara
     */
    @JsonProperty("ddlTsuzukigara")
    public void setDdlTsuzukigara(DropDownList ddlTsuzukigara) {
        this.ddlTsuzukigara = ddlTsuzukigara;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtMobileNo
     * @return txtMobileNo
     */
    @JsonProperty("txtMobileNo")
    public TextBoxTelNo getTxtMobileNo() {
        return txtMobileNo;
    }

    /*
     * settxtMobileNo
     * @param txtMobileNo txtMobileNo
     */
    @JsonProperty("txtMobileNo")
    public void setTxtMobileNo(TextBoxTelNo txtMobileNo) {
        this.txtMobileNo = txtMobileNo;
    }

    /*
     * getShinseishoKanriNo
     * @return ShinseishoKanriNo
     */
    @JsonProperty("ShinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return ShinseishoKanriNo;
    }

    /*
     * setShinseishoKanriNo
     * @param ShinseishoKanriNo ShinseishoKanriNo
     */
    @JsonProperty("ShinseishoKanriNo")
    public void setShinseishoKanriNo(RString ShinseishoKanriNo) {
        this.ShinseishoKanriNo = ShinseishoKanriNo;
    }

    /*
     * gethdnDatabaseSubGyomuCode
     * @return hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    /*
     * sethdnDatabaseSubGyomuCode
     * @param hdnDatabaseSubGyomuCode hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode = hdnDatabaseSubGyomuCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
