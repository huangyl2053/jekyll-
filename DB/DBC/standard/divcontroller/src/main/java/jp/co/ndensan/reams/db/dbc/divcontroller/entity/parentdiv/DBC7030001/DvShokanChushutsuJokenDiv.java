package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvShokanChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvKensakuJoken")
    private DvKensakuJokenDiv DvKensakuJoken;
    @JsonProperty("dvYoshikiNo")
    private dvYoshikiNoDiv dvYoshikiNo;
    @JsonProperty("ccdShokanHokenshaList")
    private HokenshaListDiv ccdShokanHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvKensakuJoken
     * @return DvKensakuJoken
     */
    @JsonProperty("DvKensakuJoken")
    public DvKensakuJokenDiv getDvKensakuJoken() {
        return DvKensakuJoken;
    }

    /*
     * setDvKensakuJoken
     * @param DvKensakuJoken DvKensakuJoken
     */
    @JsonProperty("DvKensakuJoken")
    public void setDvKensakuJoken(DvKensakuJokenDiv DvKensakuJoken) {
        this.DvKensakuJoken = DvKensakuJoken;
    }

    /*
     * getdvYoshikiNo
     * @return dvYoshikiNo
     */
    @JsonProperty("dvYoshikiNo")
    public dvYoshikiNoDiv getDvYoshikiNo() {
        return dvYoshikiNo;
    }

    /*
     * setdvYoshikiNo
     * @param dvYoshikiNo dvYoshikiNo
     */
    @JsonProperty("dvYoshikiNo")
    public void setDvYoshikiNo(dvYoshikiNoDiv dvYoshikiNo) {
        this.dvYoshikiNo = dvYoshikiNo;
    }

    /*
     * getccdShokanHokenshaList
     * @return ccdShokanHokenshaList
     */
    @JsonProperty("ccdShokanHokenshaList")
    public IHokenshaListDiv getCcdShokanHokenshaList() {
        return ccdShokanHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtShokanServiceTeikyoYM() {
        return this.getDvKensakuJoken().getTxtShokanServiceTeikyoYM();
    }

    @JsonIgnore
    public void setTxtShokanServiceTeikyoYM(TextBoxDateRange txtShokanServiceTeikyoYM) {
        this.getDvKensakuJoken().setTxtShokanServiceTeikyoYM(txtShokanServiceTeikyoYM);
    }

    @JsonIgnore
    public DropDownList getDdlShokanShoriJokyo() {
        return this.getDvKensakuJoken().getDdlShokanShoriJokyo();
    }

    @JsonIgnore
    public void setDdlShokanShoriJokyo(DropDownList ddlShokanShoriJokyo) {
        this.getDvKensakuJoken().setDdlShokanShoriJokyo(ddlShokanShoriJokyo);
    }

    @JsonIgnore
    public DropDownList getDdlShokanKetteiJoho() {
        return this.getDvKensakuJoken().getDdlShokanKetteiJoho();
    }

    @JsonIgnore
    public void setDdlShokanKetteiJoho(DropDownList ddlShokanKetteiJoho) {
        this.getDvKensakuJoken().setDdlShokanKetteiJoho(ddlShokanKetteiJoho);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShiharaisaki() {
        return this.getDvKensakuJoken().getRadKogakuShiharaisaki();
    }

    @JsonIgnore
    public void setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.getDvKensakuJoken().setRadKogakuShiharaisaki(radKogakuShiharaisaki);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanShinseiDate() {
        return this.getDvKensakuJoken().getTxtShokanShinseiDate();
    }

    @JsonIgnore
    public void setTxtShokanShinseiDate(TextBoxDateRange txtShokanShinseiDate) {
        this.getDvKensakuJoken().setTxtShokanShinseiDate(txtShokanShinseiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanHokenshaKetteiDate() {
        return this.getDvKensakuJoken().getTxtShokanHokenshaKetteiDate();
    }

    @JsonIgnore
    public void setTxtShokanHokenshaKetteiDate(TextBoxDateRange txtShokanHokenshaKetteiDate) {
        this.getDvKensakuJoken().setTxtShokanHokenshaKetteiDate(txtShokanHokenshaKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanKetteiDate() {
        return this.getDvKensakuJoken().getTxtShokanKetteiDate();
    }

    @JsonIgnore
    public void setTxtShokanKetteiDate(TextBoxDateRange txtShokanKetteiDate) {
        this.getDvKensakuJoken().setTxtShokanKetteiDate(txtShokanKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanKokuhorenSofuYM() {
        return this.getDvKensakuJoken().getTxtShokanKokuhorenSofuYM();
    }

    @JsonIgnore
    public void setTxtShokanKokuhorenSofuYM(TextBoxDateRange txtShokanKokuhorenSofuYM) {
        this.getDvKensakuJoken().setTxtShokanKokuhorenSofuYM(txtShokanKokuhorenSofuYM);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return this.getDvKensakuJoken().getCcdKogakuKinyuKikan();
    }

    @JsonIgnore
    public Button getBtnShokanKaigo() {
        return this.getDvYoshikiNo().getBtnShokanKaigo();
    }

    @JsonIgnore
    public void setBtnShokanKaigo(Button btnShokanKaigo) {
        this.getDvYoshikiNo().setBtnShokanKaigo(btnShokanKaigo);
    }

    @JsonIgnore
    public Button getBtnYobo() {
        return this.getDvYoshikiNo().getBtnYobo();
    }

    @JsonIgnore
    public void setBtnYobo(Button btnYobo) {
        this.getDvYoshikiNo().setBtnYobo(btnYobo);
    }

    @JsonIgnore
    public DataGrid<dgYoshikiNo_Row> getDgYoshikiNo() {
        return this.getDvYoshikiNo().getDgYoshikiNo();
    }

    @JsonIgnore
    public void setDgYoshikiNo(DataGrid<dgYoshikiNo_Row> dgYoshikiNo) {
        this.getDvYoshikiNo().setDgYoshikiNo(dgYoshikiNo);
    }

    // </editor-fold>
}
