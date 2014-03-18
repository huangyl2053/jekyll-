/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import java.util.EnumMap;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaJisshibashoKubun;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaKekkaConverter;
import jp.co.ndensan.reams.ur.urf.business._KaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business._NinteiChosain;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.definition.KaigoJigyoshaShubetsu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.*;
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

        NinteichosaKekkaConverter converter = new NinteichosaKekkaConverter(NinteichosahyoFactory.createサービス状況Instance(KoroshoIFKubun.V09A));

        Ninteichosahyo result = new Ninteichosahyo(new EnumMap<>(NinteichosaItemKubunOfGaikyo.class), NinteichosaItemGroup.Of2009.values());
        result.set調査項目(converter.create調査結果(サービス区分コード, ServiceKubun.介護.getValue()));
        result.set調査項目(converter.create調査結果(訪問介護, 0));
        result.set調査項目(converter.create調査結果(訪問入浴介護, 1));
        result.set調査項目(converter.create調査結果(訪問看護, 2));
        result.set調査項目(converter.create調査結果(訪問リハビリ, 3));
        result.set調査項目(converter.create調査結果(居宅療養管理指導, 4));
        result.set調査項目(converter.create調査結果(通所介護, 5));
        result.set調査項目(converter.create調査結果(通所リハビリテーション, 6));
        result.set調査項目(converter.create調査結果(短期入所生活介護, 7));
        result.set調査項目(converter.create調査結果(短期入所療養介護, 8));
        result.set調査項目(converter.create調査結果(特定施設入居者生活介護, 9));
        result.set調査項目(converter.create調査結果(福祉用具貸与, 0));
        result.set調査項目(converter.create調査結果(特定福祉用具販売, 1));
        result.set調査項目(converter.create調査結果(住宅改修, 2));
        result.set調査項目(converter.create調査結果(夜間対応型訪問介護, 3));
        result.set調査項目(converter.create調査結果(認知症対応型通所介護, 4));
        result.set調査項目(converter.create調査結果(小規模多機能型居宅介護, 5));
        result.set調査項目(converter.create調査結果(認知症対応型共同生活介護, 6));
        result.set調査項目(converter.create調査結果(地域密着型特定施設入居者生活介護, 7));
        result.set調査項目(converter.create調査結果(地域密着型介護老人福祉施設入所者生活介護, 8));
        result.set調査項目(converter.create調査結果(定期巡回_随時対応型訪問介護看護, 9));
        result.set調査項目(converter.create調査結果(複合型サービス, 0));
        result.set調査項目(converter.create調査結果(市町村特別給付, new RString("市町村特別給付")));
        result.set調査項目(converter.create調査結果(介護保険給付以外の在宅サービス, new RString("介護保険給付以外の在宅サービス")));
        result.set調査項目(converter.create調査結果(利用施設コード, new RString("利用施設コード")));
        result.set調査項目(converter.create調査結果(利用施設名, new RString("利用施設名")));
        result.set調査項目(converter.create調査結果(利用施設住所, new RString("利用施設住所")));
        result.set調査項目(converter.create調査結果(利用施設電話番号, new RString("利用施設電話番号")));
        result.set調査項目(converter.create調査結果(利用施設郵便番号, new RString("1234567")));
        result.set調査項目(converter.create調査結果(概況特記事項, new RString("概況特記事項")));

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
                new _ShikibetsuCode(new RString("1234567890")), new RString("事業者略称"), new RString("事業者略称カナ"),
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

        NinteichosaKekkaConverter converter = new NinteichosaKekkaConverter(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A));

        Ninteichosahyo result = new Ninteichosahyo(new EnumMap<>(NinteichosaItemKubunOfKihon.class), NinteichosaItemGroup.Of2009.values());
        result.set調査項目(converter.create調査結果(麻痺等の有無_左上肢, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(麻痺等の有無_右上肢, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(麻痺等の有無_左下肢, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(麻痺等の有無_右下肢, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(麻痺等の有無_その他, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(関節の動く範囲の制限_肩関節, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(関節の動く範囲の制限_股関節, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(関節の動く範囲の制限_膝関節, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(関節の動く範囲の制限_その他, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(寝返り, DekiruDekinai3.できる.getValue()));
        result.set調査項目(converter.create調査結果(起き上がり, DekiruDekinai3.できない.getValue()));
        result.set調査項目(converter.create調査結果(座位保持, DekiruDekinai6.できる.getValue()));
        result.set調査項目(converter.create調査結果(両足での立位, DekiruDekinai5.できない.getValue()));
        result.set調査項目(converter.create調査結果(歩行, DekiruDekinai3.できる.getValue()));
        result.set調査項目(converter.create調査結果(立ち上がり, DekiruDekinai3.できない.getValue()));
        result.set調査項目(converter.create調査結果(片足での立位, DekiruDekinai5.できる.getValue()));
        result.set調査項目(converter.create調査結果(洗身, Kaijo2.自立.getValue()));
        result.set調査項目(converter.create調査結果(つめ切り, Kaijo.全介助.getValue()));
        result.set調査項目(converter.create調査結果(視力, Shiryoku.普通.getValue()));
        result.set調査項目(converter.create調査結果(聴力, Choryoku.判断不能.getValue()));
        result.set調査項目(converter.create調査結果(移乗, Kaijo3.自立.getValue()));
        result.set調査項目(converter.create調査結果(移動, Kaijo3.全介助.getValue()));
        result.set調査項目(converter.create調査結果(嚥下, DekiruDekinai4.できる.getValue()));
        result.set調査項目(converter.create調査結果(食事摂取, Kaijo3.自立.getValue()));
        result.set調査項目(converter.create調査結果(排尿, Kaijo3.全介助.getValue()));
        result.set調査項目(converter.create調査結果(排便, Kaijo3.自立.getValue()));
        result.set調査項目(converter.create調査結果(口腔清潔, Kaijo.全介助.getValue()));
        result.set調査項目(converter.create調査結果(洗顔, Kaijo.自立.getValue()));
        result.set調査項目(converter.create調査結果(整髪, Kaijo.全介助.getValue()));
        result.set調査項目(converter.create調査結果(上衣の着脱, Kaijo3.自立.getValue()));
        result.set調査項目(converter.create調査結果(ズボン等の着脱, Kaijo3.全介助.getValue()));
        result.set調査項目(converter.create調査結果(外出頻度, Gaishutsu.月１回以上.getValue()));
        result.set調査項目(converter.create調査結果(意思の伝達, DekiruDekinai2.できる.getValue()));
        result.set調査項目(converter.create調査結果(毎日の日課を理解, DekiruDekinai.できない.getValue()));
        result.set調査項目(converter.create調査結果(生年月日をいう, DekiruDekinai.できる.getValue()));
        result.set調査項目(converter.create調査結果(短期記憶, DekiruDekinai.できない.getValue()));
        result.set調査項目(converter.create調査結果(自分の名前をいう, DekiruDekinai.できる.getValue()));
        result.set調査項目(converter.create調査結果(今の季節を理解, DekiruDekinai.できない.getValue()));
        result.set調査項目(converter.create調査結果(場所の理解, DekiruDekinai.できる.getValue()));
        result.set調査項目(converter.create調査結果(常時の徘徊, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(外出して戻れない, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(被害的, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(作話, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(感情が不安定, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(昼夜逆転, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(同じ話をする, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(大声を出す, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(介護に抵抗, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(落ち着きなし, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(一人で出たがる, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(収集癖, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(物や衣類を壊す, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(ひどい物忘れ, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(独り言_独り笑, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(自分勝手に行動する, NaiAru2.ある.getValue()));
        result.set調査項目(converter.create調査結果(話がまとまらない, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(薬の内服, Kaijo.自立.getValue()));
        result.set調査項目(converter.create調査結果(金銭の管理, Kaijo.全介助.getValue()));
        result.set調査項目(converter.create調査結果(日常の意思決定, DekiruDekinai7.できる.getValue()));
        result.set調査項目(converter.create調査結果(集団への不適応, NaiAru2.ない.getValue()));
        result.set調査項目(converter.create調査結果(買い物, Kaijo3.自立.getValue()));
        result.set調査項目(converter.create調査結果(簡単な調理, Kaijo3.全介助.getValue()));
        result.set調査項目(converter.create調査結果(点滴の管理, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(中心静脈栄養, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(透析, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(ストーマの処置, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(酸素療法, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(レスピレーター, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(気管切開, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(疼痛の看護, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(経管栄養, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(モニター測定, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(じょくそうの処置, NaiAru.ない.getValue()));
        result.set調査項目(converter.create調査結果(カテーテル, NaiAru.ある.getValue()));
        result.set調査項目(converter.create調査結果(障害高齢者の日常生活自立度, ShogaiJiritsu.Ａ１.getValue()));
        result.set調査項目(converter.create調査結果(認知症高齢者の日常生活自立度, NinchishoJiritsu.Ⅱａ.getValue()));

        return new NinteichosaResultOfKihon(new ShinseishoKanriNo(new RString("1234567890")), new NinteichosaIraiRirekiNo(0), KoroshoIFKubun.V09A, result);
    }
}
