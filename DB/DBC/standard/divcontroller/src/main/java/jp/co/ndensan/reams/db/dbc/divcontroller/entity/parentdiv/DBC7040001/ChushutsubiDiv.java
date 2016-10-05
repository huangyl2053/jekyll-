package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Chushutsubi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsubiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Yohaku")
    private Space Yohaku;
    @JsonProperty("txtShoriTaishoNengetsu")
    private TextBoxDateRange txtShoriTaishoNengetsu;
    @JsonProperty("txtIdoNengetsu")
    private TextBoxDateRange txtIdoNengetsu;
    @JsonProperty("chkIdotukiSaisinJohoChushutsu")
    private CheckBoxList chkIdotukiSaisinJohoChushutsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYohaku
     * @return Yohaku
     */
    @JsonProperty("Yohaku")
    public Space getYohaku() {
        return Yohaku;
    }

    /*
     * setYohaku
     * @param Yohaku Yohaku
     */
    @JsonProperty("Yohaku")
    public void setYohaku(Space Yohaku) {
        this.Yohaku = Yohaku;
    }

    /*
     * gettxtShoriTaishoNengetsu
     * @return txtShoriTaishoNengetsu
     */
    @JsonProperty("txtShoriTaishoNengetsu")
    public TextBoxDateRange getTxtShoriTaishoNengetsu() {
        return txtShoriTaishoNengetsu;
    }

    /*
     * settxtShoriTaishoNengetsu
     * @param txtShoriTaishoNengetsu txtShoriTaishoNengetsu
     */
    @JsonProperty("txtShoriTaishoNengetsu")
    public void setTxtShoriTaishoNengetsu(TextBoxDateRange txtShoriTaishoNengetsu) {
        this.txtShoriTaishoNengetsu = txtShoriTaishoNengetsu;
    }

    /*
     * gettxtIdoNengetsu
     * @return txtIdoNengetsu
     */
    @JsonProperty("txtIdoNengetsu")
    public TextBoxDateRange getTxtIdoNengetsu() {
        return txtIdoNengetsu;
    }

    /*
     * settxtIdoNengetsu
     * @param txtIdoNengetsu txtIdoNengetsu
     */
    @JsonProperty("txtIdoNengetsu")
    public void setTxtIdoNengetsu(TextBoxDateRange txtIdoNengetsu) {
        this.txtIdoNengetsu = txtIdoNengetsu;
    }

    /*
     * getchkIdotukiSaisinJohoChushutsu
     * @return chkIdotukiSaisinJohoChushutsu
     */
    @JsonProperty("chkIdotukiSaisinJohoChushutsu")
    public CheckBoxList getChkIdotukiSaisinJohoChushutsu() {
        return chkIdotukiSaisinJohoChushutsu;
    }

    /*
     * setchkIdotukiSaisinJohoChushutsu
     * @param chkIdotukiSaisinJohoChushutsu chkIdotukiSaisinJohoChushutsu
     */
    @JsonProperty("chkIdotukiSaisinJohoChushutsu")
    public void setChkIdotukiSaisinJohoChushutsu(CheckBoxList chkIdotukiSaisinJohoChushutsu) {
        this.chkIdotukiSaisinJohoChushutsu = chkIdotukiSaisinJohoChushutsu;
    }

    // </editor-fold>
}
