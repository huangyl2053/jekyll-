package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosahyoPrintList のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosahyoPrintListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Chkchosa")
    private CheckBoxList Chkchosa;
    @JsonProperty("ChkchosaOcr")
    private CheckBoxList ChkchosaOcr;
    @JsonProperty("ChkchosaSonota")
    private CheckBoxList ChkchosaSonota;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChkchosa
     * @return Chkchosa
     */
    @JsonProperty("Chkchosa")
    public CheckBoxList getChkchosa() {
        return Chkchosa;
    }

    /*
     * setChkchosa
     * @param Chkchosa Chkchosa
     */
    @JsonProperty("Chkchosa")
    public void setChkchosa(CheckBoxList Chkchosa) {
        this.Chkchosa = Chkchosa;
    }

    /*
     * getChkchosaOcr
     * @return ChkchosaOcr
     */
    @JsonProperty("ChkchosaOcr")
    public CheckBoxList getChkchosaOcr() {
        return ChkchosaOcr;
    }

    /*
     * setChkchosaOcr
     * @param ChkchosaOcr ChkchosaOcr
     */
    @JsonProperty("ChkchosaOcr")
    public void setChkchosaOcr(CheckBoxList ChkchosaOcr) {
        this.ChkchosaOcr = ChkchosaOcr;
    }

    /*
     * getChkchosaSonota
     * @return ChkchosaSonota
     */
    @JsonProperty("ChkchosaSonota")
    public CheckBoxList getChkchosaSonota() {
        return ChkchosaSonota;
    }

    /*
     * setChkchosaSonota
     * @param ChkchosaSonota ChkchosaSonota
     */
    @JsonProperty("ChkchosaSonota")
    public void setChkchosaSonota(CheckBoxList ChkchosaSonota) {
        this.ChkchosaSonota = ChkchosaSonota;
    }

    // </editor-fold>
}
