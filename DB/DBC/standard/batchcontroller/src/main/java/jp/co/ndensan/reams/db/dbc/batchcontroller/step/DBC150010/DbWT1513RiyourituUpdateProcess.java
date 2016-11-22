/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_ServiceKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 在宅利用率、訪問利用率、短期利用率の更新のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513RiyourituUpdateProcess extends BatchProcessBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select利用率情報");

    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    private static final int ZERO = 0;
    private static final int 数字_100 = 100;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
    }

    @Override
    protected void process(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        entity.setZaitakuRiyoritsu(利用率算出(RiyoJokyoTokeihyoMeisaiListSakuseiService.add(
                entity.getHomonRiyoServiceTanisu(), entity.getTankiRiyoServiceTanisu()),
                entity.getHomonShikyuGendogaku(), entity.getServiceKubun()));
        entity.setHomonRiyoritsu(利用率算出(entity.getHomonRiyoServiceTanisu(),
                entity.getHomonShikyuGendogaku(), entity.getServiceKubun()));
        entity.setTankiRiyoritsu(利用率算出(entity.getTankiRiyoServiceTanisu(),
                entity.getHomonShikyuGendogaku(), entity.getServiceKubun()));
        利用状況統計表一時TBL.update(entity);
    }

    private RString 利用率算出(RString 単位数, RString 限度額, RString サービス区分) {
        Decimal 単位数Del = new Decimal(単位数.toString());
        if (1 <= 単位数Del.intValue()) {
            Decimal 限度額Del = new Decimal(限度額.toString());
            return DecimalFormatter.toRString(単位数Del.divide(限度額Del).multiply(数字_100), ZERO);
        } else if (RiyojokyoTokeihyo_ServiceKubun.在宅.getコード().equals(サービス区分)
                || RiyojokyoTokeihyo_ServiceKubun.混在.getコード().equals(サービス区分)) {
            return new RString("000");
        } else {
            return RString.EMPTY;
        }
    }
}
