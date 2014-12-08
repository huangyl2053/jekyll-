package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * KashitsukekinKariukenin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinKariukeninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKariukeninName")
    private TextBox txtKariukeninName;
    @JsonProperty("txtKariukeninKana")
    private TextBoxKana txtKariukeninKana;
    @JsonProperty("txtKariukeninYubinNo")
    private TextBoxYubinNo txtKariukeninYubinNo;
    @JsonProperty("txtKariukeninTelNo")
    private TextBox txtKariukeninTelNo;
    @JsonProperty("txtKariukeninJusho")
    private TextBox txtKariukeninJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKariukeninName")
    public TextBox getTxtKariukeninName() {
        return txtKariukeninName;
    }

    @JsonProperty("txtKariukeninName")
    public void setTxtKariukeninName(TextBox txtKariukeninName) {
        this.txtKariukeninName=txtKariukeninName;
    }

    @JsonProperty("txtKariukeninKana")
    public TextBoxKana getTxtKariukeninKana() {
        return txtKariukeninKana;
    }

    @JsonProperty("txtKariukeninKana")
    public void setTxtKariukeninKana(TextBoxKana txtKariukeninKana) {
        this.txtKariukeninKana=txtKariukeninKana;
    }

    @JsonProperty("txtKariukeninYubinNo")
    public TextBoxYubinNo getTxtKariukeninYubinNo() {
        return txtKariukeninYubinNo;
    }

    @JsonProperty("txtKariukeninYubinNo")
    public void setTxtKariukeninYubinNo(TextBoxYubinNo txtKariukeninYubinNo) {
        this.txtKariukeninYubinNo=txtKariukeninYubinNo;
    }

    @JsonProperty("txtKariukeninTelNo")
    public TextBox getTxtKariukeninTelNo() {
        return txtKariukeninTelNo;
    }

    @JsonProperty("txtKariukeninTelNo")
    public void setTxtKariukeninTelNo(TextBox txtKariukeninTelNo) {
        this.txtKariukeninTelNo=txtKariukeninTelNo;
    }

    @JsonProperty("txtKariukeninJusho")
    public TextBox getTxtKariukeninJusho() {
        return txtKariukeninJusho;
    }

    @JsonProperty("txtKariukeninJusho")
    public void setTxtKariukeninJusho(TextBox txtKariukeninJusho) {
        this.txtKariukeninJusho=txtKariukeninJusho;
    }

}
