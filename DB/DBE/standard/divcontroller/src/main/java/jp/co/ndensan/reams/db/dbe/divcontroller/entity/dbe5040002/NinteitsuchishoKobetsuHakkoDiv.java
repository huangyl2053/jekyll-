package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002.NinteitsuchishoKobetsuHakkoTargetListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002.NinteitsuchishoKobetsuHakkoTargetSearchDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteitsuchishoKobetsuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteitsuchishoKobetsuHakkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteitsuchishoKobetsuHakkoTargetSearch")
    private NinteitsuchishoKobetsuHakkoTargetSearchDiv NinteitsuchishoKobetsuHakkoTargetSearch;
    @JsonProperty("NinteitsuchishoKobetsuHakkoTargetList")
    private NinteitsuchishoKobetsuHakkoTargetListDiv NinteitsuchishoKobetsuHakkoTargetList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteitsuchishoKobetsuHakkoTargetSearch")
    public NinteitsuchishoKobetsuHakkoTargetSearchDiv getNinteitsuchishoKobetsuHakkoTargetSearch() {
        return NinteitsuchishoKobetsuHakkoTargetSearch;
    }

    @JsonProperty("NinteitsuchishoKobetsuHakkoTargetSearch")
    public void setNinteitsuchishoKobetsuHakkoTargetSearch(NinteitsuchishoKobetsuHakkoTargetSearchDiv NinteitsuchishoKobetsuHakkoTargetSearch) {
        this.NinteitsuchishoKobetsuHakkoTargetSearch=NinteitsuchishoKobetsuHakkoTargetSearch;
    }

    @JsonProperty("NinteitsuchishoKobetsuHakkoTargetList")
    public NinteitsuchishoKobetsuHakkoTargetListDiv getNinteitsuchishoKobetsuHakkoTargetList() {
        return NinteitsuchishoKobetsuHakkoTargetList;
    }

    @JsonProperty("NinteitsuchishoKobetsuHakkoTargetList")
    public void setNinteitsuchishoKobetsuHakkoTargetList(NinteitsuchishoKobetsuHakkoTargetListDiv NinteitsuchishoKobetsuHakkoTargetList) {
        this.NinteitsuchishoKobetsuHakkoTargetList=NinteitsuchishoKobetsuHakkoTargetList;
    }

}
