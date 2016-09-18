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
 * IchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIchijiHanteiKanryo")
    private CheckBoxList chkIchijiHanteiKanryo;
    @JsonProperty("spSpace2")
    private Space spSpace2;
    @JsonProperty("spSpace3")
    private Space spSpace3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkIchijiHanteiKanryo
     * @return chkIchijiHanteiKanryo
     */
    @JsonProperty("chkIchijiHanteiKanryo")
    public CheckBoxList getChkIchijiHanteiKanryo() {
        return chkIchijiHanteiKanryo;
    }

    /*
     * setchkIchijiHanteiKanryo
     * @param chkIchijiHanteiKanryo chkIchijiHanteiKanryo
     */
    @JsonProperty("chkIchijiHanteiKanryo")
    public void setChkIchijiHanteiKanryo(CheckBoxList chkIchijiHanteiKanryo) {
        this.chkIchijiHanteiKanryo = chkIchijiHanteiKanryo;
    }

    /*
     * getspSpace2
     * @return spSpace2
     */
    @JsonProperty("spSpace2")
    public Space getSpSpace2() {
        return spSpace2;
    }

    /*
     * setspSpace2
     * @param spSpace2 spSpace2
     */
    @JsonProperty("spSpace2")
    public void setSpSpace2(Space spSpace2) {
        this.spSpace2 = spSpace2;
    }

    /*
     * getspSpace3
     * @return spSpace3
     */
    @JsonProperty("spSpace3")
    public Space getSpSpace3() {
        return spSpace3;
    }

    /*
     * setspSpace3
     * @param spSpace3 spSpace3
     */
    @JsonProperty("spSpace3")
    public void setSpSpace3(Space spSpace3) {
        this.spSpace3 = spSpace3;
    }

    // </editor-fold>
}
