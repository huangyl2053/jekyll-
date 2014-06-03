package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.HihokenshaForNinteichosaResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.NinteichosaDetailDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.tabNinteichosaResultDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaResultEntryMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaResultEntryMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaForNinteichosaResult")
    private HihokenshaForNinteichosaResultDiv HihokenshaForNinteichosaResult;
    @JsonProperty("NinteichosaDetail")
    private NinteichosaDetailDiv NinteichosaDetail;
    @JsonProperty("tabNinteichosaResult")
    private tabNinteichosaResultDiv tabNinteichosaResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaForNinteichosaResult")
    public HihokenshaForNinteichosaResultDiv getHihokenshaForNinteichosaResult() {
        return HihokenshaForNinteichosaResult;
    }

    @JsonProperty("HihokenshaForNinteichosaResult")
    public void setHihokenshaForNinteichosaResult(HihokenshaForNinteichosaResultDiv HihokenshaForNinteichosaResult) {
        this.HihokenshaForNinteichosaResult=HihokenshaForNinteichosaResult;
    }

    @JsonProperty("NinteichosaDetail")
    public NinteichosaDetailDiv getNinteichosaDetail() {
        return NinteichosaDetail;
    }

    @JsonProperty("NinteichosaDetail")
    public void setNinteichosaDetail(NinteichosaDetailDiv NinteichosaDetail) {
        this.NinteichosaDetail=NinteichosaDetail;
    }

    @JsonProperty("tabNinteichosaResult")
    public tabNinteichosaResultDiv getTabNinteichosaResult() {
        return tabNinteichosaResult;
    }

    @JsonProperty("tabNinteichosaResult")
    public void setTabNinteichosaResult(tabNinteichosaResultDiv tabNinteichosaResult) {
        this.tabNinteichosaResult=tabNinteichosaResult;
    }

}
