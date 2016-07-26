package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IChosaKekkaInfoGaikyoDiv extends ICommonChildDivBaseProperties {

    void onLoad(List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList, List<RembanServiceJokyoBusiness> serviceJokyos,
            List<NinteichosahyoShisetsuRiyo> shisetsuRiyos, RString path);
}
