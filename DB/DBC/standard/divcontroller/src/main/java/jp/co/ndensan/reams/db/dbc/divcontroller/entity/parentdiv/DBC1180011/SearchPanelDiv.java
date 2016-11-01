package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * SearchPanel のクラスファイル
 *
 * @reamsid_L DBC-2030-010 huzongcheng
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
    private TextBoxDateRange txtKensakuTaishoNendo;
    @JsonProperty("chkRirekiHyoji")
    private CheckBoxList chkRirekiHyoji;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

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
    public TextBoxDateRange getTxtKensakuTaishoNendo() {
        return txtKensakuTaishoNendo;
    }

    /*
     * settxtKensakuTaishoNendo
     * @param txtKensakuTaishoNendo txtKensakuTaishoNendo
     */
    @JsonProperty("txtKensakuTaishoNendo")
    public void setTxtKensakuTaishoNendo(TextBoxDateRange txtKensakuTaishoNendo) {
        this.txtKensakuTaishoNendo = txtKensakuTaishoNendo;
    }

    /*
     * getchkRirekiHyoji
     * @return chkRirekiHyoji
     */
    @JsonProperty("chkRirekiHyoji")
    public CheckBoxList getChkRirekiHyoji() {
        return chkRirekiHyoji;
    }

    /*
     * setchkRirekiHyoji
     * @param chkRirekiHyoji chkRirekiHyoji
     */
    @JsonProperty("chkRirekiHyoji")
    public void setChkRirekiHyoji(CheckBoxList chkRirekiHyoji) {
        this.chkRirekiHyoji = chkRirekiHyoji;
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

    // </editor-fold>
}
