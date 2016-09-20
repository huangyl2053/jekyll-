/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.TaishoshaTmpEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 対象者と対象外データを一時テーブルに登録クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class HeinjunkaFukaTaishoBunkatuProcess extends BatchProcessBase<FukaJohoTmpEntity> {

    private static final RString 対象外データTEMP_TABLE_NAME = new RString("TmpTaishogai");
    private static final RString 対象者データTEMP_TABLE_NAME = new RString("TmpTaishosha");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka6gatsu.ITokuchoHeinjunka6GatsuBatchMapper.getTmpHeijunkaMae");
    private static final RString 備考コード_併徴者 = new RString("1");
    private static final RString 備考コード_特徴6月開始者 = new RString("6");
    private static final RString 備考コード_仮徴収額修正者 = new RString("2");
    private static final int 仮算定期間_期1 = 1;
    private static final int 仮算定期間_期2 = 2;
    private static final int 仮算定期間_期3 = 3;
    private static final int 仮算定期間_期4 = 4;
    private static final int 仮算定期間_期5 = 5;
    private static final int 仮算定期間_期6 = 6;
    private static final int 仮算定期間_期7 = 7;
    private static final int 仮算定期間_期8 = 8;
    private static final int 仮算定期間_期9 = 9;
    private static final int 仮算定期間_期10 = 10;
    private static final int 仮算定期間_期11 = 11;
    private static final int 仮算定期間_期12 = 12;
    private static final int 仮算定期間_期13 = 13;
    private static final int 仮算定期間_期14 = 14;
    private int 仮算定期間_最大期;
    private int 仮算定期間_最小期;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象外データ一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象者データ一時tableWriter;

    @Override
    protected void beforeExecute() {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        List<Kitsuki> 普徴仮算定期間リスト = 普徴仮算定期間.toList();
        仮算定期間_最大期 = 普徴仮算定期間リスト.get(0).get期AsInt();
        仮算定期間_最小期 = 普徴仮算定期間リスト.get(普徴仮算定期間リスト.size() - 1).get期AsInt();
    }

    @Override
    protected void createWriter() {
        対象外データ一時tableWriter = new BatchEntityCreatedTempTableWriter(対象外データTEMP_TABLE_NAME,
                TaishoshaTmpEntity.class, true);
        対象者データ一時tableWriter = new BatchEntityCreatedTempTableWriter(対象者データTEMP_TABLE_NAME,
                TaishoshaTmpEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(FukaJohoTmpEntity fukaTmpEntity) {
        RString 備考コード = RString.EMPTY;
        Decimal 特徴期別金額合計 = Decimal.ZERO;
        final Decimal 特徴期別金額01 = fukaTmpEntity.getTkKibetsuGaku01();
        final Decimal 特徴期別金額02 = fukaTmpEntity.getTkKibetsuGaku02();
        final Decimal 特徴期別金額03 = fukaTmpEntity.getTkKibetsuGaku03();
        if (特徴期別金額01 != null) {
            特徴期別金額合計 = 特徴期別金額合計.add(特徴期別金額01);
        }
        if (特徴期別金額02 != null) {
            特徴期別金額合計 = 特徴期別金額合計.add(特徴期別金額02);
        }
        if (特徴期別金額03 != null) {
            特徴期別金額合計 = 特徴期別金額合計.add(特徴期別金額03);
        }
        Decimal 普徴期別金額合計 = Decimal.ZERO;
        for (int i = 仮算定期間_最小期; i <= 仮算定期間_最大期; i++) {
            普徴期別金額合計 = 普徴期別金額合計.add(普徴期別金額取得(i, fukaTmpEntity));
        }
        TokuchoHeijunkaRokuBatchTaishogaiTempEntity 対象外データTempEntity;
        TokuchoHeijunkaRokuBatchTaishogaiTempEntity 対象者データTempEntity;
        if (Decimal.ZERO.compareTo(特徴期別金額合計) < 0 && Decimal.ZERO.compareTo(普徴期別金額合計) < 0) {
            備考コード = 備考コード_併徴者;
        } else if (Decimal.ZERO.equals(普徴期別金額合計) && Decimal.ZERO.equals(特徴期別金額01)) {
            備考コード = 備考コード_特徴6月開始者;
        } else if (特徴期別金額比較(特徴期別金額01, 特徴期別金額02, 特徴期別金額03)) {
            備考コード = 備考コード_仮徴収額修正者;
        }

        if (!備考コード.isEmpty()) {
            対象外データTempEntity = new TokuchoHeijunkaRokuBatchTaishogaiTempEntity(fukaTmpEntity, 備考コード);
            対象外データ一時tableWriter.insert(対象外データTempEntity);
        } else {
            対象者データTempEntity = new TokuchoHeijunkaRokuBatchTaishogaiTempEntity(fukaTmpEntity, RString.EMPTY);
            対象者データ一時tableWriter.insert(対象者データTempEntity);
        }
    }

    private boolean 特徴期別金額比較(final Decimal 特徴期別金額01, final Decimal 特徴期別金額02, final Decimal 特徴期別金額03) {
        return 特徴期別金額不等(特徴期別金額01, 特徴期別金額02)
                || 特徴期別金額不等(特徴期別金額02, 特徴期別金額03)
                || 特徴期別金額不等(特徴期別金額01, 特徴期別金額03);
    }

    private boolean 特徴期別金額不等(final Decimal 特徴期別金額01, final Decimal 特徴期別金額02) {
        return (特徴期別金額01 != null && 特徴期別金額02 != null && !特徴期別金額01.equals(特徴期別金額02))
                || (特徴期別金額01 == null && 特徴期別金額02 != null) || (特徴期別金額01 != null && 特徴期別金額02 == null);
    }

    private Decimal 普徴期別金額取得(int 仮算定期間_期, FukaJohoTmpEntity fukaTmpEntity) {
        Decimal 普徴期別金額 = Decimal.ZERO;
        switch (仮算定期間_期) {
            case 仮算定期間_期1:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku01());
                break;
            case 仮算定期間_期2:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku02());
                break;
            case 仮算定期間_期3:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku03());
                break;
            case 仮算定期間_期4:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku04());
                break;
            case 仮算定期間_期5:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku05());
                break;
            case 仮算定期間_期6:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku06());
                break;
            case 仮算定期間_期7:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku07());
                break;
            case 仮算定期間_期8:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku08());
                break;
            case 仮算定期間_期9:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku09());
                break;
            case 仮算定期間_期10:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku10());
                break;
            case 仮算定期間_期11:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku11());
                break;
            case 仮算定期間_期12:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku12());
                break;
            case 仮算定期間_期13:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku13());
                break;
            case 仮算定期間_期14:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaTmpEntity.getFuKibetsuGaku14());
                break;
            default:
                break;
        }
        return 普徴期別金額;
    }

    private Decimal get普徴期別金額合計(Decimal 普徴期別金額合計, Decimal 普徴期別金額) {
        if (普徴期別金額 != null) {
            普徴期別金額合計 = 普徴期別金額合計.add(普徴期別金額);
        }
        return 普徴期別金額合計;
    }
}
