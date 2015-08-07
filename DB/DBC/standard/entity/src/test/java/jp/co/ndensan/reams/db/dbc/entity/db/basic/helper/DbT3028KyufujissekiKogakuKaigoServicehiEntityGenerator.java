/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
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
 * 給付実績高額介護サービス費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator {

    public static final KokanShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final NyuryokuShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_給付実績情報作成区分コード = new RString("Data");
    public static final RString DEFAULT_給付実績区分コード = new RString("Data");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_公費１負担番号 = new RString("Data");
    public static final RString DEFAULT_公費２負担番号 = new RString("Data");
    public static final RString DEFAULT_公費３負担番号 = new RString("Data");
    public static final int DEFAULT_利用者負担額 = 1;
    public static final int DEFAULT_公費１負担額 = 1;
    public static final int DEFAULT_公費２負担額 = 1;
    public static final int DEFAULT_公費３負担額 = 1;
    public static final int DEFAULT_支給額 = 1;
    public static final int DEFAULT_公費１支給額 = 1;
    public static final int DEFAULT_公費２支給額 = 1;
    public static final int DEFAULT_公費３支給額 = 1;
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYear("1990");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_作成区分 = new RString("Data");
    public static final RString DEFAULT_管理番号 = new RString("Data");
    public static final boolean DEFAULT_保険者保有給付実績情報削除済フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator() {
    }

    public static DbT3028KyufujissekiKogakuKaigoServicehiEntity createDbT3028KyufujissekiKogakuKaigoServicehiEntity() {
        DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = new DbT3028KyufujissekiKogakuKaigoServicehiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setKyufuSakuseiKubunCode(DEFAULT_給付実績情報作成区分コード);
        entity.setKyufuJissekiKubunCode(DEFAULT_給付実績区分コード);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setKohi1FutanNo(DEFAULT_公費１負担番号);
        entity.setKohi2FutanNo(DEFAULT_公費２負担番号);
        entity.setKohi3FutanNo(DEFAULT_公費３負担番号);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setKohi1Futangaku(DEFAULT_公費１負担額);
        entity.setKohi2Futangaku(DEFAULT_公費２負担額);
        entity.setKohi3Futangaku(DEFAULT_公費３負担額);
        entity.setShikyugaku(DEFAULT_支給額);
        entity.setKohi1Shikyugaku(DEFAULT_公費１支給額);
        entity.setKohi2Shikyugaku(DEFAULT_公費２支給額);
        entity.setKohi3Shikyugaku(DEFAULT_公費３支給額);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setSofuYM(DEFAULT_送付年月);
        entity.setTorikomiYM(DEFAULT_取込年月);
        entity.setSakuseiKubun(DEFAULT_作成区分);
        entity.setKanriNo(DEFAULT_管理番号);
        entity.setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(DEFAULT_保険者保有給付実績情報削除済フラグ);
        return entity;
    }
}
