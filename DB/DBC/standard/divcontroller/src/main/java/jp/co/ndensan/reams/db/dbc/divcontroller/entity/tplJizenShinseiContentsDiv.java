package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiReasonForTabDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuJizenShinseiDetail_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplJizenShinseiContents のクラスファイル
 *
 * @author 自動生成
 */
public class tplJizenShinseiContentsDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtJutakuOwner")
    private TextBox txtJutakuOwner;
    @JsonProperty("txtRelationWithHihokensha")
    private TextBox txtRelationWithHihokensha;
    @JsonProperty("dgJutakuKaishuJizenShinseiDetail")
    private DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> dgJutakuKaishuJizenShinseiDetail;
    @JsonProperty("JutakuKaishuJizenShinseisha")
    private ShinseishaInfoDiv JutakuKaishuJizenShinseisha;
    @JsonProperty("JutakuKaishuJizenShinseiReasonForTab")
    private JutakuKaishuJizenShinseiReasonForTabDiv JutakuKaishuJizenShinseiReasonForTab;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner = txtJutakuOwner;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha = txtRelationWithHihokensha;
    }

    @JsonProperty("dgJutakuKaishuJizenShinseiDetail")
    public DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> getDgJutakuKaishuJizenShinseiDetail() {
        return dgJutakuKaishuJizenShinseiDetail;
    }

    @JsonProperty("dgJutakuKaishuJizenShinseiDetail")
    public void setDgJutakuKaishuJizenShinseiDetail(DataGrid<dgJutakuKaishuJizenShinseiDetail_Row> dgJutakuKaishuJizenShinseiDetail) {
        this.dgJutakuKaishuJizenShinseiDetail = dgJutakuKaishuJizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuJizenShinseisha")
    public ShinseishaInfoDiv getJutakuKaishuJizenShinseisha() {
        return JutakuKaishuJizenShinseisha;
    }

    @JsonProperty("JutakuKaishuJizenShinseiReasonForTab")
    public JutakuKaishuJizenShinseiReasonForTabDiv getJutakuKaishuJizenShinseiReasonForTab() {
        return JutakuKaishuJizenShinseiReasonForTab;
    }

    @JsonProperty("JutakuKaishuJizenShinseiReasonForTab")
    public void setJutakuKaishuJizenShinseiReasonForTab(JutakuKaishuJizenShinseiReasonForTabDiv JutakuKaishuJizenShinseiReasonForTab) {
        this.JutakuKaishuJizenShinseiReasonForTab = JutakuKaishuJizenShinseiReasonForTab;
    }

}
