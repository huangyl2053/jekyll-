package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplZaitaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplZaitakuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJutakuKaishu")
    private RadioButton radJutakuKaishu;
    @JsonProperty("JutakuGaikyoChosa")
    private JutakuGaikyoChosaDiv JutakuGaikyoChosa;
    @JsonProperty("ShichosonTokubetsuKyufu")
    private ShichosonTokubetsuKyufuDiv ShichosonTokubetsuKyufu;
    @JsonProperty("txtShichosonTokubetsuKyufu")
    private TextBoxMultiLine txtShichosonTokubetsuKyufu;
    @JsonProperty("txtKyufuIgaiJutakuService")
    private TextBoxMultiLine txtKyufuIgaiJutakuService;
    @JsonProperty("ZaitakuService")
    private ZaitakuServiceDiv ZaitakuService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJutakuKaishu
     * @return radJutakuKaishu
     */
    @JsonProperty("radJutakuKaishu")
    public RadioButton getRadJutakuKaishu() {
        return radJutakuKaishu;
    }

    /*
     * setradJutakuKaishu
     * @param radJutakuKaishu radJutakuKaishu
     */
    @JsonProperty("radJutakuKaishu")
    public void setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.radJutakuKaishu = radJutakuKaishu;
    }

    /*
     * getJutakuGaikyoChosa
     * @return JutakuGaikyoChosa
     */
    @JsonProperty("JutakuGaikyoChosa")
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return JutakuGaikyoChosa;
    }

    /*
     * setJutakuGaikyoChosa
     * @param JutakuGaikyoChosa JutakuGaikyoChosa
     */
    @JsonProperty("JutakuGaikyoChosa")
    public void setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.JutakuGaikyoChosa = JutakuGaikyoChosa;
    }

    /*
     * getShichosonTokubetsuKyufu
     * @return ShichosonTokubetsuKyufu
     */
    @JsonProperty("ShichosonTokubetsuKyufu")
    public ShichosonTokubetsuKyufuDiv getShichosonTokubetsuKyufu() {
        return ShichosonTokubetsuKyufu;
    }

    /*
     * setShichosonTokubetsuKyufu
     * @param ShichosonTokubetsuKyufu ShichosonTokubetsuKyufu
     */
    @JsonProperty("ShichosonTokubetsuKyufu")
    public void setShichosonTokubetsuKyufu(ShichosonTokubetsuKyufuDiv ShichosonTokubetsuKyufu) {
        this.ShichosonTokubetsuKyufu = ShichosonTokubetsuKyufu;
    }

    /*
     * gettxtShichosonTokubetsuKyufu
     * @return txtShichosonTokubetsuKyufu
     */
    @JsonProperty("txtShichosonTokubetsuKyufu")
    public TextBoxMultiLine getTxtShichosonTokubetsuKyufu() {
        return txtShichosonTokubetsuKyufu;
    }

    /*
     * settxtShichosonTokubetsuKyufu
     * @param txtShichosonTokubetsuKyufu txtShichosonTokubetsuKyufu
     */
    @JsonProperty("txtShichosonTokubetsuKyufu")
    public void setTxtShichosonTokubetsuKyufu(TextBoxMultiLine txtShichosonTokubetsuKyufu) {
        this.txtShichosonTokubetsuKyufu = txtShichosonTokubetsuKyufu;
    }

    /*
     * gettxtKyufuIgaiJutakuService
     * @return txtKyufuIgaiJutakuService
     */
    @JsonProperty("txtKyufuIgaiJutakuService")
    public TextBoxMultiLine getTxtKyufuIgaiJutakuService() {
        return txtKyufuIgaiJutakuService;
    }

    /*
     * settxtKyufuIgaiJutakuService
     * @param txtKyufuIgaiJutakuService txtKyufuIgaiJutakuService
     */
    @JsonProperty("txtKyufuIgaiJutakuService")
    public void setTxtKyufuIgaiJutakuService(TextBoxMultiLine txtKyufuIgaiJutakuService) {
        this.txtKyufuIgaiJutakuService = txtKyufuIgaiJutakuService;
    }

    /*
     * getZaitakuService
     * @return ZaitakuService
     */
    @JsonProperty("ZaitakuService")
    public ZaitakuServiceDiv getZaitakuService() {
        return ZaitakuService;
    }

    /*
     * setZaitakuService
     * @param ZaitakuService ZaitakuService
     */
    @JsonProperty("ZaitakuService")
    public void setZaitakuService(ZaitakuServiceDiv ZaitakuService) {
        this.ZaitakuService = ZaitakuService;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgRiyoServiceJyokyo_Row> getDgRiyoServiceJyokyo() {
        return this.getJutakuGaikyoChosa().getDgRiyoServiceJyokyo();
    }

    @JsonIgnore
    public void  setDgRiyoServiceJyokyo(DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo) {
        this.getJutakuGaikyoChosa().setDgRiyoServiceJyokyo(dgRiyoServiceJyokyo);
    }

    @JsonIgnore
    public Label getLblShichosonTokubetsuKyufu() {
        return this.getShichosonTokubetsuKyufu().getLblShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setLblShichosonTokubetsuKyufu(Label lblShichosonTokubetsuKyufu) {
        this.getShichosonTokubetsuKyufu().setLblShichosonTokubetsuKyufu(lblShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public DynamicImage getImgShichosonTokubetsuKyufu() {
        return this.getShichosonTokubetsuKyufu().getImgShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setImgShichosonTokubetsuKyufu(DynamicImage imgShichosonTokubetsuKyufu) {
        this.getShichosonTokubetsuKyufu().setImgShichosonTokubetsuKyufu(imgShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public Label getLblZaitakuService() {
        return this.getZaitakuService().getLblZaitakuService();
    }

    @JsonIgnore
    public void  setLblZaitakuService(Label lblZaitakuService) {
        this.getZaitakuService().setLblZaitakuService(lblZaitakuService);
    }

    @JsonIgnore
    public DynamicImage getImgZaitakuService() {
        return this.getZaitakuService().getImgZaitakuService();
    }

    @JsonIgnore
    public void  setImgZaitakuService(DynamicImage imgZaitakuService) {
        this.getZaitakuService().setImgZaitakuService(imgZaitakuService);
    }

    // </editor-fold>
}
