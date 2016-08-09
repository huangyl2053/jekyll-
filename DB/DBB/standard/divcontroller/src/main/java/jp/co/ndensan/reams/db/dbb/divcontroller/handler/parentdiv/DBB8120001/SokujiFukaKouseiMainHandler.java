/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8120001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.shuno.ShunoManager;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.ChoteiJiyuParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.FukaJohoList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoFuka;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.KibetsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKousei;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHosokuMonth;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.FukakonkyoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.FukakonkyoMaeDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiFukaKouseiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujikouseiKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.dgFuchoKanendo_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.tblSanteinokisoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.tblSanteinokisoMaeDiv;
import jp.co.ndensan.reams.db.dbb.service.core.basic.GemmenManager;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.choteijiyu.ChoteiJiyuHantei;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HonsanteiIkoHantei;
import jp.co.ndensan.reams.db.dbb.service.core.tokucho.TokuchoIraiJohoSakuseiJokyo;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenTorikeshiShurui;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * {@link SokujiFukaKouseiMainHandler}のHandlerクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiMainHandler {

    private final SokujiFukaKouseiMainDiv div;
    private static final long LONG_1 = 1;
    private static final int NUM_0 = 0;
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
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final Decimal DECIMAL_12 = new Decimal(12);
    private static final RString 期 = new RString("期");
    private static final RString 月 = new RString("月");
    private static final RString 左括弧 = new RString("（");
    private static final RString 右括弧 = new RString("）");
    private static final RString 読点 = new RString(",");
    private static final RString 一月一日 = new RString("0101");
    private static final RString 三月 = new RString("03");
    private static final RString カラ = new RString("～");

    /**
     * コンストラクタです。
     *
     * @param div SokujiFukaKouseiMain
     */
    public SokujiFukaKouseiMainHandler(SokujiFukaKouseiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時の動作です。
     *
     * @param is特殊処理 is特殊処理
     * @param 賦課年度 賦課年度
     * @param 更正前後賦課のリスト 更正前後賦課のリスト
     * @param 通知書番号 通知書番号
     * @param 更正前後徴収方法 更正前後徴収方法
     */
    public void initializeヘッダエリア(
            boolean is特殊処理,
            FlexibleYear 賦課年度,
            List<KoseiZengoFuka> 更正前後賦課のリスト,
            TsuchishoNo 通知書番号,
            KoseiZengoChoshuHoho 更正前後徴収方法) {
        RDate システム日付 = RDate.getNowDate();
        init更正年月エリア(is特殊処理, 賦課年度, システム日付, 更正前後賦課のリスト, 通知書番号, 更正前後徴収方法);
    }

    /**
     * 更正前後データ初期化設定の動作です。
     *
     * @param is特殊処理 is特殊処理
     * @param 更正前賦課リスト 更正前賦課リスト
     * @param 更正後賦課リスト 更正後賦課リスト
     * @param 更正前後徴収方法 更正前後徴収方法
     * @param is本算定処理済フラグ is本算定処理済フラグ
     */
    public void initialize更正前後データ(
            boolean is特殊処理,
            NendobunFukaList 更正前賦課リスト,
            NendobunFukaList 更正後賦課リスト,
            KoseiZengoChoshuHoho 更正前後徴収方法,
            boolean is本算定処理済フラグ) {
        HokenryoDankaiSettings 保険料段階取得共通クラス = HokenryoDankaiSettings.createInstance();
        HokenryoDankaiList 保険料段階List = 保険料段階取得共通クラス.getCurrent保険料段階List();
        set賦課根拠期割額(更正前賦課リスト, 更正後賦課リスト, 保険料段階List);
        set減免額(更正後賦課リスト);
        set現年度の特別徴収情報(更正前賦課リスト, 更正後賦課リスト);
        set現年度の普通徴収情報(更正前賦課リスト, 更正後賦課リスト);
        if (!is特殊処理) {
            set現年度の特別徴収情報の入力制御(更正前後徴収方法, 更正後賦課リスト, is本算定処理済フラグ);
            set現年度の普通徴収情報の入力制御(更正後賦課リスト);
        }
        set過年度の徴収情報(更正前賦課リスト, 更正後賦課リスト);
        set保険料年額と事由タブエリア(更正前賦課リスト, 更正後賦課リスト, 保険料段階List);
    }

    /**
     * is期別修正による特徴停止の確認メッセージを表示です。
     *
     * @param is特殊処理 is特殊処理
     * @return is確認メッセージを表示
     */
    public boolean is期別修正による特徴停止(boolean is特殊処理) {
        if (is特殊処理) {
            return Boolean.FALSE;
        }
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 納付額_２期 = tablePanel.getTxtTokuchoKoseiGo06().getValue();
        Decimal 納付額_３期 = tablePanel.getTxtTokuchoKoseiGo08().getValue();
        return (!ZERO.equals(div.getTokuchoNofugakuValue06())
                && 納付額_２期.compareTo(Decimal.ZERO) == 0)
                || (!ZERO.equals(div.getTokuchoNofugakuValue08())
                && 納付額_３期.compareTo(Decimal.ZERO) == 0);
    }

    /**
     * 最新賦課の情報に画面入力項目を反映する。
     *
     * @param 更正後 更正後
     * @return boolean is差異がある
     */
    public boolean set画面入力項目を反映(NendobunFukaList 更正後) {
        Boolean is差異がある = Boolean.FALSE;
        FukaJoho 最新賦課の情報 = 更正後.get最新賦課の情報();
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        is差異がある = set期別金額(最新賦課の情報, NUM_1, ChoshuHohoKibetsu.特別徴収.getコード(), tablePanel.getTxtTokuchoKoseiGo04(),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_2, ChoshuHohoKibetsu.特別徴収.getコード(), tablePanel.getTxtTokuchoKoseiGo06(),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_3, ChoshuHohoKibetsu.特別徴収.getコード(), tablePanel.getTxtTokuchoKoseiGo08(),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_4, ChoshuHohoKibetsu.特別徴収.getコード(), tablePanel.getTxtTokuchoKoseiGo10(),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_5, ChoshuHohoKibetsu.特別徴収.getコード(), tablePanel.getTxtTokuchoKoseiGo12(),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_6, ChoshuHohoKibetsu.特別徴収.getコード(), tablePanel.getTxtTokuchoKoseiGo02(),
                null, is差異がある);

        is差異がある = set期別金額(最新賦課の情報, NUM_1, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo04(),
                tablePanel.getTxtFuchoNokigen01(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_2, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo05(),
                tablePanel.getTxtFuchoNokigen02(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_3, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo06(),
                tablePanel.getTxtFuchoNokigen03(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_4, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo07(),
                tablePanel.getTxtFuchoNokigen04(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_5, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo08(),
                tablePanel.getTxtFuchoNokigen05(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_6, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo09(),
                tablePanel.getTxtFuchoNokigen06(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_7, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo10(),
                tablePanel.getTxtFuchoNokigen07(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_8, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo11(),
                tablePanel.getTxtFuchoNokigen08(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_9, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo12(),
                tablePanel.getTxtFuchoNokigen09(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_10, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo01(),
                tablePanel.getTxtFuchoNokigen10(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_11, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo02(),
                tablePanel.getTxtFuchoNokigen11(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_12, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGo03(),
                tablePanel.getTxtFuchoNokigen12(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_13, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGoYoku04(),
                tablePanel.getTxtFuchoNokigenYoku04(), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_14, ChoshuHohoKibetsu.普通徴収.getコード(), tablePanel.getTxtFuchoKoseiGoYoku05(),
                tablePanel.getTxtFuchoNokigenYoku05(), is差異がある);
        boolean is過年度を反映 = Boolean.FALSE;
        if (更正後.get過年度5() != null) {
            is過年度を反映 = Boolean.TRUE;
            更正後.set過年度5(最新賦課の情報);
        }
        if (!is過年度を反映 && 更正後.get過年度4() != null) {
            is過年度を反映 = Boolean.TRUE;
            更正後.set過年度4(最新賦課の情報);
        }
        if (!is過年度を反映 && 更正後.get過年度3() != null) {
            is過年度を反映 = Boolean.TRUE;
            更正後.set過年度3(最新賦課の情報);
        }
        if (!is過年度を反映 && 更正後.get過年度2() != null) {
            is過年度を反映 = Boolean.TRUE;
            更正後.set過年度2(最新賦課の情報);
        }
        if (!is過年度を反映 && 更正後.get過年度1() != null) {
            is過年度を反映 = Boolean.TRUE;
            更正後.set過年度1(最新賦課の情報);
        }
        if (!is過年度を反映) {
            更正後.set現年度(最新賦課の情報);
        }
        return is差異がある;
    }

    /**
     * 画面コントロールの制御入力不可にする。
     */
    public void set画面項目入力不可() {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getTxtTokuchoKoseiGo04().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo06().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo08().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo10().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo12().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo02().setReadOnly(true);

        tablePanel.getTxtFuchoKoseiGo04().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo05().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo06().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo07().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo08().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo09().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo10().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo11().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo12().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo01().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo02().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo03().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGoYoku04().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGoYoku05().setReadOnly(true);

        tablePanel.getTxtFuchoNokigen04().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen05().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen06().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen07().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen08().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen09().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen10().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen11().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen12().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen01().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen02().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen03().setReadOnly(true);
        tablePanel.getTxtFuchoNokigenYoku04().setReadOnly(true);
        tablePanel.getTxtFuchoNokigenYoku05().setReadOnly(true);

    }

    /**
     * 保存処理にする。
     *
     * @param is特殊処理 is特殊処理
     * @param 更正前 更正前
     * @param 更正後 更正後
     * @param 更正前後徴収方法 更正前後徴収方法
     * @return SokujiFukaKousei 即時賦課更正entity
     */
    public SokujiFukaKousei set保存処理(boolean is特殊処理,
            NendobunFukaList 更正前,
            NendobunFukaList 更正後,
            KoseiZengoChoshuHoho 更正前後徴収方法) {
        set画面入力項目を反映(更正後);
        SokujiFukaKousei sokujiFukaKousei = new SokujiFukaKousei();
        if (is特殊処理) {
            FukaJoho fukaJoho = 更正後.get現年度().createBuilderForEdit().set職権区分(ShokkenKubun.該当.getコード()).build();
            ChoteiJiyuHantei choteiJiyuHantei = new ChoteiJiyuHantei();
            ChoteiJiyuParameter parameter = new ChoteiJiyuParameter();
            parameter.set現年度(更正前.get現年度());
            List<FukaJohoList> fukaJohoList = new ArrayList<>();
            FukaJohoList 更正後賦課の情報リスト = new FukaJohoList();
            更正後賦課の情報リスト.set現年度(fukaJoho);
            fukaJohoList.add(更正後賦課の情報リスト);
            parameter.set更正後賦課リスト(fukaJohoList);
            parameter.set更正前徴収方法(更正前後徴収方法.get更正前());
            parameter.set更正後徴収方法(更正前後徴収方法.get更正後());
            List<FukaJohoList> 調定事由リスト = choteiJiyuHantei.set調定事由(parameter);
            for (FukaJohoList 調定事由 : 調定事由リスト) {
                if (調定事由.get現年度().hasChanged()) {
                    更正後.set現年度(調定事由.get現年度());
                }
            }
        } else {
            boolean is調定事由を反映 = Boolean.FALSE;
            if (RString.isNullOrEmpty(更正後.get現年度().get調定事由1())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由1(ChoteiJiyuCode.期別修正による更正.getコード());
            }
            if (!is調定事由を反映 && RString.isNullOrEmpty(更正後.get現年度().get調定事由2())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由2(ChoteiJiyuCode.期別修正による更正.getコード());
            }
            if (!is調定事由を反映 && RString.isNullOrEmpty(更正後.get現年度().get調定事由3())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由3(ChoteiJiyuCode.期別修正による更正.getコード());
            }
            if (!is調定事由を反映 && RString.isNullOrEmpty(更正後.get現年度().get調定事由4())) {
                is調定事由を反映 = Boolean.TRUE;
                更正後.get現年度().createBuilderForEdit().set調定事由4(ChoteiJiyuCode.期別修正による更正.getコード());
            }
        }
        List<FukaJoho> 更新対象 = get更新対象(更正前, 更正後);
        sokujiFukaKousei.set賦課の情報リスト(更新対象);
        if (更正前後徴収方法.isHasChanged()) {
            sokujiFukaKousei.set更正後徴収方法(更正前後徴収方法.get更正後());
        }
        List<Gemmen> 減免の情報リスト = new ArrayList<>();
        GemmenManager gemmenManager = new GemmenManager();
        for (FukaJoho fukaJoho : 更新対象) {
            if (fukaJoho.get減免額().compareTo(Decimal.ONE) > 0) {
                Gemmen 減免情報 = gemmenManager.get介護賦課減免(fukaJoho.get調定年度(), fukaJoho.get賦課年度(), fukaJoho.get通知書番号());
                if (減免情報 == null) {
                    continue;
                }
                Gemmen 更新後の減免情報 = new Gemmen(減免情報.get調定年度(), 減免情報.get賦課年度(),
                        減免情報.get通知書番号(), 減免情報.get履歴番号().add(Decimal.ONE)).createBuilderForEdit().
                        set減免申請日(減免情報.get減免申請日()).
                        set減免決定日(減免情報.get減免決定日()).
                        set減免取消日(減免情報.get減免取消日()).
                        set減免状態区分(減免情報.get減免状態区分()).
                        set減免作成区分(減免情報.get減免作成区分()).
                        set申請事由(減免情報.get申請事由()).
                        set減免種類コード(減免情報.get減免種類コード()).
                        set減免事由(減免情報.get減免事由()).
                        set減免取消種類(new HokenryoGemmenTorikeshiShurui(減免情報.get減免取消種類コード())).
                        set減免取消事由(減免情報.get減免取消事由()).
                        set申請減免額(減免情報.get申請減免額()).
                        set決定減免額(fukaJoho.get減免額()).
                        set取消減免額(減免情報.get取消減免額()).build();
                減免の情報リスト.add(更新後の減免情報);
            }
        }
        sokujiFukaKousei.set減免の情報リスト(減免の情報リスト);
        return sokujiFukaKousei;
    }

    private List<FukaJoho> get更新対象(NendobunFukaList 更正前, NendobunFukaList 更正後) {
        List<FukaJoho> 更新対象 = new ArrayList<>();
        if (is内容に異なる箇所がある(更正前.get現年度(), 更正後.get現年度())) {
            更新対象.add(更正後.get現年度());
        }
        if (is内容に異なる箇所がある(更正前.get過年度1(), 更正後.get過年度1())) {
            更新対象.add(更正後.get過年度1());
        }
        if (is内容に異なる箇所がある(更正前.get過年度2(), 更正後.get過年度2())) {
            更新対象.add(更正後.get過年度2());
        }
        if (is内容に異なる箇所がある(更正前.get過年度3(), 更正後.get過年度3())) {
            更新対象.add(更正後.get過年度3());
        }
        if (is内容に異なる箇所がある(更正前.get過年度4(), 更正後.get過年度4())) {
            更新対象.add(更正後.get過年度4());
        }
        if (is内容に異なる箇所がある(更正前.get過年度5(), 更正後.get過年度5())) {
            更新対象.add(更正後.get過年度5());
        }
        return 更新対象;
    }

    private boolean is内容に異なる箇所がある(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        if (更正前賦課 == null || 更正後賦課 == null) {
            return Boolean.FALSE;
        }
        return is介護賦課異なる1(更正前賦課, 更正後賦課)
                || is介護賦課異なる2(更正前賦課, 更正後賦課)
                || is介護賦課異なる3(更正前賦課, 更正後賦課)
                || is介護期別異なる(更正前賦課, 更正後賦課);
    }

    private boolean is介護期別異なる(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        for (Kibetsu kibetsu : 更正前賦課.getKibetsuList()) {
            ChoteiKyotsuIdentifier choteiKyotsuIdentifier = new ChoteiKyotsuIdentifier(kibetsu.get調定ID().longValue());
            ChoteiKyotsu 更正前介護期別 = kibetsu.getChoteiKyotsu(choteiKyotsuIdentifier);
            KibetsuIdentifier kibetsuIdentifier = new KibetsuIdentifier(kibetsu.get調定年度(), kibetsu.get賦課年度(),
                    kibetsu.get通知書番号(), kibetsu.get履歴番号(), kibetsu.get徴収方法(), kibetsu.get期());
            ChoteiKyotsu 更正後介護期別 = 更正後賦課.getKibetsu(kibetsuIdentifier).getChoteiKyotsu(choteiKyotsuIdentifier);
            if (is調定共通異なる(更正前介護期別, 更正後介護期別)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private boolean is調定共通異なる(ChoteiKyotsu 更正前介護期別, ChoteiKyotsu 更正後介護期別) {
        return is異なる(更正前介護期別.get収納ID().intValue(), 更正後介護期別.get収納ID().intValue())
                || is異なる(更正前介護期別.get会計年度().toDateString(), 更正後介護期別.get会計年度().toDateString())
                || is異なる(更正前介護期別.get処理年度().toDateString(), 更正後介護期別.get処理年度().toDateString())
                || is異なる(更正前介護期別.get処理番号(), 更正後介護期別.get処理番号())
                || is異なる(更正前介護期別.get更正回数(), 更正後介護期別.get更正回数())
                || is異なる(更正前介護期別.get調定事由コード(), 更正後介護期別.get調定事由コード())
                || is異なる(更正前介護期別.get調定年月日().toDateString(), 更正後介護期別.get調定年月日().toDateString())
                || is異なる(更正前介護期別.get調定額(), 更正後介護期別.get調定額())
                || is異なる(更正前介護期別.get消費税額(), 更正後介護期別.get消費税額())
                || is異なる(更正前介護期別.get納期限().toDateString(), 更正後介護期別.get納期限().toDateString())
                || is異なる(更正前介護期別.get法定納期限等().toDateString(), 更正後介護期別.get法定納期限等().toDateString())
                || (更正前介護期別.is賦課処理状況() != 更正後介護期別.is賦課処理状況());
    }

    private boolean is介護賦課異なる1(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        return is異なる(更正前賦課.get被保険者番号().getColumnValue(), 更正後賦課.get被保険者番号().getColumnValue())
                || is異なる(更正前賦課.get識別コード().getColumnValue(), 更正後賦課.get識別コード().getColumnValue())
                || is異なる(更正前賦課.get世帯コード().getColumnValue(), 更正後賦課.get世帯コード().getColumnValue())
                || is異なる(更正前賦課.get世帯員数(), 更正後賦課.get世帯員数())
                || is異なる(更正前賦課.get資格取得日(), 更正後賦課.get資格取得日())
                || is異なる(更正前賦課.get資格取得事由(), 更正後賦課.get資格取得事由())
                || is異なる(更正前賦課.get資格喪失日(), 更正後賦課.get資格喪失日())
                || is異なる(更正前賦課.get資格喪失事由(), 更正後賦課.get資格喪失事由())
                || is異なる(更正前賦課.get生活保護扶助種類(), 更正後賦課.get生活保護扶助種類())
                || is異なる(更正前賦課.get生保開始日(), 更正後賦課.get生保開始日())
                || is異なる(更正前賦課.get生保廃止日(), 更正後賦課.get生保廃止日())
                || is異なる(更正前賦課.get老年開始日(), 更正後賦課.get老年開始日())
                || is異なる(更正前賦課.get老年廃止日(), 更正後賦課.get老年廃止日())
                || is異なる(更正前賦課.get賦課期日(), 更正後賦課.get賦課期日())
                || is異なる(更正前賦課.get課税区分(), 更正後賦課.get課税区分())
                || is異なる(更正前賦課.get世帯課税区分(), 更正後賦課.get世帯課税区分())
                || is異なる(更正前賦課.get合計所得金額(), 更正後賦課.get合計所得金額())
                || is異なる(更正前賦課.get公的年金収入額(), 更正後賦課.get公的年金収入額());
    }

    private boolean is介護賦課異なる2(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        return is異なる(更正前賦課.get保険料段階(), 更正後賦課.get保険料段階())
                || is異なる(更正前賦課.get保険料算定段階1(), 更正後賦課.get保険料算定段階1())
                || is異なる(更正前賦課.get算定年額保険料1(), 更正後賦課.get算定年額保険料1())
                || is異なる(更正前賦課.get月割開始年月1(), 更正後賦課.get月割開始年月1())
                || is異なる(更正前賦課.get月割終了年月1(), 更正後賦課.get月割終了年月1())
                || is異なる(更正前賦課.get保険料算定段階2(), 更正後賦課.get保険料算定段階2())
                || is異なる(更正前賦課.get算定年額保険料2(), 更正後賦課.get算定年額保険料2())
                || is異なる(更正前賦課.get月割開始年月2(), 更正後賦課.get月割開始年月2())
                || is異なる(更正前賦課.get月割終了年月2(), 更正後賦課.get月割終了年月2())
                || is異なる(更正前賦課.get調定日時(), 更正後賦課.get調定日時())
                || is異なる(更正前賦課.get調定事由1(), 更正後賦課.get調定事由1())
                || is異なる(更正前賦課.get調定事由2(), 更正後賦課.get調定事由2())
                || is異なる(更正前賦課.get調定事由3(), 更正後賦課.get調定事由3())
                || is異なる(更正前賦課.get調定事由4(), 更正後賦課.get調定事由4())
                || is異なる(更正前賦課.get更正月(), 更正後賦課.get更正月())
                || is異なる(更正前賦課.get減免前介護保険料_年額(), 更正後賦課.get減免前介護保険料_年額())
                || is異なる(更正前賦課.get減免額(), 更正後賦課.get減免額())
                || is異なる(更正前賦課.get確定介護保険料_年額(), 更正後賦課.get確定介護保険料_年額());
    }

    private boolean is介護賦課異なる3(FukaJoho 更正前賦課, FukaJoho 更正後賦課) {
        return is異なる(更正前賦課.get保険料段階(), 更正後賦課.get保険料段階())
                || is異なる(更正前賦課.get徴収方法履歴番号(), 更正後賦課.get徴収方法履歴番号())
                || is異なる(更正前賦課.get異動基準日時(), 更正後賦課.get異動基準日時())
                || is異なる(更正前賦課.get口座区分(), 更正後賦課.get口座区分())
                || is異なる(更正前賦課.get境界層区分(), 更正後賦課.get境界層区分())
                || is異なる(更正前賦課.get職権区分(), 更正後賦課.get職権区分())
                || is異なる(更正前賦課.get賦課市町村コード().code市町村RString(), 更正後賦課.get賦課市町村コード().code市町村RString())
                || is異なる(更正前賦課.get特徴歳出還付額(), 更正後賦課.get特徴歳出還付額())
                || is異なる(更正前賦課.get普徴歳出還付額(), 更正後賦課.get普徴歳出還付額());
    }

    private boolean is異なる(RString rstr1, RString rstr2) {
        if (RString.isNullOrEmpty(rstr1) && RString.isNullOrEmpty(rstr2)) {
            return Boolean.FALSE;
        }
        if (!RString.isNullOrEmpty(rstr1) && rstr1.equals(rstr2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(int num1, int num2) {
        return num1 != num2;
    }

    private boolean is異なる(long num1, long num2) {
        return num1 != num2;
    }

    private boolean is異なる(FlexibleDate date1, FlexibleDate date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(FlexibleYearMonth date1, FlexibleYearMonth date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(YMDHMS date1, YMDHMS date2) {
        if (date1 == null && date2 == null) {
            return Boolean.FALSE;
        }
        if (date1 != null && date1.equals(date2)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean is異なる(Decimal dec1, Decimal dec2) {
        return !dec1.equals(dec2);
    }

    private boolean set期別金額(FukaJoho 賦課の情報, int 期, RString 徴収方法期別, TextBoxNum textBoxNum, TextBoxDate textBoxDate, Boolean is差異がある) {
        if (賦課の情報 == null || 賦課の情報.getKibetsuList().isEmpty()) {
            return is差異がある;
        }
        Decimal 期別金額 = textBoxNum.getValue();
        List<Kibetsu> 介護期別List = new ArrayList<>(賦課の情報.getKibetsuList());
        for (Kibetsu 介護期別 : 介護期別List) {
            if (徴収方法期別.equals(介護期別.get徴収方法())
                    && 期 == 介護期別.get期()) {
                ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
                ChoteiKyotsuBuilder choteiKyotsuBuilder = 介護期別.getChoteiKyotsu(identifier).createBuilderForEdit();
                boolean isChange = Boolean.FALSE;
                if (!期別金額.equals(介護期別.getChoteiKyotsu(identifier).get調定額()) && !textBoxNum.isReadOnly()) {
                    is差異がある = Boolean.TRUE;
                    isChange = Boolean.TRUE;
                    choteiKyotsuBuilder.set調定額(期別金額);
                }
                if (ChoshuHohoKibetsu.普通徴収.getコード().equals(徴収方法期別)
                        && !介護期別.getChoteiKyotsu(identifier).get納期限().equals(textBoxDate.getValue())
                        && !textBoxDate.isReadOnly()) {
                    is差異がある = Boolean.TRUE;
                    isChange = Boolean.TRUE;
                    choteiKyotsuBuilder.set納期限(textBoxDate.getValue());
                }
                if (isChange) {
                    Kibetsu 介護期別情報 = 介護期別.createBuilderForEdit().setKibetsu(choteiKyotsuBuilder.build().modifiedModel()).build();
                    賦課の情報.createBuilderForEdit().setKibetsu(介護期別情報);
                }
                return is差異がある;
            }
        }
        return is差異がある;
    }

    private void set賦課根拠期割額(NendobunFukaList 更正前賦課リスト, NendobunFukaList 更正後賦課リスト,
            HokenryoDankaiList 保険料段階List) {
        if (更正前賦課リスト != null) {
            FukaJoho 更正前最新賦課の情報 = 更正前賦課リスト.get最新賦課の情報();
            FukakonkyoMaeDiv fukakonkyoMaeDiv = div.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoMae();
            if (更正前最新賦課の情報.get資格取得日() != null) {
                fukakonkyoMaeDiv.getTxtShikakushutokuYMD1().setValue(更正前最新賦課の情報.get資格取得日());
            }
            if (更正前最新賦課の情報.get資格喪失日() != null) {
                fukakonkyoMaeDiv.getTxtShikakusoshitsuYMD1().setValue(更正前最新賦課の情報.get資格喪失日().wareki().toDateString());
            }
            if (更正前最新賦課の情報.get生保開始日() != null) {
                fukakonkyoMaeDiv.getTxtSeihoKaishiYMD1().setValue(更正前最新賦課の情報.get生保開始日());
            }
            if (更正前最新賦課の情報.get生保廃止日() != null) {
                fukakonkyoMaeDiv.getTxtSeihoShuryoYMD1().setValue(更正前最新賦課の情報.get生保廃止日());
            }
            if (更正前最新賦課の情報.get老年開始日() != null) {
                fukakonkyoMaeDiv.getTxtRonenKaishiYMD1().setValue(更正前最新賦課の情報.get老年開始日());
            }
            if (更正前最新賦課の情報.get老年廃止日() != null) {
                fukakonkyoMaeDiv.getTxtRonenShuryoYMD1().setValue(更正前最新賦課の情報.get老年廃止日());
            }
            if (!RString.isNullOrEmpty(更正前最新賦課の情報.get課税区分())) {
                fukakonkyoMaeDiv.getTxtHonninKazei1().setValue(KazeiKubun.toValue(更正前最新賦課の情報.get課税区分()).get名称());
            }
            if (!RString.isNullOrEmpty(更正前最新賦課の情報.get世帯課税区分())) {
                fukakonkyoMaeDiv.getTxtSetaiKazei1().setValue(SetaiKazeiKubun.toValue(更正前最新賦課の情報.get世帯課税区分()).get名称());
            }
            fukakonkyoMaeDiv.getTxtGoukeiShotoku1().setValue(更正前最新賦課の情報.get合計所得金額());
            fukakonkyoMaeDiv.getTxtNenkinShunyu1().setValue(更正前最新賦課の情報.get公的年金収入額());
            if (!RString.isNullOrEmpty(更正前最新賦課の情報.get保険料段階())) {
                fukakonkyoMaeDiv.getTxtHokenryoDankai1().setValue(保険料段階List.getBy段階区分(更正前最新賦課の情報.get保険料段階()).get表記());
            }
            fukakonkyoMaeDiv.getTxtGemmenGaku1().setValue(更正前最新賦課の情報.get減免額());
            fukakonkyoMaeDiv.getTxtNenkanHokenryo1().setValue(更正前最新賦課の情報.get確定介護保険料_年額());
        }
        set更正後賦課根拠期割額(更正後賦課リスト, 保険料段階List);
    }

    private void set更正後賦課根拠期割額(NendobunFukaList 更正後賦課リスト, HokenryoDankaiList 保険料段階List) {
        FukaJoho 更正後賦課リストの情報 = 更正後賦課リスト.get最新賦課の情報();
        FukakonkyoAtoDiv fukakonkyoAtoDiv = div.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoAto();
        if (更正後賦課リストの情報.get資格取得日() != null) {
            fukakonkyoAtoDiv.getTxtShikakushutokuYMD2().setValue(更正後賦課リストの情報.get資格取得日());
            fukakonkyoAtoDiv.getTxtShikakushutokuYMD2().setValue(更正後賦課リストの情報.get資格取得日().plusYear(2));
        }
        if (更正後賦課リストの情報.get資格喪失日() != null) {
            fukakonkyoAtoDiv.getTxtShikakusoshitsuYMD2().setValue(更正後賦課リストの情報.get資格喪失日().wareki().toDateString());
        }
        if (更正後賦課リストの情報.get生保開始日() != null) {
            fukakonkyoAtoDiv.getTxtSeihoKaishiYMD2().setValue(更正後賦課リストの情報.get生保開始日());
        }
        if (更正後賦課リストの情報.get生保廃止日() != null) {
            fukakonkyoAtoDiv.getTxtSeihoShuryoYMD2().setValue(更正後賦課リストの情報.get生保廃止日());
        }
        if (更正後賦課リストの情報.get老年開始日() != null) {
            fukakonkyoAtoDiv.getTxtRonenKaishiYMD2().setValue(更正後賦課リストの情報.get老年開始日());
        }
        if (更正後賦課リストの情報.get老年廃止日() != null) {
            fukakonkyoAtoDiv.getTxtRonenShuryoYMD2().setValue(更正後賦課リストの情報.get老年廃止日());
        }
        if (!RString.isNullOrEmpty(更正後賦課リストの情報.get課税区分())) {
            fukakonkyoAtoDiv.getTxtHonninKazei2().setValue(KazeiKubun.toValue(更正後賦課リストの情報.get課税区分()).get名称());
        }
        if (!RString.isNullOrEmpty(更正後賦課リストの情報.get世帯課税区分())) {
            fukakonkyoAtoDiv.getTxtSetaiKazei2().setValue(SetaiKazeiKubun.toValue(更正後賦課リストの情報.get世帯課税区分()).get名称());
        }
        fukakonkyoAtoDiv.getTxtGoukeiShotoku2().setValue(更正後賦課リストの情報.get合計所得金額());
        fukakonkyoAtoDiv.getTxtNenkinShunyu2().setValue(更正後賦課リストの情報.get公的年金収入額());
        if (!RString.isNullOrEmpty(更正後賦課リストの情報.get保険料段階())) {
            fukakonkyoAtoDiv.getTxtHokenryoDankai2().setValue(保険料段階List.getBy段階区分(更正後賦課リストの情報.get保険料段階()).get表記());
        }
        fukakonkyoAtoDiv.getTxtGemmenGaku2().setValue(更正後賦課リストの情報.get減免額());
        fukakonkyoAtoDiv.getTxtNenkanHokenryo2().setValue(更正後賦課リストの情報.get確定介護保険料_年額());
    }

    private void set減免額(NendobunFukaList 更正後賦課リスト) {
        if (更正後賦課リスト == null) {
            return;
        }
        if (更正後賦課リスト.get最新賦課の情報().get減免額().compareTo(Decimal.ZERO) > 0) {
            div.getTxtGemmenGakuInput().setValue(更正後賦課リスト.get最新賦課の情報().get減免額());
        }
    }

    private void set現年度の普通徴収情報(NendobunFukaList 更正前賦課リスト, NendobunFukaList 更正後賦課リスト) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        FuchoKiUtil 月期対応取得_普徴クラス = new FuchoKiUtil();
        FukaNokiResearcher researcher = FukaNokiResearcher.createInstance();
        KitsukiList 期月リスト = 月期対応取得_普徴クラス.get期月リスト();
        FukaJoho 更正前現年度賦課 = 更正前賦課リスト.get現年度();
        FukaJoho 更正後現年度賦課 = 更正後賦課リスト.get現年度();
        RString 月の期_4月 = 期月リスト.get月の期(Tsuki._4月).get期();
        tablePanel.getLblFuchoKi04().setText(getFormat期(月の期_4月));
        tablePanel.getLblFuchoKoseiMaeValue04().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額01()));
        tablePanel.getTxtFuchoKoseiGo04().setValue(更正後現年度賦課.get普徴期別金額01());
        tablePanel.getLblFuchoZogenValue04().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額01().
                subtract(更正前現年度賦課.get普徴期別金額01())));
        tablePanel.getLblFuchoNofugakuValue04().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_4月, Tsuki._4月));
        tablePanel.getTxtFuchoNokigen04().setValue(researcher.get普徴納期(Integer.valueOf(月の期_4月.toString())).get納期限());

        RString 月の期_5月 = 期月リスト.get月の期(Tsuki._5月).get期();
        tablePanel.getLblFuchoKi05().setText(getFormat期(月の期_5月));
        tablePanel.getLblFuchoKoseiMaeValue05().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額02()));
        tablePanel.getTxtFuchoKoseiGo05().setValue(更正後現年度賦課.get普徴期別金額02());
        tablePanel.getLblFuchoZogenValue05().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額02().
                subtract(更正前現年度賦課.get普徴期別金額02())));
        tablePanel.getLblFuchoNofugakuValue05().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_5月, Tsuki._5月));
        tablePanel.getTxtFuchoNokigen05().setValue(researcher.get普徴納期(Integer.valueOf(月の期_5月.toString())).get納期限());

        RString 月の期_6月 = 期月リスト.get月の期(Tsuki._6月).get期();
        tablePanel.getLblFuchoKi06().setText(getFormat期(月の期_6月));
        tablePanel.getLblFuchoKoseiMaeValue06().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額03()));
        tablePanel.getTxtFuchoKoseiGo06().setValue(更正後現年度賦課.get普徴期別金額03());
        tablePanel.getLblFuchoZogenValue06().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額03().
                subtract(更正前現年度賦課.get普徴期別金額03())));
        tablePanel.getLblFuchoNofugakuValue06().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_6月, Tsuki._6月));
        tablePanel.getTxtFuchoNokigen06().setValue(researcher.get普徴納期(Integer.valueOf(月の期_6月.toString())).get納期限());

        RString 月の期_7月 = 期月リスト.get月の期(Tsuki._7月).get期();
        tablePanel.getLblFuchoKi07().setText(getFormat期(月の期_7月));
        tablePanel.getLblFuchoKoseiMaeValue07().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額04()));
        tablePanel.getTxtFuchoKoseiGo07().setValue(更正後現年度賦課.get普徴期別金額04());
        tablePanel.getLblFuchoZogenValue07().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額04().
                subtract(更正前現年度賦課.get普徴期別金額04())));
        tablePanel.getLblFuchoNofugakuValue07().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_7月, Tsuki._7月));
        tablePanel.getTxtFuchoNokigen07().setValue(researcher.get普徴納期(Integer.valueOf(月の期_7月.toString())).get納期限());

        RString 月の期_8月 = 期月リスト.get月の期(Tsuki._8月).get期();
        tablePanel.getLblFuchoKi08().setText(getFormat期(月の期_8月));
        tablePanel.getLblFuchoKoseiMaeValue08().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額05()));
        tablePanel.getTxtFuchoKoseiGo08().setValue(更正後現年度賦課.get普徴期別金額05());
        tablePanel.getLblFuchoZogenValue08().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額05().
                subtract(更正前現年度賦課.get普徴期別金額05())));
        tablePanel.getLblFuchoNofugakuValue08().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_8月, Tsuki._8月));
        tablePanel.getTxtFuchoNokigen08().setValue(researcher.get普徴納期(Integer.valueOf(月の期_8月.toString())).get納期限());

        RString 月の期_9月 = 期月リスト.get月の期(Tsuki._9月).get期();
        tablePanel.getLblFuchoKi09().setText(getFormat期(月の期_9月));
        tablePanel.getLblFuchoKoseiMaeValue09().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額06()));
        tablePanel.getTxtFuchoKoseiGo09().setValue(更正後現年度賦課.get普徴期別金額06());
        tablePanel.getLblFuchoZogenValue09().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額06().
                subtract(更正前現年度賦課.get普徴期別金額06())));
        tablePanel.getLblFuchoNofugakuValue09().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_9月, Tsuki._9月));
        tablePanel.getTxtFuchoNokigen09().setValue(researcher.get普徴納期(Integer.valueOf(月の期_9月.toString())).get納期限());

        RString 月の期_10月 = 期月リスト.get月の期(Tsuki._10月).get期();
        tablePanel.getLblFuchoKi10().setText(getFormat期(月の期_10月));
        tablePanel.getLblFuchoKoseiMaeValue10().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額07()));
        tablePanel.getTxtFuchoKoseiGo10().setValue(更正後現年度賦課.get普徴期別金額07());
        tablePanel.getLblFuchoZogenValue10().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額07().
                subtract(更正前現年度賦課.get普徴期別金額07())));
        tablePanel.getLblFuchoNofugakuValue10().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_10月, Tsuki._10月));
        tablePanel.getTxtFuchoNokigen10().setValue(researcher.get普徴納期(Integer.valueOf(月の期_10月.toString())).get納期限());

        RString 月の期_11月 = 期月リスト.get月の期(Tsuki._11月).get期();
        tablePanel.getLblFuchoKi11().setText(getFormat期(月の期_11月));
        tablePanel.getLblFuchoKoseiMaeValue11().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額08()));
        tablePanel.getTxtFuchoKoseiGo11().setValue(更正後現年度賦課.get普徴期別金額08());
        tablePanel.getLblFuchoZogenValue11().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額08().
                subtract(更正前現年度賦課.get普徴期別金額08())));
        tablePanel.getLblFuchoNofugakuValue11().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_11月, Tsuki._11月));
        tablePanel.getTxtFuchoNokigen11().setValue(researcher.get普徴納期(Integer.valueOf(月の期_11月.toString())).get納期限());

        RString 月の期_12月 = 期月リスト.get月の期(Tsuki._12月).get期();
        tablePanel.getLblFuchoKi12().setText(getFormat期(月の期_12月));
        tablePanel.getLblFuchoKoseiMaeValue12().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額09()));
        tablePanel.getTxtFuchoKoseiGo12().setValue(更正後現年度賦課.get普徴期別金額09());
        tablePanel.getLblFuchoZogenValue12().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額09().
                subtract(更正前現年度賦課.get普徴期別金額09())));
        tablePanel.getLblFuchoNofugakuValue12().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_12月, Tsuki._12月));
        tablePanel.getTxtFuchoNokigen12().setValue(researcher.get普徴納期(Integer.valueOf(月の期_12月.toString())).get納期限());

        RString 月の期_1月 = 期月リスト.get月の期(Tsuki._1月).get期();
        tablePanel.getLblFuchoKi01().setText(getFormat期(月の期_1月));
        tablePanel.getLblFuchoKoseiMaeValue01().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額10()));
        tablePanel.getTxtFuchoKoseiGo01().setValue(更正後現年度賦課.get普徴期別金額10());
        tablePanel.getLblFuchoZogenValue01().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額10().
                subtract(更正前現年度賦課.get普徴期別金額10())));
        tablePanel.getLblFuchoNofugakuValue01().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_1月, Tsuki._1月));
        tablePanel.getTxtFuchoNokigen01().setValue(researcher.get普徴納期(Integer.valueOf(月の期_1月.toString())).get納期限());

        RString 月の期_2月 = 期月リスト.get月の期(Tsuki._2月).get期();
        tablePanel.getLblFuchoKi02().setText(getFormat期(月の期_2月));
        tablePanel.getLblFuchoKoseiMaeValue02().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額11()));
        tablePanel.getTxtFuchoKoseiGo02().setValue(更正後現年度賦課.get普徴期別金額11());
        tablePanel.getLblFuchoZogenValue02().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額11().
                subtract(更正前現年度賦課.get普徴期別金額11())));
        tablePanel.getLblFuchoNofugakuValue02().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_2月, Tsuki._2月));
        tablePanel.getTxtFuchoNokigen02().setValue(researcher.get普徴納期(Integer.valueOf(月の期_2月.toString())).get納期限());

        RString 月の期_3月 = 期月リスト.get月の期(Tsuki._3月).get期();
        tablePanel.getLblFuchoKi03().setText(getFormat期(月の期_3月));
        tablePanel.getLblFuchoKoseiMaeValue03().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額12()));
        tablePanel.getTxtFuchoKoseiGo03().setValue(更正後現年度賦課.get普徴期別金額12());
        tablePanel.getLblFuchoZogenValue03().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額12().
                subtract(更正前現年度賦課.get普徴期別金額12())));
        tablePanel.getLblFuchoNofugakuValue03().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_3月, Tsuki._3月));
        tablePanel.getTxtFuchoNokigen03().setValue(researcher.get普徴納期(Integer.valueOf(月の期_3月.toString())).get納期限());

        RString 月の期_翌年度4月 = 期月リスト.get月の期(Tsuki.翌年度4月).get期();
        tablePanel.getLblFuchoKiYoku04().setText(getFormat期(月の期_翌年度4月));
        tablePanel.getLblFuchoKoseiMaeValueYoku04().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額13()));
        tablePanel.getTxtFuchoKoseiGoYoku04().setValue(更正後現年度賦課.get普徴期別金額13());
        tablePanel.getLblFuchoZogenValueYoku04().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額13().
                subtract(更正前現年度賦課.get普徴期別金額13())));
        tablePanel.getLblFuchoNofugakuValueYoku04().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_翌年度4月, Tsuki.翌年度4月));
        tablePanel.getTxtFuchoNokigenYoku04().setValue(researcher.get普徴納期(Integer.valueOf(月の期_翌年度4月.toString())).get納期限());

        RString 月の期_翌年度5月 = 期月リスト.get月の期(Tsuki.翌年度5月).get期();
        tablePanel.getLblFuchoKiYoku05().setText(getFormat期(月の期_翌年度5月));
        tablePanel.getLblFuchoKoseiMaeValueYoku05().setText(get金額のカンマ編集(更正前現年度賦課.get普徴期別金額14()));
        tablePanel.getTxtFuchoKoseiGoYoku05().setValue(更正後現年度賦課.get普徴期別金額14());
        tablePanel.getLblFuchoZogenValueYoku05().setText(get金額のカンマ編集(更正後現年度賦課.get普徴期別金額14().
                subtract(更正前現年度賦課.get普徴期別金額14())));
        tablePanel.getLblFuchoNofugakuValueYoku05().setText(get普通徴収の納付額(更正後現年度賦課, 月の期_翌年度5月, Tsuki.翌年度5月));
        tablePanel.getTxtFuchoNokigenYoku05().setValue(researcher.get普徴納期(Integer.valueOf(月の期_翌年度5月.toString())).get納期限());

        tablePanel.getLblFuchoKoseiMaeSum().setText(get普通徴収の更正前合計(更正前現年度賦課));
        tablePanel.getLblFuchoKoseiGoSum().setText(get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(get普通徴収の増減合計());
        tablePanel.getLblFuchoNofugakuSum().setText(get普通徴収の納付額合計());
    }

    private void set現年度の普通徴収情報の入力制御(NendobunFukaList 更正後賦課リスト) {
        FlexibleYear 賦課年度 = 更正後賦課リスト.get賦課年度();
        RYearMonth 調定年月 = 更正後賦課リスト.get現年度().get調定日時().getDate().getYearMonth();
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        boolean is入力不可_4月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._4月);
        tablePanel.getTxtFuchoKoseiGo04().setReadOnly(is入力不可_4月);
        tablePanel.getTxtFuchoNokigen04().setReadOnly(is入力不可_4月);

        boolean is入力不可_5月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._5月);
        tablePanel.getTxtFuchoKoseiGo05().setReadOnly(is入力不可_5月);
        tablePanel.getTxtFuchoNokigen05().setReadOnly(is入力不可_5月);

        boolean is入力不可_6月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._6月);
        tablePanel.getTxtFuchoKoseiGo06().setReadOnly(is入力不可_6月);
        tablePanel.getTxtFuchoNokigen06().setReadOnly(is入力不可_6月);

        boolean is入力不可_7月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._7月);
        tablePanel.getTxtFuchoKoseiGo07().setReadOnly(is入力不可_7月);
        tablePanel.getTxtFuchoNokigen07().setReadOnly(is入力不可_7月);

        boolean is入力不可_8月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._8月);
        tablePanel.getTxtFuchoKoseiGo08().setReadOnly(is入力不可_8月);
        tablePanel.getTxtFuchoNokigen08().setReadOnly(is入力不可_8月);

        boolean is入力不可_9月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._9月);
        tablePanel.getTxtFuchoKoseiGo09().setReadOnly(is入力不可_9月);
        tablePanel.getTxtFuchoNokigen09().setReadOnly(is入力不可_9月);

        boolean is入力不可_10月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._10月);
        tablePanel.getTxtFuchoKoseiGo10().setReadOnly(is入力不可_10月);
        tablePanel.getTxtFuchoNokigen10().setReadOnly(is入力不可_10月);

        boolean is入力不可_11月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._11月);
        tablePanel.getTxtFuchoKoseiGo11().setReadOnly(is入力不可_11月);
        tablePanel.getTxtFuchoNokigen11().setReadOnly(is入力不可_11月);

        boolean is入力不可_12月 = is更正後と納期限入力不可(調定年月, 賦課年度, Tsuki._12月);
        tablePanel.getTxtFuchoKoseiGo12().setReadOnly(is入力不可_12月);
        tablePanel.getTxtFuchoNokigen12().setReadOnly(is入力不可_12月);

        boolean is入力不可_1月 = is更正後と納期限入力不可(調定年月, 賦課年度.plusYear(NUM_1), Tsuki._1月);
        tablePanel.getTxtFuchoKoseiGo01().setReadOnly(is入力不可_1月);
        tablePanel.getTxtFuchoNokigen01().setReadOnly(is入力不可_1月);

        boolean is入力不可_2月 = is更正後と納期限入力不可(調定年月, 賦課年度.plusYear(NUM_1), Tsuki._2月);
        tablePanel.getTxtFuchoKoseiGo02().setReadOnly(is入力不可_2月);
        tablePanel.getTxtFuchoNokigen02().setReadOnly(is入力不可_2月);

        boolean is入力不可_3月 = is更正後と納期限入力不可(調定年月, 賦課年度.plusYear(NUM_1), Tsuki._3月);
        tablePanel.getTxtFuchoKoseiGo03().setReadOnly(is入力不可_3月);
        tablePanel.getTxtFuchoNokigen03().setReadOnly(is入力不可_3月);

        boolean is入力不可_翌年度4月 = is更正後と納期限入力不可(調定年月, 賦課年度.plusYear(NUM_1), Tsuki.翌年度4月);
        tablePanel.getTxtFuchoKoseiGoYoku04().setReadOnly(is入力不可_翌年度4月);
        tablePanel.getTxtFuchoNokigenYoku04().setReadOnly(is入力不可_翌年度4月);

        boolean is入力不可_翌年度5月 = is更正後と納期限入力不可(調定年月, 賦課年度.plusYear(NUM_1), Tsuki.翌年度5月);
        tablePanel.getTxtFuchoKoseiGoYoku04().setReadOnly(is入力不可_翌年度5月);
        tablePanel.getTxtFuchoNokigenYoku04().setReadOnly(is入力不可_翌年度5月);
    }

    private void set現年度の特別徴収情報(NendobunFukaList 更正前賦課リスト, NendobunFukaList 更正後賦課リスト) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        TokuchoKiUtil 月期対応取得_特徴クラス = new TokuchoKiUtil();
        KitsukiList 期月リスト = 月期対応取得_特徴クラス.get期月リスト();
        FukaJoho 更正前現年度賦課 = 更正前賦課リスト.get現年度();
        FukaJoho 更正後現年度賦課 = 更正後賦課リスト.get現年度();
        RString 月の期_4月 = get月の期By月(期月リスト, Tsuki._4月);
        tablePanel.getLblTokuchoKi04().setText(getFormat期(月の期_4月));
        tablePanel.getLblTokuchoKoseiMaeValue04().setText(get金額のカンマ編集(更正前現年度賦課.get特徴期別金額01()));
        tablePanel.getTxtTokuchoKoseiGo04().setValue(更正後現年度賦課.get特徴期別金額01());
        tablePanel.getLblTokuchoZogenValue04().setText(get金額のカンマ編集(更正後現年度賦課.get特徴期別金額01().
                subtract(更正前現年度賦課.get特徴期別金額01())));
        tablePanel.getLblTokuchoNofugakuValue04().setText(get特別徴収の納付額(更正後現年度賦課, 月の期_4月, Tsuki._4月));

        RString 月の期_6月 = get月の期By月(期月リスト, Tsuki._6月);
        tablePanel.getLblTokuchoKi06().setText(getFormat期(月の期_6月));
        tablePanel.getLblTokuchoKoseiMaeValue06().setText(get金額のカンマ編集(更正前現年度賦課.get特徴期別金額02()));
        tablePanel.getTxtTokuchoKoseiGo06().setValue(更正後現年度賦課.get特徴期別金額02());
        tablePanel.getLblTokuchoZogenValue06().setText(get金額のカンマ編集(更正後現年度賦課.get特徴期別金額02().
                subtract(更正前現年度賦課.get特徴期別金額02())));
        RString 納付額_6月 = get特別徴収の納付額(更正後現年度賦課, 月の期_6月, Tsuki._6月);
        tablePanel.getLblTokuchoNofugakuValue06().setText(納付額_6月);
        div.setTokuchoNofugakuValue06(納付額_6月);

        RString 月の期_8月 = get月の期By月(期月リスト, Tsuki._8月);
        tablePanel.getLblTokuchoKi08().setText(getFormat期(月の期_8月));
        tablePanel.getLblTokuchoKoseiMaeValue08().setText(get金額のカンマ編集(更正前現年度賦課.get特徴期別金額03()));
        tablePanel.getTxtTokuchoKoseiGo08().setValue(更正後現年度賦課.get特徴期別金額03());
        tablePanel.getLblTokuchoZogenValue08().setText(get金額のカンマ編集(更正後現年度賦課.get特徴期別金額03().
                subtract(更正前現年度賦課.get特徴期別金額03())));
        RString 納付額_8月 = get特別徴収の納付額(更正後現年度賦課, 月の期_8月, Tsuki._8月);
        tablePanel.getLblTokuchoNofugakuValue08().setText(納付額_8月);
        div.setTokuchoNofugakuValue08(納付額_8月);

        RString 月の期_10月 = get月の期By月(期月リスト, Tsuki._10月);
        tablePanel.getLblTokuchoKi10().setText(getFormat期(月の期_10月));
        tablePanel.getLblTokuchoKoseiMaeValue10().setText(get金額のカンマ編集(更正前現年度賦課.get特徴期別金額04()));
        tablePanel.getTxtTokuchoKoseiGo10().setValue(更正後現年度賦課.get特徴期別金額04());
        tablePanel.getLblTokuchoZogenValue10().setText(get金額のカンマ編集(更正後現年度賦課.get特徴期別金額04().
                subtract(更正前現年度賦課.get特徴期別金額04())));
        RString 納付額_10月 = get特別徴収の納付額(更正後現年度賦課, 月の期_10月, Tsuki._10月);
        tablePanel.getLblTokuchoNofugakuValue10().setText(納付額_10月);
        div.setTokuchoNofugakuValue10(納付額_10月);

        RString 月の期_12月 = get月の期By月(期月リスト, Tsuki._12月);
        tablePanel.getLblTokuchoKi12().setText(getFormat期(月の期_12月));
        tablePanel.getLblTokuchoKoseiMaeValue12().setText(get金額のカンマ編集(更正前現年度賦課.get特徴期別金額05()));
        tablePanel.getTxtTokuchoKoseiGo12().setValue(更正後現年度賦課.get特徴期別金額05());
        tablePanel.getLblTokuchoZogenValue12().setText(get金額のカンマ編集(更正後現年度賦課.get特徴期別金額05().
                subtract(更正前現年度賦課.get特徴期別金額05())));
        RString 納付額_12月 = get特別徴収の納付額(更正後現年度賦課, 月の期_12月, Tsuki._12月);
        tablePanel.getLblTokuchoNofugakuValue12().setText(納付額_12月);
        div.setTokuchoNofugakuValue12(納付額_12月);

        RString 月の期_2月 = get月の期By月(期月リスト, Tsuki._2月);
        tablePanel.getLblTokuchoKi02().setText(getFormat期(月の期_2月));
        tablePanel.getLblTokuchoKoseiMaeValue02().setText(get金額のカンマ編集(更正前現年度賦課.get特徴期別金額06()));
        tablePanel.getTxtTokuchoKoseiGo02().setValue(更正後現年度賦課.get特徴期別金額06());
        tablePanel.getLblTokuchoZogenValue02().setText(get金額のカンマ編集(更正後現年度賦課.get特徴期別金額06().
                subtract(更正前現年度賦課.get特徴期別金額06())));
        RString 納付額_2月 = get特別徴収の納付額(更正後現年度賦課, 月の期_2月, Tsuki._2月);
        tablePanel.getLblTokuchoNofugakuValue02().setText(納付額_2月);
        div.setTokuchoNofugakuValue02(納付額_2月);

        tablePanel.getLblTokuchoKoseiMaeSum().setText(get特別徴収の更正前合計(更正前現年度賦課));
        tablePanel.getLblTokuchoKoseiGoSum().setText(get特別徴収の更正後合計());
        tablePanel.getLblTokuchoZogenSum().setText(get特別徴収の増減合計());
        tablePanel.getLblTokuchoNofugakuSum().setText(get特別徴収の納付額合計());
    }

    private void set現年度の特別徴収情報の入力制御(
            KoseiZengoChoshuHoho 更正前後徴収方法,
            NendobunFukaList 更正後賦課リスト,
            boolean is本算定処理済フラグ) {
        TokuchoIraiJohoSakuseiJokyo 特徴依頼情報作成状況 = new TokuchoIraiJohoSakuseiJokyo();
        boolean is1期入力可 = Boolean.TRUE;
        boolean is2期入力可 = Boolean.TRUE;
        boolean is3期入力可 = Boolean.TRUE;
        boolean is4期入力可 = Boolean.TRUE;
        boolean is5期入力可 = Boolean.TRUE;
        boolean is6期入力可 = Boolean.TRUE;
        if (更正前後徴収方法.get更正後() != null) {
            is2期入力可 = is特徴開始者(更正前後徴収方法.get更正後().get徴収方法6月());
            is3期入力可 = is特徴開始者(更正前後徴収方法.get更正後().get徴収方法8月());
            is4期入力可 = is特徴開始者(更正前後徴収方法.get更正後().get徴収方法10月())
                    || is特徴開始者(更正前後徴収方法.get更正後().get徴収方法12月());
            is5期入力可 = is特徴開始者(更正前後徴収方法.get更正後().get徴収方法12月());
            is6期入力可 = is特徴開始者(更正前後徴収方法.get更正後().get徴収方法2月());
        }
        if (is本算定処理済フラグ) {
            boolean is両方とも未処理 = is特徴異動情報作成前であれば(特徴依頼情報作成状況, TokuchoHosokuMonth.特徴10月捕捉)
                    && is特徴異動情報作成前であれば(特徴依頼情報作成状況, TokuchoHosokuMonth.特徴4月捕捉);
            boolean is4月捕捉未処理 = is特徴異動情報作成前であれば(特徴依頼情報作成状況, TokuchoHosokuMonth.特徴4月捕捉);
            boolean is6月捕捉未処理 = is特徴異動情報作成前であれば(特徴依頼情報作成状況, TokuchoHosokuMonth.特徴6月捕捉);
            boolean is8月捕捉未処理 = is特徴異動情報作成前であれば(特徴依頼情報作成状況, TokuchoHosokuMonth.特徴8月捕捉);
            is1期入力可 = Boolean.FALSE;
            is2期入力可 = Boolean.FALSE;
            is3期入力可 = Boolean.FALSE;
            is4期入力可 = !is4期入力可 ? Boolean.FALSE : is4月捕捉未処理 || is両方とも未処理;
            is5期入力可 = !is5期入力可 ? Boolean.FALSE : is4月捕捉未処理 || is6月捕捉未処理 || is両方とも未処理;
            is6期入力可 = !is6期入力可 ? Boolean.FALSE : is8月捕捉未処理;
        } else {
            is1期入力可 = Boolean.FALSE;
            is2期入力可 = !is2期入力可 ? Boolean.FALSE : is特徴異動情報作成前であれば(特徴依頼情報作成状況, TokuchoHosokuMonth.特徴12月捕捉);
            is3期入力可 = !is3期入力可 ? Boolean.FALSE : is特徴異動情報作成前であれば(特徴依頼情報作成状況, TokuchoHosokuMonth.特徴2月捕捉);
            is4期入力可 = Boolean.FALSE;
            is5期入力可 = Boolean.FALSE;
            is6期入力可 = Boolean.FALSE;
        }
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getTxtTokuchoKoseiGo04().setReadOnly(!is1期入力可);
        tablePanel.getTxtTokuchoKoseiGo06().setReadOnly(!is2期入力可);
        tablePanel.getTxtTokuchoKoseiGo08().setReadOnly(!is3期入力可);
        tablePanel.getTxtTokuchoKoseiGo10().setReadOnly(!is4期入力可);
        tablePanel.getTxtTokuchoKoseiGo12().setReadOnly(!is5期入力可);
        tablePanel.getTxtTokuchoKoseiGo02().setReadOnly(!is6期入力可);
    }

    private boolean is特徴開始者(RString 徴収方法) {
        return ChoshuHoho.特別徴収_地共済.getコード().equals(徴収方法) || ChoshuHoho.特別徴収_厚生労働省.getコード().equals(徴収方法);
    }

    private boolean is特徴異動情報作成前であれば(TokuchoIraiJohoSakuseiJokyo 特徴依頼情報作成状況, TokuchoHosokuMonth month) {
        List<ShoriDateKanri> 処理状況リスト = 特徴依頼情報作成状況.find処理状況Of(month.getコード());
        for (ShoriDateKanri shoriDateKanri : 処理状況リスト) {
            if (shoriDateKanri.get基準日時() != null && !shoriDateKanri.get基準日時().isEmpty()) {
                return Boolean.FALSE;
            }
        }
        return 処理状況リスト.isEmpty();
    }

    private void set過年度の徴収情報(NendobunFukaList 更正前賦課リスト, NendobunFukaList 更正後賦課リスト) {
        if (!更正後賦課リスト.isHas過年度賦課()) {
            div.getDgFuchoKanendo().setDisplayNone(true);
            return;
        }
        KanendoKiUtil 月期対応取得_過年度 = new KanendoKiUtil();
        KitsukiList 期月リスト = 月期対応取得_過年度.get期月リスト();
        FlexibleYear 賦課年度 = 更正後賦課リスト.get賦課年度();
        if (更正後賦課リスト.get過年度1() != null) {
            FlexibleYear 調定年度 = 賦課年度.plusYear(NUM_1);
            FukaJoho 更正前過年度1 = 更正前賦課リスト.get過年度1();
            FukaJoho 更正後過年度1 = 更正後賦課リスト.get過年度1();
            set過年度の徴収DateGrid(賦課年度, 調定年度, 更正前過年度1, 更正後過年度1, 期月リスト);
        }
        if (更正後賦課リスト.get過年度2() != null) {
            FlexibleYear 調定年度 = 賦課年度.plusYear(NUM_2);
            FukaJoho 更正前過年度2 = 更正前賦課リスト.get過年度2();
            FukaJoho 更正後過年度2 = 更正後賦課リスト.get過年度2();
            set過年度の徴収DateGrid(賦課年度, 調定年度, 更正前過年度2, 更正後過年度2, 期月リスト);
        }
        if (更正後賦課リスト.get過年度3() != null) {
            FlexibleYear 調定年度 = 賦課年度.plusYear(NUM_3);
            FukaJoho 更正前過年度3 = 更正前賦課リスト.get過年度3();
            FukaJoho 更正後過年度3 = 更正後賦課リスト.get過年度3();
            set過年度の徴収DateGrid(賦課年度, 調定年度, 更正前過年度3, 更正後過年度3, 期月リスト);
        }
        if (更正後賦課リスト.get過年度4() != null) {
            FlexibleYear 調定年度 = 賦課年度.plusYear(NUM_4);
            FukaJoho 更正前過年度4 = 更正前賦課リスト.get過年度4();
            FukaJoho 更正後過年度4 = 更正後賦課リスト.get過年度4();
            set過年度の徴収DateGrid(賦課年度, 調定年度, 更正前過年度4, 更正後過年度4, 期月リスト);
        }
        if (更正後賦課リスト.get過年度5() != null) {
            FlexibleYear 調定年度 = 賦課年度.plusYear(NUM_5);
            FukaJoho 更正前過年度5 = 更正前賦課リスト.get過年度5();
            FukaJoho 更正後過年度5 = 更正後賦課リスト.get過年度5();
            set過年度の徴収DateGrid(賦課年度, 調定年度, 更正前過年度5, 更正後過年度5, 期月リスト);
        }
    }

    private void set保険料年額と事由タブエリア(NendobunFukaList 更正前賦課リスト, NendobunFukaList 更正後賦課リスト,
            HokenryoDankaiList 保険料段階List) {
        set更正前算定の基礎(更正前賦課リスト, 保険料段階List);
        set更正後算定の基礎(更正後賦課リスト, 保険料段階List);
        FukaJoho 更正後現年度 = 更正後賦課リスト.get現年度();
        HonsanteiIkoHantei honsanteiIkoHantei = HonsanteiIkoHantei.createInstance();
        if (!honsanteiIkoHantei.is本算定後(更正後賦課リスト.get現年度())) {
            div.getSokujikouseiJiyu().setDisplayNone(true);
            return;
        }
        if (更正後現年度.get調定事由1() != null) {
            div.getSokujikouseiJiyu().getTxtChoteiJiyu1().setValue(更正後現年度.get調定事由1());
        }
        if (更正後現年度.get調定事由2() != null) {
            div.getSokujikouseiJiyu().getTxtChoteiJiyu2().setValue(更正後現年度.get調定事由2());
        }
        if (更正後現年度.get調定事由3() != null) {
            div.getSokujikouseiJiyu().getTxtChoteiJiyu3().setValue(更正後現年度.get調定事由3());
        }
        if (更正後現年度.get調定事由4() != null) {
            div.getSokujikouseiJiyu().getTxtChoteiJiyu4().setValue(更正後現年度.get調定事由4());
        }
    }

    private void set更正前算定の基礎(NendobunFukaList 更正前賦課リスト, HokenryoDankaiList 保険料段階List) {
        tblSanteinokisoMaeDiv tablePanel1 = div.getSokujikouseiSanteinoKiso().getTblSanteinokisoMae();
        FukaJoho 更正前現年度 = 更正前賦課リスト.get現年度();
        RString 期間1 = RString.EMPTY;
        if (更正前現年度.get月割開始年月1() != null) {
            期間1 = 期間1.concat(更正前現年度.get月割開始年月1().wareki().toDateString());
        }
        期間1 = 期間1.concat(カラ);
        if (更正前現年度.get月割終了年月1() != null) {
            期間1 = 期間1.concat(更正前現年度.get月割終了年月1().wareki().toDateString());
        }
        tablePanel1.getLblKikanMae1().setText(期間1);
        if (更正前現年度.get月割終了年月1() != null && 更正前現年度.get月割開始年月1() != null) {
            tablePanel1.getLblTsukisuMae1().setText(new RString(更正前現年度.get月割終了年月1().
                    getBetweenMonths(更正前現年度.get月割開始年月1())));
        }

        if (更正前現年度.get保険料算定段階1() != null && !RString.isNullOrEmpty(更正前現年度.get保険料算定段階1())) {
            HokenryoDankai 更正前保険料段階1 = 保険料段階List.getBy段階区分(更正前現年度.get保険料算定段階1());
            tablePanel1.getLblHokenryoDankaiMae1().setText(更正前保険料段階1.get表記());
            tablePanel1.getLblHokenryoritsuMae1().setText(get金額のカンマ編集(更正前保険料段階1.get保険料率()));
            if (更正前現年度.get月割終了年月1() != null && 更正前現年度.get月割開始年月1() != null) {
                tablePanel1.getLblHokenryoSanshutsuGakuMae1().setText(get金額のカンマ編集(更正前保険料段階1.get保険料率().
                        multiply(更正前現年度.get月割終了年月1().
                                getBetweenMonths(更正前現年度.get月割開始年月1())).divide(DECIMAL_12)));
            }
        }
        tablePanel1.getLblHokenryoGakuMae1().setText(get金額のカンマ編集(更正前現年度.get算定年額保険料1()));

        RString 期間2 = RString.EMPTY;
        if (更正前現年度.get月割開始年月2() != null) {
            期間2 = 期間2.concat(更正前現年度.get月割開始年月2().wareki().toDateString());
        }
        期間2 = 期間2.concat(カラ);
        if (更正前現年度.get月割終了年月2() != null) {
            期間2 = 期間2.concat(更正前現年度.get月割終了年月2().wareki().toDateString());
        }
        tablePanel1.getLblKikanMae2().setText(期間2);
        if (更正前現年度.get月割終了年月2() != null && 更正前現年度.get月割開始年月2() != null) {
            tablePanel1.getLblTsukisuMae2().setText(new RString(更正前現年度.get月割終了年月2().
                    getBetweenMonths(更正前現年度.get月割開始年月2())));
        }
        if (更正前現年度.get保険料算定段階2() != null && !RString.isNullOrEmpty(更正前現年度.get保険料算定段階2())) {
            HokenryoDankai 更正前保険料段階2 = 保険料段階List.getBy段階区分(更正前現年度.get保険料算定段階2());
            tablePanel1.getLblHokenryoDankaiMae2().setText(更正前保険料段階2.get表記());
            tablePanel1.getLblHokenryoritsuMae2().setText(get金額のカンマ編集(更正前保険料段階2.get保険料率()));
            if (更正前現年度.get月割終了年月2() != null && 更正前現年度.get月割開始年月2() != null) {
                tablePanel1.getLblHokenryoSanshutsuGakuMae2().setText(get金額のカンマ編集(更正前保険料段階2.get保険料率().
                        multiply(更正前現年度.get月割終了年月2().
                                getBetweenMonths(更正前現年度.get月割開始年月2())).divide(DECIMAL_12)));
            }
        }
        tablePanel1.getLblHokenryoGakuMae2().setText(get金額のカンマ編集(更正前現年度.get算定年額保険料2()));
    }

    private void set更正後算定の基礎(NendobunFukaList 更正後賦課リスト, HokenryoDankaiList 保険料段階List) {
        tblSanteinokisoAtoDiv tablePanel2 = div.getSokujikouseiSanteinoKiso().getTblSanteinokisoAto();
        FukaJoho 更正後現年度 = 更正後賦課リスト.get現年度();
        RString 期間1 = RString.EMPTY;
        if (更正後現年度.get月割開始年月1() != null) {
            期間1 = 期間1.concat(更正後現年度.get月割開始年月1().wareki().toDateString());
        }
        期間1 = 期間1.concat(カラ);
        if (更正後現年度.get月割終了年月1() != null) {
            期間1 = 期間1.concat(更正後現年度.get月割終了年月1().wareki().toDateString());
        }
        tablePanel2.getLblKikanAto1().setText(期間1);
        if (更正後現年度.get月割終了年月1() != null && 更正後現年度.get月割開始年月1() != null) {
            tablePanel2.getLblTsukisuAto1().setText(new RString(更正後現年度.get月割終了年月1().
                    getBetweenMonths(更正後現年度.get月割開始年月1())));
        }
        if (更正後現年度.get保険料算定段階1() != null && !RString.isNullOrEmpty(更正後現年度.get保険料算定段階1())) {
            HokenryoDankai 更正後保険料段階1 = 保険料段階List.getBy段階区分(更正後現年度.get保険料算定段階1());
            tablePanel2.getLblHokenryoDankaiAto1().setText(更正後保険料段階1.get表記());
            tablePanel2.getLblHokenryoritsuAto1().setText(get金額のカンマ編集(更正後保険料段階1.get保険料率()));
            if (更正後現年度.get月割終了年月1() != null && 更正後現年度.get月割開始年月1() != null) {
                tablePanel2.getLblHokenryoSanshutsuGakuAto1().setText(get金額のカンマ編集(更正後保険料段階1.get保険料率().
                        multiply(更正後現年度.get月割終了年月1().
                                getBetweenMonths(更正後現年度.get月割開始年月1())).divide(DECIMAL_12)));
            }
        }
        tablePanel2.getLblHokenryoGakuAto1().setText(get金額のカンマ編集(更正後現年度.get算定年額保険料1()));

        RString 期間2 = RString.EMPTY;
        if (更正後現年度.get月割開始年月2() != null) {
            期間2 = 期間2.concat(更正後現年度.get月割開始年月2().wareki().toDateString());
        }
        期間2 = 期間2.concat(カラ);
        if (更正後現年度.get月割終了年月2() != null) {
            期間2 = 期間2.concat(更正後現年度.get月割終了年月2().wareki().toDateString());
        }
        tablePanel2.getLblKikanAto2().setText(期間2);
        if (更正後現年度.get月割終了年月2() != null && 更正後現年度.get月割開始年月2() != null) {
            tablePanel2.getLblTsukisuAto2().setText(new RString(更正後現年度.get月割終了年月2().
                    getBetweenMonths(更正後現年度.get月割開始年月2())));
        }
        if (更正後現年度.get保険料算定段階2() != null && !RString.isNullOrEmpty(更正後現年度.get保険料算定段階2())) {
            HokenryoDankai 更正後保険料段階2 = 保険料段階List.getBy段階区分(更正後現年度.get保険料算定段階2());
            tablePanel2.getLblHokenryoDankaiAto2().setText(更正後保険料段階2.get表記());
            tablePanel2.getLblHokenryoritsuAto2().setText(get金額のカンマ編集(更正後保険料段階2.get保険料率()));
            if (更正後現年度.get月割終了年月2() != null && 更正後現年度.get月割開始年月2() != null) {
                tablePanel2.getLblHokenryoSanshutsuGakuAto2().setText(get金額のカンマ編集(更正後保険料段階2.get保険料率().
                        multiply(更正後現年度.get月割終了年月2().
                                getBetweenMonths(更正後現年度.get月割開始年月2())).divide(DECIMAL_12)));
            }
        }
        tablePanel2.getLblHokenryoGakuAto2().setText(get金額のカンマ編集(更正後現年度.get算定年額保険料2()));
    }

    private void set過年度の徴収DateGrid(FlexibleYear 賦課年度, FlexibleYear 調定年度, FukaJoho 更正前過年度,
            FukaJoho 更正後過年度, KitsukiList 期月リスト) {
        FukaNokiResearcher researcher = FukaNokiResearcher.createInstance();
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            dgFuchoKanendo_Row row = new dgFuchoKanendo_Row();
            row.getChoteiNendo().setValue(new FlexibleDate(賦課年度.toDateString().concat(一月一日)));
            row.getFukaNendo().setValue(new FlexibleDate(調定年度.toDateString().concat(一月一日)));
            row.setTsuki(new RString(kitsuki.get月AsInt()).concat(月));
            row.setKi(getFormat期(kitsuki.get期()));
            Decimal 更正前 = 更正前過年度.get普徴期別金額(kitsuki.get期AsInt());
            Decimal 更正後 = 更正後過年度.get普徴期別金額(kitsuki.get期AsInt());
            if (!更正前.equals(Decimal.ZERO)
                    || !更正後.equals(Decimal.ZERO)) {
                row.getKoseiMae().setValue(更正前);
                row.getKoseiGo().setValue(更正後);
                row.getZogen().setValue(row.getKoseiGo().getValue().multiply(row.getKoseiMae().getValue()));
                row.getNofuGaku().setValue(getFormat金額(get普通徴収の納付額(更正後過年度, kitsuki.get期(), kitsuki.get月())));
                row.getNoKigen().setValue(researcher.get過年度納期(kitsuki.get期AsInt()).get納期限());
            }
            row.getTokuchoSaishutsuKanpu().setValue(更正後過年度.get特徴歳出還付額());
            row.getFuchoSaishutsuKanpu().setValue(更正後過年度.get普徴歳出還付額());
            if (!更正前.equals(Decimal.ZERO)
                    || !更正後.equals(Decimal.ZERO)
                    || !更正後過年度.get特徴歳出還付額().equals(Decimal.ZERO)
                    || !更正後過年度.get普徴歳出還付額().equals(Decimal.ZERO)) {
                div.getDgFuchoKanendo().getDataSource().add(row);
            }
        }
    }

    private RString get特別徴収の更正前合計(FukaJoho 更正前現年度賦課) {
        Decimal 特別徴収の更正前合計 = 更正前現年度賦課.get特徴期別金額01().add(更正前現年度賦課.get特徴期別金額02()).
                add(更正前現年度賦課.get特徴期別金額03()).add(更正前現年度賦課.get特徴期別金額04()).
                add(更正前現年度賦課.get特徴期別金額05()).add(更正前現年度賦課.get特徴期別金額06());
        return get金額のカンマ編集(特別徴収の更正前合計);
    }

    private RString get普通徴収の更正前合計(FukaJoho 更正前現年度賦課) {
        Decimal 普通徴収の更正前合計 = 更正前現年度賦課.get普徴期別金額01().add(更正前現年度賦課.get普徴期別金額02()).
                add(更正前現年度賦課.get普徴期別金額03()).add(更正前現年度賦課.get普徴期別金額04()).
                add(更正前現年度賦課.get普徴期別金額05()).add(更正前現年度賦課.get普徴期別金額06()).
                add(更正前現年度賦課.get普徴期別金額07()).add(更正前現年度賦課.get普徴期別金額08()).
                add(更正前現年度賦課.get普徴期別金額09()).add(更正前現年度賦課.get普徴期別金額10()).
                add(更正前現年度賦課.get普徴期別金額11()).add(更正前現年度賦課.get普徴期別金額12()).
                add(更正前現年度賦課.get普徴期別金額13()).add(更正前現年度賦課.get普徴期別金額14());
        return get金額のカンマ編集(普通徴収の更正前合計);
    }

    private RString get特別徴収の更正後合計() {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 特別徴収の更正後合計 = tablePanel.getTxtTokuchoKoseiGo04().getValue().add(tablePanel.getTxtTokuchoKoseiGo06().getValue()).
                add(tablePanel.getTxtTokuchoKoseiGo08().getValue()).add(tablePanel.getTxtTokuchoKoseiGo10().getValue()).
                add(tablePanel.getTxtTokuchoKoseiGo12().getValue()).add(tablePanel.getTxtTokuchoKoseiGo02().getValue());
        return get金額のカンマ編集(特別徴収の更正後合計);
    }

    private RString get普通徴収の更正後合計() {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 普通徴収の更正後合計 = tablePanel.getTxtFuchoKoseiGo04().getValue().add(tablePanel.getTxtFuchoKoseiGo05().getValue()).
                add(tablePanel.getTxtFuchoKoseiGo06().getValue()).add(tablePanel.getTxtFuchoKoseiGo07().getValue()).
                add(tablePanel.getTxtFuchoKoseiGo08().getValue()).add(tablePanel.getTxtFuchoKoseiGo09().getValue()).
                add(tablePanel.getTxtFuchoKoseiGo10().getValue()).add(tablePanel.getTxtFuchoKoseiGo11().getValue()).
                add(tablePanel.getTxtFuchoKoseiGo12().getValue()).add(tablePanel.getTxtFuchoKoseiGo01().getValue()).
                add(tablePanel.getTxtFuchoKoseiGo02().getValue()).add(tablePanel.getTxtFuchoKoseiGo03().getValue()).
                add(tablePanel.getTxtFuchoKoseiGoYoku04().getValue()).add(tablePanel.getTxtFuchoKoseiGoYoku05().getValue());
        return get金額のカンマ編集(普通徴収の更正後合計);
    }

    private RString get特別徴収の増減合計() {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 特別徴収の増減合計 = getFormat金額(tablePanel.getLblTokuchoZogenValue04().getText()).
                add(getFormat金額(tablePanel.getLblTokuchoZogenValue06().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoZogenValue08().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoZogenValue10().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoZogenValue12().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoZogenValue02().getText()));
        return get金額のカンマ編集(特別徴収の増減合計);
    }

    private RString get普通徴収の増減合計() {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 普通徴収の増減合計 = getFormat金額(tablePanel.getLblFuchoZogenValue04().getText()).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue05().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue06().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue07().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue08().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue09().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue10().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue11().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue12().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue01().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue02().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValue03().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValueYoku04().getText())).
                add(getFormat金額(tablePanel.getLblFuchoZogenValueYoku05().getText()));
        return get金額のカンマ編集(普通徴収の増減合計);
    }

    private RString get特別徴収の納付額合計() {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 特別徴収の納付額合計 = getFormat金額(tablePanel.getLblTokuchoNofugakuValue04().getText()).
                add(getFormat金額(tablePanel.getLblTokuchoNofugakuValue06().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoNofugakuValue08().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoNofugakuValue10().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoNofugakuValue12().getText())).
                add(getFormat金額(tablePanel.getLblTokuchoNofugakuValue02().getText()));
        return get金額のカンマ編集(特別徴収の納付額合計);
    }

    private RString get普通徴収の納付額合計() {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 普通徴収の納付額合計 = getFormat金額(tablePanel.getLblFuchoNofugakuValue04().getText()).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue05().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue05().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue06().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue07().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue08().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue09().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue10().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue11().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue12().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue01().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue02().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValue03().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValueYoku04().getText())).
                add(getFormat金額(tablePanel.getLblFuchoNofugakuValueYoku05().getText()));
        return get金額のカンマ編集(普通徴収の納付額合計);
    }

    /**
     * 更正前後賦課のリスト順番の降順の動作です。
     *
     * @param 更正前後賦課のリスト 更正前後賦課のリスト
     */
    public void set更正前後賦課のリスト降順(List<KoseiZengoFuka> 更正前後賦課のリスト) {
        if (更正前後賦課のリスト.isEmpty()) {
            return;
        }
        Collections.sort(更正前後賦課のリスト, new Comparator<KoseiZengoFuka>() {
            @Override
            public int compare(KoseiZengoFuka arg0, KoseiZengoFuka arg1) {
                return arg1.get通知書番号().getColumnValue().compareTo(arg0.get通知書番号().getColumnValue());
            }
        });
    }

    private void init更正年月エリア(boolean is特殊処理, FlexibleYear 賦課年度, RDate システム日付, List<KoseiZengoFuka> 更正前後賦課のリスト,
            TsuchishoNo 通知書番号, KoseiZengoChoshuHoho 更正前後徴収方法) {
        div.getTxtChoteiNendo().setValue(getパターン102(賦課年度));
        div.getTxtFukaNendo().setValue(getパターン102(賦課年度));
        div.getTxtChoteiYMD().setValue(システム日付);
        set更正月データ(システム日付);
        if (!is特殊処理) {
            div.getDdlKoseigoTsuchishoNo().setDisplayNone(false);
            div.getDdlKoseigoTsuchishoNo().setDataSource(get通知書番号データ(更正前後賦課のリスト));
            div.getDdlKoseigoTsuchishoNo().setSelectedKey(通知書番号.getColumnValue());
            boolean is翌年度4月特徴開始者 = Boolean.FALSE;

            if (更正前後徴収方法.get更正後() != null) {
                is翌年度4月特徴開始者 = !ChoshuHoho.特別徴収_厚生労働省.getコード().equals(更正前後徴収方法.get更正後().get徴収方法3月())
                        && !ChoshuHoho.特別徴収_地共済.getコード().equals(更正前後徴収方法.get更正後().get徴収方法3月())
                        && (ChoshuHoho.特別徴収_厚生労働省.getコード().equals(更正前後徴収方法.get更正後().get徴収方法4月())
                        || ChoshuHoho.特別徴収_地共済.getコード().equals(更正前後徴収方法.get更正後().get徴収方法4月()));
            }
            div.getBtnYokunendoHyoji().setVisible(is翌年度4月特徴開始者 && is翌年度の特徴依頼金額計算が処理済());
        }
    }

    private boolean is翌年度の特徴依頼金額計算が処理済() {
        TokuchoIraiJohoSakuseiJokyo 特徴依頼情報作成状況 = new TokuchoIraiJohoSakuseiJokyo();
        List<ShoriDateKanri> 処理状況リスト = 特徴依頼情報作成状況.find依頼金額計算処理状況();
        for (ShoriDateKanri shoriDateKanri : 処理状況リスト) {
            if (shoriDateKanri.get基準日時() != null && !shoriDateKanri.get基準日時().isEmpty()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private RString getパターン102(FlexibleYear date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear();
        }
        return wareki;
    }

    private void set更正月データ(RDate システム日付) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KoseiTsukiHantei 更正月判定クラス = new KoseiTsukiHantei();
        FuchoKiUtil 月期対応取得_普徴クラス = new FuchoKiUtil();
        Kitsuki 更正月 = 更正月判定クラス.find更正月(システム日付);
        Tsuki from月 = Tsuki._4月;
        Tsuki to月 = Tsuki.翌年度5月;
        if (from月.compareTo(更正月.get月()) != 0) {
            from月 = Tsuki.toValue(new RString(Month.of(更正月.get月AsInt()).minus(LONG_1).getValue()).padZeroToLeft(NUM_2));
        }
        if (to月.compareTo(更正月.get月()) != 0) {
            to月 = Tsuki.toValue(new RString(Month.of(更正月.get月AsInt()).plus(LONG_1).getValue()).padZeroToLeft(NUM_2));
        }
        KitsukiList 期月リスト = 月期対応取得_普徴クラス.get期月リスト().subListBy月(from月, to月);
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(kitsuki.get月().getコード());
            dataSource.setValue(getFormat期(kitsuki.get期()).concat(getFormat月(kitsuki.get月())));
            dataSourceList.add(dataSource);
        }
        Collections.reverse(dataSourceList);
        div.getDdlKoseiTsuki().setDataSource(dataSourceList);
        div.getDdlKoseiTsuki().setSelectedKey(更正月.get月().getコード());
    }

    private RString get月の期By月(KitsukiList 期月リスト, Tsuki 月) {
        return 期月リスト.get月の期(月).get期();
    }

    private RString getFormat期(RString num) {
        return new RString(Integer.valueOf(num.toString()).toString()).concat(期);
    }

    private RString getFormat月(Tsuki month) {
        return 左括弧.concat(new RString(Integer.valueOf(month.getコード().toString()).toString())).concat(月).concat(右括弧);
    }

    private Decimal getFormat金額(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return Decimal.ZERO;
        }
        return new Decimal(金額.replace(読点, RString.EMPTY).trim().toString());
    }

    private RString get金額のカンマ編集(Decimal 金額) {
        if (金額 == null) {
            return ZERO;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, NUM_0);
    }

    private List<KeyValueDataSource> get通知書番号データ(List<KoseiZengoFuka> 更正前後賦課のリスト) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (KoseiZengoFuka koseiZengoFuka : 更正前後賦課のリスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(koseiZengoFuka.get通知書番号().getColumnValue());
            dataSource.setValue(koseiZengoFuka.get通知書番号().getColumnValue());
            if (!dataSourceList.contains(dataSource)) {
                dataSourceList.add(dataSource);
            }
        }
        return dataSourceList;
    }

    private RString get特別徴収の納付額(FukaJoho 更正後現年度賦課, RString 月の期, Tsuki 月) {
        if (is特別徴収の納付額は空白(更正後現年度賦課.get調定日時().getDate().getYearMonth(), 更正後現年度賦課.get賦課年度(), 月)) {
            return RString.EMPTY;
        }
        ShunoManager manager = ShunoManager.createInstance();
        Long 収納ID = 更正後現年度賦課.get収納ID(Integer.valueOf(月の期.toString()));
        if (収納ID == null || manager.get収納(収納ID) == null) {
            return RString.EMPTY;
        }
        return get金額のカンマ編集(manager.get収納(収納ID).get収入合計情報().get本税());
    }

    private boolean is特別徴収の納付額は空白(RYearMonth 調定年月, FlexibleYear 年度, Tsuki 月) {
        RString コード_月 = 月.getコード();
        if (Tsuki.翌年度4月.compareTo(月) == 0
                || Tsuki.翌年度5月.compareTo(月) == 0) {
            コード_月 = コード_月.replace(ONE, ZERO);
            年度 = 年度.plusYear(NUM_1);
        }
        if (Tsuki._1月.compareTo(月) == 0
                || Tsuki._2月.compareTo(月) == 0
                || Tsuki._3月.compareTo(月) == 0) {
            年度 = 年度.plusYear(NUM_1);
        }
        RYearMonth 該当月 = new RYearMonth(年度.toDateString().concat(コード_月));
        return 該当月.compareTo(調定年月) >= 0;
    }

    private RString get普通徴収の納付額(FukaJoho 更正後現年度賦課, RString 月の期, Tsuki 月) {
        RYearMonth 調定年月 = 更正後現年度賦課.get調定日時().getDate().getYearMonth();
        if (is普通徴収の納付額は空白(更正後現年度賦課.get賦課年度(), 調定年月, 月)) {
            return RString.EMPTY;
        }
        ShunoManager manager = ShunoManager.createInstance();
        Long 収納ID = 更正後現年度賦課.get収納ID(Integer.valueOf(月の期.toString()));
        return get金額のカンマ編集(manager.get収納(収納ID).get収入合計情報().get本税());
    }

    private boolean is普通徴収の納付額は空白(FlexibleYear 年度, RYearMonth 調定年月, Tsuki 月) {
        RYearMonth 調定年月From = 調定年月.minusMonth(NUM_1);
        RYearMonth 調定年月To = new RYearMonth(調定年月.getYear().plusYear(NUM_1).toDateString().concat(三月));
        RString コード_月 = 月.getコード();
        if (Tsuki.翌年度4月.compareTo(月) == 0
                || Tsuki.翌年度5月.compareTo(月) == 0) {
            コード_月 = コード_月.replace(ONE, ZERO);
        }
        RYearMonth 該当月 = new RYearMonth(年度.toDateString().concat(コード_月));
        return 該当月.compareTo(調定年月From) < 0 || 該当月.compareTo(調定年月To) > 0;
    }

    private boolean is更正後と納期限入力不可(RYearMonth 調定年月, FlexibleYear 年度, Tsuki 月) {
        RString コード_月 = 月.getコード();
        if (Tsuki.翌年度4月.compareTo(月) == 0
                || Tsuki.翌年度5月.compareTo(月) == 0) {
            コード_月 = コード_月.replace(ONE, ZERO);
        }
        RYearMonth 該当月 = new RYearMonth(年度.toDateString().concat(コード_月));
        return 該当月.compareTo(調定年月) < 0;
    }
}
