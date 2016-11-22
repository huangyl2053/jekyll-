/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0030001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0030001.FukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 *
 * 特徴仮算定賦課確定のHandlerクラスです。
 *
 * @reamsid_L DBB-0800-010 wanghui
 */
public class FukaKakuteiPanelHandler {

    private final FukaKakuteiDiv div;
    private static final RString 特徴仮算定賦課確定 = new RString("特徴仮算定賦課確定");
    private static final RString 普徴仮算定賦課確定 = new RString("普徴仮算定賦課確定");
    private static final RString 仮算定異動賦課確定 = new RString("仮算定異動賦課確定");
    private static final RString 本算定賦課確定 = new RString("本算定賦課確定");
    private static final RString 異動賦課確定 = new RString("異動賦課確定");
    private static final RString 特別徴収仮算定賦課処理の結果を確定します = new RString("特別徴収仮算定賦課処理の結果を確定します。");
    private static final RString 普通徴収仮算定賦課処理の結果を確定します = new RString("普通徴収仮算定賦課処理の結果を確定します。");
    private static final RString 仮算定異動賦課処理の結果を確定します = new RString("仮算定異動賦課処理の結果を確定します。");
    private static final RString 本算定賦課処理の結果を確定します = new RString("本算定賦課処理の結果を確定します。");
    private static final RString 本算定 = new RString("本算定異動（現年度）賦課処理の結果を確定します。");
    private static final RString 確定処理 = new RString("確定処理");
    private static final RString 共通ボタン = new RString("btnFukaKakutei");

