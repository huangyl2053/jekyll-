package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.IFukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChoshuYuyoJuminKihon のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class ChoshuYuyoJuminKihonDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChoshuYuyoFukaRirekiAll")
    private ChoshuYuyoFukaRirekiAllDiv ChoshuYuyoFukaRirekiAll;
    @JsonProperty("ChoshuYuyoMain")
    private ChoshuYuyoMainDiv ChoshuYuyoMain;
    @JsonProperty("ChoshuYuyoPrintinfo")
    private ChoshuYuyoPrintinfoDiv ChoshuYuyoPrintinfo;
    @JsonProperty("ccdKaigoFukaKihon")
    private KaigoFukaKihonDiv ccdKaigoFukaKihon;
    @JsonProperty("AtenaKihon")
    private KaigoAtenaInfoDiv AtenaKihon;
    @JsonProperty("ChoshuYuyoShuruiCode")
    private RString ChoshuYuyoShuruiCode;
    @JsonProperty("ChoshuYuyoShuruiHyojiMongon")
    private RString ChoshuYuyoShuruiHyojiMongon;
    @JsonProperty("GemmenTorikeshiShuruiCode")
    private RString GemmenTorikeshiShuruiCode;
    @JsonProperty("GemmenTorikeshiShuruiHyojiMongon")
    private RString GemmenTorikeshiShuruiHyojiMongon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChoshuYuyoFukaRirekiAll
     * @return ChoshuYuyoFukaRirekiAll
     */
    @JsonProperty("ChoshuYuyoFukaRirekiAll")
    public ChoshuYuyoFukaRirekiAllDiv getChoshuYuyoFukaRirekiAll() {
        return ChoshuYuyoFukaRirekiAll;
    }

    /*
     * setChoshuYuyoFukaRirekiAll
     * @param ChoshuYuyoFukaRirekiAll ChoshuYuyoFukaRirekiAll
     */
    @JsonProperty("ChoshuYuyoFukaRirekiAll")
    public void setChoshuYuyoFukaRirekiAll(ChoshuYuyoFukaRirekiAllDiv ChoshuYuyoFukaRirekiAll) {
        this.ChoshuYuyoFukaRirekiAll = ChoshuYuyoFukaRirekiAll;
    }

    /*
     * getChoshuYuyoMain
     * @return ChoshuYuyoMain
     */
    @JsonProperty("ChoshuYuyoMain")
    public ChoshuYuyoMainDiv getChoshuYuyoMain() {
        return ChoshuYuyoMain;
    }

    /*
     * setChoshuYuyoMain
     * @param ChoshuYuyoMain ChoshuYuyoMain
     */
    @JsonProperty("ChoshuYuyoMain")
    public void setChoshuYuyoMain(ChoshuYuyoMainDiv ChoshuYuyoMain) {
        this.ChoshuYuyoMain = ChoshuYuyoMain;
    }

    /*
     * getChoshuYuyoPrintinfo
     * @return ChoshuYuyoPrintinfo
     */
    @JsonProperty("ChoshuYuyoPrintinfo")
    public ChoshuYuyoPrintinfoDiv getChoshuYuyoPrintinfo() {
        return ChoshuYuyoPrintinfo;
    }

    /*
     * setChoshuYuyoPrintinfo
     * @param ChoshuYuyoPrintinfo ChoshuYuyoPrintinfo
     */
    @JsonProperty("ChoshuYuyoPrintinfo")
    public void setChoshuYuyoPrintinfo(ChoshuYuyoPrintinfoDiv ChoshuYuyoPrintinfo) {
        this.ChoshuYuyoPrintinfo = ChoshuYuyoPrintinfo;
    }

    /*
     * getccdKaigoFukaKihon
     * @return ccdKaigoFukaKihon
     */
    @JsonProperty("ccdKaigoFukaKihon")
    public IKaigoFukaKihonDiv getCcdKaigoFukaKihon() {
        return ccdKaigoFukaKihon;
    }

    /*
     * getAtenaKihon
     * @return AtenaKihon
     */
    @JsonProperty("AtenaKihon")
    public IKaigoAtenaInfoDiv getAtenaKihon() {
        return AtenaKihon;
    }

    /*
     * getChoshuYuyoShuruiCode
     * @return ChoshuYuyoShuruiCode
     */
    @JsonProperty("ChoshuYuyoShuruiCode")
    public RString getChoshuYuyoShuruiCode() {
        return ChoshuYuyoShuruiCode;
    }

    /*
     * setChoshuYuyoShuruiCode
     * @param ChoshuYuyoShuruiCode ChoshuYuyoShuruiCode
     */
    @JsonProperty("ChoshuYuyoShuruiCode")
    public void setChoshuYuyoShuruiCode(RString ChoshuYuyoShuruiCode) {
        this.ChoshuYuyoShuruiCode = ChoshuYuyoShuruiCode;
    }

    /*
     * getChoshuYuyoShuruiHyojiMongon
     * @return ChoshuYuyoShuruiHyojiMongon
     */
    @JsonProperty("ChoshuYuyoShuruiHyojiMongon")
    public RString getChoshuYuyoShuruiHyojiMongon() {
        return ChoshuYuyoShuruiHyojiMongon;
    }

    /*
     * setChoshuYuyoShuruiHyojiMongon
     * @param ChoshuYuyoShuruiHyojiMongon ChoshuYuyoShuruiHyojiMongon
     */
    @JsonProperty("ChoshuYuyoShuruiHyojiMongon")
    public void setChoshuYuyoShuruiHyojiMongon(RString ChoshuYuyoShuruiHyojiMongon) {
        this.ChoshuYuyoShuruiHyojiMongon = ChoshuYuyoShuruiHyojiMongon;
    }

    /*
     * getGemmenTorikeshiShuruiCode
     * @return GemmenTorikeshiShuruiCode
     */
    @JsonProperty("GemmenTorikeshiShuruiCode")
    public RString getGemmenTorikeshiShuruiCode() {
        return GemmenTorikeshiShuruiCode;
    }

    /*
     * setGemmenTorikeshiShuruiCode
     * @param GemmenTorikeshiShuruiCode GemmenTorikeshiShuruiCode
     */
    @JsonProperty("GemmenTorikeshiShuruiCode")
    public void setGemmenTorikeshiShuruiCode(RString GemmenTorikeshiShuruiCode) {
        this.GemmenTorikeshiShuruiCode = GemmenTorikeshiShuruiCode;
    }

    /*
     * getGemmenTorikeshiShuruiHyojiMongon
     * @return GemmenTorikeshiShuruiHyojiMongon
     */
    @JsonProperty("GemmenTorikeshiShuruiHyojiMongon")
    public RString getGemmenTorikeshiShuruiHyojiMongon() {
        return GemmenTorikeshiShuruiHyojiMongon;
    }

    /*
     * setGemmenTorikeshiShuruiHyojiMongon
     * @param GemmenTorikeshiShuruiHyojiMongon GemmenTorikeshiShuruiHyojiMongon
     */
    @JsonProperty("GemmenTorikeshiShuruiHyojiMongon")
    public void setGemmenTorikeshiShuruiHyojiMongon(RString GemmenTorikeshiShuruiHyojiMongon) {
        this.GemmenTorikeshiShuruiHyojiMongon = GemmenTorikeshiShuruiHyojiMongon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IFukaRirekiAllDiv getDghukainfo() {
        return this.getChoshuYuyoFukaRirekiAll().getDghukainfo();
    }

    @JsonIgnore
    public Label getLblPrintMessage() {
        return this.getChoshuYuyoPrintinfo().getPritPublish1().getLblPrintMessage();
    }

    @JsonIgnore
    public void setLblPrintMessage(Label lblPrintMessage) {
        this.getChoshuYuyoPrintinfo().getPritPublish1().setLblPrintMessage(lblPrintMessage);
    }

    @JsonIgnore
    public pritPublish2Div getPritPublish2() {
        return this.getChoshuYuyoPrintinfo().getPritPublish1().getPritPublish2();
    }

    @JsonIgnore
    public void setPritPublish2(pritPublish2Div pritPublish2) {
        this.getChoshuYuyoPrintinfo().getPritPublish1().setPritPublish2(pritPublish2);
    }

    // </editor-fold>
}
