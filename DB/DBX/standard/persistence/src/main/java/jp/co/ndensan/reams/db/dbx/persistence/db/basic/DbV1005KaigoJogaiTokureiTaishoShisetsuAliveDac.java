/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaShubetsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsu.yukoKaishiYMD;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例者台帳管理Aliveのデータアクセスクラスです。
 */
public class DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac implements ISaveable<DbV1005KaigoJogaiTokureiTaishoShisetsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで他市町村住所地特例者台帳管理Aliveを取得します。
     *
     * @param 事業者種別 JigyoshaShubetsu
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始年月日 YukoKaishiYMD
     * @return DbV1005KaigoJogaiTokureiTaishoShisetsuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1005KaigoJogaiTokureiTaishoShisetsuEntity selectByKey(
            RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) throws NullPointerException {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1005KaigoJogaiTokureiTaishoShisetsu.class).
                where(and(
                                eq(jigyoshaShubetsu, 事業者種別),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yukoKaishiYMD, 有効開始年月日))).
                toObject(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

    /**
     * 他市町村住所地特例者台帳管理Aliveを全件返します。
     *
     * @return List<DbV1005KaigoJogaiTokureiTaishoShisetsuEntity>
     */
    @Transaction
    public List<DbV1005KaigoJogaiTokureiTaishoShisetsuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1005KaigoJogaiTokureiTaishoShisetsu.class).
                toList(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

    /**
     * DbV1005KaigoJogaiTokureiTaishoShisetsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例者台帳管理Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
