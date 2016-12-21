package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosahyoSelectItemsOne のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosahyoSelectItemsOneDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Chkirai")
    private CheckBoxList Chkirai;
    @JsonProperty("ChkchosaOcr")
    private CheckBoxList ChkchosaOcr;
    @JsonProperty("chkNinteiChosahyoSonota")
    private CheckBoxList chkNinteiChosahyoSonota;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChkirai
     * @return Chkirai
     */
    @JsonProperty("Chkirai")
    public CheckBoxList getChkirai() {
        return Chkirai;
    }

    /*
     * setChkirai
     * @param Chkirai Chkirai
     */
    @JsonProperty("Chkirai")
    public void setChkirai(CheckBoxList Chkirai) {
        this.Chkirai = Chkirai;
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
     * getchkNinteiChosahyoSonota
     * @return chkNinteiChosahyoSonota
     */
    @JsonProperty("chkNinteiChosahyoSonota")
    public CheckBoxList getChkNinteiChosahyoSonota() {
        return chkNinteiChosahyoSonota;
    }

    /*
     * setchkNinteiChosahyoSonota
     * @param chkNinteiChosahyoSonota chkNinteiChosahyoSonota
     */
    @JsonProperty("chkNinteiChosahyoSonota")
    public void setChkNinteiChosahyoSonota(CheckBoxList chkNinteiChosahyoSonota) {
        this.chkNinteiChosahyoSonota = chkNinteiChosahyoSonota;
    }

    // </editor-fold>
}
