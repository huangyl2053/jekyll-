/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001;

import jp.co.ndensan.reams.ux.uxx.definition.mybatisprm.kozafurikomi.kozafurikomi.KozaFurikomiMapperParameter;
import jp.co.ndensan.reams.ux.uxx.service.core.kozafurikomi.kozafurikomi.KozaFurikomiManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細・振込みデータ作成のバリデーションクラスです。
 *
 * @reamsid_L DBC-2180-010 x_liuwei
 */
public enum DBC8010001MainDivSpec implements IPredicate<DBC8010001MainDiv> {

    /**
     * 委託者情報の取得チェック。
     */
    実行不可 {
                @Override
                public boolean apply(DBC8010001MainDiv div) {
                    //TODO メソードFurikomiGroupItakushaItakushaKoseiFinder.getFurikomiGroupItakushItakushKosei利用できるなら、コメントを解除する。
//                    DBC8010001MainHandler handler = new DBC8010001MainHandler(div);
//                    List list = new ArrayList();
//                    List<FurikomiGroupItakushaRelateEntity> list = handler.getFurikomiGroupItakushaRelateEntity();
//                    return 0 != list.size();
                    return true;
                }
            },
    /**
     * 振込指定日休日チェック。
     */
    振込指定日休日チェック {
                @Override
                public boolean apply(DBC8010001MainDiv div) {
                    return !div.getTxtFurikomiShiteiYMD().getValue().isHoliday();
                }
            },
    /**
     * 振込指定日過去日チェック。
     */
    振込指定日過去日チェック {
                @Override
                public boolean apply(DBC8010001MainDiv div) {
                    return !div.getTxtFurikomiShiteiYMD().getValue().isBefore(RDate.getNowDate());
                }
            },
    /**
     * 正・振込指定日休日チェック。
     */
    正振込指定日休日チェック {
                @Override
                public boolean apply(DBC8010001MainDiv div) {
                    return !div.getTxtCorrectFurikomiShiteiYMD().getValue().isHoliday();
                }
            },
    /**
     * 正・振込指定日過去日チェック。
     */
    正振込指定日過去日チェック {
                @Override
                public boolean apply(DBC8010001MainDiv div) {
                    return !div.getTxtCorrectFurikomiShiteiYMD().getValue().isBefore(RDate.getNowDate());
                }
            },
    /**
     * 再処理対象データ存在チェック。
     */
    再処理対象データ存在チェック {
                @Override
                public boolean apply(DBC8010001MainDiv div) {
                    RString 委託者ID = div.getTxtItakushaCode().getValue();
                    div.getTxtFurikomiShiteiYMD().getValue();
                    KozaFurikomiMapperParameter parameter;
                    //TODO Code in the next line is incorrect,not final, need to be modified!
                    parameter = KozaFurikomiMapperParameter.createSelectParameter(0l, new Decimal(委託者ID.toString()), div.getTxtFurikomiShiteiYMD().getValue(), Decimal.ZERO, SubGyomuCode.DBC介護給付);
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
                public boolean apply(DBC8010001MainDiv div) {
                    RString 委託者ID = div.getTxtItakushaCode().getValue();
                    KozaFurikomiMapperParameter parameter;
                    //TODO Need to be sure!
                    parameter = KozaFurikomiMapperParameter.createSelectParameter(0l, new Decimal(委託者ID.toString()), div.getTxtWrongFurikomiShiteiYMD().getValue(), Decimal.ZERO, SubGyomuCode.DBC介護給付);
                    KozaFurikomiManager manager = KozaFurikomiManager.createInstance();
                    int size = manager.get口座振込リストBy検索条件(parameter).records().size();
                    return 0 != size;
                }
            }
}
