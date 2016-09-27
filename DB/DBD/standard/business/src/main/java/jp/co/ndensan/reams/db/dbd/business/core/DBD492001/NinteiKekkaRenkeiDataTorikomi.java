/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.DBD492001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.OutFile;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.OutFilekekka;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力ファイルのデータの編集ビジネスクラスです。
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class NinteiKekkaRenkeiDataTorikomi {

    private final RString K02A = new RString("02A");
    private final RString K99A = new RString("99A");
    private final RString K06A = new RString("06A");
    private final RString K09A = new RString("09A");
    private final RString K09B = new RString("09B");
    private final RString ONE = new RString("1");
    private final RString ZEROONE = new RString("01");
    private final RString TWO = new RString("2");
    private final RString ZEROTWO = new RString("02");
    private final RString THREE = new RString("3");
    private final RString ZEROTHREE = new RString("03");
    private final RString FOUR = new RString("4");
    private final RString ZEROFOUR = new RString("04");
    private final RString FIVE = new RString("5");
    private final RString ZEROFIVE = new RString("05");
    private final RString SIX = new RString("6");
    private final RString ZEROSIX = new RString("06");
    private final RString SEVEN = new RString("7");
    private final RString ZEROSEVEN = new RString("07");
    private final RString EIGHT = new RString("8");
    private final RString ZEROEIGHT = new RString("08");
    private final RString NINE = new RString("9");
    private final RString ZERONINE = new RString("09");
    private final RString TEN = new RString("10");
    private final RString ELEVEN = new RString("11");
    private final RString TWELVE = new RString("12");
    private final RString THIRTEEN = new RString("13");
    private final RString FOURTEEN = new RString("14");
    private final RString FIVETEEN = new RString("15");
    private final RString SIXTEEN = new RString("16");
    private final RString NINETEEN = new RString("19");
    private final RString TWENTYONE = new RString("21");
    private final RString TWENTYTWO = new RString("22");
    private final RString TWENTYTHREE = new RString("23");
    private final RString TWENTYFOUR = new RString("24");
    private final RString TWENTYFIVE = new RString("25");
    private final RString NINETY_NINE = new RString("99");

    private final RString A = new RString("A");
    private final RString B = new RString("B");

    /**
     * 項目設定します．
     *
     * @param t t
     * @param out out
     */
    public void NinteiKekkaRenkeiDataTorikomi(OutFile t, OutFilekekka out) {

        out.set識別コード(t.get識別コード());
        if (K02A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V02A.getCode());
        } else if (K99A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V99A.getCode());
        } else if (K06A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V06A.getCode());
        } else if (K09A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V09A.getCode());
        } else if (K09B.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V09B.getCode());
        }
        out.set保険者番号(t.get保険者番号());
        out.set被保険者番号(t.get被保険者番号());
        out.set認定申請日(t.get認定申請日());
        out.set枝番(t.get枝番());
        if (K09B.equals(t.get識別コード())) {
            out.set申請区分_法令_コード(t.get申請区分_法令_コード());
            if (ONE.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.新規申請.get名称());
            } else if (TWO.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.更新申請.get名称());
            } else if (THREE.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.区分変更申請.get名称());
            } else if (FOUR.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.職権.get名称());
            }
        } else {
            out.set申請区分_法令_コード(RString.EMPTY);
            out.set申請区分_法令_コード名称(RString.EMPTY);
        }
        out.set申請区分_申請時_コード(t.get申請区分_申請時_コード());
        if (ONE.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.新規申請.get名称());
        } else if (TWO.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.更新申請.get名称());
        } else if (THREE.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.区分変更申請.get名称());
        } else if (FOUR.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.職権.get名称());
        } else if (FIVE.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.転入申請.get名称());
        } else if (SIX.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.get名称());
        } else if (A.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.新規申請_事前.get名称());
        } else if (B.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.更新申請_事前.get名称());
        }
        out.set取下区分コード(t.get取下区分コード());
        if (ONE.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.認定申請有効.get名称());
        } else if (TWO.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.却下.get名称());
        } else if (THREE.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.取り下げ.get名称());
        } else if (FOUR.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.区分変更却下.get名称());
        }
        out.set被保険者区分コード(t.get被保険者区分コード());
        if (ONE.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.第１号被保険者.get名称());
        } else if (TWO.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.第２号被保険者.get名称());
        } else if (EIGHT.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.生活保護.get名称());
        } else if (NINE.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.その他.get名称());
        }
        out.set申請代行区分コード(t.get申請代行区分コード());
        if (ONE.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.本人.get名称());
        } else if (TWO.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.家族.get名称());
        } else if (THREE.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.委任.get名称());
        } else if (FOUR.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.代行.get名称());
        } else if (NINE.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.その他.get名称());
        }
        out.set生年月日(t.get生年月日());
        out.set年齢(t.get年齢());
        out.set性別コード(t.get性別コード());
        if (ONE.equals(t.get性別コード())) {
            out.set性別コード名称(Seibetsu.男.get名称());
        } else if (TWO.equals(t.get性別コード())) {
            out.set性別コード名称(Seibetsu.女.get名称());
        }
        out.set被保険者ｶﾅ氏名(t.get被保険者ｶﾅ氏名());
        out.set被保険者漢字氏名(t.get被保険者漢字氏名());
        out.set郵便番号(t.get郵便番号());
        out.set住所(t.get住所());
        out.set電話番号(t.get電話番号());
        out.set病院施設等の名称(t.get病院施設等の名称());
        out.set病院施設等の所在地(t.get病院施設等の所在地());
        out.set前回の認定審査会結果(t.get前回の認定審査会結果());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set前回の認定有効期間_開始(t.get前回の認定有効期間_開始());
        out.set前回の認定有効期間_終了(t.get前回の認定有効期間_終了());
        out.set主治医医療機関番号(t.get主治医医療機関番号());
        out.set主治医番号(t.get主治医番号());
        out.set意見書依頼日(t.get意見書依頼日());
        out.set意見書入手日(t.get意見書入手日());
        out.set意見書_短期記憶(t.get意見書_短期記憶());
        out.set意見書_認知能力(t.get意見書_認知能力());
        out.set意見書_伝達能力(t.get意見書_伝達能力());
        out.set意見書_食事行為(t.get意見書_食事行為());
        out.set意見書_認知症高齢者の日常生活自立度(t.get意見書_認知症高齢者の日常生活自立度());
        out.set調査依頼日(t.get調査依頼日());
        out.set調査実施日(t.get調査実施日());
        out.set指定居宅介護支援事業者等番号(t.get指定居宅介護支援事業者等番号());
        out.set委託区分(t.get委託区分());
        if (ONE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.保険者_市町村等.get名称());
        } else if (TWO.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.指定市町村事務受託法人.get名称());
        } else if (THREE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.指定居宅介護支援事業者.get名称());
        } else if (FOUR.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.介護保険施設.get名称());
        } else if (FIVE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.介護支援専門員.get名称());
        } else if (SIX.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.他市町村.get名称());
        } else if (NINE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.その他.get名称());
        }
        out.set認定調査員番号(t.get認定調査員番号());
        out.set認定調査員資格コード(t.get認定調査員資格コード());
        if (ZEROONE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.医師.get名称());
        } else if (ZEROTWO.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.歯科医師.get名称());
        } else if (ZEROTHREE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.薬剤師.get名称());
        } else if (ZEROFOUR.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.保健師.get名称());
        } else if (ZEROFIVE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.助産師.get名称());
        } else if (ZEROSIX.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku._准_看護師.get名称());
        } else if (ZEROSEVEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.理学療法士.get名称());
        } else if (ZEROEIGHT.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.作業療法士.get名称());
        } else if (ZERONINE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.社会福祉士.get名称());
        } else if (TEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.介護福祉士.get名称());
        } else if (ELEVEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.ソーシャルワーカー.get名称());
        } else if (TWELVE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.福祉事務所現業員等.get名称());
        } else if (THIRTEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.ホームヘルパー.get名称());
        } else if (FOURTEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.介護職員.get名称());
        } else if (FIVETEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.その他福祉関係者.get名称());
        } else if (SIXTEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.行政関係者.get名称());
        } else if (NINETY_NINE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.その他.get名称());
        }
        out.set一次判定日(t.get一次判定日());
        out.set一次判定結果(t.get一次判定結果());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set一次判定結果_認知症加算(t.get一次判定結果_認知症加算());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set認定審査会資料作成日(t.get認定審査会資料作成日());
        out.set認定審査会予定日(t.get認定審査会予定日());
        out.set合議体番号(t.get合議体番号());
        out.set審査会資料番号(t.get審査会資料番号());
        out.set二次判定日(t.get二次判定日());
        out.set二次判定結果(t.get二次判定結果());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set認定有効期間_開始(t.get認定有効期間_開始());
        out.set認定有効期間_終了(t.get認定有効期間_終了());
        out.set特定疾病コード(t.get特定疾病コード());
        if (ZEROONE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.筋萎縮性側索硬化症.get名称());
        } else if (ZEROTWO.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.後縦靭帯骨化症.get名称());
        } else if (ZEROTHREE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.骨折を伴う骨粗鬆症.get名称());
        } else if (ZEROFOUR.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.多系統萎縮症.get名称());
        } else if (ZEROFIVE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.初老期における認知症.get名称());
        } else if (ZEROSIX.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.脊髄小脳変性症.get名称());
        } else if (ZEROSEVEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.脊柱管狭窄症.get名称());
        } else if (ZEROEIGHT.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.早老症.get名称());
        } else if (ZERONINE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症.get名称());
        } else if (TEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.脳血管疾患.get名称());
        } else if (ELEVEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.パーキンソン病関連疾患.get名称());
        } else if (TWELVE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.閉塞性動脈硬化症.get名称());
        } else if (THIRTEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.関節リウマチ.get名称());
        } else if (FOURTEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.慢性閉塞性肺疾患.get名称());
        } else if (FIVETEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.両側の膝関節又は股関節に著しい変形を伴う変形性関節症.get名称());
        } else if (SIXTEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.がん_末期.get名称());
        } else if (NINETY_NINE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.特定疾病以外.get名称());
        }
        out.set要介護1の場合の状態像(t.get要介護1の場合の状態像());
        if (ZEROONE.equals(t.get要介護1の場合の状態像())) {
            out.set要介護1の場合の状態像名称(YokaigoJotaizoReiCode.認知機能の低下等.get名称());
        } else if (ZEROTWO.equals(t.get要介護1の場合の状態像())) {
            out.set要介護1の場合の状態像名称(YokaigoJotaizoReiCode.不安定な状態.get名称());
        } else if (NINETY_NINE.equals(t.get要介護1の場合の状態像())) {
            out.set要介護1の場合の状態像名称(YokaigoJotaizoReiCode.その他.get名称());
        }
        out.set現在のサービス区分コード(t.get現在のサービス区分コード());
        if (ONE.equals(t.get現在のサービス区分コード())) {
            out.set現在のサービス区分コード名称(ServiceKubunCode.予防給付サービス.get名称());
        } else if (TWO.equals(t.get現在のサービス区分コード())) {
            out.set現在のサービス区分コード名称(ServiceKubunCode.介護給付サービス.get名称());
        } else if (NINE.equals(t.get現在のサービス区分コード())) {
            out.set現在のサービス区分コード名称(ServiceKubunCode.なし.get名称());
        }
        out.set現在の状況(t.get現在の状況());
        if (ONE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.居宅_施設利用なし.get名称());
        } else if (TWO.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.指定介護老人福祉施設.get名称());
        } else if (THREE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.介護老人保健施設.get名称());
        } else if (FOUR.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.指定介護療養型医療施設.get名称());
        } else if (FIVE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.認知症対応型共同生活介護適用施設_グループホーム.get名称());
        } else if (SIX.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.特定施設入居者生活介護適用施設_ケアハウス等.get名称());
        } else if (SEVEN.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.医療機関_医療保険適用療養病床.get名称());
        } else if (EIGHT.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.医療機関_療養病棟以外.get名称());
        } else if (NINE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.その他の施設.get名称());
        }
    }
}
