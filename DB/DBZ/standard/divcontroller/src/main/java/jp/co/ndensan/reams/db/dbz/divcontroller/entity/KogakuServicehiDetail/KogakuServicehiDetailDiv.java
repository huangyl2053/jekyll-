package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail.IKogakuServicehiDetailDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResult.IKogakuServicehiJudgementResultDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResult.KogakuServicehiJudgementResultDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod.PaymentMethodDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail.tabKogakuServicehiDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResult.tplJudgementResultDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail.tplKozaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail.tplShinseishaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResult.tplJudgementResultDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KogakuServicehiDetail のクラスファイル
 *
 * @author 自動生成
 */
public class KogakuServicehiDetailDiv extends Panel implements IKogakuServicehiDetailDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("tabKogakuServicehiDetail")
    private tabKogakuServicehiDetailDiv tabKogakuServicehiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM = txtTeikyoYM;
    }

    @JsonProperty("tabKogakuServicehiDetail")
    public tabKogakuServicehiDetailDiv getTabKogakuServicehiDetail() {
        return tabKogakuServicehiDetail;
    }

    @JsonProperty("tabKogakuServicehiDetail")
    public void setTabKogakuServicehiDetail(tabKogakuServicehiDetailDiv tabKogakuServicehiDetail) {
        this.tabKogakuServicehiDetail = tabKogakuServicehiDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplShinseishaDiv getTplShinseisha() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha();
    }

    @JsonIgnore
    public void setTplShinseisha(tplShinseishaDiv tplShinseisha) {
        this.getTabKogakuServicehiDetail().setTplShinseisha(tplShinseisha);
    }

    @JsonIgnore
    public ShinseishaInfoDiv getShinseisha() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getShinseisha();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiTotalAmount() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtShiharaiTotalAmount();
    }

    @JsonIgnore
    public void setTxtShiharaiTotalAmount(TextBoxNum txtShiharaiTotalAmount) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtShiharaiTotalAmount(txtShiharaiTotalAmount);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getTabKogakuServicehiDetail().getTplShinseisha().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getTabKogakuServicehiDetail().getTplShinseisha().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public tplKozaDiv getTplKoza() {
        return this.getTabKogakuServicehiDetail().getTplKoza();
    }

    @JsonIgnore
    public void setTplKoza(tplKozaDiv tplKoza) {
        this.getTabKogakuServicehiDetail().setTplKoza(tplKoza);
    }

    @JsonIgnore
    public PaymentMethodDiv getPaymentMethod() {
        return this.getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod();
    }

    @JsonIgnore
    public tplJudgementResultDiv getTplJudgementResult() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult();
    }

    @JsonIgnore
    public void setTplJudgementResult(tplJudgementResultDiv tplJudgementResult) {
        this.getTabKogakuServicehiDetail().setTplJudgementResult(tplJudgementResult);
    }

    @JsonIgnore
    public IKogakuServicehiJudgementResultDiv getJudgementResult() {
        return this.getTabKogakuServicehiDetail().getTplJudgementResult().getJudgementResult();
    }

    @JsonIgnore
    public tplKetteiJohoDiv getTplKetteiJoho() {
        return this.getTabKogakuServicehiDetail().getTplKetteiJoho();
    }

    @JsonIgnore
    public void setTplKetteiJoho(tplKetteiJohoDiv tplKetteiJoho) {
        this.getTabKogakuServicehiDetail().setTplKetteiJoho(tplKetteiJoho);
    }

    //--------------- この行より下にコードを追加してください -------------------
}
