/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiEntity;
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
 * 予防給付計画自己作成明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_居宅サービス区分 = new RString("Data");
    public static final JigyoshaNo DEFAULT_サービス提供事業者番号 = new JigyoshaNo();
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode();
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode();
    public static final Decimal DEFAULT_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_回数・日数 = new Decimal(0);
    public static final Decimal DEFAULT_種類限度内単位数・日数 = new Decimal(0);
    public static final Decimal DEFAULT_種類限度超過単位数・日数 = new Decimal(0);
    public static final Decimal DEFAULT_区分限度内単位数・日数 = new Decimal(0);
    public static final Decimal DEFAULT_区分限度超過単位数・日数 = new Decimal(0);
    public static final Decimal DEFAULT_単位数単価 = new Decimal(0);
    public static final HokenKyufuRitsu DEFAULT_給付率 = new HokenKyufuRitsu();
    public static final HokenKyufuRitsu DEFAULT_割引後適用率 = new HokenKyufuRitsu();
    public static final Decimal DEFAULT_割引後適用単位数 = new Decimal(0);
    public static final Decimal DEFAULT_定額利用者負担単価金額 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator() {
    }

    public static DbT3011YoboKeikakuJikoSakuseiMeisaiEntity createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity() {
        DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity = new DbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKyotakuServiceKubun(DEFAULT_居宅サービス区分);
        entity.setServiceTeikyoJigyoshaNo(DEFAULT_サービス提供事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTaniSu(DEFAULT_単位数);
        entity.setKaisu_Nissu(DEFAULT_回数・日数);
        entity.setShuruiGendoNaiTaniSu_Nissu(DEFAULT_種類限度内単位数・日数);
        entity.setShuruiGendoChokaTaniSu_Nissu(DEFAULT_種類限度超過単位数・日数);
        entity.setKubunGendoNaiTaniSu_Nissu(DEFAULT_区分限度内単位数・日数);
        entity.setKubunGendoChokaTaniSu_Nissu(DEFAULT_区分限度超過単位数・日数);
        entity.setTaniSuTanka(DEFAULT_単位数単価);
        entity.setKyufuRitsu(DEFAULT_給付率);
        entity.setWaribikiGoTekiyoRitsu(DEFAULT_割引後適用率);
        entity.setWaribikiGoTekiyoTaniSu(DEFAULT_割引後適用単位数);
        entity.setTeigakuRiyoshaFutanTankaKingaku(DEFAULT_定額利用者負担単価金額);
        return entity;
    }
}
