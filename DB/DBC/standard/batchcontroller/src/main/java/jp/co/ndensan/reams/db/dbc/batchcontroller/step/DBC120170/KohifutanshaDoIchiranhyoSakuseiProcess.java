/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain.KagoKetteiKohifutanshaInProperty.KagoKetteiKohifutanshaInBreakerFieldsEnum;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshainkouhifutann.KagoKetteiKohifutanshaChohyoManager;
import jp.co.ndensan.reams.db.dbc.service.report.kagoketteikohifutanshain.KagoKetteiKohifutanshaInPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 一覧表作成。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KohifutanshaDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;

    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");

    @Override
    protected void process() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == order) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        Map<String, Object> mybatisParameter = new HashMap<>();
        RString 出力順 = MyBatisOrderByClauseCreator.create(KagoKetteiKohifutanshaInBreakerFieldsEnum.class, order);
        mybatisParameter.put(キー_出力順.toString(), 出力順);
        KagoKetteiKohifutanshaChohyoManager manager = KagoKetteiKohifutanshaChohyoManager.createInstance();
        List<KagoKetteiKohifutanshaChohyoEntity> list = manager.get帳票出力対象データ(mybatisParameter);
        KagoKetteiKohifutanshaInPrintService printService = new KagoKetteiKohifutanshaInPrintService();
        printService.printTaitsu(list, order, parameter.get処理年月(), parameter.getシステム日付());

        Set<HihokenshaNo> 被保険者番号set = new HashSet<>();
        for (KagoKetteiKohifutanshaChohyoEntity entity : list) {
            if (null == entity.get被保険者番号() || entity.get被保険者番号().isEmpty()) {
                continue;
            }
            if (被保険者番号set.contains(entity.get被保険者番号())) {
                continue;
            }
            被保険者番号set.add(entity.get被保険者番号());
            AccessLogger.log(AccessLogType.照会, toPersonalData(entity.get識別コード(), entity.get被保険者番号()));
        }
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

}
