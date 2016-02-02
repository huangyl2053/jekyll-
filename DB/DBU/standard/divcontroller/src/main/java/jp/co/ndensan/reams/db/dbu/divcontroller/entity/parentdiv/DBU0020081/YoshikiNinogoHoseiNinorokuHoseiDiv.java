package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiNinogoHoseiNinorokuHosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiNinogoHoseiNinorokuHoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnl2")
    private pnl2Div pnl2;
    @JsonProperty("pnlKanryo")
    private pnlKanryoDiv pnlKanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnl2
     * @return pnl2
     */
    @JsonProperty("pnl2")
    public pnl2Div getPnl2() {
        return pnl2;
    }

    /*
     * setpnl2
     * @param pnl2 pnl2
     */
    @JsonProperty("pnl2")
    public void setPnl2(pnl2Div pnl2) {
        this.pnl2 = pnl2;
    }

    /*
     * getpnlKanryo
     * @return pnlKanryo
     */
    @JsonProperty("pnlKanryo")
    public pnlKanryoDiv getPnlKanryo() {
        return pnlKanryo;
    }

    /*
     * setpnlKanryo
     * @param pnlKanryo pnlKanryo
     */
    @JsonProperty("pnlKanryo")
    public void setPnlKanryo(pnlKanryoDiv pnlKanryo) {
        this.pnlKanryo = pnlKanryo;
    }

    // </editor-fold>
}
