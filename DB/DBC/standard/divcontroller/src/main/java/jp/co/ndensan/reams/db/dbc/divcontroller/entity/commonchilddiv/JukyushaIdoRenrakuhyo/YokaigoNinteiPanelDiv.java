package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * YokaigoNinteiPanel のクラスファイル
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public class YokaigoNinteiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxFlexibleDate txtShinseiYMD;
    @JsonProperty("radShinseiShubetsu")
    private RadioButton radShinseiShubetsu;
    @JsonProperty("btnYokaigoninteiRireki")
    private ButtonDialog btnYokaigoninteiRireki;
    @JsonProperty("ddlYokaigoJotaiKubun")
    private DropDownList ddlYokaigoJotaiKubun;
    @JsonProperty("radHenkoShinseichuKubun")
    private RadioButton radHenkoShinseichuKubun;
    @JsonProperty("txtNinteiYukoKikanYMD")
    private TextBoxDateRange txtNinteiYukoKikanYMD;
    @JsonProperty("radMinashiYokaigoJotaiKubun")
    private RadioButton radMinashiYokaigoJotaiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getradShinseiShubetsu
     * @return radShinseiShubetsu
     */
    @JsonProperty("radShinseiShubetsu")
    public RadioButton getRadShinseiShubetsu() {
        return radShinseiShubetsu;
    }

    /*
     * setradShinseiShubetsu
     * @param radShinseiShubetsu radShinseiShubetsu
     */
    @JsonProperty("radShinseiShubetsu")
    public void setRadShinseiShubetsu(RadioButton radShinseiShubetsu) {
        this.radShinseiShubetsu = radShinseiShubetsu;
    }

    /*
     * getbtnYokaigoninteiRireki
     * @return btnYokaigoninteiRireki
     */
    @JsonProperty("btnYokaigoninteiRireki")
    public ButtonDialog getBtnYokaigoninteiRireki() {
        return btnYokaigoninteiRireki;
    }

    /*
     * setbtnYokaigoninteiRireki
     * @param btnYokaigoninteiRireki btnYokaigoninteiRireki
     */
    @JsonProperty("btnYokaigoninteiRireki")
    public void setBtnYokaigoninteiRireki(ButtonDialog btnYokaigoninteiRireki) {
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
     * gettxtNinteiYukoKikanYMD
     * @return txtNinteiYukoKikanYMD
     */
    @JsonProperty("txtNinteiYukoKikanYMD")
    public TextBoxDateRange getTxtNinteiYukoKikanYMD() {
        return txtNinteiYukoKikanYMD;
    }

    /*
     * settxtNinteiYukoKikanYMD
     * @param txtNinteiYukoKikanYMD txtNinteiYukoKikanYMD
     */
    @JsonProperty("txtNinteiYukoKikanYMD")
    public void setTxtNinteiYukoKikanYMD(TextBoxDateRange txtNinteiYukoKikanYMD) {
        this.txtNinteiYukoKikanYMD = txtNinteiYukoKikanYMD;
    }

    /*
     * getradMinashiYokaigoJotaiKubun
     * @return radMinashiYokaigoJotaiKubun
     */
    @JsonProperty("radMinashiYokaigoJotaiKubun")
    public RadioButton getRadMinashiYokaigoJotaiKubun() {
        return radMinashiYokaigoJotaiKubun;
    }

    /*
     * setradMinashiYokaigoJotaiKubun
     * @param radMinashiYokaigoJotaiKubun radMinashiYokaigoJotaiKubun
     */
    @JsonProperty("radMinashiYokaigoJotaiKubun")
    public void setRadMinashiYokaigoJotaiKubun(RadioButton radMinashiYokaigoJotaiKubun) {
        this.radMinashiYokaigoJotaiKubun = radMinashiYokaigoJotaiKubun;
    }

    // </editor-fold>
}
