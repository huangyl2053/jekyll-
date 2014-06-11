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
 * KashitsukeHenkanChoshu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeHenkanChoshuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChoshuHoho")
    private RadioButton radChoshuHoho;
    @JsonProperty("txtHenkanChoshuYMD")
    private TextBoxDate txtHenkanChoshuYMD;
    @JsonProperty("radKafusokuKekka")
    private RadioButton radKafusokuKekka;
    @JsonProperty("txtHenkanChoshugaku")
    private TextBoxNum txtHenkanChoshugaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radChoshuHoho")
    public RadioButton getRadChoshuHoho() {
        return radChoshuHoho;
    }

    @JsonProperty("radChoshuHoho")
    public void setRadChoshuHoho(RadioButton radChoshuHoho) {
        this.radChoshuHoho=radChoshuHoho;
    }

    @JsonProperty("txtHenkanChoshuYMD")
    public TextBoxDate getTxtHenkanChoshuYMD() {
        return txtHenkanChoshuYMD;
    }

    @JsonProperty("txtHenkanChoshuYMD")
    public void setTxtHenkanChoshuYMD(TextBoxDate txtHenkanChoshuYMD) {
        this.txtHenkanChoshuYMD=txtHenkanChoshuYMD;
    }

    @JsonProperty("radKafusokuKekka")
    public RadioButton getRadKafusokuKekka() {
        return radKafusokuKekka;
    }

    @JsonProperty("radKafusokuKekka")
    public void setRadKafusokuKekka(RadioButton radKafusokuKekka) {
        this.radKafusokuKekka=radKafusokuKekka;
    }

    @JsonProperty("txtHenkanChoshugaku")
    public TextBoxNum getTxtHenkanChoshugaku() {
        return txtHenkanChoshugaku;
    }

    @JsonProperty("txtHenkanChoshugaku")
    public void setTxtHenkanChoshugaku(TextBoxNum txtHenkanChoshugaku) {
        this.txtHenkanChoshugaku=txtHenkanChoshugaku;
    }

}
