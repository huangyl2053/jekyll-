package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;
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
 * ShowResultTwo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShowResultTwoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYMShowTwo")
    private TextBoxDate txtTeikyoYMShowTwo;
    @JsonProperty("txtSetaiShuyakuNo")
    private TextBoxCode txtSetaiShuyakuNo;
    @JsonProperty("hlJudgementResult")
    private HorizontalLine hlJudgementResult;
    @JsonProperty("txtHihoNoL")
    private TextBoxCode txtHihoNoL;
    @JsonProperty("txtHihoNameR")
    private TextBox txtHihoNameR;
    @JsonProperty("txtHihoNoR")
    private TextBoxCode txtHihoNoR;
    @JsonProperty("txtHihoNameL")
    private TextBox txtHihoNameL;
    @JsonProperty("JudgementResultL")
    private JudgementResultLDiv JudgementResultL;
    @JsonProperty("JudgementResultR")
    private JudgementResultRDiv JudgementResultR;
    @JsonProperty("btnReturnShowOne")
    private Button btnReturnShowOne;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTeikyoYMShowTwo")
    public TextBoxDate getTxtTeikyoYMShowTwo() {
        return txtTeikyoYMShowTwo;
    }

    @JsonProperty("txtTeikyoYMShowTwo")
    public void setTxtTeikyoYMShowTwo(TextBoxDate txtTeikyoYMShowTwo) {
        this.txtTeikyoYMShowTwo=txtTeikyoYMShowTwo;
    }

    @JsonProperty("txtSetaiShuyakuNo")
    public TextBoxCode getTxtSetaiShuyakuNo() {
        return txtSetaiShuyakuNo;
    }

    @JsonProperty("txtSetaiShuyakuNo")
    public void setTxtSetaiShuyakuNo(TextBoxCode txtSetaiShuyakuNo) {
        this.txtSetaiShuyakuNo=txtSetaiShuyakuNo;
    }

    @JsonProperty("hlJudgementResult")
    public HorizontalLine getHlJudgementResult() {
        return hlJudgementResult;
    }

    @JsonProperty("hlJudgementResult")
    public void setHlJudgementResult(HorizontalLine hlJudgementResult) {
        this.hlJudgementResult=hlJudgementResult;
    }

    @JsonProperty("txtHihoNoL")
    public TextBoxCode getTxtHihoNoL() {
        return txtHihoNoL;
    }

    @JsonProperty("txtHihoNoL")
    public void setTxtHihoNoL(TextBoxCode txtHihoNoL) {
        this.txtHihoNoL=txtHihoNoL;
    }

    @JsonProperty("txtHihoNameR")
    public TextBox getTxtHihoNameR() {
        return txtHihoNameR;
    }

    @JsonProperty("txtHihoNameR")
    public void setTxtHihoNameR(TextBox txtHihoNameR) {
        this.txtHihoNameR=txtHihoNameR;
    }

    @JsonProperty("txtHihoNoR")
    public TextBoxCode getTxtHihoNoR() {
        return txtHihoNoR;
    }

    @JsonProperty("txtHihoNoR")
    public void setTxtHihoNoR(TextBoxCode txtHihoNoR) {
        this.txtHihoNoR=txtHihoNoR;
    }

    @JsonProperty("txtHihoNameL")
    public TextBox getTxtHihoNameL() {
        return txtHihoNameL;
    }

    @JsonProperty("txtHihoNameL")
    public void setTxtHihoNameL(TextBox txtHihoNameL) {
        this.txtHihoNameL=txtHihoNameL;
    }

    @JsonProperty("JudgementResultL")
    public JudgementResultLDiv getJudgementResultL() {
        return JudgementResultL;
    }

    @JsonProperty("JudgementResultL")
    public void setJudgementResultL(JudgementResultLDiv JudgementResultL) {
        this.JudgementResultL=JudgementResultL;
    }

    @JsonProperty("JudgementResultR")
    public JudgementResultRDiv getJudgementResultR() {
        return JudgementResultR;
    }

    @JsonProperty("JudgementResultR")
    public void setJudgementResultR(JudgementResultRDiv JudgementResultR) {
        this.JudgementResultR=JudgementResultR;
    }

    @JsonProperty("btnReturnShowOne")
    public Button getBtnReturnShowOne() {
        return btnReturnShowOne;
    }

    @JsonProperty("btnReturnShowOne")
    public void setBtnReturnShowOne(Button btnReturnShowOne) {
        this.btnReturnShowOne=btnReturnShowOne;
    }

}
