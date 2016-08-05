package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * ShunoJoho のクラスファイル
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public class ShunoJohoDiv extends Panel implements IShunoJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtTsuchiNo")
    private TextBoxCode txtTsuchiNo;
    @JsonProperty("ddlChoteiNendo")
    private DropDownList ddlChoteiNendo;
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("btnNendoChange")
    private Button btnNendoChange;
    @JsonProperty("ShunoJohoTokucho")
    private ShunoJohoTokuchoDiv ShunoJohoTokucho;
    @JsonProperty("ShunoJohoFucho")
    private ShunoJohoFuchoDiv ShunoJohoFucho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtTsuchiNo
     * @return txtTsuchiNo
     */
    @JsonProperty("txtTsuchiNo")
    public TextBoxCode getTxtTsuchiNo() {
        return txtTsuchiNo;
    }

    /*
     * settxtTsuchiNo
     * @param txtTsuchiNo txtTsuchiNo
     */
    @JsonProperty("txtTsuchiNo")
    public void setTxtTsuchiNo(TextBoxCode txtTsuchiNo) {
        this.txtTsuchiNo = txtTsuchiNo;
    }

    /*
     * getddlChoteiNendo
     * @return ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public DropDownList getDdlChoteiNendo() {
        return ddlChoteiNendo;
    }

    /*
     * setddlChoteiNendo
     * @param ddlChoteiNendo ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public void setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.ddlChoteiNendo = ddlChoteiNendo;
    }

    /*
     * getddlFukaNendo
     * @return ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    /*
     * setddlFukaNendo
     * @param ddlFukaNendo ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo = ddlFukaNendo;
    }

    /*
     * getbtnNendoChange
     * @return btnNendoChange
     */
    @JsonProperty("btnNendoChange")
    public Button getBtnNendoChange() {
        return btnNendoChange;
    }

    /*
     * setbtnNendoChange
     * @param btnNendoChange btnNendoChange
     */
    @JsonProperty("btnNendoChange")
    public void setBtnNendoChange(Button btnNendoChange) {
        this.btnNendoChange = btnNendoChange;
    }

    /*
     * getShunoJohoTokucho
     * @return ShunoJohoTokucho
     */
    @JsonProperty("ShunoJohoTokucho")
    public ShunoJohoTokuchoDiv getShunoJohoTokucho() {
        return ShunoJohoTokucho;
    }

    /*
     * setShunoJohoTokucho
     * @param ShunoJohoTokucho ShunoJohoTokucho
     */
    @JsonProperty("ShunoJohoTokucho")
    public void setShunoJohoTokucho(ShunoJohoTokuchoDiv ShunoJohoTokucho) {
        this.ShunoJohoTokucho = ShunoJohoTokucho;
    }

    /*
     * getShunoJohoFucho
     * @return ShunoJohoFucho
     */
    @JsonProperty("ShunoJohoFucho")
    public ShunoJohoFuchoDiv getShunoJohoFucho() {
        return ShunoJohoFucho;
    }

    /*
     * setShunoJohoFucho
     * @param ShunoJohoFucho ShunoJohoFucho
     */
    @JsonProperty("ShunoJohoFucho")
    public void setShunoJohoFucho(ShunoJohoFuchoDiv ShunoJohoFucho) {
        this.ShunoJohoFucho = ShunoJohoFucho;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        getHandler().load(調定年度, 賦課年度, 通知書番号);
    }

    @JsonIgnore
    public ShunoJohoHandler getHandler() {
        return new ShunoJohoHandler(this);
    }
}
