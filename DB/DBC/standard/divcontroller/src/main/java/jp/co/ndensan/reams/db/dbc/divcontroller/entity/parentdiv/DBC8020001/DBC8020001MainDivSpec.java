/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001;

import jp.co.ndensan.reams.db.dbc.service.core.jigyogasanjigyobunmeisaishosakusei.DBC8020001MainManager;
import jp.co.ndensan.reams.ux.uxx.definition.mybatisprm.kozafurikomi.kozafurikomi.KozaFurikomiMapperParameter;
import jp.co.ndensan.reams.ux.uxx.service.core.kozafurikomi.kozafurikomi.KozaFurikomiManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 事業合算・事業分振込明細書作成（一括）のバリデーションクラスです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public enum DBC8020001MainDivSpec implements IPredicate<DBC8020001MainDiv> {

    /**
     * 委託者情報の取得チェック。
     */
    実行不可 {
                @Override
                public boolean apply(DBC8020001MainDiv div
                ) {
                    RString メニューID = ResponseHolder.getMenuID();
                    DBC8020001MainManager manager = new DBC8020001MainManager();
                    return manager.if存在(メニューID);
                }
            },
    /**
     * 振込指定日休日チェック。
     */
    振込指定日休日チェック {
                @Override
                public boolean apply(DBC8020001MainDiv div
                ) {
                    return !div.getTxtFurikomiShiteiYMD().getValue().isHoliday();
                }
            },
    /**
     * 振込指定日過去日チェック。
     */
    振込指定日過去日チェック {
                @Override
                public boolean apply(DBC8020001MainDiv div
                ) {
                    return !div.getTxtFurikomiShiteiYMD().getValue().isBefore(RDate.getNowDate());
                }
            },
    /**
     * 正・振込指定日休日チェック。
     */
    正振込指定日休日チェック {
                @Override
                public boolean apply(DBC8020001MainDiv div
                ) {
                    return !div.getTxtCorrectFurikomiShiteiYMD().getValue().isHoliday();
                }
            },
    /**
     * 正・振込指定日過去日チェック。
     */
    正振込指定日過去日チェック {
                @Override
                public boolean apply(DBC8020001MainDiv div
                ) {
                    return !div.getTxtCorrectFurikomiShiteiYMD().getValue().isBefore(RDate.getNowDate());
                }
            },
    /**
     * 再処理対象データ存在チェック。
     */
    再処理対象データ存在チェック {
                @Override
                public boolean apply(DBC8020001MainDiv div
                ) {
                    RString 委託者ID = div.getItakusha().getItakushaId();
                    div.getTxtFurikomiShiteiYMD().getValue();
                    KozaFurikomiMapperParameter parameter;
                    parameter = KozaFurikomiMapperParameter.createSelectParameter(new Decimal(委託者ID.toString()),
                            div.getTxtFurikomiShiteiYMD().getValue(), SubGyomuCode.DBC介護給付);
                    KozaFurikomiManager manager = KozaFurikomiManager.createInstance();
                    int size = manager.get口座振込リストBy検索条件(parameter).records().size();
                    return 0 != size;
                }
            },
    /**
     * 修正対象データ存在チェック。
     */
    修正対象データ存在チェック {
                @Override
                public boolean apply(DBC8020001MainDiv div
                ) {
                    RString 委託者ID = div.getItakusha().getItakushaId();
                    KozaFurikomiMapperParameter parameter;
                    parameter = KozaFurikomiMapperParameter.createSelectParameter(new Decimal(委託者ID.toString()),
                            div.getTxtWrongFurikomiShiteiYMD().getValue(), SubGyomuCode.DBC介護給付);
                    KozaFurikomiManager manager = KozaFurikomiManager.createInstance();
                    int size = manager.get口座振込リストBy検索条件(parameter).records().size();
                    return 0 != size;
                }
            }
}
