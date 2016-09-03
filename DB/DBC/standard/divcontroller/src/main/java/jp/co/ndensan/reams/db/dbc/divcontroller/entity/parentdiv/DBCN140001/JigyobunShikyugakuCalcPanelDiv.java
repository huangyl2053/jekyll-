package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * JigyobunShikyugakuCalcPanel のクラスファイル
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class JigyobunShikyugakuCalcPanelDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("KoshinNaiyo")
    private KoshinNaiyoDiv KoshinNaiyo;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getKoshinNaiyo
     * @return KoshinNaiyo
     */
    @JsonProperty("KoshinNaiyo")
    public KoshinNaiyoDiv getKoshinNaiyo() {
        return KoshinNaiyo;
    }

    /*
     * setKoshinNaiyo
     * @param KoshinNaiyo KoshinNaiyo
     */
    @JsonProperty("KoshinNaiyo")
    public void setKoshinNaiyo(KoshinNaiyoDiv KoshinNaiyo) {
        this.KoshinNaiyo = KoshinNaiyo;
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
    public RadioButton getRadTaishoshaSearch() {
        return this.getChushutsuJoken().getRadTaishoshaSearch();
    }

    @JsonIgnore
    public void setRadTaishoshaSearch(RadioButton radTaishoshaSearch) {
        this.getChushutsuJoken().setRadTaishoshaSearch(radTaishoshaSearch);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiUketoriYM() {
        return this.getChushutsuJoken().getTxtZenkaiUketoriYM();
    }

    @JsonIgnore
    public void setTxtZenkaiUketoriYM(TextBoxFlexibleDate txtZenkaiUketoriYM) {
        this.getChushutsuJoken().setTxtZenkaiUketoriYM(txtZenkaiUketoriYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiUketoriDate() {
        return this.getChushutsuJoken().getTxtZenkaiUketoriDate();
    }

    @JsonIgnore
    public void setTxtZenkaiUketoriDate(TextBoxFlexibleDate txtZenkaiUketoriDate) {
        this.getChushutsuJoken().setTxtZenkaiUketoriDate(txtZenkaiUketoriDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiUketoriTime() {
        return this.getChushutsuJoken().getTxtZenkaiUketoriTime();
    }

    @JsonIgnore
    public void setTxtZenkaiUketoriTime(TextBoxTime txtZenkaiUketoriTime) {
        this.getChushutsuJoken().setTxtZenkaiUketoriTime(txtZenkaiUketoriTime);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtUketoriYM() {
        return this.getChushutsuJoken().getTxtUketoriYM();
    }

    @JsonIgnore
    public void setTxtUketoriYM(TextBoxFlexibleDate txtUketoriYM) {
        this.getChushutsuJoken().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaNoShitei() {
        return this.getChushutsuJoken().getRadHihokenshaNoShitei();
    }

    @JsonIgnore
    public void setRadHihokenshaNoShitei(RadioButton radHihokenshaNoShitei) {
        this.getChushutsuJoken().setRadHihokenshaNoShitei(radHihokenshaNoShitei);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getChushutsuJoken().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getChushutsuJoken().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaSearch() {
        return this.getChushutsuJoken().getBtnHihokenshaSearch();
    }

    @JsonIgnore
    public void setBtnHihokenshaSearch(ButtonDialog btnHihokenshaSearch) {
        this.getChushutsuJoken().setBtnHihokenshaSearch(btnHihokenshaSearch);
    }

    @JsonIgnore
    public DropDownList getDdlNendo() {
        return this.getChushutsuJoken().getDdlNendo();
    }

    @JsonIgnore
    public void setDdlNendo(DropDownList ddlNendo) {
        this.getChushutsuJoken().setDdlNendo(ddlNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return this.getKoshinNaiyo().getTxtKetteiDate();
    }

    @JsonIgnore
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.getKoshinNaiyo().setTxtKetteiDate(txtKetteiDate);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufunoShurui() {
        return this.getKoshinNaiyo().getTxtKyufunoShurui();
    }

    @JsonIgnore
    public void setTxtKyufunoShurui(TextBoxMultiLine txtKyufunoShurui) {
        this.getKoshinNaiyo().setTxtKyufunoShurui(txtKyufunoShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return this.getKoshinNaiyo().getTxtFushikyuRiyu();
    }

    @JsonIgnore
    public void setTxtFushikyuRiyu(TextBoxMultiLine txtFushikyuRiyu) {
        this.getKoshinNaiyo().setTxtFushikyuRiyu(txtFushikyuRiyu);
    }

    @JsonIgnore
    public MadoguchibaraiJohoDiv getMadoguchibaraiJoho() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho();
    }

    @JsonIgnore
    public void setMadoguchibaraiJoho(MadoguchibaraiJohoDiv MadoguchibaraiJoho) {
        this.getKoshinNaiyo().setMadoguchibaraiJoho(MadoguchibaraiJoho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShiharaiBasho() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getTxtShiharaiBasho();
    }

    @JsonIgnore
    public void setTxtShiharaiBasho(TextBoxMultiLine txtShiharaiBasho) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setTxtShiharaiBasho(txtShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaishiDate() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getTxtKaishiDate();
    }

    @JsonIgnore
    public void setTxtKaishiDate(TextBoxFlexibleDate txtKaishiDate) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setTxtKaishiDate(txtKaishiDate);
    }

    @JsonIgnore
    public TextBox getTxtKaishiYobi() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getTxtKaishiYobi();
    }

    @JsonIgnore
    public void setTxtKaishiYobi(TextBox txtKaishiYobi) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setTxtKaishiYobi(txtKaishiYobi);
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiTime() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getTxtKaishiTime();
    }

    @JsonIgnore
    public void setTxtKaishiTime(TextBoxTime txtKaishiTime) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setTxtKaishiTime(txtKaishiTime);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShuryoDate() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getTxtShuryoDate();
    }

    @JsonIgnore
    public void setTxtShuryoDate(TextBoxFlexibleDate txtShuryoDate) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setTxtShuryoDate(txtShuryoDate);
    }

    @JsonIgnore
    public TextBox getTxtShuryoYobi() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getTxtShuryoYobi();
    }

    @JsonIgnore
    public void setTxtShuryoYobi(TextBox txtShuryoYobi) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setTxtShuryoYobi(txtShuryoYobi);
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoTime() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getTxtShuryoTime();
    }

    @JsonIgnore
    public void setTxtShuryoTime(TextBoxTime txtShuryoTime) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setTxtShuryoTime(txtShuryoTime);
    }

    @JsonIgnore
    public Label getLblChuiGaki1() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getLblChuiGaki1();
    }

    @JsonIgnore
    public void setLblChuiGaki1(Label lblChuiGaki1) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setLblChuiGaki1(lblChuiGaki1);
    }

    @JsonIgnore
    public Label getLblChuiGaki2() {
        return this.getKoshinNaiyo().getMadoguchibaraiJoho().getLblChuiGaki2();
    }

    @JsonIgnore
    public void setLblChuiGaki2(Label lblChuiGaki2) {
        this.getKoshinNaiyo().getMadoguchibaraiJoho().setLblChuiGaki2(lblChuiGaki2);
    }

    // </editor-fold>
}
