package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.HyojunFutangakuGemmenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dgTaishoshaList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HyojunFutangakuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HyojunFutangakuGengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTaishoshaList")
    private DataGrid<dgTaishoshaList_Row> dgTaishoshaList;
    @JsonProperty("HyojunFutangakuGemmenDetail")
    private HyojunFutangakuGemmenDetailDiv HyojunFutangakuGemmenDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTaishoshaList")
    public DataGrid<dgTaishoshaList_Row> getDgTaishoshaList() {
        return dgTaishoshaList;
    }

    @JsonProperty("dgTaishoshaList")
    public void setDgTaishoshaList(DataGrid<dgTaishoshaList_Row> dgTaishoshaList) {
        this.dgTaishoshaList=dgTaishoshaList;
    }

    @JsonProperty("HyojunFutangakuGemmenDetail")
    public HyojunFutangakuGemmenDetailDiv getHyojunFutangakuGemmenDetail() {
        return HyojunFutangakuGemmenDetail;
    }

    @JsonProperty("HyojunFutangakuGemmenDetail")
    public void setHyojunFutangakuGemmenDetail(HyojunFutangakuGemmenDetailDiv HyojunFutangakuGemmenDetail) {
        this.HyojunFutangakuGemmenDetail=HyojunFutangakuGemmenDetail;
    }

}
