/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri.kijunTimestamp;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri.nendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri.shoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.in;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付管理マスタのデータアクセスクラスです。
 *
 * @reamsid_L DBB-9999-012 xuxin
 */
public class DbT7022ShoriDateKanriDac implements ISaveable<DbT7022ShoriDateKanriEntity> {

    private static final RString 処理名_本算定賦課 = new RString("本算定賦課");
    private static final RString 処理名_普徴仮算定賦課確定 = new RString("普徴仮算定賦課確定");
    private static final RString 処理名_仮算定異動賦課確定 = new RString("仮算定異動賦課確定");
    private static final RString 処理名_本算定賦課確定 = new RString("本算定賦課確定");
    private static final RString 処理名_異動賦課確定 = new RString("異動賦課確定");
    private static final RString 処理名_過年度賦課確定 = new RString("過年度賦課確定");
    private static final int 開始桁数 = 1;
    private static final int LENGTH = 6;

    @InjectSession
    private SqlSession session;

    /**
     * 最大基準日時の取得です。
     *
     * @param 賦課年度 FlexibleYear
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity get最大基準日時(FlexibleYear 賦課年度) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(kijunTimestamp)).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(shoriName, 処理名_本算定賦課),
                                eq(nendo, 賦課年度)
                        )).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 月次処理状況の取得です。
     *
     * @param 口座振替年月 FlexibleYearMonth
     * @return List<DbT7022ShoriDateKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> get月次処理状況(FlexibleYearMonth 口座振替年月) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(kijunTimestamp).
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(substr(kijunTimestamp, 開始桁数, LENGTH), 口座振替年月),
                                in(shoriName,
                                        処理名_普徴仮算定賦課確定,
                                        処理名_仮算定異動賦課確定,
                                        処理名_本算定賦課確定,
                                        処理名_異動賦課確定,
                                        処理名_過年度賦課確定))).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    public int save(DbT7022ShoriDateKanriEntity entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
