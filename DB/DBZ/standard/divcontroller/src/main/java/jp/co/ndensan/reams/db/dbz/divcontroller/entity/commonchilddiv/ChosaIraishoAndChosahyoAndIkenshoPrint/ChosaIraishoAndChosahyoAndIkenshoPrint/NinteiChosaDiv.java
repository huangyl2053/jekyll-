package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-15_14-55-30">
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
    public CheckBoxList getChkIraisho() {
        return this.getNinteiChosaPrint().getChkIraisho();
    }

    @JsonIgnore
    public void  setChkIraisho(CheckBoxList chkIraisho) {
        this.getNinteiChosaPrint().setChkIraisho(chkIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoKatamen() {
        return this.getNinteiChosaPrint().getChkChosahyoKatamen();
    }

    @JsonIgnore
    public void  setChkChosahyoKatamen(CheckBoxList chkChosahyoKatamen) {
        this.getNinteiChosaPrint().setChkChosahyoKatamen(chkChosahyoKatamen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoRyomen() {
        return this.getNinteiChosaPrint().getChkChosahyoRyomen();
    }

    @JsonIgnore
    public void  setChkChosahyoRyomen(CheckBoxList chkChosahyoRyomen) {
        this.getNinteiChosaPrint().setChkChosahyoRyomen(chkChosahyoRyomen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoGaikyo() {
        return this.getNinteiChosaPrint().getChkChosahyoGaikyo();
    }

    @JsonIgnore
    public void  setChkChosahyoGaikyo(CheckBoxList chkChosahyoGaikyo) {
        this.getNinteiChosaPrint().setChkChosahyoGaikyo(chkChosahyoGaikyo);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoSai() {
        return this.getNinteiChosaPrint().getChkChosahyoSai();
    }

    @JsonIgnore
    public void  setChkChosahyoSai(CheckBoxList chkChosahyoSai) {
        this.getNinteiChosaPrint().setChkChosahyoSai(chkChosahyoSai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoTokki() {
        return this.getNinteiChosaPrint().getChkChosahyoTokki();
    }

    @JsonIgnore
    public void  setChkChosahyoTokki(CheckBoxList chkChosahyoTokki) {
        this.getNinteiChosaPrint().setChkChosahyoTokki(chkChosahyoTokki);
    }

    // </editor-fold>
}
