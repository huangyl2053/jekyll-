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
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 二割負担の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdFutanWariaiTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select二割負担");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");
    private static final RString RST_TRUE = new RString("TRUE");
    private static final RString RST_FALSE = new RString("FALSE");

    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 二割負担List;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        二割負担List = new ArrayList<>();
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
        RString 全項目 = 二割負担全項目(entity.get二割負担());
        if (二割負担List.contains(全項目)) {
            return;
        }
        二割負担List.add(全項目);
        Decimal 連番 = 連番Map.get(entity.get二割負担().getHihokenshaNo());
        if (連番 == null) {
            連番Map.put(entity.get二割負担().getHihokenshaNo(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set利用者負担割合明細(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        Decimal 連番temp = 連番.add(Decimal.ONE);
        if (連番temp.intValue() <= entity.get異動一時().get被保険者番号Max連番()) {
            if (連番temp.intValue() != entity.get異動一時().get連番()) {
                return;
            }
            連番Map.put(entity.get二割負担().getHihokenshaNo(), 連番temp);
            IdouTblEntity update = entity.get異動一時();
            update.set居宅計画(全項目);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番.add(Decimal.ONE).intValue()) {
            連番Map.put(entity.get二割負担().getHihokenshaNo(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get二割負担().getHihokenshaNo());
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
            insert.set利用者負担割合明細(全項目);
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

    private RString 二割負担全項目(DbT3114RiyoshaFutanWariaiMeisaiEntity 二割負担) {
        RString 全項目 = RString.EMPTY;
        全項目 = cancatYMD(二割負担.getYukoKaishiYMD(), 全項目);
        全項目 = cancatYMD(二割負担.getYukoShuryoYMD(), 全項目);
        全項目 = 全項目.concat(二割負担.getHihokenshaNo().getColumnValue()).concat(SPLIT)
                .concat(二割負担.getNendo().toDateString()).concat(SPLIT)
                .concat(new RString(二割負担.getRirekiNo())).concat(SPLIT)
                .concat(new RString(二割負担.getEdaNo())).concat(SPLIT)
                .concat(二割負担.getInsertDantaiCd()).concat(SPLIT)
                .concat(二割負担.getIsDeleted() ? RST_TRUE : RST_FALSE).concat(SPLIT);
        全項目 = cancatRString(二割負担.getShikakuKubun(), 全項目);
        全項目 = cancatRString(二割負担.getFutanWariaiKubun(), 全項目);
        全項目 = cancatDecimal(二割負担.getHonninGoukeiShotokuGaku(), 全項目);
        全項目 = 全項目.concat(new RString(二割負担.getSetaiIchigouHihokenshaSu())).concat(SPLIT);
        全項目 = cancatDecimal(二割負担.getNenkinShunyuGoukei(), 全項目);
        全項目 = cancatDecimal(二割負担.getSonotanoGoukeiShotokuKingakuGoukei(), 全項目);
        if (RString.isNullOrEmpty(二割負担.getKoseiRiyu())) {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(二割負担.getKoseiRiyu()).concat(SPLIT);
        }
        全項目 = cancatSetaiCode(二割負担.getSetaiCd(), 全項目);
        全項目 = 全項目.concat(二割負担.getIsDeleted() ? RST_TRUE : RST_FALSE);
        return 全項目;
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

    private RString cancatSetaiCode(SetaiCode 項目, RString 全項目) {
        if (項目 != null) {
            return 全項目.concat(項目.getColumnValue()).concat(SPLIT);
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
