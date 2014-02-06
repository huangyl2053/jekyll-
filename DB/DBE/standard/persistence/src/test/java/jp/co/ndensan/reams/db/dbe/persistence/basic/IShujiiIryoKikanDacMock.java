/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;

/**
 * 主治医医療機関DACのテスト用selecterのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShujiiIryoKikanDacMock {

    DbT7011ShujiiIryoKikanJohoEntity select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード);
}
