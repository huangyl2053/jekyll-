/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chohyoseigyokyotsucontro;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 帳票選択データの取得処理クラスです。
 *
 * @reamsid_L DBA-1201-010 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ChohyoSeigyoKyotsuParameter {

    private final SubGyomuCode サブ業務コード;
    private final List<ReportId> 帳票分類ID;
    private final boolean 帳票分類IDフラグ;

    private ChohyoSeigyoKyotsuParameter(
            SubGyomuCode サブ業務コード,
            List<ReportId> 帳票分類ID,
            boolean 帳票分類IDフラグ) {
        this.サブ業務コード = サブ業務コード;
        this.帳票分類ID = 帳票分類ID;
        this.帳票分類IDフラグ = 帳票分類IDフラグ;
    }

    /**
     * パラメータ設定。
     *
     * @param サブ業務コード RString
     * @param 帳票分類ID List<RString>
     * @return JigyoshaInputGuideParameter
     */
    public static ChohyoSeigyoKyotsuParameter createParam(
            SubGyomuCode サブ業務コード,
            List<ReportId> 帳票分類ID) {
        boolean 帳票分類IDフラグ = false;
        if (帳票分類ID != null && !帳票分類ID.isEmpty()) {
            帳票分類IDフラグ = true;
        }
        return new ChohyoSeigyoKyotsuParameter(
                サブ業務コード,
                帳票分類ID,
                帳票分類IDフラグ);
    }
}
