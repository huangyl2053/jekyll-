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
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static final RString DBCMN82001 = new RString("DBCMN82001");
    private static final RString DBCMN82002 = new RString("DBCMN82002");
    private static final RString NUM_00 = new RString("00");
    private static final RString NUM_1 = new RString("1");
    private static final RString NUM_2 = new RString("2");
    private static final RString NUM_120 = new RString("120");
    private static final int NUM_5 = 5;
    private static final int NUM_38 = 38;
    private static final int NUM_43 = 43;
    private static final int NUM_322 = 322;
    private static final int NUM_327 = 327;
    private static final int NUM_91 = 91;
    private static final int NUM_342 = 342;
    private static final int NUM_63 = 63;
    private static final int NUM_493 = 493;
    private static final RString NUM_111 = new RString("111");
    private static final RString NUM_112 = new RString("112");
    private static final RString IDENTIFICATION = new RString("\\");

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
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        List<UzT0885SharedFileEntryEntity> 国保情報List;
        RString 国保ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        RString 後期ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期ＩＦ種類, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                国保情報List = SharedFile.searchSharedFile(単一国保情報);
                単一messeges(国保情報List);
                if種類(国保ＩＦ種類, 導入形態コード, 単一国保情報, null);
            }

            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                    国保情報List = SharedFile.searchSharedFile(
                            国保情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                    単一messeges(国保情報List);
                    if種類(国保ＩＦ種類, 導入形態コード, 国保情報, row);
                }
            }
        }

        if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(後期情報);
                単一messeges(後期情報List);
                if種類(後期ＩＦ種類, 導入形態コード, 広域後期情報, null);
            }
            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                    List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(
                            後期情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                    単一messeges(後期情報List);
                    if種類(後期ＩＦ種類, 導入形態コード, 後期情報, row);

                }
            }
        }
    }

    private void if種類(RString 種類, Code 導入形態コード, RString fileName, dgShichoson_Row row) {
        if (種類.equals(NUM_1)) {
            getNum1長さ判定(fileName, 導入形態コード, row);
        }
        if (種類.equals(NUM_2)) {
            getNum2長さ判定(fileName, 導入形態コード, row);
        }
    }

    private void getNum1長さ判定(RString fileName, Code 導入形態コード, dgShichoson_Row row) {
        if (fileName.equals(単一国保情報)) {
            長さ判定(単一国保情報, NUM_91, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(国保情報)) {
            長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_91, NUM_38, NUM_43, 導入形態コード, row);
        }
        if (fileName.equals(広域後期情報)) {
            長さ判定(広域後期情報, NUM_63, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(後期情報)) {
            長さ判定(後期情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_63, NUM_322, NUM_327, 導入形態コード, row);
        }
    }

    private void getNum2長さ判定(RString fileName, Code 導入形態コード, dgShichoson_Row row) {
        if (fileName.equals(単一国保情報)) {
            長さ判定(単一国保情報, NUM_342, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(国保情報)) {
            長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_342, NUM_38, NUM_43, 導入形態コード, row);
        }
        if (fileName.equals(広域後期情報)) {
            長さ判定(広域後期情報, NUM_493, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(後期情報)) {
            長さ判定(後期情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_493, NUM_322, NUM_327, 導入形態コード, row);
        }
    }

    /**
     * 文件第一行字节数的确定
     *
     * @param fileName RString
     * @param num int
     * @param from int
     * @param to int
     * @param 導入形態コード int
     * @param row int
     */
    public void 長さ判定(RString fileName, int num, int from, int to, Code 導入形態コード, dgShichoson_Row row) {
        try {
            RString path = new RString(SharedFile.getBasePath() + File.separator + fileName);
            File file = new File(path.toString());
            // File file = new File(SharedFile.getBasePath().concat(IDENTIFICATION.toString()).concat(fileName.toString()));
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            if (bufferedReader.readLine().length() != num) {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                        .replace(対象のファイル.toString()).evaluate());
            }
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                if (!bufferedReader.readLine().substring(from, to).equals(div.getHdnShichosonCD().getValue())) {
                    messeges();
                }
            } else {
                if (!bufferedReader.readLine().substring(from, to).equals(row.getShichosonMei().
                        substring(0, NUM_5))) {
                    messeges();
                }
            }
        } catch (IOException | ApplicationException e) {
            e.getMessage();

        }
    }

    /**
     * ファイルは無検査
     *
     * @param listResult List<UzT0885SharedFileEntryEntity>
     */
    public void 単一messeges(List<UzT0885SharedFileEntryEntity> listResult) {
        if (listResult.isEmpty() || listResult == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(対象のファイル.toString()).evaluate());
        }
    }

    /**
     * ファイルは無検査
     *
     */
    public void messeges() {

        throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                .replace(対象のファイル.toString()).evaluate());

    }
}
