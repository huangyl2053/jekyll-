/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.futanwariai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link FutanWariaiSokujiKouseiResultBuilder}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class FutanWariaiSokujiKouseiResultBuilder {

    private final DbT3113RiyoshaFutanWariaiEntity entity;
    private final RiyoshaFutanWariaiIdentifier id;
    private final Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細;

    /**
     * {@link DbT3113RiyoshaFutanWariaiEntity}より{@link FutanWariaiSokujiKouseiResult}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3113RiyoshaFutanWariaiEntity}
     * @param id {@link RiyoshaFutanWariaiIdentifier}
     *
     */
    FutanWariaiSokujiKouseiResultBuilder(
            DbT3113RiyoshaFutanWariaiEntity entity,
            RiyoshaFutanWariaiIdentifier id,
            Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.利用者負担割合明細 = 利用者負担割合明細;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 年度を設定します。
     *
     * @param 年度 年度
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set年度(FlexibleYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 発行不要フラグを設定します。
     *
     * @param 発行不要フラグ 発行不要フラグ
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set発行不要フラグ(boolean 発行不要フラグ) {
        requireNonNull(発行不要フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("発行不要フラグ"));
        entity.setHakoFuyoFlag(発行不要フラグ);
        return this;
    }

    /**
     * 職権変更フラグを設定します。
     *
     * @param 職権変更フラグ 職権変更フラグ
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set職権変更フラグ(boolean 職権変更フラグ) {
        requireNonNull(職権変更フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("職権変更フラグ"));
        entity.setShokenFlag(職権変更フラグ);
        return this;
    }

    /**
     * 判定日を設定します。
     *
     * @param 判定日 判定日
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set判定日(FlexibleDate 判定日) {
        requireNonNull(判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定日"));
        entity.setHanteiYMD(判定日);
        return this;
    }

    /**
     * 判定区分を設定します。
     *
     * @param 判定区分 判定区分
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set判定区分(RString 判定区分) {
        requireNonNull(判定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("判定区分"));
        entity.setHanteiKubun(判定区分);
        return this;
    }

    /**
     * 更正事由を設定します。
     *
     * @param 更正事由 更正事由
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set更正事由(Code 更正事由) {
        requireNonNull(更正事由, UrSystemErrorMessages.値がnull.getReplacedMessage("更正事由"));
        entity.setKoseiJiyu(更正事由);
        return this;
    }

    /**
     * 発行区分を設定します。
     *
     * @param 発行区分 発行区分
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set発行区分(RString 発行区分) {
        requireNonNull(発行区分, UrSystemErrorMessages.値がnull.getReplacedMessage("発行区分"));
        entity.setHakoKubun(発行区分);
        return this;
    }

    /**
     * 発行日を設定します。
     *
     * @param 発行日 発行日
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set発行日(FlexibleDate 発行日) {
        requireNonNull(発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("発行日"));
        entity.setHakoYMD(発行日);
        return this;
    }

    /**
     * 交付日を設定します。
     *
     * @param 交付日 交付日
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set交付日(FlexibleDate 交付日) {
        requireNonNull(交付日, UrSystemErrorMessages.値がnull.getReplacedMessage("交付日"));
        entity.setKofuYMD(交付日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link FutanWariaiSokujiKouseiResultBuilder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * 利用者負担割合明細を追加します。
     *
     * @param 利用者負担割合明細 {@link RiyoshaFutanWariaiMeisai}
     * @return {@link Builder}
     */
    public FutanWariaiSokujiKouseiResultBuilder set利用者負担割合明細(RiyoshaFutanWariaiMeisai 利用者負担割合明細) {
        if (hasSameIdentifier(利用者負担割合明細.identifier())) {
            this.利用者負担割合明細.add(利用者負担割合明細);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(RiyoshaFutanWariaiMeisaiIdentifier 利用者負担割合明細識別子) {
        return (id.get年度().equals(利用者負担割合明細識別子.get年度())
                && id.get被保険者番号() == 利用者負担割合明細識別子.get被保険者番号()
                && id.get履歴番号() == 利用者負担割合明細識別子.get履歴番号());
    }

    /**
     * {@link FutanWariaiSokujiKouseiResult}のインスタンスを生成します。
     *
     * @return {@link ShikyuTeishiRelate}のインスタンス
     */
    public FutanWariaiSokujiKouseiResult build() {
        return new FutanWariaiSokujiKouseiResult(entity, id, 利用者負担割合明細);
    }
}
