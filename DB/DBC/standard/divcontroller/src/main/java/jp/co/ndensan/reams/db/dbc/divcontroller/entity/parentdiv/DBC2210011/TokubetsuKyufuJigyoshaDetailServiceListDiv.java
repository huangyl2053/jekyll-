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
 * TokubetsuKyufuJigyoshaDetailServiceList のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaDetailServiceListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnServiceAdd")
    private Button btnServiceAdd;
    @JsonProperty("dgTokubetsuKyufuJigyoshaDetailServiceList")
    private DataGrid<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> dgTokubetsuKyufuJigyoshaDetailServiceList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnServiceAdd
     * @return btnServiceAdd
     */
    @JsonProperty("btnServiceAdd")
    public Button getBtnServiceAdd() {
        return btnServiceAdd;
    }

    /*
     * setbtnServiceAdd
     * @param btnServiceAdd btnServiceAdd
     */
    @JsonProperty("btnServiceAdd")
    public void setBtnServiceAdd(Button btnServiceAdd) {
        this.btnServiceAdd = btnServiceAdd;
    }

    /*
     * getdgTokubetsuKyufuJigyoshaDetailServiceList
     * @return dgTokubetsuKyufuJigyoshaDetailServiceList
     */
    @JsonProperty("dgTokubetsuKyufuJigyoshaDetailServiceList")
    public DataGrid<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> getDgTokubetsuKyufuJigyoshaDetailServiceList() {
        return dgTokubetsuKyufuJigyoshaDetailServiceList;
    }

    /*
     * setdgTokubetsuKyufuJigyoshaDetailServiceList
     * @param dgTokubetsuKyufuJigyoshaDetailServiceList dgTokubetsuKyufuJigyoshaDetailServiceList
     */
    @JsonProperty("dgTokubetsuKyufuJigyoshaDetailServiceList")
    public void setDgTokubetsuKyufuJigyoshaDetailServiceList(DataGrid<dgTokubetsuKyufuJigyoshaDetailServiceList_Row> dgTokubetsuKyufuJigyoshaDetailServiceList) {
        this.dgTokubetsuKyufuJigyoshaDetailServiceList = dgTokubetsuKyufuJigyoshaDetailServiceList;
    }

    // </editor-fold>
}
