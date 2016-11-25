/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeikoiki;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJoho;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.shotokujohochushutsu.ShotokuJohoChushutsuGamenParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112002.DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112004.DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shichoson.ShoriHizukeKanriMaster;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51005_1_所得情報抽出・連携（広域用）
 *
 * @reamsid_L DBB-1690-040 sunhui
 */
public class ShotokuJohoChushutsuRenkeiKoiki {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString 処理済 = new RString("1");
    private static final RString 正常終了 = new RString("正常終了");
    private static final RString 処理日付管理マスタ無し = new RString("3");
    private static final RString 可 = new RString("1");
    private static final RString 不可 = new RString("2");
    private static final RString データなし = new RString("5");
    private static final RString 状態なし = new RString("状態なし");
    private static final RString SUFFIX = new RString(".DAT");
    private static final RString SPLIT = new RString("_");
    private static final RString 当初所得情報ファイル名 = new RString("DEC05F001");
    private static final RString 異動所得情報ファイル名 = new RString("DEE01F001");
    private static final RString 当初_広域 = new RString("1");
    private static final RString 異動_広域 = new RString("2");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString RSTRING_0001 = new RString("0001");

    /**
     * コンストラクタです。
     */
    ShotokuJohoChushutsuRenkeiKoiki() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     */
    ShotokuJohoChushutsuRenkeiKoiki(DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShotokuJohoChushutsuRenkeiKoiki}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShotokuJohoChushutsuRenkeiKoiki}のインスタンス
     */
    public static ShotokuJohoChushutsuRenkeiKoiki createInstance() {
        return InstanceProvider.create(ShotokuJohoChushutsuRenkeiKoiki.class);
    }

    /**
     * 市町村一覧情報取得メソッドです
     *
     * @param koikiZenShichosonJohoList List<KoikiZenShichosonJoho>
     * @param 遷移区分 RString
     * @param 年度 FlexibleYear
     * @return List<ShichosonJohoResult>
     */
    public List<ShichosonJohoResult> getShichosonJoho(List<KoikiZenShichosonJoho> koikiZenShichosonJohoList,
            RString 遷移区分, FlexibleYear 年度) {
        List<ShichosonJohoResult> shichosonJohoResultList = new ArrayList<>();
        List<ShichosonJoho> shichosonJohoList = new ArrayList<>();
        ShoriHizukeKanriMaster kanriMasterEntity;
        for (KoikiZenShichosonJoho entity : koikiZenShichosonJohoList) {
            DbT7022ShoriDateKanriEntity 処理日付管理異動情報Entity;
            kanriMasterEntity = new ShoriHizukeKanriMaster();
            if (遷移区分_0.equals(遷移区分)) {
                処理日付管理異動情報Entity = 処理日付管理Dac.selectByKey(SubGyomuCode.DBB介護賦課, entity.get市町村コード(),
                        ShoriName.当初所得引出.get名称(), RSTRING_00.concat(entity.get市町村識別ID()), 年度, RSTRING_0001);
                if (処理日付管理異動情報Entity == null) {
                    kanriMasterEntity.set処理状態(処理済);
                    kanriMasterEntity.set表示用処理状態(正常終了);
                    kanriMasterEntity.set処理日時(null);
                    kanriMasterEntity.set処理区分(処理日付管理マスタ無し);
                } else {
                    基準日時と共有フォルダ処理判定(処理日付管理異動情報Entity, kanriMasterEntity, entity);
                }
            }
            if (遷移区分_1.equals(遷移区分)) {
                処理日付管理異動情報Entity = 処理日付管理Dac.select処理日付管理マスタ_所得情報抽出連携異動(
                        年度, entity.get市町村コード(), entity.get市町村識別ID(), ShoriName.所得引出.get名称());
                if (処理日付管理異動情報Entity == null) {
                    kanriMasterEntity.set処理状態(null);
                    kanriMasterEntity.set表示用処理状態(null);
                    kanriMasterEntity.set処理日時(null);
                    kanriMasterEntity.set処理区分(可);
                } else {
                    YMDHMS 基準日時;
                    基準日時 = 処理日付管理異動情報Entity.getKijunTimestamp();
                    共有フォルダ処理(kanriMasterEntity, entity);
                    kanriMasterEntity.set処理日時(基準日時);
                    kanriMasterEntity.set処理区分(可);
                }
            }
            ShichosonJoho shichosonJohoEntity = new ShichosonJoho();
            shichosonJohoEntity.set市町村コード(entity.get市町村コード());
            shichosonJohoEntity.set市町村名(entity.get市町村名称());
            shichosonJohoEntity.set処理状態(kanriMasterEntity.get処理状態());
            shichosonJohoEntity.set表示用処理状態(kanriMasterEntity.get表示用処理状態());
            shichosonJohoEntity.set処理日時(kanriMasterEntity.get処理日時());
            shichosonJohoEntity.set処理区分(kanriMasterEntity.get処理区分());
            shichosonJohoList.add(shichosonJohoEntity);
        }
        for (ShichosonJoho resultEntity : shichosonJohoList) {
            shichosonJohoResultList.add(new ShichosonJohoResult(resultEntity));
        }
        return shichosonJohoResultList;
    }

    /**
     * 当初_広域 バッチ用パラメータ作成します。
     *
     * @param parameter ShotokuJohoChushutsuGamenParameter
     * @return DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter
     */
    public DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter createShotokuJoho_DBB112002Parameter(
            ShotokuJohoChushutsuGamenParameter parameter) {
        DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter result = new DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter();
        result.set処理年度(parameter.get処理年度());
        result.set市町村情報List(parameter.get市町村情報List());
        result.set出力順ID(parameter.get出力順ID());
        result.set帳票ID(ReportIdDBB.DBB200008.getReportId());
        result.set処理区分(当初_広域);
        return result;
    }

    /**
     * 異動_広域 バッチ用パラメータ作成します。
     *
     * @param parameter ShotokuJohoChushutsuGamenParameter
     * @return DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter
     */
    public DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter createShotokuJoho_DBB112004Parameter(
            ShotokuJohoChushutsuGamenParameter parameter) {
        DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter result = new DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter();
        result.set処理年度(parameter.get処理年度());
        result.set市町村情報List(parameter.get市町村情報List());
        result.set出力順ID(parameter.get出力順ID());
        result.set帳票ID(ReportIdDBB.DBB200008.getReportId());
        result.set処理区分(異動_広域);
        return result;
    }

    private void 基準日時と共有フォルダ処理判定(DbT7022ShoriDateKanriEntity 処理日付管理異動情報Entity,
            ShoriHizukeKanriMaster kanriMasterEntity, KoikiZenShichosonJoho entity) {
        YMDHMS 基準日時;
        基準日時 = 処理日付管理異動情報Entity.getKijunTimestamp();
        if (基準日時 != null) {
            kanriMasterEntity.set処理状態(処理済);
            kanriMasterEntity.set表示用処理状態(正常終了);
            kanriMasterEntity.set処理日時(基準日時);
            kanriMasterEntity.set処理区分(不可);
        } else {
            RStringBuilder rsb = new RStringBuilder();
            rsb.append(当初所得情報ファイル名);
            rsb.append(SPLIT);
            rsb.append(entity.get市町村識別ID());
            rsb.append(SUFFIX.toString());
            RString path = new RString(SharedFile.getBasePath() + File.separator + rsb.toRString());
            File file = new File(path.toString());
            if (!file.exists()) {
                kanriMasterEntity.set処理状態(データなし);
                kanriMasterEntity.set表示用処理状態(状態なし);
            } else {
                kanriMasterEntity.set処理状態(null);
                kanriMasterEntity.set表示用処理状態(正常終了);
            }
            kanriMasterEntity.set処理日時(null);
            kanriMasterEntity.set処理区分(可);
        }
    }

    private void 共有フォルダ処理(ShoriHizukeKanriMaster kanriMasterEntity, KoikiZenShichosonJoho entity) {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(異動所得情報ファイル名);
        rsb.append(SPLIT);
        rsb.append(entity.get市町村識別ID());
        rsb.append(SUFFIX.toString());
        RString path = new RString(SharedFile.getBasePath() + File.separator + rsb.toRString());
        File file = new File(path.toString());
        if (!file.exists()) {
            kanriMasterEntity.set処理状態(データなし);
            kanriMasterEntity.set表示用処理状態(状態なし);
        } else {
            kanriMasterEntity.set処理状態(null);
            kanriMasterEntity.set表示用処理状態(正常終了);
        }
    }

}
