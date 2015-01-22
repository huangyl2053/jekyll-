/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaShubetsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu.yukoKaishiYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護除外住所地特例対象施設のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT1005KaigoJogaiTokureiTaishoShisetsuDac implements IModifiable<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護除外住所地特例対象施設を取得します。
     *
     * @param 事業者種別 JigyoshaShubetsu
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始年月日 YukoKaishiYMD
     * @return DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1005KaigoJogaiTokureiTaishoShisetsuEntity selectByKey(
            RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) throws NullPointerException {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                where(and(
                                eq(jigyoshaShubetsu, 事業者種別),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yukoKaishiYMD, 有効開始年月日))).
                toObject(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

    /**
     * 介護除外住所地特例対象施設を全件返します。
     *
     * @return List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity>
     */
    @Transaction
    public List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
