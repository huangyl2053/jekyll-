package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.OutputOrderAndNewpageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * YoguKonyuhiShikyuKetteishaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuKetteishaListDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YoguKonyuhiShikyuKetteishaListHakkoDate")
    private PrintContentsSettingDiv YoguKonyuhiShikyuKetteishaListHakkoDate;
    @JsonProperty("OutputOrderForKetteishaList")
    private OutputOrderAndNewpageDiv OutputOrderForKetteishaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("YoguKonyuhiShikyuKetteishaListHakkoDate")
    public PrintContentsSettingDiv getYoguKonyuhiShikyuKetteishaListHakkoDate() {
        return YoguKonyuhiShikyuKetteishaListHakkoDate;
    }

    @JsonProperty("YoguKonyuhiShikyuKetteishaListHakkoDate")
    public void setYoguKonyuhiShikyuKetteishaListHakkoDate(PrintContentsSettingDiv YoguKonyuhiShikyuKetteishaListHakkoDate) {
        this.YoguKonyuhiShikyuKetteishaListHakkoDate=YoguKonyuhiShikyuKetteishaListHakkoDate;
    }

    @JsonProperty("OutputOrderForKetteishaList")
    public OutputOrderAndNewpageDiv getOutputOrderForKetteishaList() {
        return OutputOrderForKetteishaList;
    }

    @JsonProperty("OutputOrderForKetteishaList")
    public void setOutputOrderForKetteishaList(OutputOrderAndNewpageDiv OutputOrderForKetteishaList) {
        this.OutputOrderForKetteishaList=OutputOrderForKetteishaList;
    }

}
