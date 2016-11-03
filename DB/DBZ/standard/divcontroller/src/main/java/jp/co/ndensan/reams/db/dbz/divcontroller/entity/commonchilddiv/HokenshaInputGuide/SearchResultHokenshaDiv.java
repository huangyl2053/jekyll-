package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaInputGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchResultHokensha のクラスファイル
 *
 * @reamsid_L DBA-0180-010 lishengli
 */
public class SearchResultHokenshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSearchResultHokensha")
    private DataGrid<dgSearchResultHokensha_Row> dgSearchResultHokensha;

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

    // </editor-fold>
}
