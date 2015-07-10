package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005;
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
 * ZennendoKari2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZennendoKari2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenryoDankaiKari2")
    private TextBox txtHokenryoDankaiKari2;
    @JsonProperty("txtHokenryoRitsuKari2")
    private TextBox txtHokenryoRitsuKari2;
    @JsonProperty("txtNengakuHokenryoKari2")
    private TextBoxNum txtNengakuHokenryoKari2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHokenryoDankaiKari2")
    public TextBox getTxtHokenryoDankaiKari2() {
        return txtHokenryoDankaiKari2;
    }

    @JsonProperty("txtHokenryoDankaiKari2")
    public void setTxtHokenryoDankaiKari2(TextBox txtHokenryoDankaiKari2) {
        this.txtHokenryoDankaiKari2=txtHokenryoDankaiKari2;
    }

    @JsonProperty("txtHokenryoRitsuKari2")
    public TextBox getTxtHokenryoRitsuKari2() {
        return txtHokenryoRitsuKari2;
    }

    @JsonProperty("txtHokenryoRitsuKari2")
    public void setTxtHokenryoRitsuKari2(TextBox txtHokenryoRitsuKari2) {
        this.txtHokenryoRitsuKari2=txtHokenryoRitsuKari2;
    }

    @JsonProperty("txtNengakuHokenryoKari2")
    public TextBoxNum getTxtNengakuHokenryoKari2() {
        return txtNengakuHokenryoKari2;
    }

    @JsonProperty("txtNengakuHokenryoKari2")
    public void setTxtNengakuHokenryoKari2(TextBoxNum txtNengakuHokenryoKari2) {
        this.txtNengakuHokenryoKari2=txtNengakuHokenryoKari2;
    }

}
