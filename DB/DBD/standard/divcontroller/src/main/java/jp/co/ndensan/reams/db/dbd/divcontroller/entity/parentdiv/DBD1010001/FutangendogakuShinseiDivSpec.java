/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutangendogakuNinteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author liangbc
 */
public enum FutangendogakuShinseiDivSpec implements IPredicate<FutangendogakuShinseiDiv> {

    受給共通_受給者登録なし {
                /**
                 * 受給共通_受給者登録なしチェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:受給者登録ありの場合です、false:受給者登録なしの場合です。
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {
                    return FutangendogakuNinteiService.createInstance().canBe利用者(
                            new HihokenshaNo(div.getHihokenshaNo()), FlexibleDate.getNowDate());
                }
            },
    変更有無チェック {
                /**
                 * 変更有無チェックです。
                 *
                 * @param div TaishouWaritsukeDiv
                 * @return true:変更あり、false:変更なし。
                 */
                @Override
                public boolean apply(FutangendogakuShinseiDiv div) {
                    boolean is変更あり = false;
                    List<dgShinseiList_Row> list = div.getDgShinseiList().getDataSource();
                    for (dgShinseiList_Row row : list) {
                        if (!row.getJotai().isEmpty()) {
                            is変更あり = true;
                            break;
                        }
                    }
                    return is変更あり;
                }
            };

}
