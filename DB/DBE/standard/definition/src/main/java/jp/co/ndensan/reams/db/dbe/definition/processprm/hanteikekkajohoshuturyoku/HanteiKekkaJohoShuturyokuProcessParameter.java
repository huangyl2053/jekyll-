/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 判定結果情報出力(介護認定審査会)のバッチ処理クラスのパラメータ。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanteiKekkaJohoShuturyokuProcessParameter implements IBatchProcessParameter {

    private RString hakkouTyouhyou;
    private List<RString> kaisaiBangouList;
    private RString kaisaiBangou;
    private List<RString> shoriJotaiKubun;
    private RString shoKisaiHokenshaNo;

    /**
     * コンストラクタです。
     *
     * @param hakkouTyouhyou 発行帳票
     * @param kaisaiBangouList 開催番号List
     * @param kaisaiBangou 開催番号
     */
    public HanteiKekkaJohoShuturyokuProcessParameter(
            RString hakkouTyouhyou,
            List<RString> kaisaiBangouList,
            RString kaisaiBangou) {
        this.hakkouTyouhyou = hakkouTyouhyou;
        this.kaisaiBangouList = kaisaiBangouList;
        this.kaisaiBangou = kaisaiBangou;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return HanteiKekkaJohoShuturyokuMybatisParameter
     */
    public HanteiKekkaJohoShuturyokuMybatisParameter toHanteiKekkaJohoShuturyokuMybatisParameter() {
        return HanteiKekkaJohoShuturyokuMybatisParameter.creatParameter(
                hakkouTyouhyou,
                kaisaiBangouList,
                kaisaiBangou,
                shoriJotaiKubun,
                shoKisaiHokenshaNo);
    }
}
