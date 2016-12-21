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
 * ChosahyoTokkijikoSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosahyoTokkijikoSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkChosahyoTokkijiko")
    private CheckBoxList chkChosahyoTokkijiko;
    @JsonProperty("chkTokkijikoTenyuryoku")
    private CheckBoxList chkTokkijikoTenyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkChosahyoTokkijiko
     * @return chkChosahyoTokkijiko
     */
    @JsonProperty("chkChosahyoTokkijiko")
    public CheckBoxList getChkChosahyoTokkijiko() {
        return chkChosahyoTokkijiko;
    }

    /*
     * setchkChosahyoTokkijiko
     * @param chkChosahyoTokkijiko chkChosahyoTokkijiko
     */
    @JsonProperty("chkChosahyoTokkijiko")
    public void setChkChosahyoTokkijiko(CheckBoxList chkChosahyoTokkijiko) {
        this.chkChosahyoTokkijiko = chkChosahyoTokkijiko;
    }

    /*
     * getchkTokkijikoTenyuryoku
     * @return chkTokkijikoTenyuryoku
     */
    @JsonProperty("chkTokkijikoTenyuryoku")
    public CheckBoxList getChkTokkijikoTenyuryoku() {
        return chkTokkijikoTenyuryoku;
    }

    /*
     * setchkTokkijikoTenyuryoku
     * @param chkTokkijikoTenyuryoku chkTokkijikoTenyuryoku
     */
    @JsonProperty("chkTokkijikoTenyuryoku")
    public void setChkTokkijikoTenyuryoku(CheckBoxList chkTokkijikoTenyuryoku) {
        this.chkTokkijikoTenyuryoku = chkTokkijikoTenyuryoku;
    }

    // </editor-fold>
}
