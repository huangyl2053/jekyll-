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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return this.getTplZaitaku().getJutakuGaikyoChosa();
    }

    @JsonIgnore
    public void  setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.getTplZaitaku().setJutakuGaikyoChosa(JutakuGaikyoChosa);
    }

    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getTplZaitaku().getJutakuGaikyoChosa().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void  setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getTplZaitaku().getJutakuGaikyoChosa().setRadJutakuKaishu(radJutakuKaishu);
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
    public TextBox getTxtShichosonTokubetsuKyufu() {
        return this.getTplZaitaku().getJutakuGaikyoChosa().getTxtShichosonTokubetsuKyufu();
    }

    @JsonIgnore
    public void  setTxtShichosonTokubetsuKyufu(TextBox txtShichosonTokubetsuKyufu) {
        this.getTplZaitaku().getJutakuGaikyoChosa().setTxtShichosonTokubetsuKyufu(txtShichosonTokubetsuKyufu);
    }

    @JsonIgnore
    public TextBox getTxtKyufuIgaiJutakuService() {
        return this.getTplZaitaku().getJutakuGaikyoChosa().getTxtKyufuIgaiJutakuService();
    }

    @JsonIgnore
    public void  setTxtKyufuIgaiJutakuService(TextBox txtKyufuIgaiJutakuService) {
        this.getTplZaitaku().getJutakuGaikyoChosa().setTxtKyufuIgaiJutakuService(txtKyufuIgaiJutakuService);
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

    // </editor-fold>
}
