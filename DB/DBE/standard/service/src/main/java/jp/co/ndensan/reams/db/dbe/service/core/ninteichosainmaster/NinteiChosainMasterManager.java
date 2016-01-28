/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosainmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.csv.ninteichosainmaster.NinteiChosainMasterCsvBusiness;
import jp.co.ndensan.reams.db.dbe.entity.csv.ninteichosainmaster.NinteiChosainMasterCsvEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査員情報のCSV出力クラスです。
 */
public class NinteiChosainMasterManager {

    /**
     * コンストラクタです。
     */
    NinteiChosainMasterManager() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosainMasterManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiChosainMasterManager}のインスタンス
     */
    public static NinteiChosainMasterManager createInstance() {
        return InstanceProvider.create(NinteiChosainMasterManager.class);
    }

    /**
     * CSV出力処理です。
     *
     * @param csvBusinessList CSV情報リスト
     */
    @Transaction
    public void csvOutput(List<NinteiChosainMasterCsvBusiness> csvBusinessList) {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        RString filePath = Path.combinePath(spoolWorkPath, new RString("調査員情報.csv"));

        try (CsvWriter writer = new CsvWriter.InstanceBuilder(filePath)
                .setEnclosure(new RString("\""))
                .setEncode(Encode.SJIS)
                .canAppend(false)
                .hasHeader(false)
                .build()) {
            for (NinteiChosainMasterCsvBusiness csvBusiness : csvBusinessList) {
                NinteiChosainMasterCsvEntity data = new NinteiChosainMasterCsvEntity(
                        csvBusiness.getShichosonCode(),
                        csvBusiness.getShichosonMeisho(),
                        csvBusiness.getNinteiChosainNo(),
                        csvBusiness.getChosainShimei(),
                        csvBusiness.getChosainKanaShimei(),
                        csvBusiness.getNinteichosaItakusakiCode(),
                        csvBusiness.getJigyoshaMeisho(),
                        csvBusiness.getSeibetsu(),
                        csvBusiness.getChikuCode(),
                        csvBusiness.getChikuMeisho(),
                        csvBusiness.getChosainShikaku(),
                        csvBusiness.getChosaKanoNinzuPerMonth(),
                        csvBusiness.getJokyoFlag(),
                        csvBusiness.getYubinNo(),
                        csvBusiness.getJusho(),
                        csvBusiness.getTelNo(),
                        csvBusiness.getFaxNo(),
                        csvBusiness.getShozokuKikanName());
                writer.writeLine(data);
            }
        }
    }
}
