package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKekkaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKekkaInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaijoKekka")
    private TextBox txtShinsakaiKaijoKekka;
    @JsonProperty("txtShinsakaiChikuKekka")
    private TextBox txtShinsakaiChikuKekka;
    @JsonProperty("txtShinsakauChikuNameKekka")
    private TextBox txtShinsakauChikuNameKekka;
    @JsonProperty("txtKaisaiDateKekka")
    private TextBoxFlexibleDate txtKaisaiDateKekka;
    @JsonProperty("txtKaishiTime")
    private TextBoxTime txtKaishiTime;
    @JsonProperty("txtShuryoTime")
    private TextBoxTime txtShuryoTime;
    @JsonProperty("txtShoyoTime")
    private TextBoxNum txtShoyoTime;
    @JsonProperty("txtJissiNinzu")
    private TextBoxNum txtJissiNinzu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiKaijoKekka
     * @return txtShinsakaiKaijoKekka
     */
    @JsonProperty("txtShinsakaiKaijoKekka")
    public TextBox getTxtShinsakaiKaijoKekka() {
        return txtShinsakaiKaijoKekka;
    }

    /*
     * settxtShinsakaiKaijoKekka
     * @param txtShinsakaiKaijoKekka txtShinsakaiKaijoKekka
     */
    @JsonProperty("txtShinsakaiKaijoKekka")
    public void setTxtShinsakaiKaijoKekka(TextBox txtShinsakaiKaijoKekka) {
        this.txtShinsakaiKaijoKekka = txtShinsakaiKaijoKekka;
    }

    /*
     * gettxtShinsakaiChikuKekka
     * @return txtShinsakaiChikuKekka
     */
    @JsonProperty("txtShinsakaiChikuKekka")
    public TextBox getTxtShinsakaiChikuKekka() {
        return txtShinsakaiChikuKekka;
    }

    /*
     * settxtShinsakaiChikuKekka
     * @param txtShinsakaiChikuKekka txtShinsakaiChikuKekka
     */
    @JsonProperty("txtShinsakaiChikuKekka")
    public void setTxtShinsakaiChikuKekka(TextBox txtShinsakaiChikuKekka) {
        this.txtShinsakaiChikuKekka = txtShinsakaiChikuKekka;
    }

    /*
     * gettxtShinsakauChikuNameKekka
     * @return txtShinsakauChikuNameKekka
     */
    @JsonProperty("txtShinsakauChikuNameKekka")
    public TextBox getTxtShinsakauChikuNameKekka() {
        return txtShinsakauChikuNameKekka;
    }

    /*
     * settxtShinsakauChikuNameKekka
     * @param txtShinsakauChikuNameKekka txtShinsakauChikuNameKekka
     */
    @JsonProperty("txtShinsakauChikuNameKekka")
    public void setTxtShinsakauChikuNameKekka(TextBox txtShinsakauChikuNameKekka) {
        this.txtShinsakauChikuNameKekka = txtShinsakauChikuNameKekka;
    }

    /*
     * gettxtKaisaiDateKekka
     * @return txtKaisaiDateKekka
     */
    @JsonProperty("txtKaisaiDateKekka")
    public TextBoxFlexibleDate getTxtKaisaiDateKekka() {
        return txtKaisaiDateKekka;
    }

    /*
     * settxtKaisaiDateKekka
     * @param txtKaisaiDateKekka txtKaisaiDateKekka
     */
    @JsonProperty("txtKaisaiDateKekka")
    public void setTxtKaisaiDateKekka(TextBoxFlexibleDate txtKaisaiDateKekka) {
        this.txtKaisaiDateKekka = txtKaisaiDateKekka;
    }

    /*
     * gettxtKaishiTime
     * @return txtKaishiTime
     */
    @JsonProperty("txtKaishiTime")
    public TextBoxTime getTxtKaishiTime() {
        return txtKaishiTime;
    }

    /*
     * settxtKaishiTime
     * @param txtKaishiTime txtKaishiTime
     */
    @JsonProperty("txtKaishiTime")
    public void setTxtKaishiTime(TextBoxTime txtKaishiTime) {
        this.txtKaishiTime = txtKaishiTime;
    }

    /*
     * gettxtShuryoTime
     * @return txtShuryoTime
     */
    @JsonProperty("txtShuryoTime")
    public TextBoxTime getTxtShuryoTime() {
        return txtShuryoTime;
    }

    /*
     * settxtShuryoTime
     * @param txtShuryoTime txtShuryoTime
     */
    @JsonProperty("txtShuryoTime")
    public void setTxtShuryoTime(TextBoxTime txtShuryoTime) {
        this.txtShuryoTime = txtShuryoTime;
    }

    /*
     * gettxtShoyoTime
     * @return txtShoyoTime
     */
    @JsonProperty("txtShoyoTime")
    public TextBoxNum getTxtShoyoTime() {
        return txtShoyoTime;
    }

    /*
     * settxtShoyoTime
     * @param txtShoyoTime txtShoyoTime
     */
    @JsonProperty("txtShoyoTime")
    public void setTxtShoyoTime(TextBoxNum txtShoyoTime) {
        this.txtShoyoTime = txtShoyoTime;
    }

    /*
     * gettxtJissiNinzu
     * @return txtJissiNinzu
     */
    @JsonProperty("txtJissiNinzu")
    public TextBoxNum getTxtJissiNinzu() {
        return txtJissiNinzu;
    }

    /*
     * settxtJissiNinzu
     * @param txtJissiNinzu txtJissiNinzu
     */
    @JsonProperty("txtJissiNinzu")
    public void setTxtJissiNinzu(TextBoxNum txtJissiNinzu) {
        this.txtJissiNinzu = txtJissiNinzu;
    }

    // </editor-fold>
}
