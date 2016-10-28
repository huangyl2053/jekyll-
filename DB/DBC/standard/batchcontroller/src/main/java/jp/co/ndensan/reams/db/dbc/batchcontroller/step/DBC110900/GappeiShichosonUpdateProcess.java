/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110900;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kakohorenjyohosakusei.HihokenshaTempUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon.KakohorenJyohoSakuseiCommonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報作成共通処理（証記載保険者番号取得）プロセスです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
public class GappeiShichosonUpdateProcess extends BatchProcessBase<KakohorenJyohoSakuseiCommonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kakohorenjyohosakuseicommon.IKakohorenJyohoSakuseiCommonMapper."
            + "select合併市町村情報");
    private static final RString 被保険者一時TBL_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時TBL_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString 編集区分_2 = new RString("2");
    private static final RString 変換対象フラグ_FALSE = new RString("0");
    private static final RString 変換対象フラグ_TRUE = new RString("1");
    private HihokenshaTempUpdateProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;
    private RString 保険者番号 = RString.EMPTY;
    private RString 変換対象フラグ = new RString("0");

    @Override
    protected IBatchReader createReader() {
        被保険者一時TBL = new BatchEntityCreatedTempTableWriter(被保険者一時TBL_NAME,
                HihokenshaTempEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TBL_NAME,
                KokuhorenSakuseiErrorTempEntity.class);
        RDate 基準日 = RDate.getNowDate();
        保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 保険者発足情報_認定有効期間_編集区分 = DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, 基準日, SubGyomuCode.DBU介護統計報告);
        if (編集区分_2.equals(保険者発足情報_認定有効期間_編集区分)) {
            変換対象フラグ = 変換対象フラグ_TRUE;
        }
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParamterBy合併年月日());
    }

    @Override
    protected void process(KakohorenJyohoSakuseiCommonEntity commonEntity) {
        HihokenshaTempEntity hihokenshaTempEntity = commonEntity.getHihokenshaTempEntity();
        DbT7056GappeiShichosonEntity dbT7056Entity = commonEntity.getDbT7056Entity();
        RString henkanFlag = hihokenshaTempEntity.getHenkanFlag();
        FlexibleDate unyoKaishiYMD = dbT7056Entity.getUnyoKaishiYMD();
        FlexibleDate unyoShuryoYMD = dbT7056Entity.getUnyoShuryoYMD();
        if (!変換対象フラグ_TRUE.equals(henkanFlag)) {
            HokenshaNo kyuHokenshaNo = dbT7056Entity.getKyuHokenshaNo();
            if (kyuHokenshaNo != null) {
                hihokenshaTempEntity.setExHokenshaNo(kyuHokenshaNo.value());
                hihokenshaTempEntity.setExShoHokenshaNo(kyuHokenshaNo.value());
            }
            hihokenshaTempEntity.setHenkanFlag(変換対象フラグ_FALSE);
            hihokenshaTempEntity.setShichosonKanyuYmd(unyoKaishiYMD);
            hihokenshaTempEntity.setShichosonDattaiYmd(unyoKaishiYMD);
        } else {
            hihokenshaTempEntity.setHenkanFlag(変換対象フラグ_TRUE);
            if (unyoShuryoYMD != null) {
                hihokenshaTempEntity.setShichosonKanyuYmd(unyoShuryoYMD.plusDay(1));
            }
            hihokenshaTempEntity.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        }
        被保険者一時TBL.update(hihokenshaTempEntity);
    }
}
