package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * Heijunka8GatsuKeisanHoho のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class Heijunka8GatsuKeisanHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHeijunka8GatsuKeisanHoho")
    private DropDownList ddlHeijunka8GatsuKeisanHoho;
    @JsonProperty("rad8GatsuGengakuHeijunKa")
    private RadioButton rad8GatsuGengakuHeijunKa;
    @JsonProperty("rad8GatsuZogakuHeijunKa")
    private RadioButton rad8GatsuZogakuHeijunKa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHeijunka8GatsuKeisanHoho
     * @return ddlHeijunka8GatsuKeisanHoho
     */
    @JsonProperty("ddlHeijunka8GatsuKeisanHoho")
    public DropDownList getDdlHeijunka8GatsuKeisanHoho() {
        return ddlHeijunka8GatsuKeisanHoho;
    }

    /*
     * setddlHeijunka8GatsuKeisanHoho
     * @param ddlHeijunka8GatsuKeisanHoho ddlHeijunka8GatsuKeisanHoho
     */
    @JsonProperty("ddlHeijunka8GatsuKeisanHoho")
    public void setDdlHeijunka8GatsuKeisanHoho(DropDownList ddlHeijunka8GatsuKeisanHoho) {
        this.ddlHeijunka8GatsuKeisanHoho = ddlHeijunka8GatsuKeisanHoho;
    }

    /*
     * getrad8GatsuGengakuHeijunKa
     * @return rad8GatsuGengakuHeijunKa
     */
    @JsonProperty("rad8GatsuGengakuHeijunKa")
    public RadioButton getRad8GatsuGengakuHeijunKa() {
        return rad8GatsuGengakuHeijunKa;
    }

    /*
     * setrad8GatsuGengakuHeijunKa
     * @param rad8GatsuGengakuHeijunKa rad8GatsuGengakuHeijunKa
     */
    @JsonProperty("rad8GatsuGengakuHeijunKa")
    public void setRad8GatsuGengakuHeijunKa(RadioButton rad8GatsuGengakuHeijunKa) {
        this.rad8GatsuGengakuHeijunKa = rad8GatsuGengakuHeijunKa;
    }

    /*
     * getrad8GatsuZogakuHeijunKa
     * @return rad8GatsuZogakuHeijunKa
     */
    @JsonProperty("rad8GatsuZogakuHeijunKa")
    public RadioButton getRad8GatsuZogakuHeijunKa() {
        return rad8GatsuZogakuHeijunKa;
    }

    /*
     * setrad8GatsuZogakuHeijunKa
     * @param rad8GatsuZogakuHeijunKa rad8GatsuZogakuHeijunKa
     */
    @JsonProperty("rad8GatsuZogakuHeijunKa")
    public void setRad8GatsuZogakuHeijunKa(RadioButton rad8GatsuZogakuHeijunKa) {
        this.rad8GatsuZogakuHeijunKa = rad8GatsuZogakuHeijunKa;
    }

    // </editor-fold>
}
