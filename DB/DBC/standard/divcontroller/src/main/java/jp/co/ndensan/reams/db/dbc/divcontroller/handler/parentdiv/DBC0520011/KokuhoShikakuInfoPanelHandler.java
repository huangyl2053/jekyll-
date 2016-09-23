/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhoShikakuInfo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhoShikakuInfoBuilder;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.KokuhoShikakuInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhoShikakuInfoManager;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsuType;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaSearchItem;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.IHokenjaManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;

/**
 * 国保資格情報登録
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class KokuhoShikakuInfoPanelHandler {

    private final KokuhoShikakuInfoPanelDiv div;
    private static final RString コード = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div KokuhoShikakuInfoPanelDiv
     */
    public KokuhoShikakuInfoPanelHandler(KokuhoShikakuInfoPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @return KokuhoShikakuInfo 国保資格詳細情報
     */
    public KokuhoShikakuInfo initialize(ShikibetsuCode shikibetsuCode, HihokenshaNo 被保険者番号) {
        IHokenjaManager iHokenjaManager = HokenjaManagerFactory.createInstance();
        INewSearchCondition 検索条件 = SearchConditionFactory.condition(
                HokenjaSearchItem.保険者種別, StringOperator.完全一致, HokenjaShubetsuType.国民健康保険.code());
        List<Hokenja> hokenja = iHokenjaManager.get保険者一覧(検索条件);
        set国保保険者番号(hokenja);
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 介護導入形態 = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.事務広域.getCode().equals(介護導入形態)) {
            介護導入形態 = HokenshaKosei.広域保険者.getコード();
        }
        if (DonyuKeitaiCode.事務単一.getCode().equals(介護導入形態)) {
            介護導入形態 = HokenshaKosei.単一市町村.getコード();
        }
        if (DonyuKeitaiCode.事務構成市町村.getCode().equals(介護導入形態)) {
            介護導入形態 = HokenshaKosei.広域市町村.getコード();
        }
        div.getHeaderPanel().getCcdAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        div.getHeaderPanel().getCcdAtenaInfo().setShoriType(コード);
        div.getHeaderPanel().getCcdAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, shikibetsuCode);
        div.getHeaderPanel().getCcdAtenaInfo().initialize();
        div.getHeaderPanel().getCcdShikakuInfo().initialize(shichosonSecurityJoho.get市町村情報().get市町村コード().value(), 被保険者番号.value());
        KokuhoShikakuInfoManager kokuhoShikakuInfoManager = KokuhoShikakuInfoManager.createInstance();
        KokuhoShikakuInfo 国保資格詳細情報 = kokuhoShikakuInfoManager.get国保資格詳細情報(shikibetsuCode);
        if (国保資格詳細情報 != null) {
            if (国保資格詳細情報.get国保保険証番号() != null && !国保資格詳細情報.get国保保険証番号().isEmpty()) {
                div.getMeisaiPanel().getTxtKokuhoHokenshoNo().setValue(new Decimal(国保資格詳細情報.get国保保険証番号().toString()));
            }
            if (国保資格詳細情報.get国保個人番号() != null && !国保資格詳細情報.get国保個人番号().isEmpty()) {
                div.getMeisaiPanel().getTxtKokuhoKojinNo().setValue(国保資格詳細情報.get国保個人番号());
            }
            if (国保資格詳細情報.get資格取得日() != null) {
                div.getMeisaiPanel().getTxtShikakuShutokuYMD().setValue(
                        new RDate(国保資格詳細情報.get資格取得日().toString()));
            }
            if (国保資格詳細情報.get資格喪失日() != null) {
                div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().setValue(
                        new RDate(国保資格詳細情報.get資格喪失日().toString()));
            }
            div.getMeisaiPanel().getTxtKokuhoNo().setValue(国保資格詳細情報.get国保番号());
            List<RString> keys = new ArrayList<>();
            if (TorokuKubun.取込.getコード().equals(国保資格詳細情報.get登録区分())) {
                keys.add(new RString("key0"));
            }
            div.getMeisaiPanel().getChkTorokuKubun().setSelectedItemsByKey(keys);
            set文字コード(国保資格詳細情報);
        }
        前排他の設定(被保険者番号);
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
        return 国保資格詳細情報;
    }

    /**
     * データを保存する
     *
     * @param 被保険者番号 HihokenshaNo
     * @param shikibetsuCode ShikibetsuCode
     * @param 国保資格詳細情報 KokuhoShikakuInfo
     * @return boolean
     */
    public boolean updateorinsert(HihokenshaNo 被保険者番号, ShikibetsuCode shikibetsuCode, KokuhoShikakuInfo 国保資格詳細情報) {
        boolean flag = false;
        KokuhoShikakuInfoManager kokuhoShikakuInfoManager = KokuhoShikakuInfoManager.createInstance();
        KokuhoShikakuInfoBuilder builder;
        if (国保資格詳細情報 != null) {
            builder = 国保資格詳細情報.createBuilderForEdit();
            if (div.getTxtKokuhoHokenshoNo().getValue() != null) {
                builder.set国保保険証番号(new RString(div.getTxtKokuhoHokenshoNo().getValue().toString()));
            }
            if (!div.getDdlKokuhoHokenshaNo().getSelectedValue().isNullOrEmpty()) {
                builder.set国保保険者番号(div.getDdlKokuhoHokenshaNo().getSelectedKey());
            }
            if (!div.getTxtKokuhoKojinNo().getValue().isNullOrEmpty()) {
                builder.set国保個人番号(div.getTxtKokuhoKojinNo().getValue());
            }
            if (!div.getTxtKokuhoNo().getValue().isNullOrEmpty()) {
                builder.set国保番号(div.getTxtKokuhoNo().getValue());
            }
            if (div.getTxtShikakuShutokuYMD().getValue() != null) {
                builder.set資格取得日(div.getTxtShikakuShutokuYMD().getValue().toDateString());
            }
            if (div.getTxtShikakuSoshitsuYMD().getValue() != null) {
                builder.set資格喪失日(div.getTxtShikakuSoshitsuYMD().getValue().toDateString());
            } else {
                builder.set資格喪失日(RString.EMPTY);
            }
            if (div.getTxtTaishokuGaitoYMD().getValue() != null) {
                builder.set退職該当日(div.getTxtTaishokuGaitoYMD().getValue().toDateString());
            } else {
                builder.set退職該当日(RString.EMPTY);
            }
            if (div.getTxtTaishokuHigaitoYMD().getValue() != null) {
                builder.set退職非該当日(div.getTxtTaishokuHigaitoYMD().getValue().toDateString());
            } else {
                builder.set退職非該当日(RString.EMPTY);
            }
            if (!div.getDdlKojinKubunCode().getSelectedValue().isNullOrEmpty()) {
                builder.set個人区分コード(div.getDdlKojinKubunCode().getSelectedKey());
            } else {
                builder.set個人区分コード(RString.EMPTY);
            }
            if (div.getChkTorokuKubun().getSelectedKeys().size() > 0) {
                builder.set登録区分(new RString("1"));
            } else {
                builder.set登録区分(new RString("0"));
            }
            if (kokuhoShikakuInfoManager.save国保資格詳細情報(builder.build())) {
                前排他制御の解除(被保険者番号);
                AccessLogger.log(AccessLogType.更新, toPersonalData(被保険者番号));
                flag = true;
            }
        } else {
            flag = insert国保資格詳細情報(shikibetsuCode, 国保資格詳細情報, kokuhoShikakuInfoManager);
            if (flag) {
                前排他制御の解除(被保険者番号);
                AccessLogger.log(AccessLogType.更新, toPersonalData(被保険者番号));
            }
        }
        return flag;
    }

    /**
     * 「一覧へ戻る」ボタンの処理
     *
     * @param 被保険者番号 shikibetsuCode
     */
    public void onClick_btnBack(HihokenshaNo 被保険者番号) {
        前排他制御の解除(被保険者番号);
    }

    private void set文字コード(KokuhoShikakuInfo 国保資格詳細情報) {
        RString 文字コード = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (new RString("2").equals(文字コード)) {
            if (国保資格詳細情報.get退職該当日() != null) {
                div.getMeisaiPanel().getTxtTaishokuGaitoYMD().setValue(
                        new RDate(国保資格詳細情報.get退職該当日().toString()));
            }
            if (国保資格詳細情報.get退職非該当日() != null) {
                div.getMeisaiPanel().getTxtTaishokuHigaitoYMD().setValue(
                        new RDate(国保資格詳細情報.get退職非該当日().toString()));
            }
            div.getMeisaiPanel().getDdlKojinKubunCode().setSelectedKey(国保資格詳細情報.get個人区分コード());
        } else {
            div.getMeisaiPanel().getTxtTaishokuGaitoYMD().setDisplayNone(true);
            div.getMeisaiPanel().getTxtTaishokuHigaitoYMD().setDisplayNone(true);
            div.getMeisaiPanel().getDdlKojinKubunCode().setDisplayNone(true);
        }
    }

    private void 前排他の設定(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(new RString("DBCHihokenshaNo").concat(被保険者番号.getColumnValue()));
        RealInitialLocker.lock(new LockingKey(排他キー));
    }

    private void 前排他制御の解除(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(new RString("DBCHihokenshaNo").concat(被保険者番号.getColumnValue()));
        RealInitialLocker.release(new LockingKey(排他キー));
    }

    private void set国保保険者番号(List<Hokenja> hokenjas) {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (Hokenja hokenja : hokenjas) {
            dataSources.add(get国保保険者番号(hokenja));
        }
        div.getMeisaiPanel().getDdlKokuhoHokenshaNo().setDataSource(dataSources);
    }

    private KeyValueDataSource get国保保険者番号(Hokenja hokenja) {
        return new KeyValueDataSource(hokenja.get保険者番号().getColumnValue(), hokenja.get保険者番号().getColumnValue().concat(RString.HALF_SPACE).concat(hokenja.get保険者名()));
    }

    private PersonalData toPersonalData(HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private boolean insert国保資格詳細情報(ShikibetsuCode shikibetsuCode, KokuhoShikakuInfo 国保資格詳細情報,
            KokuhoShikakuInfoManager kokuhoShikakuInfoManager) {
        国保資格詳細情報 = new KokuhoShikakuInfo(shikibetsuCode, new RString("0001"));
        KokuhoShikakuInfoBuilder builder = 国保資格詳細情報.createBuilderForEdit();
        if (div.getTxtKokuhoHokenshoNo().getValue() != null) {
            builder.set国保保険証番号(new RString(div.getTxtKokuhoHokenshoNo().getValue().toString()));
        }
        if (!div.getDdlKokuhoHokenshaNo().getSelectedValue().isNullOrEmpty()) {
            builder.set国保保険者番号(div.getDdlKokuhoHokenshaNo().getSelectedKey());
        }
        if (!div.getTxtKokuhoKojinNo().getValue().isNullOrEmpty()) {
            builder.set国保個人番号(div.getTxtKokuhoKojinNo().getValue());
        }
        if (!div.getTxtKokuhoNo().getValue().isNullOrEmpty()) {
            builder.set国保番号(div.getTxtKokuhoNo().getValue());
        }
        if (div.getTxtShikakuShutokuYMD().getValue() != null) {
            builder.set資格取得日(div.getTxtShikakuShutokuYMD().getValue().toDateString());
        }
        if (div.getTxtShikakuSoshitsuYMD().getValue() != null) {
            builder.set資格喪失日(div.getTxtShikakuSoshitsuYMD().getValue().toDateString());
        }
        if (div.getTxtTaishokuGaitoYMD().getValue() != null) {
            builder.set退職該当日(div.getTxtTaishokuGaitoYMD().getValue().toDateString());
        }
        if (div.getTxtTaishokuHigaitoYMD().getValue() != null) {
            builder.set退職非該当日(div.getTxtTaishokuHigaitoYMD().getValue().toDateString());
        }
        if (!div.getDdlKojinKubunCode().getSelectedValue().isNullOrEmpty()) {
            builder.set個人区分コード(div.getDdlKojinKubunCode().getSelectedKey());
        }
        if (div.getChkTorokuKubun().getSelectedKeys().size() > 0) {
            builder.set登録区分(new RString("1"));
        } else {
            builder.set登録区分(new RString("0"));
        }
        return kokuhoShikakuInfoManager.save国保資格詳細情報(builder.build());
    }
}
