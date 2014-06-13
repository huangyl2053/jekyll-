package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tplIkenshoShosaiImageHyoji1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tplIkenshoShosaiImageHyoji2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabIkenshoShosaiHyoji のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabIkenshoShosaiHyojiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplIkenshoShosaiImageHyoji1")
    private tplIkenshoShosaiImageHyoji1Div tplIkenshoShosaiImageHyoji1;
    @JsonProperty("tplIkenshoShosaiImageHyoji2")
    private tplIkenshoShosaiImageHyoji2Div tplIkenshoShosaiImageHyoji2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplIkenshoShosaiImageHyoji1")
    public tplIkenshoShosaiImageHyoji1Div getTplIkenshoShosaiImageHyoji1() {
        return tplIkenshoShosaiImageHyoji1;
    }

    @JsonProperty("tplIkenshoShosaiImageHyoji1")
    public void setTplIkenshoShosaiImageHyoji1(tplIkenshoShosaiImageHyoji1Div tplIkenshoShosaiImageHyoji1) {
        this.tplIkenshoShosaiImageHyoji1=tplIkenshoShosaiImageHyoji1;
    }

    @JsonProperty("tplIkenshoShosaiImageHyoji2")
    public tplIkenshoShosaiImageHyoji2Div getTplIkenshoShosaiImageHyoji2() {
        return tplIkenshoShosaiImageHyoji2;
    }

    @JsonProperty("tplIkenshoShosaiImageHyoji2")
    public void setTplIkenshoShosaiImageHyoji2(tplIkenshoShosaiImageHyoji2Div tplIkenshoShosaiImageHyoji2) {
        this.tplIkenshoShosaiImageHyoji2=tplIkenshoShosaiImageHyoji2;
    }

}
