/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo;

import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.search.IAtenaSearchKey;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.search.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.shikibetsutaisho.enumeratedtype.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 介護宛名基本情報Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoAtenaInfoHandler {

    private final KaigoAtenaInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護宛名基本情報Div
     */
    public KaigoAtenaInfoHandler(KaigoAtenaInfoDiv div) {
        this.div = div;
    }

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 識別コード 識別コード
     */
    public void load(ShikibetsuCode 識別コード) {
        IAtesakiGyomuHanteiKey 業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険);
        IAtenaSearchKey 検索キー = new AtenaSearchKeyBuilder(KensakuYusenKubun.住登内優先, 業務判定キー)
                .set識別コード(識別コード)
                .build();
        div.getAtenaInfo().load(検索キー);
    }

    /**
     * 介護宛名資格モードに設定します。
     */
    public void set介護宛名資格モード() {
        // TODO N8156 宮本 康 外部からボタンの表示非表示を制御できるようになり次第対応する。（URに依頼済み）
        // 非表示にするボタン : 代納人、利用届出
    }

    /**
     * 介護宛名賦課モードに設定します。
     */
    public void set介護宛名賦課モード() {
        // TODO N8156 宮本 康 外部からボタンの表示非表示を制御できるようになり次第対応する。（URに依頼済み）
        // 非表示にするボタン : 利用届出
    }
}
