package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJudgementResultDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail.tplKetteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplShinseishaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IPaymentMethodDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResultDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKogakuServicehiDetail のクラスファイル
 *
 * @author 自動生成
 */
public class tabKogakuServicehiDetailDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("tplShinseisha")
    private tplShinseishaDiv tplShinseisha;
    @JsonProperty("tplKoza")
    private tplKozaDiv tplKoza;
    @JsonProperty("tplJudgementResult")
    private tplJudgementResultDiv tplJudgementResult;
    @JsonProperty("tplKetteiJoho")
    private tplKetteiJohoDiv tplKetteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplShinseisha")
    public tplShinseishaDiv getTplShinseisha() {
        return tplShinseisha;
    }

    @JsonProperty("tplShinseisha")
    public void setTplShinseisha(tplShinseishaDiv tplShinseisha) {
        this.tplShinseisha = tplShinseisha;
    }

    @JsonProperty("tplKoza")
    public tplKozaDiv getTplKoza() {
        return tplKoza;
    }

    @JsonProperty("tplKoza")
    public void setTplKoza(tplKozaDiv tplKoza) {
        this.tplKoza = tplKoza;
    }

    @JsonProperty("tplJudgementResult")
    public tplJudgementResultDiv getTplJudgementResult() {
        return tplJudgementResult;
    }

    @JsonProperty("tplJudgementResult")
    public void setTplJudgementResult(tplJudgementResultDiv tplJudgementResult) {
        this.tplJudgementResult = tplJudgementResult;
    }

    @JsonProperty("tplKetteiJoho")
    public tplKetteiJohoDiv getTplKetteiJoho() {
        return tplKetteiJoho;
    }

    @JsonProperty("tplKetteiJoho")
    public void setTplKetteiJoho(tplKetteiJohoDiv tplKetteiJoho) {
        this.tplKetteiJoho = tplKetteiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShinseishaInfoDiv getShinseisha() {
        return this.getTplShinseisha().getShinseisha();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiTotalAmount() {
        return this.getTplShinseisha().getTxtShiharaiTotalAmount();
    }

    @JsonIgnore
    public void setTxtShiharaiTotalAmount(TextBoxNum txtShiharaiTotalAmount) {
        this.getTplShinseisha().setTxtShiharaiTotalAmount(txtShiharaiTotalAmount);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getTplShinseisha().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getTplShinseisha().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public IPaymentMethodDiv getPaymentMethod() {
        return this.getTplKoza().getPaymentMethod();
    }

    @JsonIgnore
    public KogakuServicehiJudgementResultDiv getJudgementResult() {
        return this.getTplJudgementResult().getJudgementResult();
    }

}
