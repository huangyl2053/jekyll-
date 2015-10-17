/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ChoiceItem;
import jp.co.ndensan.reams.db.dbe.business.core.InputItem;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.chosahyo.NinteichosaItemGroupOf2006;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.chosahyo.NinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.chosahyo.NinteichosaItemSubGroupOf2006;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査票定義（2006年改訂版）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
class NinteichosahyoRegulationOf2006 implements INinteichosahyoRegulation {

    private static final Map<NinteichosaItemKubunOfGaikyo, INinteichosaItem> サービス状況調査定義;
    private static final Map<NinteichosaItemKubunOfKihon, INinteichosaItem> 基本調査定義;

    static {
        サービス状況調査定義 = new EnumMap<>(NinteichosaItemKubunOfGaikyo.class);
        基本調査定義 = new EnumMap<>(NinteichosaItemKubunOfKihon.class);
        initializeサービス状況調査定義();
        initialize基本調査定義();
    }

    private static void initializeサービス状況調査定義() {
        NinteichosahyoRegulationBuilder builder = new NinteichosahyoRegulationBuilder(サービス状況調査定義);
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.サービス状況, NinteichosaItemSubGroup.なし);
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問介護, "訪問介護(ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ)", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問入浴介護, "訪問入浴介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問看護, "訪問看護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問リハビリ, "訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.居宅療養管理指導, "居宅療養管理指導", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.通所介護, "通所介護(ﾃﾞｲｻｰﾋﾞｽ)", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.通所リハビリテーション, "通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ(ﾃﾞｲｹｱ)", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.短期入所生活介護, "短期入所生活介護(特養等)", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.短期入所療養介護, "短期入所療養介護(老健・診療所)", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.特定施設入居者生活介護, "特定施設入居者生活介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.福祉用具貸与, "福祉用具貸与", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.特定福祉用具販売, "特定福祉用具販売", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.夜間対応型訪問介護, "夜間対応型訪問介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.認知症対応型通所介護, "認知症対応型通所介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.小規模多機能型居宅介護, "小規模多機能型居宅介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.認知症対応型共同生活介護, "認知症対応型共同生活介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.地域密着型特定施設入居者生活介護, "地域密着型特定施設入居者生活介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.地域密着型介護老人福祉施設入所者生活介護, "地域密着型介護老人福祉施設入所者生活介護", new InputItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.住宅改修, "住宅改修", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.概況特記事項, NinteichosaItemSubGroup.なし);
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.概況特記事項, "", new InputItem());
    }

    private static void initialize基本調査定義() {
        final RString 麻痺番号 = new RString("1-1");
        final RString 拘縮番号 = new RString("1-2");
        NinteichosahyoRegulationBuilder builder = new NinteichosahyoRegulationBuilder(基本調査定義);
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第１群, NinteichosaItemSubGroupOf2006.麻痺);
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢, "（左－上肢）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢, "（右－上肢）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_左下肢, "（左－下肢）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_右下肢, "（右－下肢）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_その他, "（その他）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第１群, NinteichosaItemSubGroupOf2006.拘縮);
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節, "（肩関節）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肘関節, "（肘関節）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_股関節, "（股関節）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_膝関節, "（膝関節）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_足関節, "（足関節）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_その他, "（その他）", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第２群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("2-1", NinteichosaItemKubunOfKihon.寝返り, "寝返り", new ChoiceItem(ChoiceResultItem.DekiruDekinai3.values()));
        builder.set調査項目("2-2", NinteichosaItemKubunOfKihon.起き上がり, "起き上がり", new ChoiceItem(ChoiceResultItem.DekiruDekinai3.values()));
        builder.set調査項目("2-3", NinteichosaItemKubunOfKihon.座位保持, "座位保持", new ChoiceItem(ChoiceResultItem.DekiruDekinai6.values()));
        builder.set調査項目("2-4", NinteichosaItemKubunOfKihon.両足での立位, "両足での立位", new ChoiceItem(ChoiceResultItem.DekiruDekinai5.values()));
        builder.set調査項目("2-5", NinteichosaItemKubunOfKihon.歩行, "歩　行", new ChoiceItem(ChoiceResultItem.DekiruDekinai3.values()));
        builder.set調査項目("2-6", NinteichosaItemKubunOfKihon.移乗, "移　乗", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目("2-7", NinteichosaItemKubunOfKihon.移動, "移　動", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第３群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("3-1", NinteichosaItemKubunOfKihon.立ち上がり, "立ち上がり", new ChoiceItem(ChoiceResultItem.DekiruDekinai3.values()));
        builder.set調査項目("3-2", NinteichosaItemKubunOfKihon.片足での立位, "片足での立位", new ChoiceItem(ChoiceResultItem.DekiruDekinai5.values()));
        builder.set調査項目("3-3", NinteichosaItemKubunOfKihon.洗身, "洗　身", new ChoiceItem(ChoiceResultItem.Kaijo2.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第４群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("4-1-ア", NinteichosaItemKubunOfKihon.じょくそう, "じょくそう", new ChoiceItem(ChoiceResultItem.NaiAru.values()));
        builder.set調査項目("4-1-イ", NinteichosaItemKubunOfKihon.他の皮膚疾患, "皮膚疾患", new ChoiceItem(ChoiceResultItem.NaiAru.values()));
        builder.set調査項目("4-2", NinteichosaItemKubunOfKihon.嚥下, "えん下", new ChoiceItem(ChoiceResultItem.DekiruDekinai4.values()));
        builder.set調査項目("4-3", NinteichosaItemKubunOfKihon.食事摂取, "食事摂取", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目("4-4", NinteichosaItemKubunOfKihon.飲水摂取, "飲　水", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目("4-5", NinteichosaItemKubunOfKihon.排尿, "排　尿", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目("4-6", NinteichosaItemKubunOfKihon.排便, "排　便", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第５群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("5-1-ア", NinteichosaItemKubunOfKihon.口腔清潔, "口腔清潔", new ChoiceItem(ChoiceResultItem.Kaijo.values()));
        builder.set調査項目("5-1-イ", NinteichosaItemKubunOfKihon.洗顔, "洗　顔", new ChoiceItem(ChoiceResultItem.Kaijo.values()));
        builder.set調査項目("5-1-ウ", NinteichosaItemKubunOfKihon.整髪, "整　髪", new ChoiceItem(ChoiceResultItem.Kaijo.values()));
        builder.set調査項目("5-1-エ", NinteichosaItemKubunOfKihon.つめ切り, "つめ切り", new ChoiceItem(ChoiceResultItem.Kaijo.values()));
        builder.set調査項目("5-2-ア", NinteichosaItemKubunOfKihon.上衣の着脱, "上衣の着脱", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目("5-2-イ", NinteichosaItemKubunOfKihon.ズボン等の着脱, "ズボン等の着脱", new ChoiceItem(ChoiceResultItem.Kaijo3.values()));
        builder.set調査項目("5-3", NinteichosaItemKubunOfKihon.薬の内服, "薬の内服", new ChoiceItem(ChoiceResultItem.Kaijo.values()));
        builder.set調査項目("5-4", NinteichosaItemKubunOfKihon.金銭の管理, "金銭の管理", new ChoiceItem(ChoiceResultItem.Kaijo.values()));
        builder.set調査項目("5-5", NinteichosaItemKubunOfKihon.電話の利用, "電話の利用", new ChoiceItem(ChoiceResultItem.Kaijo.values()));
        builder.set調査項目("5-6", NinteichosaItemKubunOfKihon.日常の意思決定, "日常の意思決定", new ChoiceItem(ChoiceResultItem.DekiruDekinai7.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第６群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("6-1", NinteichosaItemKubunOfKihon.視力, "視　力", new ChoiceItem(ChoiceResultItem.Shiryoku.values()));
        builder.set調査項目("6-2", NinteichosaItemKubunOfKihon.聴力, "聴　力", new ChoiceItem(ChoiceResultItem.Choryoku.values()));
        builder.set調査項目("6-3", NinteichosaItemKubunOfKihon.意思の伝達, "意思の伝達", new ChoiceItem(ChoiceResultItem.DekiruDekinai2.values()));
        builder.set調査項目("6-4", NinteichosaItemKubunOfKihon.指示への反応, "指示への反応", new ChoiceItem(ChoiceResultItem.Shiji.values()));
        builder.set調査項目("6-5-ア", NinteichosaItemKubunOfKihon.毎日の日課を理解, "毎日の日課を理解", new ChoiceItem(ChoiceResultItem.DekiruDekinai.values()));
        builder.set調査項目("6-5-イ", NinteichosaItemKubunOfKihon.生年月日をいう, "生年月日をいう", new ChoiceItem(ChoiceResultItem.DekiruDekinai.values()));
        builder.set調査項目("6-5-ウ", NinteichosaItemKubunOfKihon.短期記憶, "短期記憶", new ChoiceItem(ChoiceResultItem.DekiruDekinai.values()));
        builder.set調査項目("6-5-エ", NinteichosaItemKubunOfKihon.自分の名前をいう, "自分の名前をいう", new ChoiceItem(ChoiceResultItem.DekiruDekinai.values()));
        builder.set調査項目("6-5-オ", NinteichosaItemKubunOfKihon.今の季節を理解, "今の季節を理解", new ChoiceItem(ChoiceResultItem.DekiruDekinai.values()));
        builder.set調査項目("6-5-カ", NinteichosaItemKubunOfKihon.場所の理解, "場所の理解", new ChoiceItem(ChoiceResultItem.DekiruDekinai.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.第７群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("7-ア", NinteichosaItemKubunOfKihon.被害的, "被害的", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-イ", NinteichosaItemKubunOfKihon.作話, "作　話", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-ウ", NinteichosaItemKubunOfKihon.幻視幻聴, "幻視幻聴", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-エ", NinteichosaItemKubunOfKihon.感情が不安定, "感情が不安定", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-オ", NinteichosaItemKubunOfKihon.昼夜逆転, "昼夜逆転", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-カ", NinteichosaItemKubunOfKihon.暴言暴行, "暴言暴行", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-キ", NinteichosaItemKubunOfKihon.同じ話をする, "同じ話をする", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-ク", NinteichosaItemKubunOfKihon.大声を出す, "大声を出す", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-ケ", NinteichosaItemKubunOfKihon.介護に抵抗, "介護に抵抗", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-コ", NinteichosaItemKubunOfKihon.常時の徘徊, "常時の徘徊", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-サ", NinteichosaItemKubunOfKihon.落ち着きなし, "落ち着きなし", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-シ", NinteichosaItemKubunOfKihon.外出して戻れない, "外出して戻れない", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-ス", NinteichosaItemKubunOfKihon.一人で出たがる, "一人で出たがる", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-セ", NinteichosaItemKubunOfKihon.収集癖, "収集癖", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-ソ", NinteichosaItemKubunOfKihon.火の不始末, "火の不始末", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-タ", NinteichosaItemKubunOfKihon.物や衣類を壊す, "物や衣類を壊す", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-チ", NinteichosaItemKubunOfKihon.不潔行為, "不潔行為", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-ツ", NinteichosaItemKubunOfKihon.異食行動, "異食行動", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目("7-テ", NinteichosaItemKubunOfKihon.ひどい物忘れ, "ひどい物忘れ", new ChoiceItem(ChoiceResultItem.NaiAru2.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.特別医療, NinteichosaItemSubGroup.なし);
        builder.set調査項目("", NinteichosaItemKubunOfKihon.点滴の管理, "点滴の管理", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.中心静脈栄養, "中心静脈栄養", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.透析, "透析", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.ストーマの処置, "ストーマの処置", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.酸素療法, "酸素療法", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.レスピレーター, "レスピレーター", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.気管切開, "気管切開の処置", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.疼痛の看護, "疼痛の看護", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.経管栄養, "経管栄養", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.モニター測定, "モニター測定", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.じょくそうの処置, "じょくそうの処置", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.カテーテル, "カテーテル", new ChoiceItem(ChoiceResultItem.Checked.values()));
        builder.set調査項目グループ(NinteichosaItemGroupOf2006.自立度, NinteichosaItemSubGroup.なし);
        builder.set調査項目("", NinteichosaItemKubunOfKihon.認知症高齢者の日常生活自立度, "認知症高齢者自立度", new ChoiceItem(ChoiceResultItem.NinchishoJiritsu.values()));
        builder.set調査項目("", NinteichosaItemKubunOfKihon.障害高齢者の日常生活自立度, "障害高齢者自立度", new ChoiceItem(ChoiceResultItem.ShogaiJiritsu.values()));
    }

    @Override
    public Map<NinteichosaItemKubunOfGaikyo, INinteichosaItem> getサービス状況調査定義() {
        return new EnumMap<>(サービス状況調査定義);
    }

    @Override
    public Map<NinteichosaItemKubunOfKihon, INinteichosaItem> get基本調査定義() {
        return new EnumMap<>(基本調査定義);
    }
}
