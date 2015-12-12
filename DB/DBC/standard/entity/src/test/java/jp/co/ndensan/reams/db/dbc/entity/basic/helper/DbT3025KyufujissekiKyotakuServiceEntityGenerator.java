 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績居宅サービス計画費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3025KyufujissekiKyotakuServiceEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo("012340123400001");
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_サービス計画費明細行番号 = new RString("Data");
    public static final RString DEFAULT_指定_基準該当等事業所区分コード = new RString("Data");
    public static final Decimal DEFAULT_単位数単価 = new Decimal(0);
    public static final FlexibleDate DEFAULT_居宅サービス計画作成依頼届出年月日 = new FlexibleDate("19900101");
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode("1");
    public static final Decimal DEFAULT_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_回数 = new Decimal(0);
    public static final Decimal DEFAULT_サービス単位数 = new Decimal(1);
    public static final Decimal DEFAULT_サービス単位数合計 = new Decimal(1);
    public static final Decimal DEFAULT_請求金額 = new Decimal(1);
    public static final RString DEFAULT_担当介護支援専門員番号 = new RString("Data");
    public static final RString DEFAULT_摘要 = new RString("Data");
    public static final Decimal DEFAULT_後_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_後_回数 = new Decimal(0);
    public static final Decimal DEFAULT_後_サービス単位数 = new Decimal(1);
    public static final Decimal DEFAULT_後_サービス単位数合計 = new Decimal(1);
    public static final Decimal DEFAULT_後_請求金額 = new Decimal(1);
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3025KyufujissekiKyotakuServiceEntityGenerator() {
    }

    public static DbT3025KyufujissekiKyotakuServiceEntity createDbT3025KyufujissekiKyotakuServiceEntity() {
        DbT3025KyufujissekiKyotakuServiceEntity entity = new DbT3025KyufujissekiKyotakuServiceEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setServicePlanhiMeisaiLineNo(DEFAULT_サービス計画費明細行番号);
        entity.setShiteiKijunGaitoJigyoshaKubunCode(DEFAULT_指定_基準該当等事業所区分コード);
        entity.setTanisuTanka(DEFAULT_単位数単価);
        entity.setKyotakuServiceSakuseiIraiYMD(DEFAULT_居宅サービス計画作成依頼届出年月日);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setTanisu(DEFAULT_単位数);
        entity.setKaisu(DEFAULT_回数);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setServiceTanisuTotal(DEFAULT_サービス単位数合計);
        entity.setSeikyuKingaku(DEFAULT_請求金額);
        entity.setTantouKaigoShienSemmoninNo(DEFAULT_担当介護支援専門員番号);
        entity.setTekiyo(DEFAULT_摘要);
        entity.setAtoTanisu(DEFAULT_後_単位数);
        entity.setAtoKaisu(DEFAULT_後_回数);
        entity.setAtoServiceTanisu(DEFAULT_後_サービス単位数);
        entity.setAtoServiceTanisuTotal(DEFAULT_後_サービス単位数合計);
        entity.setAtoSeikyuKingaku(DEFAULT_後_請求金額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
