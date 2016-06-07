/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoteishitaisyosyadoutei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理日付管理マスタからデータを取得する。 MybatisParameter
 *
 * @reamsid_L DBB-1850-030 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoTeishiTaisyosyaDouteiMybatisParameter
        implements IMyBatisParameter {

    private FlexibleYear 処理年度;
    private RString 最新の広域構成市町村;
    private RString 表示;
    private SubGyomuCode 介護賦課;
    private RString 処理名;
    private RString 対象者情報取得月;
    private RString 特徴結果情報取込;
    private RString 特徴対象者情報取込;
    private RString 特徴対象者同定;

    /**
     * コンストラクタです
     *
     */
    public TokuchoTeishiTaisyosyaDouteiMybatisParameter() {
    }

    /**
     * コンストラクタです
     *
     * @param 処理年度 FlexibleYear
     * @param 最新の広域構成市町村 RString
     * @param 表示 RString
     * @param 介護賦課 SubGyomuCode
     * @param 処理名 RString
     * @param 対象者情報取得月 RString
     * @param 特徴結果情報取込 RString
     * @param 特徴対象者情報取込 RString
     * @param 特徴対象者同定 RString
     */
    public TokuchoTeishiTaisyosyaDouteiMybatisParameter(
            FlexibleYear 処理年度,
            RString 最新の広域構成市町村,
            RString 表示,
            SubGyomuCode 介護賦課,
            RString 処理名,
            RString 対象者情報取得月,
            RString 特徴結果情報取込,
            RString 特徴対象者情報取込,
            RString 特徴対象者同定) {
        this.処理年度 = 処理年度;
        this.最新の広域構成市町村 = 最新の広域構成市町村;
        this.表示 = 表示;
        this.介護賦課 = 介護賦課;
        this.処理名 = 処理名;
        this.対象者情報取得月 = 対象者情報取得月;
        this.特徴結果情報取込 = 特徴結果情報取込;
        this.特徴対象者情報取込 = 特徴対象者情報取込;
        this.特徴対象者同定 = 特徴対象者同定;
    }
}
