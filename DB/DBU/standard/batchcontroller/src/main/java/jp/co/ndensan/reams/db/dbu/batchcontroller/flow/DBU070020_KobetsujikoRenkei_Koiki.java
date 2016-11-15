/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU070020.KaiGoJuminHyokouKiuDBUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU070020.KaiGoJuminHyokouKiuEucCsvProcess;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyokobetsukoikiunyo.KaigoJuminhyoKobetsuKoikiunyo;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU070020.DBU070020_KobetsujikoRenkei_KoikiParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KobetsuKoikiunyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuProcessParameter;
import jp.co.ndensan.reams.db.dbu.service.core.kaigojuminhyobatchparameter.KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public class DBU070020_KobetsujikoRenkei_Koiki extends BatchFlowBase<DBU070020_KobetsujikoRenkei_KoikiParameter> {

    private List<KaigoJuminhyoKobetsuKoikiunyo> koikiunyoEntityList;
    private KobetsuKoikiunyoParameter kaigojuminiEntity;
    private KaiGoJuminHyokouKiuProcessParameter processpaam;

    @Override
    protected void initialize() {
        koikiunyoEntityList = new ArrayList<>();
        processpaam = new KaiGoJuminHyokouKiuProcessParameter(getParameter().getKobetsuKoikiunyoParameterList());
    }

    @Override
    protected void defineFlow() {
        if (getParameter().getKobetsuKoikiunyoParameterList() == null || getParameter().getKobetsuKoikiunyoParameterList().isEmpty()) {
            KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder 広域運用抽出期間情報リスト = new KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder();
            koikiunyoEntityList = 広域運用抽出期間情報リスト.getKoikiunyoChushutsukikanJohoList().records();
            for (KaigoJuminhyoKobetsuKoikiunyo entitylist : koikiunyoEntityList) {
                kaigojuminiEntity = new KobetsuKoikiunyoParameter();
                kaigojuminiEntity.setShichosonCode(entitylist.getShichosonCode().value());
                kaigojuminiEntity.setDateFrom(entitylist.getTaishoShuryoTimestamp().getRDateTime());
                kaigojuminiEntity.setDateTo(YMDHMS.now().getRDateTime());
                if (!kaigojuminiEntity.getDateFrom().isBefore(kaigojuminiEntity.getDateTo())) {
                    throw new BatchInterruptedException(DbzErrorMessages.期間が不正_未来日付不可.getMessage().toString());
                }
                getParameter().getKobetsuKoikiunyoParameterList().add(kaigojuminiEntity);
            }
        }
        for (KobetsuKoikiunyoParameter kyparameter : getParameter().getKobetsuKoikiunyoParameterList()) {
            processpaam.setDateFrom(kyparameter.getDateFrom());
            processpaam.setDateTo(kyparameter.getDateTo());
            processpaam.setShichosonCode(kyparameter.getShichosonCode());
            executeStep(KAIGOJUMINHYO_EUC_CSV_PROCESS);
            executeStep(KAIGOJUMINHYO_DB_UPD_PROCESS);
        }
    }

    private static final String KAIGOJUMINHYO_EUC_CSV_PROCESS = "KaiGoJuminHyokouKiuEucCsvProcess";
    private static final String KAIGOJUMINHYO_DB_UPD_PROCESS = "KaiGoJuminHyokouKiuDBUpdateProcess";

    /**
     * CSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(KAIGOJUMINHYO_EUC_CSV_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoEucCsvProcess() {
        return loopBatch(KaiGoJuminHyokouKiuEucCsvProcess.class).arguments(processpaam).define();
    }

    /**
     * DB登録またはDB更新です。
     *
     * @return 登録または更新件数
     */
    @Step(KAIGOJUMINHYO_DB_UPD_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoDBUpdateProcess() {
        return loopBatch(KaiGoJuminHyokouKiuDBUpdateProcess.class).arguments(processpaam).define();
    }
}
