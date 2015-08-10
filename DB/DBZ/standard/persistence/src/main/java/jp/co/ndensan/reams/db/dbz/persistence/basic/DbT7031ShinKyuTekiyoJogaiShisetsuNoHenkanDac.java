/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan.kyuTekiyoJogaiShisetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧適用除外施設番号変換テーブルのデータアクセスクラスです。
 */
public class DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanDac implements ISaveable<DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧適用除外施設番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧適用除外施設番号 KyuTekiyoJogaiShisetsuNo
     * @return DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧適用除外施設番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuTekiyoJogaiShisetsuNo, 旧適用除外施設番号))).
                toObject(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.class);
    }

    /**
     * 新旧適用除外施設番号変換テーブルを全件返します。
     *
     * @return List<DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity>
     */
    @Transaction
    public List<DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan.class).
                toList(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.class);
    }

    /**
     * DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧適用除外施設番号変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
