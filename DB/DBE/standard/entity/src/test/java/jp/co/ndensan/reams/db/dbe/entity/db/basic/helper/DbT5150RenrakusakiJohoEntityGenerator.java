/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護連絡先情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5150RenrakusakiJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_連番 = 1;
    public static final RString DEFAULT_連絡先区分番号 = new RString("1");
    public static final ShishoCode DEFAULT_支所コード = new ShishoCode("123456");
    public static final AtenaMeisho DEFAULT_連絡先氏名 = new AtenaMeisho("あああ");
    public static final AtenaKanaMeisho DEFAULT_連絡先氏名カナ = new AtenaKanaMeisho("カナ");
    public static final RString DEFAULT_連絡先続柄 = new RString("1");
    public static final YubinNo DEFAULT_連絡先郵便番号 = new YubinNo("3801234");
    public static final AtenaJusho DEFAULT_連絡先住所 = new AtenaJusho("長野市県町");
    public static final TelNo DEFAULT_連絡先電話番号 = new TelNo("123456790");
    public static final TelNo DEFAULT_連絡先携帯番号 = new TelNo("123456790");
    public static final int DEFAULT_優先順位 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5150RenrakusakiJohoEntityGenerator() {
    }

    public static DbT5150RenrakusakiJohoEntity createDbT5150RenrakusakiJohoEntity() {
        DbT5150RenrakusakiJohoEntity entity = new DbT5150RenrakusakiJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setRenban(DEFAULT_連番);
        entity.setRenrakusakiKubunNo(DEFAULT_連絡先区分番号);
        entity.setShishoCode(DEFAULT_支所コード);
        entity.setRenrakusakiShimei(DEFAULT_連絡先氏名);
        entity.setRenrakusakiKanaSimei(DEFAULT_連絡先氏名カナ);
        entity.setRenrakusakiTuzukigara(DEFAULT_連絡先続柄);
        entity.setRenrakusakiYubinNo(DEFAULT_連絡先郵便番号);
        entity.setRenrakusakiJusho(DEFAULT_連絡先住所);
        entity.setRenrakusakiTelNo(DEFAULT_連絡先電話番号);
        entity.setRenrakusakiKeitaiTelNo(DEFAULT_連絡先携帯番号);
        entity.setPriority(DEFAULT_優先順位);
        return entity;
    }
}
