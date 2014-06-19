package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310002;
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
 * HonsanteiShoriNichiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonsanteiShoriNichijiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKakuteiFukaNendo")
    private TextBox txtKakuteiFukaNendo;
    @JsonProperty("txtHonsanteiShoriNichiji")
    private TextBox txtHonsanteiShoriNichiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKakuteiFukaNendo")
    public TextBox getTxtKakuteiFukaNendo() {
        return txtKakuteiFukaNendo;
    }

    @JsonProperty("txtKakuteiFukaNendo")
    public void setTxtKakuteiFukaNendo(TextBox txtKakuteiFukaNendo) {
        this.txtKakuteiFukaNendo=txtKakuteiFukaNendo;
    }

    @JsonProperty("txtHonsanteiShoriNichiji")
    public TextBox getTxtHonsanteiShoriNichiji() {
        return txtHonsanteiShoriNichiji;
    }

    @JsonProperty("txtHonsanteiShoriNichiji")
    public void setTxtHonsanteiShoriNichiji(TextBox txtHonsanteiShoriNichiji) {
        this.txtHonsanteiShoriNichiji=txtHonsanteiShoriNichiji;
    }

}
