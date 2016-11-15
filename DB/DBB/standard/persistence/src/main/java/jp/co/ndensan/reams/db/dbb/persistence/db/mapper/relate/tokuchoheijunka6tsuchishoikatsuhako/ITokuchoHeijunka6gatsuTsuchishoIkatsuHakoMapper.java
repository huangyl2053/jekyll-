/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.ShutsuRyokuTaishoShutokuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)のMapperクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
public interface ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper {

    /**
     * 基準日時を取得する。
     *
     * @param param パラメータ
     * @return 基準日時
     */
    RString get基準日時(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 帳票制御共通情報を取得します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @return 帳票制御共通情報
     */
    DbT7065ChohyoSeigyoKyotsuEntity select帳票制御共通情報(@Param("サブ業務コード") RString サブ業務コード, @Param("帳票分類ID") RString 帳票分類ID);

    /**
     * 出力対象情報を取得する。
     *
     * @param param パラメータ
     * @return 出力対象情報
     */
    List<KarisanteiGakuHenkoEntity> select出力対象情報(ShutsuRyokuTaishoShutokuMyBatisParameter param);
            
    /**
     * 計算後情報テーブルの更新前後区分が「更正前」のデータにより、仮算定額変更情報一時テーブルの計算後情報「更正前」情報を更新する。
     *
     * @param param パラメータ
     */
    void update計算後情報更正前(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 前年度・特徴期別金額06を更新する。
     *
     * @param param パラメータ
     */
    void update前年度特徴期別金額06(TokuchoHeijunka6gatsuMyBatisParameter param);
    
}
