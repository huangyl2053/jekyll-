/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link NinteiKanryoJoho}の編集を行うビルダークラスです。
 */
public class NinteiKanryoJohoBuilder {

    private final DbT5105NinteiKanryoJohoEntity entity;
    private final NinteiKanryoJohoIdentifier id;

    /**
     * {@link DbT5105NinteiKanryoJohoEntity}より{@link NinteiKanryoJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5105NinteiKanryoJohoEntity}
     * @param id {@link NinteiKanryoJohoIdentifier}
     *
     */
    NinteiKanryoJohoBuilder(
            DbT5105NinteiKanryoJohoEntity entity,
            NinteiKanryoJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 認定申請情報登録完了年月日を設定します。
     *
     * @param 認定申請情報登録完了年月日 認定申請情報登録完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set認定申請情報登録完了年月日(FlexibleDate 認定申請情報登録完了年月日) {
        requireNonNull(認定申請情報登録完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請情報登録完了年月日"));
        entity.setNinteiShinseiJohoTorokuKanryoYMD(認定申請情報登録完了年月日);
        return this;
    }

    /**
     * 認定調査依頼完了年月日を設定します。
     *
     * @param 認定調査依頼完了年月日 認定調査依頼完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set認定調査依頼完了年月日(FlexibleDate 認定調査依頼完了年月日) {
        requireNonNull(認定調査依頼完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼完了年月日"));
        entity.setNinteichosaIraiKanryoYMD(認定調査依頼完了年月日);
        return this;
    }

    /**
     * 認定調査完了年月日を設定します。
     *
     * @param 認定調査完了年月日 認定調査完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set認定調査完了年月日(FlexibleDate 認定調査完了年月日) {
        requireNonNull(認定調査完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査完了年月日"));
        entity.setNinteichosaKanryoYMD(認定調査完了年月日);
        return this;
    }

    /**
     * 主治医意見書作成依頼完了年月日を設定します。
     *
     * @param 主治医意見書作成依頼完了年月日 主治医意見書作成依頼完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set主治医意見書作成依頼完了年月日(FlexibleDate 主治医意見書作成依頼完了年月日) {
        requireNonNull(主治医意見書作成依頼完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼完了年月日"));
        entity.setIkenshoSakuseiIraiKanryoYMD(主治医意見書作成依頼完了年月日);
        return this;
    }

    /**
     * 主治医意見書登録完了年月日を設定します。
     *
     * @param 主治医意見書登録完了年月日 主治医意見書登録完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set主治医意見書登録完了年月日(FlexibleDate 主治医意見書登録完了年月日) {
        requireNonNull(主治医意見書登録完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書登録完了年月日"));
        entity.setIkenshoTorokuKanryoYMD(主治医意見書登録完了年月日);
        return this;
    }

    /**
     * 要介護認定一次判定完了年月日を設定します。
     *
     * @param 要介護認定一次判定完了年月日 要介護認定一次判定完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set要介護認定一次判定完了年月日(FlexibleDate 要介護認定一次判定完了年月日) {
        requireNonNull(要介護認定一次判定完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定完了年月日"));
        entity.setIchijiHanteiKanryoYMD(要介護認定一次判定完了年月日);
        return this;
    }

    /**
     * マスキング完了年月日を設定します。
     *
     * @param マスキング完了年月日 マスキング完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder setマスキング完了年月日(FlexibleDate マスキング完了年月日) {
        requireNonNull(マスキング完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("マスキング完了年月日"));
        entity.setMaskingKanryoYMD(マスキング完了年月日);
        return this;
    }

    /**
     * 認定審査会割当完了年月日を設定します。
     *
     * @param 認定審査会割当完了年月日 認定審査会割当完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set認定審査会割当完了年月日(FlexibleDate 認定審査会割当完了年月日) {
        requireNonNull(認定審査会割当完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会割当完了年月日"));
        entity.setNinteiShinsakaiWariateKanryoYMD(認定審査会割当完了年月日);
        return this;
    }

    /**
     * 認定審査会完了年月日を設定します。
     *
     * @param 認定審査会完了年月日 認定審査会完了年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder set認定審査会完了年月日(FlexibleDate 認定審査会完了年月日) {
        requireNonNull(認定審査会完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会完了年月日"));
        entity.setNinteiShinsakaiKanryoYMD(認定審査会完了年月日);
        return this;
    }

    /**
     * センター送信年月日を設定します。
     *
     * @param センター送信年月日 センター送信年月日
     * @return {@link NinteiKanryoJohoBuilder}
     */
    public NinteiKanryoJohoBuilder setセンター送信年月日(FlexibleDate センター送信年月日) {
        requireNonNull(センター送信年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("センター送信年月日"));
        entity.setCenterSoshinYMD(センター送信年月日);
        return this;
    }

    /**
     * {@link NinteiKanryoJoho}のインスタンスを生成します。
     *
     * @return {@link NinteiKanryoJoho}のインスタンス
     */
    public NinteiKanryoJoho build() {
        return new NinteiKanryoJoho(entity, id);
    }
}
