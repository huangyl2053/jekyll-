/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績基本エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3017KyufujissekiKihonEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo(new RString("2"));
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo(new RString("2"));
    public static final RString DEFAULT_レコード種別コード = new RString("1");
    public static final RString DEFAULT_給付実績情報作成区分コード = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_給付実績区分コード = new RString("1");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_通し番号 = new RString("1");
    public static final RString DEFAULT_公費１_負担者番号 = new RString("1");
    public static final RString DEFAULT_公費１_受給者番号 = new RString("1");
    public static final RString DEFAULT_公費２_負担者番号 = new RString("1");
    public static final RString DEFAULT_公費２_受給者番号 = new RString("1");
    public static final RString DEFAULT_公費３_負担者番号 = new RString("1");
    public static final RString DEFAULT_公費３_受給者番号 = new RString("1");
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_性別コード = new RString("1");
    public static final RString DEFAULT_要介護状態区分コード = new RString("1");
    public static final RString DEFAULT_旧措置入所者特例コード = new RString("1");
    public static final FlexibleDate DEFAULT_認定有効期間_開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_認定有功期間_終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_老人保健市町村番号 = new RString("1");
    public static final RString DEFAULT_老人保健受給者番号 = new RString("1");
    public static final RString DEFAULT_保険者番号_後期 = new RString("1");
    public static final RString DEFAULT_被保険者番号_後期 = new RString("1");
    public static final RString DEFAULT_保険者番号_国保 = new RString("1");
    public static final RString DEFAULT_被保険者証番号_国保 = new RString("1");
    public static final RString DEFAULT_個人番号_国保 = new RString("1");
    public static final RString DEFAULT_居宅サービス計画作成区分コード = new RString("1");
    public static final JigyoshaNo DEFAULT_事業所番号_居宅介護支援事業所等 = new JigyoshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_中止年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_中止理由_入所_院前の状況コード = new RString("1");
    public static final FlexibleDate DEFAULT_入所_院年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_退所_院年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_入所_院実日数 = 1;
    public static final int DEFAULT_外泊日数 = 1;
    public static final RString DEFAULT_退所_院後の状態コード = new RString("1");
    public static final HokenKyufuRitsu DEFAULT_保険給付率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final HokenKyufuRitsu DEFAULT_公費１給付率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final HokenKyufuRitsu DEFAULT_公費２給付率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final HokenKyufuRitsu DEFAULT_公費３給付率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final int DEFAULT_前_保険_サービス単位数 = 1;
    public static final Decimal DEFAULT_前_保険_請求額 = new Decimal(1);
    public static final int DEFAULT_前_保険_利用者負担額 = 1;
    public static final Decimal DEFAULT_前_保険_緊急時施設療養費請求額 = new Decimal(1);
    public static final Decimal DEFAULT_前_保険_特定診療費請求額 = new Decimal(1);
    public static final int DEFAULT_前_保険_特定入所者介護サービス費等請求額 = 1;
    public static final int DEFAULT_前_公費１_サービス単位数 = 1;
    public static final int DEFAULT_前_公費１_請求額 = 1;
    public static final int DEFAULT_前_公費１_本人負担額 = 1;
    public static final int DEFAULT_前_公費１_緊急時施設療養費請求額 = 1;
    public static final int DEFAULT_前_公費１_特定診療費請求額 = 1;
    public static final int DEFAULT_前_公費１_特定入所者介護サービス費等請求額 = 1;
    public static final int DEFAULT_前_公費２_サービス単位数 = 1;
    public static final int DEFAULT_前_公費２_請求額 = 1;
    public static final int DEFAULT_前_公費２_本人負担額 = 1;
    public static final int DEFAULT_前_公費２_緊急時施設療養費請求額 = 1;
    public static final int DEFAULT_前_公費２_特定診療費請求額 = 1;
    public static final int DEFAULT_前_公費２_特定入所者介護サービス費等請求額 = 1;
    public static final int DEFAULT_前_公費３_サービス単位数 = 1;
    public static final int DEFAULT_前_公費３_請求額 = 1;
    public static final int DEFAULT_前_公費３_本人負担額 = 1;
    public static final int DEFAULT_前_公費３_緊急時施設療養費請求額 = 1;
    public static final int DEFAULT_前_公費３_特定診療費請求額 = 1;
    public static final int DEFAULT_前_公費３_特定入所者介護サービス費等請求額 = 1;
    public static final int DEFAULT_後_保険_サービス単位数 = 1;
    public static final Decimal DEFAULT_後_保険_請求額 = new Decimal(1);
    public static final int DEFAULT_後_保険_利用者負担額 = 1;
    public static final Decimal DEFAULT_後_緊急時施設療養費請求額 = new Decimal(1);
    public static final Decimal DEFAULT_後_保険_特定診療費請求額 = new Decimal(1);
    public static final int DEFAULT_後_保険_特定入所者介護サービス費等請求額 = 1;
    public static final int DEFAULT_後_公費１_サービス単位数 = 1;
    public static final int DEFAULT_後_公費１_請求額 = 1;
    public static final int DEFAULT_後_公費１_本人負担額 = 1;
    public static final int DEFAULT_後_公費１_緊急時施設療養費請求額 = 1;
    public static final int DEFAULT_後_公費１_特定診療費請求額 = 1;
    public static final int DEFAULT_後_公費１_特定入所者介護サービス費等請求額 = 1;
    public static final int DEFAULT_後_公費２_サービス単位数 = 1;
    public static final int DEFAULT_後_公費２_請求額 = 1;
    public static final int DEFAULT_後_公費２_利用者負担額 = 1;
    public static final int DEFAULT_後_公費２_緊急時施設療養費請求額 = 1;
    public static final int DEFAULT_後_公費２_特定診療費請求額 = 1;
    public static final int DEFAULT_後_公費２_特定入所者介護サービス費等請求額 = 1;
    public static final int DEFAULT_後_公費３_サービス単位数 = 1;
    public static final int DEFAULT_後_公費３_請求額 = 1;
    public static final int DEFAULT_後_公費３_利用者負担額 = 1;
    public static final int DEFAULT_後_公費３_緊急時施設療養費請求額 = 1;
    public static final int DEFAULT_後_公費３_特定診療費請求額 = 1;
    public static final int DEFAULT_後_公費３_特定入所者介護サービス費等請求額 = 1;
    public static final RString DEFAULT_警告区分コード = new RString("1");
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_独自作成区分 = new RString("1");
    public static final boolean DEFAULT_保険者保有給付実績情報削除済フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3017KyufujissekiKihonEntityGenerator() {
    }

    public static DbT3017KyufujissekiKihonEntity createDbT3017KyufujissekiKihonEntity() {
        DbT3017KyufujissekiKihonEntity entity = new DbT3017KyufujissekiKihonEntity();
        entity.setKokanShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setKyufuSakuseiKubunCode(DEFAULT_給付実績情報作成区分コード);
        entity.setHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setKyufuJissekiKubunCode(DEFAULT_給付実績区分コード);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setKohi1FutanshaNo(DEFAULT_公費１_負担者番号);
        entity.setKohi1JukyushaNo(DEFAULT_公費１_受給者番号);
        entity.setKohi2FutanshaNo(DEFAULT_公費２_負担者番号);
        entity.setKohi2JukyushaNo(DEFAULT_公費２_受給者番号);
        entity.setKohi3FutanshaNo(DEFAULT_公費３_負担者番号);
        entity.setKohi3JukyushaNo(DEFAULT_公費３_受給者番号);
        entity.setUmareYMD(DEFAULT_生年月日);
        entity.setSeibetsuCode(DEFAULT_性別コード);
        entity.setYoKaigoJotaiKubunCode(DEFAULT_要介護状態区分コード);
        entity.setKyuSochiNyushoshaTokureiCode(DEFAULT_旧措置入所者特例コード);
        entity.setNinteiYukoKaishiYMD(DEFAULT_認定有効期間_開始年月日);
        entity.setNinteiYukoShuryoYMD(DEFAULT_認定有功期間_終了年月日);
        entity.setRojinHokenShichosonNo(DEFAULT_老人保健市町村番号);
        entity.setRojinhokenJukyushaNo(DEFAULT_老人保健受給者番号);
        entity.setKokiHokenshaNo(DEFAULT_保険者番号_後期);
        entity.setKokiHiHokenshaNo(DEFAULT_被保険者番号_後期);
        entity.setKokuhoHokenshaNo(DEFAULT_保険者番号_国保);
        entity.setKokuhoHiHokenshashoNo(DEFAULT_被保険者証番号_国保);
        entity.setKokuhoKojinNo(DEFAULT_個人番号_国保);
        entity.setKyotakuServiceSakuseiKubunCode(DEFAULT_居宅サービス計画作成区分コード);
        entity.setKyotakuKaigoShienJigyoshoNo(DEFAULT_事業所番号_居宅介護支援事業所等);
        entity.setKaishiYMD(DEFAULT_開始年月日);
        entity.setChushiYMD(DEFAULT_中止年月日);
        entity.setChushiRiyuNyushomaeJyokyoCode(DEFAULT_中止理由_入所_院前の状況コード);
        entity.setNyushoYMD(DEFAULT_入所_院年月日);
        entity.setTaishoYMD(DEFAULT_退所_院年月日);
        entity.setNyushoJitsunissu(DEFAULT_入所_院実日数);
        entity.setGaihakuNissu(DEFAULT_外泊日数);
        entity.setTaishogoJotaiCode(DEFAULT_退所_院後の状態コード);
        entity.setHokenKyufuritsu(DEFAULT_保険給付率);
        entity.setKohi1Kyufuritsu(DEFAULT_公費１給付率);
        entity.setKohi2Kyufuritsu(DEFAULT_公費２給付率);
        entity.setKohi3Kyufuritsu(DEFAULT_公費３給付率);
        entity.setMaeHokenServiceTanisu(DEFAULT_前_保険_サービス単位数);
        entity.setMaeHokenSeikyugaku(DEFAULT_前_保険_請求額);
        entity.setMaeHokenRiyoshaFutangaku(DEFAULT_前_保険_利用者負担額);
        entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(DEFAULT_前_保険_緊急時施設療養費請求額);
        entity.setMaeHokenTokuteiShinryohiSeikyugaku(DEFAULT_前_保険_特定診療費請求額);
        entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_前_保険_特定入所者介護サービス費等請求額);
        entity.setMaeKohi1ServiceTanisu(DEFAULT_前_公費１_サービス単位数);
        entity.setMaeKohi1Seikyugaku(DEFAULT_前_公費１_請求額);
        entity.setMaeKohi1RiyoshaFutangaku(DEFAULT_前_公費１_本人負担額);
        entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(DEFAULT_前_公費１_緊急時施設療養費請求額);
        entity.setMaeKohi1TokuteiShinryohiSeikyugaku(DEFAULT_前_公費１_特定診療費請求額);
        entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_前_公費１_特定入所者介護サービス費等請求額);
        entity.setMaeKohi2ServiceTanisu(DEFAULT_前_公費２_サービス単位数);
        entity.setMaeKohi2Seikyugaku(DEFAULT_前_公費２_請求額);
        entity.setMaeKohi2RiyoshaFutangaku(DEFAULT_前_公費２_本人負担額);
        entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(DEFAULT_前_公費２_緊急時施設療養費請求額);
        entity.setMaeKohi2TokuteiShinryohiSeikyugaku(DEFAULT_前_公費２_特定診療費請求額);
        entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_前_公費２_特定入所者介護サービス費等請求額);
        entity.setMaeKohi3ServiceTanisu(DEFAULT_前_公費３_サービス単位数);
        entity.setMaeKohi3Seikyugaku(DEFAULT_前_公費３_請求額);
        entity.setMaeKohi3RiyoshaFutangaku(DEFAULT_前_公費３_本人負担額);
        entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(DEFAULT_前_公費３_緊急時施設療養費請求額);
        entity.setMaeKohi3TokuteiShinryohiSeikyugaku(DEFAULT_前_公費３_特定診療費請求額);
        entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_前_公費３_特定入所者介護サービス費等請求額);
        entity.setAtoHokenServiceTanisu(DEFAULT_後_保険_サービス単位数);
        entity.setAtoHokenSeikyugaku(DEFAULT_後_保険_請求額);
        entity.setAtoHokenRiyoshaFutangaku(DEFAULT_後_保険_利用者負担額);
        entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(DEFAULT_後_緊急時施設療養費請求額);
        entity.setAtoHokenTokuteiShinryohiSeikyugaku(DEFAULT_後_保険_特定診療費請求額);
        entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_後_保険_特定入所者介護サービス費等請求額);
        entity.setAtoKohi1ServiceTanisu(DEFAULT_後_公費１_サービス単位数);
        entity.setAtoKohi1Seikyugaku(DEFAULT_後_公費１_請求額);
        entity.setAtoKohi1RiyoshaFutangaku(DEFAULT_後_公費１_本人負担額);
        entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(DEFAULT_後_公費１_緊急時施設療養費請求額);
        entity.setAtoKohi1TokuteiShinryohiSeikyugaku(DEFAULT_後_公費１_特定診療費請求額);
        entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_後_公費１_特定入所者介護サービス費等請求額);
        entity.setAtoKohi2ServiceTanisu(DEFAULT_後_公費２_サービス単位数);
        entity.setAtoKohi2Seikyugaku(DEFAULT_後_公費２_請求額);
        entity.setAtoKohi2RiyoshaFutangaku(DEFAULT_後_公費２_利用者負担額);
        entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(DEFAULT_後_公費２_緊急時施設療養費請求額);
        entity.setAtoKohi2TokuteiShinryohiSeikyugaku(DEFAULT_後_公費２_特定診療費請求額);
        entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_後_公費２_特定入所者介護サービス費等請求額);
        entity.setAtoKohi3ServiceTanisu(DEFAULT_後_公費３_サービス単位数);
        entity.setAtoKohi3Seikyugaku(DEFAULT_後_公費３_請求額);
        entity.setAtoKohi3RiyoshaFutangaku(DEFAULT_後_公費３_利用者負担額);
        entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(DEFAULT_後_公費３_緊急時施設療養費請求額);
        entity.setAtoKohi3TokuteiShinryohiSeikyugaku(DEFAULT_後_公費３_特定診療費請求額);
        entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(DEFAULT_後_公費３_特定入所者介護サービス費等請求額);
        entity.setKeikaiKubunCode(DEFAULT_警告区分コード);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setSofuYM(DEFAULT_送付年月);
        entity.setTorikomiYM(DEFAULT_取込年月);
        entity.setDokujiSakuseiKubun(DEFAULT_独自作成区分);
        entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(DEFAULT_保険者保有給付実績情報削除済フラグ);
        return entity;
    }
}
