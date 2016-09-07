/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshasEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * DB出力(申請書発行対象) 。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class DbT4033ShinseishoHakkoTaishoDac implements ISaveable<DbT4033ShinseishoHakkoTaishoshasEntity> {

    @InjectSession
    private SqlSession session;

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
