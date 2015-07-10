package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002;
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
 * FukakonkyoNengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukakonkyoNengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeisanjoNenkanHokenryo")
    private TextBoxNum txtKeisanjoNenkanHokenryo;
    @JsonProperty("txtGemmen")
    private TextBoxNum txtGemmen;
    @JsonProperty("txtNenkanHokenryo")
    private TextBoxNum txtNenkanHokenryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKeisanjoNenkanHokenryo")
    public TextBoxNum getTxtKeisanjoNenkanHokenryo() {
        return txtKeisanjoNenkanHokenryo;
    }

    @JsonProperty("txtKeisanjoNenkanHokenryo")
    public void setTxtKeisanjoNenkanHokenryo(TextBoxNum txtKeisanjoNenkanHokenryo) {
        this.txtKeisanjoNenkanHokenryo=txtKeisanjoNenkanHokenryo;
    }

    @JsonProperty("txtGemmen")
    public TextBoxNum getTxtGemmen() {
        return txtGemmen;
    }

    @JsonProperty("txtGemmen")
    public void setTxtGemmen(TextBoxNum txtGemmen) {
        this.txtGemmen=txtGemmen;
    }

    @JsonProperty("txtNenkanHokenryo")
    public TextBoxNum getTxtNenkanHokenryo() {
        return txtNenkanHokenryo;
    }

    @JsonProperty("txtNenkanHokenryo")
    public void setTxtNenkanHokenryo(TextBoxNum txtNenkanHokenryo) {
        this.txtNenkanHokenryo=txtNenkanHokenryo;
    }

}
