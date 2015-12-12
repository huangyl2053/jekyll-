/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料ランクを管理するクラスです。
 */
public class HokenryoRankManager {

    private final DbT2012HokenryoRankDac dac;

    /**
     * コンストラクタです。
     */
    public HokenryoRankManager() {
        dac = InstanceProvider.create(DbT2012HokenryoRankDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2012HokenryoRankDac}
     */
    HokenryoRankManager(DbT2012HokenryoRankDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する保険料ランクを返します。
     *
     * @param 賦課年度 FukaNendo
     * @param 市町村コード ShichosonCode
     * @return HokenryoRank
     */
    @Transaction
    public HokenryoRank get保険料ランク(
            FlexibleYear 賦課年度,
            LasdecCode 市町村コード) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbT2012HokenryoRankEntity entity = dac.selectByKey(
                賦課年度,
                市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HokenryoRank(entity);
    }

    /**
     * 保険料ランクを全件返します。
     *
     * @return List<HokenryoRank>
     */
    @Transaction
    public List<HokenryoRank> get保険料ランク一覧() {
        List<HokenryoRank> businessList = new ArrayList<>();

        for (DbT2012HokenryoRankEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new HokenryoRank(entity));
        }

        return businessList;
    }

    /**
     * 保険料ランク{@link HokenryoRank}を保存します。
     *
     * @param 保険料ランク {@link HokenryoRank}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save保険料ランク(HokenryoRank 保険料ランク) {
        requireNonNull(保険料ランク, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料ランク"));
        if (!保険料ランク.hasChanged()) {
            return false;
        }
        return 1 == dac.save(保険料ランク.toEntity());
    }
}
