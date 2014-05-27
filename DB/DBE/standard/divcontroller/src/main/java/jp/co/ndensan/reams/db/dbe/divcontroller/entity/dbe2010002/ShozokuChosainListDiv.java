package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShozokuChosainListCom;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShozokuChosainListCom;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShozokuChosainList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShozokuChosainListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("comChosainList")
    private ShozokuChosainListCom comChosainList;
    @JsonProperty("comChosainListAll")
    private ShozokuChosainListCom comChosainListAll;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("comChosainList")
    public ShozokuChosainListCom getComChosainList() {
        return comChosainList;
    }

    @JsonProperty("comChosainList")
    public void setComChosainList(ShozokuChosainListCom comChosainList) {
        this.comChosainList=comChosainList;
    }

    @JsonProperty("comChosainListAll")
    public ShozokuChosainListCom getComChosainListAll() {
        return comChosainListAll;
    }

    @JsonProperty("comChosainListAll")
    public void setComChosainListAll(ShozokuChosainListCom comChosainListAll) {
        this.comChosainListAll=comChosainListAll;
    }

}
