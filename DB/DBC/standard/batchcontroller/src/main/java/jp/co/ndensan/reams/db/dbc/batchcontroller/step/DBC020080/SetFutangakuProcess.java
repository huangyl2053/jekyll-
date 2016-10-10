/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DbT3070MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.journal.JournalWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の<br/>
 * 計算結果を「高額合算自己負担額」、「高額合算自己負担額明細」に登録のプロセスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class SetFutangakuProcess extends BatchProcessBase<DbT3070MatchingEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.getFutangaku");
    private DBC020080ProcessParameter parameter;
    private DBC020080DataUtil util;
    private Decimal 抽出対象自己負担基準額;
    private RDateTime システム日時;
    @BatchWriter
    private IBatchTableWriter<DbT3070KogakuGassanJikoFutanGakuEntity> 高額合算自己負担額Writer;
    @BatchWriter
    private IBatchTableWriter<DbT3071KogakuGassanJikoFutanGakuMeisaiEntity> 高額合算自己負担額明細Writer;
    @BatchWriter
    private IBatchTableWriter<JissekiFutangakuDataTempEntity> 実績負担額TempWriter;

    @Override
    protected void initialize() {
        システム日時 = RDate.getNowDateTime();
        util = new DBC020080DataUtil();
        RString configValue = DbBusinessConfig.get(
                ConfigNameDBC.高額合算自己負担額計算_抽出対象自己負担基準額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        抽出対象自己負担基準額 = new Decimal(configValue.toString());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toDBC020080MyBatisParameter());
    }

    @Override
    protected void process(DbT3070MatchingEntity entity) {
        JissekiFutangakuDataTempEntity 実績負担額 = entity.get実績負担額データ();
        DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額 = entity.get高額合算自己負担額();
        if (高額合算自己負担額 == null) {
            new JournalWriter().writeWarningJournal(システム日時, util.getErrorMessage(実績負担額));
            return;
        }
        if (util.judge抽出対象自己負担基準額(高額合算自己負担額, 抽出対象自己負担基準額)) {
//TODO  ＜中間DB＞実績負担額データに補正済データを上書き、
//            詳細は「DB出力（実績負担額データ)」の「③SetFutangaku　処理時」を参照する。
        }
//TODO ＜中間DB＞実績負担額データを「高額合算自己負担額」テーブル、「高額合算自己負担額明細」テーブルに更新登録を行う
    }
}
