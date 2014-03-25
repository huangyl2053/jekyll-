/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.EnumMap;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkensho;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoBase;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoDetails;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoFactory;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5012ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書情報を変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class ShujiiIkenshoMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoMapper() {
    }

    /**
     * 引数の主治医意見書エンティティから主治医意見書結果情報を作成して返します。
     *
     * @param shujiiIkenshoEntity 主治医意見書エンティティ
     * @param kaigoDoctor 介護医師情報
     * @return 主治医意見書結果情報
     */
    public static ShujiiIkenshoResult toShujiiIkenshoResult(ShujiiIkenshoEntity shujiiIkenshoEntity, KaigoDoctor kaigoDoctor) {
        return new ShujiiIkenshoResult(toShujiiIkenshoBase(shujiiIkenshoEntity, kaigoDoctor), toShujiiIkenshoDetails(shujiiIkenshoEntity));
    }

    /**
     * 引数の主治医意見書結果情報から主治医意見書エンティティを作成して返します。
     *
     * @param shujiiIkenshoResult 主治医意見書結果情報
     * @return 主治医意見書エンティティ
     */
    public static ShujiiIkenshoEntity toShujiiIkenshoEntity(ShujiiIkenshoResult shujiiIkenshoResult) {
        ShujiiIkenshoEntity shujiiIkenshoEntity = new ShujiiIkenshoEntity();
        shujiiIkenshoEntity.setDbT5012ShujiiIkenshoJohoEntity(toDbT5012ShujiiIkenshoJohoEntity(shujiiIkenshoResult));
        shujiiIkenshoEntity.setDbT5013ShujiiIkenshoShosaiJohoEntity(toDbT5013ShujiiIkenshoShosaiJohoEntity(shujiiIkenshoResult));
        return shujiiIkenshoEntity;
    }

    private static DbT5012ShujiiIkenshoJohoEntity toDbT5012ShujiiIkenshoJohoEntity(ShujiiIkenshoResult shujiiIkenshoResult) {
        ShujiiIkenshoBase rslt = shujiiIkenshoResult.get基本情報();
        DbT5012ShujiiIkenshoJohoEntity entity = new DbT5012ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(rslt.get申請書管理番号());
        entity.setIkenshoIraiKubun(rslt.get意見書依頼区分().getCode());
        entity.setIkenshoIraiRirekiNo(rslt.get意見書履歴番号().value().intValue());
        entity.setShujiiIryoKikanCode(rslt.get主治医().get介護医療機関コード().getValue());
        entity.setShujiiCode(rslt.get主治医().get介護医師コード().value());
        entity.setIkenshoJuryoYMD(rslt.get意見書受領年月日());
        entity.setIkenshoKinyuYMD(rslt.get意見書記入年月日());
        entity.setIkenshoSakuseiKaisu(rslt.get意見書作成回数().getCode());
        entity.setIkenshoSakuseiryoShubetsu(rslt.get意見書作成料種別().getCode());
        entity.setNinteiJohoTeikyoKiboFlag(rslt.is認定情報提供希望());
        entity.setIkenshoDoiUmuFlag(rslt.is意見書同意());
        return entity;
    }

    private static DbT5013ShujiiIkenshoShosaiJohoEntity toDbT5013ShujiiIkenshoShosaiJohoEntity(ShujiiIkenshoResult shujiiIkenshoResult) {
        ShujiiIkenshoConverter converter = new ShujiiIkenshoConverter(shujiiIkenshoResult.get詳細情報().get主治医意見書());
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = new DbT5013ShujiiIkenshoShosaiJohoEntity();
        entity.setShinseishoKanriNo(shujiiIkenshoResult.get詳細情報().get申請書管理番号());
        entity.setIkenshoIraiRirekiNo(shujiiIkenshoResult.get詳細情報().get意見書履歴番号().value());
        entity.setKoroshoIfShikibetsuCode(shujiiIkenshoResult.get詳細情報().get厚労省IF識別区分().getCode());
        entity.setIk_shindamMei1(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.診断名1));
        entity.setIk_hasshoYMD1(new FlexibleDate(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.発症年月日1)));
        entity.setIk_shindamMei2(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.診断名2));
        entity.setIk_hasshoYMD2(new FlexibleDate(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.発症年月日2)));
        entity.setIk_shindamMei3(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.診断名3));
        entity.setIk_hasshoYMD3(new FlexibleDate(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.発症年月日3)));
        entity.setIk_anteisei(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.症状の安定性));
        entity.setIk_anteiseiHuanteiJokyo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.具体的な状況));
        entity.setIk_chiryoNaiyo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.治療内容));
        entity.setIk_tokubetsuIryoTentekiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.点滴の管理));
        entity.setIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.中心静脈栄養));
        entity.setIk_tokubetsuIryoTosekiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.透析));
        entity.setIk_tokubetsuIryoStomaShochiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.ストーマの処置));
        entity.setIk_tokubetsuIryoSansoRyohoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.酸素療法));
        entity.setIk_tokubetsuIryoRespiratorUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.レスピレーター));
        entity.setIk_tokubetsuIryoKikanSekkaiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.気管切開の処置));
        entity.setIk_tokubetsuIryoTotsuKangoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.疼痛の看護));
        entity.setIk_tokubetsuIryoKeikanEiyoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.経管栄養));
        entity.setIk_tokubetsuIryoMonitorSokuteiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.モニター測定));
        entity.setIk_tokubetsuIryoJokusoShochiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.褥瘡の処置));
        entity.setIk_tokubetsuIryoCatheterUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.カテーテル));
        entity.setIk_seikatsuJiritsudoShyogaiCode(converter.get意見書結果ByCodeValue(ShujiiIkenshoItemKubun.障害高齢者日常生活自立度));
        entity.setIk_seikatsuJiritsudoNinchshoCode(converter.get意見書結果ByCodeValue(ShujiiIkenshoItemKubun.認知症高齢者日常生活自立度));
        entity.setIk_chukakuShojoTankiKioku(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.短期記憶));
        entity.setIk_chukakuShojoNinchiNoryoku(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.認知能力));
        entity.setIk_chukakuShojoDentatsuNoryoku(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.伝達能力));
        entity.setIk_shuhenShojoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.認知症の周辺症状));
        entity.setIk_shuhenShojoGenshiGenchoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.幻視幻聴));
        entity.setIk_shuhenShojoMosoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.妄想));
        entity.setIk_shuhenShojoChuyaGakutenUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.昼夜逆転));
        entity.setIk_shuhenShojoBogenUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.暴言));
        entity.setIk_shuhenShojoBokoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.暴行));
        entity.setIk_shuhenShojoKaigoHenoTeikoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.介護への抵抗));
        entity.setIk_shuhenShojoHaikaiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.認知症_徘徊));
        entity.setIk_shuhenShojoHiNoFushimatsuUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.火の不始末));
        entity.setIk_shuhenShojoFuketsuKoiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.不潔行為));
        entity.setIk_shuhenShojoIshokuKodoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.異食行動));
        entity.setIk_shuhenShojoSeitekiMondaiKodoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.性的問題行動));
        entity.setIk_shuhenShojoSonotaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.認知症_その他));
        entity.setIk_shuhenShojoSonotaNaiyo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.認知症_その他内容));
        entity.setIk_seishinOrShinkeiShojoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.精神_神経症状));
        entity.setIk_seishinOrShinkeiShojoShimei(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.精神_神経症状名));
        entity.setIk_semmonkaiJushinUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.専門科医受診));
        entity.setIk_semmonkaiJushin(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.専門科医受診内容));
        entity.setIk_kikiudeKubun(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.利き腕));
        entity.setIk_shincho(converter.get意見書結果ByIntValue(ShujiiIkenshoItemKubun.身長));
        entity.setIk_taiju(converter.get意見書結果ByIntValue(ShujiiIkenshoItemKubun.体重));
        entity.setIk_taijuHenka(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.体重の変化));
        entity.setIk_shishiKessonUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.四肢欠損));
        entity.setIk_shishiKessonBui(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.四肢欠損部位));
        entity.setIk_shishiKessonTeido(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.四肢欠損程度));
        entity.setIk_mahiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.麻痺));
        entity.setIk_mahiTeido(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.麻痺程度));
        entity.setIk_mahiHidariJoshi(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.麻痺_左上肢));
        entity.setIk_mahiMigiJoshi(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.麻痺_右上肢));
        entity.setIk_mahiHidariKashi(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.麻痺_左下肢));
        entity.setIk_mahiMigiKashi(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.麻痺_右下肢));
        entity.setIk_mahiSonota(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.麻痺_その他));
        entity.setIk_kinryokuTeikaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.筋力低下));
        entity.setIk_kinryokuTeikaBui(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.筋力低下部位));
        entity.setIk_kinryokuTeikaTeido(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.筋力低下程度));
        entity.setIk_koshukuMigiKataUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右肩));
        entity.setIk_koshukuHidariKataUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左肩));
        entity.setIk_koshukuMigiHijiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右肘));
        entity.setIk_koshukuHidariHijiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左肘));
        entity.setIk_koshukuMigiMataUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右股));
        entity.setIk_koshukuHidariMataUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左股));
        entity.setIk_koshukuMigiHizaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右膝));
        entity.setIk_koshukuHidariHizaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左膝));
        entity.setIk_kansetsuKoshukuTeido(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.関節の拘縮程度));
        entity.setIk_kansetsuItamiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.関節の痛み));
        entity.setIk_kansetsuItamiBui(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.関節の痛み部位));
        entity.setIk_kansatsuItamiTeido(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.関節の痛み程度));
        entity.setIk_huzuiiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.失調不随意));
        entity.setIk_huzuiiMigiJoshiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.失調不随意_右上肢));
        entity.setIk_huzuiiHidariJoshiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.失調不随意_左上肢));
        entity.setIk_huzuiiMigiTaikanUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.失調不随意_右体幹));
        entity.setIk_huzuiiHidariTaikanUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.失調不随意_左体幹));
        entity.setIk_huzuiiMigiKashiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.失調不随意_右下肢));
        entity.setIk_huzuiiHidariKashiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.失調不随意_左下肢));
        entity.setIk_jokusoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.じょくそう));
        entity.setIk_jokusoBui(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.じょくそう部位));
        entity.setIk_jokusoTeido(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.じょくそう程度));
        entity.setIk_sonotaHifuShikkanUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.その他皮膚疾患));
        entity.setIk_sonotaHifuShikkkanBui(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.その他皮膚疾患部位));
        entity.setIk_sonotaHifushikkanTeido(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.その他皮膚疾患程度));
        entity.setIk_idoOkugaiHoko(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.屋外歩行));
        entity.setIk_idoKurumaisu(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.車椅子の使用));
        entity.setIk_idoHokohojoguMishiyo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.歩行補助具_装具未使用));
        entity.setIk_idoHokohojoguOkugai(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.歩行補助具_装具屋外使用));
        entity.setIk_idoHokohojoguOkunai(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.歩行補助具_装具屋内使用));
        entity.setIk_shokuseikatsuShokujiKoi(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.食事行為));
        entity.setIk_shokuseikatsuEiyoJotai(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.現在の栄養状態));
        entity.setIk_shokuseikatsuRyuiten(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.栄養_食生活留意点));
        entity.setIk_probabilityNyoShikkinUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.尿失禁));
        entity.setIk_probabilityTentoOrKossetsuUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.転倒_骨折));
        entity.setIk_probabilityIdoNoryokuTeikaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.移動能力の低下));
        entity.setIk_probabilityJokusoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.褥瘡));
        entity.setIk_probabilityTojikomoriUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.閉じこもり));
        entity.setIk_probabilitiyIyokuTeikaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.意欲低下));
        entity.setIk_probabilityHaikaiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.徘徊));
        entity.setIk_probabilityTeiEiyoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.低栄養));
        entity.setIk_probabilitySesshokuEngiKinoTeikaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.摂食_嚥下機能低下));
        entity.setIk_probabilityDassuiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.脱水));
        entity.setIk_probabilityIkansenshoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.易感染症));
        entity.setIk_probabilityTotsuUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.がん等による疼痛));
        entity.setIk_probabilitySonotaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.その他状態));
        entity.setIk_probabilitySonotaNaiyo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.その他状態内容));
        entity.setIk_probabilityEngeseiHaienUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.嚥下性肺炎));
        entity.setIk_probabilityChoHeisokuUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.腸閉塞));
        entity.setIk_probabilityShinpaiKinoTeikaUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.心肺機能の低下));
        entity.setIk_probabilityItamiUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.痛み));
        entity.setIk_probabilityTaisho(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.状態対処方針));
        entity.setIk_yogoMitoshi(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.介護の必要な程度に関する予後の見直し));
        entity.setIk_ijiKaizenMitoshi(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.サービス利用による生活機能の維持_改善の見通し));
        entity.setIk_homonShinryoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.訪問診療));
        entity.setIk_tankiNyushoRyoyoKaigoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.短期入所療養介護));
        entity.setIk_homonEiyoShokujiShidoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.訪問栄養食事指導));
        entity.setIk_homonKangoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.訪問看護));
        entity.setIk_homonShikaShinryoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.訪問歯科診療));
        entity.setIk_homonRihabilitationUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.訪問リハビリテーション));
        entity.setIk_homonShikaEiseiShidoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.訪問歯科衛生指導));
        entity.setIk_tushoRihabilitationUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.通所リハビリテーション));
        entity.setIk_homonYakuzaiKanriShidoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.訪問薬剤管理指導));
        entity.setIk_sonotaIgakutekiKanriUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.その他医学的管理));
        entity.setIk_ryuiJikoKetsuatsuUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.血圧));
        entity.setIk_ryuiJikoKetsuatsu(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.血圧内容));
        entity.setIk_ryuiJikoSesshokuUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.摂食));
        entity.setIk_ryuiJikoSesshoku(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.摂食内容));
        entity.setIk_ryuiJikoEngeUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.嚥下));
        entity.setIk_ryuiJikoEnge(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.嚥下内容));
        entity.setIk_ryuiJikoIdoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.移動));
        entity.setIk_ryuiJikoIdo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.移動内容));
        entity.setIk_ryuiJikoUndoUmuKubun(converter.is意見書結果(ShujiiIkenshoItemKubun.運動));
        entity.setIk_ryuiJikoUndo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.運動内容));
        entity.setIk_ryuiJikoSonota(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.その他留意事項));
        entity.setIk_kansenshoUmu(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.感染症));
        entity.setIk_kansenshoShojo(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.感染症内容));
        entity.setIk_tokkiJiko(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.特記事項));
        entity.setIk_kangoSyokuiHomonUmu(converter.get意見書結果ByStringValue(ShujiiIkenshoItemKubun.看護職員の訪問による相談_支援));
        return entity;
    }

    private static ShujiiIkenshoBase toShujiiIkenshoBase(ShujiiIkenshoEntity shujiiIkenshoEntity, KaigoDoctor kaigoDoctor) {
        DbT5012ShujiiIkenshoJohoEntity entity = shujiiIkenshoEntity.getDbT5012ShujiiIkenshoJohoEntity();
        return new ShujiiIkenshoBase(
                entity.getShinseishoKanriNo(),
                new ShujiiIkenshoRirekiNo(entity.getIkenshoIraiRirekiNo()),
                ShujiiIkenshoIraiKubun.toValue(entity.getIkenshoIraiKubun()),
                kaigoDoctor,
                entity.getIkenshoJuryoYMD(),
                entity.getIkenshoKinyuYMD(),
                ShujiiIkenshoSakuseiKaisu.toValue(entity.getIkenshoSakuseiKaisu()),
                ShujiiIkenshoSakuseiryoShubetsu.toValue(entity.getIkenshoSakuseiryoShubetsu()),
                entity.getNinteiJohoTeikyoKiboFlag(),
                entity.getIkenshoDoiUmuFlag());
    }

    private static ShujiiIkenshoDetails toShujiiIkenshoDetails(ShujiiIkenshoEntity shujiiIkenshoEntity) {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = shujiiIkenshoEntity.getDbT5013ShujiiIkenshoShosaiJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        ShujiiIkenshoConverter converter = new ShujiiIkenshoConverter(ShujiiIkenshoFactory.create主治医意見書Instance(koroshoIFKubun));
        ShujiiIkensho result = new ShujiiIkensho(new EnumMap<>(ShujiiIkenshoItemKubun.class), getShujiiIkenshoItemGroup(koroshoIFKubun));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.診断名1, entity.getIk_shindamMei1()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.発症年月日1, new RString(entity.getIk_hasshoYMD1().toString())));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.診断名2, entity.getIk_shindamMei2()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.発症年月日2, new RString(entity.getIk_hasshoYMD2().toString())));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.診断名3, entity.getIk_shindamMei3()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.発症年月日3, new RString(entity.getIk_hasshoYMD3().toString())));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.症状の安定性, entity.getIk_anteisei()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.具体的な状況, entity.getIk_anteiseiHuanteiJokyo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.治療内容, entity.getIk_chiryoNaiyo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.点滴の管理, entity.getIk_tokubetsuIryoTentekiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.中心静脈栄養, entity.getIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.透析, entity.getIk_tokubetsuIryoTosekiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.ストーマの処置, entity.getIk_tokubetsuIryoStomaShochiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.酸素療法, entity.getIk_tokubetsuIryoSansoRyohoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.レスピレーター, entity.getIk_tokubetsuIryoRespiratorUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.気管切開の処置, entity.getIk_tokubetsuIryoKikanSekkaiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.疼痛の看護, entity.getIk_tokubetsuIryoTotsuKangoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.経管栄養, entity.getIk_tokubetsuIryoKeikanEiyoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.モニター測定, entity.getIk_tokubetsuIryoMonitorSokuteiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.褥瘡の処置, entity.getIk_tokubetsuIryoJokusoShochiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.カテーテル, entity.getIk_tokubetsuIryoCatheterUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.障害高齢者日常生活自立度, entity.getIk_seikatsuJiritsudoShyogaiCode().value()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.認知症高齢者日常生活自立度, entity.getIk_seikatsuJiritsudoNinchshoCode().value()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.短期記憶, entity.getIk_chukakuShojoTankiKioku()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.認知能力, entity.getIk_chukakuShojoNinchiNoryoku()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.伝達能力, entity.getIk_chukakuShojoDentatsuNoryoku()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.認知症の周辺症状, entity.getIk_shuhenShojoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.幻視幻聴, entity.getIk_shuhenShojoGenshiGenchoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.妄想, entity.getIk_shuhenShojoMosoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.昼夜逆転, entity.getIk_shuhenShojoChuyaGakutenUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.暴言, entity.getIk_shuhenShojoBogenUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.暴行, entity.getIk_shuhenShojoBokoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.介護への抵抗, entity.getIk_shuhenShojoKaigoHenoTeikoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.認知症_徘徊, entity.getIk_shuhenShojoHaikaiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.火の不始末, entity.getIk_shuhenShojoHiNoFushimatsuUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.不潔行為, entity.getIk_shuhenShojoFuketsuKoiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.異食行動, entity.getIk_shuhenShojoIshokuKodoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.性的問題行動, entity.getIk_shuhenShojoSeitekiMondaiKodoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.認知症_その他, entity.getIk_shuhenShojoSonotaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.認知症_その他内容, entity.getIk_shuhenShojoSonotaNaiyo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.精神_神経症状, entity.getIk_seishinOrShinkeiShojoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.精神_神経症状名, entity.getIk_seishinOrShinkeiShojoShimei()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.専門科医受診, entity.getIk_semmonkaiJushinUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.専門科医受診内容, entity.getIk_semmonkaiJushin()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.利き腕, entity.getIk_kikiudeKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.身長, entity.getIk_shincho()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.体重, entity.getIk_taiju()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.体重の変化, entity.getIk_taijuHenka()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.四肢欠損, entity.getIk_shishiKessonUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.四肢欠損部位, entity.getIk_shishiKessonBui()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.四肢欠損程度, entity.getIk_shishiKessonTeido()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.麻痺, entity.getIk_mahiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.麻痺程度, entity.getIk_mahiTeido()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.麻痺_左上肢, entity.getIk_mahiHidariJoshi()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.麻痺_右上肢, entity.getIk_mahiMigiJoshi()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.麻痺_左下肢, entity.getIk_mahiHidariKashi()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.麻痺_右下肢, entity.getIk_mahiMigiKashi()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.麻痺_その他, entity.getIk_mahiSonota()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.筋力低下, entity.getIk_kinryokuTeikaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.筋力低下部位, entity.getIk_kinryokuTeikaBui()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.筋力低下程度, entity.getIk_kinryokuTeikaTeido()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右肩, entity.getIk_koshukuMigiKataUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左肩, entity.getIk_koshukuHidariKataUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右肘, entity.getIk_koshukuMigiHijiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左肘, entity.getIk_koshukuHidariHijiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右股, entity.getIk_koshukuMigiMataUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左股, entity.getIk_koshukuHidariMataUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_右膝, entity.getIk_koshukuMigiHizaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮_左膝, entity.getIk_koshukuHidariHizaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の拘縮程度, entity.getIk_kansetsuKoshukuTeido()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の痛み, entity.getIk_kansetsuItamiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の痛み部位, entity.getIk_kansetsuItamiBui()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.関節の痛み程度, entity.getIk_kansatsuItamiTeido()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.失調不随意, entity.getIk_huzuiiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.失調不随意_右上肢, entity.getIk_huzuiiMigiJoshiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.失調不随意_左上肢, entity.getIk_huzuiiHidariJoshiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.失調不随意_右体幹, entity.getIk_huzuiiMigiTaikanUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.失調不随意_左体幹, entity.getIk_huzuiiHidariTaikanUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.失調不随意_右下肢, entity.getIk_huzuiiMigiKashiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.失調不随意_左下肢, entity.getIk_huzuiiHidariKashiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.じょくそう, entity.getIk_jokusoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.じょくそう部位, entity.getIk_jokusoBui()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.じょくそう程度, entity.getIk_jokusoTeido()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.その他皮膚疾患, entity.getIk_sonotaHifuShikkanUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.その他皮膚疾患部位, entity.getIk_sonotaHifuShikkkanBui()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.その他皮膚疾患程度, entity.getIk_sonotaHifushikkanTeido()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.屋外歩行, entity.getIk_idoOkugaiHoko()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.車椅子の使用, entity.getIk_idoKurumaisu()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.歩行補助具_装具未使用, entity.getIk_idoHokohojoguMishiyo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.歩行補助具_装具屋外使用, entity.getIk_idoHokohojoguOkugai()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.歩行補助具_装具屋内使用, entity.getIk_idoHokohojoguOkunai()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.食事行為, entity.getIk_shokuseikatsuShokujiKoi()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.現在の栄養状態, entity.getIk_shokuseikatsuEiyoJotai()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.栄養_食生活留意点, entity.getIk_shokuseikatsuRyuiten()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.尿失禁, entity.getIk_probabilityNyoShikkinUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.転倒_骨折, entity.getIk_probabilityTentoOrKossetsuUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.移動能力の低下, entity.getIk_probabilityIdoNoryokuTeikaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.褥瘡, entity.getIk_probabilityJokusoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.閉じこもり, entity.getIk_probabilityTojikomoriUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.意欲低下, entity.getIk_probabilitiyIyokuTeikaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.徘徊, entity.getIk_probabilityHaikaiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.低栄養, entity.getIk_probabilityTeiEiyoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.摂食_嚥下機能低下, entity.getIk_probabilitySesshokuEngiKinoTeikaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.脱水, entity.getIk_probabilityDassuiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.易感染症, entity.getIk_probabilityIkansenshoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.がん等による疼痛, entity.getIk_probabilityTotsuUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.その他状態, entity.getIk_probabilitySonotaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.その他状態内容, entity.getIk_probabilitySonotaNaiyo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.嚥下性肺炎, entity.getIk_probabilityEngeseiHaienUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.腸閉塞, entity.getIk_probabilityChoHeisokuUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.心肺機能の低下, entity.getIk_probabilityShinpaiKinoTeikaUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.痛み, entity.getIk_probabilityItamiUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.状態対処方針, entity.getIk_probabilityTaisho()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.介護の必要な程度に関する予後の見直し, entity.getIk_yogoMitoshi()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.サービス利用による生活機能の維持_改善の見通し, entity.getIk_ijiKaizenMitoshi()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.訪問診療, entity.getIk_homonShinryoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.短期入所療養介護, entity.getIk_tankiNyushoRyoyoKaigoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.訪問栄養食事指導, entity.getIk_homonEiyoShokujiShidoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.訪問看護, entity.getIk_homonKangoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.訪問歯科診療, entity.getIk_homonShikaShinryoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.訪問リハビリテーション, entity.getIk_homonRihabilitationUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.訪問歯科衛生指導, entity.getIk_homonShikaEiseiShidoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.通所リハビリテーション, entity.getIk_tushoRihabilitationUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.訪問薬剤管理指導, entity.getIk_homonYakuzaiKanriShidoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.その他医学的管理, entity.getIk_sonotaIgakutekiKanriUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.血圧, entity.getIk_ryuiJikoKetsuatsuUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.血圧内容, entity.getIk_ryuiJikoKetsuatsu()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.摂食, entity.getIk_ryuiJikoSesshokuUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.摂食内容, entity.getIk_ryuiJikoSesshoku()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.嚥下, entity.getIk_ryuiJikoEngeUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.嚥下内容, entity.getIk_ryuiJikoEnge()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.移動, entity.getIk_ryuiJikoIdoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.移動内容, entity.getIk_ryuiJikoIdo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.運動, entity.getIk_ryuiJikoUndoUmuKubun()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.運動内容, entity.getIk_ryuiJikoUndo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.その他留意事項, entity.getIk_ryuiJikoSonota()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.感染症, entity.getIk_kansenshoUmu()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.感染症内容, entity.getIk_kansenshoShojo()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.特記事項, entity.getIk_tokkiJiko()));
        result.set意見書項目(converter.create意見書結果(ShujiiIkenshoItemKubun.看護職員の訪問による相談_支援, entity.getIk_kangoSyokuiHomonUmu()));
        return new ShujiiIkenshoDetails(
                entity.getShinseishoKanriNo(), new ShujiiIkenshoRirekiNo(entity.getIkenshoIraiRirekiNo()), koroshoIFKubun, result);
    }

    private static IShujiiIkenshoItemGroup[] getShujiiIkenshoItemGroup(KoroshoIFKubun koroshoIFKubun) {
        switch (koroshoIFKubun) {
            case V09A:
                return ShujiiIkenshoItemGroupOf2009.values();
            default:
                return null;
        }
    }
}
