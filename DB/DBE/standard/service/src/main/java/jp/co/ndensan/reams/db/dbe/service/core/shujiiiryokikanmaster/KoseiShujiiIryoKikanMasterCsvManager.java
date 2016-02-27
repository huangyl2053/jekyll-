/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterCSV;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterCsvEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関情報のCSV出力クラスです。
 *
 */
public class KoseiShujiiIryoKikanMasterCsvManager {

    private static final int CSV_TYPE = 1024;

    /**
     * コンストラクタです。
     */
    KoseiShujiiIryoKikanMasterCsvManager() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShujiiIryoKikanMasterCsvManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoseiShujiiIryoKikanMasterCsvManager}のインスタンス
     */
    public static KoseiShujiiIryoKikanMasterCsvManager createInstance() {
        return InstanceProvider.create(KoseiShujiiIryoKikanMasterCsvManager.class);
    }

    /**
     * CSV出力処理です。
     *
     * @param csvBusinessList CSV情報リスト
     */
    @Transaction
    public void getCSVoutput(List<KoseiShujiiIryoKikanMasterCSV> csvBusinessList) {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        RString filePath = Path.combinePath(spoolWorkPath, new RString("主治医医療機関情報.csv"));
        try (CsvWriter writer = new CsvWriter.InstanceBuilder(filePath)
                .setEncode(Encode.SJIS)
                .canAppend(false)
                .hasHeader(true)
                .build()) {
            for (KoseiShujiiIryoKikanMasterCSV csvBusiness : csvBusinessList) {
                KoseiShujiiIryoKikanMasterCsvEntity data = new KoseiShujiiIryoKikanMasterCsvEntity(
                        csvBusiness.getShichosonCode(),
                        csvBusiness.getShichosonMeisho(),
                        csvBusiness.getShujiiIryokikanCode(),
                        csvBusiness.getIryokikanCode(),
                        csvBusiness.getIryoKikanMeisho(),
                        csvBusiness.getIryoKikanMeishoKana(),
                        csvBusiness.getYubinNo(),
                        csvBusiness.getJusho(),
                        csvBusiness.getTelNo(),
                        csvBusiness.getFaxNo(),
                        csvBusiness.getDaihyoshaName(),
                        csvBusiness.getDaihyoshaNameKana(),
                        csvBusiness.getJokyoFlag());
                writer.writeLine(data);
            }
        }
    }
}
