/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
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
 * 給付実績特定入所者介護サービス費用エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator {

    public static final KokanShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final NyuryokuShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo();
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_特定入所者介護サービス費用情報レコード順次番号 = new RString("Data");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode();
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode();
    public static final Decimal DEFAULT_費用単価 = new Decimal(0);
    public static final Decimal DEFAULT_負担限度額 = new Decimal(0);
    public static final Decimal DEFAULT_日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費１日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費２日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費３日数 = new Decimal(0);
    public static final int DEFAULT_費用額 = 1;
    public static final int DEFAULT_保険分請求額 = 1;
    public static final int DEFAULT_公費１負担額（明細） = 1;
    public static final int DEFAULT_公費２負担額（明細） = 1;
    public static final int DEFAULT_公費３負担額（明細） = 1;
    public static final int DEFAULT_利用者負担額 = 1;
    public static final int DEFAULT_費用額合計 = 1;
    public static final int DEFAULT_保険分請求額合計 = 1;
    public static final int DEFAULT_利用者負担額合計 = 1;
    public static final int DEFAULT_公費１・負担額合計 = 1;
    public static final int DEFAULT_公費１・請求額 = 1;
    public static final int DEFAULT_公費１・本人負担月額 = 1;
    public static final int DEFAULT_公費２・負担額合計 = 1;
    public static final int DEFAULT_公費２・請求額 = 1;
    public static final int DEFAULT_公費２・本人負担月額 = 1;
    public static final int DEFAULT_公費３・負担額合計 = 1;
    public static final int DEFAULT_公費３・請求額 = 1;
    public static final int DEFAULT_公費３・本人負担月額 = 1;
    public static final Decimal DEFAULT_後・費用単価 = new Decimal(0);
    public static final Decimal DEFAULT_後・日数 = new Decimal(0);
    public static final Decimal DEFAULT_後・公費１日数 = new Decimal(0);
    public static final Decimal DEFAULT_後・公費２日数 = new Decimal(0);
    public static final Decimal DEFAULT_後・公費３日数 = new Decimal(0);
    public static final int DEFAULT_後・費用額 = 1;
    public static final int DEFAULT_後・保険分請求額 = 1;
    public static final int DEFAULT_後・公費１負担額（明細） = 1;
    public static final int DEFAULT_後・公費２負担額（明細） = 1;
    public static final int DEFAULT_後・公費３負担額（明細） = 1;
    public static final int DEFAULT_後・利用者負担額 = 1;
    public static final int DEFAULT_後・費用額合計 = 1;
    public static final int DEFAULT_後・保険分請求額合計 = 1;
    public static final int DEFAULT_後・利用者負担額合計 = 1;
    public static final int DEFAULT_後・公費１・負担額合計 = 1;
    public static final int DEFAULT_後・公費１・請求額 = 1;
    public static final int DEFAULT_後・公費１・本人負担月額 = 1;
    public static final int DEFAULT_後・公費２・負担額合計 = 1;
    public static final int DEFAULT_後・公費２・請求額 = 1;
    public static final int DEFAULT_後・公費２・本人負担月額 = 1;
    public static final int DEFAULT_後・公費３・負担額合計 = 1;
    public static final int DEFAULT_後・公費３・請求額 = 1;
    public static final int DEFAULT_後・公費３・本人負担月額 = 1;
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

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
        entity.setKohi1Futangaku(DEFAULT_公費１負担額（明細）);
        entity.setKohi2Futangaku(DEFAULT_公費２負担額（明細）);
        entity.setKohi3Futangaku(DEFAULT_公費３負担額（明細）);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setHiyogakuTotal(DEFAULT_費用額合計);
        entity.setHokenbunSeikyugakuTotal(DEFAULT_保険分請求額合計);
        entity.setRiyoshaFutangakuTotal(DEFAULT_利用者負担額合計);
        entity.setKohi1FutangakuTotal(DEFAULT_公費１・負担額合計);
        entity.setKohi1Seikyugaku(DEFAULT_公費１・請求額);
        entity.setKohi1HonninFutanGetsugaku(DEFAULT_公費１・本人負担月額);
        entity.setKohi2FutangakuTotal(DEFAULT_公費２・負担額合計);
        entity.setKohi2Seikyugaku(DEFAULT_公費２・請求額);
        entity.setKohi2HonninFutanGetsugaku(DEFAULT_公費２・本人負担月額);
        entity.setKohi3FutangakuTotal(DEFAULT_公費３・負担額合計);
        entity.setKohi3Seikyugaku(DEFAULT_公費３・請求額);
        entity.setKohi3HonninFutanGetsugaku(DEFAULT_公費３・本人負担月額);
        entity.setAtoHiyoTanka(DEFAULT_後・費用単価);
        entity.setAtoNissu(DEFAULT_後・日数);
        entity.setAtoKohi1Nissu(DEFAULT_後・公費１日数);
        entity.setAtoKohi2Nissu(DEFAULT_後・公費２日数);
        entity.setAtoKohi3Nissu(DEFAULT_後・公費３日数);
        entity.setAtoHiyogaku(DEFAULT_後・費用額);
        entity.setAtoHokenbunSeikyugaku(DEFAULT_後・保険分請求額);
        entity.setAtoKohi1Futangaku(DEFAULT_後・公費１負担額（明細）);
        entity.setAtoKohi2Futangaku(DEFAULT_後・公費２負担額（明細）);
        entity.setAtoKohi3Futangaku(DEFAULT_後・公費３負担額（明細）);
        entity.setAtoRiyoshaFutangaku(DEFAULT_後・利用者負担額);
        entity.setAtoHiyogakuTotal(DEFAULT_後・費用額合計);
        entity.setAtoHokenbunSeikyugakuTotal(DEFAULT_後・保険分請求額合計);
        entity.setAtoRiyoshaFutangakuTotal(DEFAULT_後・利用者負担額合計);
        entity.setAtoKohi1FutangakuTotal(DEFAULT_後・公費１・負担額合計);
        entity.setAtoKohi1Seikyugaku(DEFAULT_後・公費１・請求額);
        entity.setAtoKohi1HonninFutanGetsugaku(DEFAULT_後・公費１・本人負担月額);
        entity.setAtoKohi2FutangakuTotal(DEFAULT_後・公費２・負担額合計);
        entity.setAtoKohi2Seikyugaku(DEFAULT_後・公費２・請求額);
        entity.setAtoKohi2HonninFutanGetsugaku(DEFAULT_後・公費２・本人負担月額);
        entity.setAtoKohi3FutangakuTotal(DEFAULT_後・公費３・負担額合計);
        entity.setAtoKohi3Seikyugaku(DEFAULT_後・公費３・請求額);
        entity.setAtoKohi3HonninFutanGetsugaku(DEFAULT_後・公費３・本人負担月額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
