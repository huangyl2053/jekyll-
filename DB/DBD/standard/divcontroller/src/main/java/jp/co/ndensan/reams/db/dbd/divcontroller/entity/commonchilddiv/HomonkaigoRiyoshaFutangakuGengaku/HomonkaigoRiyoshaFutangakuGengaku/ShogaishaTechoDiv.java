package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaTecho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaTechoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHasShogaishaTecho")
    private TextBox txtHasShogaishaTecho;
    @JsonProperty("txtShogaishaTechoTokyu")
    private TextBox txtShogaishaTechoTokyu;
    @JsonProperty("txtShogaishaTechoNo")
    private TextBoxCode txtShogaishaTechoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHasShogaishaTecho
     * @return txtHasShogaishaTecho
     */
    @JsonProperty("txtHasShogaishaTecho")
    public TextBox getTxtHasShogaishaTecho() {
        return txtHasShogaishaTecho;
    }

    /*
     * settxtHasShogaishaTecho
     * @param txtHasShogaishaTecho txtHasShogaishaTecho
     */
    @JsonProperty("txtHasShogaishaTecho")
    public void setTxtHasShogaishaTecho(TextBox txtHasShogaishaTecho) {
        this.txtHasShogaishaTecho = txtHasShogaishaTecho;
    }

    /*
     * gettxtShogaishaTechoTokyu
     * @return txtShogaishaTechoTokyu
     */
    @JsonProperty("txtShogaishaTechoTokyu")
    public TextBox getTxtShogaishaTechoTokyu() {
        return txtShogaishaTechoTokyu;
    }

    /*
     * settxtShogaishaTechoTokyu
     * @param txtShogaishaTechoTokyu txtShogaishaTechoTokyu
     */
    @JsonProperty("txtShogaishaTechoTokyu")
    public void setTxtShogaishaTechoTokyu(TextBox txtShogaishaTechoTokyu) {
        this.txtShogaishaTechoTokyu = txtShogaishaTechoTokyu;
    }

    /*
     * gettxtShogaishaTechoNo
     * @return txtShogaishaTechoNo
     */
    @JsonProperty("txtShogaishaTechoNo")
    public TextBoxCode getTxtShogaishaTechoNo() {
        return txtShogaishaTechoNo;
    }

    /*
     * settxtShogaishaTechoNo
     * @param txtShogaishaTechoNo txtShogaishaTechoNo
     */
    @JsonProperty("txtShogaishaTechoNo")
    public void setTxtShogaishaTechoNo(TextBoxCode txtShogaishaTechoNo) {
        this.txtShogaishaTechoNo = txtShogaishaTechoNo;
    }

    // </editor-fold>
}
