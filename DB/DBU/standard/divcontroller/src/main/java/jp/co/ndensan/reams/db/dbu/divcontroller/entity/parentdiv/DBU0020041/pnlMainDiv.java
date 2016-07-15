package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * pnlMain のクラスファイル
 *
 * @reamsid_L DBU-1100-040 yebangqiang
 */
public class pnlMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbdHokokuNengetsu")
    private TextBoxDate tbdHokokuNengetsu;
    @JsonProperty("tbdShukeiNengetsu")
    private TextBoxDate tbdShukeiNengetsu;
    @JsonProperty("pnlYosikiHosei")
    private TextBox pnlYosikiHosei;
    @JsonProperty("tbHokensyaName")
    private TextBox tbHokensyaName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbdHokokuNengetsu
     * @return tbdHokokuNengetsu
     */
    @JsonProperty("tbdHokokuNengetsu")
    public TextBoxDate getTbdHokokuNengetsu() {
        return tbdHokokuNengetsu;
    }

    /*
     * settbdHokokuNengetsu
     * @param tbdHokokuNengetsu tbdHokokuNengetsu
     */
    @JsonProperty("tbdHokokuNengetsu")
    public void setTbdHokokuNengetsu(TextBoxDate tbdHokokuNengetsu) {
        this.tbdHokokuNengetsu = tbdHokokuNengetsu;
    }

    /*
     * gettbdShukeiNengetsu
     * @return tbdShukeiNengetsu
     */
    @JsonProperty("tbdShukeiNengetsu")
    public TextBoxDate getTbdShukeiNengetsu() {
        return tbdShukeiNengetsu;
    }

    /*
     * settbdShukeiNengetsu
     * @param tbdShukeiNengetsu tbdShukeiNengetsu
     */
    @JsonProperty("tbdShukeiNengetsu")
    public void setTbdShukeiNengetsu(TextBoxDate tbdShukeiNengetsu) {
        this.tbdShukeiNengetsu = tbdShukeiNengetsu;
    }

    /*
     * getpnlYosikiHosei
     * @return pnlYosikiHosei
     */
    @JsonProperty("pnlYosikiHosei")
    public TextBox getPnlYosikiHosei() {
        return pnlYosikiHosei;
    }

    /*
     * setpnlYosikiHosei
     * @param pnlYosikiHosei pnlYosikiHosei
     */
    @JsonProperty("pnlYosikiHosei")
    public void setPnlYosikiHosei(TextBox pnlYosikiHosei) {
        this.pnlYosikiHosei = pnlYosikiHosei;
    }

    /*
     * gettbHokensyaName
     * @return tbHokensyaName
     */
    @JsonProperty("tbHokensyaName")
    public TextBox getTbHokensyaName() {
        return tbHokensyaName;
    }

    /*
     * settbHokensyaName
     * @param tbHokensyaName tbHokensyaName
     */
    @JsonProperty("tbHokensyaName")
    public void setTbHokensyaName(TextBox tbHokensyaName) {
        this.tbHokensyaName = tbHokensyaName;
    }

    // </editor-fold>
}
