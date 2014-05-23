package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * KariKaigoCommon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KariKaigoCommonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txt4")
    private TextBox txt4;
    @JsonProperty("txt5")
    private TextBox txt5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txt4")
    public TextBox getTxt4() {
        return txt4;
    }

    @JsonProperty("txt4")
    public void setTxt4(TextBox txt4) {
        this.txt4=txt4;
    }

    @JsonProperty("txt5")
    public TextBox getTxt5() {
        return txt5;
    }

    @JsonProperty("txt5")
    public void setTxt5(TextBox txt5) {
        this.txt5=txt5;
    }

}
