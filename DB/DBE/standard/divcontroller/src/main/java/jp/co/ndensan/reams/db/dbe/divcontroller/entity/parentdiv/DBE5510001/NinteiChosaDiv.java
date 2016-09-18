package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinteiChosaIrai")
    private CheckBoxList chkNinteiChosaIrai;
    @JsonProperty("chkNinteiChosaJisshi")
    private CheckBoxList chkNinteiChosaJisshi;
    @JsonProperty("chkNinteiChosaTokki")
    private CheckBoxList chkNinteiChosaTokki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkNinteiChosaIrai
     * @return chkNinteiChosaIrai
     */
    @JsonProperty("chkNinteiChosaIrai")
    public CheckBoxList getChkNinteiChosaIrai() {
        return chkNinteiChosaIrai;
    }

    /*
     * setchkNinteiChosaIrai
     * @param chkNinteiChosaIrai chkNinteiChosaIrai
     */
    @JsonProperty("chkNinteiChosaIrai")
    public void setChkNinteiChosaIrai(CheckBoxList chkNinteiChosaIrai) {
        this.chkNinteiChosaIrai = chkNinteiChosaIrai;
    }

    /*
     * getchkNinteiChosaJisshi
     * @return chkNinteiChosaJisshi
     */
    @JsonProperty("chkNinteiChosaJisshi")
    public CheckBoxList getChkNinteiChosaJisshi() {
        return chkNinteiChosaJisshi;
    }

    /*
     * setchkNinteiChosaJisshi
     * @param chkNinteiChosaJisshi chkNinteiChosaJisshi
     */
    @JsonProperty("chkNinteiChosaJisshi")
    public void setChkNinteiChosaJisshi(CheckBoxList chkNinteiChosaJisshi) {
        this.chkNinteiChosaJisshi = chkNinteiChosaJisshi;
    }

    /*
     * getchkNinteiChosaTokki
     * @return chkNinteiChosaTokki
     */
    @JsonProperty("chkNinteiChosaTokki")
    public CheckBoxList getChkNinteiChosaTokki() {
        return chkNinteiChosaTokki;
    }

    /*
     * setchkNinteiChosaTokki
     * @param chkNinteiChosaTokki chkNinteiChosaTokki
     */
    @JsonProperty("chkNinteiChosaTokki")
    public void setChkNinteiChosaTokki(CheckBoxList chkNinteiChosaTokki) {
        this.chkNinteiChosaTokki = chkNinteiChosaTokki;
    }

    // </editor-fold>
}
