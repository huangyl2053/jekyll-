/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績社会福祉法人軽減額エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo(new RString("2"));
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo(new RString("2"));
    public static final RString DEFAULT_レコード種別コード = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_通し番号 = new RString("1");
    public static final Decimal DEFAULT_軽減率 = new Decimal(1);
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final int DEFAULT_受領すべき利用者負担の総額 = 1;
    public static final int DEFAULT_軽減額 = 1;
    public static final int DEFAULT_軽減後利用者負担額 = 1;
    public static final RString DEFAULT_備考 = new RString("1");
    public static final int DEFAULT_後_受領すべき利用者負担の総額 = 1;
    public static final int DEFAULT_後_軽減額 = 1;
    public static final int DEFAULT_後_軽減後利用者負担額 = 1;
    public static final int DEFAULT_再審査回数 = 1;
    public static final int DEFAULT_過誤回数 = 1;
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator() {
    }

    public static DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity() {
        DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity = new DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setKeigenritsu(DEFAULT_軽減率);
        entity.setServiceSyuruiCode(DEFAULT_サービス種類コード);
        entity.setRiyoshaFutanTotal(DEFAULT_受領すべき利用者負担の総額);
        entity.setKeigengaku(DEFAULT_軽減額);
        entity.setKeigengoRiyoshaFutangaku(DEFAULT_軽減後利用者負担額);
        entity.setBiko(DEFAULT_備考);
        entity.setAtoRiyoshaFutanTotal(DEFAULT_後_受領すべき利用者負担の総額);
        entity.setAtoKeigengaku(DEFAULT_後_軽減額);
        entity.setAtoKeigengoRiyoshaFutangaku(DEFAULT_後_軽減後利用者負担額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
