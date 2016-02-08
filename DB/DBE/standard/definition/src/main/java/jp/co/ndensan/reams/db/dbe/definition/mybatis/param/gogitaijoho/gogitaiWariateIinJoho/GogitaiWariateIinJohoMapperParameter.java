/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaiWariateIinJoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体割当委員情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class GogitaiWariateIinJohoMapperParameter {

    private final int 合議体番号;
    private final FlexibleDate 合議体有効期間開始年月日;
    private final RString 介護認定審査会委員コード;

    private final boolean uses合議体番号;
    private final boolean uses合議体有効期間開始年月日;
    private final boolean uses介護認定審査会委員コード;

    /**
     * コンストラクタです。
     *
     * @param 合議体番号 int
     * @param 合議体有効期間開始年月日 FlexibleDate
     * @param 介護認定審査会委員コード RString
     * @param uses合議体番号 boolean
     * @param uses合議体有効期間開始年月日 boolean
     * @param uses介護認定審査会委員コード boolean
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private GogitaiWariateIinJohoMapperParameter(
            int 合議体番号,
            @lombok.NonNull FlexibleDate 合議体有効期間開始年月日,
            @lombok.NonNull RString 介護認定審査会委員コード,
            boolean uses合議体番号,
            boolean uses合議体有効期間開始年月日,
            boolean uses介護認定審査会委員コード) {

        this.合議体番号 = 合議体番号;
        this.合議体有効期間開始年月日 = 合議体有効期間開始年月日;
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
        this.uses合議体番号 = uses合議体番号;
        this.uses合議体有効期間開始年月日 = uses合議体有効期間開始年月日;
        this.uses介護認定審査会委員コード = uses介護認定審査会委員コード;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 合議体番号 int
     * @param 合議体有効期間開始年月日 FlexibleDate
     * @param 介護認定審査会委員コード RString
     * @return 身体手帳検索パラメータ
     */
    public static GogitaiWariateIinJohoMapperParameter createSelectByKeyParam(
            int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日,
            RString 介護認定審査会委員コード) {
        return new GogitaiWariateIinJohoMapperParameter(合議体番号, 合議体有効期間開始年月日, 介護認定審査会委員コード, true, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 合議体番号 int
     * @param 合議体有効期間開始年月日 FlexibleDate
     * @return 身体手帳検索パラメータ
     */
    public static GogitaiWariateIinJohoMapperParameter createSelectListParam(
            int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日) {
        return new GogitaiWariateIinJohoMapperParameter(合議体番号, 合議体有効期間開始年月日, RString.EMPTY, true, true, false);
    }
}
