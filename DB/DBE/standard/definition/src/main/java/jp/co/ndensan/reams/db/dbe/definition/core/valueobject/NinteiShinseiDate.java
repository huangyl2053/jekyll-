/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 認定申請年月日を表すクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteiShinseiDate implements IDbColumnMappable, IValueObject<FlexibleDate> {

    private final FlexibleDate 認定申請年月日;

    /**
     * コンストラクタです。
     *
     * @param 認定申請年月日 認定申請年月日
     */
    public NinteiShinseiDate(FlexibleDate 認定申請年月日) {
        this.認定申請年月日 = requireNonNull(認定申請年月日,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定申請年月日", getClass().getName()));
    }

    @Override
    public FlexibleDate getColumnValue() {
        return 認定申請年月日;
    }

    @Override
    public FlexibleDate value() {
        return 認定申請年月日;
    }
}
