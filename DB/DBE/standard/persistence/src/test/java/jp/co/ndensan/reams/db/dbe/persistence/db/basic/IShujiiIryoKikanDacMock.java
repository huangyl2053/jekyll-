/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関DACのテスト用selecterのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShujiiIryoKikanDacMock {

    @Transaction
    DbT7011ShujiiIryoKikanJohoEntity select(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード);
}
