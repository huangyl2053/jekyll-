package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaResetInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaResultDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaShinseiContentsDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuShinseiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuShinsaShinseiContents")
    private JutakuKaishuShinsaShinseiContentsDiv JutakuKaishuShinsaShinseiContents;
    @JsonProperty("JutakuKaishuShinsaResetInfo")
    private JutakuKaishuShinsaResetInfoDiv JutakuKaishuShinsaResetInfo;
    @JsonProperty("JutakuKaishuShinsaResult")
    private JutakuKaishuShinsaResultDiv JutakuKaishuShinsaResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuKaishuShinsaShinseiContents")
    public JutakuKaishuShinsaShinseiContentsDiv getJutakuKaishuShinsaShinseiContents() {
        return JutakuKaishuShinsaShinseiContents;
    }

    @JsonProperty("JutakuKaishuShinsaShinseiContents")
    public void setJutakuKaishuShinsaShinseiContents(JutakuKaishuShinsaShinseiContentsDiv JutakuKaishuShinsaShinseiContents) {
        this.JutakuKaishuShinsaShinseiContents=JutakuKaishuShinsaShinseiContents;
    }

    @JsonProperty("JutakuKaishuShinsaResetInfo")
    public JutakuKaishuShinsaResetInfoDiv getJutakuKaishuShinsaResetInfo() {
        return JutakuKaishuShinsaResetInfo;
    }

    @JsonProperty("JutakuKaishuShinsaResetInfo")
    public void setJutakuKaishuShinsaResetInfo(JutakuKaishuShinsaResetInfoDiv JutakuKaishuShinsaResetInfo) {
        this.JutakuKaishuShinsaResetInfo=JutakuKaishuShinsaResetInfo;
    }

    @JsonProperty("JutakuKaishuShinsaResult")
    public JutakuKaishuShinsaResultDiv getJutakuKaishuShinsaResult() {
        return JutakuKaishuShinsaResult;
    }

    @JsonProperty("JutakuKaishuShinsaResult")
    public void setJutakuKaishuShinsaResult(JutakuKaishuShinsaResultDiv JutakuKaishuShinsaResult) {
        this.JutakuKaishuShinsaResult=JutakuKaishuShinsaResult;
    }

}
