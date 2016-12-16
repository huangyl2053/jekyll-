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

    private List<RString> kaisaiBangouList;
    private RString kaisaiBangou;
    private List<RString> shoriJotaiKubun;
    private RString shoKisaiHokenshaNo;
    private boolean isPublish_HanteiKekkaA3;
    private boolean isPublish_HanteiKekka;
    private boolean isPublish_HanteiKekkaKagami;
    private boolean isPublish_ShinsakaiGijiroku;
    private boolean isPublish_KekkaTsuchiIchiran;

    /**
     * コンストラクタです。
     *
     * @param kaisaiBangouList 開催番号List
     * @param kaisaiBangou 開催番号
     * @param isPublish_HanteiKekkaA3 要介護認定判定結果一覧表A3版
     * @param isPublish_HanteiKekka 要介護認定判定結果一覧表
     * @param isPublish_HanteiKekkaKagami 要介護認定審査判定結果_鑑
     * @param isPublish_ShinsakaiGijiroku 要介護認定審査会議事録
     * @param isPublish_KekkaTsuchiIchiran 要介護認定結果通知一覧表
     */
    public HanteiKekkaJohoShuturyokuProcessParameter(
            List<RString> kaisaiBangouList,
            RString kaisaiBangou,
            boolean isPublish_HanteiKekkaA3,
            boolean isPublish_HanteiKekka,
            boolean isPublish_HanteiKekkaKagami,
            boolean isPublish_ShinsakaiGijiroku,
            boolean isPublish_KekkaTsuchiIchiran
    ) {
        this.kaisaiBangouList = kaisaiBangouList;
        this.kaisaiBangou = kaisaiBangou;
        this.isPublish_HanteiKekkaA3 = isPublish_HanteiKekkaA3;
        this.isPublish_HanteiKekka = isPublish_HanteiKekka;
        this.isPublish_HanteiKekkaKagami = isPublish_HanteiKekkaKagami;
        this.isPublish_ShinsakaiGijiroku = isPublish_ShinsakaiGijiroku;
        this.isPublish_KekkaTsuchiIchiran = isPublish_KekkaTsuchiIchiran;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return HanteiKekkaJohoShuturyokuMybatisParameter
     */
    public HanteiKekkaJohoShuturyokuMybatisParameter toHanteiKekkaJohoShuturyokuMybatisParameter() {
        return HanteiKekkaJohoShuturyokuMybatisParameter.creatParameter(
                kaisaiBangouList,
                kaisaiBangou,
                shoriJotaiKubun,
                shoKisaiHokenshaNo);
    }
}
