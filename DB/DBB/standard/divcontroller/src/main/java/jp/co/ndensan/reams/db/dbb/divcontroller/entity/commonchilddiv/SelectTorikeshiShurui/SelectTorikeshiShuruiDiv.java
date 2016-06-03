package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.SelectTorikeshiShurui;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SelectTorikeshiShurui のクラスファイル 
 * 
 * @author 自動生成
 */
public class SelectTorikeshiShuruiDiv extends Panel implements ISelectTorikeshiShuruiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTorikeshiShurui")
    private DataGrid<dgTorikeshiShurui_Row> dgTorikeshiShurui;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTorikeshiShurui
     * @return dgTorikeshiShurui
     */
    @JsonProperty("dgTorikeshiShurui")
    public DataGrid<dgTorikeshiShurui_Row> getDgTorikeshiShurui() {
        return dgTorikeshiShurui;
    }

    /*
     * setdgTorikeshiShurui
     * @param dgTorikeshiShurui dgTorikeshiShurui
     */
    @JsonProperty("dgTorikeshiShurui")
    public void setDgTorikeshiShurui(DataGrid<dgTorikeshiShurui_Row> dgTorikeshiShurui) {
        this.dgTorikeshiShurui = dgTorikeshiShurui;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
