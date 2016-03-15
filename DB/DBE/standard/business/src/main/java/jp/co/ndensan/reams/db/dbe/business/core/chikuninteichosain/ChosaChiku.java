/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChosaChikuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査地区情報を管理するクラスです。
 */
public class ChosaChiku {

    private final ChosaChikuEntity chosaChikuEntity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChosaChikuEntity}より{@link ChosaChiku}を生成します。
     *
     * @param chosaChikuEntity DBより取得した{@link ChosaChikuEntity}
     */
    public ChosaChiku(ChosaChikuEntity chosaChikuEntity) {
        this.chosaChikuEntity = chosaChikuEntity;
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public RString get調査地区コード() {
        return chosaChikuEntity.getChosaChikuCode();
    }

    /**
     * 調査地区名称を返します。
     *
     * @return 調査地区名称
     */
    public RString get調査地区名称() {
        return chosaChikuEntity.getChosaChikuName();
    }

    /**
     * 調査地区コード設定する。
     *
     * @param ChosaChikuCode 調査地区コード
     */
    public void set調査地区コード(RString ChosaChikuCode) {
        chosaChikuEntity.setChosaChikuCode(ChosaChikuCode);
    }

    /**
     * 調査地区名称設定する。
     *
     * @param ChosaChikuName 調査地区名称
     */
    public void set調査地区名称(RString ChosaChikuName) {
        chosaChikuEntity.setChosaChikuName(ChosaChikuName);
    }
}
