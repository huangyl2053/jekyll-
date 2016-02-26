/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0030001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0030001.FukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 特徴仮算定賦課確定のHandlerクラスです。
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
                setDomain(new FlexibleYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課).toString()));
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
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            if (特徴仮算定賦課確定の基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(特別徴収仮算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(特徴仮算定賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(特徴仮算定賦課確定);
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
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            if (普徴仮算定賦課確定の基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(普通徴収仮算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(普徴仮算定賦課の最大基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(DataPassingConverter.serialize(普徴仮算定賦課確定));
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
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            if (仮算定異動賦課確定の最大基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(仮算定異動賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(仮算定異動賦課の基準日.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(DataPassingConverter.serialize(仮算定異動賦課確定));
                return true;
            } else if (仮算定異動賦課の基準日.isBeforeOrEquals(仮算定異動賦課確定の最大基準日時)) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(仮算定異動賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(仮算定異動賦課の基準日.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(DataPassingConverter.serialize(仮算定異動賦課確定));
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
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            if (本算定賦課確定の基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(本算定賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(DataPassingConverter.serialize(本算定賦課確定));
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
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            if (異動賦課確定の最大基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(異動賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(DataPassingConverter.serialize(異動賦課確定));
                return true;
            } else if (異動賦課確定の最大基準日時.isBeforeOrEquals(異動賦課の基準日時)) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(異動賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(DataPassingConverter.serialize(異動賦課確定));
                return true;
            } else if (異動賦課の基準日時.isBefore(異動賦課確定の最大基準日時)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
            }
        }
        return false;
    }
}
