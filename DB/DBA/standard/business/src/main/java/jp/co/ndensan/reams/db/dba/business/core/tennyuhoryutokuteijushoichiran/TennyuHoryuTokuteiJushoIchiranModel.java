/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tennyuhoryutokuteijushoichiran;

import jp.co.ndensan.reams.db.dba.entity.db.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiJushoIchiranEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 転入保留特定住所登録の取得するクラスです。
 */
public class TennyuHoryuTokuteiJushoIchiranModel {

    private final TennyuHoryuTokuteiJushoIchiranEntity entity;

    /**
     * コンストラクタです。<br/>
     * 転入保留特定住所登録の新規作成時に使用します。
     *
     * @param entity TennyuHoryuTokuteiJushoIchiranEntity
     */
    public TennyuHoryuTokuteiJushoIchiranModel(TennyuHoryuTokuteiJushoIchiranEntity entity) {
        this.entity = entity;
    }

    /**
     * 管理番号を返します。
     *
     * @return 管理番号
     */
    public RString get管理番号() {
        return entity.getKanriNo();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 住所コードを返します。
     *
     * @return 住所コード
     */
    public ChoikiCode get住所コード() {
        return entity.getJushoCode();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 番地コード1を返します。
     *
     * @return 番地コード1
     */
    public BanchiCode get番地コード1() {
        return entity.getBanchiCode1();
    }

    /**
     * 番地コード2を返します。
     *
     * @return 番地コード2
     */
    public BanchiCode get番地コード2() {
        return entity.getBanchiCode2();
    }

    /**
     * 番地コード3を返します。
     *
     * @return 番地コード3
     */
    public BanchiCode get番地コード3() {
        return entity.getBanchiCode3();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public AtenaBanchi get番地() {
        return entity.getBanchi();
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public RString get施設種類() {
        return entity.getShisetsuShurui();
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return entity.getShisetsuCode();
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称
     */
    public AtenaMeisho get施設名称() {
        return entity.getJigyoshaName();
    }
}
