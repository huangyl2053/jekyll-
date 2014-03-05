/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaItemResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfChosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoService;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems.*;
import static org.mockito.Mockito.spy;

/**
 * NinteichosaResultを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultMock {

    private static final int NENDO_2006 = 2006;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosaResultMock() {
    }

    /**
     * NinteichosaResultを生成して返します。
     *
     * @return NinteichosaResult
     */
    public static NinteichosaResult getSpiedNinteichosaResultInstance() {
        return spy(new NinteichosaResult(getSpiedNinteichosaResultChosahyoInstance(), getSpiedNinteichosaResultGaikyoInstance()));
    }

    /**
     * NinteichosaResultChosahyoを生成して返します。
     *
     * @return NinteichosaResultOfChosahyo
     */
    public static NinteichosaResultOfChosahyo getSpiedNinteichosaResultChosahyoInstance() {
        Map<ChosahyoItems, NinteichosaItemResult> resultMap = new EnumMap<>(ChosahyoItems.class);
        Ninteichosahyo chosahyo = NinteichosahyoFactory.createInstance(NENDO_2006);
        setResultMap(resultMap, chosahyo, 麻痺等の有無_左上肢, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, 麻痺等の有無_右上肢, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 麻痺等の有無_左下肢, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, 麻痺等の有無_右下肢, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 麻痺等の有無_その他, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, 関節の動く範囲の制限_肩関節, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, 関節の動く範囲の制限_股関節, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 関節の動く範囲の制限_膝関節, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, 関節の動く範囲の制限_その他, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 寝返り, DekiruDekinai3.できる.getCode());
        setResultMap(resultMap, chosahyo, 起き上がり, DekiruDekinai3.できない.getCode());
        setResultMap(resultMap, chosahyo, 座位保持, DekiruDekinai6.できる.getCode());
        setResultMap(resultMap, chosahyo, 両足での立位, DekiruDekinai5.できない.getCode());
        setResultMap(resultMap, chosahyo, 歩行, DekiruDekinai3.できる.getCode());
        setResultMap(resultMap, chosahyo, 立ち上がり, DekiruDekinai3.できない.getCode());
        setResultMap(resultMap, chosahyo, 片足での立位, DekiruDekinai5.できる.getCode());
        setResultMap(resultMap, chosahyo, 洗身, Kaijo2.自立.getCode());
        setResultMap(resultMap, chosahyo, つめ切り, Kaijo.全介助.getCode());
        setResultMap(resultMap, chosahyo, 視力, Shiryoku.普通.getCode());
        setResultMap(resultMap, chosahyo, 聴力, Choryoku.判断不能.getCode());
        setResultMap(resultMap, chosahyo, 移乗, Kaijo3.自立.getCode());
        setResultMap(resultMap, chosahyo, 移動, Kaijo3.全介助.getCode());
        setResultMap(resultMap, chosahyo, 嚥下, DekiruDekinai4.できる.getCode());
        setResultMap(resultMap, chosahyo, 食事摂取, Kaijo3.自立.getCode());
        setResultMap(resultMap, chosahyo, 排尿, Kaijo3.全介助.getCode());
        setResultMap(resultMap, chosahyo, 排便, Kaijo3.自立.getCode());
        setResultMap(resultMap, chosahyo, 口腔清潔, Kaijo.全介助.getCode());
        setResultMap(resultMap, chosahyo, 洗顔, Kaijo.自立.getCode());
        setResultMap(resultMap, chosahyo, 整髪, Kaijo.全介助.getCode());
        setResultMap(resultMap, chosahyo, 上衣の着脱, Kaijo3.自立.getCode());
        setResultMap(resultMap, chosahyo, ズボン等の着脱, Kaijo3.全介助.getCode());
        setResultMap(resultMap, chosahyo, 外出頻度, Gaishutsu.月１回以上.getCode());
        setResultMap(resultMap, chosahyo, 意思の伝達, DekiruDekinai2.できる.getCode());
        setResultMap(resultMap, chosahyo, 毎日の日課を理解, DekiruDekinai.できない.getCode());
        setResultMap(resultMap, chosahyo, 生年月日をいう, DekiruDekinai.できる.getCode());
        setResultMap(resultMap, chosahyo, 短期記憶, DekiruDekinai.できない.getCode());
        setResultMap(resultMap, chosahyo, 自分の名前をいう, DekiruDekinai.できる.getCode());
        setResultMap(resultMap, chosahyo, 今の季節を理解, DekiruDekinai.できない.getCode());
        setResultMap(resultMap, chosahyo, 場所の理解, DekiruDekinai.できる.getCode());
        setResultMap(resultMap, chosahyo, 常時の徘徊, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 外出して戻れない, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 被害的, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 作話, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 感情が不安定, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 昼夜逆転, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 同じ話をする, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 大声を出す, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 介護に抵抗, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 落ち着きなし, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 一人で出たがる, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 収集癖, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 物や衣類を壊す, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, ひどい物忘れ, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 独り言_独り笑, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 自分勝手に行動する, NaiAru2.ある.getCode());
        setResultMap(resultMap, chosahyo, 話がまとまらない, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 薬の内服, Kaijo.自立.getCode());
        setResultMap(resultMap, chosahyo, 金銭の管理, Kaijo.全介助.getCode());
        setResultMap(resultMap, chosahyo, 日常の意思決定, DekiruDekinai7.できる.getCode());
        setResultMap(resultMap, chosahyo, 集団への不適応, NaiAru2.ない.getCode());
        setResultMap(resultMap, chosahyo, 買い物, Kaijo3.自立.getCode());
        setResultMap(resultMap, chosahyo, 簡単な調理, Kaijo3.全介助.getCode());
        setResultMap(resultMap, chosahyo, 点滴の管理, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, 中心静脈栄養, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 透析, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, ストーマの処置, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 酸素療法, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, レスピレーター, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 気管切開, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, 疼痛の看護, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 経管栄養, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, モニター測定, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, じょくそうの処置, NaiAru.ない.getCode());
        setResultMap(resultMap, chosahyo, カテーテル, NaiAru.ある.getCode());
        setResultMap(resultMap, chosahyo, 障害高齢者の日常生活自立度, ShogaiJiritsu.Ａ１.getCode());
        setResultMap(resultMap, chosahyo, 認知症高齢者の日常生活自立度, NinchishoJiritsu.Ⅱａ.getCode());
        return new NinteichosaResultOfChosahyo(new ShinseishoKanriNo(new RString("1234567890")), new NinteichosaIraiRirekiNo(0),
                NENDO_2006, new Ninteichosahyo(resultMap, ChosahyoItemGroup.Of2006.values()));
    }

    private static void setResultMap(
            Map<ChosahyoItems, NinteichosaItemResult> 調査結果Map, Ninteichosahyo 調査票, ChosahyoItems 調査票項目, RString 調査結果) {
        調査結果Map.put(調査票項目, new NinteichosaItemResult((NinteichosaItem) 調査票.get調査項目(調査票項目), 調査結果));
    }

    /**
     * NinteichosaResultGaikyoを生成して返します。
     *
     * @return NinteichosaResultOfGaikyo
     */
    public static NinteichosaResultOfGaikyo getSpiedNinteichosaResultGaikyoInstance() {
        return spy(new NinteichosaResultOfGaikyo(new ShinseishoKanriNo(new RString("1234567890")), new NinteichosaIraiRirekiNo(0),
                getSpiedNinteichosaResultGaikyoKihonInstance(), getSpiedNinteichosaResultGaikyoServiceInstance()));
    }

    /**
     * NinteichosaResultGaikyoKihonを生成して返します。
     *
     * @return NinteichosaResultOfGaikyoKihon
     */
    public static NinteichosaResultOfGaikyoKihon getSpiedNinteichosaResultGaikyoKihonInstance() {
        return spy(new NinteichosaResultOfGaikyoKihon(
                new FlexibleDate("20140101"),
                ChosaIraiKubun.初回,
                new RString("12345678"),
                new RString("認定調査実施場所名称"),
                ChosaKubun.新規調査,
                new RString("概況特記事項"),
                ShinsakaiFuriwakeKubun.希望無し));
    }

    /**
     * NinteichosaResultGaikyoServiceを生成して返します。
     *
     * @return NinteichosaResultOfGaikyoService
     */
    public static NinteichosaResultOfGaikyoService getSpiedNinteichosaResultGaikyoServiceInstance() {
        return spy(new NinteichosaResultOfGaikyoService(
                ServiceKubun.介護給付サービス,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                GenzaiJokyoKubun.指定介護療養型医療施設,
                new RString("市町村特別給付"),
                new RString("介護保険給付以外の在宅サービス")));
    }
}
