package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuKeikakuTodokedeShoruiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuKeikakuTodokedeShoruiMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo")
    private Label lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo")
    public Label getLblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo() {
        return lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo;
    }

    @JsonProperty("lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo")
    public void setLblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo(Label lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo) {
        this.lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo=lblKyotakuServiceKeikakuSakuseiIraiTodokedeShoruiJokyo;
    }

}
