/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ChoiceItem;
import jp.co.ndensan.reams.db.dbe.business.core.InputItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemSubGroupOf2009;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の定義（2009年改訂版）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
class ShujiiIkenshoRegulationOf2009 implements IShujiiIkenshoRegulation {

    private static final Map<ShujiiIkenshoItemKubun, IShujiiIkenshoItem> 意見書定義;
    private static final RString その他 = new RString("その他");
    private static final ShujiiIkenshoRegulationBuilder builder;

    static {
        意見書定義 = new EnumMap<>(ShujiiIkenshoItemKubun.class);
        builder = new ShujiiIkenshoRegulationBuilder(意見書定義);
        initialize();
    }

    private static void initializeShobyo() {
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.傷病, ShujiiIkenshoItemSubGroupOf2009.診断名_発症年月日);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.診断名1, "１．診断名", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.発症年月日1, "発症年月日", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.診断名2, "２．診断名", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.発症年月日2, "発症年月日", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.診断名3, "３．診断名", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.発症年月日3, "発症年月日", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.傷病, ShujiiIkenshoItemSubGroupOf2009.安定性);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.症状の安定性, "", new ChoiceItem(ChoiceResultItem.Antei.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.具体的な状況, "", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.傷病, ShujiiIkenshoItemSubGroupOf2009.傷病_治療内容);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.治療内容, "", new InputItem());
    }

    private static void initializeTokubetsuIryo() {
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.特別医療, ShujiiIkenshoItemSubGroupOf2009.処置内容);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.点滴の管理, "点滴の管理", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.中心静脈栄養, "中心静脈栄養", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.透析, "透析", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.ストーマの処置, "ストーマの処置", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.酸素療法, "酸素療法", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.レスピレーター, "レスピレーター", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.気管切開の処置, "気管切開の処置", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.疼痛の看護, "疼痛の看護", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.経管栄養, "経管栄養", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.特別医療, ShujiiIkenshoItemSubGroupOf2009.特別対応);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.モニター測定, "モニター測定（血圧、心拍、酸素飽和度等）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.褥瘡の処置, "褥瘡の処置", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.特別医療, ShujiiIkenshoItemSubGroupOf2009.失禁対応);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.カテーテル, "カテーテル（コンドームカテーテル、留置カテーテル 等）", new ChoiceItem(ChoiceResultItem.Checked.values()));
    }

    private static void initialize() {
        initializeShobyo();
        initializeTokubetsuIryo();
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.心身状態, ShujiiIkenshoItemSubGroupOf2009.自立度);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.障害高齢者日常生活自立度, "障害高齢者の日常生活自立度(寝たきり度)", new ChoiceItem(ChoiceResultItem.ShogaiJiritsu.values()));
        builder.set主要意見書項目("", ShujiiIkenshoItemKubun.認知症高齢者日常生活自立度, "認知症高齢者の日常生活自立度", new ChoiceItem(ChoiceResultItem.NinchishoJiritsu.values()));
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.心身状態, ShujiiIkenshoItemSubGroupOf2009.中核症状);
        builder.set主要意見書項目("", ShujiiIkenshoItemKubun.短期記憶, "短期記憶", new ChoiceItem(ChoiceResultItem.MondaiNashiAri.values()));
        builder.set主要意見書項目("", ShujiiIkenshoItemKubun.認知能力, "日常の意思決定を行うための認知能力", new ChoiceItem(ChoiceResultItem.Ninchi.values()));
        builder.set主要意見書項目("", ShujiiIkenshoItemKubun.伝達能力, "自分の意思の伝達能力", new ChoiceItem(ChoiceResultItem.Dentatsu.values()));
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.心身状態, ShujiiIkenshoItemSubGroupOf2009.周辺症状);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.認知症の周辺症状, "", new ChoiceItem(ChoiceResultItem.NashiAri.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.幻視幻聴, "幻視･幻聴", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.妄想, "妄想", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.昼夜逆転, "昼夜逆転", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.暴言, "暴言", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.暴行, "暴行", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.介護への抵抗, "介護への抵抗", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.認知症_徘徊, "徘徊", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.火の不始末, "火の不始末", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.不潔行為, "不潔行為", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.異食行動, "異食行動", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.性的問題行動, "性的問題行動", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.認知症_その他, その他.toString(), new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.認知症_その他内容, "", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.心身状態, ShujiiIkenshoItemSubGroupOf2009.精神_神経症状);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.精神_神経症状, "", new ChoiceItem(ChoiceResultItem.NashiAri.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.精神_神経症状名, "症状名", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.専門科医受診, "", new ChoiceItem(ChoiceResultItem.AriNashi.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.専門科医受診内容, "", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.心身状態, ShujiiIkenshoItemSubGroupOf2009.身体状態);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.利き腕, "利き腕", new ChoiceItem(ChoiceResultItem.MigiHidari.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.身長, "身長", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.体重, "体重", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.体重の変化, "過去６ヶ月の体重の変化", new ChoiceItem(ChoiceResultItem.ZokaGensho.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.四肢欠損, "四肢欠損", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.四肢欠損部位, "部位", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.四肢欠損程度, "程度", new ChoiceItem(ChoiceResultItem.Teido.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.麻痺, "麻痺", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.麻痺_右上肢, "右上肢", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.麻痺_左上肢, "左上肢", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.麻痺_右下肢, "右下肢", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.麻痺_左下肢, "左下肢", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.麻痺_その他, その他.toString(), new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.麻痺程度, "程度", new ChoiceItem(ChoiceResultItem.Teido.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.筋力低下, "筋力の低下", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.筋力低下部位, "部位", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.筋力低下程度, "程度", new ChoiceItem(ChoiceResultItem.Teido.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_右肩, "右肩", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_左肩, "左肩", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_右肘, "右肘", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_左肘, "左肘", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_右股, "右股", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_左股, "左股", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_右膝, "右膝", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮_左膝, "左膝", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の拘縮程度, "程度", new ChoiceItem(ChoiceResultItem.Teido.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の痛み, "関節の痛み", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の痛み部位, "部位", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.関節の痛み程度, "程度", new ChoiceItem(ChoiceResultItem.Teido.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.失調不随意, "失調不随意", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.失調不随意_右上肢, "右", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.失調不随意_左上肢, "左", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.失調不随意_右下肢, "右", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.失調不随意_左下肢, "左", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.失調不随意_右体幹, "右", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.失調不随意_左体幹, "左", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.じょくそう, "褥瘡", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.じょくそう部位, "部位", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.じょくそう程度, "程度", new ChoiceItem(ChoiceResultItem.Teido.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.その他皮膚疾患, "その他の皮膚疾患", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.その他皮膚疾患部位, "部位", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.その他皮膚疾患程度, "程度", new ChoiceItem(ChoiceResultItem.Teido.values()));
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.生活機能_サービス, ShujiiIkenshoItemSubGroupOf2009.移動);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.屋外歩行, "屋外歩行", new ChoiceItem(ChoiceResultItem.Kaijo4.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.車椅子の使用, "車椅子の使用", new ChoiceItem(ChoiceResultItem.Kurumaisu.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.歩行補助具_装具未使用, "用いていない", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.歩行補助具_装具屋外使用, "屋外で使用", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.歩行補助具_装具屋内使用, "屋内で使用", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.生活機能_サービス, ShujiiIkenshoItemSubGroupOf2009.栄養_食生活);
        builder.set主要意見書項目("", ShujiiIkenshoItemKubun.食事行為, "食事行為", new ChoiceItem(ChoiceResultItem.Shokuji.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.現在の栄養状態, "現在の栄養状態", new ChoiceItem(ChoiceResultItem.Jotai.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.栄養_食生活留意点, "栄養･食生活上の留意点", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.生活機能_サービス, ShujiiIkenshoItemSubGroupOf2009.状態_対処方針);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.尿失禁, "尿失禁", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.転倒_骨折, "転倒・骨折", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.移動能力の低下, "移動能力の低下", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.褥瘡, "褥瘡", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.心肺機能の低下, "心肺機能の低下", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.閉じこもり, "閉じこもり", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.意欲低下, "意欲低下", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.徘徊, "徘徊", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.低栄養, "低栄養", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.摂食_嚥下機能低下, "摂食・嚥下機能低下", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.脱水, "脱水", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.易感染症, "易感染症", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.がん等による疼痛, "がん等による疼痛", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.その他状態, その他.toString(), new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.その他状態内容, その他.toString(), new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.状態対処方針, "対処方針", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.生活機能_サービス, ShujiiIkenshoItemSubGroupOf2009.維持_改善見通し);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.介護の必要な程度に関する予後の見直し, "", new ChoiceItem(ChoiceResultItem.Kitai.values()));
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.生活機能_サービス, ShujiiIkenshoItemSubGroupOf2009.管理の必要性);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.訪問診療, "訪問診療", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.訪問看護, "訪問看護", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.看護職員の訪問による相談_支援, "看護職員の訪問による相談・支援", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.訪問歯科診療, "訪問歯科診療", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.訪問薬剤管理指導, "訪問薬剤管理指導", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.訪問リハビリテーション, "訪問リハビリテーション", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.短期入所療養介護, "短期入所療養介護", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.訪問歯科衛生指導, "訪問歯科衛生指導", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.訪問栄養食事指導, "訪問栄養食事指導", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.通所リハビリテーション, "通所リハビリテーション", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.その他医学的管理, "その他の医療系サービス", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.生活機能_サービス, ShujiiIkenshoItemSubGroupOf2009.留意事項);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.血圧, "血圧", new ChoiceItem(ChoiceResultItem.NashiAri3.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.血圧内容, "", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.移動, "移動", new ChoiceItem(ChoiceResultItem.NashiAri3.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.移動内容, "", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.摂食, "摂食", new ChoiceItem(ChoiceResultItem.NashiAri3.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.摂食内容, "", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.運動, "運動", new ChoiceItem(ChoiceResultItem.NashiAri3.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.運動内容, "", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.嚥下, "嚥下", new ChoiceItem(ChoiceResultItem.NashiAri3.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.嚥下内容, "", new InputItem());
        builder.set意見書項目("", ShujiiIkenshoItemKubun.その他留意事項, "", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.生活機能_サービス, ShujiiIkenshoItemSubGroupOf2009.感染症);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.感染症, "感染症", new ChoiceItem(ChoiceResultItem.NashiAri2.values()));
        builder.set意見書項目("", ShujiiIkenshoItemKubun.感染症内容, "", new InputItem());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroupOf2009.特記事項, ShujiiIkenshoItemSubGroup.なし);
        builder.set意見書項目("", ShujiiIkenshoItemKubun.特記事項, "", new InputItem());
    }

    @Override
    public Map<ShujiiIkenshoItemKubun, IShujiiIkenshoItem> get意見書定義() {
        return new EnumMap<>(意見書定義);
    }
}
