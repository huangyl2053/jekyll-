/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
    RDateTime get基準日時(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 特徴平準化_6月分更新後とリアルのデータを抽出し、仮算定額変更情報一時テーブルに登録する。
     *
     * @param param パラメータ
     * @return List<KarisanteiGakuHenkoEntity>
     */
    List<KarisanteiGakuHenkoEntity> select特徴平準化_6月分更新後とリアルのデータ(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 計算後情報テーブルの更新前後区分が「更正前」のデータにより、仮算定額変更情報一時テーブルの計算後情報「更正前」情報を更新する。
     *
     * @param param パラメータ
     */
    void update計算後情報更正前(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 全ての賦課情報（前年度）を抽出して、前年度賦課情報一時テーブルに登録する
     *
     * @param param パラメータ
     * @return List<DbT2002FukaEntity>
     */
    List<DbT2002FukaEntity> select前年度賦課情報(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 前年度・特徴期別金額06を更新する。
     *
     * @param param パラメータ
     */
    void update前年度特徴期別金額06(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 継続の被保険者区分を更新する
     *
     * @param param パラメータ
     */
    void update継続の被保険者区分(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 4月開始の被保険者区分を更新する
     *
     * @param param パラメータ
     */
    void update4月開始の被保険者区分(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 6月開始の被保険者区分を更新する。
     *
     * @param param パラメータ
     */
    void update6月開始の被保険者区分(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 出力対象情報の取得を行います。
     *
     * @param 出力対象区分 出力対象区分
     * @param 出力順 出力順
     * @return List<KarisanteiGakuHenkoEntity>
     */
    List<KarisanteiGakuHenkoEntity> select出力対象情報(@Param("出力対象区分") int 出力対象区分, @Param("出力順") RString 出力順);

    /**
     * 入力の出力対象区分によって、出力対象データを抽出する。
     */
    void insert入力の出力対象区分によって();

    /**
     * 入力の出力対象区分によって、出力対象データを抽出する。
     *
     * @param 出力対象区分 出力対象区分
     * @param 出力順 出力順
     * @param 帳票作成日時 帳票作成日時
     * @param 帳票ID 帳票ID
     */
    void insert通知書発行後異動者(@Param("帳票作成日時") RDateTime 帳票作成日時,
            @Param("出力対象区分") int 出力対象区分,
            @Param("帳票ID") RString 帳票ID,
            @Param("出力順") RString 出力順);
}
