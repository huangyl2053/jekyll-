package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * JukyushaIdoSofuTaishoshaList のクラスファイル
 *
 * @author 自動生成
 */
public class JukyushaIdoSofuTaishoshaListDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("JukyushaIdoSofuTaishoshaListPrintSetting")
    private PrintContentsSettingDiv JukyushaIdoSofuTaishoshaListPrintSetting;
    @JsonProperty("JukyushaIdoSofuTaishoshaListOutputOrder")
    private ChohyoShutsuryokujunDiv JukyushaIdoSofuTaishoshaListOutputOrder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoSofuTaishoshaListPrintSetting")
    public PrintContentsSettingDiv getJukyushaIdoSofuTaishoshaListPrintSetting() {
        return JukyushaIdoSofuTaishoshaListPrintSetting;
    }

    @JsonProperty("JukyushaIdoSofuTaishoshaListPrintSetting")
    public void setJukyushaIdoSofuTaishoshaListPrintSetting(PrintContentsSettingDiv JukyushaIdoSofuTaishoshaListPrintSetting) {
        this.JukyushaIdoSofuTaishoshaListPrintSetting = JukyushaIdoSofuTaishoshaListPrintSetting;
    }

    @JsonProperty("JukyushaIdoSofuTaishoshaListOutputOrder")
    public ChohyoShutsuryokujunDiv getJukyushaIdoSofuTaishoshaListOutputOrder() {
        return JukyushaIdoSofuTaishoshaListOutputOrder;
    }

    @JsonProperty("JukyushaIdoSofuTaishoshaListOutputOrder")
    public void setJukyushaIdoSofuTaishoshaListOutputOrder(ChohyoShutsuryokujunDiv JukyushaIdoSofuTaishoshaListOutputOrder) {
        this.JukyushaIdoSofuTaishoshaListOutputOrder = JukyushaIdoSofuTaishoshaListOutputOrder;
    }

}
