package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KennsakuJyokenn のクラスファイル
 *
 * @reamsid_L DBA-0140-010 houtianpeng
 */
public class KennsakuJyokennDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJIgyoshaNo")
    private TextBox txtJIgyoshaNo;
    @JsonProperty("txtYukouKaishibi")
    private TextBoxDateRange txtYukouKaishibi;
    @JsonProperty("txtJigyoshamei")
    private TextBox txtJigyoshamei;
    @JsonProperty("ddlKennsakuKubun")
    private DropDownList ddlKennsakuKubun;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("ServiceJigyosha")
    private ServiceJigyoshaDiv ServiceJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJIgyoshaNo
     * @return txtJIgyoshaNo
     */
    @JsonProperty("txtJIgyoshaNo")
    public TextBox getTxtJIgyoshaNo() {
        return txtJIgyoshaNo;
    }

    /*
     * settxtJIgyoshaNo
     * @param txtJIgyoshaNo txtJIgyoshaNo
     */
    @JsonProperty("txtJIgyoshaNo")
    public void setTxtJIgyoshaNo(TextBox txtJIgyoshaNo) {
        this.txtJIgyoshaNo = txtJIgyoshaNo;
    }

    /*
     * gettxtYukouKaishibi
     * @return txtYukouKaishibi
     */
    @JsonProperty("txtYukouKaishibi")
    public TextBoxDateRange getTxtYukouKaishibi() {
        return txtYukouKaishibi;
    }

    /*
     * settxtYukouKaishibi
     * @param txtYukouKaishibi txtYukouKaishibi
     */
    @JsonProperty("txtYukouKaishibi")
    public void setTxtYukouKaishibi(TextBoxDateRange txtYukouKaishibi) {
        this.txtYukouKaishibi = txtYukouKaishibi;
    }

    /*
     * gettxtJigyoshamei
     * @return txtJigyoshamei
     */
    @JsonProperty("txtJigyoshamei")
    public TextBox getTxtJigyoshamei() {
        return txtJigyoshamei;
    }

    /*
     * settxtJigyoshamei
     * @param txtJigyoshamei txtJigyoshamei
     */
    @JsonProperty("txtJigyoshamei")
    public void setTxtJigyoshamei(TextBox txtJigyoshamei) {
        this.txtJigyoshamei = txtJigyoshamei;
    }

    /*
     * getddlKennsakuKubun
     * @return ddlKennsakuKubun
     */
    @JsonProperty("ddlKennsakuKubun")
    public DropDownList getDdlKennsakuKubun() {
        return ddlKennsakuKubun;
    }

    /*
     * setddlKennsakuKubun
     * @param ddlKennsakuKubun ddlKennsakuKubun
     */
    @JsonProperty("ddlKennsakuKubun")
    public void setDdlKennsakuKubun(DropDownList ddlKennsakuKubun) {
        this.ddlKennsakuKubun = ddlKennsakuKubun;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * getServiceJigyosha
     * @return ServiceJigyosha
     */
    @JsonProperty("ServiceJigyosha")
    public ServiceJigyoshaDiv getServiceJigyosha() {
        return ServiceJigyosha;
    }

    /*
     * setServiceJigyosha
     * @param ServiceJigyosha ServiceJigyosha
     */
    @JsonProperty("ServiceJigyosha")
    public void setServiceJigyosha(ServiceJigyoshaDiv ServiceJigyosha) {
        this.ServiceJigyosha = ServiceJigyosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKennCode() {
        return this.getServiceJigyosha().getDdlKennCode();
    }

    @JsonIgnore
    public void setDdlKennCode(DropDownList ddlKennCode) {
        this.getServiceJigyosha().setDdlKennCode(ddlKennCode);
    }

    @JsonIgnore
    public DropDownList getDdlJigyoshaKubun() {
        return this.getServiceJigyosha().getDdlJigyoshaKubun();
    }

    @JsonIgnore
    public void setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.getServiceJigyosha().setDdlJigyoshaKubun(ddlJigyoshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlGunshiCode() {
        return this.getServiceJigyosha().getDdlGunshiCode();
    }

    @JsonIgnore
    public void setDdlGunshiCode(DropDownList ddlGunshiCode) {
        this.getServiceJigyosha().setDdlGunshiCode(ddlGunshiCode);
    }

    @JsonIgnore
    public DropDownList getDdlServiceShurui() {
        return this.getServiceJigyosha().getDdlServiceShurui();
    }

    @JsonIgnore
    public void setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.getServiceJigyosha().setDdlServiceShurui(ddlServiceShurui);
    }

    // </editor-fold>
}
