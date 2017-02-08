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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKensakuJoken")
    private tblKensakuJokenDiv tblKensakuJoken;
    @JsonProperty("chkDoiNashiFukumu")
    private CheckBoxList chkDoiNashiFukumu;
    @JsonProperty("txtMaxHyojiKensu")
    private TextBoxNum txtMaxHyojiKensu;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblKensakuJoken
     * @return tblKensakuJoken
     */
    @JsonProperty("tblKensakuJoken")
    public tblKensakuJokenDiv getTblKensakuJoken() {
        return tblKensakuJoken;
    }

    /*
     * settblKensakuJoken
     * @param tblKensakuJoken tblKensakuJoken
     */
    @JsonProperty("tblKensakuJoken")
    public void setTblKensakuJoken(tblKensakuJokenDiv tblKensakuJoken) {
        this.tblKensakuJoken = tblKensakuJoken;
    }

    /*
     * getchkDoiNashiFukumu
     * @return chkDoiNashiFukumu
     */
    @JsonProperty("chkDoiNashiFukumu")
    public CheckBoxList getChkDoiNashiFukumu() {
        return chkDoiNashiFukumu;
    }

    /*
     * setchkDoiNashiFukumu
     * @param chkDoiNashiFukumu chkDoiNashiFukumu
     */
    @JsonProperty("chkDoiNashiFukumu")
    public void setChkDoiNashiFukumu(CheckBoxList chkDoiNashiFukumu) {
        this.chkDoiNashiFukumu = chkDoiNashiFukumu;
    }

    /*
     * gettxtMaxHyojiKensu
     * @return txtMaxHyojiKensu
     */
    @JsonProperty("txtMaxHyojiKensu")
    public TextBoxNum getTxtMaxHyojiKensu() {
        return txtMaxHyojiKensu;
    }

    /*
     * settxtMaxHyojiKensu
     * @param txtMaxHyojiKensu txtMaxHyojiKensu
     */
    @JsonProperty("txtMaxHyojiKensu")
    public void setTxtMaxHyojiKensu(TextBoxNum txtMaxHyojiKensu) {
        this.txtMaxHyojiKensu = txtMaxHyojiKensu;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKensakuKomoku() {
        return this.getTblKensakuJoken().getRadKensakuKomoku();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteibi() {
        return this.getTblKensakuJoken().getTxtNijiHanteibi();
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getTblKensakuJoken().getTxtHihokenshaNo();
    }

    // </editor-fold>
}
