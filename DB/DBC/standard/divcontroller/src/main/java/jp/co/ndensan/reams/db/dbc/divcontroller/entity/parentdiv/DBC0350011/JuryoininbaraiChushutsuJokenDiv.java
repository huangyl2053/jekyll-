package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0350011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * JuryoininbaraiChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-2110-010 lihang
 */
public class JuryoininbaraiChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeiyakuBangoFrom")
    private TextBoxCode txtKeiyakuBangoFrom;
    @JsonProperty("txtKeiyakuBangoTo")
    private TextBoxCode txtKeiyakuBangoTo;
    @JsonProperty("txtKeiyakuYMD")
    private TextBoxDateRange txtKeiyakuYMD;
    @JsonProperty("radKeiyakuShubetsu")
    private RadioButton radKeiyakuShubetsu;
    @JsonProperty("radKeiyakuKikanShuryoGyosha")
    private RadioButton radKeiyakuKikanShuryoGyosha;
    @JsonProperty("lin1")
    private HorizontalLine lin1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKeiyakuBangoFrom
     * @return txtKeiyakuBangoFrom
     */
    @JsonProperty("txtKeiyakuBangoFrom")
    public TextBoxCode getTxtKeiyakuBangoFrom() {
        return txtKeiyakuBangoFrom;
    }

    /*
     * settxtKeiyakuBangoFrom
     * @param txtKeiyakuBangoFrom txtKeiyakuBangoFrom
     */
    @JsonProperty("txtKeiyakuBangoFrom")
    public void setTxtKeiyakuBangoFrom(TextBoxCode txtKeiyakuBangoFrom) {
        this.txtKeiyakuBangoFrom = txtKeiyakuBangoFrom;
    }

    /*
     * gettxtKeiyakuBangoTo
     * @return txtKeiyakuBangoTo
     */
    @JsonProperty("txtKeiyakuBangoTo")
    public TextBoxCode getTxtKeiyakuBangoTo() {
        return txtKeiyakuBangoTo;
    }

    /*
     * settxtKeiyakuBangoTo
     * @param txtKeiyakuBangoTo txtKeiyakuBangoTo
     */
    @JsonProperty("txtKeiyakuBangoTo")
    public void setTxtKeiyakuBangoTo(TextBoxCode txtKeiyakuBangoTo) {
        this.txtKeiyakuBangoTo = txtKeiyakuBangoTo;
    }

    /*
     * gettxtKeiyakuYMD
     * @return txtKeiyakuYMD
     */
    @JsonProperty("txtKeiyakuYMD")
    public TextBoxDateRange getTxtKeiyakuYMD() {
        return txtKeiyakuYMD;
    }

    /*
     * settxtKeiyakuYMD
     * @param txtKeiyakuYMD txtKeiyakuYMD
     */
    @JsonProperty("txtKeiyakuYMD")
    public void setTxtKeiyakuYMD(TextBoxDateRange txtKeiyakuYMD) {
        this.txtKeiyakuYMD = txtKeiyakuYMD;
    }

    /*
     * getradKeiyakuShubetsu
     * @return radKeiyakuShubetsu
     */
    @JsonProperty("radKeiyakuShubetsu")
    public RadioButton getRadKeiyakuShubetsu() {
        return radKeiyakuShubetsu;
    }

    /*
     * setradKeiyakuShubetsu
     * @param radKeiyakuShubetsu radKeiyakuShubetsu
     */
    @JsonProperty("radKeiyakuShubetsu")
    public void setRadKeiyakuShubetsu(RadioButton radKeiyakuShubetsu) {
        this.radKeiyakuShubetsu = radKeiyakuShubetsu;
    }

    /*
     * getradKeiyakuKikanShuryoGyosha
     * @return radKeiyakuKikanShuryoGyosha
     */
    @JsonProperty("radKeiyakuKikanShuryoGyosha")
    public RadioButton getRadKeiyakuKikanShuryoGyosha() {
        return radKeiyakuKikanShuryoGyosha;
    }

    /*
     * setradKeiyakuKikanShuryoGyosha
     * @param radKeiyakuKikanShuryoGyosha radKeiyakuKikanShuryoGyosha
     */
    @JsonProperty("radKeiyakuKikanShuryoGyosha")
    public void setRadKeiyakuKikanShuryoGyosha(RadioButton radKeiyakuKikanShuryoGyosha) {
        this.radKeiyakuKikanShuryoGyosha = radKeiyakuKikanShuryoGyosha;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    // </editor-fold>
}
