package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShunoJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShunoJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTainoHanteiKijunDate")
    private TextBoxFlexibleDate txtTainoHanteiKijunDate;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("dgShunoJokyo")
    private DataGrid<dgShunoJokyo_Row> dgShunoJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTainoHanteiKijunDate
     * @return txtTainoHanteiKijunDate
     */
    @JsonProperty("txtTainoHanteiKijunDate")
    public TextBoxFlexibleDate getTxtTainoHanteiKijunDate() {
        return txtTainoHanteiKijunDate;
    }

    /*
     * settxtTainoHanteiKijunDate
     * @param txtTainoHanteiKijunDate txtTainoHanteiKijunDate
     */
    @JsonProperty("txtTainoHanteiKijunDate")
    public void setTxtTainoHanteiKijunDate(TextBoxFlexibleDate txtTainoHanteiKijunDate) {
        this.txtTainoHanteiKijunDate = txtTainoHanteiKijunDate;
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
     * getdgShunoJokyo
     * @return dgShunoJokyo
     */
    @JsonProperty("dgShunoJokyo")
    public DataGrid<dgShunoJokyo_Row> getDgShunoJokyo() {
        return dgShunoJokyo;
    }

    /*
     * setdgShunoJokyo
     * @param dgShunoJokyo dgShunoJokyo
     */
    @JsonProperty("dgShunoJokyo")
    public void setDgShunoJokyo(DataGrid<dgShunoJokyo_Row> dgShunoJokyo) {
        this.dgShunoJokyo = dgShunoJokyo;
    }

    // </editor-fold>
}
