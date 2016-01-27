/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariateiinjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会割当委員情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ShinsakaiWariateIinJohoMapperParameter {

    private final RString shinsakaiKaisaiNo;
    private final RString shinsakaiIinCode;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo RString
     * @param shinsakaiIinCode RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShinsakaiWariateIinJohoMapperParameter(
            RString shinsakaiKaisaiNo,
            RString shinsakaiIinCode) {

        this.shinsakaiKaisaiNo = requireNonNull(shinsakaiKaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        this.shinsakaiIinCode = requireNonNull(shinsakaiIinCode, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinsakaiKaisaiNo RString
     * @param shinsakaiIinCode RString
     * @return 身体手帳検索パラメータ
     */
    public static ShinsakaiWariateIinJohoMapperParameter createSelectByKeyParam(
            RString shinsakaiKaisaiNo,
            RString shinsakaiIinCode) {
        return new ShinsakaiWariateIinJohoMapperParameter(shinsakaiKaisaiNo, shinsakaiIinCode);
    }
}
