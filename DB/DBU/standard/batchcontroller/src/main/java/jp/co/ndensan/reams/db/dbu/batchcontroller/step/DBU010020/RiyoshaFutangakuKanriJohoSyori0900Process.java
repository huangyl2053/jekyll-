/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.RiyoshaFutangakuKanriJohoSyoriMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.RiyoshaFutangakuKanriJohoSyoriProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.RiyoshaFutangakuGemmenJohoKonkyoCSVEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 利用者負担減額管理情報処理のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class RiyoshaFutangakuKanriJohoSyori0900Process extends BatchProcessBase<RiyoshaFutangakuGemmenJohoKonkyoCSVEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getRiyoshaFutangakuGemmenJohoKonkyoCSV");
    private static final RString 拡張子 = new RString(".CSV");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private RiyoshaFutangakuKanriJohoSyoriProcessParameter processParameter;
    private RiyoshaFutangakuKanriJohoSyoriMybatisParameter mybatisParameter;
    private IJigyoHokokuGeppoIppanMapper mapper;
    private RString 集計番号;

    @BatchWriter
    private CsvWriter<RiyoshaFutangakuGemmenJohoKonkyoCSVEntity> csvWriter;

    @Override
    protected void initialize() {
        集計番号 = ShukeiNo.一般状況_7_利用者負担減額_免除認定_再掲_第2号被保険者分.getコード();
        mybatisParameter = processParameter.toRiyoshaFutangakuKanriJohoSyoriMybatisParameter();
        mybatisParameter.setShukeiNo(new Code(集計番号));
        mybatisParameter.setKyuSochishaYMD(new FlexibleDate(
                DbBusinessConfig.get(ConfigNameDBD.旧措置者_旧措置者期限, RDate.getNowDate(), SubGyomuCode.DBD介護受給)));
        mapper = getMapper(IJigyoHokokuGeppoIppanMapper.class);
        csvWriter = new CsvWriter.InstanceBuilder(Path.combinePath(processParameter.get出力ファイルPATH(), 集計番号.concat(拡張子))).
                setEncode(Encode.UTF_8withBOM)
                .canAppend(true)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void beforeExecute() {
        mapper.exeRiyoshaFutangakuGemmenDataInsert(mybatisParameter);
    }

    @Override
    protected void process(RiyoshaFutangakuGemmenJohoKonkyoCSVEntity entity) {
        if (集計番号.equals(entity.get集計番号())) {
            csvWriter.writeLine(entity);
            AccessLogger.log(AccessLogType.照会, toPersonalData(entity.get被保険者番号()));
        }
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
