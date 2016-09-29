/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020060;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.SelectShoriDateKanriMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper;
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
 * 高額総合事業サービス費支給（不支給）決定通知書作成の一時テーブルのデータに設定
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class UpdateKogakuJigyoKetteiTsuchishoInfoTempProcess extends BatchProcessBase<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.get更新の判定結果データ");

    private static final RString フラグ_FALSE = new RString("false");
    private static final RString 抽出モード_受付日 = new RString("1");
    private static final RString 抽出モード_決定日 = new RString("2");
    private static final RString 抽出モード_決定者受付年月 = new RString("3");
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度_固定 = new FlexibleYear("0000");
    private static final RString 年度内連番_01 = new RString("01");

    private KogakuKaigoServiceProcessParameter parameter;
    private IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper mapper;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> permanentTableWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toパラメータ());
    }

    @Override
    protected void createWriter() {
        permanentTableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity) {
        // TODO QA1560
    }

    @Override
    protected void afterExecute() {
        if (フラグ_FALSE.equals(parameter.getテスト出力フラグ())) {
            SelectShoriDateKanriMybatisParameter mybatisParameter
                    = new SelectShoriDateKanriMybatisParameter(SubGyomuCode.DBC介護給付, 市町村コード,
                            ShoriName.高額サービス等支給不支給決定通知書一括作成.get名称(), 処理枝番, 年度_固定);
            int 年度内連番 = mapper.select最大年度内連番(mybatisParameter);
            permanentTableWriter.insert(get処理日付管理マスタ(年度内連番));
        }
    }

    private DbT7022ShoriDateKanriEntity get処理日付管理マスタ(int 度内連番) {
        DbT7022ShoriDateKanriEntity tempEntity = new DbT7022ShoriDateKanriEntity();
        tempEntity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        tempEntity.setShichosonCode(市町村コード);
        tempEntity.setShoriName(ShoriName.高額サービス等支給不支給決定通知書一括作成.get名称());
        tempEntity.setShoriEdaban(処理枝番);
        tempEntity.setNendo(年度_固定);
        if (度内連番 == 0) {
            tempEntity.setNendoNaiRenban(年度内連番_01);
        } else {
            tempEntity.setNendoNaiRenban(new RString(度内連番 + 1).padZeroToLeft(2));
        }
        if (抽出モード_受付日.equals(parameter.get抽出モード()) || 抽出モード_決定日.equals(parameter.get抽出モード())) {
            tempEntity.setTaishoKaishiYMD(new FlexibleDate(parameter.get抽出条件日付From().toDateString()));
            tempEntity.setTaishoShuryoYMD(new FlexibleDate(parameter.get抽出条件日付To().toDateString()));
        } else if (抽出モード_決定者受付年月.equals(parameter.get抽出モード())) {
            RString 月初日 = parameter.get決定者受付年月().toDateString().concat(new RString(1));
            RString 月末日 = parameter.get決定者受付年月().toDateString()
                    .concat(new RString(parameter.get決定者受付年月().getLastDay()));
            tempEntity.setTaishoKaishiYMD(new FlexibleDate(月初日));
            tempEntity.setTaishoShuryoYMD(new FlexibleDate(月末日));
        }
        return tempEntity;
    }
}
