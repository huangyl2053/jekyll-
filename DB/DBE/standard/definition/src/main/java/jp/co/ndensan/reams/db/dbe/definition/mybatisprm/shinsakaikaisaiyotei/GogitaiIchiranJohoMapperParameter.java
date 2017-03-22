/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyotei;

import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定登録　合議体情報一覧表示のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class GogitaiIchiranJohoMapperParameter {

    private static final int NENDO_START_MONTH = 4;
    private static final int NENDO_START_DAY = 1;
    private static final int NENDO_END_MONTH = 3;
    private static final int NENDO_END_DAY = 31;
    private final RString YukoYMDFrom;
    private final RString YukoYMDTo;
    private final RString nendoFrom;
    private final RString nendoTo;
    private final int GogitaiNo;
    private final boolean usesGogitaiNo;
    private final RString 審査会進捗状況_中止_コード;

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
        int nendoYear = new RDate(YukoYMDFrom.toString()).getNendo().getYearValue();
        this.nendoFrom = new RDate(nendoYear, NENDO_START_MONTH, NENDO_START_DAY).toDateString();
        this.nendoTo = new RDate(nendoYear + 1, NENDO_END_MONTH, NENDO_END_DAY).toDateString();
        this.GogitaiNo = GogitaiNo;
        this.usesGogitaiNo = usesGogitaiNo;
        this.審査会進捗状況_中止_コード = ShinsakaiShinchokuJokyo.中止.getコード();
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
