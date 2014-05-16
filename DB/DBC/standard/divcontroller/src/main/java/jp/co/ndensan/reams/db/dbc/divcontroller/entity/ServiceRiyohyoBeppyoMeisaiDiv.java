package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * ServiceRiyohyoBeppyoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoBeppyoMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJigyoshaCode")
    private TextBoxCode txtJigyoshaCode;
    @JsonProperty("btnJigyosha")
    private Button btnJigyosha;
    @JsonProperty("btnJigyoshaName")
    private TextBox btnJigyoshaName;
    @JsonProperty("txtServiceShuruiCode")
    private TextBoxCode txtServiceShuruiCode;
    @JsonProperty("btnServiceShurui")
    private Button btnServiceShurui;
    @JsonProperty("txtServiceCode")
    private TextBoxCode txtServiceCode;
    @JsonProperty("btnService")
    private Button btnService;
    @JsonProperty("btnServiceName")
    private TextBox btnServiceName;
    @JsonProperty("txtTani")
    private TextBoxNum txtTani;
    @JsonProperty("txtWaribikigoRitsu")
    private TextBoxNum txtWaribikigoRitsu;
    @JsonProperty("txtWaribikigoTain")
    private TextBoxNum txtWaribikigoTain;
    @JsonProperty("txtKaisu")
    private TextBoxNum txtKaisu;
    @JsonProperty("lblKaisu")
    private Label lblKaisu;
    @JsonProperty("txtServiceTani")
    private TextBoxNum txtServiceTani;
    @JsonProperty("lblServiceTani")
    private Label lblServiceTani;
    @JsonProperty("btnBeppyoMeisaiKakutei")
    private Button btnBeppyoMeisaiKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJigyoshaCode")
    public TextBoxCode getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    @JsonProperty("txtJigyoshaCode")
    public void setTxtJigyoshaCode(TextBoxCode txtJigyoshaCode) {
        this.txtJigyoshaCode=txtJigyoshaCode;
    }

    @JsonProperty("btnJigyosha")
    public Button getBtnJigyosha() {
        return btnJigyosha;
    }

    @JsonProperty("btnJigyosha")
    public void setBtnJigyosha(Button btnJigyosha) {
        this.btnJigyosha=btnJigyosha;
    }

    @JsonProperty("btnJigyoshaName")
    public TextBox getBtnJigyoshaName() {
        return btnJigyoshaName;
    }

    @JsonProperty("btnJigyoshaName")
    public void setBtnJigyoshaName(TextBox btnJigyoshaName) {
        this.btnJigyoshaName=btnJigyoshaName;
    }

    @JsonProperty("txtServiceShuruiCode")
    public TextBoxCode getTxtServiceShuruiCode() {
        return txtServiceShuruiCode;
    }

    @JsonProperty("txtServiceShuruiCode")
    public void setTxtServiceShuruiCode(TextBoxCode txtServiceShuruiCode) {
        this.txtServiceShuruiCode=txtServiceShuruiCode;
    }

    @JsonProperty("btnServiceShurui")
    public Button getBtnServiceShurui() {
        return btnServiceShurui;
    }

    @JsonProperty("btnServiceShurui")
    public void setBtnServiceShurui(Button btnServiceShurui) {
        this.btnServiceShurui=btnServiceShurui;
    }

    @JsonProperty("txtServiceCode")
    public TextBoxCode getTxtServiceCode() {
        return txtServiceCode;
    }

    @JsonProperty("txtServiceCode")
    public void setTxtServiceCode(TextBoxCode txtServiceCode) {
        this.txtServiceCode=txtServiceCode;
    }

    @JsonProperty("btnService")
    public Button getBtnService() {
        return btnService;
    }

    @JsonProperty("btnService")
    public void setBtnService(Button btnService) {
        this.btnService=btnService;
    }

    @JsonProperty("btnServiceName")
    public TextBox getBtnServiceName() {
        return btnServiceName;
    }

    @JsonProperty("btnServiceName")
    public void setBtnServiceName(TextBox btnServiceName) {
        this.btnServiceName=btnServiceName;
    }

    @JsonProperty("txtTani")
    public TextBoxNum getTxtTani() {
        return txtTani;
    }

    @JsonProperty("txtTani")
    public void setTxtTani(TextBoxNum txtTani) {
        this.txtTani=txtTani;
    }

    @JsonProperty("txtWaribikigoRitsu")
    public TextBoxNum getTxtWaribikigoRitsu() {
        return txtWaribikigoRitsu;
    }

    @JsonProperty("txtWaribikigoRitsu")
    public void setTxtWaribikigoRitsu(TextBoxNum txtWaribikigoRitsu) {
        this.txtWaribikigoRitsu=txtWaribikigoRitsu;
    }

    @JsonProperty("txtWaribikigoTain")
    public TextBoxNum getTxtWaribikigoTain() {
        return txtWaribikigoTain;
    }

    @JsonProperty("txtWaribikigoTain")
    public void setTxtWaribikigoTain(TextBoxNum txtWaribikigoTain) {
        this.txtWaribikigoTain=txtWaribikigoTain;
    }

    @JsonProperty("txtKaisu")
    public TextBoxNum getTxtKaisu() {
        return txtKaisu;
    }

    @JsonProperty("txtKaisu")
    public void setTxtKaisu(TextBoxNum txtKaisu) {
        this.txtKaisu=txtKaisu;
    }

    @JsonProperty("lblKaisu")
    public Label getLblKaisu() {
        return lblKaisu;
    }

    @JsonProperty("lblKaisu")
    public void setLblKaisu(Label lblKaisu) {
        this.lblKaisu=lblKaisu;
    }

    @JsonProperty("txtServiceTani")
    public TextBoxNum getTxtServiceTani() {
        return txtServiceTani;
    }

    @JsonProperty("txtServiceTani")
    public void setTxtServiceTani(TextBoxNum txtServiceTani) {
        this.txtServiceTani=txtServiceTani;
    }

    @JsonProperty("lblServiceTani")
    public Label getLblServiceTani() {
        return lblServiceTani;
    }

    @JsonProperty("lblServiceTani")
    public void setLblServiceTani(Label lblServiceTani) {
        this.lblServiceTani=lblServiceTani;
    }

    @JsonProperty("btnBeppyoMeisaiKakutei")
    public Button getBtnBeppyoMeisaiKakutei() {
        return btnBeppyoMeisaiKakutei;
    }

    @JsonProperty("btnBeppyoMeisaiKakutei")
    public void setBtnBeppyoMeisaiKakutei(Button btnBeppyoMeisaiKakutei) {
        this.btnBeppyoMeisaiKakutei=btnBeppyoMeisaiKakutei;
    }

}
