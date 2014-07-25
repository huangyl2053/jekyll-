/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
//import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * みなし2号者台帳のデータアクセスインターフェースです。
 *
 * @author N8211 田辺 紘一
 */
public interface IMinashi2GoshaDaichoDac extends IInsertable<DbT1012Minashi2GoshaDaichoEntity> {

    // TODO 田辺 紘一 〆日に間に合わず 2014/07/24
//    @Transaction
//    List<DbT1012Minashi2GoshaDaichoEntity> select(ISearchCondition condition);
}
