/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 日常生活予防給付計画自己作成明細エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_居宅サービス区分 = new RString("1");
    public static final JigyoshaNo DEFAULT_サービス提供事業者番号 = new JigyoshaNo(new RString("2"));
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode(new RString("2"));
    public static final Decimal DEFAULT_単位数 = new Decimal(1);
    public static final Decimal DEFAULT_回数_日数 = new Decimal(1);
    public static final Decimal DEFAULT_種類限度内単位数_日数 = new Decimal(1);
    public static final Decimal DEFAULT_種類限度超過単位数_日数 = new Decimal(1);
    public static final Decimal DEFAULT_区分限度内単位数_日数 = new Decimal(1);
    public static final Decimal DEFAULT_区分限度超過単位数_日数 = new Decimal(1);
    public static final Decimal DEFAULT_単位数単価 = new Decimal(1);
    public static final HokenKyufuRitsu DEFAULT_給付率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final HokenKyufuRitsu DEFAULT_割引後適用率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final Decimal DEFAULT_割引後適用単位数 = new Decimal(1);
    public static final Decimal DEFAULT_定額利用者負担単価金額 = new Decimal(1);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator() {
    }

    public static DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity createDbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity() {
        DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = new DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKyotakuServiceKubun(DEFAULT_居宅サービス区分);
        entity.setServiceTeikyoJigyoshaNo(DEFAULT_サービス提供事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTaniSu(DEFAULT_単位数);
        entity.setKaisu_Nissu(DEFAULT_回数_日数);
        entity.setShuruiGendoNaiTaniSu_Nissu(DEFAULT_種類限度内単位数_日数);
        entity.setShuruiGendoChokaTaniSu_Nissu(DEFAULT_種類限度超過単位数_日数);
        entity.setKubunGendoNaiTaniSu_Nissu(DEFAULT_区分限度内単位数_日数);
        entity.setKubunGendoChokaTaniSu_Nissu(DEFAULT_区分限度超過単位数_日数);
        entity.setTaniSuTanka(DEFAULT_単位数単価);
        entity.setKyufuRitsu(DEFAULT_給付率);
        entity.setWaribikiGoTekiyoRitsu(DEFAULT_割引後適用率);
        entity.setWaribikiGoTekiyoTaniSu(DEFAULT_割引後適用単位数);
        entity.setTeigakuRiyoshaFutanTankaKingaku(DEFAULT_定額利用者負担単価金額);
        return entity;
    }
}
