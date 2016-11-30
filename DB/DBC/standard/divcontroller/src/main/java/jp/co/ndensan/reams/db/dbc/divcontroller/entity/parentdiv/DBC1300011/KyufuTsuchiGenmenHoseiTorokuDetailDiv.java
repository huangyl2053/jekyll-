package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.IServiceTypeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiGenmenHoseiTorokuDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuTsuchiGenmenHoseiTorokuDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBoxDateSaabisu")
    private TextBoxDate TextBoxDateSaabisu;
    @JsonProperty("TextBoxFudangoukei")
    private TextBoxNum TextBoxFudangoukei;
    @JsonProperty("TextBoxNumHiyouGoukei")
    private TextBoxNum TextBoxNumHiyouGoukei;
    @JsonProperty("HorizontalLineSita")
    private HorizontalLine HorizontalLineSita;
    @JsonProperty("ButtonBack")
    private Button ButtonBack;
    @JsonProperty("ButtonYes")
    private Button ButtonYes;
    @JsonProperty("ccdServiceTypeInput")
    private ServiceTypeInputCommonChildDivDiv ccdServiceTypeInput;
    @JsonProperty("ccdJigyoshaInput")
    private ShisetsuJohoCommonChildDivDiv ccdJigyoshaInput;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("state")
    private RString state;
    @JsonProperty("hiddenInputDiv")
    private RString hiddenInputDiv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTextBoxDateSaabisu
     * @return TextBoxDateSaabisu
     */
    @JsonProperty("TextBoxDateSaabisu")
    public TextBoxDate getTextBoxDateSaabisu() {
        return TextBoxDateSaabisu;
    }

    /*
     * setTextBoxDateSaabisu
     * @param TextBoxDateSaabisu TextBoxDateSaabisu
     */
    @JsonProperty("TextBoxDateSaabisu")
    public void setTextBoxDateSaabisu(TextBoxDate TextBoxDateSaabisu) {
        this.TextBoxDateSaabisu = TextBoxDateSaabisu;
    }

    /*
     * getTextBoxFudangoukei
     * @return TextBoxFudangoukei
     */
    @JsonProperty("TextBoxFudangoukei")
    public TextBoxNum getTextBoxFudangoukei() {
        return TextBoxFudangoukei;
    }

    /*
     * setTextBoxFudangoukei
     * @param TextBoxFudangoukei TextBoxFudangoukei
     */
    @JsonProperty("TextBoxFudangoukei")
    public void setTextBoxFudangoukei(TextBoxNum TextBoxFudangoukei) {
        this.TextBoxFudangoukei = TextBoxFudangoukei;
    }

    /*
     * getTextBoxNumHiyouGoukei
     * @return TextBoxNumHiyouGoukei
     */
    @JsonProperty("TextBoxNumHiyouGoukei")
    public TextBoxNum getTextBoxNumHiyouGoukei() {
        return TextBoxNumHiyouGoukei;
    }

    /*
     * setTextBoxNumHiyouGoukei
     * @param TextBoxNumHiyouGoukei TextBoxNumHiyouGoukei
     */
    @JsonProperty("TextBoxNumHiyouGoukei")
    public void setTextBoxNumHiyouGoukei(TextBoxNum TextBoxNumHiyouGoukei) {
        this.TextBoxNumHiyouGoukei = TextBoxNumHiyouGoukei;
    }

    /*
     * getHorizontalLineSita
     * @return HorizontalLineSita
     */
    @JsonProperty("HorizontalLineSita")
    public HorizontalLine getHorizontalLineSita() {
        return HorizontalLineSita;
    }

    /*
     * setHorizontalLineSita
     * @param HorizontalLineSita HorizontalLineSita
     */
    @JsonProperty("HorizontalLineSita")
    public void setHorizontalLineSita(HorizontalLine HorizontalLineSita) {
        this.HorizontalLineSita = HorizontalLineSita;
    }

    /*
     * getButtonBack
     * @return ButtonBack
     */
    @JsonProperty("ButtonBack")
    public Button getButtonBack() {
        return ButtonBack;
    }

    /*
     * setButtonBack
     * @param ButtonBack ButtonBack
     */
    @JsonProperty("ButtonBack")
    public void setButtonBack(Button ButtonBack) {
        this.ButtonBack = ButtonBack;
    }

    /*
     * getButtonYes
     * @return ButtonYes
     */
    @JsonProperty("ButtonYes")
    public Button getButtonYes() {
        return ButtonYes;
    }

    /*
     * setButtonYes
     * @param ButtonYes ButtonYes
     */
    @JsonProperty("ButtonYes")
    public void setButtonYes(Button ButtonYes) {
        this.ButtonYes = ButtonYes;
    }

    /*
     * getccdServiceTypeInput
     * @return ccdServiceTypeInput
     */
    @JsonProperty("ccdServiceTypeInput")
    public IServiceTypeInputCommonChildDiv getCcdServiceTypeInput() {
        return ccdServiceTypeInput;
    }

    /*
     * getccdJigyoshaInput
     * @return ccdJigyoshaInput
     */
    @JsonProperty("ccdJigyoshaInput")
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaInput() {
        return ccdJigyoshaInput;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * getstate
     * @return state
     */
    @JsonProperty("state")
    public RString getState() {
        return state;
    }

    /*
     * setstate
     * @param state state
     */
    @JsonProperty("state")
    public void setState(RString state) {
        this.state = state;
    }

    /*
     * gethiddenInputDiv
     * @return hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public RString getHiddenInputDiv() {
        return hiddenInputDiv;
    }

    /*
     * sethiddenInputDiv
     * @param hiddenInputDiv hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public void setHiddenInputDiv(RString hiddenInputDiv) {
        this.hiddenInputDiv = hiddenInputDiv;
    }

    // </editor-fold>
}
