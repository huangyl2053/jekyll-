package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiContentsDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiResetInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuShinseiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuShinseiContents")
    private JutakuKaishuShinseiContentsDiv JutakuKaishuShinseiContents;
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    private JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo;
    @JsonProperty("btnAddShinseiContents")
    private Button btnAddShinseiContents;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuKaishuShinseiContents")
    public JutakuKaishuShinseiContentsDiv getJutakuKaishuShinseiContents() {
        return JutakuKaishuShinseiContents;
    }

    @JsonProperty("JutakuKaishuShinseiContents")
    public void setJutakuKaishuShinseiContents(JutakuKaishuShinseiContentsDiv JutakuKaishuShinseiContents) {
        this.JutakuKaishuShinseiContents=JutakuKaishuShinseiContents;
    }

    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public JutakuKaishuShinseiResetInfoDiv getJutakuKaishuShinseiResetInfo() {
        return JutakuKaishuShinseiResetInfo;
    }

    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public void setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo) {
        this.JutakuKaishuShinseiResetInfo=JutakuKaishuShinseiResetInfo;
    }

    @JsonProperty("btnAddShinseiContents")
    public Button getBtnAddShinseiContents() {
        return btnAddShinseiContents;
    }

    @JsonProperty("btnAddShinseiContents")
    public void setBtnAddShinseiContents(Button btnAddShinseiContents) {
        this.btnAddShinseiContents=btnAddShinseiContents;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

}
