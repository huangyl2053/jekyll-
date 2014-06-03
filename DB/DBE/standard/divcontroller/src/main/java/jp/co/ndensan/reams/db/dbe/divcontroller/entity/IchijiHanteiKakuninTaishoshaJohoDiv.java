package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * IchijiHanteiKakuninTaishoshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiKakuninTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("txtHihokenNo")
    private TextBoxCode txtHihokenNo;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("txtShinseibi")
    private TextBoxDate txtShinseibi;
    @JsonProperty("txtShinseiKbnShin")
    private TextBox txtShinseiKbnShin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha=txtHokensha;
    }

    @JsonProperty("txtHihokenNo")
    public TextBoxCode getTxtHihokenNo() {
        return txtHihokenNo;
    }

    @JsonProperty("txtHihokenNo")
    public void setTxtHihokenNo(TextBoxCode txtHihokenNo) {
        this.txtHihokenNo=txtHihokenNo;
    }

    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName=txtHihokenshaName;
    }

    @JsonProperty("txtShinseibi")
    public TextBoxDate getTxtShinseibi() {
        return txtShinseibi;
    }

    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.txtShinseibi=txtShinseibi;
    }

    @JsonProperty("txtShinseiKbnShin")
    public TextBox getTxtShinseiKbnShin() {
        return txtShinseiKbnShin;
    }

    @JsonProperty("txtShinseiKbnShin")
    public void setTxtShinseiKbnShin(TextBox txtShinseiKbnShin) {
        this.txtShinseiKbnShin=txtShinseiKbnShin;
    }

}
