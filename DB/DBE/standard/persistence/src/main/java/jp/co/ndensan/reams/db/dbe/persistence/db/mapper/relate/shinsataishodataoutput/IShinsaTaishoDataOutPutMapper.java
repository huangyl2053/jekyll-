/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.ShinsaTaishoDataOutPutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.KihonChosaKomokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.NijihanteiKekkaTorokuMobileShinsaiinRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.SaikaiObjectOutPutEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査会割当委員情報出力（モバイル）のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public interface IShinsaTaishoDataOutPutMapper {

    /**
     * 介護認定審査会情報を取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<ShinsakaiJohoRelateEntity>
     */
    List<ShinsakaiJohoRelateEntity> get介護認定審査会情報(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 介護認定審査会委員情報を取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<ShinsakaiIinJohoRelateEntity>
     */
    List<ShinsakaiIinJohoRelateEntity> get介護認定審査会委員情報(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 基本調査項目データを取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<KihonChosaKomokuDataRelateEntity>
     */
    List<KihonChosaKomokuDataRelateEntity> get基本調査項目データ(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 概況調査データを取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<KihonChosaKomokuDataRelateEntity>
     */
    List<GaikyoChosaDataRelateEntity> get概況調査データ(ShinsaTaishoDataOutPutMybatisParameter param);

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

    /**
     * 審査対象データを取得します。
     *
     * @param kaisaiBangou 審査対象データを取得のパラメータ
     * @return NijihanteiKekkaTorokuMobileRelateEntity
     */
    SaikaiObjectOutPutEntity get審査対象(RString kaisaiBangou);

}
