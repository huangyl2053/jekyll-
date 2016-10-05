package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7180001;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SougouJigyoHiJouhou のクラスファイル 
 * 
 * @author 自動生成
 */
public class SougouJigyoHiJouhouDiv extends PanelBatchParameter {
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
    @JsonProperty("HdnDonyuKeitai")
    private RString HdnDonyuKeitai;

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
     * getHdnDonyuKeitai
     * @return HdnDonyuKeitai
     */
    @JsonProperty("HdnDonyuKeitai")
    public RString getHdnDonyuKeitai() {
        return HdnDonyuKeitai;
    }

    /*
     * setHdnDonyuKeitai
     * @param HdnDonyuKeitai HdnDonyuKeitai
     */
    @JsonProperty("HdnDonyuKeitai")
    public void setHdnDonyuKeitai(RString HdnDonyuKeitai) {
        this.HdnDonyuKeitai = HdnDonyuKeitai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return this.getJokenFukugenHozonl().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getJokenFukugenHozonl().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getJokenFukugenHozonl().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getJokenFukugenHozonl().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public HorizontalLine getLinChushutsuJyoken1() {
        return this.getChushutsuJokenPanel().getLinChushutsuJyoken1();
    }

    @JsonIgnore
    public void  setLinChushutsuJyoken1(HorizontalLine linChushutsuJyoken1) {
        this.getChushutsuJokenPanel().setLinChushutsuJyoken1(linChushutsuJyoken1);
    }

    @JsonIgnore
    public RadioButton getRadSakuseiKubun() {
        return this.getChushutsuJokenPanel().getRadSakuseiKubun();
    }

    @JsonIgnore
    public void  setRadSakuseiKubun(RadioButton radSakuseiKubun) {
        this.getChushutsuJokenPanel().setRadSakuseiKubun(radSakuseiKubun);
    }

    @JsonIgnore
    public HorizontalLine getLinChushutsuJyoken2() {
        return this.getChushutsuJokenPanel().getLinChushutsuJyoken2();
    }

    @JsonIgnore
    public void  setLinChushutsuJyoken2(HorizontalLine linChushutsuJyoken2) {
        this.getChushutsuJokenPanel().setLinChushutsuJyoken2(linChushutsuJyoken2);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSabisuTeikyoNengetsu() {
        return this.getChushutsuJokenPanel().getTxtSabisuTeikyoNengetsu();
    }

    @JsonIgnore
    public void  setTxtSabisuTeikyoNengetsu(TextBoxDateRange txtSabisuTeikyoNengetsu) {
        this.getChushutsuJokenPanel().setTxtSabisuTeikyoNengetsu(txtSabisuTeikyoNengetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSinsaNengetsu() {
        return this.getChushutsuJokenPanel().getTxtSinsaNengetsu();
    }

    @JsonIgnore
    public void  setTxtSinsaNengetsu(TextBoxDateRange txtSinsaNengetsu) {
        this.getChushutsuJokenPanel().setTxtSinsaNengetsu(txtSinsaNengetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTorikomiNengetsu() {
        return this.getChushutsuJokenPanel().getTxtTorikomiNengetsu();
    }

    @JsonIgnore
    public void  setTxtTorikomiNengetsu(TextBoxDateRange txtTorikomiNengetsu) {
        this.getChushutsuJokenPanel().setTxtTorikomiNengetsu(txtTorikomiNengetsu);
    }

    @JsonIgnore
    public DropDownList getDdlSabisuSyurui() {
        return this.getChushutsuJokenPanel().getDdlSabisuSyurui();
    }

    @JsonIgnore
    public void  setDdlSabisuSyurui(DropDownList ddlSabisuSyurui) {
        this.getChushutsuJokenPanel().setDdlSabisuSyurui(ddlSabisuSyurui);
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
