package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * KariKihonPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KariKihonPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txt1")
    private TextBox txt1;
    @JsonProperty("txt2")
    private TextBox txt2;
    @JsonProperty("txt3")
    private TextBox txt3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txt1")
    public TextBox getTxt1() {
        return txt1;
    }

    @JsonProperty("txt1")
    public void setTxt1(TextBox txt1) {
        this.txt1=txt1;
    }

    @JsonProperty("txt2")
    public TextBox getTxt2() {
        return txt2;
    }

    @JsonProperty("txt2")
    public void setTxt2(TextBox txt2) {
        this.txt2=txt2;
    }

    @JsonProperty("txt3")
    public TextBox getTxt3() {
        return txt3;
    }

    @JsonProperty("txt3")
    public void setTxt3(TextBox txt3) {
        this.txt3=txt3;
    }

}
