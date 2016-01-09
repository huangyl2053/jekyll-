package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Zenken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenkenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkZenken")
    private CheckBoxList chkZenken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkZenken
     * @return chkZenken
     */
    @JsonProperty("chkZenken")
    public CheckBoxList getChkZenken() {
        return chkZenken;
    }

    /*
     * setchkZenken
     * @param chkZenken chkZenken
     */
    @JsonProperty("chkZenken")
    public void setChkZenken(CheckBoxList chkZenken) {
        this.chkZenken = chkZenken;
    }

    // </editor-fold>
}
