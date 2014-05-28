package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplGendoGakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShienJigyoshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShinsakaiIkenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabHihokenshaShikakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabHihokenshaShikakuShosaiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplGendoGaku")
    private tplGendoGakuDiv tplGendoGaku;
    @JsonProperty("tplShinsakaiIken")
    private tplShinsakaiIkenDiv tplShinsakaiIken;
    @JsonProperty("tplKyufuSeigen")
    private tplKyufuSeigenDiv tplKyufuSeigen;
    @JsonProperty("tplShienJigyosha")
    private tplShienJigyoshaDiv tplShienJigyosha;
    @JsonProperty("tplShisetsuNyutaisho")
    private tplShisetsuNyutaishoDiv tplShisetsuNyutaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplGendoGaku")
    public tplGendoGakuDiv getTplGendoGaku() {
        return tplGendoGaku;
    }

    @JsonProperty("tplGendoGaku")
    public void setTplGendoGaku(tplGendoGakuDiv tplGendoGaku) {
        this.tplGendoGaku=tplGendoGaku;
    }

    @JsonProperty("tplShinsakaiIken")
    public tplShinsakaiIkenDiv getTplShinsakaiIken() {
        return tplShinsakaiIken;
    }

    @JsonProperty("tplShinsakaiIken")
    public void setTplShinsakaiIken(tplShinsakaiIkenDiv tplShinsakaiIken) {
        this.tplShinsakaiIken=tplShinsakaiIken;
    }

    @JsonProperty("tplKyufuSeigen")
    public tplKyufuSeigenDiv getTplKyufuSeigen() {
        return tplKyufuSeigen;
    }

    @JsonProperty("tplKyufuSeigen")
    public void setTplKyufuSeigen(tplKyufuSeigenDiv tplKyufuSeigen) {
        this.tplKyufuSeigen=tplKyufuSeigen;
    }

    @JsonProperty("tplShienJigyosha")
    public tplShienJigyoshaDiv getTplShienJigyosha() {
        return tplShienJigyosha;
    }

    @JsonProperty("tplShienJigyosha")
    public void setTplShienJigyosha(tplShienJigyoshaDiv tplShienJigyosha) {
        this.tplShienJigyosha=tplShienJigyosha;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return tplShisetsuNyutaisho;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.tplShisetsuNyutaisho=tplShisetsuNyutaisho;
    }

}
