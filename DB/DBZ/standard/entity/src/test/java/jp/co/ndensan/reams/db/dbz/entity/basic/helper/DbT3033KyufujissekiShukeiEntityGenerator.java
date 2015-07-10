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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績集計エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3033KyufujissekiShukeiEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo(new RString("2"));
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo(new RString("2"));
    public static final RString DEFAULT_レコード種別コード = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_通し番号 = new RString("1");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final int DEFAULT_サービス実日数 = 1;
    public static final int DEFAULT_計画単位数 = 1;
    public static final int DEFAULT_限度額管理対象単位数 = 1;
    public static final int DEFAULT_限度額管理対象外単位数 = 1;
    public static final int DEFAULT_短期入所計画日数 = 1;
    public static final int DEFAULT_短期入所実日数 = 1;
    public static final int DEFAULT_保険_単位数合計 = 1;
    public static final Decimal DEFAULT_保険_単位数単価 = new Decimal(1);
    public static final RString DEFAULT_保険_請求額 = new RString("1");
    public static final int DEFAULT_保険_利用者負担額 = 1;
    public static final int DEFAULT_公費１_単位数合計 = 1;
    public static final RString DEFAULT_公費１_請求額 = new RString("1");
    public static final int DEFAULT_公費１_本人負担額 = 1;
    public static final int DEFAULT_公費２_単位数合計 = 1;
    public static final RString DEFAULT_公費２_請求額 = new RString("1");
    public static final int DEFAULT_公費２_本人負担額 = 1;
    public static final int DEFAULT_公費３_単位数合計 = 1;
    public static final RString DEFAULT_公費３_請求額 = new RString("1");
    public static final int DEFAULT_公費３_本人負担額 = 1;
    public static final int DEFAULT_保険_出来高単位数合計 = 1;
    public static final RString DEFAULT_保険_出来高請求額 = new RString("1");
    public static final int DEFAULT_保険_出来高医療費利用者負担額 = 1;
    public static final int DEFAULT_公費１_出来高単位数合計 = 1;
    public static final RString DEFAULT_公費１_出来高請求額 = new RString("1");
    public static final int DEFAULT_公費１_出来高医療費利用者負担額 = 1;
    public static final int DEFAULT_公費２_出来高単位数合計 = 1;
    public static final RString DEFAULT_公費２_出来高請求額 = new RString("1");
    public static final int DEFAULT_公費２_出来高医療費本人負担額 = 1;
    public static final int DEFAULT_公費３_出来高単位数合計 = 1;
    public static final RString DEFAULT_公費３_出来高請求額 = new RString("1");
    public static final int DEFAULT_公費３_出来高医療費本人負担額 = 1;
    public static final int DEFAULT_後_短期入所実日数 = 1;
    public static final int DEFAULT_後_単位数合計 = 1;
    public static final RString DEFAULT_後_保険請求分請求額 = new RString("1");
    public static final int DEFAULT_後_公費１_単位数合計 = 1;
    public static final RString DEFAULT_後_公費１_請求額 = new RString("1");
    public static final int DEFAULT_後_公費２_単位数合計 = 1;
    public static final RString DEFAULT_後_公費２_請求額 = new RString("1");
    public static final int DEFAULT_後_公費３_単位数合計 = 1;
    public static final RString DEFAULT_後_公費３_請求額 = new RString("1");
    public static final int DEFAULT_後_保険_出来高単位数合計 = 1;
    public static final RString DEFAULT_後_保険_出来高請求額 = new RString("1");
    public static final int DEFAULT_後_公費１_出来高単位数合計 = 1;
    public static final RString DEFAULT_後_公費１_出来高請求額 = new RString("1");
    public static final int DEFAULT_後_公費２_出来高単位数合計 = 1;
    public static final RString DEFAULT_後_公費２_出来高請求額 = new RString("1");
    public static final int DEFAULT_後_公費３_出来高単位数合計 = 1;
    public static final RString DEFAULT_後_公費３_出来高請求額 = new RString("1");
    public static final int DEFAULT_再審査回数 = 1;
    public static final int DEFAULT_過誤回数 = 1;
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3033KyufujissekiShukeiEntityGenerator() {
    }

    public static DbT3033KyufujissekiShukeiEntity createDbT3033KyufujissekiShukeiEntity() {
        DbT3033KyufujissekiShukeiEntity entity = new DbT3033KyufujissekiShukeiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setServiceSyuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceJitsunissu(DEFAULT_サービス実日数);
        entity.setPlanTanisu(DEFAULT_計画単位数);
        entity.setGendogakuKanriTaishoTanisu(DEFAULT_限度額管理対象単位数);
        entity.setGendogakuKanritaishogaiTanisu(DEFAULT_限度額管理対象外単位数);
        entity.setTankiNyushoPlanNissu(DEFAULT_短期入所計画日数);
        entity.setTankiNyushoJitsunissu(DEFAULT_短期入所実日数);
        entity.setHokenTanisuTotal(DEFAULT_保険_単位数合計);
        entity.setHokenTanisuTani(DEFAULT_保険_単位数単価);
        entity.setHokenSeikyugaku(DEFAULT_保険_請求額);
        entity.setHokenRiyoshaFutangaku(DEFAULT_保険_利用者負担額);
        entity.setKohi1TanisuTotal(DEFAULT_公費１_単位数合計);
        entity.setKohi1Seikyugaku(DEFAULT_公費１_請求額);
        entity.setKohi1HonninFutangaku(DEFAULT_公費１_本人負担額);
        entity.setKohi2TanisuTotal(DEFAULT_公費２_単位数合計);
        entity.setKohi2Seikyugaku(DEFAULT_公費２_請求額);
        entity.setKohi2HonninFutangaku(DEFAULT_公費２_本人負担額);
        entity.setKohi3TanisuTotal(DEFAULT_公費３_単位数合計);
        entity.setKohi3Seikyugaku(DEFAULT_公費３_請求額);
        entity.setKohi3HonninFutangaku(DEFAULT_公費３_本人負担額);
        entity.setHokenDekidakaTanisuTotal(DEFAULT_保険_出来高単位数合計);
        entity.setHokenDekidakaSeikyugaku(DEFAULT_保険_出来高請求額);
        entity.setHokenDekidakaIryohiRiyoshaFutangaku(DEFAULT_保険_出来高医療費利用者負担額);
        entity.setKohi1DekidakaTanisuTotal(DEFAULT_公費１_出来高単位数合計);
        entity.setKohi1DekidakaSeikyugaku(DEFAULT_公費１_出来高請求額);
        entity.setKohi1DekidakaIryohiRiyoshaFutangaku(DEFAULT_公費１_出来高医療費利用者負担額);
        entity.setKohi2DekidakaTanisuTotal(DEFAULT_公費２_出来高単位数合計);
        entity.setKohi2DekidakaSeikyugaku(DEFAULT_公費２_出来高請求額);
        entity.setKohi2DekidakaIryohiRiyoshaFutangaku(DEFAULT_公費２_出来高医療費本人負担額);
        entity.setKohi3DekidakaTanisuTotal(DEFAULT_公費３_出来高単位数合計);
        entity.setKohi3DekidakaSeikyugaku(DEFAULT_公費３_出来高請求額);
        entity.setKohi3DekidakaIryohiRiyoshaFutangaku(DEFAULT_公費３_出来高医療費本人負担額);
        entity.setAtoTankiNyushoJitsunissu(DEFAULT_後_短期入所実日数);
        entity.setAtoHokenTanisuTotal(DEFAULT_後_単位数合計);
        entity.setAtoHokenSeikyugaku(DEFAULT_後_保険請求分請求額);
        entity.setAtoKohi1TanisuTotal(DEFAULT_後_公費１_単位数合計);
        entity.setAtoKohi1Seikyugaku(DEFAULT_後_公費１_請求額);
        entity.setAtoKohi2TanisuTotal(DEFAULT_後_公費２_単位数合計);
        entity.setAtoKohi2Seikyugaku(DEFAULT_後_公費２_請求額);
        entity.setAtoKohi3TanisuTotal(DEFAULT_後_公費３_単位数合計);
        entity.setAtoKohi3Seikyugaku(DEFAULT_後_公費３_請求額);
        entity.setAtoHokenDekidakaTanisuTotal(DEFAULT_後_保険_出来高単位数合計);
        entity.setAtoHokenDekidakaSeikyugaku(DEFAULT_後_保険_出来高請求額);
        entity.setAtoKohi1DekidakaTanisuTotal(DEFAULT_後_公費１_出来高単位数合計);
        entity.setAtoKohi1DekidakaSeikyugaku(DEFAULT_後_公費１_出来高請求額);
        entity.setAtoKohi2DekidakaTanisuTotal(DEFAULT_後_公費２_出来高単位数合計);
        entity.setAtoKohi2DekidakaSeikyugaku(DEFAULT_後_公費２_出来高請求額);
        entity.setAtoKohi3DekidakaTanisuTotal(DEFAULT_後_公費３_出来高単位数合計);
        entity.setAtoKohi3DekidakaSeikyugaku(DEFAULT_後_公費３_出来高請求額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
