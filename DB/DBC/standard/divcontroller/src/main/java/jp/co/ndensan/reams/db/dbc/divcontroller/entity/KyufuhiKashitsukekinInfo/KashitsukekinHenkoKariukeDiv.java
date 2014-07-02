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
 * KashitsukekinHenkoKariuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinHenkoKariukeDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHenkoKariukeninName")
    private TextBox txtHenkoKariukeninName;
    @JsonProperty("txtHenkoKariukeninKana")
    private TextBoxKana txtHenkoKariukeninKana;
    @JsonProperty("txtHenkoKariukeninYubinNo")
    private TextBoxYubinNo txtHenkoKariukeninYubinNo;
    @JsonProperty("txtHenkoKariukeninTelNo")
    private TextBox txtHenkoKariukeninTelNo;
    @JsonProperty("txtHenkoKariukeninJusho")
    private TextBox txtHenkoKariukeninJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHenkoKariukeninName")
    public TextBox getTxtHenkoKariukeninName() {
        return txtHenkoKariukeninName;
    }

    @JsonProperty("txtHenkoKariukeninName")
    public void setTxtHenkoKariukeninName(TextBox txtHenkoKariukeninName) {
        this.txtHenkoKariukeninName=txtHenkoKariukeninName;
    }

    @JsonProperty("txtHenkoKariukeninKana")
    public TextBoxKana getTxtHenkoKariukeninKana() {
        return txtHenkoKariukeninKana;
    }

    @JsonProperty("txtHenkoKariukeninKana")
    public void setTxtHenkoKariukeninKana(TextBoxKana txtHenkoKariukeninKana) {
        this.txtHenkoKariukeninKana=txtHenkoKariukeninKana;
    }

    @JsonProperty("txtHenkoKariukeninYubinNo")
    public TextBoxYubinNo getTxtHenkoKariukeninYubinNo() {
        return txtHenkoKariukeninYubinNo;
    }

    @JsonProperty("txtHenkoKariukeninYubinNo")
    public void setTxtHenkoKariukeninYubinNo(TextBoxYubinNo txtHenkoKariukeninYubinNo) {
        this.txtHenkoKariukeninYubinNo=txtHenkoKariukeninYubinNo;
    }

    @JsonProperty("txtHenkoKariukeninTelNo")
    public TextBox getTxtHenkoKariukeninTelNo() {
        return txtHenkoKariukeninTelNo;
    }

    @JsonProperty("txtHenkoKariukeninTelNo")
    public void setTxtHenkoKariukeninTelNo(TextBox txtHenkoKariukeninTelNo) {
        this.txtHenkoKariukeninTelNo=txtHenkoKariukeninTelNo;
    }

    @JsonProperty("txtHenkoKariukeninJusho")
    public TextBox getTxtHenkoKariukeninJusho() {
        return txtHenkoKariukeninJusho;
    }

    @JsonProperty("txtHenkoKariukeninJusho")
    public void setTxtHenkoKariukeninJusho(TextBox txtHenkoKariukeninJusho) {
        this.txtHenkoKariukeninJusho=txtHenkoKariukeninJusho;
    }

}
