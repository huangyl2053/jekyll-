/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.Ido1TmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdoTblTmpEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.IdoKubunType;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データレコード書込みクラスです。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsIdoIchiji1TempProcess extends BatchProcessBase<Ido1TmpEntity> {

    private static final RString MYBATIS_ID = new RString("");

    private static final RString TABLE_NAME = new RString("IdoTmp2");
    private static final RString パイプ = new RString("|");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final RString 定数_5 = new RString("5");
    private static final RString 定数_6 = new RString("6");
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

    private Ido1TmpEntity before;
    private List<Ido1TmpEntity> list;
    private int count = 0;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, IdoTblTmpEntity.class);
    }

    @Override
    protected void process(Ido1TmpEntity entity) {
        if (before == null) {
            before = entity;
            list.add(entity);
            return;
        }
        if (before.get被保険者番号().equals(entity.get被保険者番号())) {
            list.add(entity);
        } else {
            insertIdoTmp2();
            list.clear();
            list.add(entity);
            before = entity;
        }
    }

    private void insertIdoTmp2() {
        RString idoDate = null;
        IdoTblTmpEntity tmp = null;
        for (Ido1TmpEntity entity : list) {
            if (idoDate != null && !entity.get異動日().equals(idoDate)) {
                tempDbWriter.insert(tmp);
                idoDate = entity.get異動日();
                tmp = new IdoTblTmpEntity();
                setInitTmpData(tmp, entity);
            }
            if (idoDate == null) {
                idoDate = entity.get異動日();
                tmp = new IdoTblTmpEntity();
                setInitTmpData(tmp, entity);
            }
        }
    }

    private RString getValue(RString value) {
        return RString.isNullOrEmpty(value) ? null : value;
    }

    private void setInitTmpData(IdoTblTmpEntity tmp, Ido1TmpEntity entity) {
        count = count + 1;
        List<RString> tempList = entity.get異動一時1テーブルエリア().split(パイプ.toString());
        tmp.set被保険者番号(new HihokenshaNo(entity.get被保険者番号()));
        tmp.set異動年月日(entity.get異動日());
        tmp.set履歴番号(new RString(count));
        tmp.set異動区分コード(IdoKubunType.追加.toRString());
        // TODO 合併情報．合併年月日 テーブルに、該当情報がありません。　QA
        tmp.set受給者異動事由(パイプ);
        tmp.set証記載保険者番号(パイプ);
        tmp.set被保険者氏名カナ(getValue(tempList.get(6)));
        tmp.set生年月日(getValue(tempList.get(7)));
        tmp.set性別コード(getValue(tempList.get(8)));
        if (定数_16.equals(entity.getデータ区分())) {
            tmp.set資格取得年月日(entity.get異動日());
            // TODO 喪失年月日 新規作成？？？
            tmp.set資格喪失年月日(entity.get終了日());
        }
        // TODO business???
        tmp.set広域連合_政令市_保険者番号(MYBATIS_ID);
        if (定数_1.equals(tempList.get(count))
                || 定数_3.equals(tempList.get(count))
                || 定数_6.equals(tempList.get(count))) {
            tmp.set申請種別コード(定数_1);
        } else if (定数_2.equals(tempList.get(count))) {
            tmp.set申請種別コード(定数_2);
        } else if (定数_4.equals(tempList.get(count))) {
            tmp.set申請種別コード(定数_3);
        }
        // TODO
        tmp.set変更申請中区分コード(パイプ);
        tmp.setみなし要介護状態区分コード(パイプ);
        if (RString.isNullOrEmpty(tempList.get(count))) {
            tmp.set要介護状態区分コード(getValue(tempList.get(19)));
            tmp.set認定有効期間開始年月日(getValue(tempList.get(20)));
            tmp.set認定有効期間終了年月日(getValue(tempList.get(21)));
            tmp.set訪問通所サービス上限管理適用期間開始年月日(getValue(tempList.get(27)));
            tmp.set訪問通所サービス上限管理適用期間終了年月日(getValue(tempList.get(28)));
        } else {
            tmp.set要介護状態区分コード(定数_06);
            tmp.set認定有効期間開始年月日(getValue(tempList.get(count)));
            tmp.set認定有効期間終了年月日(getValue(tempList.get(count)));
            tmp.set訪問通所サービス上限管理適用期間開始年月日(getValue(tempList.get(count)));
            tmp.set訪問通所サービス上限管理適用期間終了年月日(getValue(tempList.get(count)));
        }
        tmp.set居宅サービス計画作成区分コード(getValue(tempList.get(22)));
        tmp.set居宅介護支援事業所番号(getValue(tempList.get(23)));
        tmp.set居宅サービス計画適用開始年月日(getValue(tempList.get(24)));
        tmp.set居宅サービス計画適用終了年月日(getValue(tempList.get(25)));
        tmp.set短期入所サービス支給限度基準額(getValue(tempList.get(29)));
        tmp.set短期入所サービス上限管理適用期間開始年月日(getValue(tempList.get(30)));
        tmp.set短期入所サービス上限管理適用期間終了年月日(getValue(tempList.get(31)));
        tmp.set公費負担上限額減額有フラグ(定数_2);
        // TODO
        tmp.set償還払化開始年月日(パイプ);
        tmp.set償還払化終了年月日(パイプ);
        tmp.set給付率引下げ開始年月日(パイプ);
        tmp.set給付率引下げ終了年月日(パイプ);

        // TODO
        if (定数_06.equals(entity.getデータ区分())) {
            tmp.set減免申請中区分コード(定数_3);
            tmp.set利用者負担区分コード(定数_2);
        } else {
            tmp.set減免申請中区分コード(定数_1);
            tmp.set利用者負担区分コード(定数_1);
        }
        tmp.set給付率(getValue(tempList.get(39)));
        tmp.set適用開始年月日(getValue(tempList.get(40)));
        tmp.set適用終了年月日(getValue(tempList.get(41)));
        // TODO
        if (定数_08.equals(entity.getデータ区分())) {
            tmp.set標準負担区分コード(定数_2);
        }
        tmp.set負担額(getValue(tempList.get(43)));
        tmp.set負担額適用開始年月日(getValue(tempList.get(44)));
        tmp.set負担額適用終了年月日(getValue(tempList.get(45)));
        // TODO
        if (定数_1.equals(tempList.get(count)) || 定数_2.equals(tempList.get(count))) {
            tmp.set特定入所者認定申請中区分コード(定数_3);
        } else {
            tmp.set特定入所者認定申請中区分コード(定数_1);
        }
        // TODO
        if (定数_1.equals(tempList.get(count))) {
            tmp.set課税層の特例減額措置対象フラグ(定数_2);
        } else {
            tmp.set課税層の特例減額措置対象フラグ(定数_1);
        }
        // TODO
        if (定数_09.equals(entity.getデータ区分())) {
            tmp.set特定入所者認定申請中区分コード(定数_3);
            tmp.set特定入所者認定申請中区分コード(null);
            tmp.set課税層の特例減額措置対象フラグ(null);
        } else {
            tmp.set特定入所者認定申請中区分コード(定数_1);
        }
        tmp.set食費負担限度額(getValue(tempList.get(49)));
        tmp.set居住費ユニット型個室負担限度額(getValue(tempList.get(50)));
        tmp.set居住費ユニット型準個室負担限度額(getValue(tempList.get(51)));
        tmp.set居住費従来型個室特養等負担限度額(getValue(tempList.get(52)));
        tmp.set居住費従来型個室老健療養等負担限度額(getValue(tempList.get(53)));
        tmp.set居住費多床室負担限度額(getValue(tempList.get(54)));
        tmp.set負担限度額適用開始年月日(getValue(tempList.get(55)));
        tmp.set負担限度額適用終了年月日(getValue(tempList.get(56)));
        tmp.set軽減率(getValue(tempList.get(57)));
        tmp.set軽減率適用開始年月日(getValue(tempList.get(58)));
        tmp.set軽減率適用終了年月日(getValue(tempList.get(59)));
        tmp.set小多機能居宅介護利用開始月利用有フラグ(定数_1);
        tmp.set後期高齢者医療保険者番号(getValue(tempList.get(61)));
        tmp.set後期高齢者医療被保険者番号(getValue(tempList.get(62)));
        tmp.set国民健康保険保険者番号(getValue(tempList.get(63)));
        tmp.set国民健康保険被保険者証番号(getValue(tempList.get(64)));
        tmp.set国民健康保険個人番号(getValue(tempList.get(65)));
        if (RString.isNullOrEmpty(getValue(tempList.get(67)))) {
            tmp.set二次予防事業区分コード(定数_1);
        } else {
            tmp.set二次予防事業区分コード(定数_2);
        }
        tmp.set二次予防事業有効期間開始年月日(getValue(tempList.get(67)));
        tmp.set二次予防事業有効期間終了年月日(getValue(tempList.get(68)));
        tmp.set送付年月(getValue(tempList.get(70)));

        if (RString.isNullOrEmpty(getValue(tempList.get(73)))) {
            tmp.set住所地特例対象者区分コード(定数_1);
        } else {
            tmp.set住所地特例対象者区分コード(定数_2);
        }
        tmp.set施設所在保険者番号(getValue(tempList.get(72)));
        tmp.set住所地特例適用開始日(getValue(tempList.get(73)));
        tmp.set住所地特例適用終了日(getValue(tempList.get(74)));
        tmp.set利用者負担割合有効開始日(getValue(tempList.get(78)));
        tmp.set利用者負担割合有効終了日(getValue(tempList.get(79)));
        // TODO
        tmp.setエラーフラグ(new RString("1：エラーあり　0：エラーなし"));
        tmp.set市町村コード(getValue(tempList.get(82)));
    }
}
