package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyuKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJukyushaNo")
    private TextBoxCode txtJukyushaNo;
    @JsonProperty("txtJukyuKaishiYMD")
    private TextBoxDate txtJukyuKaishiYMD;
    @JsonProperty("txtJukyuHaishiYMD")
    private TextBoxDate txtJukyuHaishiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJukyushaNo
     * @return txtJukyushaNo
     */
    @JsonProperty("txtJukyushaNo")
    public TextBoxCode getTxtJukyushaNo() {
        return txtJukyushaNo;
    }

    /*
     * settxtJukyushaNo
     * @param txtJukyushaNo txtJukyushaNo
     */
    @JsonProperty("txtJukyushaNo")
    public void setTxtJukyushaNo(TextBoxCode txtJukyushaNo) {
        this.txtJukyushaNo = txtJukyushaNo;
    }

    /*
     * gettxtJukyuKaishiYMD
     * @return txtJukyuKaishiYMD
     */
    @JsonProperty("txtJukyuKaishiYMD")
    public TextBoxDate getTxtJukyuKaishiYMD() {
        return txtJukyuKaishiYMD;
    }

    /*
     * settxtJukyuKaishiYMD
     * @param txtJukyuKaishiYMD txtJukyuKaishiYMD
     */
    @JsonProperty("txtJukyuKaishiYMD")
    public void setTxtJukyuKaishiYMD(TextBoxDate txtJukyuKaishiYMD) {
        this.txtJukyuKaishiYMD = txtJukyuKaishiYMD;
    }

    /*
     * gettxtJukyuHaishiYMD
     * @return txtJukyuHaishiYMD
     */
    @JsonProperty("txtJukyuHaishiYMD")
    public TextBoxDate getTxtJukyuHaishiYMD() {
        return txtJukyuHaishiYMD;
    }

    /*
     * settxtJukyuHaishiYMD
     * @param txtJukyuHaishiYMD txtJukyuHaishiYMD
     */
    @JsonProperty("txtJukyuHaishiYMD")
    public void setTxtJukyuHaishiYMD(TextBoxDate txtJukyuHaishiYMD) {
        this.txtJukyuHaishiYMD = txtJukyuHaishiYMD;
    }

    // </editor-fold>
}
