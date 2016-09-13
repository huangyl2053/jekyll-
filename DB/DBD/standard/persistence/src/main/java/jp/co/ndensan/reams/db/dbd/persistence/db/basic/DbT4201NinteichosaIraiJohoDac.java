/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のデータアクセスクラスです。
 *
 * @reamsid_L DBD-9999-013 x_youyj
 */
public class DbT4201NinteichosaIraiJohoDac {

    @InjectSession
    private SqlSession session;

    /**
     * 認定調査依頼情報のモバイルデータ出力済フラグを出力済みで更新する。
     *
     * @param entity DbT4201NinteichosaIraiJohoEntity
     */
    @Transaction
    public void updateDbt4201johon(DbT4201NinteichosaIraiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        accessor.update(entity);
    }

    /**
     * 要介護認定申請情報のモバイルデータ出力済フラグを出力済みで更新する。
     *
     * @param entity DbT4101NinteiShinseiJohoEntity
     */
    @Transaction
    public void updateDbt4101johon(DbT4101NinteiShinseiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        accessor.update(entity);
    }
}
