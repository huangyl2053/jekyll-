package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.dba203001t;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabInputs のクラスファイル
 *
 * @author 自動生成
 */
public class tabInputsDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("tplShikakuJoho")
    private tplShikakuJohoDiv tplShikakuJoho;
    @JsonProperty("tplIryoHoken")
    private tplIryoHokenDiv tplIryoHoken;
    @JsonProperty("tplRofukuNenkin")
    private tplRofukuNenkinDiv tplRofukuNenkin;
    @JsonProperty("tplShisetsuNyutaisho")
    private tplShisetsuNyutaishoDiv tplShisetsuNyutaisho;
    @JsonProperty("tplSeikatsuHogo")
    private tplSeikatsuHogoDiv tplSeikatsuHogo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplShikakuJoho")
    public tplShikakuJohoDiv getTplShikakuJoho() {
        return tplShikakuJoho;
    }

    @JsonProperty("tplShikakuJoho")
    public void setTplShikakuJoho(tplShikakuJohoDiv tplShikakuJoho) {
        this.tplShikakuJoho = tplShikakuJoho;
    }

    @JsonProperty("tplIryoHoken")
    public tplIryoHokenDiv getTplIryoHoken() {
        return tplIryoHoken;
    }

    @JsonProperty("tplIryoHoken")
    public void setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.tplIryoHoken = tplIryoHoken;
    }

    @JsonProperty("tplRofukuNenkin")
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return tplRofukuNenkin;
    }

    @JsonProperty("tplRofukuNenkin")
    public void setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.tplRofukuNenkin = tplRofukuNenkin;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return tplShisetsuNyutaisho;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.tplShisetsuNyutaisho = tplShisetsuNyutaisho;
    }

    @JsonProperty("tplSeikatsuHogo")
    public tplSeikatsuHogoDiv getTplSeikatsuHogo() {
        return tplSeikatsuHogo;
    }

    @JsonProperty("tplSeikatsuHogo")
    public void setTplSeikatsuHogo(tplSeikatsuHogoDiv tplSeikatsuHogo) {
        this.tplSeikatsuHogo = tplSeikatsuHogo;
    }

}
