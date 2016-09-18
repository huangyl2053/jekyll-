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
 * ShujiiIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShujiiIkenshoIrai")
    private CheckBoxList chkShujiiIkenshoIrai;
    @JsonProperty("chkShujiiIkenshoJuryo")
    private CheckBoxList chkShujiiIkenshoJuryo;
    @JsonProperty("spSpace1")
    private Space spSpace1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShujiiIkenshoIrai
     * @return chkShujiiIkenshoIrai
     */
    @JsonProperty("chkShujiiIkenshoIrai")
    public CheckBoxList getChkShujiiIkenshoIrai() {
        return chkShujiiIkenshoIrai;
    }

    /*
     * setchkShujiiIkenshoIrai
     * @param chkShujiiIkenshoIrai chkShujiiIkenshoIrai
     */
    @JsonProperty("chkShujiiIkenshoIrai")
    public void setChkShujiiIkenshoIrai(CheckBoxList chkShujiiIkenshoIrai) {
        this.chkShujiiIkenshoIrai = chkShujiiIkenshoIrai;
    }

    /*
     * getchkShujiiIkenshoJuryo
     * @return chkShujiiIkenshoJuryo
     */
    @JsonProperty("chkShujiiIkenshoJuryo")
    public CheckBoxList getChkShujiiIkenshoJuryo() {
        return chkShujiiIkenshoJuryo;
    }

    /*
     * setchkShujiiIkenshoJuryo
     * @param chkShujiiIkenshoJuryo chkShujiiIkenshoJuryo
     */
    @JsonProperty("chkShujiiIkenshoJuryo")
    public void setChkShujiiIkenshoJuryo(CheckBoxList chkShujiiIkenshoJuryo) {
        this.chkShujiiIkenshoJuryo = chkShujiiIkenshoJuryo;
    }

    /*
     * getspSpace1
     * @return spSpace1
     */
    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    /*
     * setspSpace1
     * @param spSpace1 spSpace1
     */
    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1 = spSpace1;
    }

    // </editor-fold>
}
