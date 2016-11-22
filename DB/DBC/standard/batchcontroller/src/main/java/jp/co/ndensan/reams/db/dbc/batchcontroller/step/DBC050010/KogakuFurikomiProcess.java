/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.GdaekomimeisaiFurikomiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.GdaekomiDetaiResultEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
 * 高額データ取得情報_振込明細一時に登録処理_Processクラスです．
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
public class KogakuFurikomiProcess extends BatchProcessBase<GdaekomiDetaiResultEntity> {

    private GdaekomimeisaiFurikomiProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010."
            + "IGdaekomimeisaiFurikomiMapper.get高額データ取得");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final int 桁数_10 = 10;
    private static final int 桁数_4 = 4;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toGdaekomimeisaiFurikomiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(FurikomiDetailTempTableEntity.class)
                .tempTableName(FurikomiDetailTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(GdaekomiDetaiResultEntity fdre) {
        tmpTableWriter.insert(create振込明細_高額情報(fdre));
    }

    private FurikomiDetailTempTableEntity create振込明細_高額情報(GdaekomiDetaiResultEntity fdre) {
        FurikomiDetailTempTableEntity data = new FurikomiDetailTempTableEntity();
        data.setDataKubun(TWO);
        data.setHihokenshaNo(fdre.get高額介護サービス費支給判定結果Entity().getHihokenshaNo());
        data.setServiceTeikyoYM(fdre.get高額介護サービス費支給判定結果Entity().getServiceTeikyoYM());
        data.setSeiriNo(RString.EMPTY);
        data.setRirekiNo(fdre.get高額介護サービス費支給判定結果Entity().getRirekiNo());
        data.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(fdre.get高額介護サービス費支給判定結果Entity().getShoKisaiHokenshaNo().getColumnValue()));
        if (ONE.equals(fdre.get高額介護サービス費支給判定結果Entity().getShinsaHohoKubun())) {
            data.setKetteiTsuchiNo(fdre.get高額介護サービス費支給審査決定Entity().getTsuchishoNo());
        } else if (!ONE.equals(fdre.get高額介護サービス費支給判定結果Entity().getShinsaHohoKubun())) {
            data.setKetteiTsuchiNo(RString.EMPTY);
        }
        if (ONE.equals(fdre.get高額介護サービス費支給判定結果Entity().getShinsaHohoKubun())) {
            data.setFurikomiKingaku(fdre.get高額介護サービス費支給審査決定Entity().getKogakuShikyuGaku());
        } else if (!ONE.equals(fdre.get高額介護サービス費支給判定結果Entity().getShinsaHohoKubun())) {
            data.setFurikomiKingaku(fdre.get高額介護サービス費支給判定結果Entity().getShikyuKingaku());
        }
        data.setZenkaiShiharaiKingaku(Decimal.ZERO);
        data.setSagakuKingakuGokei(Decimal.ZERO);
        data.setShiharaiHohoKubunCode(fdre.get高額介護サービス費支給申請Entity().getShiharaiHohoKubunCode());
        data.setKozaID(fdre.get高額介護サービス費支給申請Entity().getKozaID());
        data.setJuryoininKeiyakuNo(RString.EMPTY);
        data.setShiharaiBasho(fdre.get高額介護サービス費支給申請Entity().getShiharaiBasho());
        data.setShiharaiKaishiYMD(fdre.get高額介護サービス費支給申請Entity().getShiharaiKaishiYMD());
        data.setShiharaiShuryoYMD(fdre.get高額介護サービス費支給申請Entity().getShiharaiShuryoYMD());
        data.setShiharaiKaishiTime(fdre.get高額介護サービス費支給申請Entity().getShiharaiKaishiTime());
        data.setShiharaiShuryoTime(fdre.get高額介護サービス費支給申請Entity().getShiharaiShuryoTime());
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
            data.setKozaNayoseKey(fdre.get高額介護サービス費支給判定結果Entity().getHihokenshaNo().getColumnValue().padZeroToLeft(桁数_10).
                    concat(fdre.get高額介護サービス費支給判定結果Entity().getServiceTeikyoYM().toDateString()).
                    concat(new RString("0000000000")).
                    concat(new RString(fdre.get高額介護サービス費支給判定結果Entity().getRirekiNo()).padZeroToLeft(桁数_4)));
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
