/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuFourEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShokanShinseiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.TainoCountermeasureTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス4クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoHaakuTainouTaisakuProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuFourEntity> {

    private int 差止中件数 = 0;
    private int 控除件数 = 0;
    private Decimal 差止中金額 = Decimal.ZERO;
    private static final RString 差止情報コード = new RString("1");
    private static final RString 保険料控除情報コード = new RString("2");
    private static final RString 差止控除状態区分_登録 = new RString("01");

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find滞納者対策情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TainoCountermeasureTempTableEntity.class)
                .tempTableName(TainoCountermeasureTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuFourEntity t) {
        TainoCountermeasureTempTableEntity tempTableEntity = create滞納者対策情報一時テーブル情報(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private TainoCountermeasureTempTableEntity create滞納者対策情報一時テーブル情報(ShiharaiHohoHenkoHaakuFourEntity t) {
        TainoCountermeasureTempTableEntity result = new TainoCountermeasureTempTableEntity();

        result.setHihokenshaNo(t.get支払方法変更Entity().getHihokenshaNo());
        result.setTekiyoKaishiYMD(t.get支払方法変更Entity().getTekiyoKaishiYMD());
        result.setTekiyoShuryoYMD(t.get支払方法変更Entity().getTekiyoShuryoYMD());
        result.setShuryoUketsukeYMD(t.get支払方法変更Entity().getShuryoShinsei_UketsukeYMD());
        result.setYokokuHakkoYMD(t.get支払方法変更Entity().getYokoku_TsuchiHakkoYMD());
        result.setBemmeiYMD(t.get支払方法変更Entity().getBemmei_TeishutsuYMD());
        result.setBemmeiUketsukeYMD(t.get支払方法変更Entity().getBemmei_UketsukeYMD());
        result.setShokanYMD(t.get支払方法変更Entity().getShokan_TsuchiHakkoYMD());
        result.setShokanHakkoYMD(t.get支払方法変更Entity().getHihokenshaShoTeishutsuYMD());

        FlexibleDate 最大差止納付期日 = FlexibleDate.EMPTY;
        FlexibleDate 最大の控除被保険者証提出期限 = FlexibleDate.EMPTY;

        if (t.get支払方法変更差止リスト() != null && t.get支払方法変更差止リスト().isEmpty()) {
            for (DbT4024ShiharaiHohoHenkoSashitomeEntity 支払方法変更差止Data : t.get支払方法変更差止リスト()) {
                if (is情報分類区分_差止控除状態区分が登録(支払方法変更差止Data.getJohoBunruiKubun(),
                        支払方法変更差止Data.getSashitomeKojoJotaiKubun())) {
                    差止中件数 = 差止中件数 + 1;
                }

                if (t.get償還情報リスト() != null && !t.get償還情報リスト().isEmpty()) {
                    for (ShokanShinseiHanteiKekkaJohoEntity 償還Data : t.get償還情報リスト()) {
                        if (支払方法変更差止Data.getSashitome_ServiceTeikyoYM() != null && FlexibleYearMonth.EMPTY.equals(支払方法変更差止Data.getSashitome_ServiceTeikyoYM())
                                && 償還Data.get償還払支給申請_サービス提供年月() != null && FlexibleYearMonth.EMPTY.equals(償還Data.get償還払支給申請_サービス提供年月())
                                && 支払方法変更差止Data.getSashitome_ServiceTeikyoYM().equals(償還Data.get償還払支給申請_サービス提供年月())) {

                            差止中金額 = 差止中金額.add(償還Data.get償還払支給判定結果_支払金額().subtract(償還Data.get償還払支給判定結果_差額金額合計()));
                        }
                    }
                }
                最大差止納付期日 = get最大の差止納付期限(最大差止納付期日, 支払方法変更差止Data.getSashitome_NofuYMD());
                最大の控除被保険者証提出期限 = get最大の差止納付期限(最大の控除被保険者証提出期限, 支払方法変更差止Data.getKojo_ShoTeishutsuYMD());
                edit控除件数と控除証期限(支払方法変更差止Data.getJohoBunruiKubun());
            }
        }

        result.setSashitomeProcessNumber(差止中件数);
        result.setSashitomeProcessKingaku(差止中金額);
        result.setSashitomePaymentYMD(最大差止納付期日);
        result.setKoujoNumber(差止中件数);
        result.setKojoShoTeishutsuYMD(最大の控除被保険者証提出期限);
        result.setTorokuKubun(t.get支払方法変更Entity().getTorokuKubun());
        result.setShuryoKubun(t.get支払方法変更Entity().getShuryoKubun());

        return result;
    }

    private boolean is情報分類区分_差止控除状態区分が登録(RString 情報分類区分, RString 差止控除状態区分) {
        return 差止情報コード.equals(情報分類区分) && 差止控除状態区分_登録.equals(差止控除状態区分);
    }

    private FlexibleDate get最大の差止納付期限(FlexibleDate 最大差止納付期日, FlexibleDate 該当行差止納付期日) {

        if (最大差止納付期日 == null || 最大差止納付期日.isEmpty()) {
            return 該当行差止納付期日;
        } else if (該当行差止納付期日 == null || 該当行差止納付期日.isEmpty()) {
            return 最大差止納付期日;
        } else if (最大差止納付期日.isBefore(該当行差止納付期日)) {
            return 該当行差止納付期日;
        }
        return 最大差止納付期日;
    }

    private Decimal edit差止中金額(FlexibleYearMonth 差止サービス提供年月, FlexibleYearMonth 還払支給申請年月,
            RString 差止償還整理番号, RString 償還払支給申請_整理番号,
            Decimal 支給金額, Decimal 差額金額合計) {

        if (差止サービス提供年月 != null && 還払支給申請年月 != null
                && !差止償還整理番号.isNullOrEmpty()
                && !償還払支給申請_整理番号.isNullOrEmpty()
                && 差止サービス提供年月.equals(還払支給申請年月)
                && 差止償還整理番号.equals(償還払支給申請_整理番号)) {

            差止中金額 = 差止中金額.add(支給金額.multiply(差額金額合計));
        }
        return Decimal.ZERO;
    }

    private void edit控除件数と控除証期限(RString 情報分類区分) {
        if (保険料控除情報コード.equals(情報分類区分)) {
            控除件数 = 控除件数 + 1;
        }
    }
}
