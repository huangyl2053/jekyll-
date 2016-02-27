/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001.ParameterSetMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 抽出条件の生成_バッチ用のパラメータです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ParameterSetProcessParameter implements IBatchProcessParameter {

    private LasdecCode 市町村コード;
    private RString 処理名;
    private RString 処理枝番;
    private FlexibleYear 年度;
    private RString 年度内連番;
    

    /**
     * コンストラクタです。
     */
    public ParameterSetProcessParameter() {
        this.市町村コード = new LasdecCode("000000");
        this.処理名 = new RString("年齢到達抽出処理");
        this.処理枝番 = new RString("00");
        this.年度 = new FlexibleYear("0000");
        this.年度内連番 = new RString("00");
    }
    
    /**
     * 抽出条件の生成のMybatisパラメータを作成します。
     * 
     * @return 抽出条件の生成のMybatisパラメータ
     */ 
    public ParameterSetMybatisParameter toNinteiChosaTokusokujoMybatisParameter() {
        return new ParameterSetMybatisParameter(市町村コード,
                                    this.処理名,
                                    this.処理枝番,
                                    this.年度,
                                    this.年度内連番);
    }
    
 

}
