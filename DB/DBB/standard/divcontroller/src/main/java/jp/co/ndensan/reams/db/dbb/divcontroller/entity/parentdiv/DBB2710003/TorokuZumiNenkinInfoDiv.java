package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TorokuZumiNenkinInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TorokuZumiNenkinInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokuZumiKisoNenkinNo")
    private TextBox txtTorokuZumiKisoNenkinNo;
    @JsonProperty("txtTorokuZumiNenkinCode")
    private TextBox txtTorokuZumiNenkinCode;
    @JsonProperty("txtTorokuZumiTokuchoGimusha")
    private TextBox txtTorokuZumiTokuchoGimusha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorokuZumiKisoNenkinNo
     * @return txtTorokuZumiKisoNenkinNo
     */
    @JsonProperty("txtTorokuZumiKisoNenkinNo")
    public TextBox getTxtTorokuZumiKisoNenkinNo() {
        return txtTorokuZumiKisoNenkinNo;
    }

    /*
     * settxtTorokuZumiKisoNenkinNo
     * @param txtTorokuZumiKisoNenkinNo txtTorokuZumiKisoNenkinNo
     */
    @JsonProperty("txtTorokuZumiKisoNenkinNo")
    public void setTxtTorokuZumiKisoNenkinNo(TextBox txtTorokuZumiKisoNenkinNo) {
        this.txtTorokuZumiKisoNenkinNo = txtTorokuZumiKisoNenkinNo;
    }

    /*
     * gettxtTorokuZumiNenkinCode
     * @return txtTorokuZumiNenkinCode
     */
    @JsonProperty("txtTorokuZumiNenkinCode")
    public TextBox getTxtTorokuZumiNenkinCode() {
        return txtTorokuZumiNenkinCode;
    }

    /*
     * settxtTorokuZumiNenkinCode
     * @param txtTorokuZumiNenkinCode txtTorokuZumiNenkinCode
     */
    @JsonProperty("txtTorokuZumiNenkinCode")
    public void setTxtTorokuZumiNenkinCode(TextBox txtTorokuZumiNenkinCode) {
        this.txtTorokuZumiNenkinCode = txtTorokuZumiNenkinCode;
    }

    /*
     * gettxtTorokuZumiTokuchoGimusha
     * @return txtTorokuZumiTokuchoGimusha
     */
    @JsonProperty("txtTorokuZumiTokuchoGimusha")
    public TextBox getTxtTorokuZumiTokuchoGimusha() {
        return txtTorokuZumiTokuchoGimusha;
    }

    /*
     * settxtTorokuZumiTokuchoGimusha
     * @param txtTorokuZumiTokuchoGimusha txtTorokuZumiTokuchoGimusha
     */
    @JsonProperty("txtTorokuZumiTokuchoGimusha")
    public void setTxtTorokuZumiTokuchoGimusha(TextBox txtTorokuZumiTokuchoGimusha) {
        this.txtTorokuZumiTokuchoGimusha = txtTorokuZumiTokuchoGimusha;
    }

    // </editor-fold>
}
