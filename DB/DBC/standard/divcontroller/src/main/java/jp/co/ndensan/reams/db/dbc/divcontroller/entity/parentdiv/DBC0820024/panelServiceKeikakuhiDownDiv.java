package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelServiceKeikakuhiDown のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelServiceKeikakuhiDownDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShiteiJigyoshaKubunCode")
    private DropDownList ddlShiteiJigyoshaKubunCode;
    @JsonProperty("txtTodokedeDate")
    private TextBoxDate txtTodokedeDate;
    @JsonProperty("rdoShinsaHouhou")
    private RadioButton rdoShinsaHouhou;
    @JsonProperty("txtTanyiDown")
    private TextBoxNum txtTanyiDown;
    @JsonProperty("txtTanyisuTanka")
    private TextBoxNum txtTanyisuTanka;
    @JsonProperty("btnkeisan")
    private Button btnkeisan;
    @JsonProperty("txtSeikyugakuDown")
    private TextBoxNum txtSeikyugakuDown;
    @JsonProperty("txtTantoukayigoshien")
    private TextBoxCode txtTantoukayigoshien;
    @JsonProperty("txtTekiyo")
    private TextBox txtTekiyo;
    @JsonProperty("ccdServiceCodeInput2")
    private ServiceCodeInputCommonChildDivDiv ccdServiceCodeInput2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShiteiJigyoshaKubunCode
     * @return ddlShiteiJigyoshaKubunCode
     */
    @JsonProperty("ddlShiteiJigyoshaKubunCode")
    public DropDownList getDdlShiteiJigyoshaKubunCode() {
        return ddlShiteiJigyoshaKubunCode;
    }

    /*
     * setddlShiteiJigyoshaKubunCode
     * @param ddlShiteiJigyoshaKubunCode ddlShiteiJigyoshaKubunCode
     */
    @JsonProperty("ddlShiteiJigyoshaKubunCode")
    public void setDdlShiteiJigyoshaKubunCode(DropDownList ddlShiteiJigyoshaKubunCode) {
        this.ddlShiteiJigyoshaKubunCode = ddlShiteiJigyoshaKubunCode;
    }

    /*
     * gettxtTodokedeDate
     * @return txtTodokedeDate
     */
    @JsonProperty("txtTodokedeDate")
    public TextBoxDate getTxtTodokedeDate() {
        return txtTodokedeDate;
    }

    /*
     * settxtTodokedeDate
     * @param txtTodokedeDate txtTodokedeDate
     */
    @JsonProperty("txtTodokedeDate")
    public void setTxtTodokedeDate(TextBoxDate txtTodokedeDate) {
        this.txtTodokedeDate = txtTodokedeDate;
    }

    /*
     * getrdoShinsaHouhou
     * @return rdoShinsaHouhou
     */
    @JsonProperty("rdoShinsaHouhou")
    public RadioButton getRdoShinsaHouhou() {
        return rdoShinsaHouhou;
    }

    /*
     * setrdoShinsaHouhou
     * @param rdoShinsaHouhou rdoShinsaHouhou
     */
    @JsonProperty("rdoShinsaHouhou")
    public void setRdoShinsaHouhou(RadioButton rdoShinsaHouhou) {
        this.rdoShinsaHouhou = rdoShinsaHouhou;
    }

    /*
     * gettxtTanyiDown
     * @return txtTanyiDown
     */
    @JsonProperty("txtTanyiDown")
    public TextBoxNum getTxtTanyiDown() {
        return txtTanyiDown;
    }

    /*
     * settxtTanyiDown
     * @param txtTanyiDown txtTanyiDown
     */
    @JsonProperty("txtTanyiDown")
    public void setTxtTanyiDown(TextBoxNum txtTanyiDown) {
        this.txtTanyiDown = txtTanyiDown;
    }

    /*
     * gettxtTanyisuTanka
     * @return txtTanyisuTanka
     */
    @JsonProperty("txtTanyisuTanka")
    public TextBoxNum getTxtTanyisuTanka() {
        return txtTanyisuTanka;
    }

    /*
     * settxtTanyisuTanka
     * @param txtTanyisuTanka txtTanyisuTanka
     */
    @JsonProperty("txtTanyisuTanka")
    public void setTxtTanyisuTanka(TextBoxNum txtTanyisuTanka) {
        this.txtTanyisuTanka = txtTanyisuTanka;
    }

    /*
     * getbtnkeisan
     * @return btnkeisan
     */
    @JsonProperty("btnkeisan")
    public Button getBtnkeisan() {
        return btnkeisan;
    }

    /*
     * setbtnkeisan
     * @param btnkeisan btnkeisan
     */
    @JsonProperty("btnkeisan")
    public void setBtnkeisan(Button btnkeisan) {
        this.btnkeisan = btnkeisan;
    }

    /*
     * gettxtSeikyugakuDown
     * @return txtSeikyugakuDown
     */
    @JsonProperty("txtSeikyugakuDown")
    public TextBoxNum getTxtSeikyugakuDown() {
        return txtSeikyugakuDown;
    }

    /*
     * settxtSeikyugakuDown
     * @param txtSeikyugakuDown txtSeikyugakuDown
     */
    @JsonProperty("txtSeikyugakuDown")
    public void setTxtSeikyugakuDown(TextBoxNum txtSeikyugakuDown) {
        this.txtSeikyugakuDown = txtSeikyugakuDown;
    }

    /*
     * gettxtTantoukayigoshien
     * @return txtTantoukayigoshien
     */
    @JsonProperty("txtTantoukayigoshien")
    public TextBoxCode getTxtTantoukayigoshien() {
        return txtTantoukayigoshien;
    }

    /*
     * settxtTantoukayigoshien
     * @param txtTantoukayigoshien txtTantoukayigoshien
     */
    @JsonProperty("txtTantoukayigoshien")
    public void setTxtTantoukayigoshien(TextBoxCode txtTantoukayigoshien) {
        this.txtTantoukayigoshien = txtTantoukayigoshien;
    }

    /*
     * gettxtTekiyo
     * @return txtTekiyo
     */
    @JsonProperty("txtTekiyo")
    public TextBox getTxtTekiyo() {
        return txtTekiyo;
    }

    /*
     * settxtTekiyo
     * @param txtTekiyo txtTekiyo
     */
    @JsonProperty("txtTekiyo")
    public void setTxtTekiyo(TextBox txtTekiyo) {
        this.txtTekiyo = txtTekiyo;
    }

    /*
     * getccdServiceCodeInput2
     * @return ccdServiceCodeInput2
     */
    @JsonProperty("ccdServiceCodeInput2")
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput2() {
        return ccdServiceCodeInput2;
    }

    // </editor-fold>
}
