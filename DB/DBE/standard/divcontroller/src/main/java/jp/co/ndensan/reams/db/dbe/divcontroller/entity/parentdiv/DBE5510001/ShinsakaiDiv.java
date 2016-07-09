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
 * Shinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShinsakaiWaritsuke")
    private CheckBoxList chkShinsakaiWaritsuke;
    @JsonProperty("chkShinsakaiJisshi")
    private CheckBoxList chkShinsakaiJisshi;
    @JsonProperty("spSpace6")
    private Space spSpace6;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShinsakaiWaritsuke
     * @return chkShinsakaiWaritsuke
     */
    @JsonProperty("chkShinsakaiWaritsuke")
    public CheckBoxList getChkShinsakaiWaritsuke() {
        return chkShinsakaiWaritsuke;
    }

    /*
     * setchkShinsakaiWaritsuke
     * @param chkShinsakaiWaritsuke chkShinsakaiWaritsuke
     */
    @JsonProperty("chkShinsakaiWaritsuke")
    public void setChkShinsakaiWaritsuke(CheckBoxList chkShinsakaiWaritsuke) {
        this.chkShinsakaiWaritsuke = chkShinsakaiWaritsuke;
    }

    /*
     * getchkShinsakaiJisshi
     * @return chkShinsakaiJisshi
     */
    @JsonProperty("chkShinsakaiJisshi")
    public CheckBoxList getChkShinsakaiJisshi() {
        return chkShinsakaiJisshi;
    }

    /*
     * setchkShinsakaiJisshi
     * @param chkShinsakaiJisshi chkShinsakaiJisshi
     */
    @JsonProperty("chkShinsakaiJisshi")
    public void setChkShinsakaiJisshi(CheckBoxList chkShinsakaiJisshi) {
        this.chkShinsakaiJisshi = chkShinsakaiJisshi;
    }

    /*
     * getspSpace6
     * @return spSpace6
     */
    @JsonProperty("spSpace6")
    public Space getSpSpace6() {
        return spSpace6;
    }

    /*
     * setspSpace6
     * @param spSpace6 spSpace6
     */
    @JsonProperty("spSpace6")
    public void setSpSpace6(Space spSpace6) {
        this.spSpace6 = spSpace6;
    }

    // </editor-fold>
}
