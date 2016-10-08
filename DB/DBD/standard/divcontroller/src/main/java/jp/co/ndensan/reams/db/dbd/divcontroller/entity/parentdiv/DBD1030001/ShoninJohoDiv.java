package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoninJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoninJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKetteiKubun")
    private RadioButton radKetteiKubun;
    @JsonProperty("txtKetteiYMD")
    private TextBoxFlexibleDate txtKetteiYMD;
    @JsonProperty("txtTekiyoYMD")
    private TextBoxFlexibleDate txtTekiyoYMD;
    @JsonProperty("txtYukoKigenYMD")
    private TextBoxFlexibleDate txtYukoKigenYMD;
    @JsonProperty("chkTokureiTaisho")
    private CheckBoxList chkTokureiTaisho;
    @JsonProperty("ddlKeigenJiyu")
    private DropDownList ddlKeigenJiyu;
    @JsonProperty("txtKeigenRitsuBunshi")
    private TextBoxNum txtKeigenRitsuBunshi;
    @JsonProperty("txtKeigenRitsuBunbo")
    private TextBoxNum txtKeigenRitsuBunbo;
    @JsonProperty("chkKyotakuServiceGentei")
    private CheckBoxList chkKyotakuServiceGentei;
    @JsonProperty("chkKyojuhiShokuhiGentei")
    private CheckBoxList chkKyojuhiShokuhiGentei;
    @JsonProperty("chkKyusochiUnitGataJunKoshitsu")
    private CheckBoxList chkKyusochiUnitGataJunKoshitsu;
    @JsonProperty("txtKakuninNo")
    private TextBoxCode txtKakuninNo;
    @JsonProperty("btnSelectHiShoninRiyu")
    private ButtonDialog btnSelectHiShoninRiyu;
    @JsonProperty("txtHiShoninRiyu")
    private TextBoxMultiLine txtHiShoninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKetteiKubun
     * @return radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public RadioButton getRadKetteiKubun() {
        return radKetteiKubun;
    }

    /*
     * setradKetteiKubun
     * @param radKetteiKubun radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.radKetteiKubun = radKetteiKubun;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * gettxtTekiyoYMD
     * @return txtTekiyoYMD
     */
    @JsonProperty("txtTekiyoYMD")
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return txtTekiyoYMD;
    }

    /*
     * settxtTekiyoYMD
     * @param txtTekiyoYMD txtTekiyoYMD
     */
    @JsonProperty("txtTekiyoYMD")
    public void setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.txtTekiyoYMD = txtTekiyoYMD;
    }

    /*
     * gettxtYukoKigenYMD
     * @return txtYukoKigenYMD
     */
    @JsonProperty("txtYukoKigenYMD")
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return txtYukoKigenYMD;
    }

    /*
     * settxtYukoKigenYMD
     * @param txtYukoKigenYMD txtYukoKigenYMD
     */
    @JsonProperty("txtYukoKigenYMD")
    public void setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.txtYukoKigenYMD = txtYukoKigenYMD;
    }

    /*
     * getchkTokureiTaisho
     * @return chkTokureiTaisho
     */
    @JsonProperty("chkTokureiTaisho")
    public CheckBoxList getChkTokureiTaisho() {
        return chkTokureiTaisho;
    }

    /*
     * setchkTokureiTaisho
     * @param chkTokureiTaisho chkTokureiTaisho
     */
    @JsonProperty("chkTokureiTaisho")
    public void setChkTokureiTaisho(CheckBoxList chkTokureiTaisho) {
        this.chkTokureiTaisho = chkTokureiTaisho;
    }

    /*
     * getddlKeigenJiyu
     * @return ddlKeigenJiyu
     */
    @JsonProperty("ddlKeigenJiyu")
    public DropDownList getDdlKeigenJiyu() {
        return ddlKeigenJiyu;
    }

    /*
     * setddlKeigenJiyu
     * @param ddlKeigenJiyu ddlKeigenJiyu
     */
    @JsonProperty("ddlKeigenJiyu")
    public void setDdlKeigenJiyu(DropDownList ddlKeigenJiyu) {
        this.ddlKeigenJiyu = ddlKeigenJiyu;
    }

    /*
     * gettxtKeigenRitsuBunshi
     * @return txtKeigenRitsuBunshi
     */
    @JsonProperty("txtKeigenRitsuBunshi")
    public TextBoxNum getTxtKeigenRitsuBunshi() {
        return txtKeigenRitsuBunshi;
    }

    /*
     * settxtKeigenRitsuBunshi
     * @param txtKeigenRitsuBunshi txtKeigenRitsuBunshi
     */
    @JsonProperty("txtKeigenRitsuBunshi")
    public void setTxtKeigenRitsuBunshi(TextBoxNum txtKeigenRitsuBunshi) {
        this.txtKeigenRitsuBunshi = txtKeigenRitsuBunshi;
    }

    /*
     * gettxtKeigenRitsuBunbo
     * @return txtKeigenRitsuBunbo
     */
    @JsonProperty("txtKeigenRitsuBunbo")
    public TextBoxNum getTxtKeigenRitsuBunbo() {
        return txtKeigenRitsuBunbo;
    }

    /*
     * settxtKeigenRitsuBunbo
     * @param txtKeigenRitsuBunbo txtKeigenRitsuBunbo
     */
    @JsonProperty("txtKeigenRitsuBunbo")
    public void setTxtKeigenRitsuBunbo(TextBoxNum txtKeigenRitsuBunbo) {
        this.txtKeigenRitsuBunbo = txtKeigenRitsuBunbo;
    }

    /*
     * getchkKyotakuServiceGentei
     * @return chkKyotakuServiceGentei
     */
    @JsonProperty("chkKyotakuServiceGentei")
    public CheckBoxList getChkKyotakuServiceGentei() {
        return chkKyotakuServiceGentei;
    }

    /*
     * setchkKyotakuServiceGentei
     * @param chkKyotakuServiceGentei chkKyotakuServiceGentei
     */
    @JsonProperty("chkKyotakuServiceGentei")
    public void setChkKyotakuServiceGentei(CheckBoxList chkKyotakuServiceGentei) {
        this.chkKyotakuServiceGentei = chkKyotakuServiceGentei;
    }

    /*
     * getchkKyojuhiShokuhiGentei
     * @return chkKyojuhiShokuhiGentei
     */
    @JsonProperty("chkKyojuhiShokuhiGentei")
    public CheckBoxList getChkKyojuhiShokuhiGentei() {
        return chkKyojuhiShokuhiGentei;
    }

    /*
     * setchkKyojuhiShokuhiGentei
     * @param chkKyojuhiShokuhiGentei chkKyojuhiShokuhiGentei
     */
    @JsonProperty("chkKyojuhiShokuhiGentei")
    public void setChkKyojuhiShokuhiGentei(CheckBoxList chkKyojuhiShokuhiGentei) {
        this.chkKyojuhiShokuhiGentei = chkKyojuhiShokuhiGentei;
    }

    /*
     * getchkKyusochiUnitGataJunKoshitsu
     * @return chkKyusochiUnitGataJunKoshitsu
     */
    @JsonProperty("chkKyusochiUnitGataJunKoshitsu")
    public CheckBoxList getChkKyusochiUnitGataJunKoshitsu() {
        return chkKyusochiUnitGataJunKoshitsu;
    }

    /*
     * setchkKyusochiUnitGataJunKoshitsu
     * @param chkKyusochiUnitGataJunKoshitsu chkKyusochiUnitGataJunKoshitsu
     */
    @JsonProperty("chkKyusochiUnitGataJunKoshitsu")
    public void setChkKyusochiUnitGataJunKoshitsu(CheckBoxList chkKyusochiUnitGataJunKoshitsu) {
        this.chkKyusochiUnitGataJunKoshitsu = chkKyusochiUnitGataJunKoshitsu;
    }

    /*
     * gettxtKakuninNo
     * @return txtKakuninNo
     */
    @JsonProperty("txtKakuninNo")
    public TextBoxCode getTxtKakuninNo() {
        return txtKakuninNo;
    }

    /*
     * settxtKakuninNo
     * @param txtKakuninNo txtKakuninNo
     */
    @JsonProperty("txtKakuninNo")
    public void setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.txtKakuninNo = txtKakuninNo;
    }

    /*
     * getbtnSelectHiShoninRiyu
     * @return btnSelectHiShoninRiyu
     */
    @JsonProperty("btnSelectHiShoninRiyu")
    public ButtonDialog getBtnSelectHiShoninRiyu() {
        return btnSelectHiShoninRiyu;
    }

    /*
     * setbtnSelectHiShoninRiyu
     * @param btnSelectHiShoninRiyu btnSelectHiShoninRiyu
     */
    @JsonProperty("btnSelectHiShoninRiyu")
    public void setBtnSelectHiShoninRiyu(ButtonDialog btnSelectHiShoninRiyu) {
        this.btnSelectHiShoninRiyu = btnSelectHiShoninRiyu;
    }

    /*
     * gettxtHiShoninRiyu
     * @return txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return txtHiShoninRiyu;
    }

    /*
     * settxtHiShoninRiyu
     * @param txtHiShoninRiyu txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public void setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.txtHiShoninRiyu = txtHiShoninRiyu;
    }

    // </editor-fold>
}
