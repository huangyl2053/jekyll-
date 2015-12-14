package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HakkoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("radChohyoSentaku")
    private RadioButton radChohyoSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHokensha
     * @return ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    /*
     * setddlHokensha
     * @param ddlHokensha ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha = ddlHokensha;
    }

    /*
     * getradChohyoSentaku
     * @return radChohyoSentaku
     */
    @JsonProperty("radChohyoSentaku")
    public RadioButton getRadChohyoSentaku() {
        return radChohyoSentaku;
    }

    /*
     * setradChohyoSentaku
     * @param radChohyoSentaku radChohyoSentaku
     */
    @JsonProperty("radChohyoSentaku")
    public void setRadChohyoSentaku(RadioButton radChohyoSentaku) {
        this.radChohyoSentaku = radChohyoSentaku;
    }

    // </editor-fold>
}
