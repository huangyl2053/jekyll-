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
 * ShogaiKoreisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaiKoreishaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShogaiKoreisha")
    private ButtonDialog btnShogaiKoreisha;
    @JsonProperty("radShogaiKoreisha")
    private RadioButton radShogaiKoreisha;
    @JsonProperty("ShogaiKoreishaShinseishoKanriNo")
    private RString ShogaiKoreishaShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShogaiKoreisha
     * @return btnShogaiKoreisha
     */
    @JsonProperty("btnShogaiKoreisha")
    public ButtonDialog getBtnShogaiKoreisha() {
        return btnShogaiKoreisha;
    }

    /*
     * setbtnShogaiKoreisha
     * @param btnShogaiKoreisha btnShogaiKoreisha
     */
    @JsonProperty("btnShogaiKoreisha")
    public void setBtnShogaiKoreisha(ButtonDialog btnShogaiKoreisha) {
        this.btnShogaiKoreisha = btnShogaiKoreisha;
    }

    /*
     * getradShogaiKoreisha
     * @return radShogaiKoreisha
     */
    @JsonProperty("radShogaiKoreisha")
    public RadioButton getRadShogaiKoreisha() {
        return radShogaiKoreisha;
    }

    /*
     * setradShogaiKoreisha
     * @param radShogaiKoreisha radShogaiKoreisha
     */
    @JsonProperty("radShogaiKoreisha")
    public void setRadShogaiKoreisha(RadioButton radShogaiKoreisha) {
        this.radShogaiKoreisha = radShogaiKoreisha;
    }

    /*
     * getShogaiKoreishaShinseishoKanriNo
     * @return ShogaiKoreishaShinseishoKanriNo
     */
    @JsonProperty("ShogaiKoreishaShinseishoKanriNo")
    public RString getShogaiKoreishaShinseishoKanriNo() {
        return ShogaiKoreishaShinseishoKanriNo;
    }

    /*
     * setShogaiKoreishaShinseishoKanriNo
     * @param ShogaiKoreishaShinseishoKanriNo ShogaiKoreishaShinseishoKanriNo
     */
    @JsonProperty("ShogaiKoreishaShinseishoKanriNo")
    public void setShogaiKoreishaShinseishoKanriNo(RString ShogaiKoreishaShinseishoKanriNo) {
        this.ShogaiKoreishaShinseishoKanriNo = ShogaiKoreishaShinseishoKanriNo;
    }

    // </editor-fold>
}
