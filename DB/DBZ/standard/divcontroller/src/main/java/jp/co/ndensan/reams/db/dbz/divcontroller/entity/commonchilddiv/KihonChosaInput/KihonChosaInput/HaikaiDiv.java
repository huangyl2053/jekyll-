package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Haikai のクラスファイル 
 * 
 * @author 自動生成
 */
public class HaikaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHaikai")
    private ButtonDialog btnHaikai;
    @JsonProperty("radHaikai")
    private RadioButton radHaikai;
    @JsonProperty("HaikaiShinseishoKanriNo")
    private RString HaikaiShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHaikai
     * @return btnHaikai
     */
    @JsonProperty("btnHaikai")
    public ButtonDialog getBtnHaikai() {
        return btnHaikai;
    }

    /*
     * setbtnHaikai
     * @param btnHaikai btnHaikai
     */
    @JsonProperty("btnHaikai")
    public void setBtnHaikai(ButtonDialog btnHaikai) {
        this.btnHaikai = btnHaikai;
    }

    /*
     * getradHaikai
     * @return radHaikai
     */
    @JsonProperty("radHaikai")
    public RadioButton getRadHaikai() {
        return radHaikai;
    }

    /*
     * setradHaikai
     * @param radHaikai radHaikai
     */
    @JsonProperty("radHaikai")
    public void setRadHaikai(RadioButton radHaikai) {
        this.radHaikai = radHaikai;
    }

    /*
     * getHaikaiShinseishoKanriNo
     * @return HaikaiShinseishoKanriNo
     */
    @JsonProperty("HaikaiShinseishoKanriNo")
    public RString getHaikaiShinseishoKanriNo() {
        return HaikaiShinseishoKanriNo;
    }

    /*
     * setHaikaiShinseishoKanriNo
     * @param HaikaiShinseishoKanriNo HaikaiShinseishoKanriNo
     */
    @JsonProperty("HaikaiShinseishoKanriNo")
    public void setHaikaiShinseishoKanriNo(RString HaikaiShinseishoKanriNo) {
        this.HaikaiShinseishoKanriNo = HaikaiShinseishoKanriNo;
    }

    // </editor-fold>
}
