/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.Choryoku;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.DekiruDekinai;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.DekiruDekinai2;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.DekiruDekinai3;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.DekiruDekinai4;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.DekiruDekinai5;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.DekiruDekinai6;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.DekiruDekinai7;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.Gaishutsu;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.Kaijo;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.Kaijo2;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.Kaijo3;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.NaiAru;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.NaiAru2;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.NinchishoKoreishaJiritsu;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.Shiryoku;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.ShogaiKoreishaJiritsu;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.自立度;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.第１群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.第２群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.第３群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.第４群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.第５群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.特別医療;

/**
 * 要介護認定調査の調査票定義情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosahyoRegulation {

    /**
     * 2006年度の調査票定義情報を表すクラスです。
     */
    public static class Of2006 implements IChosahyoRegulation {

        private static Map<ChosahyoItems, INinteichosaItem> chosahyoMap;

        static {
            chosahyoMap = new EnumMap<>(ChosahyoItems.class);
            initialize();
        }

        private static void initialize() {
            final RString no101 = new RString("101");
            final RString no102 = new RString("102");
            setChosahyoMap(第１群, no101, ChosahyoItems.麻痺等の有無_左上肢, new RString("麻痺等の有無 左上肢"), NaiAru.values());
            setChosahyoMap(第１群, no101, ChosahyoItems.麻痺等の有無_右上肢, new RString("麻痺等の有無 右上肢"), NaiAru.values());
            setChosahyoMap(第１群, no101, ChosahyoItems.麻痺等の有無_左下肢, new RString("麻痺等の有無 左下肢"), NaiAru.values());
            setChosahyoMap(第１群, no101, ChosahyoItems.麻痺等の有無_右下肢, new RString("麻痺等の有無 右下肢"), NaiAru.values());
            setChosahyoMap(第１群, no101, ChosahyoItems.麻痺等の有無_その他, new RString("麻痺等の有無 その他"), NaiAru.values());
            setChosahyoMap(第１群, no102, ChosahyoItems.関節の動く範囲の制限_肩関節, new RString("拘縮の有無 肩"), NaiAru.values());
            setChosahyoMap(第１群, no102, ChosahyoItems.関節の動く範囲の制限_股関節, new RString("拘縮の有無 股"), NaiAru.values());
            setChosahyoMap(第１群, no102, ChosahyoItems.関節の動く範囲の制限_膝関節, new RString("拘縮の有無 膝"), NaiAru.values());
            setChosahyoMap(第１群, no102, ChosahyoItems.関節の動く範囲の制限_その他, new RString("拘縮の有無 その他"), NaiAru.values());
            setChosahyoMap(第１群, new RString("103"), ChosahyoItems.寝返り, new RString("寝返り"), DekiruDekinai3.values());
            setChosahyoMap(第１群, new RString("104"), ChosahyoItems.起き上がり, new RString("起き上がり"), DekiruDekinai3.values());
            setChosahyoMap(第１群, new RString("105"), ChosahyoItems.座位保持, new RString("座位保持"), DekiruDekinai6.values());
            setChosahyoMap(第１群, new RString("106"), ChosahyoItems.両足での立位, new RString("両足での立位保持"), DekiruDekinai5.values());
            setChosahyoMap(第１群, new RString("107"), ChosahyoItems.歩行, new RString("歩行"), DekiruDekinai3.values());
            setChosahyoMap(第１群, new RString("108"), ChosahyoItems.立ち上がり, new RString("立ち上がり"), DekiruDekinai3.values());
            setChosahyoMap(第１群, new RString("109"), ChosahyoItems.片足での立位, new RString("片足での立位"), DekiruDekinai5.values());
            setChosahyoMap(第１群, new RString("110"), ChosahyoItems.洗身, new RString("洗身"), Kaijo2.values());
            setChosahyoMap(第１群, new RString("111"), ChosahyoItems.つめ切り, new RString("つめ切り"), Kaijo.values());
            setChosahyoMap(第１群, new RString("112"), ChosahyoItems.視力, new RString("視力"), Shiryoku.values());
            setChosahyoMap(第１群, new RString("113"), ChosahyoItems.聴力, new RString("聴力"), Choryoku.values());
            setChosahyoMap(第２群, new RString("201"), ChosahyoItems.移乗, new RString("移乗"), Kaijo3.values());
            setChosahyoMap(第２群, new RString("202"), ChosahyoItems.移動, new RString("移動"), Kaijo3.values());
            setChosahyoMap(第２群, new RString("203"), ChosahyoItems.嚥下, new RString("えん下"), DekiruDekinai4.values());
            setChosahyoMap(第２群, new RString("204"), ChosahyoItems.食事摂取, new RString("食事摂取"), Kaijo3.values());
            setChosahyoMap(第２群, new RString("205"), ChosahyoItems.排尿, new RString("排尿"), Kaijo3.values());
            setChosahyoMap(第２群, new RString("206"), ChosahyoItems.排便, new RString("排便"), Kaijo3.values());
            setChosahyoMap(第２群, new RString("207"), ChosahyoItems.口腔清潔, new RString("口腔清潔"), Kaijo.values());
            setChosahyoMap(第２群, new RString("208"), ChosahyoItems.洗顔, new RString("洗顔"), Kaijo.values());
            setChosahyoMap(第２群, new RString("209"), ChosahyoItems.整髪, new RString("整髪"), Kaijo.values());
            setChosahyoMap(第２群, new RString("210"), ChosahyoItems.上衣の着脱, new RString("上衣の着脱"), Kaijo3.values());
            setChosahyoMap(第２群, new RString("211"), ChosahyoItems.ズボン等の着脱, new RString("ズボン等の着脱"), Kaijo3.values());
            setChosahyoMap(第２群, new RString("212"), ChosahyoItems.外出頻度, new RString("外出頻度"), Gaishutsu.values());
            setChosahyoMap(第３群, new RString("301"), ChosahyoItems.意思の伝達, new RString("意思の伝達"), DekiruDekinai2.values());
            setChosahyoMap(第３群, new RString("302"), ChosahyoItems.毎日の日課を理解, new RString("毎日の日課を理解"), DekiruDekinai.values());
            setChosahyoMap(第３群, new RString("303"), ChosahyoItems.生年月日をいう, new RString("生年月日や年齢を言う"), DekiruDekinai.values());
            setChosahyoMap(第３群, new RString("304"), ChosahyoItems.短期記憶, new RString("短期記憶"), DekiruDekinai.values());
            setChosahyoMap(第３群, new RString("305"), ChosahyoItems.自分の名前をいう, new RString("自分の名前を言う"), DekiruDekinai.values());
            setChosahyoMap(第３群, new RString("306"), ChosahyoItems.今の季節を理解, new RString("今の季節を理解する"), DekiruDekinai.values());
            setChosahyoMap(第３群, new RString("307"), ChosahyoItems.場所の理解, new RString("場所の理解"), DekiruDekinai.values());
            setChosahyoMap(第３群, new RString("308"), ChosahyoItems.常時の徘徊, new RString("徘徊"), NaiAru2.values());
            setChosahyoMap(第３群, new RString("309"), ChosahyoItems.外出して戻れない, new RString("外出すると戻れない"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("401"), ChosahyoItems.被害的, new RString("被害的"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("402"), ChosahyoItems.作話, new RString("作話"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("403"), ChosahyoItems.感情が不安定, new RString("感情が不安定"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("404"), ChosahyoItems.昼夜逆転, new RString("昼夜逆転"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("405"), ChosahyoItems.同じ話をする, new RString("同じ話をする"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("406"), ChosahyoItems.大声を出す, new RString("大声をだす"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("407"), ChosahyoItems.介護に抵抗, new RString("介護に抵抗"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("408"), ChosahyoItems.落ち着きなし, new RString("落ち着きなし"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("409"), ChosahyoItems.一人で出たがる, new RString("一人で出たがる"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("410"), ChosahyoItems.収集癖, new RString("収集癖"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("411"), ChosahyoItems.物や衣類を壊す, new RString("物や衣類を壊す"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("412"), ChosahyoItems.ひどい物忘れ, new RString("ひどい物忘れ"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("413"), ChosahyoItems.独り言_独り笑, new RString("独り言・独り笑い"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("414"), ChosahyoItems.自分勝手に行動する, new RString("自分勝手に行動する"), NaiAru2.values());
            setChosahyoMap(第４群, new RString("415"), ChosahyoItems.話がまとまらない, new RString("話がまとまらない"), NaiAru2.values());
            setChosahyoMap(第５群, new RString("501"), ChosahyoItems.薬の内服, new RString("薬の内服"), Kaijo.values());
            setChosahyoMap(第５群, new RString("502"), ChosahyoItems.金銭の管理, new RString("金銭の管理"), Kaijo.values());
            setChosahyoMap(第５群, new RString("503"), ChosahyoItems.日常の意思決定, new RString("日常の意思決定"), DekiruDekinai7.values());
            setChosahyoMap(第５群, new RString("504"), ChosahyoItems.集団への不適応, new RString("集団への不適応"), NaiAru2.values());
            setChosahyoMap(第５群, new RString("505"), ChosahyoItems.買い物, new RString("買い物"), Kaijo3.values());
            setChosahyoMap(第５群, new RString("506"), ChosahyoItems.簡単な調理, new RString("簡単な調理"), Kaijo3.values());
            setChosahyoMap(特別医療, new RString("601"), ChosahyoItems.点滴の管理, new RString("点滴の管理"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("602"), ChosahyoItems.中心静脈栄養, new RString("中心静脈栄養"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("603"), ChosahyoItems.透析, new RString("透析"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("604"), ChosahyoItems.ストーマの処置, new RString("ストーマの処置"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("605"), ChosahyoItems.酸素療法, new RString("酸素療法"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("606"), ChosahyoItems.レスピレーター, new RString("レスピレーター"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("607"), ChosahyoItems.気管切開, new RString("気管切開の処置"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("608"), ChosahyoItems.疼痛の看護, new RString("疼痛の看護"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("609"), ChosahyoItems.経管栄養, new RString("経管栄養"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("610"), ChosahyoItems.モニター測定, new RString("モニター測定（血圧、心拍、酸素飽和度等）"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("611"), ChosahyoItems.じょくそうの処置, new RString("じょくそうの処置"), NaiAru.values());
            setChosahyoMap(特別医療, new RString("612"), ChosahyoItems.カテーテル, new RString("カテーテル（コンドームカテーテル、留置カテーテル、ウロストーマ等）"), NaiAru.values());
            setChosahyoMap(自立度, new RString("701"), ChosahyoItems.障害高齢者の日常生活自立度, new RString("障害高齢者の日常生活自立度（寝たきり度）"), ShogaiKoreishaJiritsu.values());
            setChosahyoMap(自立度, new RString("702"), ChosahyoItems.認知症高齢者の日常生活自立度, new RString("認知症高齢者の日常生活自立度"), NinchishoKoreishaJiritsu.values());
        }

        private static void setChosahyoMap(IChosahyoItemGroup 調査票項目分類, RString 調査項目番号, ChosahyoItems 調査票項目, RString 表示名称, IAnsweringItem[] 選択肢) {
            chosahyoMap.put(調査票項目, new NinteichosaItem(調査票項目分類, new NinteichosaItemNo(調査項目番号), 調査票項目, 表示名称, new Choices(選択肢)));
        }

        @Override
        public Map<ChosahyoItems, INinteichosaItem> get調査票定義() {
            return chosahyoMap;
        }
    }
}
