package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * RenrakusakiKinyuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class RenrakusakiKinyuKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtTelNo1")
    private TextBoxTelNo txtTelNo1;
    @JsonProperty("txtFaxNo")
    private TextBoxTelNo txtFaxNo;
    @JsonProperty("ddlYusoKubun")
    private DropDownList ddlYusoKubun;
    @JsonProperty("ddlHaishiFlag")
    private DropDownList ddlHaishiFlag;
    @JsonProperty("txtHaishiYMD")
    private TextBoxDate txtHaishiYMD;
    @JsonProperty("KozaJoho")
    private KozaJohoDiv KozaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtTelNo1
     * @return txtTelNo1
     */
    @JsonProperty("txtTelNo1")
    public TextBoxTelNo getTxtTelNo1() {
        return txtTelNo1;
    }

    /*
     * settxtTelNo1
     * @param txtTelNo1 txtTelNo1
     */
    @JsonProperty("txtTelNo1")
    public void setTxtTelNo1(TextBoxTelNo txtTelNo1) {
        this.txtTelNo1 = txtTelNo1;
    }

    /*
     * gettxtFaxNo
     * @return txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public TextBoxTelNo getTxtFaxNo() {
        return txtFaxNo;
    }

    /*
     * settxtFaxNo
     * @param txtFaxNo txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public void setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.txtFaxNo = txtFaxNo;
    }

    /*
     * getddlYusoKubun
     * @return ddlYusoKubun
     */
    @JsonProperty("ddlYusoKubun")
    public DropDownList getDdlYusoKubun() {
        return ddlYusoKubun;
    }

    /*
     * setddlYusoKubun
     * @param ddlYusoKubun ddlYusoKubun
     */
    @JsonProperty("ddlYusoKubun")
    public void setDdlYusoKubun(DropDownList ddlYusoKubun) {
        this.ddlYusoKubun = ddlYusoKubun;
    }

    /*
     * getddlHaishiFlag
     * @return ddlHaishiFlag
     */
    @JsonProperty("ddlHaishiFlag")
    public DropDownList getDdlHaishiFlag() {
        return ddlHaishiFlag;
    }

    /*
     * setddlHaishiFlag
     * @param ddlHaishiFlag ddlHaishiFlag
     */
    @JsonProperty("ddlHaishiFlag")
    public void setDdlHaishiFlag(DropDownList ddlHaishiFlag) {
        this.ddlHaishiFlag = ddlHaishiFlag;
    }

    /*
     * gettxtHaishiYMD
     * @return txtHaishiYMD
     */
    @JsonProperty("txtHaishiYMD")
    public TextBoxDate getTxtHaishiYMD() {
        return txtHaishiYMD;
    }

    /*
     * settxtHaishiYMD
     * @param txtHaishiYMD txtHaishiYMD
     */
    @JsonProperty("txtHaishiYMD")
    public void setTxtHaishiYMD(TextBoxDate txtHaishiYMD) {
        this.txtHaishiYMD = txtHaishiYMD;
    }

    /*
     * getKozaJoho
     * @return KozaJoho
     */
    @JsonProperty("KozaJoho")
    public KozaJohoDiv getKozaJoho() {
        return KozaJoho;
    }

    /*
     * setKozaJoho
     * @param KozaJoho KozaJoho
     */
    @JsonProperty("KozaJoho")
    public void setKozaJoho(KozaJohoDiv KozaJoho) {
        this.KozaJoho = KozaJoho;
    }

    // </editor-fold>
}
