package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokkiChecks のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiChecksDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTokkiKomokuAri")
    private CheckBoxList chkTokkiKomokuAri;
    @JsonProperty("chkTokkiKomokuNashi")
    private CheckBoxList chkTokkiKomokuNashi;
    @JsonProperty("chkTokkiFree")
    private CheckBoxList chkTokkiFree;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTokkiKomokuAri
     * @return chkTokkiKomokuAri
     */
    @JsonProperty("chkTokkiKomokuAri")
    public CheckBoxList getChkTokkiKomokuAri() {
        return chkTokkiKomokuAri;
    }

    /*
     * setchkTokkiKomokuAri
     * @param chkTokkiKomokuAri chkTokkiKomokuAri
     */
    @JsonProperty("chkTokkiKomokuAri")
    public void setChkTokkiKomokuAri(CheckBoxList chkTokkiKomokuAri) {
        this.chkTokkiKomokuAri = chkTokkiKomokuAri;
    }

    /*
     * getchkTokkiKomokuNashi
     * @return chkTokkiKomokuNashi
     */
    @JsonProperty("chkTokkiKomokuNashi")
    public CheckBoxList getChkTokkiKomokuNashi() {
        return chkTokkiKomokuNashi;
    }

    /*
     * setchkTokkiKomokuNashi
     * @param chkTokkiKomokuNashi chkTokkiKomokuNashi
     */
    @JsonProperty("chkTokkiKomokuNashi")
    public void setChkTokkiKomokuNashi(CheckBoxList chkTokkiKomokuNashi) {
        this.chkTokkiKomokuNashi = chkTokkiKomokuNashi;
    }

    /*
     * getchkTokkiFree
     * @return chkTokkiFree
     */
    @JsonProperty("chkTokkiFree")
    public CheckBoxList getChkTokkiFree() {
        return chkTokkiFree;
    }

    /*
     * setchkTokkiFree
     * @param chkTokkiFree chkTokkiFree
     */
    @JsonProperty("chkTokkiFree")
    public void setChkTokkiFree(CheckBoxList chkTokkiFree) {
        this.chkTokkiFree = chkTokkiFree;
    }

    // </editor-fold>
}
