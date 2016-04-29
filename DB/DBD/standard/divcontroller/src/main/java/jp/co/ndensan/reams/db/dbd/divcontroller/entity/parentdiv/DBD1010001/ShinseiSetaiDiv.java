package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiSetai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiSetaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    private TextBox txtRiyoshaFutanDankai;
    @JsonProperty("txtDispSetaiJoho")
    private ButtonDialog txtDispSetaiJoho;
    @JsonProperty("btnDispGemmenJoho")
    private ButtonDialog btnDispGemmenJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRiyoshaFutanDankai
     * @return txtRiyoshaFutanDankai
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    public TextBox getTxtRiyoshaFutanDankai() {
        return txtRiyoshaFutanDankai;
    }

    /*
     * settxtRiyoshaFutanDankai
     * @param txtRiyoshaFutanDankai txtRiyoshaFutanDankai
     */
    @JsonProperty("txtRiyoshaFutanDankai")
    public void setTxtRiyoshaFutanDankai(TextBox txtRiyoshaFutanDankai) {
        this.txtRiyoshaFutanDankai = txtRiyoshaFutanDankai;
    }

    /*
     * gettxtDispSetaiJoho
     * @return txtDispSetaiJoho
     */
    @JsonProperty("txtDispSetaiJoho")
    public ButtonDialog getTxtDispSetaiJoho() {
        return txtDispSetaiJoho;
    }

    /*
     * settxtDispSetaiJoho
     * @param txtDispSetaiJoho txtDispSetaiJoho
     */
    @JsonProperty("txtDispSetaiJoho")
    public void setTxtDispSetaiJoho(ButtonDialog txtDispSetaiJoho) {
        this.txtDispSetaiJoho = txtDispSetaiJoho;
    }

    /*
     * getbtnDispGemmenJoho
     * @return btnDispGemmenJoho
     */
    @JsonProperty("btnDispGemmenJoho")
    public ButtonDialog getBtnDispGemmenJoho() {
        return btnDispGemmenJoho;
    }

    /*
     * setbtnDispGemmenJoho
     * @param btnDispGemmenJoho btnDispGemmenJoho
     */
    @JsonProperty("btnDispGemmenJoho")
    public void setBtnDispGemmenJoho(ButtonDialog btnDispGemmenJoho) {
        this.btnDispGemmenJoho = btnDispGemmenJoho;
    }

    // </editor-fold>
}
