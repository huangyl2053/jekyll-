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
 * KazeiTorikeshi のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class KazeiTorikeshiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKazeiTorikeshiKyoseiSettei")
    private RadioButton radKazeiTorikeshiKyoseiSettei;
    @JsonProperty("ddlKazeiTorikeshiKyoseiSettei")
    private DropDownList ddlKazeiTorikeshiKyoseiSettei;
    @JsonProperty("lin5")
    private HorizontalLine lin5;
    @JsonProperty("radKazeiTorikeshiKazeiKbn")
    private RadioButton radKazeiTorikeshiKazeiKbn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKazeiTorikeshiKyoseiSettei
     * @return radKazeiTorikeshiKyoseiSettei
     */
    @JsonProperty("radKazeiTorikeshiKyoseiSettei")
    public RadioButton getRadKazeiTorikeshiKyoseiSettei() {
        return radKazeiTorikeshiKyoseiSettei;
    }

    /*
     * setradKazeiTorikeshiKyoseiSettei
     * @param radKazeiTorikeshiKyoseiSettei radKazeiTorikeshiKyoseiSettei
     */
    @JsonProperty("radKazeiTorikeshiKyoseiSettei")
    public void setRadKazeiTorikeshiKyoseiSettei(RadioButton radKazeiTorikeshiKyoseiSettei) {
        this.radKazeiTorikeshiKyoseiSettei = radKazeiTorikeshiKyoseiSettei;
    }

    /*
     * getddlKazeiTorikeshiKyoseiSettei
     * @return ddlKazeiTorikeshiKyoseiSettei
     */
    @JsonProperty("ddlKazeiTorikeshiKyoseiSettei")
    public DropDownList getDdlKazeiTorikeshiKyoseiSettei() {
        return ddlKazeiTorikeshiKyoseiSettei;
    }

    /*
     * setddlKazeiTorikeshiKyoseiSettei
     * @param ddlKazeiTorikeshiKyoseiSettei ddlKazeiTorikeshiKyoseiSettei
     */
    @JsonProperty("ddlKazeiTorikeshiKyoseiSettei")
    public void setDdlKazeiTorikeshiKyoseiSettei(DropDownList ddlKazeiTorikeshiKyoseiSettei) {
        this.ddlKazeiTorikeshiKyoseiSettei = ddlKazeiTorikeshiKyoseiSettei;
    }

    /*
     * getlin5
     * @return lin5
     */
    @JsonProperty("lin5")
    public HorizontalLine getLin5() {
        return lin5;
    }

    /*
     * setlin5
     * @param lin5 lin5
     */
    @JsonProperty("lin5")
    public void setLin5(HorizontalLine lin5) {
        this.lin5 = lin5;
    }

    /*
     * getradKazeiTorikeshiKazeiKbn
     * @return radKazeiTorikeshiKazeiKbn
     */
    @JsonProperty("radKazeiTorikeshiKazeiKbn")
    public RadioButton getRadKazeiTorikeshiKazeiKbn() {
        return radKazeiTorikeshiKazeiKbn;
    }

    /*
     * setradKazeiTorikeshiKazeiKbn
     * @param radKazeiTorikeshiKazeiKbn radKazeiTorikeshiKazeiKbn
     */
    @JsonProperty("radKazeiTorikeshiKazeiKbn")
    public void setRadKazeiTorikeshiKazeiKbn(RadioButton radKazeiTorikeshiKazeiKbn) {
        this.radKazeiTorikeshiKazeiKbn = radKazeiTorikeshiKazeiKbn;
    }

    // </editor-fold>
}
