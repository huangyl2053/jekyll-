package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoTypeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoRelatedReportTypeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoIraishoPublishingOptions のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoIraishoPublishingOptionsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiIkenshoIraishoType")
    private ShujiiIkenshoIraishoTypeDiv ShujiiIkenshoIraishoType;
    @JsonProperty("ShujiiIkenshoRelatedReportType")
    private ShujiiIkenshoRelatedReportTypeDiv ShujiiIkenshoRelatedReportType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShujiiIkenshoIraishoType")
    public ShujiiIkenshoIraishoTypeDiv getShujiiIkenshoIraishoType() {
        return ShujiiIkenshoIraishoType;
    }

    @JsonProperty("ShujiiIkenshoIraishoType")
    public void setShujiiIkenshoIraishoType(ShujiiIkenshoIraishoTypeDiv ShujiiIkenshoIraishoType) {
        this.ShujiiIkenshoIraishoType=ShujiiIkenshoIraishoType;
    }

    @JsonProperty("ShujiiIkenshoRelatedReportType")
    public ShujiiIkenshoRelatedReportTypeDiv getShujiiIkenshoRelatedReportType() {
        return ShujiiIkenshoRelatedReportType;
    }

    @JsonProperty("ShujiiIkenshoRelatedReportType")
    public void setShujiiIkenshoRelatedReportType(ShujiiIkenshoRelatedReportTypeDiv ShujiiIkenshoRelatedReportType) {
        this.ShujiiIkenshoRelatedReportType=ShujiiIkenshoRelatedReportType;
    }

}
