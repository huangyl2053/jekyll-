/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
//import jp.co.ndensan.reams.ur.urz.business.AtenaSearchKeyBuilder;
//import jp.co.ndensan.reams.ur.urz.business.IAtenaSearchKey;
//import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * AtenaShokaiSimpleクラスを利用するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class AtenaShokaiSimpleAdapter {

    /**
     * デモ用のデータを設定します。
     *
     * @param div KaigoAtenaInfoDiv
     * @param 識別コード 識別コード
     * @deprecated プロダクトとしては絶対に使わないので、削除します。
     */
    @Deprecated
    public static void setDemoData(KaigoAtenaInfoDiv div, ShikibetsuCode 識別コード) {
//        AtenaShokaiSimple.setData(div.getAtenaInfo(), 識別コード);
    }

//TODO n3327 三浦凌 AtenaShokaiSimpleを簡単に使うための介護用ユーティリティを作る。このクラスを拡張で実現するかどうかも含めて検討する。
//   例えば以下のようなメソッドを設ける。
//    public static void load(KaigoAtenaInfoDiv div, ShikibetsuCode 識別コード){
//        IAtenaSearchKey key = new AtenaSearchKeyBuilder(KensakuYusenKubun.住登内優先, null).build();
//        div.getAtenaInfo().load(key);
//    }
}
