package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;
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
 * OkiAgari のクラスファイル 
 * 
 * @author 自動生成
 */
public class OkiAgariDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOkiAgari")
    private ButtonDialog btnOkiAgari;
    @JsonProperty("radOkiAgari")
    private RadioButton radOkiAgari;
    @JsonProperty("OkiAgariShinseishoKanriNo")
    private RString OkiAgariShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnOkiAgari
     * @return btnOkiAgari
     */
    @JsonProperty("btnOkiAgari")
    public ButtonDialog getBtnOkiAgari() {
        return btnOkiAgari;
    }

    /*
     * setbtnOkiAgari
     * @param btnOkiAgari btnOkiAgari
     */
    @JsonProperty("btnOkiAgari")
    public void setBtnOkiAgari(ButtonDialog btnOkiAgari) {
        this.btnOkiAgari = btnOkiAgari;
    }

    /*
     * getradOkiAgari
     * @return radOkiAgari
     */
    @JsonProperty("radOkiAgari")
    public RadioButton getRadOkiAgari() {
        return radOkiAgari;
    }

    /*
     * setradOkiAgari
     * @param radOkiAgari radOkiAgari
     */
    @JsonProperty("radOkiAgari")
    public void setRadOkiAgari(RadioButton radOkiAgari) {
        this.radOkiAgari = radOkiAgari;
    }

    /*
     * getOkiAgariShinseishoKanriNo
     * @return OkiAgariShinseishoKanriNo
     */
    @JsonProperty("OkiAgariShinseishoKanriNo")
    public RString getOkiAgariShinseishoKanriNo() {
        return OkiAgariShinseishoKanriNo;
    }

    /*
     * setOkiAgariShinseishoKanriNo
     * @param OkiAgariShinseishoKanriNo OkiAgariShinseishoKanriNo
     */
    @JsonProperty("OkiAgariShinseishoKanriNo")
    public void setOkiAgariShinseishoKanriNo(RString OkiAgariShinseishoKanriNo) {
        this.OkiAgariShinseishoKanriNo = OkiAgariShinseishoKanriNo;
    }

    // </editor-fold>
}
