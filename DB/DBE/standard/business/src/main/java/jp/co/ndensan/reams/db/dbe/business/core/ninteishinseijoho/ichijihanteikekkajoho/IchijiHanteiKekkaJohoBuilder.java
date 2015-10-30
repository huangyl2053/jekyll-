/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link IchijiHanteiKekkaJoho}の編集を行うビルダークラスです。
 */
public class IchijiHanteiKekkaJohoBuilder {

    private final DbT5116IchijiHanteiKekkaJohoEntity entity;
    private final IchijiHanteiKekkaJohoIdentifier id;

    /**
     * {@link DbT5116IchijiHanteiKekkaJohoEntity}より{@link IchijiHanteiKekkaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5116IchijiHanteiKekkaJohoEntity}
     * @param id {@link IchijiHanteiKekkaJohoIdentifier}
     *
     */
    IchijiHanteiKekkaJohoBuilder(
            DbT5116IchijiHanteiKekkaJohoEntity entity,
            IchijiHanteiKekkaJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 要介護認定等基準時間を設定します。
     *
     * @param 要介護認定等基準時間 要介護認定等基準時間
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間(int 要介護認定等基準時間) {
        requireNonNull(要介護認定等基準時間, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間"));
        entity.setKijunJikan(要介護認定等基準時間);
        return this;
    }

    /**
     * 要介護認定等基準時間_食事を設定します。
     *
     * @param 要介護認定等基準時間_食事 要介護認定等基準時間_食事
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_食事(int 要介護認定等基準時間_食事) {
        requireNonNull(要介護認定等基準時間_食事, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_食事"));
        entity.setKijunJikanShokuji(要介護認定等基準時間_食事);
        return this;
    }

    /**
     * 要介護認定等基準時間_排泄を設定します。
     *
     * @param 要介護認定等基準時間_排泄 要介護認定等基準時間_排泄
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_排泄(int 要介護認定等基準時間_排泄) {
        requireNonNull(要介護認定等基準時間_排泄, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_排泄"));
        entity.setKijunJikanHaisetsu(要介護認定等基準時間_排泄);
        return this;
    }

    /**
     * 要介護認定等基準時間_移動を設定します。
     *
     * @param 要介護認定等基準時間_移動 要介護認定等基準時間_移動
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_移動(int 要介護認定等基準時間_移動) {
        requireNonNull(要介護認定等基準時間_移動, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_移動"));
        entity.setKijunJikanIdo(要介護認定等基準時間_移動);
        return this;
    }

    /**
     * 要介護認定等基準時間_清潔保持を設定します。
     *
     * @param 要介護認定等基準時間_清潔保持 要介護認定等基準時間_清潔保持
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_清潔保持(int 要介護認定等基準時間_清潔保持) {
        requireNonNull(要介護認定等基準時間_清潔保持, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_清潔保持"));
        entity.setKijunJikanSeiketsuHoji(要介護認定等基準時間_清潔保持);
        return this;
    }

    /**
     * 要介護認定等基準時間_間接ケアを設定します。
     *
     * @param 要介護認定等基準時間_間接ケア 要介護認定等基準時間_間接ケア
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_間接ケア(int 要介護認定等基準時間_間接ケア) {
        requireNonNull(要介護認定等基準時間_間接ケア, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_間接ケア"));
        entity.setKijunJikanKansetsuCare(要介護認定等基準時間_間接ケア);
        return this;
    }

    /**
     * 要介護認定等基準時間_BPSD関連を設定します。
     *
     * @param 要介護認定等基準時間_BPSD関連 要介護認定等基準時間_BPSD関連
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_BPSD関連(int 要介護認定等基準時間_BPSD関連) {
        requireNonNull(要介護認定等基準時間_BPSD関連, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_BPSD関連"));
        entity.setKijunJikanBPSDKanren(要介護認定等基準時間_BPSD関連);
        return this;
    }

    /**
     * 要介護認定等基準時間_機能訓練を設定します。
     *
     * @param 要介護認定等基準時間_機能訓練 要介護認定等基準時間_機能訓練
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_機能訓練(int 要介護認定等基準時間_機能訓練) {
        requireNonNull(要介護認定等基準時間_機能訓練, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_機能訓練"));
        entity.setKijunJikanKinoKunren(要介護認定等基準時間_機能訓練);
        return this;
    }

    /**
     * 要介護認定等基準時間_医療関連を設定します。
     *
     * @param 要介護認定等基準時間_医療関連 要介護認定等基準時間_医療関連
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_医療関連(int 要介護認定等基準時間_医療関連) {
        requireNonNull(要介護認定等基準時間_医療関連, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_医療関連"));
        entity.setKijunJikanIryoKanren(要介護認定等基準時間_医療関連);
        return this;
    }

    /**
     * 要介護認定等基準時間_認知症加算を設定します。
     *
     * @param 要介護認定等基準時間_認知症加算 要介護認定等基準時間_認知症加算
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定等基準時間_認知症加算(int 要介護認定等基準時間_認知症加算) {
        requireNonNull(要介護認定等基準時間_認知症加算, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定等基準時間_認知症加算"));
        entity.setKijunJikanNinchishoKasan(要介護認定等基準時間_認知症加算);
        return this;
    }

    /**
     * 中間評価項目得点第1群を設定します。
     *
     * @param 中間評価項目得点第1群 中間評価項目得点第1群
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set中間評価項目得点第1群(int 中間評価項目得点第1群) {
        requireNonNull(中間評価項目得点第1群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第1群"));
        entity.setChukanHyokaKomoku1gun(中間評価項目得点第1群);
        return this;
    }

    /**
     * 中間評価項目得点第2群を設定します。
     *
     * @param 中間評価項目得点第2群 中間評価項目得点第2群
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set中間評価項目得点第2群(int 中間評価項目得点第2群) {
        requireNonNull(中間評価項目得点第2群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第2群"));
        entity.setChukanHyokaKomoku2gun(中間評価項目得点第2群);
        return this;
    }

    /**
     * 中間評価項目得点第3群を設定します。
     *
     * @param 中間評価項目得点第3群 中間評価項目得点第3群
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set中間評価項目得点第3群(int 中間評価項目得点第3群) {
        requireNonNull(中間評価項目得点第3群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第3群"));
        entity.setChukanHyokaKomoku3gun(中間評価項目得点第3群);
        return this;
    }

    /**
     * 中間評価項目得点第4群を設定します。
     *
     * @param 中間評価項目得点第4群 中間評価項目得点第4群
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set中間評価項目得点第4群(int 中間評価項目得点第4群) {
        requireNonNull(中間評価項目得点第4群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第4群"));
        entity.setChukanHyokaKomoku4gun(中間評価項目得点第4群);
        return this;
    }

    /**
     * 中間評価項目得点第5群を設定します。
     *
     * @param 中間評価項目得点第5群 中間評価項目得点第5群
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set中間評価項目得点第5群(int 中間評価項目得点第5群) {
        requireNonNull(中間評価項目得点第5群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第5群"));
        entity.setChukanHyokaKomoku5gun(中間評価項目得点第5群);
        return this;
    }

    /**
     * 中間評価項目得点第6群を設定します。
     *
     * @param 中間評価項目得点第6群 中間評価項目得点第6群
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set中間評価項目得点第6群(int 中間評価項目得点第6群) {
        requireNonNull(中間評価項目得点第6群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第6群"));
        entity.setChukanHyokaKomoku6gun(中間評価項目得点第6群);
        return this;
    }

    /**
     * 中間評価項目得点第7群を設定します。
     *
     * @param 中間評価項目得点第7群 中間評価項目得点第7群
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set中間評価項目得点第7群(int 中間評価項目得点第7群) {
        requireNonNull(中間評価項目得点第7群, UrSystemErrorMessages.値がnull.getReplacedMessage("中間評価項目得点第7群"));
        entity.setChukanHyokaKomoku7gun(中間評価項目得点第7群);
        return this;
    }

    /**
     * 要介護認定一次判定警告コードを設定します。
     *
     * @param 要介護認定一次判定警告コード 要介護認定一次判定警告コード
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定一次判定警告コード(Code 要介護認定一次判定警告コード) {
        requireNonNull(要介護認定一次判定警告コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定警告コード"));
        entity.setIchijiHnateiKeikokuCode(要介護認定一次判定警告コード);
        return this;
    }

    /**
     * 要介護認定状態の安定性コードを設定します。
     *
     * @param 要介護認定状態の安定性コード 要介護認定状態の安定性コード
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set要介護認定状態の安定性コード(Code 要介護認定状態の安定性コード) {
        requireNonNull(要介護認定状態の安定性コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定状態の安定性コード"));
        entity.setJotaiAnteiseiCode(要介護認定状態の安定性コード);
        return this;
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性を設定します。
     *
     * @param 認知症自立度Ⅱ以上の蓋然性 認知症自立度Ⅱ以上の蓋然性
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set認知症自立度Ⅱ以上の蓋然性(Decimal 認知症自立度Ⅱ以上の蓋然性) {
        requireNonNull(認知症自立度Ⅱ以上の蓋然性, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症自立度Ⅱ以上の蓋然性"));
        entity.setNinchishoJiritsudoIIijoNoGaizensei(認知症自立度Ⅱ以上の蓋然性);
        return this;
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードを設定します。
     *
     * @param 認知機能及び状態安定性から推定される給付区分コード 認知機能及び状態安定性から推定される給付区分コード
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set認知機能及び状態安定性から推定される給付区分コード(Code 認知機能及び状態安定性から推定される給付区分コード) {
        requireNonNull(認知機能及び状態安定性から推定される給付区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認知機能及び状態安定性から推定される給付区分コード"));
        entity.setSuiteiKyufuKubunCode(認知機能及び状態安定性から推定される給付区分コード);
        return this;
    }

    /**
     * 運動能力の低下していない認知症高齢者の指標コードを設定します。
     *
     * @param 運動能力の低下していない認知症高齢者の指標コード 運動能力の低下していない認知症高齢者の指標コード
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set運動能力の低下していない認知症高齢者の指標コード(Code 運動能力の低下していない認知症高齢者の指標コード) {
        requireNonNull(運動能力の低下していない認知症高齢者の指標コード, UrSystemErrorMessages.値がnull.getReplacedMessage("運動能力の低下していない認知症高齢者の指標コード"));
        entity.setNinchishoKoreishaShihyoCode(運動能力の低下していない認知症高齢者の指標コード);
        return this;
    }

    /**
     * 日常生活自立度の組み合わせ_自立を設定します。
     *
     * @param 日常生活自立度の組み合わせ_自立 日常生活自立度の組み合わせ_自立
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set日常生活自立度の組み合わせ_自立(int 日常生活自立度の組み合わせ_自立) {
        requireNonNull(日常生活自立度の組み合わせ_自立, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度の組み合わせ_自立"));
        entity.setJiritsudoKumiawase1(日常生活自立度の組み合わせ_自立);
        return this;
    }

    /**
     * 日常生活自立度の組み合わせ_要支援を設定します。
     *
     * @param 日常生活自立度の組み合わせ_要支援 日常生活自立度の組み合わせ_要支援
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set日常生活自立度の組み合わせ_要支援(int 日常生活自立度の組み合わせ_要支援) {
        requireNonNull(日常生活自立度の組み合わせ_要支援, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度の組み合わせ_要支援"));
        entity.setJiritsudoKumiawase2(日常生活自立度の組み合わせ_要支援);
        return this;
    }

    /**
     * 日常生活自立度の組み合わせ_要介護１を設定します。
     *
     * @param 日常生活自立度の組み合わせ_要介護１ 日常生活自立度の組み合わせ_要介護１
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set日常生活自立度の組み合わせ_要介護１(int 日常生活自立度の組み合わせ_要介護１) {
        requireNonNull(日常生活自立度の組み合わせ_要介護１, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度の組み合わせ_要介護１"));
        entity.setJiritsudoKumiawase3(日常生活自立度の組み合わせ_要介護１);
        return this;
    }

    /**
     * 日常生活自立度の組み合わせ_要介護２を設定します。
     *
     * @param 日常生活自立度の組み合わせ_要介護２ 日常生活自立度の組み合わせ_要介護２
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set日常生活自立度の組み合わせ_要介護２(int 日常生活自立度の組み合わせ_要介護２) {
        requireNonNull(日常生活自立度の組み合わせ_要介護２, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度の組み合わせ_要介護２"));
        entity.setJiritsudoKumiawase4(日常生活自立度の組み合わせ_要介護２);
        return this;
    }

    /**
     * 日常生活自立度の組み合わせ_要介護３を設定します。
     *
     * @param 日常生活自立度の組み合わせ_要介護３ 日常生活自立度の組み合わせ_要介護３
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set日常生活自立度の組み合わせ_要介護３(int 日常生活自立度の組み合わせ_要介護３) {
        requireNonNull(日常生活自立度の組み合わせ_要介護３, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度の組み合わせ_要介護３"));
        entity.setJiritsudoKumiawase5(日常生活自立度の組み合わせ_要介護３);
        return this;
    }

    /**
     * 日常生活自立度の組み合わせ_要介護４を設定します。
     *
     * @param 日常生活自立度の組み合わせ_要介護４ 日常生活自立度の組み合わせ_要介護４
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set日常生活自立度の組み合わせ_要介護４(int 日常生活自立度の組み合わせ_要介護４) {
        requireNonNull(日常生活自立度の組み合わせ_要介護４, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度の組み合わせ_要介護４"));
        entity.setJiritsudoKumiawase6(日常生活自立度の組み合わせ_要介護４);
        return this;
    }

    /**
     * 日常生活自立度の組み合わせ_要介護５を設定します。
     *
     * @param 日常生活自立度の組み合わせ_要介護５ 日常生活自立度の組み合わせ_要介護５
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set日常生活自立度の組み合わせ_要介護５(int 日常生活自立度の組み合わせ_要介護５) {
        requireNonNull(日常生活自立度の組み合わせ_要介護５, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活自立度の組み合わせ_要介護５"));
        entity.setJiritsudoKumiawase7(日常生活自立度の組み合わせ_要介護５);
        return this;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コードを設定します。
     *
     * @param 認知症高齢者の日常生活自立度の蓋然性評価コード 認知症高齢者の日常生活自立度の蓋然性評価コード
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set認知症高齢者の日常生活自立度の蓋然性評価コード(Code 認知症高齢者の日常生活自立度の蓋然性評価コード) {
        requireNonNull(認知症高齢者の日常生活自立度の蓋然性評価コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症高齢者の日常生活自立度の蓋然性評価コード"));
        entity.setGaizenseiHyokaCode(認知症高齢者の日常生活自立度の蓋然性評価コード);
        return this;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価を設定します。
     *
     * @param 認知症高齢者の日常生活自立度の蓋然性評価 認知症高齢者の日常生活自立度の蓋然性評価
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set認知症高齢者の日常生活自立度の蓋然性評価(int 認知症高齢者の日常生活自立度の蓋然性評価) {
        requireNonNull(認知症高齢者の日常生活自立度の蓋然性評価, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症高齢者の日常生活自立度の蓋然性評価"));
        entity.setGaizenseiHyokaPercent(認知症高齢者の日常生活自立度の蓋然性評価);
        return this;
    }

    /**
     * 一次判定結果送付区分を設定します。
     *
     * @param 一次判定結果送付区分 一次判定結果送付区分
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set一次判定結果送付区分(RString 一次判定結果送付区分) {
        requireNonNull(一次判定結果送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果送付区分"));
        entity.setIchijiHanteiSofuKubun(一次判定結果送付区分);
        return this;
    }

    /**
     * 一次判定結果送付年月日を設定します。
     *
     * @param 一次判定結果送付年月日 一次判定結果送付年月日
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set一次判定結果送付年月日(FlexibleDate 一次判定結果送付年月日) {
        requireNonNull(一次判定結果送付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果送付年月日"));
        entity.setIchijiHanteiKekkaSofuYMD(一次判定結果送付年月日);
        return this;
    }

    /**
     * チャートを設定します。
     *
     * @param チャート チャート
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder setチャート(RString チャート) {
        requireNonNull(チャート, UrSystemErrorMessages.値がnull.getReplacedMessage("チャート"));
        entity.setChert(チャート);
        return this;
    }

    /**
     * 状態像を設定します。
     *
     * @param 状態像 状態像
     * @return {@link IchijiHanteiKekkaJohoBuilder}
     */
    public IchijiHanteiKekkaJohoBuilder set状態像(RString 状態像) {
        requireNonNull(状態像, UrSystemErrorMessages.値がnull.getReplacedMessage("状態像"));
        entity.setJotaizo(状態像);
        return this;
    }

    /**
     * {@link IchijiHanteiKekkaJoho}のインスタンスを生成します。
     *
     * @return {@link IchijiHanteiKekkaJoho}のインスタンス
     */
    public IchijiHanteiKekkaJoho build() {
        return new IchijiHanteiKekkaJoho(entity, id);
    }
}
