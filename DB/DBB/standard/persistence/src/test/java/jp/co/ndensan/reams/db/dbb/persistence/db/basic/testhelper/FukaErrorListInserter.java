/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic.testhelper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 賦課エラー一覧テーブルに、テスト用のデータを挿入するためのクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorListInserter {

    @InjectSession
    private SqlSession session;

    /**
     * 受け取った賦課エラー一覧EntityをDBに追加します。
     *
     * @param entity 賦課エラー一覧Entity
     * @return insertに成功したら1
     */
    public int insert(DbT2010FukaErrorListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }
}
