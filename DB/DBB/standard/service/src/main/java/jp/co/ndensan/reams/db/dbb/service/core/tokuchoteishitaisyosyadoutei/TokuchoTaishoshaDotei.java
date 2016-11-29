/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoteishitaisyosyadoutei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.KonkaiShoriNaiyoJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.ShoriDateKanriResult;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.ShoriJokyoJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoteishitaisyosyadoutei.TokuchoTeishiTaisyosyaDouteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoteishitaisyosyadoutei.TokuchoTeishiTaisyosyaDouteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shoridatekanri.KonkaiShoriNaiyoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shoridatekanri.ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shoridatekanri.ShoriJokyoJohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoteishitaisyosyadoutei.ITokuchoTeishiTaisyosyaDouteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ81002_1_特徴対象者同定（一括）
 *
 * @reamsid_L DBB-1850-030 sunhui
 */
public class TokuchoTaishoshaDotei {

    private final RString 単一保険者 = new RString("1");
    private final RString 広域保険者 = new RString("2");
    private final RString 最新の広域構成市町村 = new RString("0");
    private final RString 表示 = new RString("1");
    private final RString 処理名 = new RString(ShoriName.特徴対象者同定.toString());
    private final DbT7022ShoriDateKanriDac shoriDateKanriDac;
    private final MapperProvider mapperProvider;
    private static final RString 年度内連番_1 = new RString("0001");
    private static final RString 年度内連番_2 = new RString("0002");
    private static final RString 年度内連番_3 = new RString("0003");
    private static final RString 年度内連番_4 = new RString("0004");
    private static final RString 年度内連番_5 = new RString("0005");
    private static final RString 年度内連番_6 = new RString("0006");
    private static final RString 年度内連番_7 = new RString("0007");
    private static final RString 年度内連番_9 = new RString("0009");
    private static final RString 年度内連番_11 = new RString("0011");
    private static final RString 月捕捉_00 = new RString("00");
    private static final RString 月捕捉_02 = new RString("02");
    private static final RString 月捕捉_04 = new RString("04");
    private static final RString 月捕捉_05 = new RString("05");
    private static final RString 月捕捉_06 = new RString("06");
    private static final RString 月捕捉_08 = new RString("08");
    private static final RString 月捕捉_10 = new RString("10");
    private static final RString 月捕捉_12 = new RString("12");
    private static final RString 対象者情報取得月_02 = new RString("02");
    private static final RString 対象者情報取得月_04 = new RString("04");
    private static final RString 対象者情報取得月_05 = new RString("05");
    private static final RString 対象者情報取得月_08 = new RString("08");
    private static final RString 対象者情報取得月_10 = new RString("10");
    private static final RString 対象者情報取得月_12 = new RString("12");
    private final RString 年次 = new RString("2");
    private final RString 月次 = new RString("1");

    /**
     * コンストラクタです。
     */
    public TokuchoTaishoshaDotei() {
        shoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoTaishoshaDotei}のインスタンス
     */
    public static TokuchoTaishoshaDotei createInstance() {
        return InstanceProvider.create(TokuchoTaishoshaDotei.class);
    }

    /**
     * 特徴対象者同定情報取得
     *
     * @param 処理年度 FlexibleYear
     * @param モード RString
     * @return List<ShoriDateKanriResult> 特徴対象者同定情報リスト<処理日付管理Result>
     */
    public List<ShoriDateKanriResult> getTokuchoTaishoJoho(FlexibleYear 処理年度, RString モード) {
        List<ShoriDateKanriResult> resultEntityList = new ArrayList<>();
        ITokuchoTeishiTaisyosyaDouteiMapper mapper = mapperProvider.create(ITokuchoTeishiTaisyosyaDouteiMapper.class);

        TokuchoTeishiTaisyosyaDouteiMybatisParameter param = new TokuchoTeishiTaisyosyaDouteiMybatisParameter();
        param.set介護賦課(SubGyomuCode.DBB介護賦課);
        param.set処理名(処理名);
        param.set処理年度(処理年度);
        param.set最新の広域構成市町村(最新の広域構成市町村);
        param.set表示(表示);

        if (広域保険者.equals(モード)) {
            List<ShoriDateKanriEntity> resultEntity = mapper.select処理日付管理マスタ(param);
            if (resultEntity == null || resultEntity.isEmpty()) {
                return new ArrayList<>();
            }
            for (ShoriDateKanriEntity entity : resultEntity) {
                ShoriDateKanriResult result = new ShoriDateKanriResult();
                result.set基準年月日(entity.get基準年月日());
                result.set市町村コード(entity.get市町村コード());
                resultEntityList.add(result);
            }
        }

        if (単一保険者.equals(モード)) {
            List<DbT7022ShoriDateKanriEntity> entityList = shoriDateKanriDac.selectShoriDateKanri(SubGyomuCode.DBB介護賦課, 処理名, 処理年度);
            if (entityList == null || entityList.isEmpty()) {
                return resultEntityList;
            }
            for (DbT7022ShoriDateKanriEntity entity : entityList) {
                ShoriDateKanriResult result = new ShoriDateKanriResult();
                result.set市町村コード(entity.getShichosonCode());
                result.set基準年月日(entity.getKijunYMD());
                resultEntityList.add(result);
            }
        }
        return resultEntityList;
    }

