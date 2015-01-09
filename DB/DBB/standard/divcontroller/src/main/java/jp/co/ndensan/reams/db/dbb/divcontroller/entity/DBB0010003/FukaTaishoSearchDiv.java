package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0010003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaTaishoSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaTaishoSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TaishoshaSearch")
    private HihokenshaFinderDiv TaishoshaSearch;
    @JsonProperty("TaishoshaSentaku")
    private TaishoshaSentakuDiv TaishoshaSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TaishoshaSearch")
    public HihokenshaFinderDiv getTaishoshaSearch() {
        return TaishoshaSearch;
    }

    @JsonProperty("TaishoshaSearch")
    public void setTaishoshaSearch(HihokenshaFinderDiv TaishoshaSearch) {
        this.TaishoshaSearch=TaishoshaSearch;
    }

    @JsonProperty("TaishoshaSentaku")
    public TaishoshaSentakuDiv getTaishoshaSentaku() {
        return TaishoshaSentaku;
    }

    @JsonProperty("TaishoshaSentaku")
    public void setTaishoshaSentaku(TaishoshaSentakuDiv TaishoshaSentaku) {
        this.TaishoshaSentaku=TaishoshaSentaku;
    }

}
