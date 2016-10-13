package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 毎年度の収納情報です。
 *
 * @reamsid_L DBD-3630-050 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoNendoEntity {

    private List<ShunoKibetsuEntity> 期別情報;
    private FlexibleYear 賦課年度;
    private boolean 過年度フラグ;
}
