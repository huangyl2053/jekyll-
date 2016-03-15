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
 * Haiben のクラスファイル 
 * 
 * @author 自動生成
 */
public class HaibenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHaiben")
    private ButtonDialog btnHaiben;
    @JsonProperty("radHaiben")
    private RadioButton radHaiben;
    @JsonProperty("HaibenShinseishoKanriNo")
    private RString HaibenShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHaiben
     * @return btnHaiben
     */
    @JsonProperty("btnHaiben")
    public ButtonDialog getBtnHaiben() {
        return btnHaiben;
    }

    /*
     * setbtnHaiben
     * @param btnHaiben btnHaiben
     */
    @JsonProperty("btnHaiben")
    public void setBtnHaiben(ButtonDialog btnHaiben) {
        this.btnHaiben = btnHaiben;
    }

    /*
     * getradHaiben
     * @return radHaiben
     */
    @JsonProperty("radHaiben")
    public RadioButton getRadHaiben() {
        return radHaiben;
    }

    /*
     * setradHaiben
     * @param radHaiben radHaiben
     */
    @JsonProperty("radHaiben")
    public void setRadHaiben(RadioButton radHaiben) {
        this.radHaiben = radHaiben;
    }

    /*
     * getHaibenShinseishoKanriNo
     * @return HaibenShinseishoKanriNo
     */
    @JsonProperty("HaibenShinseishoKanriNo")
    public RString getHaibenShinseishoKanriNo() {
        return HaibenShinseishoKanriNo;
    }

    /*
     * setHaibenShinseishoKanriNo
     * @param HaibenShinseishoKanriNo HaibenShinseishoKanriNo
     */
    @JsonProperty("HaibenShinseishoKanriNo")
    public void setHaibenShinseishoKanriNo(RString HaibenShinseishoKanriNo) {
        this.HaibenShinseishoKanriNo = HaibenShinseishoKanriNo;
    }

    // </editor-fold>
}
