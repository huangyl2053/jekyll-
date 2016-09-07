/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710001;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.KonkaiShoriNaiyoJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.ShoriDateKanriResult;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.ShoriJokyoJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoteishitaisyosyadoutei.TokuchoTeishiTaisyosyaDouteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.KonkaiShoriNaiyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.TokuchoDoteiShoriDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001.dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoteishitaisyosyadoutei.TokuchoTeishiTaisyosyaDoutei;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.config.ConfigKeysHizuke;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBBGM81002_1_特徴対象者同定（一括）のハンドラクラス
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public final class TokuchoDoteiShoriHandler {

    private final TokuchoDoteiShoriDiv div;
    private static final RString モード_単一保険者 = new RString("1");
    private static final RString モード_広域保険者 = new RString("2");
    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 実行する_単一市町村 = new RString("btnBatchRegister");
    private static final RString 実行する_広域保険者 = new RString("btnBatchRegi");
    private static final RString 漢字_処理なし = new RString("処理なし");
    private static final RString 対応状況_未対応 = new RString("未");
    private static final RString 対応状況_対応済 = new RString("済");
    private static final int 月字数 = 2;
    private static final int BEGIN = 4;
    private static final int END = 6;

    /**
     * コンストラクタ
     *
     * @param div
     */
    private TokuchoDoteiShoriHandler(TokuchoDoteiShoriDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static TokuchoDoteiShoriHandler of(TokuchoDoteiShoriDiv div) {
        return new TokuchoDoteiShoriHandler(div);
    }

    /**
     * 画面初期化処理です。
     *
     * @return Entry<RString, Boolean>
     */
    public Entry<RString, Boolean> onload() {
        return do初期値取得();
    }

    private Entry<RString, Boolean> do初期値取得() {
        ShichosonSecurityJoho joho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 保険者モード = モード_単一保険者;
        boolean can実行 = false;
        if (null != joho && null != joho.get導入形態コード()) {
            RString 導入形態コード = joho.get導入形態コード().getColumnValue();
            if (導入形態コード.equals(導入形態コード_112) || 導入形態コード.equals(導入形態コード_120)) {
                保険者モード = モード_単一保険者;
            } else if (導入形態コード.equals(導入形態コード_111)) {
                保険者モード = モード_広域保険者;
            }
        } else {
            return new SimpleEntry<>(保険者モード, false);
        }
        FlexibleYear 日付関連_調定年度 = new FlexibleYear(DbBusinessConfig.get(
                ConfigKeysHizuke.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        TokuchoTeishiTaisyosyaDoutei tokuchoTeishiTaisyosyaDoutei = TokuchoTeishiTaisyosyaDoutei.createInstance();
        List<ShoriDateKanriResult> 特徴対象者同定情報リスト = tokuchoTeishiTaisyosyaDoutei.getTokuchoTaishoJoho(日付関連_調定年度, 保険者モード);
        if (null == 特徴対象者同定情報リスト || 特徴対象者同定情報リスト.isEmpty()) {
            can実行 = false;
        } else {
            for (ShoriDateKanriResult 特徴対象者同定情報 : 特徴対象者同定情報リスト) {
                if (null == 特徴対象者同定情報.get基準年月日()
                        || FlexibleDate.EMPTY.equals(特徴対象者同定情報.get基準年月日())) {
                    can実行 = true;
                    break;
                }
            }
        }
        KonkaiShoriNaiyoJohoResult 今回処理内容情報 = tokuchoTeishiTaisyosyaDoutei.getKonkaiShoriNaiyoJoho(日付関連_調定年度, 保険者モード);
        if (null != 今回処理内容情報 && !RString.isNullOrEmpty(今回処理内容情報.get対象者情報取得月())) {
            List<ShoriJokyoJohoResult> 処理状況一覧情報 = tokuchoTeishiTaisyosyaDoutei.getShoriJokyoList(
                    日付関連_調定年度, 今回処理内容情報.get対象者情報取得月().substringReturnAsPossible(BEGIN, END), 保険者モード);
            if (処理状況一覧情報.isEmpty()) {
                can実行 = false;
            }
            do画面表示(保険者モード, 今回処理内容情報, 処理状況一覧情報);
        } else {
            can実行 = false;
        }
        return new SimpleEntry<>(保険者モード, can実行);
    }

    /**
     * 「実行する」ボタンの活性状態。
     *
     * @param state RString
     * @param can実行 boolean
     */
    public void set実行ボタン(RString state, boolean can実行) {
        if (モード_単一保険者.equals(state)) {
            if (can実行) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_単一市町村, false);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_単一市町村, true);
            }
        } else {
            if (can実行) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_広域保険者, false);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_広域保険者, true);
            }
        }
    }

    private void do画面表示(RString 保険者モード, KonkaiShoriNaiyoJohoResult 今回処理内容情報, List<ShoriJokyoJohoResult> 処理状況一覧情報) {
        KonkaiShoriNaiyoDiv konkaiShoriNaiyoDiv = div.getKonkaiShoriNaiyo();
        konkaiShoriNaiyoDiv.getTxtShutokuM().setValue(new RDate(今回処理内容情報.get対象者情報取得月().toString()));
        konkaiShoriNaiyoDiv.getTxtHosokuM1().setValue(new RDate(今回処理内容情報.get捕捉月１().toString()));
        if (!RString.isNullOrEmpty(今回処理内容情報.get捕捉月２())) {
            konkaiShoriNaiyoDiv.getTxtHosokuM2().setValue(今回処理内容情報.get捕捉月２());
        } else {
            konkaiShoriNaiyoDiv.getTxtHosokuM2().setDisplayNone(true);
        }
        if (!RString.isNullOrEmpty(今回処理内容情報.get捕捉月３())) {
            konkaiShoriNaiyoDiv.getTxtHosokuM3().setValue(今回処理内容情報.get捕捉月３());
        } else {
            konkaiShoriNaiyoDiv.getTxtHosokuM3().setDisplayNone(true);
        }

        if (RString.isNullOrEmpty(今回処理内容情報.get特別徴収開始月())) {
            konkaiShoriNaiyoDiv.getTxtKaishiM().setPlaceHolder(漢字_処理なし);
        } else {
            konkaiShoriNaiyoDiv.getTxtKaishiM().setValue(new RDate(今回処理内容情報.get特別徴収開始月().toString()));
        }
        List<dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row> tanitsuList = new ArrayList<>();
        List<dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row> koikiList = new ArrayList<>();

        for (ShoriJokyoJohoResult 処理状況情報 : 処理状況一覧情報) {
            RString 状況 = get状況(処理状況情報.get基準日時());
            RString 処理日時 = get処理日時(処理状況情報.get基準日時());
            if (モード_単一保険者.equals(保険者モード)) {
                dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row row = new dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row();
                row.getTxtJokyo().setValue(状況);
                row.getTxtShoriMei().setValue(RString.isNullOrEmpty(処理状況情報.get処理名()) ? RString.EMPTY : 処理状況情報.get処理名());
                row.getTxtShoriNichiji().setValue(処理日時);
                tanitsuList.add(row);
            } else {
                dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row row = new dgTokuchoTaishoshaDoteiShoriKakuninKoiki_Row();
                row.getTxtShichosonCode().setValue(処理状況情報.get市町村コード().getColumnValue());
                row.getTxtShichosonMei().setValue(処理状況情報.get市町村名称());
                row.getTxtJokyo().setValue(状況);
                row.getTxtShoriMei().setValue(RString.isNullOrEmpty(処理状況情報.get処理名()) ? RString.EMPTY : 処理状況情報.get処理名());
                row.getTxtShoriNichiji().setValue(処理日時);
                koikiList.add(row);
            }
            div.getDgTokuchoTaishoshaDoteiShoriKakuninKoiki().setDataSource(koikiList);
            div.getDgTokuchoTaishoshaDoteiShoriKakuninTanitsu().setDataSource(tanitsuList);
        }

    }

    private RString get状況(YMDHMS 基準日時) {
        return (null == 基準日時) ? 対応状況_未対応 : 対応状況_対応済;
    }

    private RString get処理日時(YMDHMS 基準日時) {
        if (null != 基準日時) {
            RString 帳票作成年月日 = 基準日時.getRDateTime().getDate().wareki().toDateString();
            RString 帳票作成時 = 基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
            return 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時);
        }
        return RString.EMPTY;
    }

    /**
     * 「実行」ボタンを押下して、バッチパラメータを設定します。
     *
     * @return TokuchoTeishiTaisyosyaDouteiBatchParameter
     */
    public TokuchoTeishiTaisyosyaDouteiBatchParameter doバッチパラメータの設定() {
        TokuchoTeishiTaisyosyaDoutei tokuchoTeishiTaisyosyaDoutei = TokuchoTeishiTaisyosyaDoutei.createInstance();
        int 捕捉月1 = div.getTxtHosokuM1().getValue().getMonthValue();
        List<RString> 捕捉月 = new ArrayList<>();
        捕捉月.add(new RString(捕捉月1).padZeroToLeft(月字数));
        捕捉月.add(div.getTxtHosokuM2().getValue());
        捕捉月.add(div.getTxtHosokuM3().getValue());

        RString 開始月str;
        if (null == div.getTxtKaishiM().getValue()) {
            開始月str = RString.EMPTY;
        } else {
            int 開始月 = div.getTxtKaishiM().getValue().getMonthValue();
            開始月str = new RString(開始月).padZeroToLeft(月字数);
        }
        return tokuchoTeishiTaisyosyaDoutei.getBatchiPara(捕捉月, 開始月str);
    }

}
