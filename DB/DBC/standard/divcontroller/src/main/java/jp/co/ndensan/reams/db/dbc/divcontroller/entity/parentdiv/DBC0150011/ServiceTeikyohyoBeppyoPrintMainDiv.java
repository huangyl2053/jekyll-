package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ServiceTeikyohyoBeppyoPrintMain のクラスファイル
 *
 * @reamsid_L DBC-5110-010 xupeng
 */
public class ServiceTeikyohyoBeppyoPrintMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("printShiji")
    private printShijiDiv printShiji;
    @JsonProperty("cccKaigoShiKakuKihon")
    private KaigoShikakuKihonDiv cccKaigoShiKakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getprintShiji
     * @return printShiji
     */
    @JsonProperty("printShiji")
    public printShijiDiv getPrintShiji() {
        return printShiji;
    }

    /*
     * setprintShiji
     * @param printShiji printShiji
     */
    @JsonProperty("printShiji")
    public void setPrintShiji(printShijiDiv printShiji) {
        this.printShiji = printShiji;
    }

    /*
     * getcccKaigoShiKakuKihon
     * @return cccKaigoShiKakuKihon
     */
    @JsonProperty("cccKaigoShiKakuKihon")
    public IKaigoShikakuKihonDiv getCccKaigoShiKakuKihon() {
        return cccKaigoShiKakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtSakuseiYmd() {
        return this.getPrintShiji().getTxtSakuseiYmd();
    }

    @JsonIgnore
    public void setTxtSakuseiYmd(TextBoxDate txtSakuseiYmd) {
        this.getPrintShiji().setTxtSakuseiYmd(txtSakuseiYmd);
    }

    @JsonIgnore
    public TextBoxDate getTxtJikoSakuseiKeikakuYm() {
        return this.getPrintShiji().getTxtJikoSakuseiKeikakuYm();
    }

    @JsonIgnore
    public void setTxtJikoSakuseiKeikakuYm(TextBoxDate txtJikoSakuseiKeikakuYm) {
        this.getPrintShiji().setTxtJikoSakuseiKeikakuYm(txtJikoSakuseiKeikakuYm);
    }

    // </editor-fold>
}
