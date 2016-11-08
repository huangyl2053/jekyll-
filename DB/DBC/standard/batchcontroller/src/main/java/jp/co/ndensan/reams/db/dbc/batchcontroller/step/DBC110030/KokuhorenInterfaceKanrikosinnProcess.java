/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka.HonnsanteiFukaProcessParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouSofuListTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 国保連インターフェース管理更新の処理です。
 *
 * @reamsid_L DBC-2770-050 jinjue
 */
public class KokuhorenInterfaceKanrikosinnProcess extends BatchProcessBase<DbT3104KokuhorenInterfaceKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper.select国保連インターフェース管理");
    private static final RString 交換情報識別番号 = new RString("5C3");
    private static final RString 処理状態区分 = new RString("3");
    private static final RString 再処理区分 = new RString("1");
    private List<IdouSofuListTempEntity> 送付対象リスト;
    private HonnsanteiFukaProcessParamter processParameter;
    private IHonnSanteiFukaMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3104KokuhorenInterfaceKanriEntity> 国保連;

    @Override
    protected void initialize() {
        mapper = getMapper(IHonnSanteiFukaMapper.class);
        送付対象リスト = mapper.select送付対象リスト();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        国保連 = new BatchPermanentTableWriter<>(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    @Override
    protected void process(DbT3104KokuhorenInterfaceKanriEntity entity) {
        if (processParameter.get処理対象年月().equals(entity.getShoriYM().toDateString()) && 交換情報識別番号.equals(entity.getKokanShikibetsuNo())) {
            entity.setShoriJotaiKubun(処理状態区分);
            entity.setShoriJisshiTimestamp(new YMDHMS(RDateTime.convertFrom(RDate.getNowDate(), RTime.now())));
            if (再処理区分.equals(processParameter.get再処理区分())) {
                entity.setSaiShoriKanoKubun(true);
            } else {
                entity.setSaiShoriKanoKubun(false);
            }
            Decimal 実行回数 = entity.getShoriJikkoKaisu();
            if (実行回数 != null) {
                entity.setShoriJikkoKaisu(実行回数.add(Decimal.ONE));
            } else {
                entity.setShoriJikkoKaisu(Decimal.ONE);
            }
            entity.setFileKensu1(送付対象リスト.size() + 2);
            entity.setCtrlRecordKensu(送付対象リスト.size());
            国保連.update(entity);
        }
    }
}
