/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokaritsuchishoikkatsuhakko;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchNokumiParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchoInsTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchokaritsuchishoikkatsuhakkoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FuchoKariTsuchishoIkkatsuHakkoTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ34002_1_普徴仮算定通知書一括発行（バッチ）のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0710-040 yebangqiang
 */
public interface IFuchoKariTsuchishoIkkatsuHakkoMapper {

    /**
     * 異動賦課情報一時を作成するメソッドです。
     */
    void creat異動賦課情報一時();

    /**
     * 異動賦課情報一時をinsertするメソッドです。
     *
     * @param parameter FuchNokumiParameter
     */
    void insert異動賦課情報一時_計算後情報一時(FuchNokumiParameter parameter);

    /**
     * 異動賦課情報一時をinsertするメソッドです。
     *
     * @param parameter FuchNokumiParameter
     */
    void insert異動賦課情報一時_計算後情報(FuchNokumiParameter parameter);

    /**
     * 計算後情報「更正前」情報を更新するメソッドです。
     */
    void update異動賦課情報_計算後情報一時_計算後情報更正前();

    /**
     * 計算後情報「更正前」情報を更新するメソッドです。
     */
    void update異動賦課情報_計算後情報_計算後情報更正前();

    /**
     * 更正前の対象者（追加含む）情報を更新するメソッドです。
     *
     * @param parameter Map
     */
    void update異動賦課情報_対象者仮徴収更正前(Map<RString, FlexibleYear> parameter);

    /**
     * 異動賦課情報_生活保護区分を更新するメソッドです。
     */
    void update異動賦課情報_生活保護区分();

    /**
     * 前年度全ての賦課情報をinsertするメソッドです。
     *
     * @param parameter Map
     */
    void insert前年度全ての賦課情報(Map<RString, FlexibleYear> parameter);

    /**
     * 異動賦課情報_前年度賦課情報を更新するメソッドです。
     */
    void update異動賦課情報_前年度賦課情報();

    /**
     * 異動賦課情報一時を抽出するメソッドです。
     *
     * @return 異動賦課情報一時テーブル List<FuchoKariTsuchishoIkkatsuHakkoTempEntity>
     */
    List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> select異動賦課情報一時();

    /**
     * 出力対象データを抽出するメソッドです。
     *
     * @param parameter FuchokaritsuchishoikkatsuhakkoParameter
     * @return 出力対象データ List<FuchoKariTsuchishoIkkatsuHakkoTempEntity>
     */
    List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> select出力対象データ(
            FuchokaritsuchishoikkatsuhakkoParameter parameter);

    /**
     * 通知書発行後異動者をinsertするメソッドです。
     *
     * @param parameter FuchoInsTsuchishoParameter
     */
    void insert通知書発行後異動者(FuchoInsTsuchishoParameter parameter);
}
