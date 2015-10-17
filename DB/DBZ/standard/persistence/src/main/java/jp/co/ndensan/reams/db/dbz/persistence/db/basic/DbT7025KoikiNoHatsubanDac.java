/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7025KoikiNoHatsuban;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7025KoikiNoHatsubanEntity;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkan.codeKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域番号発番テーブルのデータアクセスクラスです。
 */
public class DbT7025KoikiNoHatsubanDac implements ISaveable<DbT7025KoikiNoHatsubanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで広域番号発番テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @return DbT7025KoikiNoHatsubanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7025KoikiNoHatsubanEntity selectByKey(
            LasdecCode 市町村コード,
            RString コード区分) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7025KoikiNoHatsuban.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(codeKubun, コード区分))).
                toObject(DbT7025KoikiNoHatsubanEntity.class);
    }

    /**
     * 広域番号発番テーブルを全件返します。
     *
     * @return List<DbT7025KoikiNoHatsubanEntity>
     */
    @Transaction
    public List<DbT7025KoikiNoHatsubanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7025KoikiNoHatsuban.class).
                toList(DbT7025KoikiNoHatsubanEntity.class);
    }

    /**
     * DbT7025KoikiNoHatsubanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7025KoikiNoHatsubanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("広域番号発番テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
