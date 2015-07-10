/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金借用書受理エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_借入申請年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_借受年月日 = new FlexibleDate("20140402");
    public static final YubinNo DEFAULT_借受人郵便番号 = new YubinNo(new RString("0100201"));
    public static final RString DEFAULT_借受人住所 = new RString("123");
    public static final AtenaKanaMeisho DEFAULT_借受人氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaMeisho DEFAULT_借受人氏名 = new AtenaMeisho("電算太郎");
    public static final TelNo DEFAULT_借受人電話番号 = new TelNo("012-345-6789");
    public static final AtenaKanaMeisho DEFAULT_保証人氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaKanaMeisho DEFAULT_保証人氏名 = new AtenaKanaMeisho("デンサンタロウ");
    public static final YubinNo DEFAULT_保証人郵便番号 = new YubinNo(new RString("0201234"));
    public static final RString DEFAULT_保証人住所 = new RString("123");
    public static final TelNo DEFAULT_保証人電話番号 = new TelNo("012-345-6789");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator() {
    }

    public static DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity createDbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity() {
        DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity = new DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKariireShinseiYMD(DEFAULT_借入申請年月日);
        entity.setShoriTimestamp(DEFAULT_処理日時);
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
