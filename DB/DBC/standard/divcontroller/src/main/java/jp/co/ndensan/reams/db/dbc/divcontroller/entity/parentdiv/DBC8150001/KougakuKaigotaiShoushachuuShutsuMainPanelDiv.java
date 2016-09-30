package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KougakuKaigotaiShoushachuuShutsuMainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KougakuKaigotaiShoushachuuShutsuMainPanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuTaishoshaShoriPanel")
    private KogakuTaishoshaShoriPanelDiv KogakuTaishoshaShoriPanel;
    @JsonProperty("KeisanTaishoKikanPanel")
    private KeisanTaishoKikanPanelDiv KeisanTaishoKikanPanel;
    @JsonProperty("ChushutsuKikanPanel")
    private ChushutsuKikanPanelDiv ChushutsuKikanPanel;
    @JsonProperty("chkTesutoShuturyoku")
    private CheckBoxList chkTesutoShuturyoku;
    @JsonProperty("InformationPanel")
    private InformationPanelDiv InformationPanel;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKogakuTaishoshaShoriPanel
     * @return KogakuTaishoshaShoriPanel
     */
    @JsonProperty("KogakuTaishoshaShoriPanel")
    public KogakuTaishoshaShoriPanelDiv getKogakuTaishoshaShoriPanel() {
        return KogakuTaishoshaShoriPanel;
    }

    /*
     * setKogakuTaishoshaShoriPanel
     * @param KogakuTaishoshaShoriPanel KogakuTaishoshaShoriPanel
     */
    @JsonProperty("KogakuTaishoshaShoriPanel")
    public void setKogakuTaishoshaShoriPanel(KogakuTaishoshaShoriPanelDiv KogakuTaishoshaShoriPanel) {
        this.KogakuTaishoshaShoriPanel = KogakuTaishoshaShoriPanel;
    }

    /*
     * getKeisanTaishoKikanPanel
     * @return KeisanTaishoKikanPanel
     */
    @JsonProperty("KeisanTaishoKikanPanel")
    public KeisanTaishoKikanPanelDiv getKeisanTaishoKikanPanel() {
        return KeisanTaishoKikanPanel;
    }

    /*
     * setKeisanTaishoKikanPanel
     * @param KeisanTaishoKikanPanel KeisanTaishoKikanPanel
     */
    @JsonProperty("KeisanTaishoKikanPanel")
    public void setKeisanTaishoKikanPanel(KeisanTaishoKikanPanelDiv KeisanTaishoKikanPanel) {
        this.KeisanTaishoKikanPanel = KeisanTaishoKikanPanel;
    }

    /*
     * getChushutsuKikanPanel
     * @return ChushutsuKikanPanel
     */
    @JsonProperty("ChushutsuKikanPanel")
    public ChushutsuKikanPanelDiv getChushutsuKikanPanel() {
        return ChushutsuKikanPanel;
    }

    /*
     * setChushutsuKikanPanel
     * @param ChushutsuKikanPanel ChushutsuKikanPanel
     */
    @JsonProperty("ChushutsuKikanPanel")
    public void setChushutsuKikanPanel(ChushutsuKikanPanelDiv ChushutsuKikanPanel) {
        this.ChushutsuKikanPanel = ChushutsuKikanPanel;
    }

    /*
     * getchkTesutoShuturyoku
     * @return chkTesutoShuturyoku
     */
    @JsonProperty("chkTesutoShuturyoku")
    public CheckBoxList getChkTesutoShuturyoku() {
        return chkTesutoShuturyoku;
    }

    /*
     * setchkTesutoShuturyoku
     * @param chkTesutoShuturyoku chkTesutoShuturyoku
     */
    @JsonProperty("chkTesutoShuturyoku")
    public void setChkTesutoShuturyoku(CheckBoxList chkTesutoShuturyoku) {
        this.chkTesutoShuturyoku = chkTesutoShuturyoku;
    }

    /*
     * getInformationPanel
     * @return InformationPanel
     */
    @JsonProperty("InformationPanel")
    public InformationPanelDiv getInformationPanel() {
        return InformationPanel;
    }

    /*
     * setInformationPanel
     * @param InformationPanel InformationPanel
     */
    @JsonProperty("InformationPanel")
    public void setInformationPanel(InformationPanelDiv InformationPanel) {
        this.InformationPanel = InformationPanel;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTitle01() {
        return this.getKogakuTaishoshaShoriPanel().getLblTitle01();
    }

    @JsonIgnore
    public void  setLblTitle01(Label lblTitle01) {
        this.getKogakuTaishoshaShoriPanel().setLblTitle01(lblTitle01);
    }

    @JsonIgnore
    public Label getLblTitle03() {
        return this.getKogakuTaishoshaShoriPanel().getLblTitle03();
    }

    @JsonIgnore
    public void  setLblTitle03(Label lblTitle03) {
        this.getKogakuTaishoshaShoriPanel().setLblTitle03(lblTitle03);
    }

    @JsonIgnore
    public Label getLblTitle02() {
        return this.getKogakuTaishoshaShoriPanel().getLblTitle02();
    }

    @JsonIgnore
    public void  setLblTitle02(Label lblTitle02) {
        this.getKogakuTaishoshaShoriPanel().setLblTitle02(lblTitle02);
    }

    @JsonIgnore
    public Label getLblTitle04() {
        return this.getKogakuTaishoshaShoriPanel().getLblTitle04();
    }

    @JsonIgnore
    public void  setLblTitle04(Label lblTitle04) {
        this.getKogakuTaishoshaShoriPanel().setLblTitle04(lblTitle04);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriYMD() {
        return this.getKogakuTaishoshaShoriPanel().getTxtShoriYMD();
    }

    @JsonIgnore
    public void  setTxtShoriYMD(TextBoxDate txtShoriYMD) {
        this.getKogakuTaishoshaShoriPanel().setTxtShoriYMD(txtShoriYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtShoriHMD() {
        return this.getKogakuTaishoshaShoriPanel().getTxtShoriHMD();
    }

    @JsonIgnore
    public void  setTxtShoriHMD(TextBoxTime txtShoriHMD) {
        this.getKogakuTaishoshaShoriPanel().setTxtShoriHMD(txtShoriHMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaYM() {
        return this.getKogakuTaishoshaShoriPanel().getTxtShinsaYM();
    }

    @JsonIgnore
    public void  setTxtShinsaYM(TextBoxDate txtShinsaYM) {
        this.getKogakuTaishoshaShoriPanel().setTxtShinsaYM(txtShinsaYM);
    }

    @JsonIgnore
    public Label getLblTitle05() {
        return this.getKeisanTaishoKikanPanel().getLblTitle05();
    }

    @JsonIgnore
    public void  setLblTitle05(Label lblTitle05) {
        this.getKeisanTaishoKikanPanel().setLblTitle05(lblTitle05);
    }

    @JsonIgnore
    public Label getLblTitle06() {
        return this.getKeisanTaishoKikanPanel().getLblTitle06();
    }

    @JsonIgnore
    public void  setLblTitle06(Label lblTitle06) {
        this.getKeisanTaishoKikanPanel().setLblTitle06(lblTitle06);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKeisanTaishoKikanYM() {
        return this.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM();
    }

    @JsonIgnore
    public void  setTxtKeisanTaishoKikanYM(TextBoxDateRange txtKeisanTaishoKikanYM) {
        this.getKeisanTaishoKikanPanel().setTxtKeisanTaishoKikanYM(txtKeisanTaishoKikanYM);
    }

    @JsonIgnore
    public Label getLblTitle07() {
        return this.getChushutsuKikanPanel().getLblTitle07();
    }

    @JsonIgnore
    public void  setLblTitle07(Label lblTitle07) {
        this.getChushutsuKikanPanel().setLblTitle07(lblTitle07);
    }

    @JsonIgnore
    public Label getLblTitle08() {
        return this.getChushutsuKikanPanel().getLblTitle08();
    }

    @JsonIgnore
    public void  setLblTitle08(Label lblTitle08) {
        this.getChushutsuKikanPanel().setLblTitle08(lblTitle08);
    }

    @JsonIgnore
    public Label getLblTitle09() {
        return this.getChushutsuKikanPanel().getLblTitle09();
    }

    @JsonIgnore
    public void  setLblTitle09(Label lblTitle09) {
        this.getChushutsuKikanPanel().setLblTitle09(lblTitle09);
    }

    @JsonIgnore
    public Label getLblTitle10() {
        return this.getChushutsuKikanPanel().getLblTitle10();
    }

    @JsonIgnore
    public void  setLblTitle10(Label lblTitle10) {
        this.getChushutsuKikanPanel().setLblTitle10(lblTitle10);
    }

    @JsonIgnore
    public Label getLblTitle11() {
        return this.getChushutsuKikanPanel().getLblTitle11();
    }

    @JsonIgnore
    public void  setLblTitle11(Label lblTitle11) {
        this.getChushutsuKikanPanel().setLblTitle11(lblTitle11);
    }

    @JsonIgnore
    public TextBoxDateTimeRange getTxtChushutsuKikanZenkai() {
        return this.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai();
    }

    @JsonIgnore
    public void  setTxtChushutsuKikanZenkai(TextBoxDateTimeRange txtChushutsuKikanZenkai) {
        this.getChushutsuKikanPanel().setTxtChushutsuKikanZenkai(txtChushutsuKikanZenkai);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriYMDZenkai() {
        return this.getChushutsuKikanPanel().getTxtShoriYMDZenkai();
    }

    @JsonIgnore
    public void  setTxtShoriYMDZenkai(TextBoxDate txtShoriYMDZenkai) {
        this.getChushutsuKikanPanel().setTxtShoriYMDZenkai(txtShoriYMDZenkai);
    }

    @JsonIgnore
    public TextBoxTime getTxtShoriHMZenkai() {
        return this.getChushutsuKikanPanel().getTxtShoriHMZenkai();
    }

    @JsonIgnore
    public void  setTxtShoriHMZenkai(TextBoxTime txtShoriHMZenkai) {
        this.getChushutsuKikanPanel().setTxtShoriHMZenkai(txtShoriHMZenkai);
    }

    @JsonIgnore
    public TextBoxDateTimeRange getTxtChushutsuKikanKonkai() {
        return this.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai();
    }

    @JsonIgnore
    public void  setTxtChushutsuKikanKonkai(TextBoxDateTimeRange txtChushutsuKikanKonkai) {
        this.getChushutsuKikanPanel().setTxtChushutsuKikanKonkai(txtChushutsuKikanKonkai);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriYMDKonkai() {
        return this.getChushutsuKikanPanel().getTxtShoriYMDKonkai();
    }

    @JsonIgnore
    public void  setTxtShoriYMDKonkai(TextBoxDate txtShoriYMDKonkai) {
        this.getChushutsuKikanPanel().setTxtShoriYMDKonkai(txtShoriYMDKonkai);
    }

    @JsonIgnore
    public TextBoxTime getTxtShoriHMKonkai() {
        return this.getChushutsuKikanPanel().getTxtShoriHMKonkai();
    }

    @JsonIgnore
    public void  setTxtShoriHMKonkai(TextBoxTime txtShoriHMKonkai) {
        this.getChushutsuKikanPanel().setTxtShoriHMKonkai(txtShoriHMKonkai);
    }

    @JsonIgnore
    public Label getLblComment1() {
        return this.getInformationPanel().getLblComment1();
    }

    @JsonIgnore
    public void  setLblComment1(Label lblComment1) {
        this.getInformationPanel().setLblComment1(lblComment1);
    }

    @JsonIgnore
    public Label getLblComment2() {
        return this.getInformationPanel().getLblComment2();
    }

    @JsonIgnore
    public void  setLblComment2(Label lblComment2) {
        this.getInformationPanel().setLblComment2(lblComment2);
    }

    @JsonIgnore
    public Label getLblComment3() {
        return this.getInformationPanel().getLblComment3();
    }

    @JsonIgnore
    public void  setLblComment3(Label lblComment3) {
        this.getInformationPanel().setLblComment3(lblComment3);
    }

    @JsonIgnore
    public Label getLblComment4() {
        return this.getInformationPanel().getLblComment4();
    }

    @JsonIgnore
    public void  setLblComment4(Label lblComment4) {
        this.getInformationPanel().setLblComment4(lblComment4);
    }

    // </editor-fold>
}
