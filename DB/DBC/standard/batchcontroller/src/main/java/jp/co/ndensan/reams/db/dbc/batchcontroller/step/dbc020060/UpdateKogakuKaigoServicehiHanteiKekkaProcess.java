/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020060;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額総合事業サービス費支給（不支給）決定通知書作成のDB更新処理Processです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class UpdateKogakuKaigoServicehiHanteiKekkaProcess extends
        BatchProcessBase<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.get更新の判定結果データ");
    private static final RString 抽出モード_受付日 = new RString("1");
    private static final RString 抽出モード_決定日 = new RString("2");
    private static final RString 抽出モード_決定者受付年月 = new RString("3");
    private static final RString 市町村コード = new RString("000000");
    private static final RString 処理枝番 = new RString("0000");
    private static final RString 年度_固定 = new RString("0000");
    private static final RString 年度内連番_01 = new RString("01");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;

    private KogakuKaigoServiceProcessParameter parameter;
    ServicehiShikyuKetteiTsuchisho manager;

    private int 度内連番;

    @BatchWriter
    BatchPermanentTableWriter<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> 支給判定結果Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> 処理日付管理マスタwriter;

    @Override
    protected void initialize() {
        manager = ServicehiShikyuKetteiTsuchisho.createInstance();
        度内連番 = manager.get年度内連番();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toパラメータ());
    }

    @Override
    protected void createWriter() {

        支給判定結果Writer = new BatchPermanentTableWriter<>(DbT3111JigyoKogakuShikyuHanteiKekkaEntity.class);
        処理日付管理マスタwriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void beforeExecute() {
        DbT7022ShoriDateKanriEntity trmpEntity = getShoriDateEntity(度内連番);
        処理日付管理マスタwriter.insert(trmpEntity);
    }

    @Override
    protected void process(DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity) {

        if (null != parameter.get決定日()) {
            entity.setKetteiYMD(new FlexibleDate(parameter.get決定日().toDateString()));
            支給判定結果Writer.update(entity);
        }
    }

    private DbT7022ShoriDateKanriEntity getShoriDateEntity(int 年度内連番) {
        DbT7022ShoriDateKanriEntity tempEntity = new DbT7022ShoriDateKanriEntity();
        tempEntity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        tempEntity.setShichosonCode(new LasdecCode(市町村コード));
        tempEntity.setShoriName(ShoriName.事業高額サービス等支給不支給決定通知書一括作成.get名称());
        tempEntity.setShoriEdaban(処理枝番);
        tempEntity.setNendo(new FlexibleYear(年度_固定));
        if (年度内連番 == INDEX_0) {
            tempEntity.setNendoNaiRenban(年度内連番_01);
        } else {
            tempEntity.setNendoNaiRenban(new RString(年度内連番 + INDEX_1));
        }
        if (抽出モード_受付日.equals(parameter.get抽出モード()) || 抽出モード_決定日.equals(parameter.get抽出モード())) {
            tempEntity.setTaishoKaishiYMD(new FlexibleDate(parameter.get抽出条件日付From().toDateString()));
            tempEntity.setTaishoShuryoYMD(new FlexibleDate(parameter.get抽出条件日付To().toDateString()));
        } else if (抽出モード_決定者受付年月.equals(parameter.get抽出モード())) {
            RString 月初日 = parameter.get決定者受付年月().toDateString().concat(new RString(INDEX_1));
            RString 月末日 = parameter.get決定者受付年月().toDateString()
                    .concat(new RString(parameter.get決定者受付年月().getLastDay()));
            tempEntity.setTaishoKaishiYMD(new FlexibleDate(月初日));
            tempEntity.setTaishoShuryoYMD(new FlexibleDate(月末日));
        }
        return tempEntity;
    }
}
