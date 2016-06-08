/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 実施状況統計情報クラスです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JisshiJokyoTokei {

    private RString タイトル;
    private RString 抽出開始年月日;
    private RString 抽出終了年月日;
    private RDateTime 発行日時;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 申請受付数タイトル;
    private RString 調査実施数タイトル;
    private RString 審査会実施数タイトル;
    private RString 認定結果数タイトル;
    private RString 新規申請タイトル;
    private RString 新規申請_申請受付数;
    private RString 新規申請_調査実施数;
    private RString 新規申請_審査会実施数;
    private RString 新規申請_認定結果数;
    private RString 更新申請タイトル;
    private RString 更新申請_申請受付数;
    private RString 更新申請_調査実施数;
    private RString 更新申請_審査会実施数;
    private RString 更新申請_認定結果数;
    private RString 区分変更申請タイトル;
    private RString 区分変更申請_申請受付数;
    private RString 区分変更申請_調査実施数;
    private RString 区分変更申請_審査会実施数;
    private RString 区分変更申請_認定結果数;
    private RString 合計タイトル;
    private RString 合計_申請受付数;
    private RString 合計_調査実施数;
    private RString 合計_審査会実施数;
    private RString 合計_認定結果数;

}
