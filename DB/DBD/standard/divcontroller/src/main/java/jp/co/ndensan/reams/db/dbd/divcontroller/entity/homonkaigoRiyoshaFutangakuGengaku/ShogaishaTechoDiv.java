package jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku;
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
 * ShogaishaTecho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaTechoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShogakushaTechoUmu")
    private RadioButton chkShogakushaTechoUmu;
    @JsonProperty("txtShogaishaTechoTokyu")
    private TextBox txtShogaishaTechoTokyu;
    @JsonProperty("txtShogaishaTechoNo")
    private TextBoxCode txtShogaishaTechoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkShogakushaTechoUmu")
    public RadioButton getChkShogakushaTechoUmu() {
        return chkShogakushaTechoUmu;
    }

    @JsonProperty("chkShogakushaTechoUmu")
    public void setChkShogakushaTechoUmu(RadioButton chkShogakushaTechoUmu) {
        this.chkShogakushaTechoUmu=chkShogakushaTechoUmu;
    }

    @JsonProperty("txtShogaishaTechoTokyu")
    public TextBox getTxtShogaishaTechoTokyu() {
        return txtShogaishaTechoTokyu;
    }

    @JsonProperty("txtShogaishaTechoTokyu")
    public void setTxtShogaishaTechoTokyu(TextBox txtShogaishaTechoTokyu) {
        this.txtShogaishaTechoTokyu=txtShogaishaTechoTokyu;
    }

    @JsonProperty("txtShogaishaTechoNo")
    public TextBoxCode getTxtShogaishaTechoNo() {
        return txtShogaishaTechoNo;
    }

    @JsonProperty("txtShogaishaTechoNo")
    public void setTxtShogaishaTechoNo(TextBoxCode txtShogaishaTechoNo) {
        this.txtShogaishaTechoNo=txtShogaishaTechoNo;
    }

}
