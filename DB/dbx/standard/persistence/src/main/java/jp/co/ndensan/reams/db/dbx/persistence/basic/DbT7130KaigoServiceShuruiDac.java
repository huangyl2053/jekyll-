/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類テーブルにアクセスするクラスです。
 *
 * @author n8104 小玉　洋一
 * @jpName 介護サービス種類Dac
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class DbT7130KaigoServiceShuruiDac implements IDbT7130KaigoServiceShuruiDac {

    @InjectSession
    private SqlSession session;

    @Transaction
    @Override
    public List<DbT7130KaigoServiceShuruiEntity> selectList(ITrueFalseCriteria criteria) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor
                .select()
                .table(DbT7130KaigoServiceShurui.class)
                .where(criteria)
                .toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     *
     * 介護サービス種類をDB上にすでに存在する場合は更新、存在しない場合は登録します。
     *
     * @param entity 対象となる介護サービス種類エンティテイ
     * @return 更新行数
     */
    @Transaction
    @Override
    public int insertOrUpdate(DbT7130KaigoServiceShuruiEntity entity) {
        if (getMatchRowCount(entity) == 0) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    @Transaction
    @Override
    public int update(DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.update(kaigoServiceShuruiEntity).execute();
    }

    @Transaction
    @Override
    public int insert(DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.insert(kaigoServiceShuruiEntity).execute();
    }

    @Override
    public int delete(DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.delete(kaigoServiceShuruiEntity).execute();
    }

    private int getMatchRowCount(DbT7130KaigoServiceShuruiEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.select().table(DbT7130KaigoServiceShurui.class).
                where(and(eq(DbT7130KaigoServiceShurui.serviceShuruiCd, entity.getServiceShuruiCd()),
                                leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, entity.getTeikyoKaishiYM()),
                                leq(entity.getTeikyoshuryoYM(), DbT7130KaigoServiceShurui.teikyoshuryoYM))).getCount();
    }
}
