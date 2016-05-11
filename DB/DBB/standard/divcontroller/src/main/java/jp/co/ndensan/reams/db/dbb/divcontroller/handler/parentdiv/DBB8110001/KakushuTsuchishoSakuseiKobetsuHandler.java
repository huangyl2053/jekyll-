/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8110001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.TyouteiZiyu;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TsuchiSho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ShutsuryokuHoshiki;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ShutsuryokuKeishiki;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.kakushutsuchishosakusei.KakushuTsuchishoSakusei;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.business.core.date.DateEditor;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 画面設計_DBBGM12001_3_各種通知書作成（個別）のハンドラクラスです。
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KakushuTsuchishoSakuseiKobetsuHandler {

    private final KakushuTsuchishoSakuseiKobetsuDiv div;
    private static final RString 特徴開始通知書 = new RString("特徴開始通知書");
    private static final RString 決定通知書 = new RString("決定通知書");
    private static final RString 変更通知書 = new RString("変更通知書");
    private static final RString 納入通知書 = new RString("納入通知書");
    private static final RString 賦課台帳 = new RString("賦課台帳");
    private static final RString 変更兼特別徴収中止通知書 = new RString("変更兼特別徴収中止通知書");
    private static final RString 郵便振替納付書 = new RString("郵便振替納付書");
    private static final RString 減免決定通知書 = new RString("減免決定通知書");
    private static final RString 減免取消通知書 = new RString("減免取消通知書");
    private static final RString 猶予決定通知書 = new RString("猶予決定通知書");
    private static final RString 猶予取消通知書 = new RString("猶予取消通知書");
    private static final RString 保険料納入通知書_仮算定 = new RString("保険料納入通知書_仮算定");
    private static final RString 保険料納入通知書_本算定 = new RString("保険料納入通知書_本算定");
    private static final RString 保険料納入通知書_過年度 = new RString("保険料納入通知書_過年度");
    private static final RString 介護保険料額決定通知書 = new RString("介護保険料額決定通知書");
    private static final RString 介護保険料額変更兼特別徴収中止通知書 = new RString("介護保険料額変更兼特別徴収中止通知書");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString スペース = RString.HALF_SPACE;
    private static final RString STR_0 = new RString("0");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_13 = 13;
    private static final int NUM_14 = 14;
    private static final RString 期1 = new RString("1期");
    private static final RString 期2 = new RString("2期");
    private static final RString 期3 = new RString("3期");
    private static final RString 期4 = new RString("4期");
    private static final RString 期5 = new RString("5期");
    private static final RString 期6 = new RString("6期");
    private static final RString 期7 = new RString("7期");
    private static final RString 期8 = new RString("8期");
    private static final RString 期9 = new RString("9期");
    private static final RString 期10 = new RString("10期");
    private static final RString 期11 = new RString("11期");
    private static final RString 期12 = new RString("12期");
    private static final RString 期13 = new RString("13期");
    private static final RString 期14 = new RString("14期");
    private static final RString 発行する = new RString("btnReportPublish");

    /**
     * コンストラクタです。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     */
    public KakushuTsuchishoSakuseiKobetsuHandler(KakushuTsuchishoSakuseiKobetsuDiv div) {
        this.div = div;
    }

    /**
     * 調定パネル設定のメソッドます。
     *
     * @param 賦課の情報List List
     */
    public void set調定パネル(ArrayList<FukaJoho> 賦課の情報List) {

        Collections.sort(賦課の情報List, new Comparator<FukaJoho>() {
            @Override
            public int compare(FukaJoho o1, FukaJoho o2) {
                YMDHMS 調定日時o1 = o1.get調定日時();
                YMDHMS 調定日時o2 = o2.get調定日時();
                if (調定日時o1 != null && 調定日時o2 != null) {
                    return 調定日時o2.compareTo(調定日時o1);
                }
                return 0;
            }
        });
        Map<RString, FukaJoho> map = new HashMap<>();
        for (FukaJoho info : 賦課の情報List) {
            YMDHMS 調定日時 = info.get調定日時();
            if (調定日時 != null) {
                map.put(new RString(調定日時.toString()), info);
            }
        }
        ViewStateHolder.put(ViewStateKeys.賦課の情報リスト, (Serializable) map);

        ArrayList<YMDHMS> 調定日時List = new ArrayList<>();
        for (FukaJoho 賦課の情報 : 賦課の情報List) {
            調定日時List.add(賦課の情報.get調定日時());
        }
        Collections.sort(調定日時List, new Comparator<YMDHMS>() {
            @Override
            public int compare(YMDHMS o1, YMDHMS o2) {
                return o2.compareTo(o1);
            }
        });
        ViewStateHolder.put(ViewStateKeys.調定日時リスト, 調定日時List);
        FukaJoho 賦課の情報 = 賦課の情報List.get(0);
        set調定パネルの共通エリア(賦課の情報);
        FlexibleYear 賦課年度 = 賦課の情報.get賦課年度();
        FlexibleYear 調定年度 = 賦課の情報.get調定年度();
        if (賦課の情報List.size() == 1) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto().setDisabled(true);
            List<KeyValueDataSource> 更正前DataSource = new ArrayList<>();
            更正前DataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setDataSource(更正前DataSource);
            List<KeyValueDataSource> 更正後DataSource = new ArrayList<>();
            YMDHMS 調定日時 = 賦課の情報.get調定日時();
            if (調定日時 != null) {
                RString 年月日 = 調定日時.getRDateTime().getDate().wareki().toDateString();
                RString 時刻 = 調定日時.getRDateTime().getTime().toFormattedTimeString(
                        DisplayTimeFormat.HH_mm);
                更正後DataSource.add(new KeyValueDataSource(new RString(調定日時.toString()), 年月日.concat(スペース).concat(時刻)));
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto()
                        .setDataSource(更正後DataSource);
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto()
                        .setSelectedKey(new RString(調定日時.toString()));
            }
            set更正後賦課根拠(賦課の情報);
            if (!賦課年度.isBefore(調定年度)) {
                FuchoKiUtil util = new FuchoKiUtil();
                set特別徴収(null, 賦課の情報);
                set普通徴収(null, 賦課の情報, util.get期月リスト());
            } else {
                KanendoKiUtil kanendoKi = new KanendoKiUtil();
                set普通徴収(null, 賦課の情報, kanendoKi.get期月リスト());
            }
        } else {
            List<KeyValueDataSource> 更正後Data = new ArrayList<>();
            List<KeyValueDataSource> 更正前Data = new ArrayList<>();
            RString 年月日;
            RString 時刻;
            for (YMDHMS 更正後日時 : 調定日時List) {
                年月日 = 更正後日時.getRDateTime().getDate().wareki().toDateString();
                時刻 = 更正後日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm);
                更正後Data.add(new KeyValueDataSource(new RString(更正後日時.toString()), 年月日.concat(スペース).concat(時刻)));
            }
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto()
                    .setDataSource(更正後Data);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto()
                    .setSelectedKey(new RString(調定日時List.get(0).toString()));

            調定日時List.remove(調定日時List.get(0));
            for (YMDHMS 更正前日時 : 調定日時List) {
                年月日 = 更正前日時.getRDateTime().getDate().wareki().toDateString();
                時刻 = 更正前日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm);
                更正前Data.add(new KeyValueDataSource(new RString(更正前日時.toString()), 年月日.concat(スペース).concat(時刻)));
            }
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setDataSource(更正前Data);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setSelectedKey(new RString(調定日時List.get(0).toString()));

            FukaJoho 更正後賦課の情報 = 賦課の情報List.get(0);
            FukaJoho 更正前賦課の情報 = 賦課の情報List.get(1);
            set更正後賦課根拠(更正後賦課の情報);
            set更正前賦課根拠(更正前賦課の情報);
            if (!賦課年度.isBefore(調定年度)) {
                FuchoKiUtil util = new FuchoKiUtil();
                set特別徴収(更正前賦課の情報, 更正後賦課の情報);
                set普通徴収(更正前賦課の情報, 更正後賦課の情報, util.get期月リスト());
            } else {
                KanendoKiUtil kanendoKi = new KanendoKiUtil();
                set普通徴収(更正前賦課の情報, 更正後賦課の情報, kanendoKi.get期月リスト());
            }
        }
        List<RString> 発行する帳票リスト = KakushuTsuchishoSakusei.createInstance().get帳票リスト(賦課の情報);
        if (発行する帳票リスト != null && !発行する帳票リスト.isEmpty()) {
            set通知書作成パネル(発行する帳票リスト);
        }
    }

    private void set調定パネルの共通エリア(FukaJoho 賦課の情報) {
        div.getFukaShokaiGrandsonTsuchisho().getTxtChoteiNendo().setDomain(賦課の情報.get調定年度());
        div.getFukaShokaiGrandsonTsuchisho().getTxtFukaNendo().setDomain(賦課の情報.get賦課年度());
        div.getFukaShokaiGrandsonTsuchisho().getTxtKoseiM().setValue(賦課の情報.get更正月());
        div.getFukaShokaiGrandsonTsuchisho().getTxtKoseiDateTime().setValue(new RString(賦課の情報.get調定日時().toString()));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getRadKobetsuHakkoChoteiJiyu()
                .setSelectedKey(KEY0);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setValue(
                賦課の情報.get調定事由1());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setValue(
                賦課の情報.get調定事由2());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setValue(
                賦課の情報.get調定事由3());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setValue(
                賦課の情報.get調定事由4());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(true);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(true);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(true);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(true);
        clear更正前賦課根拠();
        clear更正後賦課根拠();
    }

    private void set更正前賦課根拠(FukaJoho 賦課の情報) {

        if (賦課の情報.get賦課期日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae1().setText(DateEditor.to和暦(賦課の情報.get賦課期日()));
        }
        if (賦課の情報.get資格取得日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae2().setText(DateEditor.to和暦(賦課の情報.get資格取得日()));
        }
        if (賦課の情報.get資格喪失日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae3().setText(DateEditor.to和暦(賦課の情報.get資格喪失日()));
        }
        if (賦課の情報.get生保開始日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae4().setText(DateEditor.to和暦(賦課の情報.get生保開始日()));
        }
        if (賦課の情報.get生保廃止日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae5().setText(DateEditor.to和暦(賦課の情報.get生保廃止日()));
        }
        if (賦課の情報.get老年開始日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae6().setText(DateEditor.to和暦(賦課の情報.get老年開始日()));
        }
        if (賦課の情報.get老年廃止日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae7().setText(DateEditor.to和暦(賦課の情報.get老年廃止日()));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae8().setText(賦課の情報.get課税区分());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae9().setText(賦課の情報.get世帯課税区分());
        Decimal 合計所得金額 = 賦課の情報.get合計所得金額();
        if (合計所得金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae10().setText(DecimalFormatter.toコンマ区切りRString(合計所得金額, 0));
        }
        Decimal 年金収入額 = 賦課の情報.get公的年金収入額();
        if (年金収入額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae11().setText(DecimalFormatter.toコンマ区切りRString(年金収入額, 0));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae12().setText(賦課の情報.get保険料段階());
        Decimal 減免額 = 賦課の情報.get減免額();
        if (減免額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae13().setText(DecimalFormatter.toコンマ区切りRString(減免額, 0));
        }
        Decimal 保険料額 = 賦課の情報.get確定介護保険料_年額();
        if (保険料額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae14().setText(DecimalFormatter.toコンマ区切りRString(保険料額, 0));
        }
    }

    private void set更正後賦課根拠(FukaJoho 賦課の情報) {

        if (賦課の情報.get賦課期日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto1().setText(DateEditor.to和暦(賦課の情報.get賦課期日()));
        }
        if (賦課の情報.get資格取得日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto2().setText(DateEditor.to和暦(賦課の情報.get資格取得日()));
        }
        if (賦課の情報.get資格喪失日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto3().setText(DateEditor.to和暦(賦課の情報.get資格喪失日()));
        }
        if (賦課の情報.get生保開始日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto4().setText(DateEditor.to和暦(賦課の情報.get生保開始日()));
        }
        if (賦課の情報.get生保廃止日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto5().setText(DateEditor.to和暦(賦課の情報.get生保廃止日()));
        }
        if (賦課の情報.get老年開始日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto6().setText(DateEditor.to和暦(賦課の情報.get老年開始日()));
        }
        if (賦課の情報.get老年廃止日() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto7().setText(DateEditor.to和暦(賦課の情報.get老年廃止日()));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto8().setText(賦課の情報.get課税区分());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto9().setText(賦課の情報.get世帯課税区分());
        Decimal 合計所得金額 = 賦課の情報.get合計所得金額();
        if (合計所得金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto10().setText(DecimalFormatter.toコンマ区切りRString(合計所得金額, 0));
        }
        Decimal 年金収入額 = 賦課の情報.get公的年金収入額();
        if (年金収入額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto11().setText(DecimalFormatter.toコンマ区切りRString(年金収入額, 0));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto12().setText(賦課の情報.get保険料段階());
        Decimal 減免額 = 賦課の情報.get減免額();
        if (減免額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto13().setText(DecimalFormatter.toコンマ区切りRString(減免額, 0));
        }
        Decimal 保険料額 = 賦課の情報.get確定介護保険料_年額();
        if (保険料額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto14().setText(DecimalFormatter.toコンマ区切りRString(保険料額, 0));
        }
    }

    private void set特別徴収(FukaJoho 更正前情報, FukaJoho 更正後情報) {

        clear更正前_特徴();
        clear更正後_特徴();
        clear期_特徴();
        TokuchoKiUtil util = new TokuchoKiUtil();
        KitsukiList 期月リスト = util.get期月リスト();
        RString 期_4月 = 期月リスト.get月の期(Tsuki._4月).get期();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi1().setText(get期(期_4月));
        Decimal 特徴期別金額 = get特徴期別金額(期_4月, 更正後情報);
        Decimal 更正後合計 = Decimal.ZERO;
        if (特徴期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoAto1().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額, 0));
            更正後合計 = 更正後合計.add(特徴期別金額);
        }
        RString 期_6月 = 期月リスト.get月の期(Tsuki._6月).get期();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi2().setText(get期(期_6月));
        特徴期別金額 = get特徴期別金額(期_6月, 更正後情報);
        if (特徴期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoAto2().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額, 0));
            更正後合計 = 更正後合計.add(特徴期別金額);
        }
        RString 期_8月 = 期月リスト.get月の期(Tsuki._8月).get期();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi3().setText(get期(期_8月));
        特徴期別金額 = get特徴期別金額(期_8月, 更正後情報);
        if (特徴期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoAto3().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額, 0));
            更正後合計 = 更正後合計.add(特徴期別金額);
        }
        RString 期_10月 = 期月リスト.get月の期(Tsuki._10月).get期();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi4().setText(get期(期_10月));
        特徴期別金額 = get特徴期別金額(期_10月, 更正後情報);
        if (特徴期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoAto4().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額, 0));
            更正後合計 = 更正後合計.add(特徴期別金額);
        }
        RString 期_12月 = 期月リスト.get月の期(Tsuki._12月).get期();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi5().setText(get期(期_12月));
        特徴期別金額 = get特徴期別金額(期_12月, 更正後情報);
        if (特徴期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoAto5().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額, 0));
            更正後合計 = 更正後合計.add(特徴期別金額);
        }
        RString 期_2月 = 期月リスト.get月の期(Tsuki._2月).get期();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi6().setText(get期(期_2月));
        特徴期別金額 = get特徴期別金額(期_2月, 更正後情報);
        if (特徴期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoAto6().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額, 0));
            更正後合計 = 更正後合計.add(特徴期別金額);
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAtoKei().setText(DecimalFormatter.toコンマ区切りRString(更正後合計, 0));

        if (更正前情報 != null) {
            set特徴_更正前期割額(更正前情報, 期_4月, 期_6月, 期_8月, 期_10月, 期_12月, 期_2月);
        }
    }

    private RString get期(RString 期) {
        switch (Integer.parseInt(期.toString())) {
            case NUM_1:
                return 期1;
            case NUM_2:
                return 期2;
            case NUM_3:
                return 期3;
            case NUM_4:
                return 期4;
            case NUM_5:
                return 期5;
            case NUM_6:
                return 期6;
            case NUM_7:
                return 期7;
            case NUM_8:
                return 期8;
            case NUM_9:
                return 期9;
            case NUM_10:
                return 期10;
            case NUM_11:
                return 期11;
            case NUM_12:
                return 期12;
            case NUM_13:
                return 期13;
            case NUM_14:
                return 期14;
            default:
                return null;
        }
    }

    private void set特徴_更正前期割額(FukaJoho 更正前情報,
            RString 期_4月,
            RString 期_6月,
            RString 期_8月,
            RString 期_10月,
            RString 期_12月,
            RString 期_2月) {

        Decimal 更正前合計 = Decimal.ZERO;
        Decimal 更正前期別金額 = get特徴期別金額(期_4月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoMae1().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get特徴期別金額(期_6月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoMae2().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get特徴期別金額(期_8月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoMae3().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get特徴期別金額(期_10月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoMae4().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get特徴期別金額(期_12月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoMae5().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get特徴期別金額(期_2月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoTokuchoMae6().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMaeKei().setText(DecimalFormatter.toコンマ区切りRString(更正前合計, 0));
    }

    private Decimal get特徴期別金額(RString 期, FukaJoho 賦課の情報) {
        switch (Integer.parseInt(期.toString())) {
            case NUM_1:
                return 賦課の情報.get特徴期別金額01();
            case NUM_2:
                return 賦課の情報.get特徴期別金額02();
            case NUM_3:
                return 賦課の情報.get特徴期別金額03();
            case NUM_4:
                return 賦課の情報.get特徴期別金額04();
            case NUM_5:
                return 賦課の情報.get特徴期別金額05();
            case NUM_6:
                return 賦課の情報.get特徴期別金額06();
            default:
                return null;
        }
    }

    private void set普通徴収(FukaJoho 更正前情報, FukaJoho 更正後情報, KitsukiList 期月リスト) {
        clear更正前_普徴();
        clear更正後_普徴();
        clear期_普徴();
        clear納期限();
        RString 期_4月 = 期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_5月 = 期月リスト.get月の期(Tsuki._5月).get期();
        RString 期_6月 = 期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_7月 = 期月リスト.get月の期(Tsuki._7月).get期();
        RString 期_8月 = 期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_9月 = 期月リスト.get月の期(Tsuki._9月).get期();
        RString 期_10月 = 期月リスト.get月の期(Tsuki._10月).get期();
        RString 期_11月 = 期月リスト.get月の期(Tsuki._11月).get期();
        RString 期_12月 = 期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_1月 = 期月リスト.get月の期(Tsuki._1月).get期();
        RString 期_2月 = 期月リスト.get月の期(Tsuki._2月).get期();
        RString 期_3月 = 期月リスト.get月の期(Tsuki._3月).get期();
        RString 期_13月 = 期月リスト.get月の期(Tsuki.翌年度4月).get期();
        RString 期_14月 = 期月リスト.get月の期(Tsuki.翌年度5月).get期();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi1().setText(get期(期_4月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi2().setText(get期(期_5月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi3().setText(get期(期_6月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi4().setText(get期(期_7月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi5().setText(get期(期_8月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi6().setText(get期(期_9月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi7().setText(get期(期_10月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi8().setText(get期(期_11月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi9().setText(get期(期_12月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi10().setText(get期(期_1月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi11().setText(get期(期_2月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi12().setText(get期(期_3月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi13().setText(get期(期_13月));
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi14().setText(get期(期_14月));

        Decimal 更正後合計 = Decimal.ZERO;
        Decimal 更正後期別金額 = get普徴期別金額(期_4月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto1().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_5月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto2().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_6月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto3().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_7月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto4().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_8月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto5().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_9月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto6().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_10月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto7().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_11月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto8().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_12月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto9().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_1月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto10().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_2月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto11().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_3月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto12().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_13月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto13().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        更正後期別金額 = get普徴期別金額(期_14月, 更正後情報);
        if (更正後期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoAto14().setText(DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0));
            更正後合計 = 更正後合計.add(更正後期別金額);
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAtoKei().setText(DecimalFormatter.toコンマ区切りRString(更正後合計, 0));
        if (更正前情報 != null) {
            set普徴_更正前期割額(更正前情報, 期_1月, 期_2月, 期_3月, 期_4月, 期_5月, 期_6月, 期_7月, 期_8月,
                    期_9月, 期_10月, 期_11月, 期_12月, 期_13月, 期_14月);
        }
        set納期限(更正後情報);
    }

    private void set納期限(FukaJoho 更正後情報) {
        // TODO
        更正後情報.get普徴期別金額01();
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen7().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen8().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen9().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen10().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen11().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen12().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen13().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen14().setText(RString.EMPTY);
    }

    private void set普徴_更正前期割額(FukaJoho 更正前情報,
            RString 期_1月,
            RString 期_2月,
            RString 期_3月,
            RString 期_4月,
            RString 期_5月,
            RString 期_6月,
            RString 期_7月,
            RString 期_8月,
            RString 期_9月,
            RString 期_10月,
            RString 期_11月,
            RString 期_12月,
            RString 期_13月,
            RString 期_14月) {
        Decimal 更正前合計 = Decimal.ZERO;
        Decimal 更正前期別金額 = get普徴期別金額(期_4月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae1().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_5月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae2().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_6月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae3().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_7月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae4().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_8月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae5().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_9月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae6().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_10月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae7().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_11月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae8().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_12月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae9().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_1月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae10().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_2月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae11().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_3月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae12().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_13月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae13().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        更正前期別金額 = get普徴期別金額(期_14月, 更正前情報);
        if (更正前期別金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                    .getLblZengoFuchoMae14().setText(DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0));
            更正前合計 = 更正前合計.add(更正前期別金額);
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMaeKei().setText(DecimalFormatter.toコンマ区切りRString(更正前合計, 0));
    }

    private Decimal get普徴期別金額(RString 期, FukaJoho 賦課の情報) {
        switch (Integer.parseInt(期.toString())) {
            case NUM_1:
                return 賦課の情報.get普徴期別金額01();
            case NUM_2:
                return 賦課の情報.get普徴期別金額02();
            case NUM_3:
                return 賦課の情報.get普徴期別金額03();
            case NUM_4:
                return 賦課の情報.get普徴期別金額04();
            case NUM_5:
                return 賦課の情報.get普徴期別金額05();
            case NUM_6:
                return 賦課の情報.get普徴期別金額06();
            case NUM_7:
                return 賦課の情報.get普徴期別金額07();
            case NUM_8:
                return 賦課の情報.get普徴期別金額08();
            case NUM_9:
                return 賦課の情報.get普徴期別金額09();
            case NUM_10:
                return 賦課の情報.get普徴期別金額10();
            case NUM_11:
                return 賦課の情報.get普徴期別金額11();
            case NUM_12:
                return 賦課の情報.get普徴期別金額12();
            case NUM_13:
                return 賦課の情報.get普徴期別金額13();
            case NUM_14:
                return 賦課の情報.get普徴期別金額14();
            default:
                return null;
        }
    }

    /**
     * 通知書作成パネル設定のメソッドます。
     *
     * @param 発行する帳票リスト List
     */
    public void set通知書作成パネル(List<RString> 発行する帳票リスト) {
        List<dgChohyoSentaku_Row> rowList = new ArrayList<>();
        dgChohyoSentaku_Row row;
        boolean 特徴開始通知書Flag = false;
        boolean 決定通知書Flag = false;
        boolean 変更通知書Flag = false;
        boolean 納入通知書Flag = false;
        boolean 減免通知書Flag = false;
        boolean 徴収猶予通知書Flag = false;
        boolean 郵振納付書Flag = false;
        boolean 賦課台帳Flag = false;
        boolean 調定事由Flag = false;
        List<RString> 帳票リスト = new ArrayList<>();
        int publishNumber = 0;
        Map<RString, RString> map = new HashMap<>();
        for (RString 帳票 : 発行する帳票リスト) {
            row = new dgChohyoSentaku_Row();
            RString 帳票略称 = TsuchiSho.valueOf(帳票.toString()).get略称();
            if (特徴開始通知書.equals(帳票略称)) {
                特徴開始通知書Flag = true;
            } else if (決定通知書.equals(帳票略称)) {
                決定通知書Flag = true;
            } else if (変更通知書.equals(帳票略称) || 変更兼特別徴収中止通知書.equals(帳票略称)) {
                変更通知書Flag = true;
            } else if (納入通知書.equals(帳票略称)) {
                set納入通知書制御情報(帳票);
                納入通知書Flag = true;
            } else if (減免決定通知書.equals(帳票略称) || 減免取消通知書.equals(帳票略称)) {
                減免通知書Flag = true;
            } else if (猶予決定通知書.equals(帳票略称) || 猶予取消通知書.equals(帳票略称)) {
                徴収猶予通知書Flag = true;
            } else if (郵便振替納付書.equals(帳票略称)) {
                郵振納付書Flag = true;
            } else if (賦課台帳.equals(帳票略称)) {
                賦課台帳Flag = true;
            }
            if (!介護保険料額決定通知書.equals(帳票) && !介護保険料額変更兼特別徴収中止通知書.equals(帳票)) {
                調定事由Flag = true;
            }
            if (!帳票リスト.contains(帳票略称)) {
                row.setTxtChohyoSentaku(帳票略称);
                rowList.add(row);
                帳票リスト.add(帳票略称);
                publishNumber++;
            }
            map.put(帳票略称, 帳票);
        }
        ViewStateHolder.put(ViewStateKeys.発行する帳票リスト, (Serializable) map);
        List<YMDHMS> 調定日時List = ViewStateHolder.get(ViewStateKeys.調定日時リスト, List.class);
        RString 調定日時 = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto().getSelectedKey();
        List<dgChohyoSentaku_Row> dgRowList = new ArrayList<>();
        dgRowList.addAll(rowList);
        if (!調定日時.equals(new RString(調定日時List.get(0).toString()))) {
            賦課台帳Flag = false;
            for (dgChohyoSentaku_Row dgRow : rowList) {
                if (dgRow.getTxtChohyoSentaku().equals(賦課台帳)) {
                    dgRowList.remove(dgRow);
                    break;
                }
            }
        }
        div.setHdnPublishFlag(new RString(String.valueOf(publishNumber)));
        div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().setDataSource(dgRowList);
        set通知書(特徴開始通知書Flag, 決定通知書Flag, 変更通知書Flag, 納入通知書Flag, 減免通知書Flag, 徴収猶予通知書Flag,
                郵振納付書Flag, 賦課台帳Flag, 調定事由Flag);
    }

    private void set通知書(boolean 特徴開始通知書Flag,
            boolean 決定通知書Flag,
            boolean 変更通知書Flag,
            boolean 納入通知書Flag,
            boolean 減免通知書Flag,
            boolean 徴収猶予通知書Flag,
            boolean 郵振納付書Flag,
            boolean 賦課台帳Flag,
            boolean 調定事由Flag) {
        if (!特徴開始通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setDisplayNone(true);
        } else {
            div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setIsOpen(true);
            div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setIsPublish(true);
        }
        if (!決定通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().setDisplayNone(true);
        } else {
            div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().setIsOpen(true);
            div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().setIsPublish(true);
        }
        if (!変更通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(true);
        } else {
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setIsOpen(true);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setIsPublish(true);
        }
        if (!納入通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().setDisplayNone(true);
        } else {
            set納入通知書();
        }
        if (!減免通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().setDisplayNone(true);
        } else {
            div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().setIsOpen(true);
            div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().setIsPublish(true);
        }
        if (!徴収猶予通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().setDisplayNone(true);
        } else {
            div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().setIsOpen(true);
            div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().setIsPublish(true);
        }
        if (!郵振納付書Flag) {
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().setDisplayNone(true);
        } else {
            KoseiTsukiHantei koseiTsukiHantei = new KoseiTsukiHantei();
            FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
            List<KeyValueDataSource> keyValueDataSource = new ArrayList<>();
            Kitsuki 期月 = koseiTsukiHantei.find更正月(RDate.getNowDate());
            KitsukiList 期月リスト = fuchoKiUtil.get期月リスト().filteredLater期(期月.get期AsInt());
            for (Kitsuki 期と月 : 期月リスト.toList()) {
                keyValueDataSource.add(new KeyValueDataSource(期と月.get期(), 期と月.get表記().asX期括弧X月()));
            }
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().getDdlYufuriShuturyokuKi().setDataSource(keyValueDataSource);
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().getDdlYufuriShuturyokuKi().setSelectedKey(期月.get期());
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().setIsOpen(true);
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().setIsPublish(true);
        }
        if (!賦課台帳Flag) {
            div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().setDisplayNone(true);
        } else {
            div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().setIsOpen(true);
            div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().setIsPublish(true);
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().setDisabled(調定事由Flag);
    }

    private void set納入通知書制御情報(RString 帳票) {
        if (保険料納入通知書_仮算定.equals(帳票)) {
            KariSanteiNonyuTsuchiShoSeigyoJoho entity = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance()
                    .get仮算定納入通知書制御情報();
            set出力方式と出力形式(entity.get納入通知書制御情報().get単票発行_出力方式(),
                    entity.get納入通知書制御情報().get単票発行_出力形式());
        }
        if (保険料納入通知書_本算定.equals(帳票) || 保険料納入通知書_過年度.equals(帳票)) {
            HonSanteiNonyuTsuchiShoSeigyoJoho entity = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance()
                    .get本算定納入通知書制御情報();
            set出力方式と出力形式(entity.get納入通知書制御情報().get単票発行_出力方式(),
                    entity.get納入通知書制御情報().get単票発行_出力形式());
        }
    }

    private void set出力方式と出力形式(ShutsuryokuHoshiki 出力方式, ShutsuryokuHoshiki 出力形式) {
        if (出力方式.equals(ShutsuryokuHoshiki.全件出力)) {
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getChkNotsuShuturyokuKi().setSelectedItemsByKey(null);
        } else if (出力方式.equals(ShutsuryokuHoshiki.別々出力)) {
            List<RString> list = new ArrayList<>();
            list.add(KEY0);
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getChkNotsuShuturyokuKi().setSelectedItemsByKey(list);
        }
        if (出力形式.getコード().equals(ShutsuryokuKeishiki.現金.getコード())) {
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getRadNotsuShuturyokuKeishiki().setSelectedKey(KEY0);
        } else if (出力形式.getコード().equals(ShutsuryokuKeishiki.口座.getコード())) {
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getRadNotsuShuturyokuKeishiki().setSelectedKey(KEY1);
        }
    }

    private void set納入通知書() {

        KoseiTsukiHantei koseiTsukiHantei = new KoseiTsukiHantei();
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
        List<KeyValueDataSource> keyValueDataSource = new ArrayList<>();
        Kitsuki 期月 = koseiTsukiHantei.find更正月(RDate.getNowDate());
        KitsukiList 期月リスト = fuchoKiUtil.get期月リスト().filteredLater期(期月.get期AsInt());
        for (Kitsuki 期と月 : 期月リスト.toList()) {
            keyValueDataSource.add(new KeyValueDataSource(期と月.get期(), 期と月.get表記().asX期括弧X月()));
        }
        div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getDdlNotsuShuturyokuKi().setDataSource(keyValueDataSource);
        div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getDdlNotsuShuturyokuKi().setSelectedKey(期月.get期());
        FlexibleYear 調定年度 = ViewStateHolder.get(ViewStateKeys.調定年度, FlexibleYear.class);
        FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
        if (賦課年度.isBefore(調定年度)) {
            Noki 過年度納期 = FukaNokiResearcher.createInstance().get過年度納期(期月.get期AsInt());
            set発行日(過年度納期.get通知書発行日());
        } else if (調定年度.equals(賦課年度)) {
            Noki 普徴納期 = FukaNokiResearcher.createInstance().get普徴納期(期月.get期AsInt());
            set発行日(普徴納期.get通知書発行日());
        }
        div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().setDisplayNone(false);
        div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().setIsOpen(true);
        div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().setIsPublish(true);
    }

    private void set発行日(RDate 発行日) {
        if (発行日 != null) {
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getTxtNotsuHakkoYMD().setValue(
                    new FlexibleDate(発行日.toString()));
        }
    }

    /**
     * 調定事由印字方法を変更のメソッドます。
     */
    public void onChange調定事由印字方法() {
        RString key = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu()
                .getRadKobetsuHakkoChoteiJiyu().getSelectedKey();
        if (KEY0.equals(key)) {
            Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
            FukaJoho info = map.get(div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                    .getDdlInjiKouseiAto().getSelectedKey());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setValue(
                    info.get調定事由1());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setValue(
                    info.get調定事由2());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setValue(
                    info.get調定事由3());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setValue(
                    info.get調定事由4());
        } else if (KEY1.equals(key)) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setValue(RString.EMPTY);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setValue(RString.EMPTY);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setValue(RString.EMPTY);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setValue(RString.EMPTY);
        }
    }

    /**
     * 更正前選択を変更のメソッドます。
     */
    public void onChange更正前() {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        FukaJoho 更正後Info = map.get(div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiAto().getSelectedKey());
        FukaJoho 更正前Info = map.get(div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiMae().getSelectedKey());
        clear更正前賦課根拠();
        clear更正前_特徴();
        clear更正前_普徴();
        set更正前賦課根拠(更正前Info);
        FlexibleYear 賦課年度 = 更正後Info.get賦課年度();
        FlexibleYear 調定年度 = 更正後Info.get調定年度();
        if (!賦課年度.isBefore(調定年度)) {
            FuchoKiUtil util = new FuchoKiUtil();
            set特別徴収(更正前Info, 更正後Info);
            set普通徴収(更正前Info, 更正後Info, util.get期月リスト());
        } else {
            KanendoKiUtil kanendoKi = new KanendoKiUtil();
            set普通徴収(更正前Info, 更正後Info, kanendoKi.get期月リスト());
        }
    }

    /**
     * 更正後選択を変更のメソッドます。
     */
    public void onChange更正後() {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        List<YMDHMS> 調定日時List = ViewStateHolder.get(ViewStateKeys.調定日時リスト, List.class);
        RString 更正後Key = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiAto().getSelectedKey();
        List<YMDHMS> 更正後の調定日時 = new ArrayList<>();
        List<YMDHMS> 調定日時 = new ArrayList<>();
        調定日時.addAll(調定日時List);
        for (YMDHMS 日時 : 調定日時List) {
            if (更正後Key.equals(new RString(日時.toString()))) {
                更正後の調定日時.addAll(調定日時);
                break;
            } else {
                調定日時.remove(日時);
            }
        }
        FukaJoho 更正後Info;
        if (更正後の調定日時.size() == 1) {
            更正後Info = map.get(更正後Key);
            set調定パネルの共通エリア(更正後Info);
            List<KeyValueDataSource> 更正前DataSource = new ArrayList<>();
            更正前DataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setDataSource(更正前DataSource);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setDisabled(true);
            clear更正前賦課根拠();
            set更正後賦課根拠(更正後Info);
            FlexibleYear 賦課年度 = 更正後Info.get賦課年度();
            FlexibleYear 調定年度 = 更正後Info.get調定年度();
            if (!賦課年度.isBefore(調定年度)) {
                FuchoKiUtil util = new FuchoKiUtil();
                set特別徴収(null, 更正後Info);
                set普通徴収(null, 更正後Info, util.get期月リスト());
            } else {
                KanendoKiUtil kanendoKi = new KanendoKiUtil();
                set普通徴収(null, 更正後Info, kanendoKi.get期月リスト());
            }
        } else {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setDisabled(false);
            RString 更正後日時 = new RString(更正後の調定日時.get(0).toString());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto()
                    .setSelectedKey(更正後日時);
            更正後Info = map.get(更正後日時);
            set調定パネルの共通エリア(更正後Info);
            更正後の調定日時.remove(更正後の調定日時.get(0));
            List<KeyValueDataSource> 更正前Data = new ArrayList<>();
            for (YMDHMS 更正前日時 : 更正後の調定日時) {
                RString 年月日 = 更正前日時.getRDateTime().getDate().wareki().toDateString();
                RString 時刻 = 更正前日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm);
                更正前Data.add(new KeyValueDataSource(new RString(更正前日時.toString()), 年月日.concat(スペース).concat(時刻)));
            }
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setDataSource(更正前Data);
            RString 更正前日時 = new RString(更正後の調定日時.get(0).toString());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setSelectedKey(更正前日時);
            FukaJoho 更正前Info = map.get(更正前日時);
            clear更正前賦課根拠();
            clear更正後賦課根拠();
            set更正前賦課根拠(更正前Info);
            set更正後賦課根拠(更正後Info);
            FlexibleYear 賦課年度 = 更正後Info.get賦課年度();
            FlexibleYear 調定年度 = 更正後Info.get調定年度();
            if (!賦課年度.isBefore(調定年度)) {
                FuchoKiUtil util = new FuchoKiUtil();
                set特別徴収(更正前Info, 更正後Info);
                set普通徴収(更正前Info, 更正後Info, util.get期月リスト());
            } else {
                KanendoKiUtil kanendoKi = new KanendoKiUtil();
                set普通徴収(更正前Info, 更正後Info, kanendoKi.get期月リスト());
            }
        }
        List<RString> 発行する帳票リスト = KakushuTsuchishoSakusei.createInstance().get帳票リスト(更正後Info);
        if (発行する帳票リスト != null && !発行する帳票リスト.isEmpty()) {
            set通知書作成パネル(発行する帳票リスト);
        }
    }

    /**
     * 発行処理のメソッドます。
     *
     * @return SourceDataCollection
     */
    public SourceDataCollection to発行処理() {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        RString 更正前Key = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiMae().getSelectedKey();
        RString 更正後Key = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiAto().getSelectedKey();

        KakushuTsuchishoParameter parameter = new KakushuTsuchishoParameter();
        // TODO 仮デ—タ
//        Map<RString, RString> 帳票Map = ViewStateHolder.get(ViewStateKeys.発行する帳票リスト, Map.class);
        List<RString> 発行する帳票List = new ArrayList<>();
//        List<dgChohyoSentaku_Row> rowList = div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().getDataSource();
//        for (dgChohyoSentaku_Row row : rowList) {
//            発行する帳票List.add(帳票Map.get(row.getTxtChohyoSentaku()));
//        }
        発行する帳票List.add(TsuchiSho.特別徴収開始通知書_本算定.get名称());
        parameter.set発行する帳票List(発行する帳票List);
        if (更正前Key != null && !更正前Key.isEmpty()) {
            parameter.set賦課の情報_更正前(map.get(更正前Key));
        }
        parameter.set賦課の情報_更正後(map.get(更正後Key));
        parameter.set決定通知書_発行日(div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu()
                .getTxtKetteiTsuchiHakkoYMD().getValue());
        parameter.set決定通知書_文書番号(div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu()
                .getCcdKetteiTsuchiBunshoNo().get文書番号());
        parameter.set変更通知書_発行日(div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu()
                .getTxtHenkoTsuchiHakkoYMD().getValue());
        parameter.set変更通知書_文書番号(div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu()
                .getCcdHenkoTsuchiBunshoNo().get文書番号());
        TyouteiZiyu 調定事由 = new TyouteiZiyu();
        調定事由.set調定事由_一番目(
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().getValue());
        調定事由.set調定事由_二番目(
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().getValue());
        調定事由.set調定事由_三番目(
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().getValue());
        調定事由.set調定事由_四番目(
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().getValue());
        parameter.set調定事由List(調定事由);
        parameter.set納入通知書_発行日(div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu()
                .getTxtNotsuHakkoYMD().getValue());
        parameter.set納入通知書_出力期(div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().getDdlNotsuShuturyokuKi()
                .getSelectedKey());
        parameter.set納入通知書_出力形式(div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu()
                .getRadNotsuShuturyokuKeishiki().getSelectedKey());
        parameter.set郵振納付書_出力期(div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().getDdlYufuriShuturyokuKi()
                .getSelectedKey());
        parameter.set特徴開始通知書_発行日(div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu()
                .getTxtTokuKaishiTsuchiHakkoYMD().getValue());
        parameter.set減免通知書_発行日(div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu()
                .getTxtGemmenHakkoYMD().getValue());
        parameter.set減免通知書_文書番号(div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu()
                .getCcdGemmenTsuchiBunshoNo().get文書番号());
        parameter.set徴収猶予通知書_発行日(div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu()
                .getTxtChoshuYuyoHakkoYMD().getValue());
        parameter.set徴収猶予通知書_文書番号(div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu()
                .getCcdChoshuYuyoTsuchiBunshoNo().get文書番号());
        return KakushuTsuchishoSakusei.createInstance().publish(parameter);
    }

    private void clear更正前賦課根拠() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae7().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae8().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae9().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae10().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae11().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae12().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae13().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae14().setText(RString.EMPTY);
    }

    private void clear更正後賦課根拠() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto7().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto8().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto9().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto10().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto11().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto12().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto13().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto14().setText(RString.EMPTY);
    }

    private void clear更正前_特徴() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMae1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMae2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMae3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMae4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMae5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMae6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoMaeKei().setText(RString.EMPTY);
    }

    private void clear更正後_特徴() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAto1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAto2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAto3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAto4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAto5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAto6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoAtoKei().setText(RString.EMPTY);
    }

    private void clear期_特徴() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoTokuchoKi6().setText(RString.EMPTY);
    }

    private void clear更正前_普徴() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae7().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae8().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae9().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae10().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae11().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae12().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae13().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMae14().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoMaeKei().setText(RString.EMPTY);
    }

    private void clear更正後_普徴() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto7().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto8().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto9().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto10().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto11().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto12().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto13().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAto14().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoAtoKei().setText(RString.EMPTY);
    }

    private void clear期_普徴() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi7().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi8().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi9().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi10().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi11().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi12().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi13().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoFuchoKi14().setText(RString.EMPTY);
    }

    private void clear納期限() {
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen1().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen2().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen3().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen4().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen5().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen6().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen7().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen8().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen9().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen10().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen11().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen12().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen13().setText(RString.EMPTY);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoKiwariGaku()
                .getLblZengoNokigen14().setText(RString.EMPTY);
    }

    /**
     * 通知書の選択処理のメソッドます。
     *
     * @param flag boolean
     * @param 通知書 RString
     */
    public void check通知書(boolean flag, RString 通知書) {
        List<dgChohyoSentaku_Row> dgRowList = div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().getDataSource();
        List<dgChohyoSentaku_Row> rowList = new ArrayList<>();
        rowList.addAll(dgRowList);
        if (flag) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(通知書);
            rowList.add(row);
        } else {
            for (dgChohyoSentaku_Row dgRow : dgRowList) {
                if (通知書.equals(dgRow.getTxtChohyoSentaku())) {
                    rowList.remove(dgRow);
                }
            }
        }
        div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().setDataSource(rowList);
        if (div.getHdnPublishFlag().equals(STR_0)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, false);
        }
    }
}
