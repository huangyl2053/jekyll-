package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.jigyoshainputguide;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * JigyoshaInputGuide のクラスファイル
 *
 * @author 自動生成
 */
public class JigyoshaInputGuideDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("radJigyoshaSearchType")
    private RadioButton radJigyoshaSearchType;
    @JsonProperty("txtJigyoshaCode")
    private TextBox txtJigyoshaCode;
    @JsonProperty("btnSearchJigyosha")
    private Button btnSearchJigyosha;
    @JsonProperty("SearchResultJigyosha")
    private SearchResultJigyoshaDiv SearchResultJigyosha;
    @JsonProperty("btnKaigoHokenShisetsuReturn")
    private Button btnKaigoHokenShisetsuReturn;
    @JsonProperty("jigyoshaCode")
    private RString jigyoshaCode;
    @JsonProperty("jigyoshaMeisho")
    private RString jigyoshaMeisho;
    @JsonProperty("jigyoshaCodeMeisho")
    private RString jigyoshaCodeMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radJigyoshaSearchType")
    public RadioButton getRadJigyoshaSearchType() {
        return radJigyoshaSearchType;
    }

    @JsonProperty("radJigyoshaSearchType")
    public void setRadJigyoshaSearchType(RadioButton radJigyoshaSearchType) {
        this.radJigyoshaSearchType = radJigyoshaSearchType;
    }

    @JsonProperty("txtJigyoshaCode")
    public TextBox getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    @JsonProperty("txtJigyoshaCode")
    public void setTxtJigyoshaCode(TextBox txtJigyoshaCode) {
        this.txtJigyoshaCode = txtJigyoshaCode;
    }

    @JsonProperty("btnSearchJigyosha")
    public Button getBtnSearchJigyosha() {
        return btnSearchJigyosha;
    }

    @JsonProperty("btnSearchJigyosha")
    public void setBtnSearchJigyosha(Button btnSearchJigyosha) {
        this.btnSearchJigyosha = btnSearchJigyosha;
    }

    @JsonProperty("SearchResultJigyosha")
    public SearchResultJigyoshaDiv getSearchResultJigyosha() {
        return SearchResultJigyosha;
    }

    @JsonProperty("SearchResultJigyosha")
    public void setSearchResultJigyosha(SearchResultJigyoshaDiv SearchResultJigyosha) {
        this.SearchResultJigyosha = SearchResultJigyosha;
    }

    @JsonProperty("btnKaigoHokenShisetsuReturn")
    public Button getBtnKaigoHokenShisetsuReturn() {
        return btnKaigoHokenShisetsuReturn;
    }

    @JsonProperty("btnKaigoHokenShisetsuReturn")
    public void setBtnKaigoHokenShisetsuReturn(Button btnKaigoHokenShisetsuReturn) {
        this.btnKaigoHokenShisetsuReturn = btnKaigoHokenShisetsuReturn;
    }

    @JsonProperty("jigyoshaCode")
    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    @JsonProperty("jigyoshaCode")
    public void setJigyoshaCode(RString jigyoshaCode) {
        this.jigyoshaCode = jigyoshaCode;
    }

    @JsonProperty("jigyoshaMeisho")
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    @JsonProperty("jigyoshaMeisho")
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    @JsonProperty("jigyoshaCodeMeisho")
    public RString getJigyoshaCodeMeisho() {
        return jigyoshaCodeMeisho;
    }

    @JsonProperty("jigyoshaCodeMeisho")
    public void setJigyoshaCodeMeisho(RString jigyoshaCodeMeisho) {
        this.jigyoshaCodeMeisho = jigyoshaCodeMeisho;
    }

}
