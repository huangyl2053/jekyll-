package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmenshokai.GemmenShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FutanWariaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanWariaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFutanWariai")
    private TextBox txtFutanWariai;
    @JsonProperty("txtFutanWariaiKaishiYMD")
    private TextBoxFlexibleDate txtFutanWariaiKaishiYMD;
    @JsonProperty("txtFutanWariaiShuryoYMD")
    private TextBoxFlexibleDate txtFutanWariaiShuryoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFutanWariai
     * @return txtFutanWariai
     */
    @JsonProperty("txtFutanWariai")
    public TextBox getTxtFutanWariai() {
        return txtFutanWariai;
    }

    /*
     * settxtFutanWariai
     * @param txtFutanWariai txtFutanWariai
     */
    @JsonProperty("txtFutanWariai")
    public void setTxtFutanWariai(TextBox txtFutanWariai) {
        this.txtFutanWariai = txtFutanWariai;
    }

    /*
     * gettxtFutanWariaiKaishiYMD
     * @return txtFutanWariaiKaishiYMD
     */
    @JsonProperty("txtFutanWariaiKaishiYMD")
    public TextBoxFlexibleDate getTxtFutanWariaiKaishiYMD() {
        return txtFutanWariaiKaishiYMD;
    }

    /*
     * settxtFutanWariaiKaishiYMD
     * @param txtFutanWariaiKaishiYMD txtFutanWariaiKaishiYMD
     */
    @JsonProperty("txtFutanWariaiKaishiYMD")
    public void setTxtFutanWariaiKaishiYMD(TextBoxFlexibleDate txtFutanWariaiKaishiYMD) {
        this.txtFutanWariaiKaishiYMD = txtFutanWariaiKaishiYMD;
    }

    /*
     * gettxtFutanWariaiShuryoYMD
     * @return txtFutanWariaiShuryoYMD
     */
    @JsonProperty("txtFutanWariaiShuryoYMD")
    public TextBoxFlexibleDate getTxtFutanWariaiShuryoYMD() {
        return txtFutanWariaiShuryoYMD;
    }

    /*
     * settxtFutanWariaiShuryoYMD
     * @param txtFutanWariaiShuryoYMD txtFutanWariaiShuryoYMD
     */
    @JsonProperty("txtFutanWariaiShuryoYMD")
    public void setTxtFutanWariaiShuryoYMD(TextBoxFlexibleDate txtFutanWariaiShuryoYMD) {
        this.txtFutanWariaiShuryoYMD = txtFutanWariaiShuryoYMD;
    }

    // </editor-fold>
}
