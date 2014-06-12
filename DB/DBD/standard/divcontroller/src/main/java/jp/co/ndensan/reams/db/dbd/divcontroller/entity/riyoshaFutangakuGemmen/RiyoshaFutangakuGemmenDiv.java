package jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen.RiyoshaFutangakuGemmenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen.dgRiyoshaFutangakuGemmenList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * RiyoshaFutangakuGemmen のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutangakuGemmenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgRiyoshaFutangakuGemmenList")
    private DataGrid<dgRiyoshaFutangakuGemmenList_Row> dgRiyoshaFutangakuGemmenList;
    @JsonProperty("RiyoshaFutangakuGemmenDetail")
    private RiyoshaFutangakuGemmenDetailDiv RiyoshaFutangakuGemmenDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgRiyoshaFutangakuGemmenList")
    public DataGrid<dgRiyoshaFutangakuGemmenList_Row> getDgRiyoshaFutangakuGemmenList() {
        return dgRiyoshaFutangakuGemmenList;
    }

    @JsonProperty("dgRiyoshaFutangakuGemmenList")
    public void setDgRiyoshaFutangakuGemmenList(DataGrid<dgRiyoshaFutangakuGemmenList_Row> dgRiyoshaFutangakuGemmenList) {
        this.dgRiyoshaFutangakuGemmenList=dgRiyoshaFutangakuGemmenList;
    }

    @JsonProperty("RiyoshaFutangakuGemmenDetail")
    public RiyoshaFutangakuGemmenDetailDiv getRiyoshaFutangakuGemmenDetail() {
        return RiyoshaFutangakuGemmenDetail;
    }

    @JsonProperty("RiyoshaFutangakuGemmenDetail")
    public void setRiyoshaFutangakuGemmenDetail(RiyoshaFutangakuGemmenDetailDiv RiyoshaFutangakuGemmenDetail) {
        this.RiyoshaFutangakuGemmenDetail=RiyoshaFutangakuGemmenDetail;
    }

}
