package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC1210011Panel のクラスファイル
 *
 * @reamsid_L DBC-2310-010 chenyadong
 */
public class DBC1210011PanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLine")
    private HorizontalLine linLine;
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakusei")
    private KogakuGassanShikyuKetteiTsuchishoSakuseiDiv KogakuGassanShikyuKetteiTsuchishoSakusei;
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiPrint")
    private KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv KogakuGassanShikyuKetteiTsuchishoSakuseiPrint;
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon")
    private KaigoShikakuKihonDiv KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKihon")
    private KaigoAtenaInfoDiv KogakuGassanShikyuKetteiTsuchishoSakuseiKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinLine
     * @return linLine
     */
    @JsonProperty("linLine")
    public HorizontalLine getLinLine() {
        return linLine;
    }

    /*
     * setlinLine
     * @param linLine linLine
     */
    @JsonProperty("linLine")
    public void setLinLine(HorizontalLine linLine) {
        this.linLine = linLine;
    }

    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakusei
     * @return KogakuGassanShikyuKetteiTsuchishoSakusei
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakusei")
    public KogakuGassanShikyuKetteiTsuchishoSakuseiDiv getKogakuGassanShikyuKetteiTsuchishoSakusei() {
        return KogakuGassanShikyuKetteiTsuchishoSakusei;
    }

    /*
     * setKogakuGassanShikyuKetteiTsuchishoSakusei
     * @param KogakuGassanShikyuKetteiTsuchishoSakusei KogakuGassanShikyuKetteiTsuchishoSakusei
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakusei")
    public void setKogakuGassanShikyuKetteiTsuchishoSakusei(KogakuGassanShikyuKetteiTsuchishoSakuseiDiv KogakuGassanShikyuKetteiTsuchishoSakusei) {
        this.KogakuGassanShikyuKetteiTsuchishoSakusei = KogakuGassanShikyuKetteiTsuchishoSakusei;
    }

    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     * @return KogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiPrint")
    public KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint() {
        return KogakuGassanShikyuKetteiTsuchishoSakuseiPrint;
    }

    /*
     * setKogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     * @param KogakuGassanShikyuKetteiTsuchishoSakuseiPrint KogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiPrint")
    public void setKogakuGassanShikyuKetteiTsuchishoSakuseiPrint(KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv KogakuGassanShikyuKetteiTsuchishoSakuseiPrint) {
        this.KogakuGassanShikyuKetteiTsuchishoSakuseiPrint = KogakuGassanShikyuKetteiTsuchishoSakuseiPrint;
    }

    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon
     * @return KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon")
    public IKaigoShikakuKihonDiv getKogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon() {
        return KogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon
     * @return KogakuGassanShikyuKetteiTsuchishoSakuseiKihon
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiKihon")
    public IKaigoAtenaInfoDiv getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon() {
        return KogakuGassanShikyuKetteiTsuchishoSakuseiKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTaishoNendo() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getDdlTaishoNendo();
    }

    @JsonIgnore
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setDdlTaishoNendo(ddlTaishoNendo);
    }

    @JsonIgnore
    public DropDownList getDdlRearakuhyoSeiriNO() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getDdlRearakuhyoSeiriNO();
    }

    @JsonIgnore
    public void setDdlRearakuhyoSeiriNO(DropDownList ddlRearakuhyoSeiriNO) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setDdlRearakuhyoSeiriNO(ddlRearakuhyoSeiriNO);
    }

    @JsonIgnore
    public DropDownList getDdlRirekiNO() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getDdlRirekiNO();
    }

    @JsonIgnore
    public void setDdlRirekiNO(DropDownList ddlRirekiNO) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setDdlRirekiNO(ddlRirekiNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkouYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getTxtHakkouYMD();
    }

    @JsonIgnore
    public void setTxtHakkouYMD(TextBoxDate txtHakkouYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().setTxtHakkouYMD(txtHakkouYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiHakkoYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getTxtZenkaiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtZenkaiHakkoYMD(TextBoxDate txtZenkaiHakkoYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().setTxtZenkaiHakkoYMD(txtZenkaiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiharaiYoteiYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getTxtShiharaiYoteiYMD();
    }

    @JsonIgnore
    public void setTxtShiharaiYoteiYMD(TextBoxDate txtShiharaiYoteiYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().setTxtShiharaiYoteiYMD(txtShiharaiYoteiYMD);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoNO() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getCcdBunshoNO();
    }

    // </editor-fold>
}
