package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;
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
 * Ochituki のクラスファイル 
 * 
 * @author 自動生成
 */
public class OchitukiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOchituki")
    private ButtonDialog btnOchituki;
    @JsonProperty("radOchituki")
    private RadioButton radOchituki;
    @JsonProperty("OchitukiShinseishoKanriNo")
    private RString OchitukiShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnOchituki
     * @return btnOchituki
     */
    @JsonProperty("btnOchituki")
    public ButtonDialog getBtnOchituki() {
        return btnOchituki;
    }

    /*
     * setbtnOchituki
     * @param btnOchituki btnOchituki
     */
    @JsonProperty("btnOchituki")
    public void setBtnOchituki(ButtonDialog btnOchituki) {
        this.btnOchituki = btnOchituki;
    }

    /*
     * getradOchituki
     * @return radOchituki
     */
    @JsonProperty("radOchituki")
    public RadioButton getRadOchituki() {
        return radOchituki;
    }

    /*
     * setradOchituki
     * @param radOchituki radOchituki
     */
    @JsonProperty("radOchituki")
    public void setRadOchituki(RadioButton radOchituki) {
        this.radOchituki = radOchituki;
    }

    /*
     * getOchitukiShinseishoKanriNo
     * @return OchitukiShinseishoKanriNo
     */
    @JsonProperty("OchitukiShinseishoKanriNo")
    public RString getOchitukiShinseishoKanriNo() {
        return OchitukiShinseishoKanriNo;
    }

    /*
     * setOchitukiShinseishoKanriNo
     * @param OchitukiShinseishoKanriNo OchitukiShinseishoKanriNo
     */
    @JsonProperty("OchitukiShinseishoKanriNo")
    public void setOchitukiShinseishoKanriNo(RString OchitukiShinseishoKanriNo) {
        this.OchitukiShinseishoKanriNo = OchitukiShinseishoKanriNo;
    }

    // </editor-fold>
}
