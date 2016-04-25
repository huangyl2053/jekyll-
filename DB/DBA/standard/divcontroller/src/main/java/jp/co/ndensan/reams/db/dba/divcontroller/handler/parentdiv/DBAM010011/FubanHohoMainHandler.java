/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBAM010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011.FubanHohoMainDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
        div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().setSelectedKey(BusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_付番方法, SubGyomuCode.DBA介護資格));
        div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().setSelectedKey(BusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報, SubGyomuCode.DBA介護資格));
        RString 開始位置 = BusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_開始位置, SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getFubanMotoJoho().getTxtKaishiKetaIchi().setValue(開始位置.isNullOrEmpty() ? Decimal.ZERO : new Decimal(開始位置.toString()));
        RString 有効桁数 = BusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_有効桁数, SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu().setValue(有効桁数.isNullOrEmpty() ? Decimal.ZERO : new Decimal(有効桁数.toString()));
        RString 前付加桁数 = BusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号_桁数, SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().setValue(前付加桁数.isNullOrEmpty() ? Decimal.ZERO : new Decimal(前付加桁数.toString()));
        div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode().setValue(BusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号, SubGyomuCode.DBA介護資格));
        RString 後付加桁数 = BusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号_桁数, SubGyomuCode.DBA介護資格);
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().setValue(後付加桁数.isNullOrEmpty() ? Decimal.ZERO : new Decimal(後付加桁数.toString()));
        div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode().setValue(BusinessConfig.get(
                ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号, SubGyomuCode.DBA介護資格));
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
        BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_付番方法,
                div.getFubanHoho().getDdlHihokenshaBangoFubanHoho().getSelectedKey(), RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        if (カスタマイズ付番.equals(被保険者番号付番方法)) {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報,
                    div.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho().getSelectedKey(), RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報,
                    未設定, RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)
                || カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_開始位置,
                    flexRString(div.getFubanHoho().getFubanMotoJoho().getTxtKaishiKetaIchi().getValue()), RString.EMPTY,
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_開始位置, new RString("00"),
                    RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)) {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_有効桁数,
                    flexRString(div.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu().getValue()), RString.EMPTY,
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_付番元情報_有効桁数,
                    new RString("00"), RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)
                || カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号_桁数,
                    flexRString(div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().getValue()), RString.EMPTY,
                    RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号_桁数,
                    flexRString(div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().getValue()), RString.EMPTY,
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号_桁数,
                    new RString("00"), RString.EMPTY, RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号_桁数,
                    new RString("00"), RString.EMPTY, RString.EMPTY, RDate.getNowDate());
        }
        if (カスタマイズ付番.equals(被保険者番号付番方法) && 住民コード.equals(付番元情報)
                || カスタマイズ付番.equals(被保険者番号付番方法) && 自動連番付番.equals(付番元情報)) {
            if (new Decimal(0).equals(div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu().getValue())) {
                BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RDate.getNowDate());
            }
            if (new Decimal(0).equals(div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu().getValue())) {
                BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RDate.getNowDate());
            }
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号,
                    div.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode().getValue(), RString.EMPTY,
                    RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号,
                    div.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode().getValue(), RString.EMPTY,
                    RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_前付与番号,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(SubGyomuCode.DBA介護資格, ConfigNameDBA.被保険者番号付番方法_カスタマイズ付番_後付与番号,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RDate.getNowDate());
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
