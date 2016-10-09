/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokaritsuchishoikkatsuhakko;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokarisanteitsuchishohakko.FuchoKarisanteiTsuchishoHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchIdoIchijiParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchNokumiParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchokaritsuchishoikkatsuhakkoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FuchoKariTsuchishoIkkatsuHakkoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FukaJohoZenendoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.KaigoFukaZenedoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.NenkenKoseigoJohoTempEntity;

/**
 * ビジネス設計_DBBBZ34002_1_普徴仮算定通知書一括発行（バッチ）のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public interface IFuchoKarisanteiTsuchishoHakkoMapper {

    /**
     * 最新調定日時を取得するメソッドです。
     *
     * @param parameter FuchoKarisanteiTsuchishoHakkoMybatisParameter
     * @return HashMap<String, Object> 最新調定日時
     */
    Map<String, Object> get最新調定日時(FuchoKarisanteiTsuchishoHakkoMybatisParameter parameter);

    /**
     * 普徴仮算定の更新後データを取得するメソッドです。
     *
     * @param parameter FuchNokumiParameter
     * @return List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> 普徴仮算定の更新後データリスト
     */
    List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> get普徴仮算定の更新後データ_計算後情報一時(FuchNokumiParameter parameter);

    /**
     * 普徴仮算定の更新後データを取得するメソッドです。
     *
     * @param parameter FuchNokumiParameter
     * @return List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> 普徴仮算定の更新後データリスト
     */
    List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> get普徴仮算定の更新後データ_計算後情報(FuchNokumiParameter parameter);

    /**
     * 異動賦課情報_計算後情報一時_計算後情報更正前データを取得するメソッドです。
     *
     * @return List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> 普徴仮算定の更新後データリスト
     */
    List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> select異動賦課情報_計算後情報一時_計算後情報更正前();

    /**
     * 異動賦課情報_計算後情報_計算後情報更正前データを取得するメソッドです。
     *
     * @return List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> 普徴仮算定の更新後データリスト
     */
    List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> select異動賦課情報_計算後情報_計算後情報更正前();

    /**
     * 異動賦課情報_対象者仮徴収更正前データを取得するメソッドです。
     *
     * @param parameter FuchIdoIchijiParameter
     * @return List<NenkenKoseigoJohoTempEntity> 普徴仮算定の更新後データリスト
     */
    List<NenkenKoseigoJohoTempEntity> select異動賦課情報_対象者仮徴収更正前(FuchIdoIchijiParameter parameter);

    /**
     * 前年度全ての賦課情報データを取得するメソッドです。
     *
     * @param parameter FuchIdoIchijiParameter
     * @return List<FukaJohoZenendoTmpEntity> 前年度全ての賦課情報データリスト
     */
    List<FukaJohoZenendoTmpEntity> select前年度全ての賦課情報(FuchIdoIchijiParameter parameter);

    /**
     * 異動賦課情報_前年度賦課情報データを取得するメソッドです。
     *
     * @return List<KaigoFukaZenedoTempEntity> 異動賦課情報_前年度賦課情報データリスト
     */
    List<KaigoFukaZenedoTempEntity> select異動賦課情報_前年度賦課情報();

    /**
     * 出力対象データを抽出するメソッドです。
     *
     * @param parameter FuchokaritsuchishoikkatsuhakkoParameter
     * @return 出力対象データ List<FuchoKariTsuchishoIkkatsuHakkoTempEntity>
     */
    List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> select出力対象データ(
            FuchokaritsuchishoikkatsuhakkoParameter parameter);
}
