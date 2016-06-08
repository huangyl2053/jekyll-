package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuchoKirikaeKeisanHoho のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class FuchoKirikaeKeisanHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlFuchoKirikaeKeisanHoho")
    private DropDownList ddlFuchoKirikaeKeisanHoho;
    @JsonProperty("ddlFuchoKirikaeJufukuStKi")
    private DropDownList ddlFuchoKirikaeJufukuStKi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlFuchoKirikaeKeisanHoho
     * @return ddlFuchoKirikaeKeisanHoho
     */
    @JsonProperty("ddlFuchoKirikaeKeisanHoho")
    public DropDownList getDdlFuchoKirikaeKeisanHoho() {
        return ddlFuchoKirikaeKeisanHoho;
    }

    /*
     * setddlFuchoKirikaeKeisanHoho
     * @param ddlFuchoKirikaeKeisanHoho ddlFuchoKirikaeKeisanHoho
     */
    @JsonProperty("ddlFuchoKirikaeKeisanHoho")
    public void setDdlFuchoKirikaeKeisanHoho(DropDownList ddlFuchoKirikaeKeisanHoho) {
        this.ddlFuchoKirikaeKeisanHoho = ddlFuchoKirikaeKeisanHoho;
    }

    /*
     * getddlFuchoKirikaeJufukuStKi
     * @return ddlFuchoKirikaeJufukuStKi
     */
    @JsonProperty("ddlFuchoKirikaeJufukuStKi")
    public DropDownList getDdlFuchoKirikaeJufukuStKi() {
        return ddlFuchoKirikaeJufukuStKi;
    }

    /*
     * setddlFuchoKirikaeJufukuStKi
     * @param ddlFuchoKirikaeJufukuStKi ddlFuchoKirikaeJufukuStKi
     */
    @JsonProperty("ddlFuchoKirikaeJufukuStKi")
    public void setDdlFuchoKirikaeJufukuStKi(DropDownList ddlFuchoKirikaeJufukuStKi) {
        this.ddlFuchoKirikaeJufukuStKi = ddlFuchoKirikaeJufukuStKi;
    }

    // </editor-fold>
}
