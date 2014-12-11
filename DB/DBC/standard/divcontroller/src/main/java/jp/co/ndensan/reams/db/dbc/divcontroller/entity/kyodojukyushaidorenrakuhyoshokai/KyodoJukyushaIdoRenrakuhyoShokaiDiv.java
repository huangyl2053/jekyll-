package jp.co.ndensan.reams.db.dbc.divcontroller.entity.kyodojukyushaidorenrakuhyoshokai;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.kyodojukyushaidorenrakuhyoshokai.IKyodoJukyushaIdoRenrakuhyoShokaiDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.kyodojukyushaidorenrakuhyoshokai.KyodoJukyushaIdoRenrakuhyoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.kyodojukyushaidorenrakuhyoshokai.KyodoJukyushaIdoRenrakuhyoKogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.kyodojukyushaidorenrakuhyoshokai.KyodoJukyushaIdoRenrakuhyoShokanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyodoJukyushaIdoRenrakuhyoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyodoJukyushaIdoRenrakuhyoShokaiDiv extends Panel implements IKyodoJukyushaIdoRenrakuhyoShokaiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBox1")
    private TextBox TextBox1;
    @JsonProperty("TextBoxDate1")
    private TextBoxDate TextBoxDate1;
    @JsonProperty("TextBoxDate2")
    private TextBoxDate TextBoxDate2;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihon")
    private KyodoJukyushaIdoRenrakuhyoKihonDiv KyodoJukyushaIdoRenrakuhyoKihon;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokan")
    private KyodoJukyushaIdoRenrakuhyoShokanDiv KyodoJukyushaIdoRenrakuhyoShokan;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogaku")
    private KyodoJukyushaIdoRenrakuhyoKogakuDiv KyodoJukyushaIdoRenrakuhyoKogaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TextBox1")
    public TextBox getTextBox1() {
        return TextBox1;
    }

    @JsonProperty("TextBox1")
    public void setTextBox1(TextBox TextBox1) {
        this.TextBox1=TextBox1;
    }

    @JsonProperty("TextBoxDate1")
    public TextBoxDate getTextBoxDate1() {
        return TextBoxDate1;
    }

    @JsonProperty("TextBoxDate1")
    public void setTextBoxDate1(TextBoxDate TextBoxDate1) {
        this.TextBoxDate1=TextBoxDate1;
    }

    @JsonProperty("TextBoxDate2")
    public TextBoxDate getTextBoxDate2() {
        return TextBoxDate2;
    }

    @JsonProperty("TextBoxDate2")
    public void setTextBoxDate2(TextBoxDate TextBoxDate2) {
        this.TextBoxDate2=TextBoxDate2;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihon")
    public KyodoJukyushaIdoRenrakuhyoKihonDiv getKyodoJukyushaIdoRenrakuhyoKihon() {
        return KyodoJukyushaIdoRenrakuhyoKihon;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihon")
    public void setKyodoJukyushaIdoRenrakuhyoKihon(KyodoJukyushaIdoRenrakuhyoKihonDiv KyodoJukyushaIdoRenrakuhyoKihon) {
        this.KyodoJukyushaIdoRenrakuhyoKihon=KyodoJukyushaIdoRenrakuhyoKihon;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokan")
    public KyodoJukyushaIdoRenrakuhyoShokanDiv getKyodoJukyushaIdoRenrakuhyoShokan() {
        return KyodoJukyushaIdoRenrakuhyoShokan;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokan")
    public void setKyodoJukyushaIdoRenrakuhyoShokan(KyodoJukyushaIdoRenrakuhyoShokanDiv KyodoJukyushaIdoRenrakuhyoShokan) {
        this.KyodoJukyushaIdoRenrakuhyoShokan=KyodoJukyushaIdoRenrakuhyoShokan;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogaku")
    public KyodoJukyushaIdoRenrakuhyoKogakuDiv getKyodoJukyushaIdoRenrakuhyoKogaku() {
        return KyodoJukyushaIdoRenrakuhyoKogaku;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogaku")
    public void setKyodoJukyushaIdoRenrakuhyoKogaku(KyodoJukyushaIdoRenrakuhyoKogakuDiv KyodoJukyushaIdoRenrakuhyoKogaku) {
        this.KyodoJukyushaIdoRenrakuhyoKogaku=KyodoJukyushaIdoRenrakuhyoKogaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTextBox13() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().getTextBox13();
    }

    @JsonIgnore
    public void  setTextBox13(TextBox TextBox13) {
        this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().setTextBox13(TextBox13);
    }

    @JsonIgnore
    public TextBox getTextBox14() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().getTextBox14();
    }

    @JsonIgnore
    public void  setTextBox14(TextBox TextBox14) {
        this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().setTextBox14(TextBox14);
    }

    @JsonIgnore
    public TextBox getTextBox15() {
        return this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().getTextBox15();
    }

    @JsonIgnore
    public void  setTextBox15(TextBox TextBox15) {
        this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().setTextBox15(TextBox15);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
