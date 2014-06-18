package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiMishinsaResultListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiMishinsaSearchConditionDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoguKonyuhiShikyuShinseiMishinsaSearchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiMishinsaSearchCondition")
    private YoguKonyuhiShikyuShinseiMishinsaSearchConditionDiv YoguKonyuhiShikyuShinseiMishinsaSearchCondition;
    @JsonProperty("YoguKonyuhiShikyuShinseiMishinsaResultList")
    private YoguKonyuhiShikyuShinseiMishinsaResultListDiv YoguKonyuhiShikyuShinseiMishinsaResultList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiMishinsaSearchCondition")
    public YoguKonyuhiShikyuShinseiMishinsaSearchConditionDiv getYoguKonyuhiShikyuShinseiMishinsaSearchCondition() {
        return YoguKonyuhiShikyuShinseiMishinsaSearchCondition;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiMishinsaSearchCondition")
    public void setYoguKonyuhiShikyuShinseiMishinsaSearchCondition(YoguKonyuhiShikyuShinseiMishinsaSearchConditionDiv YoguKonyuhiShikyuShinseiMishinsaSearchCondition) {
        this.YoguKonyuhiShikyuShinseiMishinsaSearchCondition=YoguKonyuhiShikyuShinseiMishinsaSearchCondition;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiMishinsaResultList")
    public YoguKonyuhiShikyuShinseiMishinsaResultListDiv getYoguKonyuhiShikyuShinseiMishinsaResultList() {
        return YoguKonyuhiShikyuShinseiMishinsaResultList;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiMishinsaResultList")
    public void setYoguKonyuhiShikyuShinseiMishinsaResultList(YoguKonyuhiShikyuShinseiMishinsaResultListDiv YoguKonyuhiShikyuShinseiMishinsaResultList) {
        this.YoguKonyuhiShikyuShinseiMishinsaResultList=YoguKonyuhiShikyuShinseiMishinsaResultList;
    }

}
