/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.DBC020080JigyobunKogakuGassanJikofutangakuKeisanMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080JigyobunKogakuGassanJikofutangakuKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）の処理日付管理テーブル更新のプロセスクラスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyi
 */
public class UpdShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020080."
            + "IJigyobunKogakuGassanJikofutangakuKeisanMapper.select処理日付管理");
    private static final RString 処理枝番_0000 = new RString("0000");
    private static final RString 年度内連番_0001 = new RString("0001");
    private static final int NUM_4 = 4;
    private static final int NUM_1 = 1;
    private DBC020080JigyobunKogakuGassanJikofutangakuKeisanProcessParameter parameter;
    private DBC020080JigyobunKogakuGassanJikofutangakuKeisanMybatisParameter param;
    private boolean updateFlag;
    @BatchWriter
    private IBatchTableWriter<DbT7022ShoriDateKanriEntity> tableWriter;
    private RString 市町村コード;

    @Override
    protected void initialize() {
        市町村コード = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        updateFlag = false;
        param = new DBC020080JigyobunKogakuGassanJikofutangakuKeisanMybatisParameter();
        param.setサブ業務コード(SubGyomuCode.DBC介護給付);
        param.set処理名(ShoriName.事業分自己負担額計算.get名称());
        param.set処理枝番(処理枝番_0000);
        param.set市町村コード(new LasdecCode(市町村コード));
        param.set年度(FlexibleYear.MIN);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, param);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        updateFlag = true;
        DbT7022ShoriDateKanriEntity result = entity;
        result.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        result.setShichosonCode(new LasdecCode(市町村コード));
        result.setShoriName(ShoriName.事業分自己負担額計算.get名称());
        result.setShoriEdaban(処理枝番_0000);
        result.setNendo(FlexibleYear.MIN);
        result.setNendoNaiRenban(get新規年度内連番(entity.getNendoNaiRenban()));
        if (parameter.get受取年月() != null && !parameter.get受取年月().isEmpty()) {
            result.setKijunYMD(new FlexibleDate(parameter.get受取年月().getYearValue(), parameter.get受取年月().getMonthValue(), NUM_1));
        } else {
            result.setKijunYMD(FlexibleDate.EMPTY);
        }
        result.setTaishoKaishiYMD(new FlexibleDate(parameter.get処理日時().getDate().toDateString()));
        result.setTaishoShuryoYMD(FlexibleDate.EMPTY);
        tableWriter.insert(result);
    }

    private RString get新規年度内連番(RString 年度内連番) {
        if (年度内連番 == null) {
            return 年度内連番_0001;
        }
        Decimal dec = new Decimal(年度内連番.toString());
        return new RString(dec.add(Decimal.ONE).toString()).padZeroToLeft(NUM_4);
    }

    @Override
    protected void afterExecute() {
        if (!updateFlag) {
            DbT7022ShoriDateKanriEntity result = new DbT7022ShoriDateKanriEntity();
            result.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            result.setShichosonCode(new LasdecCode(市町村コード));
            result.setShoriName(ShoriName.事業分自己負担額計算.get名称());
            result.setShoriEdaban(処理枝番_0000);
            result.setNendo(FlexibleYear.MIN);
            result.setNendoNaiRenban(get新規年度内連番(null));
            if (parameter.get受取年月() != null && !parameter.get受取年月().isEmpty()) {
                result.setKijunYMD(new FlexibleDate(parameter.get受取年月().getYearValue(), parameter.get受取年月().getMonthValue(), NUM_1));
            } else {
                result.setKijunYMD(FlexibleDate.EMPTY);
            }
            result.setTaishoKaishiYMD(new FlexibleDate(parameter.get処理日時().getDate().toDateString()));
            result.setTaishoShuryoYMD(FlexibleDate.EMPTY);
            tableWriter.insert(result);
        }
    }

}
