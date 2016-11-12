package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NiteiChosaSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class NiteiChosaSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-04_20-07-38">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinteichosaDesign")
    private CheckBoxList chkNinteichosaDesign;
    @JsonProperty("chkNinteichosaOcr")
    private CheckBoxList chkNinteichosaOcr;
    @JsonProperty("chkSaiCheck")
    private CheckBoxList chkSaiCheck;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkNinteichosaDesign
     * @return chkNinteichosaDesign
     */
    @JsonProperty("chkNinteichosaDesign")
    public CheckBoxList getChkNinteichosaDesign() {
        return chkNinteichosaDesign;
    }

    /*
     * setchkNinteichosaDesign
     * @param chkNinteichosaDesign chkNinteichosaDesign
     */
    @JsonProperty("chkNinteichosaDesign")
    public void setChkNinteichosaDesign(CheckBoxList chkNinteichosaDesign) {
        this.chkNinteichosaDesign = chkNinteichosaDesign;
    }

    /*
     * getchkNinteichosaOcr
     * @return chkNinteichosaOcr
     */
    @JsonProperty("chkNinteichosaOcr")
    public CheckBoxList getChkNinteichosaOcr() {
        return chkNinteichosaOcr;
    }

    /*
     * setchkNinteichosaOcr
     * @param chkNinteichosaOcr chkNinteichosaOcr
     */
    @JsonProperty("chkNinteichosaOcr")
    public void setChkNinteichosaOcr(CheckBoxList chkNinteichosaOcr) {
        this.chkNinteichosaOcr = chkNinteichosaOcr;
    }

    /*
     * getchkSaiCheck
     * @return chkSaiCheck
     */
    @JsonProperty("chkSaiCheck")
    public CheckBoxList getChkSaiCheck() {
        return chkSaiCheck;
    }

    /*
     * setchkSaiCheck
     * @param chkSaiCheck chkSaiCheck
     */
    @JsonProperty("chkSaiCheck")
    public void setChkSaiCheck(CheckBoxList chkSaiCheck) {
        this.chkSaiCheck = chkSaiCheck;
    }

    // </editor-fold>
}
