 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.ChohyoMeter;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.SanteiIdoGennen;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.Shoriku;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.CreateHonsanteiIdoBatchParameter;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定異動（現年度）のビジネスクラスです。
 *
 */
public class HonsanteiIdoGennendo {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private static RString zf = new RString("0001");
    private static FlexibleYear year = new FlexibleYear("0000");

    /**
     * コンストラクタです
     */
    public HonsanteiIdoGennendo() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac 処理日付管理Dac
     */
    HonsanteiIdoGennendo(DbT7022ShoriDateKanriDac 処理日付管理Dac,
            DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * にて生成した{@link HonsanteiIdoGennendo}のインスタンスを返します。
     *
     * @return HonsanteiIdoGennendo
     */
    public static HonsanteiIdoGennendo createInstance() {
        return InstanceProvider.create(HonsanteiIdoGennendo.class);
    }

    /**
     * 処理状況取得
     *
     * @param 算定月 算定月
     * @param 調定年度 調定年度
     * @param 遷移元区分 遷移元区分
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getShoriDateKanriList(RString 算定月, FlexibleYear 調定年度,
            RString 遷移元区分) {
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        if (new RString("0").equals(遷移元区分)) {
            if (new RString("10").equals(算定月)) {
                entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                        ShoriName.特徴対象者同定.get名称(),
                        zf, 調定年度, new RString("0003"));
            } else if (new RString("12").equals(算定月)) {
                entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                        ShoriName.特徴対象者同定.get名称(),
                        zf, 調定年度, new RString("0004"));
            } else if (new RString("2").equals(算定月)) {
                entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                        ShoriName.特徴対象者同定.get名称(),
                        zf, 調定年度, new RString("0005"));
            }
        } else if (new RString("1").equals(遷移元区分)) {
            DbT7022ShoriDateKanriEntity entity
                    = 処理日付管理Dac.selectByFourKeys(SubGyomuCode.DBB介護賦課,
                            ShoriName.異動賦課.get名称(), zf, 調定年度);
            entityList.add(entity);
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
     * 抽出開始日時取得
     *
     * @param 調定年度 調定年度
     * @return ShoriDateKanri
     */
    public ShoriDateKanri getChushutsuKaishiNichiji(FlexibleYear 調定年度) {
        DbT7022ShoriDateKanriEntity kanriEntity;
        kanriEntity = 処理日付管理Dac.selectByFourKeys(SubGyomuCode.DBB介護賦課,
                ShoriName.異動賦課.get名称(), zf, 調定年度);
        if (kanriEntity == null) {
            kanriEntity = 処理日付管理Dac.selectBySomeKeysLimits(SubGyomuCode.DBB介護賦課,
                    ShoriName.本算定賦課.get名称(), zf,
                    調定年度, zf);
        }
        return new ShoriDateKanri(kanriEntity);
    }

    /**
     * 処理区分設定 パラメータ
     *
     * @param list list
     * @param 年度内連番 年度内連番
     * @return int
     */
    public int getCountFlag(List<DbT7022ShoriDateKanriEntity> list, RString 年度内連番) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (年度内連番.equals(list.get(i).getNendoNaiRenban())
                    && list.get(i).getKijunTimestamp() != null) {
                count = 1;
                break;
            }
        }
        if (count == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 処理区分設定 パラメータ
     *
     * @param entity entity
     * @param countLog countLog
     */
    public void setEntity(Shoriku entity, int countLog) {
        if (countLog == 1) {
            entity.set計算処理区分(new RString("1"));
        } else {
            entity.set計算処理区分(new RString("0"));
        }
    }

    /**
     * 処理区分設定
     *
     * @param 算定月 算定月
     * @param 調定年度 調定年度
     * @return Shoriku
     */
    public Shoriku setShorikubun(RString 算定月, FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> entityFir;
        List<DbT7022ShoriDateKanriEntity> entitySec;
        Shoriku entity = new Shoriku();
        int countLog = 0;
        entityFir = 処理日付管理Dac.selectShorikubun(SubGyomuCode.DBB介護賦課,
                ShoriName.特徴対象者同定.get名称(), 調定年度);
        entitySec = 処理日付管理Dac.selectShorikubun(SubGyomuCode.DBB介護賦課,
                ShoriName.依頼金額計算.get名称(), 調定年度);

        if (entityFir == null || entityFir.isEmpty() || entitySec == null || entitySec.isEmpty()) {
            return null;
        }

        if (new RString("10").equals(算定月)) {
            countLog = this.getCountFlag(entityFir, new RString("0003"));
            if (countLog == 0) {
                entity.set特徴同定区分(new RString("0"));
                entity.set計算処理区分(new RString("0"));
                return entity;
            } else {
                entity.set特徴同定区分(new RString("1"));
                countLog = 0;
                countLog = this.getCountFlag(entitySec, new RString("0004"));
                this.setEntity(entity, countLog);
                return entity;
            }
        }

        if (new RString("12").equals(算定月)) {
            countLog = 0;
            countLog = this.getCountFlag(entityFir, new RString("0004"));
            if (countLog == 0) {
                entity.set特徴同定区分(new RString("0"));
                entity.set計算処理区分(new RString("0"));
                return entity;
            } else {
                entity.set特徴同定区分(new RString("1"));
                countLog = 0;
                countLog = this.getCountFlag(entitySec, new RString("0005"));
                this.setEntity(entity, countLog);
                return entity;
            }
        }

        if (new RString("2").equals(算定月)) {
            countLog = 0;
            countLog = this.getCountFlag(entityFir, new RString("0005"));
            if (countLog == 0) {
                entity.set特徴同定区分(new RString("0"));
                entity.set計算処理区分(new RString("0"));
                return entity;
            } else {
                entity.set特徴同定区分(new RString("1"));
                countLog = 0;
                countLog = this.getCountFlag(entitySec, new RString("0006"));
                this.setEntity(entity, countLog);
                return entity;
            }
        }
        return null;
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
    public ChohyoSeigyoHanyo getChohyoHanyoKey(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID, FlexibleYear 管理年度, RString 項目名) {

        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.selectByKey(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        } else {
            return new ChohyoSeigyoHanyo(entity);
        }
    }

    /**
     * 特徴開始通知書(本算定）が選択される場合の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @return ChohyoResult
     */
    public ChohyoResult get特徴開始通知書_本算定(ReportId 帳票分類ID, RString 出力順ID) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                year, new RString("追加候補者用通知書タイプ"));
        ChohyoSeigyoHanyo 連帳区分を = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                year, new RString("追加候補者用連帳区分"));
        switch (帳票タイプを.get設定値().toString() + 連帳区分を.get設定値().toString()) {
            case "0011":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100033_TokubetsuChoshuKaishiTsuchishoB5Rencho"), 出力順ID);
            case "0010":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100032_TokubetsuChoshuKaishiTsuchishoB5"), 出力順ID);
            case "0021":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100037_TokubetsuChoshuKaishiTsuchishoB52Rencho"), 出力順ID);
            case "0020":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100036_TokubetsuChoshuKaishiTsuchishoB52"), 出力順ID);
            case "0031":
            case "0030":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100038_TokubetsuChoshuKaishiTsuchishoKairiA4Tate"), 出力順ID);
            case "1011":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100035_TokubetsuChoshuKaishiTsuchishoSealerRencho"), 出力順ID);
            case "1010":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100034_TokubetsuChoshuKaishiTsuchishoSealer"), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 特徴開始通知書(仮算定）の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @return ChohyoResult
     */
    public ChohyoResult get特徴開始通知書_仮算定(ReportId 帳票分類ID, RString 出力順ID) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                new FlexibleYear("0000"), new RString("追加候補者用通知書タイプ"));
        ChohyoSeigyoHanyo 連帳区分を = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                new FlexibleYear("0000"), new RString("追加候補者用連帳区分"));
        switch (帳票タイプを.get設定値().toString() + 連帳区分を.get設定値().toString()) {
            case "0011":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100004_TokubetsuChoshuKaishiTsuchishoKairiB5Rencho"), 出力順ID);
            case "0010":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100003_TokubetsuChoshuKaishiTsuchishoKairiB5"), 出力順ID);
            case "0021":
            case "0020":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100009_TokubetsuChoshuKaishiTsuchishoKairiOverlayB5Yoko"), 出力順ID);
            case "0031":
            case "0030":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100008_TokubetsuChoshuKaishiTsuchishoKairiOverlayA4Tate"), 出力順ID);
            case "1011":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100006_TokubetsuChoshuKaishiTsuchishoKairiSealerRencho"), 出力順ID);
            case "1010":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100005_TokubetsuChoshuKaishiTsuchishoKairiSealer"), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 決定通知書の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @param 調定年度 調定年度
     * @return ChohyoResult
     */
    public ChohyoResult get決定通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, new RString("通知書タイプ"));
        switch (帳票タイプを.get設定値().toString()) {
            case "001":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoB5Yoko"), 出力順ID);
            case "002":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100040_KaigoHokenHokenryogakuKetteiTsuchishoA4Tate"), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 変更通知書の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 出力順ID 出力順ID
     * @param 調定年度 調定年度
     * @return ChohyoResult
     */
    public ChohyoResult get変更通知書(ReportId 帳票分類ID, RString 出力順ID, FlexibleYear 調定年度) {
        ChohyoSeigyoHanyo 帳票タイプを = this.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, new RString("通知書タイプ"));
        switch (帳票タイプを.get設定値().toString()) {
            case "001":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100042_KaigoHokenHokenryogakuHenkoKenChushiTsuchishoB5Yoko"), 出力順ID);
            case "002":
                return new ChohyoResult(帳票分類ID,
                        new RString("DBB100043_KaigoHokenHokenryogakuHenkoKenChushiTsuchishoA4Tate"), 出力順ID);
            default:
                return null;
        }
    }

    /**
     * 納入通知書の帳票IDを取得する。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @return ChohyoResult
     */
    public ChohyoResult get納入通知書(ReportId 帳票分類ID, FlexibleYear 調定年度, RString 算定期) {
        RString 項目名 = null;
        switch (算定期.toString()) {
            case "1":
                項目名 = new RString("期毎納入通知書タイプ");
                break;
            case "2":
                項目名 = new RString("銀振納入通知書タイプ");
                break;
            case "4":
                項目名 = new RString("銀振納入通知書タイプ");
                break;
            case "5":
                項目名 = new RString("その他納入通知書タイプ");
                break;
            case "6":
                項目名 = new RString("その他納入通知書タイプ");
                break;
            default:
                項目名 = null;
        }
        if (項目名 == null) {
            return null;
        } else {
            項目名 = null;
            //TODO QA.316(Redmine#77907)
        }
        return null;
    }

    /**
     * 帳票ID取得
     *
     * @param 調定年度 調定年度
     * @param 算定期 算定期
     * @param chohyoPara chohyoPara
     * @return List<ChohyoResult>
     */
    public List<ChohyoResult> getChohyoID(FlexibleYear 調定年度,
            RString 算定期, List<ChohyoMeter> chohyoPara) {

        List<ChohyoResult> resultList = new ArrayList<>();
        ChohyoResult result;
        if (chohyoPara == null || chohyoPara.isEmpty()) {
            return null;
        }
        for (ChohyoMeter choParameter : chohyoPara) {
            if (new ReportId("DBB_001").equals(choParameter.get帳票分類ID())) {
                result = this.get特徴開始通知書_本算定(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID());
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (new ReportId("DBB_0011").equals(choParameter.get帳票分類ID())) {
                result = get特徴開始通知書_仮算定(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID());
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (new ReportId("DBB_00111").equals(choParameter.get帳票分類ID())) {
                result = get決定通知書(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID(), 調定年度);
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (new ReportId("DBB_00111").equals(choParameter.get帳票分類ID())) {
                result = get変更通知書(choParameter.get帳票分類ID(),
                        choParameter.get出力順ID(), 調定年度);
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (new ReportId("DBB_0022").equals(choParameter.get帳票分類ID())) {
                result = get納入通知書(choParameter.get帳票分類ID(), 調定年度, 算定期);
                if (result == null || new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo").
                        equals(choParameter.get帳票分類ID())) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().
                            replace("納入通知書の帳票ID").evaluate());
                } else {
                    resultList.add(result);
                }
            }
        }
        return resultList;
    }

    /**
     *
     * @param parameter parameter
     * @return BatchParamResult
     */
    public CreateHonsanteiIdoBatchParameter createBatchParam(SanteiIdoGennen parameter) {
        CreateHonsanteiIdoBatchParameter result = new CreateHonsanteiIdoBatchParameter();
        result.setChoteiNendo(parameter.get調定年度());
        result.set賦課年度(parameter.get賦課年度());
        result.set処理対象(parameter.get処理対象());
        result.set抽出開始日時(parameter.get抽出開始日時());
        result.set抽出終了日時(parameter.get抽出終了日時());
        result.set特徴捕捉分(parameter.get特徴捕捉分());
        result.set依頼金額計算(parameter.get依頼金額計算());
        List<ChohyoResult> choResult = this.getChohyoID(parameter.get調定年度(),
                parameter.get算定期(), parameter.get出力帳票一覧List());
        result.set出力帳票List(choResult);
        if (new RString("12月特徴開始者").equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(new RString("2"));
        } else if (new RString("2月特徴開始者").equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(new RString("3"));
        } else if (new RString("4月特徴開始者").equals(parameter.get特徴_出力対象())) {
            result.set特徴_出力対象(new RString("4"));
        }
        result.set特徴_発行日(parameter.get特徴_発行日());
        result.set決定_チェックボックス(parameter.get決定_チェックボックス());
        result.set決定_文書番号(parameter.get決定_文書番号());
        result.set決定_発行日(parameter.get決定_発行日());
        result.set変更_チェックボックス(parameter.get変更_チェックボックス());
        if (new RString("（すべて選択）").equals(parameter.get変更_対象者())) {
            result.set変更_対象者(new RString("2"));
        } else if (new RString("現金納付者").equals(parameter.get変更_対象者())) {
            result.set変更_対象者(new RString("0"));
        } else if (new RString("口座振替者").equals(parameter.get変更_対象者())) {
            result.set変更_対象者(new RString("1"));
        }
        result.set変更_文書番号(parameter.get変更_文書番号());
        result.set変更_発行日(parameter.get変更_発行日());

        if (new RString("（すべて選択）").equals(parameter.get納入_対象者())) {
            result.set納入_対象者(new RString("2"));
        } else if (new RString("現金納付者").equals(parameter.get納入_対象者())) {
            result.set納入_対象者(new RString("0"));
        } else if (new RString("口座振替者").equals(parameter.get納入_対象者())) {
            result.set納入_対象者(new RString("1"));
        }

        if (new RString("口座用").equals(parameter.get納入_口座振替者())) {
            result.set納入_口座振替者(new RString("1"));
        } else if (new RString("口座用").equals(parameter.get納入_口座振替者())) {
            result.set納入_口座振替者(new RString("2"));
        }
        result.set納入_発行日(parameter.get納入_発行日());
        if (new RString("別々出力").equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(new RString("0"));
        } else if (new RString("全件出力").equals(parameter.get納入_出力方法())) {
            result.set納入_出力方法(new RString("1"));
        }
        result.set納入_出力期(parameter.get納入_出力期());

        if (new RString("する").equals(parameter.get納入_生活保護対象者())) {
            result.set納入_生活保護対象者(new RString("0"));
        } else if (new RString("しない").equals(parameter.get納入_生活保護対象者())) {
            result.set納入_生活保護対象者(new RString("1"));
        }

        if (new RString("する").equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(new RString("0"));
        } else if (new RString("しない").equals(parameter.get納入_ページごとに山分け())) {
            result.set納入_ページごとに山分け(new RString("1"));
        }
        result.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        result.set随時フラグ(parameter.is随時フラグ());
        return result;
    }

}
