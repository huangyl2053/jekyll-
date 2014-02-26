/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IInsertable;

/**
 * 介護認定審査会開催場所テーブルの情報を扱うデータアクセスクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShinsakaiKaisaiBashoDac extends IInsertable<DbT5104ShinsakaiKaisaiBashoJohoEntity> {
    //TODO n8178 城間篤人 他チケットで再度実装予定のため、ここで必要なものを用意する。今後改修予定 2014年3月末

    /**
     * 審査会開催場所コードを指定して、該当する審査会開催場所の情報を取得します。
     *
     * @param 審査会開催場所コード 審査会開催場所コード
     * @return 審査会開催場所
     */
    DbT5104ShinsakaiKaisaiBashoJohoEntity select(ShinsakaiKaisaiBashoCode 審査会開催場所コード);
}
