/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiFurikomiDataJigyoKogakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細・振込みデータ作成（事業高額）のデータ取得です。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class InsJigyoKogakuProcess extends BatchProcessBase<FurikomimeisaiFurikomiDataJigyoKogakuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.get事業高額データ");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_4 = 4;
    private static final int INT_6 = 6;
    private static final int INT_10 = 10;
    private static final RString TWO = new RString("2");
    private static final RString RSTRING_21ZERO = new RString("000000000000000000000");
    private static final RString RSTRING_01 = new RString("01");
    private static final RString 振込明細一時NAME = new RString("DbWT0510FurikomiMeisai");

    /**
     * 登録件数取得です。
     */
    public static final RString PARAMETER_OUT_登録件数;

    static {
        PARAMETER_OUT_登録件数 = new RString("登録件数");
    }
    private OutputParameter<Integer> 登録件数;
    private FurikomimeisaiFurikomiDataProcessParameter parameter;
    private int renban;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 振込明細一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter shoriKekkaKakuninListDataNasi;

    @Override
    protected void initialize() {
        登録件数 = new OutputParameter<>();
        renban = INT_0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        振込明細一時tableWriter = new BatchEntityCreatedTempTableWriter(振込明細一時NAME, DbWT0510FurikomiMeisaiTempEntity.class);
        shoriKekkaKakuninListDataNasi
                = new BatchEntityCreatedTempTableWriter(ShoriKekkaKakuninListTempTableEntity.TABLE_NAME, ShoriKekkaKakuninListTempTableEntity.class);
    }

    @Override
    protected void process(FurikomimeisaiFurikomiDataJigyoKogakuEntity entity) {
        renban = renban + INT_1;
        DbWT0510FurikomiMeisaiTempEntity 振込明細一時entity = get振込明細一時entity(entity);
        振込明細一時tableWriter.insert(振込明細一時entity);
    }

    @Override
    protected void afterExecute() {
        登録件数.setValue(renban);
        if (renban == INT_0) {
            shoriKekkaKakuninListDataNasi.insert(create処理結果確認_振込データなし());
        }
    }

    private ShoriKekkaKakuninListTempTableEntity create処理結果確認_振込データなし() {
        ShoriKekkaKakuninListTempTableEntity data = new ShoriKekkaKakuninListTempTableEntity();
        data.setErrorKubun(FurikomiDataSakusei_ErrorKubun.振込データなし.getコード());
        return data;
    }

    private DbWT0510FurikomiMeisaiTempEntity get振込明細一時entity(FurikomimeisaiFurikomiDataJigyoKogakuEntity entity) {
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果entity = entity.get判定結果entity();
        DbT3110JigyoKogakuShikyuShinseiEntity 支給申請entity = entity.get支給申請entity();
        DbT3112KogakuShikyuShinsaKetteiEntity 審査決定entity = entity.get審査決定entity();
        DbT3105SogoJigyoTaishoshaEntity 総合事業entity = entity.get総合事業entity();
        DbWT0510FurikomiMeisaiTempEntity 一時entity = new DbWT0510FurikomiMeisaiTempEntity();
        一時entity.setHihokenshaNo(判定結果entity.getHihokenshaNo());
        一時entity.setServiceTeikyoYM(判定結果entity.getServiceTeikyoYM());
        一時entity.setTaishoNendo(FlexibleYear.EMPTY);
        一時entity.setShikyuShinseishoSeiriNo(RString.EMPTY);
        一時entity.setRirekiNo(判定結果entity.getRirekiNo().intValue());
        一時entity.setShoKisaiHokenshaNo(判定結果entity.getShoKisaiHokenshaNo());
        RString 決定通知番号;
        Decimal 振込金額;
        FlexibleDate 決定年月日;
        if (ShinsaHohoKubun.審査依頼.getコード().equals(判定結果entity.getShinsaHohoKubun())) {
            if (審査決定entity == null) {
                決定通知番号 = RString.EMPTY;
                振込金額 = null;
                決定年月日 = FlexibleDate.EMPTY;
            } else {
                決定通知番号 = 審査決定entity.getTsuchishoNo();
                振込金額 = 審査決定entity.getJigyoKogakuShikyuGaku();
                決定年月日 = 審査決定entity.getKetteiYM() == null || 審査決定entity.getKetteiYM().isEmpty()
                        ? FlexibleDate.EMPTY : new FlexibleDate(審査決定entity.getKetteiYM().toDateString().concat(RSTRING_01));
            }
        } else {
            決定通知番号 = RString.EMPTY;
            振込金額 = 判定結果entity.getShiharaiKingaku();
            決定年月日 = 判定結果entity.getKetteiYMD();
        }
        一時entity.setKetteiTsuchiNo(決定通知番号);
        一時entity.setFurikomiKingaku(振込金額);
        一時entity.setKeisanKaishiYMD(FlexibleDate.EMPTY);
        一時entity.setKeisanShuryoYMD(FlexibleDate.EMPTY);
        一時entity.setShinseiYMD(支給申請entity.getShinseiYMD());
        一時entity.setKetteiYMD(決定年月日);
        一時entity.setJikoFutanSogaku(Decimal.ZERO);
        一時entity.setShiharaiHohoKubunCode(支給申請entity.getShiharaiHohoKubunCode());
        一時entity.setKozaID(支給申請entity.getKozaID());
        一時entity.setShiharaiBasho(支給申請entity.getShiharaiBasho());
        一時entity.setShiharaiKaishiYMD(支給申請entity.getShiharaiKaishiYMD());
        一時entity.setShiharaiShuryoYMD(支給申請entity.getShiharaiShuryoYMD());
        一時entity.setShiharaiKaishiTime(支給申請entity.getShiharaiKaishiTime());
        一時entity.setShiharaiShuryoTime(支給申請entity.getShiharaiShuryoTime());
        一時entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        一時entity.setShimeiKana(AtenaKanaMeisho.EMPTY);
        一時entity.setShimei(AtenaMeisho.EMPTY);
        一時entity.setShimei50onKana(RString.EMPTY);
        一時entity.setChoikiCode(ChoikiCode.EMPTY);
        一時entity.setGyoseikuCode(GyoseikuCode.EMPTY);
        一時entity.setGyoseikuMei(RString.EMPTY);
        一時entity.setYubinNo(YubinNo.EMPTY);
        一時entity.setJusho(AtenaJusho.EMPTY);
        一時entity.setShichosonCode(LasdecCode.EMPTY);
        一時entity.setKozaDataFlag(TWO.equals(parameter.get支払方法()));
        一時entity.setKozaShikibetsuCode(ShikibetsuCode.EMPTY);
        一時entity.setKinyuKikanCode(KinyuKikanCode.EMPTY);
        一時entity.setKinyuKikanName(RString.EMPTY);
        一時entity.setKinyuKikanKanaName(RString.EMPTY);
        一時entity.setKinyuKikanShitenCode(KinyuKikanShitenCode.EMPTY);
        一時entity.setKinyuKikanShitenName(RString.EMPTY);
        一時entity.setKinyuKikanShitenKanaName(RString.EMPTY);
        一時entity.setYokinShubetsuCode(RString.EMPTY);
        一時entity.setYokinShubetsuName(RString.EMPTY);
        一時entity.setKozaNo(RString.EMPTY);
        一時entity.setKozaMeiginin(AtenaKanaMeisho.EMPTY);
        一時entity.setKozaMeigininKanji(AtenaMeisho.EMPTY);
        RString 口座名寄せキー;
        if (TWO.equals(parameter.get支払方法())) {
            口座名寄せキー = 判定結果entity.getHihokenshaNo().getColumnValue().padZeroToLeft(INT_10)
                    .concat(判定結果entity.getServiceTeikyoYM().toDateString().padZeroToLeft(INT_6))
                    .concat(RSTRING_21ZERO).concat(new RString(判定結果entity.getRirekiNo().intValue()).padZeroToLeft(INT_4));
        } else {
            口座名寄せキー = RString.EMPTY;
        }
        一時entity.setKozaNayoseKey(口座名寄せキー);
        一時entity.setShinseiDataFlag(false);
        一時entity.setShinseiKubunCode(Code.EMPTY);
        一時entity.setYokaigoJotaiKubunCode(Code.EMPTY);
        一時entity.setNinteiYukoKikanKaishiYMD(FlexibleDate.EMPTY);
        一時entity.setNinteiYukoKikanShuryoYMD(FlexibleDate.EMPTY);
        if (総合事業entity != null) {
            一時entity.setSogoJigyoFlag(true);
            一時entity.setSogoJigyoTekiyoKaishiYMD(総合事業entity.getTekiyoKaishiYMD());
            一時entity.setSogoJigyoTekiyoShuryoYMD(総合事業entity.getTekiyoShuryoYMD());
        } else {
            一時entity.setSogoJigyoFlag(false);
            一時entity.setSogoJigyoTekiyoKaishiYMD(FlexibleDate.EMPTY);
            一時entity.setSogoJigyoTekiyoShuryoYMD(FlexibleDate.EMPTY);
        }
        一時entity.setRenban(renban);
        return 一時entity;
    }

}
