package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeKaigoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tabKyotakuServiceJikoSakuseiTodokedeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

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
    @JsonProperty("KyotakuJikoTodokedeKaigoKihon")
    private KyotakuJikoTodokedeKaigoKihonDiv KyotakuJikoTodokedeKaigoKihon;
    @JsonProperty("tabKyotakuServiceJikoSakuseiTodokede")
    private tabKyotakuServiceJikoSakuseiTodokedeDiv tabKyotakuServiceJikoSakuseiTodokede;
    @JsonProperty("btnReturn")
    private Button btnReturn;

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

    @JsonProperty("KyotakuJikoTodokedeKaigoKihon")
    public KyotakuJikoTodokedeKaigoKihonDiv getKyotakuJikoTodokedeKaigoKihon() {
        return KyotakuJikoTodokedeKaigoKihon;
    }

    @JsonProperty("KyotakuJikoTodokedeKaigoKihon")
    public void setKyotakuJikoTodokedeKaigoKihon(KyotakuJikoTodokedeKaigoKihonDiv KyotakuJikoTodokedeKaigoKihon) {
        this.KyotakuJikoTodokedeKaigoKihon=KyotakuJikoTodokedeKaigoKihon;
    }

    @JsonProperty("tabKyotakuServiceJikoSakuseiTodokede")
    public tabKyotakuServiceJikoSakuseiTodokedeDiv getTabKyotakuServiceJikoSakuseiTodokede() {
        return tabKyotakuServiceJikoSakuseiTodokede;
    }

    @JsonProperty("tabKyotakuServiceJikoSakuseiTodokede")
    public void setTabKyotakuServiceJikoSakuseiTodokede(tabKyotakuServiceJikoSakuseiTodokedeDiv tabKyotakuServiceJikoSakuseiTodokede) {
        this.tabKyotakuServiceJikoSakuseiTodokede=tabKyotakuServiceJikoSakuseiTodokede;
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
