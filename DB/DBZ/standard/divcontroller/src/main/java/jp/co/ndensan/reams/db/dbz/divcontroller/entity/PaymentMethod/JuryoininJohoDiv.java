package jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod;
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
 * JuryoininJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuryoininJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJuryoininKeiyakuNo")
    private TextBoxCode txtJuryoininKeiyakuNo;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtJigyoshaNameKana")
    private TextBox txtJigyoshaNameKana;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJuryoininKeiyakuNo")
    public TextBoxCode getTxtJuryoininKeiyakuNo() {
        return txtJuryoininKeiyakuNo;
    }

    @JsonProperty("txtJuryoininKeiyakuNo")
    public void setTxtJuryoininKeiyakuNo(TextBoxCode txtJuryoininKeiyakuNo) {
        this.txtJuryoininKeiyakuNo=txtJuryoininKeiyakuNo;
    }

    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo=txtJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName=txtJigyoshaName;
    }

    @JsonProperty("txtJigyoshaNameKana")
    public TextBox getTxtJigyoshaNameKana() {
        return txtJigyoshaNameKana;
    }

    @JsonProperty("txtJigyoshaNameKana")
    public void setTxtJigyoshaNameKana(TextBox txtJigyoshaNameKana) {
        this.txtJigyoshaNameKana=txtJigyoshaNameKana;
    }

}
