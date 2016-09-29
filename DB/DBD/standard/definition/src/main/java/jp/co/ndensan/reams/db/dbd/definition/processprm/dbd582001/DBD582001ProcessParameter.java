/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd582001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd582001.YokaigoNinteiTsukibetsuJukyushaMybatisParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
    private FlexibleDate 基準年月日04;
    private FlexibleDate 基準年月日05;
    private FlexibleDate 基準年月日06;
    private FlexibleDate 基準年月日07;
    private FlexibleDate 基準年月日08;
    private FlexibleDate 基準年月日09;
    private FlexibleDate 基準年月日10;
    private FlexibleDate 基準年月日11;
    private FlexibleDate 基準年月日12;
    private FlexibleDate 基準年月日01;
    private FlexibleDate 基準年月日02;
    private FlexibleDate 基準年月日03;
    private RString 基準年月04;
    private RString 基準年月05;
    private RString 基準年月06;
    private RString 基準年月07;
    private RString 基準年月08;
    private RString 基準年月09;
    private RString 基準年月10;
    private RString 基準年月11;
    private RString 基準年月12;
    private RString 基準年月01;
    private RString 基準年月02;
    private RString 基準年月03;
    private FlexibleDate 生年月日From;
    private FlexibleDate 生年月日To;
    private RString 地区区分;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private RString 集計単位;
    private int 年齢From;
    private int 年齢To;
    private FlexibleYear 対象年度;

    /**
     * コンストラクタです。
     *
     * @param 基準フラグ 基準フラグ
     * @param 年齢基準日 年齢基準日
     * @param 基準年月日 基準年月日
     * @param 基準年月 基準年月
     * @param 生年月日From 生年月日From
     * @param 生年月日To 生年月日To
     * @param 地区区分 地区区分
     * @param 開始地区コード 開始地区コード
     * @param 終了地区コード 終了地区コード
     * @param 集計単位 集計単位
     * @param 年齢From 年齢From
     * @param 年齢To 年齢To
     * @param 対象年度 対象年度
     */
    public DBD582001ProcessParameter(
            RString 基準フラグ,
            FlexibleDate 年齢基準日,
            FlexibleDate 基準年月日04,
            FlexibleDate 基準年月日05,
            FlexibleDate 基準年月日06,
            FlexibleDate 基準年月日07,
            FlexibleDate 基準年月日08,
            FlexibleDate 基準年月日09,
            FlexibleDate 基準年月日10,
            FlexibleDate 基準年月日11,
            FlexibleDate 基準年月日12,
            FlexibleDate 基準年月日01,
            FlexibleDate 基準年月日02,
            FlexibleDate 基準年月日03,
            RString 基準年月04,
            RString 基準年月05,
            RString 基準年月06,
            RString 基準年月07,
            RString 基準年月08,
            RString 基準年月09,
            RString 基準年月10,
            RString 基準年月11,
            RString 基準年月12,
            RString 基準年月01,
            RString 基準年月02,
            RString 基準年月03,
            FlexibleDate 生年月日From,
            FlexibleDate 生年月日To,
            RString 地区区分,
            Code 開始地区コード,
            Code 終了地区コード,
            RString 集計単位,
            int 年齢From,
            int 年齢To,
            FlexibleYear 対象年度) {
        this.基準フラグ = 基準フラグ;
        this.年齢基準日 = 年齢基準日;
        this.基準年月日04 = 基準年月日04;
        this.基準年月日05 = 基準年月日05;
        this.基準年月日06 = 基準年月日06;
        this.基準年月日07 = 基準年月日07;
        this.基準年月日08 = 基準年月日08;
        this.基準年月日09 = 基準年月日09;
        this.基準年月日10 = 基準年月日10;
        this.基準年月日11 = 基準年月日11;
        this.基準年月日12 = 基準年月日12;
        this.基準年月日01 = 基準年月日01;
        this.基準年月日02 = 基準年月日02;
        this.基準年月日03 = 基準年月日03;
        this.基準年月04 = 基準年月04;
        this.基準年月05 = 基準年月05;
        this.基準年月06 = 基準年月06;
        this.基準年月07 = 基準年月07;
        this.基準年月08 = 基準年月08;
        this.基準年月09 = 基準年月09;
        this.基準年月10 = 基準年月10;
        this.基準年月11 = 基準年月11;
        this.基準年月12 = 基準年月12;
        this.基準年月01 = 基準年月01;
        this.基準年月02 = 基準年月02;
        this.基準年月03 = 基準年月03;
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
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        return new YokaigoNinteiTsukibetsuJukyushaMybatisParameter(
                基準フラグ,
                年齢基準日,
                基準年月日04,
                基準年月日05,
                基準年月日06,
                基準年月日07,
                基準年月日08,
                基準年月日09,
                基準年月日10,
                基準年月日11,
                基準年月日12,
                基準年月日01,
                基準年月日02,
                基準年月日03,
                基準年月04,
                基準年月05,
                基準年月06,
                基準年月07,
                基準年月08,
                基準年月09,
                基準年月10,
                基準年月11,
                基準年月12,
                基準年月01,
                基準年月02,
                基準年月03,
                生年月日From,
                生年月日To,
                地区区分,
                開始地区コード,
                終了地区コード,
                集計単位,
                年齢From,
                年齢To,
                key.build());
    }
}
