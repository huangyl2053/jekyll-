package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * tabShinseiTorokuPanel1 のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class tabShinseiTorokuPanel1Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoShikaku")
    private KaigoShikakuDiv KaigoShikaku;
    @JsonProperty("KaigoHihokensha")
    private KaigoHihokenshaDiv KaigoHihokensha;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoShikaku
     * @return KaigoShikaku
     */
    @JsonProperty("KaigoShikaku")
    public KaigoShikakuDiv getKaigoShikaku() {
        return KaigoShikaku;
    }

    /*
     * setKaigoShikaku
     * @param KaigoShikaku KaigoShikaku
     */
    @JsonProperty("KaigoShikaku")
    public void setKaigoShikaku(KaigoShikakuDiv KaigoShikaku) {
        this.KaigoShikaku = KaigoShikaku;
    }

    /*
     * getKaigoHihokensha
     * @return KaigoHihokensha
     */
    @JsonProperty("KaigoHihokensha")
    public KaigoHihokenshaDiv getKaigoHihokensha() {
        return KaigoHihokensha;
    }

    /*
     * setKaigoHihokensha
     * @param KaigoHihokensha KaigoHihokensha
     */
    @JsonProperty("KaigoHihokensha")
    public void setKaigoHihokensha(KaigoHihokenshaDiv KaigoHihokensha) {
        this.KaigoHihokensha = KaigoHihokensha;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtKanyuKikanYMD() {
        return this.getKaigoShikaku().getTxtKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuKikanYMD(TextBoxDateRange txtKanyuKikanYMD) {
        this.getKaigoShikaku().setTxtKanyuKikanYMD(txtKanyuKikanYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKubun() {
        return this.getKaigoHihokensha().getDdlShotokuKubun();
    }

    @JsonIgnore
    public void setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.getKaigoHihokensha().setDdlShotokuKubun(ddlShotokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlOver70ShotokuKubun() {
        return this.getKaigoHihokensha().getDdlOver70ShotokuKubun();
    }

    @JsonIgnore
    public void setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.getKaigoHihokensha().setDdlOver70ShotokuKubun(ddlOver70ShotokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return this.getKaigoHihokensha().getTxtShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.getKaigoHihokensha().setTxtShikakuSoshitsuYMD(txtShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return this.getKaigoHihokensha().getDdlShikakuSoshitsuJiyu();
    }

    @JsonIgnore
    public void setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.getKaigoHihokensha().setDdlShikakuSoshitsuJiyu(ddlShikakuSoshitsuJiyu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKeisanKikanYMD() {
        return this.getKaigoHihokensha().getTxtTaishoKeisanKikanYMD();
    }

    @JsonIgnore
    public void setTxtTaishoKeisanKikanYMD(TextBoxDateRange txtTaishoKeisanKikanYMD) {
        this.getKaigoHihokensha().setTxtTaishoKeisanKikanYMD(txtTaishoKeisanKikanYMD);
    }

    // </editor-fold>
}
