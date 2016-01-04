/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkan.codeKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkan.gaibuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkan.naibuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkanEntity;
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
 * 各種コード変換テーブルのデータアクセスクラスです。
 */
public class DbT7027KakushuCodeHenkanDac implements ISaveable<DbT7027KakushuCodeHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで各種コード変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @param 外部コード GaibuCode
     * @return DbT7027KakushuCodeHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7027KakushuCodeHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString コード区分,
            RString 外部コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        requireNonNull(外部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7027KakushuCodeHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(codeKubun, コード区分),
                                eq(gaibuCode, 外部コード))).
                toObject(DbT7027KakushuCodeHenkanEntity.class);
    }

    /**
     * 各種コード変換テーブルを全件返します。
     *
     * @return List<DbT7027KakushuCodeHenkanEntity>
     */
    @Transaction
    public List<DbT7027KakushuCodeHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7027KakushuCodeHenkan.class).
                toList(DbT7027KakushuCodeHenkanEntity.class);
    }

    /**
     * DbT7027KakushuCodeHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7027KakushuCodeHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("各種コード変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * コード区分と内部コードより、市町村コードと外部コードを取得します
     *
     * @param コード変換区分 コード変換区分
     * @param 内部コード 内部コード
     * @return DbT7027KakushuCodeHenkanEntity
     */
    @Transaction
    public DbT7027KakushuCodeHenkanEntity selectByCodeKubun(RString コード変換区分, RString 内部コード) {
        requireNonNull(コード変換区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード変換区分"));
        requireNonNull(内部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("内部コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7027KakushuCodeHenkan.class).
                where(and(
                                eq(codeKubun, コード変換区分),
                                eq(naibuCode, 内部コード))).
                toObject(DbT7027KakushuCodeHenkanEntity.class);
    }
}
