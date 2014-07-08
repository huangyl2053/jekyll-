package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaHikakuZennendo1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaHikakuZennendo1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenryoDankai1")
    private TextBox txtHokenryoDankai1;
    @JsonProperty("txtHokenryoRitsu1")
    private TextBox txtHokenryoRitsu1;
    @JsonProperty("txtNengakuHokensryo1")
    private TextBox txtNengakuHokensryo1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHokenryoDankai1")
    public TextBox getTxtHokenryoDankai1() {
        return txtHokenryoDankai1;
    }

    @JsonProperty("txtHokenryoDankai1")
    public void setTxtHokenryoDankai1(TextBox txtHokenryoDankai1) {
        this.txtHokenryoDankai1=txtHokenryoDankai1;
    }

    @JsonProperty("txtHokenryoRitsu1")
    public TextBox getTxtHokenryoRitsu1() {
        return txtHokenryoRitsu1;
    }

    @JsonProperty("txtHokenryoRitsu1")
    public void setTxtHokenryoRitsu1(TextBox txtHokenryoRitsu1) {
        this.txtHokenryoRitsu1=txtHokenryoRitsu1;
    }

    @JsonProperty("txtNengakuHokensryo1")
    public TextBox getTxtNengakuHokensryo1() {
        return txtNengakuHokensryo1;
    }

    @JsonProperty("txtNengakuHokensryo1")
    public void setTxtNengakuHokensryo1(TextBox txtNengakuHokensryo1) {
        this.txtNengakuHokensryo1=txtNengakuHokensryo1;
    }

}
