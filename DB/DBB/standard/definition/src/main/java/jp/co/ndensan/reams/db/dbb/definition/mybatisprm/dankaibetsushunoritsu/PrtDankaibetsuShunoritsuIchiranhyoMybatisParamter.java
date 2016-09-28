/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dankaibetsushunoritsu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料段階別収納率一覧表の発行のmybatisパラメーターです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtDankaibetsuShunoritsuIchiranhyoMybatisParamter implements IMyBatisParameter {

    private RString 広域判定区分;
    private RString 抽出条件;
    private RString 市町村情報;

    /**
     * コンストラクタです
     *
     * @param 広域判定区分 広域判定区分
     * @param 抽出条件 抽出条件
     * @param 市町村情報 市町村情報
     */
    public PrtDankaibetsuShunoritsuIchiranhyoMybatisParamter(
            RString 広域判定区分,
            RString 抽出条件,
            RString 市町村情報) {
        this.広域判定区分 = 広域判定区分;
        this.抽出条件 = 抽出条件;
        this.市町村情報 = 市町村情報;
    }
}
