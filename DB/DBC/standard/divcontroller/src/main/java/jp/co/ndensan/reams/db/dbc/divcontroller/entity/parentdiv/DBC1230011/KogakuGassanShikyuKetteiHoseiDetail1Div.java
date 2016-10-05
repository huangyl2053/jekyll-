package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KogakuGassanShikyuKetteiHoseiDetail1 のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiDetail1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("txtJikoFutanSogaku")
    private TextBoxNum txtJikoFutanSogaku;
    @JsonProperty("radShikyuKubunCode")
    private RadioButton radShikyuKubunCode;
    @JsonProperty("txtShikyugaku")
    private TextBoxNum txtShikyugaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * gettxtJikoFutanSogaku
     * @return txtJikoFutanSogaku
     */
    @JsonProperty("txtJikoFutanSogaku")
    public TextBoxNum getTxtJikoFutanSogaku() {
        return txtJikoFutanSogaku;
    }

    /*
     * settxtJikoFutanSogaku
     * @param txtJikoFutanSogaku txtJikoFutanSogaku
     */
    @JsonProperty("txtJikoFutanSogaku")
    public void setTxtJikoFutanSogaku(TextBoxNum txtJikoFutanSogaku) {
        this.txtJikoFutanSogaku = txtJikoFutanSogaku;
    }

    /*
     * getradShikyuKubunCode
     * @return radShikyuKubunCode
     */
    @JsonProperty("radShikyuKubunCode")
    public RadioButton getRadShikyuKubunCode() {
        return radShikyuKubunCode;
    }

    /*
     * setradShikyuKubunCode
     * @param radShikyuKubunCode radShikyuKubunCode
     */
    @JsonProperty("radShikyuKubunCode")
    public void setRadShikyuKubunCode(RadioButton radShikyuKubunCode) {
        this.radShikyuKubunCode = radShikyuKubunCode;
    }

    /*
     * gettxtShikyugaku
     * @return txtShikyugaku
     */
    @JsonProperty("txtShikyugaku")
    public TextBoxNum getTxtShikyugaku() {
        return txtShikyugaku;
    }

    /*
     * settxtShikyugaku
     * @param txtShikyugaku txtShikyugaku
     */
    @JsonProperty("txtShikyugaku")
    public void setTxtShikyugaku(TextBoxNum txtShikyugaku) {
        this.txtShikyugaku = txtShikyugaku;
    }

    // </editor-fold>
}
