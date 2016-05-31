package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiIchinogoHosei のクラスファイル
 *
 * @reamsid_L DBU-1100-050 quxiaodong
 */
public class YoshikiIchinogoHoseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlMain")
    private pnlMainDiv pnlMain;
    @JsonProperty("pnl11")
    private pnl11Div pnl11;
    @JsonProperty("pnl12")
    private pnl12Div pnl12;
    @JsonProperty("pnl13")
    private pnl13Div pnl13;
    @JsonProperty("pnl14")
    private pnl14Div pnl14;
    @JsonProperty("pnlKanryo")
    private pnlKanryoDiv pnlKanryo;
    @JsonProperty("要支援計")
    private RString 要支援計;
    @JsonProperty("要介護計")
    private RString 要介護計;
    @JsonProperty("合計")
    private RString 合計;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlMain
     * @return pnlMain
     */
    @JsonProperty("pnlMain")
    public pnlMainDiv getPnlMain() {
        return pnlMain;
    }

    /*
     * setpnlMain
     * @param pnlMain pnlMain
     */
    @JsonProperty("pnlMain")
    public void setPnlMain(pnlMainDiv pnlMain) {
        this.pnlMain = pnlMain;
    }

    /*
     * getpnl11
     * @return pnl11
     */
    @JsonProperty("pnl11")
    public pnl11Div getPnl11() {
        return pnl11;
    }

    /*
     * setpnl11
     * @param pnl11 pnl11
     */
    @JsonProperty("pnl11")
    public void setPnl11(pnl11Div pnl11) {
        this.pnl11 = pnl11;
    }

    /*
     * getpnl12
     * @return pnl12
     */
    @JsonProperty("pnl12")
    public pnl12Div getPnl12() {
        return pnl12;
    }

    /*
     * setpnl12
     * @param pnl12 pnl12
     */
    @JsonProperty("pnl12")
    public void setPnl12(pnl12Div pnl12) {
        this.pnl12 = pnl12;
    }

    /*
     * getpnl13
     * @return pnl13
     */
    @JsonProperty("pnl13")
    public pnl13Div getPnl13() {
        return pnl13;
    }

    /*
     * setpnl13
     * @param pnl13 pnl13
     */
    @JsonProperty("pnl13")
    public void setPnl13(pnl13Div pnl13) {
        this.pnl13 = pnl13;
    }

    /*
     * getpnl14
     * @return pnl14
     */
    @JsonProperty("pnl14")
    public pnl14Div getPnl14() {
        return pnl14;
    }

    /*
     * setpnl14
     * @param pnl14 pnl14
     */
    @JsonProperty("pnl14")
    public void setPnl14(pnl14Div pnl14) {
        this.pnl14 = pnl14;
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
     * get要支援計
     * @return 要支援計
     */
    @JsonProperty("要支援計")
    public RString get要支援計() {
        return 要支援計;
    }

    /*
     * set要支援計
     * @param 要支援計 要支援計
     */
    @JsonProperty("要支援計")
    public void set要支援計(RString 要支援計) {
        this.要支援計 = 要支援計;
    }

    /*
     * get要介護計
     * @return 要介護計
     */
    @JsonProperty("要介護計")
    public RString get要介護計() {
        return 要介護計;
    }

    /*
     * set要介護計
     * @param 要介護計 要介護計
     */
    @JsonProperty("要介護計")
    public void set要介護計(RString 要介護計) {
        this.要介護計 = 要介護計;
    }

    /*
     * get合計
     * @return 合計
     */
    @JsonProperty("合計")
    public RString get合計() {
        return 合計;
    }

    /*
     * set合計
     * @param 合計 合計
     */
    @JsonProperty("合計")
    public void set合計(RString 合計) {
        this.合計 = 合計;
    }

    // </editor-fold>
}
