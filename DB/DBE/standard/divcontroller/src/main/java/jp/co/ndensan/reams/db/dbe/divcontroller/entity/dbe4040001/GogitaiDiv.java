package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Gogitai のクラスファイル 
 * 
 * @author 自動生成
 */
public class GogitaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("OperationForShinsakaiIinList")
    private OperationForShinsakaiIinListDiv OperationForShinsakaiIinList;
    @JsonProperty("dgShinsakaiIinList")
    private DataGrid<dgShinsakaiIinList_Row> dgShinsakaiIinList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("OperationForShinsakaiIinList")
    public OperationForShinsakaiIinListDiv getOperationForShinsakaiIinList() {
        return OperationForShinsakaiIinList;
    }

    @JsonProperty("OperationForShinsakaiIinList")
    public void setOperationForShinsakaiIinList(OperationForShinsakaiIinListDiv OperationForShinsakaiIinList) {
        this.OperationForShinsakaiIinList=OperationForShinsakaiIinList;
    }

    @JsonProperty("dgShinsakaiIinList")
    public DataGrid<dgShinsakaiIinList_Row> getDgShinsakaiIinList() {
        return dgShinsakaiIinList;
    }

    @JsonProperty("dgShinsakaiIinList")
    public void setDgShinsakaiIinList(DataGrid<dgShinsakaiIinList_Row> dgShinsakaiIinList) {
        this.dgShinsakaiIinList=dgShinsakaiIinList;
    }

}
