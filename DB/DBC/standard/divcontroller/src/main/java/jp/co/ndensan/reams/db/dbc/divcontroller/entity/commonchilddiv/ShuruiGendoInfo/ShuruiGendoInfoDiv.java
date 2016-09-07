package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShuruiGendoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShuruiGendoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShuruiGendoInfoDiv extends Panel implements IShuruiGendoInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgGendoInfo")
    private DataGrid<dgGendoInfo_Row> dgGendoInfo;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgGendoInfo
     * @return dgGendoInfo
     */
    @JsonProperty("dgGendoInfo")
    public DataGrid<dgGendoInfo_Row> getDgGendoInfo() {
        return dgGendoInfo;
    }

    /*
     * setdgGendoInfo
     * @param dgGendoInfo dgGendoInfo
     */
    @JsonProperty("dgGendoInfo")
    public void setDgGendoInfo(DataGrid<dgGendoInfo_Row> dgGendoInfo) {
        this.dgGendoInfo = dgGendoInfo;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
