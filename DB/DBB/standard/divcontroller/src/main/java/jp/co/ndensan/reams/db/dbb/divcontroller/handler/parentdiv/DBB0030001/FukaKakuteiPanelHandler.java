/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0030001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0030001.FukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.service.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiManager;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 特徴仮算定賦課確定のHandlerクラスです。
 */
public class FukaKakuteiPanelHandler {

    private final FukaKakuteiDiv div;
    private static final RString 特徴仮算定賦課 = new RString("特徴仮算定賦課");
    private static final RString 普徴仮算定賦課 = new RString("普徴仮算定賦課");
    private static final RString 仮算定異動賦課 = new RString("仮算定異動賦課");
    private static final RString 本算定賦課 = new RString("本算定賦課");
    private static final RString 異動賦課 = new RString("異動賦課");
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
     *
     * @param fukaKakuteiManager TokuchoKarisanteiFukaKakuteiManager
     */
    public void initialize(TokuchoKarisanteiFukaKakuteiManager fukaKakuteiManager) {

        div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().setDomain(new FlexibleYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課).toString()));
        処理名_特徴仮算定賦課(fukaKakuteiManager);
        処理名_普徴仮算定賦課(fukaKakuteiManager);
        処理名_仮算定異動賦課(fukaKakuteiManager);
        処理名_本算定賦課(fukaKakuteiManager);
        処理名_異動賦課(fukaKakuteiManager);

    }

    private void 処理名_特徴仮算定賦課(TokuchoKarisanteiFukaKakuteiManager fukaKakuteiManager) {

        FlexibleDate 特徴仮算定賦課の基準日時 = fukaKakuteiManager
                .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 特徴仮算定賦課);
        if (特徴仮算定賦課の基準日時 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            FlexibleDate 特徴仮算定賦課確定の基準日時 = fukaKakuteiManager
                    .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 特徴仮算定賦課確定);
            if (特徴仮算定賦課確定の基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(特別徴収仮算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(特徴仮算定賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(特徴仮算定賦課確定);
            } else {
            }
        }
    }

    private void 処理名_普徴仮算定賦課(TokuchoKarisanteiFukaKakuteiManager fukaKakuteiManager) {
        FlexibleDate 普徴仮算定賦課の最大基準日時 = fukaKakuteiManager
                .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 普徴仮算定賦課);
        if (普徴仮算定賦課の最大基準日時 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            FlexibleDate 普徴仮算定賦課確定の基準日時 = fukaKakuteiManager
                    .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 普徴仮算定賦課確定);
            if (普徴仮算定賦課確定の基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(普通徴収仮算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(普徴仮算定賦課の最大基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(普徴仮算定賦課確定);
            } else {
            }
        }
    }

    private void 処理名_仮算定異動賦課(TokuchoKarisanteiFukaKakuteiManager fukaKakuteiManager) {
        FlexibleDate 仮算定異動賦課の基準日 = fukaKakuteiManager
                .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 仮算定異動賦課);
        if (仮算定異動賦課の基準日 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            FlexibleDate 仮算定異動賦課確定の最大基準日時 = fukaKakuteiManager
                    .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 仮算定異動賦課確定);
            if (仮算定異動賦課確定の最大基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(仮算定異動賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(仮算定異動賦課の基準日.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(仮算定異動賦課確定);
            } else if (仮算定異動賦課の基準日.isBeforeOrEquals(仮算定異動賦課確定の最大基準日時)) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(仮算定異動賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(仮算定異動賦課の基準日.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(仮算定異動賦課確定);
            }
        }
    }

    private void 処理名_本算定賦課(TokuchoKarisanteiFukaKakuteiManager fukaKakuteiManager) {
        FlexibleDate 本算定賦課の基準日時 = fukaKakuteiManager
                .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 本算定賦課);
        if (本算定賦課の基準日時 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            FlexibleDate 本算定賦課確定の基準日時 = fukaKakuteiManager
                    .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 本算定賦課確定);
            if (本算定賦課確定の基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定賦課処理の結果を確定します);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(本算定賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(本算定賦課確定);
            } else {
            }
        }

    }

    private void 処理名_異動賦課(TokuchoKarisanteiFukaKakuteiManager fukaKakuteiManager) {
        FlexibleDate 異動賦課の基準日時 = fukaKakuteiManager
                .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 異動賦課);
        if (異動賦課の基準日時 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
        } else {
            FlexibleDate 異動賦課確定の最大基準日時 = fukaKakuteiManager
                    .getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 異動賦課確定);
            if (異動賦課確定の最大基準日時 == null) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(異動賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(異動賦課確定);
            } else if (異動賦課確定の最大基準日時.isBeforeOrEquals(異動賦課の基準日時)) {
                div.getFukaKakuteiBatchParameter().getLblFukaKeisanKakuteiMsg().setText(本算定);
                div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().
                        setValue(new RString(異動賦課の基準日時.toString()));
                div.getFukaKakuteiBatchParameter().set処理名(異動賦課確定);
            } else if (異動賦課確定の最大基準日時.isBefore(異動賦課の基準日時)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("確定処理").evaluate());
            }
        }
    }
}
