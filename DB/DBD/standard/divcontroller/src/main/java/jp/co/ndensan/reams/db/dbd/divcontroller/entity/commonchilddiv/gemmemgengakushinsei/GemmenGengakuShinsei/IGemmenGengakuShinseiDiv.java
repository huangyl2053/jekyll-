package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei;

import jp.co.ndensan.reams.db.dbd.business.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IGemmenGengakuShinseiDiv extends ICommonChildDivBaseProperties {

    void initialize(ShikibetsuCode 本人識別コード);

    ShikibetsuCode get本人識別コード();

    void set減免減額申請情報(ShinseiJoho 減免減額申請情報, FlexibleDate 申請日);

    ShinseiJoho get減免減額申請情報();

}
