package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinteiChosa")
    private CheckBoxList chkNinteiChosa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkNinteiChosa
     * @return chkNinteiChosa
     */
    @JsonProperty("chkNinteiChosa")
    public CheckBoxList getChkNinteiChosa() {
        return chkNinteiChosa;
    }

    /*
     * setchkNinteiChosa
     * @param chkNinteiChosa chkNinteiChosa
     */
    @JsonProperty("chkNinteiChosa")
    public void setChkNinteiChosa(CheckBoxList chkNinteiChosa) {
        this.chkNinteiChosa = chkNinteiChosa;
    }

    // </editor-fold>
}
