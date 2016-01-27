/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9020001;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho.ShujiiMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiMasterDiv;

/**
 * 主治医マスタ画面のハンドラークラスです。
 *
 */
public class ShujiiMasterHandler {

    private final ShujiiMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医マスタDiv
     */
    public ShujiiMasterHandler(ShujiiMasterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void load() {

    }

    /**
     * 検索条件入力項目をクリアします。
     */
    public void clearKensakuJoken() {
        div.getDdlSearchShichoson().setSelectedIndex(0);
        div.getTxtSearchShujiiIryokikanCodeFrom().clearValue();
        div.getTxtSearchShujiiIryokikanCodeTo().clearValue();
        div.getTxtSearchShujiiIryokikanMeisho().clearValue();
        div.getTxtSearchShujiiIryokikanKanaMeisho().clearValue();
        div.getTxtSearchShujiiCodeFrom().clearValue();
        div.getTxtSearchShujiiCodeTo().clearValue();
        div.getTxtSearchShujiiShimei().clearValue();
        div.getTxtSearchShujiiKanaShimei().clearValue();
        div.getRadSearchJokyoFlag().setSelectedIndex(0);

    }

    /**
     * 検索処理です。
     *
     * @param param 主治医マスタ用パラメータ
     */
    public void btnSearchShujii(ShujiiMasterMapperParameter param) {

    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void btnInsert() {

    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void btnUpdate() {

    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
    }

}
