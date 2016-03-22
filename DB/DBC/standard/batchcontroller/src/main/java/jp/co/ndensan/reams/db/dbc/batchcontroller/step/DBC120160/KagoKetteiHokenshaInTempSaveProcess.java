
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120160;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVHeaderEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一時テーブルの登録
 */
public class KagoKetteiHokenshaInTempSaveProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
    }
    InputParameter<RString> filePath;

    private final Integer レコード種別 = 1;
    private final RString 区切り文字 = new RString(",");
    private KagoKetteiHokenshaInCSVHeaderEntity header;
    private KagoKetteiHokenshaInCSVMeisaiEntity meisai;
    private KagoKetteiHokenshaInCSVShukeiEntity shukei;
    private List<KagoKetteiHokenshaInCSVMeisaiEntity> list;
    private final RString レコード種別_ヘッダ = new RString("H1");
    private final RString レコード種別_明細 = new RString("D1");
    private final RString レコード種別_集計 = new RString("T1");

    @BatchWriter
    BatchEntityCreatedTempTableWriter meisaiTempTableWriter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter shukeiTempTableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        list = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
    }

    @Override
    protected void createWriter() {
        meisaiTempTableWriter
                = new BatchEntityCreatedTempTableWriter(KagoKetteiHokenshaInMeisaiEntity.TABLE_NAME, KagoKetteiHokenshaInMeisaiEntity.class);

        shukeiTempTableWriter
                = new BatchEntityCreatedTempTableWriter(KagoKetteiHokenshaInShukeiEntity.TABLE_NAME, KagoKetteiHokenshaInShukeiEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (null == data || 1 >= data.size()) {
            return;
        }
        if (レコード種別_ヘッダ.equals(data.get(レコード種別))) {
            header = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInCSVHeaderEntity.class, data);
        } else if (レコード種別_明細.equals(data.get(レコード種別))) {
            meisai = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInCSVMeisaiEntity.class, data);
            list.add(meisai);
        } else if (レコード種別_集計.equals(data.get(レコード種別))) {
            shukei = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInCSVShukeiEntity.class, data);
        }
    }

    @Override
    protected void afterExecute() {
        for (KagoKetteiHokenshaInCSVMeisaiEntity meisaiEntity : list) {
            meisaiTempTableWriter.insert(createMeiseiRecord(header, meisaiEntity));
        }
        shukeiTempTableWriter.insert(createShukeiRecord(header, shukei));
    }

    private KagoKetteiHokenshaInMeisaiEntity createMeiseiRecord(
            KagoKetteiHokenshaInCSVHeaderEntity csvHeader,
            KagoKetteiHokenshaInCSVMeisaiEntity csvMeisei) {

        KagoKetteiHokenshaInMeisaiEntity entity
                = new KagoKetteiHokenshaInMeisaiEntity();

        entity.setToriatsukaiYM(new FlexibleYearMonth(trim囲み文字(csvHeader.getToriatsukaiYM())));
        entity.setShokisaiHokenshaNo(new HokenshaNo(trim囲み文字(csvHeader.getShokisaiHokenshaNo())));
        entity.setShokisaiHokenshaNa(trim囲み文字(csvHeader.getShokisaiHokenshaNa()));
        entity.setSakuseiYMD(new FlexibleDate(trim囲み文字(csvHeader.getSakuseiYMD())));
        entity.setKokukoRengoukaiNa(trim囲み文字(csvHeader.getKokukoRengoukaiNa()));
        entity.setJigyoshoNo(new JigyoshaNo(trim囲み文字(csvMeisei.getJigyoshoNo())));
        entity.setJigyoshoName(trim囲み文字(csvMeisei.getJigyoshoName()));
        entity.setHiHokenshaNo(new HihokenshaNo(trim囲み文字(csvMeisei.getHiHokenshaNo())));
        entity.setHiHokenshaSimei(trim囲み文字(csvMeisei.getHiHokenshaSimei()));
        entity.setServiceTeikyoYM(new FlexibleYearMonth(trim囲み文字(csvMeisei.getServiceTeikyoYM())));
        entity.setServiceShuruiCode(new ServiceShuruiCode(trim囲み文字(csvMeisei.getServiceShuruiCode())));
        entity.setServiceShuruiName(trim囲み文字(csvMeisei.getServiceShuruiName()));
        entity.setKagomoushitateJiyuCode(new Code(trim囲み文字(csvMeisei.getKagomoushitateJiyuCode())));
        entity.setKagomoushitateJiyu(trim囲み文字(csvMeisei.getKagomoushitateJiyu()));
        entity.setTanisu(new Decimal(trim囲み文字(csvMeisei.getTanisu()).toString()));
        entity.setHokenshaFutangaku(new Decimal(trim囲み文字(csvMeisei.getHokenshaFutangaku()).toString()));

        return entity;
    }

    private KagoKetteiHokenshaInShukeiEntity createShukeiRecord(
            KagoKetteiHokenshaInCSVHeaderEntity cSVHeader,
            KagoKetteiHokenshaInCSVShukeiEntity csvShukei) {

        KagoKetteiHokenshaInShukeiEntity entity
                = new KagoKetteiHokenshaInShukeiEntity();

        entity.setToriatsukaiYM(new FlexibleYearMonth(trim囲み文字(cSVHeader.getToriatsukaiYM())));
        entity.setKaigoKyufuhiKensu(Integer.parseInt(trim囲み文字(csvShukei.getKaigoKyufuhiKensu()).toString()));
        entity.setKaigoKyufuhiTanisu(new Decimal(trim囲み文字(csvShukei.getKaigoKyufuhiTanisu()).toString()));
        entity.setKaigoKyufuhiFutangaku(new Decimal(trim囲み文字(csvShukei.getKaigoKyufuhiFutangaku()).toString()));
        entity.setKogakuServicehiKensu(Integer.parseInt(trim囲み文字(csvShukei.getKogakuServicehiKensu()).toString()));
        entity.setKogakuServicehiTanisu(new Decimal(trim囲み文字(csvShukei.getKogakuServicehiTanisu()).toString()));
        entity.setKogakuServicehiFutangaku(new Decimal(trim囲み文字(csvShukei.getKaigoKyufuhiTanisu()).toString()));
        entity.setTokuteiNyushoshaServicehiKensu(Integer.parseInt(trim囲み文字(csvShukei.
                getTokuteiNyushoshaServicehiKensu()).toString()));
        entity.setTokuteiNyushoshaServicehiTanisu(new Decimal(trim囲み文字(csvShukei.getTokuteiNyushoshaServicehiTanisu()).toString()));
        entity.setTokuteiNyushoshaServicehiFutangaku(new Decimal(trim囲み文字(csvShukei.getTokuteiNyushoshaServicehiFutangaku()).toString()));
        entity.setSakuseiYMD(new FlexibleDate(trim囲み文字(cSVHeader.getSakuseiYMD())));

        return entity;
    }

    private RString trim囲み文字(RString 対象文字列) {

        final char trim文字 = '"';

        try {

            対象文字列 = 対象文字列.trim(trim文字);
        } catch (NullPointerException e) {
            対象文字列 = RString.EMPTY;
        }
        return 対象文字列;
    }

}
