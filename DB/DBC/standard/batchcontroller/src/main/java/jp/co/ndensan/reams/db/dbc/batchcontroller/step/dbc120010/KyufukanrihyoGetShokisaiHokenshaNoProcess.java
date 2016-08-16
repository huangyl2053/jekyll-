/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.HihokenshaKanriDataEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyoin.IKyufukanrihyoInMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.koikishokisaihokenshano.KoikiShokisaiHokenshaNoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 公費負担者分・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
public class KyufukanrihyoGetShokisaiHokenshaNoProcess extends BatchProcessBase<HihokenshaKanriDataEntity> {

    private KoikiShokisaiHokenshaNoFinder finder;
    private IKyufukanrihyoInMapper mapper;
    private IKokuhorenKyoutsuuTempTableMapper 一時Mapper;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufukanrihyoin.IKyufukanrihyoInMapper.get直近の被保険者台帳管理データ");

    private static final RString エラー区分_証記載保険者番号取得エラー = new RString("41");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void beforeExecute() {
        finder = KoikiShokisaiHokenshaNoFinder.createInstance();
        mapper = getMapper(IKyufukanrihyoInMapper.class);
        一時Mapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
    }

    @Override
    protected void process(HihokenshaKanriDataEntity entity) {
        DbWT0001HihokenshaTempEntity 被保険者一時 = entity.getTemp();
        if (null == entity.getDaicho()) {
            doエラー登録(被保険者一時);
            return;
        }
        FlexibleDate サービス提供年月末日 = entity.getTemp().getサービス提供年月末日();
        FlexibleYearMonth サービス提供年月 = サービス提供年月末日.getYearMonth();
        LasdecCode 市町村コード = entity.getDaicho().getShichosonCode();
        ShoKisaiHokenshaNo 証記載保険者番号 = finder.getShokisaiHokenshaNo(市町村コード, サービス提供年月);
        if (null == 証記載保険者番号) {
            doエラー登録(被保険者一時);
            return;
        }
        被保険者一時.set証記載保険者番号(証記載保険者番号);
        mapper.被保険者一時データに証記載保険者番号を登録する(被保険者一時);
    }

    private void doエラー登録(DbWT0001HihokenshaTempEntity 被保険者一時) {
        DbWT0002KokuhorenTorikomiErrorTempEntity エラー結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        エラー結果.setエラー区分(エラー区分_証記載保険者番号取得エラー);
        エラー結果.set証記載保険者番号(被保険者一時.get証記載保険者番号());
        エラー結果.set被保険者番号(被保険者一時.get登録被保険者番号());
        FlexibleDate サービス提供年月末日 = 被保険者一時.getサービス提供年月末日();
        FlexibleYearMonth サービス提供年月 = サービス提供年月末日.getYearMonth();
        エラー結果.setキー1(サービス提供年月.wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
        エラー結果.setキー2(RString.EMPTY);
        エラー結果.setキー3(RString.EMPTY);
        エラー結果.setキー4(RString.EMPTY);
        エラー結果.setキー5(RString.EMPTY);
        エラー結果.set被保険者カナ氏名(被保険者一時.get被保険者カナ氏名());
        エラー結果.set被保険者氏名(被保険者一時.get被保険者氏名());
        エラー結果.set備考(RString.EMPTY);
        一時Mapper.処理結果リスト一時TBLに登録(エラー結果);
    }

}
