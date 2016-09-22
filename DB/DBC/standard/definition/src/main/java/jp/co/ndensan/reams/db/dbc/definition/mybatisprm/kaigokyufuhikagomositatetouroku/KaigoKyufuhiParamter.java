/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomositatetouroku;

import jp.co.ndensan.reams.db.dbc.definition.core.kyufubunruikubun.KyufubunruiKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のパラメータクラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KaigoKyufuhiParamter {

    private static final RString MENUID_DBCMN91001 = new RString("DBCMN91001");
    private static final RString MENUID_DBCMN91002 = new RString("DBCMN91002");
    private static final RString MENUID_DBCMN91003 = new RString("DBCMN91003");
    private final RString 被保番号;
    private final RString 事業者;
    private final RString 提供年月開始;
    private final RString 提供年月終了;
    private final LasdecCode 保険者番号;
    private final boolean 申立書作成済みのみフラグ;
    private final RString メニューID;
    private final boolean meunID_91001;
    private final boolean meunID_91002;
    private final boolean meunID_91003;
    private final boolean 被保番号NOTEMPTY;
    private final boolean 事業者NOTEMPTY;
    private final boolean 保険者番号NOTEMPTY;
    private final RString 介護給付;
    private final RString 予防給付;
    private final RString 介護給付と予防給付;
    private final RString 総合事業_経過措置;
    private final RString 総合事業;

    private KaigoKyufuhiParamter(RString 被保番号,
            RString 事業者,
            RString 提供年月開始,
            RString 提供年月終了,
            LasdecCode 保険者番号,
            boolean 申立書作成済みのみフラグ,
            RString メニューID,
            boolean meunID_91001,
            boolean meunID_91002,
            boolean meunID_91003,
            boolean 被保番号NOTEMPTY,
            boolean 事業者NOTEMPTY,
            boolean 保険者番号NOTEMPTY,
            RString 介護給付,
            RString 予防給付,
            RString 介護給付と予防給付,
            RString 総合事業_経過措置,
            RString 総合事業) {
        this.被保番号 = 被保番号;
        this.事業者 = 事業者;
        this.提供年月開始 = 提供年月開始;
        this.提供年月終了 = 提供年月終了;
        this.保険者番号 = 保険者番号;
        this.申立書作成済みのみフラグ = 申立書作成済みのみフラグ;
        this.メニューID = メニューID;
        this.meunID_91001 = meunID_91001;
        this.meunID_91002 = meunID_91002;
        this.meunID_91003 = meunID_91003;
        this.被保番号NOTEMPTY = 被保番号NOTEMPTY;
        this.事業者NOTEMPTY = 事業者NOTEMPTY;
        this.保険者番号NOTEMPTY = 保険者番号NOTEMPTY;
        this.介護給付 = 介護給付;
        this.予防給付 = 予防給付;
        this.介護給付と予防給付 = 介護給付と予防給付;
        this.総合事業_経過措置 = 総合事業_経過措置;
        this.総合事業 = 総合事業;
    }

    /**
     * 給付実績一覧取得のパラメータを作成します。
     *
     * @param 被保番号 被保番号
     * @param 事業者 事業者
     * @param 提供年月開始 提供年月開始
     * @param 提供年月終了 提供年月終了
     * @param 保険者番号 保険者番号
     * @param 申立書作成済みのみフラグ 申立書作成済みのみフラグ
     * @param メニューID メニューID
     * @return KaigoKyufuhiParamter
     */
    public static KaigoKyufuhiParamter createParem(RString 被保番号,
            RString 事業者,
            RString 提供年月開始,
            RString 提供年月終了,
            LasdecCode 保険者番号,
            boolean 申立書作成済みのみフラグ,
            RString メニューID) {
        return new KaigoKyufuhiParamter(被保番号,
                事業者,
                提供年月開始,
                提供年月終了,
                保険者番号,
                申立書作成済みのみフラグ,
                メニューID,
                MENUID_DBCMN91001.equals(メニューID),
                MENUID_DBCMN91002.equals(メニューID),
                MENUID_DBCMN91003.equals(メニューID),
                !RString.isNullOrEmpty(被保番号),
                !RString.isNullOrEmpty(事業者),
                保険者番号 != null && !new RString("000000").equals(保険者番号.value()),
                KyufubunruiKubun.介護給付.getコード(),
                KyufubunruiKubun.予防給付.getコード(),
                KyufubunruiKubun.介護給付と予防給付.getコード(),
                KyufubunruiKubun.総合事業_経過措置.getコード(),
                KyufubunruiKubun.総合事業.getコード());
    }
}
