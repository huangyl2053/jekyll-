package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.sonotakikanguide.SonotaKikanGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * SonotaKikanGuide のクラスファイル 
 * 
 * @reamsid_L DBE-3000-050 wangkun
 */
public class SonotaKikanGuideDiv extends Panel implements ISonotaKikanGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("SelectIchiran")
    private SelectIchiranDiv SelectIchiran;
    @JsonProperty("SoNoTaKikanGuideModel")
    private RString SoNoTaKikanGuideModel;

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
     * getSelectIchiran
     * @return SelectIchiran
     */
    @JsonProperty("SelectIchiran")
    public SelectIchiranDiv getSelectIchiran() {
        return SelectIchiran;
    }

    /*
     * setSelectIchiran
     * @param SelectIchiran SelectIchiran
     */
    @JsonProperty("SelectIchiran")
    public void setSelectIchiran(SelectIchiranDiv SelectIchiran) {
        this.SelectIchiran = SelectIchiran;
    }

    /*
     * getSoNoTaKikanGuideModel
     * @return SoNoTaKikanGuideModel
     */
    @JsonProperty("SoNoTaKikanGuideModel")
    public RString getSoNoTaKikanGuideModel() {
        return SoNoTaKikanGuideModel;
    }

    /*
     * setSoNoTaKikanGuideModel
     * @param SoNoTaKikanGuideModel SoNoTaKikanGuideModel
     */
    @JsonProperty("SoNoTaKikanGuideModel")
    public void setSoNoTaKikanGuideModel(RString SoNoTaKikanGuideModel) {
        this.SoNoTaKikanGuideModel = SoNoTaKikanGuideModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getKensakuJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public TextBox getTxtSonotaKikanCodefrom() {
        return this.getKensakuJoken().getTxtSonotaKikanCodefrom();
    }

    @JsonIgnore
    public void  setTxtSonotaKikanCodefrom(TextBox txtSonotaKikanCodefrom) {
        this.getKensakuJoken().setTxtSonotaKikanCodefrom(txtSonotaKikanCodefrom);
    }

    @JsonIgnore
    public Label getBlkara() {
        return this.getKensakuJoken().getBlkara();
    }

    @JsonIgnore
    public void  setBlkara(Label blkara) {
        this.getKensakuJoken().setBlkara(blkara);
    }

    @JsonIgnore
    public TextBox getTxtSonotaKikanCodeto() {
        return this.getKensakuJoken().getTxtSonotaKikanCodeto();
    }

    @JsonIgnore
    public void  setTxtSonotaKikanCodeto(TextBox txtSonotaKikanCodeto) {
        this.getKensakuJoken().setTxtSonotaKikanCodeto(txtSonotaKikanCodeto);
    }

    @JsonIgnore
    public RadioButton getRadHaisi() {
        return this.getKensakuJoken().getRadHaisi();
    }

    @JsonIgnore
    public void  setRadHaisi(RadioButton radHaisi) {
        this.getKensakuJoken().setRadHaisi(radHaisi);
    }

    @JsonIgnore
    public TextBox getTxtSonotaKikanName() {
        return this.getKensakuJoken().getTxtSonotaKikanName();
    }

    @JsonIgnore
    public void  setTxtSonotaKikanName(TextBox txtSonotaKikanName) {
        this.getKensakuJoken().setTxtSonotaKikanName(txtSonotaKikanName);
    }

    @JsonIgnore
    public DropDownList getDdlChosaItakusakiKubun() {
        return this.getKensakuJoken().getDdlChosaItakusakiKubun();
    }

    @JsonIgnore
    public void  setDdlChosaItakusakiKubun(DropDownList ddlChosaItakusakiKubun) {
        this.getKensakuJoken().setDdlChosaItakusakiKubun(ddlChosaItakusakiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxDisp() {
        return this.getKensakuJoken().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.getKensakuJoken().setTxtMaxDisp(txtMaxDisp);
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
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgSonotaKikanIchiran_Row> getDgSonotaKikanIchiran() {
        return this.getSelectIchiran().getDgSonotaKikanIchiran();
    }

    @JsonIgnore
    public void  setDgSonotaKikanIchiran(DataGrid<dgSonotaKikanIchiran_Row> dgSonotaKikanIchiran) {
        this.getSelectIchiran().setDgSonotaKikanIchiran(dgSonotaKikanIchiran);
    }

    @JsonIgnore
    public Button getBtnback() {
        return this.getSelectIchiran().getBtnback();
    }

    @JsonIgnore
    public void  setBtnback(Button btnback) {
        this.getSelectIchiran().setBtnback(btnback);
    }

    @JsonIgnore
    public Button getBtnResearch() {
        return this.getSelectIchiran().getBtnResearch();
    }

    @JsonIgnore
    public void  setBtnResearch(Button btnResearch) {
        this.getSelectIchiran().setBtnResearch(btnResearch);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

//    @Override
//    public void load() {
//        getHandler().load();
//    }

//     private SoNoTaKikanGuideHandler getHandler() {
//        return new SoNoTaKikanGuideHandler(this);
//    }
}
