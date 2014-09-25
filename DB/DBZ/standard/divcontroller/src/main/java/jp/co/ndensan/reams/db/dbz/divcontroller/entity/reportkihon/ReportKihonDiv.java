package jp.co.ndensan.reams.db.dbz.divcontroller.entity.reportkihon;
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
 * ReportKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class ReportKihonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtListName")
    private TextBox txtListName;
    @JsonProperty("txtListCreationDate")
    private TextBoxDate txtListCreationDate;
    @JsonProperty("txtListCreationTime")
    private TextBoxTime txtListCreationTime;
    @JsonProperty("txtBatchName")
    private TextBox txtBatchName;
    @JsonProperty("txtBatchStartingDate")
    private TextBoxDate txtBatchStartingDate;
    @JsonProperty("txtBatchStartingTime")
    private TextBoxTime txtBatchStartingTime;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtListName")
    public TextBox getTxtListName() {
        return txtListName;
    }

    @JsonProperty("txtListName")
    public void setTxtListName(TextBox txtListName) {
        this.txtListName=txtListName;
    }

    @JsonProperty("txtListCreationDate")
    public TextBoxDate getTxtListCreationDate() {
        return txtListCreationDate;
    }

    @JsonProperty("txtListCreationDate")
    public void setTxtListCreationDate(TextBoxDate txtListCreationDate) {
        this.txtListCreationDate=txtListCreationDate;
    }

    @JsonProperty("txtListCreationTime")
    public TextBoxTime getTxtListCreationTime() {
        return txtListCreationTime;
    }

    @JsonProperty("txtListCreationTime")
    public void setTxtListCreationTime(TextBoxTime txtListCreationTime) {
        this.txtListCreationTime=txtListCreationTime;
    }

    @JsonProperty("txtBatchName")
    public TextBox getTxtBatchName() {
        return txtBatchName;
    }

    @JsonProperty("txtBatchName")
    public void setTxtBatchName(TextBox txtBatchName) {
        this.txtBatchName=txtBatchName;
    }

    @JsonProperty("txtBatchStartingDate")
    public TextBoxDate getTxtBatchStartingDate() {
        return txtBatchStartingDate;
    }

    @JsonProperty("txtBatchStartingDate")
    public void setTxtBatchStartingDate(TextBoxDate txtBatchStartingDate) {
        this.txtBatchStartingDate=txtBatchStartingDate;
    }

    @JsonProperty("txtBatchStartingTime")
    public TextBoxTime getTxtBatchStartingTime() {
        return txtBatchStartingTime;
    }

    @JsonProperty("txtBatchStartingTime")
    public void setTxtBatchStartingTime(TextBoxTime txtBatchStartingTime) {
        this.txtBatchStartingTime=txtBatchStartingTime;
    }

}
