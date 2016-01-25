package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelKyotaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKyotakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeikakuSakuseiKubun")
    private TextBox txtKeikakuSakuseiKubun;
    @JsonProperty("chkKyusochi")
    private CheckBoxList chkKyusochi;
    @JsonProperty("txtJigyosha")
    private TextBoxCode txtJigyosha;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtHokenKyufuritsu")
    private TextBoxNum txtHokenKyufuritsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKeikakuSakuseiKubun
     * @return txtKeikakuSakuseiKubun
     */
    @JsonProperty("txtKeikakuSakuseiKubun")
    public TextBox getTxtKeikakuSakuseiKubun() {
        return txtKeikakuSakuseiKubun;
    }

    /*
     * settxtKeikakuSakuseiKubun
     * @param txtKeikakuSakuseiKubun txtKeikakuSakuseiKubun
     */
    @JsonProperty("txtKeikakuSakuseiKubun")
    public void setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.txtKeikakuSakuseiKubun = txtKeikakuSakuseiKubun;
    }

    /*
     * getchkKyusochi
     * @return chkKyusochi
     */
    @JsonProperty("chkKyusochi")
    public CheckBoxList getChkKyusochi() {
        return chkKyusochi;
    }

    /*
     * setchkKyusochi
     * @param chkKyusochi chkKyusochi
     */
    @JsonProperty("chkKyusochi")
    public void setChkKyusochi(CheckBoxList chkKyusochi) {
        this.chkKyusochi = chkKyusochi;
    }

    /*
     * gettxtJigyosha
     * @return txtJigyosha
     */
    @JsonProperty("txtJigyosha")
    public TextBoxCode getTxtJigyosha() {
        return txtJigyosha;
    }

    /*
     * settxtJigyosha
     * @param txtJigyosha txtJigyosha
     */
    @JsonProperty("txtJigyosha")
    public void setTxtJigyosha(TextBoxCode txtJigyosha) {
        this.txtJigyosha = txtJigyosha;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * gettxtHokenKyufuritsu
     * @return txtHokenKyufuritsu
     */
    @JsonProperty("txtHokenKyufuritsu")
    public TextBoxNum getTxtHokenKyufuritsu() {
        return txtHokenKyufuritsu;
    }

    /*
     * settxtHokenKyufuritsu
     * @param txtHokenKyufuritsu txtHokenKyufuritsu
     */
    @JsonProperty("txtHokenKyufuritsu")
    public void setTxtHokenKyufuritsu(TextBoxNum txtHokenKyufuritsu) {
        this.txtHokenKyufuritsu = txtHokenKyufuritsu;
    }

    // </editor-fold>
}
