/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code;

import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * コード種別を表す列挙型です。
 *
 * @author N3317 塚田 萌
 * @jpName
 * @bizDomain 介護
 * @category コードマスタ
 * @subCategory コード種別
 * @mainClass ○
 * @reference
 */
public enum DBXCodeShubetsu {

    /**
     * 介護交付証種類します。
     */
    介護交付証種類("0014", KaigoKofushoShurui.class),
    /**
     * 指定／基準該当等事業所区分します。
     */
    指定_基準該当等事業所区分("0026", ShiteiKijunGaitoJigyoshoKubun.class),
    /**
     * 医師の配置基準します。
     */
    医師の配置基準("0029", IshiHaichiKijun.class),
    /**
     * 食事提供の状況します。
     */
    食事提供の状況("0031", ShokujiTeikyoJokyo.class),
    /**
     * 送迎体制します。
     */
    送迎体制("0032", SogeiTaisei.class),
    /**
     * 地域区分コードします。
     */
    地域区分コード("0034", ChiikiKubun.class),
    /**
     * 時間延長サービス体制します。
     */
    時間延長サービス体制("0035", JikanEnchoServiceTaisei.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制("0036", KobetsuRehabilitationTeikyoTaisei.class),
    /**
     * 居住費対策します。
     */
    居住費対策("0037", KyojuhiTaiseku.class),
    /**
     * 栄養管理の評価します。
     */
    栄養管理の評価("0038", EiyoKanriHyoka.class),
    /**
     * 指定更新申請中区分します。
     */
    指定更新申請中区分("0039", ShiteiKoshinShinseichuKubun.class),
    /**
     * 設備基準します。
     */
    設備基準("0040", SetsubiKijun.class),
    /**
     * 介護サービス分類コードします。
     */
    介護サービス分類コード("0041", KaigoServiceBunruiCode.class),
    /**
     * 単位数識別します。
     */
    単位数識別("0042", TanisuShikibetsu.class),
    /**
     * 単位数算定単位します。
     */
    単位数算定単位("0043", TanisuSanteiTani.class),
    /**
     * 介護サービス異動事由します。
     */
    介護サービス異動事由("0044", KaigoServiceIdoJiyu.class),
    /**
     * 介護資格取得事由します。
     */
    介護資格取得事由("0117", KaigoShikakuShutokuJiyu.class),
    /**
     * 介護他特適用事由します。
     */
    介護他特適用事由("0118", KaigoTatokuTekiyoJiyu.class),
    /**
     * 介護除外適用事由します。
     */
    介護除外適用事由("0119", KaigoJogaiTekiyoJiyu.class),
    /**
     * 介護資格喪失事由します。
     */
    介護資格喪失事由("0121", KaigoShikakuSoshitsuJiyu.class),
    /**
     * 介護他特解除事由します。
     */
    介護他特解除事由("0122", KaigoTatokuKaijoJiyu.class),
    /**
     * 介護除外解除事由します。
     */
    介護除外解除事由("0123", KaigoJogaiKaijoJiyu.class),
    /**
     * 介護資格変更事由します。
     */
    介護資格変更事由("0126", KaigoShikakuHenkoJiyu.class),
    /**
     * 介護資格住特適用事由します。
     */
    介護資格住特適用事由("0127", KaigoShikakuJutokuTekiyoJiyu.class),
    /**
     * 介護資格住特解除事由します。
     */
    介護資格住特解除事由("0128", KaigoShikakuJutokuKaijoJiyu.class),
    /**
     * 特別地域加算の有無します。
     */
    特別地域加算の有無("0141", TokubetsuChiikiKasanUmu.class),
    /**
     * 緊急時訪問看護加算の有無します。
     */
    緊急時訪問看護加算の有無("0142", KinkyujiHomonKaigoKasanUmu.class),
    /**
     * 特別管理体制します。
     */
    特別管理体制("0143", TokubetsuKanriTaisei.class),
    /**
     * 機能訓練指導体制の有無します。
     */
    機能訓練指導体制の有無("0144", KinokunrenShidoTaiseiUmu.class),
    /**
     * 食事提供体制の有無します。
     */
    食事提供体制の有無("0145", ShokujiTeikyoTaiseiUmu.class),
    /**
     * 入浴介助体制の有無します。
     */
    入浴介助体制の有無("0146", NyuyokuKaijoTaiseiUmu.class),
    /**
     * 特別入浴介助体制の有無します。
     */
    特別入浴介助体制の有無("0147", TokubetsuNyuyokuKaijoTaiseiUmu.class),
    /**
     * 常勤専従医師配置の有無します。
     */
    常勤専従医師配置の有無("0148", JokinSenjuIshiHaichiUmu.class),
    /**
     * 精神科医師定期的療養指導の有無します。
     */
    精神科医師定期的療養指導の有無("0149", SeishinkaIshiTeikitekiRyoyoshidoUmu.class),
    /**
     * 認知症専門棟の有無します。
     */
    認知症専門棟の有無("0150", NinchishoSemmontoUmu.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無("0151", RehabilitationTeikyoTaiseiUmuSogoRehabilitationShisetsu.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無("0152", RehabilitationTeikyoTaiseiUmuRigakuRyoho2.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無("0153", RehabilitationTeikyoTaiseiUmuRigakuRyoho3.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無("0154", RehabilitationTeikyoTaiseiUmuSagyoRyoho2.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_精神科作業療法_の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_精神科作業療法_の有無("0155", RehabilitationTeikyoTaiseiUmuSeishinkaSagyoRyoho.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無("0156", RehabilitationTeikyoTaiseiUmuSonota.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ加算状況の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ加算状況の有無("0157", RehabilitationKasanJokyoUmu.class),
    /**
     * 医師の欠員による減算の状況の有無します。
     */
    医師の欠員による減算の状況の有無("0158", GenzanJokyoUmuByIshiKetsuin.class),
    /**
     * 看護職員の欠員による減算の状況の有無します。
     */
    看護職員の欠員による減算の状況の有無("0159", GenzanJokyoUmuByKangoStaffKetsuin.class),
    /**
     * 理学療法士の欠員による減算の状況の有無します。
     */
    理学療法士の欠員による減算の状況の有無("0160", GenzanJokyoUmuByRigakuryohoshiKetsuin.class),
    /**
     * 作業療法士の欠員による減算の状況の有無します。
     */
    作業療法士の欠員による減算の状況の有無("0161", GenzanJokyoUmuBySagyoryohoshiKetsuin.class),
    /**
     * 介護職員の欠員による減算の状況の有無します。
     */
    介護職員の欠員による減算の状況の有無("0162", GenzanJokyoUmuByKaigoStaffKetsuin.class),
    /**
     * 介護支援専門員の欠員による減算の状況の有無します。
     */
    介護支援専門員の欠員による減算の状況の有無("0163", GenzanJokyoUmuByKaigoSupportSemmoninKetsuin.class),
    /**
     * 介護従業者の欠員による減算の状況の有無します。
     */
    介護従業者の欠員による減算の状況の有無("0164", GenzanJokyoUmuByKaigojugyoshaKetsuin.class),
    /**
     * 感染対策指導管理の有無します。
     */
    感染対策指導管理の有無("0165", KansentaisakuShidoKanriUmu.class),
    /**
     * 重症皮膚潰瘍指導管理の有無します。
     */
    重症皮膚潰瘍指導管理の有無("0166", JushoHifukaiyoShidoKanriUmu.class),
    /**
     * 薬剤管理指導の有無します。
     */
    薬剤管理指導の有無("0167", YakuzaiKanriShidoUmu.class),
    /**
     * 障害者生活支援体制の有無します。
     */
    障害者生活支援体制の有無("0168", ShogaishaSeikatsuSupportTaiseiUmu.class),
    /**
     * 生活保護法による指定の有無します。
     */
    生活保護法による指定の有無("0169", ShiteiUmuBySeikatsuhogoho.class),
    /**
     * 受領委任の有無します。
     */
    受領委任の有無("0170", JuryoininUmu.class),
    /**
     * 夜間ケアの有無します。
     */
    夜間ケアの有無("0172", YakanCareUmu.class),
    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ機能強化の有無します。
     */
    ﾘﾊﾋﾞﾘﾃｰｼｮﾝ機能強化の有無("0173", RehabilitationKinoKyokaUmu.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無("0174", KobetsuRehabilitationTeikyoTaiseiUmuSogoRehabilitationShisetsu.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無("0175", KobetsuRehabilitationTeikyoTaiseiUmuRigakuRyoho2.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無_平成18年3月以前します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無_平成18年3月以前("0176", KobetsuRehabilitationTeikyoTaiseiUmuRigakuRyoho3BeforeH183.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無("0177", KobetsuRehabilitationTeikyoTaiseiUmuGengoChokakuRyoho1.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅰ_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅰ_の有無("0178", KobetsuRehabilitationTeikyoTaiseiUmuGengoChokakuRyoho2.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅱ_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅱ_の有無("0179", KobetsuRehabilitationTeikyoTaiseiUmuSagyoRyoho2.class),
    /**
     * 言語聴覚士の欠員による減算の状況の有無します。
     */
    言語聴覚士の欠員による減算の状況の有無("0180", GenzanJokyoUmuByGengoChokakushiKetsuin.class),
    /**
     * 社会福祉法人軽減事業実施の有無します。
     */
    社会福祉法人軽減事業実施の有無("0181", ShafukuhojinKeigenJigyoJisshiUmu.class),
    /**
     * 特定事業所加算_訪問介護_の有無します。
     */
    特定事業所加算_訪問介護_の有無("0182", TokuteiJigyoshoKasanUmu.class),
    /**
     * 若年性認知症ケア体制の有無します。
     */
    若年性認知症ケア体制の有無("0183", JakunenseiNinchishoCareTaiseiUmu.class),
    /**
     * 運動器機能向上体制の有無します。
     */
    運動器機能向上体制の有無("0184", UndokiKinoKojoTaiseiUmu.class),
    /**
     * 栄養マネジメント_改善_体制の有無します。
     */
    栄養マネジメント_改善_体制の有無("0185", EiyoManagementTaiseiUmu.class),
    /**
     * 口腔機能向上体制の有無します。
     */
    口腔機能向上体制の有無("0186", KokuKinoKojoTaiseiUmu.class),
    /**
     * 事業所評価加算_申出_の有無します。
     */
    事業所評価加算_申出_の有無("0187", JigyoshoHyokaKasanMoshideUmu.class),
    /**
     * 事業所評価加算_決定_の有無します。
     */
    事業所評価加算_決定_の有無("0188", JigyoshoHyokaKasanKetteiUmu.class),
    /**
     * 緊急受入体制の有無します。
     */
    緊急受入体制の有無("0189", KinkyuUkeireTaiseiUmu.class),
    /**
     * 夜間看護体制の有無します。
     */
    夜間看護体制の有無("0190", YakanKangoTaiseiUmu.class),
    /**
     * 大規模事業所該当の有無します。
     */
    大規模事業所該当の有無("0191", DaikiboJigyoshoGaitoUmu.class),
    /**
     * 準ユニットケア体制の有無します。
     */
    準ユニットケア体制の有無("0192", JunUnitCareTaiseiUmu.class),
    /**
     * 重度化対応体制の有無します。
     */
    重度化対応体制の有無("0193", JudokaTaioTaiseiUmu.class),
    /**
     * 医療連携体制の有無します。
     */
    医療連携体制の有無("0194", IryoRenkeiTaiseiUmu.class),
    /**
     * ユニットケア体制の有無します。
     */
    ユニットケア体制の有無("0195", UnitCareTaiseiUmu.class),
    /**
     * 在宅_入所相互利用体制の有無します。
     */
    在宅_入所相互利用体制の有無("0196", JutakuNyushoSogoriyoTaiseiUmu.class),
    /**
     * ターミナルケア体制_看取り介護体制_の有無します。
     */
    ターミナルケア体制_看取り介護体制_の有無("0197", TerminalCareTaiseiUmu.class),
    /**
     * 身体拘束廃止取組の有無します。
     */
    身体拘束廃止取組の有無("0198", ShintaikosokuHaishiTorikumiUmu.class),
    /**
     * 小規模拠点集合体制の有無します。
     */
    小規模拠点集合体制の有無("0199", ShokiboKyotenShugoTaiseiUmu.class),
    /**
     * 認知症ケア加算の有無します。
     */
    認知症ケア加算の有無("0200", NinchishoCareKasanUmu.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅰ_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅰ_の有無("0201", KobetsuRehabilitationTeikyoTaiseiUmuRigakuRyoho1.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無_平成21年3月以前します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無_平成21年3月以前("0202", KobetsuRehabilitationTeikyoTaiseiUmuRigakuRyoho2BeforeH213.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法_の有無("0203", KobetsuRehabilitationTeikyoTaiseiUmuSagyoRyoho.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法_の有無("0204", KobetsuRehabilitationTeikyoTaiseiUmuGengoChokakuRyoho.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無("0205", KobetsuRehabilitationTeikyoTaiseiUmuSonota.class),
    /**
     * 療養体制維持特別加算します。
     */
    療養体制維持特別加算("0206", RyoyoTaiseiIjiTokubetsuKasan.class),
    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_ﾘﾊﾋﾞﾘﾃｰｼｮﾝ指導管理_の有無します。
     */
    個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_ﾘﾊﾋﾞﾘﾃｰｼｮﾝ指導管理_の有無("0207", KobetsuRehabilitationTeikyoTaiseiUmu.class),
    /**
     * 三級ヘルパー体制します。
     */
    三級ヘルパー体制("0208", ThirdGradeHelperTaisei.class),
    /**
     * 中山間地域等における小規模事業所加算_地域に関する状況します。
     */
    中山間地域等における小規模事業所加算_地域に関する状況("0209", ShokiboJigyoshoKasanInMountainAreaSituationAboutArea.class),
    /**
     * 中山間地域等における小規模事業所加算_規模に関する状況します。
     */
    中山間地域等における小規模事業所加算_規模に関する状況("0210", ShokiboJigyoshoKasanInMountainAreaSituationAboutScale.class),
    /**
     * 認知症短期集中リハビリテーション加算します。
     */
    認知症短期集中リハビリテーション加算("0211", NinchishoTankiShuchuRehabilitationKasan.class),
    /**
     * 若年性認知症利用者_入所者_患者_受入加算します。
     */
    若年性認知症利用者_入所者_患者_受入加算("0212", JakunenseiNinchishoRiyoshaUkeireKasan.class),
    /**
     * 看護体制加算します。
     */
    看護体制加算("0213", KangoTaiseiKasan.class),
    /**
     * 夜勤職員配置加算します。
     */
    夜勤職員配置加算("0214", YakinStaffHaichiKasan.class),
    /**
     * 療養食加算します。
     */
    療養食加算("0215", RyoyoshokuKasan.class),
    /**
     * 日常生活継続支援加算します。
     */
    日常生活継続支援加算("0216", NichijoSeikatsuKeizokuSupprtKasan.class),
    /**
     * 認知症専門ケア加算します。
     */
    認知症専門ケア加算("0217", NinchishoSemmonCareKasan.class),
    /**
     * 二十四時間通報対応加算します。
     */
    二十四時間通報対応加算("0218", TsuhoTaioFor24HoursKasan.class),
    /**
     * 看護職員配置加算します。
     */
    看護職員配置加算("0219", KangoStaffHaichiKasan.class),
    /**
     * 夜間ケア加算します。
     */
    夜間ケア加算("0220", YakanCareKasan.class),
    /**
     * 集団コミュニケーション療法の有無します。
     */
    集団コミュニケーション療法の有無("0221", ShudanCommunicationRyohoUmu.class),
    /**
     * サービス提供体制強化加算_空床型します。
     */
    サービス提供体制強化加算_空床型("0222", ServiceTeikyoTaiseiKyokaKasanForKushoType.class),
    /**
     * 日中の身体介護２０分未満体制の有無します。
     */
    日中の身体介護２０分未満体制の有無("0223", ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu.class),
    /**
     * サービス提供責任者体制の有無します。
     */
    サービス提供責任者体制の有無("0224", ServiceTeikyoSekininshaTaiseiUmu.class),
    /**
     * 同一建物に居住する利用者の減算の有無します。
     */
    同一建物に居住する利用者の減算の有無("0225", DoitsuTatemonoKyojuUserGenzanUmu.class),
    /**
     * 緊急短期入所体制確保加算します。
     */
    緊急短期入所体制確保加算("0226", KinkyuTankinyushoTaiseiKakuhoKasan.class),
    /**
     * 在宅復帰_在宅療養支援機能加算します。
     */
    在宅復帰_在宅療養支援機能加算("0227", ZaitakuFukkiZaitakuRyoyoSupportKinoKasan.class),
    /**
     * 生活機能向上グループ活動加算します。
     */
    生活機能向上グループ活動加算("0228", SeikatsuKinoKojoGroupKatsudoKasan.class),
    /**
     * 介護職員処遇改善加算します。
     */
    介護職員処遇改善加算("0229", KaigoStaffShoguKaizenKasan.class),
    /**
     * 訂正区分コードします。
     */
    訂正区分コード("0230", TeiseiKubunCode.class),
    /**
     * キャリアパス対応の状況します。
     */
    キャリアパス対応の状況("0231", CareerPathsTaioJokyo.class),
    /**
     * 訪問介護します。
     */
    訪問介護("0232", Homonkaigo.class),
    /**
     * 訪問看護_平成24年3月以前します。
     */
    訪問看護_平成24年3月以前("0233", HomonkangoBeforeH243.class),
    /**
     * 訪問看護_平成24年4月以降します。
     */
    訪問看護_平成24年4月以降("0234", HomonkangoAfterH244.class),
    /**
     * 訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝします。
     */
    訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ("0235", HomonRehabilitation.class),
    /**
     * 通所介護_平成18年3月以前します。
     */
    通所介護_平成18年3月以前("0236", TsushokaigoBeforeH183.class),
    /**
     * 通所介護_平成18年4月以降します。
     */
    通所介護_平成18年4月以降("0237", TsushokaigoAfterH184.class),
    /**
     * 通所介護_平成21年4月以降します。
     */
    通所介護_平成21年4月以降("0238", TsushokaigoAfterH214.class),
    /**
     * 通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年3月以前します。
     */
    通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年3月以前("0239", TsushoRehabilitationBeforeH213.class),
    /**
     * 通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降します。
     */
    通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降("0240", TsushoRehabilitationAfterH214.class),
    /**
     * 通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成24年4月以降します。
     */
    通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成24年4月以降("0241", TsushoRehabilitationAfterH244.class),
    /**
     * 短期入所生活介護_平成15年3月以前します。
     */
    短期入所生活介護_平成15年3月以前("0242", TankinyushoSeikatsukaigoBeforeH153.class),
    /**
     * 短期入所生活介護_平成15年4月以降します。
     */
    短期入所生活介護_平成15年4月以降("0243", TankinyushoSeikatsukaigoAfterH154.class),
    /**
     * 短期入所生活介護_平成17年10月以降します。
     */
    短期入所生活介護_平成17年10月以降("0244", TankinyushoSeikatsukaigoAfterH1710.class),
    /**
     * 短期入所療養介護_老健_平成17年9月以前します。
     */
    短期入所療養介護_老健_平成17年9月以前("0245", TankinyushoRyoyokaigoRokenBeforeH179.class),
    /**
     * 短期入所療養介護_老健_平成17年10月以降します。
     */
    短期入所療養介護_老健_平成17年10月以降("0246", TankinyushoRyoyokaigoRokenAfterH1710.class),
    /**
     * 短期入所療養介護_老健_平成20年5月以降します。
     */
    短期入所療養介護_老健_平成20年5月以降("0247", TankinyushoRyoyokaigoRokenAfterH205.class),
    /**
     * 短期入所療養介護_診療所等_平成15年3月以前します。
     */
    短期入所療養介護_診療所等_平成15年3月以前("0248", TankinyushoRyoyokaigoShinryojoBeforeH153.class),
    /**
     * 短期入所療養介護_診療所等_平成15年4月以降します。
     */
    短期入所療養介護_診療所等_平成15年4月以降("0249", TankinyushoRyoyokaigoShinryojoAfterH154.class),
    /**
     * 短期入所療養介護_診療所等_平成17年10月以降します。
     */
    短期入所療養介護_診療所等_平成17年10月以降("0250", TankinyushoRyoyokaigoShinryojoAfterH1710.class),
    /**
     * 短期入所療養介護_診療所等_平成18年7月以降します。
     */
    短期入所療養介護_診療所等_平成18年7月以降("0251", TankinyushoRyoyokaigoShinryojoAfterH187.class),
    /**
     * 短期入所療養介護_診療所等_平成20年5月以降します。
     */
    短期入所療養介護_診療所等_平成20年5月以降("0252", TankinyushoRyoyokaigoShinryojoAfterH205.class),
    /**
     * 短期入所療養介護_診療所等_平成21年4月以降します。
     */
    短期入所療養介護_診療所等_平成21年4月以降("0253", TankinyushoRyoyokaigoShinryojoAfterH214.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_平成18年3月以前します。
     */
    特定施設入居者生活介護_短期利用型以外_平成18年3月以前("0254", TokuteishisetsunyukyoshaSeikatsukaigoTankiriyogataIgaiBeforeH183.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_平成18年4月以降します。
     */
    特定施設入居者生活介護_短期利用型以外_平成18年4月以降("0255", TokuteishisetsunyukyoshaSeikatsukaigoTankiriyogataIgaiAfterH184.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_平成21年4月以降します。
     */
    特定施設入居者生活介護_短期利用型以外_平成21年4月以降("0256", TokuteishisetsunyukyoshaSeikatsukaigoTankiriyogataIgaiAfterH214.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_平成24年4月以降します。
     */
    特定施設入居者生活介護_短期利用型以外_平成24年4月以降("0257", TokuteishisetsunyukyoshaSeikatsukaigoTankiriyogataIgaiAfterH244.class),
    /**
     * 介護老人福祉施設_平成15年3月以前します。
     */
    介護老人福祉施設_平成15年3月以前("0258", KaigorojinfukushishisetsuBeforeH153.class),
    /**
     * 介護老人福祉施設_平成15年4月以降します。
     */
    介護老人福祉施設_平成15年4月以降("0259", KaigorojinfukushishisetsuAfterH154.class),
    /**
     * 介護老人福祉施設_平成17年10月以降します。
     */
    介護老人福祉施設_平成17年10月以降("0260", KaigorojinfukushishisetsuAfterH1710.class),
    /**
     * 介護老人保健施設_平成17年10月以降します。
     */
    介護老人保健施設_平成17年10月以降("0261", KaigorojinfukushishisetsuAfterH1710.class),
    /**
     * 介護老人保健施設_平成18年4月以降します。
     */
    介護老人保健施設_平成18年4月以降("0262", KaigorojinfukushishisetsuAfterH184.class),
    /**
     * 介護老人保健施設_平成20年5月以降します。
     */
    介護老人保健施設_平成20年5月以降("0263", KaigorojinfukushishisetsuAfterH205.class),
    /**
     * 介護療養型医療施設_平成15年3月以前します。
     */
    介護療養型医療施設_平成15年3月以前("0264", KaigoryoyogataIryoshisetsuBeforeH153.class),
    /**
     * 介護療養型医療施設_平成15年4月以降します。
     */
    介護療養型医療施設_平成15年4月以降("0265", KaigoryoyogataIryoshisetsuAfterH154.class),
    /**
     * 介護療養型医療施設_平成17年10月以降します。
     */
    介護療養型医療施設_平成17年10月以降("0266", KaigoryoyogataIryoshisetsuAfterH1710.class),
    /**
     * 介護療養型医療施設_平成18年7月以降します。
     */
    介護療養型医療施設_平成18年7月以降("0267", KaigoryoyogataIryoshisetsuAfterH187.class),
    /**
     * 介護療養型医療施設_平成20年5月以降します。
     */
    介護療養型医療施設_平成20年5月以降("0268", KaigoryoyogataIryoshisetsuAfterH205.class),
    /**
     * 介護予防訪問看護します。
     */
    介護予防訪問看護("0269", KaigoyoboHomonkango.class),
    /**
     * 介護予防訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝします。
     */
    介護予防訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ("0270", KaigoyoboHomonRehabilitation.class),
    /**
     * 介護予防短期入所生活介護します。
     */
    介護予防短期入所生活介護("0271", KaigoyoboTankinyushoSeikatsukaigo.class),
    /**
     * 介護予防短期入所療養介護_老健_平成18年4月以降します。
     */
    介護予防短期入所療養介護_老健_平成18年4月以降("0272", KaigoyoboTankinyushoRyoyokaigoRokenAfterH184.class),
    /**
     * 介護予防短期入所療養介護_老健_平成20年5月以降します。
     */
    介護予防短期入所療養介護_老健_平成20年5月以降("0273", KaigoyoboTankinyushoRyoyokaigoRokenAfterH205.class),
    /**
     * 介護予防短期入所療養介護_診療所等_平成18年4月以降します。
     */
    介護予防短期入所療養介護_診療所等_平成18年4月以降("0274", KaigoyoboTankinyushoRyoyokaigoShinryojoAfterH184.class),
    /**
     * 介護予防短期入所療養介護_診療所等_平成18年7月以降します。
     */
    介護予防短期入所療養介護_診療所等_平成18年7月以降("0275", KaigoyoboTankinyushoRyoyokaigoShinryojoAfterH187.class),
    /**
     * 介護予防短期入所療養介護_診療所等_平成20年5月以降します。
     */
    介護予防短期入所療養介護_診療所等_平成20年5月以降("0276", KaigoyoboTankinyushoRyoyokaigoShinryojoAfterH205.class),
    /**
     * 介護予防短期入所療養介護_診療所等_平成21年4月以降します。
     */
    介護予防短期入所療養介護_診療所等_平成21年4月以降("0277", KaigoyoboTankinyushoRyoyokaigoShinryojoAfterH214.class),
    /**
     * 介護予防特定施設入居者生活介護_平成24年3月以前します。
     */
    介護予防特定施設入居者生活介護_平成24年3月以前("0278", KaigoyoboTokuteishisetsunyukyoshaSeikatsukaigoBeforeH243.class),
    /**
     * 介護予防特定施設入居者生活介護_平成24年4月以降します。
     */
    介護予防特定施設入居者生活介護_平成24年4月以降("0279", KaigoyoboTokuteishisetsunyukyoshaSeikatsukaigoAfterH244.class),
    /**
     * 夜間対応型訪問介護します。
     */
    夜間対応型訪問介護("0280", YakantaiogataHomonkaigo.class),
    /**
     * 認知症対応型通所介護します。
     */
    認知症対応型通所介護("0281", NinchishotaiogataTsushokaigo.class),
    /**
     * 地域密着型特定施設入居者生活介護_短期利用型以外_平成18年4月以降します。
     */
    地域密着型特定施設入居者生活介護_短期利用型以外_平成18年4月以降("0282", ChiikimitchakugataTokuteishisetsunyukyoshaSeikatsukaigoTankiriyogataigaiAfterH184.class),
    /**
     * 地域密着型特定施設入居者生活介護_短期利用型以外_平成20年5月以降します。
     */
    地域密着型特定施設入居者生活介護_短期利用型以外_平成20年5月以降("0283", ChiikimitchakugataTokuteishisetsunyukyoshaSeikatsukaigoTankiriyogataigaiAfterH205.class),
    /**
     * 地域密着型特定施設入居者生活介護_短期利用型以外_平成24年4月以降します。
     */
    地域密着型特定施設入居者生活介護_短期利用型以外_平成24年4月以降("0284", ChiikimitchakugataTokuteishisetsunyukyoshaSeikatsukaigoTankiriyogataigaiAfterH244.class),
    /**
     * 地域密着型介護老人福祉施設_施設等の区分します。
     */
    地域密着型介護老人福祉施設_施設等の区分("0285", ChiikimitchakugataKaigorojinfukushishisetsuShisetsutoKubun.class),
    /**
     * 介護予防認知症対応型通所介護します。
     */
    介護予防認知症対応型通所介護("0286", KaigoyoboNinchishotaiogataTsuchokaigo.class),
    /**
     * 特定施設入居者生活介護_短期利用型します。
     */
    特定施設入居者生活介護_短期利用型("0287", TokuteishisetsuNyukyoshaSeikatsukaigoTankiriyogata.class),
    /**
     * 介護予防通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝします。
     */
    介護予防通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ("0288", KaigoyoboTsuchoRehabilitation.class),
    /**
     * 定期巡回_随時対応型訪問介護看護します。
     */
    定期巡回_随時対応型訪問介護看護("0289", TeikijunkaiZuijitaiogataHomonkaigokango.class),
    /**
     * 小規模多機能型居宅介護します。
     */
    小規模多機能型居宅介護("0290", ShokiboTakinogataKyotakukaigo.class),
    /**
     * 認知症対応型共同生活介護_短期利用型以外します。
     */
    認知症対応型共同生活介護_短期利用型以外("0291", NinchishotaiogataKyodoSeikatsukaigoTankiriyogataigai.class),
    /**
     * 認知症対応型共同生活介護_短期利用型します。
     */
    認知症対応型共同生活介護_短期利用型("0292", NinchishotaiogataKyodoSeikatsukaigoTankiriyogata.class),
    /**
     * 地域密着型特定施設入居者生活介護_短期利用型します。
     */
    地域密着型特定施設入居者生活介護_短期利用型("0293", ChiikimitchakugataTokuteishisetsunyukyoshaSeikatsukaigoTankiriyogata.class),
    /**
     * 介護予防小規模多機能型居宅介護します。
     */
    介護予防小規模多機能型居宅介護("0294", KaigoyoboShokiboTakinogataKyotakukaigo.class),
    /**
     * 介護予防認知症対応型共同生活介護_短期利用型以外します。
     */
    介護予防認知症対応型共同生活介護_短期利用型以外("0295", KaigoyoboNinchishotaiogataKyodoSeikatsukaigoTankiriyogataigai.class),
    /**
     * 介護予防認知症対応型共同生活介護_短期利用型します。
     */
    介護予防認知症対応型共同生活介護_短期利用型("0296", KaigoyoboNinchishotaiogataKyodoSeikatsukaigoTankiriyogata.class),
    /**
     * 通所介護します。
     */
    通所介護("0297", Tsushokaigo.class),
    /**
     * 短期入所生活介護します。
     */
    短期入所生活介護("0298", TankinyushoSeikatsukaigo.class),
    /**
     * 短期入所療養介護_平成17年9月以前します。
     */
    短期入所療養介護_平成17年9月以前("0299", TankinyushoRyoyokaigoBeforeH179.class),
    /**
     * 短期入所療養介護_通常型します。
     */
    短期入所療養介護_通常型("0300", TankinyushoRyoyokaigoTsujogata.class),
    /**
     * 短期入所療養介護_療養型します。
     */
    短期入所療養介護_療養型("0301", TankinyushoRyoyokaigoRyoyogata.class),
    /**
     * 短期入所療養介護_病院療養型_平成15年3月以前します。
     */
    短期入所療養介護_病院療養型_平成15年3月以前("0302", TankinyushoRyoyokaigoByoinRyoyogataBeforeH153.class),
    /**
     * 短期入所療養介護_病院療養型_平成15年4月以降します。
     */
    短期入所療養介護_病院療養型_平成15年4月以降("0303", TankinyushoRyoyokaigoByoinRyoyogataAfterH154.class),
    /**
     * 短期入所療養介護_診療所療養型_平成15年3月以前します。
     */
    短期入所療養介護_診療所療養型_平成15年3月以前("0304", TankinyushoRyoyokaigoShinryojoRyoyogataBeforeH153.class),
    /**
     * 短期入所療養介護_診療所療養型_平成15年4月以降します。
     */
    短期入所療養介護_診療所療養型_平成15年4月以降("0305", TankinyushoRyoyokaigoShinryojoRyoyogataAfterH154.class),
    /**
     * 短期入所療養介護_認知症疾患型_平成15年3月以前します。
     */
    短期入所療養介護_認知症疾患型_平成15年3月以前("0306", TankinyushoRyoyokaigoNinchishoShikkangataBeforeH153.class),
    /**
     * 短期入所療養介護_認知症疾患型_平成15年4月以降します。
     */
    短期入所療養介護_認知症疾患型_平成15年4月以降("0307", TankinyushoRyoyokaigoNinchishoShikkangataAfterH154.class),
    /**
     * 短期入所療養介護_介護力強化型_平成15年3月以前します。
     */
    短期入所療養介護_介護力強化型_平成15年3月以前("0308", TankinyushoRyoyokaigoKaigoryokuKyokagataBeforeH153.class),
    /**
     * 短期入所療養介護_病院療養型します。
     */
    短期入所療養介護_病院療養型("0309", TankinyushoRyoyokaigoByoinRyoyogata.class),
    /**
     * 短期入所療養介護_診療所療養型します。
     */
    短期入所療養介護_診療所療養型("0310", TankinyushoRyoyokaigoShinryojoRyoyogata.class),
    /**
     * 短期入所療養介護_認知症疾患型します。
     */
    短期入所療養介護_認知症疾患型("0311", TankinyushoRyoyokaigoNinchishoShikkangata.class),
    /**
     * 短期入所療養介護_ユニット型認知症疾患型します。
     */
    短期入所療養介護_ユニット型認知症疾患型("0312", TankinyushoRyoyokaigoUnitGataNinchishoShikkangata.class),
    /**
     * 短期入所療養介護_病院経過型_平成20年5月以降します。
     */
    短期入所療養介護_病院経過型_平成20年5月以降("0313", TankinyushoRyoyokaigoByoinkeikagataAfterH205.class),
    /**
     * 介護老人福祉施設_平成17年9月以前します。
     */
    介護老人福祉施設_平成17年9月以前("0314", KaigorojinfukushishisetsuBeforeH179.class),
    /**
     * 介護老人保健施設_平成17年9月以前します。
     */
    介護老人保健施設_平成17年9月以前("0315", KaigorojinhokenshisetsuBeforeH179.class),
    /**
     * 介護老人保健施設_通常型します。
     */
    介護老人保健施設_通常型("0316", KaigorojinhokenshisetsuNormalType.class),
    /**
     * 介護老人保健施設_療養型します。
     */
    介護老人保健施設_療養型("0317", KaigorojinhokenshisetsuRyoyogata.class),
    /**
     * 介護療養型医療施設_病院療養型_平成15年3月以前します。
     */
    介護療養型医療施設_病院療養型_平成15年3月以前("0318", KaigoryoyogataIryoshisetsuByoinryoyogataBeforeH153.class),
    /**
     * 介護療養型医療施設_病院療養型_平成15年4月以降します。
     */
    介護療養型医療施設_病院療養型_平成15年4月以降("0319", KaigoryoyogataIryoshisetsuByoinryoyogataAfterH154.class),
    /**
     * 介護療養型医療施設_診療所型_平成15年3月以前します。
     */
    介護療養型医療施設_診療所型_平成15年3月以前("0320", KaigoryoyogataIryoshisetsuShinryojogataBeforeH153.class),
    /**
     * 介護療養型医療施設_診療所型_平成15年4月以降します。
     */
    介護療養型医療施設_診療所型_平成15年4月以降("0321", KaigoryoyogataIryoshisetsuShinryoujokataAfterH154.class),
    /**
     * 介護療養型医療施設_認知症疾患型_平成15年3月以前します。
     */
    介護療養型医療施設_認知症疾患型_平成15年3月以前("0322", KaigoryoyogataIryoshisetsuNinchishoShikkangataBeforeH153.class),
    /**
     * 介護療養型医療施設_認知症疾患型_平成15年4月以降します。
     */
    介護療養型医療施設_認知症疾患型_平成15年4月以降("0323", KaigoryoyogataIryoshisetsuNinchishoShikkangataAfterH154.class),
    /**
     * 介護療養型医療施設_介護力強化型_平成15年3月以前します。
     */
    介護療養型医療施設_介護力強化型_平成15年3月以前("0324", KaigoryoyogataIryoshisetsuKaigoryokuKyokagataBeforeH153.class),
    /**
     * 介護療養型医療施設_病院療養型します。
     */
    介護療養型医療施設_病院療養型("0325", KaigoryoyogataIryoshisetsuByoinryoyogata.class),
    /**
     * 介護療養型医療施設_診療所型します。
     */
    介護療養型医療施設_診療所型("0326", KaigoryoyogataIryoshisetsuShinryojogata.class),
    /**
     * 介護療養型医療施設_認知症疾患型します。
     */
    介護療養型医療施設_認知症疾患型("0327", KaigoryoyogataIryoshisetsuNinchishoShikkangata.class),
    /**
     * 介護療養型医療施設_ユニット型認知症疾患型します。
     */
    介護療養型医療施設_ユニット型認知症疾患型("0328", KaigoryoyogataIryoshisetsuUnitGataNinchishoShikkangata.class),
    /**
     * 介護療養型医療施設_病院経過型します。
     */
    介護療養型医療施設_病院経過型("0329", KaigoryoyogataIryoshisetsuByoinkeikagata.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_有料老人ホームします。
     */
    特定施設入居者生活介護_短期利用型以外_有料老人ホーム("0330", TokuteishisetsuNyukyoshaSeikatsukaigoTankiriyogataigaiYuryoRojinHome.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_軽費老人ホームします。
     */
    特定施設入居者生活介護_短期利用型以外_軽費老人ホーム("0331", TokuteishisetsuNyukyoshaSeikatsukaigoTankiriyogataigaiKeihiRojinHome.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_養護老人ホームします。
     */
    特定施設入居者生活介護_短期利用型以外_養護老人ホーム("0332", TokuteishisetsuNyukyoshaSeikatsukaigoTankiriyogataigaiYogoRojinHome.class),
    /**
     * 特定施設入居者生活介護_短期利用型以外_高齢者専用賃貸住宅します。
     */
    特定施設入居者生活介護_短期利用型以外_高齢者専用賃貸住宅("0333", TokuteishisetsuNyukyoshaSeikatsukaigoTankiriyogataigaiKoreishaSenyoChintaijutaku.class),
    /**
     * 介護予防短期入所療養介護_病院療養型します。
     */
    介護予防短期入所療養介護_病院療養型("0334", KaigoyoboTankinyushoRyoyokaigoByoinRyoyogata.class),
    /**
     * 介護予防短期入所療養介護_診療所療養型します。
     */
    介護予防短期入所療養介護_診療所療養型("0335", KaigoyoboTankinyushoRyoyokaigoShinryojoRyoyogata.class),
    /**
     * 介護予防短期入所療養介護_認知症疾患型します。
     */
    介護予防短期入所療養介護_認知症疾患型("0336", KaigoyoboTankinyushoRyoyokaigoNinchishoShikkangata.class),
    /**
     * 介護予防短期入所療養介護_ユニット型認知症疾患型します。
     */
    介護予防短期入所療養介護_ユニット型認知症疾患型("0337", KaigoyoboTankinyushoRyoyokaigoUnitGataNinchishoShikkangata.class),
    /**
     * 介護予防短期入所療養介護_病院経過型します。
     */
    介護予防短期入所療養介護_病院経過型("0338", KaigoyoboTankinyushoRyoyokaigoByoinKeikagata.class),
    /**
     * 介護予防特定施設入居者生活介護_有料老人ホームします。
     */
    介護予防特定施設入居者生活介護_有料老人ホーム("0339", KaigoyoboTokuteishisetsuNyukyoshaSeikatsukaigoYuryoRojinHome.class),
    /**
     * 介護予防特定施設入居者生活介護_軽費老人ホームします。
     */
    介護予防特定施設入居者生活介護_軽費老人ホーム("0340", KaigoyoboTokuteishisetsuNyukyoshaSeikatsukaigoKeihiRojinHome.class),
    /**
     * 介護予防特定施設入居者生活介護_養護老人ホームします。
     */
    介護予防特定施設入居者生活介護_養護老人ホーム("0341", KaigoyoboTokuteishisetsuNyukyoshaSeikatsukaigoYogoRojinHome.class),
    /**
     * 介護予防特定施設入居者生活介護_高齢者専用賃貸住宅します。
     */
    介護予防特定施設入居者生活介護_高齢者専用賃貸住宅("0342", KaigoyoboTokuteishisetsuNyukyoshaSeikatsukaigoKoreishaSenyoChintaijutaku.class),
    /**
     * 地域密着型介護老人福祉施設_人員配置区分します。
     */
    地域密着型介護老人福祉施設_人員配置区分("0343", ChiikimitchakugataKaigoRojinfukushishisetsuJininHaichiKubun.class),
    /**
     * 介護予防短期入所療養介護_通常型します。
     */
    介護予防短期入所療養介護_通常型("0344", KaigoyoboTankinyushoRyoyokaigoNormalType.class),
    /**
     * 介護予防短期入所療養介護_療養型します。
     */
    介護予防短期入所療養介護_療養型("0345", KaigoyoboTankinyushoRyoyokaigoRyoyogata.class),
    /**
     * 夜間勤務条件基準_平成15年3月以前します。
     */
    夜間勤務条件基準_平成15年3月以前("0346", YakanKinmuJokenKijunBeforeH153.class),
    /**
     * 夜間勤務条件基準_平成15年4月以降します。
     */
    夜間勤務条件基準_平成15年4月以降("0347", YakanKinmuJokenKijunAfterH154.class),
    /**
     * 夜間勤務条件基準_平成21年4月以降します。
     */
    夜間勤務条件基準_平成21年4月以降("0348", YakanKinmuJokenKijunAfterH214.class),
    /**
     * 療養環境基準_平成19年3月以前します。
     */
    療養環境基準_平成19年3月以前("0349", RyoyokankyoKijunBeforeH193.class),
    /**
     * 療養環境基準_病院療養型ユニット型_病院療養型_病院経過型_平成19年4月以降します。
     */
    療養環境基準_病院療養型ユニット型_病院療養型_病院経過型_平成19年4月以降("0350", RyoyokankyoKijunAfterH194.class),
    /**
     * 療養環境基準_病院療養型ユニット型_病院療養型_病院経過型_平成20年4月以降します。
     */
    療養環境基準_病院療養型ユニット型_病院療養型_病院経過型_平成20年4月以降("0351", RyoyokankyoKijunAfterH204.class),
    /**
     * 療養環境基準_診療所療養型ユニット型_診療所療養型します。
     */
    療養環境基準_診療所療養型ユニット型_診療所療養型("0352", RyoyokankyoKijunShinryojoRyoyogataUnitGataShinryojoRyoyogata.class),
    /**
     * 特定事業所加算_居宅介護支援_の有無_平成21年3月以前します。
     */
    特定事業所加算_居宅介護支援_の有無_平成21年3月以前("0353", TokuteijigyoshokasanKyotakukaigoshienUmuBeforeH213.class),
    /**
     * 特定事業所加算_居宅介護支援_の有無_平成21年4月以降します。
     */
    特定事業所加算_居宅介護支援_の有無_平成21年4月以降("0354", TokuteijigyoshokasanKyotakukaigoshienUmuAfterH214.class),
    /**
     * 個別機能訓練体制の有無_通所介護_平成21年3月以前します。
     */
    個別機能訓練体制の有無_通所介護_平成21年3月以前("0355", KobetsuKinokunrentaiseiUmuTsushokaigoBforeH213.class),
    /**
     * 個別機能訓練体制の有無_通所介護_平成21年4月以降します。
     */
    個別機能訓練体制の有無_通所介護_平成21年4月以降("0356", KobetsuKinokunrentaiseiUmuTsushokaigoAfterH214.class),
    /**
     * 個別機能訓練体制の有無_通所介護_平成24年4月以降します。
     */
    個別機能訓練体制の有無_通所介護_平成24年4月以降("0357", KobetsuKinokunrentaiseiUmuTsushokaigoAfterH244.class),
    /**
     * 個別機能訓練体制の有無_通所介護以外します。
     */
    個別機能訓練体制の有無_通所介護以外("0358", KobetsuKinokunrentaiseiUmuTsushokaigoigai.class),
    /**
     * サービス提供体制強化加算_訪問入浴介護等します。
     */
    サービス提供体制強化加算_訪問入浴介護等("0359", ServiceTeikyoTaiseikyokakasanHomonnyuyokukaigoEtc.class),
    /**
     * サービス提供体制強化加算_訪問看護等します。
     */
    サービス提供体制強化加算_訪問看護等("0360", ServiceTeikyoTaiseikyokakasanHomonkangoEtc.class),
    /**
     * サービス提供体制強化加算_その他サービスします。
     */
    サービス提供体制強化加算_その他サービス("0361", ServiceTeikyoTaiseikyokakasanSonotaService.class),
    /**
     * 法人等種別します。
     */
    法人等種別("0364", HojinsShubetsu.class);

    private final SubGyomuCode subGyomuCode = SubGyomuCode.DBX介護公開;
    private final CodeShubetsu codeShubetsu;
    private final Class returnType;

    private DBXCodeShubetsu(String codeShubetsu, Class returnType) {
        this.codeShubetsu = new CodeShubetsu(codeShubetsu);
        this.returnType = returnType;
    }

    /**
     * コード種別を返します。
     *
     * @return コード種別
     */
    public CodeShubetsu getCodeShubetsu() {
        return codeShubetsu;
    }

    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * 型を返します。
     *
     * @return 型
     */
    public Class<?> getReturnType() {
        return returnType;
    }
}
