/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.model.HokenryoDankaiModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;

/**
 * 保険料段階のデータアクセスクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoDankaiDac implements IModifiable<HokenryoDankaiModel> {

    @InjectSession
    private SqlSession session;
    private final DbT2013HokenryoDankaiDac 保険料段階Dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    private final DbT2012HokenryoRankDac 保険料ランクDac = InstanceProvider.create(DbT2012HokenryoRankDac.class);

    /**
     * 保険料段階情報をキー検索で１件返します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階インデックス 段階インデックス
     * @param ランク区分 ランク区分
     * @return HokenryoDankaiModel
     */
    @Transaction
    public HokenryoDankaiModel select保険料段階ByKey(FlexibleYear 賦課年度, DankaiIndex 段階インデックス, RankKubun ランク区分) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階インデックス, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

        return createModel(保険料段階Dac.selectByKey(賦課年度, 段階インデックス, ランク区分));
    }

    /**
     * 引数に合致する保険料段階のリストを返します。
     *
     * @param 賦課年度 賦課年度
     * @return List<HokenryoDankaiModel>
     */
    @Transaction
    public List<HokenryoDankaiModel> select保険料段階一覧(FlexibleYear 賦課年度) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2013HokenryoDankaiEntity> 保険料段階List = accessor.select().
                table(DbT2013HokenryoDankai.class).
                where(eq(DbT2013HokenryoDankai.fukaNendo, 賦課年度)).
                toList(DbT2013HokenryoDankaiEntity.class);

        List<HokenryoDankaiModel> modelList = new ArrayList<>();

        for (DbT2013HokenryoDankaiEntity 保険料段階 : 保険料段階List) {
            modelList.add(createModel(保険料段階));
        }

        return modelList;
    }

    /**
     * 引数に合致する保険料段階のリストを返します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階区分 段階区分
     * @return List<HokenryoDankaiModel>
     */
    @Transaction
    public List<HokenryoDankaiModel> select保険料段階一覧(FlexibleYear 賦課年度, RString 段階区分) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階区分, UrSystemErrorMessages.値がnull.getReplacedMessage("段階区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2013HokenryoDankaiEntity> 保険料段階List = accessor.select().
                table(DbT2013HokenryoDankai.class).
                where(and(
                                eq(DbT2013HokenryoDankai.fukaNendo, 賦課年度),
                                eq(DbT2013HokenryoDankai.dankaiKubun, 段階区分))).
                toList(DbT2013HokenryoDankaiEntity.class);

        List<HokenryoDankaiModel> modelList = new ArrayList<>();

        for (DbT2013HokenryoDankaiEntity 保険料段階 : 保険料段階List) {
            modelList.add(createModel(保険料段階));
        }

        return modelList;
    }

    /**
     * 引数に合致する保険料段階のリストを返します。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @param 段階区分 段階区分
     * @return List<HokenryoDankaiModel>
     */
    @Transaction
    public List<HokenryoDankaiModel> select保険料段階一覧(FlexibleYear 賦課年度, LasdecCode 市町村コード, RString 段階区分) {

        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(段階区分, UrSystemErrorMessages.値がnull.getReplacedMessage("段階区分"));

        DbT2012HokenryoRankEntity entity = 保険料ランクDac.selectByKey(賦課年度, 市町村コード);
        if (entity == null) {
            return Collections.EMPTY_LIST;
        }

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT2013HokenryoDankaiEntity> 保険料段階List = accessor.select().
                table(DbT2013HokenryoDankai.class).
                where(and(
                                eq(DbT2013HokenryoDankai.fukaNendo, 賦課年度),
                                eq(DbT2013HokenryoDankai.rankuKubun, entity.getRankKubun()),
                                eq(DbT2013HokenryoDankai.dankaiKubun, 段階区分))).
                toList(DbT2013HokenryoDankaiEntity.class);

        List<HokenryoDankaiModel> modelList = new ArrayList<>();

        for (DbT2013HokenryoDankaiEntity 保険料段階 : 保険料段階List) {
            modelList.add(createModel(保険料段階));
        }

        return modelList;
    }

    private HokenryoDankaiModel createModel(DbT2013HokenryoDankaiEntity 保険料段階エンティティ) {
        if (保険料段階エンティティ == null) {
            return null;
        }

        return new HokenryoDankaiModel(保険料段階エンティティ);
    }

    @Override
    public int insert(HokenryoDankaiModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料段階Dac.insert(data.getEntity());

        return result;
    }

    @Override
    public int update(HokenryoDankaiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料段階Dac.update(data.getEntity());

        return result;
    }

    @Override
    public int delete(HokenryoDankaiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料段階Dac.delete(data.getEntity());

        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data HokenryoDankaiModel
     * @return int 件数
     */
    public int deletePhysical(HokenryoDankaiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 保険料段階Dac.deletePhysical(data.getEntity());

        return result;
    }
}
