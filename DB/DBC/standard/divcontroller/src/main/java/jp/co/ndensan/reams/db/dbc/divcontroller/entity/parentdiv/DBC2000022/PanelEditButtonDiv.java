package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelEditButton のクラスファイル
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class PanelEditButtonDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddBefore")
    private Button btnAddBefore;
    @JsonProperty("btnAddNext")
    private Button btnAddNext;
    @JsonProperty("btnEdit")
    private Button btnEdit;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddBefore
     * @return btnAddBefore
     */
    @JsonProperty("btnAddBefore")
    public Button getBtnAddBefore() {
        return btnAddBefore;
    }

    /*
     * setbtnAddBefore
     * @param btnAddBefore btnAddBefore
     */
    @JsonProperty("btnAddBefore")
    public void setBtnAddBefore(Button btnAddBefore) {
        this.btnAddBefore = btnAddBefore;
    }

    /*
     * getbtnAddNext
     * @return btnAddNext
     */
    @JsonProperty("btnAddNext")
    public Button getBtnAddNext() {
        return btnAddNext;
    }

    /*
     * setbtnAddNext
     * @param btnAddNext btnAddNext
     */
    @JsonProperty("btnAddNext")
    public void setBtnAddNext(Button btnAddNext) {
        this.btnAddNext = btnAddNext;
    }

    /*
     * getbtnEdit
     * @return btnEdit
     */
    @JsonProperty("btnEdit")
    public Button getBtnEdit() {
        return btnEdit;
    }

    /*
     * setbtnEdit
     * @param btnEdit btnEdit
     */
    @JsonProperty("btnEdit")
    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    // </editor-fold>
}
