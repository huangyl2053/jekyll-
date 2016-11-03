/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050023;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiDataJukyushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給取得状況データ取得_事業高額合算Process処理クラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class JigyoKogakuGassanJukyushaProcess extends BatchProcessBase<FurikomimeisaiDataJukyushaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.select受給取得状況情報_高額合算と事業高額合算");
    private static final RString 振込明細一時NAME = new RString("DbWT0510FurikomiMeisai");

    private FurikomimeisaiFurikomiDataProcessParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 振込明細一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        振込明細一時tableWriter = new BatchEntityCreatedTempTableWriter(振込明細一時NAME, DbWT0510FurikomiMeisaiTempEntity.class);
    }

    @Override
    protected void process(FurikomimeisaiDataJukyushaEntity t) {
        DbWT0510FurikomiMeisaiTempEntity data = t.get振込明細一時Entity();
        data.setShinseiKubunCode(t.get要介護認定申請情報entity().getNinteiShinseiShinseijiKubunCode());
        data.setYokaigoJotaiKubunCode(t.get受給者台帳entity().getYokaigoJotaiKubunCode());
        data.setNinteiYukoKikanKaishiYMD(t.get受給者台帳entity().getNinteiYukoKikanKaishiYMD());
        data.setNinteiYukoKikanShuryoYMD(t.get受給者台帳entity().getNinteiYukoKikanShuryoYMD());
        振込明細一時tableWriter.update(data);
    }
}
