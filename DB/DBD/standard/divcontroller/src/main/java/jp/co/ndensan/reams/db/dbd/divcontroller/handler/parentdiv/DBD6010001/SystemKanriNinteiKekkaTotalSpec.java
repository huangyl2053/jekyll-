/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBDCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * システム管理登録（認定結果通知書文言変更）画面のチェックロジックです。
 *
 * @reamsid_L DBD-3760-010 tz_chengpeng
 */
public enum SystemKanriNinteiKekkaTotalSpec implements IPredicate<SystemKanriNinteiKekkaTotalDiv> {

    /**
     * 付加情報1_データ更新チェック
     */
    付加情報_データ更新チェック {
                @Override
                public boolean apply(SystemKanriNinteiKekkaTotalDiv div) {
                    /**
                     * 付加情報1_データ
                     */
                    RString 付加情報1_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho1().getValue();
                    /**
                     * 付加情報2_データ
                     */
                    RString 付加情報2_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho2().getValue();
                    /**
                     * 付加情報3_データ
                     */
                    RString 付加情報3_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho3().getValue();
                    /**
                     * 付加情報4_データ
                     */
                    RString 付加情報4_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho4().getValue();
                    /**
                     * 付加情報5_データ
                     */
                    RString 付加情報5_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho5().getValue();
                    /**
                     * 付加情報6_データ
                     */
                    RString 付加情報6_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho6().getValue();
                    /**
                     * 付加情報7_データ
                     */
                    RString 付加情報7_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho7().getValue();
                    /**
                     * 付加情報8_データ
                     */
                    RString 付加情報8_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho8().getValue();
                    /**
                     * 付加情報9_データ
                     */
                    RString 付加情報9_データ = div.getSystemKanri().getSystemKanriNinteiKekka()
                    .getTxtFukaJoho9().getValue();

                    return !付加情報1_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("01")), FlexibleDate.getNowDate())) || !付加情報2_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("02")), FlexibleDate.getNowDate())) || !付加情報3_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("12")), FlexibleDate.getNowDate())) || !付加情報4_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("13")), FlexibleDate.getNowDate())) || !付加情報5_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("21")), FlexibleDate.getNowDate())) || !付加情報6_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("22")), FlexibleDate.getNowDate())) || !付加情報7_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("23")), FlexibleDate.getNowDate())) || !付加情報8_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("24")), FlexibleDate.getNowDate())) || !付加情報9_データ.equals(CodeMaster.getCodeMeisho(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.結果通知理由.getコード(),
                                    new Code(new RString("25")), FlexibleDate.getNowDate()));
                }
            },
}
