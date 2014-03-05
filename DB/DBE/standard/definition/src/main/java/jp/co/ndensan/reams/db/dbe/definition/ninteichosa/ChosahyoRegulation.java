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
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup.Of2006.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemSubGroup.Of2006.*;

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
            setChosahyoMap(第１群, 麻痺等の有無, 1, "1-1", 麻痺等の有無_ない, "ない", OffOn.values());
            setChosahyoMap(第１群, 麻痺等の有無, 2, "1-1", 麻痺等の有無_左上肢, "左上肢", OffOn.values());
            setChosahyoMap(第１群, 麻痺等の有無, 3, "1-1", 麻痺等の有無_右上肢, "右上肢", OffOn.values());
            setChosahyoMap(第１群, 麻痺等の有無, 4, "1-1", 麻痺等の有無_左下肢, "左下肢", OffOn.values());
            setChosahyoMap(第１群, 麻痺等の有無, 5, "1-1", 麻痺等の有無_右下肢, "右下肢", OffOn.values());
            setChosahyoMap(第１群, 麻痺等の有無, 6, "1-1", 麻痺等の有無_その他, "その他", OffOn.values());
            setChosahyoMap(第１群, 拘縮の有無, 1, "1-2", 関節の動く範囲の制限_ない, "ない", OffOn.values());
            setChosahyoMap(第１群, 拘縮の有無, 2, "1-2", 関節の動く範囲の制限_肩関節, "肩", OffOn.values());
            setChosahyoMap(第１群, 拘縮の有無, 3, "1-2", 関節の動く範囲の制限_股関節, "股", OffOn.values());
            setChosahyoMap(第１群, 拘縮の有無, 4, "1-2", 関節の動く範囲の制限_膝関節, "膝", OffOn.values());
            setChosahyoMap(第１群, 拘縮の有無, 5, "1-2", 関節の動く範囲の制限_その他, "その他", OffOn.values());
            setChosahyoMap(第１群, "1-3", 寝返り, "寝返り", DekiruDekinai3.values());
            setChosahyoMap(第１群, "1-4", 起き上がり, "起き上がり", DekiruDekinai3.values());
            setChosahyoMap(第１群, "1-5", 座位保持, "座位保持", DekiruDekinai6.values());
            setChosahyoMap(第１群, "1-6", 両足での立位, "両足での立位保持", DekiruDekinai5.values());
            setChosahyoMap(第１群, "1-7", 歩行, "歩行", DekiruDekinai3.values());
            setChosahyoMap(第１群, "1-8", 立ち上がり, "立ち上がり", DekiruDekinai3.values());
            setChosahyoMap(第１群, "1-9", 片足での立位, "片足での立位", DekiruDekinai5.values());
            setChosahyoMap(第１群, "1-10", 洗身, "洗身", Kaijo2.values());
            setChosahyoMap(第１群, "1-11", つめ切り, "つめ切り", Kaijo.values());
            setChosahyoMap(第１群, "1-12", 視力, "視力", Shiryoku.values());
            setChosahyoMap(第１群, "1-13", 聴力, "聴力", Choryoku.values());
            setChosahyoMap(第２群, "2-1", 移乗, "移乗", Kaijo3.values());
            setChosahyoMap(第２群, "2-2", 移動, "移動", Kaijo3.values());
            setChosahyoMap(第２群, "2-3", 嚥下, "えん下", DekiruDekinai4.values());
            setChosahyoMap(第２群, "2-4", 食事摂取, "食事摂取", Kaijo3.values());
            setChosahyoMap(第２群, "2-5", 排尿, "排尿", Kaijo3.values());
            setChosahyoMap(第２群, "2-6", 排便, "排便", Kaijo3.values());
            setChosahyoMap(第２群, "2-7", 口腔清潔, "口腔清潔", Kaijo.values());
            setChosahyoMap(第２群, "2-8", 洗顔, "洗顔", Kaijo.values());
            setChosahyoMap(第２群, "2-9", 整髪, "整髪", Kaijo.values());
            setChosahyoMap(第２群, "2-10", 上衣の着脱, "上衣の着脱", Kaijo3.values());
            setChosahyoMap(第２群, "2-11", ズボン等の着脱, "ズボン等の着脱", Kaijo3.values());
            setChosahyoMap(第２群, "2-12", 外出頻度, "外出頻度", Gaishutsu.values());
            setChosahyoMap(第３群, "3-1", 意思の伝達, "意思の伝達", DekiruDekinai2.values());
            setChosahyoMap(第３群, "3-2", 毎日の日課を理解, "毎日の日課を理解", DekiruDekinai.values());
            setChosahyoMap(第３群, "3-3", 生年月日をいう, "生年月日や年齢を言う", DekiruDekinai.values());
            setChosahyoMap(第３群, "3-4", 短期記憶, "短期記憶", DekiruDekinai.values());
            setChosahyoMap(第３群, "3-5", 自分の名前をいう, "自分の名前を言う", DekiruDekinai.values());
            setChosahyoMap(第３群, "3-6", 今の季節を理解, "今の季節を理解する", DekiruDekinai.values());
            setChosahyoMap(第３群, "3-7", 場所の理解, "場所の理解", DekiruDekinai.values());
            setChosahyoMap(第３群, "3-8", 常時の徘徊, "徘徊", NaiAru2.values());
            setChosahyoMap(第３群, "3-9", 外出して戻れない, "外出すると戻れない", NaiAru2.values());
            setChosahyoMap(第４群, "4-1", 被害的, "被害的", NaiAru2.values());
            setChosahyoMap(第４群, "4-2", 作話, "作話", NaiAru2.values());
            setChosahyoMap(第４群, "4-3", 感情が不安定, "感情が不安定", NaiAru2.values());
            setChosahyoMap(第４群, "4-4", 昼夜逆転, "昼夜逆転", NaiAru2.values());
            setChosahyoMap(第４群, "4-5", 同じ話をする, "同じ話をする", NaiAru2.values());
            setChosahyoMap(第４群, "4-6", 大声を出す, "大声をだす", NaiAru2.values());
            setChosahyoMap(第４群, "4-7", 介護に抵抗, "介護に抵抗", NaiAru2.values());
            setChosahyoMap(第４群, "4-8", 落ち着きなし, "落ち着きなし", NaiAru2.values());
            setChosahyoMap(第４群, "4-9", 一人で出たがる, "一人で出たがる", NaiAru2.values());
            setChosahyoMap(第４群, "4-10", 収集癖, "収集癖", NaiAru2.values());
            setChosahyoMap(第４群, "4-11", 物や衣類を壊す, "物や衣類を壊す", NaiAru2.values());
            setChosahyoMap(第４群, "4-12", ひどい物忘れ, "ひどい物忘れ", NaiAru2.values());
            setChosahyoMap(第４群, "4-13", 独り言_独り笑, "独り言・独り笑い", NaiAru2.values());
            setChosahyoMap(第４群, "4-14", 自分勝手に行動する, "自分勝手に行動する", NaiAru2.values());
            setChosahyoMap(第４群, "4-15", 話がまとまらない, "話がまとまらない", NaiAru2.values());
            setChosahyoMap(第５群, "5-1", 薬の内服, "薬の内服", Kaijo.values());
            setChosahyoMap(第５群, "5-2", 金銭の管理, "金銭の管理", Kaijo.values());
            setChosahyoMap(第５群, "5-3", 日常の意思決定, "日常の意思決定", DekiruDekinai7.values());
            setChosahyoMap(第５群, "5-4", 集団への不適応, "集団への不適応", NaiAru2.values());
            setChosahyoMap(第５群, "5-5", 買い物, "買い物", Kaijo3.values());
            setChosahyoMap(第５群, "5-6", 簡単な調理, "簡単な調理", Kaijo3.values());
            setChosahyoMap(特別医療, 処置内容, 1, "6-1", 点滴の管理, "点滴の管理", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 2, "6-2", 中心静脈栄養, "中心静脈栄養", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 3, "6-3", 透析, "透析", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 4, "6-4", ストーマの処置, "ストーマの処置", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 5, "6-5", 酸素療法, "酸素療法", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 6, "6-6", レスピレーター, "レスピレーター", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 7, "6-7", 気管切開, "気管切開の処置", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 8, "6-8", 疼痛の看護, "疼痛の看護", OffOn.values());
            setChosahyoMap(特別医療, 処置内容, 9, "6-9", 経管栄養, "経管栄養", OffOn.values());
            setChosahyoMap(特別医療, 特別な対応, 1, "6-10", モニター測定, "モニター測定（血圧、心拍、酸素飽和度等）", OffOn.values());
            setChosahyoMap(特別医療, 特別な対応, 2, "6-11", じょくそうの処置, "じょくそうの処置", OffOn.values());
            setChosahyoMap(特別医療, 特別な対応, 3, "6-12", カテーテル, "カテーテル（コンドームカテーテル、留置カテーテル、ウロストーマ等）", OffOn.values());
            setChosahyoMap(自立度, "7-1", 障害高齢者の日常生活自立度, "障害高齢者の日常生活自立度（寝たきり度）", ShogaiJiritsu.values());
            setChosahyoMap(自立度, "7-2", 認知症高齢者の日常生活自立度, "認知症高齢者の日常生活自立度", NinchishoJiritsu.values());
        }

        private static void setChosahyoMap(IChosahyoItemGroup 調査票項目グループ,
                String 調査項目番号, ChosahyoItems 調査票項目, String 表示名称, IAnsweringItem[] 選択肢) {
            setChosahyoMap(調査票項目グループ, なし, 1, 調査項目番号, 調査票項目, 表示名称, 選択肢);
        }

        private static void setChosahyoMap(IChosahyoItemGroup 調査票項目グループ, IChosahyoItemSubGroup 調査票項目サブグループ, int 調査票項目サブグループ内番号,
                String 調査項目番号, ChosahyoItems 調査票項目, String 表示名称, IAnsweringItem[] 選択肢) {
            chosahyoMap.put(調査票項目, new NinteichosaItem(調査票項目グループ, 調査票項目サブグループ, 調査票項目サブグループ内番号,
                    new NinteichosaItemNo(new RString(調査項目番号)), 調査票項目, new RString(表示名称), new Choices(選択肢)));
        }

        @Override
        public Map<ChosahyoItems, INinteichosaItem> get調査票定義() {
            return chosahyoMap;
        }
    }
}
