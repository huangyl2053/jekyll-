/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110900;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon.KakohorenJyohoSakuseiCommonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
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
public class HihokenshaTempUpdateKouikiProcess1 extends BatchProcessBase<KakohorenJyohoSakuseiCommonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kakohorenjyohosakuseicommon.IKakohorenJyohoSakuseiCommonMapper."
            + "select合併なし市町村情報");
    private static final RString 被保険者一時TBL_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 変換対象フラグ_FALSE = new RString("0");
    private static final RString 変換対象フラグ_TRUE = new RString("1");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 被保険者一時TBL;
    private RString 保険者番号;
    private FlexibleYearMonth 発足年月;

    @Override
    protected IBatchReader createReader() {
        被保険者一時TBL = new BatchEntityCreatedTempTableWriter(被保険者一時TBL_NAME,
                HihokenshaTempEntity.class);
        RDate 基準日 = RDate.getNowDate();
        保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 保険者発足情報_広域保険者_合併保険者_発足日 = DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_広域保険者_合併保険者_発足日, 基準日, SubGyomuCode.DBU介護統計報告);
        発足年月 = new FlexibleDate(保険者発足情報_広域保険者_合併保険者_発足日).getYearMonth();

        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(KakohorenJyohoSakuseiCommonEntity commonEntity) {
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
}
