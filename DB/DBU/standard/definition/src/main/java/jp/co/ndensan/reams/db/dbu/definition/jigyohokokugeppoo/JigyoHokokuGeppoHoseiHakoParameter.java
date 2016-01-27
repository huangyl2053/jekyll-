/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author sunhui
 */
public class JigyoHokokuGeppoHoseiHakoParameter {

    private final FlexibleYear hokokuYSeireki;
    private final FlexibleYear shukeiTaishoYSeireki;
    private final RString toukeiTaishoKubun;
    private final LasdecCode shichosonCode;
    private final Code hyoNo;
    private final Code shukeiNo;
    private final RString hokokuM ;
    private final RString shukeiTaishoM;

    private JigyoHokokuGeppoHoseiHakoParameter(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード) {
        this.hokokuYSeireki = 報告年;
        this.shukeiTaishoYSeireki = 集計対象年;
        this.shichosonCode = 市町村コード;
        this.toukeiTaishoKubun = 統計対象区分;
        this.hyoNo=new Code();
         this.shukeiNo = new Code();
         this.hokokuM=null;
         this.shukeiTaishoM=null;
         
    }

    private JigyoHokokuGeppoHoseiHakoParameter(FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年, RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号) {
        this.hokokuYSeireki = 報告年;
        this.hokokuM = 報告月;
        this.shukeiTaishoYSeireki = 集計対象年;
        this.shukeiTaishoM=集計対象月;
        this.shichosonCode = 市町村コード;
        this.toukeiTaishoKubun = 統計対象区分;
        this.hyoNo=表番号;
         this.shukeiNo = 集計番号;
        
    }

    public static JigyoHokokuGeppoHoseiHakoParameter createParameterForJigyoHokokuGeppo(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード) {

        return new JigyoHokokuGeppoHoseiHakoParameter(報告年, 集計対象年, 統計対象区分, 市町村コード);
    }
    public static JigyoHokokuGeppoHoseiHakoParameter createParameterForJigyoHokokuNenpoDetal(FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年, RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号){
        return  new JigyoHokokuGeppoHoseiHakoParameter(報告年, 報告月,集計対象年,集計対象月,統計対象区分,市町村コード,表番号,集計番号);
    }

    public FlexibleYear getHokokuYSeireki() {
        return hokokuYSeireki;
    }

    public FlexibleYear getShukeiTaishoYSeireki() {
        return shukeiTaishoYSeireki;
    }

    public RString getToukeiTaishoKubun() {
        return toukeiTaishoKubun;
    }

    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }
}
