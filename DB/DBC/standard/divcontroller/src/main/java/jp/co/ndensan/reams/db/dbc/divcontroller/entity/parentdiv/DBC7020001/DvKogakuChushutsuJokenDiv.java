package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001;
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
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvKogakuChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvKogakuChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dvKogakuService")
    private dvKogakuServiceDiv dvKogakuService;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdvKogakuService
     * @return dvKogakuService
     */
    @JsonProperty("dvKogakuService")
    public dvKogakuServiceDiv getDvKogakuService() {
        return dvKogakuService;
    }

    /*
     * setdvKogakuService
     * @param dvKogakuService dvKogakuService
     */
    @JsonProperty("dvKogakuService")
    public void setDvKogakuService(dvKogakuServiceDiv dvKogakuService) {
        this.dvKogakuService = dvKogakuService;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtKogakuServiceTeikyoYM() {
        return this.getDvKogakuService().getTxtKogakuServiceTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtKogakuServiceTeikyoYM(TextBoxDateRange txtKogakuServiceTeikyoYM) {
        this.getDvKogakuService().setTxtKogakuServiceTeikyoYM(txtKogakuServiceTeikyoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuShinseiDate() {
        return this.getDvKogakuService().getTxtKogakuShinseiDate();
    }

    @JsonIgnore
    public void  setTxtKogakuShinseiDate(TextBoxDateRange txtKogakuShinseiDate) {
        this.getDvKogakuService().setTxtKogakuShinseiDate(txtKogakuShinseiDate);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuShoriJokyo() {
        return this.getDvKogakuService().getDdlKogakuShoriJokyo();
    }

    @JsonIgnore
    public void  setDdlKogakuShoriJokyo(DropDownList ddlKogakuShoriJokyo) {
        this.getDvKogakuService().setDdlKogakuShoriJokyo(ddlKogakuShoriJokyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuHokenshaKetteiDate() {
        return this.getDvKogakuService().getTxtKogakuHokenshaKetteiDate();
    }

    @JsonIgnore
    public void  setTxtKogakuHokenshaKetteiDate(TextBoxDateRange txtKogakuHokenshaKetteiDate) {
        this.getDvKogakuService().setTxtKogakuHokenshaKetteiDate(txtKogakuHokenshaKetteiDate);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuShinsaHoho() {
        return this.getDvKogakuService().getDdlKogakuShinsaHoho();
    }

    @JsonIgnore
    public void  setDdlKogakuShinsaHoho(DropDownList ddlKogakuShinsaHoho) {
        this.getDvKogakuService().setDdlKogakuShinsaHoho(ddlKogakuShinsaHoho);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKokuhorenKetteiYM() {
        return this.getDvKogakuService().getTxtKogakuKokuhorenKetteiYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKokuhorenKetteiYM(TextBoxDateRange txtKogakuKokuhorenKetteiYM) {
        this.getDvKogakuService().setTxtKogakuKokuhorenKetteiYM(txtKogakuKokuhorenKetteiYM);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuSanteiKijun() {
        return this.getDvKogakuService().getDdlKogakuSanteiKijun();
    }

    @JsonIgnore
    public void  setDdlKogakuSanteiKijun(DropDownList ddlKogakuSanteiKijun) {
        this.getDvKogakuService().setDdlKogakuSanteiKijun(ddlKogakuSanteiKijun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuTaishoshaUketoriYM() {
        return this.getDvKogakuService().getTxtKogakuTaishoshaUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKogakuTaishoshaUketoriYM(TextBoxDateRange txtKogakuTaishoshaUketoriYM) {
        this.getDvKogakuService().setTxtKogakuTaishoshaUketoriYM(txtKogakuTaishoshaUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuKokuhorenFuicchi() {
        return this.getDvKogakuService().getRadKogakuKokuhorenFuicchi();
    }

    @JsonIgnore
    public void  setRadKogakuKokuhorenFuicchi(RadioButton radKogakuKokuhorenFuicchi) {
        this.getDvKogakuService().setRadKogakuKokuhorenFuicchi(radKogakuKokuhorenFuicchi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKokuhorenSofuYM() {
        return this.getDvKogakuService().getTxtKogakuKokuhorenSofuYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKokuhorenSofuYM(TextBoxDateRange txtKogakuKokuhorenSofuYM) {
        this.getDvKogakuService().setTxtKogakuKokuhorenSofuYM(txtKogakuKokuhorenSofuYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuTaishosha() {
        return this.getDvKogakuService().getRadKogakuTaishosha();
    }

    @JsonIgnore
    public void  setRadKogakuTaishosha(RadioButton radKogakuTaishosha) {
        this.getDvKogakuService().setRadKogakuTaishosha(radKogakuTaishosha);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKetteiJohoUketoriYM() {
        return this.getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKetteiJohoUketoriYM(TextBoxDateRange txtKogakuKetteiJohoUketoriYM) {
        this.getDvKogakuService().setTxtKogakuKetteiJohoUketoriYM(txtKogakuKetteiJohoUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShinseiKubun() {
        return this.getDvKogakuService().getRadKogakuShinseiKubun();
    }

    @JsonIgnore
    public void  setRadKogakuShinseiKubun(RadioButton radKogakuShinseiKubun) {
        this.getDvKogakuService().setRadKogakuShinseiKubun(radKogakuShinseiKubun);
    }

    @JsonIgnore
    public Label getLblKogakuShiharai() {
        return this.getDvKogakuService().getLblKogakuShiharai();
    }

    @JsonIgnore
    public void  setLblKogakuShiharai(Label lblKogakuShiharai) {
        this.getDvKogakuService().setLblKogakuShiharai(lblKogakuShiharai);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShiharaisaki() {
        return this.getDvKogakuService().getRadKogakuShiharaisaki();
    }

    @JsonIgnore
    public void  setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.getDvKogakuService().setRadKogakuShiharaisaki(radKogakuShiharaisaki);
    }

    @JsonIgnore
    public Label getLblKogakuKetteiGaku() {
        return this.getDvKogakuService().getLblKogakuKetteiGaku();
    }

    @JsonIgnore
    public void  setLblKogakuKetteiGaku(Label lblKogakuKetteiGaku) {
        this.getDvKogakuService().setLblKogakuKetteiGaku(lblKogakuKetteiGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaNengetsu() {
        return this.getDvKogakuService().getTxtShinsaNengetsu();
    }

    @JsonIgnore
    public void  setTxtShinsaNengetsu(TextBoxDate txtShinsaNengetsu) {
        this.getDvKogakuService().setTxtShinsaNengetsu(txtShinsaNengetsu);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return this.getDvKogakuService().getCcdKogakuKinyuKikan();
    }

    // </editor-fold>
}
