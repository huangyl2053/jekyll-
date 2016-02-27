/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.core.kanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri.KariSanteiNonyuTsuchiShoSeigyoJohoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;

/**
 *
 * 納入通知書制御情報取得のマッパーインタフェースです。
 */
public interface INonyuTsuchiShoSeigyoJohoLoaderMapper {

    /**
     * 仮算定納入通知書制御情報を取得します。
     *
     * @param 納入通知書制御情報取得パラメータ 納入通知書制御情報取得パラメータ
     * @return 仮算定納入通知書制御情報
     */
    List<DbT7067ChohyoSeigyoHanyoEntity> get仮算定納入通知書制御情報(KariSanteiNonyuTsuchiShoSeigyoJohoParameter 納入通知書制御情報取得パラメータ);

    /**
     * 本算定納入通知書制御情報を取得します。
     *
     * @param 納入通知書制御情報取得パラメータ 納入通知書制御情報取得パラメータ
     * @return 本算定納入通知書制御情報
     */
    List<DbT7067ChohyoSeigyoHanyoEntity> get本算定納入通知書制御情報(KariSanteiNonyuTsuchiShoSeigyoJohoParameter 納入通知書制御情報取得パラメータ);

}
