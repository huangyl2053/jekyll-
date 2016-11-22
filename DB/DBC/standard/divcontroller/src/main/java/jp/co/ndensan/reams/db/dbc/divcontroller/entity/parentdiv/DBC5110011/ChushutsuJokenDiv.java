package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoYM")
    private RadioButton radTaishoYM;
    @JsonProperty("TasyoNengetu")
    private TextBoxDate TasyoNengetu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoYM
     * @return radTaishoYM
     */
    @JsonProperty("radTaishoYM")
    public RadioButton getRadTaishoYM() {
        return radTaishoYM;
    }

    /*
     * setradTaishoYM
     * @param radTaishoYM radTaishoYM
     */
    @JsonProperty("radTaishoYM")
    public void setRadTaishoYM(RadioButton radTaishoYM) {
        this.radTaishoYM = radTaishoYM;
    }

    /*
     * getTasyoNengetu
     * @return TasyoNengetu
     */
    @JsonProperty("TasyoNengetu")
    public TextBoxDate getTasyoNengetu() {
        return TasyoNengetu;
    }

    /*
     * setTasyoNengetu
     * @param TasyoNengetu TasyoNengetu
     */
    @JsonProperty("TasyoNengetu")
    public void setTasyoNengetu(TextBoxDate TasyoNengetu) {
        this.TasyoNengetu = TasyoNengetu;
    }

    // </editor-fold>
}
