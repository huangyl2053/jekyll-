package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Koshuku のクラスファイル
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KoshukuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKoshuku")
    private ButtonDialog btnKoshuku;
    @JsonProperty("chkKoshuku")
    private CheckBoxList chkKoshuku;
    @JsonProperty("KoshukuShinseishoKanriNo")
    private RString KoshukuShinseishoKanriNo;
    @JsonProperty("isKoshukuSelected")
    private RString isKoshukuSelected;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKoshuku
     * @return btnKoshuku
     */
    @JsonProperty("btnKoshuku")
    public ButtonDialog getBtnKoshuku() {
        return btnKoshuku;
    }

    /*
     * setbtnKoshuku
     * @param btnKoshuku btnKoshuku
     */
    @JsonProperty("btnKoshuku")
    public void setBtnKoshuku(ButtonDialog btnKoshuku) {
        this.btnKoshuku = btnKoshuku;
    }

    /*
     * getchkKoshuku
     * @return chkKoshuku
     */
    @JsonProperty("chkKoshuku")
    public CheckBoxList getChkKoshuku() {
        return chkKoshuku;
    }

    /*
     * setchkKoshuku
     * @param chkKoshuku chkKoshuku
     */
    @JsonProperty("chkKoshuku")
    public void setChkKoshuku(CheckBoxList chkKoshuku) {
        this.chkKoshuku = chkKoshuku;
    }

    /*
     * getKoshukuShinseishoKanriNo
     * @return KoshukuShinseishoKanriNo
     */
    @JsonProperty("KoshukuShinseishoKanriNo")
    public RString getKoshukuShinseishoKanriNo() {
        return KoshukuShinseishoKanriNo;
    }

    /*
     * setKoshukuShinseishoKanriNo
     * @param KoshukuShinseishoKanriNo KoshukuShinseishoKanriNo
     */
    @JsonProperty("KoshukuShinseishoKanriNo")
    public void setKoshukuShinseishoKanriNo(RString KoshukuShinseishoKanriNo) {
        this.KoshukuShinseishoKanriNo = KoshukuShinseishoKanriNo;
    }

    /*
     * getisKoshukuSelected
     * @return isKoshukuSelected
     */
    @JsonProperty("isKoshukuSelected")
    public RString getIsKoshukuSelected() {
        return isKoshukuSelected;
    }

    /*
     * setisKoshukuSelected
     * @param isKoshukuSelected isKoshukuSelected
     */
    @JsonProperty("isKoshukuSelected")
    public void setIsKoshukuSelected(RString isKoshukuSelected) {
        this.isKoshukuSelected = isKoshukuSelected;
    }

    // </editor-fold>
}
