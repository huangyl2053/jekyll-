/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3020KyufujissekiTokuteiSinryohiEntity;
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
 * 給付実績特定診療費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3020KyufujissekiTokuteiSinryohiEntityGenerator {

    public static final KokanShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final NyuryokuShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo();
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_特定診療情報レコード順次番号 = new RString("Data");
    public static final RString DEFAULT_傷病名 = new RString("Data");
    public static final int DEFAULT_保険・指導管理料等 = 1;
    public static final int DEFAULT_保険・単純エックス線 = 1;
    public static final int DEFAULT_保険・リハビリテーション = 1;
    public static final int DEFAULT_保険・精神科専門療法 = 1;
    public static final int DEFAULT_保険・合計単位数 = 1;
    public static final int DEFAULT_公費１・指導管理料等 = 1;
    public static final int DEFAULT_公費１・単純エックス線 = 1;
    public static final int DEFAULT_公費１・リハビリテーション = 1;
    public static final int DEFAULT_公費１・精神科専門療法 = 1;
    public static final int DEFAULT_公費１・合計単位数 = 1;
    public static final int DEFAULT_公費２・指導管理料等 = 1;
    public static final int DEFAULT_公費２・単純エックス線 = 1;
    public static final int DEFAULT_公費２・リハビリテーション = 1;
    public static final int DEFAULT_公費２・精神科専門療法 = 1;
    public static final int DEFAULT_公費２・合計単位数 = 1;
    public static final int DEFAULT_公費３・指導管理料等 = 1;
    public static final int DEFAULT_公費３・単純エックス線 = 1;
    public static final int DEFAULT_公費３・リハビリテーション = 1;
    public static final int DEFAULT_公費３・精神科専門療法 = 1;
    public static final int DEFAULT_公費３・合計単位数 = 1;
    public static final RString DEFAULT_摘要１ = new RString("Data");
    public static final RString DEFAULT_摘要２ = new RString("Data");
    public static final RString DEFAULT_摘要３ = new RString("Data");
    public static final RString DEFAULT_摘要４ = new RString("Data");
    public static final RString DEFAULT_摘要５ = new RString("Data");
    public static final RString DEFAULT_摘要６ = new RString("Data");
    public static final RString DEFAULT_摘要７ = new RString("Data");
    public static final RString DEFAULT_摘要８ = new RString("Data");
    public static final RString DEFAULT_摘要９ = new RString("Data");
    public static final RString DEFAULT_摘要１０ = new RString("Data");
    public static final RString DEFAULT_摘要１１ = new RString("Data");
    public static final RString DEFAULT_摘要１２ = new RString("Data");
    public static final RString DEFAULT_摘要１３ = new RString("Data");
    public static final RString DEFAULT_摘要１４ = new RString("Data");
    public static final RString DEFAULT_摘要１５ = new RString("Data");
    public static final RString DEFAULT_摘要１６ = new RString("Data");
    public static final RString DEFAULT_摘要１７ = new RString("Data");
    public static final RString DEFAULT_摘要１８ = new RString("Data");
    public static final RString DEFAULT_摘要１９ = new RString("Data");
    public static final RString DEFAULT_摘要２０ = new RString("Data");
    public static final int DEFAULT_後・保険・指導管理料等 = 1;
    public static final int DEFAULT_後・保険・単純エックス線 = 1;
    public static final int DEFAULT_後・保険・リハビリテーション = 1;
    public static final int DEFAULT_後・保険・精神科専門療法 = 1;
    public static final int DEFAULT_後・公費１・指導管理料等 = 1;
    public static final int DEFAULT_後・公費１・単純エックス線 = 1;
    public static final int DEFAULT_後・公費１・リハビリテーション = 1;
    public static final int DEFAULT_後・公費１・精神科専門療法 = 1;
    public static final int DEFAULT_後・公費２・指導管理料等 = 1;
    public static final int DEFAULT_後・公費２・単純エックス線 = 1;
    public static final int DEFAULT_後・公費２・リハビリテーション = 1;
    public static final int DEFAULT_後・公費２・精神科専門療法 = 1;
    public static final int DEFAULT_後・公費３・指導管理料等 = 1;
    public static final int DEFAULT_後・公費３・単純エックス線 = 1;
    public static final int DEFAULT_後・公費３・リハビリテーション = 1;
    public static final int DEFAULT_後・公費３・精神科専門療法 = 1;
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

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
        entity.setHokenShidoKanriryo(DEFAULT_保険・指導管理料等);
        entity.setHokenTanjunXsen(DEFAULT_保険・単純エックス線);
        entity.setHokenRehabilitation(DEFAULT_保険・リハビリテーション);
        entity.setHokenSeishinkaSemmonRyoho(DEFAULT_保険・精神科専門療法);
        entity.setHokenTotalTanisu(DEFAULT_保険・合計単位数);
        entity.setKohi1ShidoKanriryo(DEFAULT_公費１・指導管理料等);
        entity.setKohi1TanjunXsen(DEFAULT_公費１・単純エックス線);
        entity.setKohi1Rehabilitation(DEFAULT_公費１・リハビリテーション);
        entity.setKohi1SeishinkaSemmonRyoho(DEFAULT_公費１・精神科専門療法);
        entity.setKohi1TotalTanisu(DEFAULT_公費１・合計単位数);
        entity.setKohi2ShidoKanriryo(DEFAULT_公費２・指導管理料等);
        entity.setKohi2TanjunXsen(DEFAULT_公費２・単純エックス線);
        entity.setKohi2Rehabilitation(DEFAULT_公費２・リハビリテーション);
        entity.setKohi2SeishinkaSemmonRyoho(DEFAULT_公費２・精神科専門療法);
        entity.setKohi2TotalTanisu(DEFAULT_公費２・合計単位数);
        entity.setKohi3ShidoKanriryo(DEFAULT_公費３・指導管理料等);
        entity.setKohi3TanjunXsen(DEFAULT_公費３・単純エックス線);
        entity.setKohi3Rehabilitation(DEFAULT_公費３・リハビリテーション);
        entity.setKohi3SeishinkaSemmonRyoho(DEFAULT_公費３・精神科専門療法);
        entity.setKohi3TotalTanisu(DEFAULT_公費３・合計単位数);
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
        entity.setAtoHokenShidoKanriryo(DEFAULT_後・保険・指導管理料等);
        entity.setAtoHokenTanjunXsen(DEFAULT_後・保険・単純エックス線);
        entity.setAtoHokenRehabilitation(DEFAULT_後・保険・リハビリテーション);
        entity.setAtoHokenSeishinkaSemmonRyoho(DEFAULT_後・保険・精神科専門療法);
        entity.setAtoKohi1ShidoKanriryo(DEFAULT_後・公費１・指導管理料等);
        entity.setAtoKohi1TanjunXsen(DEFAULT_後・公費１・単純エックス線);
        entity.setAtoKohi1Rehabilitation(DEFAULT_後・公費１・リハビリテーション);
        entity.setAtoKohi1SeishinkaSemmonRyoho(DEFAULT_後・公費１・精神科専門療法);
        entity.setAtoKohi2ShidoKanriryo(DEFAULT_後・公費２・指導管理料等);
        entity.setAtoKohi2TanjunXsen(DEFAULT_後・公費２・単純エックス線);
        entity.setAtoKohi2Rehabilitation(DEFAULT_後・公費２・リハビリテーション);
        entity.setAtoKohi2SeishinkaSemmonRyoho(DEFAULT_後・公費２・精神科専門療法);
        entity.setAtoKohi3ShidoKanriryo(DEFAULT_後・公費３・指導管理料等);
        entity.setAtoKohi3TanjunXsen(DEFAULT_後・公費３・単純エックス線);
        entity.setAtoKohi3Rehabilitation(DEFAULT_後・公費３・リハビリテーション);
        entity.setAtoKohi3SeishinkaSemmonRyoho(DEFAULT_後・公費３・精神科専門療法);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
