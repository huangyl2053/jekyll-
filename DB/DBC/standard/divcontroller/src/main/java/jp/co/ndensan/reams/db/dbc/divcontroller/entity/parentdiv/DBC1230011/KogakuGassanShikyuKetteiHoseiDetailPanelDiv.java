package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KogakuGassanShikyuKetteiHoseiDetailPanel のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiDetailPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtStatusFlg")
    private TextBox txtStatusFlg;
    @JsonProperty("txtTaishoNendo")
    private TextBoxDate txtTaishoNendo;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShikyuSeiriNo")
    private TextBox txtShikyuSeiriNo;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("tabKogakuGassanShikyuFushikyuKettei")
    private tabKogakuGassanShikyuFushikyuKetteiDiv tabKogakuGassanShikyuFushikyuKettei;
    @JsonProperty("btnIchiramModoru")
    private Button btnIchiramModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtStatusFlg
     * @return txtStatusFlg
     */
    @JsonProperty("txtStatusFlg")
    public TextBox getTxtStatusFlg() {
        return txtStatusFlg;
    }

    /*
     * settxtStatusFlg
     * @param txtStatusFlg txtStatusFlg
     */
    @JsonProperty("txtStatusFlg")
    public void setTxtStatusFlg(TextBox txtStatusFlg) {
        this.txtStatusFlg = txtStatusFlg;
    }

    /*
     * gettxtTaishoNendo
     * @return txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public TextBoxDate getTxtTaishoNendo() {
        return txtTaishoNendo;
    }

    /*
     * settxtTaishoNendo
     * @param txtTaishoNendo txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public void setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.txtTaishoNendo = txtTaishoNendo;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtShikyuSeiriNo
     * @return txtShikyuSeiriNo
     */
    @JsonProperty("txtShikyuSeiriNo")
    public TextBox getTxtShikyuSeiriNo() {
        return txtShikyuSeiriNo;
    }

    /*
     * settxtShikyuSeiriNo
     * @param txtShikyuSeiriNo txtShikyuSeiriNo
     */
    @JsonProperty("txtShikyuSeiriNo")
    public void setTxtShikyuSeiriNo(TextBox txtShikyuSeiriNo) {
        this.txtShikyuSeiriNo = txtShikyuSeiriNo;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * gettabKogakuGassanShikyuFushikyuKettei
     * @return tabKogakuGassanShikyuFushikyuKettei
     */
    @JsonProperty("tabKogakuGassanShikyuFushikyuKettei")
    public tabKogakuGassanShikyuFushikyuKetteiDiv getTabKogakuGassanShikyuFushikyuKettei() {
        return tabKogakuGassanShikyuFushikyuKettei;
    }

    /*
     * settabKogakuGassanShikyuFushikyuKettei
     * @param tabKogakuGassanShikyuFushikyuKettei tabKogakuGassanShikyuFushikyuKettei
     */
    @JsonProperty("tabKogakuGassanShikyuFushikyuKettei")
    public void setTabKogakuGassanShikyuFushikyuKettei(tabKogakuGassanShikyuFushikyuKetteiDiv tabKogakuGassanShikyuFushikyuKettei) {
        this.tabKogakuGassanShikyuFushikyuKettei = tabKogakuGassanShikyuFushikyuKettei;
    }

    /*
     * getbtnIchiramModoru
     * @return btnIchiramModoru
     */
    @JsonProperty("btnIchiramModoru")
    public Button getBtnIchiramModoru() {
        return btnIchiramModoru;
    }

    /*
     * setbtnIchiramModoru
     * @param btnIchiramModoru btnIchiramModoru
     */
    @JsonProperty("btnIchiramModoru")
    public void setBtnIchiramModoru(Button btnIchiramModoru) {
        this.btnIchiramModoru = btnIchiramModoru;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplKetteiDiv getTplKettei() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei();
    }

    @JsonIgnore
    public void setTplKettei(tplKetteiDiv tplKettei) {
        this.getTabKogakuGassanShikyuFushikyuKettei().setTplKettei(tplKettei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKeisanYMD() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtKeisanYMD();
    }

    @JsonIgnore
    public void setTxtKeisanYMD(TextBoxDateRange txtKeisanYMD) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtKeisanYMD(txtKeisanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNo() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtJikoFutanSeiriNo();
    }

    @JsonIgnore
    public void setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtJikoFutanSeiriNo(txtJikoFutanSeiriNo);
    }

    @JsonIgnore
    public KogakuGassanShikyuKetteiHoseiDetail1Div getKogakuGassanShikyuKetteiHoseiDetail1() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1();
    }

    @JsonIgnore
    public void setKogakuGassanShikyuKetteiHoseiDetail1(KogakuGassanShikyuKetteiHoseiDetail1Div KogakuGassanShikyuKetteiHoseiDetail1) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setKogakuGassanShikyuKetteiHoseiDetail1(KogakuGassanShikyuKetteiHoseiDetail1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanSogaku() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtJikoFutanSogaku();
    }

    @JsonIgnore
    public void setTxtJikoFutanSogaku(TextBoxNum txtJikoFutanSogaku) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtJikoFutanSogaku(txtJikoFutanSogaku);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunCode() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getRadShikyuKubunCode();
    }

    @JsonIgnore
    public void setRadShikyuKubunCode(RadioButton radShikyuKubunCode) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setRadShikyuKubunCode(radShikyuKubunCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyugaku() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShikyugaku();
    }

    @JsonIgnore
    public void setTxtShikyugaku(TextBoxNum txtShikyugaku) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShikyugaku(txtShikyugaku);
    }

    @JsonIgnore
    public KogakuGassanShikyuKetteiHoseiDetail2Div getKogakuGassanShikyuKetteiHoseiDetail2() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2();
    }

    @JsonIgnore
    public void setKogakuGassanShikyuKetteiHoseiDetail2(KogakuGassanShikyuKetteiHoseiDetail2Div KogakuGassanShikyuKetteiHoseiDetail2) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setKogakuGassanShikyuKetteiHoseiDetail2(KogakuGassanShikyuKetteiHoseiDetail2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuShurui() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().getTxtKyufuShurui();
    }

    @JsonIgnore
    public void setTxtKyufuShurui(TextBoxMultiLine txtKyufuShurui) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().setTxtKyufuShurui(txtKyufuShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setLin3(lin3);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtUketoriYM();
    }

    @JsonIgnore
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiSakuseiYMD() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtKetteiTsuchiSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiSakuseiYMD(TextBoxDate txtKetteiTsuchiSakuseiYMD) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtKetteiTsuchiSakuseiYMD(txtKetteiTsuchiSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtFurikomiTsuchiSakuseiYMD() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtFurikomiTsuchiSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtFurikomiTsuchiSakuseiYMD(TextBoxDate txtFurikomiTsuchiSakuseiYMD) {
        this.getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtFurikomiTsuchiSakuseiYMD(txtFurikomiTsuchiSakuseiYMD);
    }

    @JsonIgnore
    public tplShiharaiDiv getTplShiharai() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplShiharai();
    }

    @JsonIgnore
    public void setTplShiharai(tplShiharaiDiv tplShiharai) {
        this.getTabKogakuGassanShikyuFushikyuKettei().setTplShiharai(tplShiharai);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getTabKogakuGassanShikyuFushikyuKettei().getTplShiharai().getCcdShiharaiHohoJoho();
    }

    // </editor-fold>
}
