/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.ShoukanFurikomiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetaiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還データ取得情報_振込明細一時に登録処理_Processクラスです．
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
public class ShoukanFurikomiProcess extends BatchProcessBase<FurikomiDetaiResultEntity> {

    private ShoukanFurikomiProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010."
            + "IFurikomimeisaiFurikomiMapper.get償還データ取得");

    private static final int ZERO = 0;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final int 桁数_10 = 10;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toFurikomimeisaiFurikomiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(FurikomiDetailTempTableEntity.class)
                .tempTableName(FurikomiDetailTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(FurikomiDetaiResultEntity fdre) {
        tmpTableWriter.insert(create振込明細_償還(fdre));
    }

    private FurikomiDetailTempTableEntity create振込明細_償還(FurikomiDetaiResultEntity fdre) {
        FurikomiDetailTempTableEntity data = new FurikomiDetailTempTableEntity();
        data.setDataKubun(ONE);
        data.setHihokenshaNo(fdre.get償還払支給判定結果Entity().getHiHokenshaNo());
        data.setServiceTeikyoYM(fdre.get償還払支給判定結果Entity().getServiceTeikyoYM());
        data.setSeiriNo(fdre.get償還払支給判定結果Entity().getSeiriNo());
        data.setRirekiNo(ZERO);
        data.setShoKisaiHokenshaNo(fdre.get償還払支給判定結果Entity().getShoKisaiHokenshaNo());
        data.setKetteiTsuchiNo(fdre.get償還払支給判定結果Entity().getKetteiTsuchiNo());
        DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果Entity = fdre.get償還払支給判定結果Entity();
        if (償還払支給判定結果Entity != null && Decimal.ZERO.equals(償還払支給判定結果Entity.getSagakuKingakuGokei())) {
            Decimal 支払金額 = 償還払支給判定結果Entity.getShiharaiKingaku();
            Decimal 前回支払金額 = 償還払支給判定結果Entity.getZenkaiShiharaiKingaku();
            if (支払金額 != null && 前回支払金額 != null) {
                data.setFurikomiKingaku(支払金額.subtract(前回支払金額));
            }

        }
        if (償還払支給判定結果Entity != null && !Decimal.ZERO.equals(償還払支給判定結果Entity.getSagakuKingakuGokei())) {
            Decimal 差額金額合計 = 償還払支給判定結果Entity.getSagakuKingakuGokei();
            Decimal 前回支払金額 = 償還払支給判定結果Entity.getZenkaiShiharaiKingaku();
            if (差額金額合計 != null && 前回支払金額 != null) {
                data.setFurikomiKingaku(差額金額合計.subtract(前回支払金額));
            }
        }
        data.setZenkaiShiharaiKingaku(fdre.get償還払支給判定結果Entity().getZenkaiShiharaiKingaku());
        data.setSagakuKingakuGokei(fdre.get償還払支給判定結果Entity().getSagakuKingakuGokei());
        data.setShiharaiHohoKubunCode(fdre.get償還払支給申請Entity().getShiharaiHohoKubunCode());
        data.setKozaID(fdre.get償還払支給申請Entity().getKozaID());
        data.setJuryoininKeiyakuNo(fdre.get償還払支給申請Entity().getJuryoininKeiyakuNo());
        data.setShiharaiBasho(fdre.get償還払支給申請Entity().getShiharaiBasho());
        data.setShiharaiKaishiYMD(fdre.get償還払支給申請Entity().getShiharaiKaishiYMD());
        data.setShiharaiShuryoYMD(fdre.get償還払支給申請Entity().getShiharaiShuryoYMD());
        data.setShiharaiKaishiTime(fdre.get償還払支給申請Entity().getShiharaiKaishiTime());
        data.setShiharaiShuryoTime(fdre.get償還払支給申請Entity().getShiharaiShuryoTime());
        data.setShikibetsuCode(ShikibetsuCode.EMPTY);
        data.setShimeiKana(AtenaKanaMeisho.EMPTY);
        data.setShimei(AtenaMeisho.EMPTY);
        data.setShimei50onKana(RString.EMPTY);
        data.setChoikiCode(ChoikiCode.EMPTY);
        data.setGyoseikuCode(GyoseikuCode.EMPTY);
        data.setGyoseikuMei(RString.EMPTY);
        data.setYubinNo(YubinNo.EMPTY);
        data.setJusho(RString.EMPTY);
        data.setShichosonCode(LasdecCode.EMPTY);
        if (TWO.equals(parameter.get支払方法().getコード())) {
            data.setKozaDataFlag(true);
        } else if (!TWO.equals(parameter.get支払方法().getコード())) {
            data.setKozaDataFlag(false);
        }
        data.setKozaShikibetsuCode(ShikibetsuCode.EMPTY);
        data.setKinyuKikanCode(KinyuKikanCode.EMPTY);
        data.setKinyuKikanName(RString.EMPTY);
        data.setKinyuKikanKanaName(RString.EMPTY);
        data.setKinyuKikanShitenCode(KinyuKikanShitenCode.EMPTY);
        data.setKinyuKikanShitenName(RString.EMPTY);
        data.setKinyuKikanShitenKanaName(RString.EMPTY);
        data.setYokinShubetsuCode(RString.EMPTY);
        data.setYokinShubetsuName(RString.EMPTY);
        data.setKozaNo(RString.EMPTY);
        data.setKozaMeiginin(AtenaKanaMeisho.EMPTY);
        data.setKozaMeigininKanji(AtenaMeisho.EMPTY);
        if (TWO.equals(parameter.get支払方法().getコード())) {
            data.setKozaNayoseKey(fdre.get償還払支給判定結果Entity().getHiHokenshaNo().getColumnValue().padZeroToLeft(桁数_10).
                    concat(fdre.get償還払支給判定結果Entity().getServiceTeikyoYM().toDateString()).
                    concat(fdre.get償還払支給判定結果Entity().getSeiriNo().padZeroToLeft(桁数_10)).concat(new RString("0000")));
        } else if (!TWO.equals(parameter.get支払方法().getコード())) {
            data.setKozaNayoseKey(RString.EMPTY);
        }
        data.setShinseiDataFlag(false);
        data.setShinseiKubunCode(Code.EMPTY);
        data.setChoikiCode(ChoikiCode.EMPTY);
        data.setNinteiYukoKikanKaishiYMD(FlexibleDate.EMPTY);
        data.setNinteiYukoKikanShuryoYMD(FlexibleDate.EMPTY);
        return data;
    }
}
