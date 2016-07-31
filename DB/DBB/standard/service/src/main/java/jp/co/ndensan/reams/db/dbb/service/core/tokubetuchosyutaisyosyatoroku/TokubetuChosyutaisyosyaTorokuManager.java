/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokubetuchosyutaisyosyatoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoBuilder;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHosokuMonth;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoStartMonth;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV2001ChoshuHohoAliveDac;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NenkinHokenshaHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysTokuchoHosoku;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ue.uex.service.core.INenkinTokuchoKaifuJohoManager;
import jp.co.ndensan.reams.ue.uex.service.core.NenkinTokuchoKaifuJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 特別徴収対象者登録。
 *
 * @reamsid_L DBB-0670-020 wangjie2
 */
public class TokubetuChosyutaisyosyaTorokuManager {

    private final RString 空白 = RString.EMPTY;
    private final RString 連番_0001 = new RString("0001");
    private final RString 連番_0002 = new RString("0002");
    private final RString 連番_0003 = new RString("0003");
    private final RString 連番_0004 = new RString("0004");
    private final RString 連番_0005 = new RString("0005");
    private final RString 連番_0006 = new RString("0006");
    private final RString 普通徴収 = new RString("3");
    private final RString 特別徴収_厚生労働省 = new RString("1");
    private final RString 特別徴収_地共済 = new RString("2");

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンス
     */
    public static TokubetuChosyutaisyosyaTorokuManager createInstance() {
        return InstanceProvider.create(TokubetuChosyutaisyosyaTorokuManager.class);
    }

    /**
     * 徴収方法情報取得
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @return 徴収方法の情報 取得できない場合、NULLを返す
     */
    @Transaction
    public SearchResult<ChoshuHoho> getChoshuHoho(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        List<ChoshuHoho> 最新介護徴収方法情報データLst = new ArrayList<>();
        ChoshuHoho 最新介護徴収方法情報データ;
        DbV2001ChoshuHohoAliveDac dac = InstanceProvider.create(DbV2001ChoshuHohoAliveDac.class);
        DbT2001ChoshuHohoEntity 最新介護徴収方法情報データEntity = dac.select最新介護徴収方法(賦課年度, 被保険者番号);
        if (null != 最新介護徴収方法情報データEntity) {
            最新介護徴収方法情報データ = new ChoshuHoho(最新介護徴収方法情報データEntity);
        } else {
            return null;
        }
        最新介護徴収方法情報データLst.add(最新介護徴収方法情報データ);
        return SearchResult.of(最新介護徴収方法情報データLst, 0, false);
    }

    /**
     * 特徴対象者（追加含む）取得
     *
     * @param 年度 年度
     * @param 捕捉月 捕捉月
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @return 特徴の情報
     */
    public NenkinTokuchoKaifuJoho getTokuchoTaishosha(FlexibleYear 年度, RString 捕捉月, RString 基礎年金番号, RString 年金コード) {
        FlexibleYear 処理年度;
        if (null == 年度) {
            処理年度 = FlexibleYear.EMPTY;
        } else {
            if (TokuchoHosokuMonth.特徴2月捕捉.getコード().equals(捕捉月)) {
                処理年度 = 年度.minusYear(1);
            } else {
                処理年度 = 年度;
            }
        }
        if (null == 基礎年金番号) {
            基礎年金番号 = RString.EMPTY;
        }
        if (null == 年金コード) {
            年金コード = RString.EMPTY;
        }
        INenkinTokuchoKaifuJohoManager manager = new NenkinTokuchoKaifuJohoManager();
        return manager.get年金特徴対象者情報(GyomuCode.DB介護保険, 処理年度, 基礎年金番号, 年金コード, 捕捉月);
    }

