package jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv;
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
 * ServiceJigyoshaSearchCondition のクラスファイル 
 * 
 * @author 自動生成
 * @jpName
 * @bizDomain 介護
 * @category DAメニュー
 * @subCategory 介護事業者登録
 * @mainClass
 * @reference
 */
public class ServiceJigyoshaSearchConditionDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSearchPrefecturesCode")
    private DropDownList ddlSearchPrefecturesCode;
    @JsonProperty("ddlSearchJigyoshaKubun")
    private DropDownList ddlSearchJigyoshaKubun;
    @JsonProperty("ddlSearchToshiCode")
    private DropDownList ddlSearchToshiCode;
    @JsonProperty("ddlSearchServiceType")
    private DropDownList ddlSearchServiceType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlSearchPrefecturesCode")
    public DropDownList getDdlSearchPrefecturesCode() {
        return ddlSearchPrefecturesCode;
    }

    @JsonProperty("ddlSearchPrefecturesCode")
    public void setDdlSearchPrefecturesCode(DropDownList ddlSearchPrefecturesCode) {
        this.ddlSearchPrefecturesCode=ddlSearchPrefecturesCode;
    }

    @JsonProperty("ddlSearchJigyoshaKubun")
    public DropDownList getDdlSearchJigyoshaKubun() {
        return ddlSearchJigyoshaKubun;
    }

    @JsonProperty("ddlSearchJigyoshaKubun")
    public void setDdlSearchJigyoshaKubun(DropDownList ddlSearchJigyoshaKubun) {
        this.ddlSearchJigyoshaKubun=ddlSearchJigyoshaKubun;
    }

    @JsonProperty("ddlSearchToshiCode")
    public DropDownList getDdlSearchToshiCode() {
        return ddlSearchToshiCode;
    }

    @JsonProperty("ddlSearchToshiCode")
    public void setDdlSearchToshiCode(DropDownList ddlSearchToshiCode) {
        this.ddlSearchToshiCode=ddlSearchToshiCode;
    }

    @JsonProperty("ddlSearchServiceType")
    public DropDownList getDdlSearchServiceType() {
        return ddlSearchServiceType;
    }

    @JsonProperty("ddlSearchServiceType")
    public void setDdlSearchServiceType(DropDownList ddlSearchServiceType) {
        this.ddlSearchServiceType=ddlSearchServiceType;
    }

}
