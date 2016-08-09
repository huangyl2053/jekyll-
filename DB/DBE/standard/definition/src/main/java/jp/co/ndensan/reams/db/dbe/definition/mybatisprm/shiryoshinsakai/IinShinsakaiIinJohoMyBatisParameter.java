/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用介護認定審査対象者一覧表のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinShinsakaiIinJohoMyBatisParameter implements IMyBatisParameter {

    private int gogitaiNo;
    private int bangoStart;
    private int bangoEnd;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaisaiNo;
    private RString shuturyokuJun;
    private boolean isIsShuturyokuJun;
    private boolean isSakuseiJokenHani;
    private boolean isSakuseiJokenTuika;
    private boolean isShuturyokuJunEmpty;
    private boolean isHaishiFlag_False;
    private boolean isHaishiFlag_True;
    private boolean isOrderKakuteiFlg;
    private FlexibleDate sisutemuYMD;
    private ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param gogitaiNo 合議体番号
     * @param bangoStart 開始番号
     * @param bangoEnd End番号
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuJun 出力順
     * @param isShuturyokuJunEmpty 出力順ファグ
     * @param isSakuseiJokenHani 作成条件_範囲指定ファグ
     * @param isSakuseiJokenTuika 作成条件_追加分ファグ
     */
    public IinShinsakaiIinJohoMyBatisParameter(
            int gogitaiNo,
            int bangoStart,
            int bangoEnd,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaisaiNo,
            RString shuturyokuJun,
            boolean isSakuseiJokenHani,
            boolean isSakuseiJokenTuika,
            boolean isShuturyokuJunEmpty) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuJun = shuturyokuJun;
        this.gogitaiNo = gogitaiNo;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.isShuturyokuJunEmpty = isShuturyokuJunEmpty;
        this.isSakuseiJokenHani = isSakuseiJokenHani;
        this.isSakuseiJokenTuika = isSakuseiJokenTuika;
    }
}
