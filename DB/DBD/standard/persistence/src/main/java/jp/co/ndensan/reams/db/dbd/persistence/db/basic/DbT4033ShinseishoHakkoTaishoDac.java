/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshas;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshas.hakkoShoriID;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshas.hihokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshasEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * DB出力(申請書発行対象) 。
 *
 * @reamsid_L DBD-9999-013 liuyl
 */
public class DbT4033ShinseishoHakkoTaishoDac implements ISaveable<DbT4033ShinseishoHakkoTaishoshasEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 申請書発行対象を取得します。
     *
     * @param 発行処理ID UUID
     * @param 被保険者番号 HihokenshaNo
     * @return 申請書発行対象
     */
    @Transaction
    public DbT4033ShinseishoHakkoTaishoshasEntity selectByKey(UUID 発行処理ID, HihokenshaNo 被保険者番号) {
        requireNonNull(発行処理ID, UrSystemErrorMessages.値がnull.getReplacedMessage("発行処理ID"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT4033ShinseishoHakkoTaishoshas.class).
                where(and(
                        eq(hakkoShoriID, 発行処理ID),
                        eq(hihokenshaNo, 被保険者番号))).
                toObject(DbT4033ShinseishoHakkoTaishoshasEntity.class);
    }

    /**
     * DB出力(申請書発行対象) 。
     *
     * @param entity DbT4033ShinseishoHakkoTaishoshasEntity
     * @return int
     */
    @Transaction
    @Override
    public int save(DbT4033ShinseishoHakkoTaishoshasEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額明細エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
