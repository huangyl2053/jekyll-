package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvShokanbaraiJoho のクラスファイル
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvShokanbaraiParam")
    private DvShokanbaraiParamDiv DvShokanbaraiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvShokanbaraiParam
     * @return DvShokanbaraiParam
     */
    @JsonProperty("DvShokanbaraiParam")
    public DvShokanbaraiParamDiv getDvShokanbaraiParam() {
        return DvShokanbaraiParam;
    }

    /*
     * setDvShokanbaraiParam
     * @param DvShokanbaraiParam DvShokanbaraiParam
     */
    @JsonProperty("DvShokanbaraiParam")
    public void setDvShokanbaraiParam(DvShokanbaraiParamDiv DvShokanbaraiParam) {
        this.DvShokanbaraiParam = DvShokanbaraiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DvJokenFukugenHozonDiv getDvJokenFukugenHozon() {
        return this.getDvShokanbaraiParam().getDvJokenFukugenHozon();
    }

    @JsonIgnore
    public void setDvJokenFukugenHozon(DvJokenFukugenHozonDiv DvJokenFukugenHozon) {
        this.getDvShokanbaraiParam().setDvJokenFukugenHozon(DvJokenFukugenHozon);
    }

    @JsonIgnore
    public ButtonBatchParameterSave getBtnShokanParamSave() {
        return this.getDvShokanbaraiParam().getDvJokenFukugenHozon().getBtnShokanParamSave();
    }

    @JsonIgnore
    public void setBtnShokanParamSave(ButtonBatchParameterSave btnShokanParamSave) {
        this.getDvShokanbaraiParam().getDvJokenFukugenHozon().setBtnShokanParamSave(btnShokanParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnShokanParamRestore() {
        return this.getDvShokanbaraiParam().getDvJokenFukugenHozon().getBtnShokanParamRestore();
    }

    @JsonIgnore
    public void setBtnShokanParamRestore(ButtonBatchParameterRestore btnShokanParamRestore) {
        this.getDvShokanbaraiParam().getDvJokenFukugenHozon().setBtnShokanParamRestore(btnShokanParamRestore);
    }

    @JsonIgnore
    public DvShokanChushutsuJokenDiv getDvShokanChushutsuJoken() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken();
    }

    @JsonIgnore
    public void setDvShokanChushutsuJoken(DvShokanChushutsuJokenDiv DvShokanChushutsuJoken) {
        this.getDvShokanbaraiParam().setDvShokanChushutsuJoken(DvShokanChushutsuJoken);
    }

    @JsonIgnore
    public DvKensakuJokenDiv getDvKensakuJoken() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken();
    }

    @JsonIgnore
    public void setDvKensakuJoken(DvKensakuJokenDiv DvKensakuJoken) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().setDvKensakuJoken(DvKensakuJoken);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanServiceTeikyoYM() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanServiceTeikyoYM();
    }

    @JsonIgnore
    public void setTxtShokanServiceTeikyoYM(TextBoxDateRange txtShokanServiceTeikyoYM) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanServiceTeikyoYM(txtShokanServiceTeikyoYM);
    }

    @JsonIgnore
    public DropDownList getDdlShokanShoriJokyo() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getDdlShokanShoriJokyo();
    }

    @JsonIgnore
    public void setDdlShokanShoriJokyo(DropDownList ddlShokanShoriJokyo) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setDdlShokanShoriJokyo(ddlShokanShoriJokyo);
    }

    @JsonIgnore
    public DropDownList getDdlShokanKetteiJoho() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getDdlShokanKetteiJoho();
    }

    @JsonIgnore
    public void setDdlShokanKetteiJoho(DropDownList ddlShokanKetteiJoho) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setDdlShokanKetteiJoho(ddlShokanKetteiJoho);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShiharaisaki() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getRadKogakuShiharaisaki();
    }

    @JsonIgnore
    public void setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setRadKogakuShiharaisaki(radKogakuShiharaisaki);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanShinseiDate() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanShinseiDate();
    }

    @JsonIgnore
    public void setTxtShokanShinseiDate(TextBoxDateRange txtShokanShinseiDate) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanShinseiDate(txtShokanShinseiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanHokenshaKetteiDate() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanHokenshaKetteiDate();
    }

    @JsonIgnore
    public void setTxtShokanHokenshaKetteiDate(TextBoxDateRange txtShokanHokenshaKetteiDate) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanHokenshaKetteiDate(txtShokanHokenshaKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanKetteiDate() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanKetteiDate();
    }

    @JsonIgnore
    public void setTxtShokanKetteiDate(TextBoxDateRange txtShokanKetteiDate) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanKetteiDate(txtShokanKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanKokuhorenSofuYM() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanKokuhorenSofuYM();
    }

    @JsonIgnore
    public void setTxtShokanKokuhorenSofuYM(TextBoxDateRange txtShokanKokuhorenSofuYM) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanKokuhorenSofuYM(txtShokanKokuhorenSofuYM);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getCcdKogakuKinyuKikan();
    }

    @JsonIgnore
    public dvYoshikiNoDiv getDvYoshikiNo() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo();
    }

    @JsonIgnore
    public void setDvYoshikiNo(dvYoshikiNoDiv dvYoshikiNo) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().setDvYoshikiNo(dvYoshikiNo);
    }

    @JsonIgnore
    public Button getBtnShokanKaigo() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnShokanKaigo();
    }

    @JsonIgnore
    public void setBtnShokanKaigo(Button btnShokanKaigo) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().setBtnShokanKaigo(btnShokanKaigo);
    }

    @JsonIgnore
    public Button getBtnYobo() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnYobo();
    }

    @JsonIgnore
    public void setBtnYobo(Button btnYobo) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().setBtnYobo(btnYobo);
    }

    @JsonIgnore
    public DataGrid<dgYoshikiNo_Row> getDgYoshikiNo() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().getDgYoshikiNo();
    }

    @JsonIgnore
    public void setDgYoshikiNo(DataGrid<dgYoshikiNo_Row> dgYoshikiNo) {
        this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().setDgYoshikiNo(dgYoshikiNo);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdShokanHokenshaList() {
        return this.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getCcdShokanHokenshaList();
    }

    @JsonIgnore
    public DvCsvHenshuHohoDiv getDvCsvHenshuHoho() {
        return this.getDvShokanbaraiParam().getDvCsvHenshuHoho();
    }

    @JsonIgnore
    public void setDvCsvHenshuHoho(DvCsvHenshuHohoDiv DvCsvHenshuHoho) {
        this.getDvShokanbaraiParam().setDvCsvHenshuHoho(DvCsvHenshuHoho);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvShokanbaraiParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvShokanbaraiParam().getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    @JsonIgnore
    public IChohyoShutsuryokuKomokuDiv getCcdShokanShutsuryokuKomoku() {
        return this.getDvShokanbaraiParam().getCcdShokanShutsuryokuKomoku();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdShokanShutsuryokujun() {
        return this.getDvShokanbaraiParam().getCcdShokanShutsuryokujun();
    }

    // </editor-fold>
}
