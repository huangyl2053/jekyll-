package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlForDesign のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlForDesignDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShinseijiShinseiKubun")
    private DropDownList ddlShinseijiShinseiKubun;
    @JsonProperty("chkSeibetsu")
    private CheckBoxList chkSeibetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShinseijiShinseiKubun
     * @return ddlShinseijiShinseiKubun
     */
    @JsonProperty("ddlShinseijiShinseiKubun")
    public DropDownList getDdlShinseijiShinseiKubun() {
        return ddlShinseijiShinseiKubun;
    }

    /*
     * setddlShinseijiShinseiKubun
     * @param ddlShinseijiShinseiKubun ddlShinseijiShinseiKubun
     */
    @JsonProperty("ddlShinseijiShinseiKubun")
    public void setDdlShinseijiShinseiKubun(DropDownList ddlShinseijiShinseiKubun) {
        this.ddlShinseijiShinseiKubun = ddlShinseijiShinseiKubun;
    }

    /*
     * getchkSeibetsu
     * @return chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public CheckBoxList getChkSeibetsu() {
        return chkSeibetsu;
    }

    /*
     * setchkSeibetsu
     * @param chkSeibetsu chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public void setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.chkSeibetsu = chkSeibetsu;
    }

    // </editor-fold>
}
