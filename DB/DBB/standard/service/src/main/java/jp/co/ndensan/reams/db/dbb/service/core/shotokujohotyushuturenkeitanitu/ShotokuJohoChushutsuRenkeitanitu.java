/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeitanitu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shotokujohochushutsu.ShotokuJohoChushutsuGamenParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112001.DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112003.DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51005_2_所得情報抽出・連携（単一他社）
 *
 * @reamsid_L DBB-1690-050 sunhui
 */
public class ShotokuJohoChushutsuRenkeitanitu {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    private static final RString 処理日付管理マスタ無し = new RString("3");
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString 不可 = new RString("2");
    private static final RString 可 = new RString("1");
    private static final RString 当初_単一 = new RString("3");
    private static final RString 異動_単一 = new RString("4");
    private static final RString 枝番 = new RString("0001");

    /**
     * コンストラクタです。
     */
    ShotokuJohoChushutsuRenkeitanitu() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     */
    ShotokuJohoChushutsuRenkeitanitu(DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShotokuJohoChushutsuRenkeitanitu}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShotokuJohoChushutsuRenkeitanitu}のインスタンス
     */
    public static ShotokuJohoChushutsuRenkeitanitu createInstance() {
        return InstanceProvider.create(ShotokuJohoChushutsuRenkeitanitu.class);
    }

    /**
     * 処理区分取得メソッドです
     *
     * @param 市町村識別ID RString
     * @param 遷移区分 RString
     * @param 年度 FlexibleYear
     * @return 処理区分 RString
     */
    public RString getShoriKubun(RString 市町村識別ID, RString 遷移区分, FlexibleYear 年度) {
        RString 処理区分 = RString.EMPTY;
        YMDHMS 基準日時;
        List<DbT7022ShoriDateKanriEntity> 処理日付管理異動情報EntityList
                = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課, ShoriName.当初所得引出.get名称(), 枝番, 年度, 枝番);
        if (遷移区分_0.equals(遷移区分)) {
            if (処理日付管理異動情報EntityList == null || 処理日付管理異動情報EntityList.isEmpty()) {
                処理区分 = 処理日付管理マスタ無し;
            } else {
                基準日時 = 処理日付管理異動情報EntityList.get(0).getKijunTimestamp();
                処理区分 = 基準日時1(基準日時);
            }
            return 処理区分;
        } else if (遷移区分_1.equals(遷移区分)) {
            if (処理日付管理異動情報EntityList == null || 処理日付管理異動情報EntityList.isEmpty()) {
                処理区分 = 不可;
                return 処理区分;
            } else {
                基準日時 = 処理日付管理異動情報EntityList.get(0).getKijunTimestamp();
                処理区分 = 基準日時2(基準日時, 年度);
                return 処理区分;
            }
        }
        return 処理区分;
    }

    /**
     * 当初_単一バッチ用パラメータ作成します。
     *
     * @param parameter ShotokuJohoChushutsuGamenParameter
     * @return DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter
     */
    public DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter createShotokuJohoDBB112001Parameter(
            ShotokuJohoChushutsuGamenParameter parameter) {
        DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter result = new DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter();
        result.set処理年度(parameter.get処理年度());
        result.set市町村情報List(parameter.get市町村情報List());
        result.set出力順ID(parameter.get出力順ID());
        result.set帳票ID(ReportIdDBB.DBB200008.getReportId());
        result.set共有ファイル名(parameter.get共有ファイル名());
        result.setファイル名(parameter.getファイル名());
        result.set共有ファイルID(parameter.get共有ファイルID());
        result.set処理区分(当初_単一);
        return result;
    }

    /**
     * バッチ用パラメータ作成します。
     *
     * @param parameter ShotokuJohoChushutsuGamenParameter
     * @return DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter
     */
    public DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter createShotokuJohoDBB112003Parameter(
            ShotokuJohoChushutsuGamenParameter parameter) {
        DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter result = new DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter();
        result.set処理年度(parameter.get処理年度());
        result.set市町村情報List(parameter.get市町村情報List());
        result.set出力順ID(parameter.get出力順ID());
        result.set帳票ID(ReportIdDBB.DBB200008.getReportId());
        result.setファイル名(parameter.getファイル名());
        result.set共有ファイル名(parameter.get共有ファイル名());
        result.set共有ファイルID(parameter.get共有ファイルID());
        result.set処理区分(異動_単一);
        return result;
    }

    private RString 基準日時1(YMDHMS 基準日時) {
        RString 処理区分;
        if (基準日時 != null && !基準日時.isEmpty()) {
            処理区分 = 不可;
        } else {
            処理区分 = 可;
        }
        return 処理区分;
    }

    private RString 基準日時2(YMDHMS 基準日時, FlexibleYear 年度) {
        if (基準日時 != null && !基準日時.isEmpty()) {
            DbT7022ShoriDateKanriEntity 処理日付管理異動情報Entity
                    = 処理日付管理Dac.selectByFourKeys(SubGyomuCode.DBB介護賦課, ShoriName.所得引出.get名称(), 枝番, 年度);
            if (処理日付管理異動情報Entity != null) {
                return 可;
            } else {
                return 可;
            }
        } else {
            return 不可;
        }
    }
}
