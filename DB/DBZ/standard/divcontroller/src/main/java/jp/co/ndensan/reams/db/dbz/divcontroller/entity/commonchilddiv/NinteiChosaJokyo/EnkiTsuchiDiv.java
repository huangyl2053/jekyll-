package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * EnkiTsuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class EnkiTsuchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtEnkiTsuchiHakkoDay")
    private TextBoxFlexibleDate txtEnkiTsuchiHakkoDay;
    @JsonProperty("txtEnkiTsuchiHakkoCount")
    private TextBoxNum txtEnkiTsuchiHakkoCount;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtEnkiTsuchiHakkoDay
     * @return txtEnkiTsuchiHakkoDay
     */
    @JsonProperty("txtEnkiTsuchiHakkoDay")
    public TextBoxFlexibleDate getTxtEnkiTsuchiHakkoDay() {
        return txtEnkiTsuchiHakkoDay;
    }

    /*
     * settxtEnkiTsuchiHakkoDay
     * @param txtEnkiTsuchiHakkoDay txtEnkiTsuchiHakkoDay
     */
    @JsonProperty("txtEnkiTsuchiHakkoDay")
    public void setTxtEnkiTsuchiHakkoDay(TextBoxFlexibleDate txtEnkiTsuchiHakkoDay) {
        this.txtEnkiTsuchiHakkoDay = txtEnkiTsuchiHakkoDay;
    }

    /*
     * gettxtEnkiTsuchiHakkoCount
     * @return txtEnkiTsuchiHakkoCount
     */
    @JsonProperty("txtEnkiTsuchiHakkoCount")
    public TextBoxNum getTxtEnkiTsuchiHakkoCount() {
        return txtEnkiTsuchiHakkoCount;
    }

    /*
     * settxtEnkiTsuchiHakkoCount
     * @param txtEnkiTsuchiHakkoCount txtEnkiTsuchiHakkoCount
     */
    @JsonProperty("txtEnkiTsuchiHakkoCount")
    public void setTxtEnkiTsuchiHakkoCount(TextBoxNum txtEnkiTsuchiHakkoCount) {
        this.txtEnkiTsuchiHakkoCount = txtEnkiTsuchiHakkoCount;
    }

    // </editor-fold>
}
