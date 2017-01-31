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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
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
    public TextBoxDateRange getTxtShujiiIkenshoSakuseiIraibi() {
        return this.getShujiiIkenshoKensakujoken().getTxtShujiiIkenshoSakuseiIraibi();
    }

    @JsonIgnore
    public void  setTxtShujiiIkenshoSakuseiIraibi(TextBoxDateRange txtShujiiIkenshoSakuseiIraibi) {
        this.getShujiiIkenshoKensakujoken().setTxtShujiiIkenshoSakuseiIraibi(txtShujiiIkenshoSakuseiIraibi);
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
    public CheckBoxList getChkIkenshoIraisho() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkIkenshoIraisho();
    }

    @JsonIgnore
    public void  setChkIkenshoIraisho(CheckBoxList chkIkenshoIraisho) {
        this.getShujiiIkenshoInsatsuChohyo().setChkIkenshoIraisho(chkIkenshoIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkensho() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkIkensho();
    }

    @JsonIgnore
    public void  setChkIkensho(CheckBoxList chkIkensho) {
        this.getShujiiIkenshoInsatsuChohyo().setChkIkensho(chkIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSeikyusho() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkIkenshoSeikyusho();
    }

    @JsonIgnore
    public void  setChkIkenshoSeikyusho(CheckBoxList chkIkenshoSeikyusho) {
        this.getShujiiIkenshoInsatsuChohyo().setChkIkenshoSeikyusho(chkIkenshoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSeikyuIchiran() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkIkenshoSeikyuIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoSeikyuIchiran(CheckBoxList chkIkenshoSeikyuIchiran) {
        this.getShujiiIkenshoInsatsuChohyo().setChkIkenshoSeikyuIchiran(chkIkenshoSeikyuIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoHakkoIchiran() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkIkenshoHakkoIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoHakkoIchiran(CheckBoxList chkIkenshoHakkoIchiran) {
        this.getShujiiIkenshoInsatsuChohyo().setChkIkenshoHakkoIchiran(chkIkenshoHakkoIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoRirekiIchiran() {
        return this.getShujiiIkenshoInsatsuChohyo().getChkIkenshoRirekiIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoRirekiIchiran(CheckBoxList chkIkenshoRirekiIchiran) {
        this.getShujiiIkenshoInsatsuChohyo().setChkIkenshoRirekiIchiran(chkIkenshoRirekiIchiran);
    }

    // </editor-fold>
}
