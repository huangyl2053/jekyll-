package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaInputGuide;
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
 * SearchResultHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchResultHokenshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSearchResultHokensha")
    private DataGrid<dgSearchResultHokensha_Row> dgSearchResultHokensha;
    @JsonProperty("HokenshaModel")
    private RString HokenshaModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSearchResultHokensha
     * @return dgSearchResultHokensha
     */
    @JsonProperty("dgSearchResultHokensha")
    public DataGrid<dgSearchResultHokensha_Row> getDgSearchResultHokensha() {
        return dgSearchResultHokensha;
    }

    /*
     * setdgSearchResultHokensha
     * @param dgSearchResultHokensha dgSearchResultHokensha
     */
    @JsonProperty("dgSearchResultHokensha")
    public void setDgSearchResultHokensha(DataGrid<dgSearchResultHokensha_Row> dgSearchResultHokensha) {
        this.dgSearchResultHokensha = dgSearchResultHokensha;
    }

    /*
     * getHokenshaModel
     * @return HokenshaModel
     */
    @JsonProperty("HokenshaModel")
    public RString getHokenshaModel() {
        return HokenshaModel;
    }

    /*
     * setHokenshaModel
     * @param HokenshaModel HokenshaModel
     */
    @JsonProperty("HokenshaModel")
    public void setHokenshaModel(RString HokenshaModel) {
        this.HokenshaModel = HokenshaModel;
    }

    // </editor-fold>
}
