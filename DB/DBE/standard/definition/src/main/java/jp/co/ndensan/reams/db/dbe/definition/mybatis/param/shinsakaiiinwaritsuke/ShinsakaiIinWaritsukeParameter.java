/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会内容検索パラメータクラス
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiIinWaritsukeParameter {

    private final RString kaisaiNo;
    private final LasdecCode shichousonCode;
    private final RString kaisaiYMD;

    /**
     * コンストラクタです。
     *
     * @param kaisaiNo 開催番号
     * @param shichousonCode 市町村コード
     * @param kaisaiYMD 開催年月日
     *
     */
    private ShinsakaiIinWaritsukeParameter(
            RString kaisaiNo,
            LasdecCode shichousonCode,
            RString kaisaiYMD) {
        this.kaisaiNo = kaisaiNo;
        this.shichousonCode = shichousonCode;
        this.kaisaiYMD = kaisaiYMD;
    }

    /**
     * 審査会内容検索パラメータークラス作成
     *
     * @param kaisaiNo 開催番号
     * @param shichousonCode 市町村コード
     * @param kaisaiYMD 開催年月日
     * @return 審査会内容検索パラメータークラス
     */
    public static ShinsakaiIinWaritsukeParameter createShinsakaiIinWaritsukeParameter(
            RString kaisaiNo,
            LasdecCode shichousonCode,
            RString kaisaiYMD) {

        return new ShinsakaiIinWaritsukeParameter(kaisaiNo, shichousonCode, kaisaiYMD);
    }
}
