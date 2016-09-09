package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HanyoListParamPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanyoListParamPanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenFukugenHozonl")
    private JokenFukugenHozonlDiv JokenFukugenHozonl;
    @JsonProperty("JokenFukugenHozonl2")
    private JokenFukugenHozonl2Div JokenFukugenHozonl2;
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
     * getJokenFukugenHozonl2
     * @return JokenFukugenHozonl2
     */
    @JsonProperty("JokenFukugenHozonl2")
    public JokenFukugenHozonl2Div getJokenFukugenHozonl2() {
        return JokenFukugenHozonl2;
    }

    /*
     * setJokenFukugenHozonl2
     * @param JokenFukugenHozonl2 JokenFukugenHozonl2
     */
    @JsonProperty("JokenFukugenHozonl2")
    public void setJokenFukugenHozonl2(JokenFukugenHozonl2Div JokenFukugenHozonl2) {
        this.JokenFukugenHozonl2 = JokenFukugenHozonl2;
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
    public ButtonBatchParameterSave getBtnHanyoListSaishinsaMoshitateParamSave() {
        return this.getJokenFukugenHozonl().getBtnHanyoListSaishinsaMoshitateParamSave();
    }

    @JsonIgnore
    public void  setBtnHanyoListSaishinsaMoshitateParamSave(ButtonBatchParameterSave btnHanyoListSaishinsaMoshitateParamSave) {
        this.getJokenFukugenHozonl().setBtnHanyoListSaishinsaMoshitateParamSave(btnHanyoListSaishinsaMoshitateParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnHanyoListSaishinsaMoshitateParamRestore() {
        return this.getJokenFukugenHozonl().getBtnHanyoListSaishinsaMoshitateParamRestore();
    }

    @JsonIgnore
    public void  setBtnHanyoListSaishinsaMoshitateParamRestore(ButtonBatchParameterRestore btnHanyoListSaishinsaMoshitateParamRestore) {
        this.getJokenFukugenHozonl().setBtnHanyoListSaishinsaMoshitateParamRestore(btnHanyoListSaishinsaMoshitateParamRestore);
    }

    @JsonIgnore
    public ButtonBatchParameterSave getBtnHanyoListSaishinsaKekkaParamSave() {
        return this.getJokenFukugenHozonl2().getBtnHanyoListSaishinsaKekkaParamSave();
    }

    @JsonIgnore
    public void  setBtnHanyoListSaishinsaKekkaParamSave(ButtonBatchParameterSave btnHanyoListSaishinsaKekkaParamSave) {
        this.getJokenFukugenHozonl2().setBtnHanyoListSaishinsaKekkaParamSave(btnHanyoListSaishinsaKekkaParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnHanyoListSaishinsaKekkaParamRestore() {
        return this.getJokenFukugenHozonl2().getBtnHanyoListSaishinsaKekkaParamRestore();
    }

    @JsonIgnore
    public void  setBtnHanyoListSaishinsaKekkaParamRestore(ButtonBatchParameterRestore btnHanyoListSaishinsaKekkaParamRestore) {
        this.getJokenFukugenHozonl2().setBtnHanyoListSaishinsaKekkaParamRestore(btnHanyoListSaishinsaKekkaParamRestore);
    }

    @JsonIgnore
    public SaisinsaMoshitateJohoChushutsuDiv getSaisinsaMoshitateJohoChushutsu() {
        return this.getChushutsuJokenPanel().getSaisinsaMoshitateJohoChushutsu();
    }

    @JsonIgnore
    public void  setSaisinsaMoshitateJohoChushutsu(SaisinsaMoshitateJohoChushutsuDiv SaisinsaMoshitateJohoChushutsu) {
        this.getChushutsuJokenPanel().setSaisinsaMoshitateJohoChushutsu(SaisinsaMoshitateJohoChushutsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhorenSofuNengetu() {
        return this.getChushutsuJokenPanel().getSaisinsaMoshitateJohoChushutsu().getTxtKokuhorenSofuNengetu();
    }

    @JsonIgnore
    public void  setTxtKokuhorenSofuNengetu(TextBoxDateRange txtKokuhorenSofuNengetu) {
        this.getChushutsuJokenPanel().getSaisinsaMoshitateJohoChushutsu().setTxtKokuhorenSofuNengetu(txtKokuhorenSofuNengetu);
    }

    @JsonIgnore
    public SaisinsaKekkaJohoChushutsuDiv getSaisinsaKekkaJohoChushutsu() {
        return this.getChushutsuJokenPanel().getSaisinsaKekkaJohoChushutsu();
    }

    @JsonIgnore
    public void  setSaisinsaKekkaJohoChushutsu(SaisinsaKekkaJohoChushutsuDiv SaisinsaKekkaJohoChushutsu) {
        this.getChushutsuJokenPanel().setSaisinsaKekkaJohoChushutsu(SaisinsaKekkaJohoChushutsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhorenToriatukaiNengetu() {
        return this.getChushutsuJokenPanel().getSaisinsaKekkaJohoChushutsu().getTxtKokuhorenToriatukaiNengetu();
    }

    @JsonIgnore
    public void  setTxtKokuhorenToriatukaiNengetu(TextBoxDateRange txtKokuhorenToriatukaiNengetu) {
        this.getChushutsuJokenPanel().getSaisinsaKekkaJohoChushutsu().setTxtKokuhorenToriatukaiNengetu(txtKokuhorenToriatukaiNengetu);
    }

    @JsonIgnore
    public CheckBoxList getChkHokenshaKubun() {
        return this.getChushutsuJokenPanel().getSaisinsaKekkaJohoChushutsu().getChkHokenshaKubun();
    }

    @JsonIgnore
    public void  setChkHokenshaKubun(CheckBoxList chkHokenshaKubun) {
        this.getChushutsuJokenPanel().getSaisinsaKekkaJohoChushutsu().setChkHokenshaKubun(chkHokenshaKubun);
    }

    @JsonIgnore
    public SaisinsaJohoChushutsuDiv getSaisinsaJohoChushutsu() {
        return this.getChushutsuJokenPanel().getSaisinsaJohoChushutsu();
    }

    @JsonIgnore
    public void  setSaisinsaJohoChushutsu(SaisinsaJohoChushutsuDiv SaisinsaJohoChushutsu) {
        this.getChushutsuJokenPanel().setSaisinsaJohoChushutsu(SaisinsaJohoChushutsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSabisuTeikyoNengetu() {
        return this.getChushutsuJokenPanel().getSaisinsaJohoChushutsu().getTxtSabisuTeikyoNengetu();
    }

    @JsonIgnore
    public void  setTxtSabisuTeikyoNengetu(TextBoxDateRange txtSabisuTeikyoNengetu) {
        this.getChushutsuJokenPanel().getSaisinsaJohoChushutsu().setTxtSabisuTeikyoNengetu(txtSabisuTeikyoNengetu);
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
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
