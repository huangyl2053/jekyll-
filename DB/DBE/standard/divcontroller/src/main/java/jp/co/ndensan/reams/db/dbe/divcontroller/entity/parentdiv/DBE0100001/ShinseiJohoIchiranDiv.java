package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShinseiJohoIchiran のクラスファイル
 *
 * @reamsid_L DBE-1370-010 sunhaidi
 */
public class ShinseiJohoIchiranDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinseiJoho")
    private DataGrid<dgShinseiJoho_Row> dgShinseiJoho;
    @JsonProperty("btnModoru")
    private Button btnModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShinseiJoho
     * @return dgShinseiJoho
     */
    @JsonProperty("dgShinseiJoho")
    public DataGrid<dgShinseiJoho_Row> getDgShinseiJoho() {
        return dgShinseiJoho;
    }

    /*
     * setdgShinseiJoho
     * @param dgShinseiJoho dgShinseiJoho
     */
    @JsonProperty("dgShinseiJoho")
    public void setDgShinseiJoho(DataGrid<dgShinseiJoho_Row> dgShinseiJoho) {
        this.dgShinseiJoho = dgShinseiJoho;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    // </editor-fold>
}
