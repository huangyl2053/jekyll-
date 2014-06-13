package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
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
 * SogoShokaiKagoMoshitateJiyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKagoMoshitateJiyuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKagoMoshitateYoshiki")
    private TextBox txtKagoMoshitateYoshiki;
    @JsonProperty("txtKagoMoshitateRiyu")
    private TextBox txtKagoMoshitateRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKagoMoshitateYoshiki")
    public TextBox getTxtKagoMoshitateYoshiki() {
        return txtKagoMoshitateYoshiki;
    }

    @JsonProperty("txtKagoMoshitateYoshiki")
    public void setTxtKagoMoshitateYoshiki(TextBox txtKagoMoshitateYoshiki) {
        this.txtKagoMoshitateYoshiki=txtKagoMoshitateYoshiki;
    }

    @JsonProperty("txtKagoMoshitateRiyu")
    public TextBox getTxtKagoMoshitateRiyu() {
        return txtKagoMoshitateRiyu;
    }

    @JsonProperty("txtKagoMoshitateRiyu")
    public void setTxtKagoMoshitateRiyu(TextBox txtKagoMoshitateRiyu) {
        this.txtKagoMoshitateRiyu=txtKagoMoshitateRiyu;
    }

}
