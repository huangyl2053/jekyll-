/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金借用書受理エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleDate DEFAULT_借入申請年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_借受年月日 = new FlexibleDate("19900101");
    public static final YubinNo DEFAULT_借受人郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_借受人住所 = new RString("Data");
    public static final AtenaKanaMeisho DEFAULT_借受人氏名カナ = new AtenaKanaMeisho("");
    public static final AtenaMeisho DEFAULT_借受人氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_借受人電話番号 = new TelNo("08011112222");
    public static final AtenaKanaMeisho DEFAULT_保証人氏名カナ = new AtenaKanaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_保証人氏名 = new AtenaKanaMeisho("");
    public static final YubinNo DEFAULT_保証人郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_保証人住所 = new RString("Data");
    public static final TelNo DEFAULT_保証人電話番号 = new TelNo("08011112222");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator() {
    }

    public static DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity createDbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity() {
        DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity = new DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKariireShinseiYMD(DEFAULT_借入申請年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKariukeYMD(DEFAULT_借受年月日);
        entity.setKariukeninYubinNo(DEFAULT_借受人郵便番号);
        entity.setKariukeninJusho(DEFAULT_借受人住所);
        entity.setKariukeninShimeiKana(DEFAULT_借受人氏名カナ);
        entity.setKariukeninShimei(DEFAULT_借受人氏名);
        entity.setKariukeninTelNo(DEFAULT_借受人電話番号);
        entity.setHoshoninShimeiKana(DEFAULT_保証人氏名カナ);
        entity.setHoshoninShimei(DEFAULT_保証人氏名);
        entity.setHoshoninYubinNo(DEFAULT_保証人郵便番号);
        entity.setHoshoninJusho(DEFAULT_保証人住所);
        entity.setHoshoninTelNo(DEFAULT_保証人電話番号);
        return entity;
    }
}
