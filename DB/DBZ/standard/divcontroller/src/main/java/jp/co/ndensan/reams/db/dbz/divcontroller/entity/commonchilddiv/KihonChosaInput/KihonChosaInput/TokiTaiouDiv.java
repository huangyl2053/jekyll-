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
 * TokiTaiou のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokiTaiouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTokiTaiou")
    private ButtonDialog btnTokiTaiou;
    @JsonProperty("chkTokiTaiou")
    private CheckBoxList chkTokiTaiou;
    @JsonProperty("TokiTaiouShinseishoKanriNo")
    private RString TokiTaiouShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTokiTaiou
     * @return btnTokiTaiou
     */
    @JsonProperty("btnTokiTaiou")
    public ButtonDialog getBtnTokiTaiou() {
        return btnTokiTaiou;
    }

    /*
     * setbtnTokiTaiou
     * @param btnTokiTaiou btnTokiTaiou
     */
    @JsonProperty("btnTokiTaiou")
    public void setBtnTokiTaiou(ButtonDialog btnTokiTaiou) {
        this.btnTokiTaiou = btnTokiTaiou;
    }

    /*
     * getchkTokiTaiou
     * @return chkTokiTaiou
     */
    @JsonProperty("chkTokiTaiou")
    public CheckBoxList getChkTokiTaiou() {
        return chkTokiTaiou;
    }

    /*
     * setchkTokiTaiou
     * @param chkTokiTaiou chkTokiTaiou
     */
    @JsonProperty("chkTokiTaiou")
    public void setChkTokiTaiou(CheckBoxList chkTokiTaiou) {
        this.chkTokiTaiou = chkTokiTaiou;
    }

    /*
     * getTokiTaiouShinseishoKanriNo
     * @return TokiTaiouShinseishoKanriNo
     */
    @JsonProperty("TokiTaiouShinseishoKanriNo")
    public RString getTokiTaiouShinseishoKanriNo() {
        return TokiTaiouShinseishoKanriNo;
    }

    /*
     * setTokiTaiouShinseishoKanriNo
     * @param TokiTaiouShinseishoKanriNo TokiTaiouShinseishoKanriNo
     */
    @JsonProperty("TokiTaiouShinseishoKanriNo")
    public void setTokiTaiouShinseishoKanriNo(RString TokiTaiouShinseishoKanriNo) {
        this.TokiTaiouShinseishoKanriNo = TokiTaiouShinseishoKanriNo;
    }

    // </editor-fold>
}
