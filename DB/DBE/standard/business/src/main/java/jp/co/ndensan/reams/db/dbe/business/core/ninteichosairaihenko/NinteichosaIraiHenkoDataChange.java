/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaihenko;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairaihenko.NinteichosaIraiHenkoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼先変更者のデータを変更のメソッドです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
public final class NinteichosaIraiHenkoDataChange {

    private static NinteichosaIraiHenkoData data;
    private static int indexTmp;
    private static int index;

    private NinteichosaIraiHenkoDataChange() {
    }

    /**
     * 認定調査依頼先変更者のパラメータを作成します。
     *
     * @param before 認定調査依頼先変更者のRelateEntity
     * @param nowEntity 認定調査依頼先変更者のRelateEntity
     * @param count 条数
     * @return 認定調査依頼先変更者
     */
    public static NinteichosaIraiHenkoData createEdit(NinteichosaIraiHenkoRelateEntity before, NinteichosaIraiHenkoRelateEntity nowEntity,
            int count) {
        if (before == null) {
            return null;
        }
        index++;
        if (before.getShinseishoKanriNo().equals(nowEntity.getShinseishoKanriNo())) {
            if (nowEntity.getNinteichosaIraiRirekiNo() > 1) {
                indexTmp++;
                data = new NinteichosaIraiHenkoData(nowEntity.getShinseishoKanriNo().value(),
                        nowEntity.getHihokenshaNo(),
                        nowEntity.getHihokenshaKana(),
                        nowEntity.getHihokenshaName(),
                        nowEntity.getSeibetsu(),
                        nowEntity.getSeinengappiYMD(),
                        nowEntity.getNinteiShinseiShinseijiKubunCode(),
                        nowEntity.getNinteiShinseiYMD(),
                        nowEntity.getShichosonMeisho(),
                        nowEntity.getNinteichosaIraiYMD(),
                        before.getJigyoshaMeisho(),
                        before.getChosainShimei(),
                        nowEntity.getJigyoshaMeisho(),
                        nowEntity.getChosainShimei(),
                        new RString(indexTmp));
            }
            if (index == count && indexTmp > 0) {
                indexTmp = 0;
                return data;
            }
        } else {
            if (indexTmp > 0) {
                indexTmp = 0;
                return data;
            }
        }
        return null;
    }

}
