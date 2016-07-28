/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.SedaiShuuyakuBangoKanrenEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishosha.IKogakuKyufuTaishoshaMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 高額介護サービス費給付対象者取込のCSVファイル読取
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInSetSedaiShuuyakuBangoProcess extends BatchProcessBase<SedaiShuuyakuBangoKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukyufutaishosha.IKogakuKyufuTaishoshaMapper.select世帯集約番号関連リスト");
    private List<DbWT0001HihokenshaTempEntity> 世帯集約番号修正被保険者リスト;
    private List<DbWT0001HihokenshaTempEntity> 世帯集約番号登録エラー被保険者リスト;
    private IKogakuKyufuTaishoshaMapper mapper;
    private IKokuhorenKyoutsuuMapper kekkaMapper;
    private static final RString エラー区分_世帯集約番号取得エラー = new RString("40");

    @Override
    protected void initialize() {
        super.initialize();
        世帯集約番号修正被保険者リスト = new ArrayList<>();
        世帯集約番号登録エラー被保険者リスト = new ArrayList<>();
        mapper = getMapper(IKogakuKyufuTaishoshaMapper.class);
        kekkaMapper = getMapper(IKokuhorenKyoutsuuMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(SedaiShuuyakuBangoKanrenEntity t) {
        DbWT0001HihokenshaTempEntity 被保険者 = t.get被保険者();
        DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額送付 = t.get高額送付();
        if (高額送付.getIdoYMD().isBeforeOrEquals(被保険者.getサービス提供年月末日())) {
            被保険者.set世帯集約番号(getColumnValue(高額送付.getSetaiShuyakuNo()));
            世帯集約番号修正被保険者リスト.add(被保険者);
            return;
        }
        世帯集約番号登録エラー被保険者リスト.add(被保険者);
    }

    @Override
    protected void afterExecute() {
        for (DbWT0001HihokenshaTempEntity 被保険者 : 世帯集約番号修正被保険者リスト) {
            mapper.do世帯集約番号の登録(被保険者);
        }
        for (DbWT0001HihokenshaTempEntity 被保険者 : 世帯集約番号登録エラー被保険者リスト) {
            DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            処理結果.setエラー区分(エラー区分_世帯集約番号取得エラー);
            処理結果.set証記載保険者番号(被保険者.get証記載保険者番号());
            処理結果.set被保険者番号(被保険者.get登録被保険者番号());
            if (null != 被保険者.getサービス提供年月末日()) {
                RString サービス提供年月末日の年月 = 被保険者.getサービス提供年月末日().getYearMonth().wareki().
                        firstYear(FirstYear.ICHI_NEN).toDateString();
                処理結果.setキー1(サービス提供年月末日の年月);
            }
            処理結果.set被保険者カナ氏名(被保険者.get被保険者カナ氏名());
            処理結果.set被保険者氏名(被保険者.get被保険者氏名());
            if (0 == kekkaMapper.count処理結果ByPK(処理結果)) {
                kekkaMapper.insert処理結果リスト一時TBL(処理結果);
            }
        }
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null == entity) {
            return RString.EMPTY;
        }
        return entity.getColumnValue();
    }

}
