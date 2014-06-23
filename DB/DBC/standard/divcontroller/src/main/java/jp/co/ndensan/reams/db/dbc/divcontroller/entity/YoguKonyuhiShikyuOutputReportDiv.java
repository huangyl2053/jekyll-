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
 * YoguKonyuhiShikyuOutputReport のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuOutputReportDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YoguKonyuhiShikyuKetteishaList")
    private PanelPublish YoguKonyuhiShikyuKetteishaList;
    @JsonProperty("YoguKonyuhiShikyuKetteiTsuchisho")
    private PanelPublish YoguKonyuhiShikyuKetteiTsuchisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("YoguKonyuhiShikyuKetteishaList")
    public PanelPublish getYoguKonyuhiShikyuKetteishaList() {
        return YoguKonyuhiShikyuKetteishaList;
    }

    @JsonProperty("YoguKonyuhiShikyuKetteishaList")
    public void setYoguKonyuhiShikyuKetteishaList(PanelPublish YoguKonyuhiShikyuKetteishaList) {
        this.YoguKonyuhiShikyuKetteishaList=YoguKonyuhiShikyuKetteishaList;
    }

    @JsonProperty("YoguKonyuhiShikyuKetteiTsuchisho")
    public PanelPublish getYoguKonyuhiShikyuKetteiTsuchisho() {
        return YoguKonyuhiShikyuKetteiTsuchisho;
    }

    @JsonProperty("YoguKonyuhiShikyuKetteiTsuchisho")
    public void setYoguKonyuhiShikyuKetteiTsuchisho(PanelPublish YoguKonyuhiShikyuKetteiTsuchisho) {
        this.YoguKonyuhiShikyuKetteiTsuchisho=YoguKonyuhiShikyuKetteiTsuchisho;
    }

}
