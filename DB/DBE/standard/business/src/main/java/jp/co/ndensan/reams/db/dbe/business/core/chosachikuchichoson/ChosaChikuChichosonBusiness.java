/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachikuchichoson.ChosaChikuChichosonRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査地区市町村情報ビジネスクラスです。
 */
public class ChosaChikuChichosonBusiness {

    private final ChosaChikuChichosonRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 調査地区市町村情報のEntity
     */
    public ChosaChikuChichosonBusiness(ChosaChikuChichosonRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 優先番号を取得します。
     *
     * @return 優先番号
     */
    public int get優先番号() {
        return entity.getYusenNo();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 自地区フラグを取得します。
     *
     * @return 自地区フラグ
     */
    public boolean is自地区フラグ() {
        return entity.isJiChikuFlag();
    }

    /**
     * 市町村名を取得します。
     *
     * @return 市町村名
     */
    public RString get市町村名() {
        return entity.getShichosonMeisho();
    }
}
