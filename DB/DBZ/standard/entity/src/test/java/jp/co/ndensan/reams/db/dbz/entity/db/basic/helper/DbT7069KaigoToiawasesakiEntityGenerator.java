/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護問合せ先エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7069KaigoToiawasesakiEntityGenerator {

    public static final SubGyomuCode DEFAULT_サブ業務コード = new SubGyomuCode("000001");
    public static final ReportId DEFAULT_帳票分類ID = new ReportId("000001");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final RString DEFAULT_所在地 = new RString("01");
    public static final RString DEFAULT_庁舎名 = new RString("01");
    public static final TelNo DEFAULT_電話番号 = new TelNo("1112223333");
    public static final RString DEFAULT_内線番号 = new RString("01");
    public static final RString DEFAULT_部署名 = new RString("01");
    public static final RString DEFAULT_担当者名 = new RString("01");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7069KaigoToiawasesakiEntityGenerator() {
    }

    public static DbT7069KaigoToiawasesakiEntity createDbT7069KaigoToiawasesakiEntity() {
        DbT7069KaigoToiawasesakiEntity entity = new DbT7069KaigoToiawasesakiEntity();
        entity.setSubGyomuCode(DEFAULT_サブ業務コード);
        entity.setChohyoBunruiID(DEFAULT_帳票分類ID);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setShozaichi(DEFAULT_所在地);
        entity.setChoshaName(DEFAULT_庁舎名);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setNaisenNo(DEFAULT_内線番号);
        entity.setBushoName(DEFAULT_部署名);
        entity.setTantoshaName(DEFAULT_担当者名);
        return entity;
    }
}
