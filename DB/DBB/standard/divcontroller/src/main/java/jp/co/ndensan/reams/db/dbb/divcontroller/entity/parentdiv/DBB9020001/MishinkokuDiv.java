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
 * Mishinkoku のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class MishinkokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radMishinkokuKyoseiSettei")
    private RadioButton radMishinkokuKyoseiSettei;
    @JsonProperty("ddlMishinkokuKyoseiSettei")
    private DropDownList ddlMishinkokuKyoseiSettei;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("radtMishinkokuKazeiKbn")
    private RadioButton radtMishinkokuKazeiKbn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradMishinkokuKyoseiSettei
     * @return radMishinkokuKyoseiSettei
     */
    @JsonProperty("radMishinkokuKyoseiSettei")
    public RadioButton getRadMishinkokuKyoseiSettei() {
        return radMishinkokuKyoseiSettei;
    }

    /*
     * setradMishinkokuKyoseiSettei
     * @param radMishinkokuKyoseiSettei radMishinkokuKyoseiSettei
     */
    @JsonProperty("radMishinkokuKyoseiSettei")
    public void setRadMishinkokuKyoseiSettei(RadioButton radMishinkokuKyoseiSettei) {
        this.radMishinkokuKyoseiSettei = radMishinkokuKyoseiSettei;
    }

    /*
     * getddlMishinkokuKyoseiSettei
     * @return ddlMishinkokuKyoseiSettei
     */
    @JsonProperty("ddlMishinkokuKyoseiSettei")
    public DropDownList getDdlMishinkokuKyoseiSettei() {
        return ddlMishinkokuKyoseiSettei;
    }

    /*
     * setddlMishinkokuKyoseiSettei
     * @param ddlMishinkokuKyoseiSettei ddlMishinkokuKyoseiSettei
     */
    @JsonProperty("ddlMishinkokuKyoseiSettei")
    public void setDdlMishinkokuKyoseiSettei(DropDownList ddlMishinkokuKyoseiSettei) {
        this.ddlMishinkokuKyoseiSettei = ddlMishinkokuKyoseiSettei;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getradtMishinkokuKazeiKbn
     * @return radtMishinkokuKazeiKbn
     */
    @JsonProperty("radtMishinkokuKazeiKbn")
    public RadioButton getRadtMishinkokuKazeiKbn() {
        return radtMishinkokuKazeiKbn;
    }

    /*
     * setradtMishinkokuKazeiKbn
     * @param radtMishinkokuKazeiKbn radtMishinkokuKazeiKbn
     */
    @JsonProperty("radtMishinkokuKazeiKbn")
    public void setRadtMishinkokuKazeiKbn(RadioButton radtMishinkokuKazeiKbn) {
        this.radtMishinkokuKazeiKbn = radtMishinkokuKazeiKbn;
    }

    // </editor-fold>
}
