package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NokigenOCR のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class NokigenOCRDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlNokigenShutsuryokuHoho")
    private DropDownList ddlNokigenShutsuryokuHoho;
    @JsonProperty("ddlOCRShutsuryokuHoho")
    private DropDownList ddlOCRShutsuryokuHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlNokigenShutsuryokuHoho
     * @return ddlNokigenShutsuryokuHoho
     */
    @JsonProperty("ddlNokigenShutsuryokuHoho")
    public DropDownList getDdlNokigenShutsuryokuHoho() {
        return ddlNokigenShutsuryokuHoho;
    }

    /*
     * setddlNokigenShutsuryokuHoho
     * @param ddlNokigenShutsuryokuHoho ddlNokigenShutsuryokuHoho
     */
    @JsonProperty("ddlNokigenShutsuryokuHoho")
    public void setDdlNokigenShutsuryokuHoho(DropDownList ddlNokigenShutsuryokuHoho) {
        this.ddlNokigenShutsuryokuHoho = ddlNokigenShutsuryokuHoho;
    }

    /*
     * getddlOCRShutsuryokuHoho
     * @return ddlOCRShutsuryokuHoho
     */
    @JsonProperty("ddlOCRShutsuryokuHoho")
    public DropDownList getDdlOCRShutsuryokuHoho() {
        return ddlOCRShutsuryokuHoho;
    }

    /*
     * setddlOCRShutsuryokuHoho
     * @param ddlOCRShutsuryokuHoho ddlOCRShutsuryokuHoho
     */
    @JsonProperty("ddlOCRShutsuryokuHoho")
    public void setDdlOCRShutsuryokuHoho(DropDownList ddlOCRShutsuryokuHoho) {
        this.ddlOCRShutsuryokuHoho = ddlOCRShutsuryokuHoho;
    }

    // </editor-fold>
}
