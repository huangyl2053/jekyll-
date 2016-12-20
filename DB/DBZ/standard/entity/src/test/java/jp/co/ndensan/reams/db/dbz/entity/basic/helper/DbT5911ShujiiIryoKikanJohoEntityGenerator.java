/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5911ShujiiIryoKikanJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202010");
    public static final ShujiiIryokikanCode DEFAULT_主治医医療機関コード = new ShujiiIryokikanCode("000001");
    public static final IryoKikanCode DEFAULT_医療機関コード = new IryoKikanCode("1000000001");
    public static final RString DEFAULT_医療機関名称 = new RString("名称");
    public static final RString DEFAULT_医療機関名称カナ = new RString("名称");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final RString DEFAULT_住所 = new RString("名称");
    public static final TelNo DEFAULT_電話番号 = new TelNo("0123456789");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("0123456789");
    public static final RString DEFAULT_代表者名 = new RString("宛名名称");
    public static final RString DEFAULT_代表者名カナ = new RString("宛名名称カナ");
    public static final boolean DEFAULT_状況フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5911ShujiiIryoKikanJohoEntityGenerator() {
    }

    public static DbT5911ShujiiIryoKikanJohoEntity createDbT5911ShujiiIryoKikanJohoEntity() {
        DbT5911ShujiiIryoKikanJohoEntity entity = new DbT5911ShujiiIryoKikanJohoEntity();
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
        entity.setDaihyoshaNameKana(DEFAULT_代表者名カナ);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
