package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KagoMoshitatePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KagoMoshitatePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HorizontalLine1")
    private HorizontalLine HorizontalLine1;
    @JsonProperty("txtMeisaiJigyoshaNo")
    private TextBoxCode txtMeisaiJigyoshaNo;
    @JsonProperty("txtMeisaiJigyoshaName")
    private TextBox txtMeisaiJigyoshaName;
    @JsonProperty("txtMeisaiMoshitateshaKubun")
    private TextBox txtMeisaiMoshitateshaKubun;
    @JsonProperty("txtMeisaiSendYM")
    private TextBoxDate txtMeisaiSendYM;
    @JsonProperty("txtMeisaiShokisaiHokenshaNo")
    private TextBoxCode txtMeisaiShokisaiHokenshaNo;
    @JsonProperty("txtMeisaiShokisaiHokenshaName")
    private TextBox txtMeisaiShokisaiHokenshaName;
    @JsonProperty("txtMeisaiTeikyoYM")
    private TextBoxDate txtMeisaiTeikyoYM;
    @JsonProperty("txtMeisaiKagoForm")
    private TextBox txtMeisaiKagoForm;
    @JsonProperty("txtMeisaiMoshitateDate")
    private TextBoxDate txtMeisaiMoshitateDate;
    @JsonProperty("ddlMeisaiKagoMoshitateRiyu")
    private DropDownList ddlMeisaiKagoMoshitateRiyu;
    @JsonProperty("chkMeisaiForDogetsuShinsa")
    private CheckBoxList chkMeisaiForDogetsuShinsa;
    @JsonProperty("KokuhirenSaiSofu")
    private CheckBoxList KokuhirenSaiSofu;
    @JsonProperty("CommonKaigoshikakuKihonChildDiv2")
    private KaigoShikakuKihonDiv CommonKaigoshikakuKihonChildDiv2;
    @JsonProperty("CommonKaigpAtenainfoChildDiv1")
    private KaigoAtenaInfoDiv CommonKaigpAtenainfoChildDiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHorizontalLine1
     * @return HorizontalLine1
     */
    @JsonProperty("HorizontalLine1")
    public HorizontalLine getHorizontalLine1() {
        return HorizontalLine1;
    }

    /*
     * setHorizontalLine1
     * @param HorizontalLine1 HorizontalLine1
     */
    @JsonProperty("HorizontalLine1")
    public void setHorizontalLine1(HorizontalLine HorizontalLine1) {
        this.HorizontalLine1 = HorizontalLine1;
    }

    /*
     * gettxtMeisaiJigyoshaNo
     * @return txtMeisaiJigyoshaNo
     */
    @JsonProperty("txtMeisaiJigyoshaNo")
    public TextBoxCode getTxtMeisaiJigyoshaNo() {
        return txtMeisaiJigyoshaNo;
    }

    /*
     * settxtMeisaiJigyoshaNo
     * @param txtMeisaiJigyoshaNo txtMeisaiJigyoshaNo
     */
    @JsonProperty("txtMeisaiJigyoshaNo")
    public void setTxtMeisaiJigyoshaNo(TextBoxCode txtMeisaiJigyoshaNo) {
        this.txtMeisaiJigyoshaNo = txtMeisaiJigyoshaNo;
    }

    /*
     * gettxtMeisaiJigyoshaName
     * @return txtMeisaiJigyoshaName
     */
    @JsonProperty("txtMeisaiJigyoshaName")
    public TextBox getTxtMeisaiJigyoshaName() {
        return txtMeisaiJigyoshaName;
    }

    /*
     * settxtMeisaiJigyoshaName
     * @param txtMeisaiJigyoshaName txtMeisaiJigyoshaName
     */
    @JsonProperty("txtMeisaiJigyoshaName")
    public void setTxtMeisaiJigyoshaName(TextBox txtMeisaiJigyoshaName) {
        this.txtMeisaiJigyoshaName = txtMeisaiJigyoshaName;
    }

    /*
     * gettxtMeisaiMoshitateshaKubun
     * @return txtMeisaiMoshitateshaKubun
     */
    @JsonProperty("txtMeisaiMoshitateshaKubun")
    public TextBox getTxtMeisaiMoshitateshaKubun() {
        return txtMeisaiMoshitateshaKubun;
    }

    /*
     * settxtMeisaiMoshitateshaKubun
     * @param txtMeisaiMoshitateshaKubun txtMeisaiMoshitateshaKubun
     */
    @JsonProperty("txtMeisaiMoshitateshaKubun")
    public void setTxtMeisaiMoshitateshaKubun(TextBox txtMeisaiMoshitateshaKubun) {
        this.txtMeisaiMoshitateshaKubun = txtMeisaiMoshitateshaKubun;
    }

    /*
     * gettxtMeisaiSendYM
     * @return txtMeisaiSendYM
     */
    @JsonProperty("txtMeisaiSendYM")
    public TextBoxDate getTxtMeisaiSendYM() {
        return txtMeisaiSendYM;
    }

    /*
     * settxtMeisaiSendYM
     * @param txtMeisaiSendYM txtMeisaiSendYM
     */
    @JsonProperty("txtMeisaiSendYM")
    public void setTxtMeisaiSendYM(TextBoxDate txtMeisaiSendYM) {
        this.txtMeisaiSendYM = txtMeisaiSendYM;
    }

    /*
     * gettxtMeisaiShokisaiHokenshaNo
     * @return txtMeisaiShokisaiHokenshaNo
     */
    @JsonProperty("txtMeisaiShokisaiHokenshaNo")
    public TextBoxCode getTxtMeisaiShokisaiHokenshaNo() {
        return txtMeisaiShokisaiHokenshaNo;
    }

    /*
     * settxtMeisaiShokisaiHokenshaNo
     * @param txtMeisaiShokisaiHokenshaNo txtMeisaiShokisaiHokenshaNo
     */
    @JsonProperty("txtMeisaiShokisaiHokenshaNo")
    public void setTxtMeisaiShokisaiHokenshaNo(TextBoxCode txtMeisaiShokisaiHokenshaNo) {
        this.txtMeisaiShokisaiHokenshaNo = txtMeisaiShokisaiHokenshaNo;
    }

    /*
     * gettxtMeisaiShokisaiHokenshaName
     * @return txtMeisaiShokisaiHokenshaName
     */
    @JsonProperty("txtMeisaiShokisaiHokenshaName")
    public TextBox getTxtMeisaiShokisaiHokenshaName() {
        return txtMeisaiShokisaiHokenshaName;
    }

    /*
     * settxtMeisaiShokisaiHokenshaName
     * @param txtMeisaiShokisaiHokenshaName txtMeisaiShokisaiHokenshaName
     */
    @JsonProperty("txtMeisaiShokisaiHokenshaName")
    public void setTxtMeisaiShokisaiHokenshaName(TextBox txtMeisaiShokisaiHokenshaName) {
        this.txtMeisaiShokisaiHokenshaName = txtMeisaiShokisaiHokenshaName;
    }

    /*
     * gettxtMeisaiTeikyoYM
     * @return txtMeisaiTeikyoYM
     */
    @JsonProperty("txtMeisaiTeikyoYM")
    public TextBoxDate getTxtMeisaiTeikyoYM() {
        return txtMeisaiTeikyoYM;
    }

    /*
     * settxtMeisaiTeikyoYM
     * @param txtMeisaiTeikyoYM txtMeisaiTeikyoYM
     */
    @JsonProperty("txtMeisaiTeikyoYM")
    public void setTxtMeisaiTeikyoYM(TextBoxDate txtMeisaiTeikyoYM) {
        this.txtMeisaiTeikyoYM = txtMeisaiTeikyoYM;
    }

    /*
     * gettxtMeisaiKagoForm
     * @return txtMeisaiKagoForm
     */
    @JsonProperty("txtMeisaiKagoForm")
    public TextBox getTxtMeisaiKagoForm() {
        return txtMeisaiKagoForm;
    }

    /*
     * settxtMeisaiKagoForm
     * @param txtMeisaiKagoForm txtMeisaiKagoForm
     */
    @JsonProperty("txtMeisaiKagoForm")
    public void setTxtMeisaiKagoForm(TextBox txtMeisaiKagoForm) {
        this.txtMeisaiKagoForm = txtMeisaiKagoForm;
    }

    /*
     * gettxtMeisaiMoshitateDate
     * @return txtMeisaiMoshitateDate
     */
    @JsonProperty("txtMeisaiMoshitateDate")
    public TextBoxDate getTxtMeisaiMoshitateDate() {
        return txtMeisaiMoshitateDate;
    }

    /*
     * settxtMeisaiMoshitateDate
     * @param txtMeisaiMoshitateDate txtMeisaiMoshitateDate
     */
    @JsonProperty("txtMeisaiMoshitateDate")
    public void setTxtMeisaiMoshitateDate(TextBoxDate txtMeisaiMoshitateDate) {
        this.txtMeisaiMoshitateDate = txtMeisaiMoshitateDate;
    }

    /*
     * getddlMeisaiKagoMoshitateRiyu
     * @return ddlMeisaiKagoMoshitateRiyu
     */
    @JsonProperty("ddlMeisaiKagoMoshitateRiyu")
    public DropDownList getDdlMeisaiKagoMoshitateRiyu() {
        return ddlMeisaiKagoMoshitateRiyu;
    }

    /*
     * setddlMeisaiKagoMoshitateRiyu
     * @param ddlMeisaiKagoMoshitateRiyu ddlMeisaiKagoMoshitateRiyu
     */
    @JsonProperty("ddlMeisaiKagoMoshitateRiyu")
    public void setDdlMeisaiKagoMoshitateRiyu(DropDownList ddlMeisaiKagoMoshitateRiyu) {
        this.ddlMeisaiKagoMoshitateRiyu = ddlMeisaiKagoMoshitateRiyu;
    }

    /*
     * getchkMeisaiForDogetsuShinsa
     * @return chkMeisaiForDogetsuShinsa
     */
    @JsonProperty("chkMeisaiForDogetsuShinsa")
    public CheckBoxList getChkMeisaiForDogetsuShinsa() {
        return chkMeisaiForDogetsuShinsa;
    }

    /*
     * setchkMeisaiForDogetsuShinsa
     * @param chkMeisaiForDogetsuShinsa chkMeisaiForDogetsuShinsa
     */
    @JsonProperty("chkMeisaiForDogetsuShinsa")
    public void setChkMeisaiForDogetsuShinsa(CheckBoxList chkMeisaiForDogetsuShinsa) {
        this.chkMeisaiForDogetsuShinsa = chkMeisaiForDogetsuShinsa;
    }

    /*
     * getKokuhirenSaiSofu
     * @return KokuhirenSaiSofu
     */
    @JsonProperty("KokuhirenSaiSofu")
    public CheckBoxList getKokuhirenSaiSofu() {
        return KokuhirenSaiSofu;
    }

    /*
     * setKokuhirenSaiSofu
     * @param KokuhirenSaiSofu KokuhirenSaiSofu
     */
    @JsonProperty("KokuhirenSaiSofu")
    public void setKokuhirenSaiSofu(CheckBoxList KokuhirenSaiSofu) {
        this.KokuhirenSaiSofu = KokuhirenSaiSofu;
    }

    /*
     * getCommonKaigoshikakuKihonChildDiv2
     * @return CommonKaigoshikakuKihonChildDiv2
     */
    @JsonProperty("CommonKaigoshikakuKihonChildDiv2")
    public IKaigoShikakuKihonDiv getCommonKaigoshikakuKihonChildDiv2() {
        return CommonKaigoshikakuKihonChildDiv2;
    }

    /*
     * getCommonKaigpAtenainfoChildDiv1
     * @return CommonKaigpAtenainfoChildDiv1
     */
    @JsonProperty("CommonKaigpAtenainfoChildDiv1")
    public IKaigoAtenaInfoDiv getCommonKaigpAtenainfoChildDiv1() {
        return CommonKaigpAtenainfoChildDiv1;
    }

    // </editor-fold>
}
