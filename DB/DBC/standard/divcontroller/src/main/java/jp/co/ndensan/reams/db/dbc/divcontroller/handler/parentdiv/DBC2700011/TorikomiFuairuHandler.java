/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2700011;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170020.DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費単位数表標準マスタ取込画面のHandlerです。
 *
 * @reamsid_L DBC-3400-010 x_zhaowen
 */
public class TorikomiFuairuHandler {

    private final RString 共有ファイル名 = new RString("KM999999_COMMON.csv");
    private static final RString HOSHI = new RString("*");

    /**
     * コンストラクタです。
     *
     */
    public TorikomiFuairuHandler() {
    }

    /**
     * ファイルupload処理
     *
     * @param csvFilePath RString
     * @param fileName RString
     * @return size
     */
    public int upload(RString csvFilePath, RString fileName) {
        SharedFileDescriptor sharedFileDescriptor
                = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(共有ファイル名));
        sharedFileDescriptor = SharedFile.defineSharedFile(sharedFileDescriptor);
        SharedFile.defineSharedFile(sharedFileDescriptor, 1, Arrays.asList(HOSHI), null, false, null);
        int size = 0;
        List<RString> 項目数;
        try (CsvListReader reader = new CsvListReader.InstanceBuilder(csvFilePath).
                setDelimiter(new RString(",")).setEnclosure(new RString("\""))
                .hasHeader(false).setEncode(Encode.SJIS).setNewLine(NewLine.CRLF).build()) {
            while ((項目数 = reader.readLine()) != null) {
                size = size + 項目数.size();
            }
        }
        return size;

    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @return DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter
     */
    public DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter setBatchParameter() {
        return new DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter();
    }
}
