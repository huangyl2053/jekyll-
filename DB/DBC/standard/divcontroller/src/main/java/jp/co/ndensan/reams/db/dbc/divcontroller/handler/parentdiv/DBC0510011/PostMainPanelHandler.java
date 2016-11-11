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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.postmainpanel.PostMainPanelMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.PostMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.dgShichoson_Row;
import jp.co.ndensan.reams.db.dbc.service.core.postmainpanel.PostMainPanelFinder;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanelHandler {

    private final PostMainPanelDiv div;
    private static final RString 国保情報 = new RString("21_DBU_KOKUHO_処理枝番.txt");
    private static final RString 後期情報 = new RString("22_DBU_KOUKI_処理枝番.txt");
    private static final RString 単一国保情報 = new RString("21_DBU_KOKUHO_0000.txt");
    private static final RString 広域後期情報 = new RString("22_DBU_KOUKI_0000.txt");
    private static final RString 定値_処理枝番 = new RString("処理枝番");
    private static final RString 対象のファイル = new RString("対象のファイル");
    private static final RString NUM_00 = new RString("00");
    private static final int NUM_5 = 5;
    private static final int NUM_38 = 38;
    private static final int NUM_43 = 43;
    private static final int NUM_322 = 322;
    private static final int NUM_327 = 327;
    private static final int NUM_90 = 90;
    private static final int NUM_341 = 341;
    private static final int NUM_62 = 62;
    private static final int NUM_492 = 492;
    private static final RString NUM_111 = new RString("111");
    private static final RString NUM_112 = new RString("112");
    private static final RString NUM_120 = new RString("120");
    private static final RString DBCMN82001 = new RString("DBCMN82001");
    private static final RString DBCMN82002 = new RString("DBCMN82002");
    private static final RString NUM_1 = new RString("1");
    private static final int NUM_8 = 8;
    private static final int NUM_14 = 14;
    private static final int NUM_3 = 3;
    private static final int NUM_2 = 2;
    private static final int NUM_4 = 4;
    private static final RString 処理枝番 = new RString("0000");
    private static final RString 国保情報取り込み = new RString("国保情報取り込み");
    private static final RString 後期高齢者情報取り込み = new RString("後期高齢者情報取り込み");
    private static final RString 処理日付管理マスタに国保の情報 = new RString("処理日付管理マスタに(国保情報取込み)の情報");
    private static final RString 処理日付管理マスタに後期高齢の情報 = new RString("処理日付管理マスタに(後期高齢情報取込み)の情報");
    private static final RString 処理名_KEY = new RString("国保情報取り込み");
    private static final RString 処理名_KEY1 = new RString("後期高齢者情報取り込み");
    private static final RString 単一モード = new RString("単一モード");
    private static final RString 媒体 = new RString("媒体");
    private static final RString サーバー = new RString("サーバー");
    private static final RString 個別事項テーブル = new RString("個別事項テーブル");
    private static final RString 全件 = new RString("全件");
    private static final RString 差分 = new RString("差分");
    private static final RString 単一の場合 = new RString("単一の場合");
    private static final RString 広域の場合 = new RString("広域の場合");
    private final Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).
            get導入形態コード();

    /**
     * コンストラクタです。
     *
     * @param div PostMainPanel
     */
    public PostMainPanelHandler(PostMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @return 場合 RString
     */
    public RString initialize() {
        RString 場合 = null;
        div.setHdnModl(DataPassingConverter.serialize(単一モード));
        div.setHdnModl1(DataPassingConverter.serialize(RString.EMPTY));
        div.setHdnModl2(DataPassingConverter.serialize(RString.EMPTY));
        if (導入形態コード.toString().equals(NUM_120.toString())) {
            div.getMeisaiPanel().setVisible(false);
            div.getSp1().setWrap(false);
            div.getHdnShichosonCD().setValue(new RString(ShichosonSecurityJoho.
                    getShichosonSecurityJoho(GyomuBunrui.介護事務).get市町村情報().get市町村コード().toString()));
            ShoriDateKanri 処理日付管理マスタ;
            ShoriDateKanriManager manager = new ShoriDateKanriManager();
            if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
                処理日付管理マスタ = manager.get処理日付管理マスタ(国保情報取り込み, 処理枝番);
                処理日付管理マスタnull処理(処理日付管理マスタ, 処理日付管理マスタに国保の情報);
            } else {
                if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
                    処理日付管理マスタ = manager.get処理日付管理マスタ(後期高齢者情報取り込み, 処理枝番);
                    処理日付管理マスタnull処理(処理日付管理マスタ, 処理日付管理マスタに後期高齢の情報);
                }
            }
            RString 連携形式 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保格納場所, RDate.getNowDate(),
                    SubGyomuCode.DBC介護給付);
            switch (Integer.parseInt(連携形式.toString())) {
                case 1:
                    div.getTxtRenkekeishiki().setValue(媒体);
                    break;
                case NUM_2:
                    div.getTxtRenkekeishiki().setValue(サーバー);
                    break;
                case NUM_3:
                    div.getTxtRenkekeishiki().setValue(個別事項テーブル);
                    break;
                default:
                    break;
            }
            if (連携形式.equals(NUM_1)) {
                div.getBtnTorikomi().setDisabled(false);
            } else {
                div.getBtnTorikomi().setDisabled(true);
            }

            場合 = 単一の場合;
        } else {
            if (導入形態コード.toString().equals(NUM_111.toString())
                    || 導入形態コード.toString().equals(NUM_112.toString())) {
                div.getTxtZenkaiYMD().setVisible(true);
                div.getTxtZenkaiTime().setVisible(true);
                div.getTxtTorikomiKeishiki().setVisible(true);
                div.getTxtRenkekeishiki().setVisible(false);
                div.getBtnTorikomi().setVisible(false);
                div.getTxtFileTime().setVisible(false);
                div.getTxtFileYMD().setVisible(false);
                div.getDgShichoson().init();
                RString 市町村識別ID = ShichosonSecurityJoho.
                        getShichosonShikibetsuId(ControlDataHolder.getUserId()).get(0).getItemId();
                if (市町村識別ID.equals(NUM_00)) {
                    List<List> resultList = 市町村識別ID00処理();
                    一覧エリア(resultList);
                    div.getTxtZenkaiYMD().setValue(new RDate(resultList.get(0).get(NUM_2).toString().substring(0, NUM_8)));
                    div.getTxtZenkaiTime().setValue(new RTime(new RString(resultList.get(0).get(NUM_2).
                            toString().substring(NUM_8, NUM_14))));
                } else {
                    List<List> resultList = 市町村識別ID処理(市町村識別ID);
                    一覧エリア(resultList);
                    RString 格納処理日時 = new RString(resultList.get(0).get(NUM_2).toString());
                    div.getTxtZenkaiYMD().setValue(new RDate(格納処理日時.toString().substring(0, NUM_8)));
                    div.getTxtZenkaiTime().setValue(new RTime(格納処理日時.substring(NUM_8, NUM_14)));
                }
                場合 = 広域の場合;
            }
        }
        RString 取込形式 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保全件差分区分, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        switch (Integer.parseInt(取込形式.toString())) {
            case 1:
                div.getTxtTorikomiKeishiki().setValue(全件);
                break;
            case NUM_2:
                div.getTxtTorikomiKeishiki().setValue(差分);
                break;
            default:
                break;
        }
        return 場合;

    }

    /**
     * 一覧エリアのメソッドます。
     */
    private List<dgShichoson_Row> 一覧エリア(List<List> resultList) {
        List<dgShichoson_Row> listDataSource = new ArrayList();
        int bango = 1;
        for (List<RString> item : resultList) {
            dgShichoson_Row items = new dgShichoson_Row();
            items.setBango(new RString(String.valueOf(bango)));
            if (!RString.isNullOrEmpty(item.get(0))) {
                items.setShichosonMei(new RString(item.get(0).toString())
                        .concat(RString.HALF_SPACE).concat(item.get(1).toString()));
            } else {
                items.setShichosonMei(RString.EMPTY);
            }
            if (!RString.isNullOrEmpty(item.get(NUM_2))) {
                items.setFileKakunoShoriNitiji(new RString(DateConverter.toWarekiHalf_Zero(new RDate(item.get(NUM_2).
                        toString().substring(0, NUM_8))).toString().concat(RString.HALF_SPACE.toString()).
                        concat(DateConverter.getTime141(new RTime(new RString(item.get(NUM_2).toString().
                                                        substring(NUM_8, NUM_14)))).toString())));
            } else {
                items.setFileKakunoShoriNitiji(RString.EMPTY);
            }
            if (!RString.isNullOrEmpty(item.get(NUM_3))) {
                items.setKoikiTorikomiNitiji(new RString(DateConverter.toWarekiHalf_Zero(new RDate(item.get(NUM_3).
                        toString().substring(0, NUM_8))).toString().concat(RString.HALF_SPACE.toString()).
                        concat(DateConverter.getTime141(new RTime(new RString(item.get(NUM_3).toString().
                                                        substring(NUM_8, NUM_14)))).toString())));
            } else {
                items.setKoikiTorikomiNitiji(RString.EMPTY);
            }
            items.setShichosonShikibetuID(new RString(item.get(NUM_4).toString()));
            bango = bango + 1;
            listDataSource.add(items);
        }
        div.getDgShichoson().setDataSource(listDataSource);
        return listDataSource;
    }

    /**
     * onOkClosebth。
     *
     * @param ファイル日時 RDateTime
     */
    public void setTime(RDateTime ファイル日時) {
        if (導入形態コード.toString().equals(NUM_120.toString())) {
            div.getTxtFileYMD().setValue(ファイル日時.getDate());
            div.getTxtFileTime().setValue(ファイル日時.getTime());
        }
        if (導入形態コード.toString().equals(NUM_111.toString())
                || 導入形態コード.toString().equals(NUM_112.toString())) {
            div.getDgShichoson().getClickedItem().setFileNitiji(new RString(ファイル日時.toString()));
        }
    }

    private void 処理日付管理マスタnull処理(ShoriDateKanri 処理日付管理マスタ, RString error情報) {
        if (処理日付管理マスタ == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(error情報.toString()).evaluate());
        } else {
            YMDHMS 基準日時 = 処理日付管理マスタ.get基準日時();
            if (基準日時 != null && !基準日時.isEmpty()) {
                RDate 前回処理年月日 = 基準日時.getDate();
                RTime 前回処理時分秒 = 基準日時.getRDateTime().getTime();
                div.getTxtZenkaiYMD().setValue(前回処理年月日);
                div.getTxtZenkaiTime().setValue(前回処理時分秒);
            }
        }
    }

    private List<List> 市町村識別ID00処理() {
        List<List> resultList = null;
        PostMainPanelFinder finder = PostMainPanelFinder.createInstance();
        if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
            Map<String, Object> parameter = createParameter(true, false);
            resultList = finder.getPostMainPanel(parameter);
            if (resultList == null) {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                        .replace(処理日付管理マスタに国保の情報.toString()).evaluate());
            }
        } else {
            if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
                Map<String, Object> parameter = createParameter(false, true);
                resultList = finder.getPostMainPanel(parameter);
                if (resultList == null) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                            .replace(処理日付管理マスタに後期高齢の情報.toString()).evaluate());
                }
            }
        }
        return resultList;
    }

    private List<List> 市町村識別ID処理(RString 市町村識別ID) {
        List<List> resultList = null;
        PostMainPanelFinder finder = PostMainPanelFinder.createInstance();
        if (ResponseHolder.getMenuID().equals(DBCMN82001)) {
            PostMainPanelMybatisParameter parameter = PostMainPanelMybatisParameter.
                    creatParameter(国保情報取り込み, new RString(市町村識別ID.toString()));
            resultList = finder.getPostMainPanel(parameter);
            if (resultList == null) {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                        .replace(処理日付管理マスタに国保の情報.toString()).evaluate());
            }
        } else {
            if (ResponseHolder.getMenuID().equals(DBCMN82002)) {
                PostMainPanelMybatisParameter parameter = PostMainPanelMybatisParameter.
                        creatParameter(後期高齢者情報取り込み, new RString(市町村識別ID.toString()));
                resultList = finder.getPostMainPanel(parameter);
                if (resultList == null) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                            .replace(処理日付管理マスタに後期高齢の情報.toString()).evaluate());
                }
            }
        }
        return resultList;
    }

    private Map<String, Object> createParameter(boolean 国保情報取り込み, boolean 後期高齢者情報取り込み) {
        Map<String, Object> sqlParameter = new HashMap<>();
        sqlParameter.put(処理名_KEY.toString(), 国保情報取り込み);
        sqlParameter.put(処理名_KEY1.toString(), 後期高齢者情報取り込み);
        return sqlParameter;
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
            長さ判定(単一国保情報, NUM_90, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(国保情報)) {
            長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_90, NUM_38, NUM_43, 導入形態コード, row);
        }
        if (fileName.equals(広域後期情報)) {
            長さ判定(広域後期情報, NUM_62, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(後期情報)) {
            長さ判定(後期情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_62, NUM_322, NUM_327, 導入形態コード, row);
        }
    }

    private void getNum2長さ判定(RString fileName, Code 導入形態コード, dgShichoson_Row row) {
        if (fileName.equals(単一国保情報)) {
            長さ判定(単一国保情報, NUM_341, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(国保情報)) {
            長さ判定(国保情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_341, NUM_38, NUM_43, 導入形態コード, row);
        }
        if (fileName.equals(広域後期情報)) {
            長さ判定(広域後期情報, NUM_492, 0, NUM_5, 導入形態コード, null);
        }
        if (fileName.equals(後期情報)) {
            長さ判定(後期情報.replace(定値_処理枝番, NUM_00.concat(row.
                    getShichosonShikibetuID())), NUM_492, NUM_322, NUM_327, 導入形態コード, row);
        }
    }

    /**
     * 長さ判定
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
            InputStream stream = new FileInputStream(file);
            InputStreamReader read = new InputStreamReader(stream, "SJIS");
            BufferedReader bufferedReader = new BufferedReader(read);
            RString hasread = new RString(bufferedReader.readLine());
            if (hasread.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                        .replace(対象のファイル.toString()).evaluate());
            } else {
                if (hasread.length() != num) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                            .replace(対象のファイル.toString()).evaluate());
                } else {
                    市町村コード(導入形態コード, hasread, from, to, row);
                }
                bufferedReader.close();
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
        if (listResult == null || listResult.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(対象のファイル.toString()).evaluate());
        }
    }

    /**
     * 市町村コード検査
     *
     * @param 導入形態コード Code
     * @param hasread RString
     * @param row dgShichoson_Row
     * @param from int
     * @param to int
     */
    public void 市町村コード(Code 導入形態コード, RString hasread, int from, int to, dgShichoson_Row row) {
        if (導入形態コード.toString().equals(NUM_120.toString())) {
            RString 市町村コード = div.getHdnShichosonCD().getValue();
            if (!hasread.substring(from, to).equals(市町村コード)) {
                messeges();
            }
        } else {
            RString 市町村コード = row.getShichosonMei().substring(0, NUM_5);
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

        throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                .replace(対象のファイル.toString()).evaluate());

    }
}
