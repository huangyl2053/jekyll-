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
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * DvKogakuServiceParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvKogakuServiceParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvJokenFukugenHozon")
    private DvJokenFukugenHozonDiv DvJokenFukugenHozon;
    @JsonProperty("DvKogakuChushutsuJoken")
    private DvKogakuChushutsuJokenDiv DvKogakuChushutsuJoken;
    @JsonProperty("DvCsvHenshuHoho")
    private DvCsvHenshuHohoDiv DvCsvHenshuHoho;
    @JsonProperty("ccdKogakuShutsuryokuKomoku")
    private ChohyoShutsuryokuKomokuDiv ccdKogakuShutsuryokuKomoku;
    @JsonProperty("ccdKogakuShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdKogakuShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvJokenFukugenHozon
     * @return DvJokenFukugenHozon
     */
    @JsonProperty("DvJokenFukugenHozon")
    public DvJokenFukugenHozonDiv getDvJokenFukugenHozon() {
        return DvJokenFukugenHozon;
    }

    /*
     * setDvJokenFukugenHozon
     * @param DvJokenFukugenHozon DvJokenFukugenHozon
     */
    @JsonProperty("DvJokenFukugenHozon")
    public void setDvJokenFukugenHozon(DvJokenFukugenHozonDiv DvJokenFukugenHozon) {
        this.DvJokenFukugenHozon = DvJokenFukugenHozon;
    }

    /*
     * getDvKogakuChushutsuJoken
     * @return DvKogakuChushutsuJoken
     */
    @JsonProperty("DvKogakuChushutsuJoken")
    public DvKogakuChushutsuJokenDiv getDvKogakuChushutsuJoken() {
        return DvKogakuChushutsuJoken;
    }

    /*
     * setDvKogakuChushutsuJoken
     * @param DvKogakuChushutsuJoken DvKogakuChushutsuJoken
     */
    @JsonProperty("DvKogakuChushutsuJoken")
    public void setDvKogakuChushutsuJoken(DvKogakuChushutsuJokenDiv DvKogakuChushutsuJoken) {
        this.DvKogakuChushutsuJoken = DvKogakuChushutsuJoken;
    }

    /*
     * getDvCsvHenshuHoho
     * @return DvCsvHenshuHoho
     */
    @JsonProperty("DvCsvHenshuHoho")
    public DvCsvHenshuHohoDiv getDvCsvHenshuHoho() {
        return DvCsvHenshuHoho;
    }

    /*
     * setDvCsvHenshuHoho
     * @param DvCsvHenshuHoho DvCsvHenshuHoho
     */
    @JsonProperty("DvCsvHenshuHoho")
    public void setDvCsvHenshuHoho(DvCsvHenshuHohoDiv DvCsvHenshuHoho) {
        this.DvCsvHenshuHoho = DvCsvHenshuHoho;
    }

    /*
     * getccdKogakuShutsuryokuKomoku
     * @return ccdKogakuShutsuryokuKomoku
     */
    @JsonProperty("ccdKogakuShutsuryokuKomoku")
    public IChohyoShutsuryokuKomokuDiv getCcdKogakuShutsuryokuKomoku() {
        return ccdKogakuShutsuryokuKomoku;
    }

    /*
     * getccdKogakuShutsuryokujun
     * @return ccdKogakuShutsuryokujun
     */
    @JsonProperty("ccdKogakuShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdKogakuShutsuryokujun() {
        return ccdKogakuShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnKogakuParamSave() {
        return this.getDvJokenFukugenHozon().getBtnKogakuParamSave();
    }

    @JsonIgnore
    public void  setBtnKogakuParamSave(ButtonBatchParameterSave btnKogakuParamSave) {
        this.getDvJokenFukugenHozon().setBtnKogakuParamSave(btnKogakuParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnKogakuParamRestore() {
        return this.getDvJokenFukugenHozon().getBtnKogakuParamRestore();
    }

    @JsonIgnore
    public void  setBtnKogakuParamRestore(ButtonBatchParameterRestore btnKogakuParamRestore) {
        this.getDvJokenFukugenHozon().setBtnKogakuParamRestore(btnKogakuParamRestore);
    }

    @JsonIgnore
    public dvKogakuServiceDiv getDvKogakuService() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService();
    }

    @JsonIgnore
    public void  setDvKogakuService(dvKogakuServiceDiv dvKogakuService) {
        this.getDvKogakuChushutsuJoken().setDvKogakuService(dvKogakuService);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuServiceTeikyoYM() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtKogakuServiceTeikyoYM(TextBoxDateRange txtKogakuServiceTeikyoYM) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuServiceTeikyoYM(txtKogakuServiceTeikyoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuShinseiDate() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate();
    }

    @JsonIgnore
    public void  setTxtKogakuShinseiDate(TextBoxDateRange txtKogakuShinseiDate) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuShinseiDate(txtKogakuShinseiDate);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuShoriJokyo() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShoriJokyo();
    }

    @JsonIgnore
    public void  setDdlKogakuShoriJokyo(DropDownList ddlKogakuShoriJokyo) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setDdlKogakuShoriJokyo(ddlKogakuShoriJokyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuHokenshaKetteiDate() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate();
    }

    @JsonIgnore
    public void  setTxtKogakuHokenshaKetteiDate(TextBoxDateRange txtKogakuHokenshaKetteiDate) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuHokenshaKetteiDate(txtKogakuHokenshaKetteiDate);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuShinsaHoho() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShinsaHoho();
    }

    @JsonIgnore
    public void  setDdlKogakuShinsaHoho(DropDownList ddlKogakuShinsaHoho) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setDdlKogakuShinsaHoho(ddlKogakuShinsaHoho);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKokuhorenKetteiYM() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKokuhorenKetteiYM(TextBoxDateRange txtKogakuKokuhorenKetteiYM) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuKokuhorenKetteiYM(txtKogakuKokuhorenKetteiYM);
    }

    @JsonIgnore
    public DropDownList getDdlKogakuSanteiKijun() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuSanteiKijun();
    }

    @JsonIgnore
    public void  setDdlKogakuSanteiKijun(DropDownList ddlKogakuSanteiKijun) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setDdlKogakuSanteiKijun(ddlKogakuSanteiKijun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuTaishoshaUketoriYM() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKogakuTaishoshaUketoriYM(TextBoxDateRange txtKogakuTaishoshaUketoriYM) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuTaishoshaUketoriYM(txtKogakuTaishoshaUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuKokuhorenFuicchi() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuKokuhorenFuicchi();
    }

    @JsonIgnore
    public void  setRadKogakuKokuhorenFuicchi(RadioButton radKogakuKokuhorenFuicchi) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuKokuhorenFuicchi(radKogakuKokuhorenFuicchi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKokuhorenSofuYM() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKokuhorenSofuYM(TextBoxDateRange txtKogakuKokuhorenSofuYM) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuKokuhorenSofuYM(txtKogakuKokuhorenSofuYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuTaishosha() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuTaishosha();
    }

    @JsonIgnore
    public void  setRadKogakuTaishosha(RadioButton radKogakuTaishosha) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuTaishosha(radKogakuTaishosha);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKogakuKetteiJohoUketoriYM() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKogakuKetteiJohoUketoriYM(TextBoxDateRange txtKogakuKetteiJohoUketoriYM) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtKogakuKetteiJohoUketoriYM(txtKogakuKetteiJohoUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShinseiKubun() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShinseiKubun();
    }

    @JsonIgnore
    public void  setRadKogakuShinseiKubun(RadioButton radKogakuShinseiKubun) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuShinseiKubun(radKogakuShinseiKubun);
    }

    @JsonIgnore
    public Label getLblKogakuShiharai() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getLblKogakuShiharai();
    }

    @JsonIgnore
    public void  setLblKogakuShiharai(Label lblKogakuShiharai) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setLblKogakuShiharai(lblKogakuShiharai);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShiharaisaki() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki();
    }

    @JsonIgnore
    public void  setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setRadKogakuShiharaisaki(radKogakuShiharaisaki);
    }

    @JsonIgnore
    public Label getLblKogakuKetteiGaku() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getLblKogakuKetteiGaku();
    }

    @JsonIgnore
    public void  setLblKogakuKetteiGaku(Label lblKogakuKetteiGaku) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setLblKogakuKetteiGaku(lblKogakuKetteiGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaNengetsu() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtShinsaNengetsu();
    }

    @JsonIgnore
    public void  setTxtShinsaNengetsu(TextBoxDate txtShinsaNengetsu) {
        this.getDvKogakuChushutsuJoken().getDvKogakuService().setTxtShinsaNengetsu(txtShinsaNengetsu);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return this.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan();
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getDvKogakuChushutsuJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
