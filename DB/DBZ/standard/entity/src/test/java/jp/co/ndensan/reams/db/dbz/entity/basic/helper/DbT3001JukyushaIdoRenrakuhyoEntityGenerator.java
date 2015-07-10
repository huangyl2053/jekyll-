/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者異動送付エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3001JukyushaIdoRenrakuhyoEntityGenerator {

    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_異動区分コード = new RString("1");
    public static final RString DEFAULT_受給者異動事由 = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_被保険者氏名カナ = new RString("1");
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_性別コード = new RString("1");
    public static final FlexibleDate DEFAULT_資格取得年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_資格喪失年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_老人保健市町村番号 = new RString("1");
    public static final RString DEFAULT_老人保健受給者番号 = new RString("1");
    public static final RString DEFAULT_公費負担者番号 = new RString("1");
    public static final HokenshaNo DEFAULT_広域連合_政令市保険者番号 = new HokenshaNo(new RString("2"));
    public static final RString DEFAULT_申請種別コード = new RString("1");
    public static final RString DEFAULT_変更申請中区分コード = new RString("1");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_みなし要介護状態区分コード = new RString("1");
    public static final RString DEFAULT_要介護状態区分コード = new RString("1");
    public static final FlexibleDate DEFAULT_認定有効期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_認定有効期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_居宅サービス計画作成区分コード = new RString("1");
    public static final JigyoshaNo DEFAULT_居宅介護支援事業所番号 = new JigyoshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_居宅サービス計画適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_居宅サービス計画適用終了年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_訪問通所サービス支給限度基準額 = 1;
    public static final FlexibleDate DEFAULT_訪問通所サービス上限管理適用期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_訪問通所サービス上限管理適用期間終了年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_短期入所サービス支給限度基準額 = 1;
    public static final FlexibleDate DEFAULT_短期入所サービス上限管理適用期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_短期入所サービス上限管理適用期間終了年月日 = new FlexibleDate("20140402");
    public static final boolean DEFAULT_公費負担上限額減額有フラグ = false;
    public static final FlexibleDate DEFAULT_償還払化開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_償還払化終了年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_給付率引下げ開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_給付率引下げ終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_減免申請中区分コード = new RString("1");
    public static final RString DEFAULT_利用者負担区分コード = new RString("1");
    public static final HokenKyufuRitsu DEFAULT_給付率 = new HokenKyufuRitsu(new Decimal("2"));
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_標準負担区分コード = new RString("1");
    public static final int DEFAULT_負担額 = 1;
    public static final FlexibleDate DEFAULT_負担額適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_負担額適用終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_特定入所者認定申請中区分コード = new RString("1");
    public static final RString DEFAULT_特定入所者介護サービス区分コード = new RString("1");
    public static final boolean DEFAULT_課税層の特例減額措置対象フラグ = false;
    public static final int DEFAULT_食費負担限度額 = 1;
    public static final int DEFAULT_居住費ユニット型個室負担限度額 = 1;
    public static final int DEFAULT_居住費ユニット型準個室負担限度額 = 1;
    public static final int DEFAULT_居住費従来型個室特養等負担限度額 = 1;
    public static final int DEFAULT_居住費従来型個室老健療養等負担限度額 = 1;
    public static final int DEFAULT_居住費多床室負担限度額 = 1;
    public static final FlexibleDate DEFAULT_負担限度額適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_負担限度額適用終了年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_軽減率 = 1;
    public static final FlexibleDate DEFAULT_軽減率適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_軽減率適用終了年月日 = new FlexibleDate("20140402");
    public static final boolean DEFAULT_小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ = false;
    public static final RString DEFAULT_後期高齢者医療保険者番号 = new RString("1");
    public static final RString DEFAULT_後期高齢者医療被保険者番号 = new RString("1");
    public static final RString DEFAULT_国民健康保険保険者番号 = new RString("1");
    public static final RString DEFAULT_国民健康保険被保険者証番号 = new RString("1");
    public static final RString DEFAULT_国民健康保険個人番号 = new RString("1");
    public static final RString DEFAULT_二次予防事業区分コード = new RString("1");
    public static final FlexibleDate DEFAULT_二次予防事業有効期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_二次予防事業有効期間終了年月日 = new FlexibleDate("20140402");
    public static final boolean DEFAULT_訂正連絡票フラグ = false;
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3001JukyushaIdoRenrakuhyoEntityGenerator() {
    }

    public static DbT3001JukyushaIdoRenrakuhyoEntity createDbT3001JukyushaIdoRenrakuhyoEntity() {
        DbT3001JukyushaIdoRenrakuhyoEntity entity = new DbT3001JukyushaIdoRenrakuhyoEntity();
        entity.setIdoYMD(DEFAULT_異動年月日);
        entity.setIdoKubunCode(DEFAULT_異動区分コード);
        entity.setJukyushaIdoJiyu(DEFAULT_受給者異動事由);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setHiHokenshaNameKana(DEFAULT_被保険者氏名カナ);
        entity.setUmareYMD(DEFAULT_生年月日);
        entity.setSeibetsuCode(DEFAULT_性別コード);
        entity.setShikakuShutokuYMD(DEFAULT_資格取得年月日);
        entity.setShikakuSoshitsuYMD(DEFAULT_資格喪失年月日);
        entity.setRojinHokenShichosonNo(DEFAULT_老人保健市町村番号);
        entity.setRojinHokenJukyushaNo(DEFAULT_老人保健受給者番号);
        entity.setKohiFutanshaNo(DEFAULT_公費負担者番号);
        entity.setKoikiRengoHokenshaNo(DEFAULT_広域連合_政令市保険者番号);
        entity.setShinseiShubetsuCode(DEFAULT_申請種別コード);
        entity.setHenkoShinseichuKubunCode(DEFAULT_変更申請中区分コード);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setMinashiYokaigoJotaiKubunCode(DEFAULT_みなし要介護状態区分コード);
        entity.setYokaigoJotaiKubunCode(DEFAULT_要介護状態区分コード);
        entity.setNinteiYukoKikankaishiYMD(DEFAULT_認定有効期間開始年月日);
        entity.setNinteiYukoKikanShuryoYMD(DEFAULT_認定有効期間終了年月日);
        entity.setKyotakuServiceSakuseiKubunCode(DEFAULT_居宅サービス計画作成区分コード);
        entity.setKyotakuKaigoShienJigyoshoNo(DEFAULT_居宅介護支援事業所番号);
        entity.setKyotakuServiceTekiyoKaishiYMD(DEFAULT_居宅サービス計画適用開始年月日);
        entity.setKyotakuServiceTekiyoShuryoYMD(DEFAULT_居宅サービス計画適用終了年月日);
        entity.setHomonTsushoServiceShikyuGendoKijungaku(DEFAULT_訪問通所サービス支給限度基準額);
        entity.setHomonTsushoServiceJogenKanriTekiyoKaishiYMD(DEFAULT_訪問通所サービス上限管理適用期間開始年月日);
        entity.setHomonTsushoServiceJogenKanriTekiyoShuryoYMD(DEFAULT_訪問通所サービス上限管理適用期間終了年月日);
        entity.setTankiNyushoServiceShikyuGendoKijungaku(DEFAULT_短期入所サービス支給限度基準額);
        entity.setTankinyushoServiceJogenKanriTekiyoKaishiYMD(DEFAULT_短期入所サービス上限管理適用期間開始年月日);
        entity.setTankinyushoServiceJogenKanriTekiyoShuryoYMD(DEFAULT_短期入所サービス上限管理適用期間終了年月日);
        entity.setKohiFutanJogenGengakuAriFlag(DEFAULT_公費負担上限額減額有フラグ);
        entity.setShokanbaraikaKaishiYMD(DEFAULT_償還払化開始年月日);
        entity.setShokanbaraikaShuryoYMD(DEFAULT_償還払化終了年月日);
        entity.setKyufuritsuHikisageKaishiYMD(DEFAULT_給付率引下げ開始年月日);
        entity.setKyufuritsuHikisageShuryoYMD(DEFAULT_給付率引下げ終了年月日);
        entity.setGemmenShinseichuKubunCode(DEFAULT_減免申請中区分コード);
        entity.setRiyoshaFutanKubunCode(DEFAULT_利用者負担区分コード);
        entity.setKyufuritsu(DEFAULT_給付率);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setHyojunFutanKubunCode(DEFAULT_標準負担区分コード);
        entity.setFutangaku(DEFAULT_負担額);
        entity.setFutangakuTekiyoKaishiYMD(DEFAULT_負担額適用開始年月日);
        entity.setFutangakuTekiyoShuryoYMD(DEFAULT_負担額適用終了年月日);
        entity.setTokuteiNyushoshaNinteiShinseichuKubunCode(DEFAULT_特定入所者認定申請中区分コード);
        entity.setTokuteiNyushoshaKaigoServiceKubunCode(DEFAULT_特定入所者介護サービス区分コード);
        entity.setKaizeisoTokureiGengakuSochiTaishoFlag(DEFAULT_課税層の特例減額措置対象フラグ);
        entity.setShokuhiFutanGendogaku(DEFAULT_食費負担限度額);
        entity.setKyojuhiUnitGataKoshitsuFutanGendogaku(DEFAULT_居住費ユニット型個室負担限度額);
        entity.setKyojuhiUnitGataJunKoshitsuFutanGendogaku(DEFAULT_居住費ユニット型準個室負担限度額);
        entity.setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(DEFAULT_居住費従来型個室特養等負担限度額);
        entity.setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(DEFAULT_居住費従来型個室老健療養等負担限度額);
        entity.setKyujuhiTashoshitsuFutanGendogaku(DEFAULT_居住費多床室負担限度額);
        entity.setFutanGendogakuTekiyoKaishiYMD(DEFAULT_負担限度額適用開始年月日);
        entity.setFutanGendogakuTekiyoShuryoYMD(DEFAULT_負担限度額適用終了年月日);
        entity.setKeigenritsu(DEFAULT_軽減率);
        entity.setKeigenritsuTekiyoKaishiYMD(DEFAULT_軽減率適用開始年月日);
        entity.setKeigenritsuTekiyoShuryoYMD(DEFAULT_軽減率適用終了年月日);
        entity.setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(DEFAULT_小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ);
        entity.setKokiKoureiIryoHokenshaNo(DEFAULT_後期高齢者医療保険者番号);
        entity.setKokikoureiIryoHiHokenshaNo(DEFAULT_後期高齢者医療被保険者番号);
        entity.setKokuhoHokenshaNo(DEFAULT_国民健康保険保険者番号);
        entity.setKokuhoHiHokenshaNo(DEFAULT_国民健康保険被保険者証番号);
        entity.setKokuhoKojinNo(DEFAULT_国民健康保険個人番号);
        entity.setNijiyoboJigyoKubunCode(DEFAULT_二次予防事業区分コード);
        entity.setNijiyoboJigyoYukoKikanKaishiYMD(DEFAULT_二次予防事業有効期間開始年月日);
        entity.setNijiyoboJigyoYukoKikanShuryoYMD(DEFAULT_二次予防事業有効期間終了年月日);
        entity.setTeiseiRenrakuhyoFlag(DEFAULT_訂正連絡票フラグ);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
