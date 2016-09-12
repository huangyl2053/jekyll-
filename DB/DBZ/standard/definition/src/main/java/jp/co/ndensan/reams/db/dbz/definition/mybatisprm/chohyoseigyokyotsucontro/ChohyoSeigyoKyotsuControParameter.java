/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chohyoseigyokyotsucontro;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 帳票選択データの取得処理クラスです。
 *
 * @reamsid_L DBA-1201-010 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ChohyoSeigyoKyotsuControParameter {

    private final SubGyomuCode サブ業務コード;
    private final boolean 共通画面使用有無;

    private ChohyoSeigyoKyotsuControParameter(
            SubGyomuCode サブ業務コード,
            boolean 共通画面使用有無) {
        this.サブ業務コード = サブ業務コード;
        this.共通画面使用有無 = 共通画面使用有無;
    }

    /**
     * パラメータ設定。
     *
     * @param サブ業務コード RString
     * @param 共通画面使用有無 boolean
     * @return JigyoshaInputGuideParameter
     */
    public static ChohyoSeigyoKyotsuControParameter createParam(
            SubGyomuCode サブ業務コード,
            boolean 共通画面使用有無) {
        return new ChohyoSeigyoKyotsuControParameter(
                サブ業務コード,
                共通画面使用有無);
    }
}
