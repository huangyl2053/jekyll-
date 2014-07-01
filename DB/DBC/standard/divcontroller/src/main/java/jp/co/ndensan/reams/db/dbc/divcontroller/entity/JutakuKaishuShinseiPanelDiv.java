package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaShinseiContentsDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiResetInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

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
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    private JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo;
    @JsonProperty("btnDummy")
    private Button btnDummy;

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

    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public JutakuKaishuShinseiResetInfoDiv getJutakuKaishuShinseiResetInfo() {
        return JutakuKaishuShinseiResetInfo;
    }

    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public void setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo) {
        this.JutakuKaishuShinseiResetInfo=JutakuKaishuShinseiResetInfo;
    }

    @JsonProperty("btnDummy")
    public Button getBtnDummy() {
        return btnDummy;
    }

    @JsonProperty("btnDummy")
    public void setBtnDummy(Button btnDummy) {
        this.btnDummy=btnDummy;
    }

}
