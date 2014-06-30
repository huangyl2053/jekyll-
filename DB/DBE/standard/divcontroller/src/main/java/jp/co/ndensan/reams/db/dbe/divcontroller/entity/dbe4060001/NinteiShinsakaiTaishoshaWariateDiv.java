package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.NinteiShinsakaiJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.tabWariateDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiShinsakaiTaishoshaWariate のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinsakaiTaishoshaWariateDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiShinsakaiJoho")
    private NinteiShinsakaiJohoDiv NinteiShinsakaiJoho;
    @JsonProperty("tabWariate")
    private tabWariateDiv tabWariate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteiShinsakaiJoho")
    public NinteiShinsakaiJohoDiv getNinteiShinsakaiJoho() {
        return NinteiShinsakaiJoho;
    }

    @JsonProperty("NinteiShinsakaiJoho")
    public void setNinteiShinsakaiJoho(NinteiShinsakaiJohoDiv NinteiShinsakaiJoho) {
        this.NinteiShinsakaiJoho=NinteiShinsakaiJoho;
    }

    @JsonProperty("tabWariate")
    public tabWariateDiv getTabWariate() {
        return tabWariate;
    }

    @JsonProperty("tabWariate")
    public void setTabWariate(tabWariateDiv tabWariate) {
        this.tabWariate=tabWariate;
    }

}
