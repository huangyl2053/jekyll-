package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKaisaiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaiInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaisaiBi")
    private TextBoxFlexibleDate txtKaisaiBi;
    @JsonProperty("txtKaisaiStartTime")
    private TextBoxTime txtKaisaiStartTime;
    @JsonProperty("txtKaisaiEndTime")
    private TextBoxTime txtKaisaiEndTime;
    @JsonProperty("txtShoyoTime")
    private TextBox txtShoyoTime;
    @JsonProperty("txtJissiSu")
    private TextBoxNum txtJissiSu;
    @JsonProperty("ddlKaisaiBasho")
    private DropDownList ddlKaisaiBasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKaisaiBi
     * @return txtKaisaiBi
     */
    @JsonProperty("txtKaisaiBi")
    public TextBoxFlexibleDate getTxtKaisaiBi() {
        return txtKaisaiBi;
    }

    /*
     * settxtKaisaiBi
     * @param txtKaisaiBi txtKaisaiBi
     */
    @JsonProperty("txtKaisaiBi")
    public void setTxtKaisaiBi(TextBoxFlexibleDate txtKaisaiBi) {
        this.txtKaisaiBi = txtKaisaiBi;
    }

    /*
     * gettxtKaisaiStartTime
     * @return txtKaisaiStartTime
     */
    @JsonProperty("txtKaisaiStartTime")
    public TextBoxTime getTxtKaisaiStartTime() {
        return txtKaisaiStartTime;
    }

    /*
     * settxtKaisaiStartTime
     * @param txtKaisaiStartTime txtKaisaiStartTime
     */
    @JsonProperty("txtKaisaiStartTime")
    public void setTxtKaisaiStartTime(TextBoxTime txtKaisaiStartTime) {
        this.txtKaisaiStartTime = txtKaisaiStartTime;
    }

    /*
     * gettxtKaisaiEndTime
     * @return txtKaisaiEndTime
     */
    @JsonProperty("txtKaisaiEndTime")
    public TextBoxTime getTxtKaisaiEndTime() {
        return txtKaisaiEndTime;
    }

    /*
     * settxtKaisaiEndTime
     * @param txtKaisaiEndTime txtKaisaiEndTime
     */
    @JsonProperty("txtKaisaiEndTime")
    public void setTxtKaisaiEndTime(TextBoxTime txtKaisaiEndTime) {
        this.txtKaisaiEndTime = txtKaisaiEndTime;
    }

    /*
     * gettxtShoyoTime
     * @return txtShoyoTime
     */
    @JsonProperty("txtShoyoTime")
    public TextBox getTxtShoyoTime() {
        return txtShoyoTime;
    }

    /*
     * settxtShoyoTime
     * @param txtShoyoTime txtShoyoTime
     */
    @JsonProperty("txtShoyoTime")
    public void setTxtShoyoTime(TextBox txtShoyoTime) {
        this.txtShoyoTime = txtShoyoTime;
    }

    /*
     * gettxtJissiSu
     * @return txtJissiSu
     */
    @JsonProperty("txtJissiSu")
    public TextBoxNum getTxtJissiSu() {
        return txtJissiSu;
    }

    /*
     * settxtJissiSu
     * @param txtJissiSu txtJissiSu
     */
    @JsonProperty("txtJissiSu")
    public void setTxtJissiSu(TextBoxNum txtJissiSu) {
        this.txtJissiSu = txtJissiSu;
    }

    /*
     * getddlKaisaiBasho
     * @return ddlKaisaiBasho
     */
    @JsonProperty("ddlKaisaiBasho")
    public DropDownList getDdlKaisaiBasho() {
        return ddlKaisaiBasho;
    }

    /*
     * setddlKaisaiBasho
     * @param ddlKaisaiBasho ddlKaisaiBasho
     */
    @JsonProperty("ddlKaisaiBasho")
    public void setDdlKaisaiBasho(DropDownList ddlKaisaiBasho) {
        this.ddlKaisaiBasho = ddlKaisaiBasho;
    }

    // </editor-fold>
}
