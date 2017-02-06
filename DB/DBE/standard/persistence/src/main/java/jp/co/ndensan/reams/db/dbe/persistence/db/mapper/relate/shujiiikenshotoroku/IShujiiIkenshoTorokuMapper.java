/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshotoroku;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshotoroku.ShujiiIkenshoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshotoroku.ShujiiIkenshoTorokuRelateEntity;

/**
 * 主治医意見書登録のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public interface IShujiiIkenshoTorokuMapper {

    /**
     * 主治医意見書登録画面初期を検索します。
     *
     * @param param 主治医意見書登録のパラメータ
     * @return ShujiiIkenshoTorokuRelateEntity
     */
    ShujiiIkenshoTorokuRelateEntity getShujiiIkenshoForLoad(ShujiiIkenshoTorokuMapperParameter param);

    /**
     * 意見書情報の件数を取得します。
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    int getShujiiIkenshoKensu(ShujiiIkenshoTorokuMapperParameter param);

    /**
     * 指定した管理番号に基づき一次判定データの件数を取得します。
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    int getIchijiHantei(ShujiiIkenshoTorokuMapperParameter param);

    /**
     * 指定した管理番号に基づき一次判定が完了した件数を取得します。
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    int getIchijiHanteiKanryo(ShujiiIkenshoTorokuMapperParameter param);

    /**
     * 指定した管理番号に基づき一次判定が未完了の件数を取得します。
     *
     * @param param 主治医意見書登録のパラメータ
     * @return int
     */
    int getIchijiHanteiMikanryo(ShujiiIkenshoTorokuMapperParameter param);
}
