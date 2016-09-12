package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChoshuKenKeimetsuKikan1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuKenKeimetsuKikan1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChoShushometsu1")
    private Label lblChoShushometsu1;
    @JsonProperty("txtChoShushometsu1")
    private TextBoxNum txtChoShushometsu1;
    @JsonProperty("Kakesan")
    private KakesanDiv Kakesan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChoShushometsu1
     * @return lblChoShushometsu1
     */
    @JsonProperty("lblChoShushometsu1")
    public Label getLblChoShushometsu1() {
        return lblChoShushometsu1;
    }

    /*
     * setlblChoShushometsu1
     * @param lblChoShushometsu1 lblChoShushometsu1
     */
    @JsonProperty("lblChoShushometsu1")
    public void setLblChoShushometsu1(Label lblChoShushometsu1) {
        this.lblChoShushometsu1 = lblChoShushometsu1;
    }

    /*
     * gettxtChoShushometsu1
     * @return txtChoShushometsu1
     */
    @JsonProperty("txtChoShushometsu1")
    public TextBoxNum getTxtChoShushometsu1() {
        return txtChoShushometsu1;
    }

    /*
     * settxtChoShushometsu1
     * @param txtChoShushometsu1 txtChoShushometsu1
     */
    @JsonProperty("txtChoShushometsu1")
    public void setTxtChoShushometsu1(TextBoxNum txtChoShushometsu1) {
        this.txtChoShushometsu1 = txtChoShushometsu1;
    }

    /*
     * getKakesan
     * @return Kakesan
     */
    @JsonProperty("Kakesan")
    public KakesanDiv getKakesan() {
        return Kakesan;
    }

    /*
     * setKakesan
     * @param Kakesan Kakesan
     */
    @JsonProperty("Kakesan")
    public void setKakesan(KakesanDiv Kakesan) {
        this.Kakesan = Kakesan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKakesan() {
        return this.getKakesan().getLblKakesan();
    }

    @JsonIgnore
    public void  setLblKakesan(Label lblKakesan) {
        this.getKakesan().setLblKakesan(lblKakesan);
    }

    // </editor-fold>
}
