package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1170011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoFutangakuShomeisho のクラスファイル
 *
 * @author 自動生成
 */
public class JikoFutangakuShomeishoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutanShomeishoSakusei")
    private JikoFutanShomeishoSakuseiDiv JikoFutanShomeishoSakusei;
    @JsonProperty("JikoFutanShomeishoSakuseiPrint")
    private JikoFutanShomeishoSakuseiPrintDiv JikoFutanShomeishoSakuseiPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutanShomeishoSakusei
     * @return JikoFutanShomeishoSakusei
     */
    @JsonProperty("JikoFutanShomeishoSakusei")
    public JikoFutanShomeishoSakuseiDiv getJikoFutanShomeishoSakusei() {
        return JikoFutanShomeishoSakusei;
    }

    /*
     * setJikoFutanShomeishoSakusei
     * @param JikoFutanShomeishoSakusei JikoFutanShomeishoSakusei
     */
    @JsonProperty("JikoFutanShomeishoSakusei")
    public void setJikoFutanShomeishoSakusei(JikoFutanShomeishoSakuseiDiv JikoFutanShomeishoSakusei) {
        this.JikoFutanShomeishoSakusei = JikoFutanShomeishoSakusei;
    }

    /*
     * getJikoFutanShomeishoSakuseiPrint
     * @return JikoFutanShomeishoSakuseiPrint
     */
    @JsonProperty("JikoFutanShomeishoSakuseiPrint")
    public JikoFutanShomeishoSakuseiPrintDiv getJikoFutanShomeishoSakuseiPrint() {
        return JikoFutanShomeishoSakuseiPrint;
    }

    /*
     * setJikoFutanShomeishoSakuseiPrint
     * @param JikoFutanShomeishoSakuseiPrint JikoFutanShomeishoSakuseiPrint
     */
    @JsonProperty("JikoFutanShomeishoSakuseiPrint")
    public void setJikoFutanShomeishoSakuseiPrint(JikoFutanShomeishoSakuseiPrintDiv JikoFutanShomeishoSakuseiPrint) {
        this.JikoFutanShomeishoSakuseiPrint = JikoFutanShomeishoSakuseiPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdShikakuKihon() {
        return this.getJikoFutanShomeishoSakusei().getCcdShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return this.getJikoFutanShomeishoSakusei().getCcdAtenaInfo();
    }

    // </editor-fold>
}
