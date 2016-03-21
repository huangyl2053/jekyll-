/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakayijidouwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会自動割付を管理するクラスです。
 */
public class ShinsaKayiJidouWaritsukeBusiness {

    private final ShinsaKayiJidouWaritsukeRelateEntity entity;

    /**
     * 審査会自動割付項目を返します。
     *
     * @param entity ShinsaKayiJidouWaritsukeRelateEntity
     */
    public ShinsaKayiJidouWaritsukeBusiness(ShinsaKayiJidouWaritsukeRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 審査会開催番号を返します。
     *
     * @return 審査会開催番号
     */
    public RString get審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 審査会名称を返します。
     *
     * @return 審査会名称
     */
    public RString get審査会名称() {
        return entity.get審査会名称();
    }

    /**
     * 合議体名称を返します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.getGogitaiMei();
    }

    /**
     * 種類を返します。
     *
     * @return 種類
     */
    public boolean get種類() {
        return entity.isGogitaiSeishinkaSonzaiFlag();
    }

    /**
     * 審査会会場を返します。
     *
     * @return 審査会会場
     */
    public RString get審査会会場() {
        return entity.getShinsakaiKaisaiBashoName();
    }

    /**
     * 開催日を返します。
     *
     * @return 開催日
     */
    public RString get開催日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 開始時間を返します。
     *
     * @return 開始時間
     */
    public RString get開始時間() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * 終了時間を返します。
     *
     * @return 終了時間
     */
    public RString get終了時間() {
        return entity.getShinsakaiShuryoYoteiTime();
    }

    /**
     * 自動割付定員を返します。
     *
     * @return 自動割付定員
     */
    public RString get自動割付定員() {
        return entity.getShinsakaiJidoWariateTeiin();
    }

    /**
     * 割付人数を返します。
     *
     * @return 割付人数
     */
    public RString get割付人数() {
        return entity.getShinsakaiWariateZumiNinzu();
    }

    /**
     * 進捗状況を返します。
     *
     * @return 進捗状況
     */
    public RString get進捗状況() {
        return entity.getShinsakaiShinchokuJokyo();
    }

    /**
     * ダミーフラグを返します。
     *
     * @return ダミーフラグ
     */
    public boolean getダミーフラグ() {
        return entity.isGogitaiDummyFlag();
    }
}
