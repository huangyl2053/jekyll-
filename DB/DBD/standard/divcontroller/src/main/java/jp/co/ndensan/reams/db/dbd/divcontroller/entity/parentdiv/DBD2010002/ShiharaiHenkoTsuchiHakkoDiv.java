package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShiharaiHenkoTsuchiHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShiharaiHenkoTsuchiHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShiharaiHenkoTsuchiHakkoRireki")
    private ShiharaiHenkoTsuchiHakkoRirekiDiv ShiharaiHenkoTsuchiHakkoRireki;
    @JsonProperty("YokokuTsuchisho")
    private YokokuTsuchishoDiv YokokuTsuchisho;
    @JsonProperty("HenkoTsuchisho")
    private HenkoTsuchishoDiv HenkoTsuchisho;
    @JsonProperty("KojoTsuchisho")
    private KojoTsuchishoDiv KojoTsuchisho;
    @JsonProperty("SashitomeTsuchisho")
    private SashitomeTsuchishoDiv SashitomeTsuchisho;
    @JsonProperty("GengakuTsuchisho")
    private GengakuTsuchishoDiv GengakuTsuchisho;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShiharaiHenkoTsuchiHakkoRireki
     * @return ShiharaiHenkoTsuchiHakkoRireki
     */
    @JsonProperty("ShiharaiHenkoTsuchiHakkoRireki")
    public ShiharaiHenkoTsuchiHakkoRirekiDiv getShiharaiHenkoTsuchiHakkoRireki() {
        return ShiharaiHenkoTsuchiHakkoRireki;
    }

    /*
     * setShiharaiHenkoTsuchiHakkoRireki
     * @param ShiharaiHenkoTsuchiHakkoRireki ShiharaiHenkoTsuchiHakkoRireki
     */
    @JsonProperty("ShiharaiHenkoTsuchiHakkoRireki")
    public void setShiharaiHenkoTsuchiHakkoRireki(ShiharaiHenkoTsuchiHakkoRirekiDiv ShiharaiHenkoTsuchiHakkoRireki) {
        this.ShiharaiHenkoTsuchiHakkoRireki = ShiharaiHenkoTsuchiHakkoRireki;
    }

    /*
     * getYokokuTsuchisho
     * @return YokokuTsuchisho
     */
    @JsonProperty("YokokuTsuchisho")
    public YokokuTsuchishoDiv getYokokuTsuchisho() {
        return YokokuTsuchisho;
    }

    /*
     * setYokokuTsuchisho
     * @param YokokuTsuchisho YokokuTsuchisho
     */
    @JsonProperty("YokokuTsuchisho")
    public void setYokokuTsuchisho(YokokuTsuchishoDiv YokokuTsuchisho) {
        this.YokokuTsuchisho = YokokuTsuchisho;
    }

    /*
     * getHenkoTsuchisho
     * @return HenkoTsuchisho
     */
    @JsonProperty("HenkoTsuchisho")
    public HenkoTsuchishoDiv getHenkoTsuchisho() {
        return HenkoTsuchisho;
    }

    /*
     * setHenkoTsuchisho
     * @param HenkoTsuchisho HenkoTsuchisho
     */
    @JsonProperty("HenkoTsuchisho")
    public void setHenkoTsuchisho(HenkoTsuchishoDiv HenkoTsuchisho) {
        this.HenkoTsuchisho = HenkoTsuchisho;
    }

    /*
     * getKojoTsuchisho
     * @return KojoTsuchisho
     */
    @JsonProperty("KojoTsuchisho")
    public KojoTsuchishoDiv getKojoTsuchisho() {
        return KojoTsuchisho;
    }

    /*
     * setKojoTsuchisho
     * @param KojoTsuchisho KojoTsuchisho
     */
    @JsonProperty("KojoTsuchisho")
    public void setKojoTsuchisho(KojoTsuchishoDiv KojoTsuchisho) {
        this.KojoTsuchisho = KojoTsuchisho;
    }

    /*
     * getSashitomeTsuchisho
     * @return SashitomeTsuchisho
     */
    @JsonProperty("SashitomeTsuchisho")
    public SashitomeTsuchishoDiv getSashitomeTsuchisho() {
        return SashitomeTsuchisho;
    }

    /*
     * setSashitomeTsuchisho
     * @param SashitomeTsuchisho SashitomeTsuchisho
     */
    @JsonProperty("SashitomeTsuchisho")
    public void setSashitomeTsuchisho(SashitomeTsuchishoDiv SashitomeTsuchisho) {
        this.SashitomeTsuchisho = SashitomeTsuchisho;
    }

    /*
     * getGengakuTsuchisho
     * @return GengakuTsuchisho
     */
    @JsonProperty("GengakuTsuchisho")
    public GengakuTsuchishoDiv getGengakuTsuchisho() {
        return GengakuTsuchisho;
    }

    /*
     * setGengakuTsuchisho
     * @param GengakuTsuchisho GengakuTsuchisho
     */
    @JsonProperty("GengakuTsuchisho")
    public void setGengakuTsuchisho(GengakuTsuchishoDiv GengakuTsuchisho) {
        this.GengakuTsuchisho = GengakuTsuchisho;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgShiharaiHohoHenkoRireki_Row> getDgShiharaiHohoHenkoRireki() {
        return this.getShiharaiHenkoTsuchiHakkoRireki().getDgShiharaiHohoHenkoRireki();
    }

    @JsonIgnore
    public void  setDgShiharaiHohoHenkoRireki(DataGrid<dgShiharaiHohoHenkoRireki_Row> dgShiharaiHohoHenkoRireki) {
        this.getShiharaiHenkoTsuchiHakkoRireki().setDgShiharaiHohoHenkoRireki(dgShiharaiHohoHenkoRireki);
    }

    @JsonIgnore
    public TextBoxDate getTxtYokokuTsuchishoHakkoDate() {
        return this.getYokokuTsuchisho().getTxtYokokuTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtYokokuTsuchishoHakkoDate(TextBoxDate txtYokokuTsuchishoHakkoDate) {
        this.getYokokuTsuchisho().setTxtYokokuTsuchishoHakkoDate(txtYokokuTsuchishoHakkoDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdYokokuTsuchishoBunshoNo() {
        return this.getYokokuTsuchisho().getCcdYokokuTsuchishoBunshoNo();
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoTsuchishoHakkoDate() {
        return this.getHenkoTsuchisho().getTxtHenkoTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtHenkoTsuchishoHakkoDate(TextBoxDate txtHenkoTsuchishoHakkoDate) {
        this.getHenkoTsuchisho().setTxtHenkoTsuchishoHakkoDate(txtHenkoTsuchishoHakkoDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdHenkoTsuchishoBunshoNo() {
        return this.getHenkoTsuchisho().getCcdHenkoTsuchishoBunshoNo();
    }

    @JsonIgnore
    public TextBoxDate getTxtKojoTsuchishoHakkoDate() {
        return this.getKojoTsuchisho().getTxtKojoTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtKojoTsuchishoHakkoDate(TextBoxDate txtKojoTsuchishoHakkoDate) {
        this.getKojoTsuchisho().setTxtKojoTsuchishoHakkoDate(txtKojoTsuchishoHakkoDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdKojoTsuchishoBunshoNo() {
        return this.getKojoTsuchisho().getCcdKojoTsuchishoBunshoNo();
    }

    @JsonIgnore
    public TextBoxDate getTxtSashitomeTsuchishoHakkoDate() {
        return this.getSashitomeTsuchisho().getTxtSashitomeTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtSashitomeTsuchishoHakkoDate(TextBoxDate txtSashitomeTsuchishoHakkoDate) {
        this.getSashitomeTsuchisho().setTxtSashitomeTsuchishoHakkoDate(txtSashitomeTsuchishoHakkoDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdSashitomeTsuchishoBunshoNo() {
        return this.getSashitomeTsuchisho().getCcdSashitomeTsuchishoBunshoNo();
    }

    @JsonIgnore
    public TextBoxDate getTxtGengakuTsuchishoHakkoDate() {
        return this.getGengakuTsuchisho().getTxtGengakuTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtGengakuTsuchishoHakkoDate(TextBoxDate txtGengakuTsuchishoHakkoDate) {
        this.getGengakuTsuchisho().setTxtGengakuTsuchishoHakkoDate(txtGengakuTsuchishoHakkoDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdGengakuTsuchishoBunshoNo() {
        return this.getGengakuTsuchisho().getCcdGengakuTsuchishoBunshoNo();
    }

    // </editor-fold>
}
