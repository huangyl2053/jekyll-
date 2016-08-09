package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;
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
 * panelInput のクラスファイル 
 * @reamsid_L DBA-0220-010 dongyabin
 * @author 自動生成
 */
public class panelInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtStartDate")
    private TextBoxDate txtStartDate;
    @JsonProperty("txtEndDate")
    private TextBoxDate txtEndDate;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("state")
    private RString state;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtStartDate
     * @return txtStartDate
     */
    @JsonProperty("txtStartDate")
    public TextBoxDate getTxtStartDate() {
        return txtStartDate;
    }

    /*
     * settxtStartDate
     * @param txtStartDate txtStartDate
     */
    @JsonProperty("txtStartDate")
    public void setTxtStartDate(TextBoxDate txtStartDate) {
        this.txtStartDate = txtStartDate;
    }

    /*
     * gettxtEndDate
     * @return txtEndDate
     */
    @JsonProperty("txtEndDate")
    public TextBoxDate getTxtEndDate() {
        return txtEndDate;
    }

    /*
     * settxtEndDate
     * @param txtEndDate txtEndDate
     */
    @JsonProperty("txtEndDate")
    public void setTxtEndDate(TextBoxDate txtEndDate) {
        this.txtEndDate = txtEndDate;
    }

    /*
     * getbtnSave
     * @return btnSave
     */
    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    /*
     * setbtnSave
     * @param btnSave btnSave
     */
    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
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

    // </editor-fold>
}
