/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshutsuryoku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 判定結果情報出力(保険者)を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HanteiKekkaJohoShutsuryokuMybitisParamter implements IMyBatisParameter {

    private final List<RString> shinseishoKanriNo;
    private final RString nijiHanteiYMDFrom;
    private final RString nijiHanteiYMDTo;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 二次判定日From 二次判定日From
     * @param 二次判定日To 二次判定日To
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public HanteiKekkaJohoShutsuryokuMybitisParamter(
            List<RString> 申請書管理番号,
            RString 二次判定日From,
            RString 二次判定日To) {

        this.shinseishoKanriNo = 申請書管理番号;
        this.nijiHanteiYMDFrom = 二次判定日From;
        this.nijiHanteiYMDTo = 二次判定日To;
    }
}
