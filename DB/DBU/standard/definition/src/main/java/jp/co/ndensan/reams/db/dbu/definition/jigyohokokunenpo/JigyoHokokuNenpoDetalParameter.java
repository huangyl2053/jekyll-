/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告年報詳細データの取得処理のMyBatisパラメタークラスです。
 *
 */
public class JigyoHokokuNenpoDetalParameter {

    private final FlexibleYear hokokuYSeireki;
    private final FlexibleYear shukeiTaishoYSeireki;
    private final RString toukeiTaishoKubun;
    private final LasdecCode shichosonCode;
    private final Code hyoNo;
    private final Code shukeiNo;
    private final List<Code> shukeiNoList;
    private boolean useshukeiNo = false;
    private boolean useshukeiNoList = false;

    private JigyoHokokuNenpoDetalParameter(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード,
            Code 表番号, Code 集計番号, List<Code> 集計番号リスト) {
        if (集計番号 != null && !集計番号.isEmpty()) {
            useshukeiNo = true;
        } else {
            useshukeiNoList = true;
        }
        this.hokokuYSeireki = 報告年;
        this.shukeiTaishoYSeireki = 集計対象年;
        this.shichosonCode = 市町村コード;
        this.toukeiTaishoKubun = 統計対象区分;
        this.shukeiNo = 集計番号;
        this.shukeiNoList = 集計番号リスト;
        this.hyoNo = 表番号;
    }

    public static JigyoHokokuNenpoDetalParameter createParameterForJigyoHokokuNenpoDetal(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード,
            Code 表番号, Code 集計番号, List<Code> 集計番号リスト) {

        return new JigyoHokokuNenpoDetalParameter(報告年, 集計対象年, 統計対象区分, 市町村コード, 表番号, 集計番号, 集計番号リスト);
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

    public Code getHyoNo() {
        return hyoNo;
    }

    public Code getShukeiNo() {
        return shukeiNo;
    }

    public List<Code> getShukeiNoList() {
        return shukeiNoList;
    }

    public boolean isUseshukeiNo() {
        return useshukeiNo;
    }

    public boolean isUseshukeiNoList() {
        return useshukeiNoList;
    }

}
