package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelRireki のクラスファイル 
 * @reamsid_L DBA-0220-010 dongyabin
 * @author 自動生成
 */
public class panelRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("datagridRireki")
    private DataGrid<datagridRireki_Row> datagridRireki;

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
     * getdatagridRireki
     * @return datagridRireki
     */
    @JsonProperty("datagridRireki")
    public DataGrid<datagridRireki_Row> getDatagridRireki() {
        return datagridRireki;
    }

    /*
     * setdatagridRireki
     * @param datagridRireki datagridRireki
     */
    @JsonProperty("datagridRireki")
    public void setDatagridRireki(DataGrid<datagridRireki_Row> datagridRireki) {
        this.datagridRireki = datagridRireki;
    }

    // </editor-fold>
}
