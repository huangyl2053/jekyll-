package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.tplIkensho1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.tplIkensho2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabIkenshoImageHyoji のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabIkenshoImageHyojiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplIkensho1")
    private tplIkensho1Div tplIkensho1;
    @JsonProperty("tplIkensho2")
    private tplIkensho2Div tplIkensho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplIkensho1")
    public tplIkensho1Div getTplIkensho1() {
        return tplIkensho1;
    }

    @JsonProperty("tplIkensho1")
    public void setTplIkensho1(tplIkensho1Div tplIkensho1) {
        this.tplIkensho1=tplIkensho1;
    }

    @JsonProperty("tplIkensho2")
    public tplIkensho2Div getTplIkensho2() {
        return tplIkensho2;
    }

    @JsonProperty("tplIkensho2")
    public void setTplIkensho2(tplIkensho2Div tplIkensho2) {
        this.tplIkensho2=tplIkensho2;
    }

}
