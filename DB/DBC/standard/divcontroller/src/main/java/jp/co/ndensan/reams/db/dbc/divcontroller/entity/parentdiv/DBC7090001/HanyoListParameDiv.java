package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterRestore;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterSave;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * HanyoListParame のクラスファイル
 *
 * @reamsid_L DBC-3095-010 qinzhen
 */
public class HanyoListParameDiv extends PanelBatchParameter {

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
    @JsonProperty("ccdShutsuryokuKoumoku")
    private ChohyoShutsuryokuKomokuDiv ccdShutsuryokuKoumoku;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;

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
     * getccdShutsuryokuKoumoku
     * @return ccdShutsuryokuKoumoku
     */
    @JsonProperty("ccdShutsuryokuKoumoku")
    public IChohyoShutsuryokuKomokuDiv getCcdShutsuryokuKoumoku() {
        return ccdShutsuryokuKoumoku;
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
    public TextBoxDateRange getTxtKokuhorenSofuNengetu() {
        return this.getChushutsuJokenPanel().getTxtKokuhorenSofuNengetu();
    }

    @JsonIgnore
    public void setTxtKokuhorenSofuNengetu(TextBoxDateRange txtKokuhorenSofuNengetu) {
        this.getChushutsuJokenPanel().setTxtKokuhorenSofuNengetu(txtKokuhorenSofuNengetu);
    }

    @JsonIgnore
    public RadioButton getRadKagoMoshitateKyufuKubun() {
        return this.getChushutsuJokenPanel().getRadKagoMoshitateKyufuKubun();
    }

    @JsonIgnore
    public void setRadKagoMoshitateKyufuKubun(RadioButton radKagoMoshitateKyufuKubun) {
        this.getChushutsuJokenPanel().setRadKagoMoshitateKyufuKubun(radKagoMoshitateKyufuKubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSabisuTeikyoNengetu() {
        return this.getChushutsuJokenPanel().getTxtSabisuTeikyoNengetu();
    }

    @JsonIgnore
    public void setTxtSabisuTeikyoNengetu(TextBoxDateRange txtSabisuTeikyoNengetu) {
        this.getChushutsuJokenPanel().setTxtSabisuTeikyoNengetu(txtSabisuTeikyoNengetu);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChushutsuJokenPanel().getCcdHokenshaList();
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaBango() {
        return this.getChushutsuJokenPanel().getCcdJigyoshaBango();
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
