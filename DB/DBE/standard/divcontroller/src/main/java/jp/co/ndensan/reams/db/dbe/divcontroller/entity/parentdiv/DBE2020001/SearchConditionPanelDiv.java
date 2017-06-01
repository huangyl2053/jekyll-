package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtConfigurationYM")
    private TextBoxFlexibleYearMonth txtConfigurationYM;
    @JsonProperty("btnPreviousMonth")
    private Button btnPreviousMonth;
    @JsonProperty("btnNextMonth")
    private Button btnNextMonth;
    @JsonProperty("ddlTaishoChiku")
    private DropDownList ddlTaishoChiku;
    @JsonProperty("btnDisplay")
    private Button btnDisplay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtConfigurationYM
     * @return txtConfigurationYM
     */
    @JsonProperty("txtConfigurationYM")
    public TextBoxFlexibleYearMonth getTxtConfigurationYM() {
        return txtConfigurationYM;
    }

    /*
     * settxtConfigurationYM
     * @param txtConfigurationYM txtConfigurationYM
     */
    @JsonProperty("txtConfigurationYM")
    public void setTxtConfigurationYM(TextBoxFlexibleYearMonth txtConfigurationYM) {
        this.txtConfigurationYM = txtConfigurationYM;
    }

    /*
     * getbtnPreviousMonth
     * @return btnPreviousMonth
     */
    @JsonProperty("btnPreviousMonth")
    public Button getBtnPreviousMonth() {
        return btnPreviousMonth;
    }

    /*
     * setbtnPreviousMonth
     * @param btnPreviousMonth btnPreviousMonth
     */
    @JsonProperty("btnPreviousMonth")
    public void setBtnPreviousMonth(Button btnPreviousMonth) {
        this.btnPreviousMonth = btnPreviousMonth;
    }

    /*
     * getbtnNextMonth
     * @return btnNextMonth
     */
    @JsonProperty("btnNextMonth")
    public Button getBtnNextMonth() {
        return btnNextMonth;
    }

    /*
     * setbtnNextMonth
     * @param btnNextMonth btnNextMonth
     */
    @JsonProperty("btnNextMonth")
    public void setBtnNextMonth(Button btnNextMonth) {
        this.btnNextMonth = btnNextMonth;
    }

    /*
     * getddlTaishoChiku
     * @return ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public DropDownList getDdlTaishoChiku() {
        return ddlTaishoChiku;
    }

    /*
     * setddlTaishoChiku
     * @param ddlTaishoChiku ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public void setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.ddlTaishoChiku = ddlTaishoChiku;
    }

    /*
     * getbtnDisplay
     * @return btnDisplay
     */
    @JsonProperty("btnDisplay")
    public Button getBtnDisplay() {
        return btnDisplay;
    }

    /*
     * setbtnDisplay
     * @param btnDisplay btnDisplay
     */
    @JsonProperty("btnDisplay")
    public void setBtnDisplay(Button btnDisplay) {
        this.btnDisplay = btnDisplay;
    }

    // </editor-fold>
}
