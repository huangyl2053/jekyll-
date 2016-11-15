/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040040.JikofutanShomeishoProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 処理日付管理マスタUpdateのprocessクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class ShoriDateKanriInsertPocess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040."
                    + "IJikofutanShomeishoMapper.select処理日付管理");
    private JikofutanShomeishoProcessParameter parameter;
    private static final RString 連番 = new RString("0001");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 処理名 = new RString("自己負担証明書作成_一括");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private boolean isAdd;
    private LasdecCode 市町村コード;

    @BatchWriter
    private BatchPermanentTableWriter tableWriter;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        if (市町村コード != null) {
            parameter.set市町村コード(市町村コード);
        }
        isAdd = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        isAdd = false;
        entity.setTaishoKaishiYMD(parameter.get開始申請年月日());
        entity.setTaishoShuryoYMD(parameter.get終了申請年月日());
        entity.setNendo(年度);
        tableWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
        if (isAdd) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            entity.setShichosonCode(市町村コード);
            entity.setShoriName(処理名);
            entity.setShoriEdaban(連番);
            entity.setNendo(年度);
            entity.setNendoNaiRenban(年度内連番);
            entity.setKijunYMD(FlexibleDate.EMPTY);
            entity.setKijunTimestamp(new YMDHMS(RString.EMPTY));
            entity.setTaishoKaishiYMD(parameter.get開始申請年月日());
            entity.setTaishoShuryoYMD(parameter.get終了申請年月日());
            entity.setTaishoKaishiTimestamp(new YMDHMS(RString.EMPTY));
            entity.setTaishoShuryoTimestamp(new YMDHMS(RString.EMPTY));
            tableWriter.insert(entity);
        }
    }
}
