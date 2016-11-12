package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokkiJokoSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiJokoSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-04_20-07-38">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTokkiJko")
    private CheckBoxList chkTokkiJko;
    @JsonProperty("chkTenyuryoku")
    private CheckBoxList chkTenyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTokkiJko
     * @return chkTokkiJko
     */
    @JsonProperty("chkTokkiJko")
    public CheckBoxList getChkTokkiJko() {
        return chkTokkiJko;
    }

    /*
     * setchkTokkiJko
     * @param chkTokkiJko chkTokkiJko
     */
    @JsonProperty("chkTokkiJko")
    public void setChkTokkiJko(CheckBoxList chkTokkiJko) {
        this.chkTokkiJko = chkTokkiJko;
    }

    /*
     * getchkTenyuryoku
     * @return chkTenyuryoku
     */
    @JsonProperty("chkTenyuryoku")
    public CheckBoxList getChkTenyuryoku() {
        return chkTenyuryoku;
    }

    /*
     * setchkTenyuryoku
     * @param chkTenyuryoku chkTenyuryoku
     */
    @JsonProperty("chkTenyuryoku")
    public void setChkTenyuryoku(CheckBoxList chkTenyuryoku) {
        this.chkTenyuryoku = chkTenyuryoku;
    }

    // </editor-fold>
}
