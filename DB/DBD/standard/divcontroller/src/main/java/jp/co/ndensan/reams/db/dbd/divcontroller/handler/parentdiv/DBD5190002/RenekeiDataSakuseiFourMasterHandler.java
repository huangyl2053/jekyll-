/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.kaigoninteihokaiseikanri.HokaiseiShikoYMDToKoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho.YokaigoNinteiGaibuDataOutputHistory;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519002.DBD519002_YokaigoNinteiKanrenDataSakuseiParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190002.RenekeiDataSakuseiFourMasterDiv;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5190001.RenkeiDataSakuseiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5190002.RenekeiDataSakuseiFourMasterManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 要介護認定関連データ作成のハンドラークラスです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class RenekeiDataSakuseiFourMasterHandler {

    private final RenekeiDataSakuseiFourMasterDiv div;
    private static final RString 対象期間キー = new RString("key0");
    private static final RString 新キー = new RString("key0");
    private static final RString 旧キー = new RString("key1");
    private static final int HOUR_23 = 23;
    private static final int MINUTE_59 = 59;
    private static final int SECOND_59 = 59;
    private static final int ONE_DAY = 1;
    private static final int ONE_SECOND = 1;

    /**
     * コンストラクタです。
     *
     * @param div ドメインオブジェクトを取り出したい {@link RenekeiDataSakuseiFourMasterDiv}
     */
    public RenekeiDataSakuseiFourMasterHandler(RenekeiDataSakuseiFourMasterDiv div) {
        this.div = div;
    }

    /**
     * 要介護認定関連データ作成画面の初期化。
     */
    public void onLoad() {
        div.getRadChushutsuJoken().setDisabled(false);
        div.getRadChushutsuJoken().setSelectedKey(対象期間キー);
        対象期間の場合表示制御(get要介護認定外部データ出力履歴());
        出力対象IFのドロップダウンリスト初期化();
        出力対象IFエリア表示制御();
    }

    /**
     * 抽出条件ラジオボタンのonClick事件。
     */
    public void radChushutsuJoken_onClick() {
        if (div.getRadChushutsuJoken().getSelectedKey().equals(対象期間キー)) {
            対象期間の場合表示制御(get要介護認定外部データ出力履歴());
        } else {
            全件の場合表示制御();
        }
    }

    /**
     * IF種別　ラジオボタンのonClick事件。
     */
    public void radIfShubetu_onClick() {
        if (新キー.equals(div.getRadIfShubetu().getSelectedKey())) {
            iF種別ラジオボタン新表示();
        } else {
            iF種別ラジオボタン旧表示();
        }
    }

    /**
     * バッチパラメータの作成。
     *
     * @return バッチパラメータ
     */
    public DBD519002_YokaigoNinteiKanrenDataSakuseiParameter createParameter() {
        DBD519002_YokaigoNinteiKanrenDataSakuseiParameter paramter = new DBD519002_YokaigoNinteiKanrenDataSakuseiParameter();
        paramter.setKonkaishoriymdtime_from(div.getTxtkonkaishoriymdtime().getFromValue());
        paramter.setKonkaishoriymdtime_to(div.getTxtkonkaishoriymdtime().getToValue());
        paramter.setShikibetsucode(get法改正施行年月日と厚労省IF識別コード().get厚労省IF識別コード());
        paramter.setChosaitakusakifilename(div.getDropDownListChosaItakusakiFileName().getSelectedValue());
        paramter.setChosainfilename(div.getDropDownListChosainFileName().getSelectedValue());
        paramter.setShujiiIryokikanfilename(div.getDropDownListShujiiIryoKikanFileName().getSelectedValue());
        paramter.setShujiifilename(div.getDropDownListShujiiFileName().getSelectedValue());
        return paramter;
    }

    private HokaiseiShikoYMDToKoroshoIfShikibetsuCode get法改正施行年月日と厚労省IF識別コード() {
        return RenekeiDataSakuseiFourMasterManager.createInstance().get法改正施行年月日と厚労省IF識別コード();
    }

    private YokaigoNinteiGaibuDataOutputHistory get要介護認定外部データ出力履歴() {
        return RenkeiDataSakuseiShinseiJohoManager.createInstance().get介護認定外部データ出力履歴(new Code(Datakubun.マスタ4.getコード()));
    }

    private void 対象期間の場合表示制御(YokaigoNinteiGaibuDataOutputHistory 要介護認定外部データ出力履歴) {
        div.getTxtkonkaishoriymdtime().setDisplayNone(false);
        div.getTxtzenkaishoriymdtime().setDisplayNone(false);
        div.getTxtkonkaishoriymdtime().setToDateValue(RDate.getNowDate());
        div.getTxtkonkaishoriymdtime().setToTimeValue(RDate.getNowTime());
        div.getTxtzenkaishoriymdtime().setReadOnly(true);
        div.getTxtkonkaishoriymdtime().setReadOnly(false);
        if (要介護認定外部データ出力履歴 == null) {
            return;
        }
        YMDHMS 終了年月日時分秒 = 要介護認定外部データ出力履歴.getDataOutputShuryoYMDHMS();
        if (終了年月日時分秒 != null) {
            div.getTxtzenkaishoriymdtime().setToDateValue(終了年月日時分秒.getDate());
            div.getTxtzenkaishoriymdtime().setToTimeValue(終了年月日時分秒.getRDateTime().getTime());
            if (終了年月日時分秒.getRDateTime().getTime().compareTo(RTime.of(HOUR_23, MINUTE_59, SECOND_59)) == 0) {
                div.getTxtkonkaishoriymdtime().setFromDateValue(終了年月日時分秒.getDate().plusDay(ONE_DAY));
                div.getTxtkonkaishoriymdtime().setFromTimeValue(RTime.of(0, 0, 0));
            } else {
                div.getTxtkonkaishoriymdtime().setFromDateValue(終了年月日時分秒.getDate());
                div.getTxtkonkaishoriymdtime().setFromTimeValue(終了年月日時分秒.getRDateTime().getTime().plusSeconds(ONE_SECOND));
            }
        }
        if (要介護認定外部データ出力履歴.getDataOutputKaishiYMDHMS() != null) {
            div.getTxtzenkaishoriymdtime().setFromDateValue(要介護認定外部データ出力履歴.getDataOutputKaishiYMDHMS().getDate());
            div.getTxtzenkaishoriymdtime().setFromTimeValue(要介護認定外部データ出力履歴.getDataOutputKaishiYMDHMS().getRDateTime().getTime());
        }
    }

    private void 全件の場合表示制御() {
        div.getTxtkonkaishoriymdtime().clearFromValue();
        div.getTxtkonkaishoriymdtime().clearToValue();
        div.getTxtzenkaishoriymdtime().clearFromValue();
        div.getTxtzenkaishoriymdtime().clearToValue();
        div.getTxtkonkaishoriymdtime().setDisplayNone(true);
        div.getTxtzenkaishoriymdtime().setDisplayNone(true);
    }

    private void 出力対象IFのドロップダウンリスト初期化() {
        List<KeyValueDataSource> 認定調査委託先情報ドロップダウンリスト = new ArrayList<>();
        認定調査委託先情報ドロップダウンリスト.add(new KeyValueDataSource(新キー, getDBDConfigValue(ConfigNameDBD.認定調査委託先データ送信ファイル名)));
        認定調査委託先情報ドロップダウンリスト.add(new KeyValueDataSource(旧キー, getDBEConfigValue(ConfigNameDBE.認定調査委託先データ送信ファイル名_新)));
        List<KeyValueDataSource> 認定調査員情報ドロップダウンリスト = new ArrayList<>();
        認定調査員情報ドロップダウンリスト.add(new KeyValueDataSource(新キー, getDBDConfigValue(ConfigNameDBD.認定調査員データ送信ファイル名)));
        認定調査員情報ドロップダウンリスト.add(new KeyValueDataSource(旧キー, getDBEConfigValue(ConfigNameDBE.認定調査員データ送信ファイル名_新)));
        List<KeyValueDataSource> 主治医医療機関情報ドロップダウンリスト = new ArrayList<>();
        主治医医療機関情報ドロップダウンリスト.add(new KeyValueDataSource(新キー, getDBDConfigValue(ConfigNameDBD.主治医医療機関データ送信ファイル名)));
        主治医医療機関情報ドロップダウンリスト.add(new KeyValueDataSource(旧キー, getDBEConfigValue(ConfigNameDBE.主治医医療機関データ送信ファイル名_新)));
        List<KeyValueDataSource> 主治医情報ドロップダウンリスト = new ArrayList<>();
        主治医情報ドロップダウンリスト.add(new KeyValueDataSource(新キー, getDBDConfigValue(ConfigNameDBD.主治医データ送信ファイル名)));
        主治医情報ドロップダウンリスト.add(new KeyValueDataSource(旧キー, getDBEConfigValue(ConfigNameDBE.主治医データ送信ファイル名_新)));
        div.getDropDownListChosaItakusakiFileName().setDataSource(認定調査委託先情報ドロップダウンリスト);
        div.getDropDownListChosainFileName().setDataSource(認定調査員情報ドロップダウンリスト);
        div.getDropDownListShujiiIryoKikanFileName().setDataSource(主治医医療機関情報ドロップダウンリスト);
        div.getDropDownListShujiiFileName().setDataSource(主治医情報ドロップダウンリスト);
    }

    private void 出力対象IFエリア表示制御() {
        HokaiseiShikoYMDToKoroshoIfShikibetsuCode 法改正施行年月日と厚労省IF識別コード = get法改正施行年月日と厚労省IF識別コード();
        if (法改正施行年月日と厚労省IF識別コード.get法改正施行年月日().isBefore(FlexibleDate.getNowDate())) {
            div.getRadIfShubetu().setSelectedKey(新キー);
            div.getRadIfShubetu().setDisabled(true);
            iF種別ラジオボタン新表示();
        } else {
            div.getRadIfShubetu().setDisabled(false);
            div.getRadIfShubetu().setSelectedKey(旧キー);
            iF種別ラジオボタン旧表示();
        }
    }

    private void iF種別ラジオボタン新表示() {
        div.getDropDownListChosaItakusakiFileName().setSelectedValue(getDBDConfigValue(ConfigNameDBD.認定調査委託先データ送信ファイル名));
        div.getDropDownListChosainFileName().setSelectedValue(getDBDConfigValue(ConfigNameDBD.認定調査員データ送信ファイル名));
        div.getDropDownListShujiiIryoKikanFileName().setSelectedValue(getDBDConfigValue(ConfigNameDBD.主治医医療機関データ送信ファイル名));
        div.getDropDownListShujiiFileName().setSelectedValue(getDBDConfigValue(ConfigNameDBD.主治医データ送信ファイル名));
        div.getDropDownListChosaItakusakiFileName().setReadOnly(true);
        div.getDropDownListChosainFileName().setReadOnly(true);
        div.getDropDownListShujiiIryoKikanFileName().setReadOnly(true);
        div.getDropDownListShujiiFileName().setReadOnly(true);
    }

    private void iF種別ラジオボタン旧表示() {
        div.getDropDownListChosaItakusakiFileName().setSelectedValue(getDBEConfigValue(ConfigNameDBE.認定調査委託先データ送信ファイル名_新));
        div.getDropDownListChosainFileName().setSelectedValue(getDBEConfigValue(ConfigNameDBE.認定調査員データ送信ファイル名_新));
        div.getDropDownListShujiiIryoKikanFileName().setSelectedValue(getDBEConfigValue(ConfigNameDBE.主治医医療機関データ送信ファイル名_新));
        div.getDropDownListShujiiFileName().setSelectedValue(getDBEConfigValue(ConfigNameDBE.主治医データ送信ファイル名_新));
        div.getDropDownListChosaItakusakiFileName().setReadOnly(true);
        div.getDropDownListChosainFileName().setReadOnly(true);
        div.getDropDownListShujiiIryoKikanFileName().setReadOnly(true);
        div.getDropDownListShujiiFileName().setReadOnly(true);
    }

    private RString getDBDConfigValue(ConfigNameDBD config) {
        return DbBusinessConfig.get(config, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
    }

    private RString getDBEConfigValue(ConfigNameDBE config) {
        return DbBusinessConfig.get(config, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }
}
