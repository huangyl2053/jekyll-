package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.CompositeControl;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * defaultLayout のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkijikoCom extends CompositeControl {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChosaItem")
    private Label lblChosaItem;
    @JsonProperty("ddlChosaItem")
    private DropDownList ddlChosaItem;
    @JsonProperty("txtTokkijikoContent")
    private TextBoxMultiLine txtTokkijikoContent;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblChosaItem")
    public Label getLblChosaItem() {
        return lblChosaItem;
    }

    @JsonProperty("lblChosaItem")
    public void setLblChosaItem(Label lblChosaItem) {
        this.lblChosaItem=lblChosaItem;
    }

    @JsonProperty("ddlChosaItem")
    public DropDownList getDdlChosaItem() {
        return ddlChosaItem;
    }

    @JsonProperty("ddlChosaItem")
    public void setDdlChosaItem(DropDownList ddlChosaItem) {
        this.ddlChosaItem=ddlChosaItem;
    }

    @JsonProperty("txtTokkijikoContent")
    public TextBoxMultiLine getTxtTokkijikoContent() {
        return txtTokkijikoContent;
    }

    @JsonProperty("txtTokkijikoContent")
    public void setTxtTokkijikoContent(TextBoxMultiLine txtTokkijikoContent) {
        this.txtTokkijikoContent=txtTokkijikoContent;
    }

}
