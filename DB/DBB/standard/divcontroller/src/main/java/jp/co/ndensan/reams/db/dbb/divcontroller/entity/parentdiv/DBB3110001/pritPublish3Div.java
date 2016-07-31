package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * pritPublish3 のクラスファイル
 *
 * @reamsid_L DBB-1660-050 gongliang
 */
public class pritPublish3Div extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShutsuryokuKi")
    private DropDownList ddlShutsuryokuKi;
    @JsonProperty("radShutsuryokuHoho")
    private RadioButton radShutsuryokuHoho;
    @JsonProperty("radShutsuryokuKeishiki")
    private RadioButton radShutsuryokuKeishiki;
    @JsonProperty("comdiv3")
    private PrintContentsSettingDiv comdiv3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShutsuryokuKi
     * @return ddlShutsuryokuKi
     */
    @JsonProperty("ddlShutsuryokuKi")
    public DropDownList getDdlShutsuryokuKi() {
        return ddlShutsuryokuKi;
    }

    /*
     * setddlShutsuryokuKi
     * @param ddlShutsuryokuKi ddlShutsuryokuKi
     */
    @JsonProperty("ddlShutsuryokuKi")
    public void setDdlShutsuryokuKi(DropDownList ddlShutsuryokuKi) {
        this.ddlShutsuryokuKi = ddlShutsuryokuKi;
    }

    /*
     * getradShutsuryokuHoho
     * @return radShutsuryokuHoho
     */
    @JsonProperty("radShutsuryokuHoho")
    public RadioButton getRadShutsuryokuHoho() {
        return radShutsuryokuHoho;
    }

    /*
     * setradShutsuryokuHoho
     * @param radShutsuryokuHoho radShutsuryokuHoho
     */
    @JsonProperty("radShutsuryokuHoho")
    public void setRadShutsuryokuHoho(RadioButton radShutsuryokuHoho) {
        this.radShutsuryokuHoho = radShutsuryokuHoho;
    }

    /*
     * getradShutsuryokuKeishiki
     * @return radShutsuryokuKeishiki
     */
    @JsonProperty("radShutsuryokuKeishiki")
    public RadioButton getRadShutsuryokuKeishiki() {
        return radShutsuryokuKeishiki;
    }

    /*
     * setradShutsuryokuKeishiki
     * @param radShutsuryokuKeishiki radShutsuryokuKeishiki
     */
    @JsonProperty("radShutsuryokuKeishiki")
    public void setRadShutsuryokuKeishiki(RadioButton radShutsuryokuKeishiki) {
        this.radShutsuryokuKeishiki = radShutsuryokuKeishiki;
    }

    /*
     * getcomdiv3
     * @return comdiv3
     */
    @JsonProperty("comdiv3")
    public IPrintContentsSettingDiv getComdiv3() {
        return comdiv3;
    }

    // </editor-fold>
}
