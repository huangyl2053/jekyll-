/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakoshinkekka.DbT3104KensakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 国保連インタフェース管理更新を実行する。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KokuhorenkyoutsuDoInterfaceKanriKousinByMybatisProcess extends BatchProcessBase<DbT3104KokuhorenInterfaceKanriEntity> {

    private static final RString 処理状態区分_終了 = new RString("3");
    private static final int 定数_0 = 0;
    private static final int 定数_1 = 1;
    private static final int 定数_2 = 2;
    private static final int 定数_3 = 3;
    private static final int 定数_4 = 4;

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter;

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.jukyushakoshinkekka.IJukyushaKoshinKekkaMapper.getDbT3104KokuhorenInterfaceKanri");

    @BatchWriter
    private BatchPermanentTableWriter dbT3104KokuhorenInterfaceKanriWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, createMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT3104KokuhorenInterfaceKanriWriter = new BatchPermanentTableWriter(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    @Override
    protected void process(DbT3104KokuhorenInterfaceKanriEntity entity) {

        entity.setShoriJotaiKubun(処理状態区分_終了);
        entity.setShoriJisshiTimestamp(YMDHMS.now());
        entity.setSaiShoriFukaKubun(false);
        entity.setShoriJikkoKaisu(getNotNull(entity.getShoriJikkoKaisu()));
        entity.setFileName1(getFileName(parameter.getFileNameList(), 定数_0));
        entity.setFileName2(getFileName(parameter.getFileNameList(), 定数_1));
        entity.setFileName3(getFileName(parameter.getFileNameList(), 定数_2));
        entity.setFileName4(getFileName(parameter.getFileNameList(), 定数_3));
        entity.setFileName5(getFileName(parameter.getFileNameList(), 定数_4));
        entity.setCtrlRecordKensu(parameter.getレコード件数合計());
        entity.setCtrlShoriYM(parameter.get処理対象年月());

        dbT3104KokuhorenInterfaceKanriWriter.update(entity);
    }

    private RString getFileName(List<RString> エントリ情報List, int 定数) {
        return (null == エントリ情報List || エントリ情報List.isEmpty() || エントリ情報List.size() <= 定数)
                ? RString.EMPTY : エントリ情報List.get(定数);
    }

    private Decimal getNotNull(Decimal decimal) {
        return (null == decimal) ? Decimal.ONE : decimal.add(Decimal.ONE);
    }

    private DbT3104KensakuMybatisParameter createMybatisParameter() {
        DbT3104KensakuMybatisParameter para = new DbT3104KensakuMybatisParameter();
        para.set交換情報識別番号(parameter.get交換情報識別番号());
        para.set処理年月(parameter.get処理年月());
        return para;
    }
}
