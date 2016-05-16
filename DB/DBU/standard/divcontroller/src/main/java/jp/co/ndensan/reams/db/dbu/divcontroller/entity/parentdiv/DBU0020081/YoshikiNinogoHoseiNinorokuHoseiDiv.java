package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiNinogoHoseiNinorokuHosei のクラスファイル
 *
 * @reamsid_L DBU-1100-070 yebangqiang
 */
public class YoshikiNinogoHoseiNinorokuHoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
    @JsonProperty("予防要支援結果")
    private RString 予防要支援結果;
    @JsonProperty("介護要支援結果")
    private RString 介護要支援結果;
    @JsonProperty("合計要支援結果")
    private RString 合計要支援結果;

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

    /*
     * get予防要支援結果
     * @return 予防要支援結果
     */
    @JsonProperty("予防要支援結果")
    public RString get予防要支援結果() {
        return 予防要支援結果;
    }

    /*
     * set予防要支援結果
     * @param 予防要支援結果 予防要支援結果
     */
    @JsonProperty("予防要支援結果")
    public void set予防要支援結果(RString 予防要支援結果) {
        this.予防要支援結果 = 予防要支援結果;
    }

    /*
     * get介護要支援結果
     * @return 介護要支援結果
     */
    @JsonProperty("介護要支援結果")
    public RString get介護要支援結果() {
        return 介護要支援結果;
    }

    /*
     * set介護要支援結果
     * @param 介護要支援結果 介護要支援結果
     */
    @JsonProperty("介護要支援結果")
    public void set介護要支援結果(RString 介護要支援結果) {
        this.介護要支援結果 = 介護要支援結果;
    }

    /*
     * get合計要支援結果
     * @return 合計要支援結果
     */
    @JsonProperty("合計要支援結果")
    public RString get合計要支援結果() {
        return 合計要支援結果;
    }

    /*
     * set合計要支援結果
     * @param 合計要支援結果 合計要支援結果
     */
    @JsonProperty("合計要支援結果")
    public void set合計要支援結果(RString 合計要支援結果) {
        this.合計要支援結果 = 合計要支援結果;
    }

    // </editor-fold>
}
