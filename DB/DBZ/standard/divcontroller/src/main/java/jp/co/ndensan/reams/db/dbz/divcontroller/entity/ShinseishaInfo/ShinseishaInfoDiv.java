package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseishaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxDate txtShinseiDate;
    @JsonProperty("ddlShinseishaKubun")
    private DropDownList ddlShinseishaKubun;
    @JsonProperty("txtUketsukeDate")
    private TextBoxDate txtUketsukeDate;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("btnJigyoshaInputGuide")
    private ButtonDialog btnJigyoshaInputGuide;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("txtShinseishaNameKana")
    private TextBox txtShinseishaNameKana;
    @JsonProperty("txtShinseishaName")
    private TextBox txtShinseishaName;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtAddress")
    private TextBox txtAddress;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("ddlShinseishaKubun")
    public DropDownList getDdlShinseishaKubun() {
        return ddlShinseishaKubun;
    }

    @JsonProperty("ddlShinseishaKubun")
    public void setDdlShinseishaKubun(DropDownList ddlShinseishaKubun) {
        this.ddlShinseishaKubun=ddlShinseishaKubun;
    }

    @JsonProperty("txtUketsukeDate")
    public TextBoxDate getTxtUketsukeDate() {
        return txtUketsukeDate;
    }

    @JsonProperty("txtUketsukeDate")
    public void setTxtUketsukeDate(TextBoxDate txtUketsukeDate) {
        this.txtUketsukeDate=txtUketsukeDate;
    }

    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo=txtJigyoshaNo;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return btnJigyoshaInputGuide;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    public void setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.btnJigyoshaInputGuide=btnJigyoshaInputGuide;
    }

    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("txtShinseishaNameKana")
    public TextBox getTxtShinseishaNameKana() {
        return txtShinseishaNameKana;
    }

    @JsonProperty("txtShinseishaNameKana")
    public void setTxtShinseishaNameKana(TextBox txtShinseishaNameKana) {
        this.txtShinseishaNameKana=txtShinseishaNameKana;
    }

    @JsonProperty("txtShinseishaName")
    public TextBox getTxtShinseishaName() {
        return txtShinseishaName;
    }

    @JsonProperty("txtShinseishaName")
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.txtShinseishaName=txtShinseishaName;
    }

    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo=txtTelNo;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtAddress")
    public TextBox getTxtAddress() {
        return txtAddress;
    }

    @JsonProperty("txtAddress")
    public void setTxtAddress(TextBox txtAddress) {
        this.txtAddress=txtAddress;
    }

}
