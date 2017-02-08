package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900002;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * YokaigoNinteiJohoTeikyoIkkatsuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShinseiList")
    private ShinseiListDiv ShinseiList;
    @JsonProperty("PrintChohyoSelect")
    private PrintChohyoSelectDiv PrintChohyoSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getShinseiList
     * @return ShinseiList
     */
    @JsonProperty("ShinseiList")
    public ShinseiListDiv getShinseiList() {
        return ShinseiList;
    }

    /*
     * setShinseiList
     * @param ShinseiList ShinseiList
     */
    @JsonProperty("ShinseiList")
    public void setShinseiList(ShinseiListDiv ShinseiList) {
        this.ShinseiList = ShinseiList;
    }

    /*
     * getPrintChohyoSelect
     * @return PrintChohyoSelect
     */
    @JsonProperty("PrintChohyoSelect")
    public PrintChohyoSelectDiv getPrintChohyoSelect() {
        return PrintChohyoSelect;
    }

    /*
     * setPrintChohyoSelect
     * @param PrintChohyoSelect PrintChohyoSelect
     */
    @JsonProperty("PrintChohyoSelect")
    public void setPrintChohyoSelect(PrintChohyoSelectDiv PrintChohyoSelect) {
        this.PrintChohyoSelect = PrintChohyoSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblKensakuJokenDiv getTblKensakuJoken() {
        return this.getKensakuJoken().getTblKensakuJoken();
    }

    @JsonIgnore
    public void  setTblKensakuJoken(tblKensakuJokenDiv tblKensakuJoken) {
        this.getKensakuJoken().setTblKensakuJoken(tblKensakuJoken);
    }

    @JsonIgnore
    public RadioButton getRadKensakuKomoku() {
        return this.getKensakuJoken().getTblKensakuJoken().getRadKensakuKomoku();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteibi() {
        return this.getKensakuJoken().getTblKensakuJoken().getTxtNijiHanteibi();
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getKensakuJoken().getTblKensakuJoken().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public CheckBoxList getChkDoiNashiFukumu() {
        return this.getKensakuJoken().getChkDoiNashiFukumu();
    }

    @JsonIgnore
    public void  setChkDoiNashiFukumu(CheckBoxList chkDoiNashiFukumu) {
        this.getKensakuJoken().setChkDoiNashiFukumu(chkDoiNashiFukumu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxHyojiKensu() {
        return this.getKensakuJoken().getTxtMaxHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtMaxHyojiKensu(TextBoxNum txtMaxHyojiKensu) {
        this.getKensakuJoken().setTxtMaxHyojiKensu(txtMaxHyojiKensu);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getKensakuJoken().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getKensakuJoken().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getKensakuJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void  setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyo() {
        return this.getPrintChohyoSelect().getChkNinteiChosahyo();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyo(CheckBoxList chkNinteiChosahyo) {
        this.getPrintChohyoSelect().setChkNinteiChosahyo(chkNinteiChosahyo);
    }

    @JsonIgnore
    public RadioButton getRadNinteiChosaMasking() {
        return this.getPrintChohyoSelect().getRadNinteiChosaMasking();
    }

    @JsonIgnore
    public void  setRadNinteiChosaMasking(RadioButton radNinteiChosaMasking) {
        this.getPrintChohyoSelect().setRadNinteiChosaMasking(radNinteiChosaMasking);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiJiko() {
        return this.getPrintChohyoSelect().getChkTokkiJiko();
    }

    @JsonIgnore
    public void  setChkTokkiJiko(CheckBoxList chkTokkiJiko) {
        this.getPrintChohyoSelect().setChkTokkiJiko(chkTokkiJiko);
    }

    @JsonIgnore
    public RadioButton getRadTokkiJikoMasking() {
        return this.getPrintChohyoSelect().getRadTokkiJikoMasking();
    }

    @JsonIgnore
    public void  setRadTokkiJikoMasking(RadioButton radTokkiJikoMasking) {
        this.getPrintChohyoSelect().setRadTokkiJikoMasking(radTokkiJikoMasking);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkensho() {
        return this.getPrintChohyoSelect().getChkShujiiIkensho();
    }

    @JsonIgnore
    public void  setChkShujiiIkensho(CheckBoxList chkShujiiIkensho) {
        this.getPrintChohyoSelect().setChkShujiiIkensho(chkShujiiIkensho);
    }

    @JsonIgnore
    public RadioButton getRadShujiiMasking() {
        return this.getPrintChohyoSelect().getRadShujiiMasking();
    }

    @JsonIgnore
    public void  setRadShujiiMasking(RadioButton radShujiiMasking) {
        this.getPrintChohyoSelect().setRadShujiiMasking(radShujiiMasking);
    }

    @JsonIgnore
    public CheckBoxList getChkSonotaShiryo() {
        return this.getPrintChohyoSelect().getChkSonotaShiryo();
    }

    @JsonIgnore
    public void  setChkSonotaShiryo(CheckBoxList chkSonotaShiryo) {
        this.getPrintChohyoSelect().setChkSonotaShiryo(chkSonotaShiryo);
    }

    @JsonIgnore
    public RadioButton getRadSonotaShiryoMasking() {
        return this.getPrintChohyoSelect().getRadSonotaShiryoMasking();
    }

    @JsonIgnore
    public void  setRadSonotaShiryoMasking(RadioButton radSonotaShiryoMasking) {
        this.getPrintChohyoSelect().setRadSonotaShiryoMasking(radSonotaShiryoMasking);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHanteiKekka() {
        return this.getPrintChohyoSelect().getChkIchijiHanteiKekka();
    }

    @JsonIgnore
    public void  setChkIchijiHanteiKekka(CheckBoxList chkIchijiHanteiKekka) {
        this.getPrintChohyoSelect().setChkIchijiHanteiKekka(chkIchijiHanteiKekka);
    }

    @JsonIgnore
    public RadioButton getRadIchijiHanteiMasking() {
        return this.getPrintChohyoSelect().getRadIchijiHanteiMasking();
    }

    @JsonIgnore
    public void  setRadIchijiHanteiMasking(RadioButton radIchijiHanteiMasking) {
        this.getPrintChohyoSelect().setRadIchijiHanteiMasking(radIchijiHanteiMasking);
    }

    // </editor-fold>
}
