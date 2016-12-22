/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力条件出力のためのプロセスパラメータ
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OutputJokenhyoFactoryProcessParameter implements IBatchProcessParameter {

    private int gogitaiNo;
    private int bangoStart;
    private int bangoEnd;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private RString shuturyokuSutairu;
    private RString printHou;
    private RString shinsakaiKaishiYoteiTime;
    private RString sakuseiJoken;
    private Map<RString, RString> 帳票一覧Map;
    
    /**
     * コンストラクタです。
     *
     * @param gogitaiNo gogitaiNo
     * @param bangoStart bangoStart
     * @param bangoEnd bangoEnd
     * @param shinsakaiKaisaiYoteiYMD shinsakaiKaisaiYoteiYMD
     * @param shinsakaiKaisaiNo shinsakaiKaisaiNo
     * @param shuturyokuJun shuturyokuJun
     * @param shuturyokuSutairu shuturyokuSutairu
     * @param printHou printHou
     * @param shinsakaiKaishiYoteiTime shinsakaiKaishiYoteiTime
     * @param sakuseiJoken sakuseiJoken
     * @param 帳票一覧Map 帳票一覧Map
     */
    public OutputJokenhyoFactoryProcessParameter(int gogitaiNo, int bangoStart, int bangoEnd, FlexibleDate shinsakaiKaisaiYoteiYMD, 
            RString shinsakaiKaisaiNo, RString shuturyokuJun, RString shuturyokuSutairu, RString printHou, 
            RString shinsakaiKaishiYoteiTime, RString sakuseiJoken, Map<RString, RString> 帳票一覧Map) {
        this.gogitaiNo = gogitaiNo;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.shuturyokuSutairu = shuturyokuSutairu;
        this.printHou = printHou;
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
        this.sakuseiJoken = sakuseiJoken;
        this.帳票一覧Map = 帳票一覧Map;
    }

}
