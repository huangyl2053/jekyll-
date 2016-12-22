package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiIkenshoKensakujoken")
    private ShujiiIkenshoKensakujokenDiv ShujiiIkenshoKensakujoken;
    @JsonProperty("ShujiiIkenshoSakuseiIraiTaishoIchiran")
    private ShujiiIkenshoSakuseiIraiTaishoIchiranDiv ShujiiIkenshoSakuseiIraiTaishoIchiran;
    @JsonProperty("ShujiiIkenshoInsatsuChohyo")
    private ShujiiIkenshoInsatsuChohyoDiv ShujiiIkenshoInsatsuChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShujiiIkenshoKensakujoken
     * @return ShujiiIkenshoKensakujoken
     */
    @JsonProperty("ShujiiIkenshoKensakujoken")
    public ShujiiIkenshoKensakujokenDiv getShujiiIkenshoKensakujoken() {
        return ShujiiIkenshoKensakujoken;
    }

    /*
     * setShujiiIkenshoKensakujoken
     * @param ShujiiIkenshoKensakujoken ShujiiIkenshoKensakujoken
     */
    @JsonProperty("ShujiiIkenshoKensakujoken")
    public void setShujiiIkenshoKensakujoken(ShujiiIkenshoKensakujokenDiv ShujiiIkenshoKensakujoken) {
        this.ShujiiIkenshoKensakujoken = ShujiiIkenshoKensakujoken;
    }

    /*
     * getShujiiIkenshoSakuseiIraiTaishoIchiran
     * @return ShujiiIkenshoSakuseiIraiTaishoIchiran
     */
    @JsonProperty("ShujiiIkenshoSakuseiIraiTaishoIchiran")
    public ShujiiIkenshoSakuseiIraiTaishoIchiranDiv getShujiiIkenshoSakuseiIraiTaishoIchiran() {
        return ShujiiIkenshoSakuseiIraiTaishoIchiran;
    }

    /*
     * setShujiiIkenshoSakuseiIraiTaishoIchiran
     * @param ShujiiIkenshoSakuseiIraiTaishoIchiran ShujiiIkenshoSakuseiIraiTaishoIchiran
     */
    @JsonProperty("ShujiiIkenshoSakuseiIraiTaishoIchiran")
    public void setShujiiIkenshoSakuseiIraiTaishoIchiran(ShujiiIkenshoSakuseiIraiTaishoIchiranDiv ShujiiIkenshoSakuseiIraiTaishoIchiran) {
        this.ShujiiIkenshoSakuseiIraiTaishoIchiran = ShujiiIkenshoSakuseiIraiTaishoIchiran;
    }

    /*
     * getShujiiIkenshoInsatsuChohyo
     * @return ShujiiIkenshoInsatsuChohyo
     */
    @JsonProperty("ShujiiIkenshoInsatsuChohyo")
    public ShujiiIkenshoInsatsuChohyoDiv getShujiiIkenshoInsatsuChohyo() {
        return ShujiiIkenshoInsatsuChohyo;
    }

    /*
     * setShujiiIkenshoInsatsuChohyo
     * @param ShujiiIkenshoInsatsuChohyo ShujiiIkenshoInsatsuChohyo
     */
    @JsonProperty("ShujiiIkenshoInsatsuChohyo")
    public void setShujiiIkenshoInsatsuChohyo(ShujiiIkenshoInsatsuChohyoDiv ShujiiIkenshoInsatsuChohyo) {
        this.ShujiiIkenshoInsatsuChohyo = ShujiiIkenshoInsatsuChohyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoSakuseiIraibiFrom() {
        return this.getShujiiIkenshoKensakujoken().getTxtShujiiIkenshoSakuseiIraibiFrom();
    }

    @JsonIgnore
    public void  setTxtShujiiIkenshoSakuseiIraibiFrom(TextBoxDate txtShujiiIkenshoSakuseiIraibiFrom) {
        this.getShujiiIkenshoKensakujoken().setTxtShujiiIkenshoSakuseiIraibiFrom(txtShujiiIkenshoSakuseiIraibiFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoSakuseiIraibiTo() {
        return this.getShujiiIkenshoKensakujoken().getTxtShujiiIkenshoSakuseiIraibiTo();
    }

    @JsonIgnore
    public void  setTxtShujiiIkenshoSakuseiIraibiTo(TextBoxDate txtShujiiIkenshoSakuseiIraibiTo) {
        this.getShujiiIkenshoKensakujoken().setTxtShujiiIkenshoSakuseiIraibiTo(txtShujiiIkenshoSakuseiIraibiTo);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiikenshoSakuseiIrai() {
        return this.getShujiiIkenshoKensakujoken().getChkShujiiikenshoSakuseiIrai();
    }

    @JsonIgnore
    public void  setChkShujiiikenshoSakuseiIrai(CheckBoxList chkShujiiikenshoSakuseiIrai) {
        this.getShujiiIkenshoKensakujoken().setChkShujiiikenshoSakuseiIrai(chkShujiiikenshoSakuseiIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkensho() {
        return this.getShujiiIkenshoKensakujoken().getChkShujiiIkensho();
    }

    @JsonIgnore
    public void  setChkShujiiIkensho(CheckBoxList chkShujiiIkensho) {
        this.getShujiiIkenshoKensakujoken().setChkShujiiIkensho(chkShujiiIkensho);
    }

    @JsonIgnore
    public TextBoxNum getTxtIkenshoDispMax() {
        return this.getShujiiIkenshoKensakujoken().getTxtIkenshoDispMax();
    }

    @JsonIgnore
    public void  setTxtIkenshoDispMax(TextBoxNum txtIkenshoDispMax) {
        this.getShujiiIkenshoKensakujoken().setTxtIkenshoDispMax(txtIkenshoDispMax);
    }

    @JsonIgnore
    public Button getBtnIkenshoClear() {
        return this.getShujiiIkenshoKensakujoken().getBtnIkenshoClear();
    }

    @JsonIgnore
    public void  setBtnIkenshoClear(Button btnIkenshoClear) {
        this.getShujiiIkenshoKensakujoken().setBtnIkenshoClear(btnIkenshoClear);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdShujiiIkenshoHokensha() {
        return this.getShujiiIkenshoKensakujoken().getCcdShujiiIkenshoHokensha();
    }

    @JsonIgnore
    public DataGrid<dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row> getDgShujiiIkenshoSakuseiIraiTaishoIchiran() {
        return this.getShujiiIkenshoSakuseiIraiTaishoIchiran().getDgShujiiIkenshoSakuseiIraiTaishoIchiran();
    }

    @JsonIgnore
    public void  setDgShujiiIkenshoSakuseiIraiTaishoIchiran(DataGrid<dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row> dgShujiiIkenshoSakuseiIraiTaishoIchiran) {
        this.getShujiiIkenshoSakuseiIraiTaishoIchiran().setDgShujiiIkenshoSakuseiIraiTaishoIchiran(dgShujiiIkenshoSakuseiIraiTaishoIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoSakuseiIrai() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkShujiiIkenshoSakuseiIrai();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoSakuseiIrai(CheckBoxList chkShujiiIkenshoSakuseiIrai) {
        this.getShujiiIkenshoInsatsuChohyo().setChkShujiiIkenshoSakuseiIrai(chkShujiiIkenshoSakuseiIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoSakuseiSeikyu() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkShujiiIkenshoSakuseiSeikyu();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoSakuseiSeikyu(CheckBoxList chkShujiiIkenshoSakuseiSeikyu) {
        this.getShujiiIkenshoInsatsuChohyo().setChkShujiiIkenshoSakuseiSeikyu(chkShujiiIkenshoSakuseiSeikyu);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoShinseiTani() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkShujiiIkenshoShinseiTani();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoShinseiTani(CheckBoxList chkShujiiIkenshoShinseiTani) {
        this.getShujiiIkenshoInsatsuChohyo().setChkShujiiIkenshoShinseiTani(chkShujiiIkenshoShinseiTani);
    }

    @JsonIgnore
    public ShujiiIkenshoChecksDiv getShujiiIkenshoChecks() {
        return this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks();
    }

    @JsonIgnore
    public void  setShujiiIkenshoChecks(ShujiiIkenshoChecksDiv ShujiiIkenshoChecks) {
        this.getShujiiIkenshoInsatsuChohyo().setShujiiIkenshoChecks(ShujiiIkenshoChecks);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoSakuseiIraisho() {
        return this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().getChkShujiiIkenshoSakuseiIraisho();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoSakuseiIraisho(CheckBoxList chkShujiiIkenshoSakuseiIraisho) {
        this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().setChkShujiiIkenshoSakuseiIraisho(chkShujiiIkenshoSakuseiIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiIkenshoyoshi() {
        return this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().getChkShujiIkenshoyoshi();
    }

    @JsonIgnore
    public void  setChkShujiIkenshoyoshi(CheckBoxList chkShujiIkenshoyoshi) {
        this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().setChkShujiIkenshoyoshi(chkShujiIkenshoyoshi);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoyoshiOcr() {
        return this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().getChkShujiiIkenshoyoshiOcr();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoyoshiOcr(CheckBoxList chkShujiiIkenshoyoshiOcr) {
        this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().setChkShujiiIkenshoyoshiOcr(chkShujiiIkenshoyoshiOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoyoshiDesign() {
        return this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().getChkShujiiIkenshoyoshiDesign();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoyoshiDesign(CheckBoxList chkShujiiIkenshoyoshiDesign) {
        this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().setChkShujiiIkenshoyoshiDesign(chkShujiiIkenshoyoshiDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoSakuseiryoSeikyusho() {
        return this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().getChkShujiiIkenshoSakuseiryoSeikyusho();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoSakuseiryoSeikyusho(CheckBoxList chkShujiiIkenshoSakuseiryoSeikyusho) {
        this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().setChkShujiiIkenshoSakuseiryoSeikyusho(chkShujiiIkenshoSakuseiryoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkShindanMeireishoAndTeishutsuIraisho() {
        return this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().getChkShindanMeireishoAndTeishutsuIraisho();
    }

    @JsonIgnore
    public void  setChkShindanMeireishoAndTeishutsuIraisho(CheckBoxList chkShindanMeireishoAndTeishutsuIraisho) {
        this.getShujiiIkenshoInsatsuChohyo().getShujiiIkenshoChecks().setChkShindanMeireishoAndTeishutsuIraisho(chkShindanMeireishoAndTeishutsuIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkikenshiiraihakko() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkikenshiiraihakko();
    }

    @JsonIgnore
    public void  setChkikenshiiraihakko(CheckBoxList Chkikenshiiraihakko) {
        this.getShujiiIkenshoInsatsuChohyo().setChkikenshiiraihakko(Chkikenshiiraihakko);
    }

    @JsonIgnore
    public CheckBoxList getChkikenshiiraiRireki() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkikenshiiraiRireki();
    }

    @JsonIgnore
    public void  setChkikenshiiraiRireki(CheckBoxList ChkikenshiiraiRireki) {
        this.getShujiiIkenshoInsatsuChohyo().setChkikenshiiraiRireki(ChkikenshiiraiRireki);
    }

    // </editor-fold>
}
