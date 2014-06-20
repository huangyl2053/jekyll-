package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
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
 * FukaHikakuFukakijun1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaHikakuFukakijun1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikakuShutokuYMD1")
    private TextBoxDate txtShikakuShutokuYMD1;
    @JsonProperty("txtShikakuSoshitsuYMD1")
    private TextBoxDate txtShikakuSoshitsuYMD1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikakuShutokuYMD1")
    public TextBoxDate getTxtShikakuShutokuYMD1() {
        return txtShikakuShutokuYMD1;
    }

    @JsonProperty("txtShikakuShutokuYMD1")
    public void setTxtShikakuShutokuYMD1(TextBoxDate txtShikakuShutokuYMD1) {
        this.txtShikakuShutokuYMD1=txtShikakuShutokuYMD1;
    }

    @JsonProperty("txtShikakuSoshitsuYMD1")
    public TextBoxDate getTxtShikakuSoshitsuYMD1() {
        return txtShikakuSoshitsuYMD1;
    }

    @JsonProperty("txtShikakuSoshitsuYMD1")
    public void setTxtShikakuSoshitsuYMD1(TextBoxDate txtShikakuSoshitsuYMD1) {
        this.txtShikakuSoshitsuYMD1=txtShikakuSoshitsuYMD1;
    }

}
