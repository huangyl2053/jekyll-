package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiIchiBesshiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiIchiBesshiHeaderDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
    @JsonProperty("txtYosikiHosei")
    private TextBox txtYosikiHosei;
    @JsonProperty("txtHokensyaName")
    private TextBox txtHokensyaName;

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
     * gettxtYosikiHosei
     * @return txtYosikiHosei
     */
    @JsonProperty("txtYosikiHosei")
    public TextBox getTxtYosikiHosei() {
        return txtYosikiHosei;
    }

    /*
     * settxtYosikiHosei
     * @param txtYosikiHosei txtYosikiHosei
     */
    @JsonProperty("txtYosikiHosei")
    public void setTxtYosikiHosei(TextBox txtYosikiHosei) {
        this.txtYosikiHosei = txtYosikiHosei;
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

    // </editor-fold>
}
