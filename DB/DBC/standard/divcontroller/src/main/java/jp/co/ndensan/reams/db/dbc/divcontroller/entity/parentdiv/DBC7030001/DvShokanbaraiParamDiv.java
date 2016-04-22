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
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * DvShokanbaraiParam のクラスファイル
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiParamDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvJokenFukugenHozon")
    private DvJokenFukugenHozonDiv DvJokenFukugenHozon;
    @JsonProperty("DvShokanChushutsuJoken")
    private DvShokanChushutsuJokenDiv DvShokanChushutsuJoken;
    @JsonProperty("DvCsvHenshuHoho")
    private DvCsvHenshuHohoDiv DvCsvHenshuHoho;
    @JsonProperty("ccdShokanShutsuryokuKomoku")
    private ChohyoShutsuryokuKomokuDiv ccdShokanShutsuryokuKomoku;
    @JsonProperty("ccdShokanShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShokanShutsuryokujun;

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
     * getDvShokanChushutsuJoken
     * @return DvShokanChushutsuJoken
     */
    @JsonProperty("DvShokanChushutsuJoken")
    public DvShokanChushutsuJokenDiv getDvShokanChushutsuJoken() {
        return DvShokanChushutsuJoken;
    }

    /*
     * setDvShokanChushutsuJoken
     * @param DvShokanChushutsuJoken DvShokanChushutsuJoken
     */
    @JsonProperty("DvShokanChushutsuJoken")
    public void setDvShokanChushutsuJoken(DvShokanChushutsuJokenDiv DvShokanChushutsuJoken) {
        this.DvShokanChushutsuJoken = DvShokanChushutsuJoken;
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
     * getccdShokanShutsuryokuKomoku
     * @return ccdShokanShutsuryokuKomoku
     */
    @JsonProperty("ccdShokanShutsuryokuKomoku")
    public IChohyoShutsuryokuKomokuDiv getCcdShokanShutsuryokuKomoku() {
        return ccdShokanShutsuryokuKomoku;
    }

    /*
     * getccdShokanShutsuryokujun
     * @return ccdShokanShutsuryokujun
     */
    @JsonProperty("ccdShokanShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShokanShutsuryokujun() {
        return ccdShokanShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnShokanParamSave() {
        return this.getDvJokenFukugenHozon().getBtnShokanParamSave();
    }

    @JsonIgnore
    public void setBtnShokanParamSave(ButtonBatchParameterSave btnShokanParamSave) {
        this.getDvJokenFukugenHozon().setBtnShokanParamSave(btnShokanParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnShokanParamRestore() {
        return this.getDvJokenFukugenHozon().getBtnShokanParamRestore();
    }

    @JsonIgnore
    public void setBtnShokanParamRestore(ButtonBatchParameterRestore btnShokanParamRestore) {
        this.getDvJokenFukugenHozon().setBtnShokanParamRestore(btnShokanParamRestore);
    }

    @JsonIgnore
    public DvKensakuJokenDiv getDvKensakuJoken() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken();
    }

    @JsonIgnore
    public void setDvKensakuJoken(DvKensakuJokenDiv DvKensakuJoken) {
        this.getDvShokanChushutsuJoken().setDvKensakuJoken(DvKensakuJoken);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanServiceTeikyoYM() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanServiceTeikyoYM();
    }

    @JsonIgnore
    public void setTxtShokanServiceTeikyoYM(TextBoxDateRange txtShokanServiceTeikyoYM) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanServiceTeikyoYM(txtShokanServiceTeikyoYM);
    }

    @JsonIgnore
    public DropDownList getDdlShokanShoriJokyo() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getDdlShokanShoriJokyo();
    }

    @JsonIgnore
    public void setDdlShokanShoriJokyo(DropDownList ddlShokanShoriJokyo) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setDdlShokanShoriJokyo(ddlShokanShoriJokyo);
    }

    @JsonIgnore
    public DropDownList getDdlShokanKetteiJoho() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getDdlShokanKetteiJoho();
    }

    @JsonIgnore
    public void setDdlShokanKetteiJoho(DropDownList ddlShokanKetteiJoho) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setDdlShokanKetteiJoho(ddlShokanKetteiJoho);
    }

    @JsonIgnore
    public RadioButton getRadKogakuShiharaisaki() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getRadKogakuShiharaisaki();
    }

    @JsonIgnore
    public void setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setRadKogakuShiharaisaki(radKogakuShiharaisaki);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanShinseiDate() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanShinseiDate();
    }

    @JsonIgnore
    public void setTxtShokanShinseiDate(TextBoxDateRange txtShokanShinseiDate) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanShinseiDate(txtShokanShinseiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanHokenshaKetteiDate() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanHokenshaKetteiDate();
    }

    @JsonIgnore
    public void setTxtShokanHokenshaKetteiDate(TextBoxDateRange txtShokanHokenshaKetteiDate) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanHokenshaKetteiDate(txtShokanHokenshaKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanKetteiDate() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanKetteiDate();
    }

    @JsonIgnore
    public void setTxtShokanKetteiDate(TextBoxDateRange txtShokanKetteiDate) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanKetteiDate(txtShokanKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShokanKokuhorenSofuYM() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanKokuhorenSofuYM();
    }

    @JsonIgnore
    public void setTxtShokanKokuhorenSofuYM(TextBoxDateRange txtShokanKokuhorenSofuYM) {
        this.getDvShokanChushutsuJoken().getDvKensakuJoken().setTxtShokanKokuhorenSofuYM(txtShokanKokuhorenSofuYM);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return this.getDvShokanChushutsuJoken().getDvKensakuJoken().getCcdKogakuKinyuKikan();
    }

    @JsonIgnore
    public dvYoshikiNoDiv getDvYoshikiNo() {
        return this.getDvShokanChushutsuJoken().getDvYoshikiNo();
    }

    @JsonIgnore
    public void setDvYoshikiNo(dvYoshikiNoDiv dvYoshikiNo) {
        this.getDvShokanChushutsuJoken().setDvYoshikiNo(dvYoshikiNo);
    }

    @JsonIgnore
    public Button getBtnShokanKaigo() {
        return this.getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnShokanKaigo();
    }

    @JsonIgnore
    public void setBtnShokanKaigo(Button btnShokanKaigo) {
        this.getDvShokanChushutsuJoken().getDvYoshikiNo().setBtnShokanKaigo(btnShokanKaigo);
    }

    @JsonIgnore
    public Button getBtnYobo() {
        return this.getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnYobo();
    }

    @JsonIgnore
    public void setBtnYobo(Button btnYobo) {
        this.getDvShokanChushutsuJoken().getDvYoshikiNo().setBtnYobo(btnYobo);
    }

    @JsonIgnore
    public DataGrid<dgYoshikiNo_Row> getDgYoshikiNo() {
        return this.getDvShokanChushutsuJoken().getDvYoshikiNo().getDgYoshikiNo();
    }

    @JsonIgnore
    public void setDgYoshikiNo(DataGrid<dgYoshikiNo_Row> dgYoshikiNo) {
        this.getDvShokanChushutsuJoken().getDvYoshikiNo().setDgYoshikiNo(dgYoshikiNo);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdShokanHokenshaList() {
        return this.getDvShokanChushutsuJoken().getCcdShokanHokenshaList();
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
