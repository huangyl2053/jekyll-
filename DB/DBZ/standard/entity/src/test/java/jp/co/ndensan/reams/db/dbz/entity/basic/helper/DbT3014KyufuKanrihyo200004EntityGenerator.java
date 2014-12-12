/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付管理票200004エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3014KyufuKanrihyo200004EntityGenerator {

    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final JigyoshaNo DEFAULT_居宅支援事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_給付管理票情報作成区分コード = new RString("1");
    public static final FlexibleDate DEFAULT_給付管理票作成年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_給付管理票種別区分コード = new RString("1");
    public static final RString DEFAULT_給付管理票明細行番号 = new RString("1");
    public static final HokenshaNo DEFAULT_保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_被保険者生年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_性別コード = new RString("1");
    public static final RString DEFAULT_要介護状態区分コード = new RString("1");
    public static final FlexibleDate DEFAULT_限度額適用期間_開始 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_限度額適用期間_終了 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_居宅_介護予防支給限度額 = new Decimal(1);
    public static final RString DEFAULT_居宅サービス計画作成区分コード = new RString("1");
    public static final JigyoshaNo DEFAULT_サービス事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_指定_基準該当_地域密着型サービス識別コード = new RString("1");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final Decimal DEFAULT_給付計画単位数 = new Decimal(1);
    public static final Decimal DEFAULT_限度額管理期間における前月までの給付計画日数 = new Decimal(1);
    public static final Decimal DEFAULT_指定サービス分小計 = new Decimal(1);
    public static final Decimal DEFAULT_基準該当サービス分小計 = new Decimal(1);
    public static final Decimal DEFAULT_給付計画合計単位数_日数 = new Decimal(1);
    public static final FlexibleDate DEFAULT_当初登録年月日 = new FlexibleDate("20140402");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3014KyufuKanrihyo200004EntityGenerator() {
    }

    public static DbT3014KyufuKanrihyo200004Entity createDbT3014KyufuKanrihyo200004Entity() {
        DbT3014KyufuKanrihyo200004Entity entity = new DbT3014KyufuKanrihyo200004Entity();
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setKyotakushienJigyoshoNo(DEFAULT_居宅支援事業所番号);
        entity.setKyufuKanrihyoSakuseiKubunCode(DEFAULT_給付管理票情報作成区分コード);
        entity.setKyufuKanrihyoSakuseiYMD(DEFAULT_給付管理票作成年月日);
        entity.setKyufuKanrihyoShubetsuKubunCode(DEFAULT_給付管理票種別区分コード);
        entity.setKyufuKanrihyoMeisaiLineNo(DEFAULT_給付管理票明細行番号);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setHiHokenshaUmareYMD(DEFAULT_被保険者生年月日);
        entity.setSeibetsuCode(DEFAULT_性別コード);
        entity.setYoKaigoJotaiKubunCode(DEFAULT_要介護状態区分コード);
        entity.setGendogakuTekiyoKaishiYMD(DEFAULT_限度額適用期間_開始);
        entity.setGendogakuTekiyoShuryoYMD(DEFAULT_限度額適用期間_終了);
        entity.setKyotakuKaigoYoboShikyuGendogaku(DEFAULT_居宅_介護予防支給限度額);
        entity.setKyotakuServicePlanSakuseiKubunCode(DEFAULT_居宅サービス計画作成区分コード);
        entity.setServiceJigyoshoNo(DEFAULT_サービス事業所番号);
        entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(DEFAULT_指定_基準該当_地域密着型サービス識別コード);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setKyufuKeikakuTanisuNissu(DEFAULT_給付計画単位数);
        entity.setKyufuKeikakuNissu(DEFAULT_限度額管理期間における前月までの給付計画日数);
        entity.setShiteiServiceSubTotal(DEFAULT_指定サービス分小計);
        entity.setKijyunGaitoServiceSubTotal(DEFAULT_基準該当サービス分小計);
        entity.setKyufuKeikakuTotalTanisuNissu(DEFAULT_給付計画合計単位数_日数);
        entity.setToshoTorokuYMD(DEFAULT_当初登録年月日);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
