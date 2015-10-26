/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5911ShujiiIryoKikanJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final RString DEFAULT_主治医医療機関コード = new RString("1");
    public static final IryoKikanCode DEFAULT_医療機関コード = new IryoKikanCode("1");
    public static final RString DEFAULT_医療機関名称 = new RString("1");
    public static final RString DEFAULT_医療機関名称カナ = new RString("1");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("3801234");
    public static final RString DEFAULT_住所 = new RString("あ");
    public static final TelNo DEFAULT_電話番号 = new TelNo("1234567890");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("1234567890");
    public static final RString DEFAULT_代表者名 = new RString("あ");
    public static final RString DEFAULT_代表者名カナ = new RString("あ");
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
