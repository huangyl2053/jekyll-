
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kakohorenjyohosakuseicommon;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kakohorenjyohosakuseicommon.KakohorenJyohoSakuseiCommonParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon.KakohorenJyohoSakuseiCommonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;

/**
 * 国保連情報作成共通処理（証記載保険者番号取得）Mapperクラスです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
public interface IKakohorenJyohoSakuseiCommonMapper {

    /**
     * 被保険者一時TBL情報を取得します。
     *
     * @param param KakohorenJyohoSakuseiCommonParameter
     * @return HihokenshaTempEntityのリスト
     */
    List<HihokenshaTempEntity> select被保険者一時TBL情報(KakohorenJyohoSakuseiCommonParameter param);

    /**
     * 新旧被保険者番号変換情報を取得します。
     *
     * @param param KakohorenJyohoSakuseiCommonParameter
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select新旧被保険者番号変換情報(KakohorenJyohoSakuseiCommonParameter param);

    /**
     * 合併市町村情報を取得します。
     *
     * @param param KakohorenJyohoSakuseiCommonParameter
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select合併市町村情報(KakohorenJyohoSakuseiCommonParameter param);

    /**
     * 被保険者一時TBL情報を取得します。
     *
     * @return HihokenshaTempEntityのリスト
     */
    List<HihokenshaTempEntity> select被保険者一時TBL情報By証記載保険者番号();

    /**
     * 被保険者台帳情報を取得します。
     *
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select被保険者台帳();

    /**
     * 合併なし市町村情報を取得します。
     *
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select合併なし市町村情報();

    /**
     * 合併あり市町村情報を取得します。
     *
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select合併あり市町村情報();

    /**
     * 合併あり被保険者一時TBL情報を取得します。
     *
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select合併あり被保険者一時TBL情報();

    /**
     * 合併あり被保険者一時TBL情報を取得します。
     *
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select新旧被保険者番号変換情報2();

    /**
     * 保険者名情報を取得します。
     *
     * @return KakohorenJyohoSakuseiCommonEntityのリスト
     */
    List<KakohorenJyohoSakuseiCommonEntity> select保険者名();

}
