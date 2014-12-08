package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * KashitsukeShinseisho のクラスファイル
 *
 * @author 自動生成
 */
public class KashitsukeShinseishoDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KyufuhiKariireShinseishoPrintSetting")
    private PrintContentsSettingDiv KyufuhiKariireShinseishoPrintSetting;
    @JsonProperty("btnPrint")
    private Button btnPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuhiKariireShinseishoPrintSetting")
    public PrintContentsSettingDiv getKyufuhiKariireShinseishoPrintSetting() {
        return KyufuhiKariireShinseishoPrintSetting;
    }

    @JsonProperty("KyufuhiKariireShinseishoPrintSetting")
    public void setKyufuhiKariireShinseishoPrintSetting(PrintContentsSettingDiv KyufuhiKariireShinseishoPrintSetting) {
        this.KyufuhiKariireShinseishoPrintSetting = KyufuhiKariireShinseishoPrintSetting;
    }

    @JsonProperty("btnPrint")
    public Button getBtnPrint() {
        return btnPrint;
    }

    @JsonProperty("btnPrint")
    public void setBtnPrint(Button btnPrint) {
        this.btnPrint = btnPrint;
    }

}
