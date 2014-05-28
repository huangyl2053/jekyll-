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
 * KozaInfoMock のクラスファイル 
 * 
 * @author 自動生成
 */
public class KozaInfoMockDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKinyuKikanCode")
    private TextBoxCode txtKinyuKikanCode;
    @JsonProperty("txtKinyuKikanName")
    private TextBox txtKinyuKikanName;
    @JsonProperty("txtKinyuBranchCode")
    private TextBoxCode txtKinyuBranchCode;
    @JsonProperty("txtKinyuBranchName")
    private TextBox txtKinyuBranchName;
    @JsonProperty("radKozaType")
    private RadioButton radKozaType;
    @JsonProperty("txtKozaNo")
    private TextBoxCode txtKozaNo;
    @JsonProperty("txtKozaMeigininKanaName")
    private TextBox txtKozaMeigininKanaName;
    @JsonProperty("txtKozaMeigininName")
    private TextBox txtKozaMeigininName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKinyuKikanCode")
    public TextBoxCode getTxtKinyuKikanCode() {
        return txtKinyuKikanCode;
    }

    @JsonProperty("txtKinyuKikanCode")
    public void setTxtKinyuKikanCode(TextBoxCode txtKinyuKikanCode) {
        this.txtKinyuKikanCode=txtKinyuKikanCode;
    }

    @JsonProperty("txtKinyuKikanName")
    public TextBox getTxtKinyuKikanName() {
        return txtKinyuKikanName;
    }

    @JsonProperty("txtKinyuKikanName")
    public void setTxtKinyuKikanName(TextBox txtKinyuKikanName) {
        this.txtKinyuKikanName=txtKinyuKikanName;
    }

    @JsonProperty("txtKinyuBranchCode")
    public TextBoxCode getTxtKinyuBranchCode() {
        return txtKinyuBranchCode;
    }

    @JsonProperty("txtKinyuBranchCode")
    public void setTxtKinyuBranchCode(TextBoxCode txtKinyuBranchCode) {
        this.txtKinyuBranchCode=txtKinyuBranchCode;
    }

    @JsonProperty("txtKinyuBranchName")
    public TextBox getTxtKinyuBranchName() {
        return txtKinyuBranchName;
    }

    @JsonProperty("txtKinyuBranchName")
    public void setTxtKinyuBranchName(TextBox txtKinyuBranchName) {
        this.txtKinyuBranchName=txtKinyuBranchName;
    }

    @JsonProperty("radKozaType")
    public RadioButton getRadKozaType() {
        return radKozaType;
    }

    @JsonProperty("radKozaType")
    public void setRadKozaType(RadioButton radKozaType) {
        this.radKozaType=radKozaType;
    }

    @JsonProperty("txtKozaNo")
    public TextBoxCode getTxtKozaNo() {
        return txtKozaNo;
    }

    @JsonProperty("txtKozaNo")
    public void setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.txtKozaNo=txtKozaNo;
    }

    @JsonProperty("txtKozaMeigininKanaName")
    public TextBox getTxtKozaMeigininKanaName() {
        return txtKozaMeigininKanaName;
    }

    @JsonProperty("txtKozaMeigininKanaName")
    public void setTxtKozaMeigininKanaName(TextBox txtKozaMeigininKanaName) {
        this.txtKozaMeigininKanaName=txtKozaMeigininKanaName;
    }

    @JsonProperty("txtKozaMeigininName")
    public TextBox getTxtKozaMeigininName() {
        return txtKozaMeigininName;
    }

    @JsonProperty("txtKozaMeigininName")
    public void setTxtKozaMeigininName(TextBox txtKozaMeigininName) {
        this.txtKozaMeigininName=txtKozaMeigininName;
    }

}
