package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;

/**
 * KeisanHoho のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class KeisanHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IraiKingakuKeisanHoho")
    private IraiKingakuKeisanHohoDiv IraiKingakuKeisanHoho;
    @JsonProperty("spaceTokucho")
    private Space spaceTokucho;
    @JsonProperty("TokubetsuChoshuShinkishaZenhan")
    private TokubetsuChoshuShinkishaZenhanDiv TokubetsuChoshuShinkishaZenhan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIraiKingakuKeisanHoho
     * @return IraiKingakuKeisanHoho
     */
    @JsonProperty("IraiKingakuKeisanHoho")
    public IraiKingakuKeisanHohoDiv getIraiKingakuKeisanHoho() {
        return IraiKingakuKeisanHoho;
    }

    /*
     * setIraiKingakuKeisanHoho
     * @param IraiKingakuKeisanHoho IraiKingakuKeisanHoho
     */
    @JsonProperty("IraiKingakuKeisanHoho")
    public void setIraiKingakuKeisanHoho(IraiKingakuKeisanHohoDiv IraiKingakuKeisanHoho) {
        this.IraiKingakuKeisanHoho = IraiKingakuKeisanHoho;
    }

    /*
     * getspaceTokucho
     * @return spaceTokucho
     */
    @JsonProperty("spaceTokucho")
    public Space getSpaceTokucho() {
        return spaceTokucho;
    }

    /*
     * setspaceTokucho
     * @param spaceTokucho spaceTokucho
     */
    @JsonProperty("spaceTokucho")
    public void setSpaceTokucho(Space spaceTokucho) {
        this.spaceTokucho = spaceTokucho;
    }

    /*
     * getTokubetsuChoshuShinkishaZenhan
     * @return TokubetsuChoshuShinkishaZenhan
     */
    @JsonProperty("TokubetsuChoshuShinkishaZenhan")
    public TokubetsuChoshuShinkishaZenhanDiv getTokubetsuChoshuShinkishaZenhan() {
        return TokubetsuChoshuShinkishaZenhan;
    }

    /*
     * setTokubetsuChoshuShinkishaZenhan
     * @param TokubetsuChoshuShinkishaZenhan TokubetsuChoshuShinkishaZenhan
     */
    @JsonProperty("TokubetsuChoshuShinkishaZenhan")
    public void setTokubetsuChoshuShinkishaZenhan(TokubetsuChoshuShinkishaZenhanDiv TokubetsuChoshuShinkishaZenhan) {
        this.TokubetsuChoshuShinkishaZenhan = TokubetsuChoshuShinkishaZenhan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdl12GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getIraiKingakuKeisanHoho().getDdl12GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl12GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl12GatsuKaishiIraiKingakuKeisanHoho) {
        this.getIraiKingakuKeisanHoho().setDdl12GatsuKaishiIraiKingakuKeisanHoho(ddl12GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl2GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getIraiKingakuKeisanHoho().getDdl2GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl2GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl2GatsuKaishiIraiKingakuKeisanHoho) {
        this.getIraiKingakuKeisanHoho().setDdl2GatsuKaishiIraiKingakuKeisanHoho(ddl2GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getIraiKingakuKeisanHoho().getDdl4GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl4GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl4GatsuKaishiIraiKingakuKeisanHoho) {
        this.getIraiKingakuKeisanHoho().setDdl4GatsuKaishiIraiKingakuKeisanHoho(ddl4GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getIraiKingakuKeisanHoho().getDdl6GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl6GatsuKaishiIraiKingakuKeisanHoho) {
        this.getIraiKingakuKeisanHoho().setDdl6GatsuKaishiIraiKingakuKeisanHoho(ddl6GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getIraiKingakuKeisanHoho().getDdl8GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl8GatsuKaishiIraiKingakuKeisanHoho) {
        this.getIraiKingakuKeisanHoho().setDdl8GatsuKaishiIraiKingakuKeisanHoho(ddl8GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiZenhan() {
        return this.getTokubetsuChoshuShinkishaZenhan().getDdl6GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiZenhan(DropDownList ddl6GatsuKaishiZenhan) {
        this.getTokubetsuChoshuShinkishaZenhan().setDdl6GatsuKaishiZenhan(ddl6GatsuKaishiZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiZenhan() {
        return this.getTokubetsuChoshuShinkishaZenhan().getDdl8GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiZenhan(DropDownList ddl8GatsuKaishiZenhan) {
        this.getTokubetsuChoshuShinkishaZenhan().setDdl8GatsuKaishiZenhan(ddl8GatsuKaishiZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl10GatsuKaishiZenhan() {
        return this.getTokubetsuChoshuShinkishaZenhan().getDdl10GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl10GatsuKaishiZenhan(DropDownList ddl10GatsuKaishiZenhan) {
        this.getTokubetsuChoshuShinkishaZenhan().setDdl10GatsuKaishiZenhan(ddl10GatsuKaishiZenhan);
    }

    // </editor-fold>
}
