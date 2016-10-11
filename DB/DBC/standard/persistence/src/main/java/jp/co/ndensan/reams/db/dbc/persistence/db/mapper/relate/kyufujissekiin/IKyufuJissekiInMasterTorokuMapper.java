/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekiin;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120050.KyufuJissekiInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3031KyufuJissekiCareManagementHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3106KyufujissekiMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.KyufuJissekiInHenkyakuD8DataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.KyufuJissekiInHenkyakuH1DataEntity;

/**
 * 給付更新結果情報取込のMapperです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public interface IKyufuJissekiInMasterTorokuMapper {

    /**
     * 再処理準備:給付実績基本TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績基本(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績明細TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績明細(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績緊急時施設療養TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績緊急時施設療養(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績特定診療費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績特定診療費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績特定診療費特別療養費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績特定診療費特別療養費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績食事費用TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績食事費用(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績居宅サービス計画費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績居宅サービス計画費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績福祉用具販売費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績福祉用具販売費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績住宅改修費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績住宅改修費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績高額介護サービス費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績高額介護サービス費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績特定入所者介護サービス費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績特定入所者介護サービス費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績社会福祉法人軽減額TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績社会福祉法人軽減額(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績ケアマネジメント費TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績ケアマネジメント費(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績所定疾患施設療養費等TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績所定疾患施設療養費等(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績明細住所地特例TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績明細住所地特例(KyufuJissekiInMybatisParameter parameter);

    /**
     * 再処理準備:給付実績集計TBLのデータを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績集計(KyufuJissekiInMybatisParameter parameter);

    /**
     * 付実績H1の新規、修正データを物理削除する。
     *
     * @return KyufuJissekiInHenkyakuH1DataEntity
     */
    KyufuJissekiInHenkyakuH1DataEntity select給付実績H1の新規修正データ();

    /**
     * 付実績H1の新規、修正関連データを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績H1の新規修正関連データ(KyufuJissekiInMybatisParameter parameter);

    /**
     * 付実績H1の取消データを物理削除する。
     *
     * @return KyufuJissekiInHenkyakuH1DataEntity
     */
    KyufuJissekiInHenkyakuH1DataEntity select給付実績H1の取消データ();

    /**
     * 付実績H1の取消関連データを物理削除する。
     *
     * @param parameter KyufuJissekiInMybatisParameter
     * @return int
     */
    int delete給付実績H1の取消関連データ(KyufuJissekiInMybatisParameter parameter);

    /**
     * 付実績D8の新規、修正データを物理削除する。
     *
     * @return KyufuJissekiInHenkyakuD8DataEntity
     */
    KyufuJissekiInHenkyakuD8DataEntity select給付実績D8の新規修正データ();

    /**
     * 付実績D8の取消データを物理削除する。
     *
     * @return KyufuJissekiInHenkyakuD8DataEntity
     */
    KyufuJissekiInHenkyakuD8DataEntity select給付実績D8の取消データ();

    /**
     * 給付実績一時TBLの最大連番を取ります。
     *
     * @return int 最大連番
     */
    Integer select給付実績一時の最大連番();

    /**
     * 給付実績H1一時のデータを取ります。
     *
     * @return DbT3017KyufujissekiKihonEntity
     */
    DbT3017KyufujissekiKihonEntity getマスタ登録データH1();

    /**
     * 給付実績D1一時のデータを取ります。
     *
     * @return DbT3018KyufujissekiMeisaiEntity
     */
    DbT3018KyufujissekiMeisaiEntity getマスタ登録データD1();

    /**
     * 給付実績D2一時のデータを取ります。
     *
     * @return DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity
     */
    DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity getマスタ登録データD2();

    /**
     * 給付実績D31一時のデータを取ります。
     *
     * @return DbT3020KyufujissekiTokuteiSinryohiEntity
     */
    DbT3020KyufujissekiTokuteiSinryohiEntity getマスタ登録データD31();

    /**
     * 給付実績D32一時のデータを取ります。
     *
     * @return DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity
     */
    DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity getマスタ登録データD32();

    /**
     * 給付実績D4一時のデータを取ります。
     *
     * @return DbT3022KyufujissekiShokujiHiyoEntity
     */
    DbT3022KyufujissekiShokujiHiyoEntity getマスタ登録データD4();

    /**
     * 給付実績D5一時のデータを取ります。
     *
     * @return DbT3025KyufujissekiKyotakuServiceEntity
     */
    DbT3025KyufujissekiKyotakuServiceEntity getマスタ登録データD5();

    /**
     * 給付実績D6一時のデータを取ります。
     *
     * @return DbT3026KyufujissekiFukushiYoguHanbaihiEntity
     */
    DbT3026KyufujissekiFukushiYoguHanbaihiEntity getマスタ登録データD6();

    /**
     * 給付実績D7一時のデータを取ります。
     *
     * @return DbT3027KyufujissekiJutakuKaishuhiEntity
     */
    DbT3027KyufujissekiJutakuKaishuhiEntity getマスタ登録データD7();

    /**
     * 給付実績D8一時のデータを取ります。
     *
     * @return DbT3028KyufujissekiKogakuKaigoServicehiEntity
     */
    DbT3028KyufujissekiKogakuKaigoServicehiEntity getマスタ登録データD8();

    /**
     * 給付実績D9一時のデータを取ります。
     *
     * @return DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity
     */
    DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity getマスタ登録データD9();

    /**
     * 給付実績DA一時のデータを取ります。
     *
     * @return DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity
     */
    DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity getマスタ登録データDA();

    /**
     * 給付実績DB一時のデータを取ります。
     *
     * @return DbT3031KyufuJissekiCareManagementHiEntity
     */
    DbT3031KyufuJissekiCareManagementHiEntity getマスタ登録データDB();

    /**
     * 給付実績DC一時のデータを取ります。
     *
     * @return DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity
     */
    DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity getマスタ登録データDC();

    /**
     * 給付実績DD一時のデータを取ります。
     *
     * @return DbT3106KyufujissekiMeisaiJushochiTokureiEntity
     */
    DbT3106KyufujissekiMeisaiJushochiTokureiEntity getマスタ登録データDD();

    /**
     * 給付実績T1一時のデータを取ります。
     *
     * @return DbT3033KyufujissekiShukeiEntity
     */
    DbT3033KyufujissekiShukeiEntity getマスタ登録データT1();
}
