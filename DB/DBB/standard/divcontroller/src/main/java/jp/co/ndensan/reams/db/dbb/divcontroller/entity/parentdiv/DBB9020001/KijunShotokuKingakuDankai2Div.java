package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KijunShotokuKingakuDankai2 のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class KijunShotokuKingakuDankai2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKijunShotokuKingaku")
    private Label lblKijunShotokuKingaku;
    @JsonProperty("txtKijunShotokuKingakuDankai2")
    private TextBoxNum txtKijunShotokuKingakuDankai2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKijunShotokuKingaku
     * @return lblKijunShotokuKingaku
     */
    @JsonProperty("lblKijunShotokuKingaku")
    public Label getLblKijunShotokuKingaku() {
        return lblKijunShotokuKingaku;
    }

    /*
     * setlblKijunShotokuKingaku
     * @param lblKijunShotokuKingaku lblKijunShotokuKingaku
     */
    @JsonProperty("lblKijunShotokuKingaku")
    public void setLblKijunShotokuKingaku(Label lblKijunShotokuKingaku) {
        this.lblKijunShotokuKingaku = lblKijunShotokuKingaku;
    }

    /*
     * gettxtKijunShotokuKingakuDankai2
     * @return txtKijunShotokuKingakuDankai2
     */
    @JsonProperty("txtKijunShotokuKingakuDankai2")
    public TextBoxNum getTxtKijunShotokuKingakuDankai2() {
        return txtKijunShotokuKingakuDankai2;
    }

    /*
     * settxtKijunShotokuKingakuDankai2
     * @param txtKijunShotokuKingakuDankai2 txtKijunShotokuKingakuDankai2
     */
    @JsonProperty("txtKijunShotokuKingakuDankai2")
    public void setTxtKijunShotokuKingakuDankai2(TextBoxNum txtKijunShotokuKingakuDankai2) {
        this.txtKijunShotokuKingakuDankai2 = txtKijunShotokuKingakuDankai2;
    }

    // </editor-fold>
}