    /**
     *
     * 処理状況一覧情報取得
     *
     * @param 処理年度 FlexibleYear
     * @param 対象者情報取得月 RString
     * @param モード RString
     * @return List<ShoriJokyoJohoResult> 処理状況一覧情報リスト<処理状況一覧情報Result>
     */
    public List<ShoriJokyoJohoResult> getShoriJokyoList(FlexibleYear 処理年度, RString 対象者情報取得月, RString モード) {
        List<ShoriJokyoJohoResult> resultEntityList = new ArrayList<>();
        ITokuchoTeishiTaisyosyaDouteiMapper mapper = mapperProvider.create(ITokuchoTeishiTaisyosyaDouteiMapper.class);

        TokuchoTeishiTaisyosyaDouteiMybatisParameter param = new TokuchoTeishiTaisyosyaDouteiMybatisParameter();
        param.set介護賦課(SubGyomuCode.DBB介護賦課);
        param.set処理年度(処理年度);
        param.set対象者情報取得月(対象者情報取得月);
        param.set特徴対象者情報取込(ShoriName.特徴対象者情報取込.get名称());
        param.set特徴結果情報取込(ShoriName.特徴結果情報取込.get名称());
        param.set最新の広域構成市町村(最新の広域構成市町村);
        param.set表示(表示);

        if (広域保険者.equals(モード)) {
            List<ShoriJokyoJohoEntity> resultEntity = mapper.select処理状況一覧情報(param);
            if (resultEntity == null || resultEntity.isEmpty()) {
                return new ArrayList<>();
            }
            for (ShoriJokyoJohoEntity entity : resultEntity) {
                ShoriJokyoJohoResult result = new ShoriJokyoJohoResult();
                result.set市町村コード(entity.get市町村コード());
                result.set市町村名称(entity.get市町村名称());
                result.set処理名(entity.get処理名());
                result.set基準年月日(entity.get基準年月日());
                result.set基準日時(entity.get基準日時());
                resultEntityList.add(result);
            }
        }

        if (単一保険者.equals(モード)) {
            RString shoriName = RString.EMPTY;
            RString nendoNaiRenban = RString.EMPTY;
            if (対象者情報取得月_04.equals(対象者情報取得月)) {
                shoriName = ShoriName.特徴結果情報取込.get名称();
                nendoNaiRenban = 年度内連番_1;
            } else if (対象者情報取得月_05.equals(対象者情報取得月)) {
                shoriName = ShoriName.特徴対象者情報取込.get名称();
                nendoNaiRenban = 年度内連番_1;
            } else if (対象者情報取得月_08.equals(対象者情報取得月)) {
                shoriName = ShoriName.特徴結果情報取込.get名称();
                nendoNaiRenban = 年度内連番_5;
            } else if (対象者情報取得月_10.equals(対象者情報取得月)) {
                shoriName = ShoriName.特徴結果情報取込.get名称();
                nendoNaiRenban = 年度内連番_7;
            } else if (対象者情報取得月_12.equals(対象者情報取得月)) {
                shoriName = ShoriName.特徴結果情報取込.get名称();
                nendoNaiRenban = 年度内連番_9;
            } else if (対象者情報取得月_02.equals(対象者情報取得月)) {
                shoriName = ShoriName.特徴結果情報取込.get名称();
                nendoNaiRenban = 年度内連番_11;
            }
            List<DbT7022ShoriDateKanriEntity> entityList = shoriDateKanriDac.select処理状況一覧情報(処理年度, shoriName, nendoNaiRenban);
            if (entityList == null || entityList.isEmpty()) {
                return resultEntityList;
            }
            for (DbT7022ShoriDateKanriEntity entity : entityList) {
                ShoriJokyoJohoResult result = new ShoriJokyoJohoResult();
                result.set処理名(entity.getShoriName());
                result.set基準年月日(entity.getKijunYMD());
                result.set基準日時(entity.getKijunTimestamp());
                resultEntityList.add(result);
            }
        }
        return resultEntityList;
    }

