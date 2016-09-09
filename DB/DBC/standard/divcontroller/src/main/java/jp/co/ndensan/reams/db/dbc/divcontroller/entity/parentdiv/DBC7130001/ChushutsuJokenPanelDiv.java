package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuKubun")
    private RadioButton radChushutsuKubun;
    @JsonProperty("TekiyoKikan")
    private TekiyoKikanDiv TekiyoKikan;
    @JsonProperty("TekiyoKikanSetumei")
    private TekiyoKikanSetumeiDiv TekiyoKikanSetumei;
    @JsonProperty("radGendogakuKanriKikansu")
    private RadioButton radGendogakuKanriKikansu;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuKubun
     * @return radChushutsuKubun
     */
    @JsonProperty("radChushutsuKubun")
    public RadioButton getRadChushutsuKubun() {
        return radChushutsuKubun;
    }

    /*
     * setradChushutsuKubun
     * @param radChushutsuKubun radChushutsuKubun
     */
    @JsonProperty("radChushutsuKubun")
    public void setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.radChushutsuKubun = radChushutsuKubun;
    }

    /*
     * getTekiyoKikan
     * @return TekiyoKikan
     */
    @JsonProperty("TekiyoKikan")
    public TekiyoKikanDiv getTekiyoKikan() {
        return TekiyoKikan;
    }

    /*
     * setTekiyoKikan
     * @param TekiyoKikan TekiyoKikan
     */
    @JsonProperty("TekiyoKikan")
    public void setTekiyoKikan(TekiyoKikanDiv TekiyoKikan) {
        this.TekiyoKikan = TekiyoKikan;
    }

    /*
     * getTekiyoKikanSetumei
     * @return TekiyoKikanSetumei
     */
    @JsonProperty("TekiyoKikanSetumei")
    public TekiyoKikanSetumeiDiv getTekiyoKikanSetumei() {
        return TekiyoKikanSetumei;
    }

    /*
     * setTekiyoKikanSetumei
     * @param TekiyoKikanSetumei TekiyoKikanSetumei
     */
    @JsonProperty("TekiyoKikanSetumei")
    public void setTekiyoKikanSetumei(TekiyoKikanSetumeiDiv TekiyoKikanSetumei) {
        this.TekiyoKikanSetumei = TekiyoKikanSetumei;
    }

    /*
     * getradGendogakuKanriKikansu
     * @return radGendogakuKanriKikansu
     */
    @JsonProperty("radGendogakuKanriKikansu")
    public RadioButton getRadGendogakuKanriKikansu() {
        return radGendogakuKanriKikansu;
    }

    /*
     * setradGendogakuKanriKikansu
     * @param radGendogakuKanriKikansu radGendogakuKanriKikansu
     */
    @JsonProperty("radGendogakuKanriKikansu")
    public void setRadGendogakuKanriKikansu(RadioButton radGendogakuKanriKikansu) {
        this.radGendogakuKanriKikansu = radGendogakuKanriKikansu;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoKaishiNengetsu() {
        return this.getTekiyoKikan().getTxtTekiyoKaishiNengetsu();
    }

    @JsonIgnore
    public void  setTxtTekiyoKaishiNengetsu(TextBoxDateRange txtTekiyoKaishiNengetsu) {
        this.getTekiyoKikan().setTxtTekiyoKaishiNengetsu(txtTekiyoKaishiNengetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoShuryoNengetsu() {
        return this.getTekiyoKikan().getTxtTekiyoShuryoNengetsu();
    }

    @JsonIgnore
    public void  setTxtTekiyoShuryoNengetsu(TextBoxDateRange txtTekiyoShuryoNengetsu) {
        this.getTekiyoKikan().setTxtTekiyoShuryoNengetsu(txtTekiyoShuryoNengetsu);
    }

    @JsonIgnore
    public Space getYohaku() {
        return this.getTekiyoKikanSetumei().getYohaku();
    }

    @JsonIgnore
    public void  setYohaku(Space Yohaku) {
        this.getTekiyoKikanSetumei().setYohaku(Yohaku);
    }

    @JsonIgnore
    public Label getＬｂｌTekiyoKikanSetumei() {
        return this.getTekiyoKikanSetumei().getＬｂｌTekiyoKikanSetumei();
    }

    @JsonIgnore
    public void  setＬｂｌTekiyoKikanSetumei(Label ｌｂｌTekiyoKikanSetumei) {
        this.getTekiyoKikanSetumei().setＬｂｌTekiyoKikanSetumei(ｌｂｌTekiyoKikanSetumei);
    }

    // </editor-fold>
}
