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
 * YoshikiIchinoyonHoseiHeader のクラスファイル
 *
 * @reamsid_L DBU-1100-040 yebangqiang
 */
public class YoshikiIchinoyonHoseiHeaderDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("txtHokenshaNo")
    private TextBox txtHokenshaNo;
    @JsonProperty("txtHokenshaName")
    private TextBox txtHokenshaName;

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
     * gettxtHokenshaNo
     * @return txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public TextBox getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    /*
     * settxtHokenshaNo
     * @param txtHokenshaNo txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBox txtHokenshaNo) {
        this.txtHokenshaNo = txtHokenshaNo;
    }

    /*
     * gettxtHokenshaName
     * @return txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public TextBox getTxtHokenshaName() {
        return txtHokenshaName;
    }

    /*
     * settxtHokenshaName
     * @param txtHokenshaName txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public void setTxtHokenshaName(TextBox txtHokenshaName) {
        this.txtHokenshaName = txtHokenshaName;
    }

    // </editor-fold>
}
