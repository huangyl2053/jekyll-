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
    private final int GogitaiNo;
    private final boolean usesGogitaiNo;

    /**
     * コンストラクタです。
     *
     * @param YukoYMDFrom 有効期間開始日
     * @param YukoYMDTo 有効期間終了日
     * @param GogitaiNo 合議体No
     */
    private GogitaiIchiranJohoMapperParameter(RString YukoYMDFrom,
            RString YukoYMDTo,
            int GogitaiNo,
            boolean usesGogitaiNo) {
        this.YukoYMDFrom = YukoYMDFrom;
        this.YukoYMDTo = YukoYMDTo;
        this.GogitaiNo = GogitaiNo;
        this.usesGogitaiNo = usesGogitaiNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param YukoYMDFrom 有効期間開始日
     * @param YukoYMDTo 有効期間終了日
     * @param GogitaiNo 合議体no
     * @return 合議体情報一覧表示パラメータ
     */
    public static GogitaiIchiranJohoMapperParameter createGogitaiJoho(
            RString YukoYMDFrom, RString YukoYMDTo, RString GogitaiNo) {
        return new GogitaiIchiranJohoMapperParameter(YukoYMDFrom,
                YukoYMDTo,
                (!RString.isNullOrEmpty(GogitaiNo) ? Integer.parseInt(GogitaiNo.toString()) : 0),
                !RString.isNullOrEmpty(GogitaiNo));
    }
}
