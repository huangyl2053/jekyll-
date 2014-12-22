/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKeyBuilder;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKeyBuilder;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.ur.urz.business.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ur.urz.business.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ur.urz.business.IAtenaSearchKey;
import jp.co.ndensan.reams.ur.urz.business.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 介護基本情報のDivを設定するクラスです。
 *
 * @author N8156 宮本 康
 */
public final class KaigoKihonAdapter {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoKihonAdapter() {
    }

    /**
     * 条件に該当する介護宛名基本情報をDivに設定します。
     *
     * @param div 介護宛名基本Div
     * @param 識別コード 識別コード
     */
    public static void set介護宛名基本(KaigoAtenaInfoDiv div, ShikibetsuCode 識別コード) {
        IAtesakiGyomuHanteiKey 業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険);
        IAtenaSearchKey 検索キー = new AtenaSearchKeyBuilder(KensakuYusenKubun.住登内優先, 業務判定キー)
                .set識別コード(識別コード)
                .build();
        div.getAtenaInfo().load(検索キー);
    }

    /**
     * 介護宛名基本Divを資格モードに設定します。
     *
     * @param div 介護宛名基本Div
     */
    public static void set介護宛名資格モード(KaigoAtenaInfoDiv div) {
        // TODO N8156 宮本 康 外部からボタンの表示非表示を制御できるようになり次第対応する。（URに依頼済み）
        // 非表示にするボタン : 代納人、利用届出
    }

    /**
     * 介護宛名基本Divを賦課モードに設定します。
     *
     * @param div 介護宛名基本Div
     */
    public static void set介護宛名賦課モード(KaigoAtenaInfoDiv div) {
        // TODO N8156 宮本 康 外部からボタンの表示非表示を制御できるようになり次第対応する。（URに依頼済み）
        // 非表示にするボタン : 利用届出
    }

    /**
     * 条件に該当する介護資格基本情報をDivに設定します。
     *
     * @param div 介護資格基本Div
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    public static void set介護資格基本(KaigoShikakuKihonDiv div, LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        div.load(new KaigoShikakuKihonSearchKeyBuilder(市町村コード, 識別コード).build());
    }

    /**
     * 条件に該当する資格特喪履歴情報をDivに設定します。
     *
     * @param div 資格特喪履歴情報Div
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    public static void set資格特喪履歴(ShikakuTokusoRirekiDiv div, LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        div.load(new KaigoShikakuKihonSearchKeyBuilder(市町村コード, 識別コード).build());
    }

    /**
     * 条件に該当する介護賦課基本情報をDivに設定します。
     *
     * @param div 介護賦課基本Div
     * @param 通知書番号 通知書番号
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    public static void set介護賦課基本(
            KaigoFukaKihonDiv div, TsuchishoNo 通知書番号, FlexibleYear 賦課年度, LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        div.load(new KaigoFukaKihonSearchKeyBuilder(通知書番号, 賦課年度, 市町村コード, 識別コード).build());
    }
}
