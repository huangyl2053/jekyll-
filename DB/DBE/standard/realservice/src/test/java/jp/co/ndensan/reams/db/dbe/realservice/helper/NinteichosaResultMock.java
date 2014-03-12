/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaItemForResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaJisshibashoKubun;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urf.business._KaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business._NinteiChosain;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.definition.KaigoJigyoshaShubetsu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun.*;
import static org.mockito.Mockito.spy;

/**
 * NinteichosaResultを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultMock {

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
        return spy(new NinteichosaResult(getSpiedNinteichosaResultGaikyoInstance(), getSpiedNinteichosaResultKihonInstance()));
    }

    /**
     * NinteichosaResultGaikyoを生成して返します。
     *
     * @return NinteichosaResultOfGaikyo
     */
    public static NinteichosaResultOfGaikyo getSpiedNinteichosaResultGaikyoInstance() {
        Ninteichosahyo chosahyo = NinteichosahyoFactory.createサービス状況Instance(KoroshoIFKubun.V09A);

        List<NinteichosaItemForResult> list = new ArrayList<>();
        list.add(createResult(chosahyo, NinteichosaItemKubun.サービス区分コード, ServiceKubun.介護.getCode()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問介護, 0));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問入浴介護, 1));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問看護, 2));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問リハビリ, 3));
        list.add(createResult(chosahyo, NinteichosaItemKubun.居宅療養管理指導, 4));
        list.add(createResult(chosahyo, NinteichosaItemKubun.通所介護, 5));
        list.add(createResult(chosahyo, NinteichosaItemKubun.通所リハビリテーション, 6));
        list.add(createResult(chosahyo, NinteichosaItemKubun.短期入所生活介護, 7));
        list.add(createResult(chosahyo, NinteichosaItemKubun.短期入所療養介護, 8));
        list.add(createResult(chosahyo, NinteichosaItemKubun.特定施設入居者生活介護, 9));
        list.add(createResult(chosahyo, NinteichosaItemKubun.福祉用具貸与, 0));
        list.add(createResult(chosahyo, NinteichosaItemKubun.特定福祉用具販売, 1));
        list.add(createResult(chosahyo, NinteichosaItemKubun.住宅改修, 2));
        list.add(createResult(chosahyo, NinteichosaItemKubun.夜間対応型訪問介護, 3));
        list.add(createResult(chosahyo, NinteichosaItemKubun.認知症対応型通所介護, 4));
        list.add(createResult(chosahyo, NinteichosaItemKubun.小規模多機能型居宅介護, 5));
        list.add(createResult(chosahyo, NinteichosaItemKubun.認知症対応型共同生活介護, 6));
        list.add(createResult(chosahyo, NinteichosaItemKubun.地域密着型特定施設入居者生活介護, 7));
        list.add(createResult(chosahyo, NinteichosaItemKubun.地域密着型介護老人福祉施設入所者生活介護, 8));
        list.add(createResult(chosahyo, NinteichosaItemKubun.定期巡回_随時対応型訪問介護看護, 9));
        list.add(createResult(chosahyo, NinteichosaItemKubun.複合型サービス, 0));
        list.add(createResult(chosahyo, NinteichosaItemKubun.市町村特別給付, new RString("市町村特別給付")));
        list.add(createResult(chosahyo, NinteichosaItemKubun.介護保険給付以外の在宅サービス, new RString("介護保険給付以外の在宅サービス")));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設コード, new RString("利用施設コード")));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設名, new RString("利用施設名")));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設住所, new RString("利用施設住所")));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設電話番号, new RString("利用施設電話番号")));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設郵便番号, new RString("1234567")));
        list.add(createResult(chosahyo, NinteichosaItemKubun.概況特記事項, new RString("概況特記事項")));

        Map<NinteichosaItemKubun, NinteichosaItemForResult> map = new EnumMap<>(NinteichosaItemKubun.class);
        for (NinteichosaItemForResult data : list) {
            if (data != null) {
                map.put(data.get調査項目区分(), data);
            }
        }

        return spy(new NinteichosaResultOfGaikyo(
                new ShinseishoKanriNo(new RString("1234567890")),
                new NinteichosaIraiRirekiNo(0),
                KoroshoIFKubun.V09A,
                new NinteichosaResultOfGaikyoKihon(
                NinteichosaIraiKubunCode.初回,
                1,
                new FlexibleDate("20140101"),
                new FlexibleDate("20140202"),
                NinteichosaKubun.新規調査,
                new _NinteiChosain(new RString("12345678"), new _Name(new RString("氏名"), RString.EMPTY), createKaigoJigyosha()),
                new NinteichosaJisshibashoKubun(
                new NinteichosaJisshibashoKubunCode(new RString("12345678")), new RString("認定調査実施場所名称"), RString.EMPTY)),
                new Ninteichosahyo(map, NinteichosaItemGroup.Of2009.values())));
    }

    private static IKaigoJigyosha createKaigoJigyosha() {
        return new _KaigoJigyosha(
                new RString("事業者番号"), KaigoJigyoshaShubetsu.介護保険施設, RDate.MIN, RDate.MAX,
                new ShikibetsuCode(new RString("1234567890")), new RString("事業者略称"), new RString("事業者略称カナ"),
                new RString("事業者住所カナ"), new RString("異動事由"), RDate.MIN, new RString("社会福祉法人軽減対象区分"),
                new RString("地域差区分"), new RString("受領委任区分"), new RString("生活保護指定区分"), new RString("法人種別"),
                RDate.MAX, RDate.MIN, RDate.MAX, RDate.MIN);
    }

    /**
     * NinteichosaResultOfKihonを生成して返します。
     *
     * @return NinteichosaResultOfKihon
     */
    public static NinteichosaResultOfKihon getSpiedNinteichosaResultKihonInstance() {
        Ninteichosahyo chosahyo = NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A);

        List<NinteichosaItemForResult> list = new ArrayList<>();
        list.add(createResult(chosahyo, 麻痺等の有無_左上肢, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, 麻痺等の有無_右上肢, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 麻痺等の有無_左下肢, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, 麻痺等の有無_右下肢, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 麻痺等の有無_その他, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, 関節の動く範囲の制限_肩関節, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, 関節の動く範囲の制限_股関節, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 関節の動く範囲の制限_膝関節, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, 関節の動く範囲の制限_その他, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 寝返り, DekiruDekinai3.できる.getCode()));
        list.add(createResult(chosahyo, 起き上がり, DekiruDekinai3.できない.getCode()));
        list.add(createResult(chosahyo, 座位保持, DekiruDekinai6.できる.getCode()));
        list.add(createResult(chosahyo, 両足での立位, DekiruDekinai5.できない.getCode()));
        list.add(createResult(chosahyo, 歩行, DekiruDekinai3.できる.getCode()));
        list.add(createResult(chosahyo, 立ち上がり, DekiruDekinai3.できない.getCode()));
        list.add(createResult(chosahyo, 片足での立位, DekiruDekinai5.できる.getCode()));
        list.add(createResult(chosahyo, 洗身, Kaijo2.自立.getCode()));
        list.add(createResult(chosahyo, つめ切り, Kaijo.全介助.getCode()));
        list.add(createResult(chosahyo, 視力, Shiryoku.普通.getCode()));
        list.add(createResult(chosahyo, 聴力, Choryoku.判断不能.getCode()));
        list.add(createResult(chosahyo, 移乗, Kaijo3.自立.getCode()));
        list.add(createResult(chosahyo, 移動, Kaijo3.全介助.getCode()));
        list.add(createResult(chosahyo, 嚥下, DekiruDekinai4.できる.getCode()));
        list.add(createResult(chosahyo, 食事摂取, Kaijo3.自立.getCode()));
        list.add(createResult(chosahyo, 排尿, Kaijo3.全介助.getCode()));
        list.add(createResult(chosahyo, 排便, Kaijo3.自立.getCode()));
        list.add(createResult(chosahyo, 口腔清潔, Kaijo.全介助.getCode()));
        list.add(createResult(chosahyo, 洗顔, Kaijo.自立.getCode()));
        list.add(createResult(chosahyo, 整髪, Kaijo.全介助.getCode()));
        list.add(createResult(chosahyo, 上衣の着脱, Kaijo3.自立.getCode()));
        list.add(createResult(chosahyo, ズボン等の着脱, Kaijo3.全介助.getCode()));
        list.add(createResult(chosahyo, 外出頻度, Gaishutsu.月１回以上.getCode()));
        list.add(createResult(chosahyo, 意思の伝達, DekiruDekinai2.できる.getCode()));
        list.add(createResult(chosahyo, 毎日の日課を理解, DekiruDekinai.できない.getCode()));
        list.add(createResult(chosahyo, 生年月日をいう, DekiruDekinai.できる.getCode()));
        list.add(createResult(chosahyo, 短期記憶, DekiruDekinai.できない.getCode()));
        list.add(createResult(chosahyo, 自分の名前をいう, DekiruDekinai.できる.getCode()));
        list.add(createResult(chosahyo, 今の季節を理解, DekiruDekinai.できない.getCode()));
        list.add(createResult(chosahyo, 場所の理解, DekiruDekinai.できる.getCode()));
        list.add(createResult(chosahyo, 常時の徘徊, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 外出して戻れない, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 被害的, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 作話, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 感情が不安定, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 昼夜逆転, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 同じ話をする, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 大声を出す, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 介護に抵抗, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 落ち着きなし, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 一人で出たがる, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 収集癖, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 物や衣類を壊す, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, ひどい物忘れ, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 独り言_独り笑, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 自分勝手に行動する, NaiAru2.ある.getCode()));
        list.add(createResult(chosahyo, 話がまとまらない, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 薬の内服, Kaijo.自立.getCode()));
        list.add(createResult(chosahyo, 金銭の管理, Kaijo.全介助.getCode()));
        list.add(createResult(chosahyo, 日常の意思決定, DekiruDekinai7.できる.getCode()));
        list.add(createResult(chosahyo, 集団への不適応, NaiAru2.ない.getCode()));
        list.add(createResult(chosahyo, 買い物, Kaijo3.自立.getCode()));
        list.add(createResult(chosahyo, 簡単な調理, Kaijo3.全介助.getCode()));
        list.add(createResult(chosahyo, 点滴の管理, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, 中心静脈栄養, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 透析, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, ストーマの処置, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 酸素療法, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, レスピレーター, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 気管切開, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, 疼痛の看護, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 経管栄養, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, モニター測定, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, じょくそうの処置, NaiAru.ない.getCode()));
        list.add(createResult(chosahyo, カテーテル, NaiAru.ある.getCode()));
        list.add(createResult(chosahyo, 障害高齢者の日常生活自立度, ShogaiJiritsu.Ａ１.getCode()));
        list.add(createResult(chosahyo, 認知症高齢者の日常生活自立度, NinchishoJiritsu.Ⅱａ.getCode()));

        Map<NinteichosaItemKubun, NinteichosaItemForResult> map = new EnumMap<>(NinteichosaItemKubun.class);
        for (NinteichosaItemForResult data : list) {
            if (data != null) {
                map.put(data.get調査項目区分(), data);
            }
        }

        return new NinteichosaResultOfKihon(new ShinseishoKanriNo(new RString("1234567890")), new NinteichosaIraiRirekiNo(0),
                KoroshoIFKubun.V09A, new Ninteichosahyo(map, NinteichosaItemGroup.Of2009.values()));
    }

    private static NinteichosaItemForResult createResult(Ninteichosahyo 調査票, NinteichosaItemKubun 調査項目区分, RString 調査結果) {
        INinteichosaItem item = 調査票.get調査項目(調査項目区分);
        return item == null ? null : new NinteichosaItemForResult(item, 調査結果);
    }

    private static NinteichosaItemForResult createResult(Ninteichosahyo 調査票, NinteichosaItemKubun 調査項目区分, int 調査結果) {
        return createResult(調査票, 調査項目区分, new RString(String.valueOf(調査結果)));
    }
}
