package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * SearchPanel のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class SearchPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKensakuTaishoNendo")
    private TextBoxDate txtKensakuTaishoNendo;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("txtKensakuHihokenshaNo")
    private TextBox txtKensakuHihokenshaNo;
    @JsonProperty("txtKensakuShikyuSeiriNo")
    private TextBox txtKensakuShikyuSeiriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKensakuTaishoNendo
     * @return txtKensakuTaishoNendo
     */
    @JsonProperty("txtKensakuTaishoNendo")
    public TextBoxDate getTxtKensakuTaishoNendo() {
        return txtKensakuTaishoNendo;
    }

    /*
     * settxtKensakuTaishoNendo
     * @param txtKensakuTaishoNendo txtKensakuTaishoNendo
     */
    @JsonProperty("txtKensakuTaishoNendo")
    public void setTxtKensakuTaishoNendo(TextBoxDate txtKensakuTaishoNendo) {
        this.txtKensakuTaishoNendo = txtKensakuTaishoNendo;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * gettxtKensakuHihokenshaNo
     * @return txtKensakuHihokenshaNo
     */
    @JsonProperty("txtKensakuHihokenshaNo")
    public TextBox getTxtKensakuHihokenshaNo() {
        return txtKensakuHihokenshaNo;
    }

    /*
     * settxtKensakuHihokenshaNo
     * @param txtKensakuHihokenshaNo txtKensakuHihokenshaNo
     */
    @JsonProperty("txtKensakuHihokenshaNo")
    public void setTxtKensakuHihokenshaNo(TextBox txtKensakuHihokenshaNo) {
        this.txtKensakuHihokenshaNo = txtKensakuHihokenshaNo;
    }

    /*
     * gettxtKensakuShikyuSeiriNo
     * @return txtKensakuShikyuSeiriNo
     */
    @JsonProperty("txtKensakuShikyuSeiriNo")
    public TextBox getTxtKensakuShikyuSeiriNo() {
        return txtKensakuShikyuSeiriNo;
    }

    /*
     * settxtKensakuShikyuSeiriNo
     * @param txtKensakuShikyuSeiriNo txtKensakuShikyuSeiriNo
     */
    @JsonProperty("txtKensakuShikyuSeiriNo")
    public void setTxtKensakuShikyuSeiriNo(TextBox txtKensakuShikyuSeiriNo) {
        this.txtKensakuShikyuSeiriNo = txtKensakuShikyuSeiriNo;
    }

    // </editor-fold>
}
