package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5040002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5040002.dgSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteitsuchishoKobetsuHakkoTargetList のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteitsuchishoKobetsuHakkoTargetListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkHakkoShoruiType")
    private CheckBoxList chkHakkoShoruiType;
    @JsonProperty("dgSearchResult")
    private DataGrid<dgSearchResult_Row> dgSearchResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkHakkoShoruiType")
    public CheckBoxList getChkHakkoShoruiType() {
        return chkHakkoShoruiType;
    }

    @JsonProperty("chkHakkoShoruiType")
    public void setChkHakkoShoruiType(CheckBoxList chkHakkoShoruiType) {
        this.chkHakkoShoruiType=chkHakkoShoruiType;
    }

    @JsonProperty("dgSearchResult")
    public DataGrid<dgSearchResult_Row> getDgSearchResult() {
        return dgSearchResult;
    }

    @JsonProperty("dgSearchResult")
    public void setDgSearchResult(DataGrid<dgSearchResult_Row> dgSearchResult) {
        this.dgSearchResult=dgSearchResult;
    }

}
