package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiShinsazumiResultListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiShinsazumiSearchConditionDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoguKonyuhiShikyuShinseiShinsazumiSearchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiShinsazumiSearchCondition")
    private YoguKonyuhiShikyuShinseiShinsazumiSearchConditionDiv YoguKonyuhiShikyuShinseiShinsazumiSearchCondition;
    @JsonProperty("YoguKonyuhiShikyuShinseiShinsazumiResultList")
    private YoguKonyuhiShikyuShinseiShinsazumiResultListDiv YoguKonyuhiShikyuShinseiShinsazumiResultList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiShinsazumiSearchCondition")
    public YoguKonyuhiShikyuShinseiShinsazumiSearchConditionDiv getYoguKonyuhiShikyuShinseiShinsazumiSearchCondition() {
        return YoguKonyuhiShikyuShinseiShinsazumiSearchCondition;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsazumiSearchCondition")
    public void setYoguKonyuhiShikyuShinseiShinsazumiSearchCondition(YoguKonyuhiShikyuShinseiShinsazumiSearchConditionDiv YoguKonyuhiShikyuShinseiShinsazumiSearchCondition) {
        this.YoguKonyuhiShikyuShinseiShinsazumiSearchCondition=YoguKonyuhiShikyuShinseiShinsazumiSearchCondition;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsazumiResultList")
    public YoguKonyuhiShikyuShinseiShinsazumiResultListDiv getYoguKonyuhiShikyuShinseiShinsazumiResultList() {
        return YoguKonyuhiShikyuShinseiShinsazumiResultList;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsazumiResultList")
    public void setYoguKonyuhiShikyuShinseiShinsazumiResultList(YoguKonyuhiShikyuShinseiShinsazumiResultListDiv YoguKonyuhiShikyuShinseiShinsazumiResultList) {
        this.YoguKonyuhiShikyuShinseiShinsazumiResultList=YoguKonyuhiShikyuShinseiShinsazumiResultList;
    }

}
