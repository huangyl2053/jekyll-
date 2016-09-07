/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshadotei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaGroupCode;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0513TokubetsuChoshuGimushaGroupEntity;
import jp.co.ndensan.reams.ue.uex.entity.relate.DoteiTempEntity;
import jp.co.ndensan.reams.ue.uex.entity.relate.MidoteiTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
     * @param 処理年度 FlexibleYear
     * @return List<TokuchoTaishoshaDoteiCombineEntity>
     */
    List<TokuchoTaishoshaDoteiCombineEntity> get介護の３つのテーブルと徴収方法の全件(FlexibleYear 処理年度);

    /**
     * 徴収方法情報を取る。
     *
     * @param 処理年度 FlexibleYear
     * @return List<TokuchoTaishoshaDoteiCombineEntity>
     */
    List<TokuchoTaishoshaDoteiCombineEntity> get徴収方法情報(FlexibleYear 処理年度);

    /**
     * 業務被保険者情報一時テーブルを作ります
     *
     */
    void create業務被保険者情報一時テーブル();

    /**
     * 業務被保険者情報一時テーブルの全件を取ります
     *
     * @return List<Map>
     */
    List<Map<String, Object>> get業務被保険者情報一時テーブルの全件();

    /**
     * 業務被保険者情報一時テーブルに登録する
     *
     * @param entity GyomuHihokenshaTempEntity
     *
     */
    void insert業務被保険者情報一時テーブル(Map<String, RString> entity);

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
     * 徴収方法を更新する
     *
     *
     * @param 徴収方法 DbV2001ChoshuHohoEntity
     */
    void insert徴収方法(DbV2001ChoshuHohoEntity 徴収方法);

    /**
     * 未同定情報一時テーブルを作ります
     *
     */
    void create未同定情報一時テーブル();

    /**
     * 未同定情報一時テーブルの全件を取ります
     *
     * @return List<Map<String,Object>>
     */
    List<Map<String, Object>> get未同定情報一時テーブルの全件();

    /**
     * 未同定情報一時テーブルに登録する
     *
     * @param entity MidoteiTempEntity
     *
     */
    void insert未同定情報一時テーブル(MidoteiTempEntity entity);

    /**
     * 同定情報一時テーブルを作ります
     *
     */
    void create同定情報一時テーブル();

    /**
     * 同定情報一時テーブルの全件を取ります
     *
     * @return List<Map>
     */
    List<Map<String, Object>> get同定情報一時テーブルの全件();

    /**
     * 同定情報一時テーブルに登録する
     *
     * @param entity MidoteiTempEntity
     *
     */
    void insert同定情報一時テーブル(DoteiTempEntity entity);

    /**
     * 特徴未同定情報作成
     *
     *
     * @param 開始月 RString
     */
    void do特徴未同定情報作成(RString 開始月);
}
