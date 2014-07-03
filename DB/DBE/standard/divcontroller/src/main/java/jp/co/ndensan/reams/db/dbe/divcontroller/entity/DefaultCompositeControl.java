package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.CompositeControl;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * defaultLayout のクラスファイル 
 * 
 * @author 自動生成
 */
public class DefaultCompositeControl extends CompositeControl {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ButtonBatchReserve1")
    private ButtonBatchReserve ButtonBatchReserve1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ButtonBatchReserve1")
    public ButtonBatchReserve getButtonBatchReserve1() {
        return ButtonBatchReserve1;
    }

    @JsonProperty("ButtonBatchReserve1")
    public void setButtonBatchReserve1(ButtonBatchReserve ButtonBatchReserve1) {
        this.ButtonBatchReserve1=ButtonBatchReserve1;
    }

}
