/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110900;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon.HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon.KakohorenJyohoSakuseiCommonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 被保険者一時TBL;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;

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
}
