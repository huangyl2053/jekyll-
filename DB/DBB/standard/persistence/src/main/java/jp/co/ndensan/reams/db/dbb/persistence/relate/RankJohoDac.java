/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2011RankJoho;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2011RankJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ランク情報のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class RankJohoDac implements IModifiable<DbT2011RankJohoEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT2011RankJohoDac ランク情報Dac = InstanceProvider.create(DbT2011RankJohoDac.class);

    /**
     * ランク情報情報をキー検索で１件返します。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     * @return DbT2011RankJohoEntity
     */
    @Transaction
    public DbT2011RankJohoEntity selectランク情報ByKey(FlexibleYear 賦課年度, RankKubun ランク区分) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

        return ランク情報Dac.selectByKey(賦課年度, ランク区分);
    }

    /**
     * 引数に合致するランク情報のリストを返します。。
     *
     * @param 賦課年度 賦課年度
     * @return List<DbT2011RankJohoEntity>
     */
    @Transaction
    public List<DbT2011RankJohoEntity> selectランク情報一覧(FlexibleYear 賦課年度) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2011RankJohoEntity> ランク情報List = accessor.select().
                table(DbT2011RankJoho.class).
                where(eq(DbT2011RankJoho.fukaNendo, 賦課年度)).
                toList(DbT2011RankJohoEntity.class);

        List<DbT2011RankJohoEntity> modelList = new ArrayList<>();

        for (DbT2011RankJohoEntity ランク情報 : ランク情報List) {
            modelList.add(createModel(ランク情報));
        }

        return modelList;
    }

    private DbT2011RankJohoEntity createModel(DbT2011RankJohoEntity ランク情報エンティティ) {
        if (ランク情報エンティティ == null) {
            return null;
        }

        return new DbT2011RankJohoEntity();
    }

    @Override
    public int insert(DbT2011RankJohoEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = ランク情報Dac.save(data);

        return result;
    }

    @Override
    public int update(DbT2011RankJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = ランク情報Dac.save(data);

        return result;
    }

    @Override
    public int delete(DbT2011RankJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = ランク情報Dac.save(data);

        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT2011RankJohoEntity
     * @return int 件数
     */
    public int deletePhysical(DbT2011RankJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = ランク情報Dac.save(data);

        return result;
    }
}
