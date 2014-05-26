package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.PublishButtonDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteitsuchishoKobetsuHakkoTargetList のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteitsuchishoKobetsuHakkoTargetListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHokenshaNo")
    private Label lblHokenshaNo;
    @JsonProperty("txtHokenshaNo")
    private TextBoxCode txtHokenshaNo;
    @JsonProperty("txtHokensaName")
    private TextBox txtHokensaName;
    @JsonProperty("dgSearchResult")
    private DataGrid<dgSearchResult_Row> dgSearchResult;
    @JsonProperty("PublishButton")
    private PublishButtonDiv PublishButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHokenshaNo")
    public Label getLblHokenshaNo() {
        return lblHokenshaNo;
    }

    @JsonProperty("lblHokenshaNo")
    public void setLblHokenshaNo(Label lblHokenshaNo) {
        this.lblHokenshaNo=lblHokenshaNo;
    }

    @JsonProperty("txtHokenshaNo")
    public TextBoxCode getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxCode txtHokenshaNo) {
        this.txtHokenshaNo=txtHokenshaNo;
    }

    @JsonProperty("txtHokensaName")
    public TextBox getTxtHokensaName() {
        return txtHokensaName;
    }

    @JsonProperty("txtHokensaName")
    public void setTxtHokensaName(TextBox txtHokensaName) {
        this.txtHokensaName=txtHokensaName;
    }

    @JsonProperty("dgSearchResult")
    public DataGrid<dgSearchResult_Row> getDgSearchResult() {
        return dgSearchResult;
    }

    @JsonProperty("dgSearchResult")
    public void setDgSearchResult(DataGrid<dgSearchResult_Row> dgSearchResult) {
        this.dgSearchResult=dgSearchResult;
    }

    @JsonProperty("PublishButton")
    public PublishButtonDiv getPublishButton() {
        return PublishButton;
    }

    @JsonProperty("PublishButton")
    public void setPublishButton(PublishButtonDiv PublishButton) {
        this.PublishButton=PublishButton;
    }

}
