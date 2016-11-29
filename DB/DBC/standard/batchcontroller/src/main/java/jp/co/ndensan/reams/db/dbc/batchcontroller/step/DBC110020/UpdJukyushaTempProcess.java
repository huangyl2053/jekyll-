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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者台帳の情報の抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpdJukyushaTempProcess extends BatchProcessBase<IdouTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper.select受給者台帳");
    private static final RString 異動一時_TABLE_NAME = new RString("IdouTemp");
    private static final RString SPLIT = new RString(",");
    private static final RString RST_1 = new RString("1");
    private static final RString RST_0 = new RString("0");

    private Map<HihokenshaNo, Decimal> 連番Map;
    private List<RString> 受給者台帳List;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動一時tableWriter;

    @Override
    protected void initialize() {
        連番Map = new HashMap<>();
        受給者台帳List = new ArrayList<>();
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
        RString 受給者台帳 = 受給者台帳全項目(entity.get受給者台帳());
        Decimal 連番 = 連番Map.get(entity.get受給者台帳().getHihokenshaNo());
        if (連番 == null) {
            if (受給者台帳List.contains(受給者台帳)) {
                return;
            }
            受給者台帳List.add(受給者台帳);
            連番Map.put(entity.get受給者台帳().getHihokenshaNo(), Decimal.ONE);
            IdouTblEntity update = entity.get異動一時();
            update.set受給者台帳(受給者台帳);
            異動一時tableWriter.update(update);
            return;
        }
        Decimal 連番temp = 連番.add(Decimal.ONE);
        if (連番temp.intValue() <= entity.get異動一時().get被保険者番号Max連番()) {
            if (連番temp.intValue() != entity.get異動一時().get連番()) {
                return;
            }
            if (受給者台帳List.contains(受給者台帳)) {
                return;
            }
            受給者台帳List.add(受給者台帳);
            連番Map.put(entity.get受給者台帳().getHihokenshaNo(), 連番temp);
            IdouTblEntity update = entity.get異動一時();
            update.set受給者台帳(受給者台帳);
            異動一時tableWriter.update(update);
            return;
        }
        if (entity.get異動一時().get被保険者番号Max連番() < 連番.add(Decimal.ONE).intValue()) {
            if (受給者台帳List.contains(受給者台帳)) {
                return;
            }
            受給者台帳List.add(受給者台帳);
            連番Map.put(entity.get受給者台帳().getHihokenshaNo(), 連番.add(Decimal.ONE));
            IdouTblEntity insert = new IdouTblEntity();
            insert.set被保険者番号(entity.get受給者台帳().getHihokenshaNo());
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
            insert.set受給者台帳(受給者台帳);
            insert.set二次予防事業対象者(RString.EMPTY);
            insert.set総合事業対象者(RString.EMPTY);
            insert.set被保険者台帳管理(RString.EMPTY);
            異動一時tableWriter.insert(insert);
        }
    }

    private RString 受給者台帳全項目(DbT4001JukyushaDaichoEntity 受給者台帳) {
        RString 全項目 = RString.EMPTY;
        全項目 = 全項目
                .concat(受給者台帳.getHihokenshaNo().getColumnValue()).concat(SPLIT);
        全項目 = concatCode(全項目, 受給者台帳.getYokaigoJotaiKubunCode());
        全項目 = concatDate(全項目, 受給者台帳.getJukyuShinseiYMD());
        全項目 = concatDate(全項目, 受給者台帳.getNinteiYukoKikanKaishiYMD());
        全項目 = concatDate(全項目, 受給者台帳.getNinteiYukoKikanShuryoYMD());
        全項目 = concatCode(全項目, 受給者台帳.getMinashiCode());
        全項目 = concatDecimal(全項目, 受給者台帳.getShikyuGendoTanisu());
        全項目 = concatDate(全項目, 受給者台帳.getShikyuGendoKaishiYMD());
        全項目 = concatDate(全項目, 受給者台帳.getShikyuGendoShuryoYMD());
        全項目 = 全項目.concat(new RString(受給者台帳.getTankiSikyuGendoNissu())).concat(SPLIT);
        全項目 = concatDate(全項目, 受給者台帳.getTankiShikyuGendoKaishiYMD());
        全項目 = concatDate(全項目, 受給者台帳.getTankiShikyuGendoShuryoYMD());
        全項目 = concatCode(全項目, 受給者台帳.getYukoMukoKubun());
        全項目 = concatCode(全項目, 受給者台帳.getJukyuShinseiJiyu());
        全項目 = concatDate(全項目, 受給者台帳.getJukyuShinseiYMD());
        全項目 = 全項目.concat(受給者台帳.getRirekiNo()).concat(SPLIT);
        if (RString.isNullOrEmpty(受給者台帳.getShinseiJokyoKubun())) {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(受給者台帳.getShinseiJokyoKubun()).concat(SPLIT);
        }
        全項目 = concatDate(全項目, 受給者台帳.getNinteiYMD());
        全項目 = concatDate(全項目, 受給者台帳.getSoshitsuYMD());
        全項目 = concatCode(全項目, 受給者台帳.getDataKubun());
        全項目 = 全項目.concat(受給者台帳.getKyuSochishaFlag() ? RST_1 : RST_0).concat(SPLIT);
        全項目 = concatDate(全項目, 受給者台帳.getToshoNinteiYukoShuryoYMD());
        return 全項目;
    }

    private RString concatCode(RString 全項目, Code code) {
        if (code == null) {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(code.getColumnValue()).concat(SPLIT);
        }
        return 全項目;
    }

    private RString concatDate(RString 全項目, FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(date.toString()).concat(SPLIT);
        }
        return 全項目;
    }

    private RString concatDecimal(RString 全項目, Decimal decimal) {
        if (decimal == null) {
            全項目 = 全項目.concat(RString.EMPTY).concat(SPLIT);
        } else {
            全項目 = 全項目.concat(decimal.toString()).concat(SPLIT);
        }
        return 全項目;
    }

}
