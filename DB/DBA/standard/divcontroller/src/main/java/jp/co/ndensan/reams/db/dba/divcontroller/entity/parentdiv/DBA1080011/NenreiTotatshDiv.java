package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenreiTotatsh のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenreiTotatshDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgNenreiTotatshusha")
    private DataGrid<dgNenreiTotatshusha_Row> dgNenreiTotatshusha;

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
     * getdgNenreiTotatshusha
     * @return dgNenreiTotatshusha
     */
    @JsonProperty("dgNenreiTotatshusha")
    public DataGrid<dgNenreiTotatshusha_Row> getDgNenreiTotatshusha() {
        return dgNenreiTotatshusha;
    }

    /*
     * setdgNenreiTotatshusha
     * @param dgNenreiTotatshusha dgNenreiTotatshusha
     */
    @JsonProperty("dgNenreiTotatshusha")
    public void setDgNenreiTotatshusha(DataGrid<dgNenreiTotatshusha_Row> dgNenreiTotatshusha) {
        this.dgNenreiTotatshusha = dgNenreiTotatshusha;
    }

    // </editor-fold>
}
