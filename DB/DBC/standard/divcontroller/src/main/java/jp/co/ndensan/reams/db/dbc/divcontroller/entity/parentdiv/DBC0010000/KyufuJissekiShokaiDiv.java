package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJissekiSearchPanel")
    private KyufuJissekiSearchPanelDiv KyufuJissekiSearchPanel;
    @JsonProperty("KyufuJissekiListPanel")
    private KyufuJissekiListPanelDiv KyufuJissekiListPanel;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
    @JsonProperty("hiddenZenBanGo")
    private RString hiddenZenBanGo;
    @JsonProperty("hiddenSaiGoBango")
    private RString hiddenSaiGoBango;
    @JsonProperty("hiddenSyuToKenSu")
    private RString hiddenSyuToKenSu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuJissekiSearchPanel
     * @return KyufuJissekiSearchPanel
     */
    @JsonProperty("KyufuJissekiSearchPanel")
    public KyufuJissekiSearchPanelDiv getKyufuJissekiSearchPanel() {
        return KyufuJissekiSearchPanel;
    }

    /*
     * setKyufuJissekiSearchPanel
     * @param KyufuJissekiSearchPanel KyufuJissekiSearchPanel
     */
    @JsonProperty("KyufuJissekiSearchPanel")
    public void setKyufuJissekiSearchPanel(KyufuJissekiSearchPanelDiv KyufuJissekiSearchPanel) {
        this.KyufuJissekiSearchPanel = KyufuJissekiSearchPanel;
    }

    /*
     * getKyufuJissekiListPanel
     * @return KyufuJissekiListPanel
     */
    @JsonProperty("KyufuJissekiListPanel")
    public KyufuJissekiListPanelDiv getKyufuJissekiListPanel() {
        return KyufuJissekiListPanel;
    }

    /*
     * setKyufuJissekiListPanel
     * @param KyufuJissekiListPanel KyufuJissekiListPanel
     */
    @JsonProperty("KyufuJissekiListPanel")
    public void setKyufuJissekiListPanel(KyufuJissekiListPanelDiv KyufuJissekiListPanel) {
        this.KyufuJissekiListPanel = KyufuJissekiListPanel;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * gethiddenZenBanGo
     * @return hiddenZenBanGo
     */
    @JsonProperty("hiddenZenBanGo")
    public RString getHiddenZenBanGo() {
        return hiddenZenBanGo;
    }

    /*
     * sethiddenZenBanGo
     * @param hiddenZenBanGo hiddenZenBanGo
     */
    @JsonProperty("hiddenZenBanGo")
    public void setHiddenZenBanGo(RString hiddenZenBanGo) {
        this.hiddenZenBanGo = hiddenZenBanGo;
    }

    /*
     * gethiddenSaiGoBango
     * @return hiddenSaiGoBango
     */
    @JsonProperty("hiddenSaiGoBango")
    public RString getHiddenSaiGoBango() {
        return hiddenSaiGoBango;
    }

    /*
     * sethiddenSaiGoBango
     * @param hiddenSaiGoBango hiddenSaiGoBango
     */
    @JsonProperty("hiddenSaiGoBango")
    public void setHiddenSaiGoBango(RString hiddenSaiGoBango) {
        this.hiddenSaiGoBango = hiddenSaiGoBango;
    }

    /*
     * gethiddenSyuToKenSu
     * @return hiddenSyuToKenSu
     */
    @JsonProperty("hiddenSyuToKenSu")
    public RString getHiddenSyuToKenSu() {
        return hiddenSyuToKenSu;
    }

    /*
     * sethiddenSyuToKenSu
     * @param hiddenSyuToKenSu hiddenSyuToKenSu
     */
    @JsonProperty("hiddenSyuToKenSu")
    public void setHiddenSyuToKenSu(RString hiddenSyuToKenSu) {
        this.hiddenSyuToKenSu = hiddenSyuToKenSu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KyufuJissekiChushutsuHaniDiv getKyufuJissekiChushutsuHani() {
        return this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani();
    }

    @JsonIgnore
    public void  setKyufuJissekiChushutsuHani(KyufuJissekiChushutsuHaniDiv KyufuJissekiChushutsuHani) {
        this.getKyufuJissekiSearchPanel().setKyufuJissekiChushutsuHani(KyufuJissekiChushutsuHani);
    }

    @JsonIgnore
    public RadioButton getRadNendo() {
        return this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().getRadNendo();
    }

    @JsonIgnore
    public void  setRadNendo(RadioButton radNendo) {
        this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().setRadNendo(radNendo);
    }

    @JsonIgnore
    public DropDownList getDdlKyufuJissekiSearchNendo() {
        return this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().getDdlKyufuJissekiSearchNendo();
    }

    @JsonIgnore
    public void  setDdlKyufuJissekiSearchNendo(DropDownList ddlKyufuJissekiSearchNendo) {
        this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().setDdlKyufuJissekiSearchNendo(ddlKyufuJissekiSearchNendo);
    }

    @JsonIgnore
    public RadioButton getRadKyufuJissekiSearchDateType() {
        return this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().getRadKyufuJissekiSearchDateType();
    }

    @JsonIgnore
    public void  setRadKyufuJissekiSearchDateType(RadioButton radKyufuJissekiSearchDateType) {
        this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().setRadKyufuJissekiSearchDateType(radKyufuJissekiSearchDateType);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuJissekiSearchServiceTeikyoYM() {
        return this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().getTxtKyufuJissekiSearchServiceTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiSearchServiceTeikyoYM(TextBoxDateRange txtKyufuJissekiSearchServiceTeikyoYM) {
        this.getKyufuJissekiSearchPanel().getKyufuJissekiChushutsuHani().setTxtKyufuJissekiSearchServiceTeikyoYM(txtKyufuJissekiSearchServiceTeikyoYM);
    }

    @JsonIgnore
    public KyufuJissekiKensakuTaishoDiv getKyufuJissekiKensakuTaisho() {
        return this.getKyufuJissekiSearchPanel().getKyufuJissekiKensakuTaisho();
    }

    @JsonIgnore
    public void  setKyufuJissekiKensakuTaisho(KyufuJissekiKensakuTaishoDiv KyufuJissekiKensakuTaisho) {
        this.getKyufuJissekiSearchPanel().setKyufuJissekiKensakuTaisho(KyufuJissekiKensakuTaisho);
    }

    @JsonIgnore
    public RadioButton getRadTaisho1() {
        return this.getKyufuJissekiSearchPanel().getKyufuJissekiKensakuTaisho().getRadTaisho1();
    }

    @JsonIgnore
    public void  setRadTaisho1(RadioButton radTaisho1) {
        this.getKyufuJissekiSearchPanel().getKyufuJissekiKensakuTaisho().setRadTaisho1(radTaisho1);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiSearchClear() {
        return this.getKyufuJissekiSearchPanel().getBtnKyufuJissekiSearchClear();
    }

    @JsonIgnore
    public void  setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.getKyufuJissekiSearchPanel().setBtnKyufuJissekiSearchClear(btnKyufuJissekiSearchClear);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiSearch() {
        return this.getKyufuJissekiSearchPanel().getBtnKyufuJissekiSearch();
    }

    @JsonIgnore
    public void  setBtnKyufuJissekiSearch(Button btnKyufuJissekiSearch) {
        this.getKyufuJissekiSearchPanel().setBtnKyufuJissekiSearch(btnKyufuJissekiSearch);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiListHihokenshaNo() {
        return this.getKyufuJissekiListPanel().getTxtKyufuJissekiListHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiListHihokenshaNo(TextBox txtKyufuJissekiListHihokenshaNo) {
        this.getKyufuJissekiListPanel().setTxtKyufuJissekiListHihokenshaNo(txtKyufuJissekiListHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiListJuminShubetsu() {
        return this.getKyufuJissekiListPanel().getTxtKyufuJissekiListJuminShubetsu();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiListJuminShubetsu(TextBox txtKyufuJissekiListJuminShubetsu) {
        this.getKyufuJissekiListPanel().setTxtKyufuJissekiListJuminShubetsu(txtKyufuJissekiListJuminShubetsu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiListYokaigodo() {
        return this.getKyufuJissekiListPanel().getTxtKyufuJissekiListYokaigodo();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiListYokaigodo(TextBox txtKyufuJissekiListYokaigodo) {
        this.getKyufuJissekiListPanel().setTxtKyufuJissekiListYokaigodo(txtKyufuJissekiListYokaigodo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuJissekiListNinteiYukoKikan() {
        return this.getKyufuJissekiListPanel().getTxtKyufuJissekiListNinteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiListNinteiYukoKikan(TextBoxDateRange txtKyufuJissekiListNinteiYukoKikan) {
        this.getKyufuJissekiListPanel().setTxtKyufuJissekiListNinteiYukoKikan(txtKyufuJissekiListNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiListName() {
        return this.getKyufuJissekiListPanel().getTxtKyufuJissekiListName();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiListName(TextBox txtKyufuJissekiListName) {
        this.getKyufuJissekiListPanel().setTxtKyufuJissekiListName(txtKyufuJissekiListName);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiListSeibetsu() {
        return this.getKyufuJissekiListPanel().getTxtKyufuJissekiListSeibetsu();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiListSeibetsu(TextBox txtKyufuJissekiListSeibetsu) {
        this.getKyufuJissekiListPanel().setTxtKyufuJissekiListSeibetsu(txtKyufuJissekiListSeibetsu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuJissekiListSeinengappi() {
        return this.getKyufuJissekiListPanel().getTxtKyufuJissekiListSeinengappi();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiListSeinengappi(TextBox txtKyufuJissekiListSeinengappi) {
        this.getKyufuJissekiListPanel().setTxtKyufuJissekiListSeinengappi(txtKyufuJissekiListSeinengappi);
    }

    @JsonIgnore
    public DataIdoPanelDiv getDataIdoPanel() {
        return this.getKyufuJissekiListPanel().getDataIdoPanel();
    }

    @JsonIgnore
    public void  setDataIdoPanel(DataIdoPanelDiv DataIdoPanel) {
        this.getKyufuJissekiListPanel().setDataIdoPanel(DataIdoPanel);
    }

    @JsonIgnore
    public Button getBtnSento() {
        return this.getKyufuJissekiListPanel().getDataIdoPanel().getBtnSento();
    }

    @JsonIgnore
    public void  setBtnSento(Button btnSento) {
        this.getKyufuJissekiListPanel().getDataIdoPanel().setBtnSento(btnSento);
    }

    @JsonIgnore
    public Button getBtnMae() {
        return this.getKyufuJissekiListPanel().getDataIdoPanel().getBtnMae();
    }

    @JsonIgnore
    public void  setBtnMae(Button btnMae) {
        this.getKyufuJissekiListPanel().getDataIdoPanel().setBtnMae(btnMae);
    }

    @JsonIgnore
    public Button getBtnTsugi() {
        return this.getKyufuJissekiListPanel().getDataIdoPanel().getBtnTsugi();
    }

    @JsonIgnore
    public void  setBtnTsugi(Button btnTsugi) {
        this.getKyufuJissekiListPanel().getDataIdoPanel().setBtnTsugi(btnTsugi);
    }

    @JsonIgnore
    public Button getBtnSaigo() {
        return this.getKyufuJissekiListPanel().getDataIdoPanel().getBtnSaigo();
    }

    @JsonIgnore
    public void  setBtnSaigo(Button btnSaigo) {
        this.getKyufuJissekiListPanel().getDataIdoPanel().setBtnSaigo(btnSaigo);
    }

    @JsonIgnore
    public DataGrid<dgKyufuJissekiMeisaiList_Row> getDgKyufuJissekiMeisaiList() {
        return this.getKyufuJissekiListPanel().getDgKyufuJissekiMeisaiList();
    }

    @JsonIgnore
    public void  setDgKyufuJissekiMeisaiList(DataGrid<dgKyufuJissekiMeisaiList_Row> dgKyufuJissekiMeisaiList) {
        this.getKyufuJissekiListPanel().setDgKyufuJissekiMeisaiList(dgKyufuJissekiMeisaiList);
    }

    @JsonIgnore
    public DataGrid<dgKyufuJissekiGokeiList_Row> getDgKyufuJissekiGokeiList() {
        return this.getKyufuJissekiListPanel().getDgKyufuJissekiGokeiList();
    }

    @JsonIgnore
    public void  setDgKyufuJissekiGokeiList(DataGrid<dgKyufuJissekiGokeiList_Row> dgKyufuJissekiGokeiList) {
        this.getKyufuJissekiListPanel().setDgKyufuJissekiGokeiList(dgKyufuJissekiGokeiList);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiResearch() {
        return this.getKyufuJissekiListPanel().getBtnKyufuJissekiResearch();
    }

    @JsonIgnore
    public void  setBtnKyufuJissekiResearch(Button btnKyufuJissekiResearch) {
        this.getKyufuJissekiListPanel().setBtnKyufuJissekiResearch(btnKyufuJissekiResearch);
    }

    // </editor-fold>
}
