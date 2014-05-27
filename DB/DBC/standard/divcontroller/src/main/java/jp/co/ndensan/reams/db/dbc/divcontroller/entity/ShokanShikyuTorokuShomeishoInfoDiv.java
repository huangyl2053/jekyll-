package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeishoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoInfoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiTeikyoshoShinseiYMD")
    private TextBoxDate txtShinseiTeikyoshoShinseiYMD;
    @JsonProperty("ddlShinseiShomeisho")
    private DropDownList ddlShinseiShomeisho;
    @JsonProperty("txtShinseiJigyoshaCode")
    private TextBoxCode txtShinseiJigyoshaCode;
    @JsonProperty("btnShinseiJigyosha")
    private Button btnShinseiJigyosha;
    @JsonProperty("txtShinseiJigyoshaName")
    private TextBox txtShinseiJigyoshaName;
    @JsonProperty("ShokanShikyuTorokuShomeishoListInfo")
    private ServiceTeikyoShomeishoListDiv ShokanShikyuTorokuShomeishoListInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiTeikyoshoShinseiYMD")
    public TextBoxDate getTxtShinseiTeikyoshoShinseiYMD() {
        return txtShinseiTeikyoshoShinseiYMD;
    }

    @JsonProperty("txtShinseiTeikyoshoShinseiYMD")
    public void setTxtShinseiTeikyoshoShinseiYMD(TextBoxDate txtShinseiTeikyoshoShinseiYMD) {
        this.txtShinseiTeikyoshoShinseiYMD=txtShinseiTeikyoshoShinseiYMD;
    }

    @JsonProperty("ddlShinseiShomeisho")
    public DropDownList getDdlShinseiShomeisho() {
        return ddlShinseiShomeisho;
    }

    @JsonProperty("ddlShinseiShomeisho")
    public void setDdlShinseiShomeisho(DropDownList ddlShinseiShomeisho) {
        this.ddlShinseiShomeisho=ddlShinseiShomeisho;
    }

    @JsonProperty("txtShinseiJigyoshaCode")
    public TextBoxCode getTxtShinseiJigyoshaCode() {
        return txtShinseiJigyoshaCode;
    }

    @JsonProperty("txtShinseiJigyoshaCode")
    public void setTxtShinseiJigyoshaCode(TextBoxCode txtShinseiJigyoshaCode) {
        this.txtShinseiJigyoshaCode=txtShinseiJigyoshaCode;
    }

    @JsonProperty("btnShinseiJigyosha")
    public Button getBtnShinseiJigyosha() {
        return btnShinseiJigyosha;
    }

    @JsonProperty("btnShinseiJigyosha")
    public void setBtnShinseiJigyosha(Button btnShinseiJigyosha) {
        this.btnShinseiJigyosha=btnShinseiJigyosha;
    }

    @JsonProperty("txtShinseiJigyoshaName")
    public TextBox getTxtShinseiJigyoshaName() {
        return txtShinseiJigyoshaName;
    }

    @JsonProperty("txtShinseiJigyoshaName")
    public void setTxtShinseiJigyoshaName(TextBox txtShinseiJigyoshaName) {
        this.txtShinseiJigyoshaName=txtShinseiJigyoshaName;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoListInfo")
    public ServiceTeikyoShomeishoListDiv getShokanShikyuTorokuShomeishoListInfo() {
        return ShokanShikyuTorokuShomeishoListInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoListInfo")
    public void setShokanShikyuTorokuShomeishoListInfo(ServiceTeikyoShomeishoListDiv ShokanShikyuTorokuShomeishoListInfo) {
        this.ShokanShikyuTorokuShomeishoListInfo=ShokanShikyuTorokuShomeishoListInfo;
    }

}
