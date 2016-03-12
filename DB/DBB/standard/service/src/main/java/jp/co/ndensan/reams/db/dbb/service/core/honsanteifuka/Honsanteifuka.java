/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteifuka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.TsuchishoUchiwakeJoken;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.BatchTyouhyouResult;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.BatchresultParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.HonsanteifukaParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.TyouhyouParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteifuka.BatchTyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2014TsuchishoUchiwakeJokenDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteifuka.IHonsanteifukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定賦課計算のビジネスクラスです。
 */
public class Honsanteifuka {

    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT2014TsuchishoUchiwakeJokenDac 通知書打ち分け条件Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    /**
     * コンストラクタです。
     */
    public Honsanteifuka() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.通知書打ち分け条件Dac = InstanceProvider.create(DbT2014TsuchishoUchiwakeJokenDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 処理日付管理Dac 処理日付管理Dac
     * @param 通知書打ち分け条件Dac 通知書打ち分け条件Dac
     * @param 帳票制御汎用Dac 帳票制御汎用Dac
     */
    Honsanteifuka(MapperProvider mapperProvider,
            DbT7022ShoriDateKanriDac 処理日付管理Dac,
            DbT2014TsuchishoUchiwakeJokenDac 通知書打ち分け条件Dac,
            DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.mapperProvider = mapperProvider;
        this.処理日付管理Dac = 処理日付管理Dac;
        this.通知書打ち分け条件Dac = 通知書打ち分け条件Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * 処理状況取得
     *
     * @param 遷移元区分 遷移元区分
     * @param 調定年度 調定年度
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getShoriDateKanriList(RString 遷移元区分, FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        if (new RString("0").equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_賦課(調定年度);
        } else if (new RString("1").equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_通知書作成(調定年度);
        }
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShoriDateKanri> kanriList = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            kanriList.add(new ShoriDateKanri(entity));
        }
        return kanriList;
    }

    /**
     * 打分け方法情報の取得処理１
     *
     * @return List<TsuchishoUchiwakeJoken>
     */
    public List<TsuchishoUchiwakeJoken> getutiwakehouhoujyoho1() {
        IHonsanteifukaMapper mapper = mapperProvider.create(IHonsanteifukaMapper.class);
        List<DbT2014TsuchishoUchiwakeJokenEntity> entityList = mapper.get通知書打ち分け条件();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        List<TsuchishoUchiwakeJoken> jokenList = new ArrayList<>();
        for (DbT2014TsuchishoUchiwakeJokenEntity entity : entityList) {
            jokenList.add(new TsuchishoUchiwakeJoken(entity));
        }
        return jokenList;
    }

    /**
     * 打分け方法情報の取得処理２
     *
     * @param 打分け方法 打分け方法
     * @return List<DbT2014TsuchishoUchiwakeJokenEntity>
     */
    public List<TsuchishoUchiwakeJoken> getutiwakehouhoujyoho2(RString 打分け方法) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("uchiwakeJoken", 打分け方法);
        IHonsanteifukaMapper mapper = mapperProvider.create(IHonsanteifukaMapper.class);
        List<DbT2014TsuchishoUchiwakeJokenEntity> entityList = mapper.get打分け方法情報一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        List<TsuchishoUchiwakeJoken> jokenList = new ArrayList<>();
        for (DbT2014TsuchishoUchiwakeJokenEntity entity : entityList) {
            jokenList.add(new TsuchishoUchiwakeJoken(entity));
        }
        return jokenList;
    }

    /**
     * 打分け方法情報の登録処理１
     *
     * @param joken joken
     */
    public void regutiwakehouhoujyoho1(TsuchishoUchiwakeJoken joken) {
        if (joken != null) {
            通知書打ち分け条件Dac.save(joken.toEntity());
        }
    }

