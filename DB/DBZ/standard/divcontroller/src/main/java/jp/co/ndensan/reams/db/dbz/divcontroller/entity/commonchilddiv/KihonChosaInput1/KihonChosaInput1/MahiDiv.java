package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Mahi のクラスファイル
 *
 * @author 自動生成
 */
public class MahiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnMahi")
    private ButtonDialog btnMahi;
    @JsonProperty("chkMahi")
    private CheckBoxList chkMahi;
    @JsonProperty("isMahiSelected")
    private RString isMahiSelected;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnMahi
     * @return btnMahi
     */
    @JsonProperty("btnMahi")
    public ButtonDialog getBtnMahi() {
        return btnMahi;
    }

    /*
     * setbtnMahi
     * @param btnMahi btnMahi
     */
    @JsonProperty("btnMahi")
    public void setBtnMahi(ButtonDialog btnMahi) {
        this.btnMahi = btnMahi;
    }

    /*
     * getchkMahi
     * @return chkMahi
     */
    @JsonProperty("chkMahi")
    public CheckBoxList getChkMahi() {
        return chkMahi;
    }

    /*
     * setchkMahi
     * @param chkMahi chkMahi
     */
    @JsonProperty("chkMahi")
    public void setChkMahi(CheckBoxList chkMahi) {
        this.chkMahi = chkMahi;
    }

    /*
     * getisMahiSelected
     * @return isMahiSelected
     */
    @JsonProperty("isMahiSelected")
    public RString getIsMahiSelected() {
        return isMahiSelected;
    }

    /*
     * setisMahiSelected
     * @param isMahiSelected isMahiSelected
     */
    @JsonProperty("isMahiSelected")
    public void setIsMahiSelected(RString isMahiSelected) {
        this.isMahiSelected = isMahiSelected;
    }

    // </editor-fold>
}
