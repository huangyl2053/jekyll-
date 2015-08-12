/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyosha.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3083DaisanshaKoiKyushoMeisai.hihokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7116JukyushaGendoGakuKanri;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT7116JukyushaGendoGakuKanri.shikibetsuKubun;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT7116JukyushaGendoGakuKanri.yukoKaishiYM;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者限度額管理のデータアクセスクラスです。
 */
public class DbT7116JukyushaGendoGakuKanriDac implements ISaveable<DbT7116JukyushaGendoGakuKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受給者限度額管理を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別区分 ShikibetsuKubun
     * @param 有効開始年月 YukoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT7116JukyushaGendoGakuKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7116JukyushaGendoGakuKanriEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 識別区分,
            FlexibleYearMonth 有効開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別区分"));
        requireNonNull(有効開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7116JukyushaGendoGakuKanri.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shikibetsuKubun, 識別区分),
                                eq(yukoKaishiYM, 有効開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7116JukyushaGendoGakuKanriEntity.class);
    }

    /**
     * 受給者限度額管理を全件返します。
     *
     * @return List<DbT7116JukyushaGendoGakuKanriEntity>
     */
    @Transaction
    public List<DbT7116JukyushaGendoGakuKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7116JukyushaGendoGakuKanri.class).
                toList(DbT7116JukyushaGendoGakuKanriEntity.class);
    }

    /**
     * DbT7116JukyushaGendoGakuKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7116JukyushaGendoGakuKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者限度額管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
