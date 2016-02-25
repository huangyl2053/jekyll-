package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Idochekkurisuto のクラスファイル 
 * 
 * @author 自動生成
 */
public class IdochekkurisutoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BatchParamterInfo")
    private BatchParamterInfoDiv BatchParamterInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBatchParamterInfo
     * @return BatchParamterInfo
     */
    @JsonProperty("BatchParamterInfo")
    public BatchParamterInfoDiv getBatchParamterInfo() {
        return BatchParamterInfo;
    }

    /*
     * setBatchParamterInfo
     * @param BatchParamterInfo BatchParamterInfo
     */
    @JsonProperty("BatchParamterInfo")
    public void setBatchParamterInfo(BatchParamterInfoDiv BatchParamterInfo) {
        this.BatchParamterInfo = BatchParamterInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChktaishodaicho() {
        return this.getBatchParamterInfo().getChktaishodaicho();
    }

    @JsonIgnore
    public void  setChktaishodaicho(CheckBoxList chktaishodaicho) {
        this.getBatchParamterInfo().setChktaishodaicho(chktaishodaicho);
    }

    @JsonIgnore
    public HorizontalLine getHLine1() {
        return this.getBatchParamterInfo().getHLine1();
    }

    @JsonIgnore
    public void  setHLine1(HorizontalLine HLine1) {
        this.getBatchParamterInfo().setHLine1(HLine1);
    }

    @JsonIgnore
    public Label getLblidotasyo() {
        return this.getBatchParamterInfo().getLblidotasyo();
    }

    @JsonIgnore
    public void  setLblidotasyo(Label lblidotasyo) {
        this.getBatchParamterInfo().setLblidotasyo(lblidotasyo);
    }

    @JsonIgnore
    public Label getLblKaishiDate() {
        return this.getBatchParamterInfo().getLblKaishiDate();
    }

    @JsonIgnore
    public void  setLblKaishiDate(Label lblKaishiDate) {
        this.getBatchParamterInfo().setLblKaishiDate(lblKaishiDate);
    }

    @JsonIgnore
    public Label getLblShuryoDate() {
        return this.getBatchParamterInfo().getLblShuryoDate();
    }

    @JsonIgnore
    public void  setLblShuryoDate(Label lblShuryoDate) {
        this.getBatchParamterInfo().setLblShuryoDate(lblShuryoDate);
    }

    @JsonIgnore
    public Label getLblZenkai() {
        return this.getBatchParamterInfo().getLblZenkai();
    }

    @JsonIgnore
    public void  setLblZenkai(Label lblZenkai) {
        this.getBatchParamterInfo().setLblZenkai(lblZenkai);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtzenkaikaishi() {
        return this.getBatchParamterInfo().getTxtzenkaikaishi();
    }

    @JsonIgnore
    public void  setTxtzenkaikaishi(TextBoxFlexibleDate txtzenkaikaishi) {
        this.getBatchParamterInfo().setTxtzenkaikaishi(txtzenkaikaishi);
    }

    @JsonIgnore
    public Label getLblZenkaiKara() {
        return this.getBatchParamterInfo().getLblZenkaiKara();
    }

    @JsonIgnore
    public void  setLblZenkaiKara(Label lblZenkaiKara) {
        this.getBatchParamterInfo().setLblZenkaiKara(lblZenkaiKara);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtzenkaishuryo() {
        return this.getBatchParamterInfo().getTxtzenkaishuryo();
    }

    @JsonIgnore
    public void  setTxtzenkaishuryo(TextBoxFlexibleDate txtzenkaishuryo) {
        this.getBatchParamterInfo().setTxtzenkaishuryo(txtzenkaishuryo);
    }

    @JsonIgnore
    public Label getLblKonkai() {
        return this.getBatchParamterInfo().getLblKonkai();
    }

    @JsonIgnore
    public void  setLblKonkai(Label lblKonkai) {
        this.getBatchParamterInfo().setLblKonkai(lblKonkai);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtkonkaikaishi() {
        return this.getBatchParamterInfo().getTxtkonkaikaishi();
    }

    @JsonIgnore
    public void  setTxtkonkaikaishi(TextBoxFlexibleDate txtkonkaikaishi) {
        this.getBatchParamterInfo().setTxtkonkaikaishi(txtkonkaikaishi);
    }

    @JsonIgnore
    public Label getLblKonkaiKara() {
        return this.getBatchParamterInfo().getLblKonkaiKara();
    }

    @JsonIgnore
    public void  setLblKonkaiKara(Label lblKonkaiKara) {
        this.getBatchParamterInfo().setLblKonkaiKara(lblKonkaiKara);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtkonkaishuryo() {
        return this.getBatchParamterInfo().getTxtkonkaishuryo();
    }

    @JsonIgnore
    public void  setTxtkonkaishuryo(TextBoxFlexibleDate txtkonkaishuryo) {
        this.getBatchParamterInfo().setTxtkonkaishuryo(txtkonkaishuryo);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getBatchParamterInfo().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
