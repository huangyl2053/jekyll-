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
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHosokuMonth;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoStartMonth;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetuchosyutaisyosyatoroku.TokubetuChosyutaisyosyaTorokusqlparamEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokubetuchosyutaisyosyatoroku.ITokubetuChosyutaisyosyaTorokuMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysTokuchoHosoku;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
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

    private final MapperProvider mapperProvider;
    private final TokubetuChosyutaisyosyaTorokusqlparamEntity sqlparams;
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
     * コンストラクタです。
     */
    public TokubetuChosyutaisyosyaTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.sqlparams = new TokubetuChosyutaisyosyaTorokusqlparamEntity();
    }

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
        ITokubetuChosyutaisyosyaTorokuMapper mapper = mapperProvider.create(ITokubetuChosyutaisyosyaTorokuMapper.class);
        List<ChoshuHoho> 最新介護徴収方法情報データLst = new ArrayList<>();
        sqlparams.set被保険者番号(被保険者番号);
        sqlparams.set賦課年度(賦課年度);
        ChoshuHoho 最新介護徴収方法情報データ;
        DbT2001ChoshuHohoEntity 最新介護徴収方法情報データEntity = mapper.getChoshuHoho(sqlparams);
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
     */
    //TODO
    public void getTokuchoTaishosha() {

    }

    /**
     * 処理日付管理マスタデータリスト取得
     *
     * @param 賦課年度 賦課年度
     * @return 処理日付管理マスタデータリスト
     */
    @Transaction
    public SearchResult<ShoriDateKanri> getDateManagementMaster(FlexibleYear 賦課年度) {
        ITokubetuChosyutaisyosyaTorokuMapper mapper = mapperProvider.create(ITokubetuChosyutaisyosyaTorokuMapper.class);
        sqlparams.set賦課年度(賦課年度);
        sqlparams.set処理名(ShoriName.特徴対象者同定);
        List<DbT7022ShoriDateKanriEntity> 処理日付管理マスタデータEntiyリスト = mapper.getShorizumiRenban(sqlparams);
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
     * @return 登録件数
     */
    public int insChoshuHoho(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号, RString 基礎年金番号, RString 年金コード) {
        SearchResult<ChoshuHoho> choshuHohoSearchResult = getChoshuHoho(賦課年度, 被保険者番号);
        if (null == choshuHohoSearchResult) {
            return 0;
        }
        ChoshuHoho 最新介護徴収方法情報データ = getChoshuHoho(賦課年度, 被保険者番号).records().get(0);
        DbT2001ChoshuHohoEntity dbT2001ChoshuHohoEntity = 最新介護徴収方法情報データ.toEntity();
        dbT2001ChoshuHohoEntity.setRirekiNo(dbT2001ChoshuHohoEntity.getRirekiNo() + 1);
        RString 年度内処理済み連番 = getShorizumiRenban(賦課年度);
        if (null == 基礎年金番号 || 空白.equals(基礎年金番号)) {
            if (連番_0001.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho8gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho9gatsu(普通徴収);
            }
            if (連番_0002.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho12gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho10gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho11gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho1gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho2gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho3gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(普通徴収);
            }
            if (連番_0003.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho12gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho1gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho2gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho3gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(普通徴収);
            }
            if (連番_0004.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho2gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHoho3gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(普通徴収);
            }
            if (連番_0005.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(普通徴収);
            }
            if (連番_0006.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(普通徴収);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(普通徴収);
            }
        } else {
            //TODO 介護賦課共通クラスの年金保険者判定．is厚労省（特徴義務者コード）来月
            RString 特徴方法 = true ? 特別徴収_厚生労働省 : 特別徴収_地共済;
            if (連番_0001.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho8gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho9gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setKariNenkinNo(基礎年金番号);
                dbT2001ChoshuHohoEntity.setKariNenkinCode(年金コード);
            }
            if (連番_0002.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho12gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho10gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho11gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho1gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho2gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho3gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setHonNenkinNo(基礎年金番号);
                dbT2001ChoshuHohoEntity.setHonNenkinCode(年金コード);
            }
            if (連番_0003.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho12gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho1gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho2gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho3gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setHonNenkinNo(基礎年金番号);
                dbT2001ChoshuHohoEntity.setHonNenkinCode(年金コード);
            }
            if (連番_0004.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHoho2gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHoho3gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setHonNenkinNo(基礎年金番号);
                dbT2001ChoshuHohoEntity.setHonNenkinCode(年金コード);
            }
            if (連番_0005.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku4gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku5gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setYokunendoKariNenkinNo(基礎年金番号);
                dbT2001ChoshuHohoEntity.setYokunendoKariNenkinCode(年金コード);
            }
            if (連番_0006.equals(年度内処理済み連番)) {
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku6gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku7gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku8gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setChoshuHohoYoku9gatsu(特徴方法);
                dbT2001ChoshuHohoEntity.setYokunendoKariNenkinNo(基礎年金番号);
                dbT2001ChoshuHohoEntity.setYokunendoKariNenkinCode(年金コード);
            }
        }
        DbT2001ChoshuHohoDac dbT2001ChoshuHohoDac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        return dbT2001ChoshuHohoDac.save(dbT2001ChoshuHohoEntity);
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
        ITokubetuChosyutaisyosyaTorokuMapper mapper = mapperProvider.create(ITokubetuChosyutaisyosyaTorokuMapper.class);
        sqlparams.set被保険者番号(被保険者番号);
        sqlparams.set資格区分(ShikakuKubun._１号.getコード());
        DbT1001HihokenshaDaichoEntity 被保険者台帳情報データEntity = mapper.getHihokenshaFlag(sqlparams);
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
        ITokubetuChosyutaisyosyaTorokuMapper mapper = mapperProvider.create(ITokubetuChosyutaisyosyaTorokuMapper.class);
        sqlparams.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        sqlparams.set処理名(処理名);
        sqlparams.set年度(年度);
        sqlparams.set年度内連番(年度内連番);
        List<DbT7022ShoriDateKanriEntity> 処理日付管理マスタデータEntityLst = mapper.getIraikinKijunbi(sqlparams);
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
