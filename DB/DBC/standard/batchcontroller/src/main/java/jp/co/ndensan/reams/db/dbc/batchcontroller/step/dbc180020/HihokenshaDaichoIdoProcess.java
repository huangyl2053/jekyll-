/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020;

import jp.co.ndensan.reams.db.dbc.business.core.idoriyoshafutanwariaihantei.HanteiTaishoshaTempEditor;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.IdoDateTyuushutuKyoutsuuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.idoriyoshafutanwariaihantei.IdoRiyoshaDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳異動データ抽出のprocessクラスです。
 *
 * @reamsid_L DBC-4950-033 pengxingyi
 */
public class HihokenshaDaichoIdoProcess extends BatchProcessBase<IdoRiyoshaDateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.idoriyoshafutanwariaihantei."
                    + "IIdoRiyoshaFutanwariaiHanteiMapper.select被保険者台帳異動");
    private IdoDateTyuushutuKyoutsuuProcessParameter parameter;
    private RString 出力条件;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;

    private static final RString 異動種別_3 = new RString("3");
    private static final RString 出力条件_受給者台帳 = new RString("1");
    private static final RString 出力条件_総合事業対象者 = new RString("2");
    private static final RString 出力条件_なし = new RString("0");
    private static final RString TABLE_NAME = new RString("HanteiTaishoshaTemp");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, HanteiTaishoshaTempEntity.class);
    }

    @Override
    protected void process(IdoRiyoshaDateEntity entity) {
        出力条件 = RString.EMPTY;
        if (entity.get受給者台帳() != null) {
            出力条件 = 出力条件_受給者台帳;
        } else if (entity.get総合事業対象者() != null) {
            出力条件 = 出力条件_総合事業対象者;
        } else {
            出力条件 = 出力条件_なし;
        }
        HanteiTaishoshaTempEditor edit = new HanteiTaishoshaTempEditor(entity, 異動種別_3, 出力条件, parameter);
        tableWriter.insert(edit.get出力データ());
    }

}
