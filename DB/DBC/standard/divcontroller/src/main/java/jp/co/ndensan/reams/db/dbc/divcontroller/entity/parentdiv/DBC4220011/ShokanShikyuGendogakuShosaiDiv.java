package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuGendogakuShosai のクラスファイル
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShikyuGendogakuShosaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoKikanRange")
    private TextBoxDateRange txtTekiyoKikanRange;
    @JsonProperty("lin01")
    private HorizontalLine lin01;
    @JsonProperty("lblMassage2")
    private Label lblMassage2;
    @JsonProperty("radTableKubun")
    private RadioButton radTableKubun;
    @JsonProperty("spc01")
    private Space spc01;
    @JsonProperty("tblGendogaku")
    private tblGendogakuDiv tblGendogaku;
    @JsonProperty("ShokanShikyuGendogakuShosaiFooter")
    private ShokanShikyuGendogakuShosaiFooterDiv ShokanShikyuGendogakuShosaiFooter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoKikanRange
     * @return txtTekiyoKikanRange
     */
    @JsonProperty("txtTekiyoKikanRange")
    public TextBoxDateRange getTxtTekiyoKikanRange() {
        return txtTekiyoKikanRange;
    }

    /*
     * settxtTekiyoKikanRange
     * @param txtTekiyoKikanRange txtTekiyoKikanRange
     */
    @JsonProperty("txtTekiyoKikanRange")
    public void setTxtTekiyoKikanRange(TextBoxDateRange txtTekiyoKikanRange) {
        this.txtTekiyoKikanRange = txtTekiyoKikanRange;
    }

    /*
     * getlin01
     * @return lin01
     */
    @JsonProperty("lin01")
    public HorizontalLine getLin01() {
        return lin01;
    }

    /*
     * setlin01
     * @param lin01 lin01
     */
    @JsonProperty("lin01")
    public void setLin01(HorizontalLine lin01) {
        this.lin01 = lin01;
    }

    /*
     * getlblMassage2
     * @return lblMassage2
     */
    @JsonProperty("lblMassage2")
    public Label getLblMassage2() {
        return lblMassage2;
    }

    /*
     * setlblMassage2
     * @param lblMassage2 lblMassage2
     */
    @JsonProperty("lblMassage2")
    public void setLblMassage2(Label lblMassage2) {
        this.lblMassage2 = lblMassage2;
    }

    /*
     * getradTableKubun
     * @return radTableKubun
     */
    @JsonProperty("radTableKubun")
    public RadioButton getRadTableKubun() {
        return radTableKubun;
    }

    /*
     * setradTableKubun
     * @param radTableKubun radTableKubun
     */
    @JsonProperty("radTableKubun")
    public void setRadTableKubun(RadioButton radTableKubun) {
        this.radTableKubun = radTableKubun;
    }

    /*
     * getspc01
     * @return spc01
     */
    @JsonProperty("spc01")
    public Space getSpc01() {
        return spc01;
    }

    /*
     * setspc01
     * @param spc01 spc01
     */
    @JsonProperty("spc01")
    public void setSpc01(Space spc01) {
        this.spc01 = spc01;
    }

    /*
     * gettblGendogaku
     * @return tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public tblGendogakuDiv getTblGendogaku() {
        return tblGendogaku;
    }

    /*
     * settblGendogaku
     * @param tblGendogaku tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public void setTblGendogaku(tblGendogakuDiv tblGendogaku) {
        this.tblGendogaku = tblGendogaku;
    }

    /*
     * getShokanShikyuGendogakuShosaiFooter
     * @return ShokanShikyuGendogakuShosaiFooter
     */
    @JsonProperty("ShokanShikyuGendogakuShosaiFooter")
    public ShokanShikyuGendogakuShosaiFooterDiv getShokanShikyuGendogakuShosaiFooter() {
        return ShokanShikyuGendogakuShosaiFooter;
    }

    /*
     * setShokanShikyuGendogakuShosaiFooter
     * @param ShokanShikyuGendogakuShosaiFooter ShokanShikyuGendogakuShosaiFooter
     */
    @JsonProperty("ShokanShikyuGendogakuShosaiFooter")
    public void setShokanShikyuGendogakuShosaiFooter(ShokanShikyuGendogakuShosaiFooterDiv ShokanShikyuGendogakuShosaiFooter) {
        this.ShokanShikyuGendogakuShosaiFooter = ShokanShikyuGendogakuShosaiFooter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKyotakuKaigo() {
        return this.getTblGendogaku().getLblKyotakuKaigo();
    }

    @JsonIgnore
    public Label getLblKyotakuShien() {
        return this.getTblGendogaku().getLblKyotakuShien();
    }

    @JsonIgnore
    public Label getLblKyotakuKaigoFukushiYogu() {
        return this.getTblGendogaku().getLblKyotakuKaigoFukushiYogu();
    }

    @JsonIgnore
    public Label getLblKyotakuKaigoJutakuKaishu() {
        return this.getTblGendogaku().getLblKyotakuKaigoJutakuKaishu();
    }

    @JsonIgnore
    public Label getLblKyotakuShienFukushiYogu() {
        return this.getTblGendogaku().getLblKyotakuShienFukushiYogu();
    }

    @JsonIgnore
    public Label getLblKyotakuShienJutakuKaishu() {
        return this.getTblGendogaku().getLblKyotakuShienJutakuKaishu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuKaigoFukushiYogu() {
        return this.getTblGendogaku().getTxtKyotakuKaigoFukushiYogu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuKaigoJutakuKaishu() {
        return this.getTblGendogaku().getTxtKyotakuKaigoJutakuKaishu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuShienFukushiYogu() {
        return this.getTblGendogaku().getTxtKyotakuShienFukushiYogu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyotakuShienJutakuKaishu() {
        return this.getTblGendogaku().getTxtKyotakuShienJutakuKaishu();
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getShokanShikyuGendogakuShosaiFooter().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getShokanShikyuGendogakuShosaiFooter().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
