/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為求償エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3082DaisanshaKoiKyushoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("Data");
    public static final RString DEFAULT_第三者行為求償請求番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_給付額合計 = new Decimal(0);
    public static final Decimal DEFAULT_過失相殺額 = new Decimal(0);
    public static final Decimal DEFAULT_保険給付請求額 = new Decimal(0);
    public static final FlexibleDate DEFAULT_損害賠償金納入期限 = new FlexibleDate("19900101");
    public static final YubinNo DEFAULT_請求先郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_請求先住所 = new RString("Data");
    public static final AtenaMeisho DEFAULT_請求先名称 = new AtenaMeisho("");
    public static final RString DEFAULT_請求先部署 = new RString("Data");
    public static final AtenaMeisho DEFAULT_請求先担当者 = new AtenaMeisho("");
    public static final TelNo DEFAULT_請求先電話番号 = new TelNo("08011112222");

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
        entity.setRirekiNo(DEFAULT_履歴番号);
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
