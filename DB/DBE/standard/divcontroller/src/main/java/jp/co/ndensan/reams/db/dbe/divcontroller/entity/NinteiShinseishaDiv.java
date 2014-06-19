package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinseiJigyoshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiShinseisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseishaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShinseishaKubun")
    private RadioButton radShinseishaKubun;
    @JsonProperty("txtShinseishaName")
    private TextBox txtShinseishaName;
    @JsonProperty("txtShinseishaNameKana")
    private TextBox txtShinseishaNameKana;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtShinseishaJusho")
    private TextBox txtShinseishaJusho;
    @JsonProperty("txtShinseishaTelNo")
    private TextBox txtShinseishaTelNo;
    @JsonProperty("ddlShinseishaTsuzukigara")
    private DropDownList ddlShinseishaTsuzukigara;
    @JsonProperty("btnSetaiin")
    private ButtonDialog btnSetaiin;
    @JsonProperty("NinteiShinseiJigyosha")
    private NinteiShinseiJigyoshaDiv NinteiShinseiJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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

    @JsonProperty("txtShinseishaNameKana")
    public TextBox getTxtShinseishaNameKana() {
        return txtShinseishaNameKana;
    }

    @JsonProperty("txtShinseishaNameKana")
    public void setTxtShinseishaNameKana(TextBox txtShinseishaNameKana) {
        this.txtShinseishaNameKana=txtShinseishaNameKana;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtShinseishaJusho")
    public TextBox getTxtShinseishaJusho() {
        return txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaJusho")
    public void setTxtShinseishaJusho(TextBox txtShinseishaJusho) {
        this.txtShinseishaJusho=txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaTelNo")
    public TextBox getTxtShinseishaTelNo() {
        return txtShinseishaTelNo;
    }

    @JsonProperty("txtShinseishaTelNo")
    public void setTxtShinseishaTelNo(TextBox txtShinseishaTelNo) {
        this.txtShinseishaTelNo=txtShinseishaTelNo;
    }

    @JsonProperty("ddlShinseishaTsuzukigara")
    public DropDownList getDdlShinseishaTsuzukigara() {
        return ddlShinseishaTsuzukigara;
    }

    @JsonProperty("ddlShinseishaTsuzukigara")
    public void setDdlShinseishaTsuzukigara(DropDownList ddlShinseishaTsuzukigara) {
        this.ddlShinseishaTsuzukigara=ddlShinseishaTsuzukigara;
    }

    @JsonProperty("btnSetaiin")
    public ButtonDialog getBtnSetaiin() {
        return btnSetaiin;
    }

    @JsonProperty("btnSetaiin")
    public void setBtnSetaiin(ButtonDialog btnSetaiin) {
        this.btnSetaiin=btnSetaiin;
    }

    @JsonProperty("NinteiShinseiJigyosha")
    public NinteiShinseiJigyoshaDiv getNinteiShinseiJigyosha() {
        return NinteiShinseiJigyosha;
    }

    @JsonProperty("NinteiShinseiJigyosha")
    public void setNinteiShinseiJigyosha(NinteiShinseiJigyoshaDiv NinteiShinseiJigyosha) {
        this.NinteiShinseiJigyosha=NinteiShinseiJigyosha;
    }

}
