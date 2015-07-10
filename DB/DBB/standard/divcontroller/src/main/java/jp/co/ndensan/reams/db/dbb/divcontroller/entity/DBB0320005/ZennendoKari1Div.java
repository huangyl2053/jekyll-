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
 * ZennendoKari1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZennendoKari1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenryoDankaiKari1")
    private TextBox txtHokenryoDankaiKari1;
    @JsonProperty("txtHokenryoRitsuKari1")
    private TextBox txtHokenryoRitsuKari1;
    @JsonProperty("txtNengakuHokenryoKari1")
    private TextBoxNum txtNengakuHokenryoKari1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHokenryoDankaiKari1")
    public TextBox getTxtHokenryoDankaiKari1() {
        return txtHokenryoDankaiKari1;
    }

    @JsonProperty("txtHokenryoDankaiKari1")
    public void setTxtHokenryoDankaiKari1(TextBox txtHokenryoDankaiKari1) {
        this.txtHokenryoDankaiKari1=txtHokenryoDankaiKari1;
    }

    @JsonProperty("txtHokenryoRitsuKari1")
    public TextBox getTxtHokenryoRitsuKari1() {
        return txtHokenryoRitsuKari1;
    }

    @JsonProperty("txtHokenryoRitsuKari1")
    public void setTxtHokenryoRitsuKari1(TextBox txtHokenryoRitsuKari1) {
        this.txtHokenryoRitsuKari1=txtHokenryoRitsuKari1;
    }

    @JsonProperty("txtNengakuHokenryoKari1")
    public TextBoxNum getTxtNengakuHokenryoKari1() {
        return txtNengakuHokenryoKari1;
    }

    @JsonProperty("txtNengakuHokenryoKari1")
    public void setTxtNengakuHokenryoKari1(TextBoxNum txtNengakuHokenryoKari1) {
        this.txtNengakuHokenryoKari1=txtNengakuHokenryoKari1;
    }

}
