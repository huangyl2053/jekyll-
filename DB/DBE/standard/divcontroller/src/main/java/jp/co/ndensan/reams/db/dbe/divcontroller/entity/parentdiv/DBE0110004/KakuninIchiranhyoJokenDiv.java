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
 * KakuninIchiranhyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KakuninIchiranhyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkKakuninIchiranhyo")
    private CheckBoxList chkKakuninIchiranhyo;
    @JsonProperty("radJoken2")
    private RadioButton radJoken2;
    @JsonProperty("txtShinsakai2")
    private TextBoxNum txtShinsakai2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkKakuninIchiranhyo
     * @return chkKakuninIchiranhyo
     */
    @JsonProperty("chkKakuninIchiranhyo")
    public CheckBoxList getChkKakuninIchiranhyo() {
        return chkKakuninIchiranhyo;
    }

    /*
     * setchkKakuninIchiranhyo
     * @param chkKakuninIchiranhyo chkKakuninIchiranhyo
     */
    @JsonProperty("chkKakuninIchiranhyo")
    public void setChkKakuninIchiranhyo(CheckBoxList chkKakuninIchiranhyo) {
        this.chkKakuninIchiranhyo = chkKakuninIchiranhyo;
    }

    /*
     * getradJoken2
     * @return radJoken2
     */
    @JsonProperty("radJoken2")
    public RadioButton getRadJoken2() {
        return radJoken2;
    }

    /*
     * setradJoken2
     * @param radJoken2 radJoken2
     */
    @JsonProperty("radJoken2")
    public void setRadJoken2(RadioButton radJoken2) {
        this.radJoken2 = radJoken2;
    }

    /*
     * gettxtShinsakai2
     * @return txtShinsakai2
     */
    @JsonProperty("txtShinsakai2")
    public TextBoxNum getTxtShinsakai2() {
        return txtShinsakai2;
    }

    /*
     * settxtShinsakai2
     * @param txtShinsakai2 txtShinsakai2
     */
    @JsonProperty("txtShinsakai2")
    public void setTxtShinsakai2(TextBoxNum txtShinsakai2) {
        this.txtShinsakai2 = txtShinsakai2;
    }

    // </editor-fold>
}
