package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnl2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnl2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokokuNengetsu")
    private TextBoxDate txtHokokuNengetsu;
    @JsonProperty("txtShukeiNengetsu")
    private TextBoxDate txtShukeiNengetsu;
    @JsonProperty("pnlYosikiHosei")
    private TextBox pnlYosikiHosei;
    @JsonProperty("txtHokensyaName")
    private TextBox txtHokensyaName;
    @JsonProperty("pnl1")
    private pnl1Div pnl1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokokuNengetsu
     * @return txtHokokuNengetsu
     */
    @JsonProperty("txtHokokuNengetsu")
    public TextBoxDate getTxtHokokuNengetsu() {
        return txtHokokuNengetsu;
    }

    /*
     * settxtHokokuNengetsu
     * @param txtHokokuNengetsu txtHokokuNengetsu
     */
    @JsonProperty("txtHokokuNengetsu")
    public void setTxtHokokuNengetsu(TextBoxDate txtHokokuNengetsu) {
        this.txtHokokuNengetsu = txtHokokuNengetsu;
    }

    /*
     * gettxtShukeiNengetsu
     * @return txtShukeiNengetsu
     */
    @JsonProperty("txtShukeiNengetsu")
    public TextBoxDate getTxtShukeiNengetsu() {
        return txtShukeiNengetsu;
    }

    /*
     * settxtShukeiNengetsu
     * @param txtShukeiNengetsu txtShukeiNengetsu
     */
    @JsonProperty("txtShukeiNengetsu")
    public void setTxtShukeiNengetsu(TextBoxDate txtShukeiNengetsu) {
        this.txtShukeiNengetsu = txtShukeiNengetsu;
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
     * gettxtHokensyaName
     * @return txtHokensyaName
     */
    @JsonProperty("txtHokensyaName")
    public TextBox getTxtHokensyaName() {
        return txtHokensyaName;
    }

    /*
     * settxtHokensyaName
     * @param txtHokensyaName txtHokensyaName
     */
    @JsonProperty("txtHokensyaName")
    public void setTxtHokensyaName(TextBox txtHokensyaName) {
        this.txtHokensyaName = txtHokensyaName;
    }

    /*
     * getpnl1
     * @return pnl1
     */
    @JsonProperty("pnl1")
    public pnl1Div getPnl1() {
        return pnl1;
    }

    /*
     * setpnl1
     * @param pnl1 pnl1
     */
    @JsonProperty("pnl1")
    public void setPnl1(pnl1Div pnl1) {
        this.pnl1 = pnl1;
    }

    // </editor-fold>
}
