package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuJoken1 のクラスファイル
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class ChushutsuJoken1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoYM")
    private RadioButton radTaishoYM;
    @JsonProperty("txtTaishoYmRange")
    private TextBoxDateRange txtTaishoYmRange;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("chkNinteiKekka")
    private CheckBoxList chkNinteiKekka;
    @JsonProperty("ccdJigyoshaNo")
    private ShisetsuJohoCommonChildDivDiv ccdJigyoshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoYM
     * @return radTaishoYM
     */
    @JsonProperty("radTaishoYM")
    public RadioButton getRadTaishoYM() {
        return radTaishoYM;
    }

    /*
     * setradTaishoYM
     * @param radTaishoYM radTaishoYM
     */
    @JsonProperty("radTaishoYM")
    public void setRadTaishoYM(RadioButton radTaishoYM) {
        this.radTaishoYM = radTaishoYM;
    }

    /*
     * gettxtTaishoYmRange
     * @return txtTaishoYmRange
     */
    @JsonProperty("txtTaishoYmRange")
    public TextBoxDateRange getTxtTaishoYmRange() {
        return txtTaishoYmRange;
    }

    /*
     * settxtTaishoYmRange
     * @param txtTaishoYmRange txtTaishoYmRange
     */
    @JsonProperty("txtTaishoYmRange")
    public void setTxtTaishoYmRange(TextBoxDateRange txtTaishoYmRange) {
        this.txtTaishoYmRange = txtTaishoYmRange;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getchkNinteiKekka
     * @return chkNinteiKekka
     */
    @JsonProperty("chkNinteiKekka")
    public CheckBoxList getChkNinteiKekka() {
        return chkNinteiKekka;
    }

    /*
     * setchkNinteiKekka
     * @param chkNinteiKekka chkNinteiKekka
     */
    @JsonProperty("chkNinteiKekka")
    public void setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.chkNinteiKekka = chkNinteiKekka;
    }

    /*
     * getccdJigyoshaNo
     * @return ccdJigyoshaNo
     */
    @JsonProperty("ccdJigyoshaNo")
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaNo() {
        return ccdJigyoshaNo;
    }

    // </editor-fold>
}
