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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnJigyoshaAdd")
    private Button btnJigyoshaAdd;
    @JsonProperty("dgTokubetsuKyufuJigyoshaList")
    private DataGrid<dgTokubetsuKyufuJigyoshaList_Row> dgTokubetsuKyufuJigyoshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnJigyoshaAdd
     * @return btnJigyoshaAdd
     */
    @JsonProperty("btnJigyoshaAdd")
    public Button getBtnJigyoshaAdd() {
        return btnJigyoshaAdd;
    }

    /*
     * setbtnJigyoshaAdd
     * @param btnJigyoshaAdd btnJigyoshaAdd
     */
    @JsonProperty("btnJigyoshaAdd")
    public void setBtnJigyoshaAdd(Button btnJigyoshaAdd) {
        this.btnJigyoshaAdd = btnJigyoshaAdd;
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
