/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120100;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanfushikyuketteiin.ShokanFushikyuKetteiInCSVHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanfushikyuketteiin.ShokanFushikyuKetteiInCSVMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.DbWT3036ShokanHanteiKekkaTemEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払不支給決定情報取込
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuKetteiInReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KogakuKyufuKetteiReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;

    private final RString 区切り文字 = new RString(",");
    private final RString レコード種別 = new RString("1");
    private final RString レコード種別_エンド = new RString("3");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private static final Integer INDEX_0 = 0;
    private static final Integer INT_1 = 1;
    private static final Integer INDEX_3 = 3;
    private static final RString NUM = new RString("99");

    private int 連番;
    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private ShokanFushikyuKetteiInCSVMeisaiEntity meisaiZenEntity;
    private ShokanFushikyuKetteiInCSVHeadEntity headEntity;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還払支給判定結果一時tableWriter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 償還払支給判定結果一時_TABLE_NAME = new RString("DbWT3036ShokanHanteiKekka");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    @Override
    protected void initialize() {
        returnEntity = new FlowEntity();
        controlCsvEntity = new KokuhorenkyoutsuControlCsvEntity();
        連番 = INDEX_0;
        flowEntity = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先フォルダ(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        償還払支給判定結果一時tableWriter
                = new BatchEntityCreatedTempTableWriter(償還払支給判定結果一時_TABLE_NAME, DbWT3036ShokanHanteiKekkaTemEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.
                        toObject(KokuhorenkyoutsuControlCsvEntity.class, data);
                returnEntity.setShoriYM(new FlexibleYearMonth(controlCsvEntity.getShoriYM()));
            } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                headEntity = new ShokanFushikyuKetteiInCSVHeadEntity();
                headEntity = ListToObjectMappingHelper.
                        toObject(ShokanFushikyuKetteiInCSVHeadEntity.class, data);
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                meisaiZenEntity = new ShokanFushikyuKetteiInCSVMeisaiEntity();
                meisaiZenEntity = ListToObjectMappingHelper.
                        toObject(ShokanFushikyuKetteiInCSVMeisaiEntity.class, data);
                連番 = 連番 + INT_1;
                一時TBLに登録する(headEntity, meisaiZenEntity, 連番);
            }

        }

    }

    @Override
    protected void afterExecute() {
        if (連番 == INDEX_0) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(NUM);
            処理結果リスト一時tableWriter.insert(errorTempentity.toEntity());
        }
        returnEntity.set明細データ登録件数(連番);
        returnEntity.setCodeNum(Integer.valueOf(controlCsvEntity.getCodeNum().toString()));
        flowEntity.setValue(returnEntity);
    }

    private void 一時TBLに登録する(ShokanFushikyuKetteiInCSVHeadEntity headEntity, ShokanFushikyuKetteiInCSVMeisaiEntity meisaiZenEntity, int 連番) {
        DbWT3036ShokanHanteiKekkaTemEntity 登録Entity = new DbWT3036ShokanHanteiKekkaTemEntity();
        登録Entity.setRenban(連番);
        登録Entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(headEntity.get証記載保険者番号()));
        登録Entity.setShoKisaiHokenshaName(headEntity.get保険者名());
        登録Entity.setSakuseiYMD(headEntity.get作成年月日());
        登録Entity.setKokuhorenName(headEntity.get国保連合会名());
        登録Entity.setTsuchishoNo(meisaiZenEntity.getNo());
        登録Entity.setSeiriNo(meisaiZenEntity.get整理番号());
        登録Entity.setServiceTeikyoYM(meisaiZenEntity.getサービス提供年月());
        if (!RString.isNullOrEmpty(meisaiZenEntity.get事業所番号())) {
            登録Entity.setJigyoshoNo(getJigyoshaNo(meisaiZenEntity.get事業所番号()));
        }
        登録Entity.setJigyoshoName(getRString(meisaiZenEntity.get事業所名_漢字()));
        登録Entity.setServiceShuruiCode(getServiceShuruiCode(meisaiZenEntity.getサービス種類コード()));
        登録Entity.setServiceShuruiMei(getRString(meisaiZenEntity.getサービス種類名()));
        登録Entity.setTanisuKingaku(meisaiZenEntity.get単位数_金額());
        登録Entity.setShiharaiKingaku(Decimal.ZERO);
        登録Entity.setZougenTanisu(Decimal.ZERO);
        登録Entity.setShiharaiHohoKubunCode(RString.EMPTY);
        登録Entity.setBiko1(getRString(meisaiZenEntity.get備考1()));
        登録Entity.setBiko2(getRString(meisaiZenEntity.get備考2()));
        登録Entity.setKoshinDBumu(RString.EMPTY);
        登録Entity.setWrkJigyoshoNo(getJigyoshaNo(meisaiZenEntity.get事業所番号()));
        償還払支給判定結果一時tableWriter.insert(登録Entity);

        DbWT0001HihokenshaIchijiEntity 被保険者Entity = new DbWT0001HihokenshaIchijiEntity();
        被保険者Entity.setMeisaiRenban(連番);
        被保険者Entity.setShoHokenshaNo(new ShoKisaiHokenshaNo(headEntity.get証記載保険者番号()));
        被保険者Entity.setOrgHihokenshaNo(new HihokenshaNo(meisaiZenEntity.get被保険者番号()));
        被保険者Entity.setServiceTeikyoYmd(new FlexibleDate(meisaiZenEntity.getサービス提供年月().
                toDateString().concat(new RString(meisaiZenEntity.getサービス提供年月().getLastDay()))));
        被保険者Entity.setOrgHihokenshaKanaShimei(RString.EMPTY);
        被保険者Entity.setOrgHihokenshaShimei(meisaiZenEntity.get被保険者氏名_漢字());
        被保険者Entity.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者Entity.setHenkanHihokenshaNo(HihokenshaNo.EMPTY);
        被保険者Entity.setHihokenshaNo(new HihokenshaNo(meisaiZenEntity.get被保険者番号()));
        被保険者Entity.setShichosonCode(LasdecCode.EMPTY);
        被保険者Entity.setKannaiKangaiKubun(RString.EMPTY);
        被保険者Entity.setYubinNo(RString.EMPTY);
        被保険者Entity.setChoikiCode(RString.EMPTY);
        被保険者Entity.setGyoseikuCode(RString.EMPTY);
        被保険者Entity.setGyoseikuMei(RString.EMPTY);
        被保険者Entity.setJusho(RString.EMPTY);
        被保険者Entity.setBanchi(RString.EMPTY);
        被保険者Entity.setKatagaki(RString.EMPTY);
        被保険者Entity.setKanaMeisho(RString.EMPTY);
        被保険者Entity.setMeisho(RString.EMPTY);
        被保険者Entity.setShimei50onKana(RString.EMPTY);
        被保険者Entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        被保険者Entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        被保険者Entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        被保険者Entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        被保険者Entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        被保険者Entity.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
        被保険者一時tableWriter.insert(被保険者Entity);

    }

    private JigyoshaNo getJigyoshaNo(RString jigyoshaNoStr) {
        if (RString.isNullOrEmpty(jigyoshaNoStr)) {
            return JigyoshaNo.EMPTY;
        }
        return new JigyoshaNo(jigyoshaNoStr);
    }

    private RString getRString(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        }
        return str;
    }

    private ServiceShuruiCode getServiceShuruiCode(RString serviceShuruiCodeStr) {
        if (RString.isNullOrEmpty(serviceShuruiCodeStr)) {
            return ServiceShuruiCode.EMPTY;
        }
        return new ServiceShuruiCode(serviceShuruiCodeStr);
    }
}
