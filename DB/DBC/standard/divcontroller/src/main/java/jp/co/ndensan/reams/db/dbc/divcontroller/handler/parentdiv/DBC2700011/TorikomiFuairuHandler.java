/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2700011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170020.DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011.KaigoServiceNaiyouCsvEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011.TorikomiFuairuDiv;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費単位数表標準マスタ取込画面のHandlerです。
 *
 * @reamsid_L DBC-3400-010 x_zhaowen
 */
public class TorikomiFuairuHandler {

    private final TorikomiFuairuDiv div;
    private final RString 共有ファイル名 = new RString("KM999999_COMMON.CSV");
    private static final RString HOSHI = new RString("*");

    /**
     * コンストラクタです。
     *
     * @param div TorikomiFuairuDiv
     */
    public TorikomiFuairuHandler(TorikomiFuairuDiv div) {
        this.div = div;
    }

    /**
     * ファイルupload処理
     *
     * @param csvFilePath RString
     */
    public void upload(RString csvFilePath) {
        SharedFileDescriptor sharedFileDescriptor
                = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(共有ファイル名));
        sharedFileDescriptor = SharedFile.defineSharedFile(sharedFileDescriptor);
        SharedFile.deleteOldestEntry(sharedFileDescriptor);
        SharedFile.defineSharedFile(sharedFileDescriptor, 1, Arrays.asList(HOSHI), null, false, null);
        SharedFile.copyToSharedFile(sharedFileDescriptor, FilesystemPath.fromString(Path.combinePath(Path.getTmpDirectoryPath(), 共有ファイル名)), new CopyToSharedFileOpts());
        List<KaigoServiceNaiyouCsvEntity> csvEntityList = new ArrayList<>();
        try (CsvReader<KaigoServiceNaiyouCsvEntity> csvReader = new CsvReader.InstanceBuilder(csvFilePath, KaigoServiceNaiyouCsvEntity.class)
                .setDelimiter(new RString(",")).setEnclosure(new RString("\""))
                .hasHeader(false).setEncode(Encode.UTF_8withBOM).build()) {
            while (true) {
                KaigoServiceNaiyouCsvEntity entity = csvReader.readLine();
                if (entity != null) {
                    csvEntityList.add(entity);
                } else {
                    break;
                }
            }
            csvReader.close();
        }
        div.getTxtFuairuRekodoSu().setValue(new Decimal(csvEntityList.size()));
    }

    /**
     * ファイルの読込処理
     */
//    public void readFile() {
//        RString line = RString.EMPTY;
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(div.getHdnFilePath().toString()), "SJIS"));
//            line = new RString(in.readLine());
//            in.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(TorikomiFuairuHandler.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(TorikomiFuairuHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        div.setHdnLine(line);
//    }
    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @return DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter
     */
    public DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter setBatchParameter() {
        return new DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter();
    }

//    private CsvReader<KaigoServiceNaiyouCsvEntity> createCsvReader(RString) {
//        return new CsvReader.InstanceBuilder(csvFilePath, KaigoServiceNaiyouCsvEntity.class)
//                .setDelimiter(new RString(",")).setEnclosure(new RString("\""))
//                .hasHeader(false).setEncode(Encode.UTF_8withBOM).build();
//    }
}
