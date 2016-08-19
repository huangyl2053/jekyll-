/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.ShinsaTaishoDataOutPutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileShinsaiinRelateEntity;

/**
 * 認定審査会割当委員情報出力（モバイル）のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public interface IShinsaTaishoDataOutPutMapper {

    /**
     * 認定審査会割当委員情報出力（モバイル）を取得します。
     *
     * @param param 認定審査会割当委員情報出力（モバイル）のパラメータ
     * @return List<NijihanteiKekkaTorokuMobileShinsaiinRelateEntity>
     */
    List<NijihanteiKekkaTorokuMobileShinsaiinRelateEntity> get認定審査会割当委員情報出力(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 二次判定結果登録用データ（モバイル）を取得します。
     *
     * @param param 二次判定結果登録用データ（モバイル）のパラメータ
     * @return List<NijihanteiKekkaTorokuMobileRelateEntity>
     */
    List<NijihanteiKekkaTorokuMobileRelateEntity> get二次判定結果登録用データ出力(ShinsaTaishoDataOutPutMybatisParameter param);

}
