/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3038ShokanKihonEntity;
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
 * 償還払請求基本エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3038ShokanKihonEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo();
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_旧措置入所者特例コード = new RString("Data");
    public static final RString DEFAULT_居宅サービス計画作成区分コード = new RString("Data");
    public static final JigyoshaNo DEFAULT_居宅サービス計画事業者番号 = new JigyoshaNo();
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_中止年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_中止理由・入所（院）前の状況コード = new RString("Data");
    public static final FlexibleDate DEFAULT_入所（院）年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_退所（院）年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_入所（院）実日数 = new Decimal(0);
    public static final Decimal DEFAULT_外泊日数 = new Decimal(0);
    public static final RString DEFAULT_退所（院）後の状態コード = new RString("Data");
    public static final HokenKyufuRitsu DEFAULT_保険給付率 = new HokenKyufuRitsu();
    public static final int DEFAULT_サービス単位数 = 1;
    public static final Decimal DEFAULT_保険請求額 = new Decimal(0);
    public static final int DEFAULT_利用者負担額 = 1;
    public static final Decimal DEFAULT_緊急時施設療養費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_特定診療費請求額 = new Decimal(0);
    public static final int DEFAULT_特定入所者介護サービス費等請求額 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3038ShokanKihonEntityGenerator() {
    }

    public static DbT3038ShokanKihonEntity createDbT3038ShokanKihonEntity() {
        DbT3038ShokanKihonEntity entity = new DbT3038ShokanKihonEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNp(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKyuSochiNyushoshaTokureiCode(DEFAULT_旧措置入所者特例コード);
        entity.setKyotakuServiceSakuseiKubunCode(DEFAULT_居宅サービス計画作成区分コード);
        entity.setKyotakuserviceJigyoshaNo(DEFAULT_居宅サービス計画事業者番号);
        entity.setKaishiYMD(DEFAULT_開始年月日);
        entity.setChushiYMD(DEFAULT_中止年月日);
        entity.setChushiRiyuNyushomaeJyokyoCode(DEFAULT_中止理由・入所（院）前の状況コード);
        entity.setNyushoYMD(DEFAULT_入所（院）年月日);
        entity.setTaishoYMD(DEFAULT_退所（院）年月日);
        entity.setNyushoJitsuNissu(DEFAULT_入所（院）実日数);
        entity.setGaihakuNissu(DEFAULT_外泊日数);
        entity.setTaishogoJotaiCode(DEFAULT_退所（院）後の状態コード);
        entity.setHokenKyufuritsu(DEFAULT_保険給付率);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setHokenSeikyugaku(DEFAULT_保険請求額);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setKinkyuShisetsuRyoyoSeikyugaku(DEFAULT_緊急時施設療養費請求額);
        entity.setTokuteiShinryoSeikyugaku(DEFAULT_特定診療費請求額);
        entity.setTokuteiNyushoshaKaigoServiceSeikyugaku(DEFAULT_特定入所者介護サービス費等請求額);
        return entity;
    }
}
