package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GenmenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenmenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("LabelTyoutei")
    private Label LabelTyoutei;
    @JsonProperty("TextBoxTyoutenendo")
    private TextBox TextBoxTyoutenendo;
    @JsonProperty("LabelFuka")
    private Label LabelFuka;
    @JsonProperty("TextBoxFukanendo")
    private TextBox TextBoxFukanendo;
    @JsonProperty("PanelGenmenJyouhou")
    private PanelGenmenJyouhouDiv PanelGenmenJyouhou;
    @JsonProperty("PanelKetteiJyouhou")
    private PanelKetteiJyouhouDiv PanelKetteiJyouhou;
    @JsonProperty("ChikuShichosonSelect")
    private ChikuShichosonSelectDiv ChikuShichosonSelect;
    @JsonProperty("GemmenShuruiCode")
    private RString GemmenShuruiCode;
    @JsonProperty("GemmenShuruiHyojiMongon")
    private RString GemmenShuruiHyojiMongon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getLabelTyoutei
     * @return LabelTyoutei
     */
    @JsonProperty("LabelTyoutei")
    public Label getLabelTyoutei() {
        return LabelTyoutei;
    }

    /*
     * setLabelTyoutei
     * @param LabelTyoutei LabelTyoutei
     */
    @JsonProperty("LabelTyoutei")
    public void setLabelTyoutei(Label LabelTyoutei) {
        this.LabelTyoutei = LabelTyoutei;
    }

    /*
     * getTextBoxTyoutenendo
     * @return TextBoxTyoutenendo
     */
    @JsonProperty("TextBoxTyoutenendo")
    public TextBox getTextBoxTyoutenendo() {
        return TextBoxTyoutenendo;
    }

    /*
     * setTextBoxTyoutenendo
     * @param TextBoxTyoutenendo TextBoxTyoutenendo
     */
    @JsonProperty("TextBoxTyoutenendo")
    public void setTextBoxTyoutenendo(TextBox TextBoxTyoutenendo) {
        this.TextBoxTyoutenendo = TextBoxTyoutenendo;
    }

    /*
     * getLabelFuka
     * @return LabelFuka
     */
    @JsonProperty("LabelFuka")
    public Label getLabelFuka() {
        return LabelFuka;
    }

    /*
     * setLabelFuka
     * @param LabelFuka LabelFuka
     */
    @JsonProperty("LabelFuka")
    public void setLabelFuka(Label LabelFuka) {
        this.LabelFuka = LabelFuka;
    }

    /*
     * getTextBoxFukanendo
     * @return TextBoxFukanendo
     */
    @JsonProperty("TextBoxFukanendo")
    public TextBox getTextBoxFukanendo() {
        return TextBoxFukanendo;
    }

    /*
     * setTextBoxFukanendo
     * @param TextBoxFukanendo TextBoxFukanendo
     */
    @JsonProperty("TextBoxFukanendo")
    public void setTextBoxFukanendo(TextBox TextBoxFukanendo) {
        this.TextBoxFukanendo = TextBoxFukanendo;
    }

    /*
     * getPanelGenmenJyouhou
     * @return PanelGenmenJyouhou
     */
    @JsonProperty("PanelGenmenJyouhou")
    public PanelGenmenJyouhouDiv getPanelGenmenJyouhou() {
        return PanelGenmenJyouhou;
    }

    /*
     * setPanelGenmenJyouhou
     * @param PanelGenmenJyouhou PanelGenmenJyouhou
     */
    @JsonProperty("PanelGenmenJyouhou")
    public void setPanelGenmenJyouhou(PanelGenmenJyouhouDiv PanelGenmenJyouhou) {
        this.PanelGenmenJyouhou = PanelGenmenJyouhou;
    }

    /*
     * getPanelKetteiJyouhou
     * @return PanelKetteiJyouhou
     */
    @JsonProperty("PanelKetteiJyouhou")
    public PanelKetteiJyouhouDiv getPanelKetteiJyouhou() {
        return PanelKetteiJyouhou;
    }

    /*
     * setPanelKetteiJyouhou
     * @param PanelKetteiJyouhou PanelKetteiJyouhou
     */
    @JsonProperty("PanelKetteiJyouhou")
    public void setPanelKetteiJyouhou(PanelKetteiJyouhouDiv PanelKetteiJyouhou) {
        this.PanelKetteiJyouhou = PanelKetteiJyouhou;
    }

    /*
     * getChikuShichosonSelect
     * @return ChikuShichosonSelect
     */
    @JsonProperty("ChikuShichosonSelect")
    public IChikuShichosonSelectDiv getChikuShichosonSelect() {
        return ChikuShichosonSelect;
    }

    /*
     * getGemmenShuruiCode
     * @return GemmenShuruiCode
     */
    @JsonProperty("GemmenShuruiCode")
    public RString getGemmenShuruiCode() {
        return GemmenShuruiCode;
    }

    /*
     * setGemmenShuruiCode
     * @param GemmenShuruiCode GemmenShuruiCode
     */
    @JsonProperty("GemmenShuruiCode")
    public void setGemmenShuruiCode(RString GemmenShuruiCode) {
        this.GemmenShuruiCode = GemmenShuruiCode;
    }

    /*
     * getGemmenShuruiHyojiMongon
     * @return GemmenShuruiHyojiMongon
     */
    @JsonProperty("GemmenShuruiHyojiMongon")
    public RString getGemmenShuruiHyojiMongon() {
        return GemmenShuruiHyojiMongon;
    }

    /*
     * setGemmenShuruiHyojiMongon
     * @param GemmenShuruiHyojiMongon GemmenShuruiHyojiMongon
     */
    @JsonProperty("GemmenShuruiHyojiMongon")
    public void setGemmenShuruiHyojiMongon(RString GemmenShuruiHyojiMongon) {
        this.GemmenShuruiHyojiMongon = GemmenShuruiHyojiMongon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLabelsinsei() {
        return this.getPanelGenmenJyouhou().getLabelsinsei();
    }

    @JsonIgnore
    public void  setLabelsinsei(Label Labelsinsei) {
        this.getPanelGenmenJyouhou().setLabelsinsei(Labelsinsei);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxSinsei() {
        return this.getPanelGenmenJyouhou().getTextBoxSinsei();
    }

    @JsonIgnore
    public void  setTextBoxSinsei(TextBoxDate TextBoxSinsei) {
        this.getPanelGenmenJyouhou().setTextBoxSinsei(TextBoxSinsei);
    }

    @JsonIgnore
    public ButtonDialog getButtonGenmenSyurui() {
        return this.getPanelGenmenJyouhou().getButtonGenmenSyurui();
    }

    @JsonIgnore
    public void  setButtonGenmenSyurui(ButtonDialog ButtonGenmenSyurui) {
        this.getPanelGenmenJyouhou().setButtonGenmenSyurui(ButtonGenmenSyurui);
    }

    @JsonIgnore
    public TextBox getTextBoxGenmenSyurui() {
        return this.getPanelGenmenJyouhou().getTextBoxGenmenSyurui();
    }

    @JsonIgnore
    public void  setTextBoxGenmenSyurui(TextBox TextBoxGenmenSyurui) {
        this.getPanelGenmenJyouhou().setTextBoxGenmenSyurui(TextBoxGenmenSyurui);
    }

    @JsonIgnore
    public Label getLabelSinseiRiryuu() {
        return this.getPanelGenmenJyouhou().getLabelSinseiRiryuu();
    }

    @JsonIgnore
    public void  setLabelSinseiRiryuu(Label LabelSinseiRiryuu) {
        this.getPanelGenmenJyouhou().setLabelSinseiRiryuu(LabelSinseiRiryuu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTextBoxMultiLineSinseiRiryuu() {
        return this.getPanelGenmenJyouhou().getTextBoxMultiLineSinseiRiryuu();
    }

    @JsonIgnore
    public void  setTextBoxMultiLineSinseiRiryuu(TextBoxMultiLine TextBoxMultiLineSinseiRiryuu) {
        this.getPanelGenmenJyouhou().setTextBoxMultiLineSinseiRiryuu(TextBoxMultiLineSinseiRiryuu);
    }

    @JsonIgnore
    public Label getLabelGenmenKeikoku() {
        return this.getPanelGenmenJyouhou().getLabelGenmenKeikoku();
    }

    @JsonIgnore
    public void  setLabelGenmenKeikoku(Label LabelGenmenKeikoku) {
        this.getPanelGenmenJyouhou().setLabelGenmenKeikoku(LabelGenmenKeikoku);
    }

    @JsonIgnore
    public Label getLabelKettei() {
        return this.getPanelKetteiJyouhou().getLabelKettei();
    }

    @JsonIgnore
    public void  setLabelKettei(Label LabelKettei) {
        this.getPanelKetteiJyouhou().setLabelKettei(LabelKettei);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxKette() {
        return this.getPanelKetteiJyouhou().getTextBoxKette();
    }

    @JsonIgnore
    public void  setTextBoxKette(TextBoxDate TextBoxKette) {
        this.getPanelKetteiJyouhou().setTextBoxKette(TextBoxKette);
    }

    @JsonIgnore
    public Label getLabelKetteRiryuu() {
        return this.getPanelKetteiJyouhou().getLabelKetteRiryuu();
    }

    @JsonIgnore
    public void  setLabelKetteRiryuu(Label LabelKetteRiryuu) {
        this.getPanelKetteiJyouhou().setLabelKetteRiryuu(LabelKetteRiryuu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTextBoxMultiLineKetteiRiryuu() {
        return this.getPanelKetteiJyouhou().getTextBoxMultiLineKetteiRiryuu();
    }

    @JsonIgnore
    public void  setTextBoxMultiLineKetteiRiryuu(TextBoxMultiLine TextBoxMultiLineKetteiRiryuu) {
        this.getPanelKetteiJyouhou().setTextBoxMultiLineKetteiRiryuu(TextBoxMultiLineKetteiRiryuu);
    }

    // </editor-fold>
}
