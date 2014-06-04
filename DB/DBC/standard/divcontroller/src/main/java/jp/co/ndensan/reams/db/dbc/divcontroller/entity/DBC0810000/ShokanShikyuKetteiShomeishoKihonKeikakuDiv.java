package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
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
 * ShokanShikyuKetteiShomeishoKihonKeikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoKihonKeikakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShomeishoKihonSakuseiKubun")
    private TextBox txtShomeishoKihonSakuseiKubun;
    @JsonProperty("txtShomeishoKihonTokurei")
    private TextBox txtShomeishoKihonTokurei;
    @JsonProperty("txtShomeishoKihonJigyoshaCode")
    private TextBoxCode txtShomeishoKihonJigyoshaCode;
    @JsonProperty("txtShomeishoKihonJigyoshaName")
    private TextBox txtShomeishoKihonJigyoshaName;
    @JsonProperty("txtShomeishoKihonKyufuritsu")
    private TextBoxNum txtShomeishoKihonKyufuritsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShomeishoKihonSakuseiKubun")
    public TextBox getTxtShomeishoKihonSakuseiKubun() {
        return txtShomeishoKihonSakuseiKubun;
    }

    @JsonProperty("txtShomeishoKihonSakuseiKubun")
    public void setTxtShomeishoKihonSakuseiKubun(TextBox txtShomeishoKihonSakuseiKubun) {
        this.txtShomeishoKihonSakuseiKubun=txtShomeishoKihonSakuseiKubun;
    }

    @JsonProperty("txtShomeishoKihonTokurei")
    public TextBox getTxtShomeishoKihonTokurei() {
        return txtShomeishoKihonTokurei;
    }

    @JsonProperty("txtShomeishoKihonTokurei")
    public void setTxtShomeishoKihonTokurei(TextBox txtShomeishoKihonTokurei) {
        this.txtShomeishoKihonTokurei=txtShomeishoKihonTokurei;
    }

    @JsonProperty("txtShomeishoKihonJigyoshaCode")
    public TextBoxCode getTxtShomeishoKihonJigyoshaCode() {
        return txtShomeishoKihonJigyoshaCode;
    }

    @JsonProperty("txtShomeishoKihonJigyoshaCode")
    public void setTxtShomeishoKihonJigyoshaCode(TextBoxCode txtShomeishoKihonJigyoshaCode) {
        this.txtShomeishoKihonJigyoshaCode=txtShomeishoKihonJigyoshaCode;
    }

    @JsonProperty("txtShomeishoKihonJigyoshaName")
    public TextBox getTxtShomeishoKihonJigyoshaName() {
        return txtShomeishoKihonJigyoshaName;
    }

    @JsonProperty("txtShomeishoKihonJigyoshaName")
    public void setTxtShomeishoKihonJigyoshaName(TextBox txtShomeishoKihonJigyoshaName) {
        this.txtShomeishoKihonJigyoshaName=txtShomeishoKihonJigyoshaName;
    }

    @JsonProperty("txtShomeishoKihonKyufuritsu")
    public TextBoxNum getTxtShomeishoKihonKyufuritsu() {
        return txtShomeishoKihonKyufuritsu;
    }

    @JsonProperty("txtShomeishoKihonKyufuritsu")
    public void setTxtShomeishoKihonKyufuritsu(TextBoxNum txtShomeishoKihonKyufuritsu) {
        this.txtShomeishoKihonKyufuritsu=txtShomeishoKihonKyufuritsu;
    }

}
