package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoYokaigonintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoYokaigoninteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("radShinseiType")
    private RadioButton radShinseiType;
    @JsonProperty("btnYokaigoninteiRireki")
    private Button btnYokaigoninteiRireki;
    @JsonProperty("ddlYokaigoJotaiKubun")
    private DropDownList ddlYokaigoJotaiKubun;
    @JsonProperty("radHenkoShinseichuKubun")
    private RadioButton radHenkoShinseichuKubun;
    @JsonProperty("txtNinteiDateRange")
    private TextBoxDateRange txtNinteiDateRange;
    @JsonProperty("radMinashiYokaigoKubun")
    private RadioButton radMinashiYokaigoKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * getradShinseiType
     * @return radShinseiType
     */
    @JsonProperty("radShinseiType")
    public RadioButton getRadShinseiType() {
        return radShinseiType;
    }

    /*
     * setradShinseiType
     * @param radShinseiType radShinseiType
     */
    @JsonProperty("radShinseiType")
    public void setRadShinseiType(RadioButton radShinseiType) {
        this.radShinseiType = radShinseiType;
    }

    /*
     * getbtnYokaigoninteiRireki
     * @return btnYokaigoninteiRireki
     */
    @JsonProperty("btnYokaigoninteiRireki")
    public Button getBtnYokaigoninteiRireki() {
        return btnYokaigoninteiRireki;
    }

    /*
     * setbtnYokaigoninteiRireki
     * @param btnYokaigoninteiRireki btnYokaigoninteiRireki
     */
    @JsonProperty("btnYokaigoninteiRireki")
    public void setBtnYokaigoninteiRireki(Button btnYokaigoninteiRireki) {
        this.btnYokaigoninteiRireki = btnYokaigoninteiRireki;
    }

    /*
     * getddlYokaigoJotaiKubun
     * @return ddlYokaigoJotaiKubun
     */
    @JsonProperty("ddlYokaigoJotaiKubun")
    public DropDownList getDdlYokaigoJotaiKubun() {
        return ddlYokaigoJotaiKubun;
    }

    /*
     * setddlYokaigoJotaiKubun
     * @param ddlYokaigoJotaiKubun ddlYokaigoJotaiKubun
     */
    @JsonProperty("ddlYokaigoJotaiKubun")
    public void setDdlYokaigoJotaiKubun(DropDownList ddlYokaigoJotaiKubun) {
        this.ddlYokaigoJotaiKubun = ddlYokaigoJotaiKubun;
    }

    /*
     * getradHenkoShinseichuKubun
     * @return radHenkoShinseichuKubun
     */
    @JsonProperty("radHenkoShinseichuKubun")
    public RadioButton getRadHenkoShinseichuKubun() {
        return radHenkoShinseichuKubun;
    }

    /*
     * setradHenkoShinseichuKubun
     * @param radHenkoShinseichuKubun radHenkoShinseichuKubun
     */
    @JsonProperty("radHenkoShinseichuKubun")
    public void setRadHenkoShinseichuKubun(RadioButton radHenkoShinseichuKubun) {
        this.radHenkoShinseichuKubun = radHenkoShinseichuKubun;
    }

    /*
     * gettxtNinteiDateRange
     * @return txtNinteiDateRange
     */
    @JsonProperty("txtNinteiDateRange")
    public TextBoxDateRange getTxtNinteiDateRange() {
        return txtNinteiDateRange;
    }

    /*
     * settxtNinteiDateRange
     * @param txtNinteiDateRange txtNinteiDateRange
     */
    @JsonProperty("txtNinteiDateRange")
    public void setTxtNinteiDateRange(TextBoxDateRange txtNinteiDateRange) {
        this.txtNinteiDateRange = txtNinteiDateRange;
    }

    /*
     * getradMinashiYokaigoKubun
     * @return radMinashiYokaigoKubun
     */
    @JsonProperty("radMinashiYokaigoKubun")
    public RadioButton getRadMinashiYokaigoKubun() {
        return radMinashiYokaigoKubun;
    }

    /*
     * setradMinashiYokaigoKubun
     * @param radMinashiYokaigoKubun radMinashiYokaigoKubun
     */
    @JsonProperty("radMinashiYokaigoKubun")
    public void setRadMinashiYokaigoKubun(RadioButton radMinashiYokaigoKubun) {
        this.radMinashiYokaigoKubun = radMinashiYokaigoKubun;
    }

    // </editor-fold>
}
