package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYearMonth;

/**
 * SaishinShoriNengetsuNyuryoku のクラスファイル
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class SaishinShoriNengetsuNyuryokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriNengetsu")
    private TextBoxFlexibleYearMonth txtShoriNengetsu;
    @JsonProperty("ddlShoriJokyo")
    private DropDownList ddlShoriJokyo;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriNengetsu
     * @return txtShoriNengetsu
     */
    @JsonProperty("txtShoriNengetsu")
    public TextBoxFlexibleYearMonth getTxtShoriNengetsu() {
        return txtShoriNengetsu;
    }

    /*
     * settxtShoriNengetsu
     * @param txtShoriNengetsu txtShoriNengetsu
     */
    @JsonProperty("txtShoriNengetsu")
    public void setTxtShoriNengetsu(TextBoxFlexibleYearMonth txtShoriNengetsu) {
        this.txtShoriNengetsu = txtShoriNengetsu;
    }

    /*
     * getddlShoriJokyo
     * @return ddlShoriJokyo
     */
    @JsonProperty("ddlShoriJokyo")
    public DropDownList getDdlShoriJokyo() {
        return ddlShoriJokyo;
    }

    /*
     * setddlShoriJokyo
     * @param ddlShoriJokyo ddlShoriJokyo
     */
    @JsonProperty("ddlShoriJokyo")
    public void setDdlShoriJokyo(DropDownList ddlShoriJokyo) {
        this.ddlShoriJokyo = ddlShoriJokyo;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    // </editor-fold>
}
