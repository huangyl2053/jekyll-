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
 * ChosahyoSelectItemsTwo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosahyoSelectItemsTwoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkChosaDesign")
    private CheckBoxList chkChosaDesign;
    @JsonProperty("chkTokkiDesign")
    private CheckBoxList chkTokkiDesign;
    @JsonProperty("chkSaiCheck")
    private CheckBoxList chkSaiCheck;
    @JsonProperty("chkGaikyoTokki")
    private CheckBoxList chkGaikyoTokki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkChosaDesign
     * @return chkChosaDesign
     */
    @JsonProperty("chkChosaDesign")
    public CheckBoxList getChkChosaDesign() {
        return chkChosaDesign;
    }

    /*
     * setchkChosaDesign
     * @param chkChosaDesign chkChosaDesign
     */
    @JsonProperty("chkChosaDesign")
    public void setChkChosaDesign(CheckBoxList chkChosaDesign) {
        this.chkChosaDesign = chkChosaDesign;
    }

    /*
     * getchkTokkiDesign
     * @return chkTokkiDesign
     */
    @JsonProperty("chkTokkiDesign")
    public CheckBoxList getChkTokkiDesign() {
        return chkTokkiDesign;
    }

    /*
     * setchkTokkiDesign
     * @param chkTokkiDesign chkTokkiDesign
     */
    @JsonProperty("chkTokkiDesign")
    public void setChkTokkiDesign(CheckBoxList chkTokkiDesign) {
        this.chkTokkiDesign = chkTokkiDesign;
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

    /*
     * getchkGaikyoTokki
     * @return chkGaikyoTokki
     */
    @JsonProperty("chkGaikyoTokki")
    public CheckBoxList getChkGaikyoTokki() {
        return chkGaikyoTokki;
    }

    /*
     * setchkGaikyoTokki
     * @param chkGaikyoTokki chkGaikyoTokki
     */
    @JsonProperty("chkGaikyoTokki")
    public void setChkGaikyoTokki(CheckBoxList chkGaikyoTokki) {
        this.chkGaikyoTokki = chkGaikyoTokki;
    }

    // </editor-fold>
}