    /**
     * 打分け方法情報の登録処理２
     *
     * @param joken joken
     * @param 変更区分 変更区分
     */
    public void regutiwakehouhoujyoho2(TsuchishoUchiwakeJoken joken, RString 変更区分) {
        if (joken != null) {
            通知書打ち分け条件Dac.save(joken.toEntity());
        }
    }

    /**
     * 帳票制御汎用キー取得
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo getChohyoHanyoKey(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    /**
     * 帳票ID取得
     *
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param parameterList parameterList
     * @return List<BatchTyouhyouResult>
     * @throws ApplicationException Exception
     */
    public List<BatchTyouhyouResult> getChohyoID(FlexibleYear 調定年度, RString 算定期, List<TyouhyouParameter> parameterList)
            throws ApplicationException {
        if (parameterList == null || parameterList.isEmpty()) {
            return null;
        }
        List<BatchTyouhyouResult> resultList = new ArrayList<>();
        for (TyouhyouParameter parameter : parameterList) {
            BatchTyouhyouEntity 特徴開始通知書 = get特徴開始通知書_帳票ID(parameter);
            if (特徴開始通知書 != null) {
                resultList.add(new BatchTyouhyouResult(特徴開始通知書));
            }
            BatchTyouhyouEntity 決定変更通知書 = get決定変更通知書_帳票ID(調定年度, parameter);
            if (決定変更通知書 != null) {
                resultList.add(new BatchTyouhyouResult(決定変更通知書));
            }
            BatchTyouhyouEntity 納入通知書 = get納入通知書_帳票ID(調定年度, 算定期, parameter);
            if (納入通知書 == null && new RString("DBB100045_HokenryoNonyuTsuchishoDaihyo").equals(
                    new RString(parameter.get帳票分類ID().value().toString()))) {
                throw new ApplicationException(UrErrorMessages.存在しない
                        .getMessage().replace("納入通知書の帳票ID").evaluate());
            } else if (納入通知書 != null) {
                resultList.add(new BatchTyouhyouResult(納入通知書));
            }
        }
        return resultList;
    }

