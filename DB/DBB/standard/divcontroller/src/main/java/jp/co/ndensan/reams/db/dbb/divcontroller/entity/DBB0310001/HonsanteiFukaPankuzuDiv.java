package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
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
 * HonsanteiFukaPankuzu のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonsanteiFukaPankuzuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHonsanteiFukaPankuzu")
    private TextBox txtHonsanteiFukaPankuzu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHonsanteiFukaPankuzu")
    public TextBox getTxtHonsanteiFukaPankuzu() {
        return txtHonsanteiFukaPankuzu;
    }

    @JsonProperty("txtHonsanteiFukaPankuzu")
    public void setTxtHonsanteiFukaPankuzu(TextBox txtHonsanteiFukaPankuzu) {
        this.txtHonsanteiFukaPankuzu=txtHonsanteiFukaPankuzu;
    }

}
