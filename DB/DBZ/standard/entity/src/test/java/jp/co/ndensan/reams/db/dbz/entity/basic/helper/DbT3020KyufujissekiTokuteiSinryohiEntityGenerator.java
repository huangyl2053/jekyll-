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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績特定診療費エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3020KyufujissekiTokuteiSinryohiEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo(new RString("2"));
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo(new RString("2"));
    public static final RString DEFAULT_レコード種別コード = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_通し番号 = new RString("1");
    public static final RString DEFAULT_特定診療情報レコード順次番号 = new RString("1");
    public static final RString DEFAULT_傷病名 = new RString("1");
    public static final int DEFAULT_保険_指導管理料等 = 1;
    public static final int DEFAULT_保険_単純エックス線 = 1;
    public static final int DEFAULT_保険_リハビリテーション = 1;
    public static final int DEFAULT_保険_精神科専門療法 = 1;
    public static final int DEFAULT_保険_合計単位数 = 1;
    public static final int DEFAULT_公費１_指導管理料等 = 1;
    public static final int DEFAULT_公費１_単純エックス線 = 1;
    public static final int DEFAULT_公費１_リハビリテーション = 1;
    public static final int DEFAULT_公費１_精神科専門療法 = 1;
    public static final int DEFAULT_公費１_合計単位数 = 1;
    public static final int DEFAULT_公費２_指導管理料等 = 1;
    public static final int DEFAULT_公費２_単純エックス線 = 1;
    public static final int DEFAULT_公費２_リハビリテーション = 1;
    public static final int DEFAULT_公費２_精神科専門療法 = 1;
    public static final int DEFAULT_公費２_合計単位数 = 1;
    public static final int DEFAULT_公費３_指導管理料等 = 1;
    public static final int DEFAULT_公費３_単純エックス線 = 1;
    public static final int DEFAULT_公費３_リハビリテーション = 1;
    public static final int DEFAULT_公費３_精神科専門療法 = 1;
    public static final int DEFAULT_公費３_合計単位数 = 1;
    public static final RString DEFAULT_摘要１ = new RString("1");
    public static final RString DEFAULT_摘要２ = new RString("1");
    public static final RString DEFAULT_摘要３ = new RString("1");
    public static final RString DEFAULT_摘要４ = new RString("1");
    public static final RString DEFAULT_摘要５ = new RString("1");
    public static final RString DEFAULT_摘要６ = new RString("1");
    public static final RString DEFAULT_摘要７ = new RString("1");
    public static final RString DEFAULT_摘要８ = new RString("1");
    public static final RString DEFAULT_摘要９ = new RString("1");
    public static final RString DEFAULT_摘要１０ = new RString("1");
    public static final RString DEFAULT_摘要１１ = new RString("1");
    public static final RString DEFAULT_摘要１２ = new RString("1");
    public static final RString DEFAULT_摘要１３ = new RString("1");
    public static final RString DEFAULT_摘要１４ = new RString("1");
    public static final RString DEFAULT_摘要１５ = new RString("1");
    public static final RString DEFAULT_摘要１６ = new RString("1");
    public static final RString DEFAULT_摘要１７ = new RString("1");
    public static final RString DEFAULT_摘要１８ = new RString("1");
    public static final RString DEFAULT_摘要１９ = new RString("1");
    public static final RString DEFAULT_摘要２０ = new RString("1");
    public static final int DEFAULT_後_保険_指導管理料等 = 1;
    public static final int DEFAULT_後_保険_単純エックス線 = 1;
    public static final int DEFAULT_後_保険_リハビリテーション = 1;
    public static final int DEFAULT_後_保険_精神科専門療法 = 1;
    public static final int DEFAULT_後_公費１_指導管理料等 = 1;
    public static final int DEFAULT_後_公費１_単純エックス線 = 1;
    public static final int DEFAULT_後_公費１_リハビリテーション = 1;
    public static final int DEFAULT_後_公費１_精神科専門療法 = 1;
    public static final int DEFAULT_後_公費２_指導管理料等 = 1;
    public static final int DEFAULT_後_公費２_単純エックス線 = 1;
    public static final int DEFAULT_後_公費２_リハビリテーション = 1;
    public static final int DEFAULT_後_公費２_精神科専門療法 = 1;
    public static final int DEFAULT_後_公費３_指導管理料等 = 1;
    public static final int DEFAULT_後_公費３_単純エックス線 = 1;
    public static final int DEFAULT_後_公費３_リハビリテーション = 1;
    public static final int DEFAULT_後_公費３_精神科専門療法 = 1;
    public static final int DEFAULT_再審査回数 = 1;
    public static final int DEFAULT_過誤回数 = 1;
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3020KyufujissekiTokuteiSinryohiEntityGenerator() {
    }

    public static DbT3020KyufujissekiTokuteiSinryohiEntity createDbT3020KyufujissekiTokuteiSinryohiEntity() {
        DbT3020KyufujissekiTokuteiSinryohiEntity entity = new DbT3020KyufujissekiTokuteiSinryohiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setRecodeJunjiNo(DEFAULT_特定診療情報レコード順次番号);
        entity.setShobyoName(DEFAULT_傷病名);
        entity.setHokenShidoKanriryo(DEFAULT_保険_指導管理料等);
        entity.setHokenTanjunXsen(DEFAULT_保険_単純エックス線);
        entity.setHokenRehabilitation(DEFAULT_保険_リハビリテーション);
        entity.setHokenSeishinkaSemmonRyoho(DEFAULT_保険_精神科専門療法);
        entity.setHokenTotalTanisu(DEFAULT_保険_合計単位数);
        entity.setKohi1ShidoKanriryo(DEFAULT_公費１_指導管理料等);
        entity.setKohi1TanjunXsen(DEFAULT_公費１_単純エックス線);
        entity.setKohi1Rehabilitation(DEFAULT_公費１_リハビリテーション);
        entity.setKohi1SeishinkaSemmonRyoho(DEFAULT_公費１_精神科専門療法);
        entity.setKohi1TotalTanisu(DEFAULT_公費１_合計単位数);
        entity.setKohi2ShidoKanriryo(DEFAULT_公費２_指導管理料等);
        entity.setKohi2TanjunXsen(DEFAULT_公費２_単純エックス線);
        entity.setKohi2Rehabilitation(DEFAULT_公費２_リハビリテーション);
        entity.setKohi2SeishinkaSemmonRyoho(DEFAULT_公費２_精神科専門療法);
        entity.setKohi2TotalTanisu(DEFAULT_公費２_合計単位数);
        entity.setKohi3ShidoKanriryo(DEFAULT_公費３_指導管理料等);
        entity.setKohi3TanjunXsen(DEFAULT_公費３_単純エックス線);
        entity.setKohi3Rehabilitation(DEFAULT_公費３_リハビリテーション);
        entity.setKohi3SeishinkaSemmonRyoho(DEFAULT_公費３_精神科専門療法);
        entity.setKohi3TotalTanisu(DEFAULT_公費３_合計単位数);
        entity.setTekiyo1(DEFAULT_摘要１);
        entity.setTekiyo2(DEFAULT_摘要２);
        entity.setTekiyo3(DEFAULT_摘要３);
        entity.setTekiyo4(DEFAULT_摘要４);
        entity.setTekiyo5(DEFAULT_摘要５);
        entity.setTekiyo6(DEFAULT_摘要６);
        entity.setTekiyo7(DEFAULT_摘要７);
        entity.setTekiyo8(DEFAULT_摘要８);
        entity.setTekiyo9(DEFAULT_摘要９);
        entity.setTekiyo10(DEFAULT_摘要１０);
        entity.setTekiyo11(DEFAULT_摘要１１);
        entity.setTekiyo12(DEFAULT_摘要１２);
        entity.setTekiyo13(DEFAULT_摘要１３);
        entity.setTekiyo14(DEFAULT_摘要１４);
        entity.setTekiyo15(DEFAULT_摘要１５);
        entity.setTekiyo16(DEFAULT_摘要１６);
        entity.setTekiyo17(DEFAULT_摘要１７);
        entity.setTekiyo18(DEFAULT_摘要１８);
        entity.setTekiyo19(DEFAULT_摘要１９);
        entity.setTekiyo20(DEFAULT_摘要２０);
        entity.setAtoHokenShidoKanriryo(DEFAULT_後_保険_指導管理料等);
        entity.setAtoHokenTanjunXsen(DEFAULT_後_保険_単純エックス線);
        entity.setAtoHokenRehabilitation(DEFAULT_後_保険_リハビリテーション);
        entity.setAtoHokenSeishinkaSemmonRyoho(DEFAULT_後_保険_精神科専門療法);
        entity.setAtoKohi1ShidoKanriryo(DEFAULT_後_公費１_指導管理料等);
        entity.setAtoKohi1TanjunXsen(DEFAULT_後_公費１_単純エックス線);
        entity.setAtoKohi1Rehabilitation(DEFAULT_後_公費１_リハビリテーション);
        entity.setAtoKohi1SeishinkaSemmonRyoho(DEFAULT_後_公費１_精神科専門療法);
        entity.setAtoKohi2ShidoKanriryo(DEFAULT_後_公費２_指導管理料等);
        entity.setAtoKohi2TanjunXsen(DEFAULT_後_公費２_単純エックス線);
        entity.setAtoKohi2Rehabilitation(DEFAULT_後_公費２_リハビリテーション);
        entity.setAtoKohi2SeishinkaSemmonRyoho(DEFAULT_後_公費２_精神科専門療法);
        entity.setAtoKohi3ShidoKanriryo(DEFAULT_後_公費３_指導管理料等);
        entity.setAtoKohi3TanjunXsen(DEFAULT_後_公費３_単純エックス線);
        entity.setAtoKohi3Rehabilitation(DEFAULT_後_公費３_リハビリテーション);
        entity.setAtoKohi3SeishinkaSemmonRyoho(DEFAULT_後_公費３_精神科専門療法);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
