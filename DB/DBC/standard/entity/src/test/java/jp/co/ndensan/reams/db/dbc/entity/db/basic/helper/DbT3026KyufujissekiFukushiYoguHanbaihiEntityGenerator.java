/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
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
 * 給付実績福祉用具販売費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator {

    public static final KokanShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final NyuryokuShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo();
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_明細番号 = new RString("Data");
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode();
    public static final FlexibleDate DEFAULT_福祉用具販売年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_福祉用具商品名 = new RString("Data");
    public static final RString DEFAULT_福祉用具種目コード = new RString("Data");
    public static final RString DEFAULT_福祉用具製造事業者名 = new RString("Data");
    public static final RString DEFAULT_福祉用具販売事業者名 = new RString("Data");
    public static final int DEFAULT_販売金額 = 1;
    public static final RString DEFAULT_摘要（品目コード） = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator() {
    }

    public static DbT3026KyufujissekiFukushiYoguHanbaihiEntity createDbT3026KyufujissekiFukushiYoguHanbaihiEntity() {
        DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity = new DbT3026KyufujissekiFukushiYoguHanbaihiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setMeisaiNo(DEFAULT_明細番号);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setFukushiyoguHanbaiYMD(DEFAULT_福祉用具販売年月日);
        entity.setFukushiyoguShohinName(DEFAULT_福祉用具商品名);
        entity.setFukushiyoguSyumokuCode(DEFAULT_福祉用具種目コード);
        entity.setFukushiyoguSeizoJigyoshaName(DEFAULT_福祉用具製造事業者名);
        entity.setFukushiyoguHanbaiJigyoshaName(DEFAULT_福祉用具販売事業者名);
        entity.setHanbaiKingaku(DEFAULT_販売金額);
        entity.setTekiyo(DEFAULT_摘要（品目コード）);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
