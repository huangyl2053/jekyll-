package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoPublishingOptionsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoRelatedDatesDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * IkenshoIraiIkkatuHakkoTab のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoIraiIkkatuHakkoTabDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiIkenshoIraishoPublishingOptions")
    private ShujiiIkenshoIraishoPublishingOptionsDiv ShujiiIkenshoIraishoPublishingOptions;
    @JsonProperty("ShujiiIkenshoIraishoTargetPersons")
    private ShujiiIkenshoIraishoTargetPersonsDiv ShujiiIkenshoIraishoTargetPersons;
    @JsonProperty("ShujiiIkenshoIraishoRelatedDates")
    private ShujiiIkenshoIraishoRelatedDatesDiv ShujiiIkenshoIraishoRelatedDates;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShujiiIkenshoIraishoPublishingOptions")
    public ShujiiIkenshoIraishoPublishingOptionsDiv getShujiiIkenshoIraishoPublishingOptions() {
        return ShujiiIkenshoIraishoPublishingOptions;
    }

    @JsonProperty("ShujiiIkenshoIraishoPublishingOptions")
    public void setShujiiIkenshoIraishoPublishingOptions(ShujiiIkenshoIraishoPublishingOptionsDiv ShujiiIkenshoIraishoPublishingOptions) {
        this.ShujiiIkenshoIraishoPublishingOptions=ShujiiIkenshoIraishoPublishingOptions;
    }

    @JsonProperty("ShujiiIkenshoIraishoTargetPersons")
    public ShujiiIkenshoIraishoTargetPersonsDiv getShujiiIkenshoIraishoTargetPersons() {
        return ShujiiIkenshoIraishoTargetPersons;
    }

    @JsonProperty("ShujiiIkenshoIraishoTargetPersons")
    public void setShujiiIkenshoIraishoTargetPersons(ShujiiIkenshoIraishoTargetPersonsDiv ShujiiIkenshoIraishoTargetPersons) {
        this.ShujiiIkenshoIraishoTargetPersons=ShujiiIkenshoIraishoTargetPersons;
    }

    @JsonProperty("ShujiiIkenshoIraishoRelatedDates")
    public ShujiiIkenshoIraishoRelatedDatesDiv getShujiiIkenshoIraishoRelatedDates() {
        return ShujiiIkenshoIraishoRelatedDates;
    }

    @JsonProperty("ShujiiIkenshoIraishoRelatedDates")
    public void setShujiiIkenshoIraishoRelatedDates(ShujiiIkenshoIraishoRelatedDatesDiv ShujiiIkenshoIraishoRelatedDates) {
        this.ShujiiIkenshoIraishoRelatedDates=ShujiiIkenshoIraishoRelatedDates;
    }

}
