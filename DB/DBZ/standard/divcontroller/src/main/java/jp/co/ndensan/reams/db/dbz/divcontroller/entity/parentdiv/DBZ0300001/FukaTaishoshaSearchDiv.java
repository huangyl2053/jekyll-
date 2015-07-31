package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaTaishoshaSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaTaishoshaSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchCondition")
    private SearchConditionDiv SearchCondition;
    @JsonProperty("GaitoshaList")
    private GaitoshaListDiv GaitoshaList;
    @JsonProperty("btnReSearchMode")
    private Button btnReSearchMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchCondition")
    public SearchConditionDiv getSearchCondition() {
        return SearchCondition;
    }

    @JsonProperty("SearchCondition")
    public void setSearchCondition(SearchConditionDiv SearchCondition) {
        this.SearchCondition=SearchCondition;
    }

    @JsonProperty("GaitoshaList")
    public GaitoshaListDiv getGaitoshaList() {
        return GaitoshaList;
    }

    @JsonProperty("GaitoshaList")
    public void setGaitoshaList(GaitoshaListDiv GaitoshaList) {
        this.GaitoshaList=GaitoshaList;
    }

    @JsonProperty("btnReSearchMode")
    public Button getBtnReSearchMode() {
        return btnReSearchMode;
    }

    @JsonProperty("btnReSearchMode")
    public void setBtnReSearchMode(Button btnReSearchMode) {
        this.btnReSearchMode=btnReSearchMode;
    }

    // </editor-fold>
}
