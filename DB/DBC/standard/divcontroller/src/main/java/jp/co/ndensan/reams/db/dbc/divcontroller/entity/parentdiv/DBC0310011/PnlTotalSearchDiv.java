package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011;
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
 * PnlTotalSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlTotalSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlSearch")
    private PnlSearchDiv PnlSearch;
    @JsonProperty("PnlKeiyakusyaList")
    private PnlKeiyakusyaListDiv PnlKeiyakusyaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlSearch
     * @return PnlSearch
     */
    @JsonProperty("PnlSearch")
    public PnlSearchDiv getPnlSearch() {
        return PnlSearch;
    }

    /*
     * setPnlSearch
     * @param PnlSearch PnlSearch
     */
    @JsonProperty("PnlSearch")
    public void setPnlSearch(PnlSearchDiv PnlSearch) {
        this.PnlSearch = PnlSearch;
    }

    /*
     * getPnlKeiyakusyaList
     * @return PnlKeiyakusyaList
     */
    @JsonProperty("PnlKeiyakusyaList")
    public PnlKeiyakusyaListDiv getPnlKeiyakusyaList() {
        return PnlKeiyakusyaList;
    }

    /*
     * setPnlKeiyakusyaList
     * @param PnlKeiyakusyaList PnlKeiyakusyaList
     */
    @JsonProperty("PnlKeiyakusyaList")
    public void setPnlKeiyakusyaList(PnlKeiyakusyaListDiv PnlKeiyakusyaList) {
        this.PnlKeiyakusyaList = PnlKeiyakusyaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKeyakusya_Row> getDgKeyakusya() {
        return this.getPnlKeiyakusyaList().getDgKeyakusya();
    }

    @JsonIgnore
    public void  setDgKeyakusya(DataGrid<dgKeyakusya_Row> dgKeyakusya) {
        this.getPnlKeiyakusyaList().setDgKeyakusya(dgKeyakusya);
    }

    @JsonIgnore
    public Button getBtnSearchAgain() {
        return this.getPnlKeiyakusyaList().getBtnSearchAgain();
    }

    @JsonIgnore
    public void  setBtnSearchAgain(Button btnSearchAgain) {
        this.getPnlKeiyakusyaList().setBtnSearchAgain(btnSearchAgain);
    }

    // </editor-fold>
}
