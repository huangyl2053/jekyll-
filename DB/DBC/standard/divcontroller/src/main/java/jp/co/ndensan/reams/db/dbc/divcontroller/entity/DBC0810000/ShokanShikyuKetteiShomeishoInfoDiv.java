package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoList.ServiceTeikyoShomeishoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuKetteiShomeishoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoInfoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiTeikyoshoShinseiYMD")
    private TextBoxDate txtShinseiTeikyoshoShinseiYMD;
    @JsonProperty("txtShinseiShomeisho")
    private TextBox txtShinseiShomeisho;
    @JsonProperty("txtShinseiJigyoshaCode")
    private TextBoxCode txtShinseiJigyoshaCode;
    @JsonProperty("txtShinseiJigyoshaName")
    private TextBox txtShinseiJigyoshaName;
    @JsonProperty("ShokanShikyuKetteiShomeishoListInfo")
    private ServiceTeikyoShomeishoListDiv ShokanShikyuKetteiShomeishoListInfo;

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

    @JsonProperty("txtShinseiShomeisho")
    public TextBox getTxtShinseiShomeisho() {
        return txtShinseiShomeisho;
    }

    @JsonProperty("txtShinseiShomeisho")
    public void setTxtShinseiShomeisho(TextBox txtShinseiShomeisho) {
        this.txtShinseiShomeisho=txtShinseiShomeisho;
    }

    @JsonProperty("txtShinseiJigyoshaCode")
    public TextBoxCode getTxtShinseiJigyoshaCode() {
        return txtShinseiJigyoshaCode;
    }

    @JsonProperty("txtShinseiJigyoshaCode")
    public void setTxtShinseiJigyoshaCode(TextBoxCode txtShinseiJigyoshaCode) {
        this.txtShinseiJigyoshaCode=txtShinseiJigyoshaCode;
    }

    @JsonProperty("txtShinseiJigyoshaName")
    public TextBox getTxtShinseiJigyoshaName() {
        return txtShinseiJigyoshaName;
    }

    @JsonProperty("txtShinseiJigyoshaName")
    public void setTxtShinseiJigyoshaName(TextBox txtShinseiJigyoshaName) {
        this.txtShinseiJigyoshaName=txtShinseiJigyoshaName;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoListInfo")
    public ServiceTeikyoShomeishoListDiv getShokanShikyuKetteiShomeishoListInfo() {
        return ShokanShikyuKetteiShomeishoListInfo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoListInfo")
    public void setShokanShikyuKetteiShomeishoListInfo(ServiceTeikyoShomeishoListDiv ShokanShikyuKetteiShomeishoListInfo) {
        this.ShokanShikyuKetteiShomeishoListInfo=ShokanShikyuKetteiShomeishoListInfo;
    }

}
