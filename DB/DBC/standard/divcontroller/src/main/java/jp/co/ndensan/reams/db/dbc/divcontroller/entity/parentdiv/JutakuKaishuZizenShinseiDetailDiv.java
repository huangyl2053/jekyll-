package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.IKyufugakuSummaryDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuZizenShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuZizenShinseiDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJutakuKaishuJizenShinseiDetail")
    private DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> dgJutakuKaishuJizenShinseiDetail;
    @JsonProperty("JutakuKaishuJizenShinseiKyufugakuSummary")
    private KyufugakuSummaryDiv JutakuKaishuJizenShinseiKyufugakuSummary;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJutakuKaishuJizenShinseiDetail")
    public DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> getDgJutakuKaishuJizenShinseiDetail() {
        return dgJutakuKaishuJizenShinseiDetail;
    }

    @JsonProperty("dgJutakuKaishuJizenShinseiDetail")
    public void setDgJutakuKaishuJizenShinseiDetail(DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> dgJutakuKaishuJizenShinseiDetail) {
        this.dgJutakuKaishuJizenShinseiDetail=dgJutakuKaishuJizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuJizenShinseiKyufugakuSummary")
    public IKyufugakuSummaryDiv getJutakuKaishuJizenShinseiKyufugakuSummary() {
        return JutakuKaishuJizenShinseiKyufugakuSummary;
    }

}
