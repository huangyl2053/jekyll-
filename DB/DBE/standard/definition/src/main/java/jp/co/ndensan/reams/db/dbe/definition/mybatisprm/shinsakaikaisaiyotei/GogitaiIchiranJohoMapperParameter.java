/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyotei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定登録　合議体情報一覧表示のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class GogitaiIchiranJohoMapperParameter {

    private final RString YukoYMDFrom;
    private final RString YukoYMDTo;

    /**
     * コンストラクタです。
     *
     * @param YukoYMDFrom 有効期間開始日
     * @param YukoYMDTo 有効期間終了日
     */
    private GogitaiIchiranJohoMapperParameter(RString YukoYMDFrom, RString YukoYMDTo) {
        this.YukoYMDFrom = YukoYMDFrom;
        this.YukoYMDTo = YukoYMDTo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param YukoYMDFrom 有効期間開始日
     * @param YukoYMDTo 有効期間終了日
     * @return 合議体情報一覧表示パラメータ
     */
    public static GogitaiIchiranJohoMapperParameter createGogitaiJoho(
            RString YukoYMDFrom, RString YukoYMDTo) {
        return new GogitaiIchiranJohoMapperParameter(YukoYMDFrom, YukoYMDTo);
    }
}
