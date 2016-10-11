/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110900;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon.HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon.KakohorenJyohoSakuseiCommonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kakohorenjyohosakuseicommon.IKakohorenJyohoSakuseiCommonMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報作成共通処理（証記載保険者番号取得）プロセスです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
public class HihokenshaTempUpdateKouikiProcess extends BatchProcessBase<KakohorenJyohoSakuseiCommonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kakohorenjyohosakuseicommon.IKakohorenJyohoSakuseiCommonMapper."
            + "select被保険者台帳");
    private static final RString 被保険者一時TBL_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時TBL_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString 広域内住所地特例フラグ_TRUE = new RString("1");
    private static final RString 変換対象フラグ_FALSE = new RString("0");
    private static final RString 変換対象フラグ_TRUE = new RString("1");
    private static final RString 編集区分_2 = new RString("2");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;

    @Override
    protected IBatchReader createReader() {
        被保険者一時TBL = new BatchEntityCreatedTempTableWriter(被保険者一時TBL_NAME,
                HihokenshaTempEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TBL_NAME,
                KokuhorenSakuseiErrorTempEntity.class);
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(KakohorenJyohoSakuseiCommonEntity commonEntity) {
        HihokenshaTempEntity entity = commonEntity.getHihokenshaTempEntity();
        HihokenshaDaichoEntity hihokenshaDaichoEntity = commonEntity.getHihokenshaDaichoEntity();
        entity.setOldShichosonCode(hihokenshaDaichoEntity.getKyuShichosonCode());
        RString 広域内住所地特例フラグ = hihokenshaDaichoEntity.getKoikinaiJushochiTokureiFlag();
        if (広域内住所地特例フラグ_TRUE.equals(広域内住所地特例フラグ)) {
            entity.setShichosonCode(hihokenshaDaichoEntity.getKoikinaiShichosonCd());
        } else {
            entity.setShichosonCode(hihokenshaDaichoEntity.getShichosonCode());
        }
        被保険者一時TBL.update(entity);
    }

    @Override
    protected void afterExecute() {
        IKakohorenJyohoSakuseiCommonMapper mapper = getMapper(IKakohorenJyohoSakuseiCommonMapper.class);
        List<KakohorenJyohoSakuseiCommonEntity> 合併なし市町村情報リスト = mapper.select合併なし市町村情報();
        RDate 基準日 = RDate.getNowDate();
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 保険者発足情報_広域保険者_合併保険者_発足日 = DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_広域保険者_合併保険者_発足日, 基準日, SubGyomuCode.DBU介護統計報告);
        FlexibleYearMonth 発足年月 = new FlexibleDate(保険者発足情報_広域保険者_合併保険者_発足日).getYearMonth();
        for (KakohorenJyohoSakuseiCommonEntity commonEntity : 合併なし市町村情報リスト) {
            HihokenshaTempEntity hihokenshaTempEntity = commonEntity.getHihokenshaTempEntity();
            DbT7051KoseiShichosonMasterEntity dbT7051Entity = commonEntity.getDbT7051Entity();
            FlexibleYearMonth サービス提供年月 = hihokenshaTempEntity.getExServiceTeikyoYm();
            FlexibleYearMonth 加入年月 = dbT7051Entity.getKanyuYMD().getYearMonth();
            if (加入年月.compareTo(サービス提供年月) <= 0) {
                hihokenshaTempEntity.setExShoHokenshaNo(dbT7051Entity.getShoKisaiHokenshaNo().value());
                hihokenshaTempEntity.setExHokenshaNo(保険者番号);
            } else {
                if (サービス提供年月.compareTo(発足年月) < 0) {
                    hihokenshaTempEntity.setHenkanFlag(変換対象フラグ_TRUE);
                } else {
                    hihokenshaTempEntity.setHenkanFlag(変換対象フラグ_FALSE);
                }
                hihokenshaTempEntity.setExShoHokenshaNo(dbT7051Entity.getShoKisaiHokenshaNo().value());
                hihokenshaTempEntity.setExHokenshaNo(dbT7051Entity.getShoKisaiHokenshaNo().value());
            }

            被保険者一時TBL.update(hihokenshaTempEntity);
        }

        List<KakohorenJyohoSakuseiCommonEntity> 合併あり市町村情報リスト = mapper.select合併あり市町村情報();
        for (KakohorenJyohoSakuseiCommonEntity commonEntity : 合併あり市町村情報リスト) {
            HihokenshaTempEntity hihokenshaTempEntity = commonEntity.getHihokenshaTempEntity();
            DbT7051KoseiShichosonMasterEntity dbT7051Entity = commonEntity.getDbT7051Entity();
            hihokenshaTempEntity.setExShoHokenshaNo(dbT7051Entity.getShoKisaiHokenshaNo().value());
            hihokenshaTempEntity.setExHokenshaNo(保険者番号);
            hihokenshaTempEntity.setShichosonCode(RString.EMPTY);
            hihokenshaTempEntity.setOldShichosonCode(RString.EMPTY);
            被保険者一時TBL.update(hihokenshaTempEntity);
        }

        List<KakohorenJyohoSakuseiCommonEntity> 合併あり被保険者一時TBL情報リスト = mapper.select合併あり被保険者一時TBL情報();

        for (KakohorenJyohoSakuseiCommonEntity commonEntity : 合併あり被保険者一時TBL情報リスト) {
            HihokenshaTempEntity hihokenshaTempEntity = commonEntity.getHihokenshaTempEntity();
            DbT7051KoseiShichosonMasterEntity dbT7051Entity = commonEntity.getDbT7051Entity();
            DbT7055GappeiJohoEntity dbT7055Entity = commonEntity.getDbT7055Entity();

            FlexibleYearMonth サービス提供年月 = hihokenshaTempEntity.getExServiceTeikyoYm();
            FlexibleYearMonth 国保連データ連携開始年月 = dbT7055Entity.getKokuhorenDataFromYMD().getYearMonth();
            if (国保連データ連携開始年月.compareTo(サービス提供年月) <= 0) {
                hihokenshaTempEntity.setExShoHokenshaNo(dbT7055Entity.getHokenshaNo().value());
                hihokenshaTempEntity.setExHokenshaNo(保険者番号);
            } else {
                if (サービス提供年月.compareTo(発足年月) < 0) {
                    hihokenshaTempEntity.setHenkanFlag(変換対象フラグ_TRUE);
                    hihokenshaTempEntity.setExHokenshaNo(dbT7051Entity.getShoKisaiHokenshaNo().value());
                } else {
                    hihokenshaTempEntity.setHenkanFlag(変換対象フラグ_FALSE);
                    hihokenshaTempEntity.setExHokenshaNo(保険者番号);
                }
                hihokenshaTempEntity.setExShoHokenshaNo(dbT7051Entity.getShoKisaiHokenshaNo().value());
            }
            hihokenshaTempEntity.setShichosonKanyuYmd(dbT7051Entity.getKanyuYMD());
            hihokenshaTempEntity.setShichosonDattaiYmd(dbT7051Entity.getRidatsuYMD());
            hihokenshaTempEntity.setShichosonCode(RString.EMPTY);
            hihokenshaTempEntity.setOldShichosonCode(RString.EMPTY);
            被保険者一時TBL.update(hihokenshaTempEntity);
        }

        List<KakohorenJyohoSakuseiCommonEntity> 新旧被保険者番号変換情報リスト = mapper.select新旧被保険者番号変換情報2();

        if (!新旧被保険者番号変換情報リスト.isEmpty()) {
            for (KakohorenJyohoSakuseiCommonEntity commonEntity : 新旧被保険者番号変換情報リスト) {
                HihokenshaTempEntity hihokenshaTempEntity = commonEntity.getHihokenshaTempEntity();
                DbT7026ShinKyuHihokenshaNoHenkanEntity dbT7026Entity = commonEntity.getDbT7026Entity();
                if (dbT7026Entity.getShichosonCode() != null) {
                    hihokenshaTempEntity.setOldShichosonCode(dbT7026Entity.getShichosonCode().value());
                }
                hihokenshaTempEntity.setSofuHihokenshaNo(dbT7026Entity.getKyuNo());
                被保険者一時TBL.update(hihokenshaTempEntity);
            }
        }
        List<HihokenshaTempEntity> 被保険者一時TBL情報リスト = mapper.select被保険者一時TBL情報By証記載保険者番号();
        RString 証記載保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 保険者発足情報_認定有効期間_編集区分 = DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, 基準日, SubGyomuCode.DBU介護統計報告);
        for (HihokenshaTempEntity entity : 被保険者一時TBL情報リスト) {
            entity.setExHihokenshaNo(保険者番号);
            entity.setExShoHokenshaNo(証記載保険者番号);
            if (編集区分_2.equals(保険者発足情報_認定有効期間_編集区分)) {
                entity.setHenkanFlag(変換対象フラグ_TRUE);
            } else {
                entity.setHenkanFlag(変換対象フラグ_FALSE);
            }

            被保険者一時TBL.update(entity);
            KokuhorenSakuseiErrorTempEntity tempEntity = new KokuhorenSakuseiErrorTempEntity();
            tempEntity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.証記載保険者番号取得エラー.getコード());
            tempEntity.setHihokenshaNo(entity.getExHihokenshaNo());
            処理結果リスト一時TBL.insert(tempEntity);
        }

        List<KakohorenJyohoSakuseiCommonEntity> 保険者情報リスト = mapper.select保険者名();
        for (KakohorenJyohoSakuseiCommonEntity commonEntity : 保険者情報リスト) {
            HihokenshaTempEntity hihokenshaTempEntity = commonEntity.getHihokenshaTempEntity();
            UrT0507HokenjaEntity urT0507Entity = commonEntity.getUrT0507Entity();
            hihokenshaTempEntity.setExHokenshaName(urT0507Entity.getHokenjaName());
            被保険者一時TBL.update(hihokenshaTempEntity);
        }
    }
}
