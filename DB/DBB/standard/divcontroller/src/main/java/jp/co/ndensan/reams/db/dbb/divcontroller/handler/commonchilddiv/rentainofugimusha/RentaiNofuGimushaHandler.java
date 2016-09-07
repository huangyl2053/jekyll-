/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.commonchilddiv.rentainofugimusha;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.rentainofugimusha.RentaiNofuGimusha.RentaiNofuGimushaDiv;
import jp.co.ndensan.reams.db.dbb.service.core.basic.RentaiGimushaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連帯納付義務者Divの操作を行うクラスです。
 *
 * @reamsid_L DBB-5700-010 chenaoqi
 */
public class RentaiNofuGimushaHandler {

    private final RentaiNofuGimushaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 連帯納付義務者Div
     */
    public RentaiNofuGimushaHandler(RentaiNofuGimushaDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divの初期化を行います。
     *
     * @param 被保険者番号 被保険者番号
     * @throws ApplicationException 連帯納付義務者情報が見つからない場合
     */
    public void initialize(HihokenshaNo 被保険者番号) throws ApplicationException {
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtKaishiYMD().clearValue();
        div.getTxtSyuryoYMD().clearValue();

        RentaiGimushaManager manager = new RentaiGimushaManager();
        RentaiGimusha 連帯義務者 = manager.get最新連帯納付義務者(被保険者番号);
        if (連帯義務者 == null) {
            div.getTxtShikibetsuCode().clearValue();
            div.getTxtShimei().clearValue();
            div.getTxtKaishiYMD().clearValue();
            div.getTxtSyuryoYMD().clearValue();
        } else {
            div.getTxtShikibetsuCode().setValue(連帯義務者.get識別コード().value());
            div.getTxtShimei().setValue(get氏名(連帯義務者.get識別コード()));
            div.getTxtKaishiYMD().setValue(new RDate(連帯義務者.get開始年月日().toString()));
            div.getTxtSyuryoYMD().setValue(new RDate(連帯義務者.get終了年月日().toString()));
        }
    }

    private RString get氏名(ShikibetsuCode 識別コード) {
        IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先);
        IShikibetsuTaishoSearchKey searchKey = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true).set識別コード(識別コード).build();
        List<IKojin> kojinList = ShikibetsuTaishoService.getKojinFinder().get個人s(searchKey);
        if (kojinList.get(0).is日本人()) {
            return kojinList.get(0).get日本人氏名().getName().value();
        } else if (kojinList.get(0).is外国人()) {
            return kojinList.get(0).get外国人氏名().getName().value();
        } else {
            return RString.EMPTY;
        }
    }

}
