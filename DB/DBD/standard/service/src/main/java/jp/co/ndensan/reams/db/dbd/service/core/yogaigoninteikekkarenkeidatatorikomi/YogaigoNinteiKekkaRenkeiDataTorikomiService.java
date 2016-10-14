/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.yogaigoninteikekkarenkeidatatorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shinchokudataoutputeuccsv.ShinchokuDataOutputEucCsvBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.niinteichosajoho.ShinchokuDataOutputEucCsvEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果連携データ取込Serviceです。
 *
 * @reamsid_L DBD_1510-010 liuyl
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomiService {

    /**
     * 取込ファイル内容一覧。
     *
     * @param path RString
     * @param encode Encode
     * @return List<ShinchokuDataOutputEucCsvBusiness>
     */
    public List<ShinchokuDataOutputEucCsvBusiness> getFileDateSource(RString path, Encode encode) {
        List<ShinchokuDataOutputEucCsvBusiness> businessList = new ArrayList<>();
        try (CsvReader<ShinchokuDataOutputEucCsvEntity> reader = new CsvReader.InstanceBuilder(path, ShinchokuDataOutputEucCsvEntity.class).
                setDelimiter(new RString(",")).setEnclosure(new RString("\""))
                .hasHeader(false).setEncode(encode).setNewLine(NewLine.CRLF).build()) {
            ShinchokuDataOutputEucCsvEntity entity;
            while ((entity = reader.readLine()) != null) {
                businessList.add(new ShinchokuDataOutputEucCsvBusiness(entity));
            }
        }
        return businessList;
    }
}
