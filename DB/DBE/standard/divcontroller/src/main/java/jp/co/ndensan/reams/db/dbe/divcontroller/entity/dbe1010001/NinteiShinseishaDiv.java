package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.NinteiShinseiJigyoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.NinteiShinseishaTudukigaraDiv;
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
    @JsonProperty("lblShinseishaKubun")
    private Label lblShinseishaKubun;
    @JsonProperty("radShinseishaKubun")
    private RadioButton radShinseishaKubun;
    @JsonProperty("lblShinseishaShimei")
    private Label lblShinseishaShimei;
    @JsonProperty("lblShinseishaNameKanji")
    private Label lblShinseishaNameKanji;
    @JsonProperty("txtShinseishaName")
    private TextBox txtShinseishaName;
    @JsonProperty("lblPaddingShinseishaName")
    private Label lblPaddingShinseishaName;
    @JsonProperty("lblShinseishaNameKana")
    private Label lblShinseishaNameKana;
    @JsonProperty("txtShinseishaNameKana")
    private TextBox txtShinseishaNameKana;
    @JsonProperty("lblYubinNo")
    private Label lblYubinNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("lblShinseishaJusho")
    private Label lblShinseishaJusho;
    @JsonProperty("txtShinseishaJusho")
    private TextBox txtShinseishaJusho;
    @JsonProperty("lblShinseishaTelNo")
    private Label lblShinseishaTelNo;
    @JsonProperty("txtShinseishaTelNo")
    private TextBox txtShinseishaTelNo;
    @JsonProperty("NinteiShinseishaTudukigara")
    private NinteiShinseishaTudukigaraDiv NinteiShinseishaTudukigara;
    @JsonProperty("NinteiShinseiJigyosha")
    private NinteiShinseiJigyoshaDiv NinteiShinseiJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinseishaKubun")
    public Label getLblShinseishaKubun() {
        return lblShinseishaKubun;
    }

    @JsonProperty("lblShinseishaKubun")
    public void setLblShinseishaKubun(Label lblShinseishaKubun) {
        this.lblShinseishaKubun=lblShinseishaKubun;
    }

    @JsonProperty("radShinseishaKubun")
    public RadioButton getRadShinseishaKubun() {
        return radShinseishaKubun;
    }

    @JsonProperty("radShinseishaKubun")
    public void setRadShinseishaKubun(RadioButton radShinseishaKubun) {
        this.radShinseishaKubun=radShinseishaKubun;
    }

    @JsonProperty("lblShinseishaShimei")
    public Label getLblShinseishaShimei() {
        return lblShinseishaShimei;
    }

    @JsonProperty("lblShinseishaShimei")
    public void setLblShinseishaShimei(Label lblShinseishaShimei) {
        this.lblShinseishaShimei=lblShinseishaShimei;
    }

    @JsonProperty("lblShinseishaNameKanji")
    public Label getLblShinseishaNameKanji() {
        return lblShinseishaNameKanji;
    }

    @JsonProperty("lblShinseishaNameKanji")
    public void setLblShinseishaNameKanji(Label lblShinseishaNameKanji) {
        this.lblShinseishaNameKanji=lblShinseishaNameKanji;
    }

    @JsonProperty("txtShinseishaName")
    public TextBox getTxtShinseishaName() {
        return txtShinseishaName;
    }

    @JsonProperty("txtShinseishaName")
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.txtShinseishaName=txtShinseishaName;
    }

    @JsonProperty("lblPaddingShinseishaName")
    public Label getLblPaddingShinseishaName() {
        return lblPaddingShinseishaName;
    }

    @JsonProperty("lblPaddingShinseishaName")
    public void setLblPaddingShinseishaName(Label lblPaddingShinseishaName) {
        this.lblPaddingShinseishaName=lblPaddingShinseishaName;
    }

    @JsonProperty("lblShinseishaNameKana")
    public Label getLblShinseishaNameKana() {
        return lblShinseishaNameKana;
    }

    @JsonProperty("lblShinseishaNameKana")
    public void setLblShinseishaNameKana(Label lblShinseishaNameKana) {
        this.lblShinseishaNameKana=lblShinseishaNameKana;
    }

    @JsonProperty("txtShinseishaNameKana")
    public TextBox getTxtShinseishaNameKana() {
        return txtShinseishaNameKana;
    }

    @JsonProperty("txtShinseishaNameKana")
    public void setTxtShinseishaNameKana(TextBox txtShinseishaNameKana) {
        this.txtShinseishaNameKana=txtShinseishaNameKana;
    }

    @JsonProperty("lblYubinNo")
    public Label getLblYubinNo() {
        return lblYubinNo;
    }

    @JsonProperty("lblYubinNo")
    public void setLblYubinNo(Label lblYubinNo) {
        this.lblYubinNo=lblYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("lblShinseishaJusho")
    public Label getLblShinseishaJusho() {
        return lblShinseishaJusho;
    }

    @JsonProperty("lblShinseishaJusho")
    public void setLblShinseishaJusho(Label lblShinseishaJusho) {
        this.lblShinseishaJusho=lblShinseishaJusho;
    }

    @JsonProperty("txtShinseishaJusho")
    public TextBox getTxtShinseishaJusho() {
        return txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaJusho")
    public void setTxtShinseishaJusho(TextBox txtShinseishaJusho) {
        this.txtShinseishaJusho=txtShinseishaJusho;
    }

    @JsonProperty("lblShinseishaTelNo")
    public Label getLblShinseishaTelNo() {
        return lblShinseishaTelNo;
    }

    @JsonProperty("lblShinseishaTelNo")
    public void setLblShinseishaTelNo(Label lblShinseishaTelNo) {
        this.lblShinseishaTelNo=lblShinseishaTelNo;
    }

    @JsonProperty("txtShinseishaTelNo")
    public TextBox getTxtShinseishaTelNo() {
        return txtShinseishaTelNo;
    }

    @JsonProperty("txtShinseishaTelNo")
    public void setTxtShinseishaTelNo(TextBox txtShinseishaTelNo) {
        this.txtShinseishaTelNo=txtShinseishaTelNo;
    }

    @JsonProperty("NinteiShinseishaTudukigara")
    public NinteiShinseishaTudukigaraDiv getNinteiShinseishaTudukigara() {
        return NinteiShinseishaTudukigara;
    }

    @JsonProperty("NinteiShinseishaTudukigara")
    public void setNinteiShinseishaTudukigara(NinteiShinseishaTudukigaraDiv NinteiShinseishaTudukigara) {
        this.NinteiShinseishaTudukigara=NinteiShinseishaTudukigara;
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
