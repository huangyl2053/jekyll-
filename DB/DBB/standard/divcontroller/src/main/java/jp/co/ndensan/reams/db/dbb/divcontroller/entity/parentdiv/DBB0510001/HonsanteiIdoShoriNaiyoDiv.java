package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * HonsanteiIdoShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class HonsanteiIdoShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxYear txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBoxYear txtFukaNendo;
    @JsonProperty("ddlShoritsuki")
    private DropDownList ddlShoritsuki;
    @JsonProperty("radShoriTaisho")
    private RadioButton radShoriTaisho;
    @JsonProperty("ddlTokuchoTeishiSelect")
    private DropDownList ddlTokuchoTeishiSelect;

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
    public TextBoxYear getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxYear getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxYear txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * getddlShoritsuki
     * @return ddlShoritsuki
     */
    @JsonProperty("ddlShoritsuki")
    public DropDownList getDdlShoritsuki() {
        return ddlShoritsuki;
    }

    /*
     * setddlShoritsuki
     * @param ddlShoritsuki ddlShoritsuki
     */
    @JsonProperty("ddlShoritsuki")
    public void setDdlShoritsuki(DropDownList ddlShoritsuki) {
        this.ddlShoritsuki = ddlShoritsuki;
    }

    /*
     * getradShoriTaisho
     * @return radShoriTaisho
     */
    @JsonProperty("radShoriTaisho")
    public RadioButton getRadShoriTaisho() {
        return radShoriTaisho;
    }

    /*
     * setradShoriTaisho
     * @param radShoriTaisho radShoriTaisho
     */
    @JsonProperty("radShoriTaisho")
    public void setRadShoriTaisho(RadioButton radShoriTaisho) {
        this.radShoriTaisho = radShoriTaisho;
    }

    /*
     * getddlTokuchoTeishiSelect
     * @return ddlTokuchoTeishiSelect
     */
    @JsonProperty("ddlTokuchoTeishiSelect")
    public DropDownList getDdlTokuchoTeishiSelect() {
        return ddlTokuchoTeishiSelect;
    }

    /*
     * setddlTokuchoTeishiSelect
     * @param ddlTokuchoTeishiSelect ddlTokuchoTeishiSelect
     */
    @JsonProperty("ddlTokuchoTeishiSelect")
    public void setDdlTokuchoTeishiSelect(DropDownList ddlTokuchoTeishiSelect) {
        this.ddlTokuchoTeishiSelect = ddlTokuchoTeishiSelect;
    }

    // </editor-fold>
}
