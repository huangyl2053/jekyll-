package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuKetteiTsuchishoHakkou のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiTsuchishoHakkouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLine")
    private HorizontalLine linLine;
    @JsonProperty("ddlServiceTeikyoYM")
    private DropDownList ddlServiceTeikyoYM;
    @JsonProperty("ddlSeiriNO")
    private DropDownList ddlSeiriNO;
    @JsonProperty("ShokanShikyuKetteiTsuchishoHakkouPrint")
    private ShokanShikyuKetteiTsuchishoHakkouPrintDiv ShokanShikyuKetteiTsuchishoHakkouPrint;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ShokanShikyuKetteiTsuchishoSakuseiKaigoKihon")
    private KaigoShikakuKihonDiv ShokanShikyuKetteiTsuchishoSakuseiKaigoKihon;
    @JsonProperty("ShokanShikyuKetteiTsuchishoHakkouKihon")
    private KaigoAtenaInfoDiv ShokanShikyuKetteiTsuchishoHakkouKihon;

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
     * getddlServiceTeikyoYM
     * @return ddlServiceTeikyoYM
     */
    @JsonProperty("ddlServiceTeikyoYM")
    public DropDownList getDdlServiceTeikyoYM() {
        return ddlServiceTeikyoYM;
    }

    /*
     * setddlServiceTeikyoYM
     * @param ddlServiceTeikyoYM ddlServiceTeikyoYM
     */
    @JsonProperty("ddlServiceTeikyoYM")
    public void setDdlServiceTeikyoYM(DropDownList ddlServiceTeikyoYM) {
        this.ddlServiceTeikyoYM = ddlServiceTeikyoYM;
    }

    /*
     * getddlSeiriNO
     * @return ddlSeiriNO
     */
    @JsonProperty("ddlSeiriNO")
    public DropDownList getDdlSeiriNO() {
        return ddlSeiriNO;
    }

    /*
     * setddlSeiriNO
     * @param ddlSeiriNO ddlSeiriNO
     */
    @JsonProperty("ddlSeiriNO")
    public void setDdlSeiriNO(DropDownList ddlSeiriNO) {
        this.ddlSeiriNO = ddlSeiriNO;
    }

    /*
     * getShokanShikyuKetteiTsuchishoHakkouPrint
     * @return ShokanShikyuKetteiTsuchishoHakkouPrint
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoHakkouPrint")
    public ShokanShikyuKetteiTsuchishoHakkouPrintDiv getShokanShikyuKetteiTsuchishoHakkouPrint() {
        return ShokanShikyuKetteiTsuchishoHakkouPrint;
    }

    /*
     * setShokanShikyuKetteiTsuchishoHakkouPrint
     * @param ShokanShikyuKetteiTsuchishoHakkouPrint ShokanShikyuKetteiTsuchishoHakkouPrint
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoHakkouPrint")
    public void setShokanShikyuKetteiTsuchishoHakkouPrint(ShokanShikyuKetteiTsuchishoHakkouPrintDiv ShokanShikyuKetteiTsuchishoHakkouPrint) {
        this.ShokanShikyuKetteiTsuchishoHakkouPrint = ShokanShikyuKetteiTsuchishoHakkouPrint;
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
     * getShokanShikyuKetteiTsuchishoSakuseiKaigoKihon
     * @return ShokanShikyuKetteiTsuchishoSakuseiKaigoKihon
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoSakuseiKaigoKihon")
    public IKaigoShikakuKihonDiv getShokanShikyuKetteiTsuchishoSakuseiKaigoKihon() {
        return ShokanShikyuKetteiTsuchishoSakuseiKaigoKihon;
    }

    /*
     * getShokanShikyuKetteiTsuchishoHakkouKihon
     * @return ShokanShikyuKetteiTsuchishoHakkouKihon
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoHakkouKihon")
    public IKaigoAtenaInfoDiv getShokanShikyuKetteiTsuchishoHakkouKihon() {
        return ShokanShikyuKetteiTsuchishoHakkouKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtHakkouYMD() {
        return this.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtHakkouYMD();
    }

    @JsonIgnore
    public void  setTxtHakkouYMD(TextBoxDate txtHakkouYMD) {
        this.getShokanShikyuKetteiTsuchishoHakkouPrint().setTxtHakkouYMD(txtHakkouYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiHakkoYMD() {
        return this.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtZenkaiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiHakkoYMD(TextBoxDate txtZenkaiHakkoYMD) {
        this.getShokanShikyuKetteiTsuchishoHakkouPrint().setTxtZenkaiHakkoYMD(txtZenkaiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiharaiYoteiYMD() {
        return this.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtShiharaiYoteiYMD();
    }

    @JsonIgnore
    public void  setTxtShiharaiYoteiYMD(TextBoxDate txtShiharaiYoteiYMD) {
        this.getShokanShikyuKetteiTsuchishoHakkouPrint().setTxtShiharaiYoteiYMD(txtShiharaiYoteiYMD);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoNO() {
        return this.getShokanShikyuKetteiTsuchishoHakkouPrint().getCcdBunshoNO();
    }

    // </editor-fold>
}
