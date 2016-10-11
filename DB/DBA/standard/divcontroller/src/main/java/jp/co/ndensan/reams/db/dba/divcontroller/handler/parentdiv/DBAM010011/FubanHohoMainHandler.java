/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBAM010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.hihokenshno.HihokenshaNoFubammotoJoho;
import jp.co.ndensan.reams.db.dba.definition.core.hihokenshno.HihokenshaNoFubanHoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011.FubanHohoMainDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 被保険者番号付番方法画面のハンドラークラスです。
 *
 * @reamsid_L DBA-1200-010 suguangjun
 */
public class FubanHohoMainHandler {

    private static final RString カスタマイズ付番 = new RString("4");
    private static final RString 自動連番付番 = new RString("2");
    private static final RString 自動連番_MCD10付番 = new RString("5");
    private static final RString 未設定 = new RString("0");
    private static final RString 住民コード = new RString("1");
    private static final RString 被保険者番号自動採番 = new RString("被保険者番号自動採番");
    private static final RString 被保険者番号自動MCD = new RString("被保険者番号自動MCD");
    private final FubanHohoMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 被保険者番号付番方法Div
     */
    public FubanHohoMainHandler(FubanHohoMainDiv div) {
        this.div = div;
    }

    /**
     * 被保険者番号付番方法情報へのデータを設定します。
     */
    public void setFubanHoho() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource bangoFubanHohoData1 = new KeyValueDataSource(HihokenshaNoFubanHoho.カスタマイズ付番.getコード(),
                HihokenshaNoFubanHoho.カスタマイズ付番.get名称());
        KeyValueDataSource bangoFubanHohoData2 = new KeyValueDataSource(HihokenshaNoFubanHoho.任意手入力付番.getコード(),
                HihokenshaNoFubanHoho.任意手入力付番.get名称());
        KeyValueDataSource bangoFubanHohoData3 = new KeyValueDataSource(HihokenshaNoFubanHoho.住民コード付番.getコード(),
                HihokenshaNoFubanHoho.住民コード付番.get名称());
        KeyValueDataSource bangoFubanHohoData4 = new KeyValueDataSource(HihokenshaNoFubanHoho.自動連番_MCD10付番.getコード(),
                HihokenshaNoFubanHoho.自動連番_MCD10付番.get名称());
        KeyValueDataSource bangoFubanHohoData5 = new KeyValueDataSource(HihokenshaNoFubanHoho.自動連番付番.getコード(),
                HihokenshaNoFubanHoho.自動連番付番.get名称());
        dataSource.add(bangoFubanHohoData1);
        dataSource.add(bangoFubanHohoData2);
        dataSource.add(bangoFubanHohoData3);
        dataSource.add(bangoFubanHohoData4);
        dataSource.add(bangoFubanHohoData5);
        div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().setDataSource(dataSource);
        dataSource.clear();
        KeyValueDataSource motoJohoData1 = new KeyValueDataSource(HihokenshaNoFubammotoJoho.未設定.getコード(),
                HihokenshaNoFubammotoJoho.未設定.get名称());
        KeyValueDataSource motoJohoData2 = new KeyValueDataSource(HihokenshaNoFubammotoJoho.住民コード.getコード(),
                HihokenshaNoFubammotoJoho.住民コード.get名称());
        KeyValueDataSource motoJohoData3 = new KeyValueDataSource(HihokenshaNoFubammotoJoho.自動連番.getコード(),
                HihokenshaNoFubammotoJoho.自動連番.get名称());
        dataSource.add(motoJohoData1);
        dataSource.add(motoJohoData2);
        dataSource.add(motoJohoData3);
        div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().setDataSource(dataSource);
        div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().setSelectedKey(DbBusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_付番方法, RDate.getNowDate(), SubGyomuCode.DBA介護資格));
        div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().setSelectedKey(DbBusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報, RDate.getNowDate(), SubGyomuCode.DBA介護資格));
        RString 開始位置 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_開始位置, RDate.getNowDate(),
                SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getFubanMotoJoho().getTxtKaishiKetaIchi().setValue(RString.isNullOrEmpty(開始位置)
                ? Decimal.ZERO : new Decimal(開始位置.toString()));
        RString 有効桁数 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_有効桁数, RDate.getNowDate(),
                SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu().setValue(RString.isNullOrEmpty(有効桁数)
                ? Decimal.ZERO : new Decimal(有効桁数.toString()));
        RString 前付加桁数 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号_桁数, RDate.getNowDate(),
                SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().setValue(RString.isNullOrEmpty(前付加桁数)
                ? Decimal.ZERO : new Decimal(前付加桁数.toString()));
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode().setValue(DbBusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号, RDate.getNowDate(), SubGyomuCode.DBA介護資格));
        RString 後付加桁数 = DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号_桁数, RDate.getNowDate(),
                SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().setValue(RString.isNullOrEmpty(後付加桁数)
                ? Decimal.ZERO : new Decimal(後付加桁数.toString()));
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode().setValue(DbBusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号, RDate.getNowDate(), SubGyomuCode.DBA介護資格));
    }

    /**
     * 被保険者番号付番方法エリアが非活性に設定します。
     */
    public void setDisabledTrueToFubanHoho() {
        div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setDisabled(true);
        div.getFubanHoho().getFubanMotoJoho().getTxtKaishiKetaIchi().setDisabled(true);
        div.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu().setDisabled(true);
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().setDisabled(true);
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode().setDisabled(true);
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().setDisabled(true);
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode().setDisabled(true);
    }

    /**
     * 被保険者番号付番方法エリアが活性に設定します。
     */
    public void setDisabledFlaseToFubanHoho() {
        div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setDisabled(false);
        div.getFubanHoho().getFubanMotoJoho().getTxtKaishiKetaIchi().setDisabled(false);
        div.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu().setDisabled(false);
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().setDisabled(false);
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode().setDisabled(false);
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().setDisabled(false);
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode().setDisabled(false);
    }

    /**
     * 被保険者番号付番方法が活性制御に設定します。
     */
    public void setDisableToFubanHoho() {
        RString 被保険者番号付番方法 = div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().getSelectedKey();
        RString 付番元情報 = div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().getSelectedKey();
        if (自動連番付番.equals(被保険者番号付番方法)) {
            setDisabledTrueToFubanHoho();
            div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setDisabled(false);
        } else if (カスタマイズ付番.equals(被保険者番号付番方法) && 未設定.equals(付番元情報)) {
            setDisabledTrueToFubanHoho();
        } else if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)) {
            setDisabledFlaseToFubanHoho();
            div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setDisabled(true);
        } else if (カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            setDisabledFlaseToFubanHoho();
            div.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu().setDisabled(true);
        } else if (自動連番_MCD10付番.equals(被保険者番号付番方法)) {
            setDisabledTrueToFubanHoho();
            div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setDisabled(false);
        } else {
            setDisabledTrueToFubanHoho();
        }
    }

    /**
     * 自動付番開始番号に設定します。
     */
    public void setJidoFubanKaishiNo() {
        RString 被保険者番号付番方法 = div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().getSelectedKey();
        RString 付番元情報 = div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().getSelectedKey();
        if (自動連番付番.equals(被保険者番号付番方法)) {
            div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setValue(getJidoFubanKaishiNo1());
        } else if (カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setValue(getJidoFubanKaishiNo1());
        } else if (自動連番_MCD10付番.equals(被保険者番号付番方法)) {
            div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setValue(getJidoFubanKaishiNo2());
        } else {
            div.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo().setValue(RString.EMPTY);
        }
    }

    private RString getJidoFubanKaishiNo1() {
        CountedItem countedItem = Saiban.get(SubGyomuCode.DBA介護資格, 被保険者番号自動採番);
        return new RString(String.valueOf(countedItem.next()));
    }

    private RString getJidoFubanKaishiNo2() {
        CountedItem countedItem = Saiban.get(SubGyomuCode.DBA介護資格, 被保険者番号自動MCD);
        return new RString(String.valueOf(countedItem.next()));
    }

    /**
     * 被保険者番号付番方法が値に設定します。
     */
    public void editFubanHoho() {
        RString 被保険者番号付番方法 = div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().getSelectedKey();
        RString 付番元情報 = div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().getSelectedKey();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        RStringBuilder 変更理由 = new RStringBuilder();
        変更理由.append(menuID);
        変更理由.append(new RString("を使用して更新"));
        BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_付番方法,
                div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().getSelectedKey(), 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
        if (カスタマイズ付番.equals(被保険者番号付番方法)) {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報,
                    div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().getSelectedKey(), 変更理由.toRString(),
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報,
                    未設定, 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)
                || カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_開始位置,
                    flexRString(div.getFubanHoho().getFubanMotoJoho().getTxtKaishiKetaIchi().getValue()), 変更理由.toRString(),
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_開始位置, new RString("00"),
                    変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)) {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_有効桁数,
                    flexRString(div.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu().getValue()), 変更理由.toRString(),
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_有効桁数,
                    new RString("00"), 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)
                || カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号_桁数,
                    flexRString(div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().getValue()), 変更理由.toRString(),
                    RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号_桁数,
                    flexRString(div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().getValue()), 変更理由.toRString(),
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号_桁数,
                    new RString("00"), 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号_桁数,
                    new RString("00"), 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)
                || カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            if (new Decimal(0).equals(div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().getValue())) {
                BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号,
                        RString.EMPTY, 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
            }
            if (new Decimal(0).equals(div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().getValue())) {
                BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号,
                        RString.EMPTY, 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
            }
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号,
                    div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode().getValue(), 変更理由.toRString(),
                    RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号,
                    div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode().getValue(), 変更理由.toRString(),
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号,
                    RString.EMPTY, 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号,
                    RString.EMPTY, 変更理由.toRString(), RString.EMPTY, RDate.getNowDate());
        }
    }

    private RString flexRString(Decimal decimal) {
        RString flexDecimal = new RString(decimal.toString());
        if (decimal.toString().length() < 2) {
            flexDecimal = new RString("0" + decimal.toString());
        }
        return flexDecimal;
    }
}
