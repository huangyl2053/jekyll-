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
 *
 * @reamsid_L DBE-0020-020 lishengli
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
     * コンストラクタです。<br/>
     * DBより取得した{@link ChosaChikuEntity}より{@link ChosaChiku}を生成します。
     *
     */
    public ChosaChiku() {
        this.chosaChikuEntity = new ChosaChikuEntity();
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
     * @param chosaChikuCode 調査地区コード
     */
    public void set調査地区コード(RString chosaChikuCode) {
        chosaChikuEntity.setChosaChikuCode(chosaChikuCode);
    }

    /**
     * 調査地区名称設定する。
     *
     * @param chosaChikuName 調査地区名称
     */
    public void set調査地区名称(RString chosaChikuName) {
        chosaChikuEntity.setChosaChikuName(chosaChikuName);
    }
}
