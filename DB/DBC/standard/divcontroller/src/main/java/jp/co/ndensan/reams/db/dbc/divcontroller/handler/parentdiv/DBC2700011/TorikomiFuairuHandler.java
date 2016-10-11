/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2700011;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170020.DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011.TorikomiFuairuDiv;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費単位数表標準マスタ取込画面のHandlerです。
 *
 * @reamsid_L DBC-3400-010 x_zhaowen
 */
public class TorikomiFuairuHandler {

    private final TorikomiFuairuDiv div;
    private final RString 共有ファイル名 = new RString("KM999999_COMMON.csv");
    private static final RString HOSHI = new RString("*");
    private static final RString 西暦 = new RString("yyyyMMddHHmmss");

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
    public int upload(RString csvFilePath) {
        SharedFileDescriptor sharedFileDescriptor
                = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(共有ファイル名));
        sharedFileDescriptor = SharedFile.defineSharedFile(sharedFileDescriptor);
        SharedFile.defineSharedFile(sharedFileDescriptor, 1, Arrays.asList(HOSHI), null, false, null);
        RString text = RString.EMPTY;
        try (FileReader reader = new FileReader(csvFilePath, Encode.UTF_8withBOM)) {
            RString line;
            while ((line = reader.readLine()) != null) {
                text = text.concat(line);
            }
        }
        div.getTxtKoshinNichiji().setValue(File.getLastModifiedTime(csvFilePath).format西暦(西暦.toString()));
        div.getTxtFuairuName().setValue(共有ファイル名);
        List<RString> csvEntityList = text.split(",");
        return csvEntityList.size();

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
