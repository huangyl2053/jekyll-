/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * DbT7012ShujiiJohoEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT7012ShujiiJohoEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7012ShujiiJohoEntityMock() {
    }

    /**
     * DbT7012ShujiiJohoEntityを生成して返します。
     *
     * @return DbT7012ShujiiJohoEntity
     */
    public static DbT7012ShujiiJohoEntity getSpiedInstance() {
        DbT7012ShujiiJohoEntity entity = new DbT7012ShujiiJohoEntity();
        entity.setShichosonCode(new RString("市町村コード"));
        entity.setKaigoIryokikanCode(new RString("介護医療機関コード"));
        entity.setKaigoIshiCode(new RString("介護医師コード"));
        entity.setIryokikanCode(new RString("1234567890"));
        entity.setShujiiCode(new RString("医師識別番号"));
        entity.setShujiiJokyo(IshiJokyo.有効.is有効());
        entity.setYubinNo(new RString("1234567"));
        entity.setJusho(new RString("住所コード"));
        entity.setTelNo(new RString("電話番号"));
        entity.setFaxNo(new RString("FAX番号"));
        return spy(entity);
    }
}
