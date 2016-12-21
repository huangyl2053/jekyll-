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
 * ChosahyoSelectItemsOne のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosahyoSelectItemsOneDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkChosaIrai")
    private CheckBoxList chkChosaIrai;
    @JsonProperty("chkChosaOcr")
    private CheckBoxList chkChosaOcr;
    @JsonProperty("chkTokkiOcr")
    private CheckBoxList chkTokkiOcr;
    @JsonProperty("chkNinteiChosahyoSonota")
    private CheckBoxList chkNinteiChosahyoSonota;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkChosaIrai
     * @return chkChosaIrai
     */
    @JsonProperty("chkChosaIrai")
    public CheckBoxList getChkChosaIrai() {
        return chkChosaIrai;
    }

    /*
     * setchkChosaIrai
     * @param chkChosaIrai chkChosaIrai
     */
    @JsonProperty("chkChosaIrai")
    public void setChkChosaIrai(CheckBoxList chkChosaIrai) {
        this.chkChosaIrai = chkChosaIrai;
    }

    /*
     * getchkChosaOcr
     * @return chkChosaOcr
     */
    @JsonProperty("chkChosaOcr")
    public CheckBoxList getChkChosaOcr() {
        return chkChosaOcr;
    }

    /*
     * setchkChosaOcr
     * @param chkChosaOcr chkChosaOcr
     */
    @JsonProperty("chkChosaOcr")
    public void setChkChosaOcr(CheckBoxList chkChosaOcr) {
        this.chkChosaOcr = chkChosaOcr;
    }

    /*
     * getchkTokkiOcr
     * @return chkTokkiOcr
     */
    @JsonProperty("chkTokkiOcr")
    public CheckBoxList getChkTokkiOcr() {
        return chkTokkiOcr;
    }

    /*
     * setchkTokkiOcr
     * @param chkTokkiOcr chkTokkiOcr
     */
    @JsonProperty("chkTokkiOcr")
    public void setChkTokkiOcr(CheckBoxList chkTokkiOcr) {
        this.chkTokkiOcr = chkTokkiOcr;
    }

    /*
     * getchkNinteiChosahyoSonota
     * @return chkNinteiChosahyoSonota
     */
    @JsonProperty("chkNinteiChosahyoSonota")
    public CheckBoxList getChkNinteiChosahyoSonota() {
        return chkNinteiChosahyoSonota;
    }

    /*
     * setchkNinteiChosahyoSonota
     * @param chkNinteiChosahyoSonota chkNinteiChosahyoSonota
     */
    @JsonProperty("chkNinteiChosahyoSonota")
    public void setChkNinteiChosahyoSonota(CheckBoxList chkNinteiChosahyoSonota) {
        this.chkNinteiChosahyoSonota = chkNinteiChosahyoSonota;
    }

    // </editor-fold>
}
