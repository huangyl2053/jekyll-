/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2012HokenryoRank;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料ランクのデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoRankDac implements IModifiable<DbT2012HokenryoRankEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT2012HokenryoRankDac 保険料ランクDac = InstanceProvider.create(DbT2012HokenryoRankDac.class);

    /**
     * 保険料ランク情報をキー検索で１件返します。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @return DbT2012HokenryoRankEntity
     */
    @Transaction
    public DbT2012HokenryoRankEntity select保険料ランクByKey(FlexibleYear 賦課年度, LasdecCode 市町村コード) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        return createModel(保険料ランクDac.selectByKey(賦課年度, 市町村コード));
    }

    /**
     * 引数に合致する保険料ランクのリストを返します。。
     *
     * @param 賦課年度 賦課年度
     * @return List<DbT2012HokenryoRankEntity>
     */
    @Transaction
    public List<DbT2012HokenryoRankEntity> select保険料ランク一覧(FlexibleYear 賦課年度) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2012HokenryoRankEntity> 保険料ランクList = accessor.select().
                table(DbT2012HokenryoRank.class).
                where(eq(DbT2012HokenryoRank.fukaNendo, 賦課年度)).
                toList(DbT2012HokenryoRankEntity.class);

        List<DbT2012HokenryoRankEntity> modelList = new ArrayList<>();

        for (DbT2012HokenryoRankEntity 保険料ランク : 保険料ランクList) {
            modelList.add(createModel(保険料ランク));
        }

        return modelList;
    }

    private DbT2012HokenryoRankEntity createModel(DbT2012HokenryoRankEntity 保険料ランクエンティティ) {
        if (保険料ランクエンティティ == null) {
            return null;
        }

        return 保険料ランクエンティティ;
    }

    @Override
    public int insert(DbT2012HokenryoRankEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.save(data);

        return result;
    }

    @Override
    public int update(DbT2012HokenryoRankEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.save(data);

        return result;
    }

    @Override
    public int delete(DbT2012HokenryoRankEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.save(data);

        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT2012HokenryoRankEntity
     * @return int 件数
     */
    public int deletePhysical(DbT2012HokenryoRankEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.save(data);

        return result;
    }
}
