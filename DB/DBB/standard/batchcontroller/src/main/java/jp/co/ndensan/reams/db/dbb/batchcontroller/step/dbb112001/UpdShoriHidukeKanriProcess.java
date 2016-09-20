/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.KaigoShotoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 所得情報抽出・連携バッチの処理日付管理マスタの更新Processです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class UpdShoriHidukeKanriProcess extends BatchProcessBase<KaigoShotoTempTableEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "toushoshotokujohochushutsurenkei.IToushoShotokuJohoChushutsuRenkeiMapper.get介護所得Temp");
    private static final RString 当初_広域_1 = new RString("1");
    private static final RString 異動_広域_2 = new RString("2");
    private static final RString 当初_単一_3 = new RString("3");
    private static final RString 異動_単一_4 = new RString("4");
    private static final RString 処理枝番_00 = new RString("00");
    private static final RString 枝番_0001 = new RString("0001");
    private static final int INT_1 = 1;
    private static final int INT_4 = 4;

    private ShutokuJohoShuchutsuRenkeiProcessParameter processParameter;
    private RString 処理区分;
    private YMDHMS バッチ起動処理日時;
    private FlexibleYear 処理年度;
    private LasdecCode 市町村コード;

    @BatchWriter
    BatchPermanentTableWriter 処理日付管理7022tableWriter;

    @Override
    protected void initialize() {
        処理区分 = processParameter.get処理区分();
        バッチ起動処理日時 = processParameter.get処理日時();
        処理年度 = processParameter.get処理年度();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        市町村コード = finder.getAssociation().get地方公共団体コード();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        処理日付管理7022tableWriter
                = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(KaigoShotoTempTableEntity entity) {
        if (当初_広域_1.equals(処理区分) || 当初_単一_3.equals(処理区分)) {
            DbT7022ShoriDateKanriEntity dbt7022Entity = get処理日付管理_当初(entity);
            処理日付管理7022tableWriter.update(dbt7022Entity);
        } else if (異動_広域_2.equals(処理区分) || 異動_単一_4.equals(処理区分)) {
            DbT7022ShoriDateKanriEntity dbt7022Entity = get処理日付管理_異動(entity);
            処理日付管理7022tableWriter.insert(dbt7022Entity);
        }
    }

    @Override
    protected void afterExecute() {
        RString 日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (当初_広域_1.equals(processParameter.get処理区分()) || 当初_単一_3.equals(processParameter.get処理区分())) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課,
                    ConfigNameDBB.日付関連_所得年度, 日付関連_調定年度, RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        }
    }

    private DbT7022ShoriDateKanriEntity get処理日付管理_当初(KaigoShotoTempTableEntity entity) {
        RString 処理枝番;
        if (当初_広域_1.equals(処理区分)) {
            処理枝番 = 処理枝番_00.concat(entity.getShichosonShikibetuId());
        } else {
            処理枝番 = 枝番_0001;
        }
        ShoriDateKanri result = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(
                SubGyomuCode.DBB介護賦課, entity.getShichosonCode(), ShoriName.当初所得引出.get名称(), 処理枝番, 処理年度, 枝番_0001);
        DbT7022ShoriDateKanriEntity dbt7022Entity = result.toEntity();
        dbt7022Entity.setKijunTimestamp(バッチ起動処理日時);
        dbt7022Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
        return dbt7022Entity;
    }

    private DbT7022ShoriDateKanriEntity get処理日付管理_異動(KaigoShotoTempTableEntity entity) {
        RString 最大年度内連番;
        YMDHMS 対象開始日時;
        RString 処理枝番;
        DbT7022ShoriDateKanriEntity dbt7022Entity = new DbT7022ShoriDateKanriEntity();
        if (異動_広域_2.equals(処理区分)) {
            処理枝番 = 処理枝番_00.concat(entity.getShichosonShikibetuId());
        } else {
            処理枝番 = 枝番_0001;
        }
        dbt7022Entity.setShoriEdaban(処理枝番);
        dbt7022Entity.setShichosonCode(市町村コード);
        DbT7022ShoriDateKanriEntity result = ShoriDateKanriManager.createInstance()
                .select処理日付管理マスタ_所得情報抽出連携異動(処理年度, ShoriName.所得引出.get名称(), 処理枝番, SubGyomuCode.DBB介護賦課);
        if (result != null) {
            最大年度内連番 = new RString((Integer.valueOf(result.getNendoNaiRenban().toString()) + INT_1)).padZeroToLeft(INT_4);
            対象開始日時 = result.getTaishoShuryoTimestamp();
        } else {
            最大年度内連番 = 枝番_0001;
            DbT7022ShoriDateKanriEntity result前年度 = ShoriDateKanriManager.createInstance().select処理日付管理マスタ_所得情報抽出連携異動(
                    処理年度.minusYear(INT_1), ShoriName.所得引出.get名称(), 処理枝番, SubGyomuCode.DBB介護賦課);
            対象開始日時 = result前年度.getTaishoShuryoTimestamp();
        }
        dbt7022Entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        dbt7022Entity.setShoriName(ShoriName.所得引出.get名称());
        dbt7022Entity.setNendo(処理年度);
        dbt7022Entity.setNendoNaiRenban(最大年度内連番);
        dbt7022Entity.setTaishoKaishiTimestamp(対象開始日時);
        dbt7022Entity.setKijunTimestamp(バッチ起動処理日時);
        dbt7022Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
        return dbt7022Entity;
    }

}
