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
 * HakkoTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoSentaku")
    private RadioButton radTaishoSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoSentaku
     * @return radTaishoSentaku
     */
    @JsonProperty("radTaishoSentaku")
    public RadioButton getRadTaishoSentaku() {
        return radTaishoSentaku;
    }

    /*
     * setradTaishoSentaku
     * @param radTaishoSentaku radTaishoSentaku
     */
    @JsonProperty("radTaishoSentaku")
    public void setRadTaishoSentaku(RadioButton radTaishoSentaku) {
        this.radTaishoSentaku = radTaishoSentaku;
    }

    // </editor-fold>
}
