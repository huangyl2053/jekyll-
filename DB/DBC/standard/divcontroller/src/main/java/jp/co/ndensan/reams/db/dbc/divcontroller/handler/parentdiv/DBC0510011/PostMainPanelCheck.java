/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0510011;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.PostMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.dgShichoson_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanelCheck {

    private final PostMainPanelDiv div;
    private static final RString 国保情報 = new RString("21_DBU_KOKUHO_処理枝番.txt");
    private static final RString 後期情報 = new RString("22_DBU_KOUKI_処理枝番.txt");
    private static final RString 単一国保情報 = new RString("21_DBU_KOKUHO_0000.txt");
    private static final RString 広域後期情報 = new RString("22_DBU_KOUKI_0000.txt");
    private static final RString 定値_処理枝番 = new RString("処理枝番");
    private static final RString 対象のファイル = new RString("対象のファイル");
    private static final RString 国保取込ファイルのフォーマット = new RString("国保取込ファイルのフォーマット");
    private static final RString 後期高齢取込ファイルのフォーマット = new RString("後期高齢取込ファイルのフォーマット");
    private static final RString DBCMN82001 = new RString("DBCMN82001");
    private static final RString DBCMN82002 = new RString("DBCMN82002");
    private static final RString NUM_00 = new RString("00");
    private static final RString NUM_1 = new RString("1");
    private static final RString NUM_2 = new RString("2");
    private static final RString NUM_120 = new RString("120");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_38 = 38;
    private static final int NUM_43 = 43;
    private static final int NUM_322 = 322;
    private static final int NUM_328 = 328;
    private static final int NUM_90 = 90;
    private static final int NUM_341 = 341;
    private static final int NUM_62 = 62;
    private static final int NUM_492 = 492;
    private static final RString NUM_111 = new RString("111");
    private static final RString NUM_112 = new RString("112");
    private static final RString DB = new RString("DB");
    private static final RString コロン = new RString(":");
    private static final RString 中黒 = new RString(".");
    private static final RString ハイフン = new RString("-");

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuJohoHoseiDiv
     */
    public PostMainPanelCheck(PostMainPanelDiv div) {
        this.div = div;
    }

    /**
     * validateCheckチェック
     *
     */
    public void validateCheck() {
        国保情報Check();
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
            RString 後期ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期ＩＦ種類, RDate.getNowDate(),
                    SubGyomuCode.DBC介護給付);
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(広域後期情報);
                単一messeges(後期情報List);
                RDateTime sharedFileId = 後期情報List.get(0).getSharedFileId();
                RString 市町村コード = div.getHdnShichosonCD().getValue();
                if種類(後期ＩＦ種類, 導入形態コード, 広域後期情報, null, sharedFileId, 市町村コード);
            }
            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                dgShichoson_Row row = div.getDgShichoson().getClickedItem();
                List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(
                        後期情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                単一messeges(後期情報List);
                RDateTime sharedFileId = 後期情報List.get(0).getSharedFileId();
                RString 市町村コード = row.getShichosonMei().substring(0, NUM_6);
                if種類(後期ＩＦ種類, 導入形態コード, 後期情報, row, sharedFileId, 市町村コード);

            }
        }
    }

    /**
     * validateCheckNewチェック
     *
     */
    public void validateCheckNew() {
        国保情報CheckNew();
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
            RString 後期ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期ＩＦ種類, RDate.getNowDate(),
                    SubGyomuCode.DBC介護給付);
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(広域後期情報);
                単一messeges(後期情報List);
                RDateTime sharedFileId = 後期情報List.get(0).getSharedFileId();
                RString 市町村コード = div.getHdnShichosonCD().getValue();
                if種類(後期ＩＦ種類, 導入形態コード, 広域後期情報, null, sharedFileId, 市町村コード);
            }
            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                    List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(
                            後期情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                    単一messeges(後期情報List);
                    RDateTime sharedFileId = 後期情報List.get(0).getSharedFileId();
                    RString 市町村コード = row.getShichosonMei().substring(0, NUM_6);
                    if種類(後期ＩＦ種類, 導入形態コード, 後期情報, row, sharedFileId, 市町村コード);

                }
            }
        }
    }

    private void 国保情報Check() {
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        List<UzT0885SharedFileEntryEntity> 国保情報List;
        RString 国保ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                国保情報List = SharedFile.searchSharedFile(単一国保情報);
                単一messeges(国保情報List);
                RDateTime sharedFileId = 国保情報List.get(0).getSharedFileId();
                RString 市町村コード = div.getHdnShichosonCD().getValue();
                if種類(国保ＩＦ種類, 導入形態コード, 単一国保情報, null, sharedFileId, 市町村コード);
            }

            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                dgShichoson_Row row = div.getDgShichoson().getClickedItem();
                国保情報List = SharedFile.searchSharedFile(
                        国保情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                単一messeges(国保情報List);
                RDateTime sharedFileId = 国保情報List.get(0).getSharedFileId();
                RString 市町村コード = row.getShichosonMei().substring(0, NUM_6);
                if種類(国保ＩＦ種類, 導入形態コード, 国保情報, row, sharedFileId, 市町村コード);
            }
        }
    }

    private void 国保情報CheckNew() {
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        List<UzT0885SharedFileEntryEntity> 国保情報List;
        RString 国保ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                国保情報List = SharedFile.searchSharedFile(単一国保情報);
                単一messeges(国保情報List);
                RDateTime sharedFileId = 国保情報List.get(0).getSharedFileId();
                RString 市町村コード = div.getHdnShichosonCD().getValue();
                if種類(国保ＩＦ種類, 導入形態コード, 単一国保情報, null, sharedFileId, 市町村コード);
            }

            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                    国保情報List = SharedFile.searchSharedFile(
                            国保情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                    単一messeges(国保情報List);
                    RDateTime sharedFileId = 国保情報List.get(0).getSharedFileId();
                    RString 市町村コード = row.getShichosonMei().substring(0, NUM_6);
                    if種類(国保ＩＦ種類, 導入形態コード, 国保情報, row, sharedFileId, 市町村コード);
                }
            }
        }
    }

    private void if種類(RString 種類, Code 導入形態コード, RString fileName, dgShichoson_Row row, RDateTime sharedFileId, RString 市町村コード) {
        if (種類.equals(NUM_1)) {
            getNum1長さ判定(fileName, 導入形態コード, row, sharedFileId, 市町村コード);
        }
        if (種類.equals(NUM_2)) {
            getNum2長さ判定(fileName, 導入形態コード, row, sharedFileId, 市町村コード);
        }
    }

    private void getNum1長さ判定(RString fileName, Code 導入形態コード, dgShichoson_Row row, RDateTime sharedFileId, RString 市町村コード) {
        if (fileName.equals(単一国保情報)) {
            長さ判定(INT_1, 単一国保情報, NUM_90, 0, NUM_6, 導入形態コード, null, sharedFileId, 市町村コード);
        }
        if (fileName.equals(国保情報)) {
            長さ判定(INT_1, 国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_90, 0, NUM_6, 導入形態コード, row, sharedFileId, 市町村コード);
        }
        if (fileName.equals(広域後期情報)) {
            長さ判定(INT_1, 広域後期情報, NUM_62, 0, NUM_6, 導入形態コード, null, sharedFileId, 市町村コード);
        }
        if (fileName.equals(後期情報)) {
            長さ判定(INT_1, 後期情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_62, 0, NUM_6, 導入形態コード, row, sharedFileId, 市町村コード);
        }
    }

    private void getNum2長さ判定(RString fileName, Code 導入形態コード, dgShichoson_Row row, RDateTime sharedFileId, RString 市町村コード) {
        if (fileName.equals(単一国保情報)) {
            長さ判定(INT_2, 単一国保情報, NUM_341, NUM_38, NUM_43, 導入形態コード, null, sharedFileId, 市町村コード);
        }
        if (fileName.equals(国保情報)) {
            長さ判定(INT_2, 国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_341, NUM_38, NUM_43, 導入形態コード, row, sharedFileId, 市町村コード);
        }
        if (fileName.equals(広域後期情報)) {
            長さ判定(INT_2, 広域後期情報, NUM_492, NUM_322, NUM_328, 導入形態コード, null, sharedFileId, 市町村コード);
        }
        if (fileName.equals(後期情報)) {
            長さ判定(INT_2, 後期情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_492, NUM_322, NUM_328, 導入形態コード, row, sharedFileId, 市町村コード);
        }
    }

    /**
     * 長さ判定
     *
     * @param 長さ判定 int
     * @param fileName RString
     * @param num int
     * @param from int
     * @param to int
     * @param 導入形態コード int
     * @param row int
     * @param sharedFileId RDateTime
     * @param 市町村コード RString
     */
    public void 長さ判定(int 長さ判定, RString fileName, int num, int from, int to, Code 導入形態コード,
            dgShichoson_Row row, RDateTime sharedFileId, RString 市町村コード) {
        try {
            RString path = new RString(SharedFile.getBasePath().concat(File.separator)
                    .concat(DB.toString()).concat(File.separator)
                    .concat(fileName.toString()).concat(File.separator)
                    .concat((sharedFileId.toString().replace(コロン.toString(), 中黒.toString())
                            .replace(ハイフン.toString(), 中黒.toString()))).concat(File.separator)
                    .concat(fileName.toString()));
            File file = new File(path.toString());
            InputStream stream = new FileInputStream(file);
            InputStreamReader read = new InputStreamReader(stream, "SJIS");
            BufferedReader bufferedReader = new BufferedReader(read);
            RString hasread = new RString(bufferedReader.readLine());
            if (hasread.isEmpty()) {
                if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
                    throw new ApplicationException(UrErrorMessages.不正.getMessage()
                            .replace(後期高齢取込ファイルのフォーマット.toString()).evaluate());
                }
                if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
                    throw new ApplicationException(UrErrorMessages.不正.getMessage()
                            .replace(国保取込ファイルのフォーマット.toString()).evaluate());
                }
            } else {
                if (hasread.toString().getBytes(Encode.SJIS.getName()).length != num && ResponseHolder.getMenuID().equals(DBCMN82002)) {
                    throw new ApplicationException(UrErrorMessages.不正.getMessage()
                            .replace(後期高齢取込ファイルのフォーマット.toString()).evaluate());
                }
                if (hasread.toString().getBytes(Encode.SJIS.getName()).length != num && ResponseHolder.getMenuID().equals(DBCMN82001)) {
                    throw new ApplicationException(UrErrorMessages.不正.getMessage()
                            .replace(国保取込ファイルのフォーマット.toString()).evaluate());
                } else {
                    市町村コード(長さ判定, 導入形態コード, hasread, from, to, row, 市町村コード);
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * ファイルは無検査
     *
     * @param listResult List<UzT0885SharedFileEntryEntity>
     */
    public void 単一messeges(List<UzT0885SharedFileEntryEntity> listResult) {
        if (listResult == null || listResult.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(対象のファイル.toString()).evaluate());
        }
    }

    /**
     * 市町村コード検査
     *
     * @param 長さ判定 int
     * @param 導入形態コード Code
     * @param hasread RString
     * @param row dgShichoson_Row
     * @param from int
     * @param to int
     * @param 市町村コード RString
     */
    public void 市町村コード(int 長さ判定, Code 導入形態コード, RString hasread, int from, int to, dgShichoson_Row row, RString 市町村コード) {
        if (ResponseHolder.getMenuID().equals(DBCMN82001) && 長さ判定 == INT_2) {
            市町村コード = 市町村コード.substring(0, NUM_5);
            if (!hasread.substring(from, to).equals(市町村コード)) {
                messeges();
            }
        } else {
            if (!hasread.substring(from, to).equals(市町村コード)) {
                messeges();
            }
        }

    }

    /**
     * ファイルは無検査
     *
     */
    public void messeges() {

        if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
            throw new ApplicationException(UrErrorMessages.不正.getMessage()
                    .replace(後期高齢取込ファイルのフォーマット.toString()).evaluate());
        }
        if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
            throw new ApplicationException(UrErrorMessages.不正.getMessage()
                    .replace(国保取込ファイルのフォーマット.toString()).evaluate());
        }

    }
}
