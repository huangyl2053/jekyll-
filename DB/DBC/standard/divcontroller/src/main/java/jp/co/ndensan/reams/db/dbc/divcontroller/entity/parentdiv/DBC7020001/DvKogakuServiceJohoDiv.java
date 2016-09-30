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
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvKogakuServiceJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvKogakuServiceJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvKogakuServiceParam")
    private DvKogakuServiceParamDiv DvKogakuServiceParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvKogakuServiceParam
     * @return DvKogakuServiceParam
     */
    @JsonProperty("DvKogakuServiceParam")
    public DvKogakuServiceParamDiv getDvKogakuServiceParam() {
        return DvKogakuServiceParam;
    }

    /*
     * setDvKogakuServiceParam
     * @param DvKogakuServiceParam DvKogakuServiceParam
     */
    @JsonProperty("DvKogakuServiceParam")
    public void setDvKogakuServiceParam(DvKogakuServiceParamDiv DvKogakuServiceParam) {
        this.DvKogakuServiceParam = DvKogakuServiceParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DvJokenFukugenHozonDiv getDvJokenFukugenHozon() {
        return this.getDvKogakuServiceParam().getDvJokenFukugenHozon();
    }

    @JsonIgnore
    public void  setDvJokenFukugenHozon(DvJokenFukugenHozonDiv DvJokenFukugenHozon) {
        this.getDvKogakuServiceParam().setDvJokenFukugenHozon(DvJokenFukugenHozon);
    }

    @JsonIgnore
    public ButtonBatchParameterSave getBtnKogakuParamSave() {
        return this.getDvKogakuServiceParam().getDvJokenFukugenHozon().getBtnKogakuParamSave();
    }

    @JsonIgnore
    public void  setBtnKogakuParamSave(ButtonBatchParameterSave btnKogakuParamSave) {
        this.getDvKogakuServiceParam().getDvJokenFukugenHozon().setBtnKogakuParamSave(btnKogakuParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnKogakuParamRestore() {
        return this.getDvKogakuServiceParam().getDvJokenFukugenHozon().getBtnKogakuParamRestore();
    }

    @JsonIgnore
    public void  setBtnKogakuParamRestore(ButtonBatchParameterRestore btnKogakuParamRestore) {
        this.getDvKogakuServiceParam().getDvJokenFukugenHozon().setBtnKogakuParamRestore(btnKogakuParamRestore);
    }

    @JsonIgnore
    public DvKogakuChushutsuJokenDiv getDvKogakuChushutsuJoken() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken();
    }

    @JsonIgnore
    public void  setDvKogakuChushutsuJoken(DvKogakuChushutsuJokenDiv DvKogakuChushutsuJoken) {
        this.getDvKogakuServiceParam().setDvKogakuChushutsuJoken(DvKogakuChushutsuJoken);
    }

    @JsonIgnore
    public dvKogakuServiceDiv getDvKogakuService() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService();
    }

    @JsonIgnore
    public void  setDvKogakuService(dvKogakuServiceDiv dvKogakuService) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().setDvKogakuService(dvKogakuService);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuServiceTeikyoYM() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtKogakuServiceTeikyoYM(TextBoxDateRange txtKogakuServiceTeikyoYM) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuServiceTeikyoYM(txtKogakuServiceTeikyoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuShinseiDate() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate();
    }

    @JsonIgnore
    public void  setTxtKogakuShinseiDate(TextBoxDateRange txtKogakuShinseiDate) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuShinseiDate(txtKogakuShinseiDate);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuShoriJokyo() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShoriJokyo();
    }

    @JsonIgnore
    public void  setDdlKogakuShoriJokyo(DropDownList ddlKogakuShoriJokyo) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setDdlKogakuShoriJokyo(ddlKogakuShoriJokyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuHokenshaKetteiDate() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate();
    }

    @JsonIgnore
    public void  setTxtKogakuHokenshaKetteiDate(TextBoxDateRange txtKogakuHokenshaKetteiDate) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuHokenshaKetteiDate(txtKogakuHokenshaKetteiDate);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuShinsaHoho() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShinsaHoho();
    }

    @JsonIgnore
    public void  setDdlKogakuShinsaHoho(DropDownList ddlKogakuShinsaHoho) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setDdlKogakuShinsaHoho(ddlKogakuShinsaHoho);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKokuhorenKetteiYM() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKokuhorenKetteiYM(TextBoxDateRange txtKogakuKokuhorenKetteiYM) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuKokuhorenKetteiYM(txtKogakuKokuhorenKetteiYM);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuSanteiKijun() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuSanteiKijun();
    }

    @JsonIgnore
    public void  setDdlKogakuSanteiKijun(DropDownList ddlKogakuSanteiKijun) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setDdlKogakuSanteiKijun(ddlKogakuSanteiKijun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuTaishoshaUketoriYM() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKogakuTaishoshaUketoriYM(TextBoxDateRange txtKogakuTaishoshaUketoriYM) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuTaishoshaUketoriYM(txtKogakuTaishoshaUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuKokuhorenFuicchi() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuKokuhorenFuicchi();
    }

    @JsonIgnore
    public void  setRadKogakuKokuhorenFuicchi(RadioButton radKogakuKokuhorenFuicchi) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuKokuhorenFuicchi(radKogakuKokuhorenFuicchi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKokuhorenSofuYM() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKokuhorenSofuYM(TextBoxDateRange txtKogakuKokuhorenSofuYM) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuKokuhorenSofuYM(txtKogakuKokuhorenSofuYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuTaishosha() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuTaishosha();
    }

    @JsonIgnore
    public void  setRadKogakuTaishosha(RadioButton radKogakuTaishosha) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuTaishosha(radKogakuTaishosha);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKetteiJohoUketoriYM() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKetteiJohoUketoriYM(TextBoxDateRange txtKogakuKetteiJohoUketoriYM) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuKetteiJohoUketoriYM(txtKogakuKetteiJohoUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShinseiKubun() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShinseiKubun();
    }

    @JsonIgnore
    public void  setRadKogakuShinseiKubun(RadioButton radKogakuShinseiKubun) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuShinseiKubun(radKogakuShinseiKubun);
    }

    @JsonIgnore
    public Label getLblKogakuShiharai() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getLblKogakuShiharai();
    }

    @JsonIgnore
    public void  setLblKogakuShiharai(Label lblKogakuShiharai) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setLblKogakuShiharai(lblKogakuShiharai);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShiharaisaki() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki();
    }

    @JsonIgnore
    public void  setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuShiharaisaki(radKogakuShiharaisaki);
    }

    @JsonIgnore
    public Label getLblKogakuKetteiGaku() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getLblKogakuKetteiGaku();
    }

    @JsonIgnore
    public void  setLblKogakuKetteiGaku(Label lblKogakuKetteiGaku) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setLblKogakuKetteiGaku(lblKogakuKetteiGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaNengetsu() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getTxtShinsaNengetsu();
    }

    @JsonIgnore
    public void  setTxtShinsaNengetsu(TextBoxDate txtShinsaNengetsu) {
        this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().setTxtShinsaNengetsu(txtShinsaNengetsu);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan();
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getDvKogakuServiceParam().getDvKogakuChushutsuJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public DvCsvHenshuHohoDiv getDvCsvHenshuHoho() {
        return this.getDvKogakuServiceParam().getDvCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setDvCsvHenshuHoho(DvCsvHenshuHohoDiv DvCsvHenshuHoho) {
        this.getDvKogakuServiceParam().setDvCsvHenshuHoho(DvCsvHenshuHoho);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvKogakuServiceParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvKogakuServiceParam().getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    @JsonIgnore
    public IChohyoShutsuryokuKomokuDiv getCcdKogakuShutsuryokuKomoku() {
        return this.getDvKogakuServiceParam().getCcdKogakuShutsuryokuKomoku();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdKogakuShutsuryokujun() {
        return this.getDvKogakuServiceParam().getCcdKogakuShutsuryokujun();
    }

    // </editor-fold>
}
