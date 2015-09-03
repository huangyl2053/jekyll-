package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;
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
 * @author 自動生成
 */
public class IdoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
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
    @JsonProperty("radOkugaiHokou")
    public RadioButton getRadOkugaiHokou() {
        return radOkugaiHokou;
    }

    @JsonProperty("radOkugaiHokou")
    public void setRadOkugaiHokou(RadioButton radOkugaiHokou) {
        this.radOkugaiHokou=radOkugaiHokou;
    }

    @JsonProperty("radKurumaisuShiyo")
    public RadioButton getRadKurumaisuShiyo() {
        return radKurumaisuShiyo;
    }

    @JsonProperty("radKurumaisuShiyo")
    public void setRadKurumaisuShiyo(RadioButton radKurumaisuShiyo) {
        this.radKurumaisuShiyo=radKurumaisuShiyo;
    }

    @JsonProperty("chkHokohojoShiyo")
    public CheckBoxList getChkHokohojoShiyo() {
        return chkHokohojoShiyo;
    }

    @JsonProperty("chkHokohojoShiyo")
    public void setChkHokohojoShiyo(CheckBoxList chkHokohojoShiyo) {
        this.chkHokohojoShiyo=chkHokohojoShiyo;
    }

    // </editor-fold>
}
