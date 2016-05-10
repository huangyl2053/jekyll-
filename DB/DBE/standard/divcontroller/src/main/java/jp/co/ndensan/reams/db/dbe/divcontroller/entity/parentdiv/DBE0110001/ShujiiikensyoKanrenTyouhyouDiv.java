package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiikensyoKanrenTyouhyou のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiikensyoKanrenTyouhyouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChohyoHakkoType")
    private ChohyoHakkoTypeDiv ChohyoHakkoType;
    @JsonProperty("ShinseiHakko")
    private ShinseiHakkoDiv ShinseiHakko;
    @JsonProperty("NinteiChosaHakko")
    private NinteiChosaHakkoDiv NinteiChosaHakko;
    @JsonProperty("ShujiiIkenshoHakko")
    private ShujiiIkenshoHakkoDiv ShujiiIkenshoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChohyoHakkoType
     * @return ChohyoHakkoType
     */
    @JsonProperty("ChohyoHakkoType")
    public ChohyoHakkoTypeDiv getChohyoHakkoType() {
        return ChohyoHakkoType;
    }

    /*
     * setChohyoHakkoType
     * @param ChohyoHakkoType ChohyoHakkoType
     */
    @JsonProperty("ChohyoHakkoType")
    public void setChohyoHakkoType(ChohyoHakkoTypeDiv ChohyoHakkoType) {
        this.ChohyoHakkoType = ChohyoHakkoType;
    }

    /*
     * getShinseiHakko
     * @return ShinseiHakko
     */
    @JsonProperty("ShinseiHakko")
    public ShinseiHakkoDiv getShinseiHakko() {
        return ShinseiHakko;
    }

    /*
     * setShinseiHakko
     * @param ShinseiHakko ShinseiHakko
     */
    @JsonProperty("ShinseiHakko")
    public void setShinseiHakko(ShinseiHakkoDiv ShinseiHakko) {
        this.ShinseiHakko = ShinseiHakko;
    }

    /*
     * getNinteiChosaHakko
     * @return NinteiChosaHakko
     */
    @JsonProperty("NinteiChosaHakko")
    public NinteiChosaHakkoDiv getNinteiChosaHakko() {
        return NinteiChosaHakko;
    }

    /*
     * setNinteiChosaHakko
     * @param NinteiChosaHakko NinteiChosaHakko
     */
    @JsonProperty("NinteiChosaHakko")
    public void setNinteiChosaHakko(NinteiChosaHakkoDiv NinteiChosaHakko) {
        this.NinteiChosaHakko = NinteiChosaHakko;
    }

    /*
     * getShujiiIkenshoHakko
     * @return ShujiiIkenshoHakko
     */
    @JsonProperty("ShujiiIkenshoHakko")
    public ShujiiIkenshoHakkoDiv getShujiiIkenshoHakko() {
        return ShujiiIkenshoHakko;
    }

    /*
     * setShujiiIkenshoHakko
     * @param ShujiiIkenshoHakko ShujiiIkenshoHakko
     */
    @JsonProperty("ShujiiIkenshoHakko")
    public void setShujiiIkenshoHakko(ShujiiIkenshoHakkoDiv ShujiiIkenshoHakko) {
        this.ShujiiIkenshoHakko = ShujiiIkenshoHakko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChohyoHakkoType() {
        return this.getChohyoHakkoType().getRadChohyoHakkoType();
    }

    @JsonIgnore
    public void  setRadChohyoHakkoType(RadioButton radChohyoHakkoType) {
        this.getChohyoHakkoType().setRadChohyoHakkoType(radChohyoHakkoType);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsei() {
        return this.getShinseiHakko().getChkShinsei();
    }

    @JsonIgnore
    public void  setChkShinsei(CheckBoxList chkShinsei) {
        this.getShinseiHakko().setChkShinsei(chkShinsei);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosa() {
        return this.getNinteiChosaHakko().getChkNinteiChosa();
    }

    @JsonIgnore
    public void  setChkNinteiChosa(CheckBoxList chkNinteiChosa) {
        this.getNinteiChosaHakko().setChkNinteiChosa(chkNinteiChosa);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkensho() {
        return this.getShujiiIkenshoHakko().getChkShujiiIkensho();
    }

    @JsonIgnore
    public void  setChkShujiiIkensho(CheckBoxList chkShujiiIkensho) {
        this.getShujiiIkenshoHakko().setChkShujiiIkensho(chkShujiiIkensho);
    }

    // </editor-fold>
}
