/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.Ido1TmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdoTblTmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.TmpDataEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * DB出力(異動一時1Tempの作成クラスです。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsIdoIchiji1TempTempProcess extends BatchProcessBase<IdoTblTmpEntity> {

    private static final RString MYBATIS_ID = new RString("");

    private static final RString TABLE_NAME = new RString("Ido1Tmp");
    private static final RString 定数_01 = new RString("01");
    private static final RString 定数_02 = new RString("02");
    private static final RString 定数_03 = new RString("03");
    private static final RString 定数_04 = new RString("04");
    private static final RString 定数_05 = new RString("05");
    private static final RString 定数_06 = new RString("06");
    private static final RString 定数_07 = new RString("07");
    private static final RString 定数_08 = new RString("08");
    private static final RString 定数_09 = new RString("09");
    private static final RString 定数_10 = new RString("10");
    private static final RString 定数_11 = new RString("11");
    private static final RString 定数_12 = new RString("12");
    private static final RString 定数_13 = new RString("13");
    private static final RString 定数_14 = new RString("14");
    private static final RString 定数_15 = new RString("15");
    private static final RString 定数_16 = new RString("16");
    private static final RString 定数_17 = new RString("17");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, Ido1TmpEntity.class);
    }

    @Override
    protected void process(IdoTblTmpEntity entity) {
        List<TmpDataEntity> temp = getTmpData(entity);
        RString エリア = entity.toRString();
        for (TmpDataEntity data : temp) {
            Ido1TmpEntity idoEntity = new Ido1TmpEntity();
            idoEntity.set被保険者番号(entity.get被保険者番号().getColumnValue());
            idoEntity.set履歴番号(entity.get履歴番号());
            idoEntity.setデータ区分(data.getデータ区分());
            idoEntity.set異動日(data.get異動日());
            idoEntity.set終了日(data.get終了日());
            idoEntity.set異動一時1テーブルエリア(エリア);
            idoEntity.setState(EntityDataState.Added);
            tempDbWriter.insert(idoEntity);
        }
    }

    private List<TmpDataEntity> getTmpData(IdoTblTmpEntity entity) {
        List<TmpDataEntity> temp = new ArrayList<>();
        if (!RString.isNullOrEmpty(entity.get認定有効期間開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get認定有効期間開始年月日());
            data.set終了日(entity.get認定有効期間終了年月日());
            data.setデータ区分(定数_01);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get居宅サービス計画適用開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get居宅サービス計画適用開始年月日());
            data.set終了日(entity.get居宅サービス計画適用終了年月日());
            data.setデータ区分(定数_02);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get訪問通所サービス上限管理適用期間開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get訪問通所サービス上限管理適用期間開始年月日());
            data.set終了日(entity.get訪問通所サービス上限管理適用期間終了年月日());
            data.setデータ区分(定数_03);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get短期入所サービス上限管理適用期間開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get短期入所サービス上限管理適用期間開始年月日());
            data.set終了日(entity.get短期入所サービス上限管理適用期間終了年月日());
            data.setデータ区分(定数_04);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get償還払化開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get償還払化開始年月日());
            data.set終了日(entity.get償還払化終了年月日());
            data.setデータ区分(定数_05);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get給付率引下げ開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get給付率引下げ開始年月日());
            data.set終了日(entity.get給付率引下げ終了年月日());
            data.setデータ区分(定数_06);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get適用開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get適用開始年月日());
            data.set終了日(entity.get適用終了年月日());
            data.setデータ区分(定数_07);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get負担額適用開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get負担額適用開始年月日());
            data.set終了日(entity.get負担額適用終了年月日());
            data.setデータ区分(定数_08);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get負担限度額適用開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get負担限度額適用開始年月日());
            data.set終了日(entity.get負担限度額適用終了年月日());
            data.setデータ区分(定数_09);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get軽減率適用開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get軽減率適用開始年月日());
            data.set終了日(entity.get軽減率適用終了年月日());
            data.setデータ区分(定数_10);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get二次予防事業有効期間開始年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get二次予防事業有効期間開始年月日());
            data.set終了日(entity.get二次予防事業有効期間終了年月日());
            data.setデータ区分(定数_11);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get住所地特例適用開始日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get住所地特例適用開始日());
            data.set終了日(entity.get住所地特例適用終了日());
            data.setデータ区分(定数_12);
            temp.add(data);
        }
        if (!RString.isNullOrEmpty(entity.get利用者負担割合有効開始日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get利用者負担割合有効開始日());
            data.set終了日(entity.get利用者負担割合有効終了日());
            data.setデータ区分(定数_13);
            temp.add(data);
        }
//        if (!RString.isNullOrEmpty(entity.get受給開始日())) {
//            TmpDataEntity data = new TmpDataEntity();
//            data.set異動日(entity.get受給開始日());
//            data.set終了日(entity.get受給廃止日());
//            data.setデータ区分(定数_14);
//            temp.add(data);
//        }
//        if (!RString.isNullOrEmpty(entity.get適用開始日())) {
//            TmpDataEntity data = new TmpDataEntity();
//            data.set異動日(entity.get適用開始日());
//            data.set終了日(entity.get適用終了日());
//            data.setデータ区分(定数_15);
//            temp.add(data);
//        }
//        if (定数_11.equals(entity.get資格取得事由コード())) {
//            TmpDataEntity data = new TmpDataEntity();
//            data.set異動日(entity.get異動日());
//            data.setデータ区分(定数_17);
//            temp.add(data);
//        } else
        if (!RString.isNullOrEmpty(entity.get資格取得年月日())) {
            TmpDataEntity data = new TmpDataEntity();
            data.set異動日(entity.get資格取得年月日());
            data.set喪失日(entity.get資格喪失年月日());
            data.setデータ区分(定数_16);
            temp.add(data);
        }
        return temp;
    }

}
