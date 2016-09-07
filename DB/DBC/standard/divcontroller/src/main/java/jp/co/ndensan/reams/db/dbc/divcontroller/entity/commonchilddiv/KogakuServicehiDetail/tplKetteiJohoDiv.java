package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKetteiJoho のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class tplKetteiJohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuhorenKetteiJohoPanel1")
    private KokuhorenKetteiJohoPanel1Div KokuhorenKetteiJohoPanel1;
    @JsonProperty("SakuseiPanel")
    private SakuseiPanelDiv SakuseiPanel;
    @JsonProperty("KokuhorenSoufuJohoPanel")
    private KokuhorenSoufuJohoPanelDiv KokuhorenSoufuJohoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuhorenKetteiJohoPanel1
     * @return KokuhorenKetteiJohoPanel1
     */
    @JsonProperty("KokuhorenKetteiJohoPanel1")
    public KokuhorenKetteiJohoPanel1Div getKokuhorenKetteiJohoPanel1() {
        return KokuhorenKetteiJohoPanel1;
    }

    /*
     * setKokuhorenKetteiJohoPanel1
     * @param KokuhorenKetteiJohoPanel1 KokuhorenKetteiJohoPanel1
     */
    @JsonProperty("KokuhorenKetteiJohoPanel1")
    public void setKokuhorenKetteiJohoPanel1(KokuhorenKetteiJohoPanel1Div KokuhorenKetteiJohoPanel1) {
        this.KokuhorenKetteiJohoPanel1 = KokuhorenKetteiJohoPanel1;
    }

    /*
     * getSakuseiPanel
     * @return SakuseiPanel
     */
    @JsonProperty("SakuseiPanel")
    public SakuseiPanelDiv getSakuseiPanel() {
        return SakuseiPanel;
    }

    /*
     * setSakuseiPanel
     * @param SakuseiPanel SakuseiPanel
     */
    @JsonProperty("SakuseiPanel")
    public void setSakuseiPanel(SakuseiPanelDiv SakuseiPanel) {
        this.SakuseiPanel = SakuseiPanel;
    }

    /*
     * getKokuhorenSoufuJohoPanel
     * @return KokuhorenSoufuJohoPanel
     */
    @JsonProperty("KokuhorenSoufuJohoPanel")
    public KokuhorenSoufuJohoPanelDiv getKokuhorenSoufuJohoPanel() {
        return KokuhorenSoufuJohoPanel;
    }

    /*
     * setKokuhorenSoufuJohoPanel
     * @param KokuhorenSoufuJohoPanel KokuhorenSoufuJohoPanel
     */
    @JsonProperty("KokuhorenSoufuJohoPanel")
    public void setKokuhorenSoufuJohoPanel(KokuhorenSoufuJohoPanelDiv KokuhorenSoufuJohoPanel) {
        this.KokuhorenSoufuJohoPanel = KokuhorenSoufuJohoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtTsuchiBango() {
        return this.getKokuhorenKetteiJohoPanel1().getTxtTsuchiBango();
    }

    @JsonIgnore
    public void  setTxtTsuchiBango(TextBoxCode txtTsuchiBango) {
        this.getKokuhorenKetteiJohoPanel1().setTxtTsuchiBango(txtTsuchiBango);
    }

    @JsonIgnore
    public TextBox getTxtShikyuKubun() {
        return this.getKokuhorenKetteiJohoPanel1().getTxtShikyuKubun();
    }

    @JsonIgnore
    public void  setTxtShikyuKubun(TextBox txtShikyuKubun) {
        this.getKokuhorenKetteiJohoPanel1().setTxtShikyuKubun(txtShikyuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYM() {
        return this.getKokuhorenKetteiJohoPanel1().getTxtKetteiYM();
    }

    @JsonIgnore
    public void  setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.getKokuhorenKetteiJohoPanel1().setTxtKetteiYM(txtKetteiYM);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiKingakuGokei() {
        return this.getKokuhorenKetteiJohoPanel1().getTxtShiharaiKingakuGokei();
    }

    @JsonIgnore
    public void  setTxtShiharaiKingakuGokei(TextBoxNum txtShiharaiKingakuGokei) {
        this.getKokuhorenKetteiJohoPanel1().setTxtShiharaiKingakuGokei(txtShiharaiKingakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return this.getKokuhorenKetteiJohoPanel1().getTxtKogakuShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.getKokuhorenKetteiJohoPanel1().setTxtKogakuShikyuGaku(txtKogakuShikyuGaku);
    }

    @JsonIgnore
    public KokuhorenKetteiJohoPanel2Div getKokuhorenKetteiJohoPanel2() {
        return this.getSakuseiPanel().getKokuhorenKetteiJohoPanel2();
    }

    @JsonIgnore
    public void  setKokuhorenKetteiJohoPanel2(KokuhorenKetteiJohoPanel2Div KokuhorenKetteiJohoPanel2) {
        this.getSakuseiPanel().setKokuhorenKetteiJohoPanel2(KokuhorenKetteiJohoPanel2);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD1() {
        return this.getSakuseiPanel().getKokuhorenKetteiJohoPanel2().getTxtSakuseiYMD1();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD1(TextBoxDate txtSakuseiYMD1) {
        this.getSakuseiPanel().getKokuhorenKetteiJohoPanel2().setTxtSakuseiYMD1(txtSakuseiYMD1);
    }

    @JsonIgnore
    public FurikomiMeisaiJohoPanelDiv getFurikomiMeisaiJohoPanel() {
        return this.getSakuseiPanel().getFurikomiMeisaiJohoPanel();
    }

    @JsonIgnore
    public void  setFurikomiMeisaiJohoPanel(FurikomiMeisaiJohoPanelDiv FurikomiMeisaiJohoPanel) {
        this.getSakuseiPanel().setFurikomiMeisaiJohoPanel(FurikomiMeisaiJohoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD2() {
        return this.getSakuseiPanel().getFurikomiMeisaiJohoPanel().getTxtSakuseiYMD2();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD2(TextBoxDate txtSakuseiYMD2) {
        this.getSakuseiPanel().getFurikomiMeisaiJohoPanel().setTxtSakuseiYMD2(txtSakuseiYMD2);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaisyoUketoriYM() {
        return this.getKokuhorenSoufuJohoPanel().getTxtTaisyoUketoriYM();
    }

    @JsonIgnore
    public void  setTxtTaisyoUketoriYM(TextBoxDate txtTaisyoUketoriYM) {
        this.getKokuhorenSoufuJohoPanel().setTxtTaisyoUketoriYM(txtTaisyoUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKekkaSoufuYM() {
        return this.getKokuhorenSoufuJohoPanel().getTxtKekkaSoufuYM();
    }

    @JsonIgnore
    public void  setTxtKekkaSoufuYM(TextBoxDate txtKekkaSoufuYM) {
        this.getKokuhorenSoufuJohoPanel().setTxtKekkaSoufuYM(txtKekkaSoufuYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiSyaUketoriYM() {
        return this.getKokuhorenSoufuJohoPanel().getTxtKetteiSyaUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKetteiSyaUketoriYM(TextBoxDate txtKetteiSyaUketoriYM) {
        this.getKokuhorenSoufuJohoPanel().setTxtKetteiSyaUketoriYM(txtKetteiSyaUketoriYM);
    }

    // </editor-fold>
}
