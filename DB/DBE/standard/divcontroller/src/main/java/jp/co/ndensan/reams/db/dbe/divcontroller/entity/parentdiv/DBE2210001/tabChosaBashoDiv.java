package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabChosaBasho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabChosaBashoDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplZaitaku")
    private tplZaitakuDiv tplZaitaku;
    @JsonProperty("tplShisetsu")
    private tplShisetsuDiv tplShisetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplZaitaku
     * @return tplZaitaku
     */
    @JsonProperty("tplZaitaku")
    public tplZaitakuDiv getTplZaitaku() {
        return tplZaitaku;
    }

    /*
     * settplZaitaku
     * @param tplZaitaku tplZaitaku
     */
    @JsonProperty("tplZaitaku")
    public void setTplZaitaku(tplZaitakuDiv tplZaitaku) {
        this.tplZaitaku = tplZaitaku;
    }

    /*
     * gettplShisetsu
     * @return tplShisetsu
     */
    @JsonProperty("tplShisetsu")
    public tplShisetsuDiv getTplShisetsu() {
        return tplShisetsu;
    }

    /*
     * settplShisetsu
     * @param tplShisetsu tplShisetsu
     */
    @JsonProperty("tplShisetsu")
    public void setTplShisetsu(tplShisetsuDiv tplShisetsu) {
        this.tplShisetsu = tplShisetsu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getTplZaitaku().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void  setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getTplZaitaku().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void  setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public DataGrid<dgRiyoServiceJyokyo_Row> getDgRiyoServiceJyokyo() {
        return this.getTplZaitaku().getJutakuGaikyoChosa().getDgRiyoServiceJyokyo();
    }

    @JsonIgnore
    public void  setDgRiyoServiceJyokyo(DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo) {
        this.getTplZaitaku().getJutakuGaikyoChosa().setDgRiyoServiceJyokyo(dgRiyoServiceJyokyo);
    }

    @JsonIgnore
    public ShichosonTokubetsuKyufuDiv getShichosonTokubetsuKyufu() {
        return this.getTplZaitaku().getShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setShichosonTokubetsuKyufu(ShichosonTokubetsuKyufuDiv ShichosonTokubetsuKyufu) {
        this.getTplZaitaku().setShichosonTokubetsuKyufu(ShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public Label getLblShichosonTokubetsuKyufu() {
        return this.getTplZaitaku().getShichosonTokubetsuKyufu().getLblShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setLblShichosonTokubetsuKyufu(Label lblShichosonTokubetsuKyufu) {
        this.getTplZaitaku().getShichosonTokubetsuKyufu().setLblShichosonTokubetsuKyufu(lblShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public DynamicImage getImgShichosonTokubetsuKyufu() {
        return this.getTplZaitaku().getShichosonTokubetsuKyufu().getImgShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setImgShichosonTokubetsuKyufu(DynamicImage imgShichosonTokubetsuKyufu) {
        this.getTplZaitaku().getShichosonTokubetsuKyufu().setImgShichosonTokubetsuKyufu(imgShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShichosonTokubetsuKyufu() {
        return this.getTplZaitaku().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setTxtShichosonTokubetsuKyufu(TextBoxMultiLine txtShichosonTokubetsuKyufu) {
        this.getTplZaitaku().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuIgaiJutakuService() {
        return this.getTplZaitaku().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void  setTxtKyufuIgaiJutakuService(TextBoxMultiLine txtKyufuIgaiJutakuService) {
        this.getTplZaitaku().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
    }

    @JsonIgnore
    public ZaitakuServiceDiv getZaitakuService() {
        return this.getTplZaitaku().getZaitakuService();
    }

    @JsonIgnore
    public void  setZaitakuService(ZaitakuServiceDiv ZaitakuService) {
        this.getTplZaitaku().setZaitakuService(ZaitakuService);
    }

    @JsonIgnore
    public Label getLblZaitakuService() {
        return this.getTplZaitaku().getZaitakuService().getLblZaitakuService();
    }

    @JsonIgnore
    public void  setLblZaitakuService(Label lblZaitakuService) {
        this.getTplZaitaku().getZaitakuService().setLblZaitakuService(lblZaitakuService);
    }

    @JsonIgnore
    public DynamicImage getImgZaitakuService() {
        return this.getTplZaitaku().getZaitakuService().getImgZaitakuService();
    }

    @JsonIgnore
    public void  setImgZaitakuService(DynamicImage imgZaitakuService) {
        this.getTplZaitaku().getZaitakuService().setImgZaitakuService(imgZaitakuService);
    }

    @JsonIgnore
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return this.getTplShisetsu().getGaikyoTokkiShisetsu();
    }

    @JsonIgnore
    public void  setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.getTplShisetsu().setGaikyoTokkiShisetsu(GaikyoTokkiShisetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getTplShisetsu().getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void  setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getTplShisetsu().getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return this.getTplShisetsu().getGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void  setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.getTplShisetsu().setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void  setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void  setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTplShisetsu().getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public ImageGaigyoShisetsuRenrakusakiDiv getImageGaigyoShisetsuRenrakusaki() {
        return this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki();
    }

    @JsonIgnore
    public void  setImageGaigyoShisetsuRenrakusaki(ImageGaigyoShisetsuRenrakusakiDiv ImageGaigyoShisetsuRenrakusaki) {
        this.getTplShisetsu().setImageGaigyoShisetsuRenrakusaki(ImageGaigyoShisetsuRenrakusaki);
    }

    @JsonIgnore
    public Label getLblShisetsuMeisho() {
        return this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLblShisetsuMeisho();
    }

    @JsonIgnore
    public void  setLblShisetsuMeisho(Label lblShisetsuMeisho) {
        this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLblShisetsuMeisho(lblShisetsuMeisho);
    }

    @JsonIgnore
    public DynamicImage getImgShisetsuMeisho() {
        return this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgShisetsuMeisho();
    }

    @JsonIgnore
    public void  setImgShisetsuMeisho(DynamicImage imgShisetsuMeisho) {
        this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgShisetsuMeisho(imgShisetsuMeisho);
    }

    @JsonIgnore
    public Label getLblJusho() {
        return this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLblJusho();
    }

    @JsonIgnore
    public void  setLblJusho(Label lblJusho) {
        this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLblJusho(lblJusho);
    }

    @JsonIgnore
    public DynamicImage getImgJusho() {
        return this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgJusho();
    }

    @JsonIgnore
    public void  setImgJusho(DynamicImage imgJusho) {
        this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgJusho(imgJusho);
    }

    @JsonIgnore
    public Label getLbTel() {
        return this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getLbTel();
    }

    @JsonIgnore
    public void  setLbTel(Label lbTel) {
        this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setLbTel(lbTel);
    }

    @JsonIgnore
    public DynamicImage getImgTel() {
        return this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgTel();
    }

    @JsonIgnore
    public void  setImgTel(DynamicImage imgTel) {
        this.getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setImgTel(imgTel);
    }

    // </editor-fold>
}
