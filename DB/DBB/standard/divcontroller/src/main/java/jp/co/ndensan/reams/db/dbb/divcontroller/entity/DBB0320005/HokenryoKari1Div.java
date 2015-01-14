package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.zanteihokenryoHeightKari1Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HokenryoKari1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenryoKari1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZanteiKeisanjoHokenryoKari1")
    private TextBoxNum txtZanteiKeisanjoHokenryoKari1;
    @JsonProperty("txtGemmenGakuKari1")
    private TextBoxNum txtGemmenGakuKari1;
    @JsonProperty("txtZanteiGoukeiGakuKari1")
    private TextBoxNum txtZanteiGoukeiGakuKari1;
    @JsonProperty("zanteihokenryoHeightKari1")
    private zanteihokenryoHeightKari1Div zanteihokenryoHeightKari1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtZanteiKeisanjoHokenryoKari1")
    public TextBoxNum getTxtZanteiKeisanjoHokenryoKari1() {
        return txtZanteiKeisanjoHokenryoKari1;
    }

    @JsonProperty("txtZanteiKeisanjoHokenryoKari1")
    public void setTxtZanteiKeisanjoHokenryoKari1(TextBoxNum txtZanteiKeisanjoHokenryoKari1) {
        this.txtZanteiKeisanjoHokenryoKari1=txtZanteiKeisanjoHokenryoKari1;
    }

    @JsonProperty("txtGemmenGakuKari1")
    public TextBoxNum getTxtGemmenGakuKari1() {
        return txtGemmenGakuKari1;
    }

    @JsonProperty("txtGemmenGakuKari1")
    public void setTxtGemmenGakuKari1(TextBoxNum txtGemmenGakuKari1) {
        this.txtGemmenGakuKari1=txtGemmenGakuKari1;
    }

    @JsonProperty("txtZanteiGoukeiGakuKari1")
    public TextBoxNum getTxtZanteiGoukeiGakuKari1() {
        return txtZanteiGoukeiGakuKari1;
    }

    @JsonProperty("txtZanteiGoukeiGakuKari1")
    public void setTxtZanteiGoukeiGakuKari1(TextBoxNum txtZanteiGoukeiGakuKari1) {
        this.txtZanteiGoukeiGakuKari1=txtZanteiGoukeiGakuKari1;
    }

    @JsonProperty("zanteihokenryoHeightKari1")
    public zanteihokenryoHeightKari1Div getZanteihokenryoHeightKari1() {
        return zanteihokenryoHeightKari1;
    }

    @JsonProperty("zanteihokenryoHeightKari1")
    public void setZanteihokenryoHeightKari1(zanteihokenryoHeightKari1Div zanteihokenryoHeightKari1) {
        this.zanteihokenryoHeightKari1=zanteihokenryoHeightKari1;
    }

}
