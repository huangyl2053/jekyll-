/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ISentakushi;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui.第１群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui.第２群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui.第３群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui.第４群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui.第５群;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui.特別医療;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui.自立度;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.NaiAru;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.NaiAru2;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.DekiruDekinai;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.DekiruDekinai2;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.DekiruDekinai3;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.DekiruDekinai4;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.DekiruDekinai5;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.DekiruDekinai6;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.DekiruDekinai7;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.Kaijo;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.Kaijo2;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.Kaijo3;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.Shiryoku;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.Choryoku;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.Gaishutsu;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.ShogaiKoreishaJiritsu;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.NinchishoKoreishaJiritsu;

/**
 * 要介護認定調査の調査票定義情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public final class NinteichosahyoTeigi {

    private static Map<ChosaKomoku, INinteichosaKomoku> 調査票項目Map = new HashMap<>();
    private static final int NENDO_2006 = 2006;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosahyoTeigi() {
    }

    /**
     * 引数の改定年度に該当する調査票定義情報を返します。
     *
     * @param 改定年度 改定年度
     * @return 調査票定義情報
     */
    public static Map<ChosaKomoku, INinteichosaKomoku> get調査票定義(int 改定年度) {
        switch (改定年度) {
            case NENDO_2006:
            default:
                createTeigi2006();
                break;
        }
        return 調査票項目Map;
    }

    private static void createTeigi2006() {
        final RString no101 = new RString("101");
        final RString no102 = new RString("102");
        add(第１群, no101, ChosaKomoku.麻痺等の有無_左上肢, new RString("麻痺等の有無 左上肢"), NaiAru.values());
        add(第１群, no101, ChosaKomoku.麻痺等の有無_右上肢, new RString("麻痺等の有無 右上肢"), NaiAru.values());
        add(第１群, no101, ChosaKomoku.麻痺等の有無_左下肢, new RString("麻痺等の有無 左下肢"), NaiAru.values());
        add(第１群, no101, ChosaKomoku.麻痺等の有無_右下肢, new RString("麻痺等の有無 右下肢"), NaiAru.values());
        add(第１群, no101, ChosaKomoku.麻痺等の有無_その他, new RString("麻痺等の有無 その他"), NaiAru.values());
        add(第１群, no102, ChosaKomoku.関節の動く範囲の制限_肩関節, new RString("拘縮の有無 肩"), NaiAru.values());
        add(第１群, no102, ChosaKomoku.関節の動く範囲の制限_股関節, new RString("拘縮の有無 股"), NaiAru.values());
        add(第１群, no102, ChosaKomoku.関節の動く範囲の制限_膝関節, new RString("拘縮の有無 膝"), NaiAru.values());
        add(第１群, no102, ChosaKomoku.関節の動く範囲の制限_その他, new RString("拘縮の有無 その他"), NaiAru.values());
        add(第１群, new RString("103"), ChosaKomoku.寝返り, new RString("寝返り"), DekiruDekinai3.values());
        add(第１群, new RString("104"), ChosaKomoku.起き上がり, new RString("起き上がり"), DekiruDekinai3.values());
        add(第１群, new RString("105"), ChosaKomoku.座位保持, new RString("座位保持"), DekiruDekinai6.values());
        add(第１群, new RString("106"), ChosaKomoku.両足での立位, new RString("両足での立位保持"), DekiruDekinai5.values());
        add(第１群, new RString("107"), ChosaKomoku.歩行, new RString("歩行"), DekiruDekinai3.values());
        add(第１群, new RString("108"), ChosaKomoku.立ち上がり, new RString("立ち上がり"), DekiruDekinai3.values());
        add(第１群, new RString("109"), ChosaKomoku.片足での立位, new RString("片足での立位"), DekiruDekinai5.values());
        add(第１群, new RString("110"), ChosaKomoku.洗身, new RString("洗身"), Kaijo2.values());
        add(第１群, new RString("111"), ChosaKomoku.つめ切り, new RString("つめ切り"), Kaijo.values());
        add(第１群, new RString("112"), ChosaKomoku.視力, new RString("視力"), Shiryoku.values());
        add(第１群, new RString("113"), ChosaKomoku.聴力, new RString("聴力"), Choryoku.values());
        add(第２群, new RString("201"), ChosaKomoku.移乗, new RString("移乗"), Kaijo3.values());
        add(第２群, new RString("202"), ChosaKomoku.移動, new RString("移動"), Kaijo3.values());
        add(第２群, new RString("203"), ChosaKomoku.嚥下, new RString("えん下"), DekiruDekinai4.values());
        add(第２群, new RString("204"), ChosaKomoku.食事摂取, new RString("食事摂取"), Kaijo3.values());
        add(第２群, new RString("205"), ChosaKomoku.排尿, new RString("排尿"), Kaijo3.values());
        add(第２群, new RString("206"), ChosaKomoku.排便, new RString("排便"), Kaijo3.values());
        add(第２群, new RString("207"), ChosaKomoku.口腔清潔, new RString("口腔清潔"), Kaijo.values());
        add(第２群, new RString("208"), ChosaKomoku.洗顔, new RString("洗顔"), Kaijo.values());
        add(第２群, new RString("209"), ChosaKomoku.整髪, new RString("整髪"), Kaijo.values());
        add(第２群, new RString("210"), ChosaKomoku.上衣の着脱, new RString("上衣の着脱"), Kaijo3.values());
        add(第２群, new RString("211"), ChosaKomoku.ズボン等の着脱, new RString("ズボン等の着脱"), Kaijo3.values());
        add(第２群, new RString("212"), ChosaKomoku.外出頻度, new RString("外出頻度"), Gaishutsu.values());
        add(第３群, new RString("301"), ChosaKomoku.意思の伝達, new RString("意思の伝達"), DekiruDekinai2.values());
        add(第３群, new RString("302"), ChosaKomoku.毎日の日課を理解, new RString("毎日の日課を理解"), DekiruDekinai.values());
        add(第３群, new RString("303"), ChosaKomoku.生年月日をいう, new RString("生年月日や年齢を言う"), DekiruDekinai.values());
        add(第３群, new RString("304"), ChosaKomoku.短期記憶, new RString("短期記憶"), DekiruDekinai.values());
        add(第３群, new RString("305"), ChosaKomoku.自分の名前をいう, new RString("自分の名前を言う"), DekiruDekinai.values());
        add(第３群, new RString("306"), ChosaKomoku.今の季節を理解, new RString("今の季節を理解する"), DekiruDekinai.values());
        add(第３群, new RString("307"), ChosaKomoku.場所の理解, new RString("場所の理解"), DekiruDekinai.values());
        add(第３群, new RString("308"), ChosaKomoku.常時の徘徊, new RString("徘徊"), NaiAru2.values());
        add(第３群, new RString("309"), ChosaKomoku.外出して戻れない, new RString("外出すると戻れない"), NaiAru2.values());
        add(第４群, new RString("401"), ChosaKomoku.被害的, new RString("被害的"), NaiAru2.values());
        add(第４群, new RString("402"), ChosaKomoku.作話, new RString("作話"), NaiAru2.values());
        add(第４群, new RString("403"), ChosaKomoku.感情が不安定, new RString("感情が不安定"), NaiAru2.values());
        add(第４群, new RString("404"), ChosaKomoku.昼夜逆転, new RString("昼夜逆転"), NaiAru2.values());
        add(第４群, new RString("405"), ChosaKomoku.同じ話をする, new RString("同じ話をする"), NaiAru2.values());
        add(第４群, new RString("406"), ChosaKomoku.大声を出す, new RString("大声をだす"), NaiAru2.values());
        add(第４群, new RString("407"), ChosaKomoku.介護に抵抗, new RString("介護に抵抗"), NaiAru2.values());
        add(第４群, new RString("408"), ChosaKomoku.落ち着きなし, new RString("落ち着きなし"), NaiAru2.values());
        add(第４群, new RString("409"), ChosaKomoku.一人で出たがる, new RString("一人で出たがる"), NaiAru2.values());
        add(第４群, new RString("410"), ChosaKomoku.収集癖, new RString("収集癖"), NaiAru2.values());
        add(第４群, new RString("411"), ChosaKomoku.物や衣類を壊す, new RString("物や衣類を壊す"), NaiAru2.values());
        add(第４群, new RString("412"), ChosaKomoku.ひどい物忘れ, new RString("ひどい物忘れ"), NaiAru2.values());
        add(第４群, new RString("413"), ChosaKomoku.独り言_独り笑, new RString("独り言・独り笑い"), NaiAru2.values());
        add(第４群, new RString("414"), ChosaKomoku.自分勝手に行動する, new RString("自分勝手に行動する"), NaiAru2.values());
        add(第４群, new RString("415"), ChosaKomoku.話がまとまらない, new RString("話がまとまらない"), NaiAru2.values());
        add(第５群, new RString("501"), ChosaKomoku.薬の内服, new RString("薬の内服"), Kaijo.values());
        add(第５群, new RString("502"), ChosaKomoku.金銭の管理, new RString("金銭の管理"), Kaijo.values());
        add(第５群, new RString("503"), ChosaKomoku.日常の意思決定, new RString("日常の意思決定"), DekiruDekinai7.values());
        add(第５群, new RString("504"), ChosaKomoku.集団への不適応, new RString("集団への不適応"), NaiAru2.values());
        add(第５群, new RString("505"), ChosaKomoku.買い物, new RString("買い物"), Kaijo3.values());
        add(第５群, new RString("506"), ChosaKomoku.簡単な調理, new RString("簡単な調理"), Kaijo3.values());
        add(特別医療, new RString("601"), ChosaKomoku.点滴の管理, new RString("点滴の管理"), NaiAru.values());
        add(特別医療, new RString("602"), ChosaKomoku.中心静脈栄養, new RString("中心静脈栄養"), NaiAru.values());
        add(特別医療, new RString("603"), ChosaKomoku.透析, new RString("透析"), NaiAru.values());
        add(特別医療, new RString("604"), ChosaKomoku.ストーマの処置, new RString("ストーマの処置"), NaiAru.values());
        add(特別医療, new RString("605"), ChosaKomoku.酸素療法, new RString("酸素療法"), NaiAru.values());
        add(特別医療, new RString("606"), ChosaKomoku.レスピレーター, new RString("レスピレーター"), NaiAru.values());
        add(特別医療, new RString("607"), ChosaKomoku.気管切開, new RString("気管切開の処置"), NaiAru.values());
        add(特別医療, new RString("608"), ChosaKomoku.疼痛の看護, new RString("疼痛の看護"), NaiAru.values());
        add(特別医療, new RString("609"), ChosaKomoku.経管栄養, new RString("経管栄養"), NaiAru.values());
        add(特別医療, new RString("610"), ChosaKomoku.モニター測定, new RString("モニター測定（血圧、心拍、酸素飽和度等）"), NaiAru.values());
        add(特別医療, new RString("611"), ChosaKomoku.じょくそうの処置, new RString("じょくそうの処置"), NaiAru.values());
        add(特別医療, new RString("612"), ChosaKomoku.カテーテル, new RString("カテーテル（コンドームカテーテル、留置カテーテル、ウロストーマ等）"), NaiAru.values());
        add(自立度, new RString("701"), ChosaKomoku.障害高齢者の日常生活自立度, new RString("障害高齢者の日常生活自立度（寝たきり度）"), ShogaiKoreishaJiritsu.values());
        add(自立度, new RString("702"), ChosaKomoku.認知症高齢者の日常生活自立度, new RString("認知症高齢者の日常生活自立度"), NinchishoKoreishaJiritsu.values());
    }

    private static void add(ChosaBunrui 調査分類, RString 調査項目番号, ChosaKomoku 調査項目, RString 表示名称, ISentakushi[] 選択肢) {
        調査票項目Map.put(調査項目, new NinteichosaKomoku(調査分類, 調査項目番号, 調査項目, 表示名称, Arrays.asList(選択肢)));
    }
}
