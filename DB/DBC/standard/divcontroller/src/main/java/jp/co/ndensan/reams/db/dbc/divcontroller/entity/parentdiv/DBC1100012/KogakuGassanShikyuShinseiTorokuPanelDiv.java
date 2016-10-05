package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012;
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
 * KogakuGassanShikyuShinseiTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuGassanShikyuShinseiTorokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuSearch")
    private KogakuGassanShikyuShinseiTorokuSearchDiv KogakuGassanShikyuShinseiTorokuSearch;
    @JsonProperty("KogakuGassanShikyuShinseiTorokuSearchResult")
    private KogakuGassanShikyuShinseiTorokuSearchResultDiv KogakuGassanShikyuShinseiTorokuSearchResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKogakuGassanShikyuShinseiTorokuSearch
     * @return KogakuGassanShikyuShinseiTorokuSearch
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuSearch")
    public KogakuGassanShikyuShinseiTorokuSearchDiv getKogakuGassanShikyuShinseiTorokuSearch() {
        return KogakuGassanShikyuShinseiTorokuSearch;
    }

    /*
     * setKogakuGassanShikyuShinseiTorokuSearch
     * @param KogakuGassanShikyuShinseiTorokuSearch KogakuGassanShikyuShinseiTorokuSearch
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuSearch")
    public void setKogakuGassanShikyuShinseiTorokuSearch(KogakuGassanShikyuShinseiTorokuSearchDiv KogakuGassanShikyuShinseiTorokuSearch) {
        this.KogakuGassanShikyuShinseiTorokuSearch = KogakuGassanShikyuShinseiTorokuSearch;
    }

    /*
     * getKogakuGassanShikyuShinseiTorokuSearchResult
     * @return KogakuGassanShikyuShinseiTorokuSearchResult
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuSearchResult")
    public KogakuGassanShikyuShinseiTorokuSearchResultDiv getKogakuGassanShikyuShinseiTorokuSearchResult() {
        return KogakuGassanShikyuShinseiTorokuSearchResult;
    }

    /*
     * setKogakuGassanShikyuShinseiTorokuSearchResult
     * @param KogakuGassanShikyuShinseiTorokuSearchResult KogakuGassanShikyuShinseiTorokuSearchResult
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuSearchResult")
    public void setKogakuGassanShikyuShinseiTorokuSearchResult(KogakuGassanShikyuShinseiTorokuSearchResultDiv KogakuGassanShikyuShinseiTorokuSearchResult) {
        this.KogakuGassanShikyuShinseiTorokuSearchResult = KogakuGassanShikyuShinseiTorokuSearchResult;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgTorokuSearchResult_Row> getDgTorokuSearchResult() {
        return this.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult();
    }

    @JsonIgnore
    public void  setDgTorokuSearchResult(DataGrid<dgTorokuSearchResult_Row> dgTorokuSearchResult) {
        this.getKogakuGassanShikyuShinseiTorokuSearchResult().setDgTorokuSearchResult(dgTorokuSearchResult);
    }

    @JsonIgnore
    public Button getBtnSaikensaku() {
        return this.getKogakuGassanShikyuShinseiTorokuSearchResult().getBtnSaikensaku();
    }

    @JsonIgnore
    public void  setBtnSaikensaku(Button btnSaikensaku) {
        this.getKogakuGassanShikyuShinseiTorokuSearchResult().setBtnSaikensaku(btnSaikensaku);
    }

    // </editor-fold>
}
