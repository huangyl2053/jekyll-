/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuRirekiInfo.ShikakuRirekiInfo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokusojouho.ShikakuTokusoJouho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jushochitokureisha.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * 資格履歴情報のクラスです。
 *
 * @reamsid_L DBZ-4560-010 wanghui
 */
public class ShikakuRirekiInfoHandler {

    private final ShikakuRirekiInfoDiv div;
    private final RString 合併無し = new RString("0");
    private final RString 合併有り = new RString("1");
    private final RString 単一広域区分 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 資格履歴情報共有子Divのエンティティ
     */
    public ShikakuRirekiInfoHandler(ShikakuRirekiInfoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void intialize() {
        ShichosonSecurityJoho 市町村セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if ((DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ.get導入形態コード().getKey())
                || DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ.get導入形態コード().getKey()))
                && (合併無し.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)))) {
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(12).setVisible(false);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(13).setVisible(false);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(14).setVisible(false);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(15).setVisible(false);
        }
        if ((DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ.get導入形態コード().getKey())
                || DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ.get導入形態コード().getKey()))
                && (合併有り.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)))) {
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(12).setVisible(false);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(13).setVisible(false);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(14).setVisible(true);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(15).setVisible(false);
        }
        if ((DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ.get導入形態コード().getKey()))
                && (合併有り.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)))) {

            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(12).setVisible(true);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(13).setVisible(true);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(14).setVisible(true);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(15).setVisible(true);
        }
        if ((DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ.get導入形態コード().getKey()))
                && (合併無し.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)))) {

            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(12).setVisible(true);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(13).setVisible(true);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(14).setVisible(false);
            div.getDgShikakuRirekiInfo().getGridSetting().getColumns().get(15).setVisible(true);
        }
        div.getDgShikakuRirekiInfo().setDisabled(true);
    }

    /**
     * 資格履歴情報gridエリア。
     *
     * @param list 情報gridエリア内容
     */
    public void setDataGrid(List<ShikakuTokusoJouho> list) {
        List<dgShikakuRirekiInfo_Row> ShikakuRirekiInfoGridList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ShikakuTokusoJouho business = list.get(i);
                if (単一広域区分.equals(business.get単一広域区分())) {
                    dgShikakuRirekiInfo_Row dgShikakuRirekiInfo_Row = new dgShikakuRirekiInfo_Row();
                    dgShikakuRirekiInfo_Row.getShutokuDate().setValue(business.get資格取得年月日() == null
                            ? FlexibleDate.EMPTY : business.get資格取得年月日());
                    dgShikakuRirekiInfo_Row.getShutokuTodokedeDate().setValue(business.get資格取得届出年月日() == null
                            ? FlexibleDate.EMPTY : business.get資格取得届出年月日());
                    dgShikakuRirekiInfo_Row.setShutokuJiyu(business.get取得事由コード() == null
                            ? RString.EMPTY : ShikakuShutokuJiyu.toValue(business.get取得事由コード()).getName());
                    dgShikakuRirekiInfo_Row.setHihokenshaKubun(business.get被保険者区分コード() == null
                            ? RString.EMPTY : HihokenshaKubunCode.toValue(business.get被保険者区分コード()).get名称());
                    dgShikakuRirekiInfo_Row.getSoshitsuDate().setValue(business.get資格喪失年月日() == null
                            ? FlexibleDate.EMPTY : business.get資格喪失年月日());
                    dgShikakuRirekiInfo_Row.getSoshitsuTodokedeDate().setValue(business.get資格喪失届出年月日());
                    dgShikakuRirekiInfo_Row.setSoshitsuJiyu(business.get喪失事由コード() == null
                            ? RString.EMPTY : ShikakuSoshitsuJiyu.toValue(business.get喪失事由コード()).get名称());
                    dgShikakuRirekiInfo_Row.setJutokuKubun(business.get住所地特例フラグ() == null
                            ? RString.EMPTY : JushochitokureishaKubun.toValue(business.get住所地特例フラグ()).get名称());
                    dgShikakuRirekiInfo_Row.setShozaiHokensha(ShichosonSecurityJoho.getKanriJoho(GyomuBunrui.介護事務).get市町村情報().get市町村名称() == null
                            ? RString.EMPTY : ShichosonSecurityJoho.getKanriJoho(GyomuBunrui.介護事務).get市町村情報().get市町村名称());
                    dgShikakuRirekiInfo_Row.setSochimotoHokensha(RString.EMPTY);
                    dgShikakuRirekiInfo_Row.setKyuHokensha(business.get旧市町村名称() == null
                            ? RString.EMPTY : business.get旧市町村名称());
                    dgShikakuRirekiInfo_Row.setShikibetsuCode(business.get識別コード() == null
                            ? RString.EMPTY : business.get識別コード().value());
                    RStringBuilder 日時 = new RStringBuilder();
                    日時.append(business.get処理日時().getDate().wareki().toDateString());
                    日時.append(new RString(" "));
                    日時.append(business.get処理日時().getTime().toString());
                    dgShikakuRirekiInfo_Row.setShoriDateTime(日時.toRString());
                    ShikakuRirekiInfoGridList.add(dgShikakuRirekiInfo_Row);
                } else {
                    dgShikakuRirekiInfo_Row dgShikakuRirekiInfo_Row = new dgShikakuRirekiInfo_Row();
                    dgShikakuRirekiInfo_Row.getShutokuDate().setValue(business.get資格取得年月日() == null
                            ? FlexibleDate.EMPTY : business.get資格取得年月日());
                    dgShikakuRirekiInfo_Row.getShutokuTodokedeDate().setValue(business.get資格取得届出年月日() == null
                            ? FlexibleDate.EMPTY : business.get資格取得届出年月日());
                    dgShikakuRirekiInfo_Row.setShutokuJiyu(business.get取得事由コード() == null
                            ? RString.EMPTY : ShikakuShutokuJiyu.toValue(business.get取得事由コード()).getShortName());
                    dgShikakuRirekiInfo_Row.setHihokenshaKubun(business.get被保険者区分コード() == null
                            ? RString.EMPTY : HihokenshaKubunCode.toValue(business.get被保険者区分コード()).get名称());
                    dgShikakuRirekiInfo_Row.getSoshitsuDate().setValue(business.get資格喪失年月日() == null
                            ? FlexibleDate.EMPTY : business.get資格喪失年月日());
                    dgShikakuRirekiInfo_Row.getSoshitsuTodokedeDate().setValue(business.get資格喪失届出年月日() == null
                            ? FlexibleDate.EMPTY : business.get資格喪失届出年月日());
                    dgShikakuRirekiInfo_Row.setSoshitsuJiyu(business.get喪失事由コード() == null
                            ? RString.EMPTY : ShikakuSoshitsuJiyu.toValue(business.get喪失事由コード()).get名称());
                    dgShikakuRirekiInfo_Row.setJutokuKubun(business.get住所地特例フラグ() == null
                            ? RString.EMPTY : JushochitokureishaKubun.toValue(business.get住所地特例フラグ()).get名称());
                    dgShikakuRirekiInfo_Row.setShozaiHokensha(business.get市町村名称() == null
                            ? RString.EMPTY : business.get市町村名称());
                    dgShikakuRirekiInfo_Row.setSochimotoHokensha(business.get措置元保険者() == null
                            ? RString.EMPTY : business.get措置元保険者());
                    dgShikakuRirekiInfo_Row.setKyuHokensha(business.get旧市町村名称() == null
                            ? RString.EMPTY : business.get旧市町村名称());
                    dgShikakuRirekiInfo_Row.setShikibetsuCode(business.get識別コード() == null
                            ? RString.EMPTY : business.get識別コード().value());
                    RStringBuilder 日時 = new RStringBuilder();
                    日時.append(business.get処理日時().getDate().wareki().toDateString());
                    日時.append(new RString(" "));
                    日時.append(business.get処理日時().getTime().toString());
                    dgShikakuRirekiInfo_Row.setShoriDateTime(日時.toRString());
                    ShikakuRirekiInfoGridList.add(dgShikakuRirekiInfo_Row);
                }
            }
            div.getDgShikakuRirekiInfo().setDataSource(ShikakuRirekiInfoGridList);
        }
    }
}