    /**
     * コンストラクタ。
     *
     * @param div FukaKakuteiDiv
     */
    public FukaKakuteiPanelHandler(FukaKakuteiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     */
    public void 賦課年度の設定() {
        div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().
                setDomain(new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                                        RDate.getNowDate(), SubGyomuCode.DBB介護賦課
                                ).toString()));
    }

    /**
     * 特徴仮算定賦課確定の基準日時取得.
     *
     * @param 特徴仮算定賦課の基準日時 FlexibleDate
     * @param 特徴仮算定賦課確定の基準日時 FlexibleDate
     * @return boolean
     */
    public boolean 処理名_特徴仮算定賦課(YMDHMS 特徴仮算定賦課の基準日時, YMDHMS 特徴仮算定賦課確定の基準日時) {
        if (特徴仮算定賦課の基準日時 == null) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, true);
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((確定処理).toString()).evaluate());
        } else {
            if (特徴仮算定賦課確定の基準日時 == null) {
                RStringBuilder 日時 = new RStringBuilder();
                日時.append(特徴仮算定賦課の基準日時.getRDateTime().getDate().wareki().toDateString());
                日時.append(new RString(" "));
                日時.append(特徴仮算定賦課の基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(特別徴収仮算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(日時.toRString());
                div.getFukaKakuteiBatchParameter().set処理名(特徴仮算定賦課確定);
                div.getFukaKakuteiBatchParameter().set基準日時(new RString(特徴仮算定賦課の基準日時.toString()));
                CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
                return true;
            }
        }
        return false;
    }

    /**
     * 普徴仮算定賦課確定の基準日時取得.
     *
     * @param 普徴仮算定賦課の最大基準日時 FlexibleDate
     * @param 普徴仮算定賦課確定の基準日時 FlexibleDate
     * @return boolean
     */
    public boolean 処理名_普徴仮算定賦課(YMDHMS 普徴仮算定賦課の最大基準日時, YMDHMS 普徴仮算定賦課確定の基準日時) {
        if (普徴仮算定賦課の最大基準日時 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((確定処理).toString()).evaluate());
        } else {
            if (普徴仮算定賦課確定の基準日時 == null) {
                RStringBuilder 日時 = new RStringBuilder();
                日時.append(普徴仮算定賦課の最大基準日時.getRDateTime().getDate().wareki().toDateString());
                日時.append(new RString(" "));
                日時.append(普徴仮算定賦課の最大基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(普通徴収仮算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(日時.toRString());
                div.getFukaKakuteiBatchParameter().set処理名(普徴仮算定賦課確定);
                div.getFukaKakuteiBatchParameter().set基準日時(new RString(普徴仮算定賦課の最大基準日時.toString()));
                CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
                return true;
            }
        }
        return false;
    }

    /**
     * 仮算定異動賦課確定の基準日時取得.
     *
     * @param 仮算定異動賦課の基準日 FlexibleDate
     * @param 仮算定異動賦課確定の最大基準日時 FlexibleDate
     * @return boolean
     */
    public boolean 処理名_仮算定異動賦課(YMDHMS 仮算定異動賦課の基準日, YMDHMS 仮算定異動賦課確定の最大基準日時) {
        if (仮算定異動賦課の基準日 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((確定処理).toString()).evaluate());
        } else {
            if (仮算定異動賦課確定の最大基準日時 == null) {
                RStringBuilder 日時 = new RStringBuilder();
                日時.append(仮算定異動賦課の基準日.getRDateTime().getDate().wareki().toDateString());
                日時.append(new RString(" "));
                日時.append(仮算定異動賦課の基準日.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(仮算定異動賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(日時.toRString());
                div.getFukaKakuteiBatchParameter().set処理名(仮算定異動賦課確定);
                div.getFukaKakuteiBatchParameter().set基準日時(new RString(仮算定異動賦課の基準日.toString()));
                CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
                return true;
            } else if (仮算定異動賦課確定の最大基準日時.isBefore(仮算定異動賦課の基準日)) {
                RStringBuilder 日時 = new RStringBuilder();
                日時.append(仮算定異動賦課の基準日.getRDateTime().getDate().wareki().toDateString());
                日時.append(new RString(" "));
                日時.append(仮算定異動賦課の基準日.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(仮算定異動賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(日時.toRString());
                div.getFukaKakuteiBatchParameter().set処理名(仮算定異動賦課確定);
                div.getFukaKakuteiBatchParameter().set基準日時(new RString(仮算定異動賦課の基準日.toString()));
                CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
                return true;
            }
        }
        return false;
    }

    /**
     * 本算定賦課の基準日時取得.
     *
     * @param 本算定賦課の基準日時 FlexibleDate
     * @param 本算定賦課確定の基準日時 FlexibleDate
     * @return boolean
     */
    public boolean 処理名_本算定賦課(YMDHMS 本算定賦課の基準日時, YMDHMS 本算定賦課確定の基準日時) {
        if (本算定賦課の基準日時 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((確定処理).toString()).evaluate());
        } else {
            if (本算定賦課確定の基準日時 == null) {
                RStringBuilder 日時 = new RStringBuilder();
                日時.append(本算定賦課の基準日時.getRDateTime().getDate().wareki().toDateString());
                日時.append(new RString(" "));
                日時.append(本算定賦課の基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(日時.toRString());
                div.getFukaKakuteiBatchParameter().set処理名(本算定賦課確定);
                div.getFukaKakuteiBatchParameter().set基準日時(new RString(本算定賦課の基準日時.toString()));
                CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
                return true;
            }
        }
        return false;
    }

    /**
     * 異動賦課の基準日時取得.
     *
     * @param 異動賦課の基準日時 FlexibleDate
     * @param 異動賦課確定の最大基準日時 FlexibleDate
     * @return boolean
     */
    public boolean 処理名_異動賦課(YMDHMS 異動賦課の基準日時, YMDHMS 異動賦課確定の最大基準日時) {
        if (異動賦課の基準日時 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((確定処理).toString()).evaluate());
        } else {
            if (異動賦課確定の最大基準日時 == null) {
                RStringBuilder 日時 = new RStringBuilder();
                日時.append(異動賦課の基準日時.getRDateTime().getDate().wareki().toDateString());
                日時.append(new RString(" "));
                日時.append(異動賦課の基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(日時.toRString());
                div.getFukaKakuteiBatchParameter().set処理名(異動賦課確定);
                div.getFukaKakuteiBatchParameter().set基準日時(new RString(異動賦課の基準日時.toString()));
                CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
                return true;
            } else if (異動賦課確定の最大基準日時.isBefore(異動賦課の基準日時)) {
                RStringBuilder 日時 = new RStringBuilder();
                日時.append(異動賦課の基準日時.getRDateTime().getDate().wareki().toDateString());
                日時.append(new RString(" "));
                日時.append(異動賦課の基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(日時.toRString());
                div.getFukaKakuteiBatchParameter().set処理名(異動賦課確定);
                div.getFukaKakuteiBatchParameter().set基準日時(new RString(異動賦課の基準日時.toString()));
                CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
                return true;
            } else if (異動賦課の基準日時.isBeforeOrEquals(異動賦課確定の最大基準日時)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((確定処理).toString()).evaluate());
            }
        }
        return false;
    }
}
