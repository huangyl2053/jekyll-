package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tplSogoShokaiJukyuGenmenGengakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tplSogoShokaiJukyuKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tplSogoShokaiJukyuNinteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tplSogoShokaiJukyuShisetsuNyushoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabSogoShokaiJukyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabSogoShokaiJukyuDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplSogoShokaiJukyuNintei")
    private tplSogoShokaiJukyuNinteiDiv tplSogoShokaiJukyuNintei;
    @JsonProperty("tplSogoShokaiJukyuKyufuSeigen")
    private tplSogoShokaiJukyuKyufuSeigenDiv tplSogoShokaiJukyuKyufuSeigen;
    @JsonProperty("tplSogoShokaiJukyuGenmenGengaku")
    private tplSogoShokaiJukyuGenmenGengakuDiv tplSogoShokaiJukyuGenmenGengaku;
    @JsonProperty("tplSogoShokaiJukyuShisetsuNyusho")
    private tplSogoShokaiJukyuShisetsuNyushoDiv tplSogoShokaiJukyuShisetsuNyusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplSogoShokaiJukyuNintei")
    public tplSogoShokaiJukyuNinteiDiv getTplSogoShokaiJukyuNintei() {
        return tplSogoShokaiJukyuNintei;
    }

    @JsonProperty("tplSogoShokaiJukyuNintei")
    public void setTplSogoShokaiJukyuNintei(tplSogoShokaiJukyuNinteiDiv tplSogoShokaiJukyuNintei) {
        this.tplSogoShokaiJukyuNintei=tplSogoShokaiJukyuNintei;
    }

    @JsonProperty("tplSogoShokaiJukyuKyufuSeigen")
    public tplSogoShokaiJukyuKyufuSeigenDiv getTplSogoShokaiJukyuKyufuSeigen() {
        return tplSogoShokaiJukyuKyufuSeigen;
    }

    @JsonProperty("tplSogoShokaiJukyuKyufuSeigen")
    public void setTplSogoShokaiJukyuKyufuSeigen(tplSogoShokaiJukyuKyufuSeigenDiv tplSogoShokaiJukyuKyufuSeigen) {
        this.tplSogoShokaiJukyuKyufuSeigen=tplSogoShokaiJukyuKyufuSeigen;
    }

    @JsonProperty("tplSogoShokaiJukyuGenmenGengaku")
    public tplSogoShokaiJukyuGenmenGengakuDiv getTplSogoShokaiJukyuGenmenGengaku() {
        return tplSogoShokaiJukyuGenmenGengaku;
    }

    @JsonProperty("tplSogoShokaiJukyuGenmenGengaku")
    public void setTplSogoShokaiJukyuGenmenGengaku(tplSogoShokaiJukyuGenmenGengakuDiv tplSogoShokaiJukyuGenmenGengaku) {
        this.tplSogoShokaiJukyuGenmenGengaku=tplSogoShokaiJukyuGenmenGengaku;
    }

    @JsonProperty("tplSogoShokaiJukyuShisetsuNyusho")
    public tplSogoShokaiJukyuShisetsuNyushoDiv getTplSogoShokaiJukyuShisetsuNyusho() {
        return tplSogoShokaiJukyuShisetsuNyusho;
    }

    @JsonProperty("tplSogoShokaiJukyuShisetsuNyusho")
    public void setTplSogoShokaiJukyuShisetsuNyusho(tplSogoShokaiJukyuShisetsuNyushoDiv tplSogoShokaiJukyuShisetsuNyusho) {
        this.tplSogoShokaiJukyuShisetsuNyusho=tplSogoShokaiJukyuShisetsuNyusho;
    }

}
