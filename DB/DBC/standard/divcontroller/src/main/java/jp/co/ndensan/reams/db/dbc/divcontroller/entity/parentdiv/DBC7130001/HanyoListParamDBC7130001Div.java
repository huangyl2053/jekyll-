package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7130001;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterRestore;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterSave;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * HanyoListParamDBC7130001 のクラスファイル
 *
 * @author 自動生成
 */
public class HanyoListParamDBC7130001Div extends PanelBatchParameter {

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
    @JsonProperty("hdnDonyuKeitai")
    private RString hdnDonyuKeitai;

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
     * gethdnDonyuKeitai
     * @return hdnDonyuKeitai
     */
    @JsonProperty("hdnDonyuKeitai")
    public RString getHdnDonyuKeitai() {
        return hdnDonyuKeitai;
    }

    /*
     * sethdnDonyuKeitai
     * @param hdnDonyuKeitai hdnDonyuKeitai
     */
    @JsonProperty("hdnDonyuKeitai")
    public void setHdnDonyuKeitai(RString hdnDonyuKeitai) {
        this.hdnDonyuKeitai = hdnDonyuKeitai;
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
    public TekiyoKikanDiv getTekiyoKikan() {
        return this.getChushutsuJokenPanel().getTekiyoKikan();
    }

    @JsonIgnore
    public void setTekiyoKikan(TekiyoKikanDiv TekiyoKikan) {
        this.getChushutsuJokenPanel().setTekiyoKikan(TekiyoKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoKaishiNengetsu() {
        return this.getChushutsuJokenPanel().getTekiyoKikan().getTxtTekiyoKaishiNengetsu();
    }

    @JsonIgnore
    public void setTxtTekiyoKaishiNengetsu(TextBoxDateRange txtTekiyoKaishiNengetsu) {
        this.getChushutsuJokenPanel().getTekiyoKikan().setTxtTekiyoKaishiNengetsu(txtTekiyoKaishiNengetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoShuryoNengetsu() {
        return this.getChushutsuJokenPanel().getTekiyoKikan().getTxtTekiyoShuryoNengetsu();
    }

    @JsonIgnore
    public void setTxtTekiyoShuryoNengetsu(TextBoxDateRange txtTekiyoShuryoNengetsu) {
        this.getChushutsuJokenPanel().getTekiyoKikan().setTxtTekiyoShuryoNengetsu(txtTekiyoShuryoNengetsu);
    }

    @JsonIgnore
    public TekiyoKikanSetumeiDiv getTekiyoKikanSetumei() {
        return this.getChushutsuJokenPanel().getTekiyoKikanSetumei();
    }

    @JsonIgnore
    public void setTekiyoKikanSetumei(TekiyoKikanSetumeiDiv TekiyoKikanSetumei) {
        this.getChushutsuJokenPanel().setTekiyoKikanSetumei(TekiyoKikanSetumei);
    }

    @JsonIgnore
    public Space getYohaku() {
        return this.getChushutsuJokenPanel().getTekiyoKikanSetumei().getYohaku();
    }

    @JsonIgnore
    public void setYohaku(Space Yohaku) {
        this.getChushutsuJokenPanel().getTekiyoKikanSetumei().setYohaku(Yohaku);
    }

    @JsonIgnore
    public Label getＬｂｌTekiyoKikanSetumei() {
        return this.getChushutsuJokenPanel().getTekiyoKikanSetumei().getＬｂｌTekiyoKikanSetumei();
    }

    @JsonIgnore
    public void setＬｂｌTekiyoKikanSetumei(Label ｌｂｌTekiyoKikanSetumei) {
        this.getChushutsuJokenPanel().getTekiyoKikanSetumei().setＬｂｌTekiyoKikanSetumei(ｌｂｌTekiyoKikanSetumei);
    }

    @JsonIgnore
    public RadioButton getRadGendogakuKanriKikansu() {
        return this.getChushutsuJokenPanel().getRadGendogakuKanriKikansu();
    }

    @JsonIgnore
    public void setRadGendogakuKanriKikansu(RadioButton radGendogakuKanriKikansu) {
        this.getChushutsuJokenPanel().setRadGendogakuKanriKikansu(radGendogakuKanriKikansu);
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
