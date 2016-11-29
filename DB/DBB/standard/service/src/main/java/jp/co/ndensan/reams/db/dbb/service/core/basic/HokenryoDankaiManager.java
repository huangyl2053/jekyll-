/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料段階を管理するクラスです。
 *
 * @reamsid_L DBB-1770-010 zhangrui
 */
public class HokenryoDankaiManager {

    private final DbT2013HokenryoDankaiDac dac;

    /**
     * コンストラクタです。
     */
    public HokenryoDankaiManager() {
        dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2013HokenryoDankaiDac}
     */
    HokenryoDankaiManager(DbT2013HokenryoDankaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する保険料段階を返します。
     *
     * @param 賦課年度 FukaNendo
     * @param 段階インデックス DankaiIndex
     * @param ランク区分 RankuKubun
     * @return HokenryoDankai
     */
    @Transaction
    public Optional<HokenryoDankai> get保険料段階(
            FlexibleYear 賦課年度,
            RString 段階インデックス,
            RString ランク区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階インデックス, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

        DbT2013HokenryoDankaiEntity entity = dac.selectByKey(
                賦課年度,
                段階インデックス,
                ランク区分);
        if (entity == null) {
            return Optional.ofNullable(null);
        }
        entity.initializeMd5();
        return Optional.ofNullable(new HokenryoDankai(entity));
    }

    /**
     * 引数のキーに合致する保険料段階を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階区分 段階区分
     * @return HokenryoDankai
     */
    @Transaction
    public Optional<HokenryoDankai> get保険料段階(
            FlexibleYear 賦課年度,
            RString 段階区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階区分, UrSystemErrorMessages.値がnull.getReplacedMessage("段階区分"));

        DbT2013HokenryoDankaiEntity entity = dac.selectBy段階区分(
                賦課年度,
                段階区分);
        if (entity == null) {
            return Optional.ofNullable(null);
        }
        entity.initializeMd5();
        return Optional.ofNullable(new HokenryoDankai(entity));
    }

    /**
     * 引数のキーに合致する保険料段階を返します。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     * @return HokenryoDankai
     */
    @Transaction
    public List<HokenryoDankai> get保険料段階一覧Byランク区分(
            FlexibleYear 賦課年度,
            RString ランク区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

        List<HokenryoDankai> businessList = new ArrayList<>();

        for (DbT2013HokenryoDankaiEntity entity : dac.selectByランク区分(賦課年度, ランク区分)) {
            entity.initializeMd5();
            businessList.add(new HokenryoDankai(entity));
        }

        return businessList;
    }

    /**
     * 保険料段階を全件返します。
     *
     * @return List<HokenryoDankai>
     */
    @Transaction
    public List<HokenryoDankai> get保険料段階一覧() {
        List<HokenryoDankai> businessList = new ArrayList<>();

        for (DbT2013HokenryoDankaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new HokenryoDankai(entity));
        }

        return businessList;
    }

    /**
     * 保険料段階{@link HokenryoDankai}を保存します。
     *
     * @param 保険料段階 {@link HokenryoDankai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save保険料段階(HokenryoDankai 保険料段階) {
        requireNonNull(保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));
        if (!保険料段階.hasChanged()) {
            return false;
        }
        return 1 == dac.save(保険料段階.toEntity());
    }
}
