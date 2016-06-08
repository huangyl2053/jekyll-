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
 * Heijunka6GatsuKeisanHoho のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class Heijunka6GatsuKeisanHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHeijunkaKeisanHoho")
    private DropDownList ddlHeijunkaKeisanHoho;
    @JsonProperty("radGengakuHeijunKa")
    private RadioButton radGengakuHeijunKa;
    @JsonProperty("radZogakuHeijunKa")
    private RadioButton radZogakuHeijunKa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHeijunkaKeisanHoho
     * @return ddlHeijunkaKeisanHoho
     */
    @JsonProperty("ddlHeijunkaKeisanHoho")
    public DropDownList getDdlHeijunkaKeisanHoho() {
        return ddlHeijunkaKeisanHoho;
    }

    /*
     * setddlHeijunkaKeisanHoho
     * @param ddlHeijunkaKeisanHoho ddlHeijunkaKeisanHoho
     */
    @JsonProperty("ddlHeijunkaKeisanHoho")
    public void setDdlHeijunkaKeisanHoho(DropDownList ddlHeijunkaKeisanHoho) {
        this.ddlHeijunkaKeisanHoho = ddlHeijunkaKeisanHoho;
    }

    /*
     * getradGengakuHeijunKa
     * @return radGengakuHeijunKa
     */
    @JsonProperty("radGengakuHeijunKa")
    public RadioButton getRadGengakuHeijunKa() {
        return radGengakuHeijunKa;
    }

    /*
     * setradGengakuHeijunKa
     * @param radGengakuHeijunKa radGengakuHeijunKa
     */
    @JsonProperty("radGengakuHeijunKa")
    public void setRadGengakuHeijunKa(RadioButton radGengakuHeijunKa) {
        this.radGengakuHeijunKa = radGengakuHeijunKa;
    }

    /*
     * getradZogakuHeijunKa
     * @return radZogakuHeijunKa
     */
    @JsonProperty("radZogakuHeijunKa")
    public RadioButton getRadZogakuHeijunKa() {
        return radZogakuHeijunKa;
    }

    /*
     * setradZogakuHeijunKa
     * @param radZogakuHeijunKa radZogakuHeijunKa
     */
    @JsonProperty("radZogakuHeijunKa")
    public void setRadZogakuHeijunKa(RadioButton radZogakuHeijunKa) {
        this.radZogakuHeijunKa = radZogakuHeijunKa;
    }

    // </editor-fold>
}
