/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeikoiki.ShotokuJohoBatchresultKoikiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeikoiki.ShotokuJohoTyushutuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.dgShichosonIchiran_Row;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJoho;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeikoiki.ShotokuJohoChushutsuRenkeiKoiki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 所得情報抽出・連携（広域用）のHandlerクラスです。
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class ShotokuJohoChushutsuKoikiBatchParameterHandler {

    private final ShotokuJohoChushutsuKoikiBatchParameterDiv div;
    private static final RString 事務広域 = new RString("111");
    private static final RString 処理区分_3 = new RString("3");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 広域保険者でないため = new RString("広域保険者でないため");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51008");
    private static final RString 当初所得引出 = new RString("当初所得引出");
    private static final RString 所得引出 = new RString("所得引出");
    private static final RString 広域職員でないため = new RString("広域職員でないため");
    private static final RString なし = new RString("0");
    private static final RString 処理待ち = new RString("処理待ち");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnBatchRegisterKoiki");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     */
    public ShotokuJohoChushutsuKoikiBatchParameterHandler(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のチェックし,初期化メソッドです
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @return ShotokuJohoChushutsuKoikiPanelHandler
     */
    public static ShotokuJohoChushutsuKoikiBatchParameterHandler of(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        return new ShotokuJohoChushutsuKoikiBatchParameterHandler(div);
    }

    /**
     * 画面初期化のチェック
     *
     * @param currentTime RDate
     */
    public void initCheck(RDate currentTime) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            RString 市町村形態コード = new RString(市町村セキュリティ情報.get導入形態コード().value().toString());
            if (!事務広域.equals(市町村形態コード)) {
                throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                        .replace(広域保険者でないため.toString()).evaluate());
            }
        }
        RString メニューID = ResponseHolder.getMenuID();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, currentTime, SubGyomuCode.DBB介護賦課);
        RString 所得年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, currentTime, SubGyomuCode.DBB介護賦課);
        if (所得情報抽出_連携異動.equals(メニューID) && !調定年度.equals(所得年度)) {
            throw new ApplicationException(DbbErrorMessages.処理不可_関連機能未処理済.getMessage()
                    .replace(当初所得引出.toString(), 所得引出.toString()).evaluate());
        }
    }

    /**
     * 市町村一覧情報の取得し,初期化設定のメソッドです
     *
     * @param currentTime RDate
     * @return SearchResult<KoikiZenShichosonJoho>
     */
    public SearchResult<KoikiZenShichosonJoho> shichosonIchiran(RDate currentTime) {
        RString ログインユーザID = ControlDataHolder.getUserId();
        List<KoikiZenShichosonJoho> list = new ArrayList<>();
        if (ログインユーザID != null) {
            List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
            if (市町村識別ID != null && !市町村識別ID.isEmpty()) {
                handler市町村識別ID(市町村識別ID, list);
            }
        }
        return SearchResult.of(list, 0, false);
    }

    /**
     * 市町村情報Entity．処理区分チェックメソッドです
     *
     * @param shichosonJohoList List<ShichosonJohoResult>
     */
    public void check処理区分(List<ShichosonJohoResult> shichosonJohoList) {
        for (ShichosonJohoResult entity : shichosonJohoList) {
            if (処理区分_3.equals(entity.getEntity().get処理区分())) {
                throw new ApplicationException(DbzErrorMessages.処理日付管理マスタなし.getMessage()
                        .replace(当初所得引出.toString()).evaluate());
            }
        }
        ShotokuJohoChushutsuKoikiPanelDiv koikiPanelDiv = div.getShotokuJohoChushutsuKoikiPanel();
        List<dgShichosonIchiran_Row> rowList = new ArrayList<>();
        boolean flag = true;
        for (ShichosonJohoResult result : shichosonJohoList) {
            dgShichosonIchiran_Row row = new dgShichosonIchiran_Row();
            if (result.getEntity().get市町村コード() != null) {
                row.getTxtCityCode().setValue(result.getEntity().get市町村コード().value());
            }
            if (result.getEntity().get市町村名() != null) {
                row.getTxtCityName().setValue(result.getEntity().get市町村名());
            }
            if (result.getEntity().get処理日時() != null) {
                YMDHMS 基準日時 = result.getEntity().get処理日時();
                RString 年月日 = 基準日時.getRDateTime().getDate().wareki().toDateString();
                RString 時刻 = 基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
                row.getTxtSaishinShoriNitiji().setValue(年月日.concat(時刻));
            }
            RString 処理状態 = result.getEntity().get表示用処理状態();
            if (処理状態 != null) {
                row.getTxtShoriState().setValue(処理状態);
                if (処理待ち.equals(処理状態)) {
                    row.setSelectable(true);
                    flag = false;
                } else {
                    row.setSelectable(false);
                }
            }
            rowList.add(row);
        }
        DataGrid<dgShichosonIchiran_Row> grid = koikiPanelDiv.getDgShichosonIchiran();
        grid.setDataSource(rowList);
        if (flag) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, false);
        }
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @return ShotokuJohoTyushutuRenkeiKoikiParameter 所得情報抽出・連携_バッチパラメータクラスです
     */
    public ShotokuJohoBatchresultKoikiParameter getBatchParamter() {
        ShotokuJohoTyushutuRenkeiKoikiParameter batchparam = new ShotokuJohoTyushutuRenkeiKoikiParameter();
        batchparam.set処理年度(new FlexibleYear(div.getTxtShoriNendoKoiki().getValue().getYear().toDateString()));
        batchparam.set出力順ID(new RString(div.getCcdChohyoShutsuryokujunKoiki().get出力順ID()));
        List<ShichosonJoho> list = new ArrayList<>();
        ShichosonJoho entity = new ShichosonJoho();
        for (int i = 0; i < div.getDgShichosonIchiran().getClickedRowId(); i++) {
            entity.set市町村コード(new LasdecCode(div.getDgShichosonIchiran().getDataSource().get(i).getTxtCityCode().getValue()));
            entity.set市町村名(div.getDgShichosonIchiran().getDataSource().get(i).getTxtCityName().getValue());
            entity.set処理状態(div.getDgShichosonIchiran().getDataSource().get(i).getTxtShoriState().getValue());
            entity.set処理日時(new YMDHMS(div.getDgShichosonIchiran().getDataSource().get(i).getTxtSaishinShoriNitiji().getValue()));
            list.add(entity);
        }
        batchparam.set市町村情報List(list);
        return ShotokuJohoChushutsuRenkeiKoiki.createInstance().createShotokuJohoParameter(batchparam);
    }

    private List<KoikiZenShichosonJoho> handler市町村識別ID(List<AuthorityItem> 市町村識別ID,
            List<KoikiZenShichosonJoho> list) {
        if (!市町村識別ID_00.equals(new RString(市町村識別ID.get(0).getItemId().toString()))) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                    .replace(広域職員でないため.toString()).evaluate());
        } else {
            SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJohoList = KoikiShichosonJohoFinder
                    .createInstance().getGenShichosonJoho();
            list.addAll(koikiZenShichosonJohoList.records());
            for (KoikiZenShichosonJoho entity : koikiZenShichosonJohoList.records()) {
                if (!entity.get所得引出方法().equals(なし)) {
                    list.remove(entity);
                }
            }
            return list;
        }
    }

}
