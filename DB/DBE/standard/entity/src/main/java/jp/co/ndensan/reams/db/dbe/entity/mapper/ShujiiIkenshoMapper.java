/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoBase;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoDetails;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoEditor;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoFactory;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoDoi;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiJohoTeikyoKibo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
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
        ShujiiIkenshoEditor editor = new ShujiiIkenshoEditor(shujiiIkenshoResult.get詳細情報().get主治医意見書());
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = new DbT5013ShujiiIkenshoShosaiJohoEntity();
        entity.setShinseishoKanriNo(shujiiIkenshoResult.get詳細情報().get申請書管理番号());
        entity.setIkenshoIraiRirekiNo(shujiiIkenshoResult.get詳細情報().get意見書履歴番号().value());
        entity.setKoroshoIfShikibetsuCode(shujiiIkenshoResult.get詳細情報().get厚労省IF識別区分().getCode());
        entity.setIk_shindamMei1(editor.getResultByString(ShujiiIkenshoItemKubun.診断名1));
        entity.setIk_hasshoYMD1(new FlexibleDate(editor.getResultByString(ShujiiIkenshoItemKubun.発症年月日1)));
        entity.setIk_shindamMei2(editor.getResultByString(ShujiiIkenshoItemKubun.診断名2));
        entity.setIk_hasshoYMD2(new FlexibleDate(editor.getResultByString(ShujiiIkenshoItemKubun.発症年月日2)));
        entity.setIk_shindamMei3(editor.getResultByString(ShujiiIkenshoItemKubun.診断名3));
        entity.setIk_hasshoYMD3(new FlexibleDate(editor.getResultByString(ShujiiIkenshoItemKubun.発症年月日3)));
        entity.setIk_anteisei(editor.getResultByString(ShujiiIkenshoItemKubun.症状の安定性));
        entity.setIk_anteiseiHuanteiJokyo(editor.getResultByString(ShujiiIkenshoItemKubun.具体的な状況));
        entity.setIk_chiryoNaiyo(editor.getResultByString(ShujiiIkenshoItemKubun.治療内容));
        entity.setIk_tokubetsuIryoTentekiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.点滴の管理));
        entity.setIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.中心静脈栄養));
        entity.setIk_tokubetsuIryoTosekiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.透析));
        entity.setIk_tokubetsuIryoStomaShochiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.ストーマの処置));
        entity.setIk_tokubetsuIryoSansoRyohoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.酸素療法));
        entity.setIk_tokubetsuIryoRespiratorUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.レスピレーター));
        entity.setIk_tokubetsuIryoKikanSekkaiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.気管切開の処置));
        entity.setIk_tokubetsuIryoTotsuKangoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.疼痛の看護));
        entity.setIk_tokubetsuIryoKeikanEiyoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.経管栄養));
        entity.setIk_tokubetsuIryoMonitorSokuteiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.モニター測定));
        entity.setIk_tokubetsuIryoJokusoShochiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.褥瘡の処置));
        entity.setIk_tokubetsuIryoCatheterUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.カテーテル));
        entity.setIk_seikatsuJiritsudoShyogaiCode(editor.getResultByCode(ShujiiIkenshoItemKubun.障害高齢者日常生活自立度));
        entity.setIk_seikatsuJiritsudoNinchshoCode(editor.getResultByCode(ShujiiIkenshoItemKubun.認知症高齢者日常生活自立度));
        entity.setIk_chukakuShojoTankiKioku(editor.getResultByString(ShujiiIkenshoItemKubun.短期記憶));
        entity.setIk_chukakuShojoNinchiNoryoku(editor.getResultByString(ShujiiIkenshoItemKubun.認知能力));
        entity.setIk_chukakuShojoDentatsuNoryoku(editor.getResultByString(ShujiiIkenshoItemKubun.伝達能力));
        entity.setIk_shuhenShojoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.認知症の周辺症状));
        entity.setIk_shuhenShojoGenshiGenchoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.幻視幻聴));
        entity.setIk_shuhenShojoMosoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.妄想));
        entity.setIk_shuhenShojoChuyaGakutenUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.昼夜逆転));
        entity.setIk_shuhenShojoBogenUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.暴言));
        entity.setIk_shuhenShojoBokoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.暴行));
        entity.setIk_shuhenShojoKaigoHenoTeikoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.介護への抵抗));
        entity.setIk_shuhenShojoHaikaiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.認知症_徘徊));
        entity.setIk_shuhenShojoHiNoFushimatsuUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.火の不始末));
        entity.setIk_shuhenShojoFuketsuKoiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.不潔行為));
        entity.setIk_shuhenShojoIshokuKodoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.異食行動));
        entity.setIk_shuhenShojoSeitekiMondaiKodoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.性的問題行動));
        entity.setIk_shuhenShojoSonotaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.認知症_その他));
        entity.setIk_shuhenShojoSonotaNaiyo(editor.getResultByString(ShujiiIkenshoItemKubun.認知症_その他内容));
        entity.setIk_seishinOrShinkeiShojoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.精神_神経症状));
        entity.setIk_seishinOrShinkeiShojoShimei(editor.getResultByString(ShujiiIkenshoItemKubun.精神_神経症状名));
        entity.setIk_semmonkaiJushinUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.専門科医受診));
        entity.setIk_semmonkaiJushin(editor.getResultByString(ShujiiIkenshoItemKubun.専門科医受診内容));
        entity.setIk_kikiudeKubun(editor.getResultByString(ShujiiIkenshoItemKubun.利き腕));
        entity.setIk_shincho(editor.getResultByInt(ShujiiIkenshoItemKubun.身長));
        entity.setIk_taiju(editor.getResultByInt(ShujiiIkenshoItemKubun.体重));
        entity.setIk_taijuHenka(editor.getResultByString(ShujiiIkenshoItemKubun.体重の変化));
        entity.setIk_shishiKessonUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.四肢欠損));
        entity.setIk_shishiKessonBui(editor.getResultByString(ShujiiIkenshoItemKubun.四肢欠損部位));
        entity.setIk_shishiKessonTeido(editor.getResultByString(ShujiiIkenshoItemKubun.四肢欠損程度));
        entity.setIk_mahiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.麻痺));
        entity.setIk_mahiTeido(editor.getResultByString(ShujiiIkenshoItemKubun.麻痺程度));
        entity.setIk_mahiHidariJoshi(editor.getResultByString(ShujiiIkenshoItemKubun.麻痺_左上肢));
        entity.setIk_mahiMigiJoshi(editor.getResultByString(ShujiiIkenshoItemKubun.麻痺_右上肢));
        entity.setIk_mahiHidariKashi(editor.getResultByString(ShujiiIkenshoItemKubun.麻痺_左下肢));
        entity.setIk_mahiMigiKashi(editor.getResultByString(ShujiiIkenshoItemKubun.麻痺_右下肢));
        entity.setIk_mahiSonota(editor.getResultByString(ShujiiIkenshoItemKubun.麻痺_その他));
        entity.setIk_kinryokuTeikaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.筋力低下));
        entity.setIk_kinryokuTeikaBui(editor.getResultByString(ShujiiIkenshoItemKubun.筋力低下部位));
        entity.setIk_kinryokuTeikaTeido(editor.getResultByString(ShujiiIkenshoItemKubun.筋力低下程度));
        entity.setIk_koshukuMigiKataUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_右肩));
        entity.setIk_koshukuHidariKataUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_左肩));
        entity.setIk_koshukuMigiHijiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_右肘));
        entity.setIk_koshukuHidariHijiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_左肘));
        entity.setIk_koshukuMigiMataUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_右股));
        entity.setIk_koshukuHidariMataUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_左股));
        entity.setIk_koshukuMigiHizaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_右膝));
        entity.setIk_koshukuHidariHizaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の拘縮_左膝));
        entity.setIk_kansetsuKoshukuTeido(editor.getResultByString(ShujiiIkenshoItemKubun.関節の拘縮程度));
        entity.setIk_kansetsuItamiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.関節の痛み));
        entity.setIk_kansetsuItamiBui(editor.getResultByString(ShujiiIkenshoItemKubun.関節の痛み部位));
        entity.setIk_kansatsuItamiTeido(editor.getResultByString(ShujiiIkenshoItemKubun.関節の痛み程度));
        entity.setIk_huzuiiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.失調不随意));
        entity.setIk_huzuiiMigiJoshiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.失調不随意_右上肢));
        entity.setIk_huzuiiHidariJoshiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.失調不随意_左上肢));
        entity.setIk_huzuiiMigiTaikanUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.失調不随意_右体幹));
        entity.setIk_huzuiiHidariTaikanUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.失調不随意_左体幹));
        entity.setIk_huzuiiMigiKashiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.失調不随意_右下肢));
        entity.setIk_huzuiiHidariKashiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.失調不随意_左下肢));
        entity.setIk_jokusoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.じょくそう));
        entity.setIk_jokusoBui(editor.getResultByString(ShujiiIkenshoItemKubun.じょくそう部位));
        entity.setIk_jokusoTeido(editor.getResultByString(ShujiiIkenshoItemKubun.じょくそう程度));
        entity.setIk_sonotaHifuShikkanUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.その他皮膚疾患));
        entity.setIk_sonotaHifuShikkkanBui(editor.getResultByString(ShujiiIkenshoItemKubun.その他皮膚疾患部位));
        entity.setIk_sonotaHifushikkanTeido(editor.getResultByString(ShujiiIkenshoItemKubun.その他皮膚疾患程度));
        entity.setIk_idoOkugaiHoko(editor.getResultByString(ShujiiIkenshoItemKubun.屋外歩行));
        entity.setIk_idoKurumaisu(editor.getResultByString(ShujiiIkenshoItemKubun.車椅子の使用));
        entity.setIk_idoHokohojoguMishiyo(editor.getResultByString(ShujiiIkenshoItemKubun.歩行補助具_装具未使用));
        entity.setIk_idoHokohojoguOkugai(editor.getResultByString(ShujiiIkenshoItemKubun.歩行補助具_装具屋外使用));
        entity.setIk_idoHokohojoguOkunai(editor.getResultByString(ShujiiIkenshoItemKubun.歩行補助具_装具屋内使用));
        entity.setIk_shokuseikatsuShokujiKoi(editor.getResultByString(ShujiiIkenshoItemKubun.食事行為));
        entity.setIk_shokuseikatsuEiyoJotai(editor.getResultByString(ShujiiIkenshoItemKubun.現在の栄養状態));
        entity.setIk_shokuseikatsuRyuiten(editor.getResultByString(ShujiiIkenshoItemKubun.栄養_食生活留意点));
        entity.setIk_probabilityNyoShikkinUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.尿失禁));
        entity.setIk_probabilityTentoOrKossetsuUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.転倒_骨折));
        entity.setIk_probabilityIdoNoryokuTeikaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.移動能力の低下));
        entity.setIk_probabilityJokusoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.褥瘡));
        entity.setIk_probabilityTojikomoriUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.閉じこもり));
        entity.setIk_probabilitiyIyokuTeikaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.意欲低下));
        entity.setIk_probabilityHaikaiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.徘徊));
        entity.setIk_probabilityTeiEiyoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.低栄養));
        entity.setIk_probabilitySesshokuEngiKinoTeikaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.摂食_嚥下機能低下));
        entity.setIk_probabilityDassuiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.脱水));
        entity.setIk_probabilityIkansenshoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.易感染症));
        entity.setIk_probabilityTotsuUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.がん等による疼痛));
        entity.setIk_probabilitySonotaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.その他状態));
        entity.setIk_probabilitySonotaNaiyo(editor.getResultByString(ShujiiIkenshoItemKubun.その他状態内容));
        entity.setIk_probabilityEngeseiHaienUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.嚥下性肺炎));
        entity.setIk_probabilityChoHeisokuUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.腸閉塞));
        entity.setIk_probabilityShinpaiKinoTeikaUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.心肺機能の低下));
        entity.setIk_probabilityItamiUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.痛み));
        entity.setIk_probabilityTaisho(editor.getResultByString(ShujiiIkenshoItemKubun.状態対処方針));
        entity.setIk_yogoMitoshi(editor.getResultByString(ShujiiIkenshoItemKubun.介護の必要な程度に関する予後の見直し));
        entity.setIk_ijiKaizenMitoshi(editor.getResultByString(ShujiiIkenshoItemKubun.サービス利用による生活機能の維持_改善の見通し));
        entity.setIk_homonShinryoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.訪問診療));
        entity.setIk_tankiNyushoRyoyoKaigoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.短期入所療養介護));
        entity.setIk_homonEiyoShokujiShidoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.訪問栄養食事指導));
        entity.setIk_homonKangoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.訪問看護));
        entity.setIk_homonShikaShinryoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.訪問歯科診療));
        entity.setIk_homonRihabilitationUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.訪問リハビリテーション));
        entity.setIk_homonShikaEiseiShidoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.訪問歯科衛生指導));
        entity.setIk_tushoRihabilitationUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.通所リハビリテーション));
        entity.setIk_homonYakuzaiKanriShidoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.訪問薬剤管理指導));
        entity.setIk_sonotaIgakutekiKanriUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.その他医学的管理));
        entity.setIk_ryuiJikoKetsuatsuUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.血圧));
        entity.setIk_ryuiJikoKetsuatsu(editor.getResultByString(ShujiiIkenshoItemKubun.血圧内容));
        entity.setIk_ryuiJikoSesshokuUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.摂食));
        entity.setIk_ryuiJikoSesshoku(editor.getResultByString(ShujiiIkenshoItemKubun.摂食内容));
        entity.setIk_ryuiJikoEngeUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.嚥下));
        entity.setIk_ryuiJikoEnge(editor.getResultByString(ShujiiIkenshoItemKubun.嚥下内容));
        entity.setIk_ryuiJikoIdoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.移動));
        entity.setIk_ryuiJikoIdo(editor.getResultByString(ShujiiIkenshoItemKubun.移動内容));
        entity.setIk_ryuiJikoUndoUmuKubun(editor.getResultByBool(ShujiiIkenshoItemKubun.運動));
        entity.setIk_ryuiJikoUndo(editor.getResultByString(ShujiiIkenshoItemKubun.運動内容));
        entity.setIk_ryuiJikoSonota(editor.getResultByString(ShujiiIkenshoItemKubun.その他留意事項));
        entity.setIk_kansenshoUmu(editor.getResultByString(ShujiiIkenshoItemKubun.感染症));
        entity.setIk_kansenshoShojo(editor.getResultByString(ShujiiIkenshoItemKubun.感染症内容));
        entity.setIk_tokkiJiko(editor.getResultByString(ShujiiIkenshoItemKubun.特記事項));
        entity.setIk_kangoShokuiHomonUmu(editor.getResultByString(ShujiiIkenshoItemKubun.看護職員の訪問による相談_支援));
        return entity;
    }

    private static ShujiiIkenshoBase toShujiiIkenshoBase(ShujiiIkenshoEntity shujiiIkenshoEntity, KaigoDoctor kaigoDoctor) {
        DbT5012ShujiiIkenshoJohoEntity entity = shujiiIkenshoEntity.getDbT5012ShujiiIkenshoJohoEntity();
        return new ShujiiIkenshoBase(
                entity.getShinseishoKanriNo(),
                new IkenshosakuseiIraiRirekiNo(entity.getIkenshoIraiRirekiNo()),
                ShujiiIkenshoIraiKubun.toValue(entity.getIkenshoIraiKubun()),
                kaigoDoctor,
                entity.getIkenshoJuryoYMD(),
                entity.getIkenshoKinyuYMD(),
                ShujiiIkenshoSakuseiKaisu.toValue(entity.getIkenshoSakuseiKaisu()),
                ShujiiIkenshoSakuseiryoShubetsu.toValue(entity.getIkenshoSakuseiryoShubetsu()),
                NinteiJohoTeikyoKibo.toValue(entity.getNinteiJohoTeikyoKiboFlag()),
                IkenshoDoi.toValue(entity.getIkenshoDoiUmuFlag()));
    }

    private static ShujiiIkenshoDetails toShujiiIkenshoDetails(ShujiiIkenshoEntity shujiiIkenshoEntity) {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = shujiiIkenshoEntity.getDbT5013ShujiiIkenshoShosaiJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        ShujiiIkenshoEditor editor = new ShujiiIkenshoEditor(ShujiiIkenshoFactory.create主治医意見書Instance(koroshoIFKubun));
        editor.setResult(ShujiiIkenshoItemKubun.診断名1, entity.getIk_shindamMei1());
        editor.setResult(ShujiiIkenshoItemKubun.発症年月日1, new RString(entity.getIk_hasshoYMD1().toString()));
        editor.setResult(ShujiiIkenshoItemKubun.診断名2, entity.getIk_shindamMei2());
        editor.setResult(ShujiiIkenshoItemKubun.発症年月日2, new RString(entity.getIk_hasshoYMD2().toString()));
        editor.setResult(ShujiiIkenshoItemKubun.診断名3, entity.getIk_shindamMei3());
        editor.setResult(ShujiiIkenshoItemKubun.発症年月日3, new RString(entity.getIk_hasshoYMD3().toString()));
        editor.setResult(ShujiiIkenshoItemKubun.症状の安定性, entity.getIk_anteisei());
        editor.setResult(ShujiiIkenshoItemKubun.具体的な状況, entity.getIk_anteiseiHuanteiJokyo());
        editor.setResult(ShujiiIkenshoItemKubun.治療内容, entity.getIk_chiryoNaiyo());
        editor.setResult(ShujiiIkenshoItemKubun.点滴の管理, entity.getIk_tokubetsuIryoTentekiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.中心静脈栄養, entity.getIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.透析, entity.getIk_tokubetsuIryoTosekiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.ストーマの処置, entity.getIk_tokubetsuIryoStomaShochiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.酸素療法, entity.getIk_tokubetsuIryoSansoRyohoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.レスピレーター, entity.getIk_tokubetsuIryoRespiratorUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.気管切開の処置, entity.getIk_tokubetsuIryoKikanSekkaiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.疼痛の看護, entity.getIk_tokubetsuIryoTotsuKangoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.経管栄養, entity.getIk_tokubetsuIryoKeikanEiyoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.モニター測定, entity.getIk_tokubetsuIryoMonitorSokuteiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.褥瘡の処置, entity.getIk_tokubetsuIryoJokusoShochiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.カテーテル, entity.getIk_tokubetsuIryoCatheterUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.障害高齢者日常生活自立度, entity.getIk_seikatsuJiritsudoShyogaiCode().value());
        editor.setResult(ShujiiIkenshoItemKubun.認知症高齢者日常生活自立度, entity.getIk_seikatsuJiritsudoNinchshoCode().value());
        editor.setResult(ShujiiIkenshoItemKubun.短期記憶, entity.getIk_chukakuShojoTankiKioku());
        editor.setResult(ShujiiIkenshoItemKubun.認知能力, entity.getIk_chukakuShojoNinchiNoryoku());
        editor.setResult(ShujiiIkenshoItemKubun.伝達能力, entity.getIk_chukakuShojoDentatsuNoryoku());
        editor.setResult(ShujiiIkenshoItemKubun.認知症の周辺症状, entity.getIk_shuhenShojoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.幻視幻聴, entity.getIk_shuhenShojoGenshiGenchoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.妄想, entity.getIk_shuhenShojoMosoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.昼夜逆転, entity.getIk_shuhenShojoChuyaGakutenUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.暴言, entity.getIk_shuhenShojoBogenUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.暴行, entity.getIk_shuhenShojoBokoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.介護への抵抗, entity.getIk_shuhenShojoKaigoHenoTeikoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.認知症_徘徊, entity.getIk_shuhenShojoHaikaiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.火の不始末, entity.getIk_shuhenShojoHiNoFushimatsuUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.不潔行為, entity.getIk_shuhenShojoFuketsuKoiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.異食行動, entity.getIk_shuhenShojoIshokuKodoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.性的問題行動, entity.getIk_shuhenShojoSeitekiMondaiKodoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.認知症_その他, entity.getIk_shuhenShojoSonotaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.認知症_その他内容, entity.getIk_shuhenShojoSonotaNaiyo());
        editor.setResult(ShujiiIkenshoItemKubun.精神_神経症状, entity.getIk_seishinOrShinkeiShojoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.精神_神経症状名, entity.getIk_seishinOrShinkeiShojoShimei());
        editor.setResult(ShujiiIkenshoItemKubun.専門科医受診, entity.getIk_semmonkaiJushinUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.専門科医受診内容, entity.getIk_semmonkaiJushin());
        editor.setResult(ShujiiIkenshoItemKubun.利き腕, entity.getIk_kikiudeKubun());
        editor.setResult(ShujiiIkenshoItemKubun.身長, entity.getIk_shincho());
        editor.setResult(ShujiiIkenshoItemKubun.体重, entity.getIk_taiju());
        editor.setResult(ShujiiIkenshoItemKubun.体重の変化, entity.getIk_taijuHenka());
        editor.setResult(ShujiiIkenshoItemKubun.四肢欠損, entity.getIk_shishiKessonUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.四肢欠損部位, entity.getIk_shishiKessonBui());
        editor.setResult(ShujiiIkenshoItemKubun.四肢欠損程度, entity.getIk_shishiKessonTeido());
        editor.setResult(ShujiiIkenshoItemKubun.麻痺, entity.getIk_mahiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.麻痺程度, entity.getIk_mahiTeido());
        editor.setResult(ShujiiIkenshoItemKubun.麻痺_左上肢, entity.getIk_mahiHidariJoshi());
        editor.setResult(ShujiiIkenshoItemKubun.麻痺_右上肢, entity.getIk_mahiMigiJoshi());
        editor.setResult(ShujiiIkenshoItemKubun.麻痺_左下肢, entity.getIk_mahiHidariKashi());
        editor.setResult(ShujiiIkenshoItemKubun.麻痺_右下肢, entity.getIk_mahiMigiKashi());
        editor.setResult(ShujiiIkenshoItemKubun.麻痺_その他, entity.getIk_mahiSonota());
        editor.setResult(ShujiiIkenshoItemKubun.筋力低下, entity.getIk_kinryokuTeikaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.筋力低下部位, entity.getIk_kinryokuTeikaBui());
        editor.setResult(ShujiiIkenshoItemKubun.筋力低下程度, entity.getIk_kinryokuTeikaTeido());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_右肩, entity.getIk_koshukuMigiKataUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_左肩, entity.getIk_koshukuHidariKataUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_右肘, entity.getIk_koshukuMigiHijiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_左肘, entity.getIk_koshukuHidariHijiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_右股, entity.getIk_koshukuMigiMataUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_左股, entity.getIk_koshukuHidariMataUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_右膝, entity.getIk_koshukuMigiHizaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮_左膝, entity.getIk_koshukuHidariHizaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の拘縮程度, entity.getIk_kansetsuKoshukuTeido());
        editor.setResult(ShujiiIkenshoItemKubun.関節の痛み, entity.getIk_kansetsuItamiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.関節の痛み部位, entity.getIk_kansetsuItamiBui());
        editor.setResult(ShujiiIkenshoItemKubun.関節の痛み程度, entity.getIk_kansatsuItamiTeido());
        editor.setResult(ShujiiIkenshoItemKubun.失調不随意, entity.getIk_huzuiiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.失調不随意_右上肢, entity.getIk_huzuiiMigiJoshiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.失調不随意_左上肢, entity.getIk_huzuiiHidariJoshiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.失調不随意_右体幹, entity.getIk_huzuiiMigiTaikanUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.失調不随意_左体幹, entity.getIk_huzuiiHidariTaikanUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.失調不随意_右下肢, entity.getIk_huzuiiMigiKashiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.失調不随意_左下肢, entity.getIk_huzuiiHidariKashiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.じょくそう, entity.getIk_jokusoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.じょくそう部位, entity.getIk_jokusoBui());
        editor.setResult(ShujiiIkenshoItemKubun.じょくそう程度, entity.getIk_jokusoTeido());
        editor.setResult(ShujiiIkenshoItemKubun.その他皮膚疾患, entity.getIk_sonotaHifuShikkanUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.その他皮膚疾患部位, entity.getIk_sonotaHifuShikkkanBui());
        editor.setResult(ShujiiIkenshoItemKubun.その他皮膚疾患程度, entity.getIk_sonotaHifushikkanTeido());
        editor.setResult(ShujiiIkenshoItemKubun.屋外歩行, entity.getIk_idoOkugaiHoko());
        editor.setResult(ShujiiIkenshoItemKubun.車椅子の使用, entity.getIk_idoKurumaisu());
        editor.setResult(ShujiiIkenshoItemKubun.歩行補助具_装具未使用, entity.getIk_idoHokohojoguMishiyo());
        editor.setResult(ShujiiIkenshoItemKubun.歩行補助具_装具屋外使用, entity.getIk_idoHokohojoguOkugai());
        editor.setResult(ShujiiIkenshoItemKubun.歩行補助具_装具屋内使用, entity.getIk_idoHokohojoguOkunai());
        editor.setResult(ShujiiIkenshoItemKubun.食事行為, entity.getIk_shokuseikatsuShokujiKoi());
        editor.setResult(ShujiiIkenshoItemKubun.現在の栄養状態, entity.getIk_shokuseikatsuEiyoJotai());
        editor.setResult(ShujiiIkenshoItemKubun.栄養_食生活留意点, entity.getIk_shokuseikatsuRyuiten());
        editor.setResult(ShujiiIkenshoItemKubun.尿失禁, entity.getIk_probabilityNyoShikkinUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.転倒_骨折, entity.getIk_probabilityTentoOrKossetsuUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.移動能力の低下, entity.getIk_probabilityIdoNoryokuTeikaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.褥瘡, entity.getIk_probabilityJokusoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.閉じこもり, entity.getIk_probabilityTojikomoriUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.意欲低下, entity.getIk_probabilitiyIyokuTeikaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.徘徊, entity.getIk_probabilityHaikaiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.低栄養, entity.getIk_probabilityTeiEiyoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.摂食_嚥下機能低下, entity.getIk_probabilitySesshokuEngiKinoTeikaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.脱水, entity.getIk_probabilityDassuiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.易感染症, entity.getIk_probabilityIkansenshoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.がん等による疼痛, entity.getIk_probabilityTotsuUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.その他状態, entity.getIk_probabilitySonotaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.その他状態内容, entity.getIk_probabilitySonotaNaiyo());
        editor.setResult(ShujiiIkenshoItemKubun.嚥下性肺炎, entity.getIk_probabilityEngeseiHaienUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.腸閉塞, entity.getIk_probabilityChoHeisokuUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.心肺機能の低下, entity.getIk_probabilityShinpaiKinoTeikaUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.痛み, entity.getIk_probabilityItamiUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.状態対処方針, entity.getIk_probabilityTaisho());
        editor.setResult(ShujiiIkenshoItemKubun.介護の必要な程度に関する予後の見直し, entity.getIk_yogoMitoshi());
        editor.setResult(ShujiiIkenshoItemKubun.サービス利用による生活機能の維持_改善の見通し, entity.getIk_ijiKaizenMitoshi());
        editor.setResult(ShujiiIkenshoItemKubun.訪問診療, entity.getIk_homonShinryoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.短期入所療養介護, entity.getIk_tankiNyushoRyoyoKaigoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.訪問栄養食事指導, entity.getIk_homonEiyoShokujiShidoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.訪問看護, entity.getIk_homonKangoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.訪問歯科診療, entity.getIk_homonShikaShinryoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.訪問リハビリテーション, entity.getIk_homonRihabilitationUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.訪問歯科衛生指導, entity.getIk_homonShikaEiseiShidoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.通所リハビリテーション, entity.getIk_tushoRihabilitationUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.訪問薬剤管理指導, entity.getIk_homonYakuzaiKanriShidoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.その他医学的管理, entity.getIk_sonotaIgakutekiKanriUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.血圧, entity.getIk_ryuiJikoKetsuatsuUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.血圧内容, entity.getIk_ryuiJikoKetsuatsu());
        editor.setResult(ShujiiIkenshoItemKubun.摂食, entity.getIk_ryuiJikoSesshokuUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.摂食内容, entity.getIk_ryuiJikoSesshoku());
        editor.setResult(ShujiiIkenshoItemKubun.嚥下, entity.getIk_ryuiJikoEngeUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.嚥下内容, entity.getIk_ryuiJikoEnge());
        editor.setResult(ShujiiIkenshoItemKubun.移動, entity.getIk_ryuiJikoIdoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.移動内容, entity.getIk_ryuiJikoIdo());
        editor.setResult(ShujiiIkenshoItemKubun.運動, entity.getIk_ryuiJikoUndoUmuKubun());
        editor.setResult(ShujiiIkenshoItemKubun.運動内容, entity.getIk_ryuiJikoUndo());
        editor.setResult(ShujiiIkenshoItemKubun.その他留意事項, entity.getIk_ryuiJikoSonota());
        editor.setResult(ShujiiIkenshoItemKubun.感染症, entity.getIk_kansenshoUmu());
        editor.setResult(ShujiiIkenshoItemKubun.感染症内容, entity.getIk_kansenshoShojo());
        editor.setResult(ShujiiIkenshoItemKubun.特記事項, entity.getIk_tokkiJiko());
        editor.setResult(ShujiiIkenshoItemKubun.看護職員の訪問による相談_支援, entity.getIk_kangoShokuiHomonUmu());
        return new ShujiiIkenshoDetails(
                entity.getShinseishoKanriNo(), new IkenshosakuseiIraiRirekiNo(entity.getIkenshoIraiRirekiNo()), koroshoIFKubun, editor.getShujiiIkensho());
    }
}
