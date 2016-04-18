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
import jp.co.ndensan.reams.db.dbb.business.core.FukaInfo;
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
    private static final RString 減免通知書 = new RString("減免通知書");
    private static final RString 徴収猶予通知書 = new RString("徴収猶予通知書");
    private static final RString 郵振納付書 = new RString("郵便振替納付書");
    private static final RString 賦課台帳 = new RString("賦課台帳");
    private static final RString 保険料納入通知書_仮算定 = new RString("保険料納入通知書_仮算定");
    private static final RString 保険料納入通知書_本算定 = new RString("保険料納入通知書_本算定");
    private static final RString 保険料納入通知書_過年度 = new RString("保険料納入通知書_過年度");
    private static final RString 介護保険料額決定通知書 = new RString("介護保険料額決定通知書");
    private static final RString 介護保険料額変更兼特別徴収中止通知書 = new RString("介護保険料額変更兼特別徴収中止通知書");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString スペース = RString.HALF_SPACE;
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
    public void set調定パネル(ArrayList<FukaInfo> 賦課の情報List) {

        Collections.sort(賦課の情報List, new Comparator<FukaInfo>() {
            @Override
            public int compare(FukaInfo o1, FukaInfo o2) {
                YMDHMS 調定日時o1 = o1.get介護賦課().getChoteiNichiji();
                YMDHMS 調定日時o2 = o2.get介護賦課().getChoteiNichiji();
                if (調定日時o1 != null && 調定日時o2 != null) {
                    return 調定日時o2.compareTo(調定日時o1);
                }
                return 0;
            }
        });
        Map<RString, FukaInfo> map = new HashMap<>();
        for (FukaInfo info : 賦課の情報List) {
            YMDHMS 調定日時 = info.get介護賦課().getChoteiNichiji();
            if (調定日時 != null) {
                map.put(new RString(調定日時.toString()), info);
            }
        }
        ViewStateHolder.put(ViewStateKeys.賦課の情報リスト, (Serializable) map);

        ArrayList<YMDHMS> 調定日時List = new ArrayList<>();
        for (FukaInfo 賦課の情報 : 賦課の情報List) {
            調定日時List.add(賦課の情報.get介護賦課().getChoteiNichiji());
        }
        Collections.sort(調定日時List, new Comparator<YMDHMS>() {
            @Override
            public int compare(YMDHMS o1, YMDHMS o2) {
                return o2.compareTo(o1);
            }
        });
        ViewStateHolder.put(ViewStateKeys.調定日時リスト, 調定日時List);
        FukaInfo 賦課の情報 = 賦課の情報List.get(0);
        set調定パネルの共通エリア(賦課の情報);
        // 検索した結果が1件しか取得できなかった場合
        if (賦課の情報List.size() == 1) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto().setDisabled(true);
            List<KeyValueDataSource> 更正前DataSource = new ArrayList<>();
            更正前DataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setDataSource(更正前DataSource);
            List<KeyValueDataSource> 更正後DataSource = new ArrayList<>();
            YMDHMS 調定日時 = 賦課の情報.get介護賦課().getChoteiNichiji();
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
            set特別徴収(null, 賦課の情報);
            set普通徴収(null, 賦課の情報);
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

            FukaInfo 更正後賦課の情報 = 賦課の情報List.get(0);
            FukaInfo 更正前賦課の情報 = 賦課の情報List.get(1);
            set更正後賦課根拠(更正後賦課の情報);
            set更正前賦課根拠(更正前賦課の情報);
            set特別徴収(更正前賦課の情報, 更正後賦課の情報);
            set普通徴収(更正前賦課の情報, 更正後賦課の情報);
        }
    }

    private void set調定パネルの共通エリア(FukaInfo 賦課の情報) {
        div.getFukaShokaiGrandsonTsuchisho().getTxtChoteiNendo().setDomain(賦課の情報.get介護賦課().getChoteiNendo());
        div.getFukaShokaiGrandsonTsuchisho().getTxtFukaNendo().setDomain(賦課の情報.get介護賦課().getFukaNendo());
        div.getFukaShokaiGrandsonTsuchisho().getTxtKoseiM().setValue(賦課の情報.get介護賦課().getKoseiM());
        // TODO 更正日時
        div.getFukaShokaiGrandsonTsuchisho().getTxtKoseiDateTime().setValue(null);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getRadKobetsuHakkoChoteiJiyu()
                .setSelectedKey(KEY0);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setValue(
                賦課の情報.get介護賦課().getChoteiJiyu1());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setValue(
                賦課の情報.get介護賦課().getChoteiJiyu2());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setValue(
                賦課の情報.get介護賦課().getChoteiJiyu3());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setValue(
                賦課の情報.get介護賦課().getChoteiJiyu4());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(true);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(true);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(true);
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(true);
        clear更正前賦課根拠();
        clear更正後賦課根拠();
    }

    private void set更正前賦課根拠(FukaInfo 賦課の情報) {

        if (賦課の情報.get介護賦課().getFukaYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae1().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getFukaYMD()));
        }
        if (賦課の情報.get介護賦課().getShikakuShutokuYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae2().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getShikakuShutokuYMD()));
        }
        if (賦課の情報.get介護賦課().getShikakuSoshitsuYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae3().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getShikakuSoshitsuYMD()));
        }
        if (賦課の情報.get介護賦課().getSeihoKaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae4().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getSeihoKaishiYMD()));
        }
        if (賦課の情報.get介護賦課().getSeihoHaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae5().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getSeihoHaishiYMD()));
        }
        if (賦課の情報.get介護賦課().getRonenKaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae6().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getRonenKaishiYMD()));
        }
        if (賦課の情報.get介護賦課().getRonenHaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae7().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getRonenHaishiYMD()));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae8().setText(賦課の情報.get介護賦課().getKazeiKubun());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae9().setText(賦課の情報.get介護賦課().getSetaikazeiKubun());
        Decimal 合計所得金額 = 賦課の情報.get介護賦課().getGokeiShotokuGaku();
        if (合計所得金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae10().setText(DecimalFormatter.toコンマ区切りRString(合計所得金額, 0));
        }
        Decimal 年金収入額 = 賦課の情報.get介護賦課().getNenkinShunyuGaku();
        if (年金収入額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae11().setText(DecimalFormatter.toコンマ区切りRString(年金収入額, 0));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoMae12().setText(賦課の情報.get介護賦課().getHokenryoDankai());
        Decimal 減免額 = 賦課の情報.get介護賦課().getGemmenGaku();
        if (減免額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae13().setText(DecimalFormatter.toコンマ区切りRString(減免額, 0));
        }
        Decimal 保険料額 = 賦課の情報.get介護賦課().getKakuteiHokenryo();
        if (保険料額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoMae14().setText(DecimalFormatter.toコンマ区切りRString(保険料額, 0));
        }
    }

    private void set更正後賦課根拠(FukaInfo 賦課の情報) {

        if (賦課の情報.get介護賦課().getFukaYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto1().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getFukaYMD()));
        }
        if (賦課の情報.get介護賦課().getShikakuShutokuYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto2().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getShikakuShutokuYMD()));
        }
        if (賦課の情報.get介護賦課().getShikakuSoshitsuYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto3().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getShikakuSoshitsuYMD()));
        }
        if (賦課の情報.get介護賦課().getSeihoKaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto4().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getSeihoKaishiYMD()));
        }
        if (賦課の情報.get介護賦課().getSeihoHaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto5().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getSeihoHaishiYMD()));
        }
        if (賦課の情報.get介護賦課().getRonenKaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto6().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getRonenKaishiYMD()));
        }
        if (賦課の情報.get介護賦課().getRonenHaishiYMD() != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto7().setText(DateEditor.to和暦(賦課の情報.get介護賦課().getRonenHaishiYMD()));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto8().setText(賦課の情報.get介護賦課().getKazeiKubun());
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto9().setText(賦課の情報.get介護賦課().getSetaikazeiKubun());
        Decimal 合計所得金額 = 賦課の情報.get介護賦課().getGokeiShotokuGaku();
        if (合計所得金額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto10().setText(DecimalFormatter.toコンマ区切りRString(合計所得金額, 0));
        }
        Decimal 年金収入額 = 賦課の情報.get介護賦課().getNenkinShunyuGaku();
        if (年金収入額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto11().setText(DecimalFormatter.toコンマ区切りRString(年金収入額, 0));
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                .getLblFukankonkyoAto12().setText(賦課の情報.get介護賦課().getHokenryoDankai());
        Decimal 減免額 = 賦課の情報.get介護賦課().getGemmenGaku();
        if (減免額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto13().setText(DecimalFormatter.toコンマ区切りRString(減免額, 0));
        }
        Decimal 保険料額 = 賦課の情報.get介護賦課().getKakuteiHokenryo();
        if (保険料額 != null) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getTblKobetsuHakkoFukakonkyo()
                    .getLblFukankonkyoAto14().setText(DecimalFormatter.toコンマ区切りRString(保険料額, 0));
        }
    }

    private void set特別徴収(FukaInfo 更正前情報, FukaInfo 更正後情報) {

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

    private void set特徴_更正前期割額(FukaInfo 更正前情報,
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

    private Decimal get特徴期別金額(RString 期, FukaInfo 賦課の情報) {
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

    private void set普通徴収(FukaInfo 更正前情報, FukaInfo 更正後情報) {
        clear更正前_普徴();
        clear更正後_普徴();
        FuchoKiUtil util = new FuchoKiUtil();
        KitsukiList 期月リスト = util.get期月リスト();
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
    }

    private void set普徴_更正前期割額(FukaInfo 更正前情報,
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

    private Decimal get普徴期別金額(RString 期, FukaInfo 賦課の情報) {
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
        for (RString 帳票 : 発行する帳票リスト) {
            row = new dgChohyoSentaku_Row();
            RString 帳票略称 = TsuchiSho.valueOf(帳票.toString()).get略称();
            row.setTxtChohyoSentaku(帳票略称);
            rowList.add(row);
            if (特徴開始通知書.equals(帳票略称)) {
                特徴開始通知書Flag = true;
            } else if (決定通知書.equals(帳票略称)) {
                決定通知書Flag = true;
            } else if (変更通知書.equals(帳票略称)) {
                変更通知書Flag = true;
            } else if (納入通知書.equals(帳票略称)) {
                set納入通知書制御情報(帳票);
                納入通知書Flag = true;
            } else if (減免通知書.equals(帳票略称)) {
                減免通知書Flag = true;
            } else if (徴収猶予通知書.equals(帳票略称)) {
                徴収猶予通知書Flag = true;
            } else if (郵振納付書.equals(帳票略称)) {
                郵振納付書Flag = true;
            } else if (賦課台帳.equals(帳票略称)) {
                賦課台帳Flag = true;
            }
            if (!介護保険料額決定通知書.equals(帳票) && !介護保険料額変更兼特別徴収中止通知書.equals(帳票)) {
                調定事由Flag = true;
            }
        }
        div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().setDataSource(rowList);
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
        }
        if (!決定通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().setDisplayNone(true);
        }
        if (!変更通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(true);
        }
        if (!納入通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().setDisplayNone(true);
        } else {
            set納入通知書();
        }
        if (!減免通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().setDisplayNone(true);
        }
        if (!徴収猶予通知書Flag) {
            div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().setDisplayNone(true);
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
        }
        if (!賦課台帳Flag) {
            div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().setDisplayNone(true);
        }
        div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().setDisplayNone(調定事由Flag);
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
            Noki 普徴納期 = FukaNokiResearcher.createInstance().get普徴納期(期月.get期AsInt());
            set発行日(普徴納期.get通知書発行日());
        } else if (調定年度.equals(賦課年度)) {
            Noki 過年度納期 = FukaNokiResearcher.createInstance().get過年度納期(期月.get期AsInt());
            set発行日(過年度納期.get通知書発行日());
        }
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
            Map<RString, FukaInfo> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
            FukaInfo info = map.get(div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                    .getDdlInjiKouseiAto().getSelectedKey());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setValue(
                    info.get介護賦課().getChoteiJiyu1());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setValue(
                    info.get介護賦課().getChoteiJiyu2());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setValue(
                    info.get介護賦課().getChoteiJiyu3());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setValue(
                    info.get介護賦課().getChoteiJiyu4());
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
        Map<RString, FukaInfo> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        FukaInfo 更正後Info = map.get(div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiAto().getSelectedKey());
        FukaInfo 更正前Info = map.get(div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiMae().getSelectedKey());
        clear更正前賦課根拠();
        clear更正前_特徴();
        clear更正前_普徴();
        set更正前賦課根拠(更正前Info);
        set特別徴収(更正前Info, 更正後Info);
        set普通徴収(更正前Info, 更正後Info);
    }

    /**
     * 更正後選択を変更のメソッドます。
     */
    public void onChange更正後() {
        Map<RString, FukaInfo> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
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
        if (更正後の調定日時.size() == 1) {
            FukaInfo 更正後Info = map.get(更正後Key);
            set調定パネルの共通エリア(更正後Info);
            List<KeyValueDataSource> 更正前DataSource = new ArrayList<>();
            更正前DataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae()
                    .setDataSource(更正前DataSource);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setDisabled(true);
            clear更正前賦課根拠();
            set更正後賦課根拠(更正後Info);
            set特別徴収(null, 更正後Info);
            set普通徴収(null, 更正後Info);
        } else {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiMae().setDisabled(false);
            RString 更正後日時 = new RString(更正後の調定日時.get(0).toString());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku().getDdlInjiKouseiAto()
                    .setSelectedKey(更正後日時);
            FukaInfo 更正後Info = map.get(更正後日時);
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
            FukaInfo 更正前Info = map.get(更正前日時);
            clear更正前賦課根拠();
            clear更正後賦課根拠();
            set更正前賦課根拠(更正前Info);
            set更正後賦課根拠(更正後Info);
            set特別徴収(更正前Info, 更正後Info);
            set普通徴収(更正前Info, 更正後Info);
        }
    }

    /**
     * 発行処理のメソッドます。
     *
     * @return SourceDataCollection
     */
    public SourceDataCollection to発行処理() {
        Map<RString, FukaInfo> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        RString 更正前Key = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiMae().getSelectedKey();
        RString 更正後Key = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                .getDdlInjiKouseiAto().getSelectedKey();

        KakushuTsuchishoParameter parameter = new KakushuTsuchishoParameter();
        parameter.set発行する帳票List(null);
        if (!更正前Key.isEmpty()) {
            parameter.set賦課の情報_更正前(null);
            // TODO
//            parameter.set賦課の情報_更正前(map.get(更正前Key));
        }
        parameter.set賦課の情報_更正後(null);
        // TODO
//      parameter.set賦課の情報_更正後(map.get(更正後Key));
        parameter.set決定通知書_発行日(null);
        parameter.set決定通知書_文書番号(null);
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
}
