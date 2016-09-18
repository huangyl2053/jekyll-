package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Masking のクラスファイル 
 * 
 * @author 自動生成
 */
public class MaskingDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkMaskingKanryo")
    private CheckBoxList chkMaskingKanryo;
    @JsonProperty("spSpace4")
    private Space spSpace4;
    @JsonProperty("spSpace5")
    private Space spSpace5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkMaskingKanryo
     * @return chkMaskingKanryo
     */
    @JsonProperty("chkMaskingKanryo")
    public CheckBoxList getChkMaskingKanryo() {
        return chkMaskingKanryo;
    }

    /*
     * setchkMaskingKanryo
     * @param chkMaskingKanryo chkMaskingKanryo
     */
    @JsonProperty("chkMaskingKanryo")
    public void setChkMaskingKanryo(CheckBoxList chkMaskingKanryo) {
        this.chkMaskingKanryo = chkMaskingKanryo;
    }

    /*
     * getspSpace4
     * @return spSpace4
     */
    @JsonProperty("spSpace4")
    public Space getSpSpace4() {
        return spSpace4;
    }

    /*
     * setspSpace4
     * @param spSpace4 spSpace4
     */
    @JsonProperty("spSpace4")
    public void setSpSpace4(Space spSpace4) {
        this.spSpace4 = spSpace4;
    }

    /*
     * getspSpace5
     * @return spSpace5
     */
    @JsonProperty("spSpace5")
    public Space getSpSpace5() {
        return spSpace5;
    }

    /*
     * setspSpace5
     * @param spSpace5 spSpace5
     */
    @JsonProperty("spSpace5")
    public void setSpSpace5(Space spSpace5) {
        this.spSpace5 = spSpace5;
    }

    // </editor-fold>
}
