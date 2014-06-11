package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000;
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
 * KashitsukeHenkanRisoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeHenkanRisokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRisokuChoshuYMD")
    private TextBoxDate txtRisokuChoshuYMD;
    @JsonProperty("txtRisokuChoshugaku")
    private TextBoxNum txtRisokuChoshugaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtRisokuChoshuYMD")
    public TextBoxDate getTxtRisokuChoshuYMD() {
        return txtRisokuChoshuYMD;
    }

    @JsonProperty("txtRisokuChoshuYMD")
    public void setTxtRisokuChoshuYMD(TextBoxDate txtRisokuChoshuYMD) {
        this.txtRisokuChoshuYMD=txtRisokuChoshuYMD;
    }

    @JsonProperty("txtRisokuChoshugaku")
    public TextBoxNum getTxtRisokuChoshugaku() {
        return txtRisokuChoshugaku;
    }

    @JsonProperty("txtRisokuChoshugaku")
    public void setTxtRisokuChoshugaku(TextBoxNum txtRisokuChoshugaku) {
        this.txtRisokuChoshugaku=txtRisokuChoshugaku;
    }

}
