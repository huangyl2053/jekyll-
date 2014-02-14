/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoDoctorEntity;
import jp.co.ndensan.reams.ur.urz.entity.DoctorEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * KaigoDoctorEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoDoctorEntityMock() {
    }

    /**
     * KaigoDoctorEntityを生成して返します。
     *
     * @return KaigoDoctorEntity
     */
    public static KaigoDoctorEntity getSpiedInstance() {
        KaigoDoctorEntity entity = new KaigoDoctorEntity();
        entity.setDoctorEntity(createDoctorEntity());
        entity.setDbT7012ShujiiJohoEntity(createDbT7012ShujiiJohoEntity());
        return spy(entity);
    }

    private static DoctorEntity createDoctorEntity() {
        DoctorEntity entity = new DoctorEntity();
        entity.setIshiShikibetsuCode(new RString("医師識別番号"));
        entity.setDoctorName(new RString("医師氏名"));
        entity.setIryokikanCode(new RString("所属医療機関コード"));
        entity.setShinryokaCode(new RString("所属診療科"));
        entity.setIshiKbn(new RString("医師区分"));
        return spy(entity);
    }

    private static DbT7012ShujiiJohoEntity createDbT7012ShujiiJohoEntity() {
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
