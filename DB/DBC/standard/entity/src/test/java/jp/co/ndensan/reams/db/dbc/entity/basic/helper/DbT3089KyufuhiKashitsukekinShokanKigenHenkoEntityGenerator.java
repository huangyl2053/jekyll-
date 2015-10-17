/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金償還期限変更エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final RString DEFAULT_貸付管理番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_償還期限延長受付年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_償還期限延長申請年月日 = new FlexibleDate("19900101");
    public static final YubinNo DEFAULT_借受人郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_借受人住所 = new RString("Data");
    public static final AtenaKanaMeisho DEFAULT_借受人氏名カナ = new AtenaKanaMeisho("");
    public static final AtenaMeisho DEFAULT_借受人氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_借受人電話番号 = new TelNo("08011112222");
    public static final Decimal DEFAULT_未償還金額 = new Decimal(0);
    public static final FlexibleDate DEFAULT_償還期限延長希望期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_償還期限延長希望期間終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_償還期限延長理由等 = new RString("Data");
    public static final FlexibleDate DEFAULT_償還期限変更決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_償還期限変更承認_不承認区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_変更後償還期限 = new FlexibleDate("19900101");
    public static final RString DEFAULT_償還期限変更不承認理由 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator() {
    }

    public static DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity() {
        DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity = new DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setShokanKigenEnchoUketsukeYMD(DEFAULT_償還期限延長受付年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShokanKigenEnchoShinseiYMD(DEFAULT_償還期限延長申請年月日);
        entity.setKariukeninYubinNo(DEFAULT_借受人郵便番号);
        entity.setKariukeninJusho(DEFAULT_借受人住所);
        entity.setKariukeninShimeiKana(DEFAULT_借受人氏名カナ);
        entity.setKariukeninShimei(DEFAULT_借受人氏名);
        entity.setKariukeninTelNo(DEFAULT_借受人電話番号);
        entity.setMiShokanKingaku(DEFAULT_未償還金額);
        entity.setEnchoKiboKaishiYMD(DEFAULT_償還期限延長希望期間開始年月日);
        entity.setEnchoKiboShuryoYMD(DEFAULT_償還期限延長希望期間終了年月日);
        entity.setEnchoRiyu(DEFAULT_償還期限延長理由等);
        entity.setHenkoKetteiYMD(DEFAULT_償還期限変更決定年月日);
        entity.setHenkoShonin_FuShoninKubun(DEFAULT_償還期限変更承認_不承認区分);
        entity.setHenkoGoShokanKigenYMD(DEFAULT_変更後償還期限);
        entity.setHenkoFuShoninRiyu(DEFAULT_償還期限変更不承認理由);
        return entity;
    }
}
