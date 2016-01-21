/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import jp.co.ndensan.reams.db.dbb.entity.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ) Mapper
 */
public interface TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoMapper {

    /**
     * 基準日時を取得する。
     *
     * @param sqlparams TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity
     * @return
     */
    RString get基準日時(
            TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity sqlparams);

    /**
     * 特徴平準化_6月分更新後とリアルのデータを抽出し、仮算定額変更情報一時テーブルに登録する。
     *
     * @param 調定年度
     */
    void select特徴平準化_6月分更新後とリアルのデータ(RString 調定年度);

    /**
     * 計算後情報テーブルの更新前後区分が「更正前」のデータにより、仮算定額変更情報一時テーブルの計算後情報「更正前」情報を更新する。
     *
     * @param sqlparams
     */
    void update仮算定額変更情報一時テーブルの計算後情報更正前情報1(
            TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity sqlparams);

    /**
     * 特徴平準化_6月分更新後のデータを抽出し、仮算定額変更情報一時テーブルに登録する。
     */
    void select特徴平準化_6月分更新後のデータ();

    /**
     * 計算後情報テーブルの更新前後区分が「更正前」のデータにより、仮算定額変更情報一時テーブルの計算後情報「更正前」情報を更新する。
     *
     * @param sqlparams TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity
     *
     */
    void update仮算定額変更情報一時テーブルの計算後情報更正前情報2(
            TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity sqlparams);

    /**
     * 更正前の対象者（追加含む）情報を更新する。
     */
    void update更正前の対象者_追加含む_情報();

    /**
     * 全ての賦課情報（前年度）を抽出して、前年度賦課情報一時テーブルに登録する
     */
    void select全ての賦課情報();

    /**
     * 前年度・特徴期別金額06を更新する。
     */
    void update前年度特徴期別金額06();

    /**
     * 継続の被保険者区分を更新する
     */
    void update継続の被保険者区分();

    /**
     * 4月開始の被保険者区分を更新する
     */
    void update4月開始の被保険者区分();

    /**
     * 6月開始の被保険者区分を更新する。
     */
    void update6月開始の被保険者区分();

    /**
     * 入力の出力対象区分によって、出力対象データを抽出する。
     */
    void insert入力の出力対象区分によって();
}
