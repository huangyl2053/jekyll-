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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績特定入所者介護サービス費用エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo(new RString("2"));
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo(new RString("2"));
    public static final RString DEFAULT_レコード種別コード = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_通し番号 = new RString("1");
    public static final RString DEFAULT_特定入所者介護サービス費用情報レコード順次番号 = new RString("1");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode(new RString("2"));
    public static final int DEFAULT_費用単価 = 1;
    public static final int DEFAULT_負担限度額 = 1;
    public static final int DEFAULT_日数 = 1;
    public static final int DEFAULT_公費１日数 = 1;
    public static final int DEFAULT_公費２日数 = 1;
    public static final int DEFAULT_公費３日数 = 1;
    public static final int DEFAULT_費用額 = 1;
    public static final int DEFAULT_保険分請求額 = 1;
    public static final int DEFAULT_公費１負担額_明細 = 1;
    public static final int DEFAULT_公費２負担額_明細 = 1;
    public static final int DEFAULT_公費３負担額_明細 = 1;
    public static final int DEFAULT_利用者負担額 = 1;
    public static final int DEFAULT_費用額合計 = 1;
    public static final int DEFAULT_保険分請求額合計 = 1;
    public static final int DEFAULT_利用者負担額合計 = 1;
    public static final int DEFAULT_公費１_負担額合計 = 1;
    public static final int DEFAULT_公費１_請求額 = 1;
    public static final int DEFAULT_公費１_本人負担月額 = 1;
    public static final int DEFAULT_公費２_負担額合計 = 1;
    public static final int DEFAULT_公費２_請求額 = 1;
    public static final int DEFAULT_公費２_本人負担月額 = 1;
    public static final int DEFAULT_公費３_負担額合計 = 1;
    public static final int DEFAULT_公費３_請求額 = 1;
    public static final int DEFAULT_公費３_本人負担月額 = 1;
    public static final int DEFAULT_後_費用単価 = 1;
    public static final int DEFAULT_後_日数 = 1;
    public static final int DEFAULT_後_公費１日数 = 1;
    public static final int DEFAULT_後_公費２日数 = 1;
    public static final int DEFAULT_後_公費３日数 = 1;
    public static final int DEFAULT_後_費用額 = 1;
    public static final int DEFAULT_後_保険分請求額 = 1;
    public static final int DEFAULT_後_公費１負担額_明細 = 1;
    public static final int DEFAULT_後_公費２負担額_明細 = 1;
    public static final int DEFAULT_後_公費３負担額_明細 = 1;
    public static final int DEFAULT_後_利用者負担額 = 1;
    public static final int DEFAULT_後_費用額合計 = 1;
    public static final int DEFAULT_後_保険分請求額合計 = 1;
    public static final int DEFAULT_後_利用者負担額合計 = 1;
    public static final int DEFAULT_後_公費１_負担額合計 = 1;
    public static final int DEFAULT_後_公費１_請求額 = 1;
    public static final int DEFAULT_後_公費１_本人負担月額 = 1;
    public static final int DEFAULT_後_公費２_負担額合計 = 1;
    public static final int DEFAULT_後_公費２_請求額 = 1;
    public static final int DEFAULT_後_公費２_本人負担月額 = 1;
    public static final int DEFAULT_後_公費３_負担額合計 = 1;
    public static final int DEFAULT_後_公費３_請求額 = 1;
    public static final int DEFAULT_後_公費３_本人負担月額 = 1;
    public static final int DEFAULT_再審査回数 = 1;
    public static final int DEFAULT_過誤回数 = 1;
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator() {
    }

    public static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity() {
        DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity = new DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setRecodeJunjiNo(DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        entity.setServiceSyuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setHiyoTanka(DEFAULT_費用単価);
        entity.setFutanGendogaku(DEFAULT_負担限度額);
        entity.setNissu(DEFAULT_日数);
        entity.setKohi1Nissu(DEFAULT_公費１日数);
        entity.setKohi2Nissu(DEFAULT_公費２日数);
        entity.setKohi3Nissu(DEFAULT_公費３日数);
        entity.setHiyogaku(DEFAULT_費用額);
        entity.setHokenbunSeikyugaku(DEFAULT_保険分請求額);
        entity.setKohi1Futangaku(DEFAULT_公費１負担額_明細);
        entity.setKohi2Futangaku(DEFAULT_公費２負担額_明細);
        entity.setKohi3Futangaku(DEFAULT_公費３負担額_明細);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setHiyogakuTotal(DEFAULT_費用額合計);
        entity.setHokenbunSeikyugakuTotal(DEFAULT_保険分請求額合計);
        entity.setRiyoshaFutangakuTotal(DEFAULT_利用者負担額合計);
        entity.setKohi1FutangakuTotal(DEFAULT_公費１_負担額合計);
        entity.setKohi1Seikyugaku(DEFAULT_公費１_請求額);
        entity.setKohi1HonninFutanGetsugaku(DEFAULT_公費１_本人負担月額);
        entity.setKohi2FutangakuTotal(DEFAULT_公費２_負担額合計);
        entity.setKohi2Seikyugaku(DEFAULT_公費２_請求額);
        entity.setKohi2HonninFutanGetsugaku(DEFAULT_公費２_本人負担月額);
        entity.setKohi3FutangakuTotal(DEFAULT_公費３_負担額合計);
        entity.setKohi3Seikyugaku(DEFAULT_公費３_請求額);
        entity.setKohi3HonninFutanGetsugaku(DEFAULT_公費３_本人負担月額);
        entity.setAtoHiyoTanka(DEFAULT_後_費用単価);
        entity.setAtoNissu(DEFAULT_後_日数);
        entity.setAtoKohi1Nissu(DEFAULT_後_公費１日数);
        entity.setAtoKohi2Nissu(DEFAULT_後_公費２日数);
        entity.setAtoKohi3Nissu(DEFAULT_後_公費３日数);
        entity.setAtoHiyogaku(DEFAULT_後_費用額);
        entity.setAtoHokenbunSeikyugaku(DEFAULT_後_保険分請求額);
        entity.setAtoKohi1Futangaku(DEFAULT_後_公費１負担額_明細);
        entity.setAtoKohi2Futangaku(DEFAULT_後_公費２負担額_明細);
        entity.setAtoKohi3Futangaku(DEFAULT_後_公費３負担額_明細);
        entity.setAtoRiyoshaFutangaku(DEFAULT_後_利用者負担額);
        entity.setAtoHiyogakuTotal(DEFAULT_後_費用額合計);
        entity.setAtoHokenbunSeikyugakuTotal(DEFAULT_後_保険分請求額合計);
        entity.setAtoRiyoshaFutangakuTotal(DEFAULT_後_利用者負担額合計);
        entity.setAtoKohi1FutangakuTotal(DEFAULT_後_公費１_負担額合計);
        entity.setAtoKohi1Seikyugaku(DEFAULT_後_公費１_請求額);
        entity.setAtoKohi1HonninFutanGetsugaku(DEFAULT_後_公費１_本人負担月額);
        entity.setAtoKohi2FutangakuTotal(DEFAULT_後_公費２_負担額合計);
        entity.setAtoKohi2Seikyugaku(DEFAULT_後_公費２_請求額);
        entity.setAtoKohi2HonninFutanGetsugaku(DEFAULT_後_公費２_本人負担月額);
        entity.setAtoKohi3FutangakuTotal(DEFAULT_後_公費３_負担額合計);
        entity.setAtoKohi3Seikyugaku(DEFAULT_後_公費３_請求額);
        entity.setAtoKohi3HonninFutanGetsugaku(DEFAULT_後_公費３_本人負担月額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
