package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.koseishichosonselector.KoseiShiChosonSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoseiShiChosonSelector のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoseiShiChosonSelectorDiv extends Panel implements IKoseiShiChosonSelectorDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKoseiShichosonList")
    private DataGrid<dgKoseiShichosonList_Row> dgKoseiShichosonList;
    @JsonProperty("btnback")
    private Button btnback;
    @JsonProperty("koseiShiChosonSelectorModel")
    private RString koseiShiChosonSelectorModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKoseiShichosonList
     * @return dgKoseiShichosonList
     */
    @JsonProperty("dgKoseiShichosonList")
    public DataGrid<dgKoseiShichosonList_Row> getDgKoseiShichosonList() {
        return dgKoseiShichosonList;
    }

    /*
     * setdgKoseiShichosonList
     * @param dgKoseiShichosonList dgKoseiShichosonList
     */
    @JsonProperty("dgKoseiShichosonList")
    public void setDgKoseiShichosonList(DataGrid<dgKoseiShichosonList_Row> dgKoseiShichosonList) {
        this.dgKoseiShichosonList = dgKoseiShichosonList;
    }

    /*
     * getbtnback
     * @return btnback
     */
    @JsonProperty("btnback")
    public Button getBtnback() {
        return btnback;
    }

    /*
     * setbtnback
     * @param btnback btnback
     */
    @JsonProperty("btnback")
    public void setBtnback(Button btnback) {
        this.btnback = btnback;
    }

    /*
     * getkoseiShiChosonSelectorModel
     * @return koseiShiChosonSelectorModel
     */
    @JsonProperty("koseiShiChosonSelectorModel")
    public RString getKoseiShiChosonSelectorModel() {
        return koseiShiChosonSelectorModel;
    }

    /*
     * setkoseiShiChosonSelectorModel
     * @param koseiShiChosonSelectorModel koseiShiChosonSelectorModel
     */
    @JsonProperty("koseiShiChosonSelectorModel")
    public void setKoseiShiChosonSelectorModel(RString koseiShiChosonSelectorModel) {
        this.koseiShiChosonSelectorModel = koseiShiChosonSelectorModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
