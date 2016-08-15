package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHanteiKensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiKensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDateRange")
    private TextBoxDateRange txtShinseiDateRange;
    @JsonProperty("txtMaxCount")
    private TextBoxNum txtMaxCount;
    @JsonProperty("btnKyufuJissekiSearchClear")
    private Button btnKyufuJissekiSearchClear;
    @JsonProperty("btnTaishoshaSearch")
    private Button btnTaishoshaSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDateRange
     * @return txtShinseiDateRange
     */
    @JsonProperty("txtShinseiDateRange")
    public TextBoxDateRange getTxtShinseiDateRange() {
        return txtShinseiDateRange;
    }

    /*
     * settxtShinseiDateRange
     * @param txtShinseiDateRange txtShinseiDateRange
     */
    @JsonProperty("txtShinseiDateRange")
    public void setTxtShinseiDateRange(TextBoxDateRange txtShinseiDateRange) {
        this.txtShinseiDateRange = txtShinseiDateRange;
    }

    /*
     * gettxtMaxCount
     * @return txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public TextBoxNum getTxtMaxCount() {
        return txtMaxCount;
    }

    /*
     * settxtMaxCount
     * @param txtMaxCount txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.txtMaxCount = txtMaxCount;
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
     * getbtnTaishoshaSearch
     * @return btnTaishoshaSearch
     */
    @JsonProperty("btnTaishoshaSearch")
    public Button getBtnTaishoshaSearch() {
        return btnTaishoshaSearch;
    }

    /*
     * setbtnTaishoshaSearch
     * @param btnTaishoshaSearch btnTaishoshaSearch
     */
    @JsonProperty("btnTaishoshaSearch")
    public void setBtnTaishoshaSearch(Button btnTaishoshaSearch) {
        this.btnTaishoshaSearch = btnTaishoshaSearch;
    }

    // </editor-fold>
}
