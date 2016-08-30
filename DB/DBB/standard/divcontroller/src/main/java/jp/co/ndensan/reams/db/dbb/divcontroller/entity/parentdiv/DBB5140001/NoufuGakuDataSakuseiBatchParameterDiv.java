package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * NoufuGakuDataSakuseiBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class NoufuGakuDataSakuseiBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriNaiyo")
    private ShoriNaiyoDiv ShoriNaiyo;
    @JsonProperty("ChushutsuKikan")
    private ChushutsuKikanDiv ChushutsuKikan;
    @JsonProperty("KoikiShori")
    private KoikiShoriDiv KoikiShori;
    @JsonProperty("ShoriSelect")
    private ShoriSelectDiv ShoriSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriNaiyo
     * @return ShoriNaiyo
     */
    @JsonProperty("ShoriNaiyo")
    public ShoriNaiyoDiv getShoriNaiyo() {
        return ShoriNaiyo;
    }

    /*
     * setShoriNaiyo
     * @param ShoriNaiyo ShoriNaiyo
     */
    @JsonProperty("ShoriNaiyo")
    public void setShoriNaiyo(ShoriNaiyoDiv ShoriNaiyo) {
        this.ShoriNaiyo = ShoriNaiyo;
    }

    /*
     * getChushutsuKikan
     * @return ChushutsuKikan
     */
    @JsonProperty("ChushutsuKikan")
    public ChushutsuKikanDiv getChushutsuKikan() {
        return ChushutsuKikan;
    }

    /*
     * setChushutsuKikan
     * @param ChushutsuKikan ChushutsuKikan
     */
    @JsonProperty("ChushutsuKikan")
    public void setChushutsuKikan(ChushutsuKikanDiv ChushutsuKikan) {
        this.ChushutsuKikan = ChushutsuKikan;
    }

    /*
     * getKoikiShori
     * @return KoikiShori
     */
    @JsonProperty("KoikiShori")
    public KoikiShoriDiv getKoikiShori() {
        return KoikiShori;
    }

    /*
     * setKoikiShori
     * @param KoikiShori KoikiShori
     */
    @JsonProperty("KoikiShori")
    public void setKoikiShori(KoikiShoriDiv KoikiShori) {
        this.KoikiShori = KoikiShori;
    }

    /*
     * getShoriSelect
     * @return ShoriSelect
     */
    @JsonProperty("ShoriSelect")
    public ShoriSelectDiv getShoriSelect() {
        return ShoriSelect;
    }

    /*
     * setShoriSelect
     * @param ShoriSelect ShoriSelect
     */
    @JsonProperty("ShoriSelect")
    public void setShoriSelect(ShoriSelectDiv ShoriSelect) {
        this.ShoriSelect = ShoriSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtTaishoNendo() {
        return this.getShoriNaiyo().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.getShoriNaiyo().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public DataGrid<dgTanitsuShoriJoken_Row> getDgTanitsuShoriJoken() {
        return this.getChushutsuKikan().getDgTanitsuShoriJoken();
    }

    @JsonIgnore
    public void setDgTanitsuShoriJoken(DataGrid<dgTanitsuShoriJoken_Row> dgTanitsuShoriJoken) {
        this.getChushutsuKikan().setDgTanitsuShoriJoken(dgTanitsuShoriJoken);
    }

    @JsonIgnore
    public DataGrid<dgKoikiShoriTaishoSelect_Row> getDgKoikiShoriTaishoSelect() {
        return this.getKoikiShori().getDgKoikiShoriTaishoSelect();
    }

    @JsonIgnore
    public void setDgKoikiShoriTaishoSelect(DataGrid<dgKoikiShoriTaishoSelect_Row> dgKoikiShoriTaishoSelect) {
        this.getKoikiShori().setDgKoikiShoriTaishoSelect(dgKoikiShoriTaishoSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkHikazeiNomiSakusei() {
        return this.getShoriSelect().getChkHikazeiNomiSakusei();
    }

    @JsonIgnore
    public void setChkHikazeiNomiSakusei(CheckBoxList chkHikazeiNomiSakusei) {
        this.getShoriSelect().setChkHikazeiNomiSakusei(chkHikazeiNomiSakusei);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getShoriSelect().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
