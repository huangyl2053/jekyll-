package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku1Input.Chiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku1Input.IChiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku3Input.Chiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku3Input.IChiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNumRange;

/**
 * HanyoListAtenaSelect のクラスファイル
 *
 * @author 自動生成
 */
public class HanyoListAtenaSelectDiv extends Panel implements IHanyoListAtenaSelectDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvAtena")
    private DvAtenaDiv DvAtena;
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    private RString hdnTxtDonyuKeitaiCode;
    @JsonProperty("hdnTxtIsMultiSelected")
    private RString hdnTxtIsMultiSelected;
    @JsonProperty("hdnTxtChikuShubetsu")
    private RString hdnTxtChikuShubetsu;
    @JsonProperty("hdnMapMultiSelect")
    private RString hdnMapMultiSelect;
    @JsonProperty("hdnTxtTitle")
    private RString hdnTxtTitle;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvAtena
     * @return DvAtena
     */
    @JsonProperty("DvAtena")
    public DvAtenaDiv getDvAtena() {
        return DvAtena;
    }

    /*
     * setDvAtena
     * @param DvAtena DvAtena
     */
    @JsonProperty("DvAtena")
    public void setDvAtena(DvAtenaDiv DvAtena) {
        this.DvAtena = DvAtena;
    }

    /*
     * gethdnTxtDonyuKeitaiCode
     * @return hdnTxtDonyuKeitaiCode
     */
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    public RString getHdnTxtDonyuKeitaiCode() {
        return hdnTxtDonyuKeitaiCode;
    }

    /*
     * sethdnTxtDonyuKeitaiCode
     * @param hdnTxtDonyuKeitaiCode hdnTxtDonyuKeitaiCode
     */
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    public void setHdnTxtDonyuKeitaiCode(RString hdnTxtDonyuKeitaiCode) {
        this.hdnTxtDonyuKeitaiCode = hdnTxtDonyuKeitaiCode;
    }

    /*
     * gethdnTxtIsMultiSelected
     * @return hdnTxtIsMultiSelected
     */
    @JsonProperty("hdnTxtIsMultiSelected")
    public RString getHdnTxtIsMultiSelected() {
        return hdnTxtIsMultiSelected;
    }

    /*
     * sethdnTxtIsMultiSelected
     * @param hdnTxtIsMultiSelected hdnTxtIsMultiSelected
     */
    @JsonProperty("hdnTxtIsMultiSelected")
    public void setHdnTxtIsMultiSelected(RString hdnTxtIsMultiSelected) {
        this.hdnTxtIsMultiSelected = hdnTxtIsMultiSelected;
    }

    /*
     * gethdnTxtChikuShubetsu
     * @return hdnTxtChikuShubetsu
     */
    @JsonProperty("hdnTxtChikuShubetsu")
    public RString getHdnTxtChikuShubetsu() {
        return hdnTxtChikuShubetsu;
    }

    /*
     * sethdnTxtChikuShubetsu
     * @param hdnTxtChikuShubetsu hdnTxtChikuShubetsu
     */
    @JsonProperty("hdnTxtChikuShubetsu")
    public void setHdnTxtChikuShubetsu(RString hdnTxtChikuShubetsu) {
        this.hdnTxtChikuShubetsu = hdnTxtChikuShubetsu;
    }

    /*
     * gethdnMapMultiSelect
     * @return hdnMapMultiSelect
     */
    @JsonProperty("hdnMapMultiSelect")
    public RString getHdnMapMultiSelect() {
        return hdnMapMultiSelect;
    }

    /*
     * sethdnMapMultiSelect
     * @param hdnMapMultiSelect hdnMapMultiSelect
     */
    @JsonProperty("hdnMapMultiSelect")
    public void setHdnMapMultiSelect(RString hdnMapMultiSelect) {
        this.hdnMapMultiSelect = hdnMapMultiSelect;
    }

    /*
     * gethdnTxtTitle
     * @return hdnTxtTitle
     */
    @JsonProperty("hdnTxtTitle")
    public RString getHdnTxtTitle() {
        return hdnTxtTitle;
    }

    /*
     * sethdnTxtTitle
     * @param hdnTxtTitle hdnTxtTitle
     */
    @JsonProperty("hdnTxtTitle")
    public void setHdnTxtTitle(RString hdnTxtTitle) {
        this.hdnTxtTitle = hdnTxtTitle;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DvJokenSelectDiv getDvJokenSelect() {
        return this.getDvAtena().getDvJokenSelect();
    }

    @JsonIgnore
    public void  setDvJokenSelect(DvJokenSelectDiv DvJokenSelect) {
        this.getDvAtena().setDvJokenSelect(DvJokenSelect);
    }

    @JsonIgnore
    public RadioButton getRadSelectKijun() {
        return this.getDvAtena().getDvJokenSelect().getRadSelectKijun();
    }

    @JsonIgnore
    public void  setRadSelectKijun(RadioButton radSelectKijun) {
        this.getDvAtena().getDvJokenSelect().setRadSelectKijun(radSelectKijun);
    }

    @JsonIgnore
    public dvKensakuJokenDiv getDvKensakuJoken() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken();
    }

    @JsonIgnore
    public void  setDvKensakuJoken(dvKensakuJokenDiv dvKensakuJoken) {
        this.getDvAtena().getDvJokenSelect().setDvKensakuJoken(dvKensakuJoken);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtNenrei() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().getTxtNenrei();
    }

    @JsonIgnore
    public void  setTxtNenrei(TextBoxNumRange txtNenrei) {
        this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().setTxtNenrei(txtNenrei);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunbi() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().getTxtNenreiKijunbi();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunbi(TextBoxDate txtNenreiKijunbi) {
        this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().setTxtNenreiKijunbi(txtNenreiKijunbi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSeinengappi() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().getTxtSeinengappi();
    }

    @JsonIgnore
    public void  setTxtSeinengappi(TextBoxDateRange txtSeinengappi) {
        this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().setTxtSeinengappi(txtSeinengappi);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getDvAtena().getDvJokenSelect().getCcdHokenshaList();
    }

    @JsonIgnore
    public DvChikuDiv getDvChiku() {
        return this.getDvAtena().getDvChiku();
    }

    @JsonIgnore
    public void  setDvChiku(DvChikuDiv DvChiku) {
        this.getDvAtena().setDvChiku(DvChiku);
    }

    @JsonIgnore
    public DropDownList getDdlChikuSelect() {
        return this.getDvAtena().getDvChiku().getDdlChikuSelect();
    }

    @JsonIgnore
    public void  setDdlChikuSelect(DropDownList ddlChikuSelect) {
        this.getDvAtena().getDvChiku().setDdlChikuSelect(ddlChikuSelect);
    }

    @JsonIgnore
    public Label getLblStart() {
        return this.getDvAtena().getDvChiku().getLblStart();
    }

    @JsonIgnore
    public void  setLblStart(Label lblStart) {
        this.getDvAtena().getDvChiku().setLblStart(lblStart);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJushoFrom() {
        return this.getDvAtena().getDvChiku().getCcdJushoFrom();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuFrom() {
        return this.getDvAtena().getDvChiku().getCcdGyoseikuFrom();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1From() {
        return this.getDvAtena().getDvChiku().getCcdChiku1From();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2From() {
        return this.getDvAtena().getDvChiku().getCcdChiku2From();
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3From() {
        return this.getDvAtena().getDvChiku().getCcdChiku3From();
    }

    @JsonIgnore
    public Label getLblEnd() {
        return this.getDvAtena().getDvChiku().getLblEnd();
    }

    @JsonIgnore
    public void  setLblEnd(Label lblEnd) {
        this.getDvAtena().getDvChiku().setLblEnd(lblEnd);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJushoTo() {
        return this.getDvAtena().getDvChiku().getCcdJushoTo();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuTo() {
        return this.getDvAtena().getDvChiku().getCcdGyoseikuTo();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1To() {
        return this.getDvAtena().getDvChiku().getCcdChiku1To();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2To() {
        return this.getDvAtena().getDvChiku().getCcdChiku2To();
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3To() {
        return this.getDvAtena().getDvChiku().getCcdChiku3To();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
