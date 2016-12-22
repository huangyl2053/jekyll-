package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
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
 * ShujiiIkenshoInsatsuChohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoInsatsuChohyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShujiiIkenshoSakuseiIrai")
    private CheckBoxList chkShujiiIkenshoSakuseiIrai;
    @JsonProperty("chkShujiiIkenshoSakuseiSeikyu")
    private CheckBoxList chkShujiiIkenshoSakuseiSeikyu;
    @JsonProperty("chkShujiiIkenshoShinseiTani")
    private CheckBoxList chkShujiiIkenshoShinseiTani;
    @JsonProperty("ShujiiIkenshoChecks")
    private ShujiiIkenshoChecksDiv ShujiiIkenshoChecks;
    @JsonProperty("Chkikenshiiraihakko")
    private CheckBoxList Chkikenshiiraihakko;
    @JsonProperty("ChkikenshiiraiRireki")
    private CheckBoxList ChkikenshiiraiRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShujiiIkenshoSakuseiIrai
     * @return chkShujiiIkenshoSakuseiIrai
     */
    @JsonProperty("chkShujiiIkenshoSakuseiIrai")
    public CheckBoxList getChkShujiiIkenshoSakuseiIrai() {
        return chkShujiiIkenshoSakuseiIrai;
    }

    /*
     * setchkShujiiIkenshoSakuseiIrai
     * @param chkShujiiIkenshoSakuseiIrai chkShujiiIkenshoSakuseiIrai
     */
    @JsonProperty("chkShujiiIkenshoSakuseiIrai")
    public void setChkShujiiIkenshoSakuseiIrai(CheckBoxList chkShujiiIkenshoSakuseiIrai) {
        this.chkShujiiIkenshoSakuseiIrai = chkShujiiIkenshoSakuseiIrai;
    }

    /*
     * getchkShujiiIkenshoSakuseiSeikyu
     * @return chkShujiiIkenshoSakuseiSeikyu
     */
    @JsonProperty("chkShujiiIkenshoSakuseiSeikyu")
    public CheckBoxList getChkShujiiIkenshoSakuseiSeikyu() {
        return chkShujiiIkenshoSakuseiSeikyu;
    }

    /*
     * setchkShujiiIkenshoSakuseiSeikyu
     * @param chkShujiiIkenshoSakuseiSeikyu chkShujiiIkenshoSakuseiSeikyu
     */
    @JsonProperty("chkShujiiIkenshoSakuseiSeikyu")
    public void setChkShujiiIkenshoSakuseiSeikyu(CheckBoxList chkShujiiIkenshoSakuseiSeikyu) {
        this.chkShujiiIkenshoSakuseiSeikyu = chkShujiiIkenshoSakuseiSeikyu;
    }

    /*
     * getchkShujiiIkenshoShinseiTani
     * @return chkShujiiIkenshoShinseiTani
     */
    @JsonProperty("chkShujiiIkenshoShinseiTani")
    public CheckBoxList getChkShujiiIkenshoShinseiTani() {
        return chkShujiiIkenshoShinseiTani;
    }

    /*
     * setchkShujiiIkenshoShinseiTani
     * @param chkShujiiIkenshoShinseiTani chkShujiiIkenshoShinseiTani
     */
    @JsonProperty("chkShujiiIkenshoShinseiTani")
    public void setChkShujiiIkenshoShinseiTani(CheckBoxList chkShujiiIkenshoShinseiTani) {
        this.chkShujiiIkenshoShinseiTani = chkShujiiIkenshoShinseiTani;
    }

    /*
     * getShujiiIkenshoChecks
     * @return ShujiiIkenshoChecks
     */
    @JsonProperty("ShujiiIkenshoChecks")
    public ShujiiIkenshoChecksDiv getShujiiIkenshoChecks() {
        return ShujiiIkenshoChecks;
    }

    /*
     * setShujiiIkenshoChecks
     * @param ShujiiIkenshoChecks ShujiiIkenshoChecks
     */
    @JsonProperty("ShujiiIkenshoChecks")
    public void setShujiiIkenshoChecks(ShujiiIkenshoChecksDiv ShujiiIkenshoChecks) {
        this.ShujiiIkenshoChecks = ShujiiIkenshoChecks;
    }

    /*
     * getChkikenshiiraihakko
     * @return Chkikenshiiraihakko
     */
    @JsonProperty("Chkikenshiiraihakko")
    public CheckBoxList getChkikenshiiraihakko() {
        return Chkikenshiiraihakko;
    }

    /*
     * setChkikenshiiraihakko
     * @param Chkikenshiiraihakko Chkikenshiiraihakko
     */
    @JsonProperty("Chkikenshiiraihakko")
    public void setChkikenshiiraihakko(CheckBoxList Chkikenshiiraihakko) {
        this.Chkikenshiiraihakko = Chkikenshiiraihakko;
    }

    /*
     * getChkikenshiiraiRireki
     * @return ChkikenshiiraiRireki
     */
    @JsonProperty("ChkikenshiiraiRireki")
    public CheckBoxList getChkikenshiiraiRireki() {
        return ChkikenshiiraiRireki;
    }

    /*
     * setChkikenshiiraiRireki
     * @param ChkikenshiiraiRireki ChkikenshiiraiRireki
     */
    @JsonProperty("ChkikenshiiraiRireki")
    public void setChkikenshiiraiRireki(CheckBoxList ChkikenshiiraiRireki) {
        this.ChkikenshiiraiRireki = ChkikenshiiraiRireki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoSakuseiIraisho() {
        return this.getShujiiIkenshoChecks().getChkShujiiIkenshoSakuseiIraisho();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoSakuseiIraisho(CheckBoxList chkShujiiIkenshoSakuseiIraisho) {
        this.getShujiiIkenshoChecks().setChkShujiiIkenshoSakuseiIraisho(chkShujiiIkenshoSakuseiIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiIkenshoyoshi() {
        return this.getShujiiIkenshoChecks().getChkShujiIkenshoyoshi();
    }

    @JsonIgnore
    public void  setChkShujiIkenshoyoshi(CheckBoxList chkShujiIkenshoyoshi) {
        this.getShujiiIkenshoChecks().setChkShujiIkenshoyoshi(chkShujiIkenshoyoshi);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoyoshiOcr() {
        return this.getShujiiIkenshoChecks().getChkShujiiIkenshoyoshiOcr();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoyoshiOcr(CheckBoxList chkShujiiIkenshoyoshiOcr) {
        this.getShujiiIkenshoChecks().setChkShujiiIkenshoyoshiOcr(chkShujiiIkenshoyoshiOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoyoshiDesign() {
        return this.getShujiiIkenshoChecks().getChkShujiiIkenshoyoshiDesign();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoyoshiDesign(CheckBoxList chkShujiiIkenshoyoshiDesign) {
        this.getShujiiIkenshoChecks().setChkShujiiIkenshoyoshiDesign(chkShujiiIkenshoyoshiDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoSakuseiryoSeikyusho() {
        return this.getShujiiIkenshoChecks().getChkShujiiIkenshoSakuseiryoSeikyusho();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoSakuseiryoSeikyusho(CheckBoxList chkShujiiIkenshoSakuseiryoSeikyusho) {
        this.getShujiiIkenshoChecks().setChkShujiiIkenshoSakuseiryoSeikyusho(chkShujiiIkenshoSakuseiryoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkShindanMeireishoAndTeishutsuIraisho() {
        return this.getShujiiIkenshoChecks().getChkShindanMeireishoAndTeishutsuIraisho();
    }

    @JsonIgnore
    public void  setChkShindanMeireishoAndTeishutsuIraisho(CheckBoxList chkShindanMeireishoAndTeishutsuIraisho) {
        this.getShujiiIkenshoChecks().setChkShindanMeireishoAndTeishutsuIraisho(chkShindanMeireishoAndTeishutsuIraisho);
    }

    // </editor-fold>
}