    /**
     * 今回処理内容情報取得
     *
     * @param 処理年度 FlexibleYear
     * @param モード RString
     * @return KonkaiShoriNaiyoJohoEntity 今回処理内容情報取得
     */
    public KonkaiShoriNaiyoJohoResult getKonkaiShoriNaiyoJoho(FlexibleYear 処理年度, RString モード) {
        KonkaiShoriNaiyoJohoResult resultEntity = new KonkaiShoriNaiyoJohoResult();
        ITokuchoTeishiTaisyosyaDouteiMapper mapper = mapperProvider.create(ITokuchoTeishiTaisyosyaDouteiMapper.class);

        TokuchoTeishiTaisyosyaDouteiMybatisParameter param = new TokuchoTeishiTaisyosyaDouteiMybatisParameter();
        param.set最新の広域構成市町村(最新の広域構成市町村);
        param.set表示(表示);
        param.set特徴対象者同定(ShoriName.特徴対象者同定.get名称());
        param.set介護賦課(SubGyomuCode.DBB介護賦課);
        param.set処理年度(処理年度);

        if (広域保険者.equals(モード)) {
            KonkaiShoriNaiyoJohoEntity result = mapper.select今回処理内容情報(param);
            if (result == null) {
                return null;
            }
            resultEntity = set捕捉月を設定(処理年度, result.get年度内連番());
            resultEntity.set年度内連番(result.get年度内連番());
        }

        if (単一保険者.equals(モード)) {
            DbT7022ShoriDateKanriEntity entity = shoriDateKanriDac.select今回処理内容情報(SubGyomuCode.DBB介護賦課, 処理年度, ShoriName.特徴対象者同定.get名称());
            if (entity == null) {
                return null;
            }
            resultEntity = set捕捉月を設定(処理年度, entity.getNendoNaiRenban());
            resultEntity.set年度内連番(entity.getNendoNaiRenban());
        }
        return resultEntity;
    }

    /**
     * バッチパラメータ取得
     *
     * @param 捕捉月 RString
     * @param 開始月 RString
     * @return KonkaiShoriNaiyoJohoEntity 今回処理内容情報取得
     */
    public TokuchoTeishiTaisyosyaDouteiBatchParameter getBatchiPara(
            List<RString> 捕捉月, RString 開始月) {
        TokuchoTeishiTaisyosyaDouteiBatchParameter param = new TokuchoTeishiTaisyosyaDouteiBatchParameter();
        RString 処理年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);

