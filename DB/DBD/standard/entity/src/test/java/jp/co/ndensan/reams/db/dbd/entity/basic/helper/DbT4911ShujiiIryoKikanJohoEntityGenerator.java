/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.basic.helper;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8235 船山洋介
 */
public final class DbT4911ShujiiIryoKikanJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("100001");
    public static final ShujiiIryokikanCode DEFAULT_主治医医療機関コード = new ShujiiIryokikanCode("1000000001");
    public static final IryoKikanCode DEFAULT_医療機関コード = new IryoKikanCode("1000000001");
    public static final RString DEFAULT_医療機関名称 = new RString("医療機関名称");
    public static final RString DEFAULT_医療機関名称カナ = new RString("イリョウキカンメイショウカナ");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final RString DEFAULT_住所 = new RString("住所");
    public static final TelNo DEFAULT_電話番号 = new TelNo("99999999999");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("99999999990");
    public static final AtenaMeisho DEFAULT_代表者名 = new AtenaMeisho("代表者名");
    public static final boolean DEFAULT_状況フラグ = true;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4911ShujiiIryoKikanJohoEntityGenerator() {
    }

    public static DbT4911ShujiiIryoKikanJohoEntity createDbT4911ShujiiIryoKikanJohoEntity() {
        DbT4911ShujiiIryoKikanJohoEntity entity = new DbT4911ShujiiIryoKikanJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShujiiIryokikanCode(DEFAULT_主治医医療機関コード);
        entity.setIryokikanCode(DEFAULT_医療機関コード);
        entity.setIryoKikanMeisho(DEFAULT_医療機関名称);
        entity.setIryoKikanMeishoKana(DEFAULT_医療機関名称カナ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setDaihyoshaName(DEFAULT_代表者名);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
