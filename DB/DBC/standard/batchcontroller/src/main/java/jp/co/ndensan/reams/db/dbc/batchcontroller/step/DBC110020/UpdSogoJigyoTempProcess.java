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
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
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
 * 総合事業対象者の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdSogoJigyoTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select総合事業対象者");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");

    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 総合事業対象者KeyList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        総合事業対象者KeyList = new ArrayList<>();
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
        RString 総合事業対象者Key = 総合事業対象者Key(entity.get総合事業対象者());
        if (総合事業対象者KeyList.contains(総合事業対象者Key)) {
            return;
        }
        総合事業対象者KeyList.add(総合事業対象者Key);
        RString 総合事業対象者 = 総合事業対象者全項目(entity.get総合事業対象者());
        Decimal 連番 = 連番Map.get(entity.get総合事業対象者().getHihokenshaNo());
        if (連番 == null) {
            連番Map.put(entity.get総合事業対象者().getHihokenshaNo(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set総合事業対象者(総合事業対象者);
            異動一時tableWriter.update(update);
            return;
        }
        Decimal 連番temp = 連番.add(Decimal.ONE);
        if (連番temp.intValue() <= entity.get異動一時().get被保険者番号Max連番()) {
            if (連番temp.intValue() != entity.get異動一時().get連番()) {
                return;
            }
            連番Map.put(entity.get総合事業対象者().getHihokenshaNo(), 連番temp);
            IdouTblEntity update = entity.get異動一時();
            update.set総合事業対象者(総合事業対象者);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番.add(Decimal.ONE).intValue()) {
            連番Map.put(entity.get総合事業対象者().getHihokenshaNo(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get総合事業対象者().getHihokenshaNo());
            insert.set連番(連番.add(Decimal.ONE).intValue());
            insert.set支払方法変更_支払方法(RString.EMPTY);
            insert.set支払方法変更_給付費減額(RString.EMPTY);
            insert.set後期高齢者情報(RString.EMPTY);
            insert.set国保資格情報(RString.EMPTY);
            insert.set生活保護受給者(RString.EMPTY);
            insert.set特定入所者(RString.EMPTY);
            insert.set社福減免(RString.EMPTY);
            insert.set利用者負担額減額(RString.EMPTY);
            insert.set標準負担(RString.EMPTY);
            insert.set利用者負担割合明細(RString.EMPTY);
            insert.set居宅計画(RString.EMPTY);
            insert.set住所地特例(RString.EMPTY);
            insert.set宛名(RString.EMPTY);
            insert.set受給者台帳(RString.EMPTY);
            insert.set二次予防事業対象者(RString.EMPTY);
            insert.set総合事業対象者(総合事業対象者);
            insert.set被保険者台帳管理(RString.EMPTY);
            異動一時tableWriter.insert(insert);
        }
    }

    private RString 総合事業対象者Key(DbT3105SogoJigyoTaishoshaEntity 総合事業対象者) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目
                .concat(総合事業対象者.getHihokenshaNo().getColumnValue()).concat(SPLIT)
                .concat(new RString(総合事業対象者.getRirekiNo()));
        return 全項目;
    }

    private RString 総合事業対象者全項目(DbT3105SogoJigyoTaishoshaEntity 総合事業対象者) {
        RString 全項目 = RString.EMPTY;
        FlexibleDate 適用開始年月日 = 総合事業対象者.getTekiyoKaishiYMD();
        if (適用開始年月日 != null) {
            全項目 = 全項目.concat(適用開始年月日.toString()).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        }
        FlexibleDate 適用終了年月日 = 総合事業対象者.getTekiyoShuryoYMD();
        if (適用終了年月日 != null) {
            全項目 = 全項目.concat(適用終了年月日.toString()).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        }
        return 全項目;
    }

}
