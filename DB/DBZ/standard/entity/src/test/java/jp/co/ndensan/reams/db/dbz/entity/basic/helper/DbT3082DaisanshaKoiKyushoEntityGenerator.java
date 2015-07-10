/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為求償エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3082DaisanshaKoiKyushoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("0"));
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("123");
    public static final RString DEFAULT_第三者行為求償請求番号 = new RString("123");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final Decimal DEFAULT_給付額合計 = new Decimal(10000);
    public static final Decimal DEFAULT_過失相殺額 = new Decimal(10000);
    public static final Decimal DEFAULT_保険給付請求額 = new Decimal(10000);
    public static final FlexibleDate DEFAULT_損害賠償金納入期限 = new FlexibleDate("20140402");
    public static final YubinNo DEFAULT_請求先郵便番号 = new YubinNo(new RString("0102013"));
    public static final RString DEFAULT_請求先住所 = new RString("123");
    public static final AtenaMeisho DEFAULT_請求先名称 = new AtenaMeisho("電算太郎");
    public static final RString DEFAULT_請求先部署 = new RString("123");
    public static final AtenaMeisho DEFAULT_請求先担当者 = new AtenaMeisho("電算太郎");
    public static final TelNo DEFAULT_請求先電話番号 = new TelNo("012-345-6789");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3082DaisanshaKoiKyushoEntityGenerator() {
    }

    public static DbT3082DaisanshaKoiKyushoEntity createDbT3082DaisanshaKoiKyushoEntity() {
        DbT3082DaisanshaKoiKyushoEntity entity = new DbT3082DaisanshaKoiKyushoEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setKyushoSeikyuNo(DEFAULT_第三者行為求償請求番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKyufuGakuGokei(DEFAULT_給付額合計);
        entity.setKashitsuSosatsuGaku(DEFAULT_過失相殺額);
        entity.setHokenKyufuSeikyuGaku(DEFAULT_保険給付請求額);
        entity.setSongaiBaishoKinNonyuYMD(DEFAULT_損害賠償金納入期限);
        entity.setSeikyusakiYubinNo(DEFAULT_請求先郵便番号);
        entity.setSeikyusakiJusho(DEFAULT_請求先住所);
        entity.setSeikyusakiMeisho(DEFAULT_請求先名称);
        entity.setSeikyusakiBusho(DEFAULT_請求先部署);
        entity.setSeikyusakiTantosha(DEFAULT_請求先担当者);
        entity.setSeikyusakiTelNo(DEFAULT_請求先電話番号);
        return entity;
    }
}
