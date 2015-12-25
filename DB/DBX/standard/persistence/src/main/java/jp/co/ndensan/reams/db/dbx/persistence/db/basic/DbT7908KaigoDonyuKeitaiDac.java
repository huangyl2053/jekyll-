/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitai;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitai.donyuKeitaiCode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitai.gyomuBunrui;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitai.shishoKanriUmuFlag;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護導入形態のデータアクセスクラスです。
 */
public class DbT7908KaigoDonyuKeitaiDac implements ISaveable<DbT7908KaigoDonyuKeitaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護導入形態を取得します。
     *
     * @param 業務分類 GyomuBunrui
     * @param 導入形態コード DonyuKeitaiCode
     * @return DbT7908KaigoDonyuKeitaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7908KaigoDonyuKeitaiEntity selectByKey(
            RString 業務分類,
            Code 導入形態コード) throws NullPointerException {
        requireNonNull(業務分類, UrSystemErrorMessages.値がnull.getReplacedMessage("業務分類"));
        requireNonNull(導入形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("導入形態コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7908KaigoDonyuKeitai.class).
                where(and(
                                eq(gyomuBunrui, 業務分類),
                                eq(donyuKeitaiCode, 導入形態コード))).
                toObject(DbT7908KaigoDonyuKeitaiEntity.class);
    }

    /**
     * 介護導入形態を全件返します。
     *
     * @return List<DbT7908KaigoDonyuKeitaiEntity>
     */
    @Transaction
    public List<DbT7908KaigoDonyuKeitaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7908KaigoDonyuKeitai.class).
                toList(DbT7908KaigoDonyuKeitaiEntity.class);
    }

    /**
     * DbT7908KaigoDonyuKeitaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7908KaigoDonyuKeitaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護導入形態エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 業務分類で介護導入形態を取得します。
     *
     * @param 業務分類 GyomuBunrui
     * @return List<DbT7908KaigoDonyuKeitaiEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7908KaigoDonyuKeitaiEntity selectByGyomuBunrui(
            RString 業務分類) throws NullPointerException {
        requireNonNull(業務分類, UrSystemErrorMessages.値がnull.getReplacedMessage("業務分類"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(gyomuBunrui, donyuKeitaiCode, shishoKanriUmuFlag).
                table(DbT7908KaigoDonyuKeitai.class).
                where(eq(gyomuBunrui, 業務分類)).
                toObject(DbT7908KaigoDonyuKeitaiEntity.class);
    }

}
