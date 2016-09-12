/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011.KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者訂正連絡票登録（対象者検索）のハンドラクラスです。
 *
 * @reamsid_L DBC-1951-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTaishoshaKensakuMainHandler {

    private final KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KyodoIdoRenrakuhyoTaishoshaKensakuMainHandler(KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     * @return ハンドラ
     */
    public static KyodoIdoRenrakuhyoTaishoshaKensakuMainHandler of(KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        return new KyodoIdoRenrakuhyoTaishoshaKensakuMainHandler(div);
    }

    /**
     * 初期化状態設定のメソッドです。
     */
    public void click条件をクリア() {
        div.getTxtSearchHihokenshaNo().clearValue();
        div.getTxtHihokenshaMei().clearDomain();
        div.getTxtSearchIdoYMD().clearFromValue();
        div.getTxtSearchIdoYMD().clearToValue();
        List<RString> keyList = new ArrayList<>();
        div.getChkSearchDeleteData().setSelectedItemsByKey(keyList);
    }

    /**
     * 被保険者名を設定のメソッドです。
     */
    public void set被保険者名() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtSearchHihokenshaNo().getValue());
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList();
        List<JuminJotai> 住民状態List = new ArrayList();
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        住民状態List.add(JuminJotai.住民);
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        builder.set住民種別(住民種別List);
        builder.set住民状態(住民状態List);
        builder.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        IShikibetsuTaisho 宛名情報 = KyodoJukyushaTaishoshaFinder.createInstance().get被保険者情報(searchKey, 被保険者番号);
        IName 名称 = 宛名情報.get名称();
        if (名称 == null) {
            div.getTxtHihokenshaMei().setDomain(AtenaMeisho.EMPTY);
        } else {
            div.getTxtHihokenshaMei().setDomain(名称.getName());
        }
    }
}
