/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.sougoujigyohijouhou;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sougoujigyohijouhou.SougouJigyoHiJouhouEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(総合事業費情報)のBusinessクラスです。
 *
 * @reamsid_L DBC-3107-010 wanghuafeng
 */
public class SougouJigyoHiJouhouBusiness {

    private final SougouJigyoHiJouhouEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 総合事業費情報Entity
     */
    public SougouJigyoHiJouhouBusiness(SougouJigyoHiJouhouEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public RString getサービス種類コード() {
        return entity.getサービス種類コード();
    }

    /**
     * サービス種類名称を取得します。
     *
     * @return サービス種類名称
     */
    public RString getサービス種類名称() {
        return entity.getサービス種類名称();
    }

    /**
     * サービス種類コード_最新を取得します。
     *
     * @return サービス種類コード_最新
     */
    public RString getサービス種類コード_最新() {
        return entity.getサービス種類コード_最新();
    }
}
