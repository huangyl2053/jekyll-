/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishoshaichiransakusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchomidoteijoho.TokuchoMidoteiJoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchomidoteijoho.TokuchoMidoteiJohoIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiKouhoshaListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiKouhoshaShousaiJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoMiDouteiListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2019TokuchoMidoteiJohoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshaichiransakusei.ITokuchoTaishoshaIchiranSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NenkinHokenshaHantei;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV2001ChoshuHohoAliveDac;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ue.uex.service.core.NenkinTokuchoKaifuJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
public class TokuchoTaishoshaIchiranSakusei {

    private final DbV2001ChoshuHohoAliveDac 徴収方法NewestDac;
    private final DbT2001ChoshuHohoDac 徴収方法Dac;
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタDac;
    private final DbT2019TokuchoMidoteiJohoDac 特徴未同定情報Dac;
    private final MapperProvider mapperProvider;
    private ITokuchoTaishoshaIchiranSakuseiMapper mapper;
    private static final RString 年度内連番_0001 = new RString("0001");
    private static final RString 年度内連番_0002 = new RString("0002");
    private static final RString 年度内連番_0003 = new RString("0003");
    private static final RString 年度内連番_0004 = new RString("0004");
    private static final RString 年度内連番_0005 = new RString("0005");
    private static final RString 年度内連番_0006 = new RString("0006");
    private static final RString 確認状況区分_未同定 = new RString("0");
    private static final RString 確認状況区分_同定済み = new RString("1");
    private static final RString 確認状況区分_対象外 = new RString("2");
    private static final RString STR00 = new RString("00");
    private static final RString STR02 = new RString("02");
    private static final RString STR04 = new RString("04");
    private static final RString STR06 = new RString("06");
    private static final RString STR08 = new RString("08");
    private static final RString STR10 = new RString("10");
    private static final RString STR12 = new RString("12");
    private static final RString 捕捉_2月 = new RString("2月捕捉");
    private static final RString 捕捉_4月 = new RString("4月捕捉");
    private static final RString 捕捉_6月 = new RString("6月捕捉");
    private static final RString 捕捉_8月 = new RString("8月捕捉");
    private static final RString 捕捉_10月 = new RString("10月捕捉");
    private static final RString 捕捉_12月 = new RString("12月捕捉");
    private static final RString 捕捉_6月_8月_10月 = new RString("6月、8月、10月捕捉");
    private static final RString 開始月_8月 = new RString("08");
    private static final RString 開始月_10月 = new RString("10");
    private static final RString 開始月_12月 = new RString("12");
    private static final RString 開始月_2月 = new RString("02");
    private static final RString 開始月_翌4月 = new RString("04");
    private static final RString 開始月_翌6月 = new RString("06");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;

