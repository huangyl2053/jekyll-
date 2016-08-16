/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.futanwariai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RiyoshaFutanWariai}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariaiBuilder {

    private final DbT3113RiyoshaFutanWariaiEntity entity;
    private final RiyoshaFutanWariaiIdentifier id;

    /**
     * {@link DbT3113RiyoshaFutanWariaiEntity}より{@link RiyoshaFutanWariai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3113RiyoshaFutanWariaiEntity}
     * @param id {@link RiyoshaFutanWariaiIdentifier}
     *
     */
    RiyoshaFutanWariaiBuilder(
            DbT3113RiyoshaFutanWariaiEntity entity,
            RiyoshaFutanWariaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 年度を設定します。
     *
     * @param 年度 年度
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set年度(FlexibleYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 発行不要フラグを設定します。
     *
     * @param 発行不要フラグ 発行不要フラグ
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set発行不要フラグ(boolean 発行不要フラグ) {
        requireNonNull(発行不要フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("発行不要フラグ"));
        entity.setHakoFuyoFlag(発行不要フラグ);
        return this;
    }

    /**
     * 職権変更フラグを設定します。
     *
     * @param 職権変更フラグ 職権変更フラグ
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set職権変更フラグ(boolean 職権変更フラグ) {
        requireNonNull(職権変更フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("職権変更フラグ"));
        entity.setShokenFlag(職権変更フラグ);
        return this;
    }

    /**
     * 判定日を設定します。
     *
     * @param 判定日 判定日
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set判定日(FlexibleDate 判定日) {
        requireNonNull(判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定日"));
        entity.setHanteiYMD(判定日);
        return this;
    }

    /**
     * 判定区分を設定します。
     *
     * @param 判定区分 判定区分
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set判定区分(RString 判定区分) {
        requireNonNull(判定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("判定区分"));
        entity.setHanteiKubun(判定区分);
        return this;
    }

    /**
     * 更正事由を設定します。
     *
     * @param 更正事由 更正事由
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set更正事由(Code 更正事由) {
        requireNonNull(更正事由, UrSystemErrorMessages.値がnull.getReplacedMessage("更正事由"));
        entity.setKoseiJiyu(更正事由);
        return this;
    }

    /**
     * 発行区分を設定します。
     *
     * @param 発行区分 発行区分
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set発行区分(RString 発行区分) {
        requireNonNull(発行区分, UrSystemErrorMessages.値がnull.getReplacedMessage("発行区分"));
        entity.setHakoKubun(発行区分);
        return this;
    }

    /**
     * 発行日を設定します。
     *
     * @param 発行日 発行日
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set発行日(FlexibleDate 発行日) {
        requireNonNull(発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("発行日"));
        entity.setHakoYMD(発行日);
        return this;
    }

    /**
     * 交付日を設定します。
     *
     * @param 交付日 交付日
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set交付日(FlexibleDate 交付日) {
        requireNonNull(交付日, UrSystemErrorMessages.値がnull.getReplacedMessage("交付日"));
        entity.setKofuYMD(交付日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link RiyoshaFutanWariaiBuilder}
     */
    public RiyoshaFutanWariaiBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link RiyoshaFutanWariai}のインスタンスを生成します。
     *
     * @return {@link RiyoshaFutanWariai}のインスタンス
     */
    public RiyoshaFutanWariai build() {
        return new RiyoshaFutanWariai(entity, id);
    }

    /**
     * setRiyoshaFutanWariaiMeisai
     *
     * @param createRiyoshaFutanWariaiMeisai RiyoshaFutanWariaiMeisai
     * @return UnsupportedOperationException("Not supported yet.")
     */
    public RiyoshaFutanWariaiBuilder setRiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisai createRiyoshaFutanWariaiMeisai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
