package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
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
 * KyufuJissekiSearchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiSearchPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJissekiChushutsuHani")
    private KyufuJissekiChushutsuHaniDiv KyufuJissekiChushutsuHani;
    @JsonProperty("KyufuJissekiKensakuTaisho")
    private KyufuJissekiKensakuTaishoDiv KyufuJissekiKensakuTaisho;
    @JsonProperty("btnKyufuJissekiSearchClear")
    private Button btnKyufuJissekiSearchClear;
    @JsonProperty("btnKyufuJissekiSearch")
    private Button btnKyufuJissekiSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuJissekiChushutsuHani
     * @return KyufuJissekiChushutsuHani
     */
    @JsonProperty("KyufuJissekiChushutsuHani")
    public KyufuJissekiChushutsuHaniDiv getKyufuJissekiChushutsuHani() {
        return KyufuJissekiChushutsuHani;
    }

    /*
     * setKyufuJissekiChushutsuHani
     * @param KyufuJissekiChushutsuHani KyufuJissekiChushutsuHani
     */
    @JsonProperty("KyufuJissekiChushutsuHani")
    public void setKyufuJissekiChushutsuHani(KyufuJissekiChushutsuHaniDiv KyufuJissekiChushutsuHani) {
        this.KyufuJissekiChushutsuHani = KyufuJissekiChushutsuHani;
    }

    /*
     * getKyufuJissekiKensakuTaisho
     * @return KyufuJissekiKensakuTaisho
     */
    @JsonProperty("KyufuJissekiKensakuTaisho")
    public KyufuJissekiKensakuTaishoDiv getKyufuJissekiKensakuTaisho() {
        return KyufuJissekiKensakuTaisho;
    }

    /*
     * setKyufuJissekiKensakuTaisho
     * @param KyufuJissekiKensakuTaisho KyufuJissekiKensakuTaisho
     */
    @JsonProperty("KyufuJissekiKensakuTaisho")
    public void setKyufuJissekiKensakuTaisho(KyufuJissekiKensakuTaishoDiv KyufuJissekiKensakuTaisho) {
        this.KyufuJissekiKensakuTaisho = KyufuJissekiKensakuTaisho;
    }

    /*
     * getbtnKyufuJissekiSearchClear
     * @return btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public Button getBtnKyufuJissekiSearchClear() {
        return btnKyufuJissekiSearchClear;
    }

    /*
     * setbtnKyufuJissekiSearchClear
     * @param btnKyufuJissekiSearchClear btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.btnKyufuJissekiSearchClear = btnKyufuJissekiSearchClear;
    }

    /*
     * getbtnKyufuJissekiSearch
     * @return btnKyufuJissekiSearch
     */
    @JsonProperty("btnKyufuJissekiSearch")
    public Button getBtnKyufuJissekiSearch() {
        return btnKyufuJissekiSearch;
    }

    /*
     * setbtnKyufuJissekiSearch
     * @param btnKyufuJissekiSearch btnKyufuJissekiSearch
     */
    @JsonProperty("btnKyufuJissekiSearch")
    public void setBtnKyufuJissekiSearch(Button btnKyufuJissekiSearch) {
        this.btnKyufuJissekiSearch = btnKyufuJissekiSearch;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadNendo() {
        return this.getKyufuJissekiChushutsuHani().getRadNendo();
    }

    @JsonIgnore
    public void  setRadNendo(RadioButton radNendo) {
        this.getKyufuJissekiChushutsuHani().setRadNendo(radNendo);
    }

    @JsonIgnore
    public DropDownList getDdlKyufuJissekiSearchNendo() {
        return this.getKyufuJissekiChushutsuHani().getDdlKyufuJissekiSearchNendo();
    }

    @JsonIgnore
    public void  setDdlKyufuJissekiSearchNendo(DropDownList ddlKyufuJissekiSearchNendo) {
        this.getKyufuJissekiChushutsuHani().setDdlKyufuJissekiSearchNendo(ddlKyufuJissekiSearchNendo);
    }

    @JsonIgnore
    public RadioButton getRadKyufuJissekiSearchDateType() {
        return this.getKyufuJissekiChushutsuHani().getRadKyufuJissekiSearchDateType();
    }

    @JsonIgnore
    public void  setRadKyufuJissekiSearchDateType(RadioButton radKyufuJissekiSearchDateType) {
        this.getKyufuJissekiChushutsuHani().setRadKyufuJissekiSearchDateType(radKyufuJissekiSearchDateType);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuJissekiSearchServiceTeikyoYM() {
        return this.getKyufuJissekiChushutsuHani().getTxtKyufuJissekiSearchServiceTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtKyufuJissekiSearchServiceTeikyoYM(TextBoxDateRange txtKyufuJissekiSearchServiceTeikyoYM) {
        this.getKyufuJissekiChushutsuHani().setTxtKyufuJissekiSearchServiceTeikyoYM(txtKyufuJissekiSearchServiceTeikyoYM);
    }

    @JsonIgnore
    public RadioButton getRadTaisho1() {
        return this.getKyufuJissekiKensakuTaisho().getRadTaisho1();
    }

    @JsonIgnore
    public void  setRadTaisho1(RadioButton radTaisho1) {
        this.getKyufuJissekiKensakuTaisho().setRadTaisho1(radTaisho1);
    }

    // </editor-fold>
}
