/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshakyufujisseki.HokenshaKyufujissekiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshakyufujisseki.HihokenshaToKyufuKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshakyufujisseki.HihokenshaToKyufuKogakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshakyufujisseki.KyufujissekiSetteiKunbunEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujisseki.DbWT1111KyufuJissekiTempTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon.DbWT1131KyufujissekiKihonTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikogakukaigoservicehi.DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のMapperです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public interface IHokenshaKyufujissekiMapper {

    /**
     * 送付対象データ取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績基本データ
     */
    List<DbT3017KyufujissekiKihonEntity> get給付実績基本データ(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績高額介護サービス費データ取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績高額介護サービス費データ
     */
    List<DbT3028KyufujissekiKogakuKaigoServicehiEntity> get給付実績高額介護サービス費データ(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本の不正データ取得する。
     *
     * @return 給付実績基本の不正データ
     */
    List<DbWT1131KyufujissekiKihonTempEntity> get集約_基本対象データ_3件以上();

    /**
     * 給付実績基本の審査年月同一データ取得する。
     *
     * @return 給付実績基本の審査年月同一データ
     */
    List<DbWT1131KyufujissekiKihonTempEntity> get集約_基本対象データ_審査年月同一();

    /**
     * 給付実績基本集約対象データ取得する。
     *
     * @return 給付実績基本集約対象データ
     */
    List<DbWT1131KyufujissekiKihonTempEntity> get集約_基本対象データ_2件存在();

    /**
     * 給付実績高額の不正データ取得する。
     *
     * @return 給付実績高額の不正データ
     */
    List<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> get集約_高額対象データ_3件以上();

    /**
     * 給付実績高額の不正データ取得する。
     *
     * @return 給付実績高額の不正データ
     */
    List<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> get集約_高額対象データ_審査年月同一();

    /**
     * 給付実績高額の不正データ取得する。
     *
     * @return 給付実績高額の不正データ
     */
    List<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> get集約_高額対象データ_2件存在();

    /**
     * 給付実績基本一時データのサービス提供年月時点で直近の識別番号管理データを取得する。
     *
     * @return 給付実績基本一時と識別番号管理Entity。
     */
    List<KyufujissekiSetteiKunbunEntity> get設定区分();

    /**
     * 識別番号管理データが取得できなかった給付実績基本一時データを取得する。
     *
     * @return 給付実績基本一時TBL．入力識別番号List。
     */
    List<RString> get識別番号管理がないの基本一時データ();

    /**
     * 被保険者一時TBLの保険者番号、送付被保険者番号 を 給付実績基本一時TBLに登録する。
     *
     * @return 被保険者一時と給付実績基本一時のデータ。
     */
    List<HihokenshaToKyufuKihonEntity> get変換結果取込_基本();

    /**
     * 被保険者一時TBLの保険者番号、送付被保険者番号 を 給付実績高額一時TBLに登録する。
     *
     * @return 被保険者一時と給付実績基本一時のデータ。
     */
    List<HihokenshaToKyufuKogakuEntity> get変換結果取込_高額();

    /**
     * 保険者番号の取得する。
     *
     * @return 保険者番号リスト。
     */
    List<HokenshaNo> get保険者番号();

    /**
     * 給付実績基本一時TBLから送付対象データを取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績基本一時データ
     */
    List<DbWT1131KyufujissekiKihonTempEntity> get基本一時データ(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績明細を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績明細データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get明細データ(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績緊急時施設療養を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 緊急時施設療養データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get緊急時施設療養(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績所定疾患施設療養費等を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 所定疾患施設療養費等データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get所定疾患施設療養費等(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績特定診療費を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績特定診療費データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get特定診療費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績特定診療費_特別療養費を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績特定診療費_特別療養費データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get特定診療費_特別療養費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績食事費用を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績食事費用データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get食事費用(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績居宅サービス計画費を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績居宅サービス計画費データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get居宅サービス計画費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績福祉用具販売費を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績福祉用具販売費データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get福祉用具販売費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績住宅改修費を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績住宅改修費データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get住宅改修費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績集計を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績集計データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get集計(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績特定入所者介護サービス費用を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績特定入所者介護サービス費用データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get特定入所者介護サービス費用(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績社会福祉法人軽減額を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績社会福祉法人軽減額データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get社会福祉法人軽減額(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績明細_住所地特例を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績明細_住所地特例データ List<DbWT1111KyufuJissekiTempTempEntity>
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get明細_住所地特例(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績高額一時を取得する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     * @return 給付実績高額一時データ
     * List<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity>
     */
    List<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> get高額一時データ(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績Tempを取得する。
     *
     * @return 給付実績Temp一時データ
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get給付実績Temp();

    /**
     * 給付実績基本Tempを取得する。
     *
     * @return 給付実績Temp一時データ
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get給付実績基本Temp();

    /**
     * 給付実績高額Tempを取得する。
     *
     * @return 給付実績Temp一時データ
     */
    List<DbWT1111KyufuJissekiTempTempEntity> get給付実績高額Temp();

    /**
     * 給付実績基本一時を取得する。
     *
     * @return 給付実績基本一時データ
     */
    List<DbWT1131KyufujissekiKihonTempEntity> get給付実績基本一時();

    /**
     * 給付実績基本一時Deleteを取得する。
     *
     * @return 給付実績基本一時データDelete
     */
    List<DbWT1131KyufujissekiKihonTempEntity> get給付実績基本一時Delete();

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績基本(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績基本(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績高額介護サービス費．送付除外フラグ＝TRUEのデータを物理削除する。
     */
    void delete給付実績高額介護サービス費();

    /**
     * 給付実績高額介護サービス費．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績高額介護サービス費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績明細(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績明細(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績緊急時施設療養(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績緊急時施設療養(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績特定診療費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績特定診療費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績特定診療費_特別療養費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績特定診療費_特別療養費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績食事費用(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績食事費用(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績居宅サービス計画費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績居宅サービス計画費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績福祉用具販売費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績福祉用具販売費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績住宅改修費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績住宅改修費(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績集計(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績集計(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績特定入所者介護サービス費用(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績特定入所者介護サービス費用(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績社会福祉法人軽減額(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績社会福祉法人軽減額(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績所定疾患施設療養費等(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績所定疾患施設療養費等(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void delete給付実績明細_住所地特例(HokenshaKyufujissekiMybatisParameter param);

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    void update給付実績明細_住所地特例(HokenshaKyufujissekiMybatisParameter param);
}
