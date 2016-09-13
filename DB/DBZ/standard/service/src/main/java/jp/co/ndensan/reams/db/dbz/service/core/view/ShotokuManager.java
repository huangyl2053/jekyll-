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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV2502KaigoShotokuAliveDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbV2502KaigoShotokuMapper;

import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護所得Aliveを管理するクラスです。
 */
public class ShotokuManager {

    private final DbV2502KaigoShotokuAliveDac dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShotokuManager() {
        dac = InstanceProvider.create(DbV2502KaigoShotokuAliveDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV2502KaigoShotokuAliveDac}
     */
    ShotokuManager(DbV2502KaigoShotokuAliveDac dac) {
        this.dac = dac;
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiinFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SetaiinFinder}のインスタンス
     */
    public static ShotokuManager createInstance() {
        return InstanceProvider.create(ShotokuManager.class);
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
        DbV2502KaigoShotokuEntity entity = dac.selectByshoriTimeStamp(識別コード, 所得年度, 所得基準年月日);
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
     * 介護所得Aliveを複数件取得します。検索対象の識別コードを複数件指定できます。
     *
     * @param 所得年度 所得年度
     * @param 所得基準年月日 所得基準年月日
     * @param 識別コードList 識別コードList
     * @return KaigoShotokuAlive{@code list}
     */
    @Transaction
    public List<KaigoShotokuAlive> get介護所得AlivesFromMapper(FlexibleYear 所得年度, YMDHMS 所得基準年月日, List<ShikibetsuCode> 識別コードList) {
        requireNonNull(識別コードList, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コードList"));
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        if (所得基準年月日 == null) {
            所得基準年月日 = YMDHMS.now();
        }

        List<DbV2502KaigoShotokuEntity> result = mapperProvider.create(IDbV2502KaigoShotokuMapper.class)
                .getShotokuJohoList(所得年度, 所得基準年月日, 識別コードList);

        List<KaigoShotokuAlive> businessList = new ArrayList<>();
        for (DbV2502KaigoShotokuEntity entity : result) {
            entity.initializeMd5();
            businessList.add(new KaigoShotokuAlive(entity));
        }
        return businessList;
    }

    /**
     * 識別コードから、対象の最新履歴を取得します。
     *
     * @param 所得年度 所得年度
     * @param 所得基準年月日 所得基準年月日
     * @param 識別コード 識別コード
     * @return KaigoShotokuAlive{@code list}
     */
    @Transaction
    public KaigoShotokuAlive get介護所得AliveFromMapper(FlexibleYear 所得年度, YMDHMS 所得基準年月日, ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        List<ShikibetsuCode> list = new ArrayList<>();
        list.add(識別コード);
        List<KaigoShotokuAlive> result = get介護所得AlivesFromMapper(所得年度, 所得基準年月日, list);

        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
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
