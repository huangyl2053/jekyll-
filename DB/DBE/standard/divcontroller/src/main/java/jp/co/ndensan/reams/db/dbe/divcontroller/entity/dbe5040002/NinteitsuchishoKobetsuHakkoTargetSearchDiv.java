package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002.HihokenshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002.SearchButtonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002.YokaigoNinteiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteitsuchishoKobetsuHakkoTargetSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteitsuchishoKobetsuHakkoTargetSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHokensha")
    private Label lblHokensha;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("Hihokensha")
    private HihokenshaDiv Hihokensha;
    @JsonProperty("YokaigoNintei")
    private YokaigoNinteiDiv YokaigoNintei;
    @JsonProperty("SearchButtons")
    private SearchButtonsDiv SearchButtons;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHokensha")
    public Label getLblHokensha() {
        return lblHokensha;
    }

    @JsonProperty("lblHokensha")
    public void setLblHokensha(Label lblHokensha) {
        this.lblHokensha=lblHokensha;
    }

    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("Hihokensha")
    public HihokenshaDiv getHihokensha() {
        return Hihokensha;
    }

    @JsonProperty("Hihokensha")
    public void setHihokensha(HihokenshaDiv Hihokensha) {
        this.Hihokensha=Hihokensha;
    }

    @JsonProperty("YokaigoNintei")
    public YokaigoNinteiDiv getYokaigoNintei() {
        return YokaigoNintei;
    }

    @JsonProperty("YokaigoNintei")
    public void setYokaigoNintei(YokaigoNinteiDiv YokaigoNintei) {
        this.YokaigoNintei=YokaigoNintei;
    }

    @JsonProperty("SearchButtons")
    public SearchButtonsDiv getSearchButtons() {
        return SearchButtons;
    }

    @JsonProperty("SearchButtons")
    public void setSearchButtons(SearchButtonsDiv SearchButtons) {
        this.SearchButtons=SearchButtons;
    }

}
