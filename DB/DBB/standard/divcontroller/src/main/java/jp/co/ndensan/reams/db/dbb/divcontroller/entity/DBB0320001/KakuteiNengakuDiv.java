package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
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
 * KakuteiNengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KakuteiNengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeisanjoNenkanHokenryoGaku")
    private TextBoxNum txtKeisanjoNenkanHokenryoGaku;
    @JsonProperty("txtGemmenGaku")
    private TextBoxNum txtGemmenGaku;
    @JsonProperty("txtNenkanHokenryoGaku")
    private TextBoxNum txtNenkanHokenryoGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKeisanjoNenkanHokenryoGaku")
    public TextBoxNum getTxtKeisanjoNenkanHokenryoGaku() {
        return txtKeisanjoNenkanHokenryoGaku;
    }

    @JsonProperty("txtKeisanjoNenkanHokenryoGaku")
    public void setTxtKeisanjoNenkanHokenryoGaku(TextBoxNum txtKeisanjoNenkanHokenryoGaku) {
        this.txtKeisanjoNenkanHokenryoGaku=txtKeisanjoNenkanHokenryoGaku;
    }

    @JsonProperty("txtGemmenGaku")
    public TextBoxNum getTxtGemmenGaku() {
        return txtGemmenGaku;
    }

    @JsonProperty("txtGemmenGaku")
    public void setTxtGemmenGaku(TextBoxNum txtGemmenGaku) {
        this.txtGemmenGaku=txtGemmenGaku;
    }

    @JsonProperty("txtNenkanHokenryoGaku")
    public TextBoxNum getTxtNenkanHokenryoGaku() {
        return txtNenkanHokenryoGaku;
    }

    @JsonProperty("txtNenkanHokenryoGaku")
    public void setTxtNenkanHokenryoGaku(TextBoxNum txtNenkanHokenryoGaku) {
        this.txtNenkanHokenryoGaku=txtNenkanHokenryoGaku;
    }

}
