/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import java.util.EnumMap;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaItemForResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaJisshibashoKubun;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urf.business._KaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business._NinteiChosain;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.definition.KaigoJigyoshaShubetsu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Choice.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfGaikyo.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon.*;
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

        Ninteichosahyo 調査票 = NinteichosahyoFactory.createサービス状況Instance(KoroshoIFKubun.V09A);

        Ninteichosahyo result = new Ninteichosahyo(new EnumMap<>(NinteichosaItemKubunOfGaikyo.class), NinteichosaItemGroupOf2009.values());
        result.set調査項目(create調査結果(調査票, サービス区分コード, ServiceKubun.介護.getCode()));
        result.set調査項目(create調査結果(調査票, 訪問介護, new RString("0")));
        result.set調査項目(create調査結果(調査票, 訪問入浴介護, new RString("1")));
        result.set調査項目(create調査結果(調査票, 訪問看護, new RString("2")));
        result.set調査項目(create調査結果(調査票, 訪問リハビリ, new RString("3")));
        result.set調査項目(create調査結果(調査票, 居宅療養管理指導, new RString("4")));
        result.set調査項目(create調査結果(調査票, 通所介護, new RString("5")));
        result.set調査項目(create調査結果(調査票, 通所リハビリテーション, new RString("6")));
        result.set調査項目(create調査結果(調査票, 短期入所生活介護, new RString("7")));
        result.set調査項目(create調査結果(調査票, 短期入所療養介護, new RString("8")));
        result.set調査項目(create調査結果(調査票, 特定施設入居者生活介護, new RString("9")));
        result.set調査項目(create調査結果(調査票, 福祉用具貸与, new RString("0")));
        result.set調査項目(create調査結果(調査票, 特定福祉用具販売, new RString("1")));
        result.set調査項目(create調査結果(調査票, 住宅改修, new RString("2")));
        result.set調査項目(create調査結果(調査票, 夜間対応型訪問介護, new RString("3")));
        result.set調査項目(create調査結果(調査票, 認知症対応型通所介護, new RString("4")));
        result.set調査項目(create調査結果(調査票, 小規模多機能型居宅介護, new RString("5")));
        result.set調査項目(create調査結果(調査票, 認知症対応型共同生活介護, new RString("6")));
        result.set調査項目(create調査結果(調査票, 地域密着型特定施設入居者生活介護, new RString("7")));
        result.set調査項目(create調査結果(調査票, 地域密着型介護老人福祉施設入所者生活介護, new RString("8")));
        result.set調査項目(create調査結果(調査票, 定期巡回_随時対応型訪問介護看護, new RString("9")));
        result.set調査項目(create調査結果(調査票, 複合型サービス, new RString("0")));
        result.set調査項目(create調査結果(調査票, 市町村特別給付, new RString("市町村特別給付")));
        result.set調査項目(create調査結果(調査票, 介護保険給付以外の在宅サービス, new RString("介護保険給付以外の在宅サービス")));
        result.set調査項目(create調査結果(調査票, 利用施設コード, new RString("利用施設コード")));
        result.set調査項目(create調査結果(調査票, 利用施設名, new RString("利用施設名")));
        result.set調査項目(create調査結果(調査票, 利用施設住所, new RString("利用施設住所")));
        result.set調査項目(create調査結果(調査票, 利用施設電話番号, new RString("利用施設電話番号")));
        result.set調査項目(create調査結果(調査票, 利用施設郵便番号, new RString("1234567")));
        result.set調査項目(create調査結果(調査票, 概況特記事項, new RString("概況特記事項")));

        return spy(new NinteichosaResultOfGaikyo(
                new ShinseishoKanriNo(new RString("1234567890")),
                new NinteichosaIraiRirekiNo(0),
                KoroshoIFKubun.V09A,
                new NinteichosaResultOfGaikyoKihon(
                NinteichosaIraiKubun.初回,
                1,
                new FlexibleDate("20140101"),
                new FlexibleDate("20140202"),
                NinteichosaKubun.新規調査,
                new _NinteiChosain(new RString("12345678"), new _Name(new AtenaMeisho("氏名"), new AtenaKanaMeisho("")), createKaigoJigyosha()),
                new NinteichosaJisshibashoKubun(
                new NinteichosaJisshibashoKubunCode(new RString("12345678")), new RString("認定調査実施場所名称"), RString.EMPTY)),
                result));
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

        Ninteichosahyo 調査票 = NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A);

        Ninteichosahyo result = new Ninteichosahyo(new EnumMap<>(NinteichosaItemKubunOfKihon.class), NinteichosaItemGroupOf2009.values());
        result.set調査項目(create調査結果(調査票, 麻痺等の有無_左上肢, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 麻痺等の有無_右上肢, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 麻痺等の有無_左下肢, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 麻痺等の有無_右下肢, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 麻痺等の有無_その他, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 関節の動く範囲の制限_肩関節, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 関節の動く範囲の制限_股関節, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 関節の動く範囲の制限_膝関節, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 関節の動く範囲の制限_その他, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 寝返り, DekiruDekinai3.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 起き上がり, DekiruDekinai3.できない.getCode()));
        result.set調査項目(create調査結果(調査票, 座位保持, DekiruDekinai6.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 両足での立位, DekiruDekinai5.できない.getCode()));
        result.set調査項目(create調査結果(調査票, 歩行, DekiruDekinai3.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 立ち上がり, DekiruDekinai3.できない.getCode()));
        result.set調査項目(create調査結果(調査票, 片足での立位, DekiruDekinai5.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 洗身, Kaijo2.自立.getCode()));
        result.set調査項目(create調査結果(調査票, つめ切り, Kaijo.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 視力, Shiryoku.普通.getCode()));
        result.set調査項目(create調査結果(調査票, 聴力, Choryoku.判断不能.getCode()));
        result.set調査項目(create調査結果(調査票, 移乗, Kaijo3.自立.getCode()));
        result.set調査項目(create調査結果(調査票, 移動, Kaijo3.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 嚥下, DekiruDekinai4.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 食事摂取, Kaijo3.自立.getCode()));
        result.set調査項目(create調査結果(調査票, 排尿, Kaijo3.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 排便, Kaijo3.自立.getCode()));
        result.set調査項目(create調査結果(調査票, 口腔清潔, Kaijo.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 洗顔, Kaijo.自立.getCode()));
        result.set調査項目(create調査結果(調査票, 整髪, Kaijo.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 上衣の着脱, Kaijo3.自立.getCode()));
        result.set調査項目(create調査結果(調査票, ズボン等の着脱, Kaijo3.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 外出頻度, Gaishutsu.月１回以上.getCode()));
        result.set調査項目(create調査結果(調査票, 意思の伝達, DekiruDekinai2.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 毎日の日課を理解, DekiruDekinai.できない.getCode()));
        result.set調査項目(create調査結果(調査票, 生年月日をいう, DekiruDekinai.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 短期記憶, DekiruDekinai.できない.getCode()));
        result.set調査項目(create調査結果(調査票, 自分の名前をいう, DekiruDekinai.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 今の季節を理解, DekiruDekinai.できない.getCode()));
        result.set調査項目(create調査結果(調査票, 場所の理解, DekiruDekinai.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 常時の徘徊, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 外出して戻れない, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 被害的, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 作話, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 感情が不安定, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 昼夜逆転, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 同じ話をする, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 大声を出す, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 介護に抵抗, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 落ち着きなし, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 一人で出たがる, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 収集癖, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 物や衣類を壊す, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, ひどい物忘れ, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 独り言_独り笑, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 自分勝手に行動する, NaiAru2.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 話がまとまらない, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 薬の内服, Kaijo.自立.getCode()));
        result.set調査項目(create調査結果(調査票, 金銭の管理, Kaijo.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 日常の意思決定, DekiruDekinai7.できる.getCode()));
        result.set調査項目(create調査結果(調査票, 集団への不適応, NaiAru2.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 買い物, Kaijo3.自立.getCode()));
        result.set調査項目(create調査結果(調査票, 簡単な調理, Kaijo3.全介助.getCode()));
        result.set調査項目(create調査結果(調査票, 点滴の管理, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 中心静脈栄養, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 透析, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, ストーマの処置, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 酸素療法, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, レスピレーター, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 気管切開, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, 疼痛の看護, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 経管栄養, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, モニター測定, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, じょくそうの処置, NaiAru.ない.getCode()));
        result.set調査項目(create調査結果(調査票, カテーテル, NaiAru.ある.getCode()));
        result.set調査項目(create調査結果(調査票, 障害高齢者の日常生活自立度, ShogaiJiritsu.Ａ１.getCode()));
        result.set調査項目(create調査結果(調査票, 認知症高齢者の日常生活自立度, NinchishoJiritsu.Ⅱａ.getCode()));

        return new NinteichosaResultOfKihon(new ShinseishoKanriNo(new RString("1234567890")), new NinteichosaIraiRirekiNo(0), KoroshoIFKubun.V09A, result);
    }

    private static NinteichosaItemForResult create調査結果(Ninteichosahyo 調査票, INinteichosaItemKubun 調査項目区分, RString 調査結果) {
        NinteichosaItem item = (NinteichosaItem) 調査票.get調査項目(調査項目区分);
        return item == null ? null : new NinteichosaItemForResult(item, 調査結果);
    }
}
