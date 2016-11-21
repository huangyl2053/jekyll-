package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelKetteiJyouhou のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelKetteiJyouhouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("LabelKettei")
    private Label LabelKettei;
    @JsonProperty("TextBoxKette")
    private TextBoxDate TextBoxKette;
    @JsonProperty("LabelKetteRiryuu")
    private Label LabelKetteRiryuu;
    @JsonProperty("TextBoxMultiLineKetteiRiryuu")
    private TextBoxMultiLine TextBoxMultiLineKetteiRiryuu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getLabelKettei
     * @return LabelKettei
     */
    @JsonProperty("LabelKettei")
    public Label getLabelKettei() {
        return LabelKettei;
    }

    /*
     * setLabelKettei
     * @param LabelKettei LabelKettei
     */
    @JsonProperty("LabelKettei")
    public void setLabelKettei(Label LabelKettei) {
        this.LabelKettei = LabelKettei;
    }

    /*
     * getTextBoxKette
     * @return TextBoxKette
     */
    @JsonProperty("TextBoxKette")
    public TextBoxDate getTextBoxKette() {
        return TextBoxKette;
    }

    /*
     * setTextBoxKette
     * @param TextBoxKette TextBoxKette
     */
    @JsonProperty("TextBoxKette")
    public void setTextBoxKette(TextBoxDate TextBoxKette) {
        this.TextBoxKette = TextBoxKette;
    }

    /*
     * getLabelKetteRiryuu
     * @return LabelKetteRiryuu
     */
    @JsonProperty("LabelKetteRiryuu")
    public Label getLabelKetteRiryuu() {
        return LabelKetteRiryuu;
    }

    /*
     * setLabelKetteRiryuu
     * @param LabelKetteRiryuu LabelKetteRiryuu
     */
    @JsonProperty("LabelKetteRiryuu")
    public void setLabelKetteRiryuu(Label LabelKetteRiryuu) {
        this.LabelKetteRiryuu = LabelKetteRiryuu;
    }

    /*
     * getTextBoxMultiLineKetteiRiryuu
     * @return TextBoxMultiLineKetteiRiryuu
     */
    @JsonProperty("TextBoxMultiLineKetteiRiryuu")
    public TextBoxMultiLine getTextBoxMultiLineKetteiRiryuu() {
        return TextBoxMultiLineKetteiRiryuu;
    }

    /*
     * setTextBoxMultiLineKetteiRiryuu
     * @param TextBoxMultiLineKetteiRiryuu TextBoxMultiLineKetteiRiryuu
     */
    @JsonProperty("TextBoxMultiLineKetteiRiryuu")
    public void setTextBoxMultiLineKetteiRiryuu(TextBoxMultiLine TextBoxMultiLineKetteiRiryuu) {
        this.TextBoxMultiLineKetteiRiryuu = TextBoxMultiLineKetteiRiryuu;
    }

    // </editor-fold>
}
