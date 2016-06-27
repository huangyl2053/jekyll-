/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0500001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.configmaintenance.ConfigMaintenance;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0500001.SystemKanriHoyouDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0500001.dgSystemKanri_Row;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfigInfo;

/**
 * システム管理汎用クラスです。
 *
 * @reamsid_L DBU-3991-010 wanghui
 */
public class SystemKanriHandler {

    private final SystemKanriHoyouDiv div;
    private final RString dbu = new RString("DBU");
    private final RString dba = new RString("DBA");
    private final RString dbb = new RString("DBB");
    private final RString dbc = new RString("DBC");
    private final RString dbd = new RString("DBD");
    private final RString dbe = new RString("DBD");

    /**
     * コンストラクタです。
     *
     * @param div 資格不整合修正Div
     */
    public SystemKanriHandler(SystemKanriHoyouDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     * @param コンフィグリスト List<ConfigMaintenance>
     */
    public void initialize(List<ConfigMaintenance> コンフィグリスト) {
        RString サブ業務名 = ControlDataHolder.getExecutionSubGyomuCode().getGyomuName();
        SubGyomuCode サブ業務 = ControlDataHolder.getExecutionSubGyomuCode();
        List<dgSystemKanri_Row> rowList = new ArrayList<>();
        for (ConfigMaintenance configName : コンフィグリスト) {
            if (dbu.equals(new RString(サブ業務.toString()))) {
                dgSystemKanri_Row row = new dgSystemKanri_Row();
                BusinessConfigInfo コンフィグ = DbBusinessConfig.getConfigInfo(ConfigNameDBU.valueOf(configName.getConfigName().toString()),
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                row.getConfigValue().setValue(コンフィグ.getConfigValue());
                row.setConfigDescription(コンフィグ.getConfigDesc());
                row.setConfigName(configName.getConfigName());
                row.setConfigValueChangeFlag(new RString("0"));
                row.setBeforeChangeConfigValue(コンフィグ.getConfigValue());
                rowList.add(row);
            } else if (dba.equals(new RString(サブ業務.toString()))) {
                BusinessConfigInfo コンフィグ = DbBusinessConfig.getConfigInfo(ConfigNameDBA.valueOf(configName.getConfigName().toString()),
                        RDate.getNowDate(), SubGyomuCode.DBA介護資格);
                dgSystemKanri_Row row = new dgSystemKanri_Row();
                row.getConfigValue().setValue(コンフィグ.getConfigValue());
                row.setConfigDescription(コンフィグ.getConfigDesc());
                row.setConfigName(configName.getConfigName());
                row.setConfigValueChangeFlag(new RString("0"));
                row.setBeforeChangeConfigValue(コンフィグ.getConfigValue());
                rowList.add(row);
            } else if (dbc.equals(new RString(サブ業務.toString()))) {
                BusinessConfigInfo コンフィグ = DbBusinessConfig.getConfigInfo(ConfigNameDBC.valueOf(configName.getConfigName().toString()),
                        RDate.getNowDate(), SubGyomuCode.DBC介護給付);
                dgSystemKanri_Row row = new dgSystemKanri_Row();
                row.getConfigValue().setValue(コンフィグ.getConfigValue());
                row.setConfigDescription(コンフィグ.getConfigDesc());
                row.setConfigName(configName.getConfigName());
                row.setConfigValueChangeFlag(new RString("0"));
                row.setBeforeChangeConfigValue(コンフィグ.getConfigValue());
                rowList.add(row);
            } else if (dbb.equals(new RString(サブ業務.toString()))) {
                BusinessConfigInfo コンフィグ = DbBusinessConfig.getConfigInfo(ConfigNameDBB.valueOf(configName.getConfigName().toString()),
                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                dgSystemKanri_Row row = new dgSystemKanri_Row();
                row.getConfigValue().setValue(コンフィグ.getConfigValue());
                row.setConfigDescription(コンフィグ.getConfigDesc());
                row.setConfigName(configName.getConfigName());
                row.setConfigValueChangeFlag(new RString("0"));
                row.setBeforeChangeConfigValue(コンフィグ.getConfigValue());
                rowList.add(row);
            } else if (dbd.equals(new RString(サブ業務.toString()))) {
                BusinessConfigInfo コンフィグ = DbBusinessConfig.getConfigInfo(ConfigNameDBD.valueOf(configName.getConfigName().toString()),
                        RDate.getNowDate(), SubGyomuCode.DBD介護受給);
                dgSystemKanri_Row row = new dgSystemKanri_Row();
                row.getConfigValue().setValue(コンフィグ.getConfigValue());
                row.setConfigDescription(コンフィグ.getConfigDesc());
                row.setConfigName(configName.getConfigName());
                row.setConfigValueChangeFlag(new RString("0"));
                row.setBeforeChangeConfigValue(コンフィグ.getConfigValue());
                rowList.add(row);
            } else if (dbe.equals(new RString(サブ業務.toString()))) {
                BusinessConfigInfo コンフィグ = DbBusinessConfig.getConfigInfo(ConfigNameDBE.valueOf(configName.getConfigName().toString()),
                        RDate.getNowDate(), SubGyomuCode.DBE認定支援);
                dgSystemKanri_Row row = new dgSystemKanri_Row();
                row.getConfigValue().setValue(コンフィグ.getConfigValue());
                row.setConfigDescription(コンフィグ.getConfigDesc());
                row.setConfigName(configName.getConfigName());
                row.setConfigValueChangeFlag(new RString("0"));
                row.setBeforeChangeConfigValue(コンフィグ.getConfigValue());
                rowList.add(row);
            }
            div.getSystemKanri().getLblSubGyomu().setText(サブ業務名);
            div.getSystemKanri().getDgSystemKanri().setDataSource(rowList);
        }
    }

    /**
     * 画面初期化処理。
     *
     */
    public void 画面処理() {
        for (int i = 0; i < div.getSystemKanri().getDgSystemKanri().getDataSource().size(); i++) {
            if (div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigValue().getValue().
                    equals(div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getBeforeChangeConfigValue())) {
                div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).setConfigValueChangeFlag(new RString("1"));
            }
        }
    }

    /**
     * 画面DBへの保存処理。
     *
     */
    public void 保存処理() {
        SubGyomuCode サブ業務 = ControlDataHolder.getExecutionSubGyomuCode();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        RStringBuilder 変更理由 = new RStringBuilder();
        変更理由.append(menuID);
        変更理由.append(new RString("を使用して更新"));
        if (dbu.equals(new RString(サブ業務.toString()))) {
            for (int i = 0; i < div.getSystemKanri().getDgSystemKanri().getDataSource().size(); i++) {
                BusinessConfig.update(SubGyomuCode.DBU介護統計報告, ConfigNameDBU.valueOf(div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigName().toString()),
                        div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigValue().getValue(), 変更理由.toRString(),
                        RString.EMPTY, RDate.getNowDate());
            }
        } else if (dba.equals(new RString(サブ業務.toString()))) {
            for (int i = 0; i < div.getSystemKanri().getDgSystemKanri().getDataSource().size(); i++) {
                BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.valueOf(div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigName().toString()),
                        div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigValue().getValue(), 変更理由.toRString(),
                        RString.EMPTY, RDate.getNowDate());
            }
        } else if (dbb.equals(new RString(サブ業務.toString()))) {
            for (int i = 0; i < div.getSystemKanri().getDgSystemKanri().getDataSource().size(); i++) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.valueOf(div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigName().toString()),
                        div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigValue().getValue(), 変更理由.toRString(),
                        RString.EMPTY, RDate.getNowDate());
            }
        } else if (dbc.equals(new RString(サブ業務.toString()))) {
            for (int i = 0; i < div.getSystemKanri().getDgSystemKanri().getDataSource().size(); i++) {
                BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigName().toString()),
                        div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigValue().getValue(), 変更理由.toRString(),
                        RString.EMPTY, RDate.getNowDate());
            }
        } else if (dbd.equals(new RString(サブ業務.toString()))) {
            for (int i = 0; i < div.getSystemKanri().getDgSystemKanri().getDataSource().size(); i++) {
                BusinessConfig.update(SubGyomuCode.DBD介護受給, ConfigNameDBD.valueOf(div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigName().toString()),
                        div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigValue().getValue(), 変更理由.toRString(),
                        RString.EMPTY, RDate.getNowDate());
            }
        } else if (dbe.equals(new RString(サブ業務.toString()))) {
            for (int i = 0; i < div.getSystemKanri().getDgSystemKanri().getDataSource().size(); i++) {
                BusinessConfig.update(SubGyomuCode.DBE認定支援, ConfigNameDBE.valueOf(div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigName().toString()),
                        div.getSystemKanri().getDgSystemKanri().getDataSource().get(i).getConfigValue().getValue(), 変更理由.toRString(),
                        RString.EMPTY, RDate.getNowDate());
            }
        }
    }
}
