package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
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
 * AtenaShosaiJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class AtenaShosaiJokenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNaiGai")
    private RadioButton radNaiGai;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJushoCode")
    private TextBoxCode txtJushoCode;
    @JsonProperty("btnJusho")
    private Button btnJusho;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("txtBanchi1")
    private TextBox txtBanchi1;
    @JsonProperty("txtBanchi2")
    private TextBox txtBanchi2;
    @JsonProperty("txtBanchi3")
    private TextBox txtBanchi3;
    @JsonProperty("txtBanchi4")
    private TextBox txtBanchi4;
    @JsonProperty("btnBunchi")
    private Button btnBunchi;
    @JsonProperty("txtKatagaki")
    private TextBox txtKatagaki;
    @JsonProperty("btnKatagaki")
    private Button btnKatagaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radNaiGai")
    public RadioButton getRadNaiGai() {
        return radNaiGai;
    }

    @JsonProperty("radNaiGai")
    public void setRadNaiGai(RadioButton radNaiGai) {
        this.radNaiGai=radNaiGai;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtJushoCode")
    public TextBoxCode getTxtJushoCode() {
        return txtJushoCode;
    }

    @JsonProperty("txtJushoCode")
    public void setTxtJushoCode(TextBoxCode txtJushoCode) {
        this.txtJushoCode=txtJushoCode;
    }

    @JsonProperty("btnJusho")
    public Button getBtnJusho() {
        return btnJusho;
    }

    @JsonProperty("btnJusho")
    public void setBtnJusho(Button btnJusho) {
        this.btnJusho=btnJusho;
    }

    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho=txtJusho;
    }

    @JsonProperty("txtBanchi1")
    public TextBox getTxtBanchi1() {
        return txtBanchi1;
    }

    @JsonProperty("txtBanchi1")
    public void setTxtBanchi1(TextBox txtBanchi1) {
        this.txtBanchi1=txtBanchi1;
    }

    @JsonProperty("txtBanchi2")
    public TextBox getTxtBanchi2() {
        return txtBanchi2;
    }

    @JsonProperty("txtBanchi2")
    public void setTxtBanchi2(TextBox txtBanchi2) {
        this.txtBanchi2=txtBanchi2;
    }

    @JsonProperty("txtBanchi3")
    public TextBox getTxtBanchi3() {
        return txtBanchi3;
    }

    @JsonProperty("txtBanchi3")
    public void setTxtBanchi3(TextBox txtBanchi3) {
        this.txtBanchi3=txtBanchi3;
    }

    @JsonProperty("txtBanchi4")
    public TextBox getTxtBanchi4() {
        return txtBanchi4;
    }

    @JsonProperty("txtBanchi4")
    public void setTxtBanchi4(TextBox txtBanchi4) {
        this.txtBanchi4=txtBanchi4;
    }

    @JsonProperty("btnBunchi")
    public Button getBtnBunchi() {
        return btnBunchi;
    }

    @JsonProperty("btnBunchi")
    public void setBtnBunchi(Button btnBunchi) {
        this.btnBunchi=btnBunchi;
    }

    @JsonProperty("txtKatagaki")
    public TextBox getTxtKatagaki() {
        return txtKatagaki;
    }

    @JsonProperty("txtKatagaki")
    public void setTxtKatagaki(TextBox txtKatagaki) {
        this.txtKatagaki=txtKatagaki;
    }

    @JsonProperty("btnKatagaki")
    public Button getBtnKatagaki() {
        return btnKatagaki;
    }

    @JsonProperty("btnKatagaki")
    public void setBtnKatagaki(Button btnKatagaki) {
        this.btnKatagaki=btnKatagaki;
    }

}
