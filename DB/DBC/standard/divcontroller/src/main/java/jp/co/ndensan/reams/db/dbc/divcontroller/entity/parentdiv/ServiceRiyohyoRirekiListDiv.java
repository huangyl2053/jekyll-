package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.IServiceRiyohyoRirekiListDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceRiyohyoRirekiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoRirekiListDiv extends Panel implements IServiceRiyohyoRirekiListDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgServiceRiyohyoRirekiList")
    private DataGrid<dgServiceRiyohyoRirekiList_Row> dgServiceRiyohyoRirekiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgServiceRiyohyoRirekiList")
    public DataGrid<dgServiceRiyohyoRirekiList_Row> getDgServiceRiyohyoRirekiList() {
        return dgServiceRiyohyoRirekiList;
    }

    @JsonProperty("dgServiceRiyohyoRirekiList")
    public void setDgServiceRiyohyoRirekiList(DataGrid<dgServiceRiyohyoRirekiList_Row> dgServiceRiyohyoRirekiList) {
        this.dgServiceRiyohyoRirekiList=dgServiceRiyohyoRirekiList;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
