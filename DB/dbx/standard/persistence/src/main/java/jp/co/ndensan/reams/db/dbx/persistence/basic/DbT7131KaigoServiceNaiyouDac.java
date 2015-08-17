/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessor;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス内容テーブルにアクセスするクラスです。
 *
 * @author n8104 小玉 洋一
 * @jpName 介護サービス内容Dac
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class DbT7131KaigoServiceNaiyouDac implements IDbT7131KaigoServiceNaiyouDac {

    @InjectSession
    private SqlSession session;

    @Transaction
    @Override
    public List<DbT7131KaigoServiceNaiyouEntity> selectList(ITrueFalseCriteria criteria) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor
                .select()
                .table(DbT7131KaigoServiceNaiyou.class)
                .where(criteria)
                .toList(DbT7131KaigoServiceNaiyouEntity.class);
    }

    /**
     * 介護サービス内容をDB上にすでに存在する場合は更新、存在しない場合は登録します。
     *
     * @param entity 対象となる介護サービス内容エンティテイ
     * @return 更新行数
     */
    @Transaction
    @Override
    public int insertOrUpdate(DbT7131KaigoServiceNaiyouEntity entity) {
        if (getMatchRowCount(entity) == 0) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    /**
     * 介護サービス内容テーブルをアップデートします。
     *
     * @param kaigoServiceNaiyoEntity データベースに反映されるデータ
     * @return 更新した行の数
     */
    @Transaction
    @Override
    public int update(DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyoEntity) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.update(kaigoServiceNaiyoEntity).execute();
    }

    /**
     * 介護サービス内容テーブルを挿入します。
     *
     * @param kaigoServiceNaiyoEntity データベースに反映されるデータ
     * @return 更新した行の数
     */
    @Transaction
    @Override
    public int insert(DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyoEntity) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.insert(kaigoServiceNaiyoEntity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyoEntity) {
        DbAccessor accessor = new DbAccessor(session);

        return accessor.delete(kaigoServiceNaiyoEntity).execute();
    }

    private int getMatchRowCount(DbT7131KaigoServiceNaiyouEntity entity) {
        DbAccessor accessor = new DbAccessor(session);
        return accessor.select().table(DbT7131KaigoServiceNaiyou.class).
                where(and(eq(DbT7131KaigoServiceNaiyou.serviceShuruiCode, entity.getServiceShuruiCode()),
                                eq(DbT7131KaigoServiceNaiyou.serviceKoumokuCode, entity.getServiceKoumokuCode()),
                                eq(DbT7131KaigoServiceNaiyou.rirekiNo, entity.getRirekiNo()),
                                eq(DbT7131KaigoServiceNaiyou.teikyoKaishiYM, entity.getTeikyoKaishiYM()),
                                eq(DbT7131KaigoServiceNaiyou.teikyoShuryoYM, entity.getTeikyoShuryoYM()))).getCount();
    }
}
