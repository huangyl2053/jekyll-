package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterRestore;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterSave;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * HanyoListOutputParam のクラスファイル
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
public class HanyoListOutputParamDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenFukugenHozonl")
    private JokenFukugenHozonlDiv JokenFukugenHozonl;
    @JsonProperty("ChushutsuJokenPanel")
    private ChushutsuJokenPanelDiv ChushutsuJokenPanel;
    @JsonProperty("DvCsvHenshuHoho")
    private DvCsvHenshuHohoDiv DvCsvHenshuHoho;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;
    @JsonProperty("ccdShutsuryokuKoumoku")
    private ChohyoShutsuryokuKomokuDiv ccdShutsuryokuKoumoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJokenFukugenHozonl
     * @return JokenFukugenHozonl
     */
    @JsonProperty("JokenFukugenHozonl")
    public JokenFukugenHozonlDiv getJokenFukugenHozonl() {
        return JokenFukugenHozonl;
    }

    /*
     * setJokenFukugenHozonl
     * @param JokenFukugenHozonl JokenFukugenHozonl
     */
    @JsonProperty("JokenFukugenHozonl")
    public void setJokenFukugenHozonl(JokenFukugenHozonlDiv JokenFukugenHozonl) {
        this.JokenFukugenHozonl = JokenFukugenHozonl;
    }

    /*
     * getChushutsuJokenPanel
     * @return ChushutsuJokenPanel
     */
    @JsonProperty("ChushutsuJokenPanel")
    public ChushutsuJokenPanelDiv getChushutsuJokenPanel() {
        return ChushutsuJokenPanel;
    }

    /*
     * setChushutsuJokenPanel
     * @param ChushutsuJokenPanel ChushutsuJokenPanel
     */
    @JsonProperty("ChushutsuJokenPanel")
    public void setChushutsuJokenPanel(ChushutsuJokenPanelDiv ChushutsuJokenPanel) {
        this.ChushutsuJokenPanel = ChushutsuJokenPanel;
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
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * getccdShutsuryokuKoumoku
     * @return ccdShutsuryokuKoumoku
     */
    @JsonProperty("ccdShutsuryokuKoumoku")
    public IChohyoShutsuryokuKomokuDiv getCcdShutsuryokuKoumoku() {
        return ccdShutsuryokuKoumoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return this.getJokenFukugenHozonl().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getJokenFukugenHozonl().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getJokenFukugenHozonl().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getJokenFukugenHozonl().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuKubun() {
        return this.getChushutsuJokenPanel().getRadChushutsuKubun();
    }

    @JsonIgnore
    public void setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.getChushutsuJokenPanel().setRadChushutsuKubun(radChushutsuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlDetaKubun() {
        return this.getChushutsuJokenPanel().getDdlDetaKubun();
    }

    @JsonIgnore
    public void setDdlDetaKubun(DropDownList ddlDetaKubun) {
        this.getChushutsuJokenPanel().setDdlDetaKubun(ddlDetaKubun);
    }

    @JsonIgnore
    public RadioButton getRadDataShurui() {
        return this.getChushutsuJokenPanel().getRadDataShurui();
    }

    @JsonIgnore
    public void setRadDataShurui(RadioButton radDataShurui) {
        this.getChushutsuJokenPanel().setRadDataShurui(radDataShurui);
    }

    @JsonIgnore
    public DropDownList getDdlTaishoNendo() {
        return this.getChushutsuJokenPanel().getDdlTaishoNendo();
    }

    @JsonIgnore
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.getChushutsuJokenPanel().setDdlTaishoNendo(ddlTaishoNendo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtUketoriNengetsu() {
        return this.getChushutsuJokenPanel().getTxtUketoriNengetsu();
    }

    @JsonIgnore
    public void setTxtUketoriNengetsu(TextBoxDateRange txtUketoriNengetsu) {
        this.getChushutsuJokenPanel().setTxtUketoriNengetsu(txtUketoriNengetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSofuNengetsu() {
        return this.getChushutsuJokenPanel().getTxtSofuNengetsu();
    }

    @JsonIgnore
    public void setTxtSofuNengetsu(TextBoxDateRange txtSofuNengetsu) {
        this.getChushutsuJokenPanel().setTxtSofuNengetsu(txtSofuNengetsu);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChushutsuJokenPanel().getCcdHokenshaList();
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
