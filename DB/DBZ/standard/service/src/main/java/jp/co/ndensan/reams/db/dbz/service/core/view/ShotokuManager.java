/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.KaigoShotokuAlive;
import jp.co.ndensan.reams.db.dbz.entity.db.view.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV2502KaigoShotokuAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護所得Aliveを管理するクラスです。
 */
public class ShotokuManager {

    private final DbV2502KaigoShotokuAliveDac dac;

    /**
     * コンストラクタです。
     */
    public ShotokuManager() {
        dac = InstanceProvider.create(DbV2502KaigoShotokuAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV2502KaigoShotokuAliveDac}
     */
    ShotokuManager(DbV2502KaigoShotokuAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する賦課Aliveを返します。
     *
     * @param 識別コード 識別コード
     * @param 所得年度 所得年度
     * @param 所得基準年月日 所得基準年月日
     * @return KaigoShotokuAlive
     */
    @Transaction
    public KaigoShotokuAlive get介護所得Alive(ShikibetsuCode 識別コード, FlexibleYear 所得年度, YMDHMS 所得基準年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        if (所得基準年月日 == null) {
            所得基準年月日 = YMDHMS.now();
        }
        DbV2502KaigoShotokuEntity entity = dac.selectByKey(識別コード, 所得年度, 所得基準年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoShotokuAlive(entity);
    }

    /**
     * 主キーに合致する賦課Aliveを返します。
     *
     * @param 識別コード 識別コード
     * @param 所得年度 所得年度
     * @return KaigoShotokuAlive
     */
    @Transaction
    public KaigoShotokuAlive get介護所得Alive(ShikibetsuCode 識別コード, FlexibleYear 所得年度) {
        return get介護所得Alive(識別コード, 所得年度, YMDHMS.now());
    }

    /**
     * 介護所得Aliveを全件返します。
     *
     * @return KaigoShotokuAlive{@code list}
     */
    @Transaction
    public List<KaigoShotokuAlive> get介護所得Alive一覧() {
        List<KaigoShotokuAlive> businessList = new ArrayList<>();

        for (DbV2502KaigoShotokuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoShotokuAlive(entity));
        }
        return businessList;
    }

    /**
     * 資格検索Alive{@link KaigoShotokuAlive}を保存します。
     *
     * @param 介護所得Alive {@link KaigoShotokuAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save資格検索Alive(KaigoShotokuAlive 介護所得Alive) {
        requireNonNull(介護所得Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("介護所得Alive"));
        if (!介護所得Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護所得Alive.toEntity());
    }
}
