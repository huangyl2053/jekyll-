package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * DvKensakuJoken のクラスファイル
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvKensakuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShokanServiceTeikyoYM")
    private TextBoxDateRange txtShokanServiceTeikyoYM;
    @JsonProperty("ddlShokanShoriJokyo")
    private DropDownList ddlShokanShoriJokyo;
    @JsonProperty("ddlShokanKetteiJoho")
    private DropDownList ddlShokanKetteiJoho;
    @JsonProperty("radKogakuShiharaisaki")
    private RadioButton radKogakuShiharaisaki;
    @JsonProperty("txtShokanShinseiDate")
    private TextBoxDateRange txtShokanShinseiDate;
    @JsonProperty("txtShokanHokenshaKetteiDate")
    private TextBoxDateRange txtShokanHokenshaKetteiDate;
    @JsonProperty("txtShokanKetteiDate")
    private TextBoxDateRange txtShokanKetteiDate;
    @JsonProperty("txtShokanKokuhorenSofuYM")
    private TextBoxDateRange txtShokanKokuhorenSofuYM;
    @JsonProperty("ccdKogakuKinyuKikan")
    private KinyuKikanInputDiv ccdKogakuKinyuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShokanServiceTeikyoYM
     * @return txtShokanServiceTeikyoYM
     */
    @JsonProperty("txtShokanServiceTeikyoYM")
    public TextBoxDateRange getTxtShokanServiceTeikyoYM() {
        return txtShokanServiceTeikyoYM;
    }

    /*
     * settxtShokanServiceTeikyoYM
     * @param txtShokanServiceTeikyoYM txtShokanServiceTeikyoYM
     */
    @JsonProperty("txtShokanServiceTeikyoYM")
    public void setTxtShokanServiceTeikyoYM(TextBoxDateRange txtShokanServiceTeikyoYM) {
        this.txtShokanServiceTeikyoYM = txtShokanServiceTeikyoYM;
    }

    /*
     * getddlShokanShoriJokyo
     * @return ddlShokanShoriJokyo
     */
    @JsonProperty("ddlShokanShoriJokyo")
    public DropDownList getDdlShokanShoriJokyo() {
        return ddlShokanShoriJokyo;
    }

    /*
     * setddlShokanShoriJokyo
     * @param ddlShokanShoriJokyo ddlShokanShoriJokyo
     */
    @JsonProperty("ddlShokanShoriJokyo")
    public void setDdlShokanShoriJokyo(DropDownList ddlShokanShoriJokyo) {
        this.ddlShokanShoriJokyo = ddlShokanShoriJokyo;
    }

    /*
     * getddlShokanKetteiJoho
     * @return ddlShokanKetteiJoho
     */
    @JsonProperty("ddlShokanKetteiJoho")
    public DropDownList getDdlShokanKetteiJoho() {
        return ddlShokanKetteiJoho;
    }

    /*
     * setddlShokanKetteiJoho
     * @param ddlShokanKetteiJoho ddlShokanKetteiJoho
     */
    @JsonProperty("ddlShokanKetteiJoho")
    public void setDdlShokanKetteiJoho(DropDownList ddlShokanKetteiJoho) {
        this.ddlShokanKetteiJoho = ddlShokanKetteiJoho;
    }

    /*
     * getradKogakuShiharaisaki
     * @return radKogakuShiharaisaki
     */
    @JsonProperty("radKogakuShiharaisaki")
    public RadioButton getRadKogakuShiharaisaki() {
        return radKogakuShiharaisaki;
    }

    /*
     * setradKogakuShiharaisaki
     * @param radKogakuShiharaisaki radKogakuShiharaisaki
     */
    @JsonProperty("radKogakuShiharaisaki")
    public void setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.radKogakuShiharaisaki = radKogakuShiharaisaki;
    }

    /*
     * gettxtShokanShinseiDate
     * @return txtShokanShinseiDate
     */
    @JsonProperty("txtShokanShinseiDate")
    public TextBoxDateRange getTxtShokanShinseiDate() {
        return txtShokanShinseiDate;
    }

    /*
     * settxtShokanShinseiDate
     * @param txtShokanShinseiDate txtShokanShinseiDate
     */
    @JsonProperty("txtShokanShinseiDate")
    public void setTxtShokanShinseiDate(TextBoxDateRange txtShokanShinseiDate) {
        this.txtShokanShinseiDate = txtShokanShinseiDate;
    }

    /*
     * gettxtShokanHokenshaKetteiDate
     * @return txtShokanHokenshaKetteiDate
     */
    @JsonProperty("txtShokanHokenshaKetteiDate")
    public TextBoxDateRange getTxtShokanHokenshaKetteiDate() {
        return txtShokanHokenshaKetteiDate;
    }

    /*
     * settxtShokanHokenshaKetteiDate
     * @param txtShokanHokenshaKetteiDate txtShokanHokenshaKetteiDate
     */
    @JsonProperty("txtShokanHokenshaKetteiDate")
    public void setTxtShokanHokenshaKetteiDate(TextBoxDateRange txtShokanHokenshaKetteiDate) {
        this.txtShokanHokenshaKetteiDate = txtShokanHokenshaKetteiDate;
    }

    /*
     * gettxtShokanKetteiDate
     * @return txtShokanKetteiDate
     */
    @JsonProperty("txtShokanKetteiDate")
    public TextBoxDateRange getTxtShokanKetteiDate() {
        return txtShokanKetteiDate;
    }

    /*
     * settxtShokanKetteiDate
     * @param txtShokanKetteiDate txtShokanKetteiDate
     */
    @JsonProperty("txtShokanKetteiDate")
    public void setTxtShokanKetteiDate(TextBoxDateRange txtShokanKetteiDate) {
        this.txtShokanKetteiDate = txtShokanKetteiDate;
    }

    /*
     * gettxtShokanKokuhorenSofuYM
     * @return txtShokanKokuhorenSofuYM
     */
    @JsonProperty("txtShokanKokuhorenSofuYM")
    public TextBoxDateRange getTxtShokanKokuhorenSofuYM() {
        return txtShokanKokuhorenSofuYM;
    }

    /*
     * settxtShokanKokuhorenSofuYM
     * @param txtShokanKokuhorenSofuYM txtShokanKokuhorenSofuYM
     */
    @JsonProperty("txtShokanKokuhorenSofuYM")
    public void setTxtShokanKokuhorenSofuYM(TextBoxDateRange txtShokanKokuhorenSofuYM) {
        this.txtShokanKokuhorenSofuYM = txtShokanKokuhorenSofuYM;
    }

    /*
     * getccdKogakuKinyuKikan
     * @return ccdKogakuKinyuKikan
     */
    @JsonProperty("ccdKogakuKinyuKikan")
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return ccdKogakuKinyuKikan;
    }

    // </editor-fold>
}
