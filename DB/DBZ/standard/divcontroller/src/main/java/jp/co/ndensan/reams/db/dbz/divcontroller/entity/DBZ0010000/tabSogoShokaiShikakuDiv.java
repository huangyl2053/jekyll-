package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tplSogoShokaiShikakuJogaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tplSogoShokaiShikakuTokureiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.tplSogoShokaiShikakuTokusoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabSogoShokaiShikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabSogoShokaiShikakuDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplSogoShokaiShikakuTokuso")
    private tplSogoShokaiShikakuTokusoDiv tplSogoShokaiShikakuTokuso;
    @JsonProperty("tplSogoShokaiShikakuTokurei")
    private tplSogoShokaiShikakuTokureiDiv tplSogoShokaiShikakuTokurei;
    @JsonProperty("tplSogoShokaiShikakuJogai")
    private tplSogoShokaiShikakuJogaiDiv tplSogoShokaiShikakuJogai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplSogoShokaiShikakuTokuso")
    public tplSogoShokaiShikakuTokusoDiv getTplSogoShokaiShikakuTokuso() {
        return tplSogoShokaiShikakuTokuso;
    }

    @JsonProperty("tplSogoShokaiShikakuTokuso")
    public void setTplSogoShokaiShikakuTokuso(tplSogoShokaiShikakuTokusoDiv tplSogoShokaiShikakuTokuso) {
        this.tplSogoShokaiShikakuTokuso=tplSogoShokaiShikakuTokuso;
    }

    @JsonProperty("tplSogoShokaiShikakuTokurei")
    public tplSogoShokaiShikakuTokureiDiv getTplSogoShokaiShikakuTokurei() {
        return tplSogoShokaiShikakuTokurei;
    }

    @JsonProperty("tplSogoShokaiShikakuTokurei")
    public void setTplSogoShokaiShikakuTokurei(tplSogoShokaiShikakuTokureiDiv tplSogoShokaiShikakuTokurei) {
        this.tplSogoShokaiShikakuTokurei=tplSogoShokaiShikakuTokurei;
    }

    @JsonProperty("tplSogoShokaiShikakuJogai")
    public tplSogoShokaiShikakuJogaiDiv getTplSogoShokaiShikakuJogai() {
        return tplSogoShokaiShikakuJogai;
    }

    @JsonProperty("tplSogoShokaiShikakuJogai")
    public void setTplSogoShokaiShikakuJogai(tplSogoShokaiShikakuJogaiDiv tplSogoShokaiShikakuJogai) {
        this.tplSogoShokaiShikakuJogai=tplSogoShokaiShikakuJogai;
    }

}
