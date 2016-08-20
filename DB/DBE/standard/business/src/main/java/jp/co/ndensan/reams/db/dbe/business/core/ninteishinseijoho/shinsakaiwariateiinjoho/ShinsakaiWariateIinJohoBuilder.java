/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiwariateiinjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiWariateIinJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 suguangjun
 */
public class ShinsakaiWariateIinJohoBuilder {

    private final DbT5503ShinsakaiWariateIinJohoEntity entity;
    private final ShinsakaiWariateIinJohoIdentifier id;

    /**
     * {@link DbT5102NinteiKekkaJohoEntity}より{@link ShinsakaiWariateIinJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5102NinteiKekkaJohoEntity}
     * @param id {@link ShinsakaiWariateIinJohoIdentifier}
     *
     */
    ShinsakaiWariateIinJohoBuilder(
            DbT5503ShinsakaiWariateIinJohoEntity entity,
            ShinsakaiWariateIinJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 介護認定審査会開催年月日を設定します。
     *
     * @param 介護認定審査会開催年月日 介護認定審査会開催年月日
     * @return {@link ShinsakaiWariateIinJohoBuilder}
     */
    public ShinsakaiWariateIinJohoBuilder set介護認定審査会開催年月日(FlexibleDate 介護認定審査会開催年月日) {
        requireNonNull(介護認定審査会開催年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催年月日"));
        entity.setShinsakaiKaisaiYMD(介護認定審査会開催年月日);
        return this;
    }

    /**
     * 介護認定審査会議長区分コードを設定します。
     *
     * @param 介護認定審査会議長区分コード 介護認定審査会議長区分コード
     * @return {@link ShinsakaiWariateIinJohoBuilder}
     */
    public ShinsakaiWariateIinJohoBuilder set介護認定審査会議長区分コード(Code 介護認定審査会議長区分コード) {
        requireNonNull(介護認定審査会議長区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会議長区分コード"));
        entity.setKaigoninteiShinsakaiGichoKubunCode(介護認定審査会議長区分コード);
        return this;
    }

    /**
     * 委員出席を設定します。
     *
     * @param 委員出席 委員出席
     * @return {@link ShinsakaiWariateIinJohoBuilder}
     */
    public ShinsakaiWariateIinJohoBuilder set委員出席(boolean 委員出席) {
        requireNonNull(委員出席, UrSystemErrorMessages.値がnull.getReplacedMessage("委員出席"));
        entity.setShussekiFlag(委員出席);
        return this;
    }

    /**
     * 委員遅刻有無を設定します。
     *
     * @param 委員遅刻有無 委員遅刻有無
     * @return {@link ShinsakaiWariateIinJohoBuilder}
     */
    public ShinsakaiWariateIinJohoBuilder set委員遅刻有無(boolean 委員遅刻有無) {
        requireNonNull(委員遅刻有無, UrSystemErrorMessages.値がnull.getReplacedMessage("委員遅刻有無"));
        entity.setExistChikokuFlag(委員遅刻有無);
        return this;
    }

    /**
     * 委員出席時間を設定します。
     *
     * @param 委員出席時間 委員出席時間
     * @return {@link ShinsakaiWariateIinJohoBuilder}
     */
    public ShinsakaiWariateIinJohoBuilder set委員出席時間(RString 委員出席時間) {
        requireNonNull(委員出席時間, UrSystemErrorMessages.値がnull.getReplacedMessage("委員出席時間"));
        entity.setShussekiTime(委員出席時間);
        return this;
    }

    /**
     * 委員早退有無を設定します。
     *
     * @param 委員早退有無 委員早退有無
     * @return {@link ShinsakaiWariateIinJohoBuilder}
     */
    public ShinsakaiWariateIinJohoBuilder set委員早退有無(boolean 委員早退有無) {
        requireNonNull(委員早退有無, UrSystemErrorMessages.値がnull.getReplacedMessage("委員早退有無"));
        entity.setExistSotaiFlag(委員早退有無);
        return this;
    }

    /**
     * 委員退席時間を設定します。
     *
     * @param 委員退席時間 委員退席時間
     * @return {@link ShinsakaiWariateIinJohoBuilder}
     */
    public ShinsakaiWariateIinJohoBuilder set委員退席時間(RString 委員退席時間) {
        requireNonNull(委員退席時間, UrSystemErrorMessages.値がnull.getReplacedMessage("委員退席時間"));
        entity.setTaisekiTime(委員退席時間);
        return this;
    }

    /**
     * {@link ShinsakaiWariateIinJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiWariateIinJoho}のインスタンス
     */
    public ShinsakaiWariateIinJoho build() {
        return new ShinsakaiWariateIinJoho(entity, id);
    }
}
