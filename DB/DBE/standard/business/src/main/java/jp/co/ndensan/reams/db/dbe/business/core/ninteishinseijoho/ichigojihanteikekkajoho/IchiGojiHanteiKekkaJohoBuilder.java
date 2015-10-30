/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link IchiGojiHanteiKekkaJoho}の編集を行うビルダークラスです。
 */
public class IchiGojiHanteiKekkaJohoBuilder {

    private final DbT5510IchiGojiHanteiKekkaJohoEntity entity;
    private final IchiGojiHanteiKekkaJohoIdentifier id;

    /**
     * {@link DbT5510IchiGojiHanteiKekkaJohoEntity}より{@link IchiGojiHanteiKekkaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5510IchiGojiHanteiKekkaJohoEntity}
     * @param id {@link IchiGojiHanteiKekkaJohoIdentifier}
     *
     */
    IchiGojiHanteiKekkaJohoBuilder(
            DbT5510IchiGojiHanteiKekkaJohoEntity entity,
            IchiGojiHanteiKekkaJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 要介護認定1.5次判定年月日を設定します。
     *
     * @param 要介護認定1_5次判定年月日 要介護認定1_5次判定年月日
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定1_5次判定年月日(FlexibleDate 要介護認定1_5次判定年月日) {
        requireNonNull(要介護認定1_5次判定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1_5次判定年月日"));
        entity.setIchiGojiHanteiYMD(要介護認定1_5次判定年月日);
        return this;
    }

    /**
     * 要介護認定1.5次判定結果コードを設定します。
     *
     * @param 要介護認定1_5次判定結果コード 要介護認定1_5次判定結果コード
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定1_5次判定結果コード(Code 要介護認定1_5次判定結果コード) {
        requireNonNull(要介護認定1_5次判定結果コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1_5次判定結果コード"));
        entity.setIchiGojiHanteiKekkaCode(要介護認定1_5次判定結果コード);
        return this;
    }

    /**
     * 要介護認定1.5次判定結果コード_認知症加算_を設定します。
     *
     * @param 要介護認定1_5次判定結果コード_認知症加算_ 要介護認定1_5次判定結果コード_認知症加算_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定1_5次判定結果コード_認知症加算_(Code 要介護認定1_5次判定結果コード_認知症加算_) {
        requireNonNull(要介護認定1_5次判定結果コード_認知症加算_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1_5次判定結果コード_認知症加算_"));
        entity.setIchiGojiHanteiKekkaNinchishoKasanCode(要介護認定1_5次判定結果コード_認知症加算_);
        return this;
    }

    /**
     * 要介護認定等基準時間を設定します。
     *
     * @param 要介護認定等基準時間 要介護認定等基準時間
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間(int 要介護認定等基準時間) {
        requireNonNull(要介護認定等基準時間, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間"));
        entity.setKijunJikan(要介護認定等基準時間);
        return this;
    }

    /**
     * 要介護認定等基準時間_食事_を設定します。
     *
     * @param 要介護認定等基準時間_食事_ 要介護認定等基準時間_食事_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_食事_(int 要介護認定等基準時間_食事_) {
        requireNonNull(要介護認定等基準時間_食事_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_食事_"));
        entity.setKijunJikanShokuji(要介護認定等基準時間_食事_);
        return this;
    }

    /**
     * 要介護認定等基準時間_排泄_を設定します。
     *
     * @param 要介護認定等基準時間_排泄_ 要介護認定等基準時間_排泄_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_排泄_(int 要介護認定等基準時間_排泄_) {
        requireNonNull(要介護認定等基準時間_排泄_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_排泄_"));
        entity.setKijunJikanHaisetsu(要介護認定等基準時間_排泄_);
        return this;
    }

    /**
     * 要介護認定等基準時間_移動_を設定します。
     *
     * @param 要介護認定等基準時間_移動_ 要介護認定等基準時間_移動_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_移動_(int 要介護認定等基準時間_移動_) {
        requireNonNull(要介護認定等基準時間_移動_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_移動_"));
        entity.setKijunJikanIdo(要介護認定等基準時間_移動_);
        return this;
    }

    /**
     * 要介護認定等基準時間_清潔保持_を設定します。
     *
     * @param 要介護認定等基準時間_清潔保持_ 要介護認定等基準時間_清潔保持_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_清潔保持_(int 要介護認定等基準時間_清潔保持_) {
        requireNonNull(要介護認定等基準時間_清潔保持_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_清潔保持_"));
        entity.setKijunJikanSeiketsuHoji(要介護認定等基準時間_清潔保持_);
        return this;
    }

    /**
     * 要介護認定等基準時間_間接ケア_を設定します。
     *
     * @param 要介護認定等基準時間_間接ケア_ 要介護認定等基準時間_間接ケア_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_間接ケア_(int 要介護認定等基準時間_間接ケア_) {
        requireNonNull(要介護認定等基準時間_間接ケア_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_間接ケア_"));
        entity.setKijunJikanKansetsuCare(要介護認定等基準時間_間接ケア_);
        return this;
    }

    /**
     * 要介護認定等基準時間_BPSD関連_を設定します。
     *
     * @param 要介護認定等基準時間_BPSD関連_ 要介護認定等基準時間_BPSD関連_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_BPSD関連_(int 要介護認定等基準時間_BPSD関連_) {
        requireNonNull(要介護認定等基準時間_BPSD関連_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_BPSD関連_"));
        entity.setKijunJikanBPSDKanren(要介護認定等基準時間_BPSD関連_);
        return this;
    }

    /**
     * 要介護認定等基準時間_機能訓練_を設定します。
     *
     * @param 要介護認定等基準時間_機能訓練_ 要介護認定等基準時間_機能訓練_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_機能訓練_(int 要介護認定等基準時間_機能訓練_) {
        requireNonNull(要介護認定等基準時間_機能訓練_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_機能訓練_"));
        entity.setKijunJikanKinoKunren(要介護認定等基準時間_機能訓練_);
        return this;
    }

    /**
     * 要介護認定等基準時間_医療関連_を設定します。
     *
     * @param 要介護認定等基準時間_医療関連_ 要介護認定等基準時間_医療関連_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_医療関連_(int 要介護認定等基準時間_医療関連_) {
        requireNonNull(要介護認定等基準時間_医療関連_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_医療関連_"));
        entity.setKijunJikanIryoKanren(要介護認定等基準時間_医療関連_);
        return this;
    }

    /**
     * 要介護認定等基準時間_認知症加算_を設定します。
     *
     * @param 要介護認定等基準時間_認知症加算_ 要介護認定等基準時間_認知症加算_
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定等基準時間_認知症加算_(int 要介護認定等基準時間_認知症加算_) {
        requireNonNull(要介護認定等基準時間_認知症加算_, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_認知症加算_"));
        entity.setKijunJikanNinchishoKasan(要介護認定等基準時間_認知症加算_);
        return this;
    }

    /**
     * 中間評価項目得点第1群を設定します。
     *
     * @param 中間評価項目得点第1群 中間評価項目得点第1群
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set中間評価項目得点第1群(int 中間評価項目得点第1群) {
        requireNonNull(中間評価項目得点第1群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第1群"));
        entity.setChukanHyokaKomoku1gun(中間評価項目得点第1群);
        return this;
    }

    /**
     * 中間評価項目得点第2群を設定します。
     *
     * @param 中間評価項目得点第2群 中間評価項目得点第2群
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set中間評価項目得点第2群(int 中間評価項目得点第2群) {
        requireNonNull(中間評価項目得点第2群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第2群"));
        entity.setChukanHyokaKomoku2gun(中間評価項目得点第2群);
        return this;
    }

    /**
     * 中間評価項目得点第3群を設定します。
     *
     * @param 中間評価項目得点第3群 中間評価項目得点第3群
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set中間評価項目得点第3群(int 中間評価項目得点第3群) {
        requireNonNull(中間評価項目得点第3群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第3群"));
        entity.setChukanHyokaKomoku3gun(中間評価項目得点第3群);
        return this;
    }

    /**
     * 中間評価項目得点第4群を設定します。
     *
     * @param 中間評価項目得点第4群 中間評価項目得点第4群
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set中間評価項目得点第4群(int 中間評価項目得点第4群) {
        requireNonNull(中間評価項目得点第4群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第4群"));
        entity.setChukanHyokaKomoku4gun(中間評価項目得点第4群);
        return this;
    }

    /**
     * 中間評価項目得点第5群を設定します。
     *
     * @param 中間評価項目得点第5群 中間評価項目得点第5群
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set中間評価項目得点第5群(int 中間評価項目得点第5群) {
        requireNonNull(中間評価項目得点第5群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第5群"));
        entity.setChukanHyokaKomoku5gun(中間評価項目得点第5群);
        return this;
    }

    /**
     * 要介護認定1.5次判定警告コードを設定します。
     *
     * @param 要介護認定1_5次判定警告コード 要介護認定1_5次判定警告コード
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定1_5次判定警告コード(Code 要介護認定1_5次判定警告コード) {
        requireNonNull(要介護認定1_5次判定警告コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1_5次判定警告コード"));
        entity.setIchiGojiHnateiKeikokuCode(要介護認定1_5次判定警告コード);
        return this;
    }

    /**
     * 要介護認定状態の安定性コードを設定します。
     *
     * @param 要介護認定状態の安定性コード 要介護認定状態の安定性コード
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set要介護認定状態の安定性コード(Code 要介護認定状態の安定性コード) {
        requireNonNull(要介護認定状態の安定性コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定状態の安定性コード"));
        entity.setJotaiAnteiseiCode(要介護認定状態の安定性コード);
        return this;
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性を設定します。
     *
     * @param 認知症自立度Ⅱ以上の蓋然性 認知症自立度Ⅱ以上の蓋然性
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set認知症自立度Ⅱ以上の蓋然性(Decimal 認知症自立度Ⅱ以上の蓋然性) {
        requireNonNull(認知症自立度Ⅱ以上の蓋然性, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症自立度Ⅱ以上の蓋然性"));
        entity.setNinchishoJiritsudoIIijoNoGaizensei(認知症自立度Ⅱ以上の蓋然性);
        return this;
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードを設定します。
     *
     * @param 認知機能及び状態安定性から推定される給付区分コード 認知機能及び状態安定性から推定される給付区分コード
     * @return {@link IchiGojiHanteiKekkaJohoBuilder}
     */
    public IchiGojiHanteiKekkaJohoBuilder set認知機能及び状態安定性から推定される給付区分コード(Code 認知機能及び状態安定性から推定される給付区分コード) {
        requireNonNull(認知機能及び状態安定性から推定される給付区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認知機能及び状態安定性から推定される給付区分コード"));
        entity.setSuiteiKyufuKubunCode(認知機能及び状態安定性から推定される給付区分コード);
        return this;
    }

    /**
     * {@link IchiGojiHanteiKekkaJoho}のインスタンスを生成します。
     *
     * @return {@link IchiGojiHanteiKekkaJoho}のインスタンス
     */
    public IchiGojiHanteiKekkaJoho build() {
        return new IchiGojiHanteiKekkaJoho(entity, id);
    }
}
