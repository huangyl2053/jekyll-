package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC4530011Panel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC4530011Panel1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Label1")
    private Label Label1;
    @JsonProperty("TextBoxMultiLine1")
    private TextBoxMultiLine TextBoxMultiLine1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getLabel1
     * @return Label1
     */
    @JsonProperty("Label1")
    public Label getLabel1() {
        return Label1;
    }

    /*
     * setLabel1
     * @param Label1 Label1
     */
    @JsonProperty("Label1")
    public void setLabel1(Label Label1) {
        this.Label1 = Label1;
    }

    /*
     * getTextBoxMultiLine1
     * @return TextBoxMultiLine1
     */
    @JsonProperty("TextBoxMultiLine1")
    public TextBoxMultiLine getTextBoxMultiLine1() {
        return TextBoxMultiLine1;
    }

    /*
     * setTextBoxMultiLine1
     * @param TextBoxMultiLine1 TextBoxMultiLine1
     */
    @JsonProperty("TextBoxMultiLine1")
    public void setTextBoxMultiLine1(TextBoxMultiLine TextBoxMultiLine1) {
        this.TextBoxMultiLine1 = TextBoxMultiLine1;
    }

    // </editor-fold>
}
