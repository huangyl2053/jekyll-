/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRank;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.model.fuka.HokenryoRankModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 保険料ランクのデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoRankDac implements IModifiable<HokenryoRankModel> {

    @InjectSession
    private SqlSession session;
    private final DbT2012HokenryoRankDac 保険料ランクDac = InstanceProvider.create(DbT2012HokenryoRankDac.class);

    /**
     * 保険料ランク情報をキー検索で１件返します。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @return HokenryoRankModel
     */
    @Transaction
    public HokenryoRankModel select保険料ランクByKey(FukaNendo 賦課年度, LasdecCode 市町村コード) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        return createModel(保険料ランクDac.selectByKey(賦課年度, 市町村コード));
    }

    /**
     * 引数に合致する保険料ランクのリストを返します。。
     *
     * @param 賦課年度 賦課年度
     * @return List<HokenryoRankModel>
     */
    @Transaction
    public List<HokenryoRankModel> select保険料ランク一覧(FukaNendo 賦課年度) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2012HokenryoRankEntity> 保険料ランクList = accessor.select().
                table(DbT2012HokenryoRank.class).
                where(eq(DbT2012HokenryoRank.fukaNendo, 賦課年度.value())).
                toList(DbT2012HokenryoRankEntity.class);

        List<HokenryoRankModel> modelList = new ArrayList<>();

        for (DbT2012HokenryoRankEntity 保険料ランク : 保険料ランクList) {
            modelList.add(createModel(保険料ランク));
        }

        return modelList;
    }

    private HokenryoRankModel createModel(DbT2012HokenryoRankEntity 保険料ランクエンティティ) {
        if (保険料ランクエンティティ == null) {
            return null;
        }

        return new HokenryoRankModel(保険料ランクエンティティ);
    }

    @Override
    public int insert(HokenryoRankModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.insert(data.getEntity());

        return result;
    }

    @Override
    public int update(HokenryoRankModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.update(data.getEntity());

        return result;
    }

    @Override
    public int delete(HokenryoRankModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.delete(data.getEntity());

        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data HokenryoRankModel
     * @return int 件数
     */
    public int deletePhysical(HokenryoRankModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料ランクDac.deletePhysical(data.getEntity());

        return result;
    }
}
