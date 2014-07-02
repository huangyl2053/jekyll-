package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuKeikakuTodokedeDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuKeikakuTodokedeDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuKeikakuTodokedeKihon")
    private KyotakuKeikakuTodokedeKihonDiv KyotakuKeikakuTodokedeKihon;
    @JsonProperty("tabKyotakuServiceKeikakuSakuseiIraiTodokede")
    private tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv tabKyotakuServiceKeikakuSakuseiIraiTodokede;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuKeikakuTodokedeKihon")
    public KyotakuKeikakuTodokedeKihonDiv getKyotakuKeikakuTodokedeKihon() {
        return KyotakuKeikakuTodokedeKihon;
    }

    @JsonProperty("KyotakuKeikakuTodokedeKihon")
    public void setKyotakuKeikakuTodokedeKihon(KyotakuKeikakuTodokedeKihonDiv KyotakuKeikakuTodokedeKihon) {
        this.KyotakuKeikakuTodokedeKihon=KyotakuKeikakuTodokedeKihon;
    }

    @JsonProperty("tabKyotakuServiceKeikakuSakuseiIraiTodokede")
    public tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv getTabKyotakuServiceKeikakuSakuseiIraiTodokede() {
        return tabKyotakuServiceKeikakuSakuseiIraiTodokede;
    }

    @JsonProperty("tabKyotakuServiceKeikakuSakuseiIraiTodokede")
    public void setTabKyotakuServiceKeikakuSakuseiIraiTodokede(tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv tabKyotakuServiceKeikakuSakuseiIraiTodokede) {
        this.tabKyotakuServiceKeikakuSakuseiIraiTodokede=tabKyotakuServiceKeikakuSakuseiIraiTodokede;
    }

}
