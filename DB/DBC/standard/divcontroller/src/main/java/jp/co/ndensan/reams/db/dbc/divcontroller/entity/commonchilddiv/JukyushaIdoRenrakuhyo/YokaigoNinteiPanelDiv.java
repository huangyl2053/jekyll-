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
 * YokaigoNinteiPanel のクラスファイル
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public class YokaigoNinteiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxFlexibleDate txtShinseiYMD;
    @JsonProperty("spc01")
    private Space spc01;
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
     * getspc01
     * @return spc01
     */
    @JsonProperty("spc01")
    public Space getSpc01() {
        return spc01;
    }

    /*
     * setspc01
     * @param spc01 spc01
     */
    @JsonProperty("spc01")
    public void setSpc01(Space spc01) {
        this.spc01 = spc01;
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
