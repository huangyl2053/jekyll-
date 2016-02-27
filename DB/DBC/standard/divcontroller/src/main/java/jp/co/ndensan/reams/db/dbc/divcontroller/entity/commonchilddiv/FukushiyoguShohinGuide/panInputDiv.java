package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class panInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKanriKaishiDay")
    private TextBoxDate txtKanriKaishiDay;
    @JsonProperty("txtKanriShuryoDay")
    private TextBoxDate txtKanriShuryoDay;
    @JsonProperty("txtShohinmei")
    private TextBox txtShohinmei;
    @JsonProperty("txtHinmokuCode")
    private TextBox txtHinmokuCode;
    @JsonProperty("txtSeizoJigyoshamei")
    private TextBox txtSeizoJigyoshamei;
    @JsonProperty("State")
    private RString State;
    @JsonProperty("ShohinNo")
    private RString ShohinNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKanriKaishiDay
     * @return txtKanriKaishiDay
     */
    @JsonProperty("txtKanriKaishiDay")
    public TextBoxDate getTxtKanriKaishiDay() {
        return txtKanriKaishiDay;
    }

    /*
     * settxtKanriKaishiDay
     * @param txtKanriKaishiDay txtKanriKaishiDay
     */
    @JsonProperty("txtKanriKaishiDay")
    public void setTxtKanriKaishiDay(TextBoxDate txtKanriKaishiDay) {
        this.txtKanriKaishiDay = txtKanriKaishiDay;
    }

    /*
     * gettxtKanriShuryoDay
     * @return txtKanriShuryoDay
     */
    @JsonProperty("txtKanriShuryoDay")
    public TextBoxDate getTxtKanriShuryoDay() {
        return txtKanriShuryoDay;
    }

    /*
     * settxtKanriShuryoDay
     * @param txtKanriShuryoDay txtKanriShuryoDay
     */
    @JsonProperty("txtKanriShuryoDay")
    public void setTxtKanriShuryoDay(TextBoxDate txtKanriShuryoDay) {
        this.txtKanriShuryoDay = txtKanriShuryoDay;
    }

    /*
     * gettxtShohinmei
     * @return txtShohinmei
     */
    @JsonProperty("txtShohinmei")
    public TextBox getTxtShohinmei() {
        return txtShohinmei;
    }

    /*
     * settxtShohinmei
     * @param txtShohinmei txtShohinmei
     */
    @JsonProperty("txtShohinmei")
    public void setTxtShohinmei(TextBox txtShohinmei) {
        this.txtShohinmei = txtShohinmei;
    }

    /*
     * gettxtHinmokuCode
     * @return txtHinmokuCode
     */
    @JsonProperty("txtHinmokuCode")
    public TextBox getTxtHinmokuCode() {
        return txtHinmokuCode;
    }

    /*
     * settxtHinmokuCode
     * @param txtHinmokuCode txtHinmokuCode
     */
    @JsonProperty("txtHinmokuCode")
    public void setTxtHinmokuCode(TextBox txtHinmokuCode) {
        this.txtHinmokuCode = txtHinmokuCode;
    }

    /*
     * gettxtSeizoJigyoshamei
     * @return txtSeizoJigyoshamei
     */
    @JsonProperty("txtSeizoJigyoshamei")
    public TextBox getTxtSeizoJigyoshamei() {
        return txtSeizoJigyoshamei;
    }

    /*
     * settxtSeizoJigyoshamei
     * @param txtSeizoJigyoshamei txtSeizoJigyoshamei
     */
    @JsonProperty("txtSeizoJigyoshamei")
    public void setTxtSeizoJigyoshamei(TextBox txtSeizoJigyoshamei) {
        this.txtSeizoJigyoshamei = txtSeizoJigyoshamei;
    }

    /*
     * getState
     * @return State
     */
    @JsonProperty("State")
    public RString getState() {
        return State;
    }

    /*
     * setState
     * @param State State
     */
    @JsonProperty("State")
    public void setState(RString State) {
        this.State = State;
    }

    /*
     * getShohinNo
     * @return ShohinNo
     */
    @JsonProperty("ShohinNo")
    public RString getShohinNo() {
        return ShohinNo;
    }

    /*
     * setShohinNo
     * @param ShohinNo ShohinNo
     */
    @JsonProperty("ShohinNo")
    public void setShohinNo(RString ShohinNo) {
        this.ShohinNo = ShohinNo;
    }

    // </editor-fold>
}
