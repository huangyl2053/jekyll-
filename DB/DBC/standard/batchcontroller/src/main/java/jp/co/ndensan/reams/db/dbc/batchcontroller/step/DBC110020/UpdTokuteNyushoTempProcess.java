/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.TokuteiNyusyoshaInfoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特定入所者の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdTokuteNyushoTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select特定入所者");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");
    private static final RString 区分_1 = new RString("1");

    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 特定入所者KeyList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        特定入所者KeyList = new ArrayList<>();
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        異動一時tableWriter
                = new BatchEntityCreatedTempTableWriter(異動一時_TABLE_NAME, IdouTblEntity.class);
    }

    @Override
    protected void process(IdouTempEntity entity) {
        TokuteiNyusyoshaInfoEntity 特定入所者 = entity.get特定入所者();
        if (区分_1.equals(特定入所者.get決定区分())
                && (isDateEmpty(特定入所者.get適用開始日()) || isDateEmpty(特定入所者.get適用終了日()))) {
            return;
        }
        if (RString.isNullOrEmpty(特定入所者.get決定区分())
                && (!isDateEmpty(特定入所者.get適用開始日()) || !isDateEmpty(特定入所者.get適用終了日()))) {
            return;
        }
        RString 特定入所者Key = get特定入所者Key(entity.get特定入所者());
        RString 全項目 = 特定入所者全項目(entity.get特定入所者());
        Decimal 連番 = 連番Map.get(entity.get特定入所者().get被保険者番号());
        if (連番 == null) {
            if (特定入所者KeyList.contains(特定入所者Key)) {
                return;
            }
            特定入所者KeyList.add(特定入所者Key);
            連番Map.put(entity.get特定入所者().get被保険者番号(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set特定入所者(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        Decimal 連番temp = 連番.add(Decimal.ONE);
        if (連番temp.intValue() <= entity.get異動一時().get被保険者番号Max連番()) {
            if (連番temp.intValue() != entity.get異動一時().get連番()) {
                return;
            }
            if (特定入所者KeyList.contains(特定入所者Key)) {
                return;
            }
            特定入所者KeyList.add(特定入所者Key);
            連番Map.put(entity.get特定入所者().get被保険者番号(), 連番temp);
            IdouTblEntity update = entity.get異動一時();
            update.set特定入所者(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番.add(Decimal.ONE).intValue()) {
            if (特定入所者KeyList.contains(特定入所者Key)) {
                return;
            }
            特定入所者KeyList.add(特定入所者Key);
            連番Map.put(entity.get特定入所者().get被保険者番号(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get特定入所者().get被保険者番号());
            insert.set連番(連番.add(Decimal.ONE).intValue());
            insert.set支払方法変更_支払方法(RString.EMPTY);
            insert.set支払方法変更_給付費減額(RString.EMPTY);
            insert.set後期高齢者情報(RString.EMPTY);
            insert.set国保資格情報(RString.EMPTY);
            insert.set生活保護受給者(RString.EMPTY);
            insert.set特定入所者(全項目);
            insert.set社福減免(RString.EMPTY);
            insert.set利用者負担額減額(RString.EMPTY);
            insert.set標準負担(RString.EMPTY);
            insert.set利用者負担割合明細(RString.EMPTY);
            insert.set居宅計画(RString.EMPTY);
            insert.set住所地特例(RString.EMPTY);
            insert.set宛名(RString.EMPTY);
            insert.set受給者台帳(RString.EMPTY);
            insert.set二次予防事業対象者(RString.EMPTY);
            insert.set総合事業対象者(RString.EMPTY);
            insert.set被保険者台帳管理(RString.EMPTY);
            異動一時tableWriter.insert(insert);
        }
    }

    private RString get特定入所者Key(TokuteiNyusyoshaInfoEntity 特定入所者) {
        return 特定入所者.get証記載保険者番号().getColumnValue().concat(SPLIT)
                .concat(特定入所者.get被保険者番号().getColumnValue()).concat(SPLIT).concat(new RString(特定入所者.get履歴番号()));
    }

    private RString 特定入所者全項目(TokuteiNyusyoshaInfoEntity 特定入所者) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目.concat(特定入所者.get減免_減額種類()).concat(SPLIT);
        全項目 = cancatYMD(特定入所者.get適用開始日(), 全項目);
        全項目 = cancatYMD(特定入所者.get適用終了日(), 全項目);
        全項目 = cancatDecimal(特定入所者.get食費負担限度額(), 全項目);
        全項目 = cancatDecimal(特定入所者.getユニット型個室(), 全項目);
        全項目 = cancatDecimal(特定入所者.getユニット型準個室(), 全項目);
        全項目 = cancatDecimal(特定入所者.get従来型個室_特養等(), 全項目);
        全項目 = cancatDecimal(特定入所者.get従来型個室_老健_療養等(), 全項目);
        全項目 = cancatDecimal(特定入所者.get多床室(), 全項目);
        全項目 = cancatRString(特定入所者.get旧措置者区分(), 全項目);
        全項目 = cancatRString(特定入所者.get決定区分(), 全項目);
        全項目 = cancatYMD(特定入所者.get申請日(), 全項目);
        全項目 = 全項目.concat(new RString(特定入所者.get履歴番号())).concat(SPLIT);
        return 全項目;
    }

    private boolean isDateEmpty(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return true;
        }
        return false;
    }

    private RString cancatYMD(FlexibleDate date, RString 全項目) {
        if (date != null) {
            return 全項目.concat(new RString(date.toString())).concat(SPLIT);
        }
        return 全項目.concat(RString.EMPTY).concat(SPLIT);
    }

    private RString cancatDecimal(Decimal 項目, RString 全項目) {
        if (項目 != null) {
            return 全項目.concat(項目.toString()).concat(SPLIT);
        }
        return 全項目.concat(RString.EMPTY).concat(SPLIT);
    }

    private RString cancatRString(RString 項目, RString 全項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 全項目.concat(項目.toString()).concat(SPLIT);
        }
        return 全項目.concat(RString.EMPTY).concat(SPLIT);
    }
}
