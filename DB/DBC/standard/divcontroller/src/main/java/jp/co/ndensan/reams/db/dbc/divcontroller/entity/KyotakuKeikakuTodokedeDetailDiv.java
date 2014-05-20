package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeKaigoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

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
    @JsonProperty("KyotakuKeikakuTodokedeKaigoKihon")
    private KyotakuKeikakuTodokedeKaigoKihonDiv KyotakuKeikakuTodokedeKaigoKihon;
    @JsonProperty("tabKyotakuServiceKeikakuSakuseiIraiTodokede")
    private tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv tabKyotakuServiceKeikakuSakuseiIraiTodokede;
    @JsonProperty("btnReturn")
    private Button btnReturn;

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

    @JsonProperty("KyotakuKeikakuTodokedeKaigoKihon")
    public KyotakuKeikakuTodokedeKaigoKihonDiv getKyotakuKeikakuTodokedeKaigoKihon() {
        return KyotakuKeikakuTodokedeKaigoKihon;
    }

    @JsonProperty("KyotakuKeikakuTodokedeKaigoKihon")
    public void setKyotakuKeikakuTodokedeKaigoKihon(KyotakuKeikakuTodokedeKaigoKihonDiv KyotakuKeikakuTodokedeKaigoKihon) {
        this.KyotakuKeikakuTodokedeKaigoKihon=KyotakuKeikakuTodokedeKaigoKihon;
    }

    @JsonProperty("tabKyotakuServiceKeikakuSakuseiIraiTodokede")
    public tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv getTabKyotakuServiceKeikakuSakuseiIraiTodokede() {
        return tabKyotakuServiceKeikakuSakuseiIraiTodokede;
    }

    @JsonProperty("tabKyotakuServiceKeikakuSakuseiIraiTodokede")
    public void setTabKyotakuServiceKeikakuSakuseiIraiTodokede(tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv tabKyotakuServiceKeikakuSakuseiIraiTodokede) {
        this.tabKyotakuServiceKeikakuSakuseiIraiTodokede=tabKyotakuServiceKeikakuSakuseiIraiTodokede;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

}
