/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 認定審査依頼IF作成（モバイル）における概況調査関連データのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class GaikyoChosaDataMybatisParameter implements IMyBatisParameter {

    private final RString 申請書管理番号;
    private final Decimal 認定調査依頼履歴番号;
    private final RString 判定結果コード;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 判定結果コード 判定結果コード
     */
    private GaikyoChosaDataMybatisParameter(
            RString 申請書管理番号,
            Decimal 認定調査依頼履歴番号,
            RString 判定結果コード) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.判定結果コード = 判定結果コード;
    }

    /**
     * 申請書管理番号による検索条件(前回、前々回情報取得用)<br>
     * 前回情報を取得する場合、今回の申請書管理番号を指定します。<br>
     * 前々回情報を取得する場合、前回の申請書管理番号を指定します。
     *
     * @param 申請書管理番号 申請書管理番号
     *
     * @return GaikyoChosaDataMybatisParameter
     */
    public static GaikyoChosaDataMybatisParameter createParamter(
            RString 申請書管理番号) {
        return new GaikyoChosaDataMybatisParameter(
                申請書管理番号,
                Decimal.ZERO,
                HanteiKekkaCode.認定.getコード());
    }

    /**
     * 申請書管理番号と認定調査依頼履歴番号による検索条件(サービスの状況等取得用)
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     *
     * @return GaikyoChosaDataMybatisParameter
     */
    public static GaikyoChosaDataMybatisParameter createParamter(
            RString 申請書管理番号,
            Decimal 認定調査依頼履歴番号) {
        return new GaikyoChosaDataMybatisParameter(
                申請書管理番号,
                認定調査依頼履歴番号,
                RString.EMPTY);
    }
}
