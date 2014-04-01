/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbe.definition.InputResultItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemSubGroupOf2009;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査票定義（2009年改訂版）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosahyoRegulationOf2009 implements INinteichosahyoRegulation {

    private static Map<NinteichosaItemKubunOfGaikyo, INinteichosaItem> サービス状況調査定義;
    private static Map<NinteichosaItemKubunOfKihon, INinteichosaItem> 基本調査定義;

    static {
        サービス状況調査定義 = new EnumMap<>(NinteichosaItemKubunOfGaikyo.class);
        基本調査定義 = new EnumMap<>(NinteichosaItemKubunOfKihon.class);
        initializeサービス状況調査定義();
        initialize基本調査定義();
    }

    private static void initializeサービス状況調査定義() {
        NinteichosahyoRegulationBuilder builder = new NinteichosahyoRegulationBuilder(サービス状況調査定義);
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.サービス状況, NinteichosaItemSubGroup.なし);
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.サービス区分コード, "現在のサービス区分", ChoiceResultItem.ServiceKubun.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問介護, "(介護予防)訪問介護(ホームヘルプサービス)", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問入浴介護, "(介護予防)訪問入浴介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問看護, "(介護予防)訪問看護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.訪問リハビリ, "(介護予防)訪問リハビリテーション", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.居宅療養管理指導, "(介護予防)居宅療養管理指導", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.通所介護, "(介護予防)通所介護(デイサービス)", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.通所リハビリテーション, "(介護予防)通所リハビリテーション(デイケア)", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.短期入所生活介護, "(介護予防)短期入所生活介護(特養等)", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.短期入所療養介護, "(介護予防)短期入所療養介護(老健・診療所)", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.特定施設入居者生活介護, "(介護予防)特定施設入居者生活介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.福祉用具貸与, "(介護予防)福祉用具貸与", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.特定福祉用具販売, "特定(介護予防)福祉用具販売", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.住宅改修, "住宅改修", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.夜間対応型訪問介護, "夜間対応型訪問介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.認知症対応型通所介護, "(介護予防)認知症対応型通所介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.小規模多機能型居宅介護, "(介護予防)小規模多機能型居宅介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.認知症対応型共同生活介護, "(介護予防)認知症対応型共同生活介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.地域密着型特定施設入居者生活介護, "地域密着型特定施設入居者生活介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.地域密着型介護老人福祉施設入所者生活介護, "地域密着型介護老人福祉施設入所者生活介護", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.市町村特別給付, "市町村特別給付", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.介護保険給付以外の在宅サービス, "介護保険給付外の在宅サービス", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.利用施設コード, "施設利用", ChoiceResultItem.ShisetsuRiyo.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.利用施設名, "施設名", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.利用施設郵便番号, "〒", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.利用施設住所, "施設住所", InputResultItem.getAnswerItem());
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.利用施設電話番号, "電話", InputResultItem.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.概況特記事項, NinteichosaItemSubGroup.なし);
        builder.set調査項目("", NinteichosaItemKubunOfGaikyo.概況特記事項, "", InputResultItem.getAnswerItem());
    }

    private static void initialize基本調査定義() {
        final RString 麻痺番号 = new RString("1-1");
        final RString 拘縮番号 = new RString("1-2");
        NinteichosahyoRegulationBuilder builder = new NinteichosahyoRegulationBuilder(基本調査定義);
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第１群, NinteichosaItemSubGroupOf2009.麻痺等の有無);
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_ない, "ない", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢, "左上肢", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢, "右上肢", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_左下肢, "左下肢", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_右下肢, "右下肢", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(麻痺番号.toString(), NinteichosaItemKubunOfKihon.麻痺等の有無_その他, "その他", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第１群, NinteichosaItemSubGroupOf2009.拘縮の有無);
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_ない, "ない", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節, "肩", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_股関節, "股", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_膝関節, "膝", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目(拘縮番号.toString(), NinteichosaItemKubunOfKihon.関節の動く範囲の制限_その他, "その他", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第１群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("1-3", NinteichosaItemKubunOfKihon.寝返り, "寝返り", ChoiceResultItem.DekiruDekinai3.getAnswerItem());
        builder.set調査項目("1-4", NinteichosaItemKubunOfKihon.起き上がり, "起き上がり", ChoiceResultItem.DekiruDekinai3.getAnswerItem());
        builder.set調査項目("1-5", NinteichosaItemKubunOfKihon.座位保持, "座位保持", ChoiceResultItem.DekiruDekinai6.getAnswerItem());
        builder.set調査項目("1-6", NinteichosaItemKubunOfKihon.両足での立位, "両足での立位保持", ChoiceResultItem.DekiruDekinai5.getAnswerItem());
        builder.set調査項目("1-7", NinteichosaItemKubunOfKihon.歩行, "歩行", ChoiceResultItem.DekiruDekinai3.getAnswerItem());
        builder.set調査項目("1-8", NinteichosaItemKubunOfKihon.立ち上がり, "立ち上がり", ChoiceResultItem.DekiruDekinai3.getAnswerItem());
        builder.set調査項目("1-9", NinteichosaItemKubunOfKihon.片足での立位, "片足での立位", ChoiceResultItem.DekiruDekinai5.getAnswerItem());
        builder.set調査項目("1-10", NinteichosaItemKubunOfKihon.洗身, "洗身", ChoiceResultItem.Kaijo2.getAnswerItem());
        builder.set調査項目("1-11", NinteichosaItemKubunOfKihon.つめ切り, "つめ切り", ChoiceResultItem.Kaijo.getAnswerItem());
        builder.set調査項目("1-12", NinteichosaItemKubunOfKihon.視力, "視力", ChoiceResultItem.Shiryoku.getAnswerItem());
        builder.set調査項目("1-13", NinteichosaItemKubunOfKihon.聴力, "聴力", ChoiceResultItem.Choryoku.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第２群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("2-1", NinteichosaItemKubunOfKihon.移乗, "移乗", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("2-2", NinteichosaItemKubunOfKihon.移動, "移動", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("2-3", NinteichosaItemKubunOfKihon.嚥下, "えん下", ChoiceResultItem.DekiruDekinai4.getAnswerItem());
        builder.set調査項目("2-4", NinteichosaItemKubunOfKihon.食事摂取, "食事摂取", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("2-5", NinteichosaItemKubunOfKihon.排尿, "排尿", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("2-6", NinteichosaItemKubunOfKihon.排便, "排便", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("2-7", NinteichosaItemKubunOfKihon.口腔清潔, "口腔清潔", ChoiceResultItem.Kaijo.getAnswerItem());
        builder.set調査項目("2-8", NinteichosaItemKubunOfKihon.洗顔, "洗顔", ChoiceResultItem.Kaijo.getAnswerItem());
        builder.set調査項目("2-9", NinteichosaItemKubunOfKihon.整髪, "整髪", ChoiceResultItem.Kaijo.getAnswerItem());
        builder.set調査項目("2-10", NinteichosaItemKubunOfKihon.上衣の着脱, "上衣の着脱", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("2-11", NinteichosaItemKubunOfKihon.ズボン等の着脱, "ズボン等の着脱", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("2-12", NinteichosaItemKubunOfKihon.外出頻度, "外出頻度", ChoiceResultItem.Gaishutsu.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第３群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("3-1", NinteichosaItemKubunOfKihon.意思の伝達, "意思の伝達", ChoiceResultItem.DekiruDekinai2.getAnswerItem());
        builder.set調査項目("3-2", NinteichosaItemKubunOfKihon.毎日の日課を理解, "毎日の日課を理解", ChoiceResultItem.DekiruDekinai.getAnswerItem());
        builder.set調査項目("3-3", NinteichosaItemKubunOfKihon.生年月日をいう, "生年月日や年齢を言う", ChoiceResultItem.DekiruDekinai.getAnswerItem());
        builder.set調査項目("3-4", NinteichosaItemKubunOfKihon.短期記憶, "短期記憶", ChoiceResultItem.DekiruDekinai.getAnswerItem());
        builder.set調査項目("3-5", NinteichosaItemKubunOfKihon.自分の名前をいう, "自分の名前を言う", ChoiceResultItem.DekiruDekinai.getAnswerItem());
        builder.set調査項目("3-6", NinteichosaItemKubunOfKihon.今の季節を理解, "今の季節を理解する", ChoiceResultItem.DekiruDekinai.getAnswerItem());
        builder.set調査項目("3-7", NinteichosaItemKubunOfKihon.場所の理解, "場所の理解", ChoiceResultItem.DekiruDekinai.getAnswerItem());
        builder.set調査項目("3-8", NinteichosaItemKubunOfKihon.常時の徘徊, "徘徊", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("3-9", NinteichosaItemKubunOfKihon.外出して戻れない, "外出すると戻れない", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第４群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("4-1", NinteichosaItemKubunOfKihon.被害的, "被害的", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-2", NinteichosaItemKubunOfKihon.作話, "作話", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-3", NinteichosaItemKubunOfKihon.感情が不安定, "感情が不安定", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-4", NinteichosaItemKubunOfKihon.昼夜逆転, "昼夜逆転", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-5", NinteichosaItemKubunOfKihon.同じ話をする, "同じ話をする", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-6", NinteichosaItemKubunOfKihon.大声を出す, "大声をだす", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-7", NinteichosaItemKubunOfKihon.介護に抵抗, "介護に抵抗", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-8", NinteichosaItemKubunOfKihon.落ち着きなし, "落ち着きなし", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-9", NinteichosaItemKubunOfKihon.一人で出たがる, "一人で出たがる", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-10", NinteichosaItemKubunOfKihon.収集癖, "収集癖", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-11", NinteichosaItemKubunOfKihon.物や衣類を壊す, "物や衣類を壊す", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-12", NinteichosaItemKubunOfKihon.ひどい物忘れ, "ひどい物忘れ", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-13", NinteichosaItemKubunOfKihon.独り言_独り笑, "独り言・独り笑い", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-14", NinteichosaItemKubunOfKihon.自分勝手に行動する, "自分勝手に行動する", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("4-15", NinteichosaItemKubunOfKihon.話がまとまらない, "話がまとまらない", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第４群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("5-1", NinteichosaItemKubunOfKihon.薬の内服, "薬の内服", ChoiceResultItem.Kaijo.getAnswerItem());
        builder.set調査項目("5-2", NinteichosaItemKubunOfKihon.金銭の管理, "金銭の管理", ChoiceResultItem.Kaijo.getAnswerItem());
        builder.set調査項目("5-3", NinteichosaItemKubunOfKihon.日常の意思決定, "日常の意思決定", ChoiceResultItem.DekiruDekinai7.getAnswerItem());
        builder.set調査項目("5-4", NinteichosaItemKubunOfKihon.集団への不適応, "集団への不適応", ChoiceResultItem.NaiAru2.getAnswerItem());
        builder.set調査項目("5-5", NinteichosaItemKubunOfKihon.買い物, "買い物", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目("5-6", NinteichosaItemKubunOfKihon.簡単な調理, "簡単な調理", ChoiceResultItem.Kaijo3.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.特別医療, NinteichosaItemSubGroupOf2009.処置内容);
        builder.set調査項目("6-1", NinteichosaItemKubunOfKihon.点滴の管理, "点滴の管理", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-2", NinteichosaItemKubunOfKihon.中心静脈栄養, "中心静脈栄養", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-3", NinteichosaItemKubunOfKihon.透析, "透析", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-4", NinteichosaItemKubunOfKihon.ストーマの処置, "ストーマの処置", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-5", NinteichosaItemKubunOfKihon.酸素療法, "酸素療法", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-6", NinteichosaItemKubunOfKihon.レスピレーター, "レスピレーター", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-7", NinteichosaItemKubunOfKihon.気管切開, "気管切開の処置", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-8", NinteichosaItemKubunOfKihon.疼痛の看護, "疼痛の看護", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-9", NinteichosaItemKubunOfKihon.経管栄養, "経管栄養", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.特別医療, NinteichosaItemSubGroupOf2009.特別な対応);
        builder.set調査項目("6-10", NinteichosaItemKubunOfKihon.モニター測定, "モニター測定（血圧、心拍、酸素飽和度等）", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-11", NinteichosaItemKubunOfKihon.じょくそうの処置, "じょくそうの処置", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目("6-12", NinteichosaItemKubunOfKihon.カテーテル, "カテーテル（コンドームカテーテル、留置カテーテル、ウロストーマ等）", ChoiceResultItem.Checked.getAnswerItem());
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.自立度, NinteichosaItemSubGroup.なし);
        builder.set調査項目("7-1", NinteichosaItemKubunOfKihon.障害高齢者の日常生活自立度, "障害高齢者の日常生活自立度（寝たきり度）", ChoiceResultItem.ShogaiJiritsu.getAnswerItem());
        builder.set調査項目("7-2", NinteichosaItemKubunOfKihon.認知症高齢者の日常生活自立度, "認知症高齢者の日常生活自立度", ChoiceResultItem.NinchishoJiritsu.getAnswerItem());
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
