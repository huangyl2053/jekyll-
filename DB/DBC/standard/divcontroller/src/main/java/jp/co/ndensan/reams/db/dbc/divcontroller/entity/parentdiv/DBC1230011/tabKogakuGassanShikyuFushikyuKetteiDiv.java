package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKogakuGassanShikyuFushikyuKettei のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class tabKogakuGassanShikyuFushikyuKetteiDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplKettei")
    private tplKetteiDiv tplKettei;
    @JsonProperty("tplShiharai")
    private tplShiharaiDiv tplShiharai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplKettei
     * @return tplKettei
     */
    @JsonProperty("tplKettei")
    public tplKetteiDiv getTplKettei() {
        return tplKettei;
    }

    /*
     * settplKettei
     * @param tplKettei tplKettei
     */
    @JsonProperty("tplKettei")
    public void setTplKettei(tplKetteiDiv tplKettei) {
        this.tplKettei = tplKettei;
    }

    /*
     * gettplShiharai
     * @return tplShiharai
     */
    @JsonProperty("tplShiharai")
    public tplShiharaiDiv getTplShiharai() {
        return tplShiharai;
    }

    /*
     * settplShiharai
     * @param tplShiharai tplShiharai
     */
    @JsonProperty("tplShiharai")
    public void setTplShiharai(tplShiharaiDiv tplShiharai) {
        this.tplShiharai = tplShiharai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtKeisanYMD() {
        return this.getTplKettei().getTxtKeisanYMD();
    }

    @JsonIgnore
    public void setTxtKeisanYMD(TextBoxDateRange txtKeisanYMD) {
        this.getTplKettei().setTxtKeisanYMD(txtKeisanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNo() {
        return this.getTplKettei().getTxtJikoFutanSeiriNo();
    }

    @JsonIgnore
    public void setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.getTplKettei().setTxtJikoFutanSeiriNo(txtJikoFutanSeiriNo);
    }

    @JsonIgnore
    public KogakuGassanShikyuKetteiHoseiDetail1Div getKogakuGassanShikyuKetteiHoseiDetail1() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1();
    }

    @JsonIgnore
    public void setKogakuGassanShikyuKetteiHoseiDetail1(KogakuGassanShikyuKetteiHoseiDetail1Div KogakuGassanShikyuKetteiHoseiDetail1) {
        this.getTplKettei().setKogakuGassanShikyuKetteiHoseiDetail1(KogakuGassanShikyuKetteiHoseiDetail1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanSogaku() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtJikoFutanSogaku();
    }

    @JsonIgnore
    public void setTxtJikoFutanSogaku(TextBoxNum txtJikoFutanSogaku) {
        this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtJikoFutanSogaku(txtJikoFutanSogaku);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunCode() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getRadShikyuKubunCode();
    }

    @JsonIgnore
    public void setRadShikyuKubunCode(RadioButton radShikyuKubunCode) {
        this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setRadShikyuKubunCode(radShikyuKubunCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyugaku() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShikyugaku();
    }

    @JsonIgnore
    public void setTxtShikyugaku(TextBoxNum txtShikyugaku) {
        this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShikyugaku(txtShikyugaku);
    }

    @JsonIgnore
    public KogakuGassanShikyuKetteiHoseiDetail2Div getKogakuGassanShikyuKetteiHoseiDetail2() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2();
    }

    @JsonIgnore
    public void setKogakuGassanShikyuKetteiHoseiDetail2(KogakuGassanShikyuKetteiHoseiDetail2Div KogakuGassanShikyuKetteiHoseiDetail2) {
        this.getTplKettei().setKogakuGassanShikyuKetteiHoseiDetail2(KogakuGassanShikyuKetteiHoseiDetail2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuShurui() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().getTxtKyufuShurui();
    }

    @JsonIgnore
    public void setTxtKyufuShurui(TextBoxMultiLine txtKyufuShurui) {
        this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().setTxtKyufuShurui(txtKyufuShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getTplKettei().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getTplKettei().setLin3(lin3);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getTplKettei().getTxtUketoriYM();
    }

    @JsonIgnore
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getTplKettei().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiSakuseiYMD() {
        return this.getTplKettei().getTxtKetteiTsuchiSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiSakuseiYMD(TextBoxDate txtKetteiTsuchiSakuseiYMD) {
        this.getTplKettei().setTxtKetteiTsuchiSakuseiYMD(txtKetteiTsuchiSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtFurikomiTsuchiSakuseiYMD() {
        return this.getTplKettei().getTxtFurikomiTsuchiSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtFurikomiTsuchiSakuseiYMD(TextBoxDate txtFurikomiTsuchiSakuseiYMD) {
        this.getTplKettei().setTxtFurikomiTsuchiSakuseiYMD(txtFurikomiTsuchiSakuseiYMD);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getTplShiharai().getCcdShiharaiHohoJoho();
    }

    // </editor-fold>
}
