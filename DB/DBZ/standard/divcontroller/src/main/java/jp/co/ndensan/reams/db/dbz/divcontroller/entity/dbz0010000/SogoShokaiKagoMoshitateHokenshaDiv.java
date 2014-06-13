package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
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
 * SogoShokaiKagoMoshitateHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKagoMoshitateHokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKagoHokenshaTanisu")
    private TextBoxNum txtKagoHokenshaTanisu;
    @JsonProperty("txtKagoHokenshaFutangaku")
    private TextBoxNum txtKagoHokenshaFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKagoHokenshaTanisu")
    public TextBoxNum getTxtKagoHokenshaTanisu() {
        return txtKagoHokenshaTanisu;
    }

    @JsonProperty("txtKagoHokenshaTanisu")
    public void setTxtKagoHokenshaTanisu(TextBoxNum txtKagoHokenshaTanisu) {
        this.txtKagoHokenshaTanisu=txtKagoHokenshaTanisu;
    }

    @JsonProperty("txtKagoHokenshaFutangaku")
    public TextBoxNum getTxtKagoHokenshaFutangaku() {
        return txtKagoHokenshaFutangaku;
    }

    @JsonProperty("txtKagoHokenshaFutangaku")
    public void setTxtKagoHokenshaFutangaku(TextBoxNum txtKagoHokenshaFutangaku) {
        this.txtKagoHokenshaFutangaku=txtKagoHokenshaFutangaku;
    }

}
