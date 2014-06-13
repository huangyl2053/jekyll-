package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoPublishingOptionsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoRelatedDatesDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraiIkkatuHakkoTab のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiIkkatuHakkoTabDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraishoPublishingOptions")
    private NinteichosaIraishoPublishingOptionsDiv NinteichosaIraishoPublishingOptions;
    @JsonProperty("NinteichosaIraishoTargetPersons")
    private NinteichosaIraishoTargetPersonsDiv NinteichosaIraishoTargetPersons;
    @JsonProperty("NinteichosaIraishoRelatedDates")
    private NinteichosaIraishoRelatedDatesDiv NinteichosaIraishoRelatedDates;
    @JsonProperty("btnToPublishOfChosa")
    private Button btnToPublishOfChosa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteichosaIraishoPublishingOptions")
    public NinteichosaIraishoPublishingOptionsDiv getNinteichosaIraishoPublishingOptions() {
        return NinteichosaIraishoPublishingOptions;
    }

    @JsonProperty("NinteichosaIraishoPublishingOptions")
    public void setNinteichosaIraishoPublishingOptions(NinteichosaIraishoPublishingOptionsDiv NinteichosaIraishoPublishingOptions) {
        this.NinteichosaIraishoPublishingOptions=NinteichosaIraishoPublishingOptions;
    }

    @JsonProperty("NinteichosaIraishoTargetPersons")
    public NinteichosaIraishoTargetPersonsDiv getNinteichosaIraishoTargetPersons() {
        return NinteichosaIraishoTargetPersons;
    }

    @JsonProperty("NinteichosaIraishoTargetPersons")
    public void setNinteichosaIraishoTargetPersons(NinteichosaIraishoTargetPersonsDiv NinteichosaIraishoTargetPersons) {
        this.NinteichosaIraishoTargetPersons=NinteichosaIraishoTargetPersons;
    }

    @JsonProperty("NinteichosaIraishoRelatedDates")
    public NinteichosaIraishoRelatedDatesDiv getNinteichosaIraishoRelatedDates() {
        return NinteichosaIraishoRelatedDates;
    }

    @JsonProperty("NinteichosaIraishoRelatedDates")
    public void setNinteichosaIraishoRelatedDates(NinteichosaIraishoRelatedDatesDiv NinteichosaIraishoRelatedDates) {
        this.NinteichosaIraishoRelatedDates=NinteichosaIraishoRelatedDates;
    }

    @JsonProperty("btnToPublishOfChosa")
    public Button getBtnToPublishOfChosa() {
        return btnToPublishOfChosa;
    }

    @JsonProperty("btnToPublishOfChosa")
    public void setBtnToPublishOfChosa(Button btnToPublishOfChosa) {
        this.btnToPublishOfChosa=btnToPublishOfChosa;
    }

}
