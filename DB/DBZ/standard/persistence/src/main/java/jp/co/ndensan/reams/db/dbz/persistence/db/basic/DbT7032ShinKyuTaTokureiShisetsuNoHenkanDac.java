/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkan.kyuTaTokureiShisetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
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
 * 新旧他特例施設番号変換テーブルのデータアクセスクラスです。
 */
public class DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac implements ISaveable<DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧他特例施設番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧他特例施設番号 KyuTaTokureiShisetsuNo
     * @return DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧他特例施設番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7032ShinKyuTaTokureiShisetsuNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuTaTokureiShisetsuNo, 旧他特例施設番号))).
                toObject(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity.class);
    }

    /**
     * 新旧他特例施設番号変換テーブルを全件返します。
     *
     * @return List<DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity>
     */
    @Transaction
    public List<DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7032ShinKyuTaTokureiShisetsuNoHenkan.class).
                toList(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity.class);
    }

    /**
     * DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧他特例施設番号変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
