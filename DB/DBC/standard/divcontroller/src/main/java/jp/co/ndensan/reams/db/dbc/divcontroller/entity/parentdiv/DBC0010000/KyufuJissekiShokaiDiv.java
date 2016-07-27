package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("KyufuJissekiSearchPanel")
    private KyufuJissekiSearchPanelDiv KyufuJissekiSearchPanel;
    @JsonProperty("KyufuJissekiListPanel")
    private KyufuJissekiListPanelDiv KyufuJissekiListPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
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

    // </editor-fold>
}
