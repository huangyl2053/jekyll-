package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KubunShikyuGendogakuIchiran のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendogakuIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShikyuGendogaku")
    private Button btnAddShikyuGendogaku;
    @JsonProperty("dgShikyuGendogaku")
    private DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddShikyuGendogaku
     * @return btnAddShikyuGendogaku
     */
    @JsonProperty("btnAddShikyuGendogaku")
    public Button getBtnAddShikyuGendogaku() {
        return btnAddShikyuGendogaku;
    }

    /*
     * setbtnAddShikyuGendogaku
     * @param btnAddShikyuGendogaku btnAddShikyuGendogaku
     */
    @JsonProperty("btnAddShikyuGendogaku")
    public void setBtnAddShikyuGendogaku(Button btnAddShikyuGendogaku) {
        this.btnAddShikyuGendogaku = btnAddShikyuGendogaku;
    }

    /*
     * getdgShikyuGendogaku
     * @return dgShikyuGendogaku
     */
    @JsonProperty("dgShikyuGendogaku")
    public DataGrid<dgShikyuGendogaku_Row> getDgShikyuGendogaku() {
        return dgShikyuGendogaku;
    }

    /*
     * setdgShikyuGendogaku
     * @param dgShikyuGendogaku dgShikyuGendogaku
     */
    @JsonProperty("dgShikyuGendogaku")
    public void setDgShikyuGendogaku(DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku) {
        this.dgShikyuGendogaku = dgShikyuGendogaku;
    }

    // </editor-fold>
}
