package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SougouZigyouTaishouItiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class SougouZigyouTaishouItiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgKihonInfo")
    private DataGrid<dgKihonInfo_Row> dgKihonInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgKihonInfo
     * @return dgKihonInfo
     */
    @JsonProperty("dgKihonInfo")
    public DataGrid<dgKihonInfo_Row> getDgKihonInfo() {
        return dgKihonInfo;
    }

    /*
     * setdgKihonInfo
     * @param dgKihonInfo dgKihonInfo
     */
    @JsonProperty("dgKihonInfo")
    public void setDgKihonInfo(DataGrid<dgKihonInfo_Row> dgKihonInfo) {
        this.dgKihonInfo = dgKihonInfo;
    }

    // </editor-fold>
}
