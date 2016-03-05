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
 * Hainyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HainyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHainyo")
    private ButtonDialog btnHainyo;
    @JsonProperty("radHainyo")
    private RadioButton radHainyo;
    @JsonProperty("HainyoShinseishoKanriNo")
    private RString HainyoShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHainyo
     * @return btnHainyo
     */
    @JsonProperty("btnHainyo")
    public ButtonDialog getBtnHainyo() {
        return btnHainyo;
    }

    /*
     * setbtnHainyo
     * @param btnHainyo btnHainyo
     */
    @JsonProperty("btnHainyo")
    public void setBtnHainyo(ButtonDialog btnHainyo) {
        this.btnHainyo = btnHainyo;
    }

    /*
     * getradHainyo
     * @return radHainyo
     */
    @JsonProperty("radHainyo")
    public RadioButton getRadHainyo() {
        return radHainyo;
    }

    /*
     * setradHainyo
     * @param radHainyo radHainyo
     */
    @JsonProperty("radHainyo")
    public void setRadHainyo(RadioButton radHainyo) {
        this.radHainyo = radHainyo;
    }

    /*
     * getHainyoShinseishoKanriNo
     * @return HainyoShinseishoKanriNo
     */
    @JsonProperty("HainyoShinseishoKanriNo")
    public RString getHainyoShinseishoKanriNo() {
        return HainyoShinseishoKanriNo;
    }

    /*
     * setHainyoShinseishoKanriNo
     * @param HainyoShinseishoKanriNo HainyoShinseishoKanriNo
     */
    @JsonProperty("HainyoShinseishoKanriNo")
    public void setHainyoShinseishoKanriNo(RString HainyoShinseishoKanriNo) {
        this.HainyoShinseishoKanriNo = HainyoShinseishoKanriNo;
    }

    // </editor-fold>
}
