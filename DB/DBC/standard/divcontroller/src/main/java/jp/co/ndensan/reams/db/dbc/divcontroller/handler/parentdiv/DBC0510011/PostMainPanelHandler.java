/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0510011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.postmainpanel.PostMainPanelMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.PostMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.dgShichoson_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.postmainpanel.PostMainPanelEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanelHandler {

    private final PostMainPanelDiv div;
    private static final RString 国保 = new RString("国保");
    private static final RString 後期 = new RString("後期");
    private static final RString NUM_120 = new RString("120");
    private static final RString NUM_111 = new RString("111");
    private static final RString NUM_1 = new RString("1");
    private static final int NUM_8 = 8;
    private static final int NUM_13 = 13;
    private static final int NUM_0 = 0;
    private static final int NUM_7 = 7;
    private static final RString NUM_112 = new RString("112");
    private static final RString 処理枝番 = new RString("0000");
    private static final RString 国保情報取り込み = new RString("国保情報取り込み");
    private static final RString 後期高齢者情報取り込み = new RString("後期高齢者情報取り込み");
    private static final RString 処理日付管理マスタに国保の情報 = new RString("処理日付管理マスタに(国保情報取込み)の情報");
    private static final RString 処理日付管理マスタに後期高齢の情報 = new RString("処理日付管理マスタに(後期高齢情報取込み)の情報");
    private static final RString NUM_00 = new RString("00");
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
        Code 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        if (導入形態コード.toString().equals(NUM_120.toString())) {
            div.getMeisaiPanel().setVisible(false);
            div.getSp1().setWrap(false);
            div.getHdnShichosonCD().setValue(new RString(ShichosonSecurityJoho.
                    getShichosonSecurityJoho(GyomuBunrui.介護事務).get市町村情報().get市町村コード().toString()));
            ShoriDateKanri 処理日付管理マスタ = null;
            ShoriDateKanriManager manager = new ShoriDateKanriManager();
            if (ResponseHolder.getState().equals(国保)) {
                処理日付管理マスタ = manager.get処理日付管理マスタ(国保情報取り込み, 処理枝番);
                if (処理日付管理マスタ == null) {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                            .replace(処理日付管理マスタに国保の情報.toString()).evaluate());
                }
            } else {
                if (ResponseHolder.getState().equals(後期)) {
                    処理日付管理マスタ = manager.get処理日付管理マスタ(後期高齢者情報取り込み, 処理枝番);
                    if (処理日付管理マスタ == null) {
                        throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                                .replace(処理日付管理マスタに後期高齢の情報.toString()).evaluate());
                    }
                }

            }
            if (処理日付管理マスタ.get基準日時() != null && !処理日付管理マスタ.get基準日時().isEmpty()) {
                RDate 前回処理年月日 = 処理日付管理マスタ.get基準日時().getDate();
                RTime 前回処理時分秒 = 処理日付管理マスタ.get基準日時().getRDateTime().getTime();
                div.getTxtZenkaiYMD().setValue(前回処理年月日);
                div.getTxtZenkaiTime().setValue(前回処理時分秒);
            }
            RString 連携形式 = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保格納場所, RDate.getNowDate(),
                    SubGyomuCode.DBC介護給付);
            switch (Integer.parseInt(連携形式.toString())) {
                case 1:
                    div.getTxtRenkekeishiki().setValue(媒体);
                    break;
                case 2:
                    div.getTxtRenkekeishiki().setValue(サーバー);
                    break;
                case 3:
                    div.getTxtRenkekeishiki().setValue(個別事項テーブル);
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
                    List<PostMainPanelEntity> resultList = null;
                    PostMainPanelFinder finder = PostMainPanelFinder.createInstance();
                    if (ResponseHolder.getState().equals(国保)) {
                        Map<String, Object> parameter = createParameter(true, false);
                        resultList = finder.getPostMainPanel(parameter);
                        if (resultList == null) {
                            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                                    .replace(処理日付管理マスタに国保の情報.toString()).evaluate());
                        }
                    } else {
                        if (ResponseHolder.getState().equals(後期)) {
                            Map<String, Object> parameter = createParameter(false, true);
                            resultList = finder.getPostMainPanel(parameter);
                            if (resultList == null) {
                                throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                                        .replace(処理日付管理マスタに後期高齢の情報.toString()).evaluate());
                            }
                        }
                    }
                    一覧エリア(resultList);
                    div.getTxtZenkaiYMD().setValue(resultList.get(0).get基準日時().getDate());
                    div.getTxtZenkaiTime().setValue(resultList.get(0).get基準日時().getRDateTime().getTime());
                } else {
                    List<PostMainPanelEntity> resultList = null;
                    PostMainPanelFinder finder = PostMainPanelFinder.createInstance();
                    if (ResponseHolder.getState().equals(国保)) {
                        PostMainPanelMybatisParameter Parameter = PostMainPanelMybatisParameter.
                                creatParameter(国保情報取り込み, new RString(市町村識別ID.toString()));
                        resultList = finder.getPostMainPanel(Parameter);
                        if (resultList == null) {
                            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                                    .replace(処理日付管理マスタに国保の情報.toString()).evaluate());
                        }
                    } else {
                        if (ResponseHolder.getState().equals(後期)) {
                            PostMainPanelMybatisParameter Parameter = PostMainPanelMybatisParameter.
                                    creatParameter(後期高齢者情報取り込み, new RString(市町村識別ID.toString()));
                            resultList = finder.getPostMainPanel(Parameter);
                            if (resultList == null) {
                                throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                                        .replace(処理日付管理マスタに後期高齢の情報.toString()).evaluate());
                            }
                        }
                    }
                    List<dgShichoson_Row> listDataSource = 一覧エリア(resultList);
                    RString 最大値の格納処理日時 = resultList.get(0).get基準日時().toDateString();
                    int i = 0;
                    for (PostMainPanelEntity row : resultList) {
                        if (0 < row.get基準日時().toDateString().compareTo(最大値の格納処理日時)) {
                            listDataSource.get(i).setSelectButtonState(DataGridButtonState.Disabled);
                            i = i + 1;
                            最大値の格納処理日時 = row.get基準日時().toDateString();
                        }
                    }
                    //TODO div.getDgShichoson().setSelectedItems(listDataSource);
                    div.getTxtZenkaiYMD().setValue(new RDate(最大値の格納処理日時.toString()));
                    div.getTxtZenkaiTime().setValue(new RTime(最大値の格納処理日時.substring(NUM_8, NUM_13)));
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
            case 2:
                div.getTxtTorikomiKeishiki().setValue(差分);
        }
        return 場合;

    }

    /**
     * 一覧エリアのメソッドます。
     */
    private List<dgShichoson_Row> 一覧エリア(List<PostMainPanelEntity> resultList) {
        List<dgShichoson_Row> listDataSource = new ArrayList();
        int bango = 1;
        for (PostMainPanelEntity item : resultList) {

            dgShichoson_Row items = new dgShichoson_Row();
            items.setBango(new RString(String.valueOf(bango)));
            if (item.get市町村コード() != null || !item.get市町村コード().toString().isEmpty()) {
                items.setShichosonMei(new RString(item.get市町村コード().toString())
                        .concat(RString.HALF_SPACE).concat(item.get市町村名称()));
            } else {
                items.setShichosonMei(RString.EMPTY);
            }
            if (item.get基準日時() != null && !item.get基準日時().isEmpty()) {
                items.setFileKakunoShoriNitiji(new RString(DateConverter.toWarekiHalf_Zero(item.get基準日時().getDate()).
                        toString().concat(RString.HALF_SPACE.toString()).concat(DateConverter.getTime141(
                                        item.get基準日時().getRDateTime().getTime()).toString())));
            } else {
                items.setFileKakunoShoriNitiji(RString.EMPTY);
            }
            if (item.get対象開始日時() != null && !item.get対象開始日時().isEmpty()) {
                items.setKoikiTorikomiNitiji(new RString(DateConverter.toWarekiHalf_Zero(item.get対象開始日時().
                        getDate()).toString().concat(RString.HALF_SPACE.toString()).concat(DateConverter.
                                getTime141(item.get対象開始日時().getRDateTime().getTime()).toString())));
            } else {
                items.setKoikiTorikomiNitiji(RString.EMPTY);
            }
            items.setShichosonShikibetuID(item.get市町村識別ID());
            bango = bango + 1;
            listDataSource.add(items);
        }
        div.getDgShichoson().setDataSource(listDataSource);
        return listDataSource;
    }

    private Map<String, Object> createParameter(boolean 国保情報取り込み, boolean 後期高齢者情報取り込み) {
        Map<String, Object> sqlParameter = new HashMap<>();
        sqlParameter.put(処理名_KEY.toString(), 国保情報取り込み);
        sqlParameter.put(処理名_KEY1.toString(), 後期高齢者情報取り込み);
        return sqlParameter;
    }
}
