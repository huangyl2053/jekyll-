package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * ShotokuChosaChu のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class ShotokuChosaChuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShotokuChosaChuKyoseiSettei")
    private RadioButton radShotokuChosaChuKyoseiSettei;
    @JsonProperty("ddlShotokuChosaChuKyoseiSettei")
    private DropDownList ddlShotokuChosaChuKyoseiSettei;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("radShotokuChosaChuKazeiKbn")
    private RadioButton radShotokuChosaChuKazeiKbn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShotokuChosaChuKyoseiSettei
     * @return radShotokuChosaChuKyoseiSettei
     */
    @JsonProperty("radShotokuChosaChuKyoseiSettei")
    public RadioButton getRadShotokuChosaChuKyoseiSettei() {
        return radShotokuChosaChuKyoseiSettei;
    }

    /*
     * setradShotokuChosaChuKyoseiSettei
     * @param radShotokuChosaChuKyoseiSettei radShotokuChosaChuKyoseiSettei
     */
    @JsonProperty("radShotokuChosaChuKyoseiSettei")
    public void setRadShotokuChosaChuKyoseiSettei(RadioButton radShotokuChosaChuKyoseiSettei) {
        this.radShotokuChosaChuKyoseiSettei = radShotokuChosaChuKyoseiSettei;
    }

    /*
     * getddlShotokuChosaChuKyoseiSettei
     * @return ddlShotokuChosaChuKyoseiSettei
     */
    @JsonProperty("ddlShotokuChosaChuKyoseiSettei")
    public DropDownList getDdlShotokuChosaChuKyoseiSettei() {
        return ddlShotokuChosaChuKyoseiSettei;
    }

    /*
     * setddlShotokuChosaChuKyoseiSettei
     * @param ddlShotokuChosaChuKyoseiSettei ddlShotokuChosaChuKyoseiSettei
     */
    @JsonProperty("ddlShotokuChosaChuKyoseiSettei")
    public void setDdlShotokuChosaChuKyoseiSettei(DropDownList ddlShotokuChosaChuKyoseiSettei) {
        this.ddlShotokuChosaChuKyoseiSettei = ddlShotokuChosaChuKyoseiSettei;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * getradShotokuChosaChuKazeiKbn
     * @return radShotokuChosaChuKazeiKbn
     */
    @JsonProperty("radShotokuChosaChuKazeiKbn")
    public RadioButton getRadShotokuChosaChuKazeiKbn() {
        return radShotokuChosaChuKazeiKbn;
    }

    /*
     * setradShotokuChosaChuKazeiKbn
     * @param radShotokuChosaChuKazeiKbn radShotokuChosaChuKazeiKbn
     */
    @JsonProperty("radShotokuChosaChuKazeiKbn")
    public void setRadShotokuChosaChuKazeiKbn(RadioButton radShotokuChosaChuKazeiKbn) {
        this.radShotokuChosaChuKazeiKbn = radShotokuChosaChuKazeiKbn;
    }

    // </editor-fold>
}
