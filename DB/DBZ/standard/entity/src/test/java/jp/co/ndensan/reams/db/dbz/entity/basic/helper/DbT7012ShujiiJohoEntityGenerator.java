/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報　継承エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7012ShujiiJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_介護医療機関コード = new RString("123");
    public static final RString DEFAULT_介護医師コード = new RString("123");
    public static final RString DEFAULT_医療機関コード = new RString("123");
    public static final RString DEFAULT_医師コード = new RString("123");
    public static final RString DEFAULT_医師の状況 = new RString("1");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo(new RString("0274511"));
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("申請書記載住所");
    public static final TelNo DEFAULT_電話番号 = new TelNo("012-345-6789");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("012-345-6789");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7012ShujiiJohoEntityGenerator() {
    }

    public static DbT7012ShujiiJohoEntity createDbT7012ShujiiJohoEntity() {
        DbT7012ShujiiJohoEntity entity = new DbT7012ShujiiJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setKaigoIryokikanCode(DEFAULT_介護医療機関コード);
        entity.setKaigoIshiCode(DEFAULT_介護医師コード);
        entity.setIryokikanCode(DEFAULT_医療機関コード);
        entity.setIshiShikibetsuNo(DEFAULT_医師コード);
        entity.setShujiiJokyo(DEFAULT_医師の状況);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        return entity;
    }
}
