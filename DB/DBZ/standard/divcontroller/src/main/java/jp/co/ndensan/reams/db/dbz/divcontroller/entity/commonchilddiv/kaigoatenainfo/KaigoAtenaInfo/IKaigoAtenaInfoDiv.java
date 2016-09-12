package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo;

import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.ShokaiDataDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-0030-011 liangbc
 */
public interface IKaigoAtenaInfoDiv extends ICommonChildDivBaseProperties {

    void initialize(ShikibetsuCode 識別コード);

    RString get氏名漢字();

    RString get氏名カナ();

    YubinNo get郵便番号();

    AtenaJusho get住所();

    ShokaiDataDiv getShokaiData();

    AtenaShokaiSimpleDiv getAtenaInfoDiv();
}
