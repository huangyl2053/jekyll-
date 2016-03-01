package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Senshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSenshin")
    private Button btnSenshin;
    @JsonProperty("radSenshin")
    private RadioButton radSenshin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSenshin
     * @return btnSenshin
     */
    @JsonProperty("btnSenshin")
    public Button getBtnSenshin() {
        return btnSenshin;
    }

    /*
     * setbtnSenshin
     * @param btnSenshin btnSenshin
     */
    @JsonProperty("btnSenshin")
    public void setBtnSenshin(Button btnSenshin) {
        this.btnSenshin = btnSenshin;
    }

    /*
     * getradSenshin
     * @return radSenshin
     */
    @JsonProperty("radSenshin")
    public RadioButton getRadSenshin() {
        return radSenshin;
    }

    /*
     * setradSenshin
     * @param radSenshin radSenshin
     */
    @JsonProperty("radSenshin")
    public void setRadSenshin(RadioButton radSenshin) {
        this.radSenshin = radSenshin;
    }

    // </editor-fold>
}
