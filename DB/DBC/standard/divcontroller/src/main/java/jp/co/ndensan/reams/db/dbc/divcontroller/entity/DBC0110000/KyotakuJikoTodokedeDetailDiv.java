package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.tabKyotakuServiceJikoSakuseiTodokedeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuJikoTodokedeDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuJikoTodokedeDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuJikoTodokedeKihon")
    private KyotakuJikoTodokedeKihonDiv KyotakuJikoTodokedeKihon;
    @JsonProperty("tabKyotakuServiceJikoSakuseiTodokede")
    private tabKyotakuServiceJikoSakuseiTodokedeDiv tabKyotakuServiceJikoSakuseiTodokede;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuJikoTodokedeKihon")
    public KyotakuJikoTodokedeKihonDiv getKyotakuJikoTodokedeKihon() {
        return KyotakuJikoTodokedeKihon;
    }

    @JsonProperty("KyotakuJikoTodokedeKihon")
    public void setKyotakuJikoTodokedeKihon(KyotakuJikoTodokedeKihonDiv KyotakuJikoTodokedeKihon) {
        this.KyotakuJikoTodokedeKihon=KyotakuJikoTodokedeKihon;
    }

    @JsonProperty("tabKyotakuServiceJikoSakuseiTodokede")
    public tabKyotakuServiceJikoSakuseiTodokedeDiv getTabKyotakuServiceJikoSakuseiTodokede() {
        return tabKyotakuServiceJikoSakuseiTodokede;
    }

    @JsonProperty("tabKyotakuServiceJikoSakuseiTodokede")
    public void setTabKyotakuServiceJikoSakuseiTodokede(tabKyotakuServiceJikoSakuseiTodokedeDiv tabKyotakuServiceJikoSakuseiTodokede) {
        this.tabKyotakuServiceJikoSakuseiTodokede=tabKyotakuServiceJikoSakuseiTodokede;
    }

}
