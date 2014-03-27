/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import java.util.ArrayList;
import java.util.EnumMap;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.Shujii;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkensho;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoBase;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoDetails;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoFactory;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoItemForResult;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoResult;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ShujiiIkenshoItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.business._Doctor;
import jp.co.ndensan.reams.ur.urz.business._Doctors;
import jp.co.ndensan.reams.ur.urz.business._IryoKikan;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun.*;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Choice.*;
import static org.mockito.Mockito.spy;

/**
 * ShujiiIkenshoResultを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoResultMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoResultMock() {
    }

    /**
     * ShujiiIkenshoResultを生成して返します。
     *
     * @return ShujiiIkenshoResult
     */
    public static ShujiiIkenshoResult getSpiedShujiiIkenshoResultInstance() {
        return spy(new ShujiiIkenshoResult(getSpiedShujiiIkenshoBaseInstance(), getSpiedShujiiIkenshoDetailsInstance()));
    }

    /**
     * ShujiiIkenshoBaseを生成して返します。
     *
     * @return ShujiiIkenshoBase
     */
    public static ShujiiIkenshoBase getSpiedShujiiIkenshoBaseInstance() {
        return spy(new ShujiiIkenshoBase(
                new ShinseishoKanriNo(new RString("1234567890")),
                new IkenshosakuseiIraiRirekiNo(0),
                ShujiiIkenshoIraiKubun.初回,
                createKaigoDoctor(),
                new FlexibleDate("20140101"),
                new FlexibleDate("20140202"),
                ShujiiIkenshoSakuseiKaisu.二回目以上,
                ShujiiIkenshoSakuseiryoShubetsu.施設,
                true,
                false));
    }

    private static KaigoDoctor createKaigoDoctor() {
        return new KaigoDoctor(
                new _Doctor(
                new RString("医師識別番号"),
                new AtenaMeisho(new RString("医師氏名")),
                new _IryoKikanCode(new RString("1234567890")),
                new Code(new RString("所属診療科")),
                new Code(new RString("医師区分"))),
                new Shujii(
                new ShichosonCode(new RString("市町村コード")),
                new KaigoIryoKikanCode(new RString("介護医療機関コード")),
                new KaigoDoctorCode(new RString("介護医師コード")),
                new _IryoKikanCode(new RString("1234567890")),
                new RString("医師識別番号"),
                IshiJokyo.有効,
                new YubinNo(new RString("1234567")),
                new AtenaJusho(new RString("住所")),
                new TelNo("電話番号"),
                new RString("FAX番号")),
                new KaigoIryoKikan(
                new _IryoKikan(
                new _IryoKikanCode(new RString("1234567890")),
                new ShikibetsuCode(new RString("123456")),
                new _Name(new AtenaMeisho(new RString("医療機関名称")), new AtenaKanaMeisho(RString.EMPTY)),
                new _Name(new AtenaMeisho(new RString("医療機関略称")), new AtenaKanaMeisho(RString.EMPTY)),
                new RString("所在地郵便番号"),
                new RString("所在地住所"),
                new RString("所在地カナ住所"),
                new Range(RDate.MIN, RDate.MAX),
                new _Doctors(new ArrayList<IDoctor>()),
                new ArrayList<IKoza>(),
                RDate.MIN,
                new RString("休止区分"),
                new RString("異動事由"),
                new RString("会員区分"),
                true),
                new ShujiiIryoKikan(
                new ShichosonCode(new RString("市町村コード")),
                new KaigoIryoKikanCode(new RString("1234567890")),
                new _IryoKikanCode(new RString("1234567890")),
                IryoKikanJokyo.有効,
                new IryoKikanKubun(new RString("医療機関の区分"), RString.EMPTY, RString.EMPTY))));
    }

    /**
     * ShujiiIkenshoDetailsを生成して返します。
     *
     * @return ShujiiIkenshoDetails
     */
    public static ShujiiIkenshoDetails getSpiedShujiiIkenshoDetailsInstance() {

        ShujiiIkensho 意見書 = ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A);

        ShujiiIkensho result = new ShujiiIkensho(new EnumMap<>(ShujiiIkenshoItemKubun.class), ShujiiIkenshoItemGroupOf2009.values());
        result.set意見書項目(create意見書結果(意見書, 診断名1, new RString("診断名1")));
        result.set意見書項目(create意見書結果(意見書, 発症年月日1, new RString("20140101")));
        result.set意見書項目(create意見書結果(意見書, 診断名2, new RString("診断名2")));
        result.set意見書項目(create意見書結果(意見書, 発症年月日2, new RString("20140202")));
        result.set意見書項目(create意見書結果(意見書, 診断名3, new RString("診断名3")));
        result.set意見書項目(create意見書結果(意見書, 発症年月日3, new RString("20140303")));
        result.set意見書項目(create意見書結果(意見書, 症状の安定性, Antei.安定.getCode()));
        result.set意見書項目(create意見書結果(意見書, 具体的な状況, new RString("具体的な状況")));
        result.set意見書項目(create意見書結果(意見書, 治療内容, new RString("治療内容")));
        result.set意見書項目(create意見書結果(意見書, 点滴の管理, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 中心静脈栄養, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 透析, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, ストーマの処置, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 酸素療法, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, レスピレーター, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 気管切開の処置, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 疼痛の看護, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 経管栄養, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, モニター測定, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 褥瘡の処置, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, カテーテル, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 障害高齢者日常生活自立度, ShogaiJiritsu.Ａ１.getCode()));
        result.set意見書項目(create意見書結果(意見書, 認知症高齢者日常生活自立度, NinchishoJiritsu.Ⅱａ.getCode()));
        result.set意見書項目(create意見書結果(意見書, 短期記憶, MondaiNashiAri.問題なし.getCode()));
        result.set意見書項目(create意見書結果(意見書, 認知能力, Ninchi.見守りが必要.getCode()));
        result.set意見書項目(create意見書結果(意見書, 伝達能力, Dentatsu.いくらか困難.getCode()));
        result.set意見書項目(create意見書結果(意見書, 認知症の周辺症状, NashiAri.無.getCode()));
        result.set意見書項目(create意見書結果(意見書, 幻視幻聴, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 妄想, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 昼夜逆転, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 暴言, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 暴行, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 介護への抵抗, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 認知症_徘徊, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 火の不始末, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 不潔行為, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 異食行動, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 性的問題行動, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 認知症_その他, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 認知症_その他内容, new RString("認知症_その他内容")));
        result.set意見書項目(create意見書結果(意見書, 精神_神経症状, NashiAri.有.getCode()));
        result.set意見書項目(create意見書結果(意見書, 精神_神経症状名, new RString("精神_神経症状名")));
        result.set意見書項目(create意見書結果(意見書, 専門科医受診, AriNashi.無.getCode()));
        result.set意見書項目(create意見書結果(意見書, 専門科医受診内容, new RString("専門科医受診内容")));
        result.set意見書項目(create意見書結果(意見書, 利き腕, MigiHidari.右.getCode()));
        result.set意見書項目(create意見書結果(意見書, 身長, new RString("160")));
        result.set意見書項目(create意見書結果(意見書, 体重, new RString("50")));
        result.set意見書項目(create意見書結果(意見書, 体重の変化, ZokaGensho.維持.getCode()));
        result.set意見書項目(create意見書結果(意見書, 四肢欠損, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 四肢欠損部位, new RString("四肢欠損部位")));
        result.set意見書項目(create意見書結果(意見書, 四肢欠損程度, Teido.中.getCode()));
        result.set意見書項目(create意見書結果(意見書, 麻痺, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 麻痺程度, Teido.重.getCode()));
        result.set意見書項目(create意見書結果(意見書, 麻痺_左上肢, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 麻痺_右上肢, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 麻痺_左下肢, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 麻痺_右下肢, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 麻痺_その他, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 筋力低下, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 筋力低下部位, new RString("筋力低下部位")));
        result.set意見書項目(create意見書結果(意見書, 筋力低下程度, Teido.軽.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_右肩, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_左肩, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_右肘, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_左肘, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_右股, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_左股, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_右膝, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮_左膝, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の拘縮程度, Teido.重.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の痛み, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 関節の痛み部位, new RString("関節の痛み部位")));
        result.set意見書項目(create意見書結果(意見書, 関節の痛み程度, Teido.中.getCode()));
        result.set意見書項目(create意見書結果(意見書, 失調不随意, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 失調不随意_右上肢, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 失調不随意_左上肢, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 失調不随意_右体幹, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 失調不随意_左体幹, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 失調不随意_右下肢, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 失調不随意_左下肢, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, じょくそう, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, じょくそう部位, new RString("じょくそう部位")));
        result.set意見書項目(create意見書結果(意見書, じょくそう程度, Teido.軽.getCode()));
        result.set意見書項目(create意見書結果(意見書, その他皮膚疾患, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, その他皮膚疾患部位, new RString("その他皮膚疾患部位")));
        result.set意見書項目(create意見書結果(意見書, その他皮膚疾患程度, Teido.重.getCode()));
        result.set意見書項目(create意見書結果(意見書, 屋外歩行, Kaijo4.自立.getCode()));
        result.set意見書項目(create意見書結果(意見書, 車椅子の使用, Kurumaisu.用いていない.getCode()));
        result.set意見書項目(create意見書結果(意見書, 歩行補助具_装具未使用, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 歩行補助具_装具屋外使用, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 歩行補助具_装具屋内使用, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 食事行為, Shokuji.自立ないし何とか自分で食べられる.getCode()));
        result.set意見書項目(create意見書結果(意見書, 現在の栄養状態, Jotai.良好.getCode()));
        result.set意見書項目(create意見書結果(意見書, 栄養_食生活留意点, new RString("栄養_食生活留意点")));
        result.set意見書項目(create意見書結果(意見書, 尿失禁, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 転倒_骨折, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 移動能力の低下, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 褥瘡, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 心肺機能の低下, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 閉じこもり, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 意欲低下, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 徘徊, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 低栄養, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 摂食_嚥下機能低下, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 脱水, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 易感染症, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, がん等による疼痛, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, その他状態, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, その他状態内容, new RString("その他状態内容")));
        result.set意見書項目(create意見書結果(意見書, 状態対処方針, new RString("状態対処方針")));
        result.set意見書項目(create意見書結果(意見書, 介護の必要な程度に関する予後の見直し, Kitai.期待できる.getCode()));
        result.set意見書項目(create意見書結果(意見書, 訪問診療, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 訪問看護, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 看護職員の訪問による相談_支援, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 訪問歯科診療, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 訪問薬剤管理指導, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 訪問リハビリテーション, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 短期入所療養介護, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 訪問歯科衛生指導, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, 訪問栄養食事指導, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 通所リハビリテーション, Checked.無し.getCode()));
        result.set意見書項目(create意見書結果(意見書, その他医学的管理, Checked.有り.getCode()));
        result.set意見書項目(create意見書結果(意見書, 血圧, NashiAri3.あり.getCode()));
        result.set意見書項目(create意見書結果(意見書, 血圧内容, new RString("血圧内容")));
        result.set意見書項目(create意見書結果(意見書, 移動, NashiAri3.特になし.getCode()));
        result.set意見書項目(create意見書結果(意見書, 移動内容, new RString("移動内容")));
        result.set意見書項目(create意見書結果(意見書, 摂食, NashiAri3.あり.getCode()));
        result.set意見書項目(create意見書結果(意見書, 摂食内容, new RString("摂食内容")));
        result.set意見書項目(create意見書結果(意見書, 運動, NashiAri3.特になし.getCode()));
        result.set意見書項目(create意見書結果(意見書, 運動内容, new RString("運動内容")));
        result.set意見書項目(create意見書結果(意見書, 嚥下, NashiAri3.あり.getCode()));
        result.set意見書項目(create意見書結果(意見書, 嚥下内容, new RString("嚥下内容")));
        result.set意見書項目(create意見書結果(意見書, その他留意事項, new RString("その他留意事項")));
        result.set意見書項目(create意見書結果(意見書, 感染症, NashiAri2.無.getCode()));
        result.set意見書項目(create意見書結果(意見書, 感染症内容, new RString("感染症内容")));
        result.set意見書項目(create意見書結果(意見書, 特記事項, new RString("特記事項")));

        return spy(new ShujiiIkenshoDetails(new ShinseishoKanriNo(new RString("1234567890")), new IkenshosakuseiIraiRirekiNo(0), KoroshoIFKubun.V09A, result));
    }

    private static ShujiiIkenshoItemForResult create意見書結果(ShujiiIkensho 意見書, IShujiiIkenshoItemKubun 意見書項目区分, RString 意見書結果) {
        ShujiiIkenshoItem item = (ShujiiIkenshoItem) 意見書.get意見書項目(意見書項目区分);
        return item == null ? null : new ShujiiIkenshoItemForResult(item, 意見書結果);
    }
}
