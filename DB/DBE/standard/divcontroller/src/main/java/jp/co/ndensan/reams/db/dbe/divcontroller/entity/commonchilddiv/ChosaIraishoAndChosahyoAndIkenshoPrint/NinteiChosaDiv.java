package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteiChosa")
    private DataGrid<dgNinteiChosa_Row> dgNinteiChosa;
    @JsonProperty("NinteiChosaPrint")
    private NinteiChosaPrintDiv NinteiChosaPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgNinteiChosa
     * @return dgNinteiChosa
     */
    @JsonProperty("dgNinteiChosa")
    public DataGrid<dgNinteiChosa_Row> getDgNinteiChosa() {
        return dgNinteiChosa;
    }

    /*
     * setdgNinteiChosa
     * @param dgNinteiChosa dgNinteiChosa
     */
    @JsonProperty("dgNinteiChosa")
    public void setDgNinteiChosa(DataGrid<dgNinteiChosa_Row> dgNinteiChosa) {
        this.dgNinteiChosa = dgNinteiChosa;
    }

    /*
     * getNinteiChosaPrint
     * @return NinteiChosaPrint
     */
    @JsonProperty("NinteiChosaPrint")
    public NinteiChosaPrintDiv getNinteiChosaPrint() {
        return NinteiChosaPrint;
    }

    /*
     * setNinteiChosaPrint
     * @param NinteiChosaPrint NinteiChosaPrint
     */
    @JsonProperty("NinteiChosaPrint")
    public void setNinteiChosaPrint(NinteiChosaPrintDiv NinteiChosaPrint) {
        this.NinteiChosaPrint = NinteiChosaPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChk() {
        return this.getNinteiChosaPrint().getChk();
    }

    @JsonIgnore
    public void  setChk(CheckBoxList chk) {
        this.getNinteiChosaPrint().setChk(chk);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyo() {
        return this.getNinteiChosaPrint().getChkChosahyo();
    }

    @JsonIgnore
    public void  setChkChosahyo(CheckBoxList chkChosahyo) {
        this.getNinteiChosaPrint().setChkChosahyo(chkChosahyo);
    }

    @JsonIgnore
    public CheckBoxList getChkOcrChosahyo() {
        return this.getNinteiChosaPrint().getChkOcrChosahyo();
    }

    @JsonIgnore
    public void  setChkOcrChosahyo(CheckBoxList chkOcrChosahyo) {
        this.getNinteiChosaPrint().setChkOcrChosahyo(chkOcrChosahyo);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyo2() {
        return this.getNinteiChosaPrint().getChkChosahyo2();
    }

    @JsonIgnore
    public void  setChkChosahyo2(CheckBoxList chkChosahyo2) {
        this.getNinteiChosaPrint().setChkChosahyo2(chkChosahyo2);
    }

    // </editor-fold>
}
