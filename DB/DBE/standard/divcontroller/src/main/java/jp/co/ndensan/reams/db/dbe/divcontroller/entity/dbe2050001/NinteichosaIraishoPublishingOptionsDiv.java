package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoTypeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaRelatedReportTypeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraishoPublishingOptions のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraishoPublishingOptionsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraishoType")
    private NinteichosaIraishoTypeDiv NinteichosaIraishoType;
    @JsonProperty("NinteichosaRelatedReportType")
    private NinteichosaRelatedReportTypeDiv NinteichosaRelatedReportType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteichosaIraishoType")
    public NinteichosaIraishoTypeDiv getNinteichosaIraishoType() {
        return NinteichosaIraishoType;
    }

    @JsonProperty("NinteichosaIraishoType")
    public void setNinteichosaIraishoType(NinteichosaIraishoTypeDiv NinteichosaIraishoType) {
        this.NinteichosaIraishoType=NinteichosaIraishoType;
    }

    @JsonProperty("NinteichosaRelatedReportType")
    public NinteichosaRelatedReportTypeDiv getNinteichosaRelatedReportType() {
        return NinteichosaRelatedReportType;
    }

    @JsonProperty("NinteichosaRelatedReportType")
    public void setNinteichosaRelatedReportType(NinteichosaRelatedReportTypeDiv NinteichosaRelatedReportType) {
        this.NinteichosaRelatedReportType=NinteichosaRelatedReportType;
    }

}
