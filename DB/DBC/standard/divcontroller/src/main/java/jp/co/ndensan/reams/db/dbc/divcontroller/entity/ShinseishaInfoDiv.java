package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IShinseishaInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseishaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaInfoDiv extends Panel implements IShinseishaInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtUketsukeYMD")
    private TextBoxDate txtUketsukeYMD;
    @JsonProperty("radShinseishaKubun")
    private RadioButton radShinseishaKubun;
    @JsonProperty("txtShinseishaName")
    private TextBox txtShinseishaName;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtAddress")
    private TextBox txtAddress;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("btnSearchJigyosha")
    private Button btnSearchJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD=txtShinseiYMD;
    }

    @JsonProperty("txtUketsukeYMD")
    public TextBoxDate getTxtUketsukeYMD() {
        return txtUketsukeYMD;
    }

    @JsonProperty("txtUketsukeYMD")
    public void setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.txtUketsukeYMD=txtUketsukeYMD;
    }

    @JsonProperty("radShinseishaKubun")
    public RadioButton getRadShinseishaKubun() {
        return radShinseishaKubun;
    }

    @JsonProperty("radShinseishaKubun")
    public void setRadShinseishaKubun(RadioButton radShinseishaKubun) {
        this.radShinseishaKubun=radShinseishaKubun;
    }

    @JsonProperty("txtShinseishaName")
    public TextBox getTxtShinseishaName() {
        return txtShinseishaName;
    }

    @JsonProperty("txtShinseishaName")
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.txtShinseishaName=txtShinseishaName;
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

    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo=txtTelNo;
    }

    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo=txtJigyoshaNo;
    }

    @JsonProperty("btnSearchJigyosha")
    public Button getBtnSearchJigyosha() {
        return btnSearchJigyosha;
    }

    @JsonProperty("btnSearchJigyosha")
    public void setBtnSearchJigyosha(Button btnSearchJigyosha) {
        this.btnSearchJigyosha=btnSearchJigyosha;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
