/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd581001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd581001.YokaigoJissiJyokyohyoHakkouMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd581001.YokaigoJissiJyokyohyoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoJissiJyokyohyoProcessParameter implements IBatchProcessParameter {

    private RString 出力帳票;
    private FlexibleDate 対象年月日From;
    private FlexibleDate 対象年月日To;
    private RString 導入形態コード;
    private FlexibleDate 年齢基準日;
    private int 年齢From;
    private int 年齢To;
    private FlexibleDate 生年月日From;
    private FlexibleDate 生年月日To;
    private RString 地区区分;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private RString 概況調査テキストイメージ区分;
    private RString 集計単位;
    private RString psmShikibetsuTaisho;
    private RString 基準日;
    private FlexibleDate 対象年度;

    public YokaigoJissiJyokyohyoProcessParameter(
            RString 出力帳票,
            FlexibleDate 対象年月日From,
            FlexibleDate 対象年月日To,
            FlexibleDate 年齢基準日,
            int 年齢From,
            int 年齢To,
            FlexibleDate 生年月日From,
            FlexibleDate 生年月日To,
            RString 地区区分,
            Code 開始地区コード,
            Code 終了地区コード,
            RString 集計単位,
            RString 基準日,
            FlexibleDate 対象年度) {
        this.出力帳票 = 出力帳票;
        this.対象年月日From = 対象年月日From;
        this.対象年月日To = 対象年月日To;
        this.年齢基準日 = 年齢基準日;
        this.年齢From = 年齢From;
        this.年齢To = 年齢To;
        this.生年月日From = 生年月日From;
        this.生年月日To = 生年月日To;
        this.地区区分 = 地区区分;
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        this.集計単位 = 集計単位;
        this.基準日 = 基準日;
        this.対象年度 = 対象年度;

    }

    /**
     * バッチMybatisパラメターを取得します．
     *
     * @return YokaigoJissiJyokyohyoMybatisParameter
     */
    public YokaigoJissiJyokyohyoMybatisParameter toYokaigoJissiJyokyohyoMybatisParameter() {
        return new YokaigoJissiJyokyohyoMybatisParameter(
                導入形態コード,
                概況調査テキストイメージ区分,
                年齢基準日,
                年齢From,
                年齢To,
                生年月日From,
                生年月日To,
                地区区分,
                開始地区コード,
                終了地区コード,
                集計単位,
                psmShikibetsuTaisho);
    }

    /**
     * バッチMybatisパラメターを取得します．
     *
     * @return YokaigoJissiJyokyohyoHakkouMybatisParameter
     */
    public YokaigoJissiJyokyohyoHakkouMybatisParameter toYokaigoJissiJyokyohyoHakkouMybatisParameter() {
        return new YokaigoJissiJyokyohyoHakkouMybatisParameter(対象年月日From, 対象年月日To);
    }
}
