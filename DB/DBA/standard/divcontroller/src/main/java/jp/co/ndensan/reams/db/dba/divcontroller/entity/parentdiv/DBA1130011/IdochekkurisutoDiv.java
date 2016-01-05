package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Idochekkurisuto のクラスファイル
 *
 * @author 自動生成
 */
public class IdochekkurisutoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    public void setChktaishodaicho(CheckBoxList chktaishodaicho) {
        this.getBatchParamterInfo().setChktaishodaicho(chktaishodaicho);
    }

    @JsonIgnore
    public HorizontalLine getHLine1() {
        return this.getBatchParamterInfo().getHLine1();
    }

    @JsonIgnore
    public void setHLine1(HorizontalLine HLine1) {
        this.getBatchParamterInfo().setHLine1(HLine1);
    }

    @JsonIgnore
    public Label getLblidotasyo() {
        return this.getBatchParamterInfo().getLblidotasyo();
    }

    @JsonIgnore
    public void setLblidotasyo(Label lblidotasyo) {
        this.getBatchParamterInfo().setLblidotasyo(lblidotasyo);
    }

    @JsonIgnore
    public Label getLblzenkaikaishi() {
        return this.getBatchParamterInfo().getLblzenkaikaishi();
    }

    @JsonIgnore
    public void setLblzenkaikaishi(Label lblzenkaikaishi) {
        this.getBatchParamterInfo().setLblzenkaikaishi(lblzenkaikaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtzenkaikaishi() {
        return this.getBatchParamterInfo().getTxtzenkaikaishi();
    }

    @JsonIgnore
    public void setTxtzenkaikaishi(TextBoxFlexibleDate txtzenkaikaishi) {
        this.getBatchParamterInfo().setTxtzenkaikaishi(txtzenkaikaishi);
    }

    @JsonIgnore
    public Label getLblzenkaikara() {
        return this.getBatchParamterInfo().getLblzenkaikara();
    }

    @JsonIgnore
    public void setLblzenkaikara(Label lblzenkaikara) {
        this.getBatchParamterInfo().setLblzenkaikara(lblzenkaikara);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtzenkaishuryo() {
        return this.getBatchParamterInfo().getTxtzenkaishuryo();
    }

    @JsonIgnore
    public void setTxtzenkaishuryo(TextBoxFlexibleDate txtzenkaishuryo) {
        this.getBatchParamterInfo().setTxtzenkaishuryo(txtzenkaishuryo);
    }

    @JsonIgnore
    public Label getLblkonkaikaishi() {
        return this.getBatchParamterInfo().getLblkonkaikaishi();
    }

    @JsonIgnore
    public void setLblkonkaikaishi(Label lblkonkaikaishi) {
        this.getBatchParamterInfo().setLblkonkaikaishi(lblkonkaikaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtkonkaikaishi() {
        return this.getBatchParamterInfo().getTxtkonkaikaishi();
    }

    @JsonIgnore
    public void setTxtkonkaikaishi(TextBoxFlexibleDate txtkonkaikaishi) {
        this.getBatchParamterInfo().setTxtkonkaikaishi(txtkonkaikaishi);
    }

    @JsonIgnore
    public Label getLblkonkaishuryo() {
        return this.getBatchParamterInfo().getLblkonkaishuryo();
    }

    @JsonIgnore
    public void setLblkonkaishuryo(Label lblkonkaishuryo) {
        this.getBatchParamterInfo().setLblkonkaishuryo(lblkonkaishuryo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtkonkaishuryo() {
        return this.getBatchParamterInfo().getTxtkonkaishuryo();
    }

    @JsonIgnore
    public void setTxtkonkaishuryo(TextBoxFlexibleDate txtkonkaishuryo) {
        this.getBatchParamterInfo().setTxtkonkaishuryo(txtkonkaishuryo);
    }

    @JsonIgnore
    public KaigoChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getBatchParamterInfo().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
