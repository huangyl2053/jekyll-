/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.KibetsuChoshyuYuyoKikann;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.chochuyuyo.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kaigofukachoshuyuyo.KaigoFukaChoshuYuyoParam;
import jp.co.ndensan.reams.db.dbb.business.core.kaigofukachoshuyuyo.KaigoKibetsuChoshuYuyoParam;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.IFukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.FuchoTablePanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.KetteiJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.TorikeshiJohoDiv;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukachoshuyuyo.KaigoFukaChoshuYuyo;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護保険料徴収猶予画面のHandlerです。
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class ChoshuYuyoJuminKihonHandler {

    private final ChoshuYuyoJuminKihonDiv div;
    private Decimal 普通徴収_合計 = Decimal.ZERO;
    private static final RString 期R = new RString("期");
    private static final int ゼロ_定値 = 0;
    private static final int イチ_定値 = 1;
    private static final int 二_定値 = 2;
    private static final int ミ_定値 = 3;
    private static final int ヨ_定値 = 4;
    private static final int ゴ_定値 = 5;
    private static final int ロク_定値 = 6;
    private static final int ナナ_定値 = 7;
    private static final int ハチ_定値 = 8;
    private static final int キュウ_定値 = 9;
    private static final int ジュウ_定値 = 10;
    private static final int ジュウイチ_定値 = 11;
    private static final int ジュウ二_定値 = 12;
    private static final int ジュウミ_定値 = 13;
    private static final int ジュウヨ_定値 = 14;
    private static final int ジュウゴ_定値 = 15;
    private static final RString 定値_イチ = new RString("1");
    private static final RString 定値_二 = new RString("2");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString 空 = RString.EMPTY;
    private final KitsukiList 普徴期月リスト = new FuchoKiUtil().get期月リスト();
    private static final RString 状況_申請中 = new RString("申請中");
    private static final RString 状況_決定済 = new RString("決定済");
    private static final RString 状況_新規 = new RString("新規申請");
    private static final RString 承認 = new RString("承認する");
    private static final RString 不承認 = new RString("承認しない");
    private static final RString 入力状況_新規申請 = new RString("新規_申請");
    private static final RString 入力状況_新規決定 = new RString("新規_決定");
    private static final RString 入力状況_申請中取消 = new RString("申請中_取消");
    private static final RString 入力状況_申請中申請 = new RString("申請中_申請");
    private static final RString 入力状況_申請中決定 = new RString("申請中_決定");
    private static final RString 入力状況_決定済訂正 = new RString("決定済_訂正");
    private static final RString 入力状況_決定済取消 = new RString("決定済_取消");
    private static final RString 保存ボタン = new RString("btnUpt");
    private static final RString 訂正をやめるボタン = new RString("btnTeiseiCansel");
    private static final RString 取消をやめるボタン = new RString("btnTorikeshiCansel");
    private static final CodeShubetsu 保険料徴収猶予種類_コード種別 = new CodeShubetsu("0005");

    /**
     * ヘッダパネルの初期化メソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param searchKey KaigoFukaKihonSearchKey
     */
    public void loadヘッダパネル(ShikibetsuCode 識別コード, KaigoFukaKihonSearchKey searchKey) {
        div.getAtenaKihon().initialize(識別コード);
        div.getCcdKaigoFukaKihon().load(searchKey);
    }

    /**
     * 全賦課履歴情報グリッドと状況情報パネルの初期化メソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 賦課年度 FukaNendo
     * @return 件数 int
     */
    public int load全賦課履歴情報グリッド(HihokenshaNo 被保険者番号, FukaNendo 賦課年度) {
        IFukaRirekiAllDiv 全賦課履歴 = div.getChoshuYuyoFukaRirekiAll().getDghukainfo();
        return 全賦課履歴.load(被保険者番号, 賦課年度);
    }

    /**
     * 賦課基本を取得する。
     *
     * @return 賦課基本 Fuka
     */
    public Fuka get賦課基本() {
        IFukaRirekiAllDiv 全賦課履歴 = div.getChoshuYuyoFukaRirekiAll().getDghukainfo();
        return 全賦課履歴.get賦課履歴().get賦課履歴All().toList().get(0);
    }

    /**
     * 状況情報パネルの値を設定する。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     * @return 状況 RString
     */
    public RString load状況情報パネル(ChoshuYuyoJoho 徴収猶予の情報) {
        RString 徴収猶予状態区分;
        RString 状況;
        if (徴収猶予の情報 == null || 徴収猶予の情報.getChoshuYuyoList().isEmpty()) {
            状況 = 状況_新規;
        } else {
            徴収猶予状態区分 = 徴収猶予の情報.get徴収猶予状態区分();
            状況 = get状況(徴収猶予状態区分);
        }
        ChoshuYuyoMainDiv 状況情報パネル = div.getChoshuYuyoMain();
        状況情報パネル.getTxtShinseiJokyo().setValue(状況);
        if (状況_新規.equals(状況)) {
            状況情報パネル.getBtnTeisei().setDisplayNone(true);
            状況情報パネル.getBtnTorikeshi().setDisplayNone(true);
        } else if (状況_申請中.equals(状況)) {
            状況情報パネル.getBtnTeisei().setDisplayNone(true);
            状況情報パネル.getBtnTorikeshi().setDisabled(false);
        } else if (状況_決定済.equals(状況)) {
            状況情報パネル.getBtnTeisei().setDisplayNone(false);
            状況情報パネル.getBtnTeisei().setDisabled(false);
            状況情報パネル.getBtnTorikeshi().setDisabled(false);
        }
        return 状況;
    }

    private RString get状況(RString 徴収猶予状態区分) {
        if (徴収猶予状態区分 == null || 徴収猶予状態区分.isEmpty()) {
            return 空;
        }
        switch (Integer.valueOf(徴収猶予状態区分.toString())) {
            case ゼロ_定値:
                return 状況_申請中;
            case イチ_定値:
                return 状況_決定済;
            case 二_定値:
                return 状況_決定済;
            case ミ_定値:
                return 状況_新規;
            case キュウ_定値:
                return 状況_新規;
            default:
                return 空;
        }
    }

    /**
     * 申請情報パネルの値を設定する。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     * @return 徴収猶予の情報 Code
     */
    public Code load申請情報パネル(ChoshuYuyoJoho 徴収猶予の情報) {
        ShinseiJohoDiv 申請情報パネル = div.getChoshuYuyoMain().getShinseiJoho();
        if (徴収猶予の情報 != null) {
            申請情報パネル.getTxtChoteiNendo().setValue(new RDate(徴収猶予の情報.get調定年度().toString()));
            申請情報パネル.getTxtFukaNendo().setValue(new RDate(徴収猶予の情報.get賦課年度().toString()));
            List<ChoshuYuyo> 介護賦課徴収猶予List = 徴収猶予の情報.getChoshuYuyoList();
            if (介護賦課徴収猶予List != null && !介護賦課徴収猶予List.isEmpty()) {
                return set申請情報パネル(介護賦課徴収猶予List.get(0), 申請情報パネル);
            }
        }
        return null;
    }

    private Code set申請情報パネル(ChoshuYuyo 介護賦課徴収猶予, ShinseiJohoDiv 申請情報パネル) {
        if (介護賦課徴収猶予.get徴収猶予申請年月日() != null) {
            申請情報パネル.getTxtShinseiYMD().setValue(new RDate(介護賦課徴収猶予.get徴収猶予申請年月日().toString()));
        }
        if (介護賦課徴収猶予.get徴収猶予種類コード() != null) {
            申請情報パネル.getTxtYuyoShurui().setValue(CodeMaster.getCodeRyakusho(
                    SubGyomuCode.DBB介護賦課, 保険料徴収猶予種類_コード種別, 介護賦課徴収猶予.get徴収猶予種類コード(), FlexibleDate.getNowDate()));
        }
        申請情報パネル.getTxtShinseiRiyu().setValue(介護賦課徴収猶予.get申請事由());
        return 介護賦課徴収猶予.get徴収猶予種類コード();
    }

    /**
     * 決定情報パネルの値を設定する。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     */
    public void load決定情報パネル(ChoshuYuyoJoho 徴収猶予の情報) {
        KetteiJohoDiv 決定情報パネル = div.getChoshuYuyoMain().getKetteiJoho();
        決定情報パネル.getRadKetteiKubun().setDataSource(get決定区分());
        if (徴収猶予の情報 != null) {
            決定情報パネル.getTxtKetteiYMD().setValue(new RDate(徴収猶予の情報.get徴収猶予決定年月日().toString()));
            List<ChoshuYuyo> 介護賦課徴収猶予List = 徴収猶予の情報.getChoshuYuyoList();
            if (介護賦課徴収猶予List != null && !介護賦課徴収猶予List.isEmpty()) {
                set決定情報パネル(介護賦課徴収猶予List.get(0), 決定情報パネル);
            }
        }
    }

    private void set決定情報パネル(ChoshuYuyo 介護賦課徴収猶予, KetteiJohoDiv 決定情報パネル) {
        RString 減免状態区分 = 介護賦課徴収猶予.get徴収猶予状態区分();
        if (定値_二.equals(減免状態区分)) {
            決定情報パネル.getRadKetteiKubun().setSelectedValue(不承認);
        } else {
            決定情報パネル.getRadKetteiKubun().setSelectedValue(承認);
        }
        決定情報パネル.getTxtKetteiRiyu().setValue(介護賦課徴収猶予.get徴収猶予事由());
    }

    /**
     * 期別徴収猶予期間リストを生成する。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     * @return List<KibetsuChoshyuYuyoKikann> 期別徴収猶予期間リスト
     */
    private List<KibetsuChoshyuYuyoKikann> get期別徴収猶予期間リスト(ChoshuYuyoJoho 徴収猶予の情報) {
        List<KibetsuChoshyuYuyoKikann> 期別徴収猶予期間リスト = new ArrayList<>();
        for (int i = イチ_定値; i < ジュウゴ_定値; i++) {
            KibetsuChoshyuYuyoKikann 期別徴収猶予期間 = new KibetsuChoshyuYuyoKikann();
            Kitsuki 期月_普徴 = 普徴期月リスト.get期の最初月(i);
            RString 期_普徴 = 期月_普徴.get期();
            期別徴収猶予期間.set普徴期(期_普徴.padZeroToLeft(二_定値));
            期別徴収猶予期間.set普徴月(期月_普徴.get月().getコード());
            Decimal 普徴期別金額 = get普徴期別納付額(期_普徴, 徴収猶予の情報);
            if (普徴期別金額 != null) {
                普通徴収_合計.add(普徴期別金額);
                期別徴収猶予期間.set普徴期別納付額(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
            }
            FlexibleDate 徴収猶予期間開始 = get徴収猶予期間開始(期_普徴, 徴収猶予の情報);
            if (徴収猶予期間開始 != null) {
                期別徴収猶予期間.set徴収猶予期間開始(徴収猶予期間開始.wareki().toDateString());
            } else {
                期別徴収猶予期間.set徴収猶予期間開始(空);
            }
            FlexibleDate 徴収猶予期間終了 = get徴収猶予期間終了(期_普徴, 徴収猶予の情報);
            if (徴収猶予期間開始 != null) {
                期別徴収猶予期間.set徴収猶予期間終了(徴収猶予期間終了.wareki().toDateString());
            } else {
                期別徴収猶予期間.set徴収猶予期間終了(空);
            }
            期別徴収猶予期間リスト.add(期別徴収猶予期間);
        }
        return 期別徴収猶予期間リスト;
    }

    private FlexibleDate get徴収猶予期間終了(RString 期, ChoshuYuyoJoho 徴収猶予の情報) {
        if (期 == null || 期.isEmpty()) {
            return null;
        }
        switch (Integer.valueOf(期.toString())) {
            case イチ_定値:
                return 徴収猶予の情報.get普徴猶予終了日01();
            case 二_定値:
                return 徴収猶予の情報.get普徴猶予終了日02();
            case ミ_定値:
                return 徴収猶予の情報.get普徴猶予終了日03();
            case ヨ_定値:
                return 徴収猶予の情報.get普徴猶予終了日04();
            case ゴ_定値:
                return 徴収猶予の情報.get普徴猶予終了日05();
            case ロク_定値:
                return 徴収猶予の情報.get普徴猶予終了日06();
            case ナナ_定値:
                return 徴収猶予の情報.get普徴猶予終了日07();
            case ハチ_定値:
                return 徴収猶予の情報.get普徴猶予終了日08();
            case キュウ_定値:
                return 徴収猶予の情報.get普徴猶予終了日09();
            case ジュウ_定値:
                return 徴収猶予の情報.get普徴猶予終了日10();
            case ジュウイチ_定値:
                return 徴収猶予の情報.get普徴猶予終了日11();
            case ジュウ二_定値:
                return 徴収猶予の情報.get普徴猶予終了日12();
            case ジュウミ_定値:
                return 徴収猶予の情報.get普徴猶予終了日13();
            case ジュウヨ_定値:
                return 徴収猶予の情報.get普徴猶予終了日14();
            default:
                return null;
        }
    }

    private FlexibleDate get徴収猶予期間開始(RString 期, ChoshuYuyoJoho 徴収猶予の情報) {
        if (期 == null || 期.isEmpty()) {
            return null;
        }
        switch (Integer.valueOf(期.toString())) {
            case イチ_定値:
                return 徴収猶予の情報.get普徴猶予開始日01();
            case 二_定値:
                return 徴収猶予の情報.get普徴猶予開始日02();
            case ミ_定値:
                return 徴収猶予の情報.get普徴猶予開始日03();
            case ヨ_定値:
                return 徴収猶予の情報.get普徴猶予開始日04();
            case ゴ_定値:
                return 徴収猶予の情報.get普徴猶予開始日05();
            case ロク_定値:
                return 徴収猶予の情報.get普徴猶予開始日06();
            case ナナ_定値:
                return 徴収猶予の情報.get普徴猶予開始日07();
            case ハチ_定値:
                return 徴収猶予の情報.get普徴猶予開始日08();
            case キュウ_定値:
                return 徴収猶予の情報.get普徴猶予開始日09();
            case ジュウ_定値:
                return 徴収猶予の情報.get普徴猶予開始日10();
            case ジュウイチ_定値:
                return 徴収猶予の情報.get普徴猶予開始日11();
            case ジュウ二_定値:
                return 徴収猶予の情報.get普徴猶予開始日12();
            case ジュウミ_定値:
                return 徴収猶予の情報.get普徴猶予開始日13();
            case ジュウヨ_定値:
                return 徴収猶予の情報.get普徴猶予開始日14();
            default:
                return null;
        }
    }

    private Decimal get普徴期別納付額(RString 期, ChoshuYuyoJoho 徴収猶予の情報) {
        if (期 == null || 期.isEmpty()) {
            return null;
        }
        switch (Integer.valueOf(期.toString())) {
            case イチ_定値:
                return 徴収猶予の情報.get普徴期別金額01();
            case 二_定値:
                return 徴収猶予の情報.get普徴期別金額02();
            case ミ_定値:
                return 徴収猶予の情報.get普徴期別金額03();
            case ヨ_定値:
                return 徴収猶予の情報.get普徴期別金額04();
            case ゴ_定値:
                return 徴収猶予の情報.get普徴期別金額05();
            case ロク_定値:
                return 徴収猶予の情報.get普徴期別金額06();
            case ナナ_定値:
                return 徴収猶予の情報.get普徴期別金額07();
            case ハチ_定値:
                return 徴収猶予の情報.get普徴期別金額08();
            case キュウ_定値:
                return 徴収猶予の情報.get普徴期別金額09();
            case ジュウ_定値:
                return 徴収猶予の情報.get普徴期別金額10();
            case ジュウイチ_定値:
                return 徴収猶予の情報.get普徴期別金額11();
            case ジュウ二_定値:
                return 徴収猶予の情報.get普徴期別金額12();
            case ジュウミ_定値:
                return 徴収猶予の情報.get普徴期別金額13();
            case ジュウヨ_定値:
                return 徴収猶予の情報.get普徴期別金額14();
            default:
                return null;
        }
    }

    /**
     * 普通徴収猶予情報パネルの初期化メソッドです。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     * @return 普通徴収_合計 Decimal
     */
    public Decimal load普通徴収猶予情報パネル(ChoshuYuyoJoho 徴収猶予の情報) {
        FuchoTablePanelDiv 普通徴収猶予情報パネル = div.getChoshuYuyoMain().getFuchoTablePanel();
        RString 期_4月 = 普徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_5月 = 普徴期月リスト.get月の期(Tsuki._5月).get期();
        RString 期_6月 = 普徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_7月 = 普徴期月リスト.get月の期(Tsuki._7月).get期();
        RString 期_8月 = 普徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_9月 = 普徴期月リスト.get月の期(Tsuki._9月).get期();
        RString 期_10月 = 普徴期月リスト.get月の期(Tsuki._10月).get期();
        RString 期_11月 = 普徴期月リスト.get月の期(Tsuki._11月).get期();
        RString 期_12月 = 普徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_1月 = 普徴期月リスト.get月の期(Tsuki._1月).get期();
        RString 期_2月 = 普徴期月リスト.get月の期(Tsuki._2月).get期();
        RString 期_3月 = 普徴期月リスト.get月の期(Tsuki._3月).get期();
        RString 期_翌年4月 = 普徴期月リスト.get月の期(Tsuki.翌年度4月).get期();
        RString 期_翌年5月 = 普徴期月リスト.get月の期(Tsuki.翌年度5月).get期();
        普通徴収猶予情報パネル.getLblFuchoKi13().setText(get期(期_4月));
        普通徴収猶予情報パネル.getLblFuchoKi14().setText(get期(期_5月));
        普通徴収猶予情報パネル.getLblFuchoKi1().setText(get期(期_6月));
        普通徴収猶予情報パネル.getLblFuchoKi2().setText(get期(期_7月));
        普通徴収猶予情報パネル.getLblFuchoKi3().setText(get期(期_8月));
        普通徴収猶予情報パネル.getLblFuchoKi4().setText(get期(期_9月));
        普通徴収猶予情報パネル.getLblFuchoKi5().setText(get期(期_10月));
        普通徴収猶予情報パネル.getLblFuchoKi6().setText(get期(期_11月));
        普通徴収猶予情報パネル.getLblFuchoKi7().setText(get期(期_12月));
        普通徴収猶予情報パネル.getLblFuchoKi8().setText(get期(期_1月));
        普通徴収猶予情報パネル.getLblFuchoKi9().setText(get期(期_2月));
        普通徴収猶予情報パネル.getLblFuchoKi10().setText(get期(期_3月));
        普通徴収猶予情報パネル.getLblFuchoKi11().setText(get期(期_翌年4月));
        普通徴収猶予情報パネル.getLblFuchoKi12().setText(get期(期_翌年5月));
        List<KibetsuChoshyuYuyoKikann> 期別徴収猶予期間リスト = get期別徴収猶予期間リスト(徴収猶予の情報);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間1 = 期別徴収猶予期間リスト.get(ゼロ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間2 = 期別徴収猶予期間リスト.get(イチ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間3 = 期別徴収猶予期間リスト.get(二_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間4 = 期別徴収猶予期間リスト.get(ミ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間5 = 期別徴収猶予期間リスト.get(ヨ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間6 = 期別徴収猶予期間リスト.get(ゴ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間7 = 期別徴収猶予期間リスト.get(ロク_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間8 = 期別徴収猶予期間リスト.get(ナナ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間9 = 期別徴収猶予期間リスト.get(ハチ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間10 = 期別徴収猶予期間リスト.get(キュウ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間11 = 期別徴収猶予期間リスト.get(ジュウ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間12 = 期別徴収猶予期間リスト.get(ジュウイチ_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間13 = 期別徴収猶予期間リスト.get(ジュウ二_定値);
        KibetsuChoshyuYuyoKikann 期別徴収猶予期間14 = 期別徴収猶予期間リスト.get(ジュウミ_定値);
        普通徴収猶予情報パネル.getLblFuchoNofuGaku13().setText(期別徴収猶予期間1.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku14().setText(期別徴収猶予期間2.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku1().setText(期別徴収猶予期間3.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku2().setText(期別徴収猶予期間4.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku3().setText(期別徴収猶予期間5.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku4().setText(期別徴収猶予期間6.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku5().setText(期別徴収猶予期間7.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku6().setText(期別徴収猶予期間8.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku7().setText(期別徴収猶予期間9.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku8().setText(期別徴収猶予期間10.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku9().setText(期別徴収猶予期間11.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku10().setText(期別徴収猶予期間12.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku11().setText(期別徴収猶予期間13.get普徴期別納付額());
        普通徴収猶予情報パネル.getLblFuchoNofuGaku12().setText(期別徴収猶予期間14.get普徴期別納付額());
        // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi13().setText(期別徴収猶予期間1.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi14().setText(期別徴収猶予期間2.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi1().setText(期別徴収猶予期間3.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi2().setText(期別徴収猶予期間4.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi3().setText(期別徴収猶予期間5.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi4().setText(期別徴収猶予期間6.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi5().setText(期別徴収猶予期間7.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi6().setText(期別徴収猶予期間8.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi7().setText(期別徴収猶予期間9.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi8().setText(期別徴収猶予期間10.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi9().setText(期別徴収猶予期間11.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi10().setText(期別徴収猶予期間12.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi11().setText(期別徴収猶予期間13.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanKaishi12().setText(期別徴収猶予期間14.get徴収猶予期間開始());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo13().setText(期別徴収猶予期間1.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo14().setText(期別徴収猶予期間2.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo1().setText(期別徴収猶予期間3.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo2().setText(期別徴収猶予期間4.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo3().setText(期別徴収猶予期間5.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo4().setText(期別徴収猶予期間6.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo5().setText(期別徴収猶予期間7.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo6().setText(期別徴収猶予期間8.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo7().setText(期別徴収猶予期間9.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo8().setText(期別徴収猶予期間10.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo9().setText(期別徴収猶予期間11.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo10().setText(期別徴収猶予期間12.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo11().setText(期別徴収猶予期間13.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblYuyoKikanShuryo12().setText(期別徴収猶予期間14.get徴収猶予期間終了());
        普通徴収猶予情報パネル.getLblFuchoNofuGakuTotal().setText(DecimalFormatter.toコンマ区切りRString(普通徴収_合計, ゼロ_定値));
        return 普通徴収_合計;
    }

    private RString get期(RString 期) {
        if (期 != null && !期.isEmpty()) {
            return 期.concat(期R);
        }
        return null;
    }

    /**
     * 全賦課履歴情報.表示件数＝1件の場合、パネルの状態の設定する。
     *
     * @param 状況 RString
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     */
    public void loadパネル状態1(RString 状況, ChoshuYuyoJoho 徴収猶予の情報) {
        div.getChoshuYuyoFukaRirekiAll().getDghukainfo().setDisplayNone(true);
        div.getChoshuYuyoMain().getTorikeshiJoho().setDisplayNone(true);
        ShinseiJohoDiv 申請情報パネル = div.getChoshuYuyoMain().getShinseiJoho();
        申請情報パネル.getTxtChoteiNendo().setReadOnly(true);
        申請情報パネル.getTxtFukaNendo().setReadOnly(true);
        申請情報パネル.getTxtYuyoShurui().setReadOnly(true);
        KetteiJohoDiv 決定情報パネル = div.getChoshuYuyoMain().getKetteiJoho();
        // TODO QA1195 labelはTextBoxDateに変換は必要ですが？ 状態定義sheetの61－88行の状態は入力可の設定。
//        FuchoTablePanelDiv 普通徴収猶予情報パネル = div.getChoshuYuyoMain().getFuchoTablePanel();
        if (状況_新規.equals(状況) || 状況_申請中.equals(状況)) {
            申請情報パネル.getTxtShinseiYMD().setReadOnly(false);
            申請情報パネル.getBtnYuyoShurui().setDisabled(false);
            申請情報パネル.getTxtShinseiRiyu().setReadOnly(false);
            決定情報パネル.getTxtKetteiYMD().setReadOnly(false);
            決定情報パネル.getRadKetteiKubun().setDisabled(false);
            決定情報パネル.getTxtKetteiRiyu().setReadOnly(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
        } else if (状況_決定済.equals(状況)) {
            申請情報パネル.getTxtShinseiYMD().setReadOnly(true);
            申請情報パネル.getBtnYuyoShurui().setDisabled(true);
            申請情報パネル.getTxtShinseiRiyu().setReadOnly(true);
            決定情報パネル.getTxtKetteiYMD().setReadOnly(true);
            決定情報パネル.getRadKetteiKubun().setDisabled(true);
            決定情報パネル.getTxtKetteiRiyu().setReadOnly(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, true);
        }
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, true);
    }

    /**
     * 全賦課履歴情報.表示件数 ≠ 1件の場合、パネルの状態の設定する。
     */
    public void loadパネル状態2() {
        div.getChoshuYuyoFukaRirekiAll().setDisplayNone(false);
        div.getChoshuYuyoMain().setDisplayNone(true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, true);
    }

    /**
     * 全賦課履歴情報グリッドの選択ボタン押下のメソッドです。
     *
     * @return 徴収猶予の情報 ChoshuYuyoJoho
     */
    public ChoshuYuyoJoho onClick_選択ボタン() {
        IFukaRirekiAllDiv 全賦課履歴 = div.getChoshuYuyoFukaRirekiAll().getDghukainfo();
        IItemList<Fuka> 全賦課履歴データ = 全賦課履歴.get賦課履歴().get賦課履歴All();
        Fuka 賦課基本 = 全賦課履歴データ.toList().get(0);
        ChoshuYuyoJoho 徴収猶予の情報 = KaigoFukaChoshuYuyo.createInstance()
                .getJokyo(賦課基本.get調定年度(), 賦課基本.get賦課年度(), 賦課基本.get通知書番号());
        return 徴収猶予の情報;
    }

    /**
     * 「訂正する」ボタン押下、画面の状態制御です。
     */
    public void onClick_訂正の状態() {
        ChoshuYuyoMainDiv 状況情報パネル = div.getChoshuYuyoMain();
        状況情報パネル.getBtnTeisei().setDisplayNone(true);
        状況情報パネル.getBtnTorikeshi().setDisplayNone(true);
        div.getChoshuYuyoMain().getTorikeshiJoho().setDisplayNone(true);
        ShinseiJohoDiv 申請情報パネル = div.getChoshuYuyoMain().getShinseiJoho();
        申請情報パネル.getTxtChoteiNendo().setReadOnly(true);
        申請情報パネル.getTxtFukaNendo().setReadOnly(true);
        申請情報パネル.getTxtShinseiYMD().setReadOnly(false);
        申請情報パネル.getBtnYuyoShurui().setDisabled(false);
        申請情報パネル.getTxtShinseiRiyu().setReadOnly(false);
        KetteiJohoDiv 決定情報パネル = div.getChoshuYuyoMain().getKetteiJoho();
        決定情報パネル.getTxtKetteiYMD().setReadOnly(false);
        決定情報パネル.getRadKetteiKubun().setDisabled(false);
        決定情報パネル.getTxtKetteiRiyu().setReadOnly(false);
        // TODO QA1195 labelはTextBoxDateに変換は必要ですが？ 状態定義sheetの281－294行の状態は入力可の設定。
//        FuchoTablePanelDiv 普通徴収猶予情報パネル = div.getChoshuYuyoMain().getFuchoTablePanel();
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(訂正をやめるボタン, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
    }

    /**
     * 「取消する」ボタン押下、画面の状態制御です。
     */
    public void onClick_取消の状態() {
        ChoshuYuyoMainDiv 状況情報パネル = div.getChoshuYuyoMain();
        RString 状況 = 状況情報パネル.getTxtShinseiJokyo().getValue();
        状況情報パネル.getBtnTeisei().setDisplayNone(true);
        状況情報パネル.getBtnTorikeshi().setDisplayNone(true);
        TorikeshiJohoDiv 取消情報パネル = div.getChoshuYuyoMain().getTorikeshiJoho();
        取消情報パネル.setDisplayNone(false);
        取消情報パネル.getTxtTorikeshiYMD().setValue(null);
        取消情報パネル.getTxtTorikeshiShurui().setValue(null);
        取消情報パネル.getTxtTorikeshiRiyu().setValue(null);
        ShinseiJohoDiv 申請情報パネル = div.getChoshuYuyoMain().getShinseiJoho();
        申請情報パネル.getTxtChoteiNendo().setReadOnly(true);
        申請情報パネル.getTxtFukaNendo().setReadOnly(true);
        申請情報パネル.getTxtShinseiYMD().setReadOnly(true);
        申請情報パネル.getBtnYuyoShurui().setDisabled(true);
        申請情報パネル.getTxtShinseiRiyu().setReadOnly(true);
        KetteiJohoDiv 決定情報パネル = div.getChoshuYuyoMain().getKetteiJoho();
        決定情報パネル.getTxtKetteiYMD().setReadOnly(false);
        決定情報パネル.getRadKetteiKubun().setDisabled(false);
        決定情報パネル.getTxtKetteiRiyu().setReadOnly(false);
        if (状況_申請中.equals(状況)) {
            決定情報パネル.setDisplayNone(true);
        } else if (状況_決定済.equals(状況)) {
            決定情報パネル.setDisplayNone(false);
            決定情報パネル.getTxtKetteiYMD().setReadOnly(true);
            決定情報パネル.getRadKetteiKubun().setDisabled(true);
            決定情報パネル.getTxtKetteiRiyu().setReadOnly(true);
        }
        // TODO QA1195 labelはTextBoxDateに変換は必要ですが？ 状態定義sheetの281－294行の状態は入力可の設定。
//        FuchoTablePanelDiv 普通徴収猶予情報パネル = div.getChoshuYuyoMain().getFuchoTablePanel();
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(取消をやめるボタン, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
    }

    /**
     * 取消種類ボタンの事件です。
     *
     * @return 取消種類code Code
     */
    public Code onOkClose取消種類() {
        RString 取消種類code = DataPassingConverter.deserialize(div.getGemmenTorikeshiShuruiCode(), RString.class);
        RString 取消理由 = DataPassingConverter.deserialize(div.getGemmenTorikeshiShuruiHyojiMongon(), RString.class);
        div.getChoshuYuyoMain().getTorikeshiJoho().getTxtTorikeshiShurui().setValue(取消理由);
        return new Code(取消種類code);
    }

    /**
     * 猶予種類ボタンの事件です。
     *
     * @return 猶予種類code Code
     */
    public Code onOkClose猶予種類() {
        // TODO QA1187 猶予種類を取得なし。
        RString 猶予種類code = DataPassingConverter.deserialize(div.getGemmenShuruiCode(), RString.class);
        RString 猶予事由 = DataPassingConverter.deserialize(div.getGemmenShuruiHyojiMongon(), RString.class);
        div.getChoshuYuyoMain().getShinseiJoho().getTxtYuyoShurui().setValue(猶予事由);
        return new Code(猶予種類code);
    }

    /**
     * 更新確認メッセージを出力する。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     * @return 更新確認メッセージの判断
     */
    public RString メッセージ判断(ChoshuYuyoJoho 徴収猶予の情報) {
        RString 状況 = div.getChoshuYuyoMain().getTxtShinseiJokyo().getValue();
        boolean 申請_入力 = is申請情報入力(徴収猶予の情報);
        boolean 決定_入力 = is決定情報入力(徴収猶予の情報);
        boolean 取消_入力 = is取消情報入力();
        if (状況_新規.equals(状況)) {
            if (申請_入力 && !決定_入力) {
                return 入力状況_新規申請;
            } else if (決定_入力) {
                return 入力状況_新規決定;
            }
        } else if (状況_申請中.equals(状況)) {
            if (取消_入力) {
                return 入力状況_申請中取消;
            }
            if (申請_入力 && !決定_入力) {
                return 入力状況_申請中申請;
            } else if (決定_入力) {
                return 入力状況_申請中決定;
            }
        } else if (状況_決定済.equals(状況)) {
            if (取消_入力) {
                return 入力状況_決定済取消;
            }
            if (申請_入力 || 決定_入力) {
                return 入力状況_決定済訂正;
            }
        }
        return 空;
    }

    private boolean is申請情報入力(ChoshuYuyoJoho 徴収猶予の情報) {
        List<ChoshuYuyo> 介護賦課徴収猶予List = 徴収猶予の情報.getChoshuYuyoList();
        ShinseiJohoDiv 申請情報パネル = div.getChoshuYuyoMain().getShinseiJoho();
        if (介護賦課徴収猶予List != null && !介護賦課徴収猶予List.isEmpty()) {
            ChoshuYuyo 介護賦課徴収猶予 = 介護賦課徴収猶予List.get(0);
            boolean flag1 = checkDate(介護賦課徴収猶予.get徴収猶予申請年月日(), 申請情報パネル.getTxtShinseiYMD().getValue());
            boolean flag2 = checkRString(CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, 保険料徴収猶予種類_コード種別,
                    介護賦課徴収猶予.get徴収猶予種類コード(), FlexibleDate.getNowDate()), 申請情報パネル.getTxtYuyoShurui().getValue());
            boolean flag3 = checkRString(介護賦課徴収猶予.get申請事由(), 申請情報パネル.getTxtShinseiRiyu().getValue());
            return flag1 || flag2 || flag3;
        } else {
            RDate 申請日 = 申請情報パネル.getTxtShinseiYMD().getValue();
            boolean flag1 = 申請日 != null;
            RString 取消種類 = 申請情報パネル.getTxtYuyoShurui().getValue();
            boolean flag2 = !(取消種類 == null || 取消種類.isEmpty());
            RString 申請事由 = 申請情報パネル.getTxtShinseiRiyu().getValue();
            boolean flag3 = !(申請事由 == null || 申請事由.isEmpty());
            return flag1 || flag2 || flag3;
        }
    }

    private boolean is決定情報入力(ChoshuYuyoJoho 徴収猶予の情報) {
        List<ChoshuYuyo> 介護賦課徴収猶予List = 徴収猶予の情報.getChoshuYuyoList();
        KetteiJohoDiv 決定情報パネル = div.getChoshuYuyoMain().getKetteiJoho();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (介護賦課徴収猶予List != null && !介護賦課徴収猶予List.isEmpty()) {
            ChoshuYuyo 介護賦課徴収猶予 = 介護賦課徴収猶予List.get(0);
            flag1 = checkDate(介護賦課徴収猶予.get徴収猶予決定年月日(), 決定情報パネル.getTxtKetteiYMD().getValue());
            RString 決定区分 = 決定情報パネル.getRadKetteiKubun().getSelectedValue();
            if (承認.equals(決定区分)) {
                flag2 = checkRString(定値_イチ, 介護賦課徴収猶予.get徴収猶予状態区分());
            } else {
                flag2 = checkRString(定値_二, 介護賦課徴収猶予.get徴収猶予状態区分());
            }
            flag3 = checkRString(介護賦課徴収猶予.get申請事由(), 決定情報パネル.getTxtKetteiRiyu().getValue());
        } else {
            RDate 決定日 = 決定情報パネル.getTxtKetteiYMD().getValue();
            flag1 = 決定日 != null;
            flag2 = !(承認.equals(決定情報パネル.getRadKetteiKubun().getSelectedValue()));
            RString 申請事由 = 決定情報パネル.getTxtKetteiRiyu().getValue();
            flag3 = !(申請事由 == null || 申請事由.isEmpty());
        }
        return flag1 && flag2 && flag3;
    }

    private boolean is取消情報入力() {
        TorikeshiJohoDiv 取消情報パネル = div.getChoshuYuyoMain().getTorikeshiJoho();
        boolean flag1 = 取消情報パネル.getTxtTorikeshiYMD().getValue() != null;
        RString 取消種類 = 取消情報パネル.getTxtTorikeshiShurui().getValue();
        boolean flag2 = !(取消種類 == null || 取消種類.isEmpty());
        RString 取消理由 = 取消情報パネル.getTxtTorikeshiRiyu().getValue();
        boolean flag3 = !(取消理由 == null || 取消理由.isEmpty());
        return flag1 || flag2 || flag3;
    }

    private List<KeyValueDataSource> get決定区分() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        KeyValueDataSource dataSource1 = new KeyValueDataSource(定値_ゼロ, 承認);
        KeyValueDataSource dataSource2 = new KeyValueDataSource(定値_イチ, 不承認);
        dataSources.add(dataSource1);
        dataSources.add(dataSource2);
        return dataSources;
    }

    /**
     * 画面情報paramを取得する。
     *
     * @param 徴収猶予の情報 ChoshuYuyoJoho
     * @param 猶予種類コード Code
     * @param 取消種類コード Code
     * @return 画面情報param KaigoFukaChoshuYuyoParam
     */
    public KaigoFukaChoshuYuyoParam get画面情報param(ChoshuYuyoJoho 徴収猶予の情報, Code 猶予種類コード, Code 取消種類コード) {
        ShinseiJohoDiv 申請情報パネル = div.getChoshuYuyoMain().getShinseiJoho();
        KetteiJohoDiv 決定情報パネル = div.getChoshuYuyoMain().getKetteiJoho();
        TorikeshiJohoDiv 取消情報パネル = div.getChoshuYuyoMain().getTorikeshiJoho();
        KaigoFukaChoshuYuyoParam param = new KaigoFukaChoshuYuyoParam();
        param.set状況(div.getChoshuYuyoMain().getTxtShinseiJokyo().getValue());
        RString 決定区分 = 決定情報パネル.getRadKetteiKubun().getSelectedValue();
        param.set決定区分(定値_ゼロ.equals(決定区分));
        param.set調定年度(徴収猶予の情報.get調定年度());
        param.set賦課年度(徴収猶予の情報.get賦課年度());
        param.set通知書番号(徴収猶予の情報.get通知書番号());
        param.set申請日(申請情報パネル.getTxtShinseiYMD().getValue() != null
                ? new FlexibleDate(申請情報パネル.getTxtShinseiYMD().getValue().toString()) : null);
        param.set決定日(決定情報パネル.getTxtKetteiYMD().getValue() != null
                ? new FlexibleDate(決定情報パネル.getTxtKetteiYMD().getValue().toString()) : null);
        param.set取消日(取消情報パネル.getTxtTorikeshiYMD().getValue() != null
                ? new FlexibleDate(取消情報パネル.getTxtTorikeshiYMD().getValue().toString()) : null);
        param.set申請事由(申請情報パネル.getTxtShinseiRiyu().getValue());
        param.set徴収猶予種類コード(猶予種類コード);
        param.set徴収猶予事由(申請情報パネル.getTxtYuyoShurui().getValue());
        param.set徴収猶予取消種類コード(取消種類コード);
        param.set徴収猶予取消事由(取消情報パネル.getTxtTorikeshiShurui().getValue());
        List<KaigoKibetsuChoshuYuyoParam> 介護期別徴収猶予データ = get介護期別徴収猶予データ();
        param.set介護期別徴収猶予データ(介護期別徴収猶予データ);
        return param;
    }

    private List<KaigoKibetsuChoshuYuyoParam> get介護期別徴収猶予データ() {
        List<KaigoKibetsuChoshuYuyoParam> 介護期別徴収猶予データ = new ArrayList<>();
        RString 期_4月 = 普徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_5月 = 普徴期月リスト.get月の期(Tsuki._5月).get期();
        RString 期_6月 = 普徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_7月 = 普徴期月リスト.get月の期(Tsuki._7月).get期();
        RString 期_8月 = 普徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_9月 = 普徴期月リスト.get月の期(Tsuki._9月).get期();
        RString 期_10月 = 普徴期月リスト.get月の期(Tsuki._10月).get期();
        if (期_4月 != null && !期_4月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_4月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_5月 != null && !期_5月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_5月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_6月 != null && !期_6月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_6月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_7月 != null && !期_7月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_7月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_8月 != null && !期_8月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_8月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_9月 != null && !期_9月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_9月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_10月 != null && !期_10月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_10月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        介護期別徴収猶予データ = get介護期別徴収猶予データ(介護期別徴収猶予データ);
        return 介護期別徴収猶予データ;
    }

    private List<KaigoKibetsuChoshuYuyoParam> get介護期別徴収猶予データ(List<KaigoKibetsuChoshuYuyoParam> 介護期別徴収猶予データ) {
        RString 期_11月 = 普徴期月リスト.get月の期(Tsuki._11月).get期();
        RString 期_12月 = 普徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_1月 = 普徴期月リスト.get月の期(Tsuki._1月).get期();
        RString 期_2月 = 普徴期月リスト.get月の期(Tsuki._2月).get期();
        RString 期_3月 = 普徴期月リスト.get月の期(Tsuki._3月).get期();
        RString 期_翌年4月 = 普徴期月リスト.get月の期(Tsuki.翌年度4月).get期();
        RString 期_翌年5月 = 普徴期月リスト.get月の期(Tsuki.翌年度5月).get期();
        if (期_11月 != null && !期_11月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_11月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_12月 != null && !期_12月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_12月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_1月 != null && !期_1月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_1月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_2月 != null && !期_2月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_2月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_3月 != null && !期_3月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_3月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_翌年4月 != null && !期_翌年4月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_翌年4月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        if (期_翌年5月 != null && !期_翌年5月.isEmpty()) {
            KaigoKibetsuChoshuYuyoParam 介護期別徴収猶予 = new KaigoKibetsuChoshuYuyoParam();
            介護期別徴収猶予.set期(Integer.valueOf(期_翌年5月.toString()));
            // TODO QA1195 labelはTextBoxDateに変換は必要ですが？
            介護期別徴収猶予.set徴収猶予開始日(null);
            介護期別徴収猶予.set徴収猶予終了日(null);
            介護期別徴収猶予データ.add(介護期別徴収猶予);
        }
        return 介護期別徴収猶予データ;
    }

    /**
     * コンストラクタです
     *
     * @param div ChoshuYuyoJuminKihonDiv
     */
    public ChoshuYuyoJuminKihonHandler(ChoshuYuyoJuminKihonDiv div) {
        this.div = div;
    }

    private boolean checkDate(FlexibleDate fDate, RDate rDate) {
        if (fDate == null || fDate.isEmpty()) {
            return !(rDate == null);
        } else {
            return !(new RDate(fDate.toString()).equals(rDate));
        }
    }

    private boolean checkRString(RString str1, RString str2) {
        if (str1 == null || str1.isEmpty()) {
            return !(str2 == null || str2.isEmpty());
        } else {
            return !str1.equals(str2);
        }
    }

}
