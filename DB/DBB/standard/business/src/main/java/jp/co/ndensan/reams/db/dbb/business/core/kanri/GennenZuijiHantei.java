/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KanendoSaishutsuKanriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.SuitoSeiriTaishoNendo;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 現年随時判定のクラスです。
 */
public class GennenZuijiHantei {

    /**
     * 普通徴収の翌年度4月、5月について業務Configの設定内容に基づき現年随時か否か、減額更正の場合に、現年度扱いか、過年度扱いかを判定します。
     *
     * @param 月 月
     * @return 出納整理対象年度
     */
    public SuitoSeiriTaishoNendo get出納整理対象年度(Tsuki 月) {

        if (!Tsuki._4月.equals(月) && !Tsuki._5月.equals(月)) {
            return SuitoSeiriTaishoNendo.過年度_増額減額;
        }
        RString 調定年度 = BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課);
        KitsukiList kitsukiList = new FuchoKiUtil(new FlexibleYear(調定年度).minusYear(1)).get期月リスト();
        Kitsuki kitsuki = kitsukiList.get月の期(月);
        if (kitsuki.isPresent()) {
            return SuitoSeiriTaishoNendo.現年度_増額減額;
        } else {
            RString 歳出管理区分 = BusinessConfig.get(ConfigNameDBB.過年度_歳出管理区分, SubGyomuCode.DBB介護賦課);
            if (KanendoSaishutsuKanriKubun.管理する.getコード().equals(歳出管理区分)) {
                return SuitoSeiriTaishoNendo.現年度_減額のみ;
            }

            if (KanendoSaishutsuKanriKubun.管理しない.getコード().equals(歳出管理区分)) {
                return SuitoSeiriTaishoNendo.過年度_増額減額;
            }
        }
        return SuitoSeiriTaishoNendo.過年度_増額減額;
    }
}
