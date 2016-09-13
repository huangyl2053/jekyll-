/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshadotei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshadotei.TokuchoTaishoshaDoteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaGroupCode;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0513TokubetsuChoshuGimushaGroupEntity;
import jp.co.ndensan.reams.ue.uex.entity.relate.MidoteiTempEntity;

/**
 *
 * 特徴対象者同定（一括）のDB操作です
 *
 * @reamsid_L DBB-1850-050 zhangrui
 */
public interface ITokuchoTaishoshaDoteiMapper {

    /**
     * 介護の３つのテーブルの全件を取る。
     *
     * @return List<TokuchoTaishoshaDoteiCombineEntity>
     */
    List<TokuchoTaishoshaDoteiCombineEntity> get介護の３つのテーブルの全件();

    /**
     * 介護の３つのテーブルと徴収方法の全件を取る。
     *
     * @param parameter TokuchoTaishoshaDoteiMybatisParameter
     * @return List<TokuchoTaishoshaDoteiCombineEntity>
     */
    List<TokuchoTaishoshaDoteiCombineEntity> get介護の３つのテーブルと徴収方法の全件(
            TokuchoTaishoshaDoteiMybatisParameter parameter);

    /**
     * 徴収方法情報を取る。
     *
     * @param parameter TokuchoTaishoshaDoteiMybatisParameter
     * @return List<TokuchoTaishoshaDoteiCombineEntity>
     */
    List<TokuchoTaishoshaDoteiCombineEntity> get徴収方法情報(TokuchoTaishoshaDoteiMybatisParameter parameter);

    /**
     * 業務被保険者情報一時テーブルの全件を取ります
     *
     * @return List<Map>
     */
    List<Map<String, Object>> get業務被保険者情報一時テーブルの全件();

    /**
     * 特別徴収義務者を取ります
     *
     *
     * @param 特別徴収義務者グループコード TokubetsuChoshuGimushaGroupCode
     * @return List<UeT0513TokubetsuChoshuGimushaGroupEntity>
     */
    List<UeT0513TokubetsuChoshuGimushaGroupEntity> get特別徴収義務者(
            TokubetsuChoshuGimushaGroupCode 特別徴収義務者グループコード);

    /**
     * 特別徴収義務者コードを取ります
     *
     *
     * @param 特別徴収義務者グループコード TokubetsuChoshuGimushaGroupCode
     * @return List<TokubetsuChoshuGimushaCode>
     */
    List<TokubetsuChoshuGimushaCode> get特別徴収義務者コード(
            TokubetsuChoshuGimushaGroupCode 特別徴収義務者グループコード);

    /**
     * 未同定情報一時テーブルの全件を取ります
     *
     * @return List<MidoteiTempEntity>
     */
    List<MidoteiTempEntity> get未同定情報一時テーブルの全件();

    /**
     * 同定情報一時テーブルの全件を取ります
     *
     * @return List<Map>
     */
    List<Map<String, Object>> get同定情報一時テーブルの全件();

    /**
     * 処理日付管理マスタを更新する。
     *
     *
     * @param parameter TokuchoTaishoshaDoteiMybatisParameter
     */
    void update処理日付管理マスタ(TokuchoTaishoshaDoteiMybatisParameter parameter);
}
