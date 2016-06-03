package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmenshurui.GemmenShurui;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenShurui のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenShuruiDiv extends Panel implements IGemmenShuruiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgGemmenShurui")
    private DataGrid<dgGemmenShurui_Row> dgGemmenShurui;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgGemmenShurui
     * @return dgGemmenShurui
     */
    @JsonProperty("dgGemmenShurui")
    public DataGrid<dgGemmenShurui_Row> getDgGemmenShurui() {
        return dgGemmenShurui;
    }

    /*
     * setdgGemmenShurui
     * @param dgGemmenShurui dgGemmenShurui
     */
    @JsonProperty("dgGemmenShurui")
    public void setDgGemmenShurui(DataGrid<dgGemmenShurui_Row> dgGemmenShurui) {
        this.dgGemmenShurui = dgGemmenShurui;
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
