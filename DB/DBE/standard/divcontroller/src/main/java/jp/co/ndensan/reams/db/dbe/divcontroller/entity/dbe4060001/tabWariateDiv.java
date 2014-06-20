package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.tplShinsainWariateDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.tplTaishoshaWariateDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabWariate のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabWariateDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplTaishoshaWariate")
    private tplTaishoshaWariateDiv tplTaishoshaWariate;
    @JsonProperty("tplShinsainWariate")
    private tplShinsainWariateDiv tplShinsainWariate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplTaishoshaWariate")
    public tplTaishoshaWariateDiv getTplTaishoshaWariate() {
        return tplTaishoshaWariate;
    }

    @JsonProperty("tplTaishoshaWariate")
    public void setTplTaishoshaWariate(tplTaishoshaWariateDiv tplTaishoshaWariate) {
        this.tplTaishoshaWariate=tplTaishoshaWariate;
    }

    @JsonProperty("tplShinsainWariate")
    public tplShinsainWariateDiv getTplShinsainWariate() {
        return tplShinsainWariate;
    }

    @JsonProperty("tplShinsainWariate")
    public void setTplShinsainWariate(tplShinsainWariateDiv tplShinsainWariate) {
        this.tplShinsainWariate=tplShinsainWariate;
    }

}
