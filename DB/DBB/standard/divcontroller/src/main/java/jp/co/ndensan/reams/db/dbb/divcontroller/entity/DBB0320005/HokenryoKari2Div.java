package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.zanteihokenryoHeightKari2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HokenryoKari2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenryoKari2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZanteiKeisanjoHokenryoKari2")
    private TextBoxNum txtZanteiKeisanjoHokenryoKari2;
    @JsonProperty("txtGemmenGakuKari2")
    private TextBoxNum txtGemmenGakuKari2;
    @JsonProperty("txtZanteiGoukeiGakuKari2")
    private TextBoxNum txtZanteiGoukeiGakuKari2;
    @JsonProperty("zanteihokenryoHeightKari2")
    private zanteihokenryoHeightKari2Div zanteihokenryoHeightKari2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtZanteiKeisanjoHokenryoKari2")
    public TextBoxNum getTxtZanteiKeisanjoHokenryoKari2() {
        return txtZanteiKeisanjoHokenryoKari2;
    }

    @JsonProperty("txtZanteiKeisanjoHokenryoKari2")
    public void setTxtZanteiKeisanjoHokenryoKari2(TextBoxNum txtZanteiKeisanjoHokenryoKari2) {
        this.txtZanteiKeisanjoHokenryoKari2=txtZanteiKeisanjoHokenryoKari2;
    }

    @JsonProperty("txtGemmenGakuKari2")
    public TextBoxNum getTxtGemmenGakuKari2() {
        return txtGemmenGakuKari2;
    }

    @JsonProperty("txtGemmenGakuKari2")
    public void setTxtGemmenGakuKari2(TextBoxNum txtGemmenGakuKari2) {
        this.txtGemmenGakuKari2=txtGemmenGakuKari2;
    }

    @JsonProperty("txtZanteiGoukeiGakuKari2")
    public TextBoxNum getTxtZanteiGoukeiGakuKari2() {
        return txtZanteiGoukeiGakuKari2;
    }

    @JsonProperty("txtZanteiGoukeiGakuKari2")
    public void setTxtZanteiGoukeiGakuKari2(TextBoxNum txtZanteiGoukeiGakuKari2) {
        this.txtZanteiGoukeiGakuKari2=txtZanteiGoukeiGakuKari2;
    }

    @JsonProperty("zanteihokenryoHeightKari2")
    public zanteihokenryoHeightKari2Div getZanteihokenryoHeightKari2() {
        return zanteihokenryoHeightKari2;
    }

    @JsonProperty("zanteihokenryoHeightKari2")
    public void setZanteihokenryoHeightKari2(zanteihokenryoHeightKari2Div zanteihokenryoHeightKari2) {
        this.zanteihokenryoHeightKari2=zanteihokenryoHeightKari2;
    }

}
