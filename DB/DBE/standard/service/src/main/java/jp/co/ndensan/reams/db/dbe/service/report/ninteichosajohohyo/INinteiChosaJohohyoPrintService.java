/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosajohohyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査情報票のPrinterのインターフェースです。
 *
 * @author N3212 竹内 和紀
 */
public interface INinteiChosaJohohyoPrintService {

    /**
     * 認定調査情報票を印刷します。
     *
     * @param business YokaigoNinteiJohoTeikyoBusiness
     * @param イメージ共有ファイルID RDateTime
     * @param 認定調査票サービス状況List NinteichosahyoServiceJokyoのリスト
     * @param 認定調査票サービス状況フラグList NinteichosahyoServiceJokyoFlagのリスト
     * @param 認定調査票調査項目List NinteichosahyoChosaItemのリスト
     * @param 認定調査票記入項目List NinteichosahyoKinyuItemのリスト
     * @param 認定調査票マスキング区分 認定調査票マスキング区分
     */
    void print(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分);
}
