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
 * Idou のクラスファイル 
 * 
 * @author 自動生成
 */
public class IdouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIdou")
    private ButtonDialog btnIdou;
    @JsonProperty("radIdou")
    private RadioButton radIdou;
    @JsonProperty("IdouShinseishoKanriNo")
    private RString IdouShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIdou
     * @return btnIdou
     */
    @JsonProperty("btnIdou")
    public ButtonDialog getBtnIdou() {
        return btnIdou;
    }

    /*
     * setbtnIdou
     * @param btnIdou btnIdou
     */
    @JsonProperty("btnIdou")
    public void setBtnIdou(ButtonDialog btnIdou) {
        this.btnIdou = btnIdou;
    }

    /*
     * getradIdou
     * @return radIdou
     */
    @JsonProperty("radIdou")
    public RadioButton getRadIdou() {
        return radIdou;
    }

    /*
     * setradIdou
     * @param radIdou radIdou
     */
    @JsonProperty("radIdou")
    public void setRadIdou(RadioButton radIdou) {
        this.radIdou = radIdou;
    }

    /*
     * getIdouShinseishoKanriNo
     * @return IdouShinseishoKanriNo
     */
    @JsonProperty("IdouShinseishoKanriNo")
    public RString getIdouShinseishoKanriNo() {
        return IdouShinseishoKanriNo;
    }

    /*
     * setIdouShinseishoKanriNo
     * @param IdouShinseishoKanriNo IdouShinseishoKanriNo
     */
    @JsonProperty("IdouShinseishoKanriNo")
    public void setIdouShinseishoKanriNo(RString IdouShinseishoKanriNo) {
        this.IdouShinseishoKanriNo = IdouShinseishoKanriNo;
    }

    // </editor-fold>
}
