package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
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
 * TokuchoIdoJohoSaiSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoIdoJohoSaiSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSaiSakuseiMsg1")
    private Label lblSaiSakuseiMsg1;
    @JsonProperty("lblSaiSakuseiMsg2")
    private Label lblSaiSakuseiMsg2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblSaiSakuseiMsg1")
    public Label getLblSaiSakuseiMsg1() {
        return lblSaiSakuseiMsg1;
    }

    @JsonProperty("lblSaiSakuseiMsg1")
    public void setLblSaiSakuseiMsg1(Label lblSaiSakuseiMsg1) {
        this.lblSaiSakuseiMsg1=lblSaiSakuseiMsg1;
    }

    @JsonProperty("lblSaiSakuseiMsg2")
    public Label getLblSaiSakuseiMsg2() {
        return lblSaiSakuseiMsg2;
    }

    @JsonProperty("lblSaiSakuseiMsg2")
    public void setLblSaiSakuseiMsg2(Label lblSaiSakuseiMsg2) {
        this.lblSaiSakuseiMsg2=lblSaiSakuseiMsg2;
    }

}
