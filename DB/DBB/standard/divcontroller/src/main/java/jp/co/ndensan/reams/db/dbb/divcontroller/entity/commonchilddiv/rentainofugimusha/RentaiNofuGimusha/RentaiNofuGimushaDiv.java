package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.rentainofugimusha.RentaiNofuGimusha;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.commonchilddiv.rentainofugimusha.RentaiNofuGimushaHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * RentaiNofuGimusha のクラスファイル
 *
 * @reamsid_L DBB-5700-010 chenaoqi
 */
public class RentaiNofuGimushaDiv extends Panel implements IRentaiNofuGimushaDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtKaishiYMD")
    private TextBoxDate txtKaishiYMD;
    @JsonProperty("txtSyuryoYMD")
    private TextBoxDate txtSyuryoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtKaishiYMD
     * @return txtKaishiYMD
     */
    @JsonProperty("txtKaishiYMD")
    public TextBoxDate getTxtKaishiYMD() {
        return txtKaishiYMD;
    }

    /*
     * settxtKaishiYMD
     * @param txtKaishiYMD txtKaishiYMD
     */
    @JsonProperty("txtKaishiYMD")
    public void setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.txtKaishiYMD = txtKaishiYMD;
    }

    /*
     * gettxtSyuryoYMD
     * @return txtSyuryoYMD
     */
    @JsonProperty("txtSyuryoYMD")
    public TextBoxDate getTxtSyuryoYMD() {
        return txtSyuryoYMD;
    }

    /*
     * settxtSyuryoYMD
     * @param txtSyuryoYMD txtSyuryoYMD
     */
    @JsonProperty("txtSyuryoYMD")
    public void setTxtSyuryoYMD(TextBoxDate txtSyuryoYMD) {
        this.txtSyuryoYMD = txtSyuryoYMD;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(HihokenshaNo 被保険者番号) {
        getHandler().initialize(被保険者番号);
    }

    @JsonIgnore
    private RentaiNofuGimushaHandler getHandler() {
        return new RentaiNofuGimushaHandler(this);
    }

}
