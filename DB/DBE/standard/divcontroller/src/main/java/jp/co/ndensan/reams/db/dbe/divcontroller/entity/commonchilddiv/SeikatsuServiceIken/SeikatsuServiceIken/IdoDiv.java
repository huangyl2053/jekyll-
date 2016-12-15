package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ido のクラスファイル 
 * 
 * @reamsid_L DBE-3000-110 wangkun
 */
public class IdoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radOkugaiHokou")
    private RadioButton radOkugaiHokou;
    @JsonProperty("radKurumaisuShiyo")
    private RadioButton radKurumaisuShiyo;
    @JsonProperty("chkHokohojoShiyo")
    private CheckBoxList chkHokohojoShiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradOkugaiHokou
     * @return radOkugaiHokou
     */
    @JsonProperty("radOkugaiHokou")
    public RadioButton getRadOkugaiHokou() {
        return radOkugaiHokou;
    }

    /*
     * setradOkugaiHokou
     * @param radOkugaiHokou radOkugaiHokou
     */
    @JsonProperty("radOkugaiHokou")
    public void setRadOkugaiHokou(RadioButton radOkugaiHokou) {
        this.radOkugaiHokou = radOkugaiHokou;
    }

    /*
     * getradKurumaisuShiyo
     * @return radKurumaisuShiyo
     */
    @JsonProperty("radKurumaisuShiyo")
    public RadioButton getRadKurumaisuShiyo() {
        return radKurumaisuShiyo;
    }

    /*
     * setradKurumaisuShiyo
     * @param radKurumaisuShiyo radKurumaisuShiyo
     */
    @JsonProperty("radKurumaisuShiyo")
    public void setRadKurumaisuShiyo(RadioButton radKurumaisuShiyo) {
        this.radKurumaisuShiyo = radKurumaisuShiyo;
    }

    /*
     * getchkHokohojoShiyo
     * @return chkHokohojoShiyo
     */
    @JsonProperty("chkHokohojoShiyo")
    public CheckBoxList getChkHokohojoShiyo() {
        return chkHokohojoShiyo;
    }

    /*
     * setchkHokohojoShiyo
     * @param chkHokohojoShiyo chkHokohojoShiyo
     */
    @JsonProperty("chkHokohojoShiyo")
    public void setChkHokohojoShiyo(CheckBoxList chkHokohojoShiyo) {
        this.chkHokohojoShiyo = chkHokohojoShiyo;
    }

    // </editor-fold>
}
