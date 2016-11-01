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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 生活保護受給者の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdSeihoTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select生活保護受給者");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");
    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 生活保護受給者KeyList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        生活保護受給者KeyList = new ArrayList<>();
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
        RString 生活保護受給者Key = get生活保護受給者Key(entity.get生活保護受給者());
        if (生活保護受給者KeyList.contains(生活保護受給者Key)) {
            return;
        }
        生活保護受給者KeyList.add(生活保護受給者Key);
        RString 全項目 = 生活保護受給者全項目(entity.get生活保護受給者());
        Decimal 連番 = 連番Map.get(entity.get被保険者番号());
        if (連番 == null) {
            連番Map.put(entity.get被保険者番号(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set生活保護受給者(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get連番() <= 連番.intValue()) {
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番.add(Decimal.ONE).intValue()) {
            連番Map.put(entity.get社福減免().get被保険者番号(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get被保険者番号());
            insert.set連番(連番.add(Decimal.ONE).intValue());
            insert.set支払方法変更_支払方法(RString.EMPTY);
            insert.set支払方法変更_給付費減額(RString.EMPTY);
            insert.set後期高齢者情報(RString.EMPTY);
            insert.set国保資格情報(RString.EMPTY);
            insert.set生活保護受給者(全項目);
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
            insert.set総合事業対象者(RString.EMPTY);
            insert.set被保険者台帳管理(RString.EMPTY);
            異動一時tableWriter.insert(insert);
        } else {
            連番Map.put(entity.get被保険者番号(), new Decimal(entity.get異動一時().get連番()));
            IdouTblEntity update = entity.get異動一時();
            update.set生活保護受給者(全項目);
            異動一時tableWriter.update(update);
        }
    }

    private RString get生活保護受給者Key(UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者) {
        return 生活保護受給者.getShikibetsuCode().getColumnValue().concat(SPLIT)
                .concat(生活保護受給者.getGyomuCode().getColumnValue()).concat(SPLIT).concat(new RString(生活保護受給者.getJukyuKaishiYMD().toString()));
    }

    private RString 生活保護受給者全項目(UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目.concat(生活保護受給者.getJukyuKaishiYMD().toString()).concat(SPLIT)
                .concat(生活保護受給者.getJukyuHaishiYMD().toString());
        return 全項目;
    }
}
