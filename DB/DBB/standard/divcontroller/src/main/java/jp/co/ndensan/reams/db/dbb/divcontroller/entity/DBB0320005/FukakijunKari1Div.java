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
 * FukakijunKari1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukakijunKari1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikakuShutokuYMDKari1")
    private TextBoxDate txtShikakuShutokuYMDKari1;
    @JsonProperty("txtShikakuSoshitsuYMDKari1")
    private TextBoxDate txtShikakuSoshitsuYMDKari1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikakuShutokuYMDKari1")
    public TextBoxDate getTxtShikakuShutokuYMDKari1() {
        return txtShikakuShutokuYMDKari1;
    }

    @JsonProperty("txtShikakuShutokuYMDKari1")
    public void setTxtShikakuShutokuYMDKari1(TextBoxDate txtShikakuShutokuYMDKari1) {
        this.txtShikakuShutokuYMDKari1=txtShikakuShutokuYMDKari1;
    }

    @JsonProperty("txtShikakuSoshitsuYMDKari1")
    public TextBoxDate getTxtShikakuSoshitsuYMDKari1() {
        return txtShikakuSoshitsuYMDKari1;
    }

    @JsonProperty("txtShikakuSoshitsuYMDKari1")
    public void setTxtShikakuSoshitsuYMDKari1(TextBoxDate txtShikakuSoshitsuYMDKari1) {
        this.txtShikakuSoshitsuYMDKari1=txtShikakuSoshitsuYMDKari1;
    }

}
