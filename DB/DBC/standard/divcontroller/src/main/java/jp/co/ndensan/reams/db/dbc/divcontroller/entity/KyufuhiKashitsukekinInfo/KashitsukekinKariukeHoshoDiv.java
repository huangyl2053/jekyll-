package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
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
 * KashitsukekinKariukeHosho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinKariukeHoshoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKariukeHoshoName")
    private TextBox txtKariukeHoshoName;
    @JsonProperty("txtKariukeHoshoKana")
    private TextBoxKana txtKariukeHoshoKana;
    @JsonProperty("txtKariukeHoshoYubinNo")
    private TextBoxYubinNo txtKariukeHoshoYubinNo;
    @JsonProperty("txtKariukeHoshoJusho")
    private TextBox txtKariukeHoshoJusho;
    @JsonProperty("txtKariukeHoshoTelNo")
    private TextBox txtKariukeHoshoTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKariukeHoshoName")
    public TextBox getTxtKariukeHoshoName() {
        return txtKariukeHoshoName;
    }

    @JsonProperty("txtKariukeHoshoName")
    public void setTxtKariukeHoshoName(TextBox txtKariukeHoshoName) {
        this.txtKariukeHoshoName=txtKariukeHoshoName;
    }

    @JsonProperty("txtKariukeHoshoKana")
    public TextBoxKana getTxtKariukeHoshoKana() {
        return txtKariukeHoshoKana;
    }

    @JsonProperty("txtKariukeHoshoKana")
    public void setTxtKariukeHoshoKana(TextBoxKana txtKariukeHoshoKana) {
        this.txtKariukeHoshoKana=txtKariukeHoshoKana;
    }

    @JsonProperty("txtKariukeHoshoYubinNo")
    public TextBoxYubinNo getTxtKariukeHoshoYubinNo() {
        return txtKariukeHoshoYubinNo;
    }

    @JsonProperty("txtKariukeHoshoYubinNo")
    public void setTxtKariukeHoshoYubinNo(TextBoxYubinNo txtKariukeHoshoYubinNo) {
        this.txtKariukeHoshoYubinNo=txtKariukeHoshoYubinNo;
    }

    @JsonProperty("txtKariukeHoshoJusho")
    public TextBox getTxtKariukeHoshoJusho() {
        return txtKariukeHoshoJusho;
    }

    @JsonProperty("txtKariukeHoshoJusho")
    public void setTxtKariukeHoshoJusho(TextBox txtKariukeHoshoJusho) {
        this.txtKariukeHoshoJusho=txtKariukeHoshoJusho;
    }

    @JsonProperty("txtKariukeHoshoTelNo")
    public TextBox getTxtKariukeHoshoTelNo() {
        return txtKariukeHoshoTelNo;
    }

    @JsonProperty("txtKariukeHoshoTelNo")
    public void setTxtKariukeHoshoTelNo(TextBox txtKariukeHoshoTelNo) {
        this.txtKariukeHoshoTelNo=txtKariukeHoshoTelNo;
    }

}
