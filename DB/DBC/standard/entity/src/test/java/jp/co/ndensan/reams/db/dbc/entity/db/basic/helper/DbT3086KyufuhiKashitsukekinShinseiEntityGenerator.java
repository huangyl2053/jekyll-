/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3086KyufuhiKashitsukekinShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金申請エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3086KyufuhiKashitsukekinShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleDate DEFAULT_借入申請年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final YubinNo DEFAULT_申請者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_申請者住所 = new RString("Data");
    public static final AtenaKanaMeisho DEFAULT_申請者氏名カナ = new AtenaKanaMeisho("");
    public static final AtenaMeisho DEFAULT_申請者氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_申請者との関係 = new RString("Data");
    public static final FlexibleDate DEFAULT_借入利用期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_借入利用期間終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_貸付対象・高額介護サービス費等有無 = new RString("Data");
    public static final RString DEFAULT_貸付対象・住宅改修費等有無 = new RString("Data");
    public static final RString DEFAULT_貸付対象・福祉用具購入費等有無 = new RString("Data");
    public static final RString DEFAULT_貸付対象・特例介護サービス費等有無 = new RString("Data");
    public static final AtenaKanaMeisho DEFAULT_保証人氏名カナ = new AtenaKanaMeisho("");
    public static final AtenaMeisho DEFAULT_保証人氏名 = new AtenaMeisho("");
    public static final FlexibleDate DEFAULT_保証人生年月日 = new FlexibleDate("19900101");
    public static final Code DEFAULT_保証人性別 = new Code();
    public static final YubinNo DEFAULT_保証人郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_保証人住所 = new RString("Data");
    public static final TelNo DEFAULT_保証人電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_借入申請者との関係 = new RString("Data");
    public static final AtenaMeisho DEFAULT_保証人勤務先名称 = new AtenaMeisho("");
    public static final YubinNo DEFAULT_保証人勤務先郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_保証人勤務先所在地 = new RString("Data");
    public static final TelNo DEFAULT_保証人勤務先電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_請求書・領収書の有無 = new RString("Data");
    public static final Decimal DEFAULT_提出物管理番号 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3086KyufuhiKashitsukekinShinseiEntityGenerator() {
    }

    public static DbT3086KyufuhiKashitsukekinShinseiEntity createDbT3086KyufuhiKashitsukekinShinseiEntity() {
        DbT3086KyufuhiKashitsukekinShinseiEntity entity = new DbT3086KyufuhiKashitsukekinShinseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKariireShinseiYMD(DEFAULT_借入申請年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShinseishaYubinNo(DEFAULT_申請者郵便番号);
        entity.setShinseishaJusho(DEFAULT_申請者住所);
        entity.setShinseishaShimeiKana(DEFAULT_申請者氏名カナ);
        entity.setShinseishaShimei(DEFAULT_申請者氏名);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseishaKankei(DEFAULT_申請者との関係);
        entity.setKariireRiyoKaishiYMD(DEFAULT_借入利用期間開始年月日);
        entity.setKariireRiyoShuryoYMD(DEFAULT_借入利用期間終了年月日);
        entity.setKashitsuke_KogakuUmu(DEFAULT_貸付対象・高額介護サービス費等有無);
        entity.setKashitsuke_JutakuKaishuUmu(DEFAULT_貸付対象・住宅改修費等有無);
        entity.setKahitsuke_YoguKonyuUmu(DEFAULT_貸付対象・福祉用具購入費等有無);
        entity.setKashitsuke_TokureiServiceUmu(DEFAULT_貸付対象・特例介護サービス費等有無);
        entity.setHoshonin_ShimeiKana(DEFAULT_保証人氏名カナ);
        entity.setHoshonin_Shimei(DEFAULT_保証人氏名);
        entity.setHoshonin_UmareYMD(DEFAULT_保証人生年月日);
        entity.setHoshinin_SeibetsuCd(DEFAULT_保証人性別);
        entity.setHoshonin_YubinNo(DEFAULT_保証人郵便番号);
        entity.setHoshonin_Jusho(DEFAULT_保証人住所);
        entity.setHoshonin_TelNo(DEFAULT_保証人電話番号);
        entity.setKariireShinseishaKankei(DEFAULT_借入申請者との関係);
        entity.setHoshonin_KinmusakiMeisho(DEFAULT_保証人勤務先名称);
        entity.setHoshonin_KinmusakiYubinNo(DEFAULT_保証人勤務先郵便番号);
        entity.setHoshonin_KinmusakiJusho(DEFAULT_保証人勤務先所在地);
        entity.setHoshonin_KinmusakiTelNo(DEFAULT_保証人勤務先電話番号);
        entity.setSeikyusho_RyoshushoUmu(DEFAULT_請求書・領収書の有無);
        entity.setTeishutsubutsuKanriNo(DEFAULT_提出物管理番号);
        return entity;
    }
}
