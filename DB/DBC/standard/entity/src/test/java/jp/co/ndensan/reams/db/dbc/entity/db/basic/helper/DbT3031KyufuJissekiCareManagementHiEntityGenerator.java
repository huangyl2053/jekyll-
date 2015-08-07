/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3031KyufuJissekiCareManagementHiEntity;
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
 * 給付実績ケアマネジメント費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3031KyufuJissekiCareManagementHiEntityGenerator {

    public static final KokanShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final NyuryokuShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo();
    public static final RString DEFAULT_指定／基準該当事業所区分コード = new RString("Data");
    public static final FlexibleDate DEFAULT_居宅サービス計画作成依頼届出年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_サービス計画費明細行番号 = new RString("Data");
    public static final Decimal DEFAULT_単位数単価 = new Decimal(0);
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode();
    public static final Decimal DEFAULT_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_回数 = new Decimal(0);
    public static final int DEFAULT_サービス単位数 = 1;
    public static final int DEFAULT_サービス単位数合計 = 1;
    public static final int DEFAULT_請求金額 = 1;
    public static final RString DEFAULT_担当介護支援専門員番号 = new RString("Data");
    public static final RString DEFAULT_摘要 = new RString("Data");
    public static final int DEFAULT_利用者負担額 = 1;
    public static final Decimal DEFAULT_後・単位数 = new Decimal(0);
    public static final Decimal DEFAULT_後・回数 = new Decimal(0);
    public static final int DEFAULT_後・サービス単位数 = 1;
    public static final int DEFAULT_後・サービス単位数合計 = 1;
    public static final int DEFAULT_後・請求金額 = 1;
    public static final int DEFAULT_後・利用者負担額 = 1;
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3031KyufuJissekiCareManagementHiEntityGenerator() {
    }

    public static DbT3031KyufuJissekiCareManagementHiEntity createDbT3031KyufuJissekiCareManagementHiEntity() {
        DbT3031KyufuJissekiCareManagementHiEntity entity = new DbT3031KyufuJissekiCareManagementHiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setShiteiKijungaitoJigyoshoKubunCode(DEFAULT_指定／基準該当事業所区分コード);
        entity.setKyotakuServiceSakuseiIraiYMD(DEFAULT_居宅サービス計画作成依頼届出年月日);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setServicePlanhiMeisaiLineNo(DEFAULT_サービス計画費明細行番号);
        entity.setTanisuTanka(DEFAULT_単位数単価);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setTanisu(DEFAULT_単位数);
        entity.setKaisu(DEFAULT_回数);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setSerivceTanisuTotal(DEFAULT_サービス単位数合計);
        entity.setSeikyuKingaku(DEFAULT_請求金額);
        entity.setTantoKaigoShienSemmoninNo(DEFAULT_担当介護支援専門員番号);
        entity.setTekiyo(DEFAULT_摘要);
        entity.setRiyoushaFutangaku(DEFAULT_利用者負担額);
        entity.setAtoTanisu(DEFAULT_後・単位数);
        entity.setAtoKaisu(DEFAULT_後・回数);
        entity.setAtoServiceTanisu(DEFAULT_後・サービス単位数);
        entity.setAtoServiceTanisuTotal(DEFAULT_後・サービス単位数合計);
        entity.setAtoSeikyuKingaku(DEFAULT_後・請求金額);
        entity.setAtoRiyoshaFutangaku(DEFAULT_後・利用者負担額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
