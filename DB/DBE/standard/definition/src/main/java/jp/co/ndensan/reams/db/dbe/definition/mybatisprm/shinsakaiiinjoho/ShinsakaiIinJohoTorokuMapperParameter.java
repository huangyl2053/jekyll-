/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定審査会委員を特定するためのMyBatis用パラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class ShinsakaiIinJohoTorokuMapperParameter {

    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString KEY3 = new RString("3");
    private final boolean isSubeteHyoji;
    private final Decimal dispMax;
    private final RString 審査会委員コードFrom;
    private final RString 審査会委員コードTo;
    private final RString 審査会委員資格;
    private final RString 審査員氏名;
    private final RString 審査員氏名キー;
    private final RString 審査員カナ名称;
    private final RString 審査員カナ名称キー;
    private final boolean usesdispMax;
    private final boolean uses審査会委員コードFrom;
    private final boolean uses審査会委員コードTo;
    private final boolean uses審査会委員資格;
    private final boolean uses審査員氏名;
    private final boolean uses審査員カナ名称;
    private final boolean uses審査員氏名前方一致;
    private final boolean uses審査員氏名後方一致;
    private final boolean uses審査員氏名完全一致;
    private final boolean uses審査員氏名部分一致;
    private final boolean uses審査員カナ名称前方一致;
    private final boolean uses審査員カナ名称後方一致;
    private final boolean uses審査員カナ名称完全一致;
    private final boolean uses審査員カナ名称部分一致;

    private ShinsakaiIinJohoTorokuMapperParameter(
            boolean isSubeteHyoji,
            Decimal dispMax,
            RString 審査会委員コードFrom,
            RString 審査会委員コードTo,
            RString 審査会委員資格,
            RString 審査員氏名,
            RString 審査員氏名キー,
            RString 審査員カナ名称,
            RString 審査員カナ名称キー,
            boolean usesdispMax,
            boolean uses審査会委員コードFrom,
            boolean uses審査会委員コードTo,
            boolean uses審査会委員資格,
            boolean uses審査員氏名,
            boolean uses審査員カナ名称,
            boolean uses審査員氏名前方一致,
            boolean uses審査員氏名後方一致,
            boolean uses審査員氏名完全一致,
            boolean uses審査員氏名部分一致,
            boolean uses審査員カナ名称前方一致,
            boolean uses審査員カナ名称後方一致,
            boolean uses審査員カナ名称完全一致,
            boolean uses審査員カナ名称部分一致
    ) {
        this.isSubeteHyoji = isSubeteHyoji;
        this.dispMax = dispMax;
        this.審査会委員コードFrom = 審査会委員コードFrom;
        this.審査会委員コードTo = 審査会委員コードTo;
        this.審査会委員資格 = 審査会委員資格;
        this.審査員氏名 = 審査員氏名;
        this.審査員氏名キー = 審査員氏名キー;
        this.審査員カナ名称 = 審査員カナ名称;
        this.審査員カナ名称キー = 審査員カナ名称キー;
        this.usesdispMax = usesdispMax;
        this.uses審査会委員コードFrom = uses審査会委員コードFrom;
        this.uses審査会委員コードTo = uses審査会委員コードTo;
        this.uses審査会委員資格 = uses審査会委員資格;
        this.uses審査員氏名 = uses審査員氏名;
        this.uses審査員カナ名称 = uses審査員カナ名称;
        this.uses審査員氏名前方一致 = uses審査員氏名前方一致;
        this.uses審査員氏名後方一致 = uses審査員氏名後方一致;
        this.uses審査員氏名完全一致 = uses審査員氏名完全一致;
        this.uses審査員氏名部分一致 = uses審査員氏名部分一致;
        this.uses審査員カナ名称前方一致 = uses審査員カナ名称前方一致;
        this.uses審査員カナ名称後方一致 = uses審査員カナ名称後方一致;
        this.uses審査員カナ名称完全一致 = uses審査員カナ名称完全一致;
        this.uses審査員カナ名称部分一致 = uses審査員カナ名称部分一致;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param isSubeteHyoji 全ての審査会委員か否か
     * @param　dispMax　最大表示件数
     * @param　審査会委員コードFrom　審査会委員コードFrom
     * @param　審査会委員コードTo　審査会委員コードTo
     * @param　審査会委員資格　審査会委員資格コード
     * @param　審査員氏名　審査員氏名
     * @param　審査員氏名キー　審査員氏名キー
     * @param　審査員カナ名称　審査員カナ名称
     * @param　審査員カナ名称キー　審査員カナ名称キー
     * @return 介護認定審査会委員登録パラメータ
     */
    public static ShinsakaiIinJohoTorokuMapperParameter createParamByShinsakaiIinTorokuList(boolean isSubeteHyoji,
            Decimal dispMax,
            RString 審査会委員コードFrom,
            RString 審査会委員コードTo,
            RString 審査会委員資格,
            RString 審査員氏名,
            RString 審査員氏名キー,
            RString 審査員カナ名称,
            RString 審査員カナ名称キー) {
        return new ShinsakaiIinJohoTorokuMapperParameter(isSubeteHyoji,
                dispMax,
                審査会委員コードFrom,
                審査会委員コードTo,
                審査会委員資格,
                審査員氏名,
                審査員氏名キー,
                審査員カナ名称,
                審査員カナ名称キー,
                dispMax != null,
                審査会委員コードFrom != null && !審査会委員コードFrom.isEmpty(),
                審査会委員コードTo != null && !審査会委員コードTo.isEmpty(),
                審査会委員資格 != null && !審査会委員資格.isEmpty(),
                審査員氏名 != null && !審査員氏名.isEmpty(),
                審査員カナ名称 != null && !審査員カナ名称.isEmpty(),
                KEY0.equals(審査員氏名キー),
                KEY1.equals(審査員氏名キー),
                KEY2.equals(審査員氏名キー),
                KEY3.equals(審査員氏名キー),
                KEY0.equals(審査員カナ名称キー),
                KEY1.equals(審査員カナ名称キー),
                KEY2.equals(審査員カナ名称キー),
                KEY3.equals(審査員カナ名称キー)
        );
    }
}
