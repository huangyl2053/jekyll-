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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.KyotakuEntity;
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
 * 居宅計画の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdKyotakuTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select居宅計画");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");

    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 居宅計画List;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        居宅計画List = new ArrayList<>();
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
//        if (!entity.get居宅計画().get被保険者番号().equals(new HihokenshaNo("2015123461"))) {
//            return;
//        }
        RString key = 居宅計画Key(entity.get居宅計画());
        if (居宅計画List.contains(key)) {
            return;
        }
        居宅計画List.add(key);
        RString 全項目 = 居宅計画全項目(entity.get居宅計画());
        Decimal 連番 = 連番Map.get(entity.get居宅計画().get被保険者番号());
        if (連番 == null) {
            連番Map.put(entity.get居宅計画().get被保険者番号(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set居宅計画(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        Decimal 連番temp = 連番.add(Decimal.ONE);
        if (連番temp.intValue() <= entity.get異動一時().get被保険者番号Max連番()) {
            if (連番temp.intValue() != entity.get異動一時().get連番()) {
                return;
            }
            連番Map.put(entity.get居宅計画().get被保険者番号(), 連番temp);
            IdouTblEntity update = entity.get異動一時();
            update.set居宅計画(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番temp.intValue()) {
            連番Map.put(entity.get居宅計画().get被保険者番号(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get居宅計画().get被保険者番号());
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
            insert.set居宅計画(全項目);
            insert.set住所地特例(RString.EMPTY);
            insert.set宛名(RString.EMPTY);
            insert.set受給者台帳(RString.EMPTY);
            insert.set二次予防事業対象者(RString.EMPTY);
            insert.set総合事業対象者(RString.EMPTY);
            insert.set被保険者台帳管理(RString.EMPTY);
            異動一時tableWriter.insert(insert);
        }
    }

    private RString 居宅計画全項目(KyotakuEntity 居宅計画) {
        RString 全項目 = RString.EMPTY;
        全項目 = concatDate(全項目, 居宅計画.get適用開始日());
        全項目 = 全項目
                .concat(居宅計画.get計画事業者番号().getColumnValue()).concat(SPLIT);
        全項目 = concatRString(全項目, 居宅計画.get居宅サービス計画作成区分コード());
        全項目 = concatRString(全項目, 居宅計画.getサービス種類コード());
        全項目 = concatDate(全項目, 居宅計画.get有効終了日());
        全項目 = concatRString(全項目, 居宅計画.get居宅計画種類());
        全項目 = concatDate(全項目, 居宅計画.get適用終了日());
        全項目 = concatDate(全項目, 居宅計画.get届出年月日());
        全項目 = 全項目.concat(居宅計画.get被保険者番号().getColumnValue()).concat(SPLIT);
        全項目 = 全項目.concat(居宅計画.getTaishoYM1().toDateString()).concat(SPLIT);
        全項目 = 全項目.concat(居宅計画.getTaishoYM2().toDateString()).concat(SPLIT);
        全項目 = 全項目.concat(new RString(居宅計画.get履歴番号()).concat(SPLIT));
        全項目 = concatDate(全項目, 居宅計画.get有効終了日());
        if (居宅計画.get委託先事業者番号() != null) {
            全項目 = 全項目.concat(居宅計画.get委託先事業者番号().getColumnValue()).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        }
        全項目 = concatRString(全項目, 居宅計画.get暫定区分());
        return 全項目;
    }

    private RString 居宅計画Key(KyotakuEntity 居宅計画) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目.concat(居宅計画.get被保険者番号().getColumnValue());
        全項目 = concatRString(全項目, 居宅計画.get居宅計画種類());
        全項目 = 全項目.concat(居宅計画.getTaishoYM1().toDateString());
        全項目 = 全項目.concat(居宅計画.getTaishoYM2().toDateString());
        全項目 = 全項目.concat(new RString(居宅計画.get履歴番号()));
        if (居宅計画.get有効終了日() != null) {
            全項目 = 全項目.concat(new RString(居宅計画.get有効終了日().toString()));
        }
        return 全項目;
    }

    private RString concatRString(RString 全項目, RString data) {
        if (RString.isNullOrEmpty(data)) {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(data).concat(SPLIT);
        }
        return 全項目;
    }

    private RString concatDate(RString 全項目, FlexibleDate data) {
        if (data == null) {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(data.toString()).concat(SPLIT);
        }
        return 全項目;
    }
}
