package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SetaiinShotoku のクラスファイル
 *
 * @author 自動生成
 */
public class SetaiinShotokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("SetaiShotokuIchiran")
    private SetaiShotokuIchiranDiv SetaiShotokuIchiran;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SetaiShotokuIchiran")
    public SetaiShotokuIchiranDiv getSetaiShotokuIchiran() {
        return SetaiShotokuIchiran;
    }

    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

}
