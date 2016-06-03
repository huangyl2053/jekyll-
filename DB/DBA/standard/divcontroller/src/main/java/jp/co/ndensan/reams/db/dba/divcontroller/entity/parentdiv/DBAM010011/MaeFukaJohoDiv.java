package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MaeFukaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class MaeFukaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtMaeFukaKetasu")
    private TextBoxNum txtMaeFukaKetasu;
    @JsonProperty("txtMaeFukaCode")
    private TextBoxCode txtMaeFukaCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtMaeFukaKetasu
     * @return txtMaeFukaKetasu
     */
    @JsonProperty("txtMaeFukaKetasu")
    public TextBoxNum getTxtMaeFukaKetasu() {
        return txtMaeFukaKetasu;
    }

    /*
     * settxtMaeFukaKetasu
     * @param txtMaeFukaKetasu txtMaeFukaKetasu
     */
    @JsonProperty("txtMaeFukaKetasu")
    public void setTxtMaeFukaKetasu(TextBoxNum txtMaeFukaKetasu) {
        this.txtMaeFukaKetasu = txtMaeFukaKetasu;
    }

    /*
     * gettxtMaeFukaCode
     * @return txtMaeFukaCode
     */
    @JsonProperty("txtMaeFukaCode")
    public TextBoxCode getTxtMaeFukaCode() {
        return txtMaeFukaCode;
    }

    /*
     * settxtMaeFukaCode
     * @param txtMaeFukaCode txtMaeFukaCode
     */
    @JsonProperty("txtMaeFukaCode")
    public void setTxtMaeFukaCode(TextBoxCode txtMaeFukaCode) {
        this.txtMaeFukaCode = txtMaeFukaCode;
    }

    // </editor-fold>
}
