/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 納付額データ作成ProcessParameterのパラメータです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class NofugakuDataMybatisParameter implements IMyBatisParameter {

    private RYear 対象年;
    private RYear 対象年minus1;
    private boolean is非課税年金;
    private RString 集計日区分;
    private LasdecCode 市町村コード;
    private RString 出力順;

    /**
     * コンストラクタです。
     */
    public NofugakuDataMybatisParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 対象年 RYear
     * @param 対象年minus1 RYear
     * @param is非課税年金 boolean
     * @param 集計日区分 RString
     * @param 市町村コード LasdecCode
     */
    public NofugakuDataMybatisParameter(RYear 対象年,
            RYear 対象年minus1,
            boolean is非課税年金,
            RString 集計日区分,
            LasdecCode 市町村コード) {
        this.対象年 = 対象年;
        this.対象年minus1 = 対象年minus1;
        this.is非課税年金 = is非課税年金;
        this.集計日区分 = 集計日区分;
        this.市町村コード = 市町村コード;
    }
}