        param.set処理年度(処理年度);
        param.set捕捉月(捕捉月);
        param.set開始月(開始月);
        if (月捕捉_10.equals(開始月)) {
            param.set処理区分(年次);
        } else {
            param.set処理区分(月次);
        }
        param.set処理日時(RDate.getNowDateTime());
        return param;
    }

    private KonkaiShoriNaiyoJohoResult set捕捉月を設定(FlexibleYear 処理年度, RString 年度内連番) {
        KonkaiShoriNaiyoJohoResult entity = new KonkaiShoriNaiyoJohoResult();
        RString 特別徴収開始月;

        if (年度内連番_1.equals(年度内連番)) {
            RString 開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_2月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_04.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_02.toString())));
            entity.set捕捉月２(null);
            entity.set捕捉月３(null);
            特別徴収開始月 = get特別徴収開始月_01(開始月, 処理年度);
            entity.set特別徴収開始月(特別徴収開始月);
        } else if (年度内連番_2.equals(年度内連番)) {
            RString 開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_4月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_05.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_04.toString())));
            entity.set捕捉月２(null);
            entity.set捕捉月３(null);
            特別徴収開始月 = get特別徴収開始月_02(開始月, 処理年度);
            entity.set特別徴収開始月(特別徴収開始月);
        } else if (年度内連番_3.equals(年度内連番)) {
            RString 開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            entity = get特別徴収開始月_03(開始月, 処理年度);
        } else if (年度内連番_4.equals(年度内連番)) {
            RString 開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            entity = get特別徴収開始月_04(開始月, 処理年度);
        } else if (年度内連番_5.equals(年度内連番)) {
            RString 開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_10月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (月捕捉_00.equals(開始月)) {
                entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_12.toString())));
                entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_10.toString())));
                entity.set捕捉月２(null);
                entity.set捕捉月３(null);
                entity.set特別徴収開始月(null);
            } else if (月捕捉_04.equals(開始月)) {
                RString 開始月_06 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                entity = get特別徴収開始月_05(開始月_06, 処理年度);
            }
        } else if (年度内連番_6.equals(年度内連番)) {
            RString 開始月_12 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_12月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            RString 開始月_10 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_10月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (月捕捉_00.equals(開始月_12)) {
                entity.set対象者情報取得月(new RString(処理年度.plusYear(1).toString().concat(月捕捉_02.toString())));
                entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_12.toString())));
                entity.set捕捉月２(null);
                entity.set捕捉月３(null);
                entity.set特別徴収開始月(null);
            } else if (月捕捉_04.equals(開始月_10)) {
                entity.set対象者情報取得月(new RString(処理年度.plusYear(1).toString().concat(月捕捉_02.toString())));
                entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_12.toString())));
                entity.set捕捉月２(null);
                entity.set捕捉月３(null);
                entity.set特別徴収開始月(new RString(処理年度.plusYear(1).toString().concat(月捕捉_06.toString())));
            }
        }
        return entity;
    }

    private RString get特別徴収開始月_01(RString 開始月, FlexibleYear 処理年度) {
        RString 特別徴収開始月 = RString.EMPTY;
        if (月捕捉_00.equals(開始月)) {
            特別徴収開始月 = null;
        } else if (月捕捉_08.equals(開始月)) {
            特別徴収開始月 = new RString(処理年度.toString().concat(月捕捉_08.toString()));
        }
        return 特別徴収開始月;
    }

    private RString get特別徴収開始月_02(RString 開始月, FlexibleYear 処理年度) {
        RString 特別徴収開始月 = RString.EMPTY;
        if (月捕捉_00.equals(開始月)) {
            特別徴収開始月 = null;
        } else if (月捕捉_10.equals(開始月)) {
            特別徴収開始月 = new RString(処理年度.toString().concat(月捕捉_10.toString()));
        }
        return 特別徴収開始月;
    }

    private KonkaiShoriNaiyoJohoResult get特別徴収開始月_03(RString 開始月, FlexibleYear 処理年度) {
        KonkaiShoriNaiyoJohoResult entity = new KonkaiShoriNaiyoJohoResult();
        if (月捕捉_00.equals(開始月) || 月捕捉_04.equals(開始月)) {
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_08.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_06.toString())));
            entity.set捕捉月２(null);
            entity.set捕捉月３(null);
            entity.set特別徴収開始月(null);
        } else if (月捕捉_12.equals(開始月)) {
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_08.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_06.toString())));
            entity.set捕捉月２(null);
            entity.set捕捉月３(null);
            entity.set特別徴収開始月(new RString(処理年度.toString().concat(月捕捉_12.toString())));
        }
        return entity;
    }

    private KonkaiShoriNaiyoJohoResult get特別徴収開始月_04(RString 開始月, FlexibleYear 処理年度) {
        KonkaiShoriNaiyoJohoResult entity = new KonkaiShoriNaiyoJohoResult();
        if (月捕捉_00.equals(開始月) || 月捕捉_04.equals(開始月)) {
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_10.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_08.toString())));
            entity.set捕捉月２(null);
            entity.set捕捉月３(null);
            entity.set特別徴収開始月(null);
        } else if (月捕捉_02.equals(開始月)) {
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_10.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_08.toString())));
            entity.set捕捉月２(null);
            entity.set捕捉月３(null);
            entity.set特別徴収開始月(new RString(処理年度.plusYear(1).toString().concat(月捕捉_02.toString())));
        }
        return entity;
    }

    private KonkaiShoriNaiyoJohoResult get特別徴収開始月_05(RString 開始月, FlexibleYear 処理年度) {
        KonkaiShoriNaiyoJohoResult entity = new KonkaiShoriNaiyoJohoResult();
        if (月捕捉_04.equals(開始月)) {
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_12.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_06.toString())));
            entity.set捕捉月２(new RString(処理年度.toString().concat(月捕捉_08.toString())));
            entity.set捕捉月３(new RString(処理年度.toString().concat(月捕捉_10.toString())));
            entity.set特別徴収開始月(new RString(処理年度.plusYear(1).toString().concat(月捕捉_04.toString())));
        } else {
            entity.set対象者情報取得月(new RString(処理年度.toString().concat(月捕捉_12.toString())));
            entity.set捕捉月１(new RString(処理年度.toString().concat(月捕捉_10.toString())));
            entity.set捕捉月２(null);
            entity.set捕捉月３(null);
            entity.set特別徴収開始月(new RString(処理年度.plusYear(1).toString().concat(月捕捉_04.toString())));
        }
        return entity;
    }
}
