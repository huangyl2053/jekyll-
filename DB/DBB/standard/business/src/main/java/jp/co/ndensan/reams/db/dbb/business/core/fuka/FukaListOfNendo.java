/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 *
 * 年度分賦課リストクラスです。
 */
public class FukaListOfNendo {

    private final List<Fuka> fukaList;

    /**
     * コンストラクタです。
     *
     * @param fukaList List<Fuka>
     */
    public FukaListOfNendo(List<Fuka> fukaList) {
        requireNonNull(fukaList, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課の情報"));
        this.fukaList = fukaList;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear getFukaNendo() {
        return fukaList.get(0).get賦課年度();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo getTuchisyoNo() {
        return fukaList.get(0).get通知書番号();
    }

    /**
     * 賦課期日を返します。
     *
     * @return 賦課期日
     */
    public FlexibleDate getFukaYMD() {
        return fukaList.get(0).get賦課期日();
    }

    /**
     * has過年度賦課を返します。
     *
     * @return has過年度賦課
     */
    public boolean hasKanendoFuka() {
        for (Fuka fuka : fukaList) {
            if (fuka.get賦課年度().isBefore(fuka.get調定年度())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 最新の賦課を返します。
     *
     * @return 最新の賦課
     */
    public Fuka getSaishinFuka() {
        Fuka fuka = fukaList.get(0);
        FlexibleYear 調定年度 = fuka.get調定年度();
        for (int i = 0; i < fukaList.size(); i++) {
            if (調定年度.isBefore(fukaList.get(i).get調定年度())) {
                fuka = fukaList.get(i);
                調定年度 = fuka.get調定年度();
            }
        }
        return fuka;
    }

    /**
     * getBy調定年度を返します。
     *
     * @param 調定年度 FlexibleYear
     * @return 賦課情報
     */
    public Fuka getByCyoteiNendo(FlexibleYear 調定年度) {
        for (Fuka fuka : fukaList) {
            if (fuka.get調定年度().equals(調定年度)) {
                return fuka;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage()
                .replace(調定年度.toString() + "調定年度の賦課の情報").evaluate());
    }

    /**
     * 現年度の賦課の情報を返します。
     *
     * @return 現年度の賦課の情報、賦課年度＝調定年度の賦課の情報が存在しない場合、nullを返却します。
     */
    public Fuka getGenNendo() {
        for (Fuka fuka : fukaList) {
            if (fuka.get調定年度().equals(fuka.get賦課年度())) {
                return fuka;
            }
        }
        return null;
    }

    /**
     * has調定年度を返します。
     *
     * @param 調定年度 調定年度
     * @return has調定年度
     */
    public boolean hasCyoteiNendo(FlexibleYear 調定年度) {
        for (Fuka fuka : fukaList) {
            if (fuka.get調定年度().equals(調定年度)) {
                return true;
            }
        }
        return false;
    }
}
