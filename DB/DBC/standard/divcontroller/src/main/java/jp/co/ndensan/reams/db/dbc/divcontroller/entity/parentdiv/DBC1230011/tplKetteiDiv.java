package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * tplKettei のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class tplKetteiDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeisanYMD")
    private TextBoxDateRange txtKeisanYMD;
    @JsonProperty("txtJikoFutanSeiriNo")
    private TextBox txtJikoFutanSeiriNo;
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetail1")
    private KogakuGassanShikyuKetteiHoseiDetail1Div KogakuGassanShikyuKetteiHoseiDetail1;
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetail2")
    private KogakuGassanShikyuKetteiHoseiDetail2Div KogakuGassanShikyuKetteiHoseiDetail2;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("txtUketoriYM")
    private TextBoxDate txtUketoriYM;
    @JsonProperty("txtKetteiTsuchiSakuseiYMD")
    private TextBoxDate txtKetteiTsuchiSakuseiYMD;
    @JsonProperty("txtFurikomiTsuchiSakuseiYMD")
    private TextBoxDate txtFurikomiTsuchiSakuseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKeisanYMD
     * @return txtKeisanYMD
     */
    @JsonProperty("txtKeisanYMD")
    public TextBoxDateRange getTxtKeisanYMD() {
        return txtKeisanYMD;
    }

    /*
     * settxtKeisanYMD
     * @param txtKeisanYMD txtKeisanYMD
     */
    @JsonProperty("txtKeisanYMD")
    public void setTxtKeisanYMD(TextBoxDateRange txtKeisanYMD) {
        this.txtKeisanYMD = txtKeisanYMD;
    }

    /*
     * gettxtJikoFutanSeiriNo
     * @return txtJikoFutanSeiriNo
     */
    @JsonProperty("txtJikoFutanSeiriNo")
    public TextBox getTxtJikoFutanSeiriNo() {
        return txtJikoFutanSeiriNo;
    }

    /*
     * settxtJikoFutanSeiriNo
     * @param txtJikoFutanSeiriNo txtJikoFutanSeiriNo
     */
    @JsonProperty("txtJikoFutanSeiriNo")
    public void setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.txtJikoFutanSeiriNo = txtJikoFutanSeiriNo;
    }

    /*
     * getKogakuGassanShikyuKetteiHoseiDetail1
     * @return KogakuGassanShikyuKetteiHoseiDetail1
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetail1")
    public KogakuGassanShikyuKetteiHoseiDetail1Div getKogakuGassanShikyuKetteiHoseiDetail1() {
        return KogakuGassanShikyuKetteiHoseiDetail1;
    }

    /*
     * setKogakuGassanShikyuKetteiHoseiDetail1
     * @param KogakuGassanShikyuKetteiHoseiDetail1 KogakuGassanShikyuKetteiHoseiDetail1
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetail1")
    public void setKogakuGassanShikyuKetteiHoseiDetail1(KogakuGassanShikyuKetteiHoseiDetail1Div KogakuGassanShikyuKetteiHoseiDetail1) {
        this.KogakuGassanShikyuKetteiHoseiDetail1 = KogakuGassanShikyuKetteiHoseiDetail1;
    }

    /*
     * getKogakuGassanShikyuKetteiHoseiDetail2
     * @return KogakuGassanShikyuKetteiHoseiDetail2
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetail2")
    public KogakuGassanShikyuKetteiHoseiDetail2Div getKogakuGassanShikyuKetteiHoseiDetail2() {
        return KogakuGassanShikyuKetteiHoseiDetail2;
    }

    /*
     * setKogakuGassanShikyuKetteiHoseiDetail2
     * @param KogakuGassanShikyuKetteiHoseiDetail2 KogakuGassanShikyuKetteiHoseiDetail2
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetail2")
    public void setKogakuGassanShikyuKetteiHoseiDetail2(KogakuGassanShikyuKetteiHoseiDetail2Div KogakuGassanShikyuKetteiHoseiDetail2) {
        this.KogakuGassanShikyuKetteiHoseiDetail2 = KogakuGassanShikyuKetteiHoseiDetail2;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * gettxtUketoriYM
     * @return txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public TextBoxDate getTxtUketoriYM() {
        return txtUketoriYM;
    }

    /*
     * settxtUketoriYM
     * @param txtUketoriYM txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.txtUketoriYM = txtUketoriYM;
    }

    /*
     * gettxtKetteiTsuchiSakuseiYMD
     * @return txtKetteiTsuchiSakuseiYMD
     */
    @JsonProperty("txtKetteiTsuchiSakuseiYMD")
    public TextBoxDate getTxtKetteiTsuchiSakuseiYMD() {
        return txtKetteiTsuchiSakuseiYMD;
    }

    /*
     * settxtKetteiTsuchiSakuseiYMD
     * @param txtKetteiTsuchiSakuseiYMD txtKetteiTsuchiSakuseiYMD
     */
    @JsonProperty("txtKetteiTsuchiSakuseiYMD")
    public void setTxtKetteiTsuchiSakuseiYMD(TextBoxDate txtKetteiTsuchiSakuseiYMD) {
        this.txtKetteiTsuchiSakuseiYMD = txtKetteiTsuchiSakuseiYMD;
    }

    /*
     * gettxtFurikomiTsuchiSakuseiYMD
     * @return txtFurikomiTsuchiSakuseiYMD
     */
    @JsonProperty("txtFurikomiTsuchiSakuseiYMD")
    public TextBoxDate getTxtFurikomiTsuchiSakuseiYMD() {
        return txtFurikomiTsuchiSakuseiYMD;
    }

    /*
     * settxtFurikomiTsuchiSakuseiYMD
     * @param txtFurikomiTsuchiSakuseiYMD txtFurikomiTsuchiSakuseiYMD
     */
    @JsonProperty("txtFurikomiTsuchiSakuseiYMD")
    public void setTxtFurikomiTsuchiSakuseiYMD(TextBoxDate txtFurikomiTsuchiSakuseiYMD) {
        this.txtFurikomiTsuchiSakuseiYMD = txtFurikomiTsuchiSakuseiYMD;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getKogakuGassanShikyuKetteiHoseiDetail1().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getKogakuGassanShikyuKetteiHoseiDetail1().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanSogaku() {
        return this.getKogakuGassanShikyuKetteiHoseiDetail1().getTxtJikoFutanSogaku();
    }

    @JsonIgnore
    public void setTxtJikoFutanSogaku(TextBoxNum txtJikoFutanSogaku) {
        this.getKogakuGassanShikyuKetteiHoseiDetail1().setTxtJikoFutanSogaku(txtJikoFutanSogaku);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunCode() {
        return this.getKogakuGassanShikyuKetteiHoseiDetail1().getRadShikyuKubunCode();
    }

    @JsonIgnore
    public void setRadShikyuKubunCode(RadioButton radShikyuKubunCode) {
        this.getKogakuGassanShikyuKetteiHoseiDetail1().setRadShikyuKubunCode(radShikyuKubunCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyugaku() {
        return this.getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShikyugaku();
    }

    @JsonIgnore
    public void setTxtShikyugaku(TextBoxNum txtShikyugaku) {
        this.getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShikyugaku(txtShikyugaku);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuShurui() {
        return this.getKogakuGassanShikyuKetteiHoseiDetail2().getTxtKyufuShurui();
    }

    @JsonIgnore
    public void setTxtKyufuShurui(TextBoxMultiLine txtKyufuShurui) {
        this.getKogakuGassanShikyuKetteiHoseiDetail2().setTxtKyufuShurui(txtKyufuShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getKogakuGassanShikyuKetteiHoseiDetail2().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getKogakuGassanShikyuKetteiHoseiDetail2().setTxtBiko(txtBiko);
    }

    // </editor-fold>
}
