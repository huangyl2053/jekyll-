package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SakuseiIraiHenkoushaIchiranhyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class SakuseiIraiHenkoushaIchiranhyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkSakuseiIraiHenkoushaIchiranhyoJoken")
    private CheckBoxList chkSakuseiIraiHenkoushaIchiranhyoJoken;
    @JsonProperty("txtShinseiYMD4")
    private TextBoxDateRange txtShinseiYMD4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkSakuseiIraiHenkoushaIchiranhyoJoken
     * @return chkSakuseiIraiHenkoushaIchiranhyoJoken
     */
    @JsonProperty("chkSakuseiIraiHenkoushaIchiranhyoJoken")
    public CheckBoxList getChkSakuseiIraiHenkoushaIchiranhyoJoken() {
        return chkSakuseiIraiHenkoushaIchiranhyoJoken;
    }

    /*
     * setchkSakuseiIraiHenkoushaIchiranhyoJoken
     * @param chkSakuseiIraiHenkoushaIchiranhyoJoken chkSakuseiIraiHenkoushaIchiranhyoJoken
     */
    @JsonProperty("chkSakuseiIraiHenkoushaIchiranhyoJoken")
    public void setChkSakuseiIraiHenkoushaIchiranhyoJoken(CheckBoxList chkSakuseiIraiHenkoushaIchiranhyoJoken) {
        this.chkSakuseiIraiHenkoushaIchiranhyoJoken = chkSakuseiIraiHenkoushaIchiranhyoJoken;
    }

    /*
     * gettxtShinseiYMD4
     * @return txtShinseiYMD4
     */
    @JsonProperty("txtShinseiYMD4")
    public TextBoxDateRange getTxtShinseiYMD4() {
        return txtShinseiYMD4;
    }

    /*
     * settxtShinseiYMD4
     * @param txtShinseiYMD4 txtShinseiYMD4
     */
    @JsonProperty("txtShinseiYMD4")
    public void setTxtShinseiYMD4(TextBoxDateRange txtShinseiYMD4) {
        this.txtShinseiYMD4 = txtShinseiYMD4;
    }

    // </editor-fold>
}
