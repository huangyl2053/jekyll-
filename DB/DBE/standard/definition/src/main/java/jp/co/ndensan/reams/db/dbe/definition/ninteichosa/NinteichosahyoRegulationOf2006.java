/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemSubGroup;

/**
 * 要介護認定調査の調査票定義（2006年改訂版）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosahyoRegulationOf2006 implements INinteichosahyoRegulation {

    private static Map<NinteichosaItemKubun, INinteichosaItem> サービス状況調査定義;
    private static Map<NinteichosaItemKubun, INinteichosaItem> 基本調査定義;

    static {
        サービス状況調査定義 = new EnumMap<>(NinteichosaItemKubun.class);
        基本調査定義 = new EnumMap<>(NinteichosaItemKubun.class);
        initializeサービス状況調査定義();
        initialize基本調査定義();
    }

    private static void initializeサービス状況調査定義() {
        NinteichosahyoRegulationBuilder builder = new NinteichosahyoRegulationBuilder(サービス状況調査定義);
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.サービス状況, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("", NinteichosaItemKubun.訪問介護, "訪問介護(ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ)", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.訪問入浴介護, "訪問入浴介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.訪問看護, "訪問看護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.訪問リハビリ, "訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.居宅療養管理指導, "居宅療養管理指導", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.通所介護, "通所介護(ﾃﾞｲｻｰﾋﾞｽ)", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.通所リハビリテーション, "通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ(ﾃﾞｲｹｱ)", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.短期入所生活介護, "短期入所生活介護(特養等)", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.短期入所療養介護, "短期入所療養介護(老健・診療所)", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.特定施設入居者生活介護, "特定施設入居者生活介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.福祉用具貸与, "福祉用具貸与", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.特定福祉用具販売, "特定福祉用具販売", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.夜間対応型訪問介護, "夜間対応型訪問介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.認知症対応型通所介護, "認知症対応型通所介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.小規模多機能型居宅介護, "小規模多機能型居宅介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.認知症対応型共同生活介護, "認知症対応型共同生活介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.地域密着型特定施設入居者生活介護, "地域密着型特定施設入居者生活介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.地域密着型介護老人福祉施設入所者生活介護, "地域密着型介護老人福祉施設入所者生活介護", Choice.FreeInput.values());
        builder.set調査項目("", NinteichosaItemKubun.住宅改修, "住宅改修", Choice.Checked.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2009.概況特記事項, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("", NinteichosaItemKubun.概況特記事項, "", Choice.FreeInput.values());
    }

    private static void initialize基本調査定義() {
        NinteichosahyoRegulationBuilder builder = new NinteichosahyoRegulationBuilder(基本調査定義);
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第１群, NinteichosaItemSubGroup.Of2006.麻痺);
        builder.set調査項目("1-1", NinteichosaItemKubun.麻痺等の有無_左上肢, "（左－上肢）", Choice.Checked.values());
        builder.set調査項目("1-1", NinteichosaItemKubun.麻痺等の有無_右上肢, "（右－上肢）", Choice.Checked.values());
        builder.set調査項目("1-1", NinteichosaItemKubun.麻痺等の有無_左下肢, "（左－下肢）", Choice.Checked.values());
        builder.set調査項目("1-1", NinteichosaItemKubun.麻痺等の有無_右下肢, "（右－下肢）", Choice.Checked.values());
        builder.set調査項目("1-1", NinteichosaItemKubun.麻痺等の有無_その他, "（その他）", Choice.Checked.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第１群, NinteichosaItemSubGroup.Of2006.拘縮);
        builder.set調査項目("1-2", NinteichosaItemKubun.関節の動く範囲の制限_肩関節, "（肩関節）", Choice.Checked.values());
        builder.set調査項目("1-2", NinteichosaItemKubun.関節の動く範囲の制限_肘関節, "（肘関節）", Choice.Checked.values());
        builder.set調査項目("1-2", NinteichosaItemKubun.関節の動く範囲の制限_股関節, "（股関節）", Choice.Checked.values());
        builder.set調査項目("1-2", NinteichosaItemKubun.関節の動く範囲の制限_膝関節, "（膝関節）", Choice.Checked.values());
        builder.set調査項目("1-2", NinteichosaItemKubun.関節の動く範囲の制限_足関節, "（足関節）", Choice.Checked.values());
        builder.set調査項目("1-2", NinteichosaItemKubun.関節の動く範囲の制限_その他, "（その他）", Choice.Checked.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第２群, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("2-1", NinteichosaItemKubun.寝返り, "寝返り", Choice.DekiruDekinai3.values());
        builder.set調査項目("2-2", NinteichosaItemKubun.起き上がり, "起き上がり", Choice.DekiruDekinai3.values());
        builder.set調査項目("2-3", NinteichosaItemKubun.座位保持, "座位保持", Choice.DekiruDekinai6.values());
        builder.set調査項目("2-4", NinteichosaItemKubun.両足での立位, "両足での立位", Choice.DekiruDekinai5.values());
        builder.set調査項目("2-5", NinteichosaItemKubun.歩行, "歩　行", Choice.DekiruDekinai3.values());
        builder.set調査項目("2-6", NinteichosaItemKubun.移乗, "移　乗", Choice.Kaijo3.values());
        builder.set調査項目("2-7", NinteichosaItemKubun.移動, "移　動", Choice.Kaijo3.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第３群, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("3-1", NinteichosaItemKubun.立ち上がり, "立ち上がり", Choice.DekiruDekinai3.values());
        builder.set調査項目("3-2", NinteichosaItemKubun.片足での立位, "片足での立位", Choice.DekiruDekinai5.values());
        builder.set調査項目("3-3", NinteichosaItemKubun.洗身, "洗　身", Choice.Kaijo2.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第４群, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("4-1-ア", NinteichosaItemKubun.じょくそう, "じょくそう", Choice.NaiAru.values());
        builder.set調査項目("4-1-イ", NinteichosaItemKubun.他の皮膚疾患, "皮膚疾患", Choice.NaiAru.values());
        builder.set調査項目("4-2", NinteichosaItemKubun.嚥下, "えん下", Choice.DekiruDekinai4.values());
        builder.set調査項目("4-3", NinteichosaItemKubun.食事摂取, "食事摂取", Choice.Kaijo3.values());
        builder.set調査項目("4-4", NinteichosaItemKubun.飲水摂取, "飲　水", Choice.Kaijo3.values());
        builder.set調査項目("4-5", NinteichosaItemKubun.排尿, "排　尿", Choice.Kaijo3.values());
        builder.set調査項目("4-6", NinteichosaItemKubun.排便, "排　便", Choice.Kaijo3.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第５群, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("5-1-ア", NinteichosaItemKubun.口腔清潔, "口腔清潔", Choice.Kaijo.values());
        builder.set調査項目("5-1-イ", NinteichosaItemKubun.洗顔, "洗　顔", Choice.Kaijo.values());
        builder.set調査項目("5-1-ウ", NinteichosaItemKubun.整髪, "整　髪", Choice.Kaijo.values());
        builder.set調査項目("5-1-エ", NinteichosaItemKubun.つめ切り, "つめ切り", Choice.Kaijo.values());
        builder.set調査項目("5-2-ア", NinteichosaItemKubun.上衣の着脱, "上衣の着脱", Choice.Kaijo3.values());
        builder.set調査項目("5-2-イ", NinteichosaItemKubun.ズボン等の着脱, "ズボン等の着脱", Choice.Kaijo3.values());
        builder.set調査項目("5-3", NinteichosaItemKubun.薬の内服, "薬の内服", Choice.Kaijo.values());
        builder.set調査項目("5-4", NinteichosaItemKubun.金銭の管理, "金銭の管理", Choice.Kaijo.values());
        builder.set調査項目("5-5", NinteichosaItemKubun.電話の利用, "電話の利用", Choice.Kaijo.values());
        builder.set調査項目("5-6", NinteichosaItemKubun.日常の意思決定, "日常の意思決定", Choice.DekiruDekinai7.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第６群, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("6-1", NinteichosaItemKubun.視力, "視　力", Choice.Shiryoku.values());
        builder.set調査項目("6-2", NinteichosaItemKubun.聴力, "聴　力", Choice.Choryoku.values());
        builder.set調査項目("6-3", NinteichosaItemKubun.意思の伝達, "意思の伝達", Choice.DekiruDekinai2.values());
        builder.set調査項目("6-4", NinteichosaItemKubun.指示への反応, "指示への反応", Choice.Shiji.values());
        builder.set調査項目("6-5-ア", NinteichosaItemKubun.毎日の日課を理解, "毎日の日課を理解", Choice.DekiruDekinai.values());
        builder.set調査項目("6-5-イ", NinteichosaItemKubun.生年月日をいう, "生年月日をいう", Choice.DekiruDekinai.values());
        builder.set調査項目("6-5-ウ", NinteichosaItemKubun.短期記憶, "短期記憶", Choice.DekiruDekinai.values());
        builder.set調査項目("6-5-エ", NinteichosaItemKubun.自分の名前をいう, "自分の名前をいう", Choice.DekiruDekinai.values());
        builder.set調査項目("6-5-オ", NinteichosaItemKubun.今の季節を理解, "今の季節を理解", Choice.DekiruDekinai.values());
        builder.set調査項目("6-5-カ", NinteichosaItemKubun.場所の理解, "場所の理解", Choice.DekiruDekinai.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.第７群, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("7-ア", NinteichosaItemKubun.被害的, "被害的", Choice.NaiAru2.values());
        builder.set調査項目("7-イ", NinteichosaItemKubun.作話, "作　話", Choice.NaiAru2.values());
        builder.set調査項目("7-ウ", NinteichosaItemKubun.幻視幻聴, "幻視幻聴", Choice.NaiAru2.values());
        builder.set調査項目("7-エ", NinteichosaItemKubun.感情が不安定, "感情が不安定", Choice.NaiAru2.values());
        builder.set調査項目("7-オ", NinteichosaItemKubun.昼夜逆転, "昼夜逆転", Choice.NaiAru2.values());
        builder.set調査項目("7-カ", NinteichosaItemKubun.暴言暴行, "暴言暴行", Choice.NaiAru2.values());
        builder.set調査項目("7-キ", NinteichosaItemKubun.同じ話をする, "同じ話をする", Choice.NaiAru2.values());
        builder.set調査項目("7-ク", NinteichosaItemKubun.大声を出す, "大声を出す", Choice.NaiAru2.values());
        builder.set調査項目("7-ケ", NinteichosaItemKubun.介護に抵抗, "介護に抵抗", Choice.NaiAru2.values());
        builder.set調査項目("7-コ", NinteichosaItemKubun.常時の徘徊, "常時の徘徊", Choice.NaiAru2.values());
        builder.set調査項目("7-サ", NinteichosaItemKubun.落ち着きなし, "落ち着きなし", Choice.NaiAru2.values());
        builder.set調査項目("7-シ", NinteichosaItemKubun.外出して戻れない, "外出して戻れない", Choice.NaiAru2.values());
        builder.set調査項目("7-ス", NinteichosaItemKubun.一人で出たがる, "一人で出たがる", Choice.NaiAru2.values());
        builder.set調査項目("7-セ", NinteichosaItemKubun.収集癖, "収集癖", Choice.NaiAru2.values());
        builder.set調査項目("7-ソ", NinteichosaItemKubun.火の不始末, "火の不始末", Choice.NaiAru2.values());
        builder.set調査項目("7-タ", NinteichosaItemKubun.物や衣類を壊す, "物や衣類を壊す", Choice.NaiAru2.values());
        builder.set調査項目("7-チ", NinteichosaItemKubun.不潔行為, "不潔行為", Choice.NaiAru2.values());
        builder.set調査項目("7-ツ", NinteichosaItemKubun.異食行動, "異食行動", Choice.NaiAru2.values());
        builder.set調査項目("7-テ", NinteichosaItemKubun.ひどい物忘れ, "ひどい物忘れ", Choice.NaiAru2.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.特別医療, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("", NinteichosaItemKubun.点滴の管理, "点滴の管理", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.中心静脈栄養, "中心静脈栄養", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.透析, "透析", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.ストーマの処置, "ストーマの処置", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.酸素療法, "酸素療法", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.レスピレーター, "レスピレーター", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.気管切開, "気管切開の処置", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.疼痛の看護, "疼痛の看護", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.経管栄養, "経管栄養", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.モニター測定, "モニター測定", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.じょくそうの処置, "じょくそうの処置", Choice.Checked.values());
        builder.set調査項目("", NinteichosaItemKubun.カテーテル, "カテーテル", Choice.Checked.values());
        builder.set調査項目グループ(NinteichosaItemGroup.Of2006.自立度, NinteichosaItemSubGroup.OfCommon.なし);
        builder.set調査項目("", NinteichosaItemKubun.認知症高齢者の日常生活自立度, "認知症高齢者自立度", Choice.NinchishoJiritsu.values());
        builder.set調査項目("", NinteichosaItemKubun.障害高齢者の日常生活自立度, "障害高齢者自立度", Choice.ShogaiJiritsu.values());
    }

    @Override
    public Map<NinteichosaItemKubun, INinteichosaItem> getサービス状況調査定義() {
        return サービス状況調査定義;
    }

    @Override
    public Map<NinteichosaItemKubun, INinteichosaItem> get基本調査定義() {
        return 基本調査定義;
    }
}
