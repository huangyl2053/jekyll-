package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelJogaisyaTekiyo のクラスファイル
 *
 */
public class panelJogaisyaTekiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyusyoDateInput")
    private TextBoxDate txtNyusyoDateInput;
    @JsonProperty("txtTekiyoDateInput")
    private TextBoxDate txtTekiyoDateInput;
    @JsonProperty("txtTkyoTododkDateIn")
    private TextBoxDate txtTkyoTododkDateIn;
    @JsonProperty("ddlTekiyoJiyuInput")
    private DropDownList ddlTekiyoJiyuInput;
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoCommonChildDivDiv ccdShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNyusyoDateInput
     * @return txtNyusyoDateInput
     */
    @JsonProperty("txtNyusyoDateInput")
    public TextBoxDate getTxtNyusyoDateInput() {
        return txtNyusyoDateInput;
    }

    /*
     * settxtNyusyoDateInput
     * @param txtNyusyoDateInput txtNyusyoDateInput
     */
    @JsonProperty("txtNyusyoDateInput")
    public void setTxtNyusyoDateInput(TextBoxDate txtNyusyoDateInput) {
        this.txtNyusyoDateInput = txtNyusyoDateInput;
    }

    /*
     * gettxtTekiyoDateInput
     * @return txtTekiyoDateInput
     */
    @JsonProperty("txtTekiyoDateInput")
    public TextBoxDate getTxtTekiyoDateInput() {
        return txtTekiyoDateInput;
    }

    /*
     * settxtTekiyoDateInput
     * @param txtTekiyoDateInput txtTekiyoDateInput
     */
    @JsonProperty("txtTekiyoDateInput")
    public void setTxtTekiyoDateInput(TextBoxDate txtTekiyoDateInput) {
        this.txtTekiyoDateInput = txtTekiyoDateInput;
    }

    /*
     * gettxtTkyoTododkDateIn
     * @return txtTkyoTododkDateIn
     */
    @JsonProperty("txtTkyoTododkDateIn")
    public TextBoxDate getTxtTkyoTododkDateIn() {
        return txtTkyoTododkDateIn;
    }

    /*
     * settxtTkyoTododkDateIn
     * @param txtTkyoTododkDateIn txtTkyoTododkDateIn
     */
    @JsonProperty("txtTkyoTododkDateIn")
    public void setTxtTkyoTododkDateIn(TextBoxDate txtTkyoTododkDateIn) {
        this.txtTkyoTododkDateIn = txtTkyoTododkDateIn;
    }

    /*
     * getddlTekiyoJiyuInput
     * @return ddlTekiyoJiyuInput
     */
    @JsonProperty("ddlTekiyoJiyuInput")
    public DropDownList getDdlTekiyoJiyuInput() {
        return ddlTekiyoJiyuInput;
    }

    /*
     * setddlTekiyoJiyuInput
     * @param ddlTekiyoJiyuInput ddlTekiyoJiyuInput
     */
    @JsonProperty("ddlTekiyoJiyuInput")
    public void setDdlTekiyoJiyuInput(DropDownList ddlTekiyoJiyuInput) {
        this.ddlTekiyoJiyuInput = ddlTekiyoJiyuInput;
    }

    /*
     * getccdShisetsuJoho
     * @return ccdShisetsuJoho
     */
    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
    }

    // </editor-fold>
}
