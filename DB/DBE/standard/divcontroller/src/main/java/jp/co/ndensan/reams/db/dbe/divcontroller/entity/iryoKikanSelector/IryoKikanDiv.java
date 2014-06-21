package jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.IryoKikanListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.IshiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IryoKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoKikanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IryoKikanList")
    private IryoKikanListDiv IryoKikanList;
    @JsonProperty("Ishi")
    private IshiDiv Ishi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("IryoKikanList")
    public IryoKikanListDiv getIryoKikanList() {
        return IryoKikanList;
    }

    @JsonProperty("IryoKikanList")
    public void setIryoKikanList(IryoKikanListDiv IryoKikanList) {
        this.IryoKikanList=IryoKikanList;
    }

    @JsonProperty("Ishi")
    public IshiDiv getIshi() {
        return Ishi;
    }

    @JsonProperty("Ishi")
    public void setIshi(IshiDiv Ishi) {
        this.Ishi=Ishi;
    }

}
