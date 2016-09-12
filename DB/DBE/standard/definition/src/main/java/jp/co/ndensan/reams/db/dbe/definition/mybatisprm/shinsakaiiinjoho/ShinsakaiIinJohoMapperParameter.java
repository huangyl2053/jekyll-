/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0110-010 wangxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaiIinJohoMapperParameter {

    private RString shinsakaiIinCode;
    private int dispMax;
    private boolean isSubeteHyoji;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiIinCode 審査会委員コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShinsakaiIinJohoMapperParameter(RString shinsakaiIinCode) {
        this.shinsakaiIinCode
                = requireNonNull(shinsakaiIinCode, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
    }

    /**
     * コンストラクタです。
     *
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShinsakaiIinJohoMapperParameter(int dispMax,
            boolean isSubeteHyoji) {
        this.dispMax = dispMax;
        this.isSubeteHyoji = isSubeteHyoji;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinsakaiIinCode 審査会委員コード
     * @return 介護認定審査会委員情報パラメータ
     */
    public static ShinsakaiIinJohoMapperParameter createParamByShinsakaiIinCode(
            RString shinsakaiIinCode) {
        return new ShinsakaiIinJohoMapperParameter(shinsakaiIinCode);
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param dispMax 最大表示件数
     * @param isSubeteHyoji 全て表示
     * @return 介護認定審査会委員情報パラメータ
     */
    public static ShinsakaiIinJohoMapperParameter createParamForShinsakaiIin(
            boolean isSubeteHyoji, int dispMax) {
        return new ShinsakaiIinJohoMapperParameter(dispMax, isSubeteHyoji);
    }

}
