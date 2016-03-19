package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    private JutakuKaishuShinseiHihokenshaPanelDiv JutakuKaishuShinseiHihokenshaPanel;
    @JsonProperty("JutakuKaishuShinseiList")
    private JutakuKaishuShinseiListDiv JutakuKaishuShinseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJutakuKaishuShinseiHihokenshaPanel
     * @return JutakuKaishuShinseiHihokenshaPanel
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    public JutakuKaishuShinseiHihokenshaPanelDiv getJutakuKaishuShinseiHihokenshaPanel() {
        return JutakuKaishuShinseiHihokenshaPanel;
    }

    /*
     * setJutakuKaishuShinseiHihokenshaPanel
     * @param JutakuKaishuShinseiHihokenshaPanel JutakuKaishuShinseiHihokenshaPanel
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    public void setJutakuKaishuShinseiHihokenshaPanel(JutakuKaishuShinseiHihokenshaPanelDiv JutakuKaishuShinseiHihokenshaPanel) {
        this.JutakuKaishuShinseiHihokenshaPanel = JutakuKaishuShinseiHihokenshaPanel;
    }

    /*
     * getJutakuKaishuShinseiList
     * @return JutakuKaishuShinseiList
     */
    @JsonProperty("JutakuKaishuShinseiList")
    public JutakuKaishuShinseiListDiv getJutakuKaishuShinseiList() {
        return JutakuKaishuShinseiList;
    }

    /*
     * setJutakuKaishuShinseiList
     * @param JutakuKaishuShinseiList JutakuKaishuShinseiList
     */
    @JsonProperty("JutakuKaishuShinseiList")
    public void setJutakuKaishuShinseiList(JutakuKaishuShinseiListDiv JutakuKaishuShinseiList) {
        this.JutakuKaishuShinseiList = JutakuKaishuShinseiList;
    }

    // </editor-fold>
}
