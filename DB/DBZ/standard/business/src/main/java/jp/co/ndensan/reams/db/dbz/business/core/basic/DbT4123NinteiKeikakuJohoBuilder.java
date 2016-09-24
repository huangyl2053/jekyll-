/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link DbT4123NinteiKeikakuJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBZ-9999-011 chengsanyuan
 */
public class DbT4123NinteiKeikakuJohoBuilder {

    private final DbT4123NinteiKeikakuJohoEntity entity;
    private final DbT4123NinteiKeikakuJohoIdentifier id;

    /**
     * {@link DbT4123NinteiKeikakuJohoEntity}より{@link DbT4123NinteiKeikakuJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4123NinteiKeikakuJohoEntity}
     * @param id {@link DbT4123NinteiKeikakuJohoIdentifier}
     *
     */
    DbT4123NinteiKeikakuJohoBuilder(
            DbT4123NinteiKeikakuJohoEntity entity,
            DbT4123NinteiKeikakuJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 認定調査依頼予定年月日を設定します。
     *
     * @param 認定調査依頼予定年月日 認定調査依頼予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder set認定調査依頼予定年月日(FlexibleDate 認定調査依頼予定年月日) {
        requireNonNull(認定調査依頼予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼予定年月日"));
        entity.setNinteichosaIraiYoteiYMD(認定調査依頼予定年月日);
        return this;
    }

    /**
     * 認定調査予定年月日を設定します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder set認定調査予定年月日(FlexibleDate 認定調査予定年月日) {
        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
        entity.setNinteichosaYoteiYMD(認定調査予定年月日);
        return this;
    }

    /**
     * 主治医意見書作成依頼予定年月日を設定します。
     *
     * @param 主治医意見書作成依頼予定年月日 主治医意見書作成依頼予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder set主治医意見書作成依頼予定年月日(FlexibleDate 主治医意見書作成依頼予定年月日) {
        requireNonNull(主治医意見書作成依頼予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼予定年月日"));
        entity.setIkenshoSakuseiIraiYoteiYMD(主治医意見書作成依頼予定年月日);
        return this;
    }

    /**
     * 主治医意見書登録予定年月日を設定します。
     *
     * @param 主治医意見書登録予定年月日 主治医意見書登録予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder set主治医意見書登録予定年月日(FlexibleDate 主治医意見書登録予定年月日) {
        requireNonNull(主治医意見書登録予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書登録予定年月日"));
        entity.setIkenshoTorokuYoteiYMD(主治医意見書登録予定年月日);
        return this;
    }

    /**
     * 要介護認定一次判定予定年月日を設定します。
     *
     * @param 要介護認定一次判定予定年月日 要介護認定一次判定予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder set要介護認定一次判定予定年月日(FlexibleDate 要介護認定一次判定予定年月日) {
        requireNonNull(要介護認定一次判定予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定予定年月日"));
        entity.setIchijiHanteiYoteiYMD(要介護認定一次判定予定年月日);
        return this;
    }

    /**
     * 認定審査会割当予定年月日を設定します。
     *
     * @param 認定審査会割当予定年月日 認定審査会割当予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder set認定審査会割当予定年月日(FlexibleDate 認定審査会割当予定年月日) {
        requireNonNull(認定審査会割当予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会割当予定年月日"));
        entity.setNinteiShinsakaiWariateYoteiYMD(認定審査会割当予定年月日);
        return this;
    }

    /**
     * 認定審査会予定年月日を設定します。
     *
     * @param 認定審査会予定年月日 認定審査会予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder set認定審査会予定年月日(FlexibleDate 認定審査会予定年月日) {
        requireNonNull(認定審査会予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会予定年月日"));
        entity.setNinteiShinsakaiYoteiYMD(認定審査会予定年月日);
        return this;
    }

    /**
     * センター送信予定年月日を設定します。
     *
     * @param センター送信予定年月日 センター送信予定年月日
     * @return {@link DbT4123NinteiKeikakuJohoBuilder}
     */
    public DbT4123NinteiKeikakuJohoBuilder setセンター送信予定年月日(FlexibleDate センター送信予定年月日) {
        requireNonNull(センター送信予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("センター送信予定年月日"));
        entity.setCenterSoshinYoteiYMD(センター送信予定年月日);
        return this;
    }

    /**
     * {@link DbT4123NinteiKeikakuJoho}のインスタンスを生成します。
     *
     * @return {@link DbT4123NinteiKeikakuJoho}のインスタンス
     */
    public DbT4123NinteiKeikakuJoho build() {
        return new DbT4123NinteiKeikakuJoho(entity, id);
    }
}
