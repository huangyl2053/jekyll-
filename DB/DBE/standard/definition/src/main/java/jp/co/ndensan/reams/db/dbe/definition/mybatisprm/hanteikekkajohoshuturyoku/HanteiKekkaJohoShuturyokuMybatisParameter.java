/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshuturyoku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 判定結果情報出力(介護認定審査会)のMyBatisパラメータ。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HanteiKekkaJohoShuturyokuMybatisParameter implements IMyBatisParameter {

    private final RString kaisaiBangou;
    private final List<RString> shoriJotaiKubun;
    private final RString shoKisaiHokenshaNo;
    private final boolean isShoKisaiHokenshaNoFlag;

    /**
     * コンストラクタです。
     *
     * @param kaisaiBangou 開催番号
     * @param shoriJotaiKubun 処理状態区分
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param isShoKisaiHokenshaNoFlag 証記載保険者番号Flag
     */
    protected HanteiKekkaJohoShuturyokuMybatisParameter(
            RString kaisaiBangou,
            List<RString> shoriJotaiKubun,
            RString shoKisaiHokenshaNo,
            boolean isShoKisaiHokenshaNoFlag) {
        this.kaisaiBangou = kaisaiBangou;
        this.shoriJotaiKubun = shoriJotaiKubun;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.isShoKisaiHokenshaNoFlag = isShoKisaiHokenshaNoFlag;
    }

    /**
     * 判定結果情報出力(介護認定審査会)のMyBatisパラメータを返します。
     *
     * @param kaisaiBangou 開催番号
     * @param shoriJotaiKubun 処理状態区分
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @return HanteiKekkaJohoShuturyokuMybatisParameter
     */
    public static HanteiKekkaJohoShuturyokuMybatisParameter creatParameter(
            RString kaisaiBangou,
            List<RString> shoriJotaiKubun,
            RString shoKisaiHokenshaNo) {
        boolean isShoKisaiHokenshaNoFlag = false;
        if (!RString.isNullOrEmpty(shoKisaiHokenshaNo)) {
            isShoKisaiHokenshaNoFlag = true;
        }
        return new HanteiKekkaJohoShuturyokuMybatisParameter(
                kaisaiBangou,
                shoriJotaiKubun,
                shoKisaiHokenshaNo,
                isShoKisaiHokenshaNoFlag);
    }
}
