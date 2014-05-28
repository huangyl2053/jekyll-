package jp.co.ndensan.reams.db.dba.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaishaDbJohoDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TekiyoJogaiTaishoshaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class TekiyoJogaiTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("TekiyoJogaishaCommonJoho")
    private AtenaShokaiSimpleDiv TekiyoJogaishaCommonJoho;
    @JsonProperty("TekiyoJogaishaDbJoho")
    private TekiyoJogaishaDbJohoDiv TekiyoJogaishaDbJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TekiyoJogaishaCommonJoho")
    public AtenaShokaiSimpleDiv getTekiyoJogaishaCommonJoho() {
        return TekiyoJogaishaCommonJoho;
    }

    @JsonProperty("TekiyoJogaishaCommonJoho")
    public void setTekiyoJogaishaCommonJoho(AtenaShokaiSimpleDiv TekiyoJogaishaCommonJoho) {
        this.TekiyoJogaishaCommonJoho = TekiyoJogaishaCommonJoho;
    }

    @JsonProperty("TekiyoJogaishaDbJoho")
    public TekiyoJogaishaDbJohoDiv getTekiyoJogaishaDbJoho() {
        return TekiyoJogaishaDbJoho;
    }

    @JsonProperty("TekiyoJogaishaDbJoho")
    public void setTekiyoJogaishaDbJoho(TekiyoJogaishaDbJohoDiv TekiyoJogaishaDbJoho) {
        this.TekiyoJogaishaDbJoho = TekiyoJogaishaDbJoho;
    }

}
