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
 * ShinkiPanel のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class ShinkiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinkiTaishoNendo")
    private TextBoxDate txtShinkiTaishoNendo;
    @JsonProperty("txtShinkiHihokenshaNo")
    private TextBox txtShinkiHihokenshaNo;
    @JsonProperty("txtShinkiShikyuSeiriNo")
    private TextBox txtShinkiShikyuSeiriNo;
    @JsonProperty("btnKetteiJohoAdd")
    private Button btnKetteiJohoAdd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinkiTaishoNendo
     * @return txtShinkiTaishoNendo
     */
    @JsonProperty("txtShinkiTaishoNendo")
    public TextBoxDate getTxtShinkiTaishoNendo() {
        return txtShinkiTaishoNendo;
    }

    /*
     * settxtShinkiTaishoNendo
     * @param txtShinkiTaishoNendo txtShinkiTaishoNendo
     */
    @JsonProperty("txtShinkiTaishoNendo")
    public void setTxtShinkiTaishoNendo(TextBoxDate txtShinkiTaishoNendo) {
        this.txtShinkiTaishoNendo = txtShinkiTaishoNendo;
    }

    /*
     * gettxtShinkiHihokenshaNo
     * @return txtShinkiHihokenshaNo
     */
    @JsonProperty("txtShinkiHihokenshaNo")
    public TextBox getTxtShinkiHihokenshaNo() {
        return txtShinkiHihokenshaNo;
    }

    /*
     * settxtShinkiHihokenshaNo
     * @param txtShinkiHihokenshaNo txtShinkiHihokenshaNo
     */
    @JsonProperty("txtShinkiHihokenshaNo")
    public void setTxtShinkiHihokenshaNo(TextBox txtShinkiHihokenshaNo) {
        this.txtShinkiHihokenshaNo = txtShinkiHihokenshaNo;
    }

    /*
     * gettxtShinkiShikyuSeiriNo
     * @return txtShinkiShikyuSeiriNo
     */
    @JsonProperty("txtShinkiShikyuSeiriNo")
    public TextBox getTxtShinkiShikyuSeiriNo() {
        return txtShinkiShikyuSeiriNo;
    }

    /*
     * settxtShinkiShikyuSeiriNo
     * @param txtShinkiShikyuSeiriNo txtShinkiShikyuSeiriNo
     */
    @JsonProperty("txtShinkiShikyuSeiriNo")
    public void setTxtShinkiShikyuSeiriNo(TextBox txtShinkiShikyuSeiriNo) {
        this.txtShinkiShikyuSeiriNo = txtShinkiShikyuSeiriNo;
    }

    /*
     * getbtnKetteiJohoAdd
     * @return btnKetteiJohoAdd
     */
    @JsonProperty("btnKetteiJohoAdd")
    public Button getBtnKetteiJohoAdd() {
        return btnKetteiJohoAdd;
    }

    /*
     * setbtnKetteiJohoAdd
     * @param btnKetteiJohoAdd btnKetteiJohoAdd
     */
    @JsonProperty("btnKetteiJohoAdd")
    public void setBtnKetteiJohoAdd(Button btnKetteiJohoAdd) {
        this.btnKetteiJohoAdd = btnKetteiJohoAdd;
    }

    // </editor-fold>
}
