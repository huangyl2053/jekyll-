package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaPrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaPrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chk")
    private CheckBoxList chk;
    @JsonProperty("chkChosahyo")
    private CheckBoxList chkChosahyo;
    @JsonProperty("chkOcrChosahyo")
    private CheckBoxList chkOcrChosahyo;
    @JsonProperty("chkChosahyo2")
    private CheckBoxList chkChosahyo2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchk
     * @return chk
     */
    @JsonProperty("chk")
    public CheckBoxList getChk() {
        return chk;
    }

    /*
     * setchk
     * @param chk chk
     */
    @JsonProperty("chk")
    public void setChk(CheckBoxList chk) {
        this.chk = chk;
    }

    /*
     * getchkChosahyo
     * @return chkChosahyo
     */
    @JsonProperty("chkChosahyo")
    public CheckBoxList getChkChosahyo() {
        return chkChosahyo;
    }

    /*
     * setchkChosahyo
     * @param chkChosahyo chkChosahyo
     */
    @JsonProperty("chkChosahyo")
    public void setChkChosahyo(CheckBoxList chkChosahyo) {
        this.chkChosahyo = chkChosahyo;
    }

    /*
     * getchkOcrChosahyo
     * @return chkOcrChosahyo
     */
    @JsonProperty("chkOcrChosahyo")
    public CheckBoxList getChkOcrChosahyo() {
        return chkOcrChosahyo;
    }

    /*
     * setchkOcrChosahyo
     * @param chkOcrChosahyo chkOcrChosahyo
     */
    @JsonProperty("chkOcrChosahyo")
    public void setChkOcrChosahyo(CheckBoxList chkOcrChosahyo) {
        this.chkOcrChosahyo = chkOcrChosahyo;
    }

    /*
     * getchkChosahyo2
     * @return chkChosahyo2
     */
    @JsonProperty("chkChosahyo2")
    public CheckBoxList getChkChosahyo2() {
        return chkChosahyo2;
    }

    /*
     * setchkChosahyo2
     * @param chkChosahyo2 chkChosahyo2
     */
    @JsonProperty("chkChosahyo2")
    public void setChkChosahyo2(CheckBoxList chkChosahyo2) {
        this.chkChosahyo2 = chkChosahyo2;
    }

    // </editor-fold>
}
