package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002;
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
 * FukaErrorShoriButton のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaErrorShoriButtonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnMishori")
    private Button btnMishori;
    @JsonProperty("btnFukaKosei")
    private Button btnFukaKosei;
    @JsonProperty("btnShikakuFuseigo")
    private Button btnShikakuFuseigo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnMishori")
    public Button getBtnMishori() {
        return btnMishori;
    }

    @JsonProperty("btnMishori")
    public void setBtnMishori(Button btnMishori) {
        this.btnMishori=btnMishori;
    }

    @JsonProperty("btnFukaKosei")
    public Button getBtnFukaKosei() {
        return btnFukaKosei;
    }

    @JsonProperty("btnFukaKosei")
    public void setBtnFukaKosei(Button btnFukaKosei) {
        this.btnFukaKosei=btnFukaKosei;
    }

    @JsonProperty("btnShikakuFuseigo")
    public Button getBtnShikakuFuseigo() {
        return btnShikakuFuseigo;
    }

    @JsonProperty("btnShikakuFuseigo")
    public void setBtnShikakuFuseigo(Button btnShikakuFuseigo) {
        this.btnShikakuFuseigo=btnShikakuFuseigo;
    }

}
