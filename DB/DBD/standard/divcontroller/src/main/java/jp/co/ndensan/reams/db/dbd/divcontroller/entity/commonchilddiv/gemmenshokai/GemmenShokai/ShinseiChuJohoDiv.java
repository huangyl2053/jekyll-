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
 * ShinseiChuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiChuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiChuShinseiYmd")
    private TextBoxFlexibleDate txtShinseiChuShinseiYmd;
    @JsonProperty("txtShinseiChuShinseiShurui")
    private TextBox txtShinseiChuShinseiShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiChuShinseiYmd
     * @return txtShinseiChuShinseiYmd
     */
    @JsonProperty("txtShinseiChuShinseiYmd")
    public TextBoxFlexibleDate getTxtShinseiChuShinseiYmd() {
        return txtShinseiChuShinseiYmd;
    }

    /*
     * settxtShinseiChuShinseiYmd
     * @param txtShinseiChuShinseiYmd txtShinseiChuShinseiYmd
     */
    @JsonProperty("txtShinseiChuShinseiYmd")
    public void setTxtShinseiChuShinseiYmd(TextBoxFlexibleDate txtShinseiChuShinseiYmd) {
        this.txtShinseiChuShinseiYmd = txtShinseiChuShinseiYmd;
    }

    /*
     * gettxtShinseiChuShinseiShurui
     * @return txtShinseiChuShinseiShurui
     */
    @JsonProperty("txtShinseiChuShinseiShurui")
    public TextBox getTxtShinseiChuShinseiShurui() {
        return txtShinseiChuShinseiShurui;
    }

    /*
     * settxtShinseiChuShinseiShurui
     * @param txtShinseiChuShinseiShurui txtShinseiChuShinseiShurui
     */
    @JsonProperty("txtShinseiChuShinseiShurui")
    public void setTxtShinseiChuShinseiShurui(TextBox txtShinseiChuShinseiShurui) {
        this.txtShinseiChuShinseiShurui = txtShinseiChuShinseiShurui;
    }

    // </editor-fold>
}
