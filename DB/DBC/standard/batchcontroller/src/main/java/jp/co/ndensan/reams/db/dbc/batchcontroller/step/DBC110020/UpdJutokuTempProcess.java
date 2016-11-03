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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.JushochitokureiInfoEntity;
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
 * 住所地特例の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdJutokuTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select住所地特例");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");

    private static final RString SPLIT = new RString(",");

    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 住所地特例KeyList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        住所地特例KeyList = new ArrayList<>();
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
//        RString 住所地特例Key = get住所地特例Key(entity.get住所地特例());
//        if (住所地特例KeyList.contains(住所地特例Key)) {
//            return;
//        }
//        住所地特例KeyList.add(住所地特例Key);
        RString 全項目 = 住所地特例全項目(entity.get住所地特例());
        Decimal 連番 = 連番Map.get(entity.get住所地特例().get被保険者番号());
        if (連番 == null) {
            連番Map.put(entity.get住所地特例().get被保険者番号(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set住所地特例(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get連番() <= 連番.intValue()) {
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番.add(Decimal.ONE).intValue()) {
            連番Map.put(entity.get住所地特例().get被保険者番号(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get被保険者番号());
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
            insert.set住所地特例(全項目);
            insert.set宛名(RString.EMPTY);
            insert.set受給者台帳(RString.EMPTY);
            insert.set二次予防事業対象者(RString.EMPTY);
            insert.set総合事業対象者(RString.EMPTY);
            insert.set被保険者台帳管理(RString.EMPTY);
            異動一時tableWriter.insert(insert);
        } else {
            連番Map.put(entity.get住所地特例().get被保険者番号(), new Decimal(entity.get異動一時().get連番()));
            IdouTblEntity update = entity.get異動一時();
            update.set住所地特例(全項目);
            異動一時tableWriter.update(update);
        }
    }

    private RString get住所地特例Key(JushochitokureiInfoEntity 住所地特例) {
        return 住所地特例.get識別コード().getColumnValue().concat(SPLIT)
                .concat(new RString(住所地特例.get履歴番号()));
    }

    private RString 住所地特例全項目(JushochitokureiInfoEntity 住所地特例) {
        RString 全項目 = RString.EMPTY;
        全項目 = concatDate(全項目, 住所地特例.get住所地特例適用開始日());
        全項目 = 全項目.concat(SPLIT);
        全項目 = concatDate(全項目, 住所地特例.get住所地特例適用終了日());
        return 全項目;
    }

    private RString concatDate(RString 全項目, FlexibleDate date) {
        if (date == null) {
            全項目 = 全項目.concat(RString.EMPTY);
        } else {
            全項目 = 全項目.concat(date.toString());
        }
        return 全項目;
    }
}
