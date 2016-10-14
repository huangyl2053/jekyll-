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
 * TokubetsuKyufuJigyoshaSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearchCode")
    private TokubetsuKyufuJigyoshaSearchCodeDiv TokubetsuKyufuJigyoshaSearchCode;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokubetsuKyufuJigyoshaSearchCode
     * @return TokubetsuKyufuJigyoshaSearchCode
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearchCode")
    public TokubetsuKyufuJigyoshaSearchCodeDiv getTokubetsuKyufuJigyoshaSearchCode() {
        return TokubetsuKyufuJigyoshaSearchCode;
    }

    /*
     * setTokubetsuKyufuJigyoshaSearchCode
     * @param TokubetsuKyufuJigyoshaSearchCode TokubetsuKyufuJigyoshaSearchCode
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearchCode")
    public void setTokubetsuKyufuJigyoshaSearchCode(TokubetsuKyufuJigyoshaSearchCodeDiv TokubetsuKyufuJigyoshaSearchCode) {
        this.TokubetsuKyufuJigyoshaSearchCode = TokubetsuKyufuJigyoshaSearchCode;
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

    // </editor-fold>
}
