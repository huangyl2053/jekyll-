/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link NinteiKeikakuJoho}の編集を行うビルダークラスです。
 */
public class NinteiKeikakuJohoBuilder {

    private final DbT5123NinteiKeikakuJohoEntity entity;
    private final NinteiKeikakuJohoIdentifier id;

    /**
     * {@link DbT5123NinteiKeikakuJohoEntity}より{@link NinteiKeikakuJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5123NinteiKeikakuJohoEntity}
     * @param id {@link NinteiKeikakuJohoIdentifier}
     *
     */
    NinteiKeikakuJohoBuilder(
            DbT5123NinteiKeikakuJohoEntity entity,
            NinteiKeikakuJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 認定調査依頼予定年月日を設定します。
     *
     * @param 認定調査依頼予定年月日 認定調査依頼予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set認定調査依頼予定年月日(FlexibleDate 認定調査依頼予定年月日) {
        requireNonNull(認定調査依頼予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼予定年月日"));
        entity.setNinteichosaIraiYoteiYMD(認定調査依頼予定年月日);
        return this;
    }

    /**
     * 認定調査予定年月日を設定します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set認定調査予定年月日(FlexibleDate 認定調査予定年月日) {
        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
        entity.setNinteichosaYoteiYMD(認定調査予定年月日);
        return this;
    }

    /**
     * 主治医意見書作成依頼予定年月日を設定します。
     *
     * @param 主治医意見書作成依頼予定年月日 主治医意見書作成依頼予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set主治医意見書作成依頼予定年月日(FlexibleDate 主治医意見書作成依頼予定年月日) {
        requireNonNull(主治医意見書作成依頼予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼予定年月日"));
        entity.setIkenshoSakuseiIraiYoteiYMD(主治医意見書作成依頼予定年月日);
        return this;
    }

    /**
     * 主治医意見書登録予定年月日を設定します。
     *
     * @param 主治医意見書登録予定年月日 主治医意見書登録予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set主治医意見書登録予定年月日(FlexibleDate 主治医意見書登録予定年月日) {
        requireNonNull(主治医意見書登録予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書登録予定年月日"));
        entity.setIkenshoTorokuYoteiYMD(主治医意見書登録予定年月日);
        return this;
    }

    /**
     * 要介護認定一次判定予定年月日を設定します。
     *
     * @param 要介護認定一次判定予定年月日 要介護認定一次判定予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set要介護認定一次判定予定年月日(FlexibleDate 要介護認定一次判定予定年月日) {
        requireNonNull(要介護認定一次判定予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定予定年月日"));
        entity.setIchijiHanteiYoteiYMD(要介護認定一次判定予定年月日);
        return this;
    }

    /**
     * 要介護認定1.5次判定予定年月日を設定します。
     *
     * @param 要介護認定1.5次判定予定年月日 要介護認定1.5次判定予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set要介護認定1_5次判定予定年月日(FlexibleDate 要介護認定1_5次判定予定年月日) {
        requireNonNull(要介護認定1_5次判定予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1_5次判定予定年月日"));
        entity.setIchiGoHanteiYoteiYMD(要介護認定1_5次判定予定年月日);
        return this;
    }

    /**
     * 認定審査会割当予定年月日を設定します。
     *
     * @param 認定審査会割当予定年月日 認定審査会割当予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set認定審査会割当予定年月日(FlexibleDate 認定審査会割当予定年月日) {
        requireNonNull(認定審査会割当予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会割当予定年月日"));
        entity.setNinteiShinsakaiWariateYoteiYMD(認定審査会割当予定年月日);
        return this;
    }

    /**
     * 認定審査会予定年月日を設定します。
     *
     * @param 認定審査会予定年月日 認定審査会予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder set認定審査会予定年月日(FlexibleDate 認定審査会予定年月日) {
        requireNonNull(認定審査会予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会予定年月日"));
        entity.setNinteiShinsakaiYoteiYMD(認定審査会予定年月日);
        return this;
    }

    /**
     * センター送信予定年月日を設定します。
     *
     * @param センター送信予定年月日 センター送信予定年月日
     * @return {@link NinteiKeikakuJohoBuilder}
     */
    public NinteiKeikakuJohoBuilder setセンター送信予定年月日(FlexibleDate センター送信予定年月日) {
        requireNonNull(センター送信予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("センター送信予定年月日"));
        entity.setCenterSoshinYoteiYMD(センター送信予定年月日);
        return this;
    }

    /**
     * {@link NinteiKeikakuJoho}のインスタンスを生成します。
     *
     * @return {@link NinteiKeikakuJoho}のインスタンス
     */
    public NinteiKeikakuJoho build() {
        return new NinteiKeikakuJoho(entity, id);
    }
}
