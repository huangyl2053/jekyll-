/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaJisshibashoKubun;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResultOfKihon;
import jp.co.ndensan.reams.db.dbe.business.core.chosahyo.NinteichosahyoEditor;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaJisshibashoKubunCode;
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
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChoiceResultItem.*;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfGaikyo.*;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfKihon.*;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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

        NinteichosahyoEditor editor = new NinteichosahyoEditor(NinteichosahyoFactory.createサービス状況Instance(KoroshoIFKubun.V09A));
        editor.setResult(サービス区分コード, ServiceKubun.介護.getCode());
        editor.setResult(訪問介護, new RString("0"));
        editor.setResult(訪問入浴介護, new RString("1"));
        editor.setResult(訪問看護, new RString("2"));
        editor.setResult(訪問リハビリ, new RString("3"));
        editor.setResult(居宅療養管理指導, new RString("4"));
        editor.setResult(通所介護, new RString("5"));
        editor.setResult(通所リハビリテーション, new RString("6"));
        editor.setResult(短期入所生活介護, new RString("7"));
        editor.setResult(短期入所療養介護, new RString("8"));
        editor.setResult(特定施設入居者生活介護, new RString("9"));
        editor.setResult(福祉用具貸与, new RString("0"));
        editor.setResult(特定福祉用具販売, new RString("1"));
        editor.setResult(住宅改修, new RString("2"));
        editor.setResult(夜間対応型訪問介護, new RString("3"));
        editor.setResult(認知症対応型通所介護, new RString("4"));
        editor.setResult(小規模多機能型居宅介護, new RString("5"));
        editor.setResult(認知症対応型共同生活介護, new RString("6"));
        editor.setResult(地域密着型特定施設入居者生活介護, new RString("7"));
        editor.setResult(地域密着型介護老人福祉施設入所者生活介護, new RString("8"));
        editor.setResult(定期巡回_随時対応型訪問介護看護, new RString("9"));
        editor.setResult(複合型サービス, new RString("0"));
        editor.setResult(市町村特別給付, new RString("市町村特別給付"));
        editor.setResult(介護保険給付以外の在宅サービス, new RString("介護保険給付以外の在宅サービス"));
        editor.setResult(利用施設コード, new RString("利用施設コード"));
        editor.setResult(利用施設名, new RString("利用施設名"));
        editor.setResult(利用施設住所, new RString("利用施設住所"));
        editor.setResult(利用施設電話番号, new RString("利用施設電話番号"));
        editor.setResult(利用施設郵便番号, new RString("1234567"));
        editor.setResult(概況特記事項, new RString("概況特記事項"));

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
                new NinteichosaJisshibashoKubunCode(new Code(new RString("12345678"))).asCode(), new RString("認定調査実施場所名称"), RString.EMPTY)),
                editor.getNinteichosahyo()));
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

        NinteichosahyoEditor editor = new NinteichosahyoEditor(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A));
        editor.setResult(麻痺等の有無_左上肢, NaiAru.ない.getCode());
        editor.setResult(麻痺等の有無_右上肢, NaiAru.ある.getCode());
        editor.setResult(麻痺等の有無_左下肢, NaiAru.ない.getCode());
        editor.setResult(麻痺等の有無_右下肢, NaiAru.ある.getCode());
        editor.setResult(麻痺等の有無_その他, NaiAru.ない.getCode());
        editor.setResult(関節の動く範囲の制限_肩関節, NaiAru.ない.getCode());
        editor.setResult(関節の動く範囲の制限_股関節, NaiAru.ある.getCode());
        editor.setResult(関節の動く範囲の制限_膝関節, NaiAru.ない.getCode());
        editor.setResult(関節の動く範囲の制限_その他, NaiAru.ある.getCode());
        editor.setResult(寝返り, DekiruDekinai3.できる.getCode());
        editor.setResult(起き上がり, DekiruDekinai3.できない.getCode());
        editor.setResult(座位保持, DekiruDekinai6.できる.getCode());
        editor.setResult(両足での立位, DekiruDekinai5.できない.getCode());
        editor.setResult(歩行, DekiruDekinai3.できる.getCode());
        editor.setResult(立ち上がり, DekiruDekinai3.できない.getCode());
        editor.setResult(片足での立位, DekiruDekinai5.できる.getCode());
        editor.setResult(洗身, Kaijo2.自立.getCode());
        editor.setResult(つめ切り, Kaijo.全介助.getCode());
        editor.setResult(視力, Shiryoku.普通.getCode());
        editor.setResult(聴力, Choryoku.判断不能.getCode());
        editor.setResult(移乗, Kaijo3.自立.getCode());
        editor.setResult(移動, Kaijo3.全介助.getCode());
        editor.setResult(嚥下, DekiruDekinai4.できる.getCode());
        editor.setResult(食事摂取, Kaijo3.自立.getCode());
        editor.setResult(排尿, Kaijo3.全介助.getCode());
        editor.setResult(排便, Kaijo3.自立.getCode());
        editor.setResult(口腔清潔, Kaijo.全介助.getCode());
        editor.setResult(洗顔, Kaijo.自立.getCode());
        editor.setResult(整髪, Kaijo.全介助.getCode());
        editor.setResult(上衣の着脱, Kaijo3.自立.getCode());
        editor.setResult(ズボン等の着脱, Kaijo3.全介助.getCode());
        editor.setResult(外出頻度, Gaishutsu.月１回以上.getCode());
        editor.setResult(意思の伝達, DekiruDekinai2.できる.getCode());
        editor.setResult(毎日の日課を理解, DekiruDekinai.できない.getCode());
        editor.setResult(生年月日をいう, DekiruDekinai.できる.getCode());
        editor.setResult(短期記憶, DekiruDekinai.できない.getCode());
        editor.setResult(自分の名前をいう, DekiruDekinai.できる.getCode());
        editor.setResult(今の季節を理解, DekiruDekinai.できない.getCode());
        editor.setResult(場所の理解, DekiruDekinai.できる.getCode());
        editor.setResult(常時の徘徊, NaiAru2.ない.getCode());
        editor.setResult(外出して戻れない, NaiAru2.ある.getCode());
        editor.setResult(被害的, NaiAru2.ない.getCode());
        editor.setResult(作話, NaiAru2.ある.getCode());
        editor.setResult(感情が不安定, NaiAru2.ない.getCode());
        editor.setResult(昼夜逆転, NaiAru2.ある.getCode());
        editor.setResult(同じ話をする, NaiAru2.ない.getCode());
        editor.setResult(大声を出す, NaiAru2.ある.getCode());
        editor.setResult(介護に抵抗, NaiAru2.ない.getCode());
        editor.setResult(落ち着きなし, NaiAru2.ある.getCode());
        editor.setResult(一人で出たがる, NaiAru2.ない.getCode());
        editor.setResult(収集癖, NaiAru2.ある.getCode());
        editor.setResult(物や衣類を壊す, NaiAru2.ない.getCode());
        editor.setResult(ひどい物忘れ, NaiAru2.ある.getCode());
        editor.setResult(独り言_独り笑, NaiAru2.ない.getCode());
        editor.setResult(自分勝手に行動する, NaiAru2.ある.getCode());
        editor.setResult(話がまとまらない, NaiAru2.ない.getCode());
        editor.setResult(薬の内服, Kaijo.自立.getCode());
        editor.setResult(金銭の管理, Kaijo.全介助.getCode());
        editor.setResult(日常の意思決定, DekiruDekinai7.できる.getCode());
        editor.setResult(集団への不適応, NaiAru2.ない.getCode());
        editor.setResult(買い物, Kaijo3.自立.getCode());
        editor.setResult(簡単な調理, Kaijo3.全介助.getCode());
        editor.setResult(点滴の管理, NaiAru.ない.getCode());
        editor.setResult(中心静脈栄養, NaiAru.ある.getCode());
        editor.setResult(透析, NaiAru.ない.getCode());
        editor.setResult(ストーマの処置, NaiAru.ある.getCode());
        editor.setResult(酸素療法, NaiAru.ない.getCode());
        editor.setResult(レスピレーター, NaiAru.ある.getCode());
        editor.setResult(気管切開, NaiAru.ない.getCode());
        editor.setResult(疼痛の看護, NaiAru.ある.getCode());
        editor.setResult(経管栄養, NaiAru.ない.getCode());
        editor.setResult(モニター測定, NaiAru.ある.getCode());
        editor.setResult(じょくそうの処置, NaiAru.ない.getCode());
        editor.setResult(カテーテル, NaiAru.ある.getCode());
        editor.setResult(障害高齢者の日常生活自立度, ShogaiJiritsu.Ａ１.getCode());
        editor.setResult(認知症高齢者の日常生活自立度, NinchishoJiritsu.Ⅱａ.getCode());

        return new NinteichosaResultOfKihon(new ShinseishoKanriNo(new RString("1234567890")), new NinteichosaIraiRirekiNo(0), KoroshoIFKubun.V09A, editor.getNinteichosahyo());
    }
}
