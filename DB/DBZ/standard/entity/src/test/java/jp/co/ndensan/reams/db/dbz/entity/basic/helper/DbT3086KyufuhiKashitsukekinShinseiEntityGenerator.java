/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3086KyufuhiKashitsukekinShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金申請エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3086KyufuhiKashitsukekinShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_借入申請年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final YubinNo DEFAULT_申請者郵便番号 = new YubinNo(new RString("0220103"));
    public static final RString DEFAULT_申請者住所 = new RString("123");
    public static final AtenaKanaMeisho DEFAULT_申請者氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaMeisho DEFAULT_申請者氏名 = new AtenaMeisho("電算太郎");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_申請者との関係 = new RString("123");
    public static final FlexibleDate DEFAULT_借入利用期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_借入利用期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_貸付対象_高額介護サービス費等有無 = new RString("1");
    public static final RString DEFAULT_貸付対象_住宅改修費等有無 = new RString("3");
    public static final RString DEFAULT_貸付対象_福祉用具購入費等有無 = new RString("2");
    public static final RString DEFAULT_貸付対象_特例介護サービス費等有無 = new RString("1");
    public static final AtenaKanaMeisho DEFAULT_保証人氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaMeisho DEFAULT_保証人氏名 = new AtenaMeisho("電算太郎");
    public static final FlexibleDate DEFAULT_保証人生年月日 = new FlexibleDate("20140402");
    public static final Code DEFAULT_保証人性別 = new Code("3");
    public static final YubinNo DEFAULT_保証人郵便番号 = new YubinNo(new RString("0261234"));
    public static final RString DEFAULT_保証人住所 = new RString("123");
    public static final TelNo DEFAULT_保証人電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_借入申請者との関係 = new RString("123");
    public static final AtenaMeisho DEFAULT_保証人勤務先名称 = new AtenaMeisho("電算太郎");
    public static final YubinNo DEFAULT_保証人勤務先郵便番号 = new YubinNo(new RString("0256487"));
    public static final RString DEFAULT_保証人勤務先所在地 = new RString("123");
    public static final TelNo DEFAULT_保証人勤務先電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_請求書_領収書の有無 = new RString("1");
    public static final int DEFAULT_提出物管理番号 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3086KyufuhiKashitsukekinShinseiEntityGenerator() {
    }

    public static DbT3086KyufuhiKashitsukekinShinseiEntity createDbT3086KyufuhiKashitsukekinShinseiEntity() {
        DbT3086KyufuhiKashitsukekinShinseiEntity entity = new DbT3086KyufuhiKashitsukekinShinseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKariireShinseiYMD(DEFAULT_借入申請年月日);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShinseishaYubinNo(DEFAULT_申請者郵便番号);
        entity.setShinseishaJusho(DEFAULT_申請者住所);
        entity.setShinseishaShimeiKana(DEFAULT_申請者氏名カナ);
        entity.setShinseishaShimei(DEFAULT_申請者氏名);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseishaKankei(DEFAULT_申請者との関係);
        entity.setKariireRiyoKaishiYMD(DEFAULT_借入利用期間開始年月日);
        entity.setKariireRiyoShuryoYMD(DEFAULT_借入利用期間終了年月日);
        entity.setKashitsuke_KogakuUmu(DEFAULT_貸付対象_高額介護サービス費等有無);
        entity.setKashitsuke_JutakuKaishuUmu(DEFAULT_貸付対象_住宅改修費等有無);
        entity.setKahitsuke_YoguKonyuUmu(DEFAULT_貸付対象_福祉用具購入費等有無);
        entity.setKashitsuke_TokureiServiceUmu(DEFAULT_貸付対象_特例介護サービス費等有無);
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
        entity.setSeikyusho_RyoshushoUmu(DEFAULT_請求書_領収書の有無);
        entity.setTeishutsubutsuKanriNo(DEFAULT_提出物管理番号);
        return entity;
    }
}
