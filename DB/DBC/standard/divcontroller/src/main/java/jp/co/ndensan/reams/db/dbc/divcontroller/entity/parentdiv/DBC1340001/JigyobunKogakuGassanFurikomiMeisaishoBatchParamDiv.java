package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JigyobunKogakuGassanFurikomiMeisaishoBatchParam のクラスファイル
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TyuusyutuJyoukenn")
    private TyuusyutuJyoukennDiv TyuusyutuJyoukenn;
    @JsonProperty("TyuusyutuHanni")
    private TyuusyutuHanniDiv TyuusyutuHanni;
    @JsonProperty("ShuturyokuTyouhyou")
    private ShuturyokuTyouhyouDiv ShuturyokuTyouhyou;
    @JsonProperty("torihikiKinyukikanShitennmei")
    private RString torihikiKinyukikanShitennmei;
    @JsonProperty("fdSakusei")
    private RString fdSakusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTyuusyutuJyoukenn
     * @return TyuusyutuJyoukenn
     */
    @JsonProperty("TyuusyutuJyoukenn")
    public TyuusyutuJyoukennDiv getTyuusyutuJyoukenn() {
        return TyuusyutuJyoukenn;
    }

    /*
     * setTyuusyutuJyoukenn
     * @param TyuusyutuJyoukenn TyuusyutuJyoukenn
     */
    @JsonProperty("TyuusyutuJyoukenn")
    public void setTyuusyutuJyoukenn(TyuusyutuJyoukennDiv TyuusyutuJyoukenn) {
        this.TyuusyutuJyoukenn = TyuusyutuJyoukenn;
    }

    /*
     * getTyuusyutuHanni
     * @return TyuusyutuHanni
     */
    @JsonProperty("TyuusyutuHanni")
    public TyuusyutuHanniDiv getTyuusyutuHanni() {
        return TyuusyutuHanni;
    }

    /*
     * setTyuusyutuHanni
     * @param TyuusyutuHanni TyuusyutuHanni
     */
    @JsonProperty("TyuusyutuHanni")
    public void setTyuusyutuHanni(TyuusyutuHanniDiv TyuusyutuHanni) {
        this.TyuusyutuHanni = TyuusyutuHanni;
    }

    /*
     * getShuturyokuTyouhyou
     * @return ShuturyokuTyouhyou
     */
    @JsonProperty("ShuturyokuTyouhyou")
    public ShuturyokuTyouhyouDiv getShuturyokuTyouhyou() {
        return ShuturyokuTyouhyou;
    }

    /*
     * setShuturyokuTyouhyou
     * @param ShuturyokuTyouhyou ShuturyokuTyouhyou
     */
    @JsonProperty("ShuturyokuTyouhyou")
    public void setShuturyokuTyouhyou(ShuturyokuTyouhyouDiv ShuturyokuTyouhyou) {
        this.ShuturyokuTyouhyou = ShuturyokuTyouhyou;
    }

    /*
     * gettorihikiKinyukikanShitennmei
     * @return torihikiKinyukikanShitennmei
     */
    @JsonProperty("torihikiKinyukikanShitennmei")
    public RString getTorihikiKinyukikanShitennmei() {
        return torihikiKinyukikanShitennmei;
    }

    /*
     * settorihikiKinyukikanShitennmei
     * @param torihikiKinyukikanShitennmei torihikiKinyukikanShitennmei
     */
    @JsonProperty("torihikiKinyukikanShitennmei")
    public void setTorihikiKinyukikanShitennmei(RString torihikiKinyukikanShitennmei) {
        this.torihikiKinyukikanShitennmei = torihikiKinyukikanShitennmei;
    }

    /*
     * getfdSakusei
     * @return fdSakusei
     */
    @JsonProperty("fdSakusei")
    public RString getFdSakusei() {
        return fdSakusei;
    }

    /*
     * setfdSakusei
     * @param fdSakusei fdSakusei
     */
    @JsonProperty("fdSakusei")
    public void setFdSakusei(RString fdSakusei) {
        this.fdSakusei = fdSakusei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSiharaihouhou() {
        return this.getTyuusyutuJyoukenn().getRadSiharaihouhou();
    }

    @JsonIgnore
    public void setRadSiharaihouhou(RadioButton radSiharaihouhou) {
        this.getTyuusyutuJyoukenn().setRadSiharaihouhou(radSiharaihouhou);
    }

    @JsonIgnore
    public TextBox getTxtItakusya() {
        return this.getTyuusyutuJyoukenn().getTxtItakusya();
    }

    @JsonIgnore
    public void setTxtItakusya(TextBox txtItakusya) {
        this.getTyuusyutuJyoukenn().setTxtItakusya(txtItakusya);
    }

    @JsonIgnore
    public TextBoxCode getTxtItakusyaCode() {
        return this.getTyuusyutuJyoukenn().getTxtItakusyaCode();
    }

    @JsonIgnore
    public void setTxtItakusyaCode(TextBoxCode txtItakusyaCode) {
        this.getTyuusyutuJyoukenn().setTxtItakusyaCode(txtItakusyaCode);
    }

    @JsonIgnore
    public TextBox getTxtTorihikiKinyukikan() {
        return this.getTyuusyutuJyoukenn().getTxtTorihikiKinyukikan();
    }

    @JsonIgnore
    public void setTxtTorihikiKinyukikan(TextBox txtTorihikiKinyukikan) {
        this.getTyuusyutuJyoukenn().setTxtTorihikiKinyukikan(txtTorihikiKinyukikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtZennkaiTaisyouNenngappi() {
        return this.getTyuusyutuHanni().getTxtZennkaiTaisyouNenngappi();
    }

    @JsonIgnore
    public void setTxtZennkaiTaisyouNenngappi(TextBoxDateRange txtZennkaiTaisyouNenngappi) {
        this.getTyuusyutuHanni().setTxtZennkaiTaisyouNenngappi(txtZennkaiTaisyouNenngappi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKonnkaiTaisyouNenngappi() {
        return this.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi();
    }

    @JsonIgnore
    public void setTxtKonnkaiTaisyouNenngappi(TextBoxDateRange txtKonnkaiTaisyouNenngappi) {
        this.getTyuusyutuHanni().setTxtKonnkaiTaisyouNenngappi(txtKonnkaiTaisyouNenngappi);
    }

    @JsonIgnore
    public DropDownList getDdlHakkouTaisyou() {
        return this.getTyuusyutuHanni().getDdlHakkouTaisyou();
    }

    @JsonIgnore
    public void setDdlHakkouTaisyou(DropDownList ddlHakkouTaisyou) {
        this.getTyuusyutuHanni().setDdlHakkouTaisyou(ddlHakkouTaisyou);
    }

    @JsonIgnore
    public TextBoxDate getTxt() {
        return this.getTyuusyutuHanni().getTxt();
    }

    @JsonIgnore
    public void setTxt(TextBoxDate txt) {
        this.getTyuusyutuHanni().setTxt(txt);
    }

    @JsonIgnore
    public DropDownList getDdlSyuturyokuTyouhyou() {
        return this.getShuturyokuTyouhyou().getDdlSyuturyokuTyouhyou();
    }

    @JsonIgnore
    public void setDdlSyuturyokuTyouhyou(DropDownList ddlSyuturyokuTyouhyou) {
        this.getShuturyokuTyouhyou().setDdlSyuturyokuTyouhyou(ddlSyuturyokuTyouhyou);
    }

    @JsonIgnore
    public CheckBoxList getChkFDDataSakusei() {
        return this.getShuturyokuTyouhyou().getChkFDDataSakusei();
    }

    @JsonIgnore
    public void setChkFDDataSakusei(CheckBoxList chkFDDataSakusei) {
        this.getShuturyokuTyouhyou().setChkFDDataSakusei(chkFDDataSakusei);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseibi() {
        return this.getShuturyokuTyouhyou().getTxtSakuseibi();
    }

    @JsonIgnore
    public void setTxtSakuseibi(TextBoxDate txtSakuseibi) {
        this.getShuturyokuTyouhyou().setTxtSakuseibi(txtSakuseibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtIraibi() {
        return this.getShuturyokuTyouhyou().getTxtIraibi();
    }

    @JsonIgnore
    public void setTxtIraibi(TextBoxDate txtIraibi) {
        this.getShuturyokuTyouhyou().setTxtIraibi(txtIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtFurikomiSiteibi() {
        return this.getShuturyokuTyouhyou().getTxtFurikomiSiteibi();
    }

    @JsonIgnore
    public void setTxtFurikomiSiteibi(TextBoxDate txtFurikomiSiteibi) {
        this.getShuturyokuTyouhyou().setTxtFurikomiSiteibi(txtFurikomiSiteibi);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShusuryokujun() {
        return this.getShuturyokuTyouhyou().getCcdChohyoShusuryokujun();
    }

    // </editor-fold>
}