    /**
     * 処理日付管理マスタデータリスト取得
     *
     * @param 賦課年度 賦課年度
     * @return 処理日付管理マスタデータリスト
     */
    @Transaction
    public SearchResult<ShoriDateKanri> getDateManagementMaster(FlexibleYear 賦課年度) {
        DbT7022ShoriDateKanriDac dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        List<DbT7022ShoriDateKanriEntity> 処理日付管理マスタデータEntiyリスト
                = dac.selectFor年度内処理済み連番(ShoriName.特徴対象者同定.get名称(), 賦課年度);
        List<ShoriDateKanri> 処理日付管理マスタデータリスト = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity 処理日付管理マスタデータEntiy : 処理日付管理マスタデータEntiyリスト) {
            処理日付管理マスタデータリスト.add(new ShoriDateKanri(処理日付管理マスタデータEntiy));
        }
        if (処理日付管理マスタデータリスト.isEmpty()) {
            return SearchResult.of(Collections.<ShoriDateKanri>emptyList(), 0, false);
        }
        return SearchResult.of(処理日付管理マスタデータリスト, 0, false);
    }

    /**
     * 年度内処理済み連番取得
     *
     * @param 賦課年度 賦課年度
     * @return 年度内処理済み連番
     */
    public RString getShorizumiRenban(FlexibleYear 賦課年度) {
        List<ShoriDateKanri> 処理日付管理マスタデータResultLst = getDateManagementMaster(賦課年度).records();
        if (処理日付管理マスタデータResultLst.isEmpty()) {
            return 空白;
        } else {
            if (!is年度内連番処理済み(連番_0001, 処理日付管理マスタデータResultLst)) {
                return 空白;
            } else if (!is年度内連番処理済み(連番_0002, 処理日付管理マスタデータResultLst)) {
                return 連番_0001;
            } else if (!is年度内連番処理済み(連番_0003, 処理日付管理マスタデータResultLst)) {
                return 連番_0002;
            } else if (!is年度内連番処理済み(連番_0004, 処理日付管理マスタデータResultLst)) {
                return 連番_0003;
            } else if (!is年度内連番処理済み(連番_0005, 処理日付管理マスタデータResultLst)) {
                return 連番_0004;
            } else if (!is年度内連番処理済み(連番_0006, 処理日付管理マスタデータResultLst)) {
                return 連番_0005;
            } else {
                return 連番_0006;
            }
        }
    }

    /**
     * 年度内連番処理済み判定
     *
     * @param 年度内連番 年度内連番
     * @param 処理日付管理マスタデータResult 処理日付管理マスタデータ
     * @return 年度内連番処理済み有無
     */
    private Boolean is年度内連番処理済み(RString 年度内連番, List<ShoriDateKanri> 処理日付管理マスタデータResultLst) {
        for (ShoriDateKanri 処理日付管理マスタデータResult : 処理日付管理マスタデータResultLst) {
            RString 処理日付管理_年度内連番 = 処理日付管理マスタデータResult.get年度内連番();
            FlexibleDate 基準年月日 = 処理日付管理マスタデータResult.get基準年月日();
            if (年度内連番.equals(処理日付管理_年度内連番) && !(null == 基準年月日) && !基準年月日.isEmpty()) {
                return true;
            }
        }
        return false;

    }

    /**
     * 登録処理
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @param 特徴義務者コード 特徴義務者コード
     */
    public void insChoshuHoho(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号, RString 基礎年金番号, RString 年金コード, RString 特徴義務者コード) {
        ChoshuHohoManager 介護徴収方法Manager = new ChoshuHohoManager();
        ChoshuHoho 介護徴収方法 = 介護徴収方法Manager.get介護徴収方法(賦課年度, 被保険者番号);
        if (null == 介護徴収方法) {
            return;
        }
        ChoshuHohoBuilder builder = 介護徴収方法.createBuilderForEdit();
        builder.set履歴番号(介護徴収方法.get履歴番号() + 1);
        RString 年度内処理済み連番 = getShorizumiRenban(賦課年度);
        if (null == 基礎年金番号 || 空白.equals(基礎年金番号)) {
            if (連番_0001.equals(年度内処理済み連番)) {
                builder.set徴収方法8月(普通徴収);
                builder.set徴収方法9月(普通徴収);
            }
            if (連番_0002.equals(年度内処理済み連番)) {
                builder.set徴収方法10月(普通徴収);
                builder.set徴収方法11月(普通徴収);
                builder.set徴収方法12月(普通徴収);
                builder.set徴収方法1月(普通徴収);
                builder.set徴収方法2月(普通徴収);
                builder.set徴収方法3月(普通徴収);
                builder.set徴収方法翌4月(普通徴収);
                builder.set徴収方法翌5月(普通徴収);
                builder.set徴収方法翌6月(普通徴収);
                builder.set徴収方法翌7月(普通徴収);
                builder.set徴収方法翌8月(普通徴収);
                builder.set徴収方法翌9月(普通徴収);
            }
            if (連番_0003.equals(年度内処理済み連番)) {
                builder.set徴収方法12月(普通徴収);
                builder.set徴収方法1月(普通徴収);
                builder.set徴収方法2月(普通徴収);
                builder.set徴収方法3月(普通徴収);
                builder.set徴収方法翌4月(普通徴収);
                builder.set徴収方法翌5月(普通徴収);
                builder.set徴収方法翌6月(普通徴収);
                builder.set徴収方法翌7月(普通徴収);
                builder.set徴収方法翌8月(普通徴収);
                builder.set徴収方法翌9月(普通徴収);
            }
            if (連番_0004.equals(年度内処理済み連番)) {
                builder.set徴収方法2月(普通徴収);
                builder.set徴収方法3月(普通徴収);
                builder.set徴収方法翌4月(普通徴収);
                builder.set徴収方法翌5月(普通徴収);
                builder.set徴収方法翌6月(普通徴収);
                builder.set徴収方法翌7月(普通徴収);
                builder.set徴収方法翌8月(普通徴収);
                builder.set徴収方法翌9月(普通徴収);
            }
            if (連番_0005.equals(年度内処理済み連番)) {
                builder.set徴収方法翌4月(普通徴収);
                builder.set徴収方法翌5月(普通徴収);
                builder.set徴収方法翌6月(普通徴収);
                builder.set徴収方法翌7月(普通徴収);
                builder.set徴収方法翌8月(普通徴収);
                builder.set徴収方法翌9月(普通徴収);
            }
            if (連番_0006.equals(年度内処理済み連番)) {
                builder.set徴収方法翌6月(普通徴収);
                builder.set徴収方法翌7月(普通徴収);
                builder.set徴収方法翌8月(普通徴収);
                builder.set徴収方法翌9月(普通徴収);
            }
        } else {
            NenkinHokenshaHantei 年金保険者判定 = NenkinHokenshaHantei.createInstance();
            RString 特徴方法 = 年金保険者判定.is厚労省(特徴義務者コード) ? 特別徴収_厚生労働省 : 特別徴収_地共済;
            if (連番_0001.equals(年度内処理済み連番)) {
                builder.set徴収方法8月(特徴方法);
                builder.set徴収方法9月(特徴方法);
                builder.set仮徴収_基礎年金番号(基礎年金番号);
                builder.set仮徴収_年金コード(年金コード);
            }
            if (連番_0002.equals(年度内処理済み連番)) {
                builder.set徴収方法10月(特徴方法);
                builder.set徴収方法11月(特徴方法);
                builder.set徴収方法12月(特徴方法);
                builder.set徴収方法1月(特徴方法);
                builder.set徴収方法2月(特徴方法);
                builder.set徴収方法3月(特徴方法);
                builder.set徴収方法翌4月(特徴方法);
                builder.set徴収方法翌5月(特徴方法);
                builder.set徴収方法翌6月(特徴方法);
                builder.set徴収方法翌7月(特徴方法);
                builder.set徴収方法翌8月(特徴方法);
                builder.set徴収方法翌9月(特徴方法);
                builder.set本徴収_基礎年金番号(基礎年金番号);
                builder.set本徴収_年金コード(年金コード);
            }
            if (連番_0003.equals(年度内処理済み連番)) {
                builder.set徴収方法12月(特徴方法);
                builder.set徴収方法1月(特徴方法);
                builder.set徴収方法2月(特徴方法);
                builder.set徴収方法3月(特徴方法);
                builder.set徴収方法翌4月(特徴方法);
                builder.set徴収方法翌5月(特徴方法);
                builder.set徴収方法翌6月(特徴方法);
                builder.set徴収方法翌7月(特徴方法);
                builder.set徴収方法翌8月(特徴方法);
                builder.set徴収方法翌9月(特徴方法);
                builder.set本徴収_基礎年金番号(基礎年金番号);
                builder.set本徴収_年金コード(年金コード);
            }
            if (連番_0004.equals(年度内処理済み連番)) {
                builder.set徴収方法2月(特徴方法);
                builder.set徴収方法3月(特徴方法);
                builder.set徴収方法翌4月(特徴方法);
                builder.set徴収方法翌5月(特徴方法);
                builder.set徴収方法翌6月(特徴方法);
                builder.set徴収方法翌7月(特徴方法);
                builder.set徴収方法翌8月(特徴方法);
                builder.set徴収方法翌9月(特徴方法);
                builder.set本徴収_基礎年金番号(基礎年金番号);
                builder.set本徴収_年金コード(年金コード);
            }
            if (連番_0005.equals(年度内処理済み連番)) {
                builder.set徴収方法翌4月(特徴方法);
                builder.set徴収方法翌5月(特徴方法);
                builder.set徴収方法翌6月(特徴方法);
                builder.set徴収方法翌7月(特徴方法);
                builder.set徴収方法翌8月(特徴方法);
                builder.set徴収方法翌9月(特徴方法);
                builder.set翌年度仮徴収_基礎年金番号(基礎年金番号);
                builder.set翌年度仮徴収_年金コード(年金コード);
            }
            if (連番_0006.equals(年度内処理済み連番)) {
                builder.set徴収方法翌6月(特徴方法);
                builder.set徴収方法翌7月(特徴方法);
                builder.set徴収方法翌8月(特徴方法);
                builder.set徴収方法翌9月(特徴方法);
                builder.set翌年度仮徴収_基礎年金番号(基礎年金番号);
                builder.set翌年度仮徴収_年金コード(年金コード);
            }
        }
        介護徴収方法Manager.save介護徴収方法(new ChoshuHoho(builder.build().toEntity()).added());
    }

    /**
     * 特徴開始月取得
     *
     * @param 捕捉月 捕捉月
     * @return 特徴開始月
     */
    public TokuchoStartMonth getTokuchoKaishibi(TokuchoHosokuMonth 捕捉月) {
        if (TokuchoHosokuMonth.特徴4月捕捉.equals(捕捉月)) {
            return TokuchoStartMonth.特徴10月開始;
        }
        if (TokuchoHosokuMonth.特徴6月捕捉.equals(捕捉月)) {
            RString result = DbBusinessConfig.get(ConfigKeysTokuchoHosoku.特別徴収_特徴開始月_6月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (new RString("12").equals(result)) {
                return TokuchoStartMonth.特徴12月開始;
            }
            if (new RString("04").equals(result)) {
                return TokuchoStartMonth.特徴4月開始;
            }
        }
        if (TokuchoHosokuMonth.特徴8月捕捉.equals(捕捉月)) {
            RString result = DbBusinessConfig.get(ConfigKeysTokuchoHosoku.特別徴収_特徴開始月_8月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (new RString("02").equals(result)) {
                return TokuchoStartMonth.特徴2月開始;
            }
            if (new RString("04").equals(result)) {
                return TokuchoStartMonth.特徴4月開始;
            }

        }
        if (TokuchoHosokuMonth.特徴10月捕捉.equals(捕捉月)) {
            return TokuchoStartMonth.特徴4月開始;
        }
        if (TokuchoHosokuMonth.特徴12月捕捉.equals(捕捉月)) {
            return TokuchoStartMonth.特徴6月開始;
        }
        if (TokuchoHosokuMonth.特徴2月捕捉.equals(捕捉月)) {
            return TokuchoStartMonth.特徴8月開始;
        }
        return null;
    }

    /**
     * 資格喪失フラグ取得
     *
     * @param 被保険者番号 被保険者番号
     * @return 資格喪失フラグ
     */
    public boolean getHihokenshaFlag(HihokenshaNo 被保険者番号) {
        List<HihokenshaDaicho> 被保険者台帳情報データResult = getInsuredRegisterInformation(被保険者番号).records();
        HihokenshaDaicho 被保険者台帳情報データ
                = 被保険者台帳情報データResult.isEmpty()
                ? null : 被保険者台帳情報データResult.get(0);
        return null == 被保険者台帳情報データ;

    }

    /**
     * 被保険者台帳情報データリスト取得
     *
     * @param 被保険者番号 被保険者番号
     * @return 被保険者台帳情報データリスト
     */
    @Transaction
    public SearchResult<HihokenshaDaicho> getInsuredRegisterInformation(HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoDac dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        DbT1001HihokenshaDaichoEntity 被保険者台帳情報データEntity
                = dac.selectFor資格喪失フラグ(被保険者番号, ShikakuKubun._１号.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<HihokenshaDaicho> 被保険者台帳情報データリスト = new ArrayList<>();
        if (null == 被保険者台帳情報データEntity) {
            return SearchResult.of(Collections.<HihokenshaDaicho>emptyList(), 0, false);
        } else {
            被保険者台帳情報データリスト.add(new HihokenshaDaicho(被保険者台帳情報データEntity));
            return SearchResult.of(被保険者台帳情報データリスト, 0, false);
        }
    }

    /**
     * 依頼金額計算基準日取得
     *
     * @param 年度 年度
     * @param 処理名 処理名
     * @param 年度内連番 年度内連番
     * @return 基準年月日 データがない場合、NULLを返却
     */
    public FlexibleDate getIraikinKijunbi(FlexibleYear 年度, ShoriName 処理名, RString 年度内連番) {
        List<ShoriDateKanri> 処理日付管理マスタデータLst = getInsuredRegisterInformation(年度, 処理名, 年度内連番).records();
        if (処理日付管理マスタデータLst.isEmpty()) {
            return null;
        }
        return 処理日付管理マスタデータLst.get(0).get基準年月日();
    }

    /**
     * 処理日付管理マスタデータリスト取得
     *
     * @param 年度 年度
     * @param 処理名 処理名
     * @param 年度内連番 年度内連番
     * @return 処理日付管理マスタデータリスト
     */
    @Transaction
    public SearchResult<ShoriDateKanri> getInsuredRegisterInformation(FlexibleYear 年度, ShoriName 処理名, RString 年度内連番) {
        DbT7022ShoriDateKanriDac dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        List<DbT7022ShoriDateKanriEntity> 処理日付管理マスタデータEntityLst
                = dac.selectFor依頼金額計算基準日取得(SubGyomuCode.DBB介護賦課, 処理名.get名称(), 年度, 年度内連番);
        List<ShoriDateKanri> 処理日付管理マスタデータLst = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity 処理日付管理マスタデータEntity : 処理日付管理マスタデータEntityLst) {
            処理日付管理マスタデータLst.add(new ShoriDateKanri(処理日付管理マスタデータEntity));
        }
        if (処理日付管理マスタデータLst.isEmpty()) {
            return SearchResult.of(Collections.<ShoriDateKanri>emptyList(), 0, false);
        }
        return SearchResult.of(処理日付管理マスタデータLst, 0, false);
    }
}
