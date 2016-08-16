/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaShubetsu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu.yukoKaishiYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.DESC;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護除外住所地特例対象施設のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 wanghui
 */
public class DbT1005KaigoJogaiTokureiTaishoShisetsuDac implements ISaveable<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 事業者番号_事業者 = new RString("事業者番号");

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
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage((事業者番号_事業者).toString()));
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

    /**
     * DbT1005KaigoJogaiTokureiTaishoShisetsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護除外住所地特例対象施設エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT1005KaigoJogaiTokureiTaishoShisetsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護除外住所地特例対象施設エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 事業者番号で介護除外住所地特例対象施設を取得します。
     *
     * @param 事業者種類 事業者種別
     * @param 事業者種別 事業者番号
     * @return List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> select介護除外住所地特例対象施設(
            JigyosyaType 事業者種別, JigyoshaNo 事業者番号) throws NullPointerException {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select()
                .table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class)
                .where(and(eq(DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaShubetsu, 事業者種別.getコード()),
                                eq(DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaNo, 事業者番号)))
                .order(by(yukoKaishiYMD, Order.DESC)).limit(1)
                .toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

    /**
     * 有効開始年月日が最新データの事業者名称を取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @return List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> select事業者名称(JigyoshaNo 事業者番号) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                where(eq(DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaNo, 事業者番号)).
                order(by(DbT1005KaigoJogaiTokureiTaishoShisetsu.yukoKaishiYMD, Order.DESC)).
                toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

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
    public List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> selectJigyoshaJoho(
            RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) throws NullPointerException {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage((事業者番号_事業者).toString()));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                where(and(
                                eq(jigyoshaShubetsu, 事業者種別),
                                eq(jigyoshaNo, 事業者番号),
                                eq(yukoKaishiYMD, 有効開始年月日)))
                .toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

    /**
     * 主キーで介護除外住所地特例対象施設を取得します。
     *
     * @param 事業者番号 RString
     * @return DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> select事業者番号(
            RString 事業者番号) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage((事業者番号_事業者).toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                where((eq(jigyoshaNo, 事業者番号)))
                .toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }

    /**
     * 主キーで介護除外住所地特例対象施設を取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @return DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> selectJigyoshaJohoFor施設名取得(
            JigyoshaNo 事業者番号) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage((事業者番号_事業者).toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                where(and(
                                eq(jigyoshaShubetsu, JigyosyaType.住所地特例対象施設.getコード()),
                                eq(jigyoshaNo, 事業者番号))).
                order(by(yukoKaishiYMD, DESC))
                .toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
    }
}
