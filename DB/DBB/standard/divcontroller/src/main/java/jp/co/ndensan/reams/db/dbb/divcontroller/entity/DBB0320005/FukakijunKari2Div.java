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
 * FukakijunKari2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukakijunKari2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikakuShutokuYMDKari2")
    private TextBoxDate txtShikakuShutokuYMDKari2;
    @JsonProperty("txtShikakuSoshitsuYMDKari2")
    private TextBoxDate txtShikakuSoshitsuYMDKari2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikakuShutokuYMDKari2")
    public TextBoxDate getTxtShikakuShutokuYMDKari2() {
        return txtShikakuShutokuYMDKari2;
    }

    @JsonProperty("txtShikakuShutokuYMDKari2")
    public void setTxtShikakuShutokuYMDKari2(TextBoxDate txtShikakuShutokuYMDKari2) {
        this.txtShikakuShutokuYMDKari2=txtShikakuShutokuYMDKari2;
    }

    @JsonProperty("txtShikakuSoshitsuYMDKari2")
    public TextBoxDate getTxtShikakuSoshitsuYMDKari2() {
        return txtShikakuSoshitsuYMDKari2;
    }

    @JsonProperty("txtShikakuSoshitsuYMDKari2")
    public void setTxtShikakuSoshitsuYMDKari2(TextBoxDate txtShikakuSoshitsuYMDKari2) {
        this.txtShikakuSoshitsuYMDKari2=txtShikakuSoshitsuYMDKari2;
    }

}
