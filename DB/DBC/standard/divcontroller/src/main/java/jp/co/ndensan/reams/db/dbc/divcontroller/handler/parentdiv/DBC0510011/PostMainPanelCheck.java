/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0510011;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    private static final RString 国保 = new RString("国保");
    private static final RString 後期 = new RString("後期");
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
     * @throws java.io.IOException
     */
    public void validateCheck() throws IOException {
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        List<UzT0885SharedFileEntryEntity> 国保情報List;
        RString 国保ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        RString 後期ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期ＩＦ種類, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        if (ResponseHolder.getState().equals(国保)) {
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                国保情報List = SharedFile.searchSharedFile(単一国保情報);
                BufferedReader bufferedReader = null;
                単一messeges(国保情報List);
                if (国保ＩＦ種類.equals(NUM_1)) {
                    bufferedReader = 長さ判定(単一国保情報, NUM_91);
                }
                if (国保ＩＦ種類.equals(NUM_2)) {
                    bufferedReader = 長さ判定(単一国保情報, NUM_342);
                }
                if (!bufferedReader.readLine().substring(0, NUM_5).equals(div.getHdnShichosonCD().getValue())) {
                    messeges();
                }
            }

            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                BufferedReader bufferedReader = null;
                for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                    国保情報List = SharedFile.searchSharedFile(
                            国保情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                    単一messeges(国保情報List);
                    if (国保ＩＦ種類.equals(NUM_1)) {
                        bufferedReader = 長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                                getShichosonShikibetuID())), NUM_91);
                    }
                    if (国保ＩＦ種類.equals(NUM_2)) {
                        bufferedReader = 長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                                getShichosonShikibetuID())), NUM_342);
                    }
                    if (!bufferedReader.readLine().substring(NUM_38, NUM_43).equals(row.getShichosonMei().
                            substring(0, NUM_5))) {
                        messeges();
                    }
                }
            }
        }

        if (ResponseHolder.getState().equals(後期)) {
            if (導入形態コード.toString().equals(NUM_120.toString())) {
                List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(後期情報);
                単一messeges(後期情報List);
                BufferedReader bufferedReader = null;
                if (後期ＩＦ種類.equals(NUM_1)) {
                    bufferedReader = 長さ判定(広域後期情報, NUM_63);
                }
                if (後期ＩＦ種類.equals(NUM_2)) {
                    bufferedReader = 長さ判定(広域後期情報, NUM_493);
                }
                if (!bufferedReader.readLine().substring(0, NUM_5).equals(div.getHdnShichosonCD().getValue())) {
                    messeges();
                }
            }
            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                BufferedReader bufferedReader = null;
                for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                    List<UzT0885SharedFileEntryEntity> 後期情報List = SharedFile.searchSharedFile(
                            後期情報.replace(定値_処理枝番, NUM_00.concat(row.getShichosonShikibetuID())));
                    単一messeges(後期情報List);
                    if (後期ＩＦ種類.equals(NUM_1)) {
                        bufferedReader = 長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                                getShichosonShikibetuID())), NUM_63);
                    }
                    if (後期ＩＦ種類.equals(NUM_2)) {
                        bufferedReader = 長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                                getShichosonShikibetuID())), NUM_493);
                    }
                    if (!bufferedReader.readLine().substring(NUM_322, NUM_327).equals(row.getShichosonMei().
                            substring(0, NUM_5))) {
                        messeges();
                    }
                }
            }
        }
    }

    /**
     * 文件第一行字节数的确定
     *
     * @param fileName RString
     * @param num int
     * @return bufferedReader BufferedReader
     * @throws java.io.FileNotFoundException
     */
    public BufferedReader 長さ判定(RString fileName, int num) throws FileNotFoundException, IOException {

        File file = new File(SharedFile.getBasePath().concat(IDENTIFICATION.toString()).concat(fileName.toString()));
        InputStreamReader read = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(read);
        if (bufferedReader.readLine().length() != num) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(対象のファイル.toString()).evaluate());
        }
        return bufferedReader;

    }

    /**
     * ファイルは無検査
     *
     * @param ListResult List<UzT0885SharedFileEntryEntity>
     */
    public void 単一messeges(List<UzT0885SharedFileEntryEntity> ListResult) {
        if (ListResult.isEmpty() || ListResult == null) {
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
