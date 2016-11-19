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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTempEntity;
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
 * 二次予防の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdNijiYoboTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select二次予防");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");

    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 二次予防KeyList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        二次予防KeyList = new ArrayList<>();
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
        RString 二次予防Key = 二次予防Key(entity.get二次予防());
        RString 二次予防 = 二次予防全項目(entity.get二次予防());
        Decimal 連番 = 連番Map.get(entity.get二次予防().getHihokenshaNo());
        if (連番 == null) {
            if (二次予防KeyList.contains(二次予防Key)) {
                return;
            }
            二次予防KeyList.add(二次予防Key);
            連番Map.put(entity.get二次予防().getHihokenshaNo(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set二次予防事業対象者(二次予防);
            異動一時tableWriter.update(update);
            return;
        }
        Decimal 連番temp = 連番.add(Decimal.ONE);
        if (連番temp.intValue() <= entity.get異動一時().get被保険者番号Max連番()) {
            if (連番temp.intValue() != entity.get異動一時().get連番()) {
                return;
            }
            if (二次予防KeyList.contains(二次予防Key)) {
                return;
            }
            二次予防KeyList.add(二次予防Key);
            連番Map.put(entity.get二次予防().getHihokenshaNo(), 連番temp);
            IdouTblEntity update = entity.get異動一時();
            update.set二次予防事業対象者(二次予防);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番.add(Decimal.ONE).intValue()) {
            if (二次予防KeyList.contains(二次予防Key)) {
                return;
            }
            二次予防KeyList.add(二次予防Key);
            連番Map.put(entity.get二次予防().getHihokenshaNo(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get二次予防().getHihokenshaNo());
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
            insert.set二次予防事業対象者(二次予防);
            insert.set総合事業対象者(RString.EMPTY);
            insert.set被保険者台帳管理(RString.EMPTY);
            異動一時tableWriter.insert(insert);
        }
    }

    private RString 二次予防全項目(DbT3100NijiYoboJigyoTaishoshaEntity 二次予防) {
        RString 全項目 = RString.EMPTY;
        全項目 = cancatYMD(二次予防.getTekiyoKaishiYMD(), 全項目);
        全項目 = cancatYMD(二次予防.getTekiyoShuryoYMD(), 全項目);
        return 全項目;
    }

    private RString 二次予防Key(DbT3100NijiYoboJigyoTaishoshaEntity 二次予防) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目
                .concat(二次予防.getHihokenshaNo().getColumnValue()).concat(SPLIT)
                .concat(new RString(二次予防.getRirekiNo()));
        return 全項目;
    }

    private RString cancatYMD(FlexibleDate date, RString 全項目) {
        if (date != null) {
            return 全項目.concat(new RString(date.toString())).concat(SPLIT);
        }
        return 全項目.concat(RString.EMPTY).concat(SPLIT);
    }

}
