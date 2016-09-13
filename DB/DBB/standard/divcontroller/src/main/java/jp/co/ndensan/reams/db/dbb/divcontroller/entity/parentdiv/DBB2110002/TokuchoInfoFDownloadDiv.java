package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuchoInfoFDownload のクラスファイル
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class TokuchoInfoFDownloadDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyo")
    private ShoriJokyoDiv ShoriJokyo;
    @JsonProperty("KoikiShoriSelect")
    private KoikiShoriSelectDiv KoikiShoriSelect;
    @JsonProperty("TsukiShoriSelect")
    private TsukiShoriSelectDiv TsukiShoriSelect;
    @JsonProperty("Kanryo")
    private KanryoDiv Kanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriJokyo
     * @return ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public ShoriJokyoDiv getShoriJokyo() {
        return ShoriJokyo;
    }

    /*
     * setShoriJokyo
     * @param ShoriJokyo ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public void setShoriJokyo(ShoriJokyoDiv ShoriJokyo) {
        this.ShoriJokyo = ShoriJokyo;
    }

    /*
     * getKoikiShoriSelect
     * @return KoikiShoriSelect
     */
    @JsonProperty("KoikiShoriSelect")
    public KoikiShoriSelectDiv getKoikiShoriSelect() {
        return KoikiShoriSelect;
    }

    /*
     * setKoikiShoriSelect
     * @param KoikiShoriSelect KoikiShoriSelect
     */
    @JsonProperty("KoikiShoriSelect")
    public void setKoikiShoriSelect(KoikiShoriSelectDiv KoikiShoriSelect) {
        this.KoikiShoriSelect = KoikiShoriSelect;
    }

    /*
     * getTsukiShoriSelect
     * @return TsukiShoriSelect
     */
    @JsonProperty("TsukiShoriSelect")
    public TsukiShoriSelectDiv getTsukiShoriSelect() {
        return TsukiShoriSelect;
    }

    /*
     * setTsukiShoriSelect
     * @param TsukiShoriSelect TsukiShoriSelect
     */
    @JsonProperty("TsukiShoriSelect")
    public void setTsukiShoriSelect(TsukiShoriSelectDiv TsukiShoriSelect) {
        this.TsukiShoriSelect = TsukiShoriSelect;
    }

    /*
     * getKanryo
     * @return Kanryo
     */
    @JsonProperty("Kanryo")
    public KanryoDiv getKanryo() {
        return Kanryo;
    }

    /*
     * setKanryo
     * @param Kanryo Kanryo
     */
    @JsonProperty("Kanryo")
    public void setKanryo(KanryoDiv Kanryo) {
        this.Kanryo = Kanryo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TokuchoInfoDownloadShoriNaiyoDiv getTokuchoInfoDownloadShoriNaiyo() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo();
    }

    @JsonIgnore
    public void setTokuchoInfoDownloadShoriNaiyo(TokuchoInfoDownloadShoriNaiyoDiv TokuchoInfoDownloadShoriNaiyo) {
        this.getShoriJokyo().setTokuchoInfoDownloadShoriNaiyo(TokuchoInfoDownloadShoriNaiyo);
    }

    @JsonIgnore
    public Label getLblChoteiNendo() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getLblChoteiNendo();
    }

    @JsonIgnore
    public void setLblChoteiNendo(Label lblChoteiNendo) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().setLblChoteiNendo(lblChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriNendo() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo();
    }

    @JsonIgnore
    public void setTxtShoriNendo(TextBoxDate txtShoriNendo) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public ShoriTaishoShichoshonTsukiDiv getShoriTaishoShichoshonTsuki() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki();
    }

    @JsonIgnore
    public void setShoriTaishoShichoshonTsuki(ShoriTaishoShichoshonTsukiDiv ShoriTaishoShichoshonTsuki) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().setShoriTaishoShichoshonTsuki(ShoriTaishoShichoshonTsuki);
    }

    @JsonIgnore
    public RadioButton getRadShichosonSelect() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getRadShichosonSelect();
    }

    @JsonIgnore
    public void setRadShichosonSelect(RadioButton radShichosonSelect) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setRadShichosonSelect(radShichosonSelect);
    }

    @JsonIgnore
    public DropDownList getDdlShichosonSelect() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getDdlShichosonSelect();
    }

    @JsonIgnore
    public void setDdlShichosonSelect(DropDownList ddlShichosonSelect) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setDdlShichosonSelect(ddlShichosonSelect);
    }

    @JsonIgnore
    public RadioButton getRadTsukiSelect() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getRadTsukiSelect();
    }

    @JsonIgnore
    public void setRadTsukiSelect(RadioButton radTsukiSelect) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setRadTsukiSelect(radTsukiSelect);
    }

    @JsonIgnore
    public DropDownList getDdlTsuki() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().getDdlTsuki();
    }

    @JsonIgnore
    public void setDdlTsuki(DropDownList ddlTsuki) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriNaiyo().getShoriTaishoShichoshonTsuki().setDdlTsuki(ddlTsuki);
    }

    @JsonIgnore
    public TokuchoInfoDownloadShoriKakuninDiv getTokuchoInfoDownloadShoriKakunin() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriKakunin();
    }

    @JsonIgnore
    public void setTokuchoInfoDownloadShoriKakunin(TokuchoInfoDownloadShoriKakuninDiv TokuchoInfoDownloadShoriKakunin) {
        this.getShoriJokyo().setTokuchoInfoDownloadShoriKakunin(TokuchoInfoDownloadShoriKakunin);
    }

    @JsonIgnore
    public DataGrid<dgShoriKakunin_Row> getDgShoriKakunin() {
        return this.getShoriJokyo().getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin();
    }

    @JsonIgnore
    public void setDgShoriKakunin(DataGrid<dgShoriKakunin_Row> dgShoriKakunin) {
        this.getShoriJokyo().getTokuchoInfoDownloadShoriKakunin().setDgShoriKakunin(dgShoriKakunin);
    }

    @JsonIgnore
    public DataGrid<dgkoikiShoriSelect_Row> getDgkoikiShoriSelect() {
        return this.getKoikiShoriSelect().getDgkoikiShoriSelect();
    }

    @JsonIgnore
    public void setDgkoikiShoriSelect(DataGrid<dgkoikiShoriSelect_Row> dgkoikiShoriSelect) {
        this.getKoikiShoriSelect().setDgkoikiShoriSelect(dgkoikiShoriSelect);
    }

    @JsonIgnore
    public DataGrid<dgTsukiShoriSelect_Row> getDgTsukiShoriSelect() {
        return this.getTsukiShoriSelect().getDgTsukiShoriSelect();
    }

    @JsonIgnore
    public void setDgTsukiShoriSelect(DataGrid<dgTsukiShoriSelect_Row> dgTsukiShoriSelect) {
        this.getTsukiShoriSelect().setDgTsukiShoriSelect(dgTsukiShoriSelect);
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return this.getKanryo().getCcdKanryoMessage();
    }

    // </editor-fold>
}
