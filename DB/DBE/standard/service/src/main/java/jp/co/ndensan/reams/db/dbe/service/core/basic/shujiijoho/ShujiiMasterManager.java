/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.shujiijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.csv.shujiijoho.ShujiiMasterCsvBusiness;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosainmaster.NinteiChosainMasterManager;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医情報のCSV出力クラスです。
 */
public class ShujiiMasterManager {

    /**
     * コンストラクタです。
     */
    ShujiiMasterManager() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosainMasterManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiMasterManager}のインスタンス
     */
    public static ShujiiMasterManager createInstance() {
        return InstanceProvider.create(ShujiiMasterManager.class);
    }

    /**
     * CSV出力処理です。
     *
     * @param csvBusinessList CSV情報リスト
     */
    @Transaction
    public void csvOutput(List<ShujiiMasterCsvBusiness> csvBusinessList) {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        RString filePath = Path.combinePath(spoolWorkPath, new RString("主治医情報.csv"));

        try (CsvWriter writer = new CsvWriter.InstanceBuilder(filePath)
                .setEnclosure(new RString("\""))
                .setEncode(Encode.SJIS)
                .canAppend(false)
                .hasHeader(false)
                .build()) {
            for (ShujiiMasterCsvBusiness csvBusiness : csvBusinessList) {
                ShujiiMasterCsvBusiness data = new ShujiiMasterCsvBusiness(
                        csvBusiness.getShichosonCode(),
                        csvBusiness.getShichosonMeisho(),
                        csvBusiness.getShujiiCode(),
                        csvBusiness.getShujiiShimei(),
                        csvBusiness.getShujiiKanaShimei(),
                        csvBusiness.getShujiiIryoKikanCode(),
                        csvBusiness.getShujiiIryoKikan(),
                        csvBusiness.getShinryoka(),
                        csvBusiness.getShiteii(),
                        csvBusiness.getJokyoFlag(),
                        csvBusiness.getYubinNo(),
                        csvBusiness.getJusho(),
                        csvBusiness.getTelNo(),
                        csvBusiness.getFaxNo(),
                        csvBusiness.getSeibetsu());
                writer.writeLine(data);
            }
        }
    }
}