    /**
     * 特徴開始通知書(本算定）が選択される場合の帳票IDを取得
     *
     * @param parameter parameter
     * @return BatchTyouhyouEntity
     */
    private BatchTyouhyouEntity get特徴開始通知書_帳票ID(TyouhyouParameter parameter) {
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                new FlexibleYear("0000"), new RString("追加候補者用通知書タイプ"));
        ChohyoSeigyoHanyo 連帳区分 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                new FlexibleYear("0000"), new RString("追加候補者用連帳区分"));
        if (帳票タイプ != null && 連帳区分 != null) {
            RString 帳票ID;
            switch (帳票タイプ.get設定値().toString() + 連帳区分.get設定値().toString()) {
                case "0011":
                    帳票ID = new RString("DBB100033_TokubetsuChoshuKaishiTsuchishoB5Rencho");
                    break;
                case "0010":
                    帳票ID = new RString("DBB100032_TokubetsuChoshuKaishiTsuchishoB5");
                    break;
                case "0021":
                    帳票ID = new RString("DBB100037_TokubetsuChoshuKaishiTsuchishoB52Rencho");
                    break;
                case "0020":
                    帳票ID = new RString("DBB100036_TokubetsuChoshuKaishiTsuchishoB52");
                    break;
                case "0031":
                case "0030":
                    帳票ID = new RString("DBB100038_TokubetsuChoshuKaishiTsuchishoKairiA4Tate");
                    break;
                case "1011":
                    帳票ID = new RString("DBB100035_TokubetsuChoshuKaishiTsuchishoSealerRencho");
                    break;
                case "1010":
                    帳票ID = new RString("DBB100034_TokubetsuChoshuKaishiTsuchishoSealer");
                    break;
                default:
                    帳票ID = new RString("");
            }
            if (new RString("").equals(帳票ID)) {
                return null;
            }
            return new BatchTyouhyouEntity(parameter.get帳票分類ID(), 帳票ID, parameter.get出力順ID());
        }
        return null;
    }

    /**
     * 決定通知書と変更通知書の帳票IDを取得
     *
     * @param 調定年度 調定年度
     * @param parameter parameter
     * @return BatchTyouhyouEntity
     */
    private BatchTyouhyouEntity get決定変更通知書_帳票ID(FlexibleYear 調定年度, TyouhyouParameter parameter) {
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                調定年度, new RString("通知書タイプ"));
        if (帳票タイプ != null) {
            RString 帳票ID = new RString("");
            if (new RString("001").equals(帳票タイプ.get設定値())) {
                帳票ID = new RString("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoB5Yoko");
            } else if (new RString("002").equals(帳票タイプ.toEntity().getKomokuValue())) {
                帳票ID = new RString("DBB100040_KaigoHokenHokenryogakuKetteiTsuchishoA4Tate");
            }
            if (new RString("").equals(帳票ID)) {
                return null;
            }
            return new BatchTyouhyouEntity(parameter.get帳票分類ID(), 帳票ID, parameter.get出力順ID());
        }
        return null;
    }

    /**
     * 納入通知書の帳票IDを取得
     *
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param parameter parameter
     * @return BatchTyouhyouEntity
     */
    private BatchTyouhyouEntity get納入通知書_帳票ID(FlexibleYear 調定年度, RString 算定期, TyouhyouParameter parameter) {
        //入力．算定期より、該当するDBBコンフィグ．普徴期情報_納付書の型Nを取得する。
        RString 項目名 = null;
        ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, parameter.get帳票分類ID(),
                調定年度, 項目名);
        BatchTyouhyouEntity entity = new BatchTyouhyouEntity(parameter.get帳票分類ID(), null, parameter.get出力順ID());
        return entity;
    }

    /**
     * バッチ用パラメータ作成
     *
     * @param parameter parameter
     * @return BatchresultParameter
     */
    public BatchresultParameter createhonsanteifukaBatchParameter(HonsanteifukaParameter parameter) {
        List<BatchTyouhyouResult> resultList
                = getChohyoID(parameter.get調定年度(), parameter.get算定期(), parameter.get出力帳票一覧List());
        BatchresultParameter result = new BatchresultParameter();
        result.set調定年度(parameter.get調定年度());
        result.set賦課年度(parameter.get賦課年度());
        result.set資格基準日(parameter.get資格基準日());
        result.set出力帳票一覧(resultList);
        if (new RString("本算定").equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(new RString("1"));
        }
        result.set特徴_発行日(parameter.get特徴_発行日());
        result.set決定変更_文書番号(parameter.get文書番号());
        result.set決定変更_発行日(parameter.get決定変更_発行日());
        if (new RString("別々出力").equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(new RString("0"));
        } else if (new RString("全件出力").equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(new RString("1"));
        }
        result.set納入_出力期(parameter.get出力期());
        if (new RString("すべて選択").equals(parameter.get納入_対象者())) {
            result.set納入_対象者(new RString("2"));
        } else if (new RString("現金納付者").equals(parameter.get納入_対象者())) {
            result.set納入_対象者(new RString("0"));
        } else if (new RString("口座振替者").equals(parameter.get納入_対象者())) {
            result.set納入_対象者(new RString("1"));
        }
        result.set納入_発行日(parameter.get納入_発行日());
        if (new RString("する").equals(parameter.get生活保護対象者())) {
            result.set納入_出力対象(new RString("0"));
        } else if (new RString("しない").equals(parameter.get生活保護対象者())) {
            result.set納入_出力対象(new RString("1"));
        }
        if (new RString("する").equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(new RString("0"));
        } else if (new RString("しない").equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(new RString("1"));
        }
        result.set打分け条件情報(parameter.get打分け条件情報());
        result.set処理日時(new FlexibleDate(RDate.getNowTime().toString()));
        result.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        return result;
    }
}
