/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteishinsakaikekkadatatorikomi;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）Mybatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShinsakaiKekkaDataTorikomiMybatisParameter implements IMyBatisParameter {

    private final RString 申請書管理番号;
    private final RString 介護認定審査会開催番号;
    private final RString 介護認定審査会委員コード;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     */
    protected ShinsakaiKekkaDataTorikomiMybatisParameter(RString 申請書管理番号,
            RString 介護認定審査会開催番号,
            RString 介護認定審査会委員コード) {
        this.申請書管理番号 = 申請書管理番号;
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
    }

    /**
     * Mybatisパラメータクラスです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return ShinsakaiKekkaDataTorikomiMybatisParameter
     */
    public static ShinsakaiKekkaDataTorikomiMybatisParameter createParam(RString 申請書管理番号,
            RString 介護認定審査会開催番号,
            RString 介護認定審査会委員コード) {
        if (RString.isNullOrEmpty(申請書管理番号)) {
            申請書管理番号 = RString.EMPTY;
        }
        if (RString.isNullOrEmpty(介護認定審査会開催番号)) {
            介護認定審査会開催番号 = RString.EMPTY;
        }
        if (RString.isNullOrEmpty(介護認定審査会委員コード)) {
            介護認定審査会委員コード = RString.EMPTY;
        }
        return new ShinsakaiKekkaDataTorikomiMybatisParameter(申請書管理番号,
                介護認定審査会開催番号, 介護認定審査会委員コード);
    }
}
