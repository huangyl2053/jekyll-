package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuKyufuJigyoshaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddJigyosha")
    private Button btnAddJigyosha;
    @JsonProperty("dgTokubetsuKyufuJigyoshaList")
    private DataGrid<dgTokubetsuKyufuJigyoshaList_Row> dgTokubetsuKyufuJigyoshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddJigyosha
     * @return btnAddJigyosha
     */
    @JsonProperty("btnAddJigyosha")
    public Button getBtnAddJigyosha() {
        return btnAddJigyosha;
    }

    /*
     * setbtnAddJigyosha
     * @param btnAddJigyosha btnAddJigyosha
     */
    @JsonProperty("btnAddJigyosha")
    public void setBtnAddJigyosha(Button btnAddJigyosha) {
        this.btnAddJigyosha = btnAddJigyosha;
    }

    /*
     * getdgTokubetsuKyufuJigyoshaList
     * @return dgTokubetsuKyufuJigyoshaList
     */
    @JsonProperty("dgTokubetsuKyufuJigyoshaList")
    public DataGrid<dgTokubetsuKyufuJigyoshaList_Row> getDgTokubetsuKyufuJigyoshaList() {
        return dgTokubetsuKyufuJigyoshaList;
    }

    /*
     * setdgTokubetsuKyufuJigyoshaList
     * @param dgTokubetsuKyufuJigyoshaList dgTokubetsuKyufuJigyoshaList
     */
    @JsonProperty("dgTokubetsuKyufuJigyoshaList")
    public void setDgTokubetsuKyufuJigyoshaList(DataGrid<dgTokubetsuKyufuJigyoshaList_Row> dgTokubetsuKyufuJigyoshaList) {
        this.dgTokubetsuKyufuJigyoshaList = dgTokubetsuKyufuJigyoshaList;
    }

    // </editor-fold>
}