    /**
     * コンストラクタです。
     */
    public TokuchoTaishoshaIchiranSakusei() {
        特徴未同定情報Dac = InstanceProvider.create(DbT2019TokuchoMidoteiJohoDac.class);
        徴収方法NewestDac = InstanceProvider.create(DbV2001ChoshuHohoAliveDac.class);
        徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        処理日付管理マスタDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 特徴未同定情報Dac DbT2019TokuchoMidoteiJohoDac
     * @param 徴収方法NewestDac DbV2001ChoshuHohoAliveDac
     * @param 徴収方法Dac DbT2001ChoshuHohoDac
     * @param 処理日付管理マスタDac DbT7022ShoriDateKanriDac
     * @param mapperProvider MapperProvider
     */
    public TokuchoTaishoshaIchiranSakusei(DbT2019TokuchoMidoteiJohoDac 特徴未同定情報Dac,
            DbV2001ChoshuHohoAliveDac 徴収方法NewestDac,
            DbT2001ChoshuHohoDac 徴収方法Dac, DbT7022ShoriDateKanriDac 処理日付管理マスタDac,
            MapperProvider mapperProvider) {
        this.特徴未同定情報Dac = 特徴未同定情報Dac;
        this.徴収方法NewestDac = 徴収方法NewestDac;
        this.徴収方法Dac = 徴収方法Dac;
        this.処理日付管理マスタDac = 処理日付管理マスタDac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * 初期化メソッドです。
     *
     * @return TokuchoTaishoshaIchiranSakusei
     */
    public static TokuchoTaishoshaIchiranSakusei createInstance() {
        return InstanceProvider.create(TokuchoTaishoshaIchiranSakusei.class);
    }

    /**
     * 今回処理内容情報を取得する.
     *
     * @param 調定年度 FlexibleYear
     * @return TokuchoTaishoshaIchiranSakuseiResult
     */
    public TokuchoTaishoshaIchiranSakuseiResult getKonkaiShoriJoho(FlexibleYear 調定年度) {
        if (調定年度 == null) {
            return null;
        }
        RDate nowDate = RDate.getNowDate();
        RString 処理名 = ShoriName.特徴対象者同定.get名称();
        DbT7022ShoriDateKanriEntity entity = 処理日付管理マスタDac.selectMaxNendoNaiRenbanByKey(処理名,
                SubGyomuCode.DBB介護賦課, 調定年度);
        if (entity == null) {
            return null;
        }
        TokuchoTaishoshaIchiranSakuseiResult result = new TokuchoTaishoshaIchiranSakuseiResult();
        if (年度内連番_0001.equals(entity.getNendoNaiRenban())) {
            RString 特徴開始月_2月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_2月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            result.set捕捉月１(調定年度.toDateString().concat(STR02));
            result.set捕捉月表示内容(捕捉_2月);
            if (STR06.equals(特徴開始月_2月捕捉)) {
                result.set特別徴収開始月(調定年度.toDateString().concat(STR08));
            }
        } else if (年度内連番_0002.equals(entity.getNendoNaiRenban())) {
            RString 特徴開始月_4月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_4月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            result.set捕捉月１(調定年度.toDateString().concat(STR04));
            result.set捕捉月表示内容(捕捉_4月);
            if (STR10.equals(特徴開始月_4月捕捉)) {
                result.set特別徴収開始月(調定年度.toDateString().concat(STR10));
            }
        } else if (年度内連番_0003.equals(entity.getNendoNaiRenban())) {
            RString 特徴開始月_6月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            result.set捕捉月１(調定年度.toDateString().concat(STR06));
            result.set捕捉月表示内容(捕捉_6月);
            if (STR12.equals(特徴開始月_6月捕捉)) {
                result.set特別徴収開始月(調定年度.toDateString().concat(STR12));
            } else if (STR04.equals(特徴開始月_6月捕捉)) {
                result.set捕捉月２(調定年度.toDateString().concat(STR08));
                result.set捕捉月３(調定年度.toDateString().concat(STR10));
                result.set捕捉月表示内容(捕捉_6月_8月_10月);
                result.set特別徴収開始月(調定年度.plusYear(NUM1).toDateString().concat(STR04));
            }
        } else if (年度内連番_0004.equals(entity.getNendoNaiRenban())) {
            RString 特徴開始月_8月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            result.set捕捉月１(調定年度.toDateString().concat(STR08));
            result.set捕捉月表示内容(捕捉_8月);
            if (STR02.equals(特徴開始月_8月捕捉)) {
                result.set特別徴収開始月(調定年度.plusYear(NUM1).toDateString().concat(STR02));
            } else if (STR04.equals(特徴開始月_8月捕捉)) {
                result.set捕捉月１(調定年度.toDateString().concat(STR06));
                result.set捕捉月２(調定年度.toDateString().concat(STR08));
                result.set捕捉月３(調定年度.toDateString().concat(STR10));
                result.set捕捉月表示内容(捕捉_6月_8月_10月);
                result.set特別徴収開始月(調定年度.plusYear(NUM1).toDateString().concat(STR04));
            }
        } else if (年度内連番_0005.equals(entity.getNendoNaiRenban())) {
            RString 特徴開始月_6月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            RString 特徴開始月_10月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_10月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            dealWhen年度内連番_0005(result, 調定年度, 特徴開始月_6月捕捉, 特徴開始月_10月捕捉);
        } else if (年度内連番_0006.equals(entity.getNendoNaiRenban())) {
            RString 特徴開始月_10月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_10月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            RString 特徴開始月_12月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_12月捕捉, nowDate,
                    SubGyomuCode.DBB介護賦課);
            if (STR00.equals(特徴開始月_12月捕捉)) {
                result.set捕捉月１(調定年度.toDateString().concat(STR12));
                result.set捕捉月表示内容(捕捉_12月);
            } else if (STR04.equals(特徴開始月_10月捕捉)) {
                result.set捕捉月１(調定年度.toDateString().concat(STR12));
                result.set捕捉月表示内容(捕捉_12月);
                result.set特別徴収開始月(調定年度.plusYear(NUM1).toDateString().concat(STR06));
            }
        }
        return result;
    }

    private void dealWhen年度内連番_0005(TokuchoTaishoshaIchiranSakuseiResult result, FlexibleYear 調定年度,
            RString 特徴開始月_6月捕捉, RString 特徴開始月_10月捕捉) {
        if (STR00.equals(特徴開始月_10月捕捉)) {
            result.set捕捉月１(調定年度.toDateString().concat(STR10));
            result.set捕捉月表示内容(捕捉_10月);
        } else if (STR04.equals(特徴開始月_10月捕捉) && STR04.equals(特徴開始月_6月捕捉)) {
            result.set捕捉月１(調定年度.toDateString().concat(STR06));
            result.set捕捉月２(調定年度.toDateString().concat(STR08));
            result.set捕捉月３(調定年度.toDateString().concat(STR10));
            result.set捕捉月表示内容(捕捉_6月_8月_10月);
            result.set特別徴収開始月(調定年度.plusYear(NUM1).toDateString().concat(STR04));
        } else if (STR04.equals(特徴開始月_10月捕捉) && !STR04.equals(特徴開始月_6月捕捉)) {
            result.set捕捉月１(調定年度.toDateString().concat(STR10));
            result.set捕捉月表示内容(捕捉_10月);
            result.set特別徴収開始月(調定年度.plusYear(NUM1).toDateString().concat(STR04));
        }
    }

    /**
     * 特別徴収同定一覧情報を取得する.
     *
     * @param 処理年度 FlexibleYear
     * @param 開始月 RString
     * @param 捕捉月リスト List<RString>
     * @return List<TokuchoDouteiListJoho>
     */
    public List<TokuchoDouteiListJoho> getTokuchoTaishoListJoho(FlexibleYear 処理年度, RString 開始月,
            List<RString> 捕捉月リスト) {
        if (処理年度 == null || 捕捉月リスト == null || 捕捉月リスト.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        RString 特別徴収情報;
        if (STR08.compareTo(開始月) == NUM0 || STR12.compareTo(開始月) == NUM0 || STR02.compareTo(開始月) == NUM0
                || STR04.compareTo(開始月) == NUM0 || STR06.compareTo(開始月) == NUM0) {
            特別徴収情報 = TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード();
        } else if (STR10.compareTo(開始月) == NUM0) {
            特別徴収情報 = TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード();
        } else {
            return Collections.EMPTY_LIST;
        }
        TokuchoTaishoshaIchiranSakuseiMybatisParameter param = new TokuchoTaishoshaIchiranSakuseiMybatisParameter();
        param.set処理年度(処理年度);
        param.set開始月(開始月);
        param.set捕捉月リスト(捕捉月リスト);
        param.set通知内容コード(特別徴収情報);
        param.set業務コード(GyomuCode.DB介護保険);
        mapper = mapperProvider.create(ITokuchoTaishoshaIchiranSakuseiMapper.class);
        List<TokuchoTaishoshaIchiranSakuseiEntity> resultEntityList = mapper.select特別徴収同定一覧(param);
        if (resultEntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<TokuchoDouteiListJoho> 同定一覧情報リスト = new ArrayList();
        for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
            TokuchoDouteiListJoho result = new TokuchoDouteiListJoho(entity);
            同定一覧情報リスト.add(result);
        }
        return 同定一覧情報リスト;
    }

    /**
     * 特別徴収未同定一覧情報を取得する.
     *
     * @param 処理年度 FlexibleYear
     * @param 開始月 RString
     * @param 捕捉月リスト List<RString>
     * @param 確認状況区分 RString
     * @return List<TokuchoMiDouteiListJoho>
     */
    public List<TokuchoMiDouteiListJoho> getTokuchoMiTaishoListJoho(FlexibleYear 処理年度, RString 開始月,
            List<RString> 捕捉月リスト, boolean 確認状況区分) {
        if (捕捉月リスト == null) {
            捕捉月リスト = new ArrayList();
        }
        TokuchoTaishoshaIchiranSakuseiMybatisParameter param = new TokuchoTaishoshaIchiranSakuseiMybatisParameter();
        param.set処理年度(処理年度);
        param.set捕捉月リスト(捕捉月リスト);
        param.set業務コード(GyomuCode.DB介護保険);
        if (STR10.compareTo(開始月) == NUM0) {
            param.set通知内容コード(TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード());
        } else {
            param.set通知内容コード(TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード());
        }
        List<RString> 確認状況区分リスト = new ArrayList();
        if (確認状況区分) {
            確認状況区分リスト.add(確認状況区分_未同定);
            確認状況区分リスト.add(確認状況区分_対象外);
        } else {
            確認状況区分リスト.add(確認状況区分_未同定);
        }
        param.set確認状況区分リスト(確認状況区分リスト);
        mapper = mapperProvider.create(ITokuchoTaishoshaIchiranSakuseiMapper.class);
        List<TokuchoTaishoshaIchiranSakuseiEntity> resultEntityList = mapper.select特別徴収未同定一覧(param);
        if (resultEntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<TokuchoMiDouteiListJoho> 未同定一覧情報リスト = new ArrayList();
        for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
            TokuchoMiDouteiListJoho result = new TokuchoMiDouteiListJoho(entity);
            未同定一覧情報リスト.add(result);
        }
        return 未同定一覧情報リスト;
    }

    /**
     * 特別徴収同定候補者一覧情報を取得する.
     *
     * @param 処理年度 FlexibleYear
     * @param 捕捉月 RString
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @param 特徴開始月 RString
     * @return List<TokuchoDouteiKouhoshaListJoho>
     */
    public List<TokuchoDouteiKouhoshaListJoho> getTokuchoTaishoKouhosyaListJoho(FlexibleYear 処理年度, RString 捕捉月,
            RString 基礎年金番号, RString 年金コード, RString 特徴開始月) {
        TokuchoTaishoshaIchiranSakuseiMybatisParameter param = new TokuchoTaishoshaIchiranSakuseiMybatisParameter();
        param.set処理年度(処理年度);
        param.set基礎年金番号(基礎年金番号);
        param.set年金コード(年金コード);
        param.set捕捉月(捕捉月);
        param.set業務コード(GyomuCode.DB介護保険);
        mapper = mapperProvider.create(ITokuchoTaishoshaIchiranSakuseiMapper.class);
        List<TokuchoTaishoshaIchiranSakuseiEntity> resultEntityList = mapper.select特別徴収同定候補者一覧(param);
        if (resultEntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<TokuchoMidoteiJoho> tokuchoMidoteiJohos = new ArrayList<>();
        List<TokuchoDouteiKouhoshaListJoho> 同定候補者一覧情報リス = new ArrayList();
        for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
            tokuchoMidoteiJohos.add(new TokuchoMidoteiJoho(entity.getDbt2019entity()));
            TokuchoDouteiKouhoshaListJoho result = new TokuchoDouteiKouhoshaListJoho(entity);
            同定候補者一覧情報リス.add(result);
        }
        Map<TokuchoMidoteiJohoIdentifier, List<DbT2019TokuchoMidoteiJohoEntity>> 対象外Map;
        ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者リスト,
                (ArrayList<TokuchoMidoteiJoho>) tokuchoMidoteiJohos);
        if (tokuchoMidoteiJohos.size() == 1) {
            ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者, tokuchoMidoteiJohos.get(NUM0));
        }
        対象外Map = get対象外Map(tokuchoMidoteiJohos);
        ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者対象外,
                (HashMap<TokuchoMidoteiJohoIdentifier, List<DbT2019TokuchoMidoteiJohoEntity>>) 対象外Map);
        return 同定候補者一覧情報リス;
    }

    private Map<TokuchoMidoteiJohoIdentifier, List<DbT2019TokuchoMidoteiJohoEntity>> get対象外Map(
            List<TokuchoMidoteiJoho> tokuchoMidoteiJohos) {
        if (tokuchoMidoteiJohos == null || tokuchoMidoteiJohos.isEmpty()) {
            return null;
        }
        Map<TokuchoMidoteiJohoIdentifier, List<DbT2019TokuchoMidoteiJohoEntity>> 対象外Map = new HashMap<>();
        for (TokuchoMidoteiJoho model : tokuchoMidoteiJohos) {
            if (model == null) {
                continue;
            }
            TokuchoMidoteiJohoIdentifier id = model.identifier();
            List<DbT2019TokuchoMidoteiJohoEntity> 特徴未同定情報List = 特徴未同定情報Dac.selectNot識別コードByKey(
                    id.get処理年度(), id.get基礎年金番号(), id.get年金コード(), id.get捕捉月(), id.get識別コード());
            if (特徴未同定情報List != null && !特徴未同定情報List.isEmpty()) {
                対象外Map.put(id, (ArrayList<DbT2019TokuchoMidoteiJohoEntity>) 特徴未同定情報List);
            }
        }
        return 対象外Map;
    }

    /**
     * 特別徴収同定候補者詳細情報を取得する
     *
     * @param 処理年度 FlexibleYear
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @param 開始月 RString
     * @param 識別コード RString
     * @param 捕捉月 RString
     * @return List<TokuchoDouteiKouhoshaShousaiJoho>
     */
    public List<TokuchoDouteiKouhoshaShousaiJoho> getTokuchoTaishoKouhosyaDetailJoho(FlexibleYear 処理年度,
            RString 基礎年金番号, RString 年金コード, RString 開始月, RString 捕捉月, ShikibetsuCode 識別コード) {
        RString 開始月数 = DateConverter.formatMonthFull(開始月);
        TokuchoTaishoshaIchiranSakuseiMybatisParameter param = new TokuchoTaishoshaIchiranSakuseiMybatisParameter();
        param.set処理年度(処理年度);
        param.set基礎年金番号(基礎年金番号);
        param.set年金コード(年金コード);
        param.set捕捉月(捕捉月);
        param.set識別コード(識別コード);
        param.set業務コード(GyomuCode.DB介護保険);
        mapper = mapperProvider.create(ITokuchoTaishoshaIchiranSakuseiMapper.class);
        List<TokuchoTaishoshaIchiranSakuseiEntity> resultEntityList = mapper.select特別徴収同定候補者詳細(param);
        if (resultEntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        RString 分配集約_基礎年金番号;
        RString 分配集約_年金コード;
        RString 分配集約_捕捉月;
        FlexibleYear 分配集約_処理年度;
        NenkinTokuchoKaifuJohoManager manager = new NenkinTokuchoKaifuJohoManager();
        List<TokuchoDouteiKouhoshaShousaiJoho> 同定候補者詳細情報List = new ArrayList();
        if (開始月_8月.compareTo(開始月数) == NUM0) {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                if (entity.getDbt2001entity() != null) {
                    分配集約_処理年度 = entity.getDbt2001entity().getFukaNendo();
                    分配集約_基礎年金番号 = entity.getDbt2001entity().getKariNenkinNo();
                    分配集約_年金コード = entity.getDbt2001entity().getKariNenkinCode();
                    分配集約_捕捉月 = entity.getDbt2001entity().getKariHosokuM();
                    NenkinTokuchoKaifuJoho nenkintokuchokaifujoho = manager.get年金特徴対象者情報(GyomuCode.DB介護保険,
                            分配集約_処理年度, 分配集約_基礎年金番号, 分配集約_年金コード, 分配集約_捕捉月);
                    get年金特徴回付情報value(nenkintokuchokaifujoho, result);
                }
                同定候補者詳細情報List.add(result);
            }
        } else if (開始月_10月.compareTo(開始月数) == NUM0 || 開始月_12月.compareTo(開始月数) == NUM0
                || 開始月_2月.compareTo(開始月数) == NUM0) {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                if (entity.getDbt2001entity() != null) {
                    分配集約_処理年度 = entity.getDbt2001entity().getFukaNendo();
                    分配集約_基礎年金番号 = entity.getDbt2001entity().getHonNenkinNo();
                    分配集約_年金コード = entity.getDbt2001entity().getHonNenkinCode();
                    分配集約_捕捉月 = entity.getDbt2001entity().getHonHosokuM();
                    NenkinTokuchoKaifuJoho nenkintokuchokaifujoho = manager.get年金特徴対象者情報(GyomuCode.DB介護保険,
                            分配集約_処理年度, 分配集約_基礎年金番号, 分配集約_年金コード,
                            分配集約_捕捉月);
                    get年金特徴回付情報value(nenkintokuchokaifujoho, result);
                }
                同定候補者詳細情報List.add(result);
            }
        } else if (開始月_翌4月.compareTo(開始月数) == NUM0 || 開始月_翌6月.compareTo(開始月数) == NUM0) {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                if (entity.getDbt2001entity() != null) {
                    分配集約_処理年度 = entity.getDbt2001entity().getFukaNendo();
                    分配集約_基礎年金番号 = entity.getDbt2001entity().getYokunendoKariNenkinNo();
                    分配集約_年金コード = entity.getDbt2001entity().getYokunendoKariNenkinCode();
                    分配集約_捕捉月 = entity.getDbt2001entity().getYokunendoKariHosokuM();
                    NenkinTokuchoKaifuJoho nenkintokuchokaifujoho = manager.get年金特徴対象者情報(GyomuCode.DB介護保険,
                            分配集約_処理年度, 分配集約_基礎年金番号, 分配集約_年金コード, 分配集約_捕捉月);
                    get年金特徴回付情報value(nenkintokuchokaifujoho, result);
                }
                同定候補者詳細情報List.add(result);
            }
        } else {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                同定候補者詳細情報List.add(result);
            }
        }
        return 同定候補者詳細情報List;
    }

    private void get年金特徴回付情報value(NenkinTokuchoKaifuJoho nenkintokuchokaifujoho,
            TokuchoDouteiKouhoshaShousaiJoho result) {
        if (nenkintokuchokaifujoho != null) {
            if (nenkintokuchokaifujoho.getDT特別徴収義務者コード() != null) {
                result.set登録済年金情報_特別徴収義務者コード(
                        nenkintokuchokaifujoho.getDT特別徴収義務者コード().value().value());
            }
            result.set登録済年金情報_基礎年金番号(nenkintokuchokaifujoho.get基礎年金番号());
            result.set登録済年金情報_年金コード(nenkintokuchokaifujoho.get年金コード());
            result.set登録済年金情報_捕捉月(nenkintokuchokaifujoho.get捕捉月());
        }
    }

    private List<DbT2019TokuchoMidoteiJohoEntity> get対象外(TokuchoMidoteiJoho model) {
        if (model == null) {
            return null;
        }
        TokuchoMidoteiJohoIdentifier id = model.identifier();
        Map<TokuchoMidoteiJohoIdentifier, List<DbT2019TokuchoMidoteiJohoEntity>> 対象外Map
                = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者対象外, HashMap.class);
        if (対象外Map == null) {
            return null;
        }
        return 対象外Map.get(id);
    }

    /**
     * 確認状態を更新する.
     *
     * @param 処理年度 FlexibleYear
     * @param 基礎年金番号 RString
     * @param 被保険者番号 RString
     * @param 年金コード RString
     * @param 開始月 RString
     * @param 特別徴収義務者コード RString
     * @param 捕捉月 RString
     * @param 確認状況区分 RString
     * @param 識別コード RString
     */
    public void kakuninJotaiUpdate(FlexibleYear 処理年度, RString 基礎年金番号, RString 被保険者番号,
            RString 年金コード, RString 開始月, RString 捕捉月, RString 確認状況区分, ShikibetsuCode 識別コード,
            RString 特別徴収義務者コード) {
        RString 開始月数 = DateConverter.formatMonthFull(開始月);
        TokuchoMidoteiJoho model = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者, TokuchoMidoteiJoho.class);
        if (model != null) {
            DbT2019TokuchoMidoteiJohoEntity 特徴未同定情報Entity = model.toEntity().clone();
            特徴未同定情報Entity.setKakuninJokyoKbn(確認状況区分);
            特徴未同定情報Entity.setState(EntityDataState.Modified);
            特徴未同定情報Dac.save(特徴未同定情報Entity);
        }
        if (確認状況区分_同定済み.compareTo(確認状況区分) == NUM0) {
            HihokenshaNo 被保険者番号Temp;
            if (!RString.isNullOrEmpty(被保険者番号)) {
                被保険者番号Temp = new HihokenshaNo(被保険者番号);
            } else {
                被保険者番号Temp = HihokenshaNo.EMPTY;
            }
            DbV2001ChoshuHohoEntity 徴収方法NewestEntity = 徴収方法NewestDac.selectChoshuhohonojohoAll(
                    処理年度, 被保険者番号Temp);
            if (徴収方法NewestEntity == null) {
                return;
            }
            DbT2001ChoshuHohoEntity 徴収方法entity = get徴収方法entity(徴収方法NewestEntity);
            ChoshuHoho 徴収方法業務概念 = new ChoshuHoho(徴収方法entity);
            徴収方法entity.setRirekiNo(徴収方法業務概念.get履歴番号() + NUM1);
            RString 徴収方法;
            if (NenkinHokenshaHantei.createInstance().is厚労省(特別徴収義務者コード)) {
                徴収方法 = jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho.特別徴収_厚生労働省
                        .getコード();
            } else {
                徴収方法 = jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho.特別徴収_地共済
                        .getコード();
            }
            if (STR08.compareTo(開始月数) == NUM0) {
                徴収方法entity.setChoshuHoho8gatsu(徴収方法);
                徴収方法entity.setChoshuHoho9gatsu(徴収方法);
                徴収方法entity.setKariNenkinNo(基礎年金番号);
                徴収方法entity.setKariNenkinCode(年金コード);
                徴収方法entity.setKariHosokuM(捕捉月);
            } else if (STR10.compareTo(開始月数) == NUM0) {
                徴収方法entity.setChoshuHoho10gatsu(徴収方法);
                徴収方法entity.setChoshuHoho11gatsu(徴収方法);
                徴収方法entity.setChoshuHoho12gatsu(徴収方法);
                徴収方法entity.setChoshuHoho1gatsu(徴収方法);
                徴収方法entity.setChoshuHoho2gatsu(徴収方法);
                徴収方法entity.setChoshuHoho3gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku4gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku5gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku6gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku7gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku8gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku9gatsu(徴収方法);
                徴収方法entity.setHonNenkinNo(基礎年金番号);
                徴収方法entity.setHonNenkinCode(年金コード);
                徴収方法entity.setHonHosokuM(捕捉月);
            } else if (STR12.compareTo(開始月数) == NUM0) {
                徴収方法entity.setChoshuHoho12gatsu(徴収方法);
                徴収方法entity.setChoshuHoho1gatsu(徴収方法);
                徴収方法entity.setChoshuHoho2gatsu(徴収方法);
                徴収方法entity.setChoshuHoho3gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku4gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku5gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku6gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku7gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku8gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku9gatsu(徴収方法);
                徴収方法entity.setHonNenkinNo(基礎年金番号);
                徴収方法entity.setHonNenkinCode(年金コード);
                徴収方法entity.setHonHosokuM(捕捉月);
            } else if (STR02.compareTo(開始月数) == NUM0) {
                徴収方法entity.setChoshuHoho2gatsu(徴収方法);
                徴収方法entity.setChoshuHoho3gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku4gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku5gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku6gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku7gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku8gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku9gatsu(徴収方法);
                徴収方法entity.setHonNenkinNo(基礎年金番号);
                徴収方法entity.setHonNenkinCode(年金コード);
                徴収方法entity.setHonHosokuM(捕捉月);
            } else if (STR04.compareTo(開始月数) == NUM0) {
                徴収方法entity.setChoshuHoho4gatsu(徴収方法);
                徴収方法entity.setChoshuHoho5gatsu(徴収方法);
                徴収方法entity.setChoshuHoho6gatsu(徴収方法);
                徴収方法entity.setChoshuHoho7gatsu(徴収方法);
                徴収方法entity.setChoshuHoho8gatsu(徴収方法);
                徴収方法entity.setChoshuHoho9gatsu(徴収方法);
                徴収方法entity.setChoshuHoho10gatsu(徴収方法);
                徴収方法entity.setChoshuHoho11gatsu(徴収方法);
                徴収方法entity.setChoshuHoho12gatsu(徴収方法);
                徴収方法entity.setChoshuHoho1gatsu(徴収方法);
                徴収方法entity.setChoshuHoho2gatsu(徴収方法);
                徴収方法entity.setChoshuHoho3gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku4gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku5gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku6gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku7gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku8gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku9gatsu(徴収方法);
                徴収方法entity.setYokunendoKariNenkinNo(基礎年金番号);
                徴収方法entity.setYokunendoKariNenkinCode(年金コード);
                徴収方法entity.setYokunendoKariHosokuM(捕捉月);
            } else if (STR06.compareTo(開始月数) == NUM0) {
                徴収方法entity.setChoshuHoho6gatsu(徴収方法);
                徴収方法entity.setChoshuHoho7gatsu(徴収方法);
                徴収方法entity.setChoshuHoho8gatsu(徴収方法);
                徴収方法entity.setChoshuHoho9gatsu(徴収方法);
                徴収方法entity.setChoshuHoho10gatsu(徴収方法);
                徴収方法entity.setChoshuHoho11gatsu(徴収方法);
                徴収方法entity.setChoshuHoho12gatsu(徴収方法);
                徴収方法entity.setChoshuHoho1gatsu(徴収方法);
                徴収方法entity.setChoshuHoho2gatsu(徴収方法);
                徴収方法entity.setChoshuHoho3gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku4gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku5gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku6gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku7gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku8gatsu(徴収方法);
                徴収方法entity.setChoshuHohoYoku9gatsu(徴収方法);
                徴収方法entity.setChoshuHoho8gatsu(徴収方法);
                徴収方法entity.setChoshuHoho9gatsu(徴収方法);
                徴収方法entity.setYokunendoKariNenkinNo(基礎年金番号);
                徴収方法entity.setYokunendoKariNenkinCode(年金コード);
                徴収方法entity.setYokunendoKariHosokuM(捕捉月);
            }
            徴収方法entity.setIraiSohuzumiFlag(false);
            徴収方法entity.setTsuikaIraiSohuzumiFlag(false);
            徴収方法entity.setTokuchoTeishiNichiji(null);
            徴収方法entity.setTokuchoTeishiJiyuCode(RString.EMPTY);
            徴収方法entity.setState(EntityDataState.Added);
            徴収方法Dac.save(徴収方法entity);
            List<DbT2019TokuchoMidoteiJohoEntity> 特徴未同定情報List = get対象外(model);
            if (特徴未同定情報List == null || 特徴未同定情報List.isEmpty()) {
                return;
            }
            for (DbT2019TokuchoMidoteiJohoEntity entity : 特徴未同定情報List) {
                entity = entity.clone();
                if (確認状況区分_同定済み.compareTo(entity.getKakuninJokyoKbn()) == NUM0) {
                    その他候補者データを登録する(開始月数, 処理年度, entity, 基礎年金番号, 年金コード, 捕捉月);
                }
                entity.setKakuninJokyoKbn(確認状況区分_対象外);
                entity.setState(EntityDataState.Modified);
                特徴未同定情報Dac.save(entity);
            }
        }
    }

    private void その他候補者データを登録する(RString 開始月数, FlexibleYear 処理年度,
            DbT2019TokuchoMidoteiJohoEntity 特徴未同定情報entity, RString 基礎年金番号,
            RString 年金コード, RString 捕捉月) {
        TokuchoTaishoshaIchiranSakuseiMybatisParameter param = new TokuchoTaishoshaIchiranSakuseiMybatisParameter();
        param.set処理年度(処理年度);
        param.set基礎年金番号(基礎年金番号);
        param.set年金コード(年金コード);
        param.set捕捉月(捕捉月);
        param.set識別コード(特徴未同定情報entity.getShikibetsuCode());
        mapper = mapperProvider.create(ITokuchoTaishoshaIchiranSakuseiMapper.class);
        List<DbT2001ChoshuHohoEntity> 徴収方法entityList = mapper.select最新介護徴収方法情報取得(param);
        if (STR08.compareTo(開始月数) == NUM0) {
            for (DbT2001ChoshuHohoEntity 徴収方法entity : 徴収方法entityList) {
                徴収方法entity.setChoshuHoho8gatsu(set徴収方法(徴収方法entity.getChoshuHoho8gatsu()));
                徴収方法entity.setChoshuHoho9gatsu(set徴収方法(徴収方法entity.getChoshuHoho9gatsu()));
                徴収方法entity.setKariNenkinNo(基礎年金番号);
                徴収方法entity.setKariNenkinCode(年金コード);
                徴収方法entity.setKariHosokuM(捕捉月);
                save徴収方法entity(徴収方法entity);
            }
        } else if (STR10.compareTo(開始月数) == NUM0) {
            for (DbT2001ChoshuHohoEntity 徴収方法entity : 徴収方法entityList) {
                徴収方法entity.setChoshuHoho10gatsu(set徴収方法(徴収方法entity.getChoshuHoho10gatsu()));
                徴収方法entity.setChoshuHoho11gatsu(set徴収方法(徴収方法entity.getChoshuHoho11gatsu()));
                徴収方法entity.setChoshuHoho12gatsu(set徴収方法(徴収方法entity.getChoshuHoho12gatsu()));
                徴収方法entity.setChoshuHoho1gatsu(set徴収方法(徴収方法entity.getChoshuHoho1gatsu()));
                徴収方法entity.setChoshuHoho2gatsu(set徴収方法(徴収方法entity.getChoshuHoho2gatsu()));
                徴収方法entity.setChoshuHoho3gatsu(set徴収方法(徴収方法entity.getChoshuHoho3gatsu()));
                徴収方法entity.setChoshuHohoYoku4gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku4gatsu()));
                徴収方法entity.setChoshuHohoYoku5gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku5gatsu()));
                徴収方法entity.setChoshuHohoYoku6gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku6gatsu()));
                徴収方法entity.setChoshuHohoYoku7gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku7gatsu()));
                徴収方法entity.setChoshuHohoYoku8gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku8gatsu()));
                徴収方法entity.setChoshuHohoYoku9gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku9gatsu()));
                徴収方法entity.setHonNenkinNo(基礎年金番号);
                徴収方法entity.setHonNenkinCode(年金コード);
                徴収方法entity.setHonHosokuM(捕捉月);
                save徴収方法entity(徴収方法entity);
            }
        } else if (STR12.compareTo(開始月数) == NUM0) {
            for (DbT2001ChoshuHohoEntity 徴収方法entity : 徴収方法entityList) {
                徴収方法entity.setChoshuHoho12gatsu(set徴収方法(徴収方法entity.getChoshuHoho12gatsu()));
                徴収方法entity.setChoshuHoho1gatsu(set徴収方法(徴収方法entity.getChoshuHoho1gatsu()));
                徴収方法entity.setChoshuHoho2gatsu(set徴収方法(徴収方法entity.getChoshuHoho2gatsu()));
                徴収方法entity.setChoshuHoho3gatsu(set徴収方法(徴収方法entity.getChoshuHoho3gatsu()));
                徴収方法entity.setChoshuHohoYoku4gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku4gatsu()));
                徴収方法entity.setChoshuHohoYoku5gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku5gatsu()));
                徴収方法entity.setChoshuHohoYoku6gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku6gatsu()));
                徴収方法entity.setChoshuHohoYoku7gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku7gatsu()));
                徴収方法entity.setChoshuHohoYoku8gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku8gatsu()));
                徴収方法entity.setChoshuHohoYoku9gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku9gatsu()));
                徴収方法entity.setHonNenkinNo(基礎年金番号);
                徴収方法entity.setHonNenkinCode(年金コード);
                徴収方法entity.setHonHosokuM(捕捉月);
                save徴収方法entity(徴収方法entity);
            }
        } else if (STR02.compareTo(開始月数) == NUM0) {
            for (DbT2001ChoshuHohoEntity 徴収方法entity : 徴収方法entityList) {
                徴収方法entity.setChoshuHoho2gatsu(set徴収方法(徴収方法entity.getChoshuHoho2gatsu()));
                徴収方法entity.setChoshuHoho3gatsu(set徴収方法(徴収方法entity.getChoshuHoho3gatsu()));
                徴収方法entity.setChoshuHohoYoku4gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku4gatsu()));
                徴収方法entity.setChoshuHohoYoku5gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku5gatsu()));
                徴収方法entity.setChoshuHohoYoku6gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku6gatsu()));
                徴収方法entity.setChoshuHohoYoku7gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku7gatsu()));
                徴収方法entity.setChoshuHohoYoku8gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku8gatsu()));
                徴収方法entity.setChoshuHohoYoku9gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku9gatsu()));
                徴収方法entity.setHonNenkinNo(基礎年金番号);
                徴収方法entity.setHonNenkinCode(年金コード);
                徴収方法entity.setHonHosokuM(捕捉月);
                save徴収方法entity(徴収方法entity);
            }
        } else if (STR04.compareTo(開始月数) == NUM0) {
            for (DbT2001ChoshuHohoEntity 徴収方法entity : 徴収方法entityList) {
                徴収方法entity.setChoshuHoho4gatsu(set徴収方法(徴収方法entity.getChoshuHoho4gatsu()));
                徴収方法entity.setChoshuHoho5gatsu(set徴収方法(徴収方法entity.getChoshuHoho5gatsu()));
                徴収方法entity.setChoshuHoho6gatsu(set徴収方法(徴収方法entity.getChoshuHoho6gatsu()));
                徴収方法entity.setChoshuHoho7gatsu(set徴収方法(徴収方法entity.getChoshuHoho7gatsu()));
                徴収方法entity.setChoshuHoho8gatsu(set徴収方法(徴収方法entity.getChoshuHoho8gatsu()));
                徴収方法entity.setChoshuHoho9gatsu(set徴収方法(徴収方法entity.getChoshuHoho9gatsu()));
                徴収方法entity.setChoshuHoho10gatsu(set徴収方法(徴収方法entity.getChoshuHoho10gatsu()));
                徴収方法entity.setChoshuHoho11gatsu(set徴収方法(徴収方法entity.getChoshuHoho11gatsu()));
                徴収方法entity.setChoshuHoho12gatsu(set徴収方法(徴収方法entity.getChoshuHoho12gatsu()));
                徴収方法entity.setChoshuHoho1gatsu(set徴収方法(徴収方法entity.getChoshuHoho1gatsu()));
                徴収方法entity.setChoshuHoho2gatsu(set徴収方法(徴収方法entity.getChoshuHoho2gatsu()));
                徴収方法entity.setChoshuHoho3gatsu(set徴収方法(徴収方法entity.getChoshuHoho3gatsu()));
                徴収方法entity.setChoshuHohoYoku4gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku4gatsu()));
                徴収方法entity.setChoshuHohoYoku5gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku5gatsu()));
                徴収方法entity.setChoshuHohoYoku6gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku6gatsu()));
                徴収方法entity.setChoshuHohoYoku7gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku7gatsu()));
                徴収方法entity.setChoshuHohoYoku8gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku8gatsu()));
                徴収方法entity.setChoshuHohoYoku9gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku9gatsu()));
                徴収方法entity.setYokunendoKariNenkinNo(基礎年金番号);
                徴収方法entity.setYokunendoKariNenkinCode(年金コード);
                徴収方法entity.setYokunendoKariHosokuM(捕捉月);
                save徴収方法entity(徴収方法entity);
            }
        } else if (STR06.compareTo(開始月数) == NUM0) {
            徴収方法entityList = mapper.select最新介護徴収方法情報取得(param);
            for (DbT2001ChoshuHohoEntity 徴収方法entity : 徴収方法entityList) {
                徴収方法entity.setChoshuHoho6gatsu(set徴収方法(徴収方法entity.getChoshuHoho6gatsu()));
                徴収方法entity.setChoshuHoho7gatsu(set徴収方法(徴収方法entity.getChoshuHoho7gatsu()));
                徴収方法entity.setChoshuHoho8gatsu(set徴収方法(徴収方法entity.getChoshuHoho8gatsu()));
                徴収方法entity.setChoshuHoho9gatsu(set徴収方法(徴収方法entity.getChoshuHoho9gatsu()));
                徴収方法entity.setChoshuHoho10gatsu(set徴収方法(徴収方法entity.getChoshuHoho10gatsu()));
                徴収方法entity.setChoshuHoho11gatsu(set徴収方法(徴収方法entity.getChoshuHoho11gatsu()));
                徴収方法entity.setChoshuHoho12gatsu(set徴収方法(徴収方法entity.getChoshuHoho12gatsu()));
                徴収方法entity.setChoshuHoho1gatsu(set徴収方法(徴収方法entity.getChoshuHoho1gatsu()));
                徴収方法entity.setChoshuHoho2gatsu(set徴収方法(徴収方法entity.getChoshuHoho2gatsu()));
                徴収方法entity.setChoshuHoho3gatsu(set徴収方法(徴収方法entity.getChoshuHoho3gatsu()));
                徴収方法entity.setChoshuHohoYoku4gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku4gatsu()));
                徴収方法entity.setChoshuHohoYoku5gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku5gatsu()));
                徴収方法entity.setChoshuHohoYoku6gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku6gatsu()));
                徴収方法entity.setChoshuHohoYoku7gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku7gatsu()));
                徴収方法entity.setChoshuHohoYoku8gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku8gatsu()));
                徴収方法entity.setChoshuHohoYoku9gatsu(set徴収方法(徴収方法entity.getChoshuHohoYoku9gatsu()));
                徴収方法entity.setYokunendoKariNenkinNo(基礎年金番号);
                徴収方法entity.setYokunendoKariNenkinCode(年金コード);
                徴収方法entity.setYokunendoKariHosokuM(捕捉月);
                save徴収方法entity(徴収方法entity);
            }
        }
    }

    private RString set徴収方法(RString 徴収方法) {
        if (jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho.特別徴収_厚生労働省.getコード().
                compareTo(徴収方法) == NUM0
                || jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho.特別徴収_地共済.getコード().
                compareTo(徴収方法) == NUM0) {
            return jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho.普通徴収.getコード();
        }
        return 徴収方法;
    }

    private void save徴収方法entity(DbT2001ChoshuHohoEntity 徴収方法entity) {
        徴収方法entity.setRirekiNo(徴収方法entity.getRirekiNo() + NUM1);
        徴収方法entity.setIraiSohuzumiFlag(false);
        徴収方法entity.setTsuikaIraiSohuzumiFlag(false);
        徴収方法entity.setTokuchoTeishiNichiji(null);
        徴収方法entity.setTokuchoTeishiJiyuCode(RString.EMPTY);
        徴収方法entity.setState(EntityDataState.Added);
        徴収方法Dac.save(徴収方法entity);
    }

    /**
     * 画面divより、バッチパラメータを用意する.
     *
     * @param result TokuchoTaishoshaIchiranSakuseiResult
     * @return TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter
     */
    public TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter getBatchiPara(TokuchoTaishoshaIchiranSakuseiResult result) {
        if (result == null) {
            return null;
        }
        RDateTime nowDateTime = RDateTime.now();
        TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter param = new TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter();
        param.setShoriNendo(new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                nowDateTime.getDate(), SubGyomuCode.DBB介護賦課)));
        param.setHosokudukiList(new ArrayList());
        if (result.get捕捉月リスト() != null && !result.get捕捉月リスト().isEmpty()) {
            for (RString 捕捉月 : result.get捕捉月リスト()) {
                param.getHosokudukiList().add(捕捉月);
            }
        }
        param.setTokubetuchoshuKaishiDuki(format特別徴収開始月(result.get特別徴収開始月()));
        param.setShuturyokuTaisho(result.get出力対象());
        param.setShoriNichiji(new YMDHMS(nowDateTime));
        param.setKakuninJokyoKubun(result.is確認状況区分());
        return param;
    }

    private RString format特別徴収開始月(RString 特別徴収開始月全文字) {
        if (RString.isNullOrEmpty(特別徴収開始月全文字)) {
            return RString.EMPTY;
        }
        return DateConverter.formatMonthFull(特別徴収開始月全文字.substring(NUM4, NUM6).trim());
    }

    /**
     * 被保険者情報が変わった場合、それに付随して住基情報、登録済年金情報のデータを取得する.
     *
     * @param 処理年度 FlexibleYear
     * @param 開始月 RString
     * @return List<TokuchoDouteiKouhoshaShousaiJoho>
     */
    public List<TokuchoDouteiKouhoshaShousaiJoho> getHihokenshaJoho(FlexibleYear 処理年度, RString 開始月) {
        TokuchoTaishoshaIchiranSakuseiMybatisParameter param = new TokuchoTaishoshaIchiranSakuseiMybatisParameter();
        param.set処理年度(処理年度);
        mapper = mapperProvider.create(ITokuchoTaishoshaIchiranSakuseiMapper.class);
        List<TokuchoTaishoshaIchiranSakuseiEntity> resultEntityList = mapper.select被保険者情報取得(param);
        if (resultEntityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        RString ue基礎年金番号;
        RString ue年金コード;
        RString ue捕捉月;
        FlexibleYear ue処理年度 = 処理年度;
        NenkinTokuchoKaifuJohoManager manager = new NenkinTokuchoKaifuJohoManager();
        List<TokuchoDouteiKouhoshaShousaiJoho> 同定候補者詳細情報List = new ArrayList();
        if (開始月_8月.compareTo(開始月) == NUM0) {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                if (entity.getDbt2001entity() != null) {
                    ue基礎年金番号 = entity.getDbt2001entity().getKariNenkinNo();
                    ue年金コード = entity.getDbt2001entity().getKariNenkinCode();
                    ue捕捉月 = entity.getDbt2001entity().getKariHosokuM();
                    NenkinTokuchoKaifuJoho nenkintokuchokaifujoho = manager.get年金特徴対象者情報(
                            GyomuCode.DB介護保険, ue処理年度, ue基礎年金番号, ue年金コード, ue捕捉月);
                    get年金特徴回付情報value(nenkintokuchokaifujoho, result);
                }
                同定候補者詳細情報List.add(result);
            }
        } else if (開始月_10月.compareTo(開始月) == NUM0 || 開始月_12月.compareTo(開始月) == NUM0
                || 開始月_2月.compareTo(開始月) == NUM0) {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                if (entity.getDbt2001entity() != null) {
                    ue基礎年金番号 = entity.getDbt2001entity().getHonNenkinNo();
                    ue年金コード = entity.getDbt2001entity().getHonNenkinCode();
                    ue捕捉月 = entity.getDbt2001entity().getHonHosokuM();
                    NenkinTokuchoKaifuJoho nenkintokuchokaifujoho = manager.get年金特徴対象者情報(
                            GyomuCode.DB介護保険, ue処理年度, ue基礎年金番号, ue年金コード, ue捕捉月);
                    get年金特徴回付情報value(nenkintokuchokaifujoho, result);
                }
                同定候補者詳細情報List.add(result);
            }
        } else if (開始月_翌4月.compareTo(開始月) == NUM0 || 開始月_翌6月.compareTo(開始月) == NUM0) {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                if (entity.getDbt2001entity() != null) {
                    ue基礎年金番号 = entity.getDbt2001entity().getYokunendoKariNenkinNo();
                    ue年金コード = entity.getDbt2001entity().getYokunendoKariNenkinCode();
                    ue捕捉月 = entity.getDbt2001entity().getYokunendoKariHosokuM();
                    NenkinTokuchoKaifuJoho nenkintokuchokaifujoho = manager.get年金特徴対象者情報(
                            GyomuCode.DB介護保険, ue処理年度, ue基礎年金番号, ue年金コード, ue捕捉月);
                    get年金特徴回付情報value(nenkintokuchokaifujoho, result);
                }
                同定候補者詳細情報List.add(result);
            }
        } else {
            for (TokuchoTaishoshaIchiranSakuseiEntity entity : resultEntityList) {
                TokuchoDouteiKouhoshaShousaiJoho result = new TokuchoDouteiKouhoshaShousaiJoho(entity);
                同定候補者詳細情報List.add(result);
            }
        }
        return 同定候補者詳細情報List;
    }

    private DbT2001ChoshuHohoEntity get徴収方法entity(DbV2001ChoshuHohoEntity dbvEntity) {
        if (dbvEntity == null) {
            return null;
        }
        DbT2001ChoshuHohoEntity dbtEntity = new DbT2001ChoshuHohoEntity();
        FlexibleYear 年度 = dbvEntity.getFukaNendo();
        if (年度 != null) {
            dbtEntity.setFukaNendo(年度);
        }
        HihokenshaNo 番号 = dbvEntity.getHihokenshaNo();
        if (番号 != null) {
            dbtEntity.setHihokenshaNo(番号);
        }
        dbtEntity.setRirekiNo(dbvEntity.getRirekiNo());
        dbtEntity.setChoshuHoho4gatsu(dbvEntity.getChoshuHoho4gatsu());
        dbtEntity.setChoshuHoho5gatsu(dbvEntity.getChoshuHoho5gatsu());
        dbtEntity.setChoshuHoho6gatsu(dbvEntity.getChoshuHoho6gatsu());
        dbtEntity.setChoshuHoho7gatsu(dbvEntity.getChoshuHoho7gatsu());
        dbtEntity.setChoshuHoho8gatsu(dbvEntity.getChoshuHoho8gatsu());
        dbtEntity.setChoshuHoho9gatsu(dbvEntity.getChoshuHoho9gatsu());
        dbtEntity.setChoshuHoho10gatsu(dbvEntity.getChoshuHoho10gatsu());
        dbtEntity.setChoshuHoho11gatsu(dbvEntity.getChoshuHoho11gatsu());
        dbtEntity.setChoshuHoho12gatsu(dbvEntity.getChoshuHoho12gatsu());
        dbtEntity.setChoshuHoho1gatsu(dbvEntity.getChoshuHoho1gatsu());
        dbtEntity.setChoshuHoho2gatsu(dbvEntity.getChoshuHoho2gatsu());
        dbtEntity.setChoshuHoho3gatsu(dbvEntity.getChoshuHoho3gatsu());
        dbtEntity.setChoshuHohoYoku4gatsu(dbvEntity.getChoshuHohoYoku4gatsu());
        dbtEntity.setChoshuHohoYoku5gatsu(dbvEntity.getChoshuHohoYoku5gatsu());
        dbtEntity.setChoshuHohoYoku6gatsu(dbvEntity.getChoshuHohoYoku6gatsu());
        dbtEntity.setChoshuHohoYoku7gatsu(dbvEntity.getChoshuHohoYoku7gatsu());
        dbtEntity.setChoshuHohoYoku8gatsu(dbvEntity.getChoshuHohoYoku8gatsu());
        dbtEntity.setChoshuHohoYoku9gatsu(dbvEntity.getChoshuHohoYoku9gatsu());
        dbtEntity.setKariNenkinNo(dbvEntity.getKariNenkinNo());
        dbtEntity.setKariNenkinCode(dbvEntity.getKariNenkinCode());
        dbtEntity.setKariHosokuM(dbvEntity.getKariHosokuM());
        dbtEntity.setHonNenkinNo(dbvEntity.getHonNenkinNo());
        dbtEntity.setHonNenkinCode(dbvEntity.getHonNenkinCode());
        dbtEntity.setHonHosokuM(dbvEntity.getHonHosokuM());
        dbtEntity.setYokunendoKariNenkinNo(dbvEntity.getYokunendoKariNenkinNo());
        dbtEntity.setYokunendoKariNenkinCode(dbvEntity.getYokunendoKariNenkinCode());
        dbtEntity.setYokunendoKariHosokuM(dbvEntity.getYokunendoKariHosokuM());
        dbtEntity.setIraiSohuzumiFlag(dbvEntity.getIraiSohuzumiFlag());
        dbtEntity.setTsuikaIraiSohuzumiFlag(dbvEntity.getTsuikaIraiSohuzumiFlag());
        dbtEntity.setTokuchoTeishiNichiji(dbvEntity.getTokuchoTeishiNichiji());
        dbtEntity.setTokuchoTeishiJiyuCode(dbvEntity.getTokuchoTeishiJiyuCode());
        return dbtEntity;
    }
}
