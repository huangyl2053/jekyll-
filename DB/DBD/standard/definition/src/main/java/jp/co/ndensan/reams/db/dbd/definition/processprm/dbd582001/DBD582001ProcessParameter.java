/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd582001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd582001.YokaigoNinteiTsukibetsuJukyushaMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定月別受給者数状況表（統計表）のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD582001ProcessParameter implements IBatchProcessParameter {

    private RString 基準フラグ;
    private FlexibleDate 年齢基準日;
    private FlexibleDate 基準年月日;
    private RString 基準年月;
    private FlexibleDate 生年月日From;
    private FlexibleDate 生年月日To;
    private RString 地区区分;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private RString 集計単位;
    private RString psmShikibetsuTaisho;
    private int 年齢From;
    private int 年齢To;
    private FlexibleDate 対象年度;

    /**
     * コンストラクタです。
     *
     * @param 基準フラグ
     * @param 年齢基準日
     * @param 基準年月日
     * @param 基準年月
     * @param 生年月日From
     * @param 生年月日To
     * @param 地区区分
     * @param 開始地区コード
     * @param 終了地区コード
     * @param 集計単位
     * @param 年齢From
     * @param 年齢To
     * @param 対象年度
     */
    public DBD582001ProcessParameter(
            RString 基準フラグ,
            FlexibleDate 年齢基準日,
            FlexibleDate 基準年月日,
            RString 基準年月,
            FlexibleDate 生年月日From,
            FlexibleDate 生年月日To,
            RString 地区区分,
            Code 開始地区コード,
            Code 終了地区コード,
            RString 集計単位,
            int 年齢From,
            int 年齢To,
            FlexibleDate 対象年度) {
        this.基準フラグ = 基準フラグ;
        this.年齢基準日 = 年齢基準日;
        this.基準年月日 = 基準年月日;
        this.基準年月 = 基準年月;
        this.生年月日From = 生年月日From;
        this.生年月日To = 生年月日To;
        this.地区区分 = 地区区分;
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        this.集計単位 = 集計単位;
        this.年齢From = 年齢From;
        this.年齢To = 年齢To;
        this.対象年度 = 対象年度;

    }

    /**
     * バッチMybatisパラメターを取得します．
     *
     * @return YokaigoNinteiTsukibetsuJukyushaMybatisParameter
     */
    public YokaigoNinteiTsukibetsuJukyushaMybatisParameter toYokaigoNinteiTsukibetsuJukyushaMybatisParameter() {
        return new YokaigoNinteiTsukibetsuJukyushaMybatisParameter(
                基準フラグ,
                年齢基準日,
                基準年月日,
                基準年月,
                生年月日From,
                生年月日To,
                地区区分,
                開始地区コード,
                終了地区コード,
                集計単位,
                年齢From,
                年齢To,
                psmShikibetsuTaisho);
    }
}
